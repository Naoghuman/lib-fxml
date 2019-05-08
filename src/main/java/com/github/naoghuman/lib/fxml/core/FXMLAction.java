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
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLAction {
    
    private final static HashMap<String, Consumer<FXMLModel>>       CONSUMERS     = new HashMap();
    private final static HashMap<String, EventHandler<ActionEvent>> EVENTHANDLERS = new HashMap();
    private final static HashMap<String, Function<Long, FXMLModel>> FUNCTIONS     = new HashMap();
    private final static HashMap<String, Supplier<List<FXMLModel>>> SUPPLIERS     = new HashMap();
    
    private final static String ERROR_MSG__ACTION_ID_ISNT_REGISTERED = "Error: The [actionId=%s] isn't registerd!"; // NOI18N
    
    private static final Optional<FXMLAction> INSTANCE = Optional.of(new FXMLAction());
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final FXMLAction getDefault() {
        return INSTANCE.get();
    }
    
    private FXMLAction() {
        
    }
    
    /**
     * 
     * @param   actionId
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void handleAction(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        if (!this.isRegistered(actionId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__ACTION_ID_ISNT_REGISTERED, actionId));
        }
        
        final EventHandler<ActionEvent> eventHandler = EVENTHANDLERS.get(actionId);
        DefaultFXMLValidator.requireNonNull(eventHandler);
        
        eventHandler.handle(new ActionEvent());
    }
    
    /**
     * 
     * @param   actionId
     * @param   source 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void handleAction(final String actionId, final Object source) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String, Object)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(source);
        
        if (!this.isRegistered(actionId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__ACTION_ID_ISNT_REGISTERED, actionId));
        }
        
        final EventHandler<ActionEvent> eventHandler = EVENTHANDLERS.get(actionId);
        DefaultFXMLValidator.requireNonNull(eventHandler);
        
        eventHandler.handle(new ActionEvent(source, null));
    }
    
    /**
     * 
     * @param   actionId
     * @param   model 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void handleConsumer(final String actionId, final FXMLModel model) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleConsumer(String, FXMLModel)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(model);
        
        if (!this.isRegistered(actionId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__ACTION_ID_ISNT_REGISTERED, actionId));
        }
        
        final Consumer<FXMLModel> consumer = CONSUMERS.get(actionId);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        consumer.accept(model);
    }
    
    /**
     * 
     * @param   actionId
     * @param   entityId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<FXMLModel> handleFunction(final String actionId, final Long entityId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleFunction(String, Long)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        Optional<FXMLModel> model = Optional.empty();
        if (this.isRegistered(actionId)) {
            final Function<Long, FXMLModel> function = FUNCTIONS.get(actionId);
            model = Optional.ofNullable(function.apply(entityId));
        }
        
        return model;
    }
    
    /**
     * 
     * @param   actionId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<List<FXMLModel>> handleSupplier(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleSupplier(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        Optional<List<FXMLModel>> models = Optional.empty();
        if (this.isRegistered(actionId)) {
            final Supplier<List<FXMLModel>> supplier = SUPPLIERS.get(actionId);
            models = Optional.ofNullable(supplier.get());
        }
        
        return models;
    }
    
    /**
     * 
     * @param   actionId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isRegistered(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#isRegistered(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        return CONSUMERS.containsKey(actionId)
                || EVENTHANDLERS.containsKey(actionId)
                || FUNCTIONS.containsKey(actionId)
                || SUPPLIERS.containsKey(actionId);
    }
    
    /**
     * 
     * @param   actionId
     * @param   consumer
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void register(final String actionId, final Consumer<FXMLModel> consumer) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Consumer<FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        CONSUMERS.put(actionId, consumer);
    }
    
    /**
     * 
     * @param   actionId
     * @param   eventHandler
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void register(final String actionId, final EventHandler<ActionEvent> eventHandler) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, EventHandler<ActionEvent>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(eventHandler);
        
        EVENTHANDLERS.put(actionId, eventHandler);
    }

    /**
     * 
     * @param   actionId
     * @param   function
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void register(final String actionId, final Function<Long, FXMLModel> function) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Function<Long, FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(function);
        
        FUNCTIONS.put(actionId, function);
    }

    /**
     * 
     * @param   actionId
     * @param   supplier
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void register(final String actionId, final Supplier<List<FXMLModel>> supplier) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Supplier<List<FXMLModel>>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(supplier);
        
        SUPPLIERS.put(actionId, supplier);
    }
    
    /**
     * 
     * @param   actionId 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void remove(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#remove(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        if (CONSUMERS.containsKey(actionId)) {
            LoggerFacade.getDefault().debug(FXMLAction.class, String.format(
                    "Remove 'Consumer<FXMLModel>' with [actionId]: %s", actionId)); // NOI18N
            
            CONSUMERS.remove(actionId);
        }
        
        if (EVENTHANDLERS.containsKey(actionId)) {
            LoggerFacade.getDefault().debug(FXMLAction.class, String.format(
                    "Remove 'EventHandler<ActionEvent>' with [actionId]: %s", actionId)); // NOI18N
            
            EVENTHANDLERS.remove(actionId);
        }
        
        if (FUNCTIONS.containsKey(actionId)) {
            LoggerFacade.getDefault().debug(FXMLAction.class, String.format(
                    "Remove 'Function<Long, FXMLModel>' with [actionId]: %s", actionId)); // NOI18N
            
            FUNCTIONS.remove(actionId);
        }
        
        if (SUPPLIERS.containsKey(actionId)) {
            LoggerFacade.getDefault().debug(FXMLAction.class, String.format(
                    "Remove 'Supplier<List<FXMLModel>>' with [actionId]: %s", actionId)); // NOI18N
            
            SUPPLIERS.remove(actionId);
        }
    }
    
}
