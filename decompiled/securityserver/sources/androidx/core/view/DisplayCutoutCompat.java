package androidx.core.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final Object mDisplayCutout;

    public DisplayCutoutCompat(Rect r2, List<Rect> r3) {
        this(new DisplayCutout(r2, r3));
    }

    public static DisplayCutoutCompat wrap(Object r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return new DisplayCutoutCompat(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (DisplayCutoutCompat.class != r5.getClass()) goto L18;
        DisplayCutoutCompat r6 = (DisplayCutoutCompat) r5;
        Object r4 = this.mDisplayCutout;
        if (r4 != null) goto L17;
        if (r6.mDisplayCutout != null) goto L19;
        return true;
    L19:
        return false;
    L17:
        return r4.equals(r6.mDisplayCutout);
    }

    public List<Rect> getBoundingRects() {
        return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
    }

    public int getSafeInsetBottom() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
    }

    public int getSafeInsetLeft() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
    }

    public int getSafeInsetRight() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
    }

    public int getSafeInsetTop() {
        return ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
    }

    public int hashCode() {
        Object r0 = this.mDisplayCutout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    @RequiresApi(api = 28)
    public DisplayCutout unwrap() {
        return (DisplayCutout) this.mDisplayCutout;
    }

    private DisplayCutoutCompat(Object r1) {
        this.mDisplayCutout = r1;
    }
}
