package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: RepeatMode.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "", "(Ljava/lang/String;I)V", "NORMAL", "LOOP", "REVERSE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RepeatMode extends Enum<RepeatMode> {
    private static final /* synthetic */ RepeatMode[] $VALUES = null;
    public static final RepeatMode LOOP = null;
    public static final RepeatMode NORMAL = null;
    public static final RepeatMode REVERSE = null;

    static {
        RepeatMode r1 = new RepeatMode("NORMAL", 0);
        NORMAL = r1;
        RepeatMode r2 = new RepeatMode("LOOP", 1);
        LOOP = r2;
        RepeatMode r3 = new RepeatMode("REVERSE", 2);
        REVERSE = r3;
        $VALUES = new RepeatMode[]{r1, r2, r3};
    }

    public static RepeatMode valueOf(String r1) {
        return (RepeatMode) Enum.valueOf(RepeatMode.class, r1);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) $VALUES.clone();
    }

    private RepeatMode(String r1, int r2) {
        super(r1, r2);
    }
}
