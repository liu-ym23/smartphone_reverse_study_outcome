package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal;
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
        r9 = transitToAnimResourceId(r0, r7);
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

    static void animateRemoveFragment(final Fragment r7, AnimationOrAnimator r8, final FragmentTransition.Callback r9) {
        final View r2 = r7.mView;
        final ViewGroup r1 = r7.mContainer;
        r1.startViewTransition(r2);
        final CancellationSignal r5 = new CancellationSignal();
        r5.setOnCancelListener(new AnonymousClass1(r7));
        r9.onStart(r7, r5);
        if (r8.animation == null) goto L5;
        EndViewTransitionAnimation r0 = new EndViewTransitionAnimation(r8.animation, r1, r2);
        r7.setAnimatingAway(r7.mView);
        r0.setAnimationListener(new AnonymousClass2(r1, r7, r9, r5));
        r7.mView.startAnimation(r0);
        return;
    L5:
        Animator r6 = r8.animator;
        r7.setAnimator(r8.animator);
        r6.addListener(new AnonymousClass3(r1, r2, r7, r9, r5));
        r6.setTarget(r7.mView);
        r6.start();
    }

    private static int transitToAnimResourceId(int r1, boolean r2) {
        if (r1 != 4097) goto L5;
        if (r2 == false) goto L18;
        return R.animator.fragment_open_enter;
    L18:
        return R.animator.fragment_open_exit;
    L5:
        if (r1 != 4099) goto L7;
        if (r2 == false) goto L23;
        return R.animator.fragment_fade_enter;
    L23:
        return R.animator.fragment_fade_exit;
    L7:
        if (r1 == 8194) goto L9;
        return -1;
    L9:
        if (r2 == false) goto L21;
        return R.animator.fragment_close_enter;
    L21:
        return R.animator.fragment_close_exit;
    }
}
