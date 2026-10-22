package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas r7, float r8, float r9, float r10, float r11, int r12) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r7.saveLayerAlpha(r8, r9, r10, r11, r12);
    L7:
        return r7.saveLayerAlpha(r8, r9, r10, r11, r12, 31);
    }

    public static int saveLayerAlpha(@NonNull Canvas r2, @Nullable RectF r3, int r4) {
        if (Build.VERSION.SDK_INT <= 21) goto L7;
        return r2.saveLayerAlpha(r3, r4);
    L7:
        return r2.saveLayerAlpha(r3, r4, 31);
    }
}
