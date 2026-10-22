package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300;
    private static final int DEF_STYLE_RES = 0;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;

    @NonNull
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;

    @NonNull
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;

    @Nullable
    private Animator menuAnimator;

    @Nullable
    private Animator modeAnimator;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int rightInset;

    public interface AnimationListener {
        void onAnimationEnd(BottomAppBar r1);

        void onAnimationStart(BottomAppBar r1);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        @NonNull
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }

        public static /* synthetic */ WeakReference access$2100(Behavior r0) {
            return r0.viewRef;
        }

        public static /* synthetic */ Rect access$2200(Behavior r0) {
            return r0.fabContentRect;
        }

        public static /* synthetic */ int access$2300(Behavior r0) {
            return r0.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
            return onLayoutChild(r1, (BottomAppBar) r2, r3);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
            return onStartNestedScroll(r1, (BottomAppBar) r2, r3, r4, r5, r6);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r4, @NonNull BottomAppBar r5, int r6) {
            this.viewRef = new WeakReference(r5);
            View r0 = BottomAppBar.access$2800(r5);
            if (r0 != null) goto L5;
        L10:
            r4.onLayoutChild(r5, r6);
            return super.onLayoutChild(r4, r5, r6);
        L5:
            if (ViewCompat.isLaidOut(r0) == true) goto L10;
            CoordinatorLayout.LayoutParams r1 = (CoordinatorLayout.LayoutParams) r0.getLayoutParams();
            r1.anchorGravity = 49;
            this.originalBottomMargin = ((ViewGroup.MarginLayoutParams) r1).bottomMargin;
            if ((r0 instanceof FloatingActionButton) == false) goto L9;
            FloatingActionButton r2 = (FloatingActionButton) r0;
            r2.addOnLayoutChangeListener(this.fabLayoutListener);
            BottomAppBar.access$2900(r5, r2);
        L9:
            BottomAppBar.access$1200(r5);
            goto L10
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r2, @NonNull BottomAppBar r3, @NonNull View r4, @NonNull View r5, int r6, int r7) {
            if (r3.getHideOnScroll() == true) goto L5;
        L7:
            return false;
        L5:
            if (super.onStartNestedScroll(r2, r3, r4, r5, r6, r7) == false) goto L7;
            return true;
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.fabLayoutListener = new AnonymousClass1(this);
            this.fabContentRect = new Rect();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int fabAlignmentMode;
        boolean fabAttached;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.fabAlignmentMode);
            r1.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.fabAlignmentMode = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.fabAttached = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    }

    public BottomAppBar(@NonNull Context r3) {
        this(r3, null, 0);
    }

    public static /* synthetic */ int access$000(BottomAppBar r0) {
        return r0.fabAlignmentMode;
    }

    public static /* synthetic */ boolean access$100(BottomAppBar r0) {
        return r0.fabAttached;
    }

    public static /* synthetic */ int access$1000(BottomAppBar r0) {
        return r0.rightInset;
    }

    public static /* synthetic */ int access$1002(BottomAppBar r0, int r1) {
        r0.rightInset = r1;
        return r1;
    }

    public static /* synthetic */ void access$1100(BottomAppBar r0) {
        r0.cancelAnimations();
    }

    public static /* synthetic */ void access$1200(BottomAppBar r0) {
        r0.setCutoutState();
    }

    public static /* synthetic */ void access$1300(BottomAppBar r0) {
        r0.setActionMenuViewPosition();
    }

    public static /* synthetic */ void access$1400(BottomAppBar r0) {
        r0.dispatchAnimationStart();
    }

    public static /* synthetic */ void access$1500(BottomAppBar r0) {
        r0.dispatchAnimationEnd();
    }

    public static /* synthetic */ float access$1600(BottomAppBar r0, int r1) {
        return r0.getFabTranslationX(r1);
    }

    public static /* synthetic */ Animator access$1702(BottomAppBar r0, Animator r1) {
        r0.menuAnimator = r1;
        return r1;
    }

    public static /* synthetic */ void access$1800(BottomAppBar r0, ActionMenuView r1, int r2, boolean r3) {
        r0.translateActionMenuView(r1, r2, r3);
    }

    public static /* synthetic */ FloatingActionButton access$1900(BottomAppBar r0) {
        return r0.findDependentFab();
    }

    public static /* synthetic */ void access$200(BottomAppBar r0, int r1, boolean r2) {
        r0.maybeAnimateMenuView(r1, r2);
    }

    public static /* synthetic */ float access$2000(BottomAppBar r0) {
        return r0.getFabTranslationX();
    }

    public static /* synthetic */ int access$2400(BottomAppBar r0) {
        return r0.getBottomInset();
    }

    public static /* synthetic */ int access$2500(BottomAppBar r0) {
        return r0.getLeftInset();
    }

    public static /* synthetic */ int access$2600(BottomAppBar r0) {
        return r0.getRightInset();
    }

    public static /* synthetic */ int access$2700(BottomAppBar r0) {
        return r0.fabOffsetEndMode;
    }

    public static /* synthetic */ View access$2800(BottomAppBar r0) {
        return r0.findDependentView();
    }

    public static /* synthetic */ void access$2900(BottomAppBar r0, FloatingActionButton r1) {
        r0.addFabAnimationListeners(r1);
    }

    public static /* synthetic */ MaterialShapeDrawable access$300(BottomAppBar r0) {
        return r0.materialShapeDrawable;
    }

    public static /* synthetic */ BottomAppBarTopEdgeTreatment access$400(BottomAppBar r0) {
        return r0.getTopEdgeTreatment();
    }

    public static /* synthetic */ boolean access$500(BottomAppBar r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    public static /* synthetic */ int access$602(BottomAppBar r0, int r1) {
        r0.bottomInset = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$700(BottomAppBar r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    public static /* synthetic */ int access$800(BottomAppBar r0) {
        return r0.leftInset;
    }

    public static /* synthetic */ int access$802(BottomAppBar r0, int r1) {
        r0.leftInset = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$900(BottomAppBar r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    private void addFabAnimationListeners(@NonNull FloatingActionButton r2) {
        r2.addOnHideAnimationListener(this.fabAnimationListener);
        r2.addOnShowAnimationListener(new AnonymousClass8(this));
        r2.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.modeAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    private void createFabTranslationXAnimation(int r3, @NonNull List<Animator> r4) {
        ObjectAnimator r2 = ObjectAnimator.ofFloat(findDependentFab(), "translationX", new float[]{getFabTranslationX(r3)});
        r2.setDuration(300);
        r4.add(r2);
    }

    private void createMenuViewTranslationAnimation(final int r9, final boolean r10, @NonNull List<Animator> r11) {
        final ActionMenuView r2 = getActionMenuView();
        if (r2 != null) goto L5;
        return;
    L5:
        Animator r4 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{1.0f});
        if (Math.abs(r2.getTranslationX() - getActionMenuViewTranslationX(r2, r9, r10)) <= 1.0f) goto L9;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{0.0f});
        r3.addListener(new AnonymousClass7(this, r2, r9, r10));
        AnimatorSet r8 = new AnimatorSet();
        r8.setDuration(150);
        r8.playSequentially(new Animator[]{r3, r4});
        r11.add(r8);
        return;
    L9:
        if (r2.getAlpha() >= 1.0f) goto L13;
        r11.add(r4);
        return;
    }

    private void dispatchAnimationEnd() {
        int r0 = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = r0;
        if (r0 != 0) goto L10;
        ArrayList<AnimationListener> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<AnimationListener> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r2.next().onAnimationEnd(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    private void dispatchAnimationStart() {
        int r0 = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = r0 + 1;
        if (r0 != 0) goto L10;
        ArrayList<AnimationListener> r1 = this.animationListeners;
        if (r1 == null) goto L12;
        Iterator<AnimationListener> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        r2.next().onAnimationStart(this);
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Nullable
    private FloatingActionButton findDependentFab() {
        View r1 = findDependentView();
        if ((r1 instanceof FloatingActionButton) == true) goto L7;
        return null;
    L7:
        return (FloatingActionButton) r1;
    }

    @Nullable
    private View findDependentView() {
        if ((getParent() instanceof CoordinatorLayout) == true) goto L5;
        return null;
    L5:
        Iterator<View> r3 = ((CoordinatorLayout) getParent()).getDependents(this).iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        View r0 = r3.next();
        if ((r0 instanceof FloatingActionButton) == true) goto L12;
        if ((r0 instanceof ExtendedFloatingActionButton) == false) goto L7;
    L12:
        return r0;
    L13:
        return null;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L10;
        View r1 = getChildAt(r0);
        if ((r1 instanceof ActionMenuView) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return (ActionMenuView) r1;
    L10:
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private float getFabTranslationX(int r4) {
        boolean r0 = ViewUtils.isLayoutRtl(this);
        int r1 = 1;
        if (r4 != 1) goto L12;
        if (r0 == false) goto L6;
        int r5 = this.leftInset;
    L7:
        int r3 = (getMeasuredWidth() / 2) - (this.fabOffsetEndMode + r5);
        if (r0 == false) goto L11;
        r1 = -1;
    L11:
        return r3 * r1;
    L6:
        r5 = this.rightInset;
        goto L7
    L12:
        return 0.0f;
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().getCradleVerticalOffset();
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    @NonNull
    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton r0 = findDependentFab();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOrWillBeShown() == false) goto L7;
        return true;
    }

    private void maybeAnimateMenuView(int r3, boolean r4) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
        return;
    L5:
        Animator r0 = this.menuAnimator;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        ArrayList r1 = new ArrayList();
        if (isFabVisibleOrWillBeShown() == true) goto L11;
        r3 = 0;
        r4 = false;
    L11:
        createMenuViewTranslationAnimation(r3, r4, r1);
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(r1);
        this.menuAnimator = r5;
        r5.addListener(new AnonymousClass6(this));
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int r4) {
        if (this.fabAlignmentMode != r4) goto L5;
        return;
    L5:
        if (ViewCompat.isLaidOut(this) == false) goto L17;
        Animator r0 = this.modeAnimator;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ArrayList r1 = new ArrayList();
        if (this.fabAnimationMode != 1) goto L13;
        createFabTranslationXAnimation(r4, r1);
    L14:
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(r1);
        this.modeAnimator = r5;
        r5.addListener(new AnonymousClass4(this));
        this.modeAnimator.start();
        return;
    L13:
        createFabDefaultXAnimation(r4, r1);
        goto L14
    }

    private void setActionMenuViewPosition() {
        ActionMenuView r0 = getActionMenuView();
        if (r0 == null) goto L9;
        r0.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown() == true) goto L7;
        translateActionMenuView(r0, 0, false);
        return;
    L7:
        translateActionMenuView(r0, this.fabAlignmentMode, this.fabAttached);
        return;
    }

    private void setCutoutState() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        View r0 = findDependentView();
        MaterialShapeDrawable r1 = this.materialShapeDrawable;
        if (this.fabAttached == true) goto L5;
    L7:
        float r2 = 0.0f;
    L8:
        r1.setInterpolation(r2);
        if (r0 == null) goto L12;
        r0.setTranslationY(getFabTranslationY());
        r0.setTranslationX(getFabTranslationX());
        return;
    L12:
        return;
    L5:
        if (isFabVisibleOrWillBeShown() == false) goto L7;
        r2 = 1.0f;
        goto L8
    }

    private void translateActionMenuView(@NonNull ActionMenuView r1, int r2, boolean r3) {
        r1.setTranslationX(getActionMenuViewTranslationX(r1, r2, r3));
    }

    public void addAnimationListener(@NonNull AnimationListener r2) {
        if (this.animationListeners != null) goto L5;
        this.animationListeners = new ArrayList();
    L5:
        this.animationListeners.add(r2);
    }

    public void createFabDefaultXAnimation(final int r2, List<Animator> r3) {
        FloatingActionButton r4 = findDependentFab();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isOrWillBeHidden() == true) goto L10;
        dispatchAnimationStart();
        r4.hide(new AnonymousClass5(this, r2));
        return;
    }

    public int getActionMenuViewTranslationX(@NonNull ActionMenuView r5, int r6, boolean r7) {
        int r1 = 0;
        if (r6 != 1) goto L28;
        if (r7 == false) goto L28;
        boolean r8 = ViewUtils.isLayoutRtl(this);
        if (r8 == false) goto L9;
        int r9 = getMeasuredWidth();
    L11:
        if (r1 >= getChildCount()) goto L20;
        View r0 = getChildAt(r1);
        if ((r0.getLayoutParams() instanceof Toolbar.LayoutParams) == false) goto L19;
        if ((((Toolbar.LayoutParams) r0.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) != 8388611) goto L19;
        if (r8 == false) goto L18;
        r9 = Math.min(r9, r0.getLeft());
        goto L19
    L18:
        r9 = Math.max(r9, r0.getRight());
    L19:
        r1 = r1 + 1;
        goto L11
    L20:
        if (r8 == false) goto L22;
        int r10 = r5.getRight();
    L23:
        if (r8 == false) goto L25;
        int r4 = this.rightInset;
    L27:
        return r9 - (r10 + r4);
    L25:
        r4 = -this.leftInset;
        goto L27
    L22:
        r10 = r5.getLeft();
        goto L23
    L9:
        r9 = 0;
    L28:
        return 0;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if ((getParent() instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) getParent()).setClipChildren(false);
        return;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L5;
        cancelAnimations();
        setCutoutState();
    L5:
        setActionMenuViewPosition();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.fabAlignmentMode = r3.fabAlignmentMode;
        this.fabAttached = r3.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.fabAlignmentMode = this.fabAlignmentMode;
        r1.fabAttached = this.fabAttached;
        return r1;
    }

    public void performHide() {
        getBehavior().slideDown(this);
    }

    public void performShow() {
        getBehavior().slideUp(this);
    }

    public void removeAnimationListener(@NonNull AnimationListener r1) {
        ArrayList<AnimationListener> r0 = this.animationListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    public void replaceMenu(@MenuRes int r2) {
        getMenu().clear();
        inflateMenu(r2);
    }

    public void setBackgroundTint(@Nullable ColorStateList r1) {
        DrawableCompat.setTintList(this.materialShapeDrawable, r1);
    }

    public void setCradleVerticalOffset(@Dimension float r2) {
        if (r2 == getCradleVerticalOffset()) goto L6;
        getTopEdgeTreatment().setCradleVerticalOffset(r2);
        this.materialShapeDrawable.invalidateSelf();
        setCutoutState();
        return;
    }

    @Override // android.view.View
    public void setElevation(float r2) {
        this.materialShapeDrawable.setElevation(r2);
        int r3 = this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY();
        getBehavior().setAdditionalHiddenOffsetY(this, r3);
    }

    public void setFabAlignmentMode(int r2) {
        maybeAnimateModeChange(r2);
        maybeAnimateMenuView(r2, this.fabAttached);
        this.fabAlignmentMode = r2;
    }

    public void setFabAnimationMode(int r1) {
        this.fabAnimationMode = r1;
    }

    public void setFabCradleMargin(@Dimension float r2) {
        if (r2 == getFabCradleMargin()) goto L6;
        getTopEdgeTreatment().setFabCradleMargin(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float r2) {
        if (r2 == getFabCradleRoundedCornerRadius()) goto L6;
        getTopEdgeTreatment().setFabCradleRoundedCornerRadius(r2);
        this.materialShapeDrawable.invalidateSelf();
        return;
    }

    public boolean setFabDiameter(@Px int r2) {
        float r3 = r2;
        if (r3 == getTopEdgeTreatment().getFabDiameter()) goto L6;
        getTopEdgeTreatment().setFabDiameter(r3);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    L6:
        return false;
    }

    public void setHideOnScroll(boolean r1) {
        this.hideOnScroll = r1;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence r1) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence r1) {
    }

    public BottomAppBar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.behavior != null) goto L6;
        this.behavior = new Behavior();
    L6:
        return this.behavior;
    }

    public BottomAppBar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r6 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r6), r12, r13);
        MaterialShapeDrawable r14 = new MaterialShapeDrawable();
        this.materialShapeDrawable = r14;
        this.animatingModeChangeCounter = 0;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1(this);
        this.fabTransformationCallback = new AnonymousClass2(this);
        Context r8 = getContext();
        TypedArray r0 = ThemeEnforcement.obtainStyledAttributes(r8, r12, R.styleable.BottomAppBar, r13, r6, new int[0]);
        ColorStateList r1 = MaterialResources.getColorStateList(r8, r0, R.styleable.BottomAppBar_backgroundTint);
        int r2 = r0.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float r3 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float r4 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float r5 = r0.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = r0.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = r0.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.hideOnScroll = r0.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r0.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        r0.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        r14.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(r3, r4, r5)).build());
        r14.setShadowCompatibilityMode(2);
        r14.setPaintStyle(Paint.Style.FILL);
        r14.initializeElevationOverlay(r8);
        setElevation(r2);
        DrawableCompat.setTintList(r14, r1);
        ViewCompat.setBackground(this, r14);
        ViewUtils.doOnApplyWindowInsets(this, r12, r13, r6, new AnonymousClass3(this));
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }
}
