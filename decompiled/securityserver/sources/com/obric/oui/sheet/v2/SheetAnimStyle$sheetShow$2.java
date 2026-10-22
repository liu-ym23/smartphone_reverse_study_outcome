package com.obric.oui.sheet.v2;

import com.obric.oui.utils.AnimUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SheetAnimStyle$sheetShow$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r3, Object r4, Object r5) {
        Intrinsics.f((String) r3, "<anonymous parameter 0>");
        Intrinsics.f(r4, "value");
        Intrinsics.f(r5, "<anonymous parameter 2>");
        Intrinsics.c(null);
        SheetAnimStyle.a(null, AnimUtils.a(((Float) r4).floatValue(), 0.0f, 0.0f), 0.0f, 0.0f);
        return Unit.f330a;
    }
}
