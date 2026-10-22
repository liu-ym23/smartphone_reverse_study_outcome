package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class CandleEntry extends Entry {
    private float mClose;
    private float mOpen;
    private float mShadowHigh;
    private float mShadowLow;

    @Override // com.github.mikephil.charting.data.Entry
    public /* bridge */ /* synthetic */ Entry copy() {
        return copy();
    }

    public CandleEntry(float r3, float r4, float r5, float r6, float r7) {
        super(r3, (r4 + r5) / 2.0f);
        this.mShadowHigh = r4;
        this.mShadowLow = r5;
        this.mOpen = r6;
        this.mClose = r7;
    }

    public CandleEntry(float r3, float r4, float r5, float r6, float r7, Object r8) {
        super(r3, (r4 + r5) / 2.0f, r8);
        this.mShadowHigh = r4;
        this.mShadowLow = r5;
        this.mOpen = r6;
        this.mClose = r7;
    }

    public CandleEntry(float r3, float r4, float r5, float r6, float r7, Drawable r8) {
        super(r3, (r4 + r5) / 2.0f, r8);
        this.mShadowHigh = r4;
        this.mShadowLow = r5;
        this.mOpen = r6;
        this.mClose = r7;
    }

    public CandleEntry(float r3, float r4, float r5, float r6, float r7, Drawable r8, Object r9) {
        super(r3, (r4 + r5) / 2.0f, r8, r9);
        this.mShadowHigh = r4;
        this.mShadowLow = r5;
        this.mOpen = r6;
        this.mClose = r7;
    }

    public float getShadowRange() {
        return Math.abs(this.mShadowHigh - this.mShadowLow);
    }

    public float getBodyRange() {
        return Math.abs(this.mOpen - this.mClose);
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float getY() {
        return super.getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public CandleEntry copy() {
        return new CandleEntry(getX(), this.mShadowHigh, this.mShadowLow, this.mOpen, this.mClose, getData());
    }

    public float getHigh() {
        return this.mShadowHigh;
    }

    public void setHigh(float r1) {
        this.mShadowHigh = r1;
    }

    public float getLow() {
        return this.mShadowLow;
    }

    public void setLow(float r1) {
        this.mShadowLow = r1;
    }

    public float getClose() {
        return this.mClose;
    }

    public void setClose(float r1) {
        this.mClose = r1;
    }

    public float getOpen() {
        return this.mOpen;
    }

    public void setOpen(float r1) {
        this.mOpen = r1;
    }
}
