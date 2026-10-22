package com.obric.security.battertpower.block;

import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: BatteryConfigBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"updateChecked", "", "checkedIndex", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BatteryConfigBlock$showSingleChoiceDialog$modifier$1$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ArrayList $items;

    BatteryConfigBlock$showSingleChoiceDialog$modifier$1$1$1(ArrayList r1) {
        this.$items = r1;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r1) {
        invoke(r1.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r6) {
        int r0 = this.$items.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        OSelectionItemView r3 = (OSelectionItemView) this.$items.get(r2);
        if (r2 != r6) goto L7;
        boolean r4 = true;
    L8:
        r3.setChecked(r4);
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = false;
        goto L8
    }
}
