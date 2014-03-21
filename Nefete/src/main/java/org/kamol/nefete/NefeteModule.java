package org.kamol.nefete;

import android.app.Application;

import org.kamol.nefete.data.DataModule;
import org.kamol.nefete.ui.UiModule;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
    includes = {
        UiModule.class,
        DataModule.class
    },
    injects = {
        NefeteApp.class
    }
)
public final class NefeteModule {
  private final NefeteApp app;

  public NefeteModule(NefeteApp app) {
    this.app = app;
  }

  @Provides @Singleton Application provideApplication() {
    return app;
  }
}
