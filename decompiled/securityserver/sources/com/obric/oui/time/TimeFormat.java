package com.obric.oui.time;

import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TimeFormat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f300a = null;

    static {
        Locale r1 = Locale.CHINA;
        Intrinsics.e(r1, "Locale.CHINA");
        TimePattern r0 = new TimePattern();
        Locale r3 = Locale.UK;
        Intrinsics.e(r3, "Locale.UK");
        TimePattern r2 = new TimePattern();
        Locale r5 = Locale.US;
        Intrinsics.e(r5, "Locale.US");
        TimePattern r4 = new TimePattern();
        f300a = MapsKt.d(new Pair[]{new Pair(r1, r0), new Pair(r3, r2), new Pair(r5, r4)});
    }
}
