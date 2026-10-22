package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float r1, boolean r2) {
        this.size = r1;
        this.inside = r2;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r3, float r4, float r5, @NonNull ShapePath r6) {
        r6.lineTo(r4 - (this.size * r5), 0.0f);
        if (this.inside == false) goto L5;
        float r0 = this.size;
    L6:
        r6.lineTo(r4, r0 * r5);
        r6.lineTo(r4 + (this.size * r5), 0.0f);
        r6.lineTo(r3, 0.0f);
        return;
    L5:
        r0 = -this.size;
        goto L6
    }
}
