package com.github.mikephil.charting.highlight;

/* JADX INFO: loaded from: classes2.dex */
public final class Range {
    public float from;
    public float to;

    public Range(float r1, float r2) {
        this.from = r1;
        this.to = r2;
    }

    public boolean contains(float r2) {
        if (r2 > this.from) goto L5;
        return false;
    L5:
        if (r2 > this.to) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isLarger(float r1) {
        if (r1 <= this.to) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSmaller(float r1) {
        if (r1 >= this.from) goto L5;
        return true;
    L5:
        return false;
    }
}
