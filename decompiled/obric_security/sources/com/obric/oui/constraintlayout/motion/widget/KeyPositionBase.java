package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit;

    abstract void calcPosition(int r1, int r2, float r3, float r4, float r5, float r6);

    @Override // com.obric.oui.constraintlayout.motion.widget.Key
    void getAttributeNames(HashSet<String> r1) {
    }

    abstract float getPositionX();

    abstract float getPositionY();

    public abstract boolean intersects(int r1, int r2, RectF r3, RectF r4, float r5, float r6);

    abstract void positionAttributes(View r1, RectF r2, RectF r3, float r4, float r5, String[] r6, float[] r7);

    KeyPositionBase() {
        this.mCurveFit = UNSET;
    }
}
