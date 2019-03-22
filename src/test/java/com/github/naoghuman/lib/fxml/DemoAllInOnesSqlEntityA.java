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

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
final class DemoAllInOnesSqlEntityA implements FXMLRegisterable {
    
    DemoAllInOnesSqlEntityA() {
        
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "DemoAllInOnesSqlEntityA#register()"); // NOI18N
    
        this.registerOnActionEntityALoad();
        this.registerOnActionEntityASave();
    }
    
    public FXMLModel onActionEntityALoad(final Long entityId) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntityA#onActionEntityALoad(Long): FXMLModel"); // NOI18N
        
        DefaultFXMLValidator.requireNonNull(entityId);
        
        final DemoAllInOnesEntityA entity = new DemoAllInOnesEntityA();
        entity.idProperty().set(entityId);
        
        if (!Objects.equals(entityId, DemoAllInOnesSqlProvider.DEFAULT_ID)) {
            entity.titleProperty().set(String.format("Load FXMLModel with Id#%s from DB!", entityId)); // NOI18N
        }
        else {
            entity.titleProperty().set(String.format("Create new FXMLModel with Id#%s!", entityId)); // NOI18N
        }
        
        return entity.writeTo();
    }
    
    public void onActionEntityASave(final FXMLModel model) {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntityA#onActionEntityASave(FXMLModel)"); // NOI18N
        
        DefaultFXMLValidator.requireNonNull(model);
        
        System.out.println(model.toString());
    }

    private void registerOnActionEntityALoad() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntityA#registerOnActionEntityALoad()"); // NOI18N
        
        FXMLAction.register(DemoAllInOnesSqlProvider.ON_ACTION__ENTITY_A__LOAD, this::onActionEntityALoad);
    }

    private void registerOnActionEntityASave() {
        LoggerFacade.getDefault().debug(this.getClass(), "DemoAllInOnesSqlEntityA#registerOnActionEntityASave()"); // NOI18N
        
        FXMLAction.register(DemoAllInOnesSqlProvider.ON_ACTION__ENTITY_A__SAVE, this::onActionEntityASave);
    }
    
}
