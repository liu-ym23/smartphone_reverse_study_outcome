package com.obric.oui.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SeekBarCompat.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u00020\u0007*\u00020\u0007H\u0002J\f\u0010\u001b\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/slider/SeekBarCompat;", "Lcom/obric/oui/slider/TickMarkSeekBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "offset", "onSeekBarChangeListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "getMaxRealValue", "getMinRealValue", "getProgress", "setMaxValue", "", "maxValue", "setMinValue", "minValue", "setOnSeekBarChangeListener", "l", "setProgress", "progress", "animate", "", "toRealValue", "toWrapValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SeekBarCompat extends TickMarkSeekBar {
    private int offset;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener;

    public SeekBarCompat(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public SeekBarCompat(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ SeekBarCompat(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ SeekBar.OnSeekBarChangeListener access$getOnSeekBarChangeListener$p(SeekBarCompat r0) {
        return r0.onSeekBarChangeListener;
    }

    public static final /* synthetic */ int access$toRealValue(SeekBarCompat r0, int r1) {
        return r0.toRealValue(r1);
    }

    public SeekBarCompat(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return toRealValue(super.getProgress());
    }

    public final int getMinRealValue() {
        return toRealValue(0);
    }

    public final int getMaxRealValue() {
        return toRealValue(getMax());
    }

    public final void setMinValue(int r1) {
        this.offset = r1;
        setMax(toWrapValue(getMax()));
    }

    public final void setMaxValue(int r1) {
        setMax(toWrapValue(r1));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1) {
        super.setProgress(toWrapValue(r1));
    }

    @Override // com.obric.oui.slider.TickMarkSeekBar, android.widget.ProgressBar
    public void setProgress(int r1, boolean r2) {
        super.setProgress(toWrapValue(r1), r2);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r1) {
        this.onSeekBarChangeListener = r1;
        super.setOnSeekBarChangeListener(new AnonymousClass1(this));
    }

    private final int toRealValue(int r1) {
        return r1 + this.offset;
    }

    private final int toWrapValue(int r1) {
        return r1 - this.offset;
    }
}
