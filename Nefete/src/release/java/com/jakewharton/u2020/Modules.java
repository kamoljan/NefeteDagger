package com.jakewharton.nefete;

import org.kamol.nefete.NefeteApp;
import org.kamol.nefete.NefeteModule;

final class Modules {
  static Object[] list(NefeteApp app) {
    return new Object[]{
        new NefeteModule(app)
    };
  }

  private Modules() {
    // No instances.
  }
}
