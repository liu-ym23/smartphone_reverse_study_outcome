package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class TranslationAnimationCreator {

    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        public TransitionPositionListener(View r2, View r3, int r4, int r5, float r6, float r7) {
            this.mMovingView = r2;
            this.mViewInHierarchy = r3;
            this.mStartX = r4 - Math.round(r2.getTranslationX());
            this.mStartY = r5 - Math.round(r2.getTranslationY());
            this.mTerminalX = r6;
            this.mTerminalY = r7;
            int[] r8 = (int[]) r3.getTag(R.id.transition_position);
            this.mTransitionPosition = r8;
            if (r8 == null) goto L6;
            r3.setTag(R.id.transition_position, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mMovingView.getTranslationX() + this.mStartX);
            this.mTransitionPosition[1] = Math.round(this.mMovingView.getTranslationY() + this.mStartY);
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r2) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r2) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r3) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            r3.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r1) {
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    public static Animator createAnimation(@NonNull View r13, @NonNull TransitionValues r14, int r15, int r16, float r17, float r18, float r19, float r20, @Nullable TimeInterpolator r21, @NonNull Transition r22) {
        float r5 = r13.getTranslationX();
        float r6 = r13.getTranslationY();
        int[] r7 = (int[]) r14.view.getTag(R.id.transition_position);
        if (r7 == null) goto L5;
        float r8 = (r7[0] - r15) + r5;
        float r9 = (r7[1] - r16) + r6;
    L6:
        int r10 = Math.round(r8 - r5) + r15;
        int r11 = Math.round(r9 - r6) + r16;
        r13.setTranslationX(r8);
        r13.setTranslationY(r9);
        if (r8 == r19) goto L9;
    L12:
        ObjectAnimator r2 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r8, r19}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r9, r20})});
        TransitionPositionListener r3 = new TransitionPositionListener(r13, r14.view, r10, r11, r5, r6);
        r22.addListener(r3);
        r2.addListener(r3);
        AnimatorUtils.addPauseListener(r2, r3);
        r2.setInterpolator(r21);
        return r2;
    L9:
        if (r9 != r20) goto L12;
        return null;
    L5:
        r8 = r17;
        r9 = r18;
        goto L6
    }
}
