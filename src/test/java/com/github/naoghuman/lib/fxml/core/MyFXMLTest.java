/*
 * Copyright (C) 2018 Naoghuman's dream
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

import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.core.FXMLPresenter;
import com.github.naoghuman.lib.fxml.core.FXMLView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 */
public class MyFXMLTest extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLView view = FXMLView.create(MyPresenter.class.getName());
        System.out.println(view.toString());
        
        FXMLPresenter presenter = view.getPresenter();
        if (presenter != null) {
            final FXMLModel data = new FXMLModel();
            data.put("my.int",    12345);
            data.put("my.double", 3.145d);
            data.put("my.string", "hello fxml");
            
            presenter.configure(data);
        }
    }
    
}
