package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum RunMode extends Enum<RunMode> {
    public static final RunMode b = null;
    public static final /* synthetic */ RunMode[] c = null;

    static {
        RunMode r0 = new RunMode("PARALLEL", 0);
        b = r0;
        c = new RunMode[]{r0, new RunMode("SERIAL", 1)};
    }

    public static RunMode valueOf(String r1) {
        return (RunMode) Enum.valueOf(RunMode.class, r1);
    }

    public static RunMode[] values() {
        return (RunMode[]) c.clone();
    }
}
