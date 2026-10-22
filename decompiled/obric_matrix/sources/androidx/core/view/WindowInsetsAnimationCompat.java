package androidx.core.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public static final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds r2) {
            this.mLowerBound = Impl30.getLowerBounds(r2);
            this.mUpperBound = Impl30.getHigherBounds(r2);
        }

        public BoundsCompat(@NonNull Insets r1, @NonNull Insets r2) {
            this.mLowerBound = r1;
            this.mUpperBound = r2;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds r1) {
            return new BoundsCompat(r1);
        }

        @NonNull
        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        @NonNull
        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets r7) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, r7.left, r7.top, r7.right, r7.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, r7.left, r7.top, r7.right, r7.bottom));
        }

        @NonNull
        @RequiresApi(30)
        public WindowInsetsAnimation.Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }
    }

    public static abstract class Callback {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface DispatchMode {
        }

        public Callback(int r1) {
            this.mDispatchMode = r1;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat r1) {
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat r1) {
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat r1, @NonNull List<WindowInsetsAnimationCompat> r2);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat r1, @NonNull BoundsCompat r2) {
            return r2;
        }
    }

    private static class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;

        @Nullable
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        Impl(int r1, @Nullable Interpolator r2, long r3) {
            this.mTypeMask = r1;
            this.mInterpolator = r2;
            this.mDurationMillis = r3;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            Interpolator r0 = this.mInterpolator;
            float r1 = this.mFraction;
            if (r0 != null) goto L5;
            return r1;
        L5:
            return r0.getInterpolation(r1);
        }

        @Nullable
        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float r1) {
            this.mAlpha = r1;
        }

        public void setFraction(float r1) {
            this.mFraction = r1;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl {

        @RequiresApi(21)
        private static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION = 160;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            Impl21OnApplyWindowInsetsListener(@NonNull View r1, @NonNull Callback r2) {
                this.mCallback = r2;
                WindowInsetsCompat r3 = ViewCompat.getRootWindowInsets(r1);
                if (r3 == null) goto L5;
                WindowInsetsCompat r4 = new WindowInsetsCompat.Builder(r3).build();
            L6:
                this.mLastInsets = r4;
                return;
            L5:
                r4 = null;
                goto L6
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(final View r16, WindowInsets r17) {
                if (r16.isLaidOut() == true) goto L7;
                this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
            L6:
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L7:
                final WindowInsetsCompat r10 = WindowInsetsCompat.toWindowInsetsCompat(r17, r16);
                if (this.mLastInsets != null) goto L11;
                this.mLastInsets = ViewCompat.getRootWindowInsets(r16);
            L11:
                if (this.mLastInsets != null) goto L13;
            L12:
                this.mLastInsets = r10;
                goto L6
            L13:
                Callback r0 = Impl21.getCallback(r16);
                if (r0 != null) goto L16;
            L19:
                final int r5 = Impl21.buildAnimationMask(r10, this.mLastInsets);
                if (r5 == 0) goto L22;
                final WindowInsetsCompat r4 = this.mLastInsets;
                final WindowInsetsAnimationCompat r11 = new WindowInsetsAnimationCompat(r5, new DecelerateInterpolator(), 160);
                r11.setFraction(0.0f);
                final ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(r11.getDurationMillis());
                final BoundsCompat r13 = Impl21.computeAnimationBounds(r10, r4, r5);
                Impl21.dispatchOnPrepare(r16, r11, r17, false);
                r12.addUpdateListener(new AnonymousClass1(this, r11, r10, r4, r5, r16));
                r12.addListener(new AnonymousClass2(this, r11, r16));
                OneShotPreDrawListener.add(r16, new AnonymousClass3(this, r16, r11, r13, r12));
                goto L12
            L22:
                return Impl21.forwardToViewIfNeeded(r16, r17);
            L16:
                if (Objects.equals(r0.mDispachedInsets, r17) == false) goto L19;
                return Impl21.forwardToViewIfNeeded(r16, r17);
            }
        }

        Impl21(int r1, @Nullable Interpolator r2, long r3) {
            super(r1, r2, r3);
        }

        @SuppressLint({"WrongConstant"})
        static int buildAnimationMask(@NonNull WindowInsetsCompat r4, @NonNull WindowInsetsCompat r5) {
            int r0 = 1;
            int r1 = 0;
        L4:
            if (r0 > 256) goto L9;
            if (r4.getInsets(r0).equals(r5.getInsets(r0)) == true) goto L8;
            r1 = r1 | r0;
        L8:
            r0 = r0 << 1;
            goto L4
        L9:
            return r1;
        }

        @NonNull
        static BoundsCompat computeAnimationBounds(@NonNull WindowInsetsCompat r4, @NonNull WindowInsetsCompat r5, int r6) {
            Insets r7 = r4.getInsets(r6);
            Insets r8 = r5.getInsets(r6);
            return new BoundsCompat(Insets.of(Math.min(r7.left, r8.left), Math.min(r7.top, r8.top), Math.min(r7.right, r8.right), Math.min(r7.bottom, r8.bottom)), Insets.of(Math.max(r7.left, r8.left), Math.max(r7.top, r8.top), Math.max(r7.right, r8.right), Math.max(r7.bottom, r8.bottom)));
        }

        @NonNull
        private static View.OnApplyWindowInsetsListener createProxyListener(@NonNull View r1, @NonNull Callback r2) {
            return new Impl21OnApplyWindowInsetsListener(r1, r2);
        }

        static void dispatchOnEnd(@NonNull View r2, @NonNull WindowInsetsAnimationCompat r3) {
            Callback r0 = getCallback(r2);
            if (r0 == null) goto L8;
            r0.onEnd(r3);
            if (r0.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r2 instanceof ViewGroup) == false) goto L13;
            ViewGroup r4 = (ViewGroup) r2;
            int r1 = 0;
        L11:
            if (r1 >= r4.getChildCount()) goto L15;
            dispatchOnEnd(r4.getChildAt(r1), r3);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        static void dispatchOnPrepare(View r2, WindowInsetsAnimationCompat r3, WindowInsets r4, boolean r5) {
            Callback r0 = getCallback(r2);
            int r1 = 0;
            if (r0 == null) goto L11;
            r0.mDispachedInsets = r4;
            if (r5 == true) goto L11;
            r0.onPrepare(r3);
            if (r0.getDispatchMode() != 0) goto L9;
            r5 = true;
            goto L11
        L9:
            r5 = false;
        L11:
            if ((r2 instanceof ViewGroup) == false) goto L16;
            ViewGroup r6 = (ViewGroup) r2;
        L14:
            if (r1 >= r6.getChildCount()) goto L18;
            dispatchOnPrepare(r6.getChildAt(r1), r3, r4, r5);
            r1 = r1 + 1;
            goto L14
        L18:
            return;
        }

        static void dispatchOnProgress(@NonNull View r2, @NonNull WindowInsetsCompat r3, @NonNull List<WindowInsetsAnimationCompat> r4) {
            Callback r0 = getCallback(r2);
            if (r0 == null) goto L8;
            r3 = r0.onProgress(r3, r4);
            if (r0.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r2 instanceof ViewGroup) == false) goto L13;
            ViewGroup r5 = (ViewGroup) r2;
            int r1 = 0;
        L11:
            if (r1 >= r5.getChildCount()) goto L15;
            dispatchOnProgress(r5.getChildAt(r1), r3, r4);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        static void dispatchOnStart(View r2, WindowInsetsAnimationCompat r3, BoundsCompat r4) {
            Callback r0 = getCallback(r2);
            if (r0 == null) goto L8;
            r0.onStart(r3, r4);
            if (r0.getDispatchMode() != 0) goto L8;
            return;
        L8:
            if ((r2 instanceof ViewGroup) == false) goto L13;
            ViewGroup r5 = (ViewGroup) r2;
            int r1 = 0;
        L11:
            if (r1 >= r5.getChildCount()) goto L15;
            dispatchOnStart(r5.getChildAt(r1), r3, r4);
            r1 = r1 + 1;
            goto L11
        L15:
            return;
        }

        @NonNull
        static WindowInsets forwardToViewIfNeeded(@NonNull View r1, @NonNull WindowInsets r2) {
            if (r1.getTag(R.id.tag_on_apply_window_listener) == null) goto L6;
            return r2;
        L6:
            return r1.onApplyWindowInsets(r2);
        }

        @Nullable
        static Callback getCallback(View r1) {
            Object r2 = r1.getTag(R.id.tag_window_insets_animation_callback);
            if ((r2 instanceof Impl21OnApplyWindowInsetsListener) == true) goto L7;
            return null;
        L7:
            return ((Impl21OnApplyWindowInsetsListener) r2).mCallback;
        }

        @SuppressLint({"WrongConstant"})
        static WindowInsetsCompat interpolateInsets(WindowInsetsCompat r12, WindowInsetsCompat r13, float r14, int r15) {
            WindowInsetsCompat.Builder r0 = new WindowInsetsCompat.Builder(r12);
            int r1 = 1;
        L4:
            if (r1 > 256) goto L11;
            if ((r15 & r1) != 0) goto L8;
            Insets r2 = r12.getInsets(r1);
        L9:
            r0.setInsets(r1, r2);
            r1 = r1 << 1;
            goto L4
        L8:
            Insets r3 = r12.getInsets(r1);
            Insets r4 = r13.getInsets(r1);
            float r5 = 1.0f - r14;
            r2 = WindowInsetsCompat.insetInsets(r3, (int) (((double) ((r3.left - r4.left) * r5)) + 0.5d), (int) (((double) ((r3.top - r4.top) * r5)) + 0.5d), (int) (((double) ((r3.right - r4.right) * r5)) + 0.5d), (int) (((double) ((r3.bottom - r4.bottom) * r5)) + 0.5d));
            goto L9
        L11:
            return r0.build();
        }

        static void setCallback(@NonNull View r2, @Nullable Callback r3) {
            Object r0 = r2.getTag(R.id.tag_on_apply_window_listener);
            if (r3 != null) goto L7;
            r2.setTag(R.id.tag_window_insets_animation_callback, null);
            if (r0 != null) goto L11;
            r2.setOnApplyWindowInsetsListener(null);
            return;
        L11:
            return;
        L7:
            View.OnApplyWindowInsetsListener r4 = createProxyListener(r2, r3);
            r2.setTag(R.id.tag_window_insets_animation_callback, r4);
            if (r0 != null) goto L13;
            r2.setOnApplyWindowInsetsListener(r4);
            return;
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {

        @NonNull
        private final WindowInsetsAnimation mWrapped;

        @RequiresApi(30)
        private static class ProxyCallback extends WindowInsetsAnimation.Callback {
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            private final Callback mCompat;
            private List<WindowInsetsAnimationCompat> mRORunningAnimations;
            private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            ProxyCallback(@NonNull Callback r2) {
                super(r2.getDispatchMode());
                this.mAnimations = new HashMap();
                this.mCompat = r2;
            }

            @NonNull
            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r2) {
                WindowInsetsAnimationCompat r0 = this.mAnimations.get(r2);
                if (r0 != null) goto L6;
                WindowInsetsAnimationCompat r1 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(r2);
                this.mAnimations.put(r2, r1);
                return r1;
            L6:
                return r0;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@NonNull WindowInsetsAnimation r3) {
                this.mCompat.onEnd(getWindowInsetsAnimationCompat(r3));
                this.mAnimations.remove(r3);
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@NonNull WindowInsetsAnimation r2) {
                this.mCompat.onPrepare(getWindowInsetsAnimationCompat(r2));
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets r4, @NonNull List<WindowInsetsAnimation> r5) {
                ArrayList<WindowInsetsAnimationCompat> r0 = this.mTmpRunningAnimations;
                if (r0 != null) goto L5;
                ArrayList<WindowInsetsAnimationCompat> r1 = new ArrayList(r5.size());
                this.mTmpRunningAnimations = r1;
                this.mRORunningAnimations = Collections.unmodifiableList(r1);
            L6:
                int r2 = r5.size() - 1;
            L7:
                if (r2 < 0) goto L10;
                WindowInsetsAnimation r3 = r5.get(r2);
                WindowInsetsAnimationCompat r6 = getWindowInsetsAnimationCompat(r3);
                r6.setFraction(r3.getFraction());
                this.mTmpRunningAnimations.add(r6);
                r2 = r2 - 1;
                goto L7
            L10:
                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(r4), this.mRORunningAnimations).toWindowInsets();
            L5:
                r0.clear();
                goto L6
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation r2, @NonNull WindowInsetsAnimation.Bounds r3) {
                return this.mCompat.onStart(getWindowInsetsAnimationCompat(r2), BoundsCompat.toBoundsCompat(r3)).toBounds();
            }
        }

        Impl30(int r2, Interpolator r3, long r4) {
            this(new WindowInsetsAnimation(r2, r3, r4));
        }

        Impl30(@NonNull WindowInsetsAnimation r5) {
            super(0, null, 0);
            this.mWrapped = r5;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds createPlatformBounds(@NonNull BoundsCompat r2) {
            return new WindowInsetsAnimation.Bounds(r2.getLowerBound().toPlatformInsets(), r2.getUpperBound().toPlatformInsets());
        }

        @NonNull
        public static Insets getHigherBounds(@NonNull WindowInsetsAnimation.Bounds r0) {
            return Insets.toCompatInsets(r0.getUpperBound());
        }

        @NonNull
        public static Insets getLowerBounds(@NonNull WindowInsetsAnimation.Bounds r0) {
            return Insets.toCompatInsets(r0.getLowerBound());
        }

        public static void setCallback(@NonNull View r1, @Nullable Callback r2) {
            if (r2 == null) goto L4;
            ProxyCallback r0 = new ProxyCallback(r2);
        L5:
            r1.setWindowInsetsAnimationCallback(r0);
            return;
        L4:
            r0 = null;
            goto L5
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        @Nullable
        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float r1) {
            this.mWrapped.setFraction(r1);
        }
    }

    public WindowInsetsAnimationCompat(int r3, @Nullable Interpolator r4, long r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        Impl r1 = new Impl30(r3, r4, r5);
    L5:
        this.mImpl = r1;
        return;
    L7:
        if (r0 < 21) goto L9;
        r1 = new Impl21(r3, r4, r5);
        goto L5
    L9:
        this.mImpl = new Impl(0, r4, r5);
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation r5) {
        this(0, null, 0);
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.mImpl = new Impl30(r5);
        return;
    }

    static void setCallback(@NonNull View r2, @Nullable Callback r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L6;
        Impl30.setCallback(r2, r3);
        return;
    L6:
        if (r0 < 21) goto L10;
        Impl21.setCallback(r2, r3);
        return;
    }

    @RequiresApi(30)
    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation r1) {
        return new WindowInsetsAnimationCompat(r1);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float r1) {
        this.mImpl.setAlpha(r1);
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float r1) {
        this.mImpl.setFraction(r1);
    }
}
