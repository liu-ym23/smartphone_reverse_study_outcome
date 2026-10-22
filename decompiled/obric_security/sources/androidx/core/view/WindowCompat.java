package androidx.core.view;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void setDecorFitsSystemWindows(Window r1, boolean r2) {
            View r3 = r1.getDecorView();
            int r0 = r3.getSystemUiVisibility();
            if (r2 == false) goto L5;
            int r4 = r0 & (-1793);
        L6:
            r3.setSystemUiVisibility(r4);
            return;
        L5:
            r4 = r0 | 1792;
            goto L6
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Window r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static void setDecorFitsSystemWindows(Window r0, boolean r1) {
            r0.setDecorFitsSystemWindows(r1);
        }
    }

    private WindowCompat() {
    }

    public static <T extends View> T requireViewById(Window r0, int r1) {
        return (T) Api28Impl.requireViewById(r0, r1);
    }

    public static void setDecorFitsSystemWindows(Window r0, boolean r1) {
        Api30Impl.setDecorFitsSystemWindows(r0, r1);
    }

    public static WindowInsetsControllerCompat getInsetsController(Window r1, View r2) {
        return new WindowInsetsControllerCompat(r1, r2);
    }
}
