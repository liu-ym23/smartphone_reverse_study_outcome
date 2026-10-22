package com.obric.oui.panel;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.obric.oui.common.util.OUILoggerKt;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks;
    protected int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    protected boolean fitToContents;
    protected int fitToContentsOffset;
    boolean fitsSystemWindow;
    int halfExpandedOffset;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private InterceptTouchEvent interceptTouchEvent;
    private boolean is69Mode;
    private int lastNestedScrollDy;
    protected int lastPeekHeight;
    private boolean mAdaptPortraitRLSlide;
    private boolean mAutoSlideToPeekHeight;
    private int mMaxSettleDuration;
    private int maxExpandedHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    protected int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private final ViewDragHelper.Callback rlDragCallback;
    BottomSheetRLDragHelper rlDragHelper;
    private boolean skipCollapsed;
    int state;
    int targetState;
    boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public void onEnterInProgressUpdate(float r1) {
        }

        public void onExitOutProgressUpdate(float r1) {
        }

        public abstract void onSlide(View r1, float r2);

        public abstract void onStateChanged(View r1, int r2);

        public BottomSheetCallback() {
        }
    }

    public interface InterceptTouchEvent {
        boolean shouldInterceptTouchEvent(MotionEvent r1, int r2, int r3);
    }

    private class RLSettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        RLSettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.this$0 = r1;
            this.view = r2;
            this.targetState = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.rlDragHelper != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
            return;
        L5:
            if (this.this$0.rlDragHelper.continueSettling(this.view, true) == false) goto L7;
            ViewCompat.postOnAnimation(this.view, this);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        final int state;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.state = r1.readInt();
        }

        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.state = r2;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    private class SettleRunnable implements Runnable {
        private final int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        SettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.this$0 = r1;
            this.view = r2;
            this.targetState = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.viewDragHelper != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
            return;
        L5:
            if (this.this$0.viewDragHelper.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.view, this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    static /* synthetic */ boolean access$000(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    static /* synthetic */ int[] access$100(BottomSheetBehavior r0, View r1, float r2, float r3) {
        return r0.getReleaseParam(r1, r2, r3);
    }

    static /* synthetic */ int access$200(BottomSheetBehavior r0) {
        return r0.getExpandedOffset();
    }

    static /* synthetic */ ViewDragHelper.Callback access$300(BottomSheetBehavior r0) {
        return r0.dragCallback;
    }

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.is69Mode = false;
        this.maxExpandedHeight = -1;
        this.draggable = true;
        this.skipCollapsed = false;
        this.state = 4;
        this.targetState = 4;
        this.callbacks = new ArrayList();
        this.fitsSystemWindow = true;
        this.mAdaptPortraitRLSlide = false;
        this.mAutoSlideToPeekHeight = true;
        this.mMaxSettleDuration = 600;
        this.dragCallback = new AnonymousClass2(this);
        this.rlDragCallback = new AnonymousClass3(this);
    }

    public BottomSheetBehavior(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.fitToContents = true;
        this.is69Mode = false;
        this.maxExpandedHeight = -1;
        this.draggable = true;
        this.skipCollapsed = false;
        this.state = 4;
        this.targetState = 4;
        this.callbacks = new ArrayList();
        this.fitsSystemWindow = true;
        this.mAdaptPortraitRLSlide = false;
        this.mAutoSlideToPeekHeight = true;
        this.mMaxSettleDuration = 600;
        this.dragCallback = new AnonymousClass2(this);
        this.rlDragCallback = new AnonymousClass3(this);
        TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.BottomSheetBehavior_Layout);
        TypedValue r3 = r8.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r3 != null) goto L5;
    L7:
        setPeekHeight(r8.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    L8:
        setHideable(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r8.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        r8.recycle();
        this.maximumVelocity = ViewConfiguration.get(r6).getScaledMaximumFlingVelocity();
        return;
    L5:
        if (r3.data != (-1)) goto L7;
        setPeekHeight(r3.data);
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout r2, V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this.state);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout r2, V r3, Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        if (r5.state != 1) goto L5;
    L8:
        this.state = 4;
        return;
    L5:
        if (r5.state == 2) goto L8;
        this.state = r5.state;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout r9, V r10, int r11) {
        if (this.fitsSystemWindow == true) goto L5;
    L9:
        int r0 = r10.getTop();
        r9.onLayoutChild(r10, r11);
        this.parentHeight = r9.getHeight();
        if (this.peekHeightAuto == true) goto L12;
        this.lastPeekHeight = this.peekHeight;
    L25:
        if (this.maxExpandedHeight <= 0) goto L29;
        int r12 = r10.getHeight();
        int r3 = this.maxExpandedHeight;
        if (r12 <= r3) goto L29;
        this.fitToContentsOffset = Math.max(0, this.parentHeight - r3);
    L30:
        this.halfExpandedOffset = this.parentHeight / 2;
        calculateCollapsedOffset();
        int r13 = this.state;
        if (r13 != 3) goto L34;
        ViewCompat.offsetTopAndBottom(r10, getExpandedOffset());
    L48:
        if (this.viewDragHelper != null) goto L51;
        ViewDragHelper r14 = ViewDragHelper.create(r9, this.dragCallback);
        this.viewDragHelper = r14;
        r14.setMaxSettleDuration(this.mMaxSettleDuration);
    L51:
        if (this.mAdaptPortraitRLSlide == true) goto L53;
    L55:
        this.viewRef = new WeakReference(r10);
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r10));
        return true;
    L53:
        if (this.rlDragHelper != null) goto L55;
        this.rlDragHelper = new BottomSheetRLDragHelper(r9.getContext(), r9, this.rlDragCallback);
        goto L55
    L34:
        if (r13 != 6) goto L37;
        ViewCompat.offsetTopAndBottom(r10, this.halfExpandedOffset);
        goto L48
    L37:
        if (this.hideable == false) goto L42;
        if (r13 != 5) goto L42;
        ViewCompat.offsetTopAndBottom(r10, this.parentHeight);
    L42:
        if (r13 != 4) goto L44;
        ViewCompat.offsetTopAndBottom(r10, this.collapsedOffset);
        goto L48
    L44:
        if (r13 == 1) goto L46;
        if (r13 != 2) goto L48;
    L46:
        ViewCompat.offsetTopAndBottom(r10, r0 - r10.getTop());
    L29:
        this.fitToContentsOffset = Math.max(0, this.parentHeight - r10.getHeight());
        goto L30
    L12:
        if (this.peekHeightMin != 0) goto L14;
        this.peekHeightMin = r9.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
    L14:
        float r15 = r9.getContext().getResources().getConfiguration().fontScale;
        OUILoggerKt.debugLog("check fontScale:" + r15);
        if (this.mAutoSlideToPeekHeight == false) goto L17;
        double r2 = 0.6d;
    L18:
        double r4 = this.peekHeightMin;
        int r6 = this.maxExpandedHeight;
        if (r6 <= 0) goto L21;
        double r5 = r6;
    L22:
        this.lastPeekHeight = (int) Math.max(r4, r5);
        goto L25
    L21:
        r5 = ((double) r15) * (((double) this.parentHeight) * r2);
        goto L22
    L17:
        r2 = 1.0d;
        goto L18
    L5:
        if (ViewCompat.getFitsSystemWindows(r9) == false) goto L9;
        if (ViewCompat.getFitsSystemWindows(r10) == true) goto L9;
        r10.setFitsSystemWindows(true);
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout r9, V r10, MotionEvent r11) {
        if (r10.isShown() == true) goto L5;
    L76:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L76;
        int r0 = r11.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r11);
        View r3 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L39;
        this.ignoreEvents = false;
        return false;
    L39:
        if (this.mAdaptPortraitRLSlide == false) goto L48;
        if (this.ignoreEvents == true) goto L48;
        BottomSheetRLDragHelper r4 = this.rlDragHelper;
        if (r4 == null) goto L48;
        if (r4.shouInterceptRLSlideMotionEvent(r10, r11) == false) goto L48;
        return true;
    L48:
        if (this.ignoreEvents == true) goto L54;
        ViewDragHelper r12 = this.viewDragHelper;
        if (r12 == null) goto L54;
        if (r12.shouldInterceptTouchEvent(r11) == false) goto L54;
        return true;
    L54:
        WeakReference<View> r13 = this.nestedScrollingChildRef;
        if (r13 == null) goto L58;
        r3 = r13.get();
    L58:
        if (r0 != 2) goto L70;
        if (r3 == null) goto L70;
        if (this.ignoreEvents == true) goto L70;
        if (this.state == 1) goto L70;
        if (r9.isPointInChildBounds(r3, (int) r11.getX(), (int) r11.getY()) == true) goto L70;
        if (this.viewDragHelper == null) goto L70;
        if (Math.abs(this.initialY - r11.getY()) <= this.viewDragHelper.getTouchSlop()) goto L70;
    L75:
        return true;
    L70:
        InterceptTouchEvent r14 = this.interceptTouchEvent;
        if (r14 != null) goto L73;
        return false;
    L73:
        if (r14.shouldInterceptTouchEvent(r11, this.state, this.targetState) == true) goto L75;
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r5 = (int) r11.getX();
        this.initialY = (int) r11.getY();
        WeakReference<View> r6 = this.nestedScrollingChildRef;
        if (r6 == null) goto L26;
        View r7 = r6.get();
    L27:
        if (r7 == null) goto L32;
        if (r9.isPointInChildBounds(r7, r5, this.initialY) == false) goto L32;
        this.activePointerId = r11.getPointerId(r11.getActionIndex());
        this.touchingScrollingChild = true;
    L32:
        if (this.activePointerId == (-1)) goto L34;
    L36:
        boolean r8 = false;
    L37:
        this.ignoreEvents = r8;
        goto L39
    L34:
        if (r9.isPointInChildBounds(r10, r5, this.initialY) == true) goto L36;
        r8 = true;
        goto L37
    L26:
        r7 = null;
        goto L27
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r5, V r6, MotionEvent r7) {
        if (r6.isShown() == true) goto L6;
        return false;
    L6:
        int r8 = r7.getActionMasked();
        if (this.state != 1) goto L10;
        if (r8 != 0) goto L10;
        return true;
    L10:
        if (r8 != 0) goto L13;
        reset();
    L13:
        if (this.velocityTracker != null) goto L15;
        this.velocityTracker = VelocityTracker.obtain();
    L15:
        this.velocityTracker.addMovement(r7);
        if (this.mAdaptPortraitRLSlide == false) goto L22;
        BottomSheetRLDragHelper r0 = this.rlDragHelper;
        if (r0 == null) goto L22;
        if (r0.isPortraitRLSliding() == false) goto L22;
        this.rlDragHelper.processRLSlideTouchEvent(r7, r6, this.state, this.velocityTracker);
    L26:
        if (this.mAdaptPortraitRLSlide == false) goto L34;
        BottomSheetRLDragHelper r1 = this.rlDragHelper;
        if (r1 == null) goto L34;
        if (r1.isPortraitRLSliding() == false) goto L34;
        return !this.ignoreEvents;
    L34:
        if (r8 != 2) goto L41;
        if (this.ignoreEvents == true) goto L41;
        if (Math.abs(this.initialY - r7.getY()) <= this.viewDragHelper.getTouchSlop()) goto L41;
        this.viewDragHelper.captureChildView(r6, r7.getPointerId(r7.getActionIndex()));
    L41:
        return !this.ignoreEvents;
    L22:
        ViewDragHelper r2 = this.viewDragHelper;
        if (r2 == null) goto L26;
        r2.processTouchEvent(r7);
        goto L26
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout r1, V r2, View r3, View r4, int r5, int r6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout r2, V r3, View r4, int r5, int r6, int[] r7, int r8) {
        if (r8 != 1) goto L6;
        return;
    L6:
        if (r4 == this.nestedScrollingChildRef.get()) goto L8;
        return;
    L8:
        int r9 = r3.getTop();
        int r10 = r9 - r6;
        if (r6 > 0) goto L11;
        if (r6 < 0) goto L19;
    L30:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L19:
        if (r4.canScrollVertically(-1) == true) goto L30;
        int r11 = this.collapsedOffset;
        if (r10 <= r11) goto L27;
        if (this.hideable == true) goto L27;
        int r12 = r9 - r11;
        r7[1] = r12;
        ViewCompat.offsetTopAndBottom(r3, -r12);
        setStateInternal(4);
    L27:
        if (this.draggable == true) goto L29;
        return;
    L29:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L30
    L11:
        if (r10 >= getExpandedOffset()) goto L14;
        int r13 = r9 - getExpandedOffset();
        r7[1] = r13;
        ViewCompat.offsetTopAndBottom(r3, -r13);
        setStateInternal(3);
        goto L30
    L14:
        if (this.draggable == true) goto L16;
        return;
    L16:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L30
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout r4, V r5, View r6, int r7) {
        int r0 = 3;
        if (r5.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (r6 == this.nestedScrollingChildRef.get()) goto L9;
        return;
    L9:
        if (this.nestedScrolled == true) goto L12;
        return;
    L12:
        if (this.lastNestedScrollDy <= 0) goto L15;
        int r8 = getExpandedOffset();
    L40:
        this.targetState = r0;
        if (this.viewDragHelper.smoothSlideViewTo(r5, r5.getLeft(), r8) == false) goto L43;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r5, new SettleRunnable(this, r5, r0));
    L44:
        this.nestedScrolled = false;
        return;
    L43:
        setStateInternal(r0);
        goto L44
    L15:
        if (this.hideable == false) goto L20;
        if (shouldHide(r5, getYVelocity()) == false) goto L20;
        r8 = this.parentHeight;
        r0 = 5;
    L20:
        if (this.lastNestedScrollDy != 0) goto L38;
        int r9 = r5.getTop();
        if (this.fitToContents == true) goto L24;
        int r1 = this.halfExpandedOffset;
        if (r9 >= r1) goto L34;
        if (r9 >= Math.abs(r9 - this.collapsedOffset)) goto L32;
        r8 = 0;
        goto L40
    L32:
        r8 = this.halfExpandedOffset;
    L36:
        r0 = 6;
        goto L40
    L34:
        if (Math.abs(r9 - r1) >= Math.abs(r9 - this.collapsedOffset)) goto L37;
        r8 = this.halfExpandedOffset;
        goto L36
    L37:
        r8 = this.collapsedOffset;
    L39:
        r0 = 4;
        goto L40
    L24:
        if (Math.abs(r9 - this.fitToContentsOffset) >= Math.abs(r9 - this.collapsedOffset)) goto L26;
        r8 = this.fitToContentsOffset;
        goto L40
    L26:
        r8 = this.collapsedOffset;
        goto L39
    L38:
        r8 = this.collapsedOffset;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout r3, V r4, View r5, float r6, float r7) {
        if (r5 == this.nestedScrollingChildRef.get()) goto L5;
    L9:
        return false;
    L5:
        if (this.state == 3) goto L7;
    L8:
        return true;
    L7:
        if (super.onNestedPreFling(r3, r4, r5, r6, r7) == false) goto L9;
        goto L8
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public void setFitToContents(boolean r2) {
        if (this.fitToContents != r2) goto L5;
        return;
    L5:
        this.fitToContents = r2;
        if (this.viewRef == null) goto L9;
        calculateCollapsedOffset();
    L9:
        if (this.fitToContents == true) goto L11;
    L13:
        int r3 = this.state;
    L14:
        setStateInternal(r3);
        return;
    L11:
        if (this.state != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public final void setPeekHeight(int r4) {
        boolean r1 = true;
        if (r4 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        if (this.state != 4) goto L24;
        WeakReference<V> r3 = this.viewRef;
        if (r3 == null) goto L25;
        V r5 = r3.get();
        if (r5 == null) goto L26;
        r5.requestLayout();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L12:
        r1 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r4);
        this.collapsedOffset = this.parentHeight - r4;
        goto L14
    L10:
        if (this.peekHeight == r4) goto L12;
        goto L12
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    public void setHideable(boolean r1) {
        this.hideable = r1;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void setSkipCollapsed(boolean r1) {
        this.skipCollapsed = r1;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback r3) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r3 == null) goto L6;
        this.callbacks.add(r3);
        return;
    }

    public void addBottomSheetCallback(BottomSheetCallback r2) {
        if (this.callbacks.contains(r2) == true) goto L6;
        this.callbacks.add(r2);
        return;
    }

    public void removeBottomSheetCallback(BottomSheetCallback r1) {
        this.callbacks.remove(r1);
    }

    public final void setState(final int r3) {
        if (r3 != this.state) goto L5;
        return;
    L5:
        WeakReference<V> r0 = this.viewRef;
        if (r0 == null) goto L8;
        final V r1 = r0.get();
        if (r1 != null) goto L22;
        return;
    L22:
        ViewParent r2 = r1.getParent();
        if (r2 != null) goto L25;
    L29:
        startSettlingAnimation(r1, r3);
        return;
    L25:
        if (r2.isLayoutRequested() == false) goto L29;
        if (ViewCompat.isAttachedToWindow(r1) == false) goto L29;
        r1.post(new AnonymousClass1(this, r1, r3));
        return;
    L8:
        if (r3 != 4) goto L10;
    L17:
        this.state = r3;
        return;
    L10:
        if (r3 == 3) goto L17;
        if (r3 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r3 == 5) goto L17;
    }

    public final int getState() {
        return this.state;
    }

    public final int getTargetState() {
        return this.targetState;
    }

    void setStateInternal(int r4) {
        if (this.state != r4) goto L5;
        return;
    L5:
        this.state = r4;
        int r1 = 0;
        if (r4 != 6) goto L8;
    L15:
        updateImportantForAccessibility(true);
    L16:
        V r0 = this.viewRef.get();
    L18:
        if (r1 >= this.callbacks.size()) goto L20;
        this.callbacks.get(r1).onStateChanged(r0, r4);
        r1 = r1 + 1;
        goto L18
    L20:
        return;
    L8:
        if (r4 == 3) goto L15;
        if (r4 != 5) goto L13;
    L14:
        updateImportantForAccessibility(false);
        goto L16
    L13:
        if (r4 != 4) goto L16;
        goto L14
    }

    protected void calculateCollapsedOffset() {
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - this.lastPeekHeight;
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    boolean shouldHide(View r5, float r6) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r6 != 0.0f) goto L18;
        if (this.is69Mode == false) goto L14;
        if (r5.getTop() <= (this.collapsedOffset + (this.lastPeekHeight / 2))) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (r5.getTop() <= (((this.parentHeight - getExpandedOffset()) / 2) + getExpandedOffset())) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.targetState != 4) goto L27;
        if (this.peekHeight <= (OUnitExtensionKt.getScreenHeight(r5.getContext()) / 2)) goto L27;
        if (r6 <= (this.maximumVelocity * 0.08f)) goto L25;
        return true;
    L25:
        return false;
    L27:
        if ((Math.abs((r5.getTop() + (r6 * 0.1f)) - this.collapsedOffset) / this.peekHeight) <= 0.5f) goto L30;
        return true;
    L30:
        return false;
    }

    View findScrollingChild(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r5) == false) goto L9;
        return r5;
    L9:
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L16;
        View r3 = findScrollingChild(r6.getChildAt(r2));
        if (r3 != null) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    L16:
        return null;
    }

    public void setInterceptTouchEvent(InterceptTouchEvent r1) {
        this.interceptTouchEvent = r1;
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private int getExpandedOffset() {
        if (this.fitToContents == true) goto L7;
        return 0;
    L7:
        return this.fitToContentsOffset;
    }

    void startSettlingAnimation(View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.collapsedOffset;
    L20:
        if (this.viewDragHelper.smoothSlideViewTo(r4, r4.getLeft(), r0) == false) goto L22;
        setStateInternal(2);
        ViewCompat.postOnAnimation(r4, new SettleRunnable(this, r4, r5));
        return;
    L22:
        setStateInternal(r5);
        return;
    L6:
        if (r5 != 6) goto L12;
        r0 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L20;
        int r2 = this.fitToContentsOffset;
        if (r0 > r2) goto L20;
        r5 = 3;
        r0 = r2;
        goto L20
    L12:
        if (r5 != 3) goto L15;
        r0 = getExpandedOffset();
        goto L20
    L15:
        if (this.hideable == false) goto L25;
        if (r5 != 5) goto L25;
        r0 = this.parentHeight;
    L25:
        throw new IllegalArgumentException("Illegal state argument: " + r5);
    }

    private int[] getReleaseParam(View r7, float r8, float r9) {
        int r2 = 6;
        int r4 = 3;
        if (r9 >= 0.0f) goto L16;
        if (Math.abs(r9) <= 1500.0f) goto L16;
        if (this.fitToContents == false) goto L9;
        int r6 = this.fitToContentsOffset;
    L48:
        return new int[]{r6, r4};
    L9:
        int r10 = r7.getTop();
        r6 = this.halfExpandedOffset;
        if (r10 > r6) goto L14;
        r6 = 0;
    L13:
        r2 = 3;
    L14:
        r4 = r2;
    L16:
        if (this.hideable == false) goto L25;
        if (shouldHide(r7, r9) == false) goto L25;
        if (r7.getTop() <= this.collapsedOffset) goto L22;
    L23:
        r6 = this.parentHeight;
        r4 = 5;
        goto L48
    L22:
        if (Math.abs(r8) < Math.abs(r9)) goto L23;
    L25:
        if (r9 != 0.0f) goto L27;
    L30:
        int r11 = r7.getTop();
        if (this.fitToContents == true) goto L33;
        int r12 = this.halfExpandedOffset;
        if (r11 >= r12) goto L44;
        if (r11 >= Math.abs(r11 - this.collapsedOffset)) goto L42;
        r6 = 0;
        goto L13
    L42:
        r6 = this.halfExpandedOffset;
        goto L14
    L44:
        if (Math.abs(r11 - r12) >= Math.abs(r11 - this.collapsedOffset)) goto L46;
        r6 = this.halfExpandedOffset;
        goto L14
    L46:
        r6 = this.collapsedOffset;
    L36:
        r2 = 4;
        goto L14
    L33:
        if (Math.abs(r11 - this.fitToContentsOffset) >= Math.abs(r11 - this.collapsedOffset)) goto L35;
        r6 = this.fitToContentsOffset;
        goto L13
    L35:
        r6 = this.collapsedOffset;
        goto L36
    L27:
        if (Math.abs(r8) > Math.abs(r9)) goto L30;
        r6 = this.collapsedOffset;
        r4 = 4;
        goto L48
    }

    void dispatchOnSlide(int r7) {
        V r0 = this.viewRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L17;
        int r2 = 0;
        if (r7 <= this.collapsedOffset) goto L12;
    L9:
        if (r2 >= this.callbacks.size()) goto L18;
        BottomSheetCallback r1 = this.callbacks.get(r2);
        int r3 = this.collapsedOffset;
        r1.onSlide(r0, (r3 - r7) / (this.parentHeight - r3));
        r2 = r2 + 1;
        goto L9
    L18:
        return;
    L12:
        if (r2 >= this.callbacks.size()) goto L19;
        BottomSheetCallback r4 = this.callbacks.get(r2);
        int r5 = this.collapsedOffset;
        r4.onSlide(r0, (r5 - r7) / (r5 - getExpandedOffset()));
        r2 = r2 + 1;
        goto L12
    L19:
        return;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V r1) {
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof CoordinatorLayout.LayoutParams) == false) goto L11;
        CoordinatorLayout.Behavior r3 = ((CoordinatorLayout.LayoutParams) r2).getBehavior();
        if ((r3 instanceof BottomSheetBehavior) == false) goto L9;
        return (BottomSheetBehavior) r3;
    L9:
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    L11:
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void updateImportantForAccessibility(boolean r7) {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.get().getParent();
        if ((r1 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r2 = (CoordinatorLayout) r1;
        int r3 = r2.getChildCount();
        if (r7 == true) goto L11;
    L14:
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L27;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.viewRef.get()) goto L26;
        if (r7 == true) goto L25;
        Map<View, Integer> r6 = this.importantForAccessibilityMap;
        if (r6 == null) goto L26;
        if (r6.containsKey(r5) == false) goto L26;
        ViewCompat.setImportantForAccessibility(r5, this.importantForAccessibilityMap.get(r5).intValue());
        goto L26
    L25:
        this.importantForAccessibilityMap.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r5, 4);
    L26:
        r4 = r4 + 1;
        goto L15
    L27:
        if (r7 == true) goto L36;
        this.importantForAccessibilityMap = null;
        return;
    L36:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r3);
        goto L14
    }

    public void setIs69Mode(boolean r1) {
        this.is69Mode = r1;
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public void setMaxExpandedHeight(int r1) {
        this.maxExpandedHeight = r1;
    }

    public void setAdaptPortraitRLSlide(boolean r1) {
        this.mAdaptPortraitRLSlide = r1;
    }

    public void setAutoSlideToPeekHeight(boolean r1) {
        this.mAutoSlideToPeekHeight = r1;
    }

    public int getMaxSettleDuration() {
        return this.mMaxSettleDuration;
    }

    public void setMaxSettleDuration(int r1) {
        this.mMaxSettleDuration = r1;
    }
}
