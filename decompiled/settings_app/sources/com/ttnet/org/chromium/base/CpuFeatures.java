package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes5.dex */
@JNINamespace("base::android")
public abstract class CpuFeatures {

    interface Natives {
        int getCoreCount();

        long getCpuFeatures();
    }

    public CpuFeatures() {
    }

    public static int getCount() {
        return CpuFeaturesJni.get().getCoreCount();
    }

    public static long getMask() {
        return CpuFeaturesJni.get().getCpuFeatures();
    }
}
