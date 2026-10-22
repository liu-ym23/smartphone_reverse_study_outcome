package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ Rect evaluate(float r1, Rect r2, Rect r3) {
        return evaluate2(r1, r2, r3);
    }

    public RectEvaluator(Rect r1) {
        this.mRect = r1;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public Rect evaluate2(float r5, Rect r6, Rect r7) {
        int r0 = r6.left;
        int r1 = r0 + ((int) ((r7.left - r0) * r5));
        int r2 = r6.top;
        int r3 = r2 + ((int) ((r7.top - r2) * r5));
        int r4 = r6.right;
        int r8 = r4 + ((int) ((r7.right - r4) * r5));
        int r9 = r6.bottom;
        int r10 = r9 + ((int) ((r7.bottom - r9) * r5));
        Rect r11 = this.mRect;
        if (r11 == null) goto L5;
        r11.set(r1, r3, r8, r10);
        return this.mRect;
    L5:
        return new Rect(r1, r3, r8, r10);
    }
}
