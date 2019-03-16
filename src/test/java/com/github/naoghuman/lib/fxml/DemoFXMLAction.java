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
    
    private static final String ON_ACTION__LOAD_ENTITY_FROM_DATABASE = "ON_ACTION__LOAD_ENTITY_FROM_DATABASE"; // NOI18N
    private static final String ON_ACTION__SAVE_ENTITY_TO_DATABASE   = "ON_ACTION__SAVE_ENTITY_TO_DATABASE";   // NOI18N
    
    public static void main(String[] args) {
        
        // DemoFXMLAction have the methods which we will registered and handled
        // with FXMLAction!
        final DemoFXMLAction demo = new DemoFXMLAction();
        
        /*
         * DEMO -> TO DATABASE
         *  - Register the method #onActionSaveEntityToDatabase(FXMLModel) with the 
         *    action-id 'ON_ACTION__SAVE_ENTITY_TO_DATABASE'.
         *  - Because the method have a parameter from type 'FXMLModel' the #register(...)
         *    method with the parameter Consumer<FXMLModel> will be used.
         */
        FXMLAction.register(ON_ACTION__SAVE_ENTITY_TO_DATABASE, demo::onActionSaveEntityToDatabase);
    
        // Execute the registered action ON_ACTION_PRINT which will then execute the 
        // registerd method :)) here in DemoFXMLAction.
        final FXMLModel modelToDatabase = new FXMLModel();
        modelToDatabase.putData("int", 12345); // NOI18N
        modelToDatabase.putData("msg", "hello from #onActionSaveEntityToDatabase(FXMLModel)!"); // NOI18N
        
        FXMLAction.handle(ON_ACTION__SAVE_ENTITY_TO_DATABASE, modelToDatabase);
        
        /*
         * DEMO <- FROM DATABASE
         *  - Register the method #onActionLoadEntityFromDatabase(Long) with the 
         *    action-id 'ON_ACTION__LOAD_ENTITY_FROM_DATABASE'.
         *  - Because the method have a parameter from type 'Long' the #register(...)
         *    method with the parameter Function<Long, FXMLModel> will be used 
         *    where 'Long' is the input type and 'FXMLModel' the type of the result.
         */
        FXMLAction.register(ON_ACTION__LOAD_ENTITY_FROM_DATABASE, demo::onActionLoadEntityFromDatabase);
        
        // Execute the registered action ON_ACTION__LOAD_ENTITY_FROM_DATABASE which 
        // will then execute the registerd method :)) here in DemoFXMLAction.
        final FXMLModel modelFromDatabase = FXMLAction.handle(ON_ACTION__LOAD_ENTITY_FROM_DATABASE, 987654321L);
        System.out.println(modelFromDatabase.toString());
    }
    
    public void onActionSaveEntityToDatabase(final FXMLModel model) {
        System.out.println("\nDemoFXMLAction.onActionSaveEntityToDatabase(FXMLModel)"); // NOI18N
        System.out.println(model.toString());
    }
    
    public FXMLModel onActionLoadEntityFromDatabase(final Long id) {
        System.out.println("\nDemoFXMLAction.onActionLoadEntityFromDatabase(Long)"); // NOI18N
        
        // TODO Search here the model in DB and return it.
        final FXMLModel model = new FXMLModel();
        model.putData("id",  id); // NOI18N
        model.putData("msg", "hello from #onActionLoadEntityFromDatabase(Long)!"); // NOI18N
        
        return model;
    }
    
}
