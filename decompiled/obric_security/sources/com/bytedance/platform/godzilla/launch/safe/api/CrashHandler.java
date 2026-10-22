package com.bytedance.platform.godzilla.launch.safe.api;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashHandler {
    private String mName;

    public abstract String getInfo();

    public abstract void handle(Context r1);

    public CrashHandler(String r1) {
        this.mName = r1;
    }

    public String getName() {
        return this.mName;
    }
}
