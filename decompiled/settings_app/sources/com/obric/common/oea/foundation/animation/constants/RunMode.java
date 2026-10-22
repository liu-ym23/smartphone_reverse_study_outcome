package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: compiled from: RunMode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "", "(Ljava/lang/String;I)V", "PARALLEL", "SERIAL", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RunMode extends Enum<RunMode> {
    private static final /* synthetic */ RunMode[] $VALUES = null;
    public static final RunMode PARALLEL = null;
    public static final RunMode SERIAL = null;

    static {
        RunMode r1 = new RunMode("PARALLEL", 0);
        PARALLEL = r1;
        RunMode r2 = new RunMode("SERIAL", 1);
        SERIAL = r2;
        $VALUES = new RunMode[]{r1, r2};
    }

    public static RunMode valueOf(String r1) {
        return (RunMode) Enum.valueOf(RunMode.class, r1);
    }

    public static RunMode[] values() {
        return (RunMode[]) $VALUES.clone();
    }

    private RunMode(String r1, int r2) {
        super(r1, r2);
    }
}
