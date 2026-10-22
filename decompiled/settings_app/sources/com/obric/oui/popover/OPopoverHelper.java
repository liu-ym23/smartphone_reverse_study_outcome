package com.obric.oui.popover;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.window.OWindowConfigController;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use OPopoverHelperEx instead")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007Jn\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/popover/OPopoverHelper;", "", "()V", "DEFAULT_EDGE_SPACE", "", "TAG", "", "autoOffsetShow", "", "popover", "Lcom/obric/oui/popover/OPopover;", "anchor", "Landroid/view/View;", "gravity", "isMiddle", "", "xOffsetWhenPopoverOutOfScreen", "yOffsetWhenPopoverOutOfScreen", "showPopoverSmartly", "arrowOffset", "", "xOffset", "yOffset", "hasAdapted", "leftPaddingDp", "rightPaddingDp", "alignArrowPadding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverHelper {
    public static final int DEFAULT_EDGE_SPACE = 10;
    public static final OPopoverHelper INSTANCE = null;
    private static final String TAG = "OPopoverHelper";

    static {
        INSTANCE = new OPopoverHelper();
    }

    public final void autoOffsetShow(OPopover r11, View r12, int r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        autoOffsetShow$default(this, r11, r12, r13, r14, 0, 0, 48, null);
    }

    public final void autoOffsetShow(OPopover r11, View r12, int r13, boolean r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "popover");
        Intrinsics.checkNotNullParameter(r12, "anchor");
        autoOffsetShow$default(this, r11, r12, r13, r14, r15, 0, 32, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, 0, 0, false, 0, 0, false, 2016, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20, int r21) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, r21, 0, false, 0, 0, false, 1984, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, r21, r22, false, 0, 0, false, 1920, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20, int r21, int r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, r21, r22, r23, 0, 0, false, 1792, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20, int r21, int r22, boolean r23, int r24) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, 0, false, 1536, null);
    }

    public final void showPopoverSmartly(OPopover r16, View r17, int r18, boolean r19, float r20, int r21, int r22, boolean r23, int r24, int r25) {
        Intrinsics.checkNotNullParameter(r16, "popover");
        Intrinsics.checkNotNullParameter(r17, "anchor");
        showPopoverSmartly$default(this, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, false, 1024, null);
    }

    private OPopoverHelper() {
    }

    public static /* synthetic */ void autoOffsetShow$default(OPopoverHelper r9, OPopover r10, View r11, int r12, boolean r13, int r14, int r15, int r16, Object r17) {
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

    public final void autoOffsetShow(OPopover r17, View r18, int r19, boolean r20, int r21, int r22) {
        Intrinsics.checkNotNullParameter(r17, "popover");
        Intrinsics.checkNotNullParameter(r18, "anchor");
        int[] r0 = new int[2];
        r18.getLocationOnScreen(r0);
        Log.i("Popover", "location of parent: " + r0[0] + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r0[1]);
        int r14 = r0[0];
        int r15 = r0[1];
        r17.setGravity$OUI_standardRelease(r19);
        int[] r1 = OPopover.calTargetPosition$OUI_standardRelease$default(r17, r20, r19, r18.getMeasuredWidth(), r18.getMeasuredHeight(), false, false, 48, null);
        r17.setGravity$OUI_standardRelease(3);
        if (r19 != 48) goto L5;
    L13:
        r17.setGravity$OUI_standardRelease(r19);
        int r2 = r17.getMeasuredWidth();
        r17.setGravity$OUI_standardRelease(3);
        Context r3 = r18.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "anchor.context");
        int r4 = OUnitExtensionKt.getScreenWidth(r3);
        int r5 = r1[0];
        if ((r14 + r5) >= 0) goto L17;
        OPopover.show$default(r17, r18, r19, r20, r14 + r5, (-r14) - r5, r22, false, 64, null);
        return;
    L17:
        if (((r14 + r5) + r2) <= r4) goto L19;
        OPopover.show$default(r17, r18, r19, r20, ((r14 + r5) + r2) - r4, r4 - ((r14 + r5) + r2), r22, false, 64, null);
        return;
    L19:
        OPopover.show$default(r17, r18, r19, r20, false, 8, null);
        return;
    L5:
        if (r19 == 80) goto L13;
        r17.setGravity$OUI_standardRelease(r19);
        int r6 = r17.getMeasuredHeight();
        r17.setGravity$OUI_standardRelease(3);
        Context r7 = r18.getContext();
        Intrinsics.checkNotNullExpressionValue(r7, "anchor.context");
        int r8 = OUnitExtensionKt.getScreenHeight(r7);
        int r9 = r1[1];
        if ((r15 + r9) >= 0) goto L10;
        OPopover.show$default(r17, r18, r19, r20, r15 + r9, r21, (-r15) - r9, false, 64, null);
        return;
    L10:
        if (((r15 + r9) + r6) <= r8) goto L12;
        OPopover.show$default(r17, r18, r19, r20, ((r15 + r9) + r6) - r8, r21, r8 - ((r15 + r9) + r6), false, 64, null);
        return;
    L12:
        OPopover.show$default(r17, r18, r19, r20, false, 8, null);
    }

    public static /* synthetic */ void showPopoverSmartly$default(OPopoverHelper r14, OPopover r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22, int r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 16) == 0) goto L5;
        float r7 = 0.0f;
    L7:
        if ((r26 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r26 & 64) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r26 & 128) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r26 & 256) == 0) goto L21;
        int r11 = 0;
    L23:
        if ((r26 & 512) == 0) goto L25;
        int r12 = 0;
    L27:
        if ((r26 & 1024) == 0) goto L29;
        boolean r13 = true;
    L30:
        r14.showPopoverSmartly(r15, r16, r17, r18, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r25;
        goto L30
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r9 = r21;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }

    public final void showPopoverSmartly(OPopover r20, View r21, int r22, boolean r23, float r24, int r25, int r26, boolean r27, int r28, int r29, boolean r30) {
        Intrinsics.checkNotNullParameter(r20, "popover");
        Intrinsics.checkNotNullParameter(r21, "anchor");
        int[] r0 = new int[2];
        r21.getLocationOnScreen(r0);
        boolean r13 = false;
        Log.i("Popover", "location of parent: " + r0[0] + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r0[1]);
        int r15 = r0[0];
        int r6 = r0[1];
        r20.setGravity$OUI_standardRelease(r22);
        r20.setXOffset(r25);
        r20.setYOffset(r26);
        r20.setAlignArrowPadding(r30);
        int[] r1 = r20.calTargetPosition$OUI_standardRelease(r23, r22, r21.getMeasuredWidth(), r21.getMeasuredHeight(), false, r27);
        r20.setGravity$OUI_standardRelease(3);
        if (r22 != 48) goto L5;
    L50:
        r20.setGravity$OUI_standardRelease(r22);
        Size r2 = OWindowConfigController.getFullWindowSize(r21.getContext());
        int r4 = r2.getHeight() - OUnitExtensionKt.vdp(r21, 10);
        int r3 = r2.getWidth();
        int r7 = OWindowConfigController.getStatusBarHeight(r21.getContext());
        r20.setMaxContentHeight(RangesKt.coerceAtLeast(r4 - r7, 0));
        int r5 = r20.getMeasuredHeight();
        int r17 = r20.getMeasuredWidth();
        r20.setGravity$OUI_standardRelease(3);
        int r18 = r1[1];
        if ((r6 + r18) >= r7) goto L58;
        if (r27 == true) goto L55;
        showPopoverSmartly$default(this, r20, r21, 80, r23, r24, r25, -r26, true, r28, r29, false, 1024, null);
        return;
    L55:
        int r8 = r26 + (r7 - (r6 + r18));
    L56:
        int r9 = r8;
    L64:
        int r10 = r1[0];
        if ((r15 + r10) >= 0) goto L83;
        if (r23 == false) goto L72;
        if (r10 >= 0) goto L69;
        showPopoverSmartly$default(this, r20, r21, r22, false, r24, (-r15) + OUnitExtensionKt.vdp(r21, 12), r26, false, r28, r29, false, 1024, null);
        return;
    L69:
        showPopoverSmartly$default(this, r20, r21, r22, false, r24, r25, r26, true, r28, r29, false, 1024, null);
        return;
    L72:
        if (r24 != 0.0f) goto L74;
        boolean r14 = true;
    L75:
        if (r14 == false) goto L80;
        if (r25 != 0) goto L80;
        if (r26 != 0) goto L80;
        r20.show(r21, r22, r23, (((OUnitExtensionKt.vdp(r21, 25) + r15) + (r21.getMeasuredWidth() / 2)) - r20.getArrowHeight()) - OUnitExtensionKt.vdp(r21, 3), (((-(r15 + r1[0])) - r20.getArrowHeight()) + OUnitExtensionKt.vdp(r21, 10)) + OUnitExtensionKt.vdp(r21, r28), r9, r27);
    L102:
        Unit r11 = Unit.INSTANCE;
        return;
    L80:
        showPopoverSmartly$default(this, r20, r21, r22, r23, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L74:
        r14 = false;
        goto L75
    L83:
        if (((r15 + r10) + r17) <= r3) goto L98;
        if (r23 == false) goto L88;
        showPopoverSmartly$default(this, r20, r21, r22, false, r24, r25, r26, true, r28, r29, false, 1024, null);
        return;
    L88:
        if (r24 != 0.0f) goto L90;
        boolean r16 = true;
    L91:
        if (r16 == false) goto L96;
        if (r25 != 0) goto L96;
        if (r26 != 0) goto L96;
        r20.show(r21, r22, r23, ((((r21.getWidth() / 2) + r15) - ((r3 - r20.getMeasuredWidth()) + OUnitExtensionKt.vdp(r21, 3))) - r20.getArrowHeight()) + OUnitExtensionKt.vdp(r21, 10), ((r3 - (((r15 + r1[0]) + r17) - r20.getArrowHeight())) - OUnitExtensionKt.vdp(r21, 10)) + OUnitExtensionKt.vdp(r21, r29), r9, r27);
    L96:
        showPopoverSmartly$default(this, r20, r21, r22, r23, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L90:
        r16 = false;
        goto L91
    L98:
        if (r23 == false) goto L100;
        int r12 = r25;
    L101:
        OPopover.show$default(r20, r21, r22, r23, r24, r12, r9, false, 64, null);
        goto L102
    L100:
        r12 = r10;
        goto L101
    L58:
        if (((r6 + r18) + r5) <= r4) goto L63;
        if (r27 == true) goto L62;
        showPopoverSmartly$default(this, r20, r21, 48, r23, r24, r25, -r26, true, r28, r29, false, 1024, null);
        return;
    L62:
        r8 = (r4 + r26) - ((r6 + r18) + r5);
        goto L56
    L63:
        r9 = r26;
        goto L64
    L5:
        if (r22 == 80) goto L50;
        r20.setGravity$OUI_standardRelease(r22);
        Context r19 = r21.getContext();
        Intrinsics.checkNotNullExpressionValue(r19, "anchor.context");
        int r31 = OUnitExtensionKt.getScreenHeight(r19);
        Context r32 = r21.getContext();
        Intrinsics.checkNotNullExpressionValue(r32, "anchor.context");
        int r33 = OUnitExtensionKt.getScreenWidth(r32);
        r20.setMaxContentHeight(r31);
        int r34 = r20.getMeasuredHeight();
        int r35 = r20.getMeasuredWidth();
        r20.setGravity$OUI_standardRelease(3);
        int r36 = r1[0];
        if (((r15 + r36) + r25) >= 0) goto L13;
        if (r27 == false) goto L10;
        showPopoverSmartly$default(this, r20, r21, 48, r23, r24, -r26, -Math.abs(r25), true, r28, r29, false, 1024, null);
        return;
    L10:
        showPopoverSmartly$default(this, r20, r21, 5, r23, r24, -r25, r26, true, r28, r29, false, 1024, null);
        return;
    L13:
        if ((((r15 + r36) + r35) + r25) <= r33) goto L18;
        if (r27 == false) goto L16;
        showPopoverSmartly$default(this, r20, r21, 48, r23, r24, -r26, -Math.abs(r25), true, r28, r29, false, 1024, null);
        return;
    L16:
        showPopoverSmartly$default(this, r20, r21, 3, r23, r24, -r25, r26, true, r28, r29, false, 1024, null);
        return;
    L18:
        int r37 = r1[1];
        if ((r6 + r37) >= 0) goto L34;
        if (r23 == false) goto L24;
        showPopoverSmartly$default(this, r20, r21, r22, false, r24, r25, r26, true, r28, r29, false, 1024, null);
        return;
    L24:
        if (r24 != 0.0f) goto L26;
        r13 = true;
    L26:
        if (r13 == false) goto L31;
        if (r25 != 0) goto L31;
        if (r26 != 0) goto L31;
        OPopover.show$default(r20, r21, r22, r23, (r6 - OUnitExtensionKt.vdp(r21, 15)) + r21.getHeight(), r25, (-r6) - r1[1], false, 64, null);
    L49:
        Unit r38 = Unit.INSTANCE;
        return;
    L31:
        showPopoverSmartly$default(this, r20, r21, r22, r23, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L34:
        if (((r6 + r37) + r34) <= r31) goto L48;
        if (r23 == false) goto L39;
        showPopoverSmartly$default(this, r20, r21, r22, false, r24, r25, r26, true, r28, r29, false, 1024, null);
        return;
    L39:
        if (r24 != 0.0f) goto L41;
        r13 = true;
    L41:
        if (r13 == false) goto L46;
        if (r25 != 0) goto L46;
        if (r26 != 0) goto L46;
        OPopover.show$default(r20, r21, r22, r23, -(((r31 - (r6 + r21.getHeight())) - OUnitExtensionKt.vdp(r21, 15)) + (r21.getHeight() / 2)), r25, r31 - ((r6 + r1[1]) + r34), false, 64, null);
    L46:
        showPopoverSmartly$default(this, r20, r21, r22, r23, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L48:
        OPopover.show$default(r20, r21, r22, r23, r24, r25, r26, false, 64, null);
        goto L49
    }
}
