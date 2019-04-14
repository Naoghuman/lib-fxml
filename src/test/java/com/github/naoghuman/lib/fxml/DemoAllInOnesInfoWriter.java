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
        
        super.writeTitleSmall("General features"); // NOI18N
        super.writeListPoint("How to use the abstract class 'FXMLController' as a convention to managed the presentation from the 'FXMLModel' data in a concrete implementation from 'FXMLController'."); // NOI18N
        super.writeListPoint("How to use the class 'FXMLModel' as a lightweight version from an entity to manage the dataflow to (in, from) the controller."); // NOI18N
        super.writeListPoint("How to use the class 'FXMLView' to load the gui declaration (.fxml file) and map it (initialization from the gui) to a controller."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("Extended features"); // NOI18N
        super.writeListPoint("How to use the singleton 'FXMLAction' to register (handle) lambda methods such like 'Consumer', 'Function' and 'Supplier'."); // NOI18N
        super.writeListPoint("How to use the class 'FXMLModel' to add additional methods which extend the original entity behavior. For example 'isUpdatedProperty()'."); // NOI18N
        super.writeListPoint("How to use the interface 'FXMLRegisterable' as a convention which allowes developers to register for example action methods."); // NOI18N
        super.writeListPoint("How to use the interface 'FXMLModelable' as a convention to create a lightweight version from an entity."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("Additional features"); // NOI18N
        super.writeListPoint("How to implement a 'singleton' instance with 'Optional<T>' in 'FXMLAction' and access the class behaviours with the static method 'getDefault()'."); // NOI18N
        super.writeListPoint("How to use the 'JavaFX' default binding features to automatically update the 'FXMLModel' (entity) data to (in, from) the controller."); // NOI18N
        super.writeListPoint("How to use the 'JavaFX' standard class 'FXMLLoader' in 'FXMLView' to load '.fxml', '.css', '.properties' files and assoziate them with a controller."); // NOI18N
        super.writeListPoint("How to style with 'CSS' different 'JavaFX' components such like 'AnchorPane', 'Button', 'TextField', 'ScrollPane'."); // NOI18N
        super.writeListPoint("How to use the library 'Lib-Logger' (https://github.com/Naoghuman/lib-logger) to log messages easily to a log-file."); // NOI18N
        
        super.writeEmptyLine();
    }
    
    @Override
    protected void writeSectionInfoDemoFiles() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesInfoWriter#writeSectionDemoFiles()"); // NOI18N
        
        super.writeTitle("Demo files"); // NOI18N
        super.writeSeparator();
        
        super.writeText(SIZE_DESCRIPTION, "In this section all files are listed which are involved into this demo. Also their main purpose are explained:"); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnes.java"); // NOI18N
        super.writeListPoint("Shows how to start a 'JavaFX' application :) ."); // NOI18N
        super.writeListPoint("Shows how to create an instance from the class 'FXMLView' to show then the gui with 'view.getRoot().orElse(new AnchorPane())' in the demo application."); // NOI18N
        super.writeListPoint("Shows how the interface 'FXMLRegisterable' can be used as a convention to register the action method from this class."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesController.java"); // NOI18N
        super.writeListPoint("Shows how the developer can access the 'URL' from the '.fxml' file."); // NOI18N
        super.writeListPoint("Shows how the developer can access the optional 'ResourceBundle' if defined."); // NOI18N
        super.writeListPoint("Shows how to use the classes 'DemoInfoWriter', 'DemoAllInOnesInfoWriter' and 'DemoAllInOnesPreferencesWriter' to write the demo infos."); // NOI18N
        super.writeListPoint("Shows how to use the overriden method 'FXMLController#configure(FXMLModel) to bind the data from the 'FXMLModel' to the gui components."); // NOI18N
        super.writeListPoint("Shows how the interface 'FXMLRegisterable' can be used as a convention to register the various action methods from this controller."); // NOI18N
        super.writeListPoint("Shows how to use the different 'FXMLAction#handle(...)' methods to fit the necessities from this controller."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesEntity.java"); // NOI18N
        super.writeListPoint("Shows how to create a simple 'POJO' with 'JavaFX' properties ('LongProperty' and 'StringProperty')."); // NOI18N
        super.writeListPoint("Shows the usage from 'JavaFX' properties to bind data which means we don't need to be aware that the data is up-to-date :)."); // NOI18N
        super.writeListPoint("Shows how to use the interface 'FXMLModelable' which allowed to configure a 'FXMLModel' with selected data properties from the entity."); // NOI18N
        
        super.writeTitleSmall("DemoAllInOnesSqlEntityProvider.java"); // NOI18N
        super.writeListPoint("Shows how to define a simple 'sql' entity provider which simulates the 'crud' operations for an entity to (from) a database."); // NOI18N
        super.writeListPoint("Shows how to use the interface 'FXMLRegisterable' as a convention to register the action methods from this class."); // NOI18N
        super.writeListPoint("Shows how to use the class 'FXMLAction' to register the (crud) action methods via lambda injection."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("demoallinones.css"); // NOI18N
        super.writeListPoint("Shows how to create a 'CSS' (Cascading Style Sheets) file which styles will be then shown in the demo application."); // NOI18N
        super.writeListPoint("Shows how to style with 'CSS' different 'JavaFX' components such like 'AnchorPane', 'Button', 'TextField', 'ScrollPane'."); // NOI18N
        
        super.writeTitleSmall("demoallinones.fxml"); // NOI18N
        super.writeListPoint("Shows how to define a declaration from the demo gui in form from a special JavaFX 'XML' file so called 'FXML'."); // NOI18N
        super.writeListPoint("Shows how then the initialization will be done during the loading and mapping from the '.fxml' file with the corresponding 'controller'."); // NOI18N
        super.writeListPoint("See 'FXMLView#initializeFXMLLoader(FXMLModel)' for more informations."); // NOI18N
        
        super.writeTitleSmall("demoallinones.properties"); // NOI18N
        super.writeListPoint("Shows how to create a '.properties' file which can contains different 'key/value' String pairs. Over the 'key' the 'value' can retrieved then in the application."); // NOI18N
        super.writeListPoint("An alternative is the useage from my Library 'Lib-I18N' (https://github.com/Naoghuman/lib-i18n), which allowed multilingualism depending from an actual 'Locale'."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeText(SIZE_DESCRIPTION, "The next files are used to create the demo informations:"); // NOI18N
        
        super.writeTitleSmall("DemoInfoWriter.java"); // NOI18N
        super.writeListPoint("The abstract class 'DemoInfoWriter' offers various functions for writing different styled informations into a 'VBox'."); // NOI18N
        super.writeListPoint("For example: Styled text (size, FontPosture), 'Button's, 'Separator's and 'TextField's."); // NOI18N
        
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
        
        super.writeTitleSmall("Usage from the singleton class 'FXMLAction'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes', 'DemoAllInOnesController', 'DemoAllInOnesInfoWriter' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Answers the question how to implement a 'singleton' instance with 'Optional<T>' in 'FXMLAction' and access the class behaviours with the static method 'getDefault()'."); // NOI18N
        super.writeListPoint("Answers the question how to register (handle) action methods from type 'Consumer<FXMLModel>', 'EventHandler<ActionEvent>' and 'Function<Long, FXMLModel>'."); // NOI18N
        super.writeListPoint("Answers also the question how to register (handle) action methods from type 'EventHandler<ActionEvent>'."); // NOI18N
        
        super.writeTitleSmall("Usage from the abstract class 'FXMLController'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnesController'."); // NOI18N
        super.writeListPoint("Used in 'FXMLView'."); // NOI18N
        super.writeListPoint("Answers the question how to use the abstract class as a convention to managed the presentation from the 'FXMLModel' data in a concrete controller."); // NOI18N
        super.writeListPoint("Answers the question how the controller (it's attributs) is the initialization from the declaration in the '.fxml' file."); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'FXMLModel'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes', 'DemoAllInOnesController', 'DemoAllInOnesEntity' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Used in 'FXMLAction', 'FXMLController', 'FXMLModelable' and 'FXMLView'."); // NOI18N
        super.writeListPoint("Answers the question how to use the model to managed the dataflow to (in, from) the gui."); // NOI18N
        super.writeListPoint("Answers the question how the 'FXMLModel' will be initialized in the entity 'DemoAllInOnesEntity' with the convention methods from the interface 'FXMLModelable'."); // NOI18N
        super.writeListPoint("Answers the question how to add some additional data methods to extend the behavior from the original entity."); // NOI18N
        
        super.writeTitleSmall("Usage from the class 'FXMLView'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes'."); // NOI18N
        super.writeListPoint("Answers the question how to use the class 'FXMLView' to load the gui declaration (.fxml file) and map it (initialization from the gui) to a controller."); // NOI18N
        super.writeListPoint("Answers the question how to use the 'JavaFX' standard class 'FXMLLoader' in 'FXMLView' to load '.fxml', '.css', '.properties' files and assoziate them with a controller."); // NOI18N
        
        super.writeEmptyLine(SIZE_HALF_EMPTY);
        
        super.writeTitleSmall("Usage from the interface 'FXMLModelable'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnesEntity'."); // NOI18N
        super.writeListPoint("Answers the question how to use the interface as a convention to initialize a FXMLModel with different entity properties."); // NOI18N
        
        super.writeTitleSmall("Usage from the interface 'FXMLRegisterable'"); // NOI18N
        super.writeListPoint("Used in 'DemoAllInOnes', 'DemoAllInOnesController' and 'DemoAllInOnesSqlEntityProvider'."); // NOI18N
        super.writeListPoint("Answers the question how to use the interface as a convention to register different action methods via 'lambda' injection."); // NOI18N
    }
    
}
