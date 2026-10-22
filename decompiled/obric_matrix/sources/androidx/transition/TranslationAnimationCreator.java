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

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View r2, View r3, int r4, int r5, float r6, float r7) {
            this.mMovingView = r2;
            this.mViewInHierarchy = r3;
            this.mStartX = r4 - Math.round(r2.getTranslationX());
            this.mStartY = r5 - Math.round(r2.getTranslationY());
            this.mTerminalX = r6;
            this.mTerminalY = r7;
            int r8 = R.id.transition_position;
            int[] r9 = (int[]) r3.getTag(r8);
            this.mTransitionPosition = r9;
            if (r9 == null) goto L6;
            r3.setTag(r8, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r4) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
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
    static Animator createAnimation(@NonNull View r14, @NonNull TransitionValues r15, int r16, int r17, float r18, float r19, float r20, float r21, @Nullable TimeInterpolator r22, @NonNull Transition r23) {
        float r2 = r14.getTranslationX();
        float r3 = r14.getTranslationY();
        int[] r4 = (int[]) r15.view.getTag(R.id.transition_position);
        if (r4 == null) goto L5;
        float r7 = (r4[0] - r16) + r2;
        float r5 = (r4[1] - r17) + r3;
    L6:
        int r8 = r16 + Math.round(r7 - r2);
        int r9 = r17 + Math.round(r5 - r3);
        r14.setTranslationX(r7);
        r14.setTranslationY(r5);
        if (r7 == r20) goto L9;
    L12:
        ObjectAnimator r6 = ObjectAnimator.ofPropertyValuesHolder(r14, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r7, r20}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r5, r21})});
        TransitionPositionListener r10 = new TransitionPositionListener(r14, r15.view, r8, r9, r2, r3);
        r23.addListener(r10);
        r6.addListener(r10);
        AnimatorUtils.addPauseListener(r6, r10);
        r6.setInterpolator(r22);
        return r6;
    L9:
        if (r5 != r21) goto L12;
        return null;
    L5:
        r7 = r18;
        r5 = r19;
        goto L6
    }
}
