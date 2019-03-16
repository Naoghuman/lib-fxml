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
import com.github.naoghuman.lib.fxml.core.FXMLModelable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class DemoAllInOnesEntityA implements FXMLModelable {
    
    public static final String ID = "DemoAllInOnesEntityA#idProperty";
    public static final String TITLE = "DemoAllInOnesEntityA#titleProperty"; 
    
    private final LongProperty   idProperty    = new SimpleLongProperty(123456789L);
    private final StringProperty titleProperty = new SimpleStringProperty("Hi title!");
    
    public LongProperty idProperty() {
        return idProperty;
    }
    
    public StringProperty titleProperty() {
        return titleProperty;
    }

    @Override
    public void readFromFXMLModel(final FXMLModel model) {
        
    }

    @Override
    public FXMLModel writeToFXMLModel() {
        final FXMLModel model = new FXMLModel();
        model.setEntity(this.getClass(), this.idProperty().get());
        
        model.putData(ID,    this.idProperty());
        model.putData(TITLE, this.titleProperty());
        
        return model;
    }
    
    
}
