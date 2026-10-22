package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum TimeStyle extends Enum<TimeStyle> {
    public static final /* synthetic */ TimeStyle[] b = null;

    static {
        b = new TimeStyle[]{new TimeStyle("FULL", 0), new TimeStyle("FULL_Y", 1), new TimeStyle("FULL_YM", 2), new TimeStyle("FULL_YMD", 3), new TimeStyle("FULL_MD", 4), new TimeStyle("FULL_YMDHM", 5), new TimeStyle("FULL_YMDEHM", 6), new TimeStyle("BRIEF_HM", 7), new TimeStyle("BRIEF_MD", 8), new TimeStyle("BRIEF_YMDHM", 9), new TimeStyle("RELATIVE_DETAILED", 10), new TimeStyle("RELATIVE_FUZZY", 11), new TimeStyle("RELATIVE_MIXED", 12), new TimeStyle("RELATIVE_MIXED_BRIEF", 13)};
    }

    public static TimeStyle valueOf(String r1) {
        return (TimeStyle) Enum.valueOf(TimeStyle.class, r1);
    }

    public static TimeStyle[] values() {
        return (TimeStyle[]) b.clone();
    }
}
