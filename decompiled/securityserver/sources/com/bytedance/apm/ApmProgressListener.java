package com.bytedance.apm;

/* JADX INFO: loaded from: classes.dex */
public abstract class ApmProgressListener {
    public ApmProgressListener() {
    }

    public abstract void afterConfigReady();

    public void afterRegisterService() {
    }

    public void functionSwitcherInited() {
    }
}
