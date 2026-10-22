package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class CornerTreatment {
    public CornerTreatment() {
    }

    @Deprecated
    public void getCornerPath(float r1, float r2, @NonNull ShapePath r3) {
    }

    public void getCornerPath(@NonNull ShapePath r1, float r2, float r3, float r4) {
        getCornerPath(r2, r3, r1);
    }

    public void getCornerPath(@NonNull ShapePath r1, float r2, float r3, @NonNull RectF r4, @NonNull CornerSize r5) {
        getCornerPath(r1, r2, r3, r5.getCornerSize(r4));
    }
}
