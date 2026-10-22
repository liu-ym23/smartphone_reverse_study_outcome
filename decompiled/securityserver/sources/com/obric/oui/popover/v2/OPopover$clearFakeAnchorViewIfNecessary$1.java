package com.obric.oui.popover.v2;

import android.view.View;
import com.obric.oui.popover.FakeAnchorView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OPopover$clearFakeAnchorViewIfNecessary$1 extends Lambda implements Function1<View, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        View r2 = (View) r1;
        Intrinsics.f(r2, "it");
        return Boolean.valueOf(r2 instanceof FakeAnchorView);
    }
}
