package org.kamol.nefete.ui;

import org.kamol.nefete.ui.debug.DebugAppContainer;
import org.kamol.nefete.ui.debug.SocketActivityHierarchyServer;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
    injects = DebugAppContainer.class,
    complete = false,
    library = true,
    overrides = true
)
public class DebugUiModule {
  @Provides @Singleton AppContainer provideAppContainer(DebugAppContainer debugAppContainer) {
    return debugAppContainer;
  }

  @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
    return new SocketActivityHierarchyServer();
  }
}
