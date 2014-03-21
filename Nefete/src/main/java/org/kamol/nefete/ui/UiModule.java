package org.kamol.nefete.ui;

import org.kamol.nefete.ui.gallery.GalleryView;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module(
    injects = {
        MainActivity.class,
        GalleryView.class,
    },
    complete = false,
    library = true
)
public class UiModule {
  @Provides @Singleton AppContainer provideAppContainer() {
    return AppContainer.DEFAULT;
  }

  @Provides @Singleton ActivityHierarchyServer provideActivityHierarchyServer() {
    return ActivityHierarchyServer.NONE;
  }
}
