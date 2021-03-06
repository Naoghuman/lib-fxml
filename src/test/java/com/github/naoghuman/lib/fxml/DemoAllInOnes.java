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

import com.github.naoghuman.lib.fxml.core.FXMLAction;
import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.core.FXMLRegisterable;
import com.github.naoghuman.lib.fxml.core.FXMLView;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class DemoAllInOnes extends Application implements FXMLRegisterable {
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__PRINT_FXMLVIEW_INFOS = "ON_ACTION__PRINT_FXMLVIEW_INFOS"; // NOI18N
    
    /**
     * 
     * @param   args 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private FXMLView view;

    @Override
    public void init() throws Exception {
        super.init();
        
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnes#init()"); // NOI18N
        
        // Register all managed actions
        this.register();
        DemoAllInOnesSqlEntityProvider.getDefault().register();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnes#start(Stage)"); // NOI18N
    
        primaryStage.setTitle("Lib-FXML Demo: 'All in Ones' v0.3.0-PRERELEASE"); // NOI18N
        
        final DemoAllInOnesEntity entity = new DemoAllInOnesEntity();
        final Optional<FXMLModel> model  = entity.writeTo();
        view = FXMLView.create(DemoAllInOnesController.class, model.get());
        
        final Scene scene = new Scene(view.getRoot().orElse(new AnchorPane()), 1280, 720);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    private void onActionPrintFXMLViewInfos(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnes#onActionPrintFXMLViewInfos(ActionEvent)"); // NOI18N
    
        System.out.println(view.toString());
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnes.register()"); // NOI18N
        
        FXMLAction.getDefault().register(ON_ACTION__PRINT_FXMLVIEW_INFOS, this::onActionPrintFXMLViewInfos);
    }
    
}
