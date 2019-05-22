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

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author PRo
 */
public class FXMLActionTest {
    
    boolean booleanForActionEvent = false;
    boolean booleanForConsumer    = false;
    boolean booleanForFunction    = false;
    boolean booleanForSupplier    = false;
    
    public FXMLActionTest() {
    }
    
    @Before
    public void setUp() {
        booleanForActionEvent = false;
        booleanForConsumer    = false;
        booleanForFunction    = false;
        booleanForSupplier    = false;
    }
    
    @After
    public void tearDown() {
        booleanForActionEvent = false;
        booleanForConsumer    = false;
        booleanForFunction    = false;
        booleanForSupplier    = false;
    }

    @Test
    public void testGetDefault() {
        FXMLAction instance = FXMLAction.getDefault();
        assertNotNull(instance);
    }

    @Test
    public void testHandleAction_String() {
        FXMLAction instance = FXMLAction.getDefault();
        String     actionId = "action-id-actionevent";
        instance.register(actionId, this::testActionEvent);
        
        assertFalse(booleanForActionEvent);
        instance.handleAction(actionId);
        assertTrue(booleanForActionEvent);
    }

    @Test
    public void testHandleAction_String_Object() {
        FXMLAction instance = FXMLAction.getDefault();
        String     actionId = "action-id-actionevent";
        instance.register(actionId, this::testActionEvent);
        
        assertFalse(booleanForActionEvent);
        instance.handleAction(actionId, "hello test");
        assertTrue(booleanForActionEvent);
    }

    @Test
    public void testHandleConsumer() {
        FXMLAction instance = FXMLAction.getDefault();
        String     actionId = "action-id-consumer";
        instance.register(actionId, this::testConsumer);
        
        assertFalse(booleanForConsumer);
        instance.handleConsumer(actionId, new FXMLModel());
        assertTrue(booleanForConsumer);
    }

    @Test
    public void testHandleFunction() {
        FXMLAction instance = FXMLAction.getDefault();
        String     actionId = "action-id-function";
        instance.register(actionId, this::testFunction);
        
        assertFalse(booleanForFunction);
        instance.handleFunction(actionId, 1234L);
        assertTrue(booleanForFunction);
    }

    @Test
    public void testHandleSupplier() {
        FXMLAction instance = FXMLAction.getDefault();
        String     actionId = "action-id-supplier";
        instance.register(actionId, this::testSupplier);
        
        assertFalse(booleanForSupplier);
        instance.handleSupplier(actionId);
        assertTrue(booleanForSupplier);
    }

    @Test
    public void testIsRegistered() {
        String          actionId = "action-id-eventhandler";
        FXMLAction.Type type     = FXMLAction.Type.EVENTHANDLERS;
        FXMLAction      instance = FXMLAction.getDefault();
        instance.register(actionId, (ActionEvent event) -> { });
        
        boolean result = instance.isRegistered(actionId, type);
        assertTrue(result);
    }

    @Test
    public void testRegister_String_Consumer() {
        String actionIdNotRegistered = "action-id-consumer-not-registerd";
        FXMLAction.Type type         = FXMLAction.Type.CONSUMERS;
        FXMLAction      instance     = FXMLAction.getDefault();

        boolean result = instance.isRegistered(actionIdNotRegistered, type);
        assertFalse(result);
        
        
        String actionId = "action-id-consumer";
        instance.register(actionId, this::testConsumer);
        
        result = instance.isRegistered(actionId, type);
        assertTrue(result);
    }

    @Test
    public void testRegister_String_EventHandler() {
        String actionIdNotRegistered = "action-id-eventhandler-not-registerd";
        FXMLAction.Type type         = FXMLAction.Type.EVENTHANDLERS;
        FXMLAction      instance     = FXMLAction.getDefault();

        boolean result = instance.isRegistered(actionIdNotRegistered, type);
        assertFalse(result);
        
        
        String actionId = "action-id-eventhandler";
        instance.register(actionId, this::testActionEvent);
        
        result = instance.isRegistered(actionId, type);
        assertTrue(result);
    }

    @Test
    public void testRegister_String_Function() {
        String actionIdNotRegistered = "action-id-function-not-registerd";
        FXMLAction.Type type         = FXMLAction.Type.FUNCTIONS;
        FXMLAction      instance     = FXMLAction.getDefault();

        boolean result = instance.isRegistered(actionIdNotRegistered, type);
        assertFalse(result);
        
        
        String actionId = "action-id-function";
        instance.register(actionId, this::testFunction);
        
        result = instance.isRegistered(actionId, type);
        assertTrue(result);
    }

    @Test
    public void testRegister_String_Supplier() {
        String actionIdNotRegistered = "action-id-supplier-not-registerd";
        FXMLAction.Type type         = FXMLAction.Type.SUPPLIERS;
        FXMLAction      instance     = FXMLAction.getDefault();

        boolean result = instance.isRegistered(actionIdNotRegistered, type);
        assertFalse(result);
        
        
        String actionId = "action-id-supplier";
        instance.register(actionId, this::testSupplier);
        
        result = instance.isRegistered(actionId, type);
        assertTrue(result);
    }

    @Test
    public void testRemove() {
        FXMLAction.Type type     = FXMLAction.Type.SUPPLIERS;
        FXMLAction      instance = FXMLAction.getDefault();

        String actionId = "action-id-supplier";
        instance.register(actionId, this::testSupplier);
        
        boolean result = instance.isRegistered(actionId, type);
        assertTrue(result);
        
        instance.remove(actionId, type);
        result = instance.isRegistered(actionId, type);
        assertFalse("should be false", result);
    }
    
    public void testActionEvent(ActionEvent event) {
        booleanForActionEvent = true;
    }
    
    public void testConsumer(FXMLModel model) {
        booleanForConsumer = true;
    }
    
    public FXMLModel testFunction(Long id) {
        booleanForFunction = true;
        
        return new FXMLModel();
    }
    
    public List<FXMLModel> testSupplier() {
        booleanForSupplier = true;
        
        return new ArrayList<>();
    }
    
}
