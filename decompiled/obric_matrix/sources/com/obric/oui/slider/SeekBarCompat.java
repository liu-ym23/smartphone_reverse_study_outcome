package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.SeekBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "", "t", "(I)I", "u", "getProgress", "()I", "getMinRealValue", "getMaxRealValue", "minValue", "Lkotlin/f0;", "setMinValue", "(I)V", "maxValue", "setMaxValue", "progress", "setProgress", "", "animate", "(IZ)V", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "l", "setOnSeekBarChangeListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "r", "I", TypedValues.CycleType.S_WAVE_OFFSET, "s", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onSeekBarChangeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class SeekBarCompat extends TickMarkSeekBar {
    private int r;
    private SeekBar.OnSeekBarChangeListener s;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SeekBarCompat f11398a;

        a(SeekBarCompat r1) {
            this.f11398a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar r3, int r4, boolean r5) {
            Log.i("SeekBarCompat", String.valueOf(r4));
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.r(this.f11398a);
            if (r0 == null) goto L6;
            r0.onProgressChanged(r3, SeekBarCompat.s(this.f11398a, r4), r5);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar r1) {
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.r(this.f11398a);
            if (r0 == null) goto L6;
            r0.onStartTrackingTouch(r1);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar r1) {
            SeekBar.OnSeekBarChangeListener r0 = SeekBarCompat.r(this.f11398a);
            if (r0 == null) goto L6;
            r0.onStopTrackingTouch(r1);
            return;
        }
    }

    public SeekBarCompat(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public SeekBarCompat(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SeekBarCompat(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener r(SeekBarCompat r0) {
        return r0.s;
    }

    public static final /* synthetic */ int s(SeekBarCompat r0, int r1) {
        return r0.t(r1);
    }

    private final int t(int r1) {
        return r1 + this.r;
    }

    private final int u(int r1) {
        return r1 - this.r;
    }

    public final int getMaxRealValue() {
        return t(getMax());
    }

    public final int getMinRealValue() {
        return t(0);
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return t(super.getProgress());
    }

    public final void setMaxValue(int r1) {
        setMax(u(r1));
    }

    public final void setMinValue(int r1) {
        this.r = r1;
        setMax(u(getMax()));
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r1) {
        this.s = r1;
        super.setOnSeekBarChangeListener(new a(this));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r1) {
        super.setProgress(u(r1));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r1, boolean r2) {
        super.setProgress(u(r1), r2);
    }
}
