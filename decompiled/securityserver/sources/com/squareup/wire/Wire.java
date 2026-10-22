package com.squareup.wire;

/* JADX INFO: loaded from: classes2.dex */
public final class Wire {
    private Wire() {
    }

    public static <T> T get(T r0, T r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r1;
    }
}
