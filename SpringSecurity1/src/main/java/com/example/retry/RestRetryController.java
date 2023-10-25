package com.example.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Use these urls to test
//http://localhost:8091/retry?simulateretry=true&simulateretryfallback=false
//http://localhost:8091/retry?simulateretry=true&simulateretryfallback=true

/*Create one Spring boot project to expose once sample Rest API which will call one backend operation which is prone to failure,
 We will simulate this failure conditions to initiate the retry.
 One service class which will actually invoke the remote api and this will send exception in case of failure,
 we will design the retry based on this custom exception, like once we receive this exception, we will retry for 3 times and finally return to client.
 In those 3 attempts, if we get success response from backend service then that success response will be returned else a standard fallback method will be called*/

@RestController
public class RestRetryController {

    @Autowired
    BackendAdapter backendAdapter;

    @GetMapping("/retry")
    @ExceptionHandler({Exception.class})
    public String validateSPringRetryCapability(@RequestParam(required = false) boolean simulateretry,
                                                @RequestParam(required = false) boolean simulateretryfallback) {
        System.out.println("===============================");
        System.out.println("Inside RestController method..");

        return backendAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }
}