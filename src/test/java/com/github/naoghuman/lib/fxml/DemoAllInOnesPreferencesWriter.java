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

import com.github.naoghuman.lib.logger.core.LoggerFacade;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class DemoAllInOnesPreferencesWriter extends DemoInfoWriter {
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String TEXT_FIELD__ENTITY_TITLE = "TEXT_FIELD__ENTITY_TITLE"; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String TEXT_FIELD__ENTITY_ID = "TEXT_FIELD__ENTITY_ID"; // NOI18N
    
    @Override
    protected void writeSectionPreferencesDescription() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesPreferencesWriter#writeSectionPreferencesDescription()"); // NOI18N
    
        super.writeText(SIZE_DESCRIPTION, "Description"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_TEXT, "This interactive area allowed the developer to do some 'CRUD' operations with the data from the current 'FXMLModel'."); // NOI18N
        super.writeText(SIZE_TEXT, "For more informations about the options plz read the tooltips."); // NOI18N
    
        super.writeEmptyLine();
    }

    @Override
    protected void writeSectionPreferencesCRUD() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesPreferencesWriter#writeSectionPreferencesCRUD()"); // NOI18N
    
        super.writeText(SIZE_DESCRIPTION, "Entity"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_TEXT, "Titel"); // NOI18N
        super.writeTextField(TEXT_FIELD__ENTITY_TITLE, "Tip here to update the 'title' from the entity."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_TEXT, "Id"); // NOI18N
        super.writeTextField(TEXT_FIELD__ENTITY_ID, "Tip here to update the 'id' from the entity."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_TEXT, "CRUD Operations"); // NOI18N
        super.writeButton("New",  "This operation create a new entity with id: -1.",            DemoAllInOnesController.ON_ACTION__ENTITY_NEW);  // NOI18N
        super.writeButton("Load", "This operation load an entity with same written id: ",       DemoAllInOnesController.ON_ACTION__ENTITY_LOAD); // NOI18N
        super.writeButton("Save", "This operation saves the entity to the database (console).", DemoAllInOnesController.ON_ACTION__ENTITY_SAVE); // NOI18N
    
        super.writeEmptyLine();
    }

    @Override
    protected void writeSectionPreferencesAdditional() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesPreferencesWriter#writeSectionPreferencesAdditional()"); // NOI18N
    
        super.writeText(SIZE_DESCRIPTION, "Additional"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_TEXT, "The following buttons demonstrate the registration with 'FXMLAction#register(String, EventHandler<ActionEvent>)."); // NOI18N
        super.writeText(SIZE_TEXT, "Click one or more from the buttons will print the actual state from the 'given' object to the console."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeButton("FXMLView",       "Prints the actual state from the 'FXMLView' instance to the console.",       DemoAllInOnes.ON_ACTION__PRINT_FXMLVIEW_INFOS);                 // NOI18N
        super.writeButton("FXMLController", "Prints the actual state from the 'FXMLController' instance to the console.", DemoAllInOnesController.ON_ACTION__PRINT_FXMLCONTROLLER_INFOS); // NOI18N
        super.writeButton("FXMLModel",      "Prints the actual state from the 'FXMLModel' instance to the console.",      DemoAllInOnesController.ON_ACTION__PRINT_FXMLMODEL_INFOS);      // NOI18N
    }
    
}
