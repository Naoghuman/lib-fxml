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
 * @version 0.4.0
 * @author  Naoghuman
 */
public final class FXMLAction {
    
    private final static HashMap<String, Consumer<FXMLModel>>       MAP_CONSUMERS     = new HashMap<>();
    private final static HashMap<String, EventHandler<ActionEvent>> MAP_EVENTHANDLERS = new HashMap<>();
    private final static HashMap<String, Function<Long, FXMLModel>> MAP_FUNCTIONS     = new HashMap<>();
    private final static HashMap<String, Supplier<List<FXMLModel>>> MAP_SUPPLIERS     = new HashMap<>();
    
    private static final Optional<FXMLAction> INSTANCE = Optional.of(new FXMLAction());
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
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
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void handleAction(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        if (this.isRegistered(FXMLAction.Type.EVENTHANDLERS, actionId)) {
            this.handleAction(actionId, ActionEvent.NULL_SOURCE_TARGET);
        }
    }
    
    /**
     * 
     * @param   actionId
     * @param   source 
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code source}   is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void handleAction(final String actionId, final Object source) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String, Object)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(source);
        
        if (this.isRegistered(FXMLAction.Type.EVENTHANDLERS, actionId)) {
            final EventHandler<ActionEvent> eventHandler = MAP_EVENTHANDLERS.get(actionId);
            eventHandler.handle(new ActionEvent(source, ActionEvent.NULL_SOURCE_TARGET));
        }
    }
    
    /**
     * 
     * @param   actionId
     * @param   model 
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code model}    is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void handleConsumer(final String actionId, final FXMLModel model) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleConsumer(String, FXMLModel)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(model);
        
        if (this.isRegistered(FXMLAction.Type.CONSUMERS, actionId)) {
            final Consumer<FXMLModel> consumer = MAP_CONSUMERS.get(actionId);
            consumer.accept(model);
        }
    }
    
    /**
     * 
     * @param   actionId
     * @param   entityId
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code entityId} is NULL.
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public Optional<FXMLModel> handleFunction(final String actionId, final Long entityId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleFunction(String, Long)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        Optional<FXMLModel> model = Optional.empty();
        if (this.isRegistered(FXMLAction.Type.FUNCTIONS, actionId)) {
            final Function<Long, FXMLModel> function = MAP_FUNCTIONS.get(actionId);
            model = Optional.ofNullable(function.apply(entityId));
        }
        
        return model;
    }
    
    /**
     * 
     * @param   actionId
     * @return 
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public Optional<List<FXMLModel>> handleSupplier(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleSupplier(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);

        Optional<List<FXMLModel>> models = Optional.empty();
        if (this.isRegistered(FXMLAction.Type.SUPPLIERS, actionId)) {
            final Supplier<List<FXMLModel>> supplier = MAP_SUPPLIERS.get(actionId);
            models = Optional.ofNullable(supplier.get());
        }
        
        return models;
    }
    
    /**
     * 
     * @param   type
     * @param   actionId
     * @return 
     * @throws  NullPointerException     if {@code type}     is NULL.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public boolean isRegistered(final FXMLAction.Type type, final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#isRegistered(FXMLAction.Type, String)"); // NOI18N

        DefaultFXMLValidator.requireNonNull(type);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        boolean isRegistered = false;
        switch(type) {
            case CONSUMERS:     { isRegistered = MAP_CONSUMERS.containsKey(    actionId); break; }
            case EVENTHANDLERS: { isRegistered = MAP_EVENTHANDLERS.containsKey(actionId); break; }
            case FUNCTIONS:     { isRegistered = MAP_FUNCTIONS.containsKey(    actionId); break; }
            case SUPPLIERS:     { isRegistered = MAP_SUPPLIERS.containsKey(    actionId); break; }
        }
        
        return isRegistered;
    }
    
    /**
     * 
     * @param   actionId
     * @param   consumer
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code consumer} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void register(final String actionId, final Consumer<FXMLModel> consumer) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Consumer<FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        MAP_CONSUMERS.put(actionId, consumer);
    }
    
    /**
     * 
     * @param   actionId
     * @param   eventHandler
     * @throws  NullPointerException     if {@code actionId}     is NULL.
     * @throws  IllegalArgumentException if {@code actionId}     is EMPTY.
     * @throws  NullPointerException     if {@code eventHandler} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void register(final String actionId, final EventHandler<ActionEvent> eventHandler) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, EventHandler<ActionEvent>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(eventHandler);
        
        MAP_EVENTHANDLERS.put(actionId, eventHandler);
    }

    /**
     * 
     * @param   actionId
     * @param   function
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code function} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void register(final String actionId, final Function<Long, FXMLModel> function) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Function<Long, FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(function);
        
        MAP_FUNCTIONS.put(actionId, function);
    }

    /**
     * 
     * @param   actionId
     * @param   supplier
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code supplier} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void register(final String actionId, final Supplier<List<FXMLModel>> supplier) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Supplier<List<FXMLModel>>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(supplier);
        
        MAP_SUPPLIERS.put(actionId, supplier);
    }
    
    /**
     * 
     * @param   type 
     * @param   actionId 
     * @throws  NullPointerException     if {@code type}     is NULL.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void remove(final FXMLAction.Type type, final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#remove(FXMLAction.Type, String)"); // NOI18N

        DefaultFXMLValidator.requireNonNull(type);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        switch(type) {
            case CONSUMERS:     { MAP_CONSUMERS.entrySet().stream().filter(    c -> MAP_CONSUMERS.containsKey(actionId)    ).forEach(c -> MAP_CONSUMERS.remove(actionId));     break; }
            case EVENTHANDLERS: { MAP_EVENTHANDLERS.entrySet().stream().filter(e -> MAP_EVENTHANDLERS.containsKey(actionId)).forEach(e -> MAP_EVENTHANDLERS.remove(actionId)); break; }
            case FUNCTIONS:     { MAP_FUNCTIONS.entrySet().stream().filter(    f -> MAP_FUNCTIONS.containsKey(actionId)    ).forEach(f -> MAP_FUNCTIONS.remove(actionId));     break; }
            case SUPPLIERS:     { MAP_SUPPLIERS.entrySet().stream().filter(    s -> MAP_SUPPLIERS.containsKey(actionId)    ).forEach(s -> MAP_SUPPLIERS.remove(actionId));     break; }
        }
    }
    
    /**
     * 
     * @since   0.4.0
     * @version 0.4.0
     * @author  Naoghuman
     */
    public enum Type {
        
        /**
         * 
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         */
        CONSUMERS,
        
        /**
         * 
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         */
        EVENTHANDLERS,
        
        /**
         * 
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         */
        FUNCTIONS,
        
        /**
         * 
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         */
        SUPPLIERS;
        
    }
    
}
