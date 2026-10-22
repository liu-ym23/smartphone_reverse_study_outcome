package com.bytedance.platform.godzilla.plugin;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePlugin {
    private PluginState mState;

    public BasePlugin() {
    }

    public void destroy() {
        this.mState = PluginState.DESTROYED;
    }

    public abstract String getName();

    public final PluginState getState() {
        return this.mState;
    }

    public void init(Application r1) {
        this.mState = PluginState.INITIALIZED;
    }

    public void start() {
        this.mState = PluginState.STARTED;
    }

    public StartType startType() {
        return StartType.IMMEDIATE;
    }

    public void stop() {
        this.mState = PluginState.STOPPED;
    }
}
