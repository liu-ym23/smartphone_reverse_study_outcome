package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private WeakReference<View> mView;

    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        public ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat r1) {
            this.mVpa = r1;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r2) {
            Object r1 = r2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r1 instanceof ViewPropertyAnimatorListener) == false) goto L5;
            ViewPropertyAnimatorListener r3 = (ViewPropertyAnimatorListener) r1;
        L6:
            if (r3 == null) goto L9;
            r3.onAnimationCancel(r2);
            return;
        L9:
            return;
        L5:
            r3 = null;
            goto L6
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View r4) {
            int r0 = this.mVpa.mOldLayerType;
            ViewPropertyAnimatorListener r1 = null;
            if (r0 <= (-1)) goto L5;
            r4.setLayerType(r0, null);
            this.mVpa.mOldLayerType = -1;
        L5:
            ViewPropertyAnimatorCompat r2 = this.mVpa;
            Runnable r3 = r2.mEndAction;
            if (r3 == null) goto L8;
            r2.mEndAction = null;
            r3.run();
        L8:
            Object r5 = r4.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r5 instanceof ViewPropertyAnimatorListener) == false) goto L11;
            r1 = (ViewPropertyAnimatorListener) r5;
        L11:
            if (r1 == null) goto L13;
            r1.onAnimationEnd(r4);
        L13:
            this.mAnimEndCalled = true;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View r4) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener r2 = null;
            if (this.mVpa.mOldLayerType <= (-1)) goto L5;
            r4.setLayerType(2, null);
        L5:
            ViewPropertyAnimatorCompat r3 = this.mVpa;
            Runnable r0 = r3.mStartAction;
            if (r0 == null) goto L8;
            r3.mStartAction = null;
            r0.run();
        L8:
            Object r5 = r4.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r5 instanceof ViewPropertyAnimatorListener) == false) goto L11;
            r2 = (ViewPropertyAnimatorListener) r5;
        L11:
            if (r2 == null) goto L14;
            r2.onAnimationStart(r4);
            return;
        }
    }

    public ViewPropertyAnimatorCompat(View r2) {
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(r2);
    }

    private void setListenerInternal(final View r3, final ViewPropertyAnimatorListener r4) {
        if (r4 == null) goto L4;
        r3.animate().setListener(new AnonymousClass1(this, r4, r3));
        return;
    L4:
        r3.animate().setListener(null);
    }

    public ViewPropertyAnimatorCompat alpha(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().alpha(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().alphaBy(r2);
    L5:
        return this;
    }

    public void cancel() {
        View r0 = this.mView.get();
        if (r0 == null) goto L6;
        r0.animate().cancel();
        return;
    }

    public long getDuration() {
        View r2 = this.mView.get();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getDuration();
    }

    public Interpolator getInterpolator() {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return (Interpolator) r0.animate().getInterpolator();
    }

    public long getStartDelay() {
        View r2 = this.mView.get();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getStartDelay();
    }

    public ViewPropertyAnimatorCompat rotation(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotation(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationX(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationXBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationY(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationYBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleX(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleXBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleY(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleYBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setDuration(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setInterpolator(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        setListenerInternal(r0, r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setStartDelay(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(final ViewPropertyAnimatorUpdateListener r3) {
        final View r0 = this.mView.get();
        if (r0 == null) goto L8;
        if (r3 == null) goto L6;
        ValueAnimator.AnimatorUpdateListener r1 = new AnonymousClass2(this, r3, r0);
    L7:
        r0.animate().setUpdateListener(r1);
        goto L8
    L6:
        r1 = null;
    L8:
        return this;
    }

    public void start() {
        View r0 = this.mView.get();
        if (r0 == null) goto L6;
        r0.animate().start();
        return;
    }

    public ViewPropertyAnimatorCompat translationX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationX(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationXBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationY(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationYBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationZ(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationZBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().withEndAction(r2);
    L5:
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().withLayer();
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().withStartAction(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat x(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().x(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().xBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat y(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().y(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().yBy(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat z(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().z(r2);
    L5:
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().zBy(r2);
    L5:
        return this;
    }
}
