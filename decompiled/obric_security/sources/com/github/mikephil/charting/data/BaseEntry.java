package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseEntry {
    private Object mData;
    private Drawable mIcon;
    private float y;

    public BaseEntry() {
        this.y = 0.0f;
        this.mData = null;
        this.mIcon = null;
    }

    public BaseEntry(float r2) {
        this.mData = null;
        this.mIcon = null;
        this.y = r2;
    }

    public BaseEntry(float r1, Object r2) {
        this(r1);
        this.mData = r2;
    }

    public BaseEntry(float r1, Drawable r2) {
        this(r1);
        this.mIcon = r2;
    }

    public BaseEntry(float r1, Drawable r2, Object r3) {
        this(r1);
        this.mIcon = r2;
        this.mData = r3;
    }

    public float getY() {
        return this.y;
    }

    public void setIcon(Drawable r1) {
        this.mIcon = r1;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public void setY(float r1) {
        this.y = r1;
    }

    public Object getData() {
        return this.mData;
    }

    public void setData(Object r1) {
        this.mData = r1;
    }
}
