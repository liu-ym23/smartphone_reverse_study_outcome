package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void setDecorFitsSystemWindows(@NonNull Window r1, boolean r2) {
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

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T requireViewById(Window r0, int r1) {
            return (T) r0.requireViewById(r1);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static void setDecorFitsSystemWindows(@NonNull Window r0, boolean r1) {
            r0.setDecorFitsSystemWindows(r1);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat getInsetsController(@NonNull Window r1, @NonNull View r2) {
        return new WindowInsetsControllerCompat(r1, r2);
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Window r2, @IdRes int r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        T r4 = (T) r2.findViewById(r3);
        if (r4 == null) goto L10;
        return r4;
    L10:
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    L5:
        return (T) Api28Impl.requireViewById(r2, r3);
    }

    public static void setDecorFitsSystemWindows(@NonNull Window r2, boolean r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L6;
        Api30Impl.setDecorFitsSystemWindows(r2, r3);
        return;
    L6:
        if (r0 < 16) goto L10;
        Api16Impl.setDecorFitsSystemWindows(r2, r3);
        return;
    }
}
