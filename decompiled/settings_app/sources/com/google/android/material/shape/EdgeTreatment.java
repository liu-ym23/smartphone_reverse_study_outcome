package com.google.android.material.shape;

/* JADX INFO: loaded from: classes3.dex */
public class EdgeTreatment {
    boolean forceIntersection() {
        return false;
    }

    public EdgeTreatment() {
    }

    @Deprecated
    public void getEdgePath(float r2, float r3, ShapePath r4) {
        getEdgePath(r2, r2 / 2.0f, r3, r4);
    }

    public void getEdgePath(float r1, float r2, float r3, ShapePath r4) {
        r4.lineTo(r1, 0.0f);
    }
}
