package com.obric.oui.slider;

import android.widget.SeekBar;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class SeekBarCompat extends TickMarkSeekBar {
    public int u;
    public SeekBar.OnSeekBarChangeListener v;

    public final int getMaxRealValue() {
        return getMax() + this.u;
    }

    public final int getMinRealValue() {
        return this.u;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return super.getProgress() + this.u;
    }

    public final void setMaxValue(int r2) {
        setMax(r2 - this.u);
    }

    public final void setMinValue(int r2) {
        this.u = r2;
        setMax(getMax() - this.u);
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(@Nullable SeekBar.OnSeekBarChangeListener r1) {
        this.v = r1;
        super.setOnSeekBarChangeListener(new AnonymousClass1(this));
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int r2) {
        super.setProgress(r2 - this.u);
    }

    @Override // android.widget.ProgressBar
    public final void setProgress(int r2, boolean r3) {
        super.setProgress(r2 - this.u, r3);
    }
}
