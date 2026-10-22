package com.obric.security.health.engine;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthTaskManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/engine/HealthTaskStage;", "", "(Ljava/lang/String;I)V", "CHECK", "OPTIMIZE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum HealthTaskStage extends Enum<HealthTaskStage> {
    private static final /* synthetic */ HealthTaskStage[] $VALUES = null;
    public static final HealthTaskStage CHECK = null;
    public static final HealthTaskStage OPTIMIZE = null;

    static {
        HealthTaskStage r1 = new HealthTaskStage("CHECK", 0);
        CHECK = r1;
        HealthTaskStage r2 = new HealthTaskStage("OPTIMIZE", 1);
        OPTIMIZE = r2;
        $VALUES = new HealthTaskStage[]{r1, r2};
    }

    public static HealthTaskStage valueOf(String r1) {
        return (HealthTaskStage) Enum.valueOf(HealthTaskStage.class, r1);
    }

    public static HealthTaskStage[] values() {
        return (HealthTaskStage[]) $VALUES.clone();
    }

    private HealthTaskStage(String r1, int r2) {
        super(r1, r2);
    }
}
