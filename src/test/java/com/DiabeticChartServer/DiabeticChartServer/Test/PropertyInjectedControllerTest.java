package com.DiabeticChartServer.DiabeticChartServer.Test;

import org.junit.jupiter.api.Test;


public class PropertyInjectedControllerTest {
    private PropertyInjectedController propertyInjectedController;

    @Test
    public void testGreeting() throws Exception {
        this.propertyInjectedController = new PropertyInjectedController();
        this.propertyInjectedController.greetingService = new GreetingServiceImpl();
        String t = propertyInjectedController.sayHello();

       // assertEquals(GreetingServiceImpl.HELLO_GURUS, propertyInjectedController.sayHello());
    }
}
