package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class MaterialArcMotion extends PathMotion {
    public MaterialArcMotion() {
    }

    private static PointF getControlPoint(float r1, float r2, float r3, float r4) {
        if (r2 <= r4) goto L7;
        return new PointF(r3, r2);
    L7:
        return new PointF(r1, r4);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float r1, float r2, float r3, float r4) {
        Path r0 = new Path();
        r0.moveTo(r1, r2);
        PointF r5 = getControlPoint(r1, r2, r3, r4);
        r0.quadTo(r5.x, r5.y, r3, r4);
        return r0;
    }
}
