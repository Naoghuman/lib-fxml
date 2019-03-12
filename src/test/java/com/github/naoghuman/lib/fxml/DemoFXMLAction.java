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

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoFXMLAction {
    
    private static final String ON_ACTION_PRINT = "ON_ACTION_PRINT"; // NOI18N
    
    public static void main(String[] args) {
        
        // Register the function 'onActionPrint(FXMLModel)'
        // with the action-id 'ON_ACTION_PRINT'.
        final DemoFXMLAction demo = new DemoFXMLAction();
        FXMLAction.register(ON_ACTION_PRINT, demo::onActionPrint);
    
        // Execute the registered action ON_ACTION_PRINT
        // which will then execute the registerd function :)). 
        final FXMLModel model = new FXMLModel();
        model.putData("my.int", 12345); // NOI18N
        FXMLAction.handle(ON_ACTION_PRINT, model);
        
        // Now remove the previous registerd action
        FXMLAction.remove(ON_ACTION_PRINT);
        
        // and check it
        System.out.println(
                "The action 'ON_ACTION_PRINT' is registerd: " // NOI18N
                + FXMLAction.isRegistered(ON_ACTION_PRINT));
    }
    
    public void onActionPrint(FXMLModel model) {
        System.out.println("\nDemoFXMLAction.onActionPrint(FXMLModel)"); // NOI18N
        System.out.println(model.toString());
    }
    
}
