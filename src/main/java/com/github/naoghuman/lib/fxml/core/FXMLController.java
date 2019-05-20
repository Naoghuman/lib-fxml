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
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * The abstract class {@code FXMLController} allowed the developer to simplify the 
 * handling from one or more entity(ies) data in the gui with the class 
 * {@link com.github.naoghuman.lib.fxml.core.FXMLModel}.
 * 
 * Of course it's also possible to work directly with your own entity in the controller.<br>
 * However, the handling of entity data by the class {@code FXMLModel} is preferred 
 * because it offers even more advantages (see the JavaDoc of the class itself).
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.4.0
 * @author  Naoghuman
 */
public abstract class FXMLController implements Initializable {
    
    private final List<FXMLModel> models = FXCollections.observableArrayList();
    
    /**
     * This method can be used by overwriting to
     * <ul>
     * <li>load an own entity and configure and bind then the entity data or</li>
     * <li>load a {@link com.github.naoghuman.lib.fxml.core.FXMLModel} and configured 
     * and bind then the model data.</li>
     * </ul>
     * 
     * Per {@code default} this method do nothing.
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
     */
    public void configure() {
        
    }
    
    /**
     * This method allowed to configure and bind this instance with the given {@code model}.
     * 
     * By {@code default}, this method first deletes all previously added models, and then adds 
     * the specified {@code model} to the available models. This means that when overriding this 
     * method in the overridden method, the {@code super.configure (model);} is written first, 
     * then followed by the individual treatment instructions (configuration, binding).
     * 
     * @param   model the {@code FXMLModel}
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void configure(final FXMLModel model) {
        DefaultFXMLValidator.requireNonNull(model);
        
        this.getModels().clear();
        this.getModels().add(model);
    }
    
    /**
	 * This method allowed to configure and bind the data from this instance with the given 
	 * {@code models}.
     * 
	 * By {@code default}, this method first deletes all previously added models, and then adds 
     * the specified {@code models} to the available models. This means that when overriding this 
     * method in the overridden method, the {@code super.configure (model);} is written first, 
     * then followed by the individual treatment instructions (configuration, binding).
     * @param   models 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void configure(final List<FXMLModel> models) {
        DefaultFXMLValidator.requireNonNull(models);
        
        this.getModels().clear();
        this.getModels().addAll(models);
    }
    
    /**
     * Search for a {@link com.github.naoghuman.lib.fxml.core.FXMLModel} with the 
     * given {@code entityName} and {@code entityId} and return it wrapped into 
     * an {@code Optional}. If no {@code FXMLModel} is found then {@code Optional#empty()} will
     * returned.
     * 
     * @param   entityName the name from the {@code FXMLModel} which will be searched.
     * @param   entityId   the id   from the {@code FXMLModel} which will be searched.
     * @return  the {@code FXMLModel} wrapped into an {@code Optional} or {@code Optional#empty()}.
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
     * @see     java.util.Optional#empty()
     */
    public Optional<FXMLModel> getModel(final String entityName, final Long entityId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(entityName);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        final FXMLModel searchCriteria = new FXMLModel();
        searchCriteria.setEntity(entityName, entityId);
        
        final Optional<FXMLModel> fxmlModel = models.stream()
                .filter(
                        model -> model.equals(searchCriteria)
                )
                .findFirst();
        
        return fxmlModel;
    }
    
    /**
     * Returns all previously registered {@link com.github.naoghuman.lib.fxml.core.FXMLModel}s.
     * 
     * @return  all momentary available {@code FXMLModel}s in this controller.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLController#configure(FXMLModel)
     * @see     com.github.naoghuman.lib.fxml.core.FXMLController#configure(List)
     * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
     */
    public List<FXMLModel> getModels() {
        return models;
    }
    
    /**
     * Returns the view from this controller as a {@link javafx.scene.Parent} or 
     * {@link java.util.Optional#empty()}.
     * 
     * @return  the view from this controller or {@code Optional#empty()}.
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     java.util.Optional#empty()
     * @see     javafx.scene.Parent
     */
    public Optional<Parent> getView() {
        return Optional.empty();
    }
    
}
