package com.sandyspring.controller

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response

/**
 * Created by sande on 7/1/2017.
 */
@Controller
@Path("/testRest")
@Slf4j
class SampleController {
    int i =0

    @Value('${sample.value}')
   String testSampleProp;

    @GET
    @Path("/sampleRest")
    public Response sayHi(@QueryParam("name") String name){
        log.info "Hello "+name
        //return Response.ok().entity("Hello "+name).build()
        return Response.ok().entity("Hello "+name+" Prop From File : "+testSampleProp).build()
    }
}
