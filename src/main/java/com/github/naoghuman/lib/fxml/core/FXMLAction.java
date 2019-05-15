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
 * The class {@code FXMLAction} let the developer register and handle {@code functionalities}
 * from different types.<br>
 * Momentary following types of functionality are supported:
 * <ul>
 * <li>{@code FXMLAction.Type.CONSUMERS     -> Consumer<FXMLModel>}</li>
 * <li>{@code FXMLAction.Type.EVENTHANDLERS -> EventHandler<ActionEvent>>}</li>
 * <li>{@code FXMLAction.Type.FUNCTIONS     -> Function<Long, FXMLModel>>}</li>
 * <li>{@code FXMLAction.Type.SUPPLIERS     -> Supplier<List<FXMLModel>>>}</li>
 * </ul>
 * For more informations about the supported types plz see the JavaDoc from the enum
 * {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type}.
 * <p>
 * Internal the functionalities will be stored in different {@link java.util.HashMap}s
 * depending from their type. This means that each key must be unique in the context of
 * the type. Otherwise, the last registered functionality will be overwritten by the new
 * functionality.
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.4.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type
 * @see     java.util.HashMap
 */
public final class FXMLAction {
    
    private final static HashMap<String, Consumer<FXMLModel>>       MAP_CONSUMERS     = new HashMap<>();
    private final static HashMap<String, EventHandler<ActionEvent>> MAP_EVENTHANDLERS = new HashMap<>();
    private final static HashMap<String, Function<Long, FXMLModel>> MAP_FUNCTIONS     = new HashMap<>();
    private final static HashMap<String, Supplier<List<FXMLModel>>> MAP_SUPPLIERS     = new HashMap<>();
    
    private static final Optional<FXMLAction> INSTANCE = Optional.of(new FXMLAction());
    
    /**
     * Create a singleton instance from the class {@code FXMLAction} if needed
     * and return it.
     *
     * @return  a singleton instance from this class.
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
     * Handles the functionality with the ID {@code actionId} in context from the registration
     * type {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type#EVENTHANDLERS}.
     *
     * @param   actionId the ID from the functionality which should be performed.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type#EVENTHANDLERS
     */
    public void handleAction(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        if (this.isRegistered(actionId, FXMLAction.Type.EVENTHANDLERS)) {
            this.handleAction(actionId, ActionEvent.NULL_SOURCE_TARGET);
        }
    }
    
    /**
     * Handles the functionality with the ID {@code actionId} in context from the registration
     * type {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type#EVENTHANDLERS}.
     *
     * Adds the object {@source} to the {@link javafx.event.ActionEvent} as event source.
     *
     * @param   actionId the ID from the functionality which should be performed.
     * @param   source   the event source object which sent the event.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code source}   is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type#EVENTHANDLERS
     * @see     javafx.event.ActionEvent
     */
    public void handleAction(final String actionId, final Object source) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleAction(String, Object)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(source);
        
        if (this.isRegistered(actionId, FXMLAction.Type.EVENTHANDLERS)) {
            final EventHandler<ActionEvent> eventHandler = MAP_EVENTHANDLERS.get(actionId);
            eventHandler.handle(new ActionEvent(source, ActionEvent.NULL_SOURCE_TARGET));
        }
    }
    
    /**
     * Handles the functionality with the ID {@code actionId} in context from the registration
     * type {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type#CONSUMERS}.
     *
     * @param   actionId the ID from the functionality which should be performed.
     * @param   model    the model which should be processed by the {@code Consumer}.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code model}    is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type#CONSUMERS
     * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
     */
    public void handleConsumer(final String actionId, final FXMLModel model) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleConsumer(String, FXMLModel)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(model);
        
        if (this.isRegistered(actionId, FXMLAction.Type.CONSUMERS)) {
            final Consumer<FXMLModel> consumer = MAP_CONSUMERS.get(actionId);
            consumer.accept(model);
        }
    }
    
    /**
     * Handles the functionality with the ID {@code actionId} in context from the registration
     * type {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type#FUNCTIONS}.
     *
     * @param   actionId the ID from the functionality which should be performed.
     * @param   entityId the ID from the entity which should be loaded by this {@code Function}.
     * @return  the loaded entity wrapped into a {@code FXMLModel} or {@code Optional#empty()}.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code entityId} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type#FUNCTIONS
     * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
     * @see     java.util.Optional#empty()
     * @see     java.util.function.Function
     */
    public Optional<FXMLModel> handleFunction(final String actionId, final Long entityId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleFunction(String, Long)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        Optional<FXMLModel> model = Optional.empty();
        if (this.isRegistered(actionId, FXMLAction.Type.FUNCTIONS)) {
            final Function<Long, FXMLModel> function = MAP_FUNCTIONS.get(actionId);
            model = Optional.ofNullable(function.apply(entityId));
        }
        
        return model;
    }
    
    /**
     * Handles the functionality with the ID {@code actionId} in context from the registration
     * type {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type#SUPPLIERS}.
     *
     * @param   actionId the ID from the functionality which should be performed.
     * @return  the loaded entities wrapped into a {@code FXMLModel} or {@code Optional#empty()}.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     java.util.Optional
     */
    public Optional<List<FXMLModel>> handleSupplier(final String actionId) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#handleSupplier(String)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);

        Optional<List<FXMLModel>> models = Optional.empty();
        if (this.isRegistered(actionId, FXMLAction.Type.SUPPLIERS)) {
            final Supplier<List<FXMLModel>> supplier = MAP_SUPPLIERS.get(actionId);
            models = Optional.ofNullable(supplier.get());
        }
        
        return models;
    }
    
    /**
     * Returns a boolean if the ID {@code actionId} is registered in context from the given {@code type}.
     * <p>
     * For more informations about the supported types plz see the JavaDoc from the enum
     * {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type}.
     *
     * @param   actionId the ID that is checked for its existence.
     * @param   type     The context within which is checked, whether the ID exists or not.
     * @return  {@code TRUE} if the function is registered is in context from the type, otherwise {@code FALSE}.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code type}     is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type
     */
    public boolean isRegistered(final String actionId, final FXMLAction.Type type) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#isRegistered(String, FXMLAction.Type)"); // NOI18N

        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(type);
        
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
     * Register a function from type {@code ConsumerFXMLModel>} with the ID {@code actionId}.<br>
     * Should previously a function registered with this {@code ID} then the new functionality
     * will be overwrite the old one.
     *
     * @param   actionId the ID which allowed the access of the stored functionality.
     * @param   consumer the functionality which should be stored.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code consumer} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     java.util.function.Consumer
     */
    public void register(final String actionId, final Consumer<FXMLModel> consumer) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Consumer<FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        MAP_CONSUMERS.put(actionId, consumer);
    }
    
    /**
     * Register a function from type {@code EventHandler<ActionEvent>} with the ID {@code actionId}.<br>
     * Should previously a function registered with this {@code ID} then the new functionality
     * will be overwrite the old one.
     *
     * @param   actionId     the ID which allowed the access of the stored functionality.
     * @param   eventHandler the functionality which should be stored.
     * @throws  NullPointerException     if {@code actionId}     is NULL.
     * @throws  IllegalArgumentException if {@code actionId}     is EMPTY.
     * @throws  NullPointerException     if {@code eventHandler} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     javafx.event.ActionEvent
     * @see     javafx.event.EventHandler
     */
    public void register(final String actionId, final EventHandler<ActionEvent> eventHandler) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, EventHandler<ActionEvent>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(eventHandler);
        
        MAP_EVENTHANDLERS.put(actionId, eventHandler);
    }

    /**
     * Register a function from type {@code Function<Long, FXMLModel>} with the ID {@code actionId}.<br>
     * Should previously a function registered with this {@code ID} then the new functionality
     * will be overwrite the old one.
     *
     * @param   actionId the ID which allowed the access of the stored functionality.
     * @param   function the functionality which should be stored.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code function} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     java.util.function.Function
     */
    public void register(final String actionId, final Function<Long, FXMLModel> function) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Function<Long, FXMLModel>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(function);
        
        MAP_FUNCTIONS.put(actionId, function);
    }

    /**
     * Register a function from type {@code Supplier<List<FXMLModel>>} with the ID {@code actionId}.<br>
     * Should previously a function registered with this {@code ID} then the new functionality
     * will be overwrite the old one.
     *
     * @param   actionId the ID which allowed the access of the stored functionality.
     * @param   supplier the functionality which should be stored.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code supplier} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     java.util.function.Supplier
     */
    public void register(final String actionId, final Supplier<List<FXMLModel>> supplier) {
        LoggerFacade.getDefault().info(FXMLAction.class, "FXMLAction#register(String, Supplier<List<FXMLModel>>)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(supplier);
        
        MAP_SUPPLIERS.put(actionId, supplier);
    }
    
    /**
     * Removes the functionality with the ID {@code actionId} in context from the
     * spezified {@code type} where type must be one value from the enum
     * {@link com.github.naoghuman.lib.fxml.core.FXMLAction.Type}:
     * <ul>
     *<li>FXMLAction.Type#CONSUMERS</li>
     *<li>FXMLAction.Type#EVENTHANDLERS</li>
     *<li>FXMLAction.Type#FUNCTIONS</li>
     *<li>FXMLAction.Type#SUPPLIERS</li>
     * </ul>
     *
     * @param   actionId the ID from the functionality which should be removed.
     * @param   type     the context from which the functionality should be removed.
     * @throws  NullPointerException     if {@code actionId} is NULL.
     * @throws  IllegalArgumentException if {@code actionId} is EMPTY.
     * @throws  NullPointerException     if {@code type}     is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     * @see     com.github.naoghuman.lib.fxml.core.FXMLAction.Type
     */
    public void remove(final String actionId, final FXMLAction.Type type) {
        LoggerFacade.getDefault().debug(FXMLAction.class, "FXMLAction#remove(String, FXMLAction.Type)"); // NOI18N

        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(type);
        
        switch(type) {
            case CONSUMERS:     { MAP_CONSUMERS.entrySet().stream().filter(    c -> MAP_CONSUMERS.containsKey(actionId)    ).forEach(c -> MAP_CONSUMERS.remove(actionId));     break; }
            case EVENTHANDLERS: { MAP_EVENTHANDLERS.entrySet().stream().filter(e -> MAP_EVENTHANDLERS.containsKey(actionId)).forEach(e -> MAP_EVENTHANDLERS.remove(actionId)); break; }
            case FUNCTIONS:     { MAP_FUNCTIONS.entrySet().stream().filter(    f -> MAP_FUNCTIONS.containsKey(actionId)    ).forEach(f -> MAP_FUNCTIONS.remove(actionId));     break; }
            case SUPPLIERS:     { MAP_SUPPLIERS.entrySet().stream().filter(    s -> MAP_SUPPLIERS.containsKey(actionId)    ).forEach(s -> MAP_SUPPLIERS.remove(actionId));     break; }
        }
    }
    
    /**
     * Defines different event types which are supported from {@code FXMLAction}.
     *
     * @since   0.4.0
     * @version 0.4.0
     * @author  Naoghuman
     */
    public enum Type {
        
        /**
         * Defines the constant {@code CONSUMERS}.<br>
         * This {@code type} allowed to register and handle functionalities from type {@code Consumer<FXMLModel>}.
         *
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
         * @see     java.util.function.Consumer
         */
        CONSUMERS,
        
        /**
         * Defines the constant {@code EVENTHANDLERS}.<br>
         * This {@code type} allowed to register and handle functionalities from type {@code EventHandler<ActionEvent>}.
         *
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
         * @see     javafx.event.ActionEvent
         * @see     javafx.event.EventHandler
         */
        EVENTHANDLERS,
        
        /**
         * Defines the constant {@code FUNCTIONS}.<br>
         * This {@code type} allowed to register and handle functionalities from type {@code Function<Long, FXMLModel>}.
         *
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
         * @see     java.util.function.Function
         */
        FUNCTIONS,
        
        /**
         * Defines the constant {@code SUPPLIERS}.<br>
         * This {@code type} allowed to register and handle functionalities from type {@code Supplier<List<FXMLModel>>}.
         *
         * @since   0.4.0
         * @version 0.4.0
         * @author  Naoghuman
         * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
         * @see     java.util.function.Supplier
         */
        SUPPLIERS;
        
    }
    
}