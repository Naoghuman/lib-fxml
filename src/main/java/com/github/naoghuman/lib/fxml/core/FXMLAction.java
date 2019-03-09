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
     * @param   identifier
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static boolean isRegistered(final String identifier) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(identifier);
        
        return ActionHandlerFacade.getDefault().isRegistered(identifier);
    }
    
    /**
     * 
     * @param   identifier
     * @param   consumer
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void register(final String identifier, final Consumer<FXMLModel> consumer) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(identifier);
        DefaultFXMLValidator.requireNonNull(consumer);
        
        ActionHandlerFacade.getDefault().register(
                identifier,
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
     * @param   identifier 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void remove(final String identifier) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(identifier);
        
        ActionHandlerFacade.getDefault().remove(identifier);
    }
    
}
