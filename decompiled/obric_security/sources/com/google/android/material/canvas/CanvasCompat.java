package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas r0, RectF r1, int r2) {
        return r0.saveLayerAlpha(r1, r2);
    }

    public static int saveLayerAlpha(Canvas r0, float r1, float r2, float r3, float r4, int r5) {
        return r0.saveLayerAlpha(r1, r2, r3, r4, r5);
    }
}
