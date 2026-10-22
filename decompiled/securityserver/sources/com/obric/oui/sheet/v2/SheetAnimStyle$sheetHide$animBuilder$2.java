package com.obric.oui.sheet.v2;

import com.obric.oui.utils.AnimUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SheetAnimStyle$sheetHide$animBuilder$2 extends Lambda implements Function3<String, Object, Object, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r1, Object r2, Object r3) {
        Intrinsics.f((String) r1, "<anonymous parameter 0>");
        Intrinsics.f(r2, "value");
        Intrinsics.f(r3, "<anonymous parameter 2>");
        Intrinsics.c(null);
        SheetAnimStyle.a(null, AnimUtils.a(((Float) r2).floatValue(), 0.0f, 0.0f), 0.0f, 0.0f);
        Float r4 = (Float) r2;
        throw null;
    }
}
