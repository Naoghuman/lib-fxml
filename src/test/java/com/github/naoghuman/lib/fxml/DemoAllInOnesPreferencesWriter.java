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
        
        super.writeText(SIZE_TEXT, "In this interactive area the developer can 'tweak' the data from the current loaded entity (FXMLModel)."); // NOI18N
    
        super.writeEmptyLine();
    }

    @Override
    protected void writeSectionPreferencesCRUD() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesPreferencesWriter#writeSectionPreferencesCRUD()"); // NOI18N
    
        super.writeText(SIZE_DESCRIPTION, "Entity"); // NOI18N
        super.writeSeparator();
        
        super.writeTitleSmall("Titel"); // NOI18N
        super.writeTextField(TEXT_FIELD__ENTITY_TITLE);
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("Id"); // NOI18N
        super.writeTextField(TEXT_FIELD__ENTITY_ID);
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("CRUD Operations"); // NOI18N
        super.writeButton("New 'Entity'",  DemoAllInOnesController.ON_ACTION__ENTITY_NEW);  // NOI18N
        super.writeButton("Load 'Entity'", DemoAllInOnesController.ON_ACTION__ENTITY_LOAD); // NOI18N
        super.writeButton("Save 'Entity'", DemoAllInOnesController.ON_ACTION__ENTITY_SAVE); // NOI18N
    
        super.writeEmptyLine();
        
    }

    @Override
    protected void writeSectionPreferencesAdditional() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesPreferencesWriter#writeSectionPreferencesAdditional()"); // NOI18N
    
        super.writeText(SIZE_DESCRIPTION, "Additional"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_TEXT, "The following buttons allowed the interested developer to print the actual state from the 'named' objects to the console."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeButton("Print 'FXMLView'",       DemoAllInOnes.ON_ACTION__PRINT_FXMLVIEW_INFOS);                 // NOI18N
        super.writeButton("Print 'FXMLController'", DemoAllInOnesController.ON_ACTION__PRINT_FXMLCONTROLLER_INFOS); // NOI18N
        super.writeButton("Print 'FXMLModel'",      DemoAllInOnesController.ON_ACTION__PRINT_FXMLMODEL_INFOS);      // NOI18N
        super.writeText(SIZE_TEXT, "See 'DemoAllInOnes#register()' and 'DemoAllInOnesController#register()' for more informations.");              // NOI18N
    }
    
}
