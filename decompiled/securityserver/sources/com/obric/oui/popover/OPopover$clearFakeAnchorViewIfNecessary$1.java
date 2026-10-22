package com.obric.oui.popover;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OPopover$clearFakeAnchorViewIfNecessary$1 extends Lambda implements Function1<View, Boolean> {
    public static final OPopover$clearFakeAnchorViewIfNecessary$1 b = null;

    static {
        b = new OPopover$clearFakeAnchorViewIfNecessary$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        View r2 = (View) r1;
        Intrinsics.f(r2, "it");
        return Boolean.valueOf(r2 instanceof FakeAnchorView);
    }
}
