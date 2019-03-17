/*
 * Copyright (C) 2018 - 2019 Naoghuman's dream
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.fxml;

import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.core.FXMLView;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoAllInOnes extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnes#init()"); // NOI18N
    
        // Register all managed actions
        DemoAllInOnesSqlProvider.getDefault().register();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnes#start(Stage)"); // NOI18N
    
        primaryStage.setTitle("Lib-FXML Demo all in ones!");
        
        final DemoAllInOnesEntityA entity = new DemoAllInOnesEntityA();
        final FXMLModel            model  = entity.writeToFXMLModel();
            
        final FXMLView                          view     = FXMLView.create(DemoAllInOnesController.class, model);
        final Optional<DemoAllInOnesController> optional = view.getController(DemoAllInOnesController.class);
        optional.ifPresent(controller -> {
            controller.onActionShowFXMLViewInfos(view.toString());
        });
        
        final Scene scene = new Scene(view.getRoot().get(), 1280, 720);
        scene.getStylesheets().add("/com/github/naoghuman/lib/fxml/demoallinones.css"); // NOI18N
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
