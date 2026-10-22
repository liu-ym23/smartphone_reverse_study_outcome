package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum ClockFormat extends Enum<ClockFormat> {
    public static final /* synthetic */ ClockFormat[] b = null;

    static {
        b = new ClockFormat[]{new ClockFormat("H12", 0), new ClockFormat("H24", 1)};
    }

    public static ClockFormat valueOf(String r1) {
        return (ClockFormat) Enum.valueOf(ClockFormat.class, r1);
    }

    public static ClockFormat[] values() {
        return (ClockFormat[]) b.clone();
    }
}
