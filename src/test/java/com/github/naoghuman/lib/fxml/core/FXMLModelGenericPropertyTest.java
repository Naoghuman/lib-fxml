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

import java.util.Optional;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class FXMLModelGenericPropertyTest {
    public static void main(String[] args) {

        FXMLModel model = new FXMLModel();
        
        StringProperty ssp = new SimpleStringProperty("hello");
        model.putData("simple-string-property",  ssp);
        model.putData("simple-boolean-property", new SimpleBooleanProperty(true));
        
        Optional<StringProperty> o = model.getData(StringProperty.class, "simple-string-property");
        System.out.println("simple-string-property is present                  : " + o.isPresent());
        System.out.println("                       is instanceOf StringProperty: " + (o.get() instanceof StringProperty));
        
        System.out.println("                       -> " + o.get().get());
        ssp.set("hello world");
        o = model.getData(StringProperty.class, "simple-string-property");
        System.out.println("                       -> " + o.get().get());
        
        Optional<BooleanProperty> o2 = model.getData(BooleanProperty.class, "simple-boolean-property");
        System.out.println("simple-boolean-property is present                   : " + o2.isPresent());
        System.out.println("                        is instanceOf BooleanProperty: " + (o2.get() instanceof BooleanProperty));
        
    }
}
