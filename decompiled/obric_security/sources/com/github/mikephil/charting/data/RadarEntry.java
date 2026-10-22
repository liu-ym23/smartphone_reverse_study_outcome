package com.github.mikephil.charting.data;

/* JADX INFO: loaded from: classes2.dex */
public class RadarEntry extends Entry {
    @Override // com.github.mikephil.charting.data.Entry
    public /* bridge */ /* synthetic */ Entry copy() {
        return copy();
    }

    public RadarEntry(float r2) {
        super(0.0f, r2);
    }

    public RadarEntry(float r2, Object r3) {
        super(0.0f, r2, r3);
    }

    public float getValue() {
        return getY();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public RadarEntry copy() {
        return new RadarEntry(getY(), getData());
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void setX(float r1) {
        super.setX(r1);
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float getX() {
        return super.getX();
    }
}
