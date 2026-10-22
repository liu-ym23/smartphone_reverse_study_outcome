package com.bytedance.apm.config;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractWidgetConfig {
    private boolean mSwitchOn;

    public AbstractWidgetConfig() {
        this.mSwitchOn = false;
    }

    public boolean isSwitchOn() {
        return this.mSwitchOn;
    }

    public AbstractWidgetConfig setSwitch(boolean r1) {
        this.mSwitchOn = r1;
        return this;
    }
}
