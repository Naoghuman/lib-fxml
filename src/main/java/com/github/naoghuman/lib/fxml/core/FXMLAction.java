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
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLAction {
    
    private final static HashMap<String, Consumer<FXMLModel>>       consumers = new HashMap();
    private final static HashMap<String, Function<Long, FXMLModel>> functions = new HashMap();
    
    private final static String ERROR_MSG__ACTION_ID_ISNT_REGISTERED = "The [actionId=%s] isn't registerd!"; // NOI18N
    /**
     * 
     * @param   actionId
     * @param   entityId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static FXMLModel handle(final String actionId, final Long entityId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        if (!FXMLAction.isRegistered(actionId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__ACTION_ID_ISNT_REGISTERED, actionId));
        }
        
        final Function<Long, FXMLModel> function = functions.get(actionId);
        
        return function.apply(entityId);
    }
    
    /**
     * 
     * @param   actionId
     * @param   model 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void handle(final String actionId, final FXMLModel model) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(model);
        
        if (!FXMLAction.isRegistered(actionId)) {
            throw new IllegalArgumentException(String.format(ERROR_MSG__ACTION_ID_ISNT_REGISTERED, actionId));
        }
        
        final Consumer<FXMLModel> consumer = consumers.get(actionId);
        consumer.accept(model);
    }
    
    /**
     * 
     * @param   actionId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static boolean isRegistered(final String actionId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        return consumers.containsKey(actionId)
                || functions.containsKey(actionId);
    }

    /**
     * 
     * @param   actionId
     * @param   function
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void register(final String actionId, final Function<Long, FXMLModel> function) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(function);
        
        functions.put(actionId, function);
    }
    
    /**
     * 
     * @param   actionId
     * @param   consumer
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void register(final String actionId, final Consumer<FXMLModel> consumer) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        consumers.put(actionId, consumer);
    }
    
    /**
     * 
     * @param   actionId 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void remove(final String actionId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(actionId);
        
        if (consumers.containsKey(actionId)) {
            consumers.remove(actionId);
        }
        
        if (functions.containsKey(actionId)) {
            functions.remove(actionId);
        }
    }
    
}
