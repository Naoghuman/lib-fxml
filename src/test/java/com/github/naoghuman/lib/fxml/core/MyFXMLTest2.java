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
package com.github.naoghuman.lib.fxml.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @since   0.2.0-PRERELEASE
 * @version 0.2.0-PRERELEASE
 * @author  Naoghuman
 */
public class MyFXMLTest2 extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demo Lib-Fxml v0.2.0-PRERELEASE (2)");
        
        final FXMLModel model = new FXMLModel();
        model.put("my.int",    12345);
        model.put("my.double", 3.145d);
        model.put("my.string", "hello fxml");
            
        FXMLView view = FXMLView.create(MyPresenter.class.getName(), model);
        System.out.println(view.toString());
        
        final Scene scene = new Scene(view.getView().get(), 640, 360);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
