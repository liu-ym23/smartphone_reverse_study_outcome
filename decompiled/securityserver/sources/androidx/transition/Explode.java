package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate = null;
    private static final TimeInterpolator sDecelerate = null;
    private int[] mTempLoc;

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float r0, float r1) {
        return (float) Math.sqrt((r1 * r1) + (r0 * r0));
    }

    private static float calculateMaxDistance(View r1, int r2, int r3) {
        return calculateDistance(Math.max(r2, r1.getWidth() - r2), Math.max(r3, r1.getHeight() - r3));
    }

    private void calculateOut(View r11, Rect r12, int[] r13) {
        r11.getLocationOnScreen(this.mTempLoc);
        int[] r0 = this.mTempLoc;
        int r2 = r0[0];
        int r1 = r0[1];
        Rect r10 = getEpicenter();
        if (r10 != null) goto L5;
        int r4 = Math.round(r11.getTranslationX()) + ((r11.getWidth() / 2) + r2);
        int r5 = Math.round(r11.getTranslationY()) + ((r11.getHeight() / 2) + r1);
    L6:
        float r14 = r12.centerX() - r4;
        float r15 = r12.centerY() - r5;
        if (r14 == 0.0f) goto L9;
    L11:
        float r6 = calculateDistance(r14, r15);
        float r16 = calculateMaxDistance(r11, r4 - r2, r5 - r1);
        r13[0] = Math.round((r14 / r6) * r16);
        r13[1] = Math.round(r16 * (r15 / r6));
        return;
    L9:
        if (r15 != 0.0f) goto L11;
        r14 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r15 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        r4 = r10.centerX();
        r5 = r10.centerY();
        goto L6
    }

    private void captureValues(TransitionValues r5) {
        View r0 = r5.view;
        r0.getLocationOnScreen(this.mTempLoc);
        int[] r4 = this.mTempLoc;
        int r1 = r4[0];
        int r6 = r4[1];
        int r2 = r0.getWidth() + r1;
        int r3 = r0.getHeight() + r6;
        r5.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(r1, r6, r2, r3));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r1) {
        super.captureEndValues(r1);
        captureValues(r1);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r1) {
        super.captureStartValues(r1);
        captureValues(r1);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r14.values.get(PROPNAME_SCREEN_BOUNDS);
        float r6 = r12.getTranslationX();
        float r7 = r12.getTranslationY();
        calculateOut(r11, r15, this.mTempLoc);
        int[] r16 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r14, r15.left, r15.top, r6 + r16[0], r7 + r16[1], r6, r7, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r11, View r12, TransitionValues r13, TransitionValues r14) {
        if (r13 != null) goto L5;
        return null;
    L5:
        Rect r15 = (Rect) r13.values.get(PROPNAME_SCREEN_BOUNDS);
        int r2 = r15.left;
        int r3 = r15.top;
        float r4 = r12.getTranslationX();
        float r5 = r12.getTranslationY();
        int[] r0 = (int[]) r13.view.getTag(R.id.transition_position);
        if (r0 == null) goto L8;
        int r7 = r0[0];
        float r8 = (r7 - r15.left) + r4;
        int r1 = r0[1];
        float r9 = (r1 - r15.top) + r5;
        r15.offsetTo(r7, r1);
    L9:
        calculateOut(r11, r15, this.mTempLoc);
        int[] r16 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r13, r2, r3, r4, r5, r8 + r16[0], r9 + r16[1], sAccelerate, this);
    L8:
        r8 = r4;
        r9 = r5;
        goto L9
    }

    public Explode(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }
}
