package com.obric.security.health.score.plan;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthPlan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/security/health/score/plan/HealthTaskPlanPolicy;", "", "(Ljava/lang/String;I)V", "EXECUTABLE", "GRANTED_HIDDEN", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum HealthTaskPlanPolicy extends Enum<HealthTaskPlanPolicy> {
    private static final /* synthetic */ HealthTaskPlanPolicy[] $VALUES = null;
    public static final HealthTaskPlanPolicy EXECUTABLE = null;
    public static final HealthTaskPlanPolicy GRANTED_HIDDEN = null;

    static {
        HealthTaskPlanPolicy r1 = new HealthTaskPlanPolicy("EXECUTABLE", 0);
        EXECUTABLE = r1;
        HealthTaskPlanPolicy r2 = new HealthTaskPlanPolicy("GRANTED_HIDDEN", 1);
        GRANTED_HIDDEN = r2;
        $VALUES = new HealthTaskPlanPolicy[]{r1, r2};
    }

    public static HealthTaskPlanPolicy valueOf(String r1) {
        return (HealthTaskPlanPolicy) Enum.valueOf(HealthTaskPlanPolicy.class, r1);
    }

    public static HealthTaskPlanPolicy[] values() {
        return (HealthTaskPlanPolicy[]) $VALUES.clone();
    }

    private HealthTaskPlanPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
