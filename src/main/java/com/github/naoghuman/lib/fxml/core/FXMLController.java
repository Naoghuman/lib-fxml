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
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.scene.Parent;

/**
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public abstract class FXMLController {
    
    private final List<FXMLModel> models = FXCollections.observableArrayList();
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void clear() {
        this.getModels().clear();
    }
    
    /**
     * 
     * @param   model 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void configure(final FXMLModel model) {
        DefaultFXMLValidator.requireNonNull(model);
        
        this.getModels().add(model);
    }
    
    public void configure(final List<FXMLModel> models) {
        DefaultFXMLValidator.requireNonNull(models);
        
        this.getModels().addAll(models);
    }
    
    /**
     * 
     * @param   entityType
     * @param   entityId
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<FXMLModel> getModel(final Class entityType, final Long entityId) {
        DefaultFXMLValidator.requireNonNull(entityType);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        final Optional<FXMLModel> fxmlModel = models.stream()
                .filter(model ->
                        model.isSameEntityType(entityType)
                        && model.isSameEntityId(entityId)
                )
                .findFirst();
        
        return fxmlModel;
    }
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public List<FXMLModel> getModels() {
        return models;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<Parent> getView() {
        return Optional.empty();
    }
    
}
