package com.example.retry;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class BackendAdapterImpl implements BackendAdapter {

    /*In the Rest Api we will add two optional request parameters.
    simulateretry – parameter to simulate the exception scenario, so that spring can retry.
    simulateretryfallback – as we are simulating the exception, after retry certain times we can either expect a successful backend call or all retry falls.
        In this case we will go to the fall back method to get hard-coded/error response.
        Now this parameter will ensure all the retry will fail and we will go to fall back path only.*/

    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) {

        if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenario.");

            if (simulateretryfallback) {
                throw new RemoteServiceNotAvailableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);

            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvailableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }

        return "Hello from Remote Backend!!!";
    }

    @Override
    public String getBackendResponseFallback(Exception e) {
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}