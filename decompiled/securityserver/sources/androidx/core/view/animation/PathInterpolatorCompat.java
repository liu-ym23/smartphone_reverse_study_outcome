package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {
    private PathInterpolatorCompat() {
    }

    public static Interpolator create(Path r1) {
        return new PathInterpolator(r1);
    }

    public static Interpolator create(float r1, float r2) {
        return new PathInterpolator(r1, r2);
    }

    public static Interpolator create(float r1, float r2, float r3, float r4) {
        return new PathInterpolator(r1, r2, r3, r4);
    }
}
