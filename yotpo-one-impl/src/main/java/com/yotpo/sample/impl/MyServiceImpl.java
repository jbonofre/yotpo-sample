package com.yotpo.sample.impl;

import com.yotpo.sample.api.MyService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class MyServiceImpl implements MyService {

    @Activate
    public void activate() {
        System.out.println("Activated");
    }

    @Deactivate
    public void deactivate() {
        System.out.println("Deactivated");
    }

    @Override
    public String echo(String message) {
        return message;
    }

}
