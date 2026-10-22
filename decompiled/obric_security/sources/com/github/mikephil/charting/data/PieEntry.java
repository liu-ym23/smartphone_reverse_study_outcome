package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class PieEntry extends Entry {
    private String label;

    @Override // com.github.mikephil.charting.data.Entry
    public /* bridge */ /* synthetic */ Entry copy() {
        return copy();
    }

    public PieEntry(float r2) {
        super(0.0f, r2);
    }

    public PieEntry(float r2, Object r3) {
        super(0.0f, r2, r3);
    }

    public PieEntry(float r2, Drawable r3) {
        super(0.0f, r2, r3);
    }

    public PieEntry(float r2, Drawable r3, Object r4) {
        super(0.0f, r2, r3, r4);
    }

    public PieEntry(float r2, String r3) {
        super(0.0f, r2);
        this.label = r3;
    }

    public PieEntry(float r2, String r3, Object r4) {
        super(0.0f, r2, r4);
        this.label = r3;
    }

    public PieEntry(float r2, String r3, Drawable r4) {
        super(0.0f, r2, r4);
        this.label = r3;
    }

    public PieEntry(float r2, String r3, Drawable r4, Object r5) {
        super(0.0f, r2, r4, r5);
        this.label = r3;
    }

    public float getValue() {
        return getY();
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String r1) {
        this.label = r1;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float r1) {
        super.setX(r1);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.getX();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public PieEntry copy() {
        return new PieEntry(getY(), this.label, getData());
    }
}
