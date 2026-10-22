package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    static final int LISTENER_TAG_ID = 2113929216;
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private final WeakReference<View> mView;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator r0, Runnable r1) {
            return r0.withEndAction(r1);
        }

        @DoNotInline
        static ViewPropertyAnimator withLayer(ViewPropertyAnimator r0) {
            return r0.withLayer();
        }

        @DoNotInline
        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator r0, Runnable r1) {
            return r0.withStartAction(r1);
        }
    }

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static Interpolator getInterpolator(ViewPropertyAnimator r0) {
            return (Interpolator) r0.getInterpolator();
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator r0, ValueAnimator.AnimatorUpdateListener r1) {
            return r0.setUpdateListener(r1);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator r0, float r1) {
            return r0.translationZ(r1);
        }

        @DoNotInline
        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator r0, float r1) {
            return r0.translationZBy(r1);
        }

        @DoNotInline
        static ViewPropertyAnimator z(ViewPropertyAnimator r0, float r1) {
            return r0.z(r1);
        }

        @DoNotInline
        static ViewPropertyAnimator zBy(ViewPropertyAnimator r0, float r1) {
            return r0.zBy(r1);
        }
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat r1) {
            this.mVpa = r1;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(@NonNull View r2) {
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
        public void onAnimationEnd(@NonNull View r4) {
            int r0 = this.mVpa.mOldLayerType;
            ViewPropertyAnimatorListener r2 = null;
            if (r0 <= (-1)) goto L6;
            r4.setLayerType(r0, null);
            this.mVpa.mOldLayerType = -1;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L8;
        L9:
            ViewPropertyAnimatorCompat r1 = this.mVpa;
            Runnable r3 = r1.mEndAction;
            if (r3 == null) goto L12;
            r1.mEndAction = null;
            r3.run();
        L12:
            Object r5 = r4.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
            if ((r5 instanceof ViewPropertyAnimatorListener) == false) goto L15;
            r2 = (ViewPropertyAnimatorListener) r5;
        L15:
            if (r2 == null) goto L17;
            r2.onAnimationEnd(r4);
        L17:
            this.mAnimEndCalled = true;
            return;
        L8:
            if (this.mAnimEndCalled == false) goto L9;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(@NonNull View r4) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener r1 = null;
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
            r1 = (ViewPropertyAnimatorListener) r5;
        L11:
            if (r1 == null) goto L14;
            r1.onAnimationStart(r4);
            return;
        }
    }

    ViewPropertyAnimatorCompat(View r2) {
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(r2);
    }

    static /* synthetic */ void a(ViewPropertyAnimatorUpdateListener r0, View r1, ValueAnimator r2) {
        r0.onAnimationUpdate(r1);
    }

    private void setListenerInternal(final View r3, final ViewPropertyAnimatorListener r4) {
        if (r4 == null) goto L4;
        r3.animate().setListener(new AnonymousClass1(this, r4, r3));
        return;
    L4:
        r3.animate().setListener(null);
    }

    @NonNull
    public ViewPropertyAnimatorCompat alpha(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().alpha(r2);
    L5:
        return this;
    }

    @NonNull
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

    @Nullable
    public Interpolator getInterpolator() {
        View r2 = this.mView.get();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 18) goto L7;
        return null;
    L7:
        return Api18Impl.getInterpolator(r2.animate());
    }

    public long getStartDelay() {
        View r2 = this.mView.get();
        if (r2 != null) goto L5;
        return 0;
    L5:
        return r2.animate().getStartDelay();
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotation(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotation(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationX(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationXBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationY(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat rotationYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().rotationYBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleX(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleXBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleY(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat scaleYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().scaleYBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setDuration(long r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setDuration(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setInterpolator(@Nullable Interpolator r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setInterpolator(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setListener(@Nullable ViewPropertyAnimatorListener r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L9:
        return this;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        r0.setTag(LISTENER_TAG_ID, r4);
        r4 = new ViewPropertyAnimatorListenerApi14(this);
    L8:
        setListenerInternal(r0, r4);
        goto L9
    }

    @NonNull
    public ViewPropertyAnimatorCompat setStartDelay(long r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().setStartDelay(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat setUpdateListener(@Nullable final ViewPropertyAnimatorUpdateListener r4) {
        final View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L10:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L10;
        ValueAnimator.AnimatorUpdateListener r1 = null;
        if (r4 == null) goto L9;
        r1 = new f(r4, r0);
    L9:
        Api19Impl.setUpdateListener(r0.animate(), r1);
        goto L10
    }

    public void start() {
        View r0 = this.mView.get();
        if (r0 == null) goto L6;
        r0.animate().start();
        return;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationX(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationX(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationXBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationXBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationY(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationY(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationYBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().translationYBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZ(float r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZ(r0.animate(), r4);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat translationZBy(float r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.translationZBy(r0.animate(), r4);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat withEndAction(@NonNull Runnable r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withEndAction(r0.animate(), r4);
        goto L8
    L7:
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        this.mEndAction = r4;
        goto L8
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withLayer(r0.animate());
        goto L8
    L7:
        this.mOldLayerType = r0.getLayerType();
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        goto L8
    }

    @NonNull
    public ViewPropertyAnimatorCompat withStartAction(@NonNull Runnable r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L8:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 16) goto L7;
        Api16Impl.withStartAction(r0.animate(), r4);
        goto L8
    L7:
        setListenerInternal(r0, new ViewPropertyAnimatorListenerApi14(this));
        this.mStartAction = r4;
        goto L8
    }

    @NonNull
    public ViewPropertyAnimatorCompat x(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().x(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat xBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().xBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat y(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().y(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat yBy(float r2) {
        View r0 = this.mView.get();
        if (r0 == null) goto L5;
        r0.animate().yBy(r2);
    L5:
        return this;
    }

    @NonNull
    public ViewPropertyAnimatorCompat z(float r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.z(r0.animate(), r4);
        goto L7
    }

    @NonNull
    public ViewPropertyAnimatorCompat zBy(float r4) {
        View r0 = this.mView.get();
        if (r0 != null) goto L5;
    L7:
        return this;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        Api21Impl.zBy(r0.animate(), r4);
        goto L7
    }
}
