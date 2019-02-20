/*
 * Copyright (C) 2018 Naoghuman's dream
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
package com.github.naoghuman.lib.fxml.core;

import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import static java.util.ResourceBundle.getBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLView {
    
    private final static String DEFAULT_SUFFIX_CSS       = ".css"; // NOI18N
    private final static String DEFAULT_SUFFIX_FXML      = ".fxml"; // NOI18N
    private final static String DEFAULT_SUFFIX_PRESENTER = "Presenter"; // NOI18N
    
    /**
     * 
     * @param   presenter
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static FXMLView create(final String presenter) {
        DefaultFXMLValidator.requireEndsWith(presenter, DEFAULT_SUFFIX_PRESENTER);
        
        return new FXMLView(presenter);
    }
    
    /**
     * 
     * @param   presenter
     * @param   model
     * @return 
     * @since   0.2.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public static FXMLView create(final String presenter, final FXMLModel model) {
        DefaultFXMLValidator.requireEndsWith(presenter, DEFAULT_SUFFIX_PRESENTER);
        DefaultFXMLValidator.requireNonNull(model);
        
        final FXMLView view = new FXMLView(presenter);
        view.getPresenter().configure(model);
        
        return new FXMLView(presenter);
    }
    
    private FXMLLoader fxmlLoader;
    private Object     instance;
    private String     baseBundleName;
    private String     conventionalName;
    
    private Optional<ResourceBundle> resourceBundle = Optional.empty();
    private Optional<URL> urlForCSS  = Optional.empty();
    private Optional<URL> urlForFXML = Optional.empty();
    
    private FXMLView(final String presenter) {
        this.initializeResourceBundle(presenter);
        
        this.initializePresenter(presenter);
        
        this.initializeConventionalName();
        this.initializeURLforCSS();
        this.initializeURLforFXML();
        this.initializeFXMLLoader();
    }
    
    private void initializeFXMLLoader() {
        try {
            fxmlLoader = new FXMLLoader();
            
            fxmlLoader.setController(instance);
            fxmlLoader.setLocation( this.getURLforFXML().get());
            fxmlLoader.setResources(this.getResourceBundle().get());
            
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(FXMLView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializePresenter(final String presenter) {
        try {
            instance = Class.forName(presenter).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FXMLView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initializeConventionalName() {
        conventionalName = this.getInstance().getClass().getSimpleName();
        conventionalName = conventionalName.substring(0, conventionalName.lastIndexOf(DEFAULT_SUFFIX_PRESENTER));
        conventionalName = conventionalName.toLowerCase();
    }
    
    private void initializeResourceBundle(final String presenter) {
        baseBundleName = presenter.substring(0, presenter.lastIndexOf(DEFAULT_SUFFIX_PRESENTER));
        baseBundleName = baseBundleName.toLowerCase();
        
        try {
            resourceBundle = Optional.ofNullable(getBundle(baseBundleName));
        } catch (MissingResourceException ex) {
        }
    }
    
    private void initializeURLforCSS() {
        urlForCSS = Optional.ofNullable(this.getInstance().getClass().getResource(this.getConventionalName() + DEFAULT_SUFFIX_CSS));
    }
    
    private void initializeURLforFXML() {
        urlForFXML = Optional.ofNullable(this.getInstance().getClass().getResource(this.getConventionalName() + DEFAULT_SUFFIX_FXML));
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public String getBaseBundleName() {
        return baseBundleName;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public String getConventionalName() {
        return conventionalName;
    }
    
    private Object getInstance() {
        return instance;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public FXMLPresenter getPresenter() {
        return (FXMLPresenter) fxmlLoader.getController();
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<ResourceBundle> getResourceBundle() {
        return resourceBundle;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<Parent> getView() {
        Optional<Parent> parent = Optional.empty();
        if (fxmlLoader != null) {
            parent = Optional.ofNullable(fxmlLoader.getRoot());
        }
        
        if (parent.isPresent() && urlForCSS.isPresent()) {
            parent.get().getStylesheets().add(urlForCSS.get().toExternalForm());
        }
        
        return parent;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<URL> getURLforCSS() {
        return urlForCSS;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<URL> getURLforFXML() {
        return urlForFXML;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLVIEW [").append("\n"); // NOI18N
        
        sb.append("  presenter       : ").append(this.getInstance().getClass().getName()).append("\n"); // NOI18N
        sb.append("  conventionalName: ").append(this.getConventionalName()).append("\n"); // NOI18N
        sb.append("  baseBundleName  : ").append(this.getBaseBundleName()).append("\n"); // NOI18N
        sb.append("  urlForCSS       : ").append(this.getURLforCSS().isPresent()  ? this.getURLforCSS().get().toString()  : "<NOT-DEFINED>").append("\n"); // NOI18N
        sb.append("  urlForFXML      : ").append(this.getURLforFXML().isPresent() ? this.getURLforFXML().get().toString() : "<NOT-DEFINED>").append("\n"); // NOI18N
        sb.append("  parent          : ").append(this.getView().isPresent()       ? this.getView().get().toString()       : "<NOT-DEFINED>").append("\n"); // NOI18N
        
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
