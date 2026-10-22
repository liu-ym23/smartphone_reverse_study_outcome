package com.obric.common.oea.foundation.animation.engine;

/* JADX INFO: loaded from: classes2.dex */
public final class FloatValueHolder {
    private float mValue;

    public FloatValueHolder() {
        this.mValue = 0.0f;
    }

    public FloatValueHolder(float r2) {
        this.mValue = 0.0f;
        setValue(r2);
    }

    public void setValue(float r1) {
        this.mValue = r1;
    }

    public float getValue() {
        return this.mValue;
    }
}
