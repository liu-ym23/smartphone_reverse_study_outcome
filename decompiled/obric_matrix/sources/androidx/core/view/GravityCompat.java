package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    @RequiresApi(17)
    static class Api17Impl {
        private Api17Impl() {
        }

        @DoNotInline
        static void apply(int r0, int r1, int r2, Rect r3, int r4, int r5, Rect r6, int r7) {
            Gravity.apply(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        @DoNotInline
        static void apply(int r0, int r1, int r2, Rect r3, Rect r4, int r5) {
            Gravity.apply(r0, r1, r2, r3, r4, r5);
        }

        @DoNotInline
        static void applyDisplay(int r0, Rect r1, Rect r2, int r3) {
            Gravity.applyDisplay(r0, r1, r2, r3);
        }
    }

    private GravityCompat() {
    }

    public static void apply(int r2, int r3, int r4, @NonNull Rect r5, int r6, int r7, @NonNull Rect r8, int r9) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.apply(r2, r3, r4, r5, r6, r7, r8, r9);
        return;
    L5:
        Gravity.apply(r2, r3, r4, r5, r6, r7, r8);
    }

    public static void apply(int r2, int r3, int r4, @NonNull Rect r5, @NonNull Rect r6, int r7) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.apply(r2, r3, r4, r5, r6, r7);
        return;
    L5:
        Gravity.apply(r2, r3, r4, r5, r6);
    }

    public static void applyDisplay(int r2, @NonNull Rect r3, @NonNull Rect r4, int r5) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        Api17Impl.applyDisplay(r2, r3, r4, r5);
        return;
    L5:
        Gravity.applyDisplay(r2, r3, r4);
    }

    public static int getAbsoluteGravity(int r2, int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L7;
        return Gravity.getAbsoluteGravity(r2, r3);
    L7:
        return r2 & (-8388609);
    }
}
