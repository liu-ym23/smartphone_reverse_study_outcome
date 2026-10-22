package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleEntry extends Entry {
    private float mSize;

    @Override // com.github.mikephil.charting.data.Entry
    public /* bridge */ /* synthetic */ Entry copy() {
        return copy();
    }

    public BubbleEntry(float r1, float r2, float r3) {
        super(r1, r2);
        this.mSize = r3;
    }

    public BubbleEntry(float r1, float r2, float r3, Object r4) {
        super(r1, r2, r4);
        this.mSize = r3;
    }

    public BubbleEntry(float r1, float r2, float r3, Drawable r4) {
        super(r1, r2, r4);
        this.mSize = r3;
    }

    public BubbleEntry(float r1, float r2, float r3, Drawable r4, Object r5) {
        super(r1, r2, r4, r5);
        this.mSize = r3;
    }

    @Override // com.github.mikephil.charting.data.Entry
    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.mSize, getData());
    }

    public float getSize() {
        return this.mSize;
    }

    public void setSize(float r1) {
        this.mSize = r1;
    }
}
