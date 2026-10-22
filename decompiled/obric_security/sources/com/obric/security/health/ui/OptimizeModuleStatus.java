package com.obric.security.health.ui;

import kotlin.Metadata;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: compiled from: OptimizeCenterUiState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/security/health/ui/OptimizeModuleStatus;", "", "(Ljava/lang/String;I)V", "PENDING", DebugCoroutineInfoImplKt.RUNNING, "DONE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum OptimizeModuleStatus extends Enum<OptimizeModuleStatus> {
    private static final /* synthetic */ OptimizeModuleStatus[] $VALUES = null;
    public static final OptimizeModuleStatus DONE = null;
    public static final OptimizeModuleStatus PENDING = null;
    public static final OptimizeModuleStatus RUNNING = null;

    static {
        OptimizeModuleStatus r1 = new OptimizeModuleStatus("PENDING", 0);
        PENDING = r1;
        OptimizeModuleStatus r2 = new OptimizeModuleStatus(DebugCoroutineInfoImplKt.RUNNING, 1);
        RUNNING = r2;
        OptimizeModuleStatus r3 = new OptimizeModuleStatus("DONE", 2);
        DONE = r3;
        $VALUES = new OptimizeModuleStatus[]{r1, r2, r3};
    }

    public static OptimizeModuleStatus valueOf(String r1) {
        return (OptimizeModuleStatus) Enum.valueOf(OptimizeModuleStatus.class, r1);
    }

    public static OptimizeModuleStatus[] values() {
        return (OptimizeModuleStatus[]) $VALUES.clone();
    }

    private OptimizeModuleStatus(String r1, int r2) {
        super(r1, r2);
    }
}
