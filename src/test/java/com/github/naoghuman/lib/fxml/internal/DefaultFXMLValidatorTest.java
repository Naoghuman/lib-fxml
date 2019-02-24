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
package com.github.naoghuman.lib.fxml.internal;

import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * UnitTests to test the validator {@link com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator}.
 *
 * @since   0.1.0-PRERELEASE
 * @version 0.1.0-PRERELEASE
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.fxml.internal.DefaultFXMLValidator
 */
public class DefaultFXMLValidatorTest {
    
    public DefaultFXMLValidatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void isNullTrue() {
        String hello = null;
        assertTrue(DefaultFXMLValidator.isNull(hello));
    }
    
    @Test
    public void isNullFalse() {
        String hello = "hello";
        assertFalse(DefaultFXMLValidator.isNull(hello));
    }
    
    @Test
    public void nonNullTrue() {
        String hello = "hello";
        assertTrue(DefaultFXMLValidator.nonNull(hello));
    }
    
    @Test
    public void nonNullFalse() {
        String hello = null;
        assertFalse(DefaultFXMLValidator.nonNull(hello));
    }
    
    @Test
    public void requireNonNull() {
        String hello = "hello";
        DefaultFXMLValidator.requireNonNull(hello);
    }
    
    @Test(expected = NullPointerException.class)
    public void requireNonNullThrowsNullPointerException() {
        String hello = null;
        DefaultFXMLValidator.requireNonNull(hello);
    }
    
    @Test
    public void requireNonNullAndNotEmptyString() {
        String hello = "hello";
        DefaultFXMLValidator.requireNonNullAndNotEmpty(hello);
    }
    
    @Test(expected = NullPointerException.class)
    public void requireNonNullAndNotEmptyStringThrowsNullPointerException() {
        String hello = null;
        DefaultFXMLValidator.requireNonNullAndNotEmpty(hello);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void requireNonNullAndNotEmptyStringThrowsIllegalArgumentException() {
        String hello = "";
        DefaultFXMLValidator.requireNonNullAndNotEmpty(hello);
    }
    
}
