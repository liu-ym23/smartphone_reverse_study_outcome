package com.android.settingslib.utils;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class HandlerInjector {
    protected final Handler mHandler;

    public HandlerInjector(Handler r1) {
        this.mHandler = r1;
    }

    public void postDelayed(Runnable r1, long r2) {
        this.mHandler.postDelayed(r1, r2);
    }

    public void removeCallbacks(Runnable r1) {
        this.mHandler.removeCallbacks(r1);
    }
}
