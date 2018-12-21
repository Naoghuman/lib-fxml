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
package com.github.naoghuman.lib.fxml.internal;

import java.util.Objects;

/**
 * An implementation from different {@code validation} methods to check preconditions 
 * in the topic from this library {@code Lib-FXML}.
 * 
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 */
public class DefaultFXMLValidator {
    
    /**
     * Delegates to {@link java.util.Objects#isNull(java.lang.Object)}.
     * <p>
     * This method exists to be used as a {@link java.util.function.Predicate}, 
     * {@code filter(Objects::isNull)}.
     * 
     * @param   obj a reference which will be checked against {@code NULL}.
     * @return  {@code TRUE} if the provided reference is {@code NULL} otherwise {@code FALSE}.
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     * @see     java.util.function.Predicate
     */
    public static boolean isNull(final Object obj) {
        return Objects.isNull(obj);
    }
    
    /**
     * Delegates to {@link java.util.Objects#nonNull(java.lang.Object)}.
     * <p>
     * This method exists to be used as a {@link java.util.function.Predicate},
     * {@code filter(Objects::nonNull)}.
     * 
     * @param   obj a reference which will be checked against {@code NULL}.
     * @return  {@code TRUE} if the provided reference is {@code NON-NULL} otherwise {@code FALSE}.
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     * @see     java.util.function.Predicate
     */
    public static boolean nonNull(final Object obj) {
        return Objects.nonNull(obj);
    }
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL}.
     * <p>
     * An additional error message will be added to the error stack:
     * <ul>
     * <li>The attribute [value] can't be NULL.</li>
     * </ul>
     *
     * @param   <T>   the type of the reference.
     * @param   value the attribute which should be validated.
     * @throws  NullPointerException if {@code (value == NULL)}.
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public static <T> void requireNonNull(final T value) throws NullPointerException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL."); // NOI18N
    }
    
    /**
     * Validates if the attribute {@code value} isn't {@code NULL} and not {@code EMPTY}.
     * <p>
     * Adds following additional error messages depending from the error to the error stack:
     * <ul>
     * <li>The attribute [value] can't be NULL.</li>
     * <li>The attribute [value] can't be EMPTY.</li>
     * </ul>
     *
     * @param   value the attribute which should be validated.
     * @throws  IllegalArgumentException if {@code (value.trim() == EMPTY)}.
     * @throws  NullPointerException     if {@code (value        == NULL)}.
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void requireNonNullAndNotEmpty(final String value) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(value, "The attribute [value] can't be NULL."); // NOI18N
        
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("The attribute [value] can't be EMPTY."); // NOI18N
        }
    }
    
    /**
     * Checks if the {@code value} ends with the given {@code suffix}.
     * <p>
     * An additional error message will be added to the error stack:
     * <ul>
     * <li>"The attribute [value] must ends with the suffix: %s"</li>
     * </ul>
     * 
     * @param   value  the String which should be checked.
     * @param   suffix the suffix which must append at the end from the {@code value}.
     * @throws  IllegalArgumentException if {@code ((value.trim() || suffxi.trim() == EMPTY) || (!value.endsWith(suffix)))}.
     * @throws  NullPointerException     if {@code (value || suffix  == NULL)}.
     * @since   0.1.0-PRERELEASE
     * @version 0.1.0-PRERELEASE
     * @author  Naoghuman
     */
    public static void requireEndsWith(final String value, final String suffix) {
        DefaultFXMLValidator.requireNonNullAndNotEmpty(value);
        DefaultFXMLValidator.requireNonNullAndNotEmpty(suffix);
        
        if (!value.endsWith(suffix)) {
            throw new IllegalArgumentException(String.format(
                    "The attribute [value] must ends with the suffix: %s", suffix)); // NOI18N
        }
    }
    
}
