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
 * @since   0.1.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoWithAllFiles extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().info(DemoFXMLAction.class, "DemoWithAllFiles#main(String[])"); // NOI18N
    
        primaryStage.setTitle("Lib-FXML Demo with all files!");
        
        final FXMLModel model = new FXMLModel();
        model.putData("my.int",    12345);
        model.putData("my.double", 3.145d);
        model.putData("my.string", "Hello Lib-FXML from demo with all files!");
            
        final FXMLView                             view     = FXMLView.create(DemoWithAllFilesController.class, model);
        final Optional<DemoWithAllFilesController> optional = view.getController(DemoWithAllFilesController.class);
        optional.ifPresent(controller -> {
            controller.onActionShowFXMLViewInfos(view.toString());
        });
        
        final Scene scene = new Scene(view.getRoot().get(), 1280, 720);
        scene.getStylesheets().add("/com/github/naoghuman/lib/fxml/demowithallfiles.css"); // NOI18N
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
