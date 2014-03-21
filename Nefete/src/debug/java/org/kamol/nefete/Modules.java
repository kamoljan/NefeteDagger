package org.kamol.nefete;

final class Modules {
  static Object[] list(NefeteApp app) {
    return new Object[] {
        new NefeteModule(app),
        new DebugNefeteModule()
    };
  }

  private Modules() {
    // No instances.
  }
}
