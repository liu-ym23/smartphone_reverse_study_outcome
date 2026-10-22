package com.tencent.qualityscan;

import android.graphics.Bitmap;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes4.dex */
public class BlurDetector {
    static {
        System.loadLibrary("blurdetector");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        q8.a("BlurDetector", th);
    }

    public BlurDetector() {
    }

    public native float blurDetect(Bitmap r1);
}
