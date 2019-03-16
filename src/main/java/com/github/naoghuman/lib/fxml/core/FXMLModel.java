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
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLModel {
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final Long DEFAULT_ENTITY_ID = -1L;
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public static final FXMLModel EMPTY = new FXMLModel();
    
    private final HashMap<String, Object> data = new HashMap<>();
    
    private Optional<Class>  entity    = Optional.empty();
    private Optional<Long>   entityId  = Optional.empty();
    private Optional<String> modelType = Optional.empty();
    
    /**
     * 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void clearAll() {
        entity    = Optional.empty();
        entityId  = Optional.empty();
        modelType = Optional.empty();
    
        data.clear();
    }
    
    /**
     * 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void clearData() {
        data.clear();
    }
    
    /**
     * 
     * @param entity
     * @param entityId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isSameEntity(final Class entity, final Long entityId) {
        DefaultFXMLValidator.requireNonNull(entity);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        if (
                this.entity.isPresent()
                && this.entityId.isPresent()
        ) {
            return this.entity.get().getName().equals(entity.getName())
                    && Objects.equals(this.getEntityId().get(), entityId);
        }
        
        return Boolean.FALSE;
    }
    
    /**
     * 
     * @param   entity
     * @param   entityId
     * @param   modelType
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isSameEntity(final Class entity, final Long entityId, final String modelType) {
        DefaultFXMLValidator.requireNonNull(entity);
        DefaultFXMLValidator.requireNonNull(entityId);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(modelType);
        
        if (
                this.entity.isPresent()
                && this.entityId.isPresent()
                && this.modelType.isPresent()
        ) {
            return this.entity.get().getName().equals(entity.getName())
                    && Objects.equals(this.getEntityId().get(), entityId)
                    && this.modelType.get().equals(modelType);
        }
        
        return Boolean.FALSE;
    }
    
    /**
     * 
     * @param   <T>
     * @param   type
     * @param   key
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public <T> Optional<T> getData(final Class<T> type, final String key) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(type);
        
        Optional<T> value = Optional.empty();
        try {
            value = Optional.ofNullable(type.cast(data.get(key)));
        } catch (Exception ex) {
            LoggerFacade.getDefault().warn(this.getClass(), 
                    String.format(
                            "Can't cast the 'value' from 'key=%s' to 'Optional<T>=%s'. Return Optional.empty().", // NOI18N
                            key, type.getName()), 
                    ex);
        }
        
        return value;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public HashMap<String, Object> getAllData() {
        return data;
    }
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<Class> getEntity() {
        return entity;
    }
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<Long> getEntityId() {
        return entityId;
    }
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public Optional<String> getModelType() {
        return modelType;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isDataEmpty() {
        return data.isEmpty();
    }
    
    /**
     * 
     * @param   key
     * @param   value 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void putData(final String key, final Object value) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(value);
        
        data.put(key, value);
    }
    
    /**
     * 
     * @param   entity 
     * @param   entityId 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void setEntity(final Class entity, final Long entityId) {
        DefaultFXMLValidator.requireNonNull(entity);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        this.entity   = Optional.of(entity);
        this.entityId = Optional.of(entityId);
    }
    
    /**
     * 
     * @param   entity 
     * @param   entityId 
     * @param   modelType 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void setEntity(final Class entity, final Long entityId, final String modelType) {
        DefaultFXMLValidator.requireNonNull(entity);
        DefaultFXMLValidator.requireNonNull(entityId);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(modelType);
        
        this.entity    = Optional.of(entity);
        this.entityId  = Optional.of(entityId);
        this.modelType = Optional.of(modelType);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLModel [\n"); // NOI18N
        
        sb.append("  entity    = ").append((entity.isPresent())    ? entity.get().getName() : "<not-defined>").append(",\n"); // NOI18N
        sb.append("  entityId  = ").append((entityId.isPresent())  ? entityId.get()         : "<not-defined>").append(",\n"); // NOI18N
        sb.append("  modelType = ").append((modelType.isPresent()) ? modelType.get()        : "<not-defined>").append(",\n"); // NOI18N
        
        sb.append("  data [\n"); // NOI18N
        final Iterator<Map.Entry<String, Object>> iterator = data.entrySet().iterator();
        if (!iterator.hasNext()) {
            sb.append("    <not-defined>\n"); // NOI18N
        }
        
        int maxLength = 0;
        for(final String key : data.keySet()) {
            maxLength = Math.max(maxLength, key.length());
        }
        
        final int elements = data.size();
        int counter = 0;
        while (iterator.hasNext()) {
            final Map.Entry<String, Object> next = iterator.next();
            final String key = next.getKey();
            final Object value = next.getValue();
            
            sb.append("    ").append(String.format("%-" + maxLength + "s", key)); // NOI18N
            sb.append(" = ").append(value); // NOI18N
            
            ++counter;
            sb.append((counter < elements) ? ",\n" : "\n"); // NOI18N
        }
        
        sb.append("  ]\n"); // NOI18N
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
