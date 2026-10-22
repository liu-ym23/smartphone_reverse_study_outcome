package com.obric.oui.titlebar.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.titlebar.OUnitedTitleBar;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BaseBehavior<T extends OUnitedTitleBar> extends HeaderBehavior<T> {
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private boolean coordinatorLayoutA11yScrollable;
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    public int offsetDelta;
    private BaseDragCallback onDragCallback;
    private SavedState savedState;

    public static abstract class BaseDragCallback<T extends OUnitedTitleBar> {
        public abstract boolean canDrag(T r1);

        public BaseDragCallback() {
        }
    }

    public static class Behavior extends BaseBehavior<OUnitedTitleBar> {

        public static abstract class DragCallback extends BaseDragCallback<OUnitedTitleBar> {
            public DragCallback() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return super.canDragView((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getMaxDragOffset(View r1) {
            return super.getMaxDragOffset((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r1) {
            return super.getScrollRangeForDragFling((OUnitedTitleBar) r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r1, View r2) {
            super.onFlingFinished(r1, (OUnitedTitleBar) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
            return super.onLayoutChild(r1, (OUnitedTitleBar) r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
            super.onNestedPreScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
            super.onNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7, r8);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, View r2, Parcelable r3) {
            super.onRestoreInstanceState(r1, (OUnitedTitleBar) r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, View r2) {
            return super.onSaveInstanceState(r1, (OUnitedTitleBar) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
            return super.onStartNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
            super.onStopNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.obric.oui.titlebar.behavior.BaseBehavior, com.obric.oui.titlebar.behavior.HeaderBehavior
        public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
            return super.setHeaderTopBottomOffset(r1, (OUnitedTitleBar) r2, r3, r4, r5);
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void onOffsetChanged(OUnitedTitleBar r1, View r2, float r3);

        public ChildScrollEffect() {
        }
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect;
        private final Rect relativeRect;

        public CompressChildScrollEffect() {
            this.relativeRect = new Rect();
            this.ghostRect = new Rect();
        }

        private static void updateRelativeRect(Rect r0, OUnitedTitleBar r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.obric.oui.titlebar.behavior.BaseBehavior.ChildScrollEffect
        public void onOffsetChanged(OUnitedTitleBar r4, View r5, float r6) {
            updateRelativeRect(this.relativeRect, r4, r5);
            float r7 = this.relativeRect.top - Math.abs(r6);
            if (r7 > 0.0f) goto L9;
            float r8 = 1.0f - MathUtils.clamp(Math.abs(r7 / this.relativeRect.height()), 0.0f, 1.0f);
            float r9 = (-r7) - ((this.relativeRect.height() * 0.3f) * (1.0f - (r8 * r8)));
            r5.setTranslationY(r9);
            r5.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-r9));
            if (r9 < this.ghostRect.height()) goto L7;
            r5.setVisibility(4);
        L8:
            ViewCompat.setClipBounds(r5, this.ghostRect);
            return;
        L7:
            r5.setVisibility(0);
            goto L8
        L9:
            ViewCompat.setClipBounds(r5, null);
            r5.setTranslationY(0.0f);
            r5.setVisibility(0);
        }
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_EFFECT_COMPRESS = 1;
        public static final int SCROLL_EFFECT_NONE = 0;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_NO_SCROLL = 0;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
        private ChildScrollEffect scrollEffect;
        int scrollFlags;
        Interpolator scrollInterpolator;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super(r3, r4);
            this.scrollFlags = 1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r5.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(0);
            if (r5.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator) == false) goto L5;
            this.scrollInterpolator = AnimationUtils.loadInterpolator(r3, r5.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
        L5:
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.scrollFlags = 1;
            this.scrollFlags = r2.scrollFlags;
            this.scrollEffect = r2.scrollEffect;
            this.scrollInterpolator = r2.scrollInterpolator;
        }

        public void setScrollFlags(int r1) {
            this.scrollFlags = r1;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
        }

        private ChildScrollEffect createScrollEffectFromInt(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new CompressChildScrollEffect();
        }

        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public void setScrollEffect(ChildScrollEffect r1) {
            this.scrollEffect = r1;
        }

        public void setScrollEffect(int r1) {
            this.scrollEffect = createScrollEffectFromInt(r1);
        }

        public void setScrollInterpolator(Interpolator r1) {
            this.scrollInterpolator = r1;
        }

        public Interpolator getScrollInterpolator() {
            return this.scrollInterpolator;
        }

        boolean isCollapsible() {
            int r2 = this.scrollFlags;
            if ((r2 & 1) == 1) goto L5;
        L7:
            return false;
        L5:
            if ((r2 & 10) == 0) goto L7;
            return true;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean firstVisibleChildAtMinimumHeight;
        int firstVisibleChildIndex;
        float firstVisibleChildPercentageShown;
        boolean fullyExpanded;
        boolean fullyScrolled;

        public SavedState(Parcel r3, ClassLoader r4) {
            super(r3, r4);
            boolean r0 = true;
            if (r3.readByte() == 0) goto L5;
            boolean r5 = true;
        L6:
            this.fullyScrolled = r5;
            if (r3.readByte() == 0) goto L9;
            boolean r6 = true;
        L10:
            this.fullyExpanded = r6;
            this.firstVisibleChildIndex = r3.readInt();
            this.firstVisibleChildPercentageShown = r3.readFloat();
            if (r3.readByte() != 0) goto L14;
            r0 = false;
        L14:
            this.firstVisibleChildAtMinimumHeight = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeByte(this.fullyScrolled ? 1 : 0);
            r1.writeByte(this.fullyExpanded ? 1 : 0);
            r1.writeInt(this.firstVisibleChildIndex);
            r1.writeFloat(this.firstVisibleChildPercentageShown);
            r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private static boolean checkFlag(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean access$000(BaseBehavior r0) {
        return r0.coordinatorLayoutA11yScrollable;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ boolean canDragView(View r1) {
        return canDragView((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getMaxDragOffset(View r1) {
        return getMaxDragOffset((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(View r1) {
        return getScrollRangeForDragFling((OUnitedTitleBar) r1);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ void onFlingFinished(CoordinatorLayout r1, View r2) {
        onFlingFinished(r1, (OUnitedTitleBar) r2);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior, com.obric.oui.titlebar.behavior.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r1, View r2, int r3) {
        return onLayoutChild(r1, (OUnitedTitleBar) r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout r1, View r2, int r3, int r4, int r5, int r6) {
        return onMeasureChild(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        onNestedPreScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int r6, int r7, int r8) {
        onNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(CoordinatorLayout r1, View r2, Parcelable r3) {
        onRestoreInstanceState(r1, (OUnitedTitleBar) r2, r3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(CoordinatorLayout r1, View r2) {
        return onSaveInstanceState(r1, (OUnitedTitleBar) r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r1, View r2, View r3, View r4, int r5, int r6) {
        return onStartNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4, r5, r6);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
        onStopNestedScroll(r1, (OUnitedTitleBar) r2, r3, r4);
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(CoordinatorLayout r1, View r2, int r3, int r4, int r5) {
        return setHeaderTopBottomOffset(r1, (OUnitedTitleBar) r2, r3, r4, r5);
    }

    public BaseBehavior() {
    }

    public BaseBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public boolean onStartNestedScroll(CoordinatorLayout r1, T r2, View r3, View r4, int r5, int r6) {
        if ((r5 & 2) != 0) goto L5;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L14;
        ValueAnimator r8 = this.offsetAnimator;
        if (r8 == null) goto L14;
        r8.cancel();
    L14:
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = r6;
        return r7;
    L5:
        if (r2.isLiftOnScroll() == false) goto L7;
    L8:
        r7 = true;
        goto L10
    L7:
        if (canScrollChildren(r1, r2, r3) == false) goto L9;
        goto L8
    }

    private boolean canScrollChildren(CoordinatorLayout r1, T r2, View r3) {
        if (r2.hasScrollableChildren() == true) goto L5;
    L7:
        return false;
    L5:
        if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
        return true;
    }

    public void onNestedPreScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int[] r12, int r13) {
        if (r11 == 0) goto L10;
        if (r11 >= 0) goto L5;
        int r14 = -r8.getTotalScrollRange();
        int r15 = r8.getDownNestedPreScrollRange() + r14;
    L6:
        int r4 = r14;
        int r5 = r15;
        if (r4 == r5) goto L10;
        r12[1] = scroll(r7, r8, r11, r4, r5);
        goto L10
    L5:
        r14 = -r8.getUpNestedPreScrollRange();
        r15 = 0;
    L10:
        if (r8.isLiftOnScroll() == false) goto L13;
        r8.setLiftedState(r8.shouldLift(r9));
        return;
    }

    public void onNestedScroll(CoordinatorLayout r7, T r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        if (r13 >= 0) goto L4;
        scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
    L4:
        if (r13 != 0) goto L7;
        updateAccessibilityActions(r7, r8);
        return;
    }

    public void onStopNestedScroll(CoordinatorLayout r2, T r3, View r4, int r5) {
        if (this.lastStartedType != 0) goto L5;
    L6:
        snapToChildIfNeeded(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L9;
        r3.setLiftedState(r3.shouldLift(r4));
    L9:
        this.lastNestedScrollingChildRef = new WeakReference(r4);
        return;
    L5:
        if (r5 != 1) goto L9;
        goto L6
    }

    public void setDragCallback(BaseDragCallback r1) {
        this.onDragCallback = r1;
    }

    private void animateOffsetTo(CoordinatorLayout r3, T r4, int r5, float r6) {
        int r0 = Math.abs(getTopBottomOffsetForScrollingSibling() - r5);
        float r7 = Math.abs(r6);
        if (r7 <= 0.0f) goto L5;
        int r8 = Math.round((r0 / r7) * 1000.0f) * 3;
    L6:
        animateOffsetWithDuration(r3, r4, r5, r8);
        return;
    L5:
        r8 = (int) (((r0 / r4.getHeight()) + 1.0f) * 150.0f);
        goto L6
    }

    private void animateOffsetWithDuration(final CoordinatorLayout r4, final T r5, int r6, int r7) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        if (r0 != r6) goto L10;
        ValueAnimator r8 = this.offsetAnimator;
        if (r8 != null) goto L7;
        return;
    L7:
        if (r8.isRunning() == false) goto L17;
        this.offsetAnimator.cancel();
        return;
    L17:
        return;
    L10:
        ValueAnimator r1 = this.offsetAnimator;
        if (r1 != null) goto L13;
        ValueAnimator r2 = new ValueAnimator();
        this.offsetAnimator = r2;
        r2.setInterpolator(com.google.android.material.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.offsetAnimator.addUpdateListener(new AnonymousClass1(this, r4, r5));
    L14:
        this.offsetAnimator.setDuration(Math.min(r7, 600));
        this.offsetAnimator.setIntValues(new int[]{r0, r6});
        this.offsetAnimator.start();
        return;
    L13:
        r1.cancel();
        goto L14
    }

    private int getChildIndexOnOffset(T r7, int r8) {
        int r6 = r7.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L12;
        View r1 = r7.getChildAt(r0);
        int r2 = r1.getTop();
        int r3 = r1.getBottom();
        LayoutParams r4 = (LayoutParams) r1.getLayoutParams();
        if (checkFlag(r4.getScrollFlags(), 32) == false) goto L7;
        r2 = r2 - r4.topMargin;
        r3 = r3 + r4.bottomMargin;
    L7:
        int r5 = -r8;
        if (r2 > r5) goto L11;
        if (r3 < r5) goto L11;
        return r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L12:
        return -1;
    }

    private void snapToChildIfNeeded(CoordinatorLayout r9, T r10) {
        int r0 = r10.getTopInset() + r10.getPaddingTop();
        int r1 = getTopBottomOffsetForScrollingSibling() - r0;
        int r2 = getChildIndexOnOffset(r10, r1);
        if (r2 < 0) goto L27;
        View r3 = r10.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        int r5 = r4.getScrollFlags();
        if ((r5 & 17) != 17) goto L28;
        int r6 = -r3.getTop();
        int r7 = -r3.getBottom();
        if (r2 != 0) goto L14;
        if (ViewCompat.getFitsSystemWindows(r10) == false) goto L14;
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L14;
        r6 = r6 - r10.getTopInset();
    L14:
        if (checkFlag(r5, 2) == false) goto L17;
        r7 = r7 + ViewCompat.getMinimumHeight(r3);
    L23:
        if (checkFlag(r5, 32) == false) goto L25;
        r6 = r6 + r4.topMargin;
        r7 = r7 - r4.bottomMargin;
    L25:
        animateOffsetTo(r9, r10, MathUtils.clamp(calculateSnapOffset(r1, r7, r6) + r0, -r10.getTotalScrollRange(), 0), 0.0f);
        return;
    L17:
        if (checkFlag(r5, 5) == false) goto L23;
        int r8 = ViewCompat.getMinimumHeight(r3) + r7;
        if (r1 >= r8) goto L21;
        r6 = r8;
        goto L23
    L21:
        r7 = r8;
        goto L23
    L28:
        return;
    }

    private int calculateSnapOffset(int r1, int r2, int r3) {
        if (r1 >= ((r2 + r3) / 2)) goto L6;
        return r2;
    L6:
        return r3;
    }

    public boolean onMeasureChild(CoordinatorLayout r7, T r8, int r9, int r10, int r11, int r12) {
        if (((CoordinatorLayout.LayoutParams) r8.getLayoutParams()).height != (-2)) goto L7;
        r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
        return true;
    L7:
        return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
    }

    public boolean onLayoutChild(CoordinatorLayout r8, T r9, int r10) {
        boolean r11 = super.onLayoutChild(r8, r9, r10);
        int r0 = r9.getPendingAction();
        SavedState r1 = this.savedState;
        if (r1 != null) goto L5;
    L17:
        if (r0 != 0) goto L19;
    L33:
        r9.resetPendingAction();
        this.savedState = null;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
        updateOUnitedTitleBarDrawableState(r8, r9, getTopAndBottomOffset(), 0, true);
        r9.dispatchOffsetChange(getTopAndBottomOffset());
        updateAccessibilityActions(r8, r9);
        return r11;
    L19:
        if ((r0 & 4) == 0) goto L21;
        boolean r2 = true;
    L23:
        if ((r0 & 1) == 0) goto L29;
        int r3 = -r9.getUpNestedPreScrollRange();
        if (r2 == false) goto L27;
        animateOffsetTo(r8, r9, r3, 0.0f);
        goto L33
    L27:
        setHeaderTopBottomOffset(r8, r9, r3);
        goto L33
    L29:
        if ((r0 & 16) == 0) goto L33;
        if (r2 == false) goto L32;
        animateOffsetTo(r8, r9, 0, 0.0f);
        goto L33
    L32:
        setHeaderTopBottomOffset(r8, r9, 0);
        goto L33
    L21:
        r2 = false;
        goto L23
    L5:
        if ((r0 & 8) != 0) goto L17;
        if (r1.fullyScrolled == false) goto L10;
        setHeaderTopBottomOffset(r8, r9, -r9.getTotalScrollRange());
        goto L33
    L10:
        if (this.savedState.fullyExpanded == false) goto L12;
        setHeaderTopBottomOffset(r8, r9, 0);
        goto L33
    L12:
        View r4 = r9.getChildAt(this.savedState.firstVisibleChildIndex);
        int r5 = -r4.getBottom();
        if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L15;
        int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
    L16:
        setHeaderTopBottomOffset(r8, r9, r5 + r6);
        goto L33
    L15:
        r6 = Math.round(r4.getHeight() * this.savedState.firstVisibleChildPercentageShown);
        goto L16
    }

    private void updateAccessibilityActions(CoordinatorLayout r3, T r4) {
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        if (r4.getTotalScrollRange() != 0) goto L5;
        return;
    L5:
        View r0 = getChildWithScrollingBehavior(r3);
        if (r0 != null) goto L9;
        return;
    L9:
        if (childrenHaveScrollFlags(r4) == true) goto L12;
        return;
    L12:
        if (ViewCompat.hasAccessibilityDelegate(r3) == true) goto L14;
        ViewCompat.setAccessibilityDelegate(r3, new AnonymousClass2(this));
    L14:
        this.coordinatorLayoutA11yScrollable = addAccessibilityScrollActions(r3, r4, r0);
    }

    private View getChildWithScrollingBehavior(CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        View r1 = r4.getChildAt(r0);
        if ((((CoordinatorLayout.LayoutParams) r1.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L6;
        r0 = r0 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    private boolean childrenHaveScrollFlags(OUnitedTitleBar r4) {
        int r3 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        if (((LayoutParams) r4.getChildAt(r1).getLayoutParams()).scrollFlags != 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean addAccessibilityScrollActions(final CoordinatorLayout r11, final T r12, final View r13) {
        boolean r3 = false;
        if (getTopBottomOffsetForScrollingSibling() == (-r12.getTotalScrollRange())) goto L6;
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        r3 = true;
    L6:
        if (getTopBottomOffsetForScrollingSibling() == 0) goto L14;
        if (r13.canScrollVertically(-1) == false) goto L12;
        final int r9 = -r12.getDownNestedPreScrollRange();
        if (r9 == 0) goto L14;
        ViewCompat.replaceAccessibilityAction(r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass3(this, r11, r12, r13, r9));
        return true;
    L12:
        addActionToExpand(r11, r12, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        return true;
    L14:
        return r3;
    }

    private void addActionToExpand(CoordinatorLayout r2, final T r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, final boolean r5) {
        ViewCompat.replaceAccessibilityAction(r2, r4, null, new AnonymousClass4(this, r3, r5));
    }

    public boolean canDragView(T r2) {
        BaseDragCallback r0 = this.onDragCallback;
        if (r0 != null) goto L5;
        WeakReference<View> r1 = this.lastNestedScrollingChildRef;
        if (r1 == null) goto L17;
        View r3 = r1.get();
        if (r3 != null) goto L11;
    L15:
        return false;
    L11:
        if (r3.isShown() == false) goto L15;
        if (r3.canScrollVertically(-1) == true) goto L15;
        return true;
    L17:
        return true;
    L5:
        return r0.canDrag(r2);
    }

    public void onFlingFinished(CoordinatorLayout r2, T r3) {
        snapToChildIfNeeded(r2, r3);
        if (r3.isLiftOnScroll() == false) goto L6;
        r3.setLiftedState(r3.shouldLift(findFirstScrollingChild(r2)));
        return;
    }

    public int getMaxDragOffset(T r1) {
        return (-r1.getDownNestedScrollRange()) + r1.getTopInset();
    }

    public int getScrollRangeForDragFling(T r1) {
        return r1.getTotalScrollRange();
    }

    public int setHeaderTopBottomOffset(CoordinatorLayout r9, T r10, int r11, int r12, int r13) {
        int r0 = getTopBottomOffsetForScrollingSibling();
        int r1 = 0;
        if (r12 == 0) goto L30;
        if (r0 < r12) goto L30;
        if (r0 > r13) goto L30;
        int r5 = MathUtils.clamp(r11, r12, r13);
        if (r0 != r5) goto L9;
    L31:
        updateAccessibilityActions(r9, r10);
        return r1;
    L9:
        if (r10.hasChildWithInterpolator() == false) goto L11;
        int r14 = interpolateOffset(r10, r5);
    L12:
        boolean r15 = setTopAndBottomOffset(r14);
        int r16 = r0 - r5;
        this.offsetDelta = r5 - r14;
        int r17 = 1;
        if (r15 == true) goto L15;
    L22:
        if (r15 == false) goto L24;
    L26:
        r10.dispatchOffsetChange(getTopAndBottomOffset());
        if (r5 >= r0) goto L29;
        r17 = -1;
    L29:
        updateOUnitedTitleBarDrawableState(r9, r10, r5, r17, false);
        r1 = r16;
        goto L31
    L24:
        if (r10.hasChildWithInterpolator() == false) goto L26;
        r9.dispatchDependentViewsChanged(r10);
    L15:
        if (r1 >= r10.getChildCount()) goto L22;
        LayoutParams r2 = (LayoutParams) r10.getChildAt(r1).getLayoutParams();
        ChildScrollEffect r3 = r2.getScrollEffect();
        if (r3 == null) goto L21;
        if ((r2.getScrollFlags() & 1) == 0) goto L21;
        r3.onOffsetChanged(r10, r10.getChildAt(r1), getTopAndBottomOffset());
    L21:
        r1 = r1 + 1;
        goto L15
    L11:
        r14 = r5;
    L30:
        this.offsetDelta = 0;
        goto L31
    }

    boolean isOffsetAnimatorRunning() {
        ValueAnimator r0 = this.offsetAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    private int interpolateOffset(T r8, int r9) {
        int r7 = Math.abs(r9);
        int r0 = r8.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        View r3 = r8.getChildAt(r2);
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        Interpolator r5 = r4.getScrollInterpolator();
        if (r7 < r3.getTop()) goto L20;
        if (r7 > r3.getBottom()) goto L20;
        if (r5 == null) goto L21;
        int r6 = r4.getScrollFlags();
        if ((r6 & 1) == 0) goto L15;
        r1 = 0 + ((r3.getHeight() + r4.topMargin) + r4.bottomMargin);
        if ((r6 & 2) == 0) goto L15;
        r1 = r1 - ViewCompat.getMinimumHeight(r3);
    L15:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L17;
        r1 = r1 - r8.getTopInset();
    L17:
        if (r1 <= 0) goto L21;
        float r10 = r1;
        return Integer.signum(r9) * (r3.getTop() + Math.round(r10 * r5.getInterpolation((r7 - r3.getTop()) / r10)));
    L20:
        r2 = r2 + 1;
    L21:
        return r9;
    }

    private void updateOUnitedTitleBarDrawableState(CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
        View r0 = getAppBarChildOnOffset(r7, r8);
        boolean r1 = false;
        if (r0 == null) goto L19;
        int r2 = ((LayoutParams) r0.getLayoutParams()).getScrollFlags();
        if ((r2 & 1) == 0) goto L19;
        int r3 = ViewCompat.getMinimumHeight(r0);
        if (r9 <= 0) goto L14;
        if ((r2 & 12) == 0) goto L14;
        if ((-r8) < ((r0.getBottom() - r3) - r7.getTopInset())) goto L19;
    L12:
        r1 = true;
    L14:
        if ((r2 & 2) == 0) goto L19;
        if ((-r8) >= ((r0.getBottom() - r3) - r7.getTopInset())) goto L12;
    L19:
        if (r7.isLiftOnScroll() == false) goto L21;
        r1 = r7.shouldLift(findFirstScrollingChild(r6));
    L21:
        boolean r11 = r7.setLiftedState(r1);
        if (r10 == true) goto L27;
        if (r11 == true) goto L25;
        return;
    L25:
        if (shouldJumpElevationState(r6, r7) == true) goto L27;
        return;
    L27:
        if (r7.getBackground() == null) goto L30;
        r7.getBackground().jumpToCurrentState();
    L30:
        if (r7.getForeground() == null) goto L33;
        r7.getForeground().jumpToCurrentState();
    L33:
        if (r7.getStateListAnimator() == null) goto L38;
        r7.getStateListAnimator().jumpToCurrentState();
        return;
    }

    private boolean shouldJumpElevationState(CoordinatorLayout r4, T r5) {
        List<View> r3 = r4.getDependents(r5);
        int r6 = r3.size();
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L11;
        CoordinatorLayout.Behavior r1 = ((CoordinatorLayout.LayoutParams) r3.get(r0).getLayoutParams()).getBehavior();
        if ((r1 instanceof ScrollingViewBehavior) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (((ScrollingViewBehavior) r1).getOverlayTop() == 0) goto L14;
        return true;
    L14:
        return false;
    L11:
        return false;
    }

    private static View getAppBarChildOnOffset(OUnitedTitleBar r4, int r5) {
        int r6 = Math.abs(r5);
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        View r2 = r4.getChildAt(r1);
        if (r6 < r2.getTop()) goto L9;
        if (r6 > r2.getBottom()) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private View findFirstScrollingChild(CoordinatorLayout r4) {
        int r3 = r4.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L13;
        View r1 = r4.getChildAt(r0);
        if ((r1 instanceof NestedScrollingChild) == true) goto L12;
        if ((r1 instanceof AbsListView) == true) goto L12;
        if ((r1 instanceof ScrollView) == true) goto L12;
        r0 = r0 + 1;
    L12:
        return r1;
    L13:
        return null;
    }

    @Override // com.obric.oui.titlebar.behavior.HeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.offsetDelta;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout r1, T r2) {
        Parcelable r3 = super.onSaveInstanceState(r1, r2);
        SavedState r0 = saveScrollState(r3, r2);
        if (r0 != null) goto L6;
        return r3;
    L6:
        return r0;
    }

    public void onRestoreInstanceState(CoordinatorLayout r2, T r3, Parcelable r4) {
        if ((r4 instanceof SavedState) == false) goto L5;
        restoreScrollState((SavedState) r4, true);
        super.onRestoreInstanceState(r2, r3, this.savedState.getSuperState());
        return;
    L5:
        super.onRestoreInstanceState(r2, r3, r4);
        this.savedState = null;
    }

    SavedState saveScrollState(Parcelable r7, T r8) {
        int r6 = getTopAndBottomOffset();
        int r0 = r8.getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        View r3 = r8.getChildAt(r2);
        int r4 = r3.getBottom() + r6;
        if ((r3.getTop() + r6) > 0) goto L25;
        if (r4 < 0) goto L25;
        if (r7 != null) goto L10;
        r7 = AbsSavedState.EMPTY_STATE;
    L10:
        SavedState r5 = new SavedState(r7);
        if (r6 != 0) goto L13;
        boolean r9 = true;
    L14:
        r5.fullyExpanded = r9;
        if (r5.fullyExpanded == false) goto L17;
    L19:
        boolean r10 = false;
    L20:
        r5.fullyScrolled = r10;
        r5.firstVisibleChildIndex = r2;
        if (r4 != (ViewCompat.getMinimumHeight(r3) + r8.getTopInset())) goto L23;
        r1 = true;
    L23:
        r5.firstVisibleChildAtMinimumHeight = r1;
        r5.firstVisibleChildPercentageShown = r4 / r3.getHeight();
        return r5;
    L17:
        if ((-r6) < r8.getTotalScrollRange()) goto L19;
        r10 = true;
        goto L20
    L13:
        r9 = false;
    L25:
        r2 = r2 + 1;
        goto L3
    L26:
        return null;
    }

    void restoreScrollState(SavedState r2, boolean r3) {
        if (this.savedState == null) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.savedState = r2;
    }
}
