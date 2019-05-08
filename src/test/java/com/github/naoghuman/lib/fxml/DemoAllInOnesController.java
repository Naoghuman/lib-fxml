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
import com.github.naoghuman.lib.fxml.core.FXMLController;
import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.core.FXMLRegisterable;
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class DemoAllInOnesController extends FXMLController implements FXMLRegisterable, Initializable {
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__ENTITY_LOAD = "ON_ACTION__ENTITY_LOAD"; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__ENTITY_NEW = "ON_ACTION__ENTITY_NEW"; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__ENTITY_SAVE = "ON_ACTION__ENTITY_SAVE"; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__PRINT_FXMLMODEL_INFOS = "ON_ACTION__PRINT_FXMLMODEL_INFOS"; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__PRINT_FXMLCONTROLLER_INFOS = "ON_ACTION__PRINT_FXMLCONTROLLER_INFOS"; // NOI18N
    
    @FXML private VBox vbDemoInfos;
    @FXML private VBox vbPreferences;
    
    private String keyHelloLibFXML;
    private String resources;
    private String location;
    
    private DemoInfoWriter demoAllInOnesPreferencesWriter;
    
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initialize(URL, ResourceBundle)"); // NOI18N
    
        this.location        = (location  != null ? location.toString()                      : "<not-defined>"); // NOI18N
        this.resources       = (resources != null ? resources.getBaseBundleName()            : "<not-defined>"); // NOI18N
        this.keyHelloLibFXML = (resources != null ? resources.getString("key.hello.libfxml") : "<not-defined>"); // NOI18N
        
        this.register();
        
        this.initializeDemoInfoWriter();
        this.initializeDemoPreferencesWriter();
    }
    
    private void initializeDemoInfoWriter() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initializeDemoInfoWriter()"); // NOI18N
        
        final DemoInfoWriter demoAllInOnesInfoWriter = new DemoAllInOnesInfoWriter();
        demoAllInOnesInfoWriter.configure(vbDemoInfos);
        demoAllInOnesInfoWriter.writeSectionInfo();
    }
    
    private void initializeDemoPreferencesWriter() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController#initializeDemoPreferencesWriter()"); // NOI18N
        
        demoAllInOnesPreferencesWriter = new DemoAllInOnesPreferencesWriter();
        demoAllInOnesPreferencesWriter.configure(vbPreferences);
        demoAllInOnesPreferencesWriter.writeSectionPreferences();
    }
    
    @Override
    public void configure(final FXMLModel model) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#configure(FXMLModel)"); // NOI18N
    
        DefaultFXMLValidator.requireNonNull(model);
        
        super.configure(model);
        
        final Optional<StringProperty> optionalTitle = model.getData(StringProperty.class, DemoAllInOnesEntity.TITLE);
        optionalTitle.ifPresent(title -> {
            final TextField textField = demoAllInOnesPreferencesWriter.getTextField(DemoAllInOnesPreferencesWriter.TEXT_FIELD__ENTITY_TITLE);
            textField.textProperty().bindBidirectional(title);
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
            
            final TextField textField = demoAllInOnesPreferencesWriter.getTextField(DemoAllInOnesPreferencesWriter.TEXT_FIELD__ENTITY_ID);
            textField.textProperty().bindBidirectional(entityId, stringConverter);
        });
    }
    
    /**
     * 
     * @param   event
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionEntityLoad(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionEntityLoad(ActionEvent)"); // NOI18N
        
        final TextField textField = demoAllInOnesPreferencesWriter.getTextField(DemoAllInOnesPreferencesWriter.TEXT_FIELD__ENTITY_ID);
        final String    strId     = textField.getText();
        Long            entityId  = DemoAllInOnesSqlEntityProvider.DEFAULT_ID;
        if (!strId.equals("") && !strId.equals("-")) { // NOI18N
            entityId = Long.parseLong(strId);
        }
        
        final FXMLModel modelFromDatabase = FXMLAction.getDefault().handleFunction(DemoAllInOnesSqlEntityProvider.ON_ACTION__SQL__ENTITY_LOAD, entityId);
        this.configure(modelFromDatabase);
    }
    
    /**
     * 
     * @param   event
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionEntityNew(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionEntityNew(ActionEvent)"); // NOI18N
        
        final FXMLModel modelFromDatabase = FXMLAction.getDefault().handleFunction(DemoAllInOnesSqlEntityProvider.ON_ACTION__SQL__ENTITY_LOAD, DemoAllInOnesSqlEntityProvider.DEFAULT_ID);
        this.configure(modelFromDatabase);
    }
    
    /**
     * 
     * @param   event
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionEntitySave(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionEntitySave(ActionEvent)"); // NOI18N
        
        final TextField           textField     = demoAllInOnesPreferencesWriter.getTextField(DemoAllInOnesPreferencesWriter.TEXT_FIELD__ENTITY_ID);
        final Optional<FXMLModel> optionalModel = super.getModel(DemoAllInOnesEntity.class.getName(), Long.parseLong(textField.getText()));
        optionalModel.ifPresent(model -> {
            FXMLAction.getDefault().handleConsumer(DemoAllInOnesSqlEntityProvider.ON_ACTION__SQL__ENTITY_SAVE, model);
        });
    }
    
    /**
     * 
     * @param   event
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionPrintFXMLControllerInfos(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionPrintFXMLControllerInfos(ActionEvent)"); // NOI18N
        
        System.out.println(this.toString());
    }
    
    /**
     * 
     * @param   event
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionPrintFXMLModelInfos(final ActionEvent event) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesController#onActionPrintFXMLModelInfos(ActionEvent)"); // NOI18N
        
        final TextField           textField     = demoAllInOnesPreferencesWriter.getTextField(DemoAllInOnesPreferencesWriter.TEXT_FIELD__ENTITY_ID);
        final Optional<FXMLModel> optionalModel = super.getModel(DemoAllInOnesEntity.class.getName(), Long.parseLong(textField.getText()));
        optionalModel.ifPresent(model -> {
            System.out.println(model.toString());
        });
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesController.register()"); // NOI18N
        
        FXMLAction.getDefault().register(ON_ACTION__ENTITY_LOAD, this::onActionEntityLoad);
        FXMLAction.getDefault().register(ON_ACTION__ENTITY_NEW,  this::onActionEntityNew);
        FXMLAction.getDefault().register(ON_ACTION__ENTITY_SAVE, this::onActionEntitySave);
        
        FXMLAction.getDefault().register(ON_ACTION__PRINT_FXMLCONTROLLER_INFOS, this::onActionPrintFXMLControllerInfos);
        FXMLAction.getDefault().register(ON_ACTION__PRINT_FXMLMODEL_INFOS,      this::onActionPrintFXMLModelInfos);
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
