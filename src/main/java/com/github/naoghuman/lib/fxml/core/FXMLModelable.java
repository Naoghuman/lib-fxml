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

import java.util.Optional;

/**
 *
 * @since   0.3.0-PRERELEASE
 * @version 0.3.0-PRERELEASE
 * @author  Naoghuman
 */
public interface FXMLModelable {
    
    /**
     * 
     * @param   model 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0-PRERELEASE
     * @author  Naoghuman
     */
    public default void readFrom(final FXMLModel model) {
        
    };
    
    /**
     * 
     * @param   key
     * @param   model 
     * @since   0.4.0-PRERELEASE
     * @version 0.4.0-PRERELEASE
     * @author  Naoghuman
     */
    public default void readFrom(final String key, final FXMLModel model) {
        
    };
    
    /**
     * 
     * @return 
     * @since   0.3.0-PRERELEASE
     * @version 0.4.0-PRERELEASE
     * @author  Naoghuman
     */
    public default Optional<FXMLModel> writeTo() {
        return Optional.empty();
    };
    
    /**
     * 
     * @param   key
     * @return 
     * @since   0.4.0-PRERELEASE
     * @version 0.4.0-PRERELEASE
     * @author  Naoghuman
     */
    public default Optional<FXMLModel> writeTo(final String key) {
        return Optional.empty();
    };
    
}
