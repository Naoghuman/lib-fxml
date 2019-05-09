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
package com.github.naoghuman.lib.fxml.core;

import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLView {
    
    private final static String DEFAULT_SUFFIX_CSS        = ".css";       // NOI18N
    private final static String DEFAULT_SUFFIX_FXML       = ".fxml";      // NOI18N
    private final static String DEFAULT_SUFFIX_CONTROLLER = "Controller"; // NOI18N
    
    /**
     * 
     * @param   controller
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static FXMLView create(final Class<? extends FXMLController> controller) {
        return FXMLView.create(controller, new FXMLModel());
    }
    
    /**
     * 
     * @param   controller
     * @param   model
     * @return 
     * @since   0.2.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static FXMLView create(final Class<? extends FXMLController> controller, final FXMLModel model) {
        return new FXMLView(controller, model);
    }
    
    private FXMLLoader fxmlLoader;
    private Object     instance;
    private String     baseBundleName;
    private String     conventionalName;
    private URL        urlForFXML;
    
    private Optional<ResourceBundle> resourceBundle = Optional.empty();
    private Optional<URL>            urlForCSS      = Optional.empty();

    private FXMLView(final Class<? extends FXMLController> controller, final FXMLModel model) {
        DefaultFXMLValidator.requireNonNull(controller);
        DefaultFXMLValidator.requireNonNull(model);
        
        this.initializeController(controller);
        this.initializeConventionalName();
        this.initializeURLforFXML();
        this.initializeResourceBundle(controller);
        this.initializeURLforCSS();
        
        this.initializeFXMLLoader(model);
    }
    
    private void initializeController(final Class<? extends FXMLController> controller) {
        final String controllerName = controller.getName();
        DefaultFXMLValidator.requireEndsWith(controllerName, DEFAULT_SUFFIX_CONTROLLER);
        
        try {
            instance = Class.forName(controllerName).newInstance();
            DefaultFXMLValidator.requireNonNull(instance);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            LoggerFacade.getDefault().error(this.getClass(),
                    String.format(
                            "Can't create a 'controller' instance from class: %s", // NOI18N
                            controllerName),
                    ex);
        }
    }
    
    private void initializeConventionalName() {
        final String simpleName = this.getInstance().getClass().getSimpleName();
        DefaultFXMLValidator.requireEndsWith(simpleName, DEFAULT_SUFFIX_CONTROLLER);
        
        conventionalName = simpleName.substring(0, simpleName.lastIndexOf(DEFAULT_SUFFIX_CONTROLLER));
        conventionalName = conventionalName.toLowerCase();
        DefaultFXMLValidator.requireNonNullAndNotEmpty(conventionalName);
    }
    
    private void initializeURLforFXML() {
        urlForFXML = this.getInstance().getClass().getResource(this.getConventionalName() + DEFAULT_SUFFIX_FXML);
        if (urlForFXML == null) {
            throw new IllegalArgumentException(String.format(
                    "Can't find a '.fxml' resource with the name: %s%s", // NOI18N
                    this.getConventionalName(),
                    DEFAULT_SUFFIX_FXML));
        }
    }
    
    private void initializeResourceBundle(final Class<? extends FXMLController> controller) {
        final String controllerName = controller.getName();
        DefaultFXMLValidator.requireEndsWith(controllerName, DEFAULT_SUFFIX_CONTROLLER);
        
        baseBundleName = controllerName.substring(0, controllerName.lastIndexOf(DEFAULT_SUFFIX_CONTROLLER));
        baseBundleName = baseBundleName.toLowerCase();
        DefaultFXMLValidator.requireNonNullAndNotEmpty(baseBundleName);
        
        try {
            resourceBundle = Optional.ofNullable(ResourceBundle.getBundle(baseBundleName));
        } catch (MissingResourceException ex) {
            LoggerFacade.getDefault().warn(this.getClass(), 
                    String.format(
                            "Can't find a ResourceBundle with the specified 'base' name: %s. Skip loading from the ResourceBundle.", // NOI18N
                            baseBundleName));
        }
    }
    
    private void initializeURLforCSS() {
        urlForCSS = Optional.ofNullable(this.getInstance().getClass().getResource(this.getConventionalName() + DEFAULT_SUFFIX_CSS));
    }
    
    private void initializeFXMLLoader(final FXMLModel model) {
        try {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setController(this.getInstance());
            fxmlLoader.setLocation(  this.getURLforFXML());
            
            this.getResourceBundle().ifPresent((bundle) -> {
                fxmlLoader.setResources(bundle);
            });
            
            fxmlLoader.load();
        
            this.getRoot().ifPresent((root) -> {
                this.getURLforCSS().ifPresent((url) -> {
                    root.getStylesheets().add(url.toExternalForm());
                });
            });
            
            this.getController().configure(model);
        } catch (IOException ex) {
            LoggerFacade.getDefault().error(this.getClass(),
                    String.format(
                            "Can't load '.fxml' file with the path: %s", // NOI18N
                            this.getURLforFXML().getPath()),
                    ex);
        }
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
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public FXMLController getController() {
        return (FXMLController) fxmlLoader.getController();
    }
    
    
    /**
     * 
     * @param   <T>
     * @param   type
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public <T extends FXMLController> Optional<T> getController(final Class<T> type) {
        DefaultFXMLValidator.requireNonNull(type);
        
        Optional<T> value = Optional.empty();
        try {
            value = Optional.ofNullable(type.cast(this.getController()));
        } catch (Exception ex) {
            LoggerFacade.getDefault().warn(this.getClass(), 
                    String.format(
                            "Can't downcast FXMLController to type of '%s'. Return Optional.empty().",
                            type.getName()), 
                    ex);
        }
        
        return value;
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
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<Parent> getRoot() {
        return Optional.ofNullable(fxmlLoader.getRoot());
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
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public URL getURLforFXML() {
        return urlForFXML;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLView [\n"); // NOI18N
        
        sb.append("  controller       = ").append(this.getController().getClass().getName()).append(",\n"); // NOI18N
        sb.append("  conventionalName = ").append(this.getConventionalName()               ).append(",\n"); // NOI18N
        sb.append("  baseBundleName   = ").append(this.getBaseBundleName()                 ).append(",\n"); // NOI18N
        sb.append("  urlForFXML       = ").append(this.getURLforFXML() != null    ? this.getURLforFXML().toString()      : "<not-defined>").append(",\n"); // NOI18N
        sb.append("  urlForCSS        = ").append(this.getURLforCSS().isPresent() ? this.getURLforCSS().get().toString() : "<not-defined>").append(",\n"); // NOI18N
        sb.append("  root             = ").append(this.getRoot().isPresent()      ? this.getRoot().get().toString()      : "<not-defined>").append("\n"); // NOI18N
        
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
