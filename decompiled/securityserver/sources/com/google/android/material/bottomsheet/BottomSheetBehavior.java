package com.google.android.material.bottomsheet;

import a.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
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
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;

    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;

    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;

    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private int saveFlags;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;

    @Nullable
    private VelocityTracker velocityTracker;

    @Nullable
    ViewDragHelper viewDragHelper;

    @Nullable
    WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public BottomSheetCallback() {
        }

        public abstract void onSlide(@NonNull View r1, float r2);

        public abstract void onStateChanged(@NonNull View r1, int r2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Parcel r2) {
            this(r2, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.state);
            r1.writeInt(this.peekHeight);
            r1.writeInt(this.fitToContents ? 1 : 0);
            r1.writeInt(this.hideable ? 1 : 0);
            r1.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r3, ClassLoader r4) {
            super(r3, r4);
            this.state = r3.readInt();
            this.peekHeight = r3.readInt();
            boolean r0 = false;
            if (r3.readInt() != 1) goto L5;
            boolean r5 = true;
        L6:
            this.fitToContents = r5;
            if (r3.readInt() != 1) goto L9;
            boolean r6 = true;
        L10:
            this.hideable = r6;
            if (r3.readInt() != 1) goto L13;
            r0 = true;
        L13:
            this.skipCollapsed = r0;
            return;
        L9:
            r6 = false;
            goto L10
        L5:
            r5 = false;
            goto L6
        }

        public SavedState(Parcelable r1, @NonNull BottomSheetBehavior<?> r2) {
            super(r1);
            this.state = r2.state;
            this.peekHeight = BottomSheetBehavior.access$600(r2);
            this.fitToContents = BottomSheetBehavior.access$500(r2);
            this.hideable = r2.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$700(r2);
        }

        @Deprecated
        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.state = r2;
        }
    }

    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        public SettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.this$0 = r1;
            this.view = r2;
            this.targetState = r3;
        }

        public static /* synthetic */ boolean access$300(SettleRunnable r0) {
            return r0.isPosted;
        }

        public static /* synthetic */ boolean access$302(SettleRunnable r0, boolean r1) {
            r0.isPosted = r1;
            return r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper r0 = this.this$0.viewDragHelper;
            if (r0 != null) goto L5;
        L7:
            this.this$0.setStateInternal(this.targetState);
        L8:
            this.isPosted = false;
            return;
        L5:
            if (r0.continueSettling(true) == false) goto L7;
            ViewCompat.postOnAnimation(this.view, this);
            goto L8
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.dragCallback = new AnonymousClass4(this);
    }

    public static /* synthetic */ MaterialShapeDrawable access$000(BottomSheetBehavior r0) {
        return r0.materialShapeDrawable;
    }

    public static /* synthetic */ int access$102(BottomSheetBehavior r0, int r1) {
        r0.gestureInsetBottom = r1;
        return r1;
    }

    public static /* synthetic */ void access$200(BottomSheetBehavior r0, boolean r1) {
        r0.updatePeekHeight(r1);
    }

    public static /* synthetic */ boolean access$400(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    public static /* synthetic */ boolean access$500(BottomSheetBehavior r0) {
        return r0.fitToContents;
    }

    public static /* synthetic */ int access$600(BottomSheetBehavior r0) {
        return r0.peekHeight;
    }

    public static /* synthetic */ boolean access$700(BottomSheetBehavior r0) {
        return r0.skipCollapsed;
    }

    private void addAccessibilityActionForState(V r2, AccessibilityNodeInfoCompat.AccessibilityActionCompat r3, final int r4) {
        ViewCompat.replaceAccessibilityAction(r2, r3, null, new AnonymousClass5(this, r4));
    }

    private void calculateCollapsedOffset() {
        int r0 = calculatePeekHeight();
        if (this.fitToContents == false) goto L5;
        this.collapsedOffset = Math.max(this.parentHeight - r0, this.fitToContentsOffset);
        return;
    L5:
        this.collapsedOffset = this.parentHeight - r0;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * this.parentHeight);
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == true) goto L5;
        int r0 = this.peekHeight;
        if (this.gestureInsetBottomIgnored == false) goto L9;
        int r2 = 0;
    L11:
        return r0 + r2;
    L9:
        r2 = this.gestureInsetBottom;
        goto L11
    L5:
        return Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16));
    }

    private void createMaterialShapeDrawable(@NonNull Context r2, AttributeSet r3, boolean r4) {
        createMaterialShapeDrawable(r2, r3, r4, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = r0;
        r0.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass2(this));
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V r1) {
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

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker r0 = this.velocityTracker;
        if (r0 == null) goto L6;
        r0.recycle();
        this.velocityTracker = null;
        return;
    }

    private void restoreOptionalState(@NonNull SavedState r5) {
        int r0 = this.saveFlags;
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r0 != (-1)) goto L8;
    L9:
        this.peekHeight = r5.peekHeight;
    L10:
        if (r0 != (-1)) goto L12;
    L13:
        this.fitToContents = r5.fitToContents;
    L14:
        if (r0 != (-1)) goto L16;
    L17:
        this.hideable = r5.hideable;
    L18:
        if (r0 != (-1)) goto L20;
    L21:
        this.skipCollapsed = r5.skipCollapsed;
        return;
    L20:
        if ((r0 & 8) == 8) goto L21;
        return;
    L16:
        if ((r0 & 4) != 4) goto L18;
    L12:
        if ((r0 & 2) != 2) goto L14;
    L8:
        if ((r0 & 1) != 1) goto L10;
        goto L9
    }

    private void setSystemGestureInsets(@NonNull View r2) {
        if (isGestureInsetBottomIgnored() == false) goto L5;
        return;
    L5:
        if (this.peekHeightAuto == true) goto L9;
        ViewUtils.doOnApplyWindowInsets(r2, new AnonymousClass3(this));
        return;
    }

    private void settleToStatePendingLayout(final int r3) {
        final V r0 = this.viewRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        if (r1 != null) goto L8;
    L12:
        settleToState(r0, r3);
        return;
    L8:
        if (r1.isLayoutRequested() == false) goto L12;
        if (ViewCompat.isAttachedToWindow(r0) == false) goto L12;
        r0.post(new AnonymousClass1(this, r0, r3));
    }

    private void updateAccessibilityActions() {
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L5;
        return;
    L5:
        V r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        ViewCompat.removeAccessibilityAction(r1, 524288);
        ViewCompat.removeAccessibilityAction(r1, 262144);
        ViewCompat.removeAccessibilityAction(r1, 1048576);
        if (this.hideable == true) goto L11;
    L13:
        int r2 = this.state;
        int r3 = 6;
        if (r2 == 3) goto L24;
        if (r2 == 4) goto L20;
        if (r2 != 6) goto L30;
        addAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        addAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L30:
        return;
    L20:
        if (this.fitToContents == false) goto L22;
        r3 = 3;
    L22:
        addAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, r3);
        return;
    L24:
        if (this.fitToContents == false) goto L26;
        r3 = 4;
    L26:
        addAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, r3);
        return;
    L11:
        if (this.state == 5) goto L13;
        addAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L13
    }

    private void updateDrawableForTargetState(int r6) {
        if (r6 != 2) goto L6;
        return;
    L6:
        if (r6 != 3) goto L8;
        boolean r7 = true;
    L10:
        if (this.isShapeExpanded == r7) goto L24;
        this.isShapeExpanded = r7;
        if (this.materialShapeDrawable == null) goto L25;
        ValueAnimator r3 = this.interpolatorAnimator;
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.isRunning() == false) goto L19;
        this.interpolatorAnimator.reverse();
        return;
    L19:
        if (r7 == false) goto L21;
        float r8 = 0.0f;
    L22:
        this.interpolatorAnimator.setFloatValues(new float[]{1.0f - r8, r8});
        this.interpolatorAnimator.start();
        return;
    L21:
        r8 = 1.0f;
        goto L22
    L25:
        return;
    L24:
        return;
    L8:
        r7 = false;
        goto L10
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
        if (r4 >= r3) goto L31;
        View r5 = r2.getChildAt(r4);
        if (r5 == this.viewRef.get()) goto L30;
        if (r7 == false) goto L24;
        this.importantForAccessibilityMap.put(r5, Integer.valueOf(r5.getImportantForAccessibility()));
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        ViewCompat.setImportantForAccessibility(r5, 4);
        goto L30
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L30;
        Map<View, Integer> r6 = this.importantForAccessibilityMap;
        if (r6 == null) goto L30;
        if (r6.containsKey(r5) == false) goto L30;
        ViewCompat.setImportantForAccessibility(r5, this.importantForAccessibilityMap.get(r5).intValue());
    L30:
        r4 = r4 + 1;
        goto L15
    L31:
        if (r7 == true) goto L42;
        this.importantForAccessibilityMap = null;
        return;
    L42:
        return;
    L11:
        if (this.importantForAccessibilityMap != null) goto L13;
        this.importantForAccessibilityMap = new HashMap(r3);
        goto L14
    }

    private void updatePeekHeight(boolean r3) {
        if (this.viewRef == null) goto L12;
        calculateCollapsedOffset();
        if (this.state != 4) goto L13;
        V r0 = this.viewRef.get();
        if (r0 == null) goto L14;
        if (r3 == false) goto L10;
        settleToStatePendingLayout(this.state);
        return;
    L10:
        r0.requestLayout();
        return;
    L14:
        return;
    L13:
        return;
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback r2) {
        if (this.callbacks.contains(r2) == true) goto L6;
        this.callbacks.add(r2);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int r4) {
        V r0 = this.viewRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L20;
        int r1 = this.collapsedOffset;
        if (r4 <= r1) goto L9;
    L13:
        int r2 = this.collapsedOffset;
        float r5 = r2 - r4;
        float r3 = this.parentHeight - r2;
    L12:
        float r6 = r5 / r3;
        int r7 = 0;
    L16:
        if (r7 >= this.callbacks.size()) goto L21;
        this.callbacks.get(r7).onSlide(r0, r6);
        r7 = r7 + 1;
        goto L16
    L21:
        return;
    L9:
        if (r1 == getExpandedOffset()) goto L13;
        int r8 = this.collapsedOffset;
        r5 = r8 - r4;
        r3 = r8 - getExpandedOffset();
        goto L12
    }

    @Nullable
    @VisibleForTesting
    public View findScrollingChild(View r4) {
        if (ViewCompat.isNestedScrollingEnabled(r4) == false) goto L6;
        return r4;
    L6:
        if ((r4 instanceof ViewGroup) == false) goto L13;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L17;
        View r2 = findScrollingChild(r5.getChildAt(r1));
        if (r2 != null) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L17:
        return null;
    L13:
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == false) goto L6;
        return this.fitToContentsOffset;
    L6:
        return this.expandedOffset;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams r1) {
        super.onAttachedToLayoutParams(r1);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
        if (r11.isShown() == true) goto L5;
    L64:
        this.ignoreEvents = true;
        return false;
    L5:
        if (this.draggable == false) goto L64;
        int r0 = r12.getActionMasked();
        if (r0 != 0) goto L11;
        reset();
    L11:
        if (this.velocityTracker != null) goto L13;
        this.velocityTracker = VelocityTracker.obtain();
    L13:
        this.velocityTracker.addMovement(r12);
        View r3 = null;
        if (r0 == 0) goto L23;
        if (r0 != 1) goto L17;
    L19:
        this.touchingScrollingChild = false;
        this.activePointerId = -1;
        if (this.ignoreEvents == false) goto L41;
        this.ignoreEvents = false;
        return false;
    L41:
        if (this.ignoreEvents == true) goto L47;
        ViewDragHelper r13 = this.viewDragHelper;
        if (r13 == null) goto L47;
        if (r13.shouldInterceptTouchEvent(r12) == false) goto L47;
        return true;
    L47:
        WeakReference<View> r14 = this.nestedScrollingChildRef;
        if (r14 == null) goto L50;
        r3 = r14.get();
    L50:
        if (r0 != 2) goto L66;
        if (r3 != null) goto L53;
        return false;
    L53:
        if (this.ignoreEvents == false) goto L55;
        return false;
    L55:
        if (this.state != 1) goto L57;
        return false;
    L57:
        if (r10.isPointInChildBounds(r3, (int) r12.getX(), (int) r12.getY()) == false) goto L59;
        return false;
    L59:
        if (this.viewDragHelper != null) goto L61;
        return false;
    L61:
        if (Math.abs(this.initialY - r12.getY()) > this.viewDragHelper.getTouchSlop()) goto L63;
        return false;
    L63:
        return true;
    L66:
        return false;
    L17:
        if (r0 == 3) goto L19;
    L23:
        int r6 = (int) r12.getX();
        this.initialY = (int) r12.getY();
        if (this.state == 2) goto L34;
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 == null) goto L28;
        View r8 = r7.get();
    L29:
        if (r8 == null) goto L34;
        if (r10.isPointInChildBounds(r8, r6, this.initialY) == false) goto L34;
        this.activePointerId = r12.getPointerId(r12.getActionIndex());
        this.touchingScrollingChild = true;
        goto L34
    L28:
        r8 = null;
    L34:
        if (this.activePointerId == (-1)) goto L36;
    L38:
        boolean r15 = false;
    L39:
        this.ignoreEvents = r15;
        goto L41
    L36:
        if (r10.isPointInChildBounds(r11, r6, this.initialY) == true) goto L38;
        r15 = true;
        goto L39
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r7, @NonNull V r8, int r9) {
        if (ViewCompat.getFitsSystemWindows(r7) == false) goto L8;
        if (ViewCompat.getFitsSystemWindows(r8) == true) goto L8;
        r8.setFitsSystemWindows(true);
    L8:
        if (this.viewRef != null) goto L32;
        this.peekHeightMin = r7.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
        setSystemGestureInsets(r8);
        this.viewRef = new WeakReference(r8);
        if (this.shapeThemingEnabled == false) goto L14;
        MaterialShapeDrawable r0 = this.materialShapeDrawable;
        if (r0 == null) goto L14;
        ViewCompat.setBackground(r8, r0);
    L14:
        MaterialShapeDrawable r1 = this.materialShapeDrawable;
        if (r1 == null) goto L28;
        float r4 = this.elevation;
        if (r4 != (-1.0f)) goto L19;
        r4 = ViewCompat.getElevation(r8);
    L19:
        r1.setElevation(r4);
        if (this.state != 3) goto L22;
        boolean r2 = true;
    L23:
        this.isShapeExpanded = r2;
        MaterialShapeDrawable r5 = this.materialShapeDrawable;
        if (r2 == false) goto L26;
        float r3 = 0.0f;
    L27:
        r5.setInterpolation(r3);
        goto L28
    L26:
        r3 = 1.0f;
        goto L27
    L22:
        r2 = false;
    L28:
        updateAccessibilityActions();
        if (ViewCompat.getImportantForAccessibility(r8) != 0) goto L32;
        ViewCompat.setImportantForAccessibility(r8, 1);
    L32:
        if (this.viewDragHelper != null) goto L34;
        this.viewDragHelper = ViewDragHelper.create(r7, this.dragCallback);
    L34:
        int r6 = r8.getTop();
        r7.onLayoutChild(r8, r9);
        this.parentWidth = r7.getWidth();
        int r10 = r7.getHeight();
        this.parentHeight = r10;
        this.fitToContentsOffset = Math.max(0, r10 - r8.getHeight());
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r11 = this.state;
        if (r11 != 3) goto L38;
        ViewCompat.offsetTopAndBottom(r8, getExpandedOffset());
    L52:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r8));
        return true;
    L38:
        if (r11 != 6) goto L41;
        ViewCompat.offsetTopAndBottom(r8, this.halfExpandedOffset);
        goto L52
    L41:
        if (this.hideable == false) goto L46;
        if (r11 != 5) goto L46;
        ViewCompat.offsetTopAndBottom(r8, this.parentHeight);
    L46:
        if (r11 != 4) goto L48;
        ViewCompat.offsetTopAndBottom(r8, this.collapsedOffset);
        goto L52
    L48:
        if (r11 != 1) goto L50;
    L51:
        ViewCompat.offsetTopAndBottom(r8, r6 - r8.getTop());
        goto L52
    L50:
        if (r11 != 2) goto L52;
        goto L51
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r4, @NonNull V r5, @NonNull View r6, float r7, float r8) {
        WeakReference<View> r0 = this.nestedScrollingChildRef;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r6 == r0.get()) goto L7;
        return false;
    L7:
        if (this.state == 3) goto L9;
    L10:
        return true;
    L9:
        if (super.onNestedPreFling(r4, r5, r6, r7, r8) == true) goto L10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout r2, @NonNull V r3, @NonNull View r4, int r5, int r6, @NonNull int[] r7, int r8) {
        if (r8 != 1) goto L5;
        return;
    L5:
        WeakReference<View> r9 = this.nestedScrollingChildRef;
        if (r9 == null) goto L8;
        View r10 = r9.get();
    L9:
        if (r4 == r10) goto L11;
        return;
    L11:
        int r11 = r3.getTop();
        int r12 = r11 - r6;
        if (r6 > 0) goto L14;
        if (r6 < 0) goto L22;
    L33:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L22:
        if (r4.canScrollVertically(-1) == true) goto L33;
        int r13 = this.collapsedOffset;
        if (r12 <= r13) goto L30;
        if (this.hideable == true) goto L30;
        int r14 = r11 - r13;
        r7[1] = r14;
        ViewCompat.offsetTopAndBottom(r3, -r14);
        setStateInternal(4);
    L30:
        if (this.draggable == true) goto L32;
        return;
    L32:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L33
    L14:
        if (r12 >= getExpandedOffset()) goto L17;
        int r15 = r11 - getExpandedOffset();
        r7[1] = r15;
        ViewCompat.offsetTopAndBottom(r3, -r15);
        setStateInternal(3);
        goto L33
    L17:
        if (this.draggable == true) goto L19;
        return;
    L19:
        r7[1] = r6;
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L33
    L8:
        r10 = null;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, int r4, int r5, int r6, int r7, int r8, @NonNull int[] r9) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout r2, @NonNull V r3, @NonNull Parcelable r4) {
        SavedState r5 = (SavedState) r4;
        super.onRestoreInstanceState(r2, r3, r5.getSuperState());
        restoreOptionalState(r5);
        int r6 = r5.state;
        if (r6 != 1) goto L5;
    L8:
        this.state = 4;
        return;
    L5:
        if (r6 == 2) goto L8;
        this.state = r6;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r2, @NonNull V r3) {
        return new SavedState(super.onSaveInstanceState(r2, r3), this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r1, @NonNull V r2, @NonNull View r3, @NonNull View r4, int r5, int r6) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((r5 & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout r3, @NonNull V r4, @NonNull View r5, int r6) {
        int r0 = 3;
        if (r4.getTop() != getExpandedOffset()) goto L6;
        setStateInternal(3);
        return;
    L6:
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 != null) goto L9;
        return;
    L9:
        if (r5 == r7.get()) goto L11;
        return;
    L11:
        if (this.nestedScrolled == true) goto L14;
        return;
    L14:
        if (this.lastNestedScrollDy <= 0) goto L23;
        if (this.fitToContents == false) goto L18;
        int r8 = this.fitToContentsOffset;
    L54:
        startSettlingAnimation(r4, r0, r8, false);
        this.nestedScrolled = false;
        return;
    L18:
        int r9 = r4.getTop();
        int r10 = this.halfExpandedOffset;
        if (r9 <= r10) goto L21;
        r0 = 6;
        r8 = r10;
        goto L54
    L21:
        r8 = this.expandedOffset;
        goto L54
    L23:
        if (this.hideable == false) goto L28;
        if (shouldHide(r4, getYVelocity()) == false) goto L28;
        r8 = this.parentHeight;
        r0 = 5;
    L28:
        if (this.lastNestedScrollDy != 0) goto L46;
        int r11 = r4.getTop();
        if (this.fitToContents == true) goto L32;
        int r1 = this.halfExpandedOffset;
        if (r11 >= r1) goto L42;
        if (r11 >= Math.abs(r11 - this.collapsedOffset)) goto L40;
        r8 = this.expandedOffset;
        goto L54
    L40:
        r8 = this.halfExpandedOffset;
    L52:
        r0 = 6;
        goto L54
    L42:
        if (Math.abs(r11 - r1) >= Math.abs(r11 - this.collapsedOffset)) goto L44;
        r8 = this.halfExpandedOffset;
        goto L52
    L44:
        r8 = this.collapsedOffset;
    L48:
        r0 = 4;
        goto L54
    L32:
        if (Math.abs(r11 - this.fitToContentsOffset) >= Math.abs(r11 - this.collapsedOffset)) goto L34;
        r8 = this.fitToContentsOffset;
        goto L54
    L34:
        r8 = this.collapsedOffset;
        goto L48
    L46:
        if (this.fitToContents == false) goto L49;
        r8 = this.collapsedOffset;
        goto L48
    L49:
        int r12 = r4.getTop();
        if (Math.abs(r12 - this.halfExpandedOffset) >= Math.abs(r12 - this.collapsedOffset)) goto L53;
        r8 = this.halfExpandedOffset;
        goto L52
    L53:
        r8 = this.collapsedOffset;
        goto L48
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r3, @NonNull V r4, @NonNull MotionEvent r5) {
        if (r4.isShown() == true) goto L6;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (this.state != 1) goto L10;
        if (r6 != 0) goto L10;
        return true;
    L10:
        ViewDragHelper r0 = this.viewDragHelper;
        if (r0 == null) goto L13;
        r0.processTouchEvent(r5);
    L13:
        if (r6 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r5);
        if (r6 != 2) goto L26;
        if (this.ignoreEvents == true) goto L26;
        if (Math.abs(this.initialY - r5.getY()) <= this.viewDragHelper.getTouchSlop()) goto L26;
        this.viewDragHelper.captureChildView(r4, r5.getPointerId(r5.getActionIndex()));
    L26:
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback r1) {
        this.callbacks.remove(r1);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback r3) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (r3 == null) goto L6;
        this.callbacks.add(r3);
        return;
    }

    public void setDraggable(boolean r1) {
        this.draggable = r1;
    }

    public void setExpandedOffset(int r1) {
        if (r1 < 0) goto L6;
        this.expandedOffset = r1;
        return;
    L6:
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
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
        updateAccessibilityActions();
        return;
    L11:
        if (this.state != 6) goto L13;
        r3 = 3;
        goto L14
    }

    public void setGestureInsetBottomIgnored(boolean r1) {
        this.gestureInsetBottomIgnored = r1;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float r2) {
        if (r2 <= 0.0f) goto L11;
        if (r2 >= 1.0f) goto L11;
        this.halfExpandedRatio = r2;
        if (this.viewRef == null) goto L12;
        calculateHalfExpandedOffset();
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean r2) {
        if (this.hideable == r2) goto L11;
        this.hideable = r2;
        if (r2 == false) goto L7;
    L9:
        updateAccessibilityActions();
        return;
    L7:
        if (this.state != 5) goto L9;
        setState(4);
        goto L9
    }

    public void setPeekHeight(int r2) {
        setPeekHeight(r2, false);
    }

    public void setSaveFlags(int r1) {
        this.saveFlags = r1;
    }

    public void setSkipCollapsed(boolean r1) {
        this.skipCollapsed = r1;
    }

    public void setState(int r2) {
        if (r2 != this.state) goto L6;
        return;
    L6:
        if (this.viewRef == null) goto L8;
        settleToStatePendingLayout(r2);
        return;
    L8:
        if (r2 != 4) goto L10;
    L17:
        this.state = r2;
        return;
    L10:
        if (r2 == 3) goto L17;
        if (r2 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r2 == 5) goto L17;
    }

    public void setStateInternal(int r4) {
        if (this.state != r4) goto L5;
        return;
    L5:
        this.state = r4;
        WeakReference<V> r0 = this.viewRef;
        if (r0 != null) goto L8;
        return;
    L8:
        V r1 = r0.get();
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = 0;
        if (r4 != 3) goto L15;
        updateImportantForAccessibility(true);
    L21:
        updateDrawableForTargetState(r4);
    L23:
        if (r2 >= this.callbacks.size()) goto L25;
        this.callbacks.get(r2).onStateChanged(r1, r4);
        r2 = r2 + 1;
        goto L23
    L25:
        updateAccessibilityActions();
        return;
    L15:
        if (r4 != 6) goto L17;
    L20:
        updateImportantForAccessibility(false);
        goto L21
    L17:
        if (r4 == 5) goto L20;
        if (r4 != 4) goto L21;
        goto L20
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r1) {
        this.updateImportantForAccessibilityOnSiblings = r1;
    }

    public void settleToState(@NonNull View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.collapsedOffset;
    L19:
        startSettlingAnimation(r4, r5, r0, false);
        return;
    L6:
        if (r5 != 6) goto L12;
        r0 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L19;
        int r2 = this.fitToContentsOffset;
        if (r0 > r2) goto L19;
        r5 = 3;
        r0 = r2;
        goto L19
    L12:
        if (r5 != 3) goto L15;
        r0 = getExpandedOffset();
        goto L19
    L15:
        if (this.hideable == false) goto L22;
        if (r5 != 5) goto L22;
        r0 = this.parentHeight;
    L22:
        throw new IllegalArgumentException(a.e(r5, "Illegal state argument: "));
    }

    public boolean shouldHide(@NonNull View r5, float r6) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r5.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs(((r6 * HIDE_FRICTION) + r5.getTop()) - this.collapsedOffset) / calculatePeekHeight()) <= HIDE_THRESHOLD) goto L12;
        return true;
    L12:
        return false;
    }

    public void startSettlingAnimation(View r2, int r3, int r4, boolean r5) {
        if (r5 == false) goto L4;
        boolean r6 = this.viewDragHelper.settleCapturedViewAt(r2.getLeft(), r4);
    L5:
        if (r6 == false) goto L13;
        setStateInternal(2);
        updateDrawableForTargetState(r3);
        if (this.settleRunnable != null) goto L10;
        this.settleRunnable = new SettleRunnable(this, r2, r3);
    L10:
        if (SettleRunnable.access$300(this.settleRunnable) == true) goto L12;
        BottomSheetBehavior<V>.SettleRunnable r7 = this.settleRunnable;
        r7.targetState = r3;
        ViewCompat.postOnAnimation(r2, r7);
        SettleRunnable.access$302(this.settleRunnable, true);
        return;
    L12:
        this.settleRunnable.targetState = r3;
        return;
    L13:
        setStateInternal(r3);
        return;
    L4:
        r6 = this.viewDragHelper.smoothSlideViewTo(r2, r2.getLeft(), r4);
        goto L5
    }

    private void createMaterialShapeDrawable(@NonNull Context r3, AttributeSet r4, boolean r5, @Nullable ColorStateList r6) {
        if (this.shapeThemingEnabled == false) goto L10;
        this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(r3, r4, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        MaterialShapeDrawable r7 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = r7;
        r7.initializeElevationOverlay(r3);
        if (r5 == false) goto L8;
        if (r6 == null) goto L8;
        this.materialShapeDrawable.setFillColor(r6);
        return;
    L8:
        TypedValue r8 = new TypedValue();
        r3.getTheme().resolveAttribute(android.R.attr.colorBackground, r8, true);
        this.materialShapeDrawable.setTint(r8.data);
        return;
    }

    public final void setPeekHeight(int r2, boolean r3) {
        if (r2 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L14;
        this.peekHeightAuto = true;
    L12:
        updatePeekHeight(r3);
        return;
    L14:
        return;
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L11:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r2);
        goto L12
    L10:
        if (this.peekHeight != r2) goto L11;
    }

    public BottomSheetBehavior(@NonNull Context r8, @Nullable AttributeSet r9) {
        super(r8, r9);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.settleRunnable = null;
        this.halfExpandedRatio = HIDE_THRESHOLD;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList();
        this.dragCallback = new AnonymousClass4(this);
        TypedArray r4 = r8.obtainStyledAttributes(r9, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = r4.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean r5 = r4.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (r5 == false) goto L5;
        createMaterialShapeDrawable(r8, r9, r5, MaterialResources.getColorStateList(r8, r4, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
    L6:
        createShapeValueAnimator();
        this.elevation = r4.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        TypedValue r10 = r4.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (r10 == null) goto L11;
        int r11 = r10.data;
        if (r11 != (-1)) goto L11;
        setPeekHeight(r11);
    L12:
        setHideable(r4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r4.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r4.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r4.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r4.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, HIDE_THRESHOLD));
        TypedValue r12 = r4.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (r12 != null) goto L15;
    L17:
        setExpandedOffset(r4.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
    L18:
        r4.recycle();
        this.maximumVelocity = ViewConfiguration.get(r8).getScaledMaximumFlingVelocity();
        return;
    L15:
        if (r12.type != 16) goto L17;
        setExpandedOffset(r12.data);
    L11:
        setPeekHeight(r4.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        goto L12
    L5:
        createMaterialShapeDrawable(r8, r9, r5);
        goto L6
    }
}
