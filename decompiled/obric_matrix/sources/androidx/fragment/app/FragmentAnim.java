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
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;

/* JADX INFO: loaded from: classes.dex */
class FragmentAnim {

    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animator r2) {
            this.animation = null;
            this.animator = r2;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }

        AnimationOrAnimator(Animation r2) {
            this.animation = r2;
            this.animator = null;
            if (r2 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(@NonNull Animation r2, @NonNull ViewGroup r3, @NonNull View r4) {
            super(false);
            this.mAnimating = true;
            this.mParent = r3;
            this.mChild = r4;
            addAnimation(r2);
            r3.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r3, @NonNull Transformation r5) {
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
        public boolean getTransformation(long r3, @NonNull Transformation r5, float r6) {
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

    @AnimRes
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

    static AnimationOrAnimator loadAnimation(@NonNull Context r5, @NonNull Fragment r6, boolean r7, boolean r8) {
        int r0 = r6.getNextTransition();
        int r9 = getNextAnim(r6, r7, r8);
        boolean r1 = false;
        r6.setAnimations(0, 0, 0, 0);
        ViewGroup r2 = r6.mContainer;
        if (r2 == null) goto L7;
        int r4 = R.id.visible_removing_fragment_view_tag;
        if (r2.getTag(r4) == null) goto L7;
        r6.mContainer.setTag(r4, null);
    L7:
        ViewGroup r3 = r6.mContainer;
        if (r3 != null) goto L10;
    L12:
        Animation r10 = r6.onCreateAnimation(r0, r7, r9);
        if (r10 != null) goto L15;
        Animator r11 = r6.onCreateAnimator(r0, r7, r9);
        if (r11 != null) goto L19;
        if (r9 != 0) goto L23;
        if (r0 == 0) goto L23;
        r9 = transitToAnimResourceId(r5, r0, r7);
    L23:
        if (r9 == 0) goto L45;
        boolean r12 = "anim".equals(r5.getResources().getResourceTypeName(r9));
        if (r12 == true) goto L49;
    L33:
        if (r1 == true) goto L45;
        Animator r13 = AnimatorInflater.loadAnimator(r5, r9);     // Catch: RuntimeException -> L38
        if (r13 == null) goto L45;
        return new AnimationOrAnimator(r13);
    L38:
        e = move-exception;
        if (r12 == true) goto L44;
        Animation r14 = AnimationUtils.loadAnimation(r5, r9);
        if (r14 == null) goto L45;
        return new AnimationOrAnimator(r14);
    L44:
        throw e;
    L49:
        Animation r15 = AnimationUtils.loadAnimation(r5, r9);     // Catch: Resources.NotFoundException -> L31 RuntimeException -> L46
        if (r15 == null) goto L30;
        return new AnimationOrAnimator(r15);
        goto L33
    L30:
        r1 = true;
    L31:
        e = move-exception;
        throw e;
    L45:
        return null;
    L19:
        return new AnimationOrAnimator(r11);
    L15:
        return new AnimationOrAnimator(r10);
    L10:
        if (r3.getLayoutTransition() == null) goto L12;
        return null;
    }

    @AnimRes
    private static int toActivityTransitResId(@NonNull Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(android.R.style.Animation.Activity, new int[]{r3});
        int r5 = r4.getResourceId(0, -1);
        r4.recycle();
        return r5;
    }

    @AnimRes
    private static int transitToAnimResourceId(@NonNull Context r1, int r2, boolean r3) {
        if (r2 != 4097) goto L5;
        if (r3 == false) goto L29;
        return R.animator.fragment_open_enter;
    L29:
        return R.animator.fragment_open_exit;
    L5:
        if (r2 != 8194) goto L7;
        if (r3 == false) goto L35;
        return R.animator.fragment_close_enter;
    L35:
        return R.animator.fragment_close_exit;
    L7:
        if (r2 != 8197) goto L9;
        if (r3 == false) goto L22;
        int r4 = android.R.attr.activityCloseEnterAnimation;
    L31:
        return toActivityTransitResId(r1, r4);
    L22:
        r4 = android.R.attr.activityCloseExitAnimation;
        goto L31
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
        if (r3 == false) goto L15;
        r4 = android.R.attr.activityOpenEnterAnimation;
        goto L31
    L15:
        r4 = android.R.attr.activityOpenExitAnimation;
        goto L31
    }
}
