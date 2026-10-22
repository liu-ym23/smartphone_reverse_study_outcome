package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Rect r1, List<Rect> r2) {
            return new DisplayCutout(r1, r2);
        }

        @DoNotInline
        static List<Rect> getBoundingRects(DisplayCutout r0) {
            return r0.getBoundingRects();
        }

        @DoNotInline
        static int getSafeInsetBottom(DisplayCutout r0) {
            return r0.getSafeInsetBottom();
        }

        @DoNotInline
        static int getSafeInsetLeft(DisplayCutout r0) {
            return r0.getSafeInsetLeft();
        }

        @DoNotInline
        static int getSafeInsetRight(DisplayCutout r0) {
            return r0.getSafeInsetRight();
        }

        @DoNotInline
        static int getSafeInsetTop(DisplayCutout r0) {
            return r0.getSafeInsetTop();
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Insets r7, Rect r8, Rect r9, Rect r10, Rect r11) {
            return new DisplayCutout(r7, r8, r9, r10, r11);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static DisplayCutout createDisplayCutout(Insets r8, Rect r9, Rect r10, Rect r11, Rect r12, Insets r13) {
            return new DisplayCutout(r8, r9, r10, r11, r12, r13);
        }

        @DoNotInline
        static Insets getWaterfallInsets(DisplayCutout r0) {
            return r0.getWaterfallInsets();
        }
    }

    public DisplayCutoutCompat(@Nullable Rect r3, @Nullable List<Rect> r4) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        DisplayCutout r5 = Api28Impl.createDisplayCutout(r3, r4);
    L6:
        this(r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    private DisplayCutoutCompat(DisplayCutout r1) {
        this.mDisplayCutout = r1;
    }

    public DisplayCutoutCompat(@NonNull androidx.core.graphics.Insets r1, @Nullable Rect r2, @Nullable Rect r3, @Nullable Rect r4, @Nullable Rect r5, @NonNull androidx.core.graphics.Insets r6) {
        this(constructDisplayCutout(r1, r2, r3, r4, r5, r6));
    }

    private static DisplayCutout constructDisplayCutout(@NonNull androidx.core.graphics.Insets r8, @Nullable Rect r9, @Nullable Rect r10, @Nullable Rect r11, @Nullable Rect r12, @NonNull androidx.core.graphics.Insets r13) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        return Api30Impl.createDisplayCutout(r8.toPlatformInsets(), r9, r10, r11, r12, r13.toPlatformInsets());
    L7:
        if (r0 < 29) goto L11;
        return Api29Impl.createDisplayCutout(r8.toPlatformInsets(), r9, r10, r11, r12);
    L11:
        if (r0 < 28) goto L23;
        Rect r14 = new Rect(r8.left, r8.top, r8.right, r8.bottom);
        ArrayList r15 = new ArrayList();
        if (r9 == null) goto L15;
        r15.add(r9);
    L15:
        if (r10 == null) goto L17;
        r15.add(r10);
    L17:
        if (r11 == null) goto L19;
        r15.add(r11);
    L19:
        if (r12 == null) goto L22;
        r15.add(r12);
    L22:
        return Api28Impl.createDisplayCutout(r14, r15);
    L23:
        return null;
    }

    static DisplayCutoutCompat wrap(DisplayCutout r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (DisplayCutoutCompat.class == r3.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r3).mDisplayCutout);
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getBoundingRects(this.mDisplayCutout);
    L7:
        return Collections.emptyList();
    }

    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return 0;
    L5:
        return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    @NonNull
    public androidx.core.graphics.Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
    L7:
        return androidx.core.graphics.Insets.NONE;
    }

    public int hashCode() {
        DisplayCutout r0 = this.mDisplayCutout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    @NonNull
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    @RequiresApi(28)
    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }
}
