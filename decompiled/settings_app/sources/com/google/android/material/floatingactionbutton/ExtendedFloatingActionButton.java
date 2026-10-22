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
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Iterator;
import java.util.List;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: loaded from: classes3.dex */
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
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private final int collapsedSize;
    private final MotionStrategy extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    protected ColorStateList originalTextCsl;
    private final MotionStrategy showStrategy;
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
        public void onChange(OnChangedCallback r2) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (this.extending == false) goto L7;
            r2.onExtended(this.this$0);
            return;
        L7:
            r2.onShrunken(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            if (this.extending == false) goto L6;
            return R.animator.mtrl_extended_fab_change_size_expand_motion_spec;
        L6:
            return R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public AnimatorSet createAnimator() {
            MotionSpec r0 = getCurrentMotionSpec();
            if (r0.hasPropertyValues(MaterialConfigFormatNames.WIDTH) == false) goto L6;
            PropertyValuesHolder[] r2 = r0.getPropertyValues(MaterialConfigFormatNames.WIDTH);
            r2[0].setFloatValues(new float[]{this.this$0.getWidth(), this.size.getWidth()});
            r0.setPropertyValues(MaterialConfigFormatNames.WIDTH, r2);
        L6:
            if (r0.hasPropertyValues(MonthWeekEventsView.VIEW_PARAMS_HEIGHT) == false) goto L9;
            PropertyValuesHolder[] r3 = r0.getPropertyValues(MonthWeekEventsView.VIEW_PARAMS_HEIGHT);
            r3[0].setFloatValues(new float[]{this.this$0.getHeight(), this.size.getHeight()});
            r0.setPropertyValues(MonthWeekEventsView.VIEW_PARAMS_HEIGHT, r3);
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

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            ExtendedFloatingActionButton.access$702(this.this$0, this.extending);
            ExtendedFloatingActionButton.access$802(this.this$0, true);
            this.this$0.setHorizontallyScrolling(true);
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
        private OnChangedCallback internalAutoHideCallback;
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout r1, View r2, Rect r3) {
            return getInsetDodgeRect(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout r1, View r2, View r3) {
            return onDependentViewChanged(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return onLayoutChild(r1, (ExtendedFloatingActionButton) r2, r3);
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context r2, AttributeSet r3) {
            super(r2, r3);
            TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = r4.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = r4.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            r4.recycle();
        }

        public void setAutoHideEnabled(boolean r1) {
            this.autoHideEnabled = r1;
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public void setAutoShrinkEnabled(boolean r1) {
            this.autoShrinkEnabled = r1;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout r1, ExtendedFloatingActionButton r2, Rect r3) {
            return super.getInsetDodgeRect(r1, r2, r3);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams r1) {
            if (r1.dodgeInsetEdges != 0) goto L6;
            r1.dodgeInsetEdges = 80;
            return;
        }

        public boolean onDependentViewChanged(CoordinatorLayout r2, ExtendedFloatingActionButton r3, View r4) {
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

        private static boolean isBottomSheet(View r1) {
            ViewGroup.LayoutParams r2 = r1.getLayoutParams();
            if ((r2 instanceof CoordinatorLayout.LayoutParams) == true) goto L5;
            return false;
        L5:
            return ((CoordinatorLayout.LayoutParams) r2).getBehavior() instanceof BottomSheetBehavior;
        }

        void setInternalAutoHideCallback(OnChangedCallback r1) {
            this.internalAutoHideCallback = r1;
        }

        void setInternalAutoShrinkCallback(OnChangedCallback r1) {
            this.internalAutoShrinkCallback = r1;
        }

        private boolean shouldUpdateVisibility(View r3, ExtendedFloatingActionButton r4) {
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

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout r2, AppBarLayout r3, ExtendedFloatingActionButton r4) {
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

        private boolean updateFabVisibilityForBottomSheet(View r3, ExtendedFloatingActionButton r4) {
            if (shouldUpdateVisibility(r3, r4) == true) goto L6;
            return false;
        L6:
            CoordinatorLayout.LayoutParams r0 = (CoordinatorLayout.LayoutParams) r4.getLayoutParams();
            if (r3.getTop() >= ((r4.getHeight() / 2) + r0.topMargin)) goto L9;
            shrinkOrHide(r4);
            return true;
        L9:
            extendOrShow(r4);
            return true;
        }

        protected void shrinkOrHide(ExtendedFloatingActionButton r2) {
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

        protected void extendOrShow(ExtendedFloatingActionButton r2) {
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

        public boolean onLayoutChild(CoordinatorLayout r6, ExtendedFloatingActionButton r7, int r8) {
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
    }

    class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public HideStrategy(ExtendedFloatingActionButton r1, AnimatorTracker r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback r1) {
            if (r1 == null) goto L5;
            r1.onHidden(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1100(this.this$0);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            this.isCancelled = false;
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 1);
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
    }

    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton r1) {
        }

        public void onHidden(ExtendedFloatingActionButton r1) {
        }

        public void onShown(ExtendedFloatingActionButton r1) {
        }

        public void onShrunken(ExtendedFloatingActionButton r1) {
        }

        public OnChangedCallback() {
        }
    }

    class ShowStrategy extends BaseMotionStrategy {
        final /* synthetic */ ExtendedFloatingActionButton this$0;

        public ShowStrategy(ExtendedFloatingActionButton r1, AnimatorTracker r2) {
            this.this$0 = r1;
            super(r1, r2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            this.this$0.setVisibility(0);
            this.this$0.setAlpha(1.0f);
            this.this$0.setScaleY(1.0f);
            this.this$0.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback r1) {
            if (r1 == null) goto L5;
            r1.onShown(this.this$0);
            return;
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator r2) {
            super.onAnimationStart(r2);
            this.this$0.setVisibility(0);
            ExtendedFloatingActionButton.access$902(this.this$0, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$902(this.this$0, 0);
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

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
        final Class<Float> r1 = Float.class;
        final String r2 = MaterialConfigFormatNames.WIDTH;
        WIDTH = new AnonymousClass4(r1, r2);
        final Class<Float> r3 = Float.class;
        final String r4 = MonthWeekEventsView.VIEW_PARAMS_HEIGHT;
        HEIGHT = new AnonymousClass5(r3, r4);
        final Class<Float> r5 = Float.class;
        final String r6 = "paddingStart";
        PADDING_START = new AnonymousClass6(r5, r6);
        final Class<Float> r7 = Float.class;
        final String r8 = "paddingEnd";
        PADDING_END = new AnonymousClass7(r7, r8);
    }

    public ExtendedFloatingActionButton(Context r2) {
        this(r2, null);
    }

    public ExtendedFloatingActionButton(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(Context r17, AttributeSet r18, int r19) {
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

    @Override // android.widget.TextView
    public void setTextColor(int r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList r1) {
        super.setTextColor(r1);
        saveOriginalTextCsl();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    protected void silentlyUpdateTextColor(ColorStateList r1) {
        super.setTextColor(r1);
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

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
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

    public final boolean isExtended() {
        return this.isExtended;
    }

    public void setAnimateShowBeforeLayout(boolean r1) {
        this.animateShowBeforeLayout = r1;
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

    public void addOnShowAnimationListener(Animator.AnimatorListener r1) {
        this.showStrategy.addAnimationListener(r1);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener r1) {
        this.showStrategy.removeAnimationListener(r1);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener r1) {
        this.hideStrategy.addAnimationListener(r1);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener r1) {
        this.hideStrategy.removeAnimationListener(r1);
    }

    public void addOnShrinkAnimationListener(Animator.AnimatorListener r1) {
        this.shrinkStrategy.addAnimationListener(r1);
    }

    public void removeOnShrinkAnimationListener(Animator.AnimatorListener r1) {
        this.shrinkStrategy.removeAnimationListener(r1);
    }

    public void addOnExtendAnimationListener(Animator.AnimatorListener r1) {
        this.extendStrategy.addAnimationListener(r1);
    }

    public void removeOnExtendAnimationListener(Animator.AnimatorListener r1) {
        this.extendStrategy.removeAnimationListener(r1);
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public void hide(OnChangedCallback r2) {
        performMotion(this.hideStrategy, r2);
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void show(OnChangedCallback r2) {
        performMotion(this.showStrategy, r2);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    public void extend(OnChangedCallback r2) {
        performMotion(this.extendStrategy, r2);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void shrink(OnChangedCallback r2) {
        performMotion(this.shrinkStrategy, r2);
    }

    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    public void setShowMotionSpec(MotionSpec r1) {
        this.showStrategy.setMotionSpec(r1);
    }

    public void setShowMotionSpecResource(int r2) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    public void setHideMotionSpec(MotionSpec r1) {
        this.hideStrategy.setMotionSpec(r1);
    }

    public void setHideMotionSpecResource(int r2) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    public void setExtendMotionSpec(MotionSpec r1) {
        this.extendStrategy.setMotionSpec(r1);
    }

    public void setExtendMotionSpecResource(int r2) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void setShrinkMotionSpec(MotionSpec r1) {
        this.shrinkStrategy.setMotionSpec(r1);
    }

    public void setShrinkMotionSpecResource(int r2) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), r2));
    }

    private void performMotion(final MotionStrategy r3, final OnChangedCallback r4) {
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

    private boolean isOrWillBeShown() {
        if (getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    private boolean isOrWillBeHidden() {
        if (getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
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

    int getCollapsedSize() {
        int r0 = this.collapsedSize;
        if (r0 < 0) goto L5;
        return r0;
    L5:
        return (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize();
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }
}
