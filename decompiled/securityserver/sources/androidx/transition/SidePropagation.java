package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed;
    private int mSide;

    public SidePropagation() {
        this.mPropagationSpeed = 3.0f;
        this.mSide = 80;
    }

    private int distance(View r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13) {
        int r4 = this.mSide;
        if (r4 != 8388611) goto L9;
        if (ViewCompat.getLayoutDirection(r5) != 1) goto L7;
    L6:
        r4 = 5;
    L13:
        if (r4 == 3) goto L24;
        if (r4 == 5) goto L28;
        if (r4 == 48) goto L27;
        if (r4 == 80) goto L26;
        return 0;
    L26:
        return Math.abs(r8 - r6) + (r7 - r11);
    L27:
        return Math.abs(r8 - r6) + (r13 - r7);
    L28:
        return Math.abs(r9 - r7) + (r6 - r10);
    L24:
        return Math.abs(r9 - r7) + (r12 - r6);
    L7:
        r4 = 3;
        goto L13
    L9:
        if (r4 != 8388613) goto L13;
        if (ViewCompat.getLayoutDirection(r5) != 1) goto L6;
        goto L6
    }

    private int getMaxDistance(ViewGroup r2) {
        int r1 = this.mSide;
        if (r1 == 3) goto L13;
        if (r1 == 5) goto L13;
        if (r1 == 8388611) goto L13;
        if (r1 == 8388613) goto L13;
        return r2.getHeight();
    L13:
        return r2.getWidth();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup r17, Transition r18, TransitionValues r19, TransitionValues r20) {
        TransitionValues r0 = r19;
        if (r0 != null) goto L6;
        if (r20 != null) goto L6;
        return 0;
    L6:
        Rect r1 = r18.getEpicenter();
        if (r20 != null) goto L9;
    L12:
        int r13 = -1;
    L13:
        int r3 = getViewX(r0);
        int r4 = getViewY(r0);
        int[] r5 = new int[2];
        r17.getLocationOnScreen(r5);
        int r6 = r5[0] + Math.round(r17.getTranslationX());
        int r7 = Math.round(r17.getTranslationY()) + r5[1];
        int r8 = r17.getWidth() + r6;
        int r9 = r17.getHeight() + r7;
        if (r1 == null) goto L16;
        int r10 = r1.centerX();
        int r15 = r1.centerY();
    L17:
        float r2 = distance(r17, r3, r4, r10, r15, r6, r7, r8, r9) / getMaxDistance(r17);
        long r11 = r18.getDuration();
        if (r11 >= 0) goto L21;
        r11 = 300;
    L21:
        return Math.round(((r11 * ((long) r13)) / this.mPropagationSpeed) * r2);
    L16:
        r10 = (r6 + r8) / 2;
        r15 = (r7 + r9) / 2;
        goto L17
    L9:
        if (getViewVisibility(r0) == 0) goto L12;
        r0 = r20;
        r13 = 1;
        goto L13
    }

    public void setPropagationSpeed(float r2) {
        if (r2 == 0.0f) goto L7;
        this.mPropagationSpeed = r2;
        return;
    L7:
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void setSide(int r1) {
        this.mSide = r1;
    }
}
