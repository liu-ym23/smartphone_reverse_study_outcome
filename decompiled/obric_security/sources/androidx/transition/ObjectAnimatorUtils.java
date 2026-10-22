package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class ObjectAnimatorUtils {
    static <T> ObjectAnimator ofPointF(T r1, Property<T, PointF> r2, Path r3) {
        return ObjectAnimator.ofObject(r1, r2, null, r3);
    }

    private ObjectAnimatorUtils() {
    }
}
