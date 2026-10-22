package androidx.core.util;

import android.util.SizeF;
import com.obric.oui.material.MaterialConfigFormatNames;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes.dex */
public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    private static final class Api21Impl {
        private Api21Impl() {
        }

        static SizeFCompat toSizeFCompat(SizeF r2) {
            Preconditions.checkNotNull(r2);
            return new SizeFCompat(r2.getWidth(), r2.getHeight());
        }

        static SizeF toSizeF(SizeFCompat r2) {
            Preconditions.checkNotNull(r2);
            return new SizeF(r2.getWidth(), r2.getHeight());
        }
    }

    public SizeFCompat(float r2, float r3) {
        this.mWidth = Preconditions.checkArgumentFinite(r2, MaterialConfigFormatNames.WIDTH);
        this.mHeight = Preconditions.checkArgumentFinite(r3, MonthWeekEventsView.VIEW_PARAMS_HEIGHT);
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SizeFCompat) == true) goto L8;
        return false;
    L8:
        SizeFCompat r6 = (SizeFCompat) r5;
        if (r6.mWidth != this.mWidth) goto L14;
        if (r6.mHeight != this.mHeight) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = Float.floatToIntBits(this.mWidth);
        return Float.floatToIntBits(this.mHeight) ^ r0;
    }

    public String toString() {
        return this.mWidth + MaterialConfigFormatNames.X + this.mHeight;
    }

    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    public static SizeFCompat toSizeFCompat(SizeF r0) {
        return Api21Impl.toSizeFCompat(r0);
    }
}
