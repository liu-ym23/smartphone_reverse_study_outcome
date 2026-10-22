package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class PathInterpolatorCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float r1, float r2) {
            return new PathInterpolator(r1, r2);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(float r1, float r2, float r3, float r4) {
            return new PathInterpolator(r1, r2, r3, r4);
        }

        @DoNotInline
        static PathInterpolator createPathInterpolator(Path r1) {
            return new PathInterpolator(r1);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(float r2, float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2, r3);
    L7:
        return new PathInterpolatorApi14(r2, r3);
    }

    @NonNull
    public static Interpolator create(float r2, float r3, float r4, float r5) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2, r3, r4, r5);
    L7:
        return new PathInterpolatorApi14(r2, r3, r4, r5);
    }

    @NonNull
    public static Interpolator create(@NonNull Path r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.createPathInterpolator(r2);
    L7:
        return new PathInterpolatorApi14(r2);
    }
}
