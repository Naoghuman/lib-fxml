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
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public abstract class DemoInfoWriter {
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static double SIZE_DESCRIPTION = 16.0d;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static double SIZE_EMPTY = 10.0d;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static double SIZE_HALF_EMPTY = 5.0d;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static double SIZE_TEXT = 12.0d;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static double SIZE_TITLE = 22.0d;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static String PREFIX_EMPTY = "    "; // NOI18N
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected final static String PREFIX_MINUS = "  - "; // NOI18N
    
    private final static String ERROR_MSG__TEXTFIELD_ID_ISNT_REGISTERED = "Error: The [textFieldId=%s] isn't registerd!"; // NOI18N
    
    private final static HashMap<String, TextField> TEXTFIELDS = new HashMap();
    
    private VBox vBox;
    
    /**
     * 
     * @param   vBox 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void configure(final VBox vBox) {
        DefaultFXMLValidator.requireNonNull(vBox);
        
        this.vBox = vBox;
    }
    
    /**
     * 
     * @param   textFieldId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public TextField getTextField(final String textFieldId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(textFieldId);
        
        if (!TEXTFIELDS.containsKey(textFieldId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__TEXTFIELD_ID_ISNT_REGISTERED, textFieldId));
        }
        
        final TextField textField = TEXTFIELDS.get(textFieldId);
        DefaultFXMLValidator.requireNonNull(textField);
        
        return textField;
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void writeSectionInfo() {
        this.writeSectionInfoIntention();
        this.writeSectionInfoDemoFiles();
        this.writeSectionInfoHowItWorks();
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void writeSectionPreferences() {
        this.writeSectionPreferencesDescription();
        this.writeSectionPreferencesCRUD();
        this.writeSectionPreferencesAdditional();
    }
    
    /**
     * 
     * @param   text 
     * @param   tooltip 
     * @param   actionId 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeButton(final String text, final String tooltip, final String actionId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(tooltip);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        final Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setOnAction((event) -> {
            FXMLAction.getDefault().handleAction(actionId);
        });
        btn.setTooltip(new Tooltip(tooltip));
        VBox.setMargin(btn, new Insets(0.0d, 0.0d, 5.0d, 0.0d));
        
        vBox.getChildren().add(btn);
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionInfoDemoFiles() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionInfoHowItWorks() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionInfoIntention() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionPreferencesAdditional() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionPreferencesDescription() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSectionPreferencesCRUD() {}
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeEmptyLine() {
        this.writeEmptyLine(SIZE_EMPTY);
    }
    
    /**
     * 
     * @param   size 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeEmptyLine(final double size) {
        final Label label = new Label("");       // NOI18N
        label.setFont(new Font("System", size)); // NOI18N
        
        vBox.getChildren().add(label);
    }
    
    /**
     * 
     * @param   text 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeListPoint(final String text) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        
        this.writeListPoint(PREFIX_MINUS, text);
    }
    
    /**
     * 
     * @param   prefix
     * @param   text
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeListPoint(final String prefix, final String text) {
        DefaultFXMLValidator.requireNonNull(prefix);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        
        final Label msg = new Label(prefix + text);
        msg.setFont(Font.font("System", SIZE_TEXT)); // NOI18N
        msg.setWrapText(true);
        msg.prefWidthProperty().bind(vBox.widthProperty());
        
        vBox.getChildren().add(msg);
    }
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeSeparator() {
        final Separator separator = new Separator();
        separator.setPadding(new Insets(0.0d, 0.0d, 5.0d, 0.0d));
        
        vBox.getChildren().add(separator);
    }
    
    /**
     * 
     * @param   size
     * @param   text 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeText(final double size, final String text) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        
        this.writeText(size, text, FontPosture.REGULAR);
    }
    
    /**
     * 
     * @param   size
     * @param   text
     * @param   fontPosture 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeText(final double size, final String text, final FontPosture fontPosture) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        DefaultFXMLValidator.requireNonNull(fontPosture);
        
        final Label label = new Label(text);
        label.setFont(Font.font("System", fontPosture, size)); // NOI18N
        label.setPadding(new Insets((size != SIZE_TEXT) ? 0 : 2, 0, 0, 0));
        label.setWrapText(true);
        label.prefWidthProperty().bind(vBox.widthProperty());
        
        vBox.getChildren().add(label);
    }
    
    /**
     * 
     * @param   textFieldId 
     * @param   tooltip 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeTextField(final String textFieldId, final String tooltip) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(textFieldId);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(tooltip);
        
        final TextField textField = new TextField();
        textField.prefWidthProperty().bind(vBox.widthProperty());
        textField.setFocusTraversable(false);
        textField.setTooltip(new Tooltip(tooltip));
        
        vBox.getChildren().add(textField);
        TEXTFIELDS.put(textFieldId, textField);
    }
    
    /**
     * 
     * @param   text 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeTitle(final String text) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        
        this.writeText(SIZE_TITLE, text, FontPosture.REGULAR);
    }
    
    /**
     * 
     * @param   text 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeTitleSmall(final String text) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        
        this.writeTitleSmall(text, FontPosture.ITALIC);
    }
    
    /**
     * 
     * @param   text 
     * @param   fontPosture 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    protected void writeTitleSmall(final String text, final FontPosture fontPosture) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(text);
        DefaultFXMLValidator.requireNonNull(fontPosture);
        
        this.writeText(SIZE_TEXT, text, fontPosture);
    }
    
}
