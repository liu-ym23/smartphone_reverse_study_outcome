package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float r2) {
        this.radius = r2 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r9, float r10, float r11, @NonNull ShapePath r12) {
        float r13 = (float) ((Math.sqrt(2.0d) * this.radius) / 2.0d);
        float r14 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(r13, 2.0d));
        r12.reset(r10 - r13, ((float) (-((Math.sqrt(2.0d) * this.radius) - ((double) this.radius)))) + r14);
        r12.lineTo(r10, (float) (-((Math.sqrt(2.0d) * this.radius) - ((double) this.radius))));
        r12.lineTo(r10 + r13, ((float) (-((Math.sqrt(2.0d) * this.radius) - ((double) this.radius)))) + r14);
    }
}
