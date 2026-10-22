package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation r2) {
            this.animation = r2;
            this.animator = null;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }

        AnimationOrAnimator(Animator r2) {
            this.animation = null;
            this.animator = r2;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation r2, ViewGroup r3, View r4) {
            super(false);
            this.mAnimating = true;
            this.mParent = r3;
            this.mChild = r4;
            addAnimation(r2);
            r3.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r3, Transformation r5, float r6) {
            this.mAnimating = true;
            if (this.mEnded == false) goto L7;
            return !this.mTransitionEnded;
        L7:
            if (super.getTransformation(r3, r5, r6) == true) goto L9;
            this.mEnded = true;
            OneShotPreDrawListener.add(this.mParent, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded == false) goto L5;
        L7:
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
            return;
        L5:
            if (this.mAnimating == false) goto L7;
            this.mAnimating = false;
            this.mParent.post(this);
        }
    }

    private FragmentAnim() {
    }

    static AnimationOrAnimator loadAnimation(Context r5, Fragment r6, boolean r7, boolean r8) {
        int r0 = r6.getNextTransition();
        int r9 = getNextAnim(r6, r7, r8);
        boolean r1 = false;
        r6.setAnimations(0, 0, 0, 0);
        if (r6.mContainer == null) goto L8;
        if (r6.mContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) goto L8;
        r6.mContainer.setTag(R.id.visible_removing_fragment_view_tag, null);
    L8:
        if (r6.mContainer != null) goto L10;
    L12:
        Animation r2 = r6.onCreateAnimation(r0, r7, r9);
        if (r2 != null) goto L15;
        Animator r10 = r6.onCreateAnimator(r0, r7, r9);
        if (r10 != null) goto L19;
        if (r9 != 0) goto L23;
        if (r0 == 0) goto L23;
        r9 = transitToAnimResourceId(r5, r0, r7);
    L23:
        if (r9 == 0) goto L45;
        boolean r11 = "anim".equals(r5.getResources().getResourceTypeName(r9));
        if (r11 == true) goto L49;
    L33:
        if (r1 == true) goto L45;
        Animator r12 = AnimatorInflater.loadAnimator(r5, r9);     // Catch: RuntimeException -> L38
        if (r12 == null) goto L45;
        return new AnimationOrAnimator(r12);
    L38:
        e = move-exception;
        if (r11 == true) goto L44;
        Animation r13 = AnimationUtils.loadAnimation(r5, r9);
        if (r13 == null) goto L45;
        return new AnimationOrAnimator(r13);
    L44:
        throw e;
    L49:
        Animation r14 = AnimationUtils.loadAnimation(r5, r9);     // Catch: Resources.NotFoundException -> L31 RuntimeException -> L46
        if (r14 == null) goto L30;
        return new AnimationOrAnimator(r14);
        goto L33
    L30:
        r1 = true;
    L31:
        e = move-exception;
        throw e;
    L45:
        return null;
    L19:
        return new AnimationOrAnimator(r10);
    L15:
        return new AnimationOrAnimator(r2);
    L10:
        if (r6.mContainer.getLayoutTransition() == null) goto L12;
        return null;
    }

    private static int getNextAnim(Fragment r0, boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (r1 == false) goto L7;
        return r0.getPopEnterAnim();
    L7:
        return r0.getPopExitAnim();
    L8:
        if (r1 == false) goto L12;
        return r0.getEnterAnim();
    L12:
        return r0.getExitAnim();
    }

    private static int transitToAnimResourceId(Context r1, int r2, boolean r3) {
        if (r2 != 4097) goto L5;
        if (r3 == false) goto L28;
        return R.animator.fragment_open_enter;
    L28:
        return R.animator.fragment_open_exit;
    L5:
        if (r2 != 8194) goto L7;
        if (r3 == false) goto L37;
        return R.animator.fragment_close_enter;
    L37:
        return R.animator.fragment_close_exit;
    L7:
        if (r2 != 8197) goto L9;
        if (r3 == false) goto L35;
        return toActivityTransitResId(r1, android.R.attr.activityCloseEnterAnimation);
    L35:
        return toActivityTransitResId(r1, android.R.attr.activityCloseExitAnimation);
    L9:
        if (r2 != 4099) goto L11;
        if (r3 == false) goto L33;
        return R.animator.fragment_fade_enter;
    L33:
        return R.animator.fragment_fade_exit;
    L11:
        if (r2 == 4100) goto L13;
        return -1;
    L13:
        if (r3 == false) goto L31;
        return toActivityTransitResId(r1, android.R.attr.activityOpenEnterAnimation);
    L31:
        return toActivityTransitResId(r1, android.R.attr.activityOpenExitAnimation);
    }

    private static int toActivityTransitResId(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{r3});
        int r5 = r4.getResourceId(0, -1);
        r4.recycle();
        return r5;
    }
}
