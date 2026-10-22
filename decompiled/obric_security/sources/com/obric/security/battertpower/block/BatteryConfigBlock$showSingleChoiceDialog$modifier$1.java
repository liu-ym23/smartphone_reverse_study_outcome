package com.obric.security.battertpower.block;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BatteryConfigBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 4, 3})
final class BatteryConfigBlock$showSingleChoiceDialog$modifier$1 extends Lambda implements Function1<ViewGroup, View> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ int $tempIdx;
    final /* synthetic */ BatteryConfigBlock this$0;

    BatteryConfigBlock$showSingleChoiceDialog$modifier$1(BatteryConfigBlock r1, Context r2, int r3) {
        this.this$0 = r1;
        this.$ctx = r2;
        this.$tempIdx = r3;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(ViewGroup r1) {
        return invoke2(r1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final View invoke2(ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        LinearLayout r13 = new LinearLayout(this.$ctx);
        r13.setOrientation(1);
        ArrayList r1 = new ArrayList(this.this$0.getLOW_POWER_MODE_TRIGER().length);
        final BatteryConfigBlock$showSingleChoiceDialog$modifier$1$1$1 r2 = new BatteryConfigBlock$showSingleChoiceDialog$modifier$1$1$1(r1);
        int r3 = this.this$0.getLOW_POWER_MODE_TRIGER().length;
        final int r5 = 0;
    L3:
        if (r5 >= r3) goto L20;
        final int r6 = this.this$0.getLOW_POWER_MODE_TRIGER()[r5];
        ViewGroup.LayoutParams r10 = null;
        OSelectionItemView r7 = new OSelectionItemView(this.$ctx, null, 2, null);
        r7.setCheckStyle(OSelectionItemView.Companion.CheckStyle.ICON);
        r7.setTitle(new StringBuilder().append(r6).append('%').toString());
        if (r5 != this.$tempIdx) goto L7;
        boolean r8 = true;
    L8:
        r7.setChecked(r8);
        if (r5 != ArraysKt.getLastIndex(this.this$0.getLOW_POWER_MODE_TRIGER())) goto L11;
        r7.showDivider(false);
    L11:
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        r10 = r9;
    L15:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r11 == null) goto L18;
        float r14 = 6;
        r11.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())));
        r11.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r14, Resources.getSystem().getDisplayMetrics())));
    L18:
        r7.setOnClickListener(new BatteryConfigBlock$showSingleChoiceDialog$modifier$1$$special$$inlined$apply$lambda$2(r6, r5, r2, this));
        r1.add(r7);
        r13.addView(r7);
        r5 = r5 + 1;
        goto L3
    L7:
        r8 = false;
        goto L8
    L20:
        return r13;
    }
}
