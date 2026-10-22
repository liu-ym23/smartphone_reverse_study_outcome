package com.obric.oui.popover.v2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.popover.FakeAnchorView;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OPopoverHelperEx.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002JR\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0007JF\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006J>\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006J<\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007J<\u0010\u001d\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007J>\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006JL\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002JT\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverHelperEx;", "", "()V", "TAG", "", "resolvePreferredGravity", "", "adaptedGravity", "rotationDegrees", "resolveWindowBounds", "Landroid/graphics/Rect;", "anchor", "Landroid/view/View;", "rotateGravityClockwise", "gravity", "rotateGravityCounterClockwise", "showPopoverSmartly", "", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "coverAnchor", "", "margin", "focusable", "widthMeasureSpec", "heightMeasureSpec", "Lcom/obric/oui/popover/v2/OPopoverModal;", "parent", "Landroid/view/ViewGroup;", "showPopoverSmartlyAtLocation", "activity", "Landroid/app/Activity;", "anchorX", "anchorY", "dialog", "Landroid/app/Dialog;", "showPopoverSmartlyInternal", "showPopoverViewSmartlyInternal", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverHelperEx {
    public static final OPopoverHelperEx INSTANCE = null;
    private static final String TAG = "OPopoverHelperEx1";

    static {
        INSTANCE = new OPopoverHelperEx();
    }

    private final int rotateGravityClockwise(int r4) {
        int r3 = r4 & 112;
        if (r3 != 48) goto L5;
        int r5 = 5;
    L9:
        int r6 = r4 & 7;
        if (r6 == 3) goto L15;
        if (r6 == 5) goto L16;
        return r5;
    L16:
        return r5 | 80;
    L15:
        return r5 | 48;
    L5:
        if (r3 == 80) goto L7;
        r5 = 0;
        goto L9
    L7:
        r5 = 3;
        goto L9
    }

    private final int rotateGravityCounterClockwise(int r4) {
        int r3 = r4 & 112;
        if (r3 != 48) goto L5;
        int r5 = 3;
    L9:
        int r6 = r4 & 7;
        if (r6 == 3) goto L15;
        if (r6 == 5) goto L16;
        return r5;
    L16:
        return r5 | 48;
    L15:
        return r5 | 80;
    L5:
        if (r3 == 80) goto L7;
        r5 = 0;
        goto L9
    L7:
        r5 = 5;
        goto L9
    }

    public final void showPopoverSmartly(OPopover r13, View r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, false, 0, false, 0, 0, 248, null);
    }

    public final void showPopoverSmartly(OPopover r13, View r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, 0, false, 0, 0, 240, null);
    }

    public final void showPopoverSmartly(OPopover r13, View r14, int r15, boolean r16, int r17) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, false, 0, 0, 224, null);
    }

    public final void showPopoverSmartly(OPopover r13, View r14, int r15, boolean r16, int r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, r18, 0, 0, 192, null);
    }

    public final void showPopoverSmartly(OPopover r13, View r14, int r15, boolean r16, int r17, boolean r18, int r19) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, r18, r19, 0, 128, null);
    }

    public final void showPopoverSmartlyAtLocation(Activity r11, OPopover r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "popover");
        showPopoverSmartlyAtLocation$default(this, r11, r12, r13, r14, false, 0, 48, null);
    }

    public final void showPopoverSmartlyAtLocation(Activity r11, OPopover r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, "popover");
        showPopoverSmartlyAtLocation$default(this, r11, r12, r13, r14, r15, 0, 32, null);
    }

    public final void showPopoverSmartlyAtLocation(Dialog r11, OPopover r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "dialog");
        Intrinsics.checkNotNullParameter(r12, "popover");
        showPopoverSmartlyAtLocation$default(this, r11, r12, r13, r14, false, 0, 48, null);
    }

    public final void showPopoverSmartlyAtLocation(Dialog r11, OPopover r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "dialog");
        Intrinsics.checkNotNullParameter(r12, "popover");
        showPopoverSmartlyAtLocation$default(this, r11, r12, r13, r14, r15, 0, 32, null);
    }

    private OPopoverHelperEx() {
    }

    public static /* synthetic */ void showPopoverSmartlyAtLocation$default(OPopoverHelperEx r7, Activity r8, OPopover r9, int r10, int r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = false;
    L5:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = 80;
    L8:
        r7.showPopoverSmartlyAtLocation(r8, r9, r10, r11, r5, r13);
    }

    public final void showPopoverSmartlyAtLocation(Activity r13, OPopover r14, int r15, int r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "popover");
        showPopoverSmartly$default(this, r14, FakeAnchorView.Companion.addInvisibleViewAtPosition(r13, r15, r16, 2, 2), r18, r17, 0, false, 0, 0, 240, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e(TAG, "showPopoverSmartlyAtLocation failed", e);
    }

    public static /* synthetic */ void showPopoverSmartlyAtLocation$default(OPopoverHelperEx r7, Dialog r8, OPopover r9, int r10, int r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = false;
    L5:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = 80;
    L8:
        r7.showPopoverSmartlyAtLocation(r8, r9, r10, r11, r5, r13);
    }

    public final void showPopoverSmartlyAtLocation(Dialog r13, OPopover r14, int r15, int r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r13, "dialog");
        Intrinsics.checkNotNullParameter(r14, "popover");
        View r3 = FakeAnchorView.Companion.addInvisibleViewAtPosition(r13, r15, r16, 2, 2);     // Catch: Exception -> L5
        r14.setIsShowInDialog(true);     // Catch: Exception -> L5
        showPopoverSmartly$default(this, r14, r3, r18, r17, 0, false, 0, 0, 240, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e(TAG, "showPopoverSmartlyAtLocation failed", e);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelperEx r12, OPopover r13, View r14, int r15, boolean r16, int r17, boolean r18, int r19, int r20, int r21, Object r22) {
        if ((r21 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r21 & 16) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r21 & 32) == 0) goto L13;
        boolean r9 = true;
    L15:
        if ((r21 & 64) == 0) goto L17;
        int r10 = 0;
    L19:
        if ((r21 & 128) == 0) goto L21;
        int r11 = 0;
    L22:
        r12.showPopoverSmartly(r13, r14, r15, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public final void showPopoverSmartly(OPopover r2, View r3, int r4, boolean r5, int r6, boolean r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "popover");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        showPopoverSmartlyInternal(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void showPopoverSmartlyAtLocation$default(OPopoverHelperEx r7, OPopoverModal r8, int r9, int r10, ViewGroup r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        ViewGroup r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = false;
    L8:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        r13 = 80;
    L11:
        r7.showPopoverSmartlyAtLocation(r8, r9, r10, r4, r5, r13);
    }

    public final void showPopoverSmartlyAtLocation(OPopoverModal r13, int r14, int r15, ViewGroup r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        ViewGroup r7 = r13.resolveHostParent$OUI_standardRelease(r16);     // Catch: Exception -> L8
        if (r7 != null) goto L6;
        return;
    L6:
        showPopoverSmartly$default(this, r13, FakeAnchorView.Companion.addInvisibleViewAtPosition(r7, r14, r15, 2, 2), r18, r7, r17, 0, 0, 96, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        L.e(TAG, "showPopoverSmartlyAtLocation for OPopoverView failed", e);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelperEx r7, OPopoverModal r8, View r9, int r10, ViewGroup r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = null;
    L5:
        ViewGroup r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        int r5 = 0;
    L10:
        if ((r14 & 32) == 0) goto L12;
        int r6 = 0;
    L13:
        r7.showPopoverSmartly(r8, r9, r10, r4, r5, r6);
        return;
    L12:
        r6 = r13;
        goto L13
    L8:
        r5 = r12;
        goto L10
    }

    public final void showPopoverSmartly(OPopoverModal r11, View r12, int r13, ViewGroup r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        showPopoverViewSmartlyInternal(r11, r12, r13, r14, true, 0, r15, r16);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelperEx r9, OPopoverModal r10, View r11, int r12, ViewGroup r13, boolean r14, int r15, int r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        ViewGroup r5 = null;
    L7:
        if ((r17 & 32) == 0) goto L9;
        int r7 = 0;
    L11:
        if ((r17 & 64) == 0) goto L13;
        int r8 = 0;
    L14:
        r9.showPopoverSmartly(r10, r11, r12, r5, r14, r7, r8);
        return;
    L13:
        r8 = r16;
        goto L14
    L9:
        r7 = r15;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final void showPopoverSmartly(OPopoverModal r11, View r12, int r13, ViewGroup r14, boolean r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        showPopoverViewSmartlyInternal(r11, r12, r13, r14, r15, 0, r16, r17);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelperEx r11, OPopoverModal r12, View r13, int r14, ViewGroup r15, boolean r16, int r17, int r18, int r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        ViewGroup r6 = null;
    L7:
        if ((r20 & 64) == 0) goto L9;
        int r9 = 0;
    L11:
        if ((r20 & 128) == 0) goto L13;
        int r10 = 0;
    L14:
        r11.showPopoverSmartly(r12, r13, r14, r6, r16, r17, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final void showPopoverSmartly(OPopoverModal r2, View r3, int r4, ViewGroup r5, boolean r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "popover");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        showPopoverViewSmartlyInternal(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    static /* synthetic */ void showPopoverSmartlyInternal$default(OPopoverHelperEx r10, OPopover r11, View r12, int r13, boolean r14, int r15, boolean r16, int r17, int r18, int r19, Object r20) {
        if ((r19 & 8) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r19 & 16) == 0) goto L9;
        int r6 = 0;
    L10:
        r10.showPopoverSmartlyInternal(r11, r12, r13, r5, r6, r16, r17, r18);
        return;
    L9:
        r6 = r15;
        goto L10
    L5:
        r5 = r14;
        goto L7
    }

    private final void showPopoverSmartlyInternal(OPopover r21, View r22, int r23, boolean r24, int r25, boolean r26, int r27, int r28) {
        if ((r23 & 112) != 0) goto L5;
        int r3 = r23 | 80;
    L68:
        Rect r4 = resolveWindowBounds(r22);     // Catch: Exception -> L65
        int[] r6 = new int[2];     // Catch: Exception -> L65
        r22.getLocationOnScreen(r6);     // Catch: Exception -> L65
        int r8 = r6[0] - r4.left;     // Catch: Exception -> L65
        int r7 = r6[1] - r4.top;     // Catch: Exception -> L65
        int r10 = r22.getMeasuredWidth() + r8;     // Catch: Exception -> L65
        int r11 = r22.getMeasuredHeight() + r7;     // Catch: Exception -> L65
        int r12 = r4.width();     // Catch: Exception -> L65
        int r13 = r4.height();     // Catch: Exception -> L65
        if (r4.top > 0) goto L9;
        int r5 = OWindowConfigController.getStatusBarHeight(r22.getContext());     // Catch: Exception -> L65
    L10:
        int r14 = OUnitExtensionKt.vdp(r22, 12);     // Catch: Exception -> L65
        if (r22.getRootWindowInsets() == null) goto L15;
        Insets r9 = r22.getRootWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());     // Catch: Exception -> L65
        Intrinsics.checkNotNullExpressionValue(r9, "anchor.rootWindowInsets.…Insets.Type.systemBars())");     // Catch: Exception -> L65
        if (r9.bottom <= 0) goto L15;
        r14 = r9.bottom;     // Catch: Exception -> L65
    L15:
        int r15 = OUnitExtensionKt.vdp(r22, 8);     // Catch: Exception -> L65
        int r16 = OUnitExtensionKt.vdp(r22, 4);     // Catch: Exception -> L65
        r21.setMaxContentHeight(RangesKt.coerceAtLeast((r13 - r5) - r14, 0));     // Catch: Exception -> L65
        r21.getContentView().measure(r27, r28);     // Catch: Exception -> L65
        int r2 = r21.getContentView().getMeasuredWidth();     // Catch: Exception -> L65
        int r17 = r21.getContentView().getMeasuredHeight();     // Catch: Exception -> L65
        int r0 = resolvePreferredGravity(r3, ((r21.getDisplayRotationDegrees$OUI_standardRelease() % 360) + 360) % 360);     // Catch: Exception -> L65
        int r18 = r0 & 112;     // Catch: Exception -> L65
        int r1 = r0 & 7;     // Catch: Exception -> L65
        int r19 = r3;
        if (r18 == 48) goto L18;
    L20:
        if (r18 != 80) goto L28;
        if (r24 == false) goto L23;
        int r110 = ((r11 + r17) - r22.getMeasuredHeight()) - r16;     // Catch: Exception -> L65
    L25:
        if (r110 <= (r13 - r14)) goto L28;
        r18 = 48;
        goto L28
    L23:
        r110 = (r11 + r17) + r25;     // Catch: Exception -> L65
    L28:
        if (r1 != 3) goto L30;
        int r20 = r10 - r2;     // Catch: Exception -> L65
    L34:
        int r111 = r12 - r2;     // Catch: Exception -> L65
        int r29 = r111 - r15;     // Catch: Exception -> L65
        if (r29 < r15) goto L37;
        int r30 = RangesKt.coerceIn(r20, r15, r29);     // Catch: Exception -> L65
    L38:
        if (r24 == false) goto L43;
        int r31 = Math.max(r15, (r10 + r16) - r2);     // Catch: Exception -> L65
        int r32 = Math.min(r29, r8 - r16);     // Catch: Exception -> L65
        if (r32 < r31) goto L43;
        r30 = RangesKt.coerceIn(r30, r31, r32);     // Catch: Exception -> L65
    L43:
        if (r18 != 48) goto L45;
        int r33 = (r7 - r17) - r25;     // Catch: Exception -> L65
    L46:
        int r112 = (r13 - r17) - r14;     // Catch: Exception -> L65
        if (r112 < r5) goto L49;
        int r34 = RangesKt.coerceIn(r33, r5, r112);     // Catch: Exception -> L65
    L50:
        if (r24 == false) goto L59;
        int r35 = r22.getMeasuredHeight();     // Catch: Exception -> L65
        if (r18 != 80) goto L54;
        int r113 = (r11 - r35) - r16;     // Catch: Exception -> L65
    L55:
        if (r112 < r5) goto L57;
        r5 = RangesKt.coerceIn(r113, r5, r112);     // Catch: Exception -> L65
    L57:
        r34 = r5;
        goto L59
    L54:
        r113 = (r11 - r17) + r16;     // Catch: Exception -> L65
    L59:
        r21.setGravity(r19);     // Catch: Exception -> L65
        if (r26 == true) goto L62;
        int r36 = 0;
        r21.setFocusable(false);     // Catch: Exception -> L65
    L63:
        r21.setGetLocationInWindow(true);     // Catch: Exception -> L65
        r21.showAtLocation(r22, r36, r30, r34);     // Catch: Exception -> L65
        return;
    L62:
        r36 = 0;
        goto L63
    L49:
        r34 = r5;
        goto L50
    L45:
        r33 = r11 + r25;     // Catch: Exception -> L65
        goto L46
    L37:
        r30 = RangesKt.coerceIn(r20, 0, Math.max(0, r111));     // Catch: Exception -> L65
        goto L38
    L30:
        if (r1 == 5) goto L32;
        r20 = ((r22.getMeasuredWidth() - r2) / 2) + r8;     // Catch: Exception -> L65
        goto L34
    L32:
        r20 = r8;
        goto L34
    L18:
        if (((r7 - r17) - r25) >= 0) goto L20;
        r18 = 80;
        goto L28
    L9:
        r5 = 0;
    L65:
        e = move-exception;
        L.e(TAG, "showPopoverSmartly failed", e);
        return;
    L5:
        r3 = r23;
        goto L68
    }

    private final Rect resolveWindowBounds(View r9) {
        View r8 = r9.getRootView();
        OWindowConfigController r0 = OWindowConfigController.INSTANCE;
        Context r1 = r9.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        Activity r2 = r0.getActivity(r1);
        int[] r3 = new int[2];
        if (r2 == null) goto L5;
        r8 = r2.getWindow().getDecorView();
    L5:
        if (r8 == null) goto L8;
        r8.getLocationOnScreen(r3);
    L8:
        boolean r4 = false;
        int r5 = r3[0];
        int r6 = r3[1];
        Integer r7 = null;
        if (r2 != null) goto L11;
    L10:
        Integer r10 = null;
    L18:
        if (r10 != null) goto L28;
        if (r8 != null) goto L21;
    L20:
        r10 = null;
    L26:
        if (r10 != null) goto L28;
        int r11 = r9.getResources().getDisplayMetrics().widthPixels;
    L29:
        if (r2 != null) goto L31;
    L30:
        Integer r12 = null;
    L38:
        if (r12 != null) goto L49;
        if (r8 == null) goto L46;
        Integer r13 = Integer.valueOf(r8.getHeight());
        if (r13.intValue() <= 0) goto L44;
        r4 = true;
    L44:
        if (r4 == false) goto L46;
        r7 = r13;
    L46:
        if (r7 != null) goto L48;
        int r14 = r9.getResources().getDisplayMetrics().heightPixels;
    L51:
        return new Rect(r5, r6, r11 + r5, r14 + r6);
    L48:
        r14 = r7.intValue();
        goto L51
    L49:
        r14 = r12.intValue();
        goto L51
    L31:
        Window r15 = r2.getWindow();
        if (r15 == null) goto L30;
        View r16 = r15.getDecorView();
        if (r16 == null) goto L30;
        r12 = Integer.valueOf(r16.getHeight());
        goto L38
    L21:
        r10 = Integer.valueOf(r8.getWidth());
        if (r10.intValue() <= 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L20;
    L24:
        r17 = false;
    L28:
        r11 = r10.intValue();
        goto L29
    L11:
        Window r18 = r2.getWindow();
        if (r18 == null) goto L10;
        View r19 = r18.getDecorView();
        if (r19 == null) goto L10;
        r10 = Integer.valueOf(r19.getWidth());
        goto L18
    }

    private final int resolvePreferredGravity(int r3, int r4) {
        Integer r0 = Integer.valueOf(r3 & 112);
        if (r0.intValue() == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        int r2 = 80;
    L12:
        int r5 = (r3 & 7) | r2;
        if (r4 == 90) goto L19;
        if (r4 == 270) goto L20;
        return r5;
    L20:
        return rotateGravityCounterClockwise(r5);
    L19:
        return rotateGravityClockwise(r5);
    L11:
        r2 = r0.intValue();
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    static /* synthetic */ void showPopoverViewSmartlyInternal$default(OPopoverHelperEx r11, OPopoverModal r12, View r13, int r14, ViewGroup r15, boolean r16, int r17, int r18, int r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        ViewGroup r6 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r7 = true;
    L11:
        if ((r20 & 32) == 0) goto L13;
        int r8 = 0;
    L15:
        if ((r20 & 64) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r20 & 128) == 0) goto L21;
        int r10 = 0;
    L22:
        r11.showPopoverViewSmartlyInternal(r12, r13, r14, r6, r7, r8, r9, r10);
        return;
    L21:
        r10 = r19;
        goto L22
    L17:
        r9 = r18;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    private final void showPopoverViewSmartlyInternal(OPopoverModal r22, View r23, int r24, ViewGroup r25, boolean r26, int r27, int r28, int r29) {
        ViewGroup r4 = r22.resolveHostParent$OUI_standardRelease(r25);     // Catch: Exception -> L70
        if (r4 != null) goto L7;
        return;
    L7:
        if ((r24 & 112) != 0) goto L9;
        int r5 = r24 | 80;     // Catch: Exception -> L70
    L10:
        Rect r6 = resolveWindowBounds(r23);     // Catch: Exception -> L70
        int[] r8 = new int[2];     // Catch: Exception -> L70
        r23.getLocationOnScreen(r8);     // Catch: Exception -> L70
        int r10 = r8[0] - r6.left;     // Catch: Exception -> L70
        boolean r11 = true;
        int r9 = r8[1] - r6.top;     // Catch: Exception -> L70
        int r7 = r23.getMeasuredWidth() + r10;     // Catch: Exception -> L70
        int r12 = r23.getMeasuredHeight() + r9;     // Catch: Exception -> L70
        int[] r13 = new int[2];     // Catch: Exception -> L70
        r4.getLocationOnScreen(r13);     // Catch: Exception -> L70
        int r14 = r13[0];     // Catch: Exception -> L70
        int r15 = r13[1];     // Catch: Exception -> L70
        int r16 = r4.getWidth() + r14;     // Catch: Exception -> L70
        int r17 = r15 + r4.getHeight();     // Catch: Exception -> L70
        int r18 = OWindowConfigController.getStatusBarHeight(r23.getContext());     // Catch: Exception -> L70
        if (r25 == null) goto L15;
        r11 = false;
    L15:
        if (r11 == false) goto L17;
        int r19 = OUnitExtensionKt.vdp(r23, 48);     // Catch: Exception -> L70
    L18:
        int r3 = OUnitExtensionKt.vdp(r23, 8);     // Catch: Exception -> L70
        RangesKt.coerceAtLeast((r16 - r14) - (r3 * 2), 0);     // Catch: Exception -> L70
        r22.setMaxContentHeight(RangesKt.coerceAtLeast(((r17 - r15) - r18) - r19, 0));     // Catch: Exception -> L70
        r22.measurePopup(r28, r29);     // Catch: Exception -> L70
        int r20 = r22.getContentView().getMeasuredWidth();     // Catch: Exception -> L70
        int r21 = r22.getContentView().getMeasuredHeight();     // Catch: Exception -> L70
        int r0 = resolvePreferredGravity(r5, ((r22.getDisplayRotationDegrees$OUI_standardRelease() % 360) + 360) % 360);     // Catch: Exception -> L70
        int r30 = r0 & 112;     // Catch: Exception -> L70
        int r1 = r0 & 7;     // Catch: Exception -> L70
        int r2 = OUnitExtensionKt.vdp(r23, 4);     // Catch: Exception -> L70
        if (r30 != 48) goto L24;
        if (((r9 - r21) - r27) >= r15) goto L24;
        int r31 = 80;
    L34:
        if (r1 != 3) goto L36;
        int r32 = r7 - r20;     // Catch: Exception -> L70
    L40:
        int r33 = r14 + r3;     // Catch: Exception -> L70
        int r110 = r16 - r20;     // Catch: Exception -> L70
        int r34 = r110 - r3;     // Catch: Exception -> L70
        if (r34 < r33) goto L43;
        int r35 = RangesKt.coerceIn(r32, r33, r34);     // Catch: Exception -> L70
    L44:
        if (r26 == false) goto L49;
        int r36 = Math.max(r33, (r7 + r2) - r20);     // Catch: Exception -> L70
        int r37 = Math.min(r34, r10 - r2);     // Catch: Exception -> L70
        if (r37 < r36) goto L49;
        r35 = RangesKt.coerceIn(r35, r36, r37);     // Catch: Exception -> L70
    L49:
        if (r31 != 48) goto L51;
        int r38 = (r9 - r21) - r27;     // Catch: Exception -> L70
    L52:
        if (r11 == false) goto L54;
        int r39 = r18;
    L55:
        int r40 = Math.max(r15, r39);     // Catch: Exception -> L70
        int r41 = (r17 - r21) - r19;     // Catch: Exception -> L70
        if (r41 < r40) goto L58;
        int r42 = RangesKt.coerceIn(r38, r40, r41);     // Catch: Exception -> L70
    L59:
        if (r26 == false) goto L67;
        int r43 = r23.getMeasuredHeight();     // Catch: Exception -> L70
        if (r31 != 80) goto L63;
        int r111 = (r12 - r43) - r2;     // Catch: Exception -> L70
    L64:
        if (r41 < r40) goto L68;
        r40 = RangesKt.coerceIn(r111, r40, r41);     // Catch: Exception -> L70
    L68:
        r22.setGravity$OUI_standardRelease(r5);     // Catch: Exception -> L70
        r22.showAtLocation(r23, r4, 0, r35, r40);     // Catch: Exception -> L70
        return;
    L63:
        r111 = (r12 - r21) + r2;     // Catch: Exception -> L70
        goto L64
    L67:
        r40 = r42;
        goto L68
    L58:
        r42 = r40;
        goto L59
    L54:
        r39 = r15;
        goto L55
    L51:
        r38 = r12 + r27;     // Catch: Exception -> L70
        goto L52
    L43:
        r35 = RangesKt.coerceIn(r32, r14, Math.max(r14, r110));     // Catch: Exception -> L70
        goto L44
    L36:
        if (r1 == 5) goto L38;
        r32 = ((r23.getMeasuredWidth() - r20) / 2) + r10;     // Catch: Exception -> L70
        goto L40
    L38:
        r32 = r10;
    L24:
        if (r30 != 80) goto L32;
        if (r26 == false) goto L27;
        int r44 = ((r12 + r21) - r23.getMeasuredHeight()) - r2;     // Catch: Exception -> L70
    L29:
        if (r44 <= (r17 - r19)) goto L32;
        r31 = 48;
        goto L34
    L27:
        r44 = (r12 + r21) + r27;     // Catch: Exception -> L70
    L32:
        r31 = r30;
        goto L34
    L17:
        r19 = OUnitExtensionKt.vdp(r23, 8);     // Catch: Exception -> L70
        goto L18
    L9:
        r5 = r24;
    L70:
        e = move-exception;
        L.e(TAG, "showPopoverSmartly for OPopoverView failed", e);
    }
}
