package com.obric.oui.popover;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OPopoverHelperEx.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use com.obric.oui.popover.v2.OPopoverHelperEx instead")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J`\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002JN\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OPopoverHelperEx;", "", "()V", "DEFAULT_EDGE_SPACE", "", "TAG", "", "showAtLeftOrRight", "", "popover", "Lcom/obric/oui/popover/OPopover;", "gravity", "anchor", "Landroid/view/View;", "anchorX", "offsetXY", "", "xOffset", "hasAdapted", "", "isMiddle", "arrowOffset", "", "yOffset", "anchorY", "showAtTopOrBottom", "showPopoverSmartly", "showPopoverSmartlyAtLocation", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverHelperEx {
    private static final int DEFAULT_EDGE_SPACE = 10;
    public static final OPopoverHelperEx INSTANCE = null;
    private static final String TAG = "OPopoverHelperEx";

    static {
        INSTANCE = new OPopoverHelperEx();
    }

    private OPopoverHelperEx() {
    }

    public final void showPopoverSmartlyAtLocation(Activity r13, OPopover r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, "popover");
        showPopoverSmartly$default(this, r14, FakeAnchorView.Companion.addInvisibleViewAtPosition(r13, r15, r16, 2, 2), 80, true, 0.0f, 0, -OPopoverLayout.Companion.getARROW_PADDING_DP(), false, 176, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e(TAG, "showPopoverSmartlyAtLocation failed", e);
    }

    public final void showPopoverSmartlyAtLocation(Dialog r13, OPopover r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r13, "dialog");
        Intrinsics.checkNotNullParameter(r14, "popover");
        View r3 = FakeAnchorView.Companion.addInvisibleViewAtPosition(r13, r15, r16, 2, 2);     // Catch: Exception -> L5
        r14.setIsShowInDialog(true);     // Catch: Exception -> L5
        showPopoverSmartly$default(this, r14, r3, 80, true, 0.0f, 0, -OPopoverLayout.Companion.getARROW_PADDING_DP(), false, 176, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e(TAG, "showPopoverSmartlyAtLocation failed", e);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelperEx r11, OPopover r12, View r13, int r14, boolean r15, float r16, int r17, int r18, boolean r19, int r20, Object r21) {
        if ((r20 & 16) == 0) goto L5;
        float r7 = 0.0f;
    L7:
        if ((r20 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r20 & 64) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r20 & 128) == 0) goto L17;
        boolean r10 = false;
    L18:
        r11.showPopoverSmartly(r12, r13, r14, r15, r7, r8, r9, r10);
        return;
    L17:
        r10 = r19;
        goto L18
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

    public final void showPopoverSmartly(OPopover r18, View r19, int r20, boolean r21, float r22, int r23, int r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r18, "popover");
        Intrinsics.checkNotNullParameter(r19, "anchor");
        int[] r12 = new int[2];
        r19.getLocationOnScreen(r12);
        int r14 = r12[0];
        int r16 = r12[1];
        r18.setGravity$OUI_standardRelease(r20);
        r18.setXOffset(r23);
        r18.setYOffset(r24);
        r18.setAlignArrowPadding(false);
        int[] r6 = r18.calTargetPosition$OUI_standardRelease(r21, r20, r19.getMeasuredWidth(), r19.getMeasuredHeight(), false, r25);
        L.d(TAG, "showPopoverSmartly, offsetXY: [" + r6[0] + ", " + r6[1] + "], arrowOffset: " + r22 + ", xOffset: " + r23 + ", yOffset: " + r24 + ", hasAdapted: " + r25 + ", isMiddle: " + r21 + ", gravity: " + r20 + ", anchor loc: [" + r12[0] + ", " + r12[1] + ']');
        if (r20 != 48) goto L5;
    L7:
        showAtTopOrBottom(r18, r20, r19, r24, r16, r6, r25, r21, r22, r23, r14);
        return;
    L5:
        if (r20 == 80) goto L7;
        showAtLeftOrRight(r18, r20, r19, r14, r6, r23, r25, r21, r22, r24, r16);
    }

    private final void showAtTopOrBottom(OPopover r15, int r16, View r17, int r18, int r19, int[] r20, boolean r21, boolean r22, float r23, int r24, int r25) {
        r15.setGravity$OUI_standardRelease(r16);
        Context r1 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        int r2 = OUnitExtensionKt.getScreenHeight(r1) - OUnitExtensionKt.vdp(r17, 10);
        Context r5 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "anchor.context");
        int r3 = OUnitExtensionKt.getScreenWidth(r5);
        int r6 = OWindowConfigController.getStatusBarHeight(r17.getContext());
        r15.setMaxContentHeight(RangesKt.coerceAtLeast(r2 - r6, 0));
        int r7 = r15.getMeasuredHeight();
        int r10 = r15.getMeasuredWidth();
        boolean r11 = true;
        int r12 = r20[1];
        if ((r19 + r12) >= r6) goto L10;
        if (r21 == true) goto L7;
        showPopoverSmartly(r15, r17, 80, r22, r23, r24, -r18, true);
        return;
    L7:
        int r4 = r18 + (r6 - (r19 + r12));
    L8:
        int r13 = r4;
    L16:
        int r8 = OUnitExtensionKt.vdp(r17, 10);
        int r9 = r20[0];
        if ((r25 + r9) >= 0) goto L33;
        if (r22 == false) goto L22;
        showPopoverSmartly(r15, r17, r16, false, r23, ((-r25) - r15.getArrowHeight()) + r8, r13, false);
        return;
    L22:
        if (r23 == 0.0f) goto L25;
        r11 = false;
    L25:
        if (r11 == false) goto L30;
        if (r24 != 0) goto L30;
        if (r18 != 0) goto L30;
        r15.show(r17, r16, false, (((OUnitExtensionKt.vdp(r17, 25) + r25) + (r17.getMeasuredWidth() / 2)) - r15.getArrowHeight()) - OUnitExtensionKt.vdp(r17, 3), ((-(r25 + r20[0])) - r15.getArrowHeight()) + r8, r13, r21);
        return;
    L30:
        showPopoverSmartly$default(this, r15, r17, r16, false, 0.0f, 0, 0, false, 240, null);
        return;
    L33:
        if (((r25 + r9) + r10) <= r3) goto L47;
        if (r22 == false) goto L38;
        showPopoverSmartly(r15, r17, r16, false, r23, r24, r18, true);
        return;
    L38:
        if (r23 == 0.0f) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L45;
        if (r24 != 0) goto L45;
        r15.show(r17, r16, false, ((((r17.getWidth() / 2) + r25) - ((r3 - r15.getMeasuredWidth()) + OUnitExtensionKt.vdp(r17, 3))) - r15.getArrowHeight()) + r8, (r3 - (((r25 + r20[0]) + r10) - r15.getArrowHeight())) - r8, r13, r21);
        return;
    L45:
        showPopoverSmartly$default(this, r15, r17, r16, false, 0.0f, 0, r18, false, 176, null);
        return;
    L47:
        if (r22 == false) goto L49;
        int r14 = r24;
    L50:
        OPopover.show$default(r15, r17, r16, r22, r23, r14, r13, false, 64, null);
        return;
    L49:
        r14 = r9;
        goto L50
    L10:
        if (((r19 + r12) + r7) <= r2) goto L15;
        if (r21 == true) goto L14;
        showPopoverSmartly(r15, r17, 48, r22, r23, r24, -r18, true);
        return;
    L14:
        r4 = (r2 + r18) - ((r19 + r12) + r7);
        goto L8
    L15:
        r13 = r18;
        goto L16
    }

    private final void showAtLeftOrRight(OPopover r14, int r15, View r16, int r17, int[] r18, int r19, boolean r20, boolean r21, float r22, int r23, int r24) {
        r14.setGravity$OUI_standardRelease(r15);
        Context r1 = r16.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        int r2 = OUnitExtensionKt.getScreenHeight(r1);
        Context r4 = r16.getContext();
        Intrinsics.checkNotNullExpressionValue(r4, "anchor.context");
        int r3 = OUnitExtensionKt.getScreenWidth(r4);
        r14.setMaxContentHeight(r2);
        int r5 = r14.getMeasuredHeight();
        int r8 = r14.getMeasuredWidth();
        boolean r9 = false;
        int r10 = r18[0];
        if (((r17 + r10) + r19) >= 0) goto L9;
        if (r20 == false) goto L6;
        showPopoverSmartly(r14, r16, 48, r21, r22, -r23, -Math.abs(r19), true);
        return;
    L6:
        showPopoverSmartly(r14, r16, 5, r21, r22, -r19, r23, true);
        return;
    L9:
        if ((((r17 + r10) + r8) + r19) <= r3) goto L14;
        if (r20 == false) goto L12;
        showPopoverSmartly(r14, r16, 48, r21, r22, -r23, -Math.abs(r19), true);
        return;
    L12:
        showPopoverSmartly(r14, r16, 3, r21, r22, -r19, r23, true);
        return;
    L14:
        int r11 = r18[1];
        if ((r24 + r11) >= 0) goto L30;
        if (r21 == false) goto L20;
        showPopoverSmartly(r14, r16, r15, false, r22, r19, r23, true);
        return;
    L20:
        if (r22 != 0.0f) goto L22;
        r9 = true;
    L22:
        if (r9 == false) goto L27;
        if (r19 != 0) goto L27;
        if (r23 != 0) goto L27;
        OPopover.show$default(r14, r16, r15, r21, (r24 - OUnitExtensionKt.vdp(r16, 15)) + r16.getHeight(), r19, (-r24) - r18[1], false, 64, null);
        return;
    L27:
        showPopoverSmartly$default(this, r14, r16, r15, r21, 0.0f, 0, 0, false, 240, null);
        return;
    L30:
        if (((r11 + r24) + r5) <= r2) goto L44;
        if (r21 == false) goto L35;
        showPopoverSmartly(r14, r16, r15, false, r22, r19, r23, true);
        return;
    L35:
        if (r22 != 0.0f) goto L37;
        r9 = true;
    L37:
        if (r9 == false) goto L42;
        if (r19 != 0) goto L42;
        if (r23 != 0) goto L42;
        OPopover.show$default(r14, r16, r15, r21, -(((r2 - (r16.getHeight() + r24)) - OUnitExtensionKt.vdp(r16, 15)) + (r16.getHeight() / 2)), r19, r2 - ((r24 + r18[1]) + r5), false, 64, null);
        return;
    L42:
        showPopoverSmartly$default(this, r14, r16, r15, r21, 0.0f, 0, 0, false, 240, null);
        return;
    L44:
        OPopover.show$default(r14, r16, r15, r21, r22, r19, r23, false, 64, null);
    }
}
