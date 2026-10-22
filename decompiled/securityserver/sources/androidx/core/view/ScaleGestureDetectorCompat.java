package androidx.core.view;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object r0) {
        return isQuickScaleEnabled((ScaleGestureDetector) r0);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object r0, boolean r1) {
        setQuickScaleEnabled((ScaleGestureDetector) r0, r1);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector r0) {
        return r0.isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector r0, boolean r1) {
        r0.setQuickScaleEnabled(r1);
    }
}
