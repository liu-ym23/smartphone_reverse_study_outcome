package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.core.util.ObjectsCompat;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    static class Api28Impl {
        private Api28Impl() {
        }

        static DisplayCutout createDisplayCutout(Rect r1, List<Rect> r2) {
            return new DisplayCutout(r1, r2);
        }

        static int getSafeInsetTop(DisplayCutout r0) {
            return r0.getSafeInsetTop();
        }

        static int getSafeInsetBottom(DisplayCutout r0) {
            return r0.getSafeInsetBottom();
        }

        static int getSafeInsetLeft(DisplayCutout r0) {
            return r0.getSafeInsetLeft();
        }

        static int getSafeInsetRight(DisplayCutout r0) {
            return r0.getSafeInsetRight();
        }

        static List<Rect> getBoundingRects(DisplayCutout r0) {
            return r0.getBoundingRects();
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static DisplayCutout createDisplayCutout(Insets r7, Rect r8, Rect r9, Rect r10, Rect r11) {
            return new DisplayCutout(r7, r8, r9, r10, r11);
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static DisplayCutout createDisplayCutout(Insets r8, Rect r9, Rect r10, Rect r11, Rect r12, Insets r13) {
            return new DisplayCutout(r8, r9, r10, r11, r12, r13);
        }

        static Insets getWaterfallInsets(DisplayCutout r0) {
            return r0.getWaterfallInsets();
        }
    }

    public DisplayCutoutCompat(Rect r1, List<Rect> r2) {
        this(Api28Impl.createDisplayCutout(r1, r2));
    }

    public DisplayCutoutCompat(androidx.core.graphics.Insets r1, Rect r2, Rect r3, Rect r4, Rect r5, androidx.core.graphics.Insets r6) {
        this(constructDisplayCutout(r1, r2, r3, r4, r5, r6));
    }

    private static DisplayCutout constructDisplayCutout(androidx.core.graphics.Insets r6, Rect r7, Rect r8, Rect r9, Rect r10, androidx.core.graphics.Insets r11) {
        return Api30Impl.createDisplayCutout(r6.toPlatformInsets(), r7, r8, r9, r10, r11.toPlatformInsets());
    }

    private DisplayCutoutCompat(DisplayCutout r1) {
        this.mDisplayCutout = r1;
    }

    public int getSafeInsetTop() {
        return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
    }

    public int getSafeInsetBottom() {
        return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
    }

    public int getSafeInsetLeft() {
        return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
    }

    public int getSafeInsetRight() {
        return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
    }

    public List<Rect> getBoundingRects() {
        return Api28Impl.getBoundingRects(this.mDisplayCutout);
    }

    public androidx.core.graphics.Insets getWaterfallInsets() {
        return androidx.core.graphics.Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) r3).mDisplayCutout);
    }

    public int hashCode() {
        DisplayCutout r0 = this.mDisplayCutout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + VectorFormat.DEFAULT_SUFFIX;
    }

    static DisplayCutoutCompat wrap(DisplayCutout r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r1);
    }

    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }
}
