package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
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
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
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

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = 0;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
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
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
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
    private int insetBottom;
    private int insetTop;

    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    int lastStableState;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;

    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
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

    protected static class SavedState extends AbsSavedState {
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

        @Deprecated
        public SavedState(Parcelable r1, int r2) {
            super(r1);
            this.state = r2;
        }

        public SavedState(Parcelable r1, @NonNull BottomSheetBehavior<?> r2) {
            super(r1);
            this.state = r2.state;
            this.peekHeight = BottomSheetBehavior.access$1100(r2);
            this.fitToContents = BottomSheetBehavior.access$1000(r2);
            this.hideable = r2.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$1200(r2);
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
    }

    private class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        final /* synthetic */ BottomSheetBehavior this$0;
        private final View view;

        SettleRunnable(BottomSheetBehavior r1, View r2, int r3) {
            this.this$0 = r1;
            this.view = r2;
            this.targetState = r3;
        }

        static /* synthetic */ boolean access$800(SettleRunnable r0) {
            return r0.isPosted;
        }

        static /* synthetic */ boolean access$802(SettleRunnable r0, boolean r1) {
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
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
    }

    public BottomSheetBehavior(@NonNull Context r9, @Nullable AttributeSet r10) {
        super(r9, r10);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.lastStableState = 4;
        this.callbacks = new ArrayList();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new AnonymousClass4(this);
        this.peekHeightGestureInsetBuffer = r9.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray r5 = r9.obtainStyledAttributes(r10, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = r5.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int r6 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean r7 = r5.hasValue(r6);
        if (r7 == false) goto L5;
        createMaterialShapeDrawable(r9, r10, r7, MaterialResources.getColorStateList(r9, r5, r6));
    L6:
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT < 21) goto L9;
        this.elevation = r5.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
    L9:
        int r11 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (r5.hasValue(r11) == false) goto L12;
        setMaxWidth(r5.getDimensionPixelSize(r11, -1));
    L12:
        int r12 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (r5.hasValue(r12) == false) goto L15;
        setMaxHeight(r5.getDimensionPixelSize(r12, -1));
    L15:
        int r13 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue r4 = r5.peekValue(r13);
        if (r4 == null) goto L20;
        int r8 = r4.data;
        if (r8 != (-1)) goto L20;
        setPeekHeight(r8);
    L21:
        setHideable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(r5.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(r5.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int r14 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue r2 = r5.peekValue(r14);
        if (r2 != null) goto L24;
    L26:
        int r15 = r5.getDimensionPixelOffset(r14, 0);
    L27:
        setExpandedOffset(r15);
        this.paddingBottomSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = r5.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        r5.recycle();
        this.maximumVelocity = ViewConfiguration.get(r9).getScaledMaximumFlingVelocity();
        return;
    L24:
        if (r2.type != 16) goto L26;
        r15 = r2.data;
    L20:
        setPeekHeight(r5.getDimensionPixelSize(r13, -1));
        goto L21
    L5:
        createMaterialShapeDrawable(r9, r10, r7);
        goto L6
    }

    static /* synthetic */ MaterialShapeDrawable access$000(BottomSheetBehavior r0) {
        return r0.materialShapeDrawable;
    }

    static /* synthetic */ boolean access$1000(BottomSheetBehavior r0) {
        return r0.fitToContents;
    }

    static /* synthetic */ int access$102(BottomSheetBehavior r0, int r1) {
        r0.insetTop = r1;
        return r1;
    }

    static /* synthetic */ int access$1100(BottomSheetBehavior r0) {
        return r0.peekHeight;
    }

    static /* synthetic */ boolean access$1200(BottomSheetBehavior r0) {
        return r0.skipCollapsed;
    }

    static /* synthetic */ boolean access$200(BottomSheetBehavior r0) {
        return r0.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$300(BottomSheetBehavior r0) {
        return r0.insetBottom;
    }

    static /* synthetic */ int access$302(BottomSheetBehavior r0, int r1) {
        r0.insetBottom = r1;
        return r1;
    }

    static /* synthetic */ boolean access$400(BottomSheetBehavior r0) {
        return r0.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$500(BottomSheetBehavior r0) {
        return r0.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ int access$602(BottomSheetBehavior r0, int r1) {
        r0.gestureInsetBottom = r1;
        return r1;
    }

    static /* synthetic */ void access$700(BottomSheetBehavior r0, boolean r1) {
        r0.updatePeekHeight(r1);
    }

    static /* synthetic */ boolean access$900(BottomSheetBehavior r0) {
        return r0.draggable;
    }

    private int addAccessibilityActionForState(V r2, @StringRes int r3, int r4) {
        return ViewCompat.addAccessibilityAction(r2, r2.getResources().getString(r3), createAccessibilityViewCommandForState(r4));
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
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        if (this.peekHeightAuto == false) goto L8;
        int r0 = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
    L6:
        return r0 + this.insetBottom;
    L8:
        if (this.gestureInsetBottomIgnored == false) goto L10;
    L15:
        r0 = this.peekHeight;
        goto L6
    L10:
        if (this.paddingBottomSystemWindowInsets == true) goto L15;
        int r1 = this.gestureInsetBottom;
        if (r1 <= 0) goto L15;
        return Math.max(this.peekHeight, r1 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int r2) {
        return new AnonymousClass5(this, r2);
    }

    private void createMaterialShapeDrawable(@NonNull Context r2, AttributeSet r3, boolean r4) {
        createMaterialShapeDrawable(r2, r3, r4, null);
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

    private int getChildMeasureSpec(int r1, int r2, int r3, int r4) {
        int r0 = ViewGroup.getChildMeasureSpec(r1, r2, r4);
        if (r3 != (-1)) goto L5;
        return r0;
    L5:
        int r5 = View.MeasureSpec.getMode(r0);
        int r6 = View.MeasureSpec.getSize(r0);
        if (r5 == 1073741824) goto L13;
        if (r6 == 0) goto L11;
        r3 = Math.min(r6, r3);
    L11:
        return View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
    L13:
        return View.MeasureSpec.makeMeasureSpec(Math.min(r6, r3), BasicMeasure.EXACTLY);
    }

    private float getYVelocity() {
        VelocityTracker r0 = this.velocityTracker;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        r0.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat r2, int r3) {
        ViewCompat.replaceAccessibilityAction(r1, r2, null, createAccessibilityViewCommandForState(r3));
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

    private void setWindowInsetsListener(@NonNull View r3) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
    L9:
        final boolean r0 = false;
    L11:
        if (this.paddingBottomSystemWindowInsets == false) goto L13;
    L18:
        ViewUtils.doOnApplyWindowInsets(r3, new AnonymousClass3(this, r0));
        return;
    L13:
        if (this.paddingLeftSystemWindowInsets == true) goto L18;
        if (this.paddingRightSystemWindowInsets == true) goto L18;
        if (r0 == true) goto L18;
        return;
    L5:
        if (isGestureInsetBottomIgnored() == true) goto L9;
        if (this.peekHeightAuto == true) goto L9;
        r0 = true;
        goto L11
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

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper != null) goto L5;
    L9:
        return false;
    L5:
        if (this.draggable == false) goto L7;
        return true;
    L7:
        if (this.state != 1) goto L9;
        return true;
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
        int r2 = this.expandHalfwayActionId;
        if (r2 == (-1)) goto L11;
        ViewCompat.removeAccessibilityAction(r1, r2);
    L11:
        int r3 = 6;
        if (this.fitToContents == true) goto L17;
        if (this.state == 6) goto L17;
        this.expandHalfwayActionId = addAccessibilityActionForState(r1, R.string.bottomsheet_action_expand_halfway, 6);
    L17:
        if (this.hideable == true) goto L19;
    L21:
        int r4 = this.state;
        if (r4 == 3) goto L32;
        if (r4 == 4) goto L28;
        if (r4 != 6) goto L38;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
    L38:
        return;
    L28:
        if (this.fitToContents == false) goto L30;
        r3 = 3;
    L30:
        AccessibilityNodeInfoCompat.AccessibilityActionCompat r5 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND;
    L35:
        replaceAccessibilityActionForState(r1, r5, r3);
        return;
    L32:
        if (this.fitToContents == false) goto L34;
        r3 = 4;
    L34:
        r5 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE;
        goto L35
    L19:
        if (this.state == 5) goto L21;
        replaceAccessibilityActionForState(r1, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        goto L21
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
        ValueAnimator r1 = this.interpolatorAnimator;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isRunning() == false) goto L19;
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

    private void updateImportantForAccessibility(boolean r9) {
        int r0 = Build.VERSION.SDK_INT;
        WeakReference<V> r1 = this.viewRef;
        if (r1 != null) goto L5;
        return;
    L5:
        ViewParent r2 = r1.get().getParent();
        if ((r2 instanceof CoordinatorLayout) == true) goto L8;
        return;
    L8:
        CoordinatorLayout r3 = (CoordinatorLayout) r2;
        int r4 = r3.getChildCount();
        if (r0 < 16) goto L15;
        if (r9 == false) goto L15;
        if (this.importantForAccessibilityMap != null) goto L14;
        this.importantForAccessibilityMap = new HashMap(r4);
        goto L15
    L14:
        return;
    L15:
        int r5 = 0;
    L16:
        if (r5 >= r4) goto L35;
        View r6 = r3.getChildAt(r5);
        if (r6 == this.viewRef.get()) goto L34;
        if (r9 == false) goto L28;
        if (r0 < 16) goto L24;
        this.importantForAccessibilityMap.put(r6, Integer.valueOf(r6.getImportantForAccessibility()));
    L24:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L34;
        int r7 = 4;
    L26:
        ViewCompat.setImportantForAccessibility(r6, r7);
        goto L34
    L28:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L34;
        Map<View, Integer> r8 = this.importantForAccessibilityMap;
        if (r8 == null) goto L34;
        if (r8.containsKey(r6) == false) goto L34;
        r7 = this.importantForAccessibilityMap.get(r6).intValue();
    L34:
        r5 = r5 + 1;
        goto L16
    L35:
        if (r9 == true) goto L38;
        this.importantForAccessibilityMap = null;
        return;
    L38:
        if (this.updateImportantForAccessibilityOnSiblings == false) goto L49;
        this.viewRef.get().sendAccessibilityEvent(8);
        return;
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

    void dispatchOnSlide(int r4) {
        V r0 = this.viewRef.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.callbacks.isEmpty() == true) goto L19;
        int r1 = this.collapsedOffset;
        if (r4 <= r1) goto L9;
    L12:
        int r2 = this.collapsedOffset;
        float r5 = r2 - r4;
        float r3 = this.parentHeight - r2;
    L13:
        float r6 = r5 / r3;
        int r7 = 0;
    L15:
        if (r7 >= this.callbacks.size()) goto L20;
        this.callbacks.get(r7).onSlide(r0, r6);
        r7 = r7 + 1;
        goto L15
    L20:
        return;
    L9:
        if (r1 == getExpandedOffset()) goto L12;
        int r8 = this.collapsedOffset;
        r5 = r8 - r4;
        r3 = r8 - getExpandedOffset();
        goto L13
    }

    @Nullable
    @VisibleForTesting
    View findScrollingChild(View r4) {
        if (ViewCompat.isNestedScrollingEnabled(r4) == false) goto L6;
        return r4;
    L6:
        if ((r4 instanceof ViewGroup) == false) goto L13;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = 0;
        int r1 = r5.getChildCount();
    L8:
        if (r0 >= r1) goto L17;
        View r2 = findScrollingChild(r5.getChildAt(r0));
        if (r2 != null) goto L11;
        r0 = r0 + 1;
        goto L8
    L11:
        return r2;
    L17:
        return null;
    L13:
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents == true) goto L11;
        int r0 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets == false) goto L8;
        int r2 = 0;
    L10:
        return Math.max(r0, r2);
    L8:
        r2 = this.insetTop;
        goto L10
    L11:
        return this.fitToContentsOffset;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLastStableState() {
        return this.lastStableState;
    }

    MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxHeight() {
        return this.maxHeight;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto == false) goto L6;
        return -1;
    L6:
        return this.peekHeight;
    }

    @VisibleForTesting
    int getPeekHeightMin() {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isNestedScrollingCheckEnabled() {
        return true;
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
        setWindowInsetsListener(r8);
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
        this.parentHeight = r7.getHeight();
        int r10 = r8.getHeight();
        this.childHeight = r10;
        int r11 = this.parentHeight;
        int r12 = r11 - r10;
        int r13 = this.insetTop;
        if (r12 < r13) goto L37;
    L40:
        this.fitToContentsOffset = Math.max(0, r11 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int r14 = this.state;
        if (r14 != 3) goto L45;
        int r15 = getExpandedOffset();
    L43:
        ViewCompat.offsetTopAndBottom(r8, r15);
    L59:
        this.nestedScrollingChildRef = new WeakReference(findScrollingChild(r8));
        return true;
    L45:
        if (r14 != 6) goto L48;
        r15 = this.halfExpandedOffset;
        goto L43
    L48:
        if (this.hideable == false) goto L53;
        if (r14 != 5) goto L53;
        r15 = this.parentHeight;
    L53:
        if (r14 != 4) goto L55;
        r15 = this.collapsedOffset;
        goto L43
    L55:
        if (r14 != 1) goto L57;
    L58:
        ViewCompat.offsetTopAndBottom(r8, r6 - r8.getTop());
        goto L59
    L57:
        if (r14 != 2) goto L59;
    L37:
        if (this.paddingTopSystemWindowInsets == false) goto L39;
        this.childHeight = r11;
        goto L40
    L39:
        this.childHeight = r11 - r13;
        goto L40
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout r4, @NonNull V r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        r5.measure(getChildMeasureSpec(r6, (((r4.getPaddingLeft() + r4.getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r7, this.maxWidth, r0.width), getChildMeasureSpec(r8, (((r4.getPaddingTop() + r4.getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r9, this.maxHeight, r0.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout r4, @NonNull V r5, @NonNull View r6, float r7, float r8) {
        if (isNestedScrollingCheckEnabled() == false) goto L14;
        WeakReference<View> r0 = this.nestedScrollingChildRef;
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r6 == r0.get()) goto L9;
        return false;
    L9:
        if (this.state == 3) goto L11;
    L12:
        return true;
    L11:
        if (super.onNestedPreFling(r4, r5, r6, r7, r8) == true) goto L12;
        return false;
    L14:
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
    L10:
        if (isNestedScrollingCheckEnabled() == false) goto L13;
        if (r4 == r10) goto L13;
        return;
    L13:
        int r11 = r3.getTop();
        int r12 = r11 - r6;
        if (r6 > 0) goto L16;
        if (r6 < 0) goto L26;
    L37:
        dispatchOnSlide(r3.getTop());
        this.lastNestedScrollDy = r6;
        this.nestedScrolled = true;
        return;
    L26:
        if (r4.canScrollVertically(-1) == true) goto L37;
        int r13 = this.collapsedOffset;
        if (r12 <= r13) goto L34;
        if (this.hideable == true) goto L34;
        r7[1] = r11 - r13;
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        int r14 = 4;
    L18:
        setStateInternal(r14);
    L34:
        if (this.draggable == true) goto L36;
        return;
    L36:
        r7[1] = r6;
    L23:
        ViewCompat.offsetTopAndBottom(r3, -r6);
        setStateInternal(1);
        goto L37
    L16:
        if (r12 >= getExpandedOffset()) goto L20;
        r7[1] = r11 - getExpandedOffset();
        ViewCompat.offsetTopAndBottom(r3, -r7[1]);
        r14 = 3;
        goto L18
    L20:
        if (this.draggable == true) goto L22;
        return;
    L22:
        r7[1] = r6;
        goto L23
    L8:
        r10 = null;
        goto L10
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
    L6:
        r6 = 4;
    L7:
        this.state = r6;
        this.lastStableState = r6;
        return;
    L5:
        if (r6 != 2) goto L7;
        goto L6
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
        if (r4.getTop() != getExpandedOffset()) goto L7;
        setStateInternal(3);
        return;
    L7:
        if (isNestedScrollingCheckEnabled() == false) goto L16;
        WeakReference<View> r7 = this.nestedScrollingChildRef;
        if (r7 != null) goto L11;
        return;
    L11:
        if (r5 == r7.get()) goto L13;
        return;
    L13:
        if (this.nestedScrolled == true) goto L16;
        return;
    L16:
        if (this.lastNestedScrollDy <= 0) goto L25;
        if (this.fitToContents == false) goto L20;
    L19:
        int r8 = this.fitToContentsOffset;
    L53:
        startSettlingAnimation(r4, r0, r8, false);
        this.nestedScrolled = false;
        return;
    L20:
        int r9 = r4.getTop();
        int r10 = this.halfExpandedOffset;
        if (r9 <= r10) goto L23;
        r0 = 6;
        r8 = r10;
    L23:
        r8 = getExpandedOffset();
        goto L53
    L25:
        if (this.hideable == false) goto L30;
        if (shouldHide(r4, getYVelocity()) == false) goto L30;
        r8 = this.parentHeight;
        r0 = 5;
    L30:
        if (this.lastNestedScrollDy != 0) goto L48;
        int r11 = r4.getTop();
        if (this.fitToContents == true) goto L34;
        int r1 = this.halfExpandedOffset;
        if (r11 >= r1) goto L45;
        if (r11 < Math.abs(r11 - this.collapsedOffset)) goto L23;
        if (shouldSkipHalfExpandedStateWhenDragging() == true) goto L49;
    L52:
        r8 = this.halfExpandedOffset;
        r0 = 6;
    L49:
        r8 = this.collapsedOffset;
        r0 = 4;
        goto L53
    L45:
        if (Math.abs(r11 - r1) >= Math.abs(r11 - this.collapsedOffset)) goto L49;
    L34:
        if (Math.abs(r11 - this.fitToContentsOffset) >= Math.abs(r11 - this.collapsedOffset)) goto L49;
    L48:
        if (this.fitToContents == true) goto L49;
        int r12 = r4.getTop();
        if (Math.abs(r12 - this.halfExpandedOffset) >= Math.abs(r12 - this.collapsedOffset)) goto L49;
        goto L49
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout r3, @NonNull V r4, @NonNull MotionEvent r5) {
        if (r4.isShown() == true) goto L6;
        return false;
    L6:
        int r6 = r5.getActionMasked();
        if (this.state != 1) goto L11;
        if (r6 != 0) goto L11;
        return true;
    L11:
        if (shouldHandleDraggingWithHelper() == false) goto L13;
        this.viewDragHelper.processTouchEvent(r5);
    L13:
        if (r6 != 0) goto L16;
        reset();
    L16:
        if (this.velocityTracker != null) goto L18;
        this.velocityTracker = VelocityTracker.obtain();
    L18:
        this.velocityTracker.addMovement(r5);
        if (shouldHandleDraggingWithHelper() == false) goto L28;
        if (r6 != 2) goto L28;
        if (this.ignoreEvents == true) goto L28;
        if (Math.abs(this.initialY - r5.getY()) <= this.viewDragHelper.getTouchSlop()) goto L28;
        this.viewDragHelper.captureChildView(r4, r5.getPointerId(r5.getActionIndex()));
    L28:
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

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float r2) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHideableInternal(boolean r1) {
        this.hideable = r1;
    }

    public void setMaxHeight(@Px int r1) {
        this.maxHeight = r1;
    }

    public void setMaxWidth(@Px int r1) {
        this.maxWidth = r1;
    }

    public void setPeekHeight(int r2) {
        setPeekHeight(r2, false);
    }

    public final void setPeekHeight(int r4, boolean r5) {
        boolean r0 = true;
        if (r4 != (-1)) goto L8;
        if (this.peekHeightAuto == true) goto L12;
        this.peekHeightAuto = true;
    L14:
        if (r0 == false) goto L17;
        updatePeekHeight(r5);
        return;
    L17:
        return;
    L12:
        r0 = false;
        goto L14
    L8:
        if (this.peekHeightAuto == false) goto L10;
    L13:
        this.peekHeightAuto = false;
        this.peekHeight = Math.max(0, r4);
        goto L14
    L10:
        if (this.peekHeight == r4) goto L12;
        goto L12
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
        this.lastStableState = r2;
        return;
    L10:
        if (r2 == 3) goto L17;
        if (r2 == 6) goto L17;
        if (this.hideable == true) goto L16;
        return;
    L16:
        if (r2 == 5) goto L17;
    }

    void setStateInternal(int r7) {
        if (this.state != r7) goto L5;
        return;
    L5:
        this.state = r7;
        if (r7 == 4) goto L12;
        if (r7 == 3) goto L12;
        if (r7 == 6) goto L12;
        if (this.hideable == false) goto L13;
        if (r7 == 5) goto L12;
    L13:
        WeakReference<V> r4 = this.viewRef;
        if (r4 != null) goto L16;
        return;
    L16:
        V r5 = r4.get();
        if (r5 != null) goto L19;
        return;
    L19:
        int r6 = 0;
        if (r7 != 3) goto L22;
        updateImportantForAccessibility(true);
    L26:
        updateDrawableForTargetState(r7);
    L28:
        if (r6 >= this.callbacks.size()) goto L30;
        this.callbacks.get(r6).onStateChanged(r5, r7);
        r6 = r6 + 1;
        goto L28
    L30:
        updateAccessibilityActions();
        return;
    L22:
        if (r7 == 6) goto L25;
        if (r7 == 5) goto L25;
        if (r7 != 4) goto L26;
    L25:
        updateImportantForAccessibility(false);
    L12:
        this.lastStableState = r7;
        goto L13
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean r1) {
        this.updateImportantForAccessibilityOnSiblings = r1;
    }

    void settleToState(@NonNull View r4, int r5) {
        if (r5 != 4) goto L6;
        int r0 = this.collapsedOffset;
    L20:
        startSettlingAnimation(r4, r5, r0, false);
        return;
    L6:
        if (r5 != 6) goto L13;
        int r1 = this.halfExpandedOffset;
        if (this.fitToContents == false) goto L12;
        int r2 = this.fitToContentsOffset;
        if (r1 > r2) goto L12;
        r5 = 3;
        r0 = r2;
    L12:
        r0 = r1;
        goto L20
    L13:
        if (r5 != 3) goto L16;
        r0 = getExpandedOffset();
        goto L20
    L16:
        if (this.hideable == true) goto L18;
    L22:
        Log.w(TAG, "The bottom sheet may be in an invalid state. Ensure `hideable` is true when using `STATE_HIDDEN`.");
        return;
    L18:
        if (r5 != 5) goto L22;
        r0 = this.parentHeight;
        goto L20
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldExpandOnUpwardDrag(long r1, @FloatRange(from = 0.0d, to = 100.0d) float r3) {
        return false;
    }

    boolean shouldHide(@NonNull View r5, float r6) {
        if (this.skipCollapsed == false) goto L6;
        return true;
    L6:
        if (r5.getTop() >= this.collapsedOffset) goto L9;
        return false;
    L9:
        if ((Math.abs((r5.getTop() + (r6 * 0.1f)) - this.collapsedOffset) / calculatePeekHeight()) <= 0.5f) goto L12;
        return true;
    L12:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    void startSettlingAnimation(View r3, int r4, int r5, boolean r6) {
        ViewDragHelper r0 = this.viewDragHelper;
        if (r0 == null) goto L11;
        if (r6 == false) goto L9;
        if (r0.settleCapturedViewAt(r3.getLeft(), r5) == false) goto L11;
    L10:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L20;
        setStateInternal(2);
        updateDrawableForTargetState(r4);
        if (this.settleRunnable != null) goto L17;
        this.settleRunnable = new SettleRunnable(this, r3, r4);
    L17:
        if (SettleRunnable.access$800(this.settleRunnable) == true) goto L19;
        BottomSheetBehavior<V>.SettleRunnable r8 = this.settleRunnable;
        r8.targetState = r4;
        ViewCompat.postOnAnimation(r3, r8);
        SettleRunnable.access$802(this.settleRunnable, true);
        return;
    L19:
        this.settleRunnable.targetState = r4;
        return;
    L20:
        setStateInternal(r4);
        return;
    L9:
        if (r0.smoothSlideViewTo(r3, r3.getLeft(), r5) == true) goto L10;
    L11:
        r7 = false;
        goto L12
    }
}
