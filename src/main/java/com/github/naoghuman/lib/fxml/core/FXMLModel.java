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
    
    private final HashMap<String, Object> model = new HashMap<>();
    
    private Optional<Long>  entityId = Optional.empty();
    private Optional<Class> entity   = Optional.empty();
    
    /**
     * 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void clear() {
        model.clear();
    }
    
    /**
     * 
     * @param entityId
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isSameEntityId(final Long entityId) {
        DefaultFXMLValidator.requireNonNull(entityId);
        
        if (!this.getEntityId().isPresent()) {
            return Boolean.FALSE;
        }
        
        return Objects.equals(this.getEntityId().get(), entityId);
    }
    
    /**
     * 
     * @param   type
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isSameEntityType(final Class type) {
        DefaultFXMLValidator.requireNonNull(type);
        
        if (!this.getEntity().isPresent()) {
            return Boolean.FALSE;
        }
        
        return getEntity().get().getName().equals(type.getName());
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
    public <T> Optional<T> get(final Class<T> type, final String key) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(type);
        
        Optional<T> value = Optional.empty();
        try {
            value = Optional.ofNullable(type.cast(model.get(key)));
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
    public HashMap<String, Object> getAll() {
        return model;
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
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isEmpty() {
        return model.isEmpty();
    }
    
    /**
     * 
     * @param   key
     * @param   value 
     * @since   0.1.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void put(final String key, final Object value) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(value);
        
        model.put(key, value);
    }
    
    /**
     * 
     * @param   entity 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void setEntity(final Class entity) {
        DefaultFXMLValidator.requireNonNull(entity);
        
        this.entity = Optional.of(entity);
    }
    
    /**
     * 
     * @param   entityId 
     * @since   0.3.0-PRERELEASE
     * @version 0.3.0-PRERELEASE
     * @author  Naoghuman
     */
    public void setEntityId(final Long entityId) {
        DefaultFXMLValidator.requireNonNull(entityId);
        
        this.entityId = Optional.of(entityId);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLModel [\n"); // NOI18N
        
        sb.append("  entity   = ").append((entity.isPresent())   ? entity.get().getName() : "<not-defined>").append(",\n"); // NOI18N
        sb.append("  entityId = ").append((entityId.isPresent()) ? entityId.get()         : "<not-defined>").append(",\n"); // NOI18N
        
        sb.append("  model [\n"); // NOI18N
        final Iterator<Map.Entry<String, Object>> iterator = model.entrySet().iterator();
        if (!iterator.hasNext()) {
            sb.append("    <not-defined>\n"); // NOI18N
        }
        
        int maxLength = 0;
        for(final String key : model.keySet()) {
            maxLength = Math.max(maxLength, key.length());
        }
        
        final int elements = model.size();
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
