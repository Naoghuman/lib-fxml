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

import com.github.naoghuman.lib.fxml.core.FXMLController;
import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public class DemoWithoutPropertiesFileController extends FXMLController {
    
    @FXML private TextArea taDemoInfos;
    
    private String keyHelloLibFXML;
    private String resources;
    private String location;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "DemoWithoutPropertiesFileController#initialize(URL, ResourceBundle)"); // NOI18N
    
        this.location        = (location  != null ? location.toString()                      : "<not-defined>"); // NOI18N
        this.resources       = (resources != null ? resources.getBaseBundleName()            : "<not-defined>"); // NOI18N
        this.keyHelloLibFXML = (resources != null ? resources.getString("key.hello.libfxml") : "<not-defined>"); // NOI18N
    
        taDemoInfos.appendText(this.initializeDemoInfos());
    }
    
    private String initializeDemoInfos() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoWithoutPropertiesFileController#initializeDemoInfos()"); // NOI18N
    
        final StringBuilder sb = new StringBuilder();
        sb.append("================================================================================\n\n"); // NOI18N
        sb.append("This demo shows how to load the following files with the library 'Lib-FXML' in v0.3.0-PRERELEASE.\n"); // NOI18N
        sb.append(" - The factory FXMLView.create (class FXMLController>, FXMLModel extended)\n"); // NOI18N
        sb.append("   loads an instance of the controller class ").append(this.getClass().getSimpleName()).append(",\n");
        sb.append("   automatically configuring thereby the passed FXMLModel.\n"); // NOI18N
        sb.append(" - The optional file '.css' is automatically loaded with the 'conventional name'\n"); // NOI18N
        sb.append("   (controller name in lower case without the suffix controller).\n\n"); // NOI18N
        
        sb.append("================================================================================\n\n"); // NOI18N
        sb.append("Demo files:\n"); // NOI18N
        sb.append(" - DemoWithAllFiles.java\n"); // NOI18N
        sb.append(" - DemoWithAllFilesController.java\n"); // NOI18N
        sb.append(" - demowithallfiles.css\n"); // NOI18N
        sb.append(" - demowithallfiles.fxml\n\n"); // NOI18N
        
        sb.append("================================================================================\n\n"); // NOI18N
        sb.append("Details:\n"); // NOI18N
        
        return sb.toString();
    }
    
    @Override
    public void configure(final FXMLModel model) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoWithoutPropertiesFileController#configure(FXMLModel)"); // NOI18N
    
        DefaultFXMLValidator.requireNonNull(model);
        
        super.configure(model);
        
        taDemoInfos.appendText(model.toString());
        taDemoInfos.appendText("\n\n"); // NOI18N
        taDemoInfos.appendText(this.toString());
        taDemoInfos.appendText("\n\n"); // NOI18N
    }
    
    /**
     * 
     * @param   fxmlViewInfos 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void onActionShowFXMLViewInfos(final String fxmlViewInfos) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoWithoutPropertiesFileController#onActionShowFXMLViewInfos(String)"); // NOI18N
    
        DefaultFXMLValidator.requireNonNullAndNotEmpty(fxmlViewInfos);
        
        taDemoInfos.appendText(fxmlViewInfos);
        taDemoInfos.appendText("\n\n"); // NOI18N
        taDemoInfos.appendText("================================================================================\n"); // NOI18N
    
        taDemoInfos.positionCaret(0);
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
