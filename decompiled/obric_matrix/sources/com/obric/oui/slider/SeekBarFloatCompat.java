package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0002*\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/slider/SeekBarFloatCompat;", "Lcom/obric/oui/slider/SeekBarCompat;", "", "", "w", "(F)I", "q", "(I)F", "decimals", "n", "(FI)F", "minValue", "Lkotlin/f0;", "setMinValue", "(F)V", "maxValue", "setMaxValue", "progress", "setProgress", "getMinValue", "()F", "getMaxValue", "getFloatProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class SeekBarFloatCompat extends SeekBarCompat {
    static {
    }

    public SeekBarFloatCompat(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public SeekBarFloatCompat(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SeekBarFloatCompat(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    private final float n(float r4, int r5) {
        String r3 = String.format(Locale.CHINA, "%." + r5 + 'f', Arrays.copyOf(new Object[]{Float.valueOf(r4)}, 1));
        o.e(r3, "format(locale, this, *args)");
        return Float.parseFloat(r3);
    }

    private final float q(int r4) {
        return v(this, r4 / 100, 0, 1, null);
    }

    static /* synthetic */ float v(SeekBarFloatCompat r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r2 = 2;
    L6:
        return r0.n(r1, r2);
    }

    private final int w(float r1) {
        return (int) (r1 * 100);
    }

    public final float getFloatProgress() {
        return q(super.getProgress());
    }

    public final float getMaxValue() {
        return q(getMaxRealValue());
    }

    public final float getMinValue() {
        return q(getMinRealValue());
    }

    public final void setMaxValue(float r1) {
        super.setMaxValue(w(r1));
    }

    public final void setMinValue(float r1) {
        super.setMinValue(w(r1));
    }

    public final void setProgress(float r1) {
        super.setProgress(w(r1));
    }
}
