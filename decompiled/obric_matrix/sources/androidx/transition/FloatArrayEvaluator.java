package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: loaded from: classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    FloatArrayEvaluator(float[] r1) {
        this.mArray = r1;
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ float[] evaluate(float r1, float[] r2, float[] r3) {
        return evaluate2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public float[] evaluate2(float r4, float[] r5, float[] r6) {
        float[] r3 = this.mArray;
        if (r3 != null) goto L5;
        r3 = new float[r5.length];
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r3.length) goto L9;
        float r1 = r5[r0];
        r3[r0] = r1 + ((r6[r0] - r1) * r4);
        r0 = r0 + 1;
        goto L7
    L9:
        return r3;
    }
}
