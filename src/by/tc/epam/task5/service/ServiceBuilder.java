/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.tc.epam.task5.service;

import java.util.HashMap;
import java.util.Map;

import by.tc.epam.task5.service.impl.DOMService;
import by.tc.epam.task5.service.impl.SAXService;
import by.tc.epam.task5.service.impl.StaXService;

public class ServiceBuilder {
    
    private static final ServiceBuilder instance = new ServiceBuilder();
    
    private final Map<String, ParserService> services = new HashMap<>();    

    private ServiceBuilder() {
        
        services.put("SAX", new SAXService());
        services.put("StaX", new StaXService());
        services.put("DOM", new DOMService());
       
    }
    
    public static ServiceBuilder getInstance(){
        return instance;
    }
    
    public ParserService getService(String serviceName){
        return services.get(serviceName);
    }
    
}
