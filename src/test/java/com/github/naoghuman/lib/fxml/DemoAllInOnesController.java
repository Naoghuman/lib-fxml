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

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.fxml.core.FXMLAction;
import com.github.naoghuman.lib.fxml.core.FXMLController;
import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoAllInOnesController extends FXMLController implements Initializable {
    
    @FXML private TextArea  taDemoInfos;
    @FXML private TextField tfEntityId;
    @FXML private TextField tfEntityTitle;
    
    private String keyHelloLibFXML;
    private String resources;
    private String location;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initialize(URL, ResourceBundle)"); // NOI18N
    
        this.location        = (location  != null ? location.toString()                      : "<not-defined>"); // NOI18N
        this.resources       = (resources != null ? resources.getBaseBundleName()            : "<not-defined>"); // NOI18N
        this.keyHelloLibFXML = (resources != null ? resources.getString("key.hello.libfxml") : "<not-defined>"); // NOI18N
    
        taDemoInfos.appendText(this.initializeDemoInfosIntention());
        taDemoInfos.appendText(this.initializeDemoInfosDemoFiles());
        taDemoInfos.appendText(this.initializeDemoInfosHowThisWorks());
    }
    
    private String initializeDemoInfosIntention() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initializeDemoInfosIntention()"); // NOI18N
    
        final StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n"); // NOI18N
        sb.append("Intention\n"); // NOI18N
        sb.append("\n");          // NOI18N
        sb.append("This demo shows how to load the following files with the library 'Lib-FXML' in v0.3.0-PRERELEASE.\n"); // NOI18N
        sb.append(" - The factory FXMLView.create (class FXMLController>, FXMLModel extended)\n"); // NOI18N
        sb.append("   loads an instance of the controller class ").append(this.getClass().getSimpleName()).append(",\n");
        sb.append("   automatically configuring thereby the passed FXMLModel.\n"); // NOI18N
        sb.append(" - The optional files '.css' and '.properties' are automatically loaded\n"); // NOI18N
        sb.append("   with the 'conventional name' (controller name in lower case without the suffix controller).\n"); // NOI18N
        sb.append("\n");          // NOI18N

        return sb.toString();
    }
    
    private String initializeDemoInfosDemoFiles() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initializeDemoInfosDemoFiles()"); // NOI18N
    
        final StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n"); // NOI18N
        sb.append("Demo files\n");                      // NOI18N
        sb.append("\n");                                // NOI18N
        sb.append(" - DemoAllInOnes.java\n");           // NOI18N
        sb.append(" - DemoAllInOnesController.java\n"); // NOI18N
        sb.append(" - DemoAllInOnesEntity.java\n");     // NOI18N
        sb.append(" - DemoAllInOnesSqlEntity.java\n");  // NOI18N
        sb.append(" - demoallinones.css\n");            // NOI18N
        sb.append(" - demoallinones.fxml\n");           // NOI18N
        sb.append(" - demoallinones.properties\n");   // NOI18N
        sb.append("\n");                                // NOI18N
        
        return sb.toString();
    }
    
    private String initializeDemoInfosHowThisWorks() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initializeDemoInfosHowThisWorks()"); // NOI18N
    
        final StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n"); // NOI18N
        sb.append("How this works!\n"); // NOI18N
        sb.append("\n");                // NOI18N
        sb.append("================================================================================\n"); // NOI18N
        
        return sb.toString();
    }
    
    @Override
    public void configure(final FXMLModel model) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#configure(FXMLModel)"); // NOI18N
    
        DefaultFXMLValidator.requireNonNull(model);
        
        super.configure(model);
        
        final Optional<StringProperty> optionalTitle = model.getData(StringProperty.class, DemoAllInOnesEntity.TITLE);
        optionalTitle.ifPresent(title -> {
            tfEntityTitle.textProperty().bindBidirectional(title);
        });
        
        final Optional<LongProperty> optionalId = model.getData(LongProperty.class, DemoAllInOnesEntity.ID);
        optionalId.ifPresent(entityId -> {
            final StringConverter stringConverter = new StringConverter<Long>() {
                @Override
                public String toString(final Long number) {
                    return number == null ? "0" : number.toString(); // NOI18N
                }

                @Override
                public Long fromString(final String string) {
                    long number = 0;
                    if (string != null && !string.equals("") && !string.equals("-")) { // NOI18N
                        number = Long.valueOf(string);
                    }
                        
                    return number;
                }
            };
            
            tfEntityId.textProperty().bindBidirectional(entityId, stringConverter);
        });
    }
    
    public void onActionEntityLoad() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionEntityLoad()"); // NOI18N
        
        Long   entityId = DemoAllInOnesSqlEntity.DEFAULT_ID;
        String strId    = tfEntityId.getText();
        if (!strId.equals("") && !strId.equals("-")) { // NOI18N
            entityId = Long.parseLong(strId);
        }
        
        final FXMLModel modelFromDatabase = FXMLAction.handle(DemoAllInOnesSqlEntity.ON_ACTION__ENTITY__LOAD, entityId);
        this.configure(modelFromDatabase);
    }
    
    public void onActionEntitySave() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionEntitySave()"); // NOI18N
        
        final Optional<FXMLModel> optionalModel = super.getModel(DemoAllInOnesEntity.class, Long.parseLong(tfEntityId.getText()));
        optionalModel.ifPresent(model -> {
            FXMLAction.handle(DemoAllInOnesSqlEntity.ON_ACTION__ENTITY__SAVE, model);
        });
    }
    
    public void onActionPrintFXMLControllerInfos() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionPrintFXMLControllerInfos()"); // NOI18N
        
        System.out.println(this.toString());
    }
    
    public void onActionPrintFXMLModelInfos() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionPrintFXMLModelInfos()"); // NOI18N
        
        final Optional<FXMLModel> optionalModel = super.getModel(DemoAllInOnesEntity.class, Long.parseLong(tfEntityId.getText()));
        optionalModel.ifPresent(model -> {
            System.out.println(model.toString());
        });
    }
    
    public void onActionPrintFXMLViewInfos() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionPrintFXMLViewInfos()"); // NOI18N
        
        ActionHandlerFacade.getDefault().handle(DemoAllInOnes.ON_ACTION__PRINT_FXMLVIEW_INFOS);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" [\n"); // NOI18N
        
        sb.append("  urlLocation       = ").append(location       ).append(",\n"); // NOI18N
        sb.append("  resourceBundle    = ").append(resources      ).append(",\n"); // NOI18N
        sb.append("  key.hello.libfxml = ").append(keyHelloLibFXML).append("\n");  // NOI18N
        
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
