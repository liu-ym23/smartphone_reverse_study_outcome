package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath r8, float r9, float r10, float r11) {
        r8.reset(0.0f, r11 * r10, 180.0f, 180.0f - r9);
        float r4 = (r11 * 2.0f) * r10;
        r8.addArc(0.0f, 0.0f, r4, r4, 180.0f, r9);
    }

    @Deprecated
    public RoundedCornerTreatment(float r1) {
        this.radius = r1;
    }
}
