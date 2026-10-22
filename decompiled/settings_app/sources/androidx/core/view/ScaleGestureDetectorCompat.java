package androidx.core.view;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static void setQuickScaleEnabled(ScaleGestureDetector r0, boolean r1) {
            r0.setQuickScaleEnabled(r1);
        }

        static boolean isQuickScaleEnabled(ScaleGestureDetector r0) {
            return r0.isQuickScaleEnabled();
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object r0, boolean r1) {
        setQuickScaleEnabled((ScaleGestureDetector) r0, r1);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector r0, boolean r1) {
        Api19Impl.setQuickScaleEnabled(r0, r1);
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object r0) {
        return isQuickScaleEnabled((ScaleGestureDetector) r0);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector r0) {
        return Api19Impl.isQuickScaleEnabled(r0);
    }
}
