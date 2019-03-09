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

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import java.util.Optional;
import java.util.function.Consumer;
import javafx.event.ActionEvent;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLAction {
    
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
        
        ActionHandlerFacade.getDefault().handle(TransferDataBuilder.create()
                .actionId(actionId)
                .objectValue(model)
                .build());
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
        
        return ActionHandlerFacade.getDefault().isRegistered(actionId);
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
        
        ActionHandlerFacade.getDefault().register(
                actionId,
                (ActionEvent event) -> {
                    final TransferData     transferData = (TransferData) event.getSource();
                    final Optional<Object> optional     = transferData.getObject();
                    optional.ifPresent(object -> {
                        if (object instanceof FXMLModel) {
                            final FXMLModel model = (FXMLModel) object;
                            consumer.accept(model);
                        }
                    });
                });
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
        
        ActionHandlerFacade.getDefault().remove(actionId);
    }
    
}
