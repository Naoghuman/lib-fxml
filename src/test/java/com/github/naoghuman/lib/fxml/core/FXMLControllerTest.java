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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * UnitTests to test the validator {@link com.github.naoghuman.lib.fxml.core.FXMLController}.
 *
 * @since   0.4.0
 * @version 0.4.0
 * @author  Naoghuman
 * @see     com.github.naoghuman.lib.fxml.core.FXMLController
 */
public class FXMLControllerTest {
    
    public FXMLControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConfigure_0args() {
        FXMLController instance = new FXMLControllerImpl();
        assertTrue(instance.getModels().isEmpty());
        
        instance.configure();
        assertTrue(instance.getModels().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testConfigure_FXMLModel__FXMLModel_throw_NullPointerException() {
        FXMLModel model = null;
        FXMLController instance = new FXMLControllerImpl();
        
        instance.configure(model);
    }

    @Test
    public void testConfigure_FXMLModel() {
        FXMLModel model = new FXMLModel();
        FXMLController instance = new FXMLControllerImpl();
        instance.configure(model);
        
        assertTrue(!instance.getModels().isEmpty());
        assertTrue(instance.getModels().size() == 1);
    }

    @Test(expected = NullPointerException.class)
    public void testConfigure_List__List_throw_NullPointerException() {
        List<FXMLModel> models = null;
        FXMLController instance = new FXMLControllerImpl();
        
        instance.configure(models);
    }

    @Test
    public void testConfigure_List() {
        List<FXMLModel> models = new ArrayList<>();
        FXMLController instance = new FXMLControllerImpl();
        instance.configure(models);
        
        assertTrue(instance.getModels().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testGetModel__String_throw_NullPointerException() {
        FXMLController instance = new FXMLControllerImpl();
        instance.getModel(null, 12321L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetModel__String_throw_IllegalArgumentException() {
        FXMLController instance = new FXMLControllerImpl();
        instance.getModel("", 12321L);
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetModel__Long_throw_NullPointerException() {
        FXMLController instance = new FXMLControllerImpl();
        instance.getModel(String.class.getName(), null);
    }

    @Test
    public void testGetModel() {
        FXMLController instance = new FXMLControllerImpl();
        FXMLModel model = new FXMLModel();
        model.setEntity(String.class.getName(), 12321L);
        instance.configure(model);
        
        Optional<FXMLModel> result = instance.getModel(String.class.getName(), 12321L);
        assertTrue(result.isPresent());
        
        FXMLModel model2 = new FXMLModel();
        model2.setEntity(String.class.getName(), 12321L);
        assertTrue(result.get().equals(model2));
    }

    @Test
    public void testGetModels() {
        FXMLController instance = new FXMLControllerImpl();
        assertTrue(instance.getModels().isEmpty());
        
        instance.configure(new FXMLModel());
        assertTrue(instance.getModels().size() == 1);
        
        List<FXMLModel> list = new ArrayList<>();
        list.add(new FXMLModel());
        list.add(new FXMLModel());
        list.add(new FXMLModel());
        instance.configure(list);
        assertTrue(instance.getModels().size() == 3);
    }

    @Test
    public void testGetView() {
        FXMLController instance = new FXMLControllerImpl();
        assertTrue(!instance.getView().isPresent());
    }

    public class FXMLControllerImpl extends FXMLController {

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            
        }
    }
    
}
