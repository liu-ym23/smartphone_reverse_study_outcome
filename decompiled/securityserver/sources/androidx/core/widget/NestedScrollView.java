package androidx.core.widget;

import a.a;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3, NestedScrollingChild3, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = null;
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = null;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View r1, AccessibilityEvent r2) {
            super.onInitializeAccessibilityEvent(r1, r2);
            NestedScrollView r3 = (NestedScrollView) r1;
            r2.setClassName(ScrollView.class.getName());
            if (r3.getScrollRange() <= 0) goto L5;
            boolean r0 = true;
        L6:
            r2.setScrollable(r0);
            r2.setScrollX(r3.getScrollX());
            r2.setScrollY(r3.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(r2, r3.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(r2, r3.getScrollRange());
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            NestedScrollView r4 = (NestedScrollView) r2;
            r3.setClassName(ScrollView.class.getName());
            if (r4.isEnabled() == false) goto L13;
            int r1 = r4.getScrollRange();
            if (r1 <= 0) goto L14;
            r3.setScrollable(true);
            if (r4.getScrollY() <= 0) goto L10;
            r3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            r3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
        L10:
            if (r4.getScrollY() >= r1) goto L15;
            r3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            r3.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            return;
        L15:
            return;
        L14:
            return;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View r2, int r3, Bundle r4) {
            if (super.performAccessibilityAction(r2, r3, r4) == false) goto L5;
            return true;
        L5:
            NestedScrollView r5 = (NestedScrollView) r2;
            if (r5.isEnabled() == true) goto L9;
            return false;
        L9:
            if (r3 != 4096) goto L11;
        L22:
            int r1 = (r5.getHeight() - r5.getPaddingBottom()) - r5.getPaddingTop();
            int r6 = Math.min(r5.getScrollY() + r1, r5.getScrollRange());
            if (r6 == r5.getScrollY()) goto L26;
            r5.smoothScrollTo(0, r6, true);
            return true;
        L26:
            return false;
        L11:
            if (r3 != 8192) goto L13;
        L17:
            int r7 = (r5.getHeight() - r5.getPaddingBottom()) - r5.getPaddingTop();
            int r8 = Math.max(r5.getScrollY() - r7, 0);
            if (r8 == r5.getScrollY()) goto L21;
            r5.smoothScrollTo(0, r8, true);
            return true;
        L21:
            return false;
        L13:
            if (r3 == 16908344) goto L17;
            if (r3 == 16908346) goto L22;
            return false;
        }
    }

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView r1, int r2, int r3, int r4, int r5);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        public int scrollPosition;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r1) {
            super(r1);
        }

        @NonNull
        public String toString() {
            StringBuilder r0 = new StringBuilder("HorizontalScrollView.SavedState{");
            r0.append(Integer.toHexString(System.identityHashCode(this)));
            r0.append(" scrollPosition=");
            return a.n(r0, "}", this.scrollPosition);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.scrollPosition);
        }

        public SavedState(Parcel r1) {
            super(r1);
            this.scrollPosition = r1.readInt();
        }
    }

    static {
        ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
        SCROLLVIEW_STYLEABLE = new int[]{R.attr.fillViewport};
    }

    public NestedScrollView(@NonNull Context r2) {
        this(r2, null);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) goto L8;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        if (((r0.getHeight() + r2.topMargin) + r2.bottomMargin) <= ((getHeight() - getPaddingTop()) - getPaddingBottom())) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    private static int clamp(int r1, int r2, int r3) {
        if (r2 >= r3) goto L10;
        if (r1 >= 0) goto L6;
        return 0;
    L6:
        if ((r2 + r1) > r3) goto L8;
        return r1;
    L8:
        return r3 - r2;
    L10:
        return 0;
    }

    private void doScrollY(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (this.mSmoothScrollingEnabled == false) goto L6;
        smoothScrollBy(0, r3);
        return;
    L6:
        scrollBy(0, r3);
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        EdgeEffect r0 = this.mEdgeGlowTop;
        if (r0 == null) goto L6;
        r0.onRelease();
        this.mEdgeGlowBottom.onRelease();
        return;
    }

    private void ensureGlows() {
        if (getOverScrollMode() != 2) goto L5;
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
        return;
    L5:
        if (this.mEdgeGlowTop != null) goto L9;
        Context r0 = getContext();
        this.mEdgeGlowTop = new EdgeEffect(r0);
        this.mEdgeGlowBottom = new EdgeEffect(r0);
        return;
    }

    private View findFocusableViewInBounds(boolean r12, int r13, int r14) {
        ArrayList<View> r11 = getFocusables(2);
        int r0 = r11.size();
        View r1 = null;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 >= r0) goto L31;
        View r5 = r11.get(r3);
        int r6 = r5.getTop();
        int r7 = r5.getBottom();
        if (r13 >= r7) goto L30;
        if (r6 >= r14) goto L30;
        if (r13 >= r6) goto L11;
        if (r7 >= r14) goto L11;
        boolean r9 = true;
    L12:
        if (r1 != null) goto L14;
        r1 = r5;
        r4 = r9;
        goto L30
    L14:
        if (r12 == true) goto L16;
    L17:
        if (r12 == false) goto L19;
    L21:
        boolean r8 = false;
    L22:
        if (r4 == false) goto L26;
        if (r9 == false) goto L30;
        if (r8 == false) goto L30;
    L29:
        r1 = r5;
        goto L30
    L26:
        if (r9 == false) goto L28;
        r1 = r5;
        r4 = true;
        goto L30
    L28:
        if (r8 == false) goto L30;
    L19:
        if (r7 <= r1.getBottom()) goto L21;
    L20:
        r8 = true;
        goto L22
    L16:
        if (r6 < r1.getTop()) goto L20;
    L11:
        r9 = false;
    L30:
        r3 = r3 + 1;
        goto L3
    L31:
        return r1;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor != 0.0f) goto L10;
        TypedValue r0 = new TypedValue();
        Context r1 = getContext();
        if (r1.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, r0, true) == false) goto L8;
        this.mVerticalScrollFactor = r0.getDimension(r1.getResources().getDisplayMetrics());
        goto L10
    L8:
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
    L10:
        return this.mVerticalScrollFactor;
    }

    private boolean inChild(int r4, int r5) {
        if (getChildCount() <= 0) goto L14;
        int r0 = getScrollY();
        View r3 = getChildAt(0);
        if (r5 >= (r3.getTop() - r0)) goto L7;
        return false;
    L7:
        if (r5 < (r3.getBottom() - r0)) goto L9;
        return false;
    L9:
        if (r4 >= r3.getLeft()) goto L11;
        return false;
    L11:
        if (r4 >= r3.getRight()) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    L5:
        r0.clear();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        this.mTouchSlop = r0.getScaledTouchSlop();
        this.mMinimumVelocity = r0.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = r0.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
        return;
    }

    private boolean isOffScreen(View r3) {
        return !isWithinDeltaOfScreen(r3, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View r2, View r3) {
        if (r2 != r3) goto L5;
        return true;
    L5:
        Object r4 = r2.getParent();
        if ((r4 instanceof ViewGroup) == true) goto L8;
    L10:
        return false;
    L8:
        if (isViewDescendantOf((View) r4, r3) == false) goto L10;
        return true;
    }

    private boolean isWithinDeltaOfScreen(View r2, int r3, int r4) {
        r2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r2, this.mTempRect);
        if ((this.mTempRect.bottom + r3) >= getScrollY()) goto L5;
    L7:
        return false;
    L5:
        if ((this.mTempRect.top - r3) > (getScrollY() + r4)) goto L7;
        return true;
    }

    private void onNestedScrollInternal(int r11, int r12, @Nullable int[] r13) {
        int r0 = getScrollY();
        scrollBy(0, r11);
        int r4 = getScrollY() - r0;
        if (r13 == null) goto L5;
        r13[1] = r13[1] + r4;
    L5:
        NestedScrollingChildHelper r2 = this.mChildHelper;
        r2.dispatchNestedScroll(0, r4, 0, r11 - r4, null, r12, r13);
    }

    private void onSecondaryPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mActivePointerId) goto L11;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mLastMotionY = (int) r4.getY(r1);
        this.mActivePointerId = r4.getPointerId(r1);
        VelocityTracker r3 = this.mVelocityTracker;
        if (r3 == null) goto L12;
        r3.clear();
        return;
    L12:
        return;
    L6:
        r1 = 0;
        goto L7
    }

    private void recycleVelocityTracker() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.mVelocityTracker = null;
        return;
    }

    private void runAnimatedScroll(boolean r2) {
        if (r2 == false) goto L5;
        startNestedScroll(2, 1);
    L6:
        this.mLastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L5:
        stopNestedScroll(1);
        goto L6
    }

    private boolean scrollAndFocus(int r7, int r8, int r9) {
        int r0 = getHeight();
        int r1 = getScrollY();
        int r2 = r0 + r1;
        boolean r3 = false;
        if (r7 != 33) goto L5;
        boolean r4 = true;
    L6:
        View r5 = findFocusableViewInBounds(r4, r8, r9);
        if (r5 != null) goto L9;
        r5 = this;
    L9:
        if (r8 < r1) goto L12;
        if (r9 > r2) goto L12;
    L17:
        if (r5 == findFocus()) goto L19;
        r5.requestFocus(r7);
    L19:
        return r3;
    L12:
        if (r4 == false) goto L14;
        int r10 = r8 - r1;
    L15:
        doScrollY(r10);
        r3 = true;
        goto L17
    L14:
        r10 = r9 - r2;
        goto L15
    L5:
        r4 = false;
        goto L6
    }

    private void scrollToChild(View r2) {
        r2.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r2, this.mTempRect);
        int r3 = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (r3 == 0) goto L6;
        scrollBy(0, r3);
        return;
    }

    private boolean scrollToChildRect(Rect r3, boolean r4) {
        int r5 = computeScrollDeltaToGetChildRectOnScreen(r3);
        if (r5 == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r4 == false) goto L9;
        scrollBy(0, r5);
        goto L10
    L9:
        smoothScrollBy(0, r5);
    L10:
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public void addView(View r2) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int r8) {
        View r0 = findFocus();
        if (r0 != this) goto L5;
        r0 = null;
    L5:
        View r1 = FocusFinder.getInstance().findNextFocus(this, r0, r8);
        int r2 = getMaxScrollAmount();
        if (r1 == null) goto L11;
        if (isWithinDeltaOfScreen(r1, r2, getHeight()) == false) goto L11;
        r1.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r1, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        r1.requestFocus(r8);
    L25:
        if (r0 != null) goto L27;
        return true;
    L27:
        if (r0.isFocused() == true) goto L29;
        return true;
    L29:
        if (isOffScreen(r0) == false) goto L35;
        int r9 = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(r9);
        return true;
    L35:
        return true;
    L11:
        if (r8 == 33) goto L13;
    L15:
        if (r8 == 130) goto L17;
    L19:
        if (r2 != 0) goto L21;
        return false;
    L21:
        if (r8 == 130) goto L24;
        r2 = -r2;
    L24:
        doScrollY(r2);
        goto L25
    L17:
        if (getChildCount() <= 0) goto L19;
        View r3 = getChildAt(0);
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r3.getLayoutParams();
        int r4 = r3.getBottom() + r5.bottomMargin;
        int r6 = getScrollY();
        r2 = Math.min(r4 - ((getHeight() + r6) - getPaddingBottom()), r2);
        goto L19
    L13:
        if (getScrollY() >= r2) goto L15;
        r2 = getScrollY();
        goto L19
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() == false) goto L5;
        return;
    L5:
        this.mScroller.computeScrollOffset();
        int r0 = this.mScroller.getCurrY();
        int r6 = r0 - this.mLastScrollerY;
        this.mLastScrollerY = r0;
        int[] r3 = this.mScrollConsumed;
        r3[1] = 0;
        dispatchNestedPreScroll(0, r6, r3, null, 1);
        int r13 = r6 - this.mScrollConsumed[1];
        int r14 = getScrollRange();
        if (r13 == 0) goto L8;
        int r15 = getScrollY();
        overScrollByCompat(0, r13, getScrollX(), r15, 0, r14, 0, 0, false);
        int r2 = getScrollY() - r15;
        int r16 = r13 - r2;
        int[] r7 = this.mScrollConsumed;
        r7[1] = 0;
        dispatchNestedScroll(0, r2, 0, r16, this.mScrollOffset, 1, r7);
        r13 = r16 - this.mScrollConsumed[1];
    L8:
        if (r13 == 0) goto L23;
        int r1 = getOverScrollMode();
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L21;
        if (r14 > 0) goto L13;
    L21:
        abortAnimatedScroll();
    L13:
        ensureGlows();
        if (r13 >= 0) goto L19;
        if (this.mEdgeGlowTop.isFinished() == false) goto L21;
        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
        goto L21
    L19:
        if (this.mEdgeGlowBottom.isFinished() == false) goto L21;
        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
    L23:
        if (this.mScroller.isFinished() == true) goto L25;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L25:
        stopNestedScroll(1);
    }

    public int computeScrollDeltaToGetChildRectOnScreen(Rect r11) {
        if (getChildCount() != 0) goto L5;
        return 0;
    L5:
        int r0 = getHeight();
        int r2 = getScrollY();
        int r3 = r2 + r0;
        int r4 = getVerticalFadingEdgeLength();
        if (r11.top <= 0) goto L8;
        r2 = r2 + r4;
    L8:
        View r5 = getChildAt(0);
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        if (r11.bottom >= ((r5.getHeight() + r6.topMargin) + r6.bottomMargin)) goto L11;
        int r7 = r3 - r4;
    L12:
        int r8 = r11.bottom;
        if (r8 <= r7) goto L22;
        if (r11.top <= r2) goto L22;
        if (r11.height() <= r0) goto L19;
        int r10 = r11.top - r2;
    L30:
        return Math.min(r10, (r5.getBottom() + r6.bottomMargin) - r3);
    L19:
        r10 = r11.bottom - r7;
    L22:
        if (r11.top >= r2) goto L31;
        if (r8 < r7) goto L25;
        return 0;
    L25:
        if (r11.height() <= r0) goto L27;
        int r1 = 0 - (r7 - r11.bottom);
    L29:
        return Math.max(r1, -getScrollY());
    L27:
        r1 = 0 - (r2 - r11.top);
        goto L29
    L31:
        return 0;
    L11:
        r7 = r3;
        goto L12
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int r0 = getChildCount();
        int r1 = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (r0 != 0) goto L5;
        return r1;
    L5:
        View r2 = getChildAt(0);
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2.getLayoutParams();
        int r4 = r2.getBottom() + r3.bottomMargin;
        int r5 = getScrollY();
        int r6 = Math.max(0, r4 - r1);
        if (r5 < 0) goto L11;
        if (r5 > r6) goto L10;
        return r4;
    L10:
        return r4 + (r5 - r6);
    L11:
        return r4 - r5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r2) {
        if (super.dispatchKeyEvent(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (executeKeyEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return this.mChildHelper.dispatchNestedFling(r1, r2, r3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return this.mChildHelper.dispatchNestedPreFling(r1, r2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return this.mChildHelper.dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int r9, int r10, int r11, int r12, @Nullable int[] r13, int r14, @NonNull int[] r15) {
        this.mChildHelper.dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (this.mEdgeGlowTop == null) goto L30;
        int r0 = getScrollY();
        int r2 = 0;
        if (this.mEdgeGlowTop.isFinished() == true) goto L18;
        int r1 = r10.save();
        int r3 = getWidth();
        int r4 = getHeight();
        int r5 = Math.min(0, r0);
        if (getClipToPadding() == false) goto L9;
        r3 = r3 - (getPaddingRight() + getPaddingLeft());
        int r6 = getPaddingLeft();
    L11:
        if (getClipToPadding() == false) goto L13;
        r4 = r4 - (getPaddingBottom() + getPaddingTop());
        r5 = r5 + getPaddingTop();
    L13:
        r10.translate(r6, r5);
        this.mEdgeGlowTop.setSize(r3, r4);
        if (this.mEdgeGlowTop.draw(r10) == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
    L16:
        r10.restoreToCount(r1);
        goto L18
    L9:
        r6 = 0;
    L18:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L31;
        int r7 = r10.save();
        int r8 = getWidth();
        int r9 = getHeight();
        int r11 = Math.max(getScrollRange(), r0) + r9;
        if (getClipToPadding() == false) goto L23;
        r8 = r8 - (getPaddingRight() + getPaddingLeft());
        r2 = getPaddingLeft();
    L23:
        if (getClipToPadding() == false) goto L25;
        r9 = r9 - (getPaddingBottom() + getPaddingTop());
        r11 = r11 - getPaddingBottom();
    L25:
        r10.translate(r2 - r8, r11);
        r10.rotate(180.0f, r8, 0.0f);
        this.mEdgeGlowBottom.setSize(r8, r9);
        if (this.mEdgeGlowBottom.draw(r10) == false) goto L28;
        ViewCompat.postInvalidateOnAnimation(this);
    L28:
        r10.restoreToCount(r7);
        return;
    L31:
        return;
    }

    public boolean executeKeyEvent(@NonNull KeyEvent r6) {
        this.mTempRect.setEmpty();
        int r2 = 130;
        if (canScroll() == true) goto L19;
        if (isFocused() == true) goto L7;
        return false;
    L7:
        if (r6.getKeyCode() == 4) goto L41;
        View r7 = findFocus();
        if (r7 != this) goto L11;
        r7 = null;
    L11:
        View r8 = FocusFinder.getInstance().findNextFocus(this, r7, 130);
        if (r8 == null) goto L42;
        if (r8 != this) goto L15;
        return false;
    L15:
        if (r8.requestFocus(130) == false) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L41:
        return false;
    L19:
        if (r6.getAction() != 0) goto L45;
        int r0 = r6.getKeyCode();
        if (r0 == 19) goto L36;
        if (r0 == 20) goto L32;
        if (r0 == 62) goto L28;
        return false;
    L28:
        if (r6.isShiftPressed() == false) goto L30;
        r2 = 33;
    L30:
        pageScroll(r2);
        return false;
    L32:
        if (r6.isAltPressed() == true) goto L48;
        return arrowScroll(130);
    L48:
        return fullScroll(130);
    L36:
        if (r6.isAltPressed() == true) goto L39;
        return arrowScroll(33);
    L39:
        return fullScroll(33);
    L45:
        return false;
    }

    public void fling(int r13) {
        if (getChildCount() <= 0) goto L6;
        this.mScroller.fling(getScrollX(), getScrollY(), 0, r13, 0, 0, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, 0);
        runAnimatedScroll(true);
        return;
    }

    public boolean fullScroll(int r6) {
        if (r6 != 130) goto L5;
        boolean r0 = true;
    L6:
        int r3 = getHeight();
        Rect r4 = this.mTempRect;
        r4.top = 0;
        r4.bottom = r3;
        if (r0 == false) goto L11;
        int r1 = getChildCount();
        if (r1 <= 0) goto L11;
        View r2 = getChildAt(r1 - 1);
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r2.getLayoutParams();
        this.mTempRect.bottom = getPaddingBottom() + (r2.getBottom() + r5.bottomMargin);
        Rect r7 = this.mTempRect;
        r7.top = r7.bottom - r3;
    L11:
        Rect r8 = this.mTempRect;
        return scrollAndFocus(r6, r8.top, r8.bottom);
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        int r2 = getVerticalFadingEdgeLength();
        int r3 = ((r0.getBottom() + r1.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (r3 < r2) goto L9;
        return 1.0f;
    L9:
        return r3 / r2;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * MAX_SCROLL_FACTOR);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) goto L6;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        return Math.max(0, ((r0.getHeight() + r2.topMargin) + r2.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    L6:
        return 0;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() != 0) goto L6;
        return 0.0f;
    L6:
        int r0 = getVerticalFadingEdgeLength();
        int r1 = getScrollY();
        if (r1 < r0) goto L9;
        return 1.0f;
    L9:
        return r1 / r0;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r1) {
        return this.mChildHelper.hasNestedScrollingParent(r1);
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    @Override // android.view.ViewGroup
    public void measureChild(View r2, int r3, int r4) {
        ViewGroup.LayoutParams r5 = r2.getLayoutParams();
        int r0 = getPaddingLeft();
        r2.measure(ViewGroup.getChildMeasureSpec(r3, getPaddingRight() + r0, r5.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View r1, int r2, int r3, int r4, int r5) {
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        int r7 = getPaddingLeft();
        r1.measure(ViewGroup.getChildMeasureSpec(r2, (((getPaddingRight() + r7) + r6.leftMargin) + r6.rightMargin) + r3, r6.width), View.MeasureSpec.makeMeasureSpec(r6.topMargin + r6.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r4) {
        if ((r4.getSource() & 2) != 0) goto L5;
    L20:
        return false;
    L5:
        if (r4.getAction() != 8) goto L20;
        if (this.mIsBeingDragged == true) goto L20;
        float r5 = r4.getAxisValue(9);
        if (r5 == 0.0f) goto L20;
        int r6 = (int) (r5 * getVerticalScrollFactorCompat());
        int r0 = getScrollRange();
        int r2 = getScrollY();
        int r7 = r2 - r6;
        if (r7 >= 0) goto L14;
        r0 = 0;
    L17:
        if (r0 == r2) goto L20;
        super.scrollTo(getScrollX(), r0);
        return true;
    L14:
        if (r7 > r0) goto L17;
        r0 = r7;
        goto L17
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r12) {
        int r0 = r12.getAction();
        if (r0 == 2) goto L5;
    L7:
        int r1 = r0 & 255;
        if (r1 != 0) goto L10;
        int r2 = (int) r12.getY();
        if (inChild((int) r12.getX(), r2) == true) goto L38;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
    L40:
        return this.mIsBeingDragged;
    L38:
        this.mLastMotionY = r2;
        this.mActivePointerId = r12.getPointerId(0);
        initOrResetVelocityTracker();
        this.mVelocityTracker.addMovement(r12);
        this.mScroller.computeScrollOffset();
        this.mIsBeingDragged = !this.mScroller.isFinished();
        startNestedScroll(2, 0);
        goto L40
    L10:
        if (r1 == 1) goto L31;
        if (r1 != 2) goto L13;
        int r3 = this.mActivePointerId;
        if (r3 == (-1)) goto L40;
        int r5 = r12.findPointerIndex(r3);
        if (r5 != (-1)) goto L24;
        Log.e(TAG, "Invalid pointerId=" + r3 + " in onInterceptTouchEvent");
        goto L40
    L24:
        int r4 = (int) r12.getY(r5);
        if (Math.abs(r4 - this.mLastMotionY) <= this.mTouchSlop) goto L40;
        if ((2 & getNestedScrollAxes()) != 0) goto L40;
        this.mIsBeingDragged = true;
        this.mLastMotionY = r4;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(r12);
        this.mNestedYOffset = 0;
        ViewParent r13 = getParent();
        if (r13 == null) goto L40;
        r13.requestDisallowInterceptTouchEvent(true);
        goto L40
    L13:
        if (r1 == 3) goto L31;
        if (r1 != 6) goto L40;
        onSecondaryPointerUp(r12);
    L31:
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L34;
        ViewCompat.postInvalidateOnAnimation(this);
    L34:
        stopNestedScroll(0);
        goto L40
    L5:
        if (this.mIsBeingDragged == false) goto L7;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = 0;
        this.mIsLayoutDirty = false;
        View r8 = this.mChildToScrollTo;
        if (r8 != null) goto L5;
    L7:
        this.mChildToScrollTo = null;
        if (this.mIsLaidOut == false) goto L10;
    L18:
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
        return;
    L10:
        if (this.mSavedState == null) goto L13;
        scrollTo(getScrollX(), this.mSavedState.scrollPosition);
        this.mSavedState = null;
    L13:
        if (getChildCount() <= 0) goto L15;
        View r9 = getChildAt(0);
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r9.getLayoutParams();
        r7 = (r9.getMeasuredHeight() + r10.topMargin) + r10.bottomMargin;
    L15:
        int r11 = ((r6 - r4) - getPaddingTop()) - getPaddingBottom();
        int r12 = getScrollY();
        int r13 = clamp(r12, r11, r7);
        if (r13 == r12) goto L18;
        scrollTo(getScrollX(), r13);
        goto L18
    L5:
        if (isViewDescendantOf(r8, this) == false) goto L7;
        scrollToChild(this.mChildToScrollTo);
        goto L7
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (this.mFillViewport == true) goto L6;
        return;
    L6:
        if (View.MeasureSpec.getMode(r6) != 0) goto L9;
        return;
    L9:
        if (getChildCount() <= 0) goto L14;
        View r7 = getChildAt(0);
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) r7.getLayoutParams();
        int r1 = r7.getMeasuredHeight();
        int r2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - r0.topMargin) - r0.bottomMargin;
        if (r1 >= r2) goto L15;
        int r3 = getPaddingLeft();
        r7.measure(ViewGroup.getChildMeasureSpec(r5, ((getPaddingRight() + r3) + r0.leftMargin) + r0.rightMargin, r0.width), View.MeasureSpec.makeMeasureSpec(r2, BasicMeasure.EXACTLY));
        return;
    L15:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View r1, float r2, float r3, boolean r4) {
        if (r4 == true) goto L5;
        dispatchNestedFling(0.0f, r3, true);
        fling((int) r3);
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View r1, float r2, float r3) {
        return dispatchNestedPreFling(r2, r3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View r7, int r8, int r9, @NonNull int[] r10, int r11) {
        dispatchNestedPreScroll(r8, r9, r10, null, r11);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r1, int r2, int r3, int r4, int r5, int r6, @NonNull int[] r7) {
        onNestedScrollInternal(r5, r6, r7);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View r2, @NonNull View r3, int r4, int r5) {
        this.mParentHelper.onNestedScrollAccepted(r2, r3, r4, r5);
        startNestedScroll(2, r5);
    }

    @Override // android.view.View
    public void onOverScrolled(int r1, int r2, boolean r3, boolean r4) {
        super.scrollTo(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r3, Rect r4) {
        if (r3 != 2) goto L6;
        r3 = 130;
    L8:
        if (r4 != null) goto L10;
        View r0 = FocusFinder.getInstance().findNextFocus(this, null, r3);
    L12:
        if (r0 != null) goto L15;
        return false;
    L15:
        if (isOffScreen(r0) == false) goto L18;
        return false;
    L18:
        return r0.requestFocus(r3, r4);
    L10:
        r0 = FocusFinder.getInstance().findNextFocusFromRect(this, r4, r3);
        goto L12
    L6:
        if (r3 != 1) goto L8;
        r3 = 33;
        goto L8
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        super.onRestoreInstanceState(r3.getSuperState());
        this.mSavedState = r3;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r1 = new SavedState(super.onSaveInstanceState());
        r1.scrollPosition = getScrollY();
        return r1;
    }

    @Override // android.view.View
    public void onScrollChanged(int r7, int r8, int r9, int r10) {
        super.onScrollChanged(r7, r8, r9, r10);
        OnScrollChangeListener r0 = this.mOnScrollChangeListener;
        if (r0 == null) goto L6;
        r0.onScrollChange(this, r7, r8, r9, r10);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        View r5 = findFocus();
        if (r5 == null) goto L10;
        if (this != r5) goto L7;
        return;
    L7:
        if (isWithinDeltaOfScreen(r5, 0, r4) == false) goto L11;
        r5.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(r5, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
        return;
    L11:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View r1, @NonNull View r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View r2, int r3) {
        this.mParentHelper.onStopNestedScroll(r2, r3);
        stopNestedScroll(r3);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r24) {
        initVelocityTrackerIfNotExists();
        int r0 = r24.getActionMasked();
        if (r0 != 0) goto L5;
        this.mNestedYOffset = 0;
    L5:
        MotionEvent r13 = MotionEvent.obtain(r24);
        r13.offsetLocation(0.0f, this.mNestedYOffset);
        if (r0 == 0) goto L88;
        if (r0 == 1) goto L78;
        if (r0 != 2) goto L11;
        int r15 = r24.findPointerIndex(this.mActivePointerId);
        if (r15 != (-1)) goto L30;
        Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
    L99:
        VelocityTracker r1 = this.mVelocityTracker;
        if (r1 == null) goto L102;
        r1.addMovement(r13);
    L102:
        r13.recycle();
        return true;
    L30:
        int r6 = (int) r24.getY(r15);
        int r2 = this.mLastMotionY - r6;
        if (this.mIsBeingDragged == false) goto L33;
    L40:
        int r7 = r2;
        if (this.mIsBeingDragged == false) goto L99;
        if (dispatchNestedPreScroll(0, r7, this.mScrollConsumed, this.mScrollOffset, 0) == false) goto L47;
        r7 = r7 - this.mScrollConsumed[1];
        this.mNestedYOffset += this.mScrollOffset[1];
    L47:
        int r16 = r7;
        this.mLastMotionY = r6 - this.mScrollOffset[1];
        int r17 = getScrollY();
        int r9 = getScrollRange();
        int r3 = getOverScrollMode();
        if (r3 == 0) goto L53;
        if (r3 != 1) goto L52;
        if (r9 > 0) goto L53;
    L52:
        boolean r18 = false;
    L55:
        if (overScrollByCompat(0, r16, 0, getScrollY(), 0, r9, 0, 0, true) == true) goto L57;
    L59:
        int r4 = getScrollY() - r17;
        int[] r8 = this.mScrollConsumed;
        r8[1] = 0;
        dispatchNestedScroll(0, r4, 0, r16 - r4, this.mScrollOffset, 0, r8);
        int r5 = this.mLastMotionY;
        int r10 = this.mScrollOffset[1];
        this.mLastMotionY = r5 - r10;
        this.mNestedYOffset += r10;
        if (r18 == false) goto L99;
        int r11 = r16 - this.mScrollConsumed[1];
        ensureGlows();
        int r12 = r17 + r11;
        if (r12 >= 0) goto L67;
        EdgeEffectCompat.onPull(this.mEdgeGlowTop, r11 / getHeight(), r24.getX(r15) / getWidth());
        if (this.mEdgeGlowBottom.isFinished() == true) goto L71;
        this.mEdgeGlowBottom.onRelease();
    L71:
        EdgeEffect r14 = this.mEdgeGlowTop;
        if (r14 == null) goto L99;
        if (r14.isFinished() == true) goto L76;
    L77:
        ViewCompat.postInvalidateOnAnimation(this);
        goto L99
    L76:
        if (this.mEdgeGlowBottom.isFinished() == true) goto L99;
    L67:
        if (r12 <= r9) goto L71;
        EdgeEffectCompat.onPull(this.mEdgeGlowBottom, r11 / getHeight(), 1.0f - (r24.getX(r15) / getWidth()));
        if (this.mEdgeGlowTop.isFinished() == true) goto L71;
        this.mEdgeGlowTop.onRelease();
        goto L71
    L57:
        if (hasNestedScrollingParent(0) == true) goto L59;
        this.mVelocityTracker.clear();
    L53:
        r18 = true;
        goto L55
    L33:
        if (Math.abs(r2) <= this.mTouchSlop) goto L40;
        ViewParent r19 = getParent();
        if (r19 == null) goto L37;
        r19.requestDisallowInterceptTouchEvent(true);
    L37:
        this.mIsBeingDragged = true;
        if (r2 <= 0) goto L41;
        r2 = r2 - this.mTouchSlop;
        goto L40
    L41:
        r2 = r2 + this.mTouchSlop;
        goto L40
    L11:
        if (r0 == 3) goto L20;
        if (r0 != 5) goto L15;
        int r20 = r24.getActionIndex();
        this.mLastMotionY = (int) r24.getY(r20);
        this.mActivePointerId = r24.getPointerId(r20);
        goto L99
    L15:
        if (r0 != 6) goto L99;
        onSecondaryPointerUp(r24);
        this.mLastMotionY = (int) r24.getY(r24.findPointerIndex(this.mActivePointerId));
        goto L99
    L20:
        if (this.mIsBeingDragged == true) goto L22;
    L26:
        this.mActivePointerId = -1;
        endDrag();
        goto L99
    L22:
        if (getChildCount() <= 0) goto L26;
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L26;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L26
    L78:
        VelocityTracker r21 = this.mVelocityTracker;
        r21.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int r22 = (int) r21.getYVelocity(this.mActivePointerId);
        if (Math.abs(r22) < this.mMinimumVelocity) goto L84;
        int r23 = -r22;
        float r25 = r23;
        if (dispatchNestedPreFling(0.0f, r25) == true) goto L86;
        dispatchNestedFling(0.0f, r25, true);
        fling(r23);
    L86:
        this.mActivePointerId = -1;
        endDrag();
        goto L99
    L84:
        if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) == false) goto L86;
        ViewCompat.postInvalidateOnAnimation(this);
        goto L86
    L88:
        if (getChildCount() != 0) goto L90;
        return false;
    L90:
        boolean r26 = !this.mScroller.isFinished();
        this.mIsBeingDragged = r26;
        if (r26 == false) goto L96;
        ViewParent r27 = getParent();
        if (r27 == null) goto L96;
        r27.requestDisallowInterceptTouchEvent(true);
    L96:
        if (this.mScroller.isFinished() == true) goto L98;
        abortAnimatedScroll();
    L98:
        this.mLastMotionY = (int) r24.getY();
        this.mActivePointerId = r24.getPointerId(0);
        startNestedScroll(2, 0);
        goto L99
    }

    public boolean overScrollByCompat(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        int r1 = getOverScrollMode();
        if (computeHorizontalScrollRange() <= computeHorizontalScrollExtent()) goto L5;
        boolean r2 = true;
    L7:
        if (computeVerticalScrollRange() <= computeVerticalScrollExtent()) goto L9;
        boolean r3 = true;
    L10:
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        if (r2 == true) goto L15;
    L14:
        boolean r4 = false;
    L16:
        if (r1 == 0) goto L21;
        if (r1 != 1) goto L20;
        if (r3 == true) goto L21;
    L20:
        boolean r5 = false;
    L22:
        int r6 = r15 + r13;
        if (r4 == true) goto L25;
        int r7 = 0;
    L26:
        int r8 = r16 + r14;
        if (r5 == true) goto L29;
        int r9 = 0;
    L30:
        int r10 = -r7;
        int r11 = r7 + r17;
        int r12 = -r9;
        int r22 = r9 + r18;
        if (r6 <= r11) goto L33;
        r6 = r11;
        boolean r23 = true;
    L36:
        if (r8 <= r22) goto L38;
        r8 = r22;
        boolean r24 = true;
    L41:
        if (r24 == true) goto L43;
    L45:
        onOverScrolled(r6, r8, r23, r24);
        if (r23 == true) goto L49;
        if (r24 == true) goto L49;
        return false;
    L49:
        return true;
    L43:
        if (hasNestedScrollingParent(1) == true) goto L45;
        this.mScroller.springBack(r6, r8, 0, 0, 0, getScrollRange());
        goto L45
    L38:
        if (r8 >= r12) goto L40;
        r24 = true;
        r8 = r12;
        goto L41
    L40:
        r24 = false;
        goto L41
    L33:
        if (r6 >= r10) goto L35;
        r23 = true;
        r6 = r10;
        goto L36
    L35:
        r23 = false;
        goto L36
    L29:
        r9 = r20;
        goto L30
    L25:
        r7 = r19;
    L21:
        r5 = true;
    L15:
        r4 = true;
        goto L16
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    public boolean pageScroll(int r5) {
        if (r5 != 130) goto L5;
        boolean r0 = true;
    L6:
        int r3 = getHeight();
        if (r0 == false) goto L13;
        this.mTempRect.top = getScrollY() + r3;
        int r1 = getChildCount();
        if (r1 <= 0) goto L16;
        View r2 = getChildAt(r1 - 1);
        int r4 = getPaddingBottom() + (r2.getBottom() + ((FrameLayout.LayoutParams) r2.getLayoutParams()).bottomMargin);
        Rect r6 = this.mTempRect;
        if ((r6.top + r3) <= r4) goto L16;
        r6.top = r4 - r3;
    L16:
        Rect r7 = this.mTempRect;
        int r8 = r7.top;
        int r9 = r3 + r8;
        r7.bottom = r9;
        return scrollAndFocus(r5, r8, r9);
    L13:
        this.mTempRect.top = getScrollY() - r3;
        Rect r10 = this.mTempRect;
        if (r10.top >= 0) goto L16;
        r10.top = 0;
        goto L16
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r2, View r3) {
        if (this.mIsLayoutDirty == true) goto L5;
        scrollToChild(r3);
    L6:
        super.requestChildFocus(r2, r3);
        return;
    L5:
        this.mChildToScrollTo = r3;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r3, Rect r4, boolean r5) {
        r4.offset(r3.getLeft() - r3.getScrollX(), r3.getTop() - r3.getScrollY());
        return scrollToChildRect(r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        if (r1 == false) goto L4;
        recycleVelocityTracker();
    L4:
        super.requestDisallowInterceptTouchEvent(r1);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int r7, int r8) {
        if (getChildCount() <= 0) goto L10;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        int r2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int r3 = (r0.getWidth() + r1.leftMargin) + r1.rightMargin;
        int r4 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r5 = (r0.getHeight() + r1.topMargin) + r1.bottomMargin;
        int r9 = clamp(r7, r2, r3);
        int r10 = clamp(r8, r4, r5);
        if (r9 == getScrollX()) goto L7;
    L8:
        super.scrollTo(r9, r10);
        return;
    L7:
        if (r10 != getScrollY()) goto L8;
        return;
    }

    public void setFillViewport(boolean r2) {
        if (r2 == this.mFillViewport) goto L6;
        this.mFillViewport = r2;
        requestLayout();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r1) {
        this.mChildHelper.setNestedScrollingEnabled(r1);
    }

    public void setOnScrollChangeListener(@Nullable OnScrollChangeListener r1) {
        this.mOnScrollChangeListener = r1;
    }

    public void setSmoothScrollingEnabled(boolean r1) {
        this.mSmoothScrollingEnabled = r1;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int r3, int r4) {
        smoothScrollBy(r3, r4, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    public final void smoothScrollTo(int r3, int r4) {
        smoothScrollTo(r3, r4, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r1, int r2) {
        return this.mChildHelper.startNestedScroll(r1, r2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r1) {
        this.mChildHelper.stopNestedScroll(r1);
    }

    public NestedScrollView(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10) {
        return dispatchNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return this.mChildHelper.dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View r7, int r8, int r9, @NonNull int[] r10) {
        onNestedPreScroll(r7, r8, r9, r10, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View r1, int r2, int r3, int r4, int r5, int r6) {
        onNestedScrollInternal(r5, r6, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View r2, @NonNull View r3, int r4) {
        return onStartNestedScroll(r2, r3, r4, 0);
    }

    public final void smoothScrollBy(int r2, int r3, int r4) {
        smoothScrollBy(r2, r3, r4, false);
    }

    public final void smoothScrollTo(int r2, int r3, int r4) {
        smoothScrollTo(r2, r3, r4, false);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r2) {
        return startNestedScroll(r2, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public NestedScrollView(@NonNull Context r5, @Nullable AttributeSet r6, int r7) {
        super(r5, r6, r7);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        TypedArray r8 = r5.obtainStyledAttributes(r6, SCROLLVIEW_STYLEABLE, r7, 0);
        setFillViewport(r8.getBoolean(0, false));
        r8.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int r9, int r10, int r11, boolean r12) {
        if (getChildCount() != 0) goto L6;
        return;
    L6:
        if ((AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll) <= 250) goto L9;
        View r0 = getChildAt(0);
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0.getLayoutParams();
        int r2 = (r0.getHeight() + r1.topMargin) + r1.bottomMargin;
        int r3 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int r4 = getScrollY();
        int r13 = r10 + r4;
        int r6 = Math.max(0, Math.min(r13, Math.max(0, r2 - r3))) - r4;
        this.mScroller.startScroll(getScrollX(), r4, 0, r6, r11);
        runAnimatedScroll(r12);
    L12:
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        return;
    L9:
        if (this.mScroller.isFinished() == true) goto L11;
        abortAnimatedScroll();
    L11:
        scrollBy(r9, r10);
        goto L12
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return this.mChildHelper.dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View r1, int r2, int r3, int r4, int r5) {
        onNestedScrollInternal(r5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View r2, @NonNull View r3, int r4) {
        onNestedScrollAccepted(r2, r3, r4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View r2) {
        onStopNestedScroll(r2, 0);
    }

    public void smoothScrollTo(int r2, int r3, boolean r4) {
        smoothScrollTo(r2, r3, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, r4);
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void smoothScrollTo(int r2, int r3, int r4, boolean r5) {
        smoothScrollBy(r2 - getScrollX(), r3 - getScrollY(), r4, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r2, ViewGroup.LayoutParams r3) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View r2, int r3, ViewGroup.LayoutParams r4) {
        if (getChildCount() > 0) goto L7;
        super.addView(r2, r3, r4);
        return;
    L7:
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
