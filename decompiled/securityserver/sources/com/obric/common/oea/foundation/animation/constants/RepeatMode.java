package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum RepeatMode extends Enum<RepeatMode> {
    public static final RepeatMode b = null;
    public static final /* synthetic */ RepeatMode[] c = null;

    static {
        RepeatMode r0 = new RepeatMode("NORMAL", 0);
        b = r0;
        c = new RepeatMode[]{r0, new RepeatMode("LOOP", 1), new RepeatMode("REVERSE", 2)};
    }

    public static RepeatMode valueOf(String r1) {
        return (RepeatMode) Enum.valueOf(RepeatMode.class, r1);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) c.clone();
    }
}
