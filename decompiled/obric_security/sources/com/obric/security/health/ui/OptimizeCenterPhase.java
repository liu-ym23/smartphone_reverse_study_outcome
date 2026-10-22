package com.obric.security.health.ui;

import kotlin.Metadata;

/* JADX INFO: compiled from: OptimizeCenterUiState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/security/health/ui/OptimizeCenterPhase;", "", "(Ljava/lang/String;I)V", "OPTIMIZING", "OPTIMIZED", "RESULT", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum OptimizeCenterPhase extends Enum<OptimizeCenterPhase> {
    private static final /* synthetic */ OptimizeCenterPhase[] $VALUES = null;
    public static final OptimizeCenterPhase OPTIMIZED = null;
    public static final OptimizeCenterPhase OPTIMIZING = null;
    public static final OptimizeCenterPhase RESULT = null;

    static {
        OptimizeCenterPhase r1 = new OptimizeCenterPhase("OPTIMIZING", 0);
        OPTIMIZING = r1;
        OptimizeCenterPhase r2 = new OptimizeCenterPhase("OPTIMIZED", 1);
        OPTIMIZED = r2;
        OptimizeCenterPhase r3 = new OptimizeCenterPhase("RESULT", 2);
        RESULT = r3;
        $VALUES = new OptimizeCenterPhase[]{r1, r2, r3};
    }

    public static OptimizeCenterPhase valueOf(String r1) {
        return (OptimizeCenterPhase) Enum.valueOf(OptimizeCenterPhase.class, r1);
    }

    public static OptimizeCenterPhase[] values() {
        return (OptimizeCenterPhase[]) $VALUES.clone();
    }

    private OptimizeCenterPhase(String r1, int r2) {
        super(r1, r2);
    }
}
