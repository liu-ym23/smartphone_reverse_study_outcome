package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        private boolean mLayerTypeChanged;
        private final View mView;

        public FadeAnimatorListener(View r2) {
            this.mLayerTypeChanged = false;
            this.mView = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            ViewUtils.setTransitionAlpha(this.mView, 1.0f);
            if (this.mLayerTypeChanged == false) goto L6;
            this.mView.setLayerType(0, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2) {
            if (ViewCompat.hasOverlappingRendering(this.mView) == true) goto L5;
            return;
        L5:
            if (this.mView.getLayerType() != 0) goto L9;
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
            return;
        }
    }

    public Fade(int r1) {
        setMode(r1);
    }

    private Animator createAnimation(final View r3, float r4, float r5) {
        if (r4 != r5) goto L6;
        return null;
    L6:
        ViewUtils.setTransitionAlpha(r3, r4);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, ViewUtils.TRANSITION_ALPHA, new float[]{r5});
        r6.addListener(new FadeAnimatorListener(r3));
        addListener(new AnonymousClass1(this, r3));
        return r6;
    }

    private static float getStartAlpha(TransitionValues r1, float r2) {
        if (r1 == null) goto L7;
        Float r3 = (Float) r1.values.get(PROPNAME_TRANSITION_ALPHA);
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.floatValue();
    L7:
        return r2;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r2) {
        super.captureStartValues(r2);
        r2.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha(r2.view)));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r2, View r3, TransitionValues r4, TransitionValues r5) {
        float r6 = 0.0f;
        float r7 = getStartAlpha(r4, 0.0f);
        if (r7 == 1.0f) goto L7;
        r6 = r7;
    L7:
        return createAnimation(r3, r6, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        ViewUtils.saveNonTransitionAlpha(r2);
        return createAnimation(r2, getStartAlpha(r3, 1.0f), 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context r4, AttributeSet r5) {
        super(r4, r5);
        TypedArray r6 = r4.obtainStyledAttributes(r5, Styleable.FADE);
        setMode(TypedArrayUtils.getNamedInt(r6, (XmlResourceParser) r5, "fadingMode", 0, getMode()));
        r6.recycle();
    }
}
