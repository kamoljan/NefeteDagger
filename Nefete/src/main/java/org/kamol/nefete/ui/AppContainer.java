package org.kamol.nefete.ui;

import android.app.Activity;
import android.view.ViewGroup;

import org.kamol.nefete.NefeteApp;

import static butterknife.ButterKnife.findById;

/** An indirection which allows controlling the root container used for each activity. */
public interface AppContainer {
  /** The root {@link android.view.ViewGroup} into which the activity should place its contents. */
  ViewGroup get(Activity activity, NefeteApp app);

  /** An {@link AppContainer} which returns the normal activity content view. */
  AppContainer DEFAULT = new AppContainer() {
    @Override public ViewGroup get(Activity activity, NefeteApp app) {
      return findById(activity, android.R.id.content);
    }
  };
}
