package com.obric.oui.picker.reels.pickers;

import java.time.LocalDate;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class Utils$generateDateRange$fmt$1<T, R> implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object r1) {
        LocalDate r2 = (LocalDate) r1;
        Intrinsics.f(r2, "it");
        String r0 = r2.toString();
        Intrinsics.e(r0, "date.toString()");
        return r0;
    }
}
