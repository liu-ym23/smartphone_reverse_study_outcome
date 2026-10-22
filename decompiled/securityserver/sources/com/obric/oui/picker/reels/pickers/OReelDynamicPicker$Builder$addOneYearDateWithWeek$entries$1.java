package com.obric.oui.picker.reels.pickers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OReelDynamicPicker$Builder$addOneYearDateWithWeek$entries$1<T, R> implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object r2) {
        LocalDate r3 = (LocalDate) r2;
        Intrinsics.f(r3, "date");
        if (r3.isEqual(null) == true) goto L9;
        DayOfWeek r4 = r3.getDayOfWeek();
        Intrinsics.e(r4, "date.dayOfWeek");
        switch(Utils.WhenMappings.f257a[r4.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        throw null;
    L7:
        throw new NoWhenBranchMatchedException();
    L9:
        throw null;
    }
}
