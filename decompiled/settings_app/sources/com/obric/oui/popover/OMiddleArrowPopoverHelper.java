package com.obric.oui.popover;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMiddleArrowPopoverHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007JP\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/popover/OMiddleArrowPopoverHelper;", "", "()V", "DEFAULT_EDGE_SPACE", "", "autoOffsetShow", "", "popover", "Lcom/obric/oui/popover/OMiddleArrowPopover;", "anchor", "Landroid/view/View;", "gravity", "isMiddle", "", "xOffsetWhenPopoverOutOfScreen", "yOffsetWhenPopoverOutOfScreen", "showPopoverSmartly", "arrowOffset", "", "xOffset", "yOffset", "hasAdapted", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMiddleArrowPopoverHelper {
    public static final int DEFAULT_EDGE_SPACE = 10;
    public static final OMiddleArrowPopoverHelper INSTANCE = null;

    static {
        INSTANCE = new OMiddleArrowPopoverHelper();
    }

    public final void autoOffsetShow(OMiddleArrowPopover r11, View r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        autoOffsetShow$default(this, r11, r12, r13, r14, 0, 0, 48, null);
    }

    public final void autoOffsetShow(OMiddleArrowPopover r11, View r12, int r13, boolean r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        autoOffsetShow$default(this, r11, r12, r13, r14, r15, 0, 32, null);
    }

    public final void showPopoverSmartly(OMiddleArrowPopover r13, View r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, 0.0f, 0, 0, false, 240, null);
    }

    public final void showPopoverSmartly(OMiddleArrowPopover r13, View r14, int r15, boolean r16, float r17) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, 0, 0, false, 224, null);
    }

    public final void showPopoverSmartly(OMiddleArrowPopover r13, View r14, int r15, boolean r16, float r17, int r18) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, r18, 0, false, 192, null);
    }

    public final void showPopoverSmartly(OMiddleArrowPopover r13, View r14, int r15, boolean r16, float r17, int r18, int r19) {
        Intrinsics.checkNotNullParameter(r13, "popover");
        Intrinsics.checkNotNullParameter(r14, "anchor");
        showPopoverSmartly$default(this, r13, r14, r15, r16, r17, r18, r19, false, 128, null);
    }

    private OMiddleArrowPopoverHelper() {
    }

    public static /* synthetic */ void autoOffsetShow$default(OMiddleArrowPopoverHelper r9, OMiddleArrowPopover r10, View r11, int r12, boolean r13, int r14, int r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r16 & 32) == 0) goto L9;
        int r8 = 0;
    L10:
        r9.autoOffsetShow(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }

    public final void autoOffsetShow(OMiddleArrowPopover r16, View r17, int r18, boolean r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        int[] r0 = new int[2];
        r17.getLocationOnScreen(r0);
        Log.i("Popover", "location of parent: " + r0[0] + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r0[1]);
        int r13 = r0[0];
        int r14 = r0[1];
        r16.setGravity$OUI_standardRelease(r18);
        int[] r1 = OMiddleArrowPopover.calTargetPosition$OUI_standardRelease$default(r16, r19, r18, r17.getMeasuredWidth(), r17.getMeasuredHeight(), false, 16, null);
        r16.setGravity$OUI_standardRelease(3);
        if (r18 != 48) goto L5;
    L13:
        r16.setGravity$OUI_standardRelease(r18);
        int r2 = r16.getMeasuredWidth();
        r16.setGravity$OUI_standardRelease(3);
        Context r3 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "anchor.context");
        int r4 = OUnitExtensionKt.getScreenWidth(r3);
        int r5 = r1[0];
        if ((r13 + r5) >= 0) goto L17;
        r16.show(r17, r18, r19, r13 + r5, (-r13) - r5, r21);
        return;
    L17:
        if (((r13 + r5) + r2) <= r4) goto L19;
        r16.show(r17, r18, r19, ((r13 + r5) + r2) - r4, r4 - ((r13 + r5) + r2), r21);
        return;
    L19:
        r16.show(r17, r18, r19);
        return;
    L5:
        if (r18 == 80) goto L13;
        r16.setGravity$OUI_standardRelease(r18);
        int r6 = r16.getMeasuredHeight();
        r16.setGravity$OUI_standardRelease(3);
        Context r7 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "anchor.context");
        int r8 = OUnitExtensionKt.getScreenHeight(r7);
        int r9 = r1[1];
        if ((r14 + r9) >= 0) goto L10;
        r16.show(r17, r18, r19, r14 + r9, r20, (-r14) - r9);
        return;
    L10:
        if (((r14 + r9) + r6) <= r8) goto L12;
        r16.show(r17, r18, r19, ((r14 + r9) + r6) - r8, r20, r8 - ((r14 + r9) + r6));
        return;
    L12:
        r16.show(r17, r18, r19);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OMiddleArrowPopoverHelper r11, OMiddleArrowPopover r12, View r13, int r14, boolean r15, float r16, int r17, int r18, boolean r19, int r20, Object r21) {
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

    public final void showPopoverSmartly(OMiddleArrowPopover r19, View r20, int r21, boolean r22, float r23, int r24, int r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r19, "popover");
        Intrinsics.checkNotNullParameter(r20, "anchor");
        int[] r0 = new int[2];
        r20.getLocationOnScreen(r0);
        boolean r14 = false;
        boolean r15 = true;
        Log.i("Popover", "location of parent: " + r0[0] + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r0[1]);
        int r16 = r0[0];
        int r7 = r0[1];
        r19.setGravity$OUI_standardRelease(r21);
        r19.setXOffset(r24);
        r19.setYOffset(r25);
        r19.setAlignArrowPadding(true);
        int[] r1 = OMiddleArrowPopover.calTargetPosition$OUI_standardRelease$default(r19, r22, r21, r20.getMeasuredWidth(), r20.getMeasuredHeight(), false, 16, null);
        r19.setGravity$OUI_standardRelease(3);
        if (r21 != 48) goto L5;
    L49:
        r19.setGravity$OUI_standardRelease(r21);
        int r2 = r19.getMeasuredHeight();
        int r5 = r19.getMeasuredWidth();
        r19.setGravity$OUI_standardRelease(3);
        Context r6 = r20.getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");
        int r8 = OUnitExtensionKt.getScreenHeight(r6);
        Context r9 = r20.getContext();
        Intrinsics.checkNotNullExpressionValue(r9, "anchor.context");
        int r4 = OUnitExtensionKt.getScreenWidth(r9);
        int r10 = r1[1];
        if ((r7 + r10) >= 0) goto L55;
        if (r26 == true) goto L55;
        showPopoverSmartly(r19, r20, 80, r22, r23, r24, -r25, true);
        return;
    L55:
        if (((r10 + r7) + r2) <= r8) goto L59;
        if (r26 == true) goto L59;
        showPopoverSmartly(r19, r20, 48, r22, r23, r24, -r25, true);
        return;
    L59:
        int r3 = OUnitExtensionKt.vdp(r20, 10);
        int r11 = r1[0];
        if ((r16 + r11) >= 0) goto L76;
        if (r22 == false) goto L65;
        showPopoverSmartly(r19, r20, r21, false, r23, r24, r25, true);
        return;
    L65:
        if (r23 == 0.0f) goto L68;
        r15 = false;
    L68:
        if (r15 == false) goto L73;
        if (r24 != 0) goto L73;
        if (r25 != 0) goto L73;
        r19.show(r20, r21, r22, (((r16 + OUnitExtensionKt.vdp(r20, 25)) + (r20.getMeasuredWidth() / 2)) - r19.getArrowHeight()) - OUnitExtensionKt.vdp(r20, 3), ((-(r16 + r1[0])) - r19.getArrowHeight()) + r3, r25);
        return;
    L73:
        showPopoverSmartly$default(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 240, null);
        return;
    L76:
        if (((r16 + r11) + r5) <= r4) goto L91;
        if (r22 == false) goto L81;
        showPopoverSmartly(r19, r20, r21, false, r23, r24, r25, true);
        return;
    L81:
        if (r23 == 0.0f) goto L84;
        r15 = false;
    L84:
        if (r15 == false) goto L89;
        if (r24 != 0) goto L89;
        if (r25 != 0) goto L89;
        r19.show(r20, r21, r22, (((r16 + (r20.getWidth() / 2)) - ((r4 - r19.getMeasuredWidth()) + OUnitExtensionKt.vdp(r20, 3))) - r19.getArrowHeight()) + r3, (r4 - (((r16 + r1[0]) + r5) - r19.getArrowHeight())) - r3, r25);
        return;
    L89:
        showPopoverSmartly$default(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 240, null);
        return;
    L91:
        r19.show(r20, r21, r22, r23, r24, r25);
        return;
    L5:
        if (r21 == 80) goto L49;
        r19.setGravity$OUI_standardRelease(r21);
        int r12 = r19.getMeasuredHeight();
        int r13 = r19.getMeasuredWidth();
        r19.setGravity$OUI_standardRelease(3);
        Context r17 = r20.getContext();
        Intrinsics.checkNotNullExpressionValue(r17, "anchor.context");
        int r18 = OUnitExtensionKt.getScreenHeight(r17);
        Context r27 = r20.getContext();
        Intrinsics.checkNotNullExpressionValue(r27, "anchor.context");
        int r28 = OUnitExtensionKt.getScreenWidth(r27);
        int r29 = r1[0];
        if (((r16 + r29) + r24) >= 0) goto L13;
        if (r26 == false) goto L10;
        showPopoverSmartly(r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true);
        return;
    L10:
        showPopoverSmartly(r19, r20, 5, r22, r23, -r24, r25, true);
        return;
    L13:
        if ((((r16 + r29) + r13) + r24) <= r28) goto L18;
        if (r26 == false) goto L16;
        showPopoverSmartly(r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true);
        return;
    L16:
        showPopoverSmartly(r19, r20, 3, r22, r23, -r24, r25, true);
        return;
    L18:
        int r30 = r1[1];
        if ((r7 + r30) >= 0) goto L34;
        if (r22 == false) goto L24;
        showPopoverSmartly(r19, r20, r21, false, r23, r24, r25, true);
        return;
    L24:
        if (r23 != 0.0f) goto L26;
        r14 = true;
    L26:
        if (r14 == false) goto L31;
        if (r24 != 0) goto L31;
        if (r25 != 0) goto L31;
        r19.show(r20, r21, r22, (r7 - OUnitExtensionKt.vdp(r20, 15)) + r20.getHeight(), r24, (-r7) - r1[1]);
        return;
    L31:
        showPopoverSmartly$default(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 240, null);
        return;
    L34:
        if (((r7 + r30) + r12) <= r18) goto L48;
        if (r22 == false) goto L39;
        showPopoverSmartly(r19, r20, r21, false, r23, r24, r25, true);
        return;
    L39:
        if (r23 != 0.0f) goto L41;
        r14 = true;
    L41:
        if (r14 == false) goto L46;
        if (r24 != 0) goto L46;
        if (r25 != 0) goto L46;
        r19.show(r20, r21, r22, -(((r18 - (r7 + r20.getHeight())) - OUnitExtensionKt.vdp(r20, 15)) + (r20.getHeight() / 2)), r24, r18 - ((r7 + r1[1]) + r12));
        return;
    L46:
        showPopoverSmartly$default(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 240, null);
        return;
    L48:
        r19.show(r20, r21, r22, r23, r24, r25);
    }
}
