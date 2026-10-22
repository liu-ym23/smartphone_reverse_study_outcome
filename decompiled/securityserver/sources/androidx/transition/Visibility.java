package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = null;
    private int mMode;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        public DisappearListener(View r2, int r3, boolean r4) {
            this.mCanceled = false;
            this.mView = r2;
            this.mFinalVisibility = r3;
            this.mParent = (ViewGroup) r2.getParent();
            this.mSuppressLayout = r4;
            suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if (this.mCanceled == true) goto L7;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L7;
            r0.invalidate();
        L7:
            suppressLayout(false);
        }

        private void suppressLayout(boolean r2) {
            if (this.mSuppressLayout == true) goto L5;
            return;
        L5:
            if (this.mLayoutSuppressed == r2) goto L11;
            ViewGroup r0 = this.mParent;
            if (r0 == null) goto L12;
            this.mLayoutSuppressed = r2;
            ViewGroupUtils.suppressLayout(r0, r2);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            hideViewWhenNotCanceled();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator r1) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator r1) {
            if (this.mCanceled == true) goto L6;
            ViewUtils.setTransitionVisibility(this.mView, 0);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition r1) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition r1) {
            hideViewWhenNotCanceled();
            r1.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition r1) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition r1) {
            suppressLayout(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition r1) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    public static class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        public VisibilityInfo() {
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_VISIBILITY, PROPNAME_PARENT};
    }

    public Visibility() {
        this.mMode = 3;
    }

    private void captureValues(TransitionValues r3) {
        int r2 = r3.view.getVisibility();
        r3.values.put(PROPNAME_VISIBILITY, Integer.valueOf(r2));
        r3.values.put(PROPNAME_PARENT, r3.view.getParent());
        int[] r4 = new int[2];
        r3.view.getLocationOnScreen(r4);
        r3.values.put(PROPNAME_SCREEN_LOCATION, r4);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues r7, TransitionValues r8) {
        VisibilityInfo r6 = new VisibilityInfo();
        r6.mVisibilityChange = false;
        r6.mFadeIn = false;
        if (r7 != null) goto L5;
    L7:
        r6.mStartVisibility = -1;
        r6.mStartParent = null;
    L8:
        if (r8 != null) goto L10;
    L12:
        r6.mEndVisibility = -1;
        r6.mEndParent = null;
    L14:
        if (r7 == null) goto L32;
        if (r8 == null) goto L32;
        int r9 = r6.mStartVisibility;
        int r10 = r6.mEndVisibility;
        if (r9 == r10) goto L19;
    L21:
        if (r9 == r10) goto L27;
        if (r9 != 0) goto L24;
        r6.mFadeIn = false;
        r6.mVisibilityChange = true;
    L40:
        return r6;
    L24:
        if (r10 != 0) goto L40;
        r6.mFadeIn = true;
        r6.mVisibilityChange = true;
        goto L40
    L27:
        if (r6.mEndParent != null) goto L30;
        r6.mFadeIn = false;
        r6.mVisibilityChange = true;
        goto L40
    L30:
        if (r6.mStartParent != null) goto L40;
        r6.mFadeIn = true;
        r6.mVisibilityChange = true;
        goto L40
    L19:
        if (r6.mStartParent != r6.mEndParent) goto L21;
        return r6;
    L32:
        if (r7 == null) goto L34;
    L36:
        if (r8 != null) goto L40;
        if (r6.mStartVisibility != 0) goto L40;
        r6.mFadeIn = false;
        r6.mVisibilityChange = true;
        goto L40
    L34:
        if (r6.mEndVisibility != 0) goto L36;
        r6.mFadeIn = true;
        r6.mVisibilityChange = true;
        goto L40
    L10:
        if (r8.values.containsKey(PROPNAME_VISIBILITY) == false) goto L12;
        r6.mEndVisibility = ((Integer) r8.values.get(PROPNAME_VISIBILITY)).intValue();
        r6.mEndParent = (ViewGroup) r8.values.get(PROPNAME_PARENT);
        goto L14
    L5:
        if (r7.values.containsKey(PROPNAME_VISIBILITY) == false) goto L7;
        r6.mStartVisibility = ((Integer) r7.values.get(PROPNAME_VISIBILITY)).intValue();
        r6.mStartParent = (ViewGroup) r7.values.get(PROPNAME_PARENT);
        goto L8
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues r1) {
        captureValues(r1);
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup r9, @Nullable TransitionValues r10, @Nullable TransitionValues r11) {
        VisibilityInfo r0 = getVisibilityChangeInfo(r10, r11);
        if (r0.mVisibilityChange == true) goto L5;
        return null;
    L5:
        if (r0.mStartParent != null) goto L9;
        if (r0.mEndParent != null) goto L9;
        return null;
    L9:
        if (r0.mFadeIn == false) goto L13;
        return onAppear(r9, r10, r0.mStartVisibility, r11, r0.mEndVisibility);
    L13:
        return onDisappear(r9, r10, r0.mStartVisibility, r11, r0.mEndVisibility);
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues r5, TransitionValues r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L6;
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        if (r6.values.containsKey(PROPNAME_VISIBILITY) == r5.values.containsKey(PROPNAME_VISIBILITY)) goto L11;
        return false;
    L11:
        VisibilityInfo r4 = getVisibilityChangeInfo(r5, r6);
        if (r4.mVisibilityChange == true) goto L14;
        return false;
    L14:
        if (r4.mStartVisibility != 0) goto L16;
    L17:
        return true;
    L16:
        if (r4.mEndVisibility == 0) goto L17;
        return false;
    }

    public boolean isVisible(TransitionValues r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r0 = ((Integer) r3.values.get(PROPNAME_VISIBILITY)).intValue();
        View r4 = (View) r3.values.get(PROPNAME_PARENT);
        if (r0 != 0) goto L10;
        if (r4 == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public Animator onAppear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return null;
    }

    public Animator onDisappear(ViewGroup r1, View r2, TransitionValues r3, TransitionValues r4) {
        return null;
    }

    public void setMode(int r2) {
        if ((r2 & (-4)) != 0) goto L7;
        this.mMode = r2;
        return;
    L7:
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Animator onAppear(ViewGroup r3, TransitionValues r4, int r5, TransitionValues r6, int r7) {
        if ((this.mMode & 1) != 1) goto L12;
        if (r6 == null) goto L12;
        if (r4 != null) goto L11;
        View r8 = (View) r6.view.getParent();
        if (getVisibilityChangeInfo(getMatchedTransitionValues(r8, false), getTransitionValues(r8, false)).mVisibilityChange == false) goto L11;
        return null;
    L11:
        return onAppear(r3, r6.view, r4, r6);
    L12:
        return null;
    }

    public Animator onDisappear(final ViewGroup r11, TransitionValues r12, int r13, TransitionValues r14, int r15) {
        if ((this.mMode & 2) == 2) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
        return null;
    L7:
        final View r16 = r12.view;
        if (r14 == null) goto L10;
        View r2 = r14.view;
    L11:
        final View r3 = (View) r16.getTag(R.id.save_overlay_view);
        if (r3 == null) goto L14;
        View r4 = null;
        boolean r6 = true;
    L45:
        if (r3 == null) goto L54;
        if (r6 == true) goto L48;
        int[] r17 = (int[]) r12.values.get(PROPNAME_SCREEN_LOCATION);
        int r1 = r17[0];
        int r18 = r17[1];
        int[] r0 = new int[2];
        r11.getLocationOnScreen(r0);
        r3.offsetLeftAndRight((r1 - r0[0]) - r3.getLeft());
        r3.offsetTopAndBottom((r18 - r0[1]) - r3.getTop());
        ViewGroupUtils.getOverlay(r11).add(r3);
    L48:
        Animator r19 = onDisappear(r11, r3, r12, r14);
        if (r6 == true) goto L53;
        if (r19 != null) goto L52;
        ViewGroupUtils.getOverlay(r11).remove(r3);
        goto L53
    L52:
        r16.setTag(R.id.save_overlay_view, r3);
        addListener(new AnonymousClass1(this, r11, r3, r16));
    L53:
        return r19;
    L54:
        if (r4 == null) goto L60;
        int r110 = r4.getVisibility();
        ViewUtils.setTransitionVisibility(r4, 0);
        Animator r111 = onDisappear(r11, r4, r12, r14);
        if (r111 == null) goto L58;
        DisappearListener r112 = new DisappearListener(r4, r15, true);
        r111.addListener(r112);
        AnimatorUtils.addPauseListener(r111, r112);
        addListener(r112);
    L59:
        return r111;
    L58:
        ViewUtils.setTransitionVisibility(r4, r110);
        goto L59
    L60:
        return null;
    L14:
        if (r2 != null) goto L16;
    L24:
        if (r2 != null) goto L25;
    L23:
        r2 = null;
        View r5 = null;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L28;
    L35:
        r6 = false;
        View r9 = r5;
        r3 = r2;
        r4 = r9;
        goto L45
    L28:
        if (r16.getParent() != null) goto L31;
    L44:
        r4 = r5;
        r6 = false;
        r3 = r16;
        goto L45
    L31:
        if ((r16.getParent() instanceof View) == false) goto L35;
        View r8 = (View) r16.getParent();
        if (getVisibilityChangeInfo(getTransitionValues(r8, true), getMatchedTransitionValues(r8, true)).mVisibilityChange == true) goto L36;
        r2 = TransitionUtils.copyViewImage(r11, r16, r8);
        goto L35
    L36:
        int r10 = r8.getId();
        if (r8.getParent() != null) goto L35;
        if (r10 == (-1)) goto L35;
        if (r11.findViewById(r10) == null) goto L35;
        if (this.mCanRemoveViews == false) goto L35;
    L25:
        r5 = null;
        r7 = false;
        goto L26
    L16:
        if (r2.getParent() == null) goto L24;
        if (r15 == 4) goto L22;
        if (r16 != r2) goto L23;
    L22:
        r5 = r2;
        r7 = false;
        r2 = null;
        goto L26
    L10:
        r2 = null;
        goto L11
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mMode = 3;
        TypedArray r5 = r3.obtainStyledAttributes(r4, Styleable.VISIBILITY_TRANSITION);
        int r6 = TypedArrayUtils.getNamedInt(r5, (XmlResourceParser) r4, "transitionVisibilityMode", 0, 0);
        r5.recycle();
        if (r6 == 0) goto L6;
        setMode(r6);
        return;
    }
}
