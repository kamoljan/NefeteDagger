package org.kamol.nefete;

import android.app.Application;
import android.content.Context;

import org.kamol.nefete.ui.ActivityHierarchyServer;

import dagger.ObjectGraph;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public class NefeteApp extends Application {
  private ObjectGraph objectGraph;

  @Inject ActivityHierarchyServer activityHierarchyServer;

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new DebugTree());
    } else {
      // TODO Crashlytics.start(this);
      // TODO Timber.plant(new CrashlyticsTree());
    }

    buildObjectGraphAndInject();

    registerActivityLifecycleCallbacks(activityHierarchyServer);
  }

  public void buildObjectGraphAndInject() {
    long start = System.nanoTime();

    objectGraph = ObjectGraph.create(Modules.list(this));
    objectGraph.inject(this);

    long diff = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    Timber.i("Global object graph creation took %sms", diff);
  }

  public void inject(Object o) {
    objectGraph.inject(o);
  }

  public static NefeteApp get(Context context) {
    return (NefeteApp) context.getApplicationContext();
  }
}
