package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
@MainDex
public final class BaseFeatureList {

    interface Natives {
        boolean isEnabled(String r1);
    }

    private BaseFeatureList() {
    }

    public static boolean isEnabled(String r1) {
        return BaseFeatureListJni.get().isEnabled(r1);
    }
}
