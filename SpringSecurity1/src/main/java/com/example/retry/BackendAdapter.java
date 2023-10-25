package com.example.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface BackendAdapter {

    @Retryable(value = {RemoteServiceNotAvailableException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000)) //Retry with 1 sec delay
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback);

    @Recover
    public String getBackendResponseFallback(Exception e);

}