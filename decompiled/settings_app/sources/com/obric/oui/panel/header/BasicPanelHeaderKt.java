package com.obric.oui.panel.header;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.titlebar.OButtonTitleBar;
import com.obric.oui.titlebar.OCompoundTitleBar;
import com.obric.oui.titlebar.ONormalTitleBar;
import com.obric.oui.titlebar.OTextTitleBar;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a7\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000bH\u0000¨\u0006\f"}, d2 = {"forceTitleBarHeaderLight", "", "context", "Landroid/content/Context;", "titleBar", "Lcom/obric/oui/titlebar/OTitleBar;", "initHeader", "useAutoSwitchTheme", "", "otherAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BasicPanelHeaderKt {
    @Deprecated(message = "已过时，所有header均支持深浅模式")
    public static final void forceTitleBarHeaderLight(Context r4, OTitleBar r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "titleBar");
        int r0 = ContextCompat.getColor(r4, R.color.TextReverse);
        r5.setBackgroundColor(ContextCompat.getColor(r4, R.color.BGReverse));
        r5.setTitleColor(r0);
        r5.setDividerLineBackground(ContextCompat.getColor(r4, R.color.PanelConstDivider));
        if ((r5 instanceof OTextTitleBar) == false) goto L9;
        OTextTitleBar r6 = (OTextTitleBar) r5;
        r6.setStartTextColor(r0);
        if (r6.getEndButtonType() != 1) goto L7;
        r6.setEndTextColor(ContextCompat.getColor(r4, R.color.Primary));
        return;
    L7:
        r6.setEndTextColor(r0);
        return;
    L9:
        if ((r5 instanceof ONormalTitleBar) == false) goto L12;
        ONormalTitleBar r7 = (ONormalTitleBar) r5;
        r7.getStartBtn().setImageTintList(ColorStateList.valueOf(r0));
        r7.getEndBtn().setImageTintList(ColorStateList.valueOf(r0));
        return;
    L12:
        if ((r5 instanceof OButtonTitleBar) == false) goto L18;
        OButtonTitleBar r8 = (OButtonTitleBar) r5;
        r8.getStartBtn().setImageTintList(ColorStateList.valueOf(r0));
        if (r8.getEndButtonType() != 1) goto L16;
        r8.getEndBtn().setTextColor(ContextCompat.getColor(r4, R.color.Primary));
        return;
    L16:
        r8.getEndBtn().setTextColor(r0);
        return;
    L18:
        if ((r5 instanceof OCompoundTitleBar) == false) goto L26;
        ((OCompoundTitleBar) r5).setTint(r0, r0, r0, r0);
        return;
    }

    public static /* synthetic */ void initHeader$default(OTitleBar r0, Context r1, boolean r2, AnonymousClass1 r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = AnonymousClass1.INSTANCE;
    L5:
        initHeader(r0, r1, r2, r3);
    }

    public static final void initHeader(final OTitleBar r10, Context r11, boolean r12, Function1<? super OTitleBar, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "otherAction");
        r10.setMinimumHeight(OUnitExtensionKt.cdp(r11, 44));
        r10.showDividerLine(true);
        r10.setDividerLineBackground(ContextCompat.getColor(r11, R.color.PanelConstDivider));
        if (r12 == false) goto L5;
        int r2 = R.color.BGPanelTint;
    L6:
        GradientDrawable r3 = new GradientDrawable();
        r3.setColor(ContextCompat.getColor(r11, r2));
        final OTitleBar r4 = r10;
        r3.setCornerRadius(OUnitExtensionKt.vdpFloat(r4, 12));
        r10.setBackground(r3);
        if (r12 == false) goto L9;
        int r14 = R.color.TextPrimary;
    L10:
        int r15 = ContextCompat.getColor(r11, r14);
        r10.setTitleColor(r15);
        int r5 = ContextCompat.getColor(r11, R.color.Primary);
        final int r16 = OUnitExtensionKt.cdp(r11, 44);
        if ((r10 instanceof OTextTitleBar) == false) goto L20;
        OTextTitleBar r0 = (OTextTitleBar) r10;
        r0.setStartTextColor(r15);
        if (r0.getEndButtonType() != 1) goto L15;
        r15 = r5;
    L15:
        r0.setEndTextColor(r15);
        if (ViewCompat.isAttachedToWindow(r4) == false) goto L18;
        TextView r6 = r0.getStartText();
        Intrinsics.checkNotNullExpressionValue(r6, "startText");
        TextView r1 = r0.getEndText();
        Intrinsics.checkNotNullExpressionValue(r1, "endText");
        ViewExtensionsKt.increaseHitAreaForViews(r4, r16, r16, new View[]{r6, r1});
    L48:
        r13.invoke(r10);
        return;
    L18:
        r4.addOnAttachStateChangeListener(new BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$1(r4, r10, r16));
        goto L48
    L20:
        if ((r10 instanceof ONormalTitleBar) == false) goto L34;
        ONormalTitleBar r7 = (ONormalTitleBar) r10;
        ImageView r8 = r7.getStartBtn();
        if (r8 == null) goto L25;
        r8.setImageTintList(ColorStateList.valueOf(r15));
    L25:
        ImageView r9 = r7.getEndBtn();
        if (r9 == null) goto L30;
        r9.setImageTintList(ColorStateList.valueOf(r15));
    L30:
        if (ViewCompat.isAttachedToWindow(r4) == false) goto L32;
        ImageView r17 = r7.getStartBtn();
        Intrinsics.checkNotNullExpressionValue(r17, "startBtn");
        ImageView r18 = r7.getEndBtn();
        Intrinsics.checkNotNullExpressionValue(r18, "endBtn");
        ViewExtensionsKt.increaseHitAreaForViews(r4, r16, r16, new View[]{r17, r18});
        goto L48
    L32:
        r4.addOnAttachStateChangeListener(new BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$2(r4, r10, r16));
        goto L48
    L34:
        if ((r10 instanceof OButtonTitleBar) == false) goto L43;
        OButtonTitleBar r19 = (OButtonTitleBar) r10;
        r19.getStartBtn().setImageTintList(ColorStateList.valueOf(r15));
        TextView r20 = r19.getEndBtn();
        if (r19.getEndButtonType() != 1) goto L38;
        r15 = r5;
    L38:
        r20.setTextColor(r15);
        if (ViewCompat.isAttachedToWindow(r4) == false) goto L41;
        ImageView r21 = r19.getStartBtn();
        Intrinsics.checkNotNullExpressionValue(r21, "startBtn");
        TextView r22 = r19.getEndBtn();
        Intrinsics.checkNotNullExpressionValue(r22, "endBtn");
        ViewExtensionsKt.increaseHitAreaForViews(r4, r16, r16, new View[]{r21, r22});
        goto L48
    L41:
        r4.addOnAttachStateChangeListener(new BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$3(r4, r10, r16));
        goto L48
    L43:
        if ((r10 instanceof OCompoundTitleBar) == false) goto L48;
        OCompoundTitleBar r23 = (OCompoundTitleBar) r10;
        r23.setTint(r15, r15, r15, r15);
        if (ViewCompat.isAttachedToWindow(r4) == false) goto L47;
        ImageView r24 = r23.getStartButton0();
        Intrinsics.checkNotNull(r24);
        ImageView r25 = r23.getEndButton0();
        Intrinsics.checkNotNull(r25);
        ViewExtensionsKt.increaseHitAreaForViews(r4, r16, r16, new View[]{r24, r25});
        goto L48
    L47:
        r4.addOnAttachStateChangeListener(new BasicPanelHeaderKt$initHeader$$inlined$doOnAttach$4(r4, r10, r16));
        goto L48
    L9:
        r14 = R.color.TextReverse;
        goto L10
    L5:
        r2 = R.color.BGTertiary;
        goto L6
    }
}
