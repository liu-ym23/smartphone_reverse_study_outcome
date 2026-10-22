package com.squareup.leakcanary;

/* JADX INFO: loaded from: classes5.dex */
public final class RefWatcher {
    public static final RefWatcher DISABLED = null;

    public void watch(Object r1) {
    }

    public void watch(Object r1, String r2) {
    }

    static {
        DISABLED = new RefWatcher();
    }

    private RefWatcher() {
    }
}
