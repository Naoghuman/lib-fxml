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

import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoWithoutCSSFileController extends FXMLController implements Initializable {
    
    @FXML private Label lHelloLibFXML;
    @FXML private Label lLocation;
    @FXML private Label lResourceBundle;
    
    @FXML private Label lMyDouble;
    @FXML private Label lMyInt;
    @FXML private Label lMyString;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        lLocation.setText(      (location  == null ? "NULL" : location.toString()));
        lResourceBundle.setText((resources == null ? "NULL" : resources.getBaseBundleName()));
        lHelloLibFXML.setText(  (resources == null ? "NULL" : resources.getString("key.hello.libfxml")));
    }
    
    @Override
    public void configure(FXMLModel model) {
        DefaultFXMLValidator.requireNonNull(model);
        
        super.configure(model);
        
        model.get(Integer.class, "my.int").ifPresent((myInt) -> {
            lMyInt.setText(String.valueOf(myInt));
        });
        
        model.get(Double.class, "my.double").ifPresent((myDouble) -> {
            lMyDouble.setText(String.valueOf(myDouble));
        });
        
        model.get(String.class, "my.string").ifPresent((myString) -> {
            lMyString.setText(myString);
        });
    }
    
}
