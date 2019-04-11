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
public final class DemoAllInOnesInfoWriter extends DemoInfoWriter {

    @Override
    protected void writeSectionInfoIntention() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesInfoWriter#writeSectionIntention()"); // NOI18N
    
        super.writeTitle("Intention"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_DESCRIPTION, "This demo wants to show, explain how to integrate the various features from the library 'Lib-FXML' into a demo application:"); // NOI18N
        super.writeListPoint("TODO How to write a demo application with the help from the various features from the library 'Lib-FXML' :) ."); // NOI18N
        super.writeListPoint("TODO (only one) How to integrate the features from library 'Lib-FXML' into the demo application."); // NOI18N
        
        super.writeListPoint("TODO first the main classes, then the interfaces"); // NOI18N
        super.writeListPoint("TODO add new point to FXMLModel. developer can add additional methods (updateProperty()) which extend the original entity behaviour"); // NOI18N
        
        super.writeListPoint("How to use the 'FXMLRegisterable' interface as a convention which allowes developers to register action methods."); // NOI18N
        super.writeListPoint("How to use the 'FXMLModelable' interface as a convention to create a lightweight version from an entity."); // NOI18N
        
        super.writeListPoint("TODO fxmlview points"); // NOI18N
        super.writeListPoint("TODO use the abstract class fxmlcontroller to "); // NOI18N
        super.writeListPoint("TODO fxmlaction register lambda methods like consumers, functions, suppliers..."); // NOI18N
        super.writeListPoint("TODO fxmlaction save, load"); // NOI18N
        super.writeListPoint("TODO javafx binding automatically update the entity, fxmlmodel data"); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_DESCRIPTION, "TODO And as a special treat :)"); // NOI18N
        super.writeListPoint("TODO fxmlloader to load fxml, assoziate with controller"); // NOI18N
        super.writeListPoint("How to style 'JavaFX' components such like 'AnchorPane', 'Button', 'TextField', 'ScrollPane' with css."); // NOI18N
        super.writeListPoint("How to define a .css file and include it into the application."); // NOI18N
        super.writeListPoint("TODO lib-action, lib-logger"); // NOI18N
        
        super.writeEmptyLine();
    }
    
    @Override
    protected void writeSectionInfoDemoFiles() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesInfoWriter#writeSectionDemoFiles()"); // NOI18N
        
        super.writeTitle("Demo files"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_DESCRIPTION, "In this section all files are listed which are involved into this demo. Also their main purpose are explained:"); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnes.java"); // NOI18N
        super.writeListPoint("The starter class from this demo application."); // NOI18N
        super.writeListPoint("Shows how to use 'FXMLView' in combination with 'FXMLModel', 'DemoAllInOnesController' and 'DemoAllInOnesEntity' to create a view which will be shown then in the gui."); // NOI18N
        super.writeListPoint("Shows how to inject the an optional .css file with 'scene.getStylesheets()'."); // NOI18N
        super.writeListPoint("Shows how the interface 'FXMLRegisterable' can be used to register the various action methods from this demo."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesController.java"); // NOI18N
        super.writeListPoint("Shows how the developer can access the 'URL' from the '.fxml' file."); // NOI18N
        super.writeListPoint("Shows how the developer can access the optional '.properties' file if defined."); // NOI18N
        super.writeListPoint("Shows how to use the classes 'DemoInfoWriter' and 'DemoAllInOnesInfoWriter' to write the demo infos."); // NOI18N
        super.writeListPoint("Shows how to use the overriden method 'FXMLController#configure(FXMLModel) to bind the data from the 'FXMLModel' to the gui components."); // NOI18N
        super.writeListPoint("Shows how the interface 'FXMLRegisterable' can be used to register the various action methods from this demo."); // NOI18N
        super.writeListPoint("Shows how to use the different 'FXMLAction#handle(...)' methods to fit the necessities from the controller."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesEntity.java"); // NOI18N
        super.writeListPoint("Shows how to create a simple 'POJO' with 2 'JavaFX' properties ('LongProperty' and 'StringProperty'."); // NOI18N
        super.writeListPoint("The usage from 'JavaFX' properties allowed to bind data which means we don't need to be aware that the data is up-to-date :)."); // NOI18N
        super.writeListPoint("Shows how to use the interface 'FXMLModelable' which allowed to get a 'FXMLModel' with selected data properties from the entity."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesSqlEntityProvider.java"); // NOI18N
        super.writeListPoint("Shows how to define a simple 'sql' entity provider which simulates the 'crud' operations for an entity / database."); // NOI18N
        super.writeListPoint("Shows how to use the interface 'FXMLRegisterable' as a convention to register the action methods from this class."); // NOI18N
        super.writeListPoint("Shows how to use the class 'FXMLAction' to register the (crud) action methods via lambda injection."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("demoallinones.css"); // NOI18N
        super.writeListPoint("This file contains all 'CSS' (Cascading Style Sheets) styles for the demo application."); // NOI18N
        super.writeListPoint("TODO add hint what styles are defined..."); // NOI18N
        
        super.writeTitleSmall("demoallinones.fxml"); // NOI18N
        super.writeListPoint("This file contains the declaration from the demo gui in form from a special JavaFX 'XML' file so called 'FXML'."); // NOI18N
        super.writeListPoint("The initialization will be done during the loading and mapping from the file with the corresponding 'controller'."); // NOI18N
        super.writeListPoint("See 'FXMLView#initializeFXMLLoader(FXMLModel)' for more informations."); // NOI18N
        
        super.writeTitleSmall("demoallinones.properties"); // NOI18N
        super.writeListPoint("TODO"); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_DESCRIPTION, "The next files are used to create the demo informations:"); // NOI18N
        
        super.writeTitleSmall("DemoInfoWriter.java"); // NOI18N
        super.writeListPoint("The abstract class 'DemoInfoWriter' offers various functions for writing different styled informations into a 'VBox'."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesInfoWriter.java"); // NOI18N
        super.writeListPoint("A concrete implementation from the abstract class 'DemoInfoWriter' for this demo."); // NOI18N
        super.writeListPoint("All informations about the features from the library 'Lib-FXML' and the demo :) in the left side from the demo are written with this class."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesPreferencesWriter.java"); // NOI18N
        super.writeListPoint("Another concrete implementation from the abstract class 'DemoInfoWriter'."); // NOI18N
        super.writeListPoint("With this class the interactive area on the right side in the demo application is written."); // NOI18N
        
        super.writeEmptyLine();
    }

    @Override
    protected void writeSectionInfoHowItWorks() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesInfoWriter#writeSectionHowItWorks()"); // NOI18N
        
        super.writeTitle("How it works!"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_DESCRIPTION, "This section shows how to use the different classes and interfaces from the 'Lib-FXML' api:"); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'FXMLAction'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnesController' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Answers the question how to register (handle) action methods from type 'Consumer<FXMLModel>', 'EventHandler<ActionEvent>' and 'Function<Long, FXMLModel>'."); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'FXMLController'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnesController'."); // NOI18N
        super.writeListPoint("TODO  Answers the question how to use the controller to managed the attributs and their data in the gui."); // NOI18N
        super.writeListPoint("The controller will be associated with the file 'demoallinones.fxml' via 'FXMLView'."); // NOI18N
        super.writeListPoint("TODO fxml=declaration, controller=initialization"); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'FXMLModel'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes', 'DemoAllInOnesController' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Answers the question how to use the model to managed the dataflow to (in, from) the gui."); // NOI18N
        super.writeListPoint("The 'FXMLModel' will be initialized in the entity 'DemoAllInOnesEntity' with the convention methods from the interface 'FXMLModelable'."); // NOI18N
        super.writeListPoint("TODO how to add some additional data to extend the original entity"); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("Usage from the interface 'FXMLModelable'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnesEntity'."); // NOI18N
        super.writeListPoint("Answers the question how to use the interface as a convention to initialize a FXMLModel with different entity properties."); // NOI18N
        
        super.writeTitleSmall("Usage from the interface 'FXMLRegisterable'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes', 'DemoAllInOnesController' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Answers the question how to use the interface as a convention to register different action methods via lambda injection."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_DESCRIPTION, "And some additional usage infos from the demo classes:"); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'DemoAllInOnes'"); // NOI18N
        
        super.writeTitleSmall("Usage from the abstract class DemoInfoWriter.java"); // NOI18N
        
        super.writeTitleSmall("Usage from the class DemoAllInOnesInfoWriter.java"); // NOI18N
        super.writeListPoint("TODO Usage from the library 'Lib-Action' which will be used to register (handle) an action from type 'EventHandler<ActionEvent>'."); // NOI18N
        
    }
    
}
