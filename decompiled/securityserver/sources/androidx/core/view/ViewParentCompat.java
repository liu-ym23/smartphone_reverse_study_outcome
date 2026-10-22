package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] r0 = sTempNestedScrollConsumed;
        if (r0 != null) goto L5;
        sTempNestedScrollConsumed = new int[2];
    L7:
        return sTempNestedScrollConsumed;
    L5:
        r0[0] = 0;
        r0[1] = 0;
        goto L7
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent r0, View r1, View r2, int r3) {
        r0.notifySubtreeAccessibilityStateChanged(r1, r2, r3);
    }

    public static boolean onNestedFling(ViewParent r0, View r1, float r2, float r3, boolean r4) {
        return r0.onNestedFling(r1, r2, r3, r4);
    L4:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r0 + " does not implement interface method onNestedFling", e);
        return false;
    }

    public static boolean onNestedPreFling(ViewParent r0, View r1, float r2, float r3) {
        return r0.onNestedPreFling(r1, r2, r3);
    L4:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r0 + " does not implement interface method onNestedPreFling", e);
        return false;
    }

    public static void onNestedPreScroll(ViewParent r6, View r7, int r8, int r9, int[] r10) {
        onNestedPreScroll(r6, r7, r8, r9, r10, 0);
    }

    public static void onNestedScroll(ViewParent r8, View r9, int r10, int r11, int r12, int r13) {
        onNestedScroll(r8, r9, r10, r11, r12, r13, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(ViewParent r1, View r2, View r3, int r4) {
        onNestedScrollAccepted(r1, r2, r3, r4, 0);
    }

    public static boolean onStartNestedScroll(ViewParent r1, View r2, View r3, int r4) {
        return onStartNestedScroll(r1, r2, r3, r4, 0);
    }

    public static void onStopNestedScroll(ViewParent r1, View r2) {
        onStopNestedScroll(r1, r2, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent r0, View r1, AccessibilityEvent r2) {
        return r0.requestSendAccessibilityEvent(r1, r2);
    }

    public static void onNestedPreScroll(ViewParent r7, View r8, int r9, int r10, int[] r11, int r12) {
        if ((r7 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r7).onNestedPreScroll(r8, r9, r10, r11, r12);
        return;
    L5:
        if (r12 != 0) goto L14;
        r7.onNestedPreScroll(r8, r9, r10, r11);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r7 + " does not implement interface method onNestedPreScroll", e);
        return;
    }

    public static void onNestedScrollAccepted(ViewParent r1, View r2, View r3, int r4, int r5) {
        if ((r1 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r1).onNestedScrollAccepted(r2, r3, r4, r5);
        return;
    L5:
        if (r5 != 0) goto L14;
        r1.onNestedScrollAccepted(r2, r3, r4);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r1 + " does not implement interface method onNestedScrollAccepted", e);
        return;
    }

    public static boolean onStartNestedScroll(ViewParent r1, View r2, View r3, int r4, int r5) {
        if ((r1 instanceof NestedScrollingParent2) == true) goto L5;
        if (r5 != 0) goto L15;
        return r1.onStartNestedScroll(r2, r3, r4);
    L9:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r1 + " does not implement interface method onStartNestedScroll", e);
        return false;
    L15:
        return false;
    L5:
        return ((NestedScrollingParent2) r1).onStartNestedScroll(r2, r3, r4, r5);
    }

    public static void onStopNestedScroll(ViewParent r1, View r2, int r3) {
        if ((r1 instanceof NestedScrollingParent2) == false) goto L5;
        ((NestedScrollingParent2) r1).onStopNestedScroll(r2, r3);
        return;
    L5:
        if (r3 != 0) goto L14;
        r1.onStopNestedScroll(r2);     // Catch: AbstractMethodError -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r1 + " does not implement interface method onStopNestedScroll", e);
        return;
    }

    public static void onNestedScroll(ViewParent r8, View r9, int r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r8, r9, r10, r11, r12, r13, r14, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent r10, View r11, int r12, int r13, int r14, int r15, int r16, @NonNull int[] r17) {
        if ((r10 instanceof NestedScrollingParent3) == false) goto L5;
        ((NestedScrollingParent3) r10).onNestedScroll(r11, r12, r13, r14, r15, r16, r17);
        return;
    L5:
        r17[0] = r17[0] + r14;
        r17[1] = r17[1] + r15;
        if ((r10 instanceof NestedScrollingParent2) == false) goto L8;
        ((NestedScrollingParent2) r10).onNestedScroll(r11, r12, r13, r14, r15, r16);
        return;
    L8:
        if (r16 != 0) goto L18;
        r10.onNestedScroll(r11, r12, r13, r14, r15);     // Catch: AbstractMethodError -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "ViewParent " + r10 + " does not implement interface method onNestedScroll", e);
        return;
    }
}
