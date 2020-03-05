package com.yotpo.sample.rest;

import com.yotpo.sample.api.MyService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class MyServiceRest {

    final MyService delegate;

    public MyServiceRest(MyService delegate) {
        this.delegate = delegate;
    }

    @Path("/")
    @Produces("application/json")
    @POST
    public String echo(String message) {
        return delegate.echo(message);
    }

}
