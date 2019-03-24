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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.List;
import javafx.collections.FXCollections;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoFXMLAction implements FXMLRegisterable {
    
    private static final String ON_ACTION__LOAD_ENTITIES_FROM_DATABASE = "ON_ACTION__LOAD_ENTITIES_FROM_DATABASE"; // NOI18N
    private static final String ON_ACTION__LOAD_ENTITY_FROM_DATABASE   = "ON_ACTION__LOAD_ENTITY_FROM_DATABASE"; // NOI18N
    private static final String ON_ACTION__SAVE_ENTITY_TO_DATABASE     = "ON_ACTION__SAVE_ENTITY_TO_DATABASE";   // NOI18N
    
    public static void main(String[] args) {
        LoggerFacade.getDefault().info(DemoFXMLAction.class, "DemoFXMLAction#main(String[])"); // NOI18N
    
        final DemoFXMLAction demoFXMLAction = new DemoFXMLAction();
        demoFXMLAction.register();
        
        demoFXMLAction.onActionSaveEntityToDatabase();
        demoFXMLAction.onActionLoadEntityFromDatabase();
        demoFXMLAction.onActionLoadEntitiesFromDatabase();
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(DemoFXMLAction.class, "DemoFXMLAction#register()"); // NOI18N
    
        FXMLAction.register(ON_ACTION__SAVE_ENTITY_TO_DATABASE,     SqlProvider::onActionSaveEntityToDatabase);
        FXMLAction.register(ON_ACTION__LOAD_ENTITY_FROM_DATABASE,   SqlProvider::onActionLoadEntityFromDatabase);
        FXMLAction.register(ON_ACTION__LOAD_ENTITIES_FROM_DATABASE, SqlProvider::onActionLoadEntitiesFromDatabase);
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    void onActionSaveEntityToDatabase() {
        LoggerFacade.getDefault().debug(DemoFXMLAction.class, "DemoFXMLAction#onActionSaveEntityToDatabase()"); // NOI18N

        /*
         * DEMO -> TO DATABASE
         *  - Register the method #onActionSaveEntityToDatabase(FXMLModel) with the 
         *    action-id 'ON_ACTION__SAVE_ENTITY_TO_DATABASE'.
         *  - Because the method have a parameter from type 'FXMLModel' the #register(...)
         *    method with the parameter Consumer<FXMLModel> will be used.
         */
        
        // Execute the registered action ON_ACTION_PRINT which will then execute the 
        // registerd method :)) here in DemoFXMLAction.
        final FXMLModel modelToDatabase = new FXMLModel();
        modelToDatabase.putData("int", 12345); // NOI18N
        modelToDatabase.putData("msg", "hello from #onActionSaveEntityToDatabase(FXMLModel)"); // NOI18N
        
        FXMLAction.handle(ON_ACTION__SAVE_ENTITY_TO_DATABASE, modelToDatabase);
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    void onActionLoadEntityFromDatabase() {
        LoggerFacade.getDefault().debug(DemoFXMLAction.class, "DemoFXMLAction#onActionLoadEntityFromDatabase()"); // NOI18N

        /*
         * DEMO <- FROM DATABASE
         *  - Register the method #onActionLoadEntityFromDatabase(Long) with the 
         *    action-id 'ON_ACTION__LOAD_ENTITY_FROM_DATABASE'.
         *  - Because the method have a parameter from type 'Long' the #register(...)
         *    method with the parameter Function<Long, FXMLModel> will be used 
         *    where 'Long' is the input type and 'FXMLModel' the type of the result.
         */
        
        // Execute the registered action ON_ACTION__LOAD_ENTITY_FROM_DATABASE which 
        // will then execute the registerd method :)) here in DemoFXMLAction.
        final FXMLModel entity = FXMLAction.handle(ON_ACTION__LOAD_ENTITY_FROM_DATABASE, 987654321L);
        System.out.println(entity.toString());
        
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    void onActionLoadEntitiesFromDatabase() {
        LoggerFacade.getDefault().debug(DemoFXMLAction.class, "DemoFXMLAction#onActionLoadEntitiesFromDatabase()"); // NOI18N

        final List<FXMLModel> entities = FXMLAction.handle(ON_ACTION__LOAD_ENTITIES_FROM_DATABASE);
        entities.stream()
                .forEach(entity -> {
                    System.out.println(entity.toString());
                });
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    static class SqlProvider {
        
        /**
         * 
         * @param   model 
         * @since   0.3.0-PRERELEASE
         * @version 0.3.0-PRERELEASE
         * @author  Naoghuman
         */
        static void onActionSaveEntityToDatabase(final FXMLModel model) {
            LoggerFacade.getDefault().debug(SqlProvider.class, "SqlProvider#onActionSaveEntityToDatabase(FXMLModel)"); // NOI18N

            System.out.println(model.toString());
        }

        /**
         * 
         * @param   entityId
         * @return 
         * @since   0.3.0-PRERELEASE
         * @version 0.3.0-PRERELEASE
         * @author  Naoghuman
         */
        static FXMLModel onActionLoadEntityFromDatabase(final Long entityId) {
            LoggerFacade.getDefault().debug(SqlProvider.class, "SqlProvider#onActionLoadEntityFromDatabase(Long)"); // NOI18N

            // search entity in db and put data in FXMLModel
            final FXMLModel model = new FXMLModel();
            model.putData("id",  entityId); // NOI18N
            model.putData("msg", "hello from #onActionLoadEntityFromDatabase(Long)"); // NOI18N

            return model;
        }
        
        /**
         * 
         * @return 
         * @since   0.3.0-PRERELEASE
         * @version 0.3.0-PRERELEASE
         * @author  Naoghuman
         */
        static List<FXMLModel> onActionLoadEntitiesFromDatabase() {
            LoggerFacade.getDefault().debug(SqlProvider.class, "SqlProvider#onActionLoadEntitiesFromDatabase()"); // NOI18N

            final List<FXMLModel> entities = FXCollections.observableArrayList();
            
            // search entities in db and put data in FXMLModel
            final FXMLModel model = new FXMLModel();
            model.putData("id",  1111111111111111L); // NOI18N
            model.putData("msg", "hello1 from #onActionLoadEntitiesFromDatabase()"); // NOI18N
            entities.add(model);
            
            final FXMLModel model2 = new FXMLModel();
            model2.putData("id",  2222222222222222L); // NOI18N
            model2.putData("msg", "hello2 from #onActionLoadEntitiesFromDatabase()"); // NOI18N
            entities.add(model2);
            
            return entities;
        }
    
    }
    
}
