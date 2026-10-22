package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

/* JADX INFO: loaded from: classes2.dex */
public class BrightnessSeekBar extends RelativeLayout {
    private SeekBar mSeekbar;

    public BrightnessSeekBar(Context r2) {
        this(r2, null);
    }

    public BrightnessSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BrightnessSeekBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mSeekbar = (SeekBar) LayoutInflater.from(r1).inflate(R.layout.brightness_seekbar_layout, this).findViewById(R.id.brightness_seekbar);
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener r3) {
        this.mSeekbar.setOnSeekBarChangeListener(null);
        this.mSeekbar.setOnSeekBarChangeListener(r3);
    }

    public void setMax(int r1) {
        this.mSeekbar.setMax(r1);
    }

    public void setProgress(int r1) {
        this.mSeekbar.setProgress(r1);
    }

    public int getProgress() {
        return this.mSeekbar.getProgress();
    }

    public void setSeekBarTag(Object r1) {
        this.mSeekbar.setTag(r1);
    }

    public void setBackground(int r1) {
        setBackgroundResource(r1);
    }
}
