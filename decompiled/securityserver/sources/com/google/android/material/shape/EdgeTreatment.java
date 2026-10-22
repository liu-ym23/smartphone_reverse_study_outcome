package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class EdgeTreatment {
    public EdgeTreatment() {
    }

    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float r2, float r3, @NonNull ShapePath r4) {
        getEdgePath(r2, r2 / 2.0f, r3, r4);
    }

    public void getEdgePath(float r1, float r2, float r3, @NonNull ShapePath r4) {
        r4.lineTo(r1, 0.0f);
    }
}
