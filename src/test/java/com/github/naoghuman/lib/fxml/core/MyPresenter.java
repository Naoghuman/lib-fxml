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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 */
public class MyPresenter extends FXMLPresenter implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        System.out.println("## MyPresenter.initialize(URL, ResourceBundle) #####");
        System.out.println("    - location      : " + (location  == null ? "NULL" : location.toString()));
        System.out.println("    - resourceBundle: " + (resources == null ? "NULL" : resources.getBaseBundleName()));
        System.out.println("    - rb.key.hello  : " + (resources == null ? "NULL" : resources.getString("key.hello")));
        System.out.println("################");
        
    }
    
    @Override
    public void configure(FXMLModel model) {
        super.configure(model);
        
        System.out.println("## MyPresenter.configure(FXMLModel) ################");
        System.out.println(model.toString());
        System.out.println("################");
        
    }
    
}
