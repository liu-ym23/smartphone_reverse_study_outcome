package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance;
    float alphaStartSwipeDistance;
    private final ViewDragHelper.Callback dragCallback;
    float dragDismissThreshold;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity;
    private boolean sensitivitySet;
    int swipeDirection;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View r1);

        void onDragStateChanged(int r1);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        final /* synthetic */ SwipeDismissBehavior this$0;
        private final View view;

        public SettleRunnable(SwipeDismissBehavior r1, View r2, boolean r3) {
            this.this$0 = r1;
            this.view = r2;
            this.dismiss = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper r0 = this.this$0.viewDragHelper;
            if (r0 == null) goto L8;
            if (r0.continueSettling(true) == false) goto L8;
            ViewCompat.postOnAnimation(this.view, this);
            return;
        L8:
            if (this.dismiss == false) goto L14;
            OnDismissListener r1 = this.this$0.listener;
            if (r1 == null) goto L15;
            r1.onDismiss(this.view);
            return;
        L15:
            return;
        }
    }

    public SwipeDismissBehavior() {
        this.sensitivity = 0.0f;
        this.swipeDirection = 2;
        this.dragDismissThreshold = 0.5f;
        this.alphaStartSwipeDistance = 0.0f;
        this.alphaEndSwipeDistance = 0.5f;
        this.dragCallback = new AnonymousClass1(this);
    }

    public static float clamp(float r0, float r1, float r2) {
        return Math.min(Math.max(r0, r1), r2);
    }

    private void ensureViewDragHelper(ViewGroup r3) {
        if (this.viewDragHelper == null) goto L5;
        return;
    L5:
        if (this.sensitivitySet == false) goto L7;
        ViewDragHelper r4 = ViewDragHelper.create(r3, this.sensitivity, this.dragCallback);
    L8:
        this.viewDragHelper = r4;
        return;
    L7:
        r4 = ViewDragHelper.create(r3, this.dragCallback);
        goto L8
    }

    public static float fraction(float r0, float r1, float r2) {
        return (r2 - r0) / (r1 - r0);
    }

    private void updateAccessibilityActions(View r3) {
        ViewCompat.removeAccessibilityAction(r3, 1048576);
        if (canSwipeDismissView(r3) == false) goto L6;
        ViewCompat.replaceAccessibilityAction(r3, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AnonymousClass2(this));
        return;
    }

    public boolean canSwipeDismissView(@NonNull View r1) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper r0 = this.viewDragHelper;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getViewDragState();
    }

    @Nullable
    @VisibleForTesting
    public OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r4, @NonNull V r5, @NonNull MotionEvent r6) {
        boolean r0 = this.interceptingEvents;
        int r1 = r6.getActionMasked();
        if (r1 != 0) goto L5;
        r0 = r4.isPointInChildBounds(r5, (int) r6.getX(), (int) r6.getY());
        this.interceptingEvents = r0;
    L11:
        if (r0 == false) goto L14;
        ensureViewDragHelper(r4);
        return this.viewDragHelper.shouldInterceptTouchEvent(r6);
    L14:
        return false;
    L5:
        if (r1 != 1) goto L7;
    L9:
        this.interceptingEvents = false;
        goto L11
    L7:
        if (r1 == 3) goto L9;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r1, @NonNull V r2, int r3) {
        boolean r4 = super.onLayoutChild(r1, r2, r3);
        if (ViewCompat.getImportantForAccessibility(r2) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(r2, 1);
        updateAccessibilityActions(r2);
    L5:
        return r4;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout r1, V r2, MotionEvent r3) {
        ViewDragHelper r0 = this.viewDragHelper;
        if (r0 == null) goto L6;
        r0.processTouchEvent(r3);
        return true;
    L6:
        return false;
    }

    public void setDragDismissDistance(float r3) {
        this.dragDismissThreshold = clamp(0.0f, r3, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float r3) {
        this.alphaEndSwipeDistance = clamp(0.0f, r3, 1.0f);
    }

    public void setListener(@Nullable OnDismissListener r1) {
        this.listener = r1;
    }

    public void setSensitivity(float r1) {
        this.sensitivity = r1;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float r3) {
        this.alphaStartSwipeDistance = clamp(0.0f, r3, 1.0f);
    }

    public void setSwipeDirection(int r1) {
        this.swipeDirection = r1;
    }

    public static int clamp(int r0, int r1, int r2) {
        return Math.min(Math.max(r0, r1), r2);
    }
}
