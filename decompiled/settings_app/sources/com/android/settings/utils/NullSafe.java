package com.android.settings.utils;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class NullSafe {
    public NullSafe() {
    }

    public static <T> T nonNull(T r0) {
        r0.getClass();
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends View> T nonNull(View r0) {
        r0.getClass();
        return r0;
    }
}
