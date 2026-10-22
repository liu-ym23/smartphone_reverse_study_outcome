package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int DEF_STYLE_RES = 0;
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;

    @Nullable
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;

    @Nullable
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private final List<LiftOnScrollListener> liftOnScrollListeners;

    @Nullable
    private WeakReference<View> liftOnScrollTargetView;

    @IdRes
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction;

    @Nullable
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

        @Nullable
        private WeakReference<View> lastNestedScrollingChildRef;
        private int lastStartedType;
        private ValueAnimator offsetAnimator;
        private int offsetDelta;
        private BaseDragCallback onDragCallback;
        private SavedState savedState;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public BaseDragCallback() {
            }

            public abstract boolean canDrag(@NonNull T r1);
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = null;
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;
            boolean fullyScrolled;

            static {
                CREATOR = new AnonymousClass1();
            }

            public SavedState(@NonNull Parcel r3, ClassLoader r4) {
                super(r3, r4);
                boolean r0 = true;
                if (r3.readByte() == 0) goto L5;
                boolean r5 = true;
            L6:
                this.fullyScrolled = r5;
                this.firstVisibleChildIndex = r3.readInt();
                this.firstVisibleChildPercentageShown = r3.readFloat();
                if (r3.readByte() != 0) goto L10;
                r0 = false;
            L10:
                this.firstVisibleChildAtMinimumHeight = r0;
                return;
            L5:
                r5 = false;
                goto L6
            }

            public SavedState(Parcelable r1) {
                super(r1);
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel r1, int r2) {
                super.writeToParcel(r1, r2);
                r1.writeByte(this.fullyScrolled ? 1 : 0);
                r1.writeInt(this.firstVisibleChildIndex);
                r1.writeFloat(this.firstVisibleChildPercentageShown);
                r1.writeByte(this.firstVisibleChildAtMinimumHeight ? 1 : 0);
            }
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        static /* synthetic */ int access$200(BaseBehavior r0) {
            return r0.offsetDelta;
        }

        private void addAccessibilityScrollActions(final CoordinatorLayout r10, @NonNull final T r11, @NonNull final View r12) {
            if (getTopBottomOffsetForScrollingSibling() == (-r11.getTotalScrollRange())) goto L8;
            if (r12.canScrollVertically(1) == false) goto L8;
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        L8:
            if (getTopBottomOffsetForScrollingSibling() != 0) goto L10;
            return;
        L10:
            if (r12.canScrollVertically(-1) == false) goto L14;
            final int r6 = -r11.getDownNestedPreScrollRange();
            if (r6 == 0) goto L17;
            ViewCompat.replaceAccessibilityAction(r10, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AnonymousClass2(this, r10, r11, r12, r6));
            return;
        L17:
            return;
        L14:
            addActionToExpand(r10, r11, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        }

        private void addActionToExpand(CoordinatorLayout r2, @NonNull final T r3, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat r4, final boolean r5) {
            ViewCompat.replaceAccessibilityAction(r2, r4, null, new AnonymousClass3(this, r3, r5));
        }

        private void animateOffsetTo(CoordinatorLayout r3, @NonNull T r4, int r5, float r6) {
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
            r2.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
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

        private boolean canScrollChildren(@NonNull CoordinatorLayout r1, @NonNull T r2, @NonNull View r3) {
            if (r2.hasScrollableChildren() == true) goto L5;
        L7:
            return false;
        L5:
            if ((r1.getHeight() - r3.getHeight()) > r2.getHeight()) goto L7;
            return true;
        }

        private static boolean checkFlag(int r0, int r1) {
            if ((r0 & r1) != r1) goto L5;
            return true;
        L5:
            return false;
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout r4) {
            int r3 = r4.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L13;
            View r1 = r4.getChildAt(r0);
            if ((r1 instanceof NestedScrollingChild) == true) goto L12;
            if ((r1 instanceof ListView) == true) goto L12;
            if ((r1 instanceof ScrollView) == true) goto L12;
            r0 = r0 + 1;
        L12:
            return r1;
        L13:
            return null;
        }

        @Nullable
        private static View getAppBarChildOnOffset(@NonNull AppBarLayout r4, int r5) {
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

        private int getChildIndexOnOffset(@NonNull T r7, int r8) {
            int r6 = r7.getChildCount();
            int r0 = 0;
        L3:
            if (r0 >= r6) goto L12;
            View r1 = r7.getChildAt(r0);
            int r2 = r1.getTop();
            int r3 = r1.getBottom();
            LayoutParams r4 = (LayoutParams) r1.getLayoutParams();
            if (checkFlag(r4.getScrollFlags(), 32) == false) goto L7;
            r2 = r2 - ((LinearLayout.LayoutParams) r4).topMargin;
            r3 = r3 + ((LinearLayout.LayoutParams) r4).bottomMargin;
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

        private int interpolateOffset(@NonNull T r8, int r9) {
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
            r1 = 0 + ((r3.getHeight() + ((LinearLayout.LayoutParams) r4).topMargin) + ((LinearLayout.LayoutParams) r4).bottomMargin);
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

        private boolean shouldJumpElevationState(@NonNull CoordinatorLayout r4, @NonNull T r5) {
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

        private void snapToChildIfNeeded(CoordinatorLayout r9, @NonNull T r10) {
            int r0 = getTopBottomOffsetForScrollingSibling();
            int r1 = getChildIndexOnOffset(r10, r0);
            if (r1 < 0) goto L26;
            View r2 = r10.getChildAt(r1);
            LayoutParams r3 = (LayoutParams) r2.getLayoutParams();
            int r4 = r3.getScrollFlags();
            if ((r4 & 17) != 17) goto L27;
            int r5 = -r2.getTop();
            int r6 = -r2.getBottom();
            if (r1 != (r10.getChildCount() - 1)) goto L10;
            r6 = r6 + (r10.getTopInset() + r10.getPaddingTop());
        L10:
            if (checkFlag(r4, 2) == false) goto L13;
            r6 = r6 + ViewCompat.getMinimumHeight(r2);
        L19:
            if (checkFlag(r4, 32) == false) goto L22;
            r5 = r5 + ((LinearLayout.LayoutParams) r3).topMargin;
            r6 = r6 - ((LinearLayout.LayoutParams) r3).bottomMargin;
        L22:
            if (r0 >= ((r6 + r5) / 2)) goto L24;
            r5 = r6;
        L24:
            animateOffsetTo(r9, r10, MathUtils.clamp(r5, -r10.getTotalScrollRange(), 0), 0.0f);
            return;
        L13:
            if (checkFlag(r4, 5) == false) goto L19;
            int r7 = ViewCompat.getMinimumHeight(r2) + r6;
            if (r0 >= r7) goto L17;
            r5 = r7;
            goto L19
        L17:
            r6 = r7;
            goto L19
        L27:
            return;
        }

        private void updateAccessibilityActions(CoordinatorLayout r3, @NonNull T r4) {
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View r0 = findFirstScrollingChild(r3);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r4.getTotalScrollRange() != 0) goto L8;
            return;
        L8:
            if ((((CoordinatorLayout.LayoutParams) r0.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior) == true) goto L10;
            return;
        L10:
            addAccessibilityScrollActions(r3, r4, r0);
        }

        private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout r6, @NonNull T r7, int r8, int r9, boolean r10) {
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
            if (r10 == true) goto L26;
            if (r11 == true) goto L25;
            return;
        L25:
            if (shouldJumpElevationState(r6, r7) == true) goto L26;
            return;
        L26:
            r7.jumpDrawablesToCurrentState();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ boolean canDragView(View r1) {
            return canDragView((AppBarLayout) r1);
        }

        boolean canDragView(T r2) {
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

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View r1) {
            return getMaxDragOffset((AppBarLayout) r1);
        }

        int getMaxDragOffset(@NonNull T r1) {
            return -r1.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View r1) {
            return getScrollRangeForDragFling((AppBarLayout) r1);
        }

        int getScrollRangeForDragFling(@NonNull T r1) {
            return r1.getTotalScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.offsetDelta;
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            ValueAnimator r0 = this.offsetAnimator;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isRunning() == false) goto L7;
            return true;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout r1, @NonNull View r2) {
            onFlingFinished(r1, (AppBarLayout) r2);
        }

        void onFlingFinished(@NonNull CoordinatorLayout r2, @NonNull T r3) {
            snapToChildIfNeeded(r2, r3);
            if (r3.isLiftOnScroll() == false) goto L6;
            r3.setLiftedState(r3.shouldLift(findFirstScrollingChild(r2)));
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
            return onLayoutChild(r1, (AppBarLayout) r2, r3);
        }

        public boolean onLayoutChild(@NonNull CoordinatorLayout r8, @NonNull T r9, int r10) {
            boolean r11 = super.onLayoutChild(r8, r9, r10);
            int r0 = r9.getPendingAction();
            SavedState r1 = this.savedState;
            if (r1 != null) goto L5;
        L15:
            if (r0 != 0) goto L17;
        L30:
            r9.resetPendingAction();
            this.savedState = null;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -r9.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(r8, r9, getTopAndBottomOffset(), 0, true);
            r9.onOffsetChanged(getTopAndBottomOffset());
            updateAccessibilityActions(r8, r9);
            return r11;
        L17:
            if ((r0 & 4) == 0) goto L19;
            boolean r2 = true;
        L21:
            if ((r0 & 2) == 0) goto L26;
            int r3 = -r9.getUpNestedPreScrollRange();
            if (r2 == true) goto L24;
        L9:
            setHeaderTopBottomOffset(r8, r9, r3);
            goto L30
        L24:
            animateOffsetTo(r8, r9, r3, 0.0f);
            goto L30
        L26:
            if ((r0 & 1) == 0) goto L30;
            if (r2 == false) goto L29;
            animateOffsetTo(r8, r9, 0, 0.0f);
            goto L30
        L29:
            setHeaderTopBottomOffset(r8, r9, 0);
            goto L30
        L19:
            r2 = false;
            goto L21
        L5:
            if ((r0 & 8) != 0) goto L15;
            if (r1.fullyScrolled == false) goto L10;
            r3 = -r9.getTotalScrollRange();
            goto L9
        L10:
            View r4 = r9.getChildAt(r1.firstVisibleChildIndex);
            int r5 = -r4.getBottom();
            if (this.savedState.firstVisibleChildAtMinimumHeight == false) goto L13;
            int r6 = ViewCompat.getMinimumHeight(r4) + r9.getTopInset();
        L14:
            setHeaderTopBottomOffset(r8, r9, r5 + r6);
            goto L30
        L13:
            r6 = Math.round(r4.getHeight() * this.savedState.firstVisibleChildPercentageShown);
            goto L14
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5, int r6) {
            return onMeasureChild(r1, (AppBarLayout) r2, r3, r4, r5, r6);
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r7, @NonNull T r8, int r9, int r10, int r11, int r12) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) r8.getLayoutParams())).height != (-2)) goto L7;
            r7.onMeasureChild(r8, r9, r10, View.MeasureSpec.makeMeasureSpec(0, 0), r12);
            return true;
        L7:
            return super.onMeasureChild(r7, r8, r9, r10, r11, r12);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int[] r6, int r7) {
            onNestedPreScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7);
        }

        public void onNestedPreScroll(CoordinatorLayout r7, @NonNull T r8, View r9, int r10, int r11, int[] r12, int r13) {
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

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
            onNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public void onNestedScroll(CoordinatorLayout r7, @NonNull T r8, View r9, int r10, int r11, int r12, int r13, int r14, int[] r15) {
            if (r13 >= 0) goto L4;
            r15[1] = scroll(r7, r8, r13, -r8.getDownNestedScrollRange(), 0);
        L4:
            if (r13 != 0) goto L7;
            updateAccessibilityActions(r7, r8);
            return;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2, Parcelable r3) {
            onRestoreInstanceState(r1, (AppBarLayout) r2, r3);
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r2, @NonNull T r3, Parcelable r4) {
            if ((r4 instanceof SavedState) == false) goto L5;
            SavedState r5 = (SavedState) r4;
            this.savedState = r5;
            super.onRestoreInstanceState(r2, r3, r5.getSuperState());
            return;
        L5:
            super.onRestoreInstanceState(r2, r3, r4);
            this.savedState = null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r1, @NonNull View r2) {
            return onSaveInstanceState(r1, (AppBarLayout) r2);
        }

        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r8, @NonNull T r9) {
            Parcelable r10 = super.onSaveInstanceState(r8, r9);
            int r0 = getTopAndBottomOffset();
            int r1 = r9.getChildCount();
            boolean r2 = false;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L17;
            View r4 = r9.getChildAt(r3);
            int r5 = r4.getBottom() + r0;
            if ((r4.getTop() + r0) > 0) goto L16;
            if (r5 < 0) goto L16;
            SavedState r6 = new SavedState(r10);
            if ((-getTopAndBottomOffset()) < r9.getTotalScrollRange()) goto L10;
            boolean r7 = true;
        L11:
            r6.fullyScrolled = r7;
            r6.firstVisibleChildIndex = r3;
            if (r5 != (ViewCompat.getMinimumHeight(r4) + r9.getTopInset())) goto L14;
            r2 = true;
        L14:
            r6.firstVisibleChildAtMinimumHeight = r2;
            r6.firstVisibleChildPercentageShown = r5 / r4.getHeight();
            return r6;
        L10:
            r7 = false;
        L16:
            r3 = r3 + 1;
            goto L3
        L17:
            return r10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3, View r4, int r5, int r6) {
            return onStartNestedScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6);
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull T r2, @NonNull View r3, View r4, int r5, int r6) {
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

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, @NonNull View r2, View r3, int r4) {
            onStopNestedScroll(r1, (AppBarLayout) r2, r3, r4);
        }

        public void onStopNestedScroll(CoordinatorLayout r2, @NonNull T r3, View r4, int r5) {
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

        public void setDragCallback(@Nullable BaseDragCallback r1) {
            this.onDragCallback = r1;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5) {
            return setHeaderTopBottomOffset(r1, (AppBarLayout) r2, r3, r4, r5);
        }

        int setHeaderTopBottomOffset(@NonNull CoordinatorLayout r9, @NonNull T r10, int r11, int r12, int r13) {
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
            r10.onOffsetChanged(getTopAndBottomOffset());
            if (r5 >= r0) goto L29;
            r17 = -1;
        L29:
            updateAppBarLayoutDrawableState(r9, r10, r5, r17, false);
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
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void onOffsetChanged(T r1, int r2);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
            public DragCallback() {
            }
        }

        public Behavior() {
        }

        public Behavior(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull AppBarLayout r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull AppBarLayout r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, @NonNull AppBarLayout r2, View r3, int r4, int r5, int[] r6, int r7) {
            super.onNestedPreScroll(r1, r2, r3, r4, r5, r6, r7);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r1, @NonNull AppBarLayout r2, View r3, int r4, int r5, int r6, int r7, int r8, int[] r9) {
            super.onNestedScroll(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout r1, @NonNull AppBarLayout r2, Parcelable r3) {
            super.onRestoreInstanceState(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r1, @NonNull AppBarLayout r2) {
            return super.onSaveInstanceState(r1, r2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull AppBarLayout r2, @NonNull View r3, View r4, int r5, int r6) {
            return super.onStartNestedScroll(r1, r2, r3, r4, r5, r6);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, @NonNull AppBarLayout r2, View r3, int r4) {
            super.onStopNestedScroll(r1, r2, r3, r4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(@Nullable BaseBehavior.BaseDragCallback r1) {
            super.setDragCallback(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }
    }

    public static abstract class ChildScrollEffect {
        public ChildScrollEffect() {
        }

        public abstract void onOffsetChanged(@NonNull AppBarLayout r1, @NonNull View r2, float r3);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {
        private static final float COMPRESS_DISTANCE_FACTOR = 0.3f;
        private final Rect ghostRect;
        private final Rect relativeRect;

        public CompressChildScrollEffect() {
            this.relativeRect = new Rect();
            this.ghostRect = new Rect();
        }

        private static void updateRelativeRect(Rect r0, AppBarLayout r1, View r2) {
            r2.getDrawingRect(r0);
            r1.offsetDescendantRectToMyCoords(r2, r0);
            r0.offset(0, -r1.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ChildScrollEffect
        public void onOffsetChanged(@NonNull AppBarLayout r3, @NonNull View r4, float r5) {
            updateRelativeRect(this.relativeRect, r3, r4);
            float r6 = this.relativeRect.top - Math.abs(r5);
            if (r6 > 0.0f) goto L5;
            float r7 = 1.0f - MathUtils.clamp(Math.abs(r6 / this.relativeRect.height()), 0.0f, 1.0f);
            float r8 = (-r6) - ((this.relativeRect.height() * COMPRESS_DISTANCE_FACTOR) * (1.0f - (r7 * r7)));
            r4.setTranslationY(r8);
            r4.getDrawingRect(this.ghostRect);
            this.ghostRect.offset(0, (int) (-r8));
            ViewCompat.setClipBounds(r4, this.ghostRect);
            return;
        L5:
            ViewCompat.setClipBounds(r4, null);
            r4.setTranslationY(0.0f);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        private static final int SCROLL_EFFECT_COMPRESS = 1;
        private static final int SCROLL_EFFECT_NONE = 0;
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
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface ScrollFlags {
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.scrollFlags = 1;
        }

        public LayoutParams(int r1, int r2, float r3) {
            super(r1, r2, r3);
            this.scrollFlags = 1;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            super(r4, r5);
            this.scrollFlags = 1;
            TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.AppBarLayout_Layout);
            this.scrollFlags = r6.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            setScrollEffect(createScrollEffectFromInt(r6.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int r0 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (r6.hasValue(r0) == false) goto L5;
            this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(r4, r6.getResourceId(r0, 0));
        L5:
            r6.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams r1) {
            super(r1);
            this.scrollFlags = 1;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams r2) {
            super(r2);
            this.scrollFlags = 1;
            this.scrollFlags = r2.scrollFlags;
            this.scrollInterpolator = r2.scrollInterpolator;
        }

        @Nullable
        private ChildScrollEffect createScrollEffectFromInt(int r1) {
            if (r1 == 1) goto L7;
            return null;
        L7:
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect getScrollEffect() {
            return this.scrollEffect;
        }

        public int getScrollFlags() {
            return this.scrollFlags;
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

        public void setScrollEffect(@Nullable ChildScrollEffect r1) {
            this.scrollEffect = r1;
        }

        public void setScrollFlags(int r1) {
            this.scrollFlags = r1;
        }

        public void setScrollInterpolator(Interpolator r1) {
            this.scrollInterpolator = r1;
        }
    }

    public interface LiftOnScrollListener {
        void onUpdate(@Dimension float r1, @ColorInt int r2);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        void onOffsetChanged(AppBarLayout r1, int r2);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context r2, AttributeSet r3) {
            super(r2, r3);
            TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(r4.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            r4.recycle();
        }

        private static int getAppBarLayoutOffset(@NonNull AppBarLayout r1) {
            CoordinatorLayout.Behavior r2 = ((CoordinatorLayout.LayoutParams) r1.getLayoutParams()).getBehavior();
            if ((r2 instanceof BaseBehavior) == true) goto L5;
            return 0;
        L5:
            return ((BaseBehavior) r2).getTopBottomOffsetForScrollingSibling();
        }

        private void offsetChildAsNeeded(@NonNull View r4, @NonNull View r5) {
            CoordinatorLayout.Behavior r0 = ((CoordinatorLayout.LayoutParams) r5.getLayoutParams()).getBehavior();
            if ((r0 instanceof BaseBehavior) == false) goto L6;
            ViewCompat.offsetTopAndBottom(r4, (((r5.getBottom() - r4.getTop()) + BaseBehavior.access$200((BaseBehavior) r0)) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(r5));
            return;
        }

        private void updateLiftedStateIfNeeded(View r1, View r2) {
            if ((r2 instanceof AppBarLayout) == false) goto L8;
            AppBarLayout r3 = (AppBarLayout) r2;
            if (r3.isLiftOnScroll() == false) goto L9;
            r3.setLiftedState(r3.shouldLift(r1));
            return;
        L9:
            return;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        /* bridge */ /* synthetic */ View findFirstDependency(@NonNull List r1) {
            return findFirstDependency(r1);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        @Nullable
        AppBarLayout findFirstDependency(@NonNull List<View> r4) {
            int r3 = r4.size();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            View r1 = r4.get(r0);
            if ((r1 instanceof AppBarLayout) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return (AppBarLayout) r1;
        L9:
            return null;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View r4) {
            if ((r4 instanceof AppBarLayout) == false) goto L13;
            AppBarLayout r5 = (AppBarLayout) r4;
            int r3 = r5.getTotalScrollRange();
            int r1 = r5.getDownNestedPreScrollRange();
            int r6 = getAppBarLayoutOffset(r5);
            if (r1 != 0) goto L7;
        L9:
            int r7 = r3 - r1;
            if (r7 == 0) goto L13;
            return (r6 / r7) + 1.0f;
        L7:
            if ((r3 + r6) > r1) goto L9;
            return 0.0f;
        L13:
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int getScrollRange(View r2) {
            if ((r2 instanceof AppBarLayout) == false) goto L7;
            return ((AppBarLayout) r2).getTotalScrollRange();
        L7:
            return super.getScrollRange(r2);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isHorizontalOffsetEnabled() {
            return super.isHorizontalOffsetEnabled();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean isVerticalOffsetEnabled() {
            return super.isVerticalOffsetEnabled();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout r1, View r2, View r3) {
            return r3 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3) {
            offsetChildAsNeeded(r2, r3);
            updateLiftedStateIfNeeded(r2, r3);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout r1, @NonNull View r2, @NonNull View r3) {
            if ((r3 instanceof AppBarLayout) == false) goto L6;
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            return;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3) {
            return super.onLayoutChild(r1, r2, r3);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout r1, @NonNull View r2, int r3, int r4, int r5, int r6) {
            return super.onMeasureChild(r1, r2, r3, r4, r5, r6);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r4, @NonNull View r5, @NonNull Rect r6, boolean r7) {
            AppBarLayout r0 = findFirstDependency(r4.getDependencies(r5));
            if (r0 == null) goto L8;
            r6.offset(r5.getLeft(), r5.getTop());
            Rect r3 = this.tempRect1;
            r3.set(0, 0, r4.getWidth(), r4.getHeight());
            if (r3.contains(r6) == true) goto L8;
            r0.setExpanded(false, !r7);
            return true;
        L8:
            return false;
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setHorizontalOffsetEnabled(boolean r1) {
            super.setHorizontalOffsetEnabled(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int r1) {
            return super.setLeftAndRightOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int r1) {
            return super.setTopAndBottomOffset(r1);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ void setVerticalOffsetEnabled(boolean r1) {
            super.setVerticalOffsetEnabled(r1);
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_AppBarLayout;
    }

    public AppBarLayout(@NonNull Context r2) {
        this(r2, null);
    }

    public AppBarLayout(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.appBarLayoutStyle);
    }

    public AppBarLayout(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        int r4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r11, r12, r13, r4), r12, r13);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        this.liftOnScrollListeners = new ArrayList();
        Context r7 = getContext();
        setOrientation(1);
        int r8 = Build.VERSION.SDK_INT;
        if (r8 >= 21) goto L5;
    L8:
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r7, r12, R.styleable.AppBarLayout, r13, r4, new int[0]);
        ViewCompat.setBackground(this, r14.getDrawable(R.styleable.AppBarLayout_android_background));
        if ((getBackground() instanceof ColorDrawable) == false) goto L11;
        ColorDrawable r15 = (ColorDrawable) getBackground();
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        r0.setFillColor(ColorStateList.valueOf(r15.getColor()));
        r0.initializeElevationOverlay(r7);
        ViewCompat.setBackground(this, r0);
    L11:
        int r16 = R.styleable.AppBarLayout_expanded;
        if (r14.hasValue(r16) == false) goto L14;
        setExpanded(r14.getBoolean(r16, false), false, false);
    L14:
        if (r8 < 21) goto L19;
        int r17 = R.styleable.AppBarLayout_elevation;
        if (r14.hasValue(r17) == false) goto L19;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r14.getDimensionPixelSize(r17, 0));
    L19:
        if (r8 < 26) goto L26;
        int r18 = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
        if (r14.hasValue(r18) == false) goto L23;
        setKeyboardNavigationCluster(r14.getBoolean(r18, false));
    L23:
        int r19 = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
        if (r14.hasValue(r19) == false) goto L26;
        setTouchscreenBlocksFocus(r14.getBoolean(r19, false));
    L26:
        this.liftOnScroll = r14.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = r14.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(r14.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        r14.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1(this));
        return;
    L5:
        if (getOutlineProvider() != ViewOutlineProvider.BACKGROUND) goto L7;
        ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
    L7:
        ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, r12, r13, r4);
        goto L8
    }

    static /* synthetic */ Drawable access$000(AppBarLayout r0) {
        return r0.statusBarForeground;
    }

    static /* synthetic */ List access$100(AppBarLayout r0) {
        return r0.liftOnScrollListeners;
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> r0 = this.liftOnScrollTargetView;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.liftOnScrollTargetView = null;
    }

    @Nullable
    private View findLiftOnScrollTargetView(@Nullable View r4) {
        if (this.liftOnScrollTargetView != null) goto L15;
        int r0 = this.liftOnScrollTargetViewId;
        if (r0 == (-1)) goto L15;
        if (r4 == null) goto L8;
        View r5 = r4.findViewById(r0);
    L9:
        if (r5 == null) goto L11;
    L13:
        if (r5 == null) goto L15;
        this.liftOnScrollTargetView = new WeakReference(r5);
        goto L15
    L11:
        if ((getParent() instanceof ViewGroup) == false) goto L13;
        r5 = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
        goto L13
    L8:
        r5 = null;
    L15:
        WeakReference<View> r3 = this.liftOnScrollTargetView;
        if (r3 != null) goto L18;
        return null;
    L18:
        return r3.get();
    }

    private boolean hasCollapsibleChild() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((LayoutParams) getChildAt(r2).getLayoutParams()).isCollapsible() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    private void setExpanded(boolean r2, boolean r3, boolean r4) {
        if (r2 == false) goto L4;
        int r5 = 1;
    L5:
        int r0 = 0;
        if (r3 == false) goto L8;
        int r6 = 4;
    L9:
        int r7 = r5 | r6;
        if (r4 == false) goto L12;
        r0 = 8;
    L12:
        this.pendingAction = r7 | r0;
        requestLayout();
        return;
    L8:
        r6 = 0;
        goto L9
    L4:
        r5 = 2;
        goto L5
    }

    private boolean setLiftableState(boolean r2) {
        if (this.liftable == r2) goto L6;
        this.liftable = r2;
        refreshDrawableState();
        return true;
    L6:
        return false;
    }

    private boolean shouldDrawStatusBarForeground() {
        if (this.statusBarForeground != null) goto L5;
    L7:
        return false;
    L5:
        if (getTopInset() <= 0) goto L7;
        return true;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) goto L10;
        View r3 = getChildAt(0);
        if (r3.getVisibility() != 8) goto L7;
        return false;
    L7:
        if (ViewCompat.getFitsSystemWindows(r3) == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void startLiftOnScrollElevationOverlayAnimation(@NonNull final MaterialShapeDrawable r4, boolean r5) {
        float r0 = getResources().getDimension(R.dimen.design_appbar_elevation);
        if (r5 == false) goto L5;
        float r2 = 0.0f;
    L6:
        if (r5 == true) goto L9;
        r0 = 0.0f;
    L9:
        ValueAnimator r6 = this.elevationOverlayAnimator;
        if (r6 == null) goto L12;
        r6.cancel();
    L12:
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{r2, r0});
        this.elevationOverlayAnimator = r7;
        r7.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        this.elevationOverlayAnimator.addUpdateListener(new AnonymousClass2(this, r4));
        this.elevationOverlayAnimator.start();
        return;
    L5:
        r2 = r0;
        goto L6
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addLiftOnScrollListener(@NonNull LiftOnScrollListener r1) {
        this.liftOnScrollListeners.add(r1);
    }

    public void addOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r2) {
        if (this.listeners != null) goto L5;
        this.listeners = new ArrayList();
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (this.listeners.contains(r2) == true) goto L11;
        this.listeners.add(r2);
        return;
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener r1) {
        addOnOffsetChangedListener(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public void clearLiftOnScrollListener() {
        this.liftOnScrollListeners.clear();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas r4) {
        super.draw(r4);
        if (shouldDrawStatusBarForeground() == false) goto L6;
        int r0 = r4.save();
        r4.translate(0.0f, -this.currentOffset);
        this.statusBarForeground.draw(r4);
        r4.restoreToCount(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.statusBarForeground;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStateful() == true) goto L7;
        return;
    L7:
        if (r1.setState(r0) == false) goto L12;
        invalidateDrawable(r1);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r2) {
        return new LayoutParams(getContext(), r2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if (Build.VERSION.SDK_INT < 19) goto L9;
        if ((r2 instanceof LinearLayout.LayoutParams) == false) goto L9;
        return new LayoutParams((LinearLayout.LayoutParams) r2);
    L9:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L13:
        return new LayoutParams(r2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int r0 = this.downPreScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount() - 1;
        int r2 = 0;
    L6:
        if (r1 < 0) goto L25;
        View r3 = getChildAt(r1);
        LayoutParams r4 = (LayoutParams) r3.getLayoutParams();
        int r5 = r3.getMeasuredHeight();
        int r6 = r4.scrollFlags;
        if ((r6 & 5) != 5) goto L22;
        int r7 = ((LinearLayout.LayoutParams) r4).topMargin + ((LinearLayout.LayoutParams) r4).bottomMargin;
        if ((r6 & 8) == 0) goto L14;
        int r8 = ViewCompat.getMinimumHeight(r3);
    L12:
        int r9 = r7 + r8;
    L17:
        if (r1 == 0) goto L19;
    L21:
        r2 = r2 + r9;
    L24:
        r1 = r1 - 1;
        goto L6
    L19:
        if (ViewCompat.getFitsSystemWindows(r3) == false) goto L21;
        r9 = Math.min(r9, r5 - getTopInset());
        goto L21
    L14:
        if ((r6 & 2) == 0) goto L16;
        r8 = r5 - ViewCompat.getMinimumHeight(r3);
        goto L12
    L16:
        r9 = r7 + r5;
        goto L17
    L22:
        if (r2 <= 0) goto L24;
    L25:
        int r10 = Math.max(0, r2);
        this.downPreScrollRange = r10;
        return r10;
    }

    int getDownNestedScrollRange() {
        int r0 = this.downScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L13;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        int r6 = r4.getMeasuredHeight() + (((LinearLayout.LayoutParams) r5).topMargin + ((LinearLayout.LayoutParams) r5).bottomMargin);
        int r7 = r5.scrollFlags;
        if ((r7 & 1) == 0) goto L13;
        r3 = r3 + r6;
        if ((r7 & 2) != 0) goto L11;
        r2 = r2 + 1;
        goto L6
    L11:
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L13:
        int r8 = Math.max(0, r3);
        this.downScrollRange = r8;
        return r8;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int r0 = getTopInset();
        int r1 = ViewCompat.getMinimumHeight(this);
        if (r1 != 0) goto L5;
        int r2 = getChildCount();
        if (r2 < 1) goto L9;
        r1 = ViewCompat.getMinimumHeight(getChildAt(r2 - 1));
    L10:
        if (r1 != 0) goto L5;
        return getHeight() / 3;
    L9:
        r1 = 0;
    L5:
        return (r1 * 2) + r0;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    final int getTopInset() {
        WindowInsetsCompat r0 = this.lastInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSystemWindowInsetTop();
    }

    public final int getTotalScrollRange() {
        int r0 = this.totalScrollRange;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = getChildCount();
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L18;
        View r4 = getChildAt(r2);
        LayoutParams r5 = (LayoutParams) r4.getLayoutParams();
        int r6 = r4.getMeasuredHeight();
        int r7 = r5.scrollFlags;
        if ((r7 & 1) == 0) goto L18;
        r3 = r3 + ((r6 + ((LinearLayout.LayoutParams) r5).topMargin) + ((LinearLayout.LayoutParams) r5).bottomMargin);
        if (r2 != 0) goto L15;
        if (ViewCompat.getFitsSystemWindows(r4) == false) goto L15;
        r3 = r3 - getTopInset();
    L15:
        if ((r7 & 2) != 0) goto L16;
        r2 = r2 + 1;
        goto L6
    L16:
        r3 = r3 - ViewCompat.getMinimumHeight(r4);
    L18:
        int r8 = Math.max(0, r3);
        this.totalScrollRange = r8;
        return r8;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
        if (getTotalScrollRange() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isLifted() {
        return this.lifted;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int r5) {
        if (this.tmpStatesArray != null) goto L5;
        this.tmpStatesArray = new int[4];
    L5:
        int[] r0 = this.tmpStatesArray;
        int[] r6 = super.onCreateDrawableState(r5 + r0.length);
        boolean r2 = this.liftable;
        int r3 = R.attr.state_liftable;
        if (r2 == true) goto L9;
        r3 = -r3;
    L9:
        r0[0] = r3;
        if (r2 == true) goto L12;
    L14:
        int r4 = -R.attr.state_lifted;
    L15:
        r0[1] = r4;
        int r7 = R.attr.state_collapsible;
        if (r2 == true) goto L19;
        r7 = -r7;
    L19:
        r0[2] = r7;
        if (r2 == true) goto L22;
    L24:
        int r8 = -R.attr.state_collapsed;
    L25:
        r0[3] = r8;
        return LinearLayout.mergeDrawableStates(r6, r0);
    L22:
        if (this.lifted == false) goto L24;
        r8 = R.attr.state_collapsed;
        goto L25
    L12:
        if (this.lifted == false) goto L14;
        r4 = R.attr.state_lifted;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        boolean r6 = true;
        if (ViewCompat.getFitsSystemWindows(this) == true) goto L5;
    L9:
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int r7 = getChildCount();
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L15;
        if (((LayoutParams) getChildAt(r8).getLayoutParams()).getScrollInterpolator() != null) goto L13;
        r8 = r8 + 1;
        goto L10
    L13:
        this.haveChildWithInterpolator = true;
    L15:
        Drawable r9 = this.statusBarForeground;
        if (r9 == null) goto L19;
        r9.setBounds(0, 0, getWidth(), getTopInset());
    L19:
        if (this.liftableOverride == false) goto L21;
        return;
    L21:
        if (this.liftOnScroll == false) goto L23;
    L26:
        setLiftableState(r6);
        return;
    L23:
        if (hasCollapsibleChild() == true) goto L26;
        r6 = false;
        goto L26
    L5:
        if (shouldOffsetFirstChild() == false) goto L9;
        int r10 = getTopInset();
        int r11 = getChildCount() - 1;
    L7:
        if (r11 < 0) goto L9;
        ViewCompat.offsetTopAndBottom(getChildAt(r11), r10);
        r11 = r11 - 1;
        goto L7
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getMode(r4);
        if (r5 != 1073741824) goto L5;
    L15:
        invalidateScrollRanges();
        return;
    L5:
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L15;
        if (shouldOffsetFirstChild() == false) goto L15;
        int r0 = getMeasuredHeight();
        if (r5 == Integer.MIN_VALUE) goto L13;
        if (r5 != 0) goto L14;
        r0 = r0 + getTopInset();
    L14:
        setMeasuredDimension(getMeasuredWidth(), r0);
        goto L15
    L13:
        r0 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(r4));
        goto L14
    }

    void onOffsetChanged(int r4) {
        this.currentOffset = r4;
        if (willNotDraw() == true) goto L5;
        ViewCompat.postInvalidateOnAnimation(this);
    L5:
        List<BaseOnOffsetChangedListener> r0 = this.listeners;
        if (r0 == null) goto L13;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L17;
        BaseOnOffsetChangedListener r3 = this.listeners.get(r1);
        if (r3 == null) goto L12;
        r3.onOffsetChanged(this, r4);
    L12:
        r1 = r1 + 1;
        goto L8
    L17:
        return;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat r3) {
        if (ViewCompat.getFitsSystemWindows(this) == false) goto L5;
        WindowInsetsCompat r0 = r3;
    L7:
        if (ObjectsCompat.equals(this.lastInsets, r0) == true) goto L9;
        this.lastInsets = r0;
        updateWillNotDraw();
        requestLayout();
    L9:
        return r3;
    L5:
        r0 = null;
        goto L7
    }

    public boolean removeLiftOnScrollListener(@NonNull LiftOnScrollListener r1) {
        return this.liftOnScrollListeners.remove(r1);
    }

    public void removeOnOffsetChangedListener(@Nullable BaseOnOffsetChangedListener r1) {
        List<BaseOnOffsetChangedListener> r0 = this.listeners;
        if (r0 == null) goto L7;
        if (r1 == null) goto L8;
        r0.remove(r1);
        return;
    L8:
        return;
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener r1) {
        removeOnOffsetChangedListener(r1);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r1) {
        super.setElevation(r1);
        MaterialShapeUtils.setElevation(this, r1);
    }

    public void setExpanded(boolean r2) {
        setExpanded(r2, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean r2, boolean r3) {
        setExpanded(r2, r3, true);
    }

    public void setLiftOnScroll(boolean r1) {
        this.liftOnScroll = r1;
    }

    public void setLiftOnScrollTargetViewId(@IdRes int r1) {
        this.liftOnScrollTargetViewId = r1;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean r2) {
        this.liftableOverride = true;
        return setLiftableState(r2);
    }

    public void setLiftableOverrideEnabled(boolean r1) {
        this.liftableOverride = r1;
    }

    public boolean setLifted(boolean r2) {
        return setLiftedState(r2, true);
    }

    boolean setLiftedState(boolean r2) {
        return setLiftedState(r2, !this.liftableOverride);
    }

    boolean setLiftedState(boolean r1, boolean r2) {
        if (r2 == true) goto L4;
        return false;
    L4:
        if (this.lifted == r1) goto L16;
        this.lifted = r1;
        refreshDrawableState();
        if (this.liftOnScroll == true) goto L8;
        return true;
    L8:
        if ((getBackground() instanceof MaterialShapeDrawable) == false) goto L15;
        startLiftOnScrollElevationOverlayAnimation((MaterialShapeDrawable) getBackground(), r1);
        return true;
    L15:
        return true;
    L16:
        return false;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int r2) {
        if (r2 != 1) goto L7;
        super.setOrientation(r2);
        return;
    L7:
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable r3) {
        Drawable r0 = this.statusBarForeground;
        if (r0 == r3) goto L21;
        Drawable r1 = null;
        if (r0 == null) goto L7;
        r0.setCallback(null);
    L7:
        if (r3 == null) goto L9;
        r1 = r3.mutate();
    L9:
        this.statusBarForeground = r1;
        if (r1 != null) goto L12;
    L19:
        updateWillNotDraw();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        if (r1.isStateful() == false) goto L14;
        this.statusBarForeground.setState(getDrawableState());
    L14:
        DrawableCompat.setLayoutDirection(this.statusBarForeground, ViewCompat.getLayoutDirection(this));
        Drawable r4 = this.statusBarForeground;
        if (getVisibility() != 0) goto L17;
        boolean r2 = true;
    L18:
        r4.setVisible(r2, false);
        this.statusBarForeground.setCallback(this);
        goto L19
    L17:
        r2 = false;
        goto L18
    }

    public void setStatusBarForegroundColor(@ColorInt int r2) {
        setStatusBarForeground(new ColorDrawable(r2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int r2) {
        setStatusBarForeground(AppCompatResources.getDrawable(getContext(), r2));
    }

    @Deprecated
    public void setTargetElevation(float r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, r3);
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        Drawable r1 = this.statusBarForeground;
        if (r1 == null) goto L10;
        r1.setVisible(r3, false);
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    boolean shouldLift(@Nullable View r1) {
        View r0 = findLiftOnScrollTargetView(r1);
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.canScrollVertically(-1) == false) goto L10;
    L11:
        return true;
    L10:
        if (r1.getScrollY() <= 0) goto L12;
        goto L11
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.statusBarForeground) goto L8;
        return false;
    }
}
