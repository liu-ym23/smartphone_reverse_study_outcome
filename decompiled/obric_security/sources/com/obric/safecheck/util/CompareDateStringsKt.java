package com.obric.safecheck.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: compareDateStrings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"compareDateStrings", "", "date1", "", "date2", "safecheck_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class CompareDateStringsKt {
    public static final int compareDateStrings(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "date1");
        Intrinsics.checkNotNullParameter(r2, "date2");
        return r1.compareTo(r2);
    }
}
