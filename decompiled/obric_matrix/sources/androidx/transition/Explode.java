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
import androidx.annotation.Nullable;

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

    public Explode(@NonNull Context r1, @NonNull AttributeSet r2) {
        super(r1, r2);
        this.mTempLoc = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float calculateDistance(float r0, float r1) {
        return (float) Math.sqrt((r0 * r0) + (r1 * r1));
    }

    private static float calculateMaxDistance(View r1, int r2, int r3) {
        return calculateDistance(Math.max(r2, r1.getWidth() - r2), Math.max(r3, r1.getHeight() - r3));
    }

    private void calculateOut(View r13, Rect r14, int[] r15) {
        r13.getLocationOnScreen(this.mTempLoc);
        int[] r0 = this.mTempLoc;
        int r2 = r0[0];
        int r1 = r0[1];
        Rect r12 = getEpicenter();
        if (r12 != null) goto L5;
        int r16 = ((r13.getWidth() / 2) + r2) + Math.round(r13.getTranslationX());
        int r4 = ((r13.getHeight() / 2) + r1) + Math.round(r13.getTranslationY());
    L6:
        float r5 = r14.centerX() - r16;
        float r17 = r14.centerY() - r4;
        if (r5 == 0.0f) goto L9;
    L11:
        float r6 = calculateDistance(r5, r17);
        float r18 = calculateMaxDistance(r13, r16 - r2, r4 - r1);
        r15[0] = Math.round((r5 / r6) * r18);
        r15[1] = Math.round(r18 * (r17 / r6));
        return;
    L9:
        if (r17 != 0.0f) goto L11;
        r5 = ((float) (Math.random() * 2.0d)) - 1.0f;
        r17 = ((float) (Math.random() * 2.0d)) - 1.0f;
        goto L11
    L5:
        int r7 = r12.centerX();
        r4 = r12.centerY();
        r16 = r7;
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
    @Nullable
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
    @Nullable
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
        float r7 = (r0[0] - r15.left) + r4;
        float r8 = (r0[1] - r15.top) + r5;
        r15.offsetTo(r0[0], r0[1]);
    L9:
        calculateOut(r11, r15, this.mTempLoc);
        int[] r16 = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation(r12, r13, r2, r3, r4, r5, r7 + r16[0], r8 + r16[1], sAccelerate, this);
    L8:
        r7 = r4;
        r8 = r5;
        goto L9
    }
}
