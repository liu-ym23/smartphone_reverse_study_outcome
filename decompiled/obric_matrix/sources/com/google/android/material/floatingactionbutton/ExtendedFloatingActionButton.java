package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int DEF_STYLE_RES = 0;
    static final Property<View, Float> HEIGHT = null;
    static final Property<View, Float> PADDING_END = null;
    static final Property<View, Float> PADDING_START = null;
    static final Property<View, Float> WIDTH = null;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @NonNull
    protected ColorStateList originalTextCsl;
    private final MotionStrategy showStrategy;

    @NonNull
    private final MotionStrategy shrinkStrategy;

    class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        ChangeSizeStrategy(ExtendedFloatingActionButton r1, AnimatorTracker r2, Size r3, boolean r4) {
            this.this$0 = r1;
            super(r1, r2);
            this.size = r3;
            this.extending = r4;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        @NonNull
        public AnimatorSet createAnimator() {
            MotionSpec r0 = getCurrentMotionSpec();
            if (r0.hasPropertyValues("width") == false) goto L6;
            PropertyValuesHolder[] r2 = r0.getPropertyValues("width");
            r2[0].setFloatValues(new float[]{this.this$0.getWidth(), this.size.getWidth()});
            r0.setPropertyValues("width", r2);
        L6:
            if (r0.hasPropertyValues("height") == false) goto L9;
            PropertyValuesHolder[] r3 = r0.getPropertyValues("height");
            r3[0].setFloatValues(new float[]{this.this$0.getHeight(), this.size.getHeight()});
            r0.setPropertyValues("height", r3);
        L9:
            if (r0.hasPropertyValues("paddingStart") == false) goto L12;
            PropertyValuesHolder[] r4 = r0.getPropertyValues("paddingStart");
            r4[0].setFloatValues(new float[]{ViewCompat.getPaddingStart(this.this$0), this.size.getPaddingStart()});
            r0.setPropertyValues("paddingStart", r4);
        L12:
            if (r0.hasPropertyValues("paddingEnd") == false) goto L15;
            PropertyValuesHolder[] r5 = r0.getPropertyValues("paddingEnd");
            r5[0].setFloatValues(new float[]{ViewCompat.getPaddingEnd(this.this$0), this.size.getPaddingEnd()});
            r0.setPropertyValues("paddingEnd", r5);
        L15:
            if (r0.hasPropertyValues("labelOpacity") == false) goto L24;
            PropertyValuesHolder[] r6 = r0.getPropertyValues("labelOpacity");
            boolean r7 = this.extending;
            float r8 = 0.0f;
            if (r7 == false) goto L19;
            float r9 = 0.0f;
        L20:
            if (r7 == false) goto L22;
            r8 = 1.0f;
        L22:
            r6[0].setFloatValues(new float[]{r9, r8});
            r0.setPropertyValues("labelOpacity", r6);
            goto L24
        L19:
            r9 = 1.0f;
        L24:
            return super.createAnimator(r0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            if (this.extending == false) goto L6;
            return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
        L6:
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$802(this.this$0, false);
            this.this$0.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams r0 = this.this$0.getLayoutParams();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.width = this.size.getLayoutParams().width;
            r0.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            ExtendedFloatingActionButton.access$702(this.this$0, this.extending);
            ExtendedFloatingActionButton.access$802(this.this$0, true);
            this.this$0.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            boolean r0 = this.extending;
            ExtendedFloatingActionButton r1 = this.this$0;
            if (r0 == false) goto L7;
            r2.onExtended(r1);
            return;
        L7:
            r2.onShrunken(r1);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.access$702(this.this$0, this.extending);
            ViewGroup.LayoutParams r0 = this.this$0.getLayoutParams();
            if (r0 != null) goto L5;
            return;
        L5:
            r0.width = this.size.getLayoutParams().width;
            r0.height = this.size.getLayoutParams().height;
            ViewCompat.setPaddingRelative(this.this$0, this.size.getPaddingStart(), this.this$0.getPaddingTop(), this.size.getPaddingEnd(), this.this$0.getPaddingBottom());
            this.this$0.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            if (this.extending != ExtendedFloatingActionButton.access$700(this.this$0)) goto L5;
        L10:
            return true;
        L5:
            if (this.this$0.getIcon() == null) goto L10;
            if (TextUtils.isEmpty(this.this$0.getText()) == true) goto L10;
            return false;
        }
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;

        @Nullable
        private OnChangedCallback internalAutoHideCallback;

        @Nullable
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context r2, @Nullable AttributeSet r3) {
            super(r2, r3);
            TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r4.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = r4.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            r4.recycle();
        }

        private static boolean isBottomSheet(@NonNull View r1) {
            ViewGroup.LayoutParams r2 = r1.getLayoutParams();
            if ((r2 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r2).getBehavior() instanceof BottomSheetBehavior;
        }

        private boolean shouldUpdateVisibility(@NonNull View r3, @NonNull ExtendedFloatingActionButton r4) {
            CoordinatorLayout.LayoutParams r5 = (CoordinatorLayout.LayoutParams) r4.getLayoutParams();
            if (this.autoHideEnabled == true) goto L8;
            if (this.autoShrinkEnabled == true) goto L8;
            return false;
        L8:
            if (r5.getAnchorId() == r3.getId()) goto L10;
            return false;
        L10:
            return true;
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r2, @NonNull AppBarLayout r3, @NonNull ExtendedFloatingActionButton r4) {
            if (shouldUpdateVisibility(r3, r4) == true) goto L7;
            return false;
        L7:
            if (this.tmpRect != null) goto L9;
            this.tmpRect = new Rect();
        L9:
            Rect r0 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(r2, r3, r0);
            if (r0.bottom > r3.getMinimumHeightForVisibleOverlappingContent()) goto L12;
            shrinkOrHide(r4);
            return true;
        L12:
            extendOrShow(r4);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(@NonNull View r3, @NonNull ExtendedFloatingActionButton r4) {
            if (shouldUpdateVisibility(r3, r4) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) r4.getLayoutParams();
            if (r3.getTop() >= ((r4.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) r0).topMargin)) goto L9;
            shrinkOrHide(r4);
            return true;
        L9:
            extendOrShow(r4);
            return true;
        }

        protected void extendOrShow(@NonNull ExtendedFloatingActionButton r2) {
            boolean r0 = this.autoShrinkEnabled;
            if (r0 == false) goto L5;
            OnChangedCallback r1 = this.internalAutoShrinkCallback;
        L6:
            if (r0 == false) goto L8;
            MotionStrategy r3 = ExtendedFloatingActionButton.access$500(r2);
        L9:
            ExtendedFloatingActionButton.access$400(r2, r3, r1);
            return;
        L8:
            r3 = ExtendedFloatingActionButton.access$600(r2);
            goto L9
        L5:
            r1 = this.internalAutoHideCallback;
            goto L6
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull Rect r3) {
            return getInsetDodgeRect(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r1, @NonNull ExtendedFloatingActionButton r2, @NonNull Rect r3) {
            return super.getInsetDodgeRect(r1, r2, r3);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r1) {
            if (r1.dodgeInsetEdges != 0) goto L6;
            r1.dodgeInsetEdges = 80;
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r1, @NonNull View r2, View r3) {
            return onDependentViewChanged(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        public boolean onDependentViewChanged(CoordinatorLayout r2, @NonNull ExtendedFloatingActionButton r3, View r4) {
            if ((r4 instanceof AppBarLayout) == false) goto L6;
            updateFabVisibilityForAppBarLayout(r2, (AppBarLayout) r4, r3);
            return false;
        L6:
            if (isBottomSheet(r4) == false) goto L11;
            updateFabVisibilityForBottomSheet(r4, r3);
            return false;
        L11:
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
            return onLayoutChild(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r6, @NonNull ExtendedFloatingActionButton r7, int r8) {
            List<View> r0 = r6.getDependencies(r7);
            int r1 = r0.size();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L15;
            View r3 = r0.get(r2);
            if ((r3 instanceof AppBarLayout) == false) goto L10;
            if (updateFabVisibilityForAppBarLayout(r6, (AppBarLayout) r3, r7) == true) goto L15;
        L14:
            r2 = r2 + 1;
            goto L3
        L10:
            if (isBottomSheet(r3) == false) goto L14;
            if (updateFabVisibilityForBottomSheet(r3, r7) == false) goto L14;
        L15:
            r6.onLayoutChild(r7, r8);
            return true;
        }

        public void setAutoHideEnabled(boolean r1) {
            this.autoHideEnabled = r1;
        }

        public void setAutoShrinkEnabled(boolean r1) {
            this.autoShrinkEnabled = r1;
        }

        @VisibleForTesting
        void setInternalAutoHideCallback(@Nullable OnChangedCallback r1) {
            this.internalAutoHideCallback = r1;
        }

        @VisibleForTesting
        void setInternalAutoShrinkCallback(@Nullable OnChangedCallback r1) {
            this.internalAutoShrinkCallback = r1;
        }

        protected void shrinkOrHide(@NonNull ExtendedFloatingActionButton r2) {
            boolean r0 = this.autoShrinkEnabled;
            if (r0 == false) goto L5;
            OnChangedCallback r1 = this.internalAutoShrinkCallback;
        L6:
            if (r0 == false) goto L8;
            MotionStrategy r3 = ExtendedFloatingActionButton.access$200(r2);
        L9:
            ExtendedFloatingActionButton.access$400(r2, r3, r1);
            return;
        L8:
            r3 = ExtendedFloatingActionButton.access$300(r2);
            goto L9
        L5:
            r1 = this.internalAutoHideCallback;
            goto L6
        }
    }

    class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public HideStrategy(ExtendedFloatingActionButton r1, AnimatorTracker r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$902(this.this$0, 0);
            if (this.isCancelled == true) goto L6;
            this.this$0.setVisibility(8);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            this.isCancelled = false;
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 1);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r1) {
            if (r1 == null) goto L5;
            r1.onHidden(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1100(this.this$0);
        }
    }

    public static abstract class OnChangedCallback {
        public OnChangedCallback() {
        }

        public void onExtended(ExtendedFloatingActionButton r1) {
        }

        public void onHidden(ExtendedFloatingActionButton r1) {
        }

        public void onShown(ExtendedFloatingActionButton r1) {
        }

        public void onShrunken(ExtendedFloatingActionButton r1) {
        }
    }

    class ShowStrategy extends BaseMotionStrategy {
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ShowStrategy(ExtendedFloatingActionButton r1, AnimatorTracker r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$902(this.this$0, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(@Nullable OnChangedCallback r1) {
            if (r1 == null) goto L5;
            r1.onShown(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(0);
            this.this$0.setAlpha(1.0f);
            this.this$0.setScaleY(1.0f);
            this.this$0.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1000(this.this$0);
        }
    }

    interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    static {
        final Class<Float> r0 = Float.class;
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        final String r2 = "width";
        WIDTH = new AnonymousClass4(r0, r2);
        final String r3 = "height";
        HEIGHT = new AnonymousClass5(r0, r3);
        final String r4 = "paddingStart";
        PADDING_START = new AnonymousClass6(r0, r4);
        final String r5 = "paddingEnd";
        PADDING_END = new AnonymousClass7(r0, r5);
    }

    public ExtendedFloatingActionButton(@NonNull Context r2) {
        this(r2, null);
    }

    public ExtendedFloatingActionButton(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(@NonNull Context r17, @Nullable AttributeSet r18, int r19) {
        int r9 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r17, r18, r19, r9), r18, r19);
        this.animState = 0;
        AnimatorTracker r1 = new AnimatorTracker();
        this.changeVisibilityTracker = r1;
        ShowStrategy r11 = new ShowStrategy(this, r1);
        this.showStrategy = r11;
        HideStrategy r12 = new HideStrategy(this, r1);
        this.hideStrategy = r12;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context r14 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(r14, r18);
        TypedArray r2 = ThemeEnforcement.obtainStyledAttributes(r14, r18, R.styleable.ExtendedFloatingActionButton, r19, r9, new int[0]);
        MotionSpec r3 = MotionSpec.createFromAttribute(r14, r2, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec r4 = MotionSpec.createFromAttribute(r14, r2, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec r5 = MotionSpec.createFromAttribute(r14, r2, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec r6 = MotionSpec.createFromAttribute(r14, r2, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = r2.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        AnimatorTracker r7 = new AnimatorTracker();
        ChangeSizeStrategy r15 = new ChangeSizeStrategy(this, r7, new AnonymousClass1(this), true);
        this.extendStrategy = r15;
        ChangeSizeStrategy r10 = new ChangeSizeStrategy(this, r7, new AnonymousClass2(this), false);
        this.shrinkStrategy = r10;
        r11.setMotionSpec(r3);
        r12.setMotionSpec(r4);
        r15.setMotionSpec(r5);
        r10.setMotionSpec(r6);
        r2.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(r14, r18, r19, r9, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    static /* synthetic */ int access$000(ExtendedFloatingActionButton r0) {
        return r0.extendedPaddingStart;
    }

    static /* synthetic */ int access$100(ExtendedFloatingActionButton r0) {
        return r0.extendedPaddingEnd;
    }

    static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton r0) {
        return r0.isOrWillBeShown();
    }

    static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton r0) {
        return r0.isOrWillBeHidden();
    }

    static /* synthetic */ MotionStrategy access$200(ExtendedFloatingActionButton r0) {
        return r0.shrinkStrategy;
    }

    static /* synthetic */ MotionStrategy access$300(ExtendedFloatingActionButton r0) {
        return r0.hideStrategy;
    }

    static /* synthetic */ void access$400(ExtendedFloatingActionButton r0, MotionStrategy r1, OnChangedCallback r2) {
        r0.performMotion(r1, r2);
    }

    static /* synthetic */ MotionStrategy access$500(ExtendedFloatingActionButton r0) {
        return r0.extendStrategy;
    }

    static /* synthetic */ MotionStrategy access$600(ExtendedFloatingActionButton r0) {
        return r0.showStrategy;
    }

    static /* synthetic */ boolean access$700(ExtendedFloatingActionButton r0) {
        return r0.isExtended;
    }

    static /* synthetic */ boolean access$702(ExtendedFloatingActionButton r0, boolean r1) {
        r0.isExtended = r1;
        return r1;
    }

    static /* synthetic */ boolean access$802(ExtendedFloatingActionButton r0, boolean r1) {
        r0.isTransforming = r1;
        return r1;
    }

    static /* synthetic */ int access$902(ExtendedFloatingActionButton r0, int r1) {
        r0.animState = r1;
        return r1;
    }

    private boolean isOrWillBeHidden() {
        int r0 = getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L8;
        if (r3 == 1) goto L6;
        return false;
    L6:
        return true;
    L8:
        if (r3 != 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean isOrWillBeShown() {
        int r0 = getVisibility();
        int r3 = this.animState;
        if (r0 != 0) goto L5;
        if (r3 != 1) goto L10;
        return false;
    L10:
        return true;
    L5:
        if (r3 == 2) goto L7;
        return false;
    L7:
        return true;
    }

    private void performMotion(@NonNull final MotionStrategy r3, @Nullable final OnChangedCallback r4) {
        if (r3.shouldCancel() == false) goto L6;
        return;
    L6:
        if (shouldAnimateVisibilityChange() == true) goto L9;
        r3.performNow();
        r3.onChange(r4);
        return;
    L9:
        measure(0, 0);
        AnimatorSet r0 = r3.createAnimator();
        r0.addListener(new AnonymousClass3(this, r3, r4));
        Iterator<Animator.AnimatorListener> r2 = r3.getListeners().iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        r0.addListener(r2.next());
        goto L11
    L13:
        r0.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this) == true) goto L9;
        if (isOrWillBeShown() == false) goto L7;
    L11:
        return false;
    L7:
        if (this.animateShowBeforeLayout == false) goto L11;
    L9:
        if (isInEditMode() == true) goto L11;
        return true;
    }

    public void addOnExtendAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.extendStrategy.addAnimationListener(r1);
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.hideStrategy.addAnimationListener(r1);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.showStrategy.addAnimationListener(r1);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.shrinkStrategy.addAnimationListener(r1);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(@NonNull OnChangedCallback r2) {
        performMotion(this.extendStrategy, r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int r0 = this.collapsedSize;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(@NonNull OnChangedCallback r2) {
        performMotion(this.hideStrategy, r2);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == true) goto L7;
        return;
    L7:
        if (getIcon() == null) goto L12;
        this.isExtended = false;
        this.shrinkStrategy.performNow();
        return;
    }

    public void removeOnExtendAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.extendStrategy.removeAnimationListener(r1);
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.hideStrategy.removeAnimationListener(r1);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.showStrategy.removeAnimationListener(r1);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator.AnimatorListener r1) {
        this.shrinkStrategy.removeAnimationListener(r1);
    }

    public void setAnimateShowBeforeLayout(boolean r1) {
        this.animateShowBeforeLayout = r1;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec r1) {
        this.extendStrategy.setMotionSpec(r1);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int r2) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public void setExtended(boolean r2) {
        if (this.isExtended != r2) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        MotionStrategy r1 = this.extendStrategy;
    L9:
        if (r1.shouldCancel() == false) goto L11;
        return;
    L11:
        r1.performNow();
        return;
    L7:
        r1 = this.shrinkStrategy;
        goto L9
    }

    public void setHideMotionSpec(@Nullable MotionSpec r1) {
        this.hideStrategy.setMotionSpec(r1);
    }

    public void setHideMotionSpecResource(@AnimatorRes int r2) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
        super.setPaddingRelative(r1, r2, r3, r4);
        if (this.isExtended == true) goto L5;
        return;
    L5:
        if (this.isTransforming == true) goto L9;
        this.extendedPaddingStart = r1;
        this.extendedPaddingEnd = r3;
        return;
    }

    public void setShowMotionSpec(@Nullable MotionSpec r1) {
        this.showStrategy.setMotionSpec(r1);
    }

    public void setShowMotionSpecResource(@AnimatorRes int r2) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec r1) {
        this.shrinkStrategy.setMotionSpec(r1);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int r2) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(@NonNull OnChangedCallback r2) {
        performMotion(this.showStrategy, r2);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(@NonNull OnChangedCallback r2) {
        performMotion(this.shrinkStrategy, r2);
    }

    protected void silentlyUpdateTextColor(@NonNull ColorStateList r1) {
        super.setTextColor(r1);
    }
}
