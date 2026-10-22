package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes3.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues;
    private final Matrix tempMatrix;
    private final float[] tempStartValues;

    public MatrixEvaluator() {
        this.tempStartValues = new float[9];
        this.tempEndValues = new float[9];
        this.tempMatrix = new Matrix();
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Matrix evaluate(float r1, Matrix r2, Matrix r3) {
        return evaluate2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Matrix evaluate2(float r3, Matrix r4, Matrix r5) {
        r4.getValues(this.tempStartValues);
        r5.getValues(this.tempEndValues);
        int r6 = 0;
    L4:
        if (r6 >= 9) goto L6;
        float[] r7 = this.tempEndValues;
        float r0 = r7[r6];
        float r1 = this.tempStartValues[r6];
        r7[r6] = r1 + ((r0 - r1) * r3);
        r6 = r6 + 1;
        goto L4
    L6:
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
