package com.obric.oui.textswitcher;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ViewSwitcher;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: OTextSwitcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ViewSwitcher$ViewFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OTextSwitcher$defaultViewFactory$2 extends Lambda implements Function0<ViewSwitcher.ViewFactory> {
    final /* synthetic */ Context $context;
    final /* synthetic */ OTextSwitcher this$0;

    /* JADX INFO: renamed from: $r8$lambda$G8x4wi64-mlphvpcxNsyjBZwGzc, reason: not valid java name */
    public static /* synthetic */ View m1416$r8$lambda$G8x4wi64mlphvpcxNsyjBZwGzc(Context r0, OTextSwitcher r1) {
        return m1417invoke$lambda4(r0, r1);
    }

    OTextSwitcher$defaultViewFactory$2(Context r1, OTextSwitcher r2) {
        this.$context = r1;
        this.this$0 = r2;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewSwitcher.ViewFactory invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewSwitcher.ViewFactory invoke() {
        final Context r0 = this.$context;
        final OTextSwitcher r2 = this.this$0;
        return new OTextSwitcher$defaultViewFactory$2$$ExternalSyntheticLambda0(r0, r2);
    }

    /* JADX INFO: renamed from: invoke$lambda-4, reason: not valid java name */
    private static final View m1417invoke$lambda4(Context r8, OTextSwitcher r9) {
        Intrinsics.checkNotNullParameter(r8, "$context");
        Intrinsics.checkNotNullParameter(r9, "this$0");
        OTextView r0 = new OTextView(r8, null, 0, null, 14, null);
        TextSwitcherSpec r10 = OTextSwitcher.access$getOTextSwitcherSpec$p(r9);
        if (r10 != null) goto L5;
        TextSpec r11 = null;
    L6:
        if (r11 == null) goto L13;
        Integer r1 = r11.getTextColor();
        if (r1 == null) goto L13;
        r0.setTextColor(r1.intValue());
    L13:
        if (r11 == null) goto L19;
        Float r2 = r11.getTextSizeDp();
        if (r2 == null) goto L19;
        r0.setTextSize(1, r2.floatValue());
    L19:
        boolean r3 = false;
        if (r11 == null) goto L28;
        int[] r12 = r11.getPaddingDp();
        if (r12 == null) goto L28;
        if (r12.length != 4) goto L28;
        r0.setPadding(r12[0], r12[1], r12[2], r12[3]);
    L28:
        r0.setGravity(16);
        r0.setSingleLine(true);
        TextSwitcherSpec r13 = OTextSwitcher.access$getOTextSwitcherSpec$p(r9);
        if (r13 != null) goto L32;
    L34:
        if (r3 == false) goto L36;
        r0.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r0.setMarqueeRepeatLimit(-1);
        r0.setSelected(true);
        r0.setHorizontallyScrolling(true);
        r0.setFocusableInTouchMode(true);
    L38:
        return r0;
    L36:
        r0.setEllipsize(TextUtils.TruncateAt.END);
        goto L38
    L32:
        if (r13.isSupportMarquee() != true) goto L34;
        r3 = true;
        goto L34
    L5:
        r11 = r10.getTextSpec();
        goto L6
    }
}
