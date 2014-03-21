package org.kamol.nefete.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import org.kamol.nefete.R;
import org.kamol.nefete.NefeteApp;

import javax.inject.Inject;

public class MainActivity extends Activity {
  @Inject AppContainer appContainer;

  private ViewGroup container;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    NefeteApp app = NefeteApp.get(this);
    app.inject(this);

    container = appContainer.get(this, app);

    getLayoutInflater().inflate(R.layout.gallery_view, container);
  }
}
