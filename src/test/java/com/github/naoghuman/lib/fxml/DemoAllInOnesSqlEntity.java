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
package com.github.naoghuman.lib.fxml;

import com.github.naoghuman.lib.fxml.core.FXMLAction;
import com.github.naoghuman.lib.fxml.core.FXMLModel;
import com.github.naoghuman.lib.fxml.core.FXMLRegisterable;
import com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public final class DemoAllInOnesSqlEntity implements FXMLRegisterable {
    
    /**
     *
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final Long DEFAULT_ID = -1L;
    
    /**
     *
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__ENTITY__LOAD = "ON_ACTION__ENTITY__LOAD"; // NOI18N
    
    /**
     *
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final String ON_ACTION__ENTITY__SAVE = "ON_ACTION__ENTITY__SAVE"; // NOI18N
    
    private static Optional<DemoAllInOnesSqlEntity> instance = Optional.empty();
    
    public static DemoAllInOnesSqlEntity getDefault() {
        if (!instance.isPresent()) {
            instance = Optional.of(new DemoAllInOnesSqlEntity());
        }
        
        return instance.get();
    }
    
    private DemoAllInOnesSqlEntity() {
        
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesSqlEntity#register()"); // NOI18N
    
        this.registerOnActionEntityLoad();
        this.registerOnActionEntitySave();
    }
    
    public FXMLModel onActionEntityLoad(final Long entityId) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntity#onActionEntityALoad(Long): FXMLModel"); // NOI18N
        
        DefaultFXMLValidator.requireNonNull(entityId);
        
        final DemoAllInOnesEntity entity = new DemoAllInOnesEntity();
        entity.idProperty().set(entityId);
        
        if (!Objects.equals(entityId, DEFAULT_ID)) {
            entity.titleProperty().set(String.format("Load Id#%s from DB!", entityId)); // NOI18N
        }
        else {
            entity.titleProperty().set(String.format("Create new FXMLModel Id#%s!", entityId)); // NOI18N
        }
        
        return entity.writeTo();
    }
    
    public void onActionEntitySave(final FXMLModel model) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntity#onActionEntitySave(FXMLModel)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNull(model);
        
        System.out.println(model.toString());
    }

    private void registerOnActionEntityLoad() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntity#registerOnActionEntityLoad()"); // NOI18N
        
        FXMLAction.register(ON_ACTION__ENTITY__LOAD, this::onActionEntityLoad);
    }

    private void registerOnActionEntitySave() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntity#registerOnActionEntitySave()"); // NOI18N
        
        FXMLAction.register(ON_ACTION__ENTITY__SAVE, this::onActionEntitySave);
    }
    
}
