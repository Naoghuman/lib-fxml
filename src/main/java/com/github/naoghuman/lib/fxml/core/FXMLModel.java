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
 * source-code changes
 * 
 * @since   0.1.0-PRERELEASE
 * @version 0.4.0
 * @author  Naoghuman
 */
public final class FXMLModel implements Comparable<FXMLModel> {
    
    private final HashMap<String, Object> data = new HashMap<>();
    
    private String entityName = "<not-defined>"; // NOI18N
    private Long   entityId   = -1L;
    
    /**
     * 
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void clearData() {
        data.clear();
    }
    
    /**
     * 
     * @param   <T>
     * @param   dataType
     * @param   key
     * @return 
     * @throws  NullPointerException     if {@code dataType} is NULL.
     * @throws  NullPointerException     if {@code key} is NULL.
     * @throws  IllegalArgumentException if {@code key} is EMPTY.
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public <T> Optional<T> getData(final Class<T> dataType, final String key) {
        DefaultFXMLValidator.requireNonNull(dataType);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        
        T value = null;
        try {
            value = dataType.cast(data.get(key));
        } catch (Exception ex) {
            LoggerFacade.getDefault().warn(this.getClass(), 
                    String.format(
                            "Can't cast the 'value' from 'key=%s' to 'Optional<T>=%s'. Return Optional.empty().", // NOI18N
                            key, dataType.getName()), 
                    ex);
        }
        
        return Optional.ofNullable(value);
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public HashMap<String, Object> getData() {
        return data;
    }
    
    /**
     * 
     * @return  the {@code name} from the defined {@code entity}.
     * @throws  NullPointerException     if {@code entityName} is NULL.
     * @throws  IllegalArgumentException if {@code entityName} is EMPTY.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public String getEntityName() {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(entityName);
        
        return entityName;
    }
    
    /**
     * 
     * @return  the {@code id} from the defined {@code entity}.
     * @throws  NullPointerException if {@code entityId} is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public Long getEntityId() {
        DefaultFXMLValidator.requireNonNull(entityId);
        
        return entityId;
    }
    
    /**
     * 
     * @return  {@code TRUE} if no data exists otherwise {@code FALSE}.
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public boolean isDataEmpty() {
        return data.isEmpty();
    }
    
    /**
     * 
     * @param   key
     * @param   value 
     * @throws  NullPointerException     if {@code key}   is NULL.
     * @throws  IllegalArgumentException if {@code key}   is EMPTY.
     * @throws  NullPointerException     if {@code value} is NULL.
     * @since   0.1.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void putData(final String key, final Object value) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(value);
        
        data.put(key, value);
    }
    
    /**
     * 
     * @param   entityName the {@code name} from the defined {@code entity}.
     * @param   entityId   the {@code id} from the defined {@code entity}.
     * @throws  NullPointerException     if {@code entityName} is NULL.
     * @throws  IllegalArgumentException if {@code entityName} is EMPTY.
     * @throws  NullPointerException     if {@code entityId}   is NULL.
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0
     * @author  Naoghuman
     */
    public void setEntity(final String entityName, final Long entityId) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(entityName);
        DefaultFXMLValidator.requireNonNull(entityId);
        
        this.entityName = entityName;
        this.entityId   = entityId;
    }
    
    @Override
    public int compareTo(final FXMLModel other) {
        int compareTo = this.getEntityName().compareTo(other.getEntityName());
        if (compareTo == 0) {
            compareTo = this.getEntityId().compareTo(other.getEntityId());
        }
        
        return compareTo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        final FXMLModel other = (FXMLModel) obj;
        
        return this.getEntityName().equals(other.getEntityName())
                && Objects.equals(this.getEntityId(), other.getEntityId());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 23;
        result = prime * result + this.getEntityName().hashCode();
        result = prime * result + this.getEntityId().hashCode();
        
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLModel [\n"); // NOI18N
        
        sb.append("  entity [\n"); // NOI18N
        sb.append("    name = ").append(this.getEntityName()).append(",\n"); // NOI18N
        sb.append("    id   = ").append(this.getEntityId()).append("\n"); // NOI18N
        sb.append("  ],\n"); // NOI18N
        
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
            
            sb.append("    ");
            sb.append(String.format("%-" + maxLength + "s", key)); // NOI18N
            sb.append(" = ").append(value); // NOI18N
            
            ++counter;
            sb.append((counter < elements) ? ",\n" : "\n"); // NOI18N
        }
        
        sb.append("  ]\n"); // NOI18N
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
