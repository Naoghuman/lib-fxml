/*
 * Copyright (C) 2018 Naoghuman's dream
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

/**
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 */
public final class FXMLModel {
    
    private final HashMap<String, Object> data = new HashMap<>();
    
    /**
     * 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public void clear() {
        data.clear();
    }
    
    /**
     * 
     * @param   <T>
     * @param   key
     * @param   type
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public <T> T get(final String key, final Class<T> type) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(type);
        
        T value = null;
        try {
            value = type.cast(data.get(key));
        } catch (Exception ex) {
            LoggerFacade.getDefault().error(this.getClass(), 
                    String.format(
                            "Can't cast the 'value' from 'key=%s' to 'Class<T>=%s'.",
                            key, type.getName()), 
                    ex);
        }
        
        return value;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public HashMap<String, Object> getAll() {
        return data;
    }
    
    /**
     * 
     * @return 
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    /**
     * 
     * @param   key
     * @param   value 
     * @since   0.1.0-PRERELEASE
     * @version 0.2.0-PRERELEASE
     * @author  Naoghuman
     */
    public void put(final String key, final Object value) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(key);
        DefaultFXMLValidator.requireNonNull(value);
        
        data.put(key, value);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FXMLModel [").append("\n"); // NOI18N
        
        sb.append("  data: ").append(data.toString()).append("\n"); // NOI18N
        
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
