/*
 * Copyright (C) 2019 Naoghuman's dream
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

import java.util.Objects;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * UnitTests to test the validator {@link com.github.naoghuman.lib.fxml.core.FXMLModel}.
 *
 * @since   0.4.0
 * @version 0.4.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.fxml.core.FXMLModel
 */
public class FXMLModelTest {
    
    public FXMLModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testClearData() {
        FXMLModel instance = new FXMLModel();
        instance.putData("id", 12345L);
        
        assertTrue(instance.getData().size() == 1);
        
        instance.clearData();
        
        assertTrue(instance.getData().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testGetData_Class_String__Class_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.getData(null, "id");
    }

    @Test(expected = NullPointerException.class)
    public void testGetData_Class_String__String_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.getData(Long.class, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetData_Class_String__String_throw_IllegalArgumentException() {
        FXMLModel instance = new FXMLModel();
        
        instance.getData(Long.class, "");
    }

    @Test
    public void testGetData_Class_String() {
        FXMLModel instance = new FXMLModel();
        instance.putData("id", 123456L);
        
        assertTrue(instance.getData(Long.class, "id").isPresent());
        assertTrue(Objects.equals(instance.getData(Long.class, "id").get(), 123456L));
    }

    @Test
    public void testGetData_0args() {
        FXMLModel instance = new FXMLModel();
        instance.putData("id", 1234567L);
        
        assertTrue(instance.getData().size() == 1);
        assertTrue(Objects.equals((Long) instance.getData().get("id"), 1234567L));
    }

    @Test
    public void testGetEntityName() {
        FXMLModel instance = new FXMLModel();
        instance.setEntity(String.class.getName(), 234L);
        
        assertTrue(instance.getEntityName() != null);
        assertTrue(instance.getEntityName().equals("java.lang.String"));
    }

    @Test
    public void testGetEntityId() {
        FXMLModel instance = new FXMLModel();
        instance.setEntity(String.class.getName(), 234L);
        
        assertTrue(instance.getEntityId() != null);
        assertTrue(Objects.equals(instance.getEntityId(), 234L));
    }

    @Test
    public void testIsDataEmpty() {
        FXMLModel instance = new FXMLModel();
        
        assertTrue(instance.getData().isEmpty());
    }
    
    @Test(expected = NullPointerException.class)
    public void testPutData__String_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.putData(null, 23456L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutData__String_throw_IllegalArgumentException() {
        FXMLModel instance = new FXMLModel();
        
        instance.putData("", 23456L);
    }
    
    @Test(expected = NullPointerException.class)
    public void testPutData__Object_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.putData("id", null);
    }

    @Test
    public void testPutData() {
        FXMLModel instance = new FXMLModel();
        instance.putData("id", 23456L);
        
        assertTrue(instance.getData(Long.class, "id").isPresent());
        assertTrue(Objects.equals(instance.getData(Long.class, "id").get(), 23456L));
    }
    
    @Test(expected = NullPointerException.class)
    public void testSetEntity_String_Long__String_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.setEntity(null, 1234L);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSetEntity_String_Long__String_throw_IllegalArgumentException() {
        FXMLModel instance = new FXMLModel();
        
        instance.setEntity("", 1234L);
    }

    @Test(expected = NullPointerException.class)
    public void testSetEntity_String_Long__Long_throw_NullPointerException() {
        FXMLModel instance = new FXMLModel();
        
        instance.setEntity(String.class.getName(), null);
    }
    
    @Test
    public void testEquals_true() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(String.class.getName(), -12345L);
        
        assertTrue(model1.equals(model2));
        assertTrue(model2.equals(model1));
    }
    
    @Test
    public void testEquals_false_Name() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(Double.class.getName(), -12345L);
        
        assertTrue(!model1.equals(model2));
        assertTrue(!model2.equals(model1));
    }
    
    @Test
    public void testEquals_false_Id() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(String.class.getName(), -12345678L);
        
        assertTrue(!model1.equals(model2));
        assertTrue(!model2.equals(model1));
    }
    
    @Test
    public void testCompareTo_Equals() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(String.class.getName(), -12345L);
        
        assertTrue(model1.compareTo(model2) == 0);
        assertTrue(model2.compareTo(model1) == 0);
    }
    
    @Test
    public void testCompareTo_Not_Equals_Name() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(Double.class.getName(), -12345L);
        
        assertTrue(model1.compareTo(model2) != 0);
        assertTrue(model2.compareTo(model1) != 0);
    }
    
    @Test
    public void testCompareTo_Not_Equals_Id() {
        FXMLModel model1 = new FXMLModel();
        model1.setEntity(String.class.getName(), -12345L);
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(String.class.getName(), -1234234L);
        
        assertTrue(model1.compareTo(model2) != 0);
        assertTrue(model2.compareTo(model1) != 0);
    }
    
    // TODO add testToString
    
}
