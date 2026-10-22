package com.obric.safecheck.util;

import com.bytedance.android.standard.tools.date.DateUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: getDateAfter6Months.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getDateBeforeXMonths", "", MaterialConfigFormatNames.X, "", "safecheck_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class GetDateAfter6MonthsKt {
    public static final String getDateBeforeXMonths(int r3) {
        String r4 = LocalDate.now().minusMonths(r3).format(DateTimeFormatter.ofPattern(DateUtils.PATTERN_YEAR));
        Intrinsics.checkNotNullExpressionValue(r4, "targetDate.format(formatter)");
        return r4;
    }
}
