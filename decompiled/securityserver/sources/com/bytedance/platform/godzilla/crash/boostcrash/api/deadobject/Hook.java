package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

/* JADX INFO: loaded from: classes.dex */
public abstract class Hook {
    protected Object mRawObject;

    public Hook() {
    }

    public abstract void onHook();

    public void setRawObject(Object r1) {
        this.mRawObject = r1;
    }
}
