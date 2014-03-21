package org.kamol.nefete;

import org.kamol.nefete.data.DebugDataModule;
import org.kamol.nefete.ui.DebugUiModule;

import dagger.Module;

@Module(
    addsTo = NefeteModule.class,
    includes = {
        DebugUiModule.class,
        DebugDataModule.class
    },
    overrides = true
)
public final class DebugNefeteModule {
}
