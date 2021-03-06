package org.kamol.nefete.data.api;

import android.content.SharedPreferences;

import org.kamol.nefete.data.ApiEndpoint;
import org.kamol.nefete.data.IsMockMode;
import org.kamol.nefete.data.prefs.StringPreference;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidMockValuePersistence;

@Module(
    complete = false,
    library = true,
    overrides = true
)
public final class DebugApiModule {
  @Provides @Singleton Endpoint provideEndpoint(@ApiEndpoint StringPreference apiEndpoint) {
    return Endpoints.newFixedEndpoint(apiEndpoint.get());
  }

  @Provides @Singleton MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter,
                                                              SharedPreferences preferences) {
    MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
    AndroidMockValuePersistence.install(mockRestAdapter, preferences);
    return mockRestAdapter;
  }

  @Provides @Singleton GalleryService provideGalleryService(RestAdapter restAdapter,
                                                            MockRestAdapter mockRestAdapter,
                                                            @IsMockMode boolean isMockMode,
                                                            MockGalleryService mockService) {
    if (isMockMode) {
      return mockRestAdapter.create(GalleryService.class, mockService);
    }
    return restAdapter.create(GalleryService.class);
  }
}
