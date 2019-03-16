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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoFXMLModelMetadata {
    
    public static void main(String[] args) {
        LoggerFacade.getDefault().info(DemoFXMLAction.class, "DemoFXMLModelMetadata#main(String[])"); // NOI18N
    
        final FXMLModel model = new FXMLModel();
//        model.setEntity(FXMLModel.class);
//        model.setEntity(System.currentTimeMillis());
        model.putData("string.property", new SimpleStringProperty("string.property")); // NOI18N
        
        System.out.println(model);
    }
    
}
