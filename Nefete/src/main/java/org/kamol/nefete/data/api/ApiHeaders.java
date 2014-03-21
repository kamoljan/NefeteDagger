package org.kamol.nefete.data.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.RequestInterceptor;

@Singleton
public final class ApiHeaders implements RequestInterceptor {
  private static final String AUTHORIZATION_PREFIX = "Client-ID";

  private final String authorizationValue;

  @Inject public ApiHeaders(@ClientId String clientId) {
    authorizationValue = AUTHORIZATION_PREFIX + " " + clientId;
  }

  @Override public void intercept(RequestFacade request) {
    request.addHeader("Authorization", authorizationValue);
  }
}
