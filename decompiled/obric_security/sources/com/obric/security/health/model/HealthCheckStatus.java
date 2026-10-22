package com.obric.security.health.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/security/health/model/HealthCheckStatus;", "", "(Ljava/lang/String;I)V", "PASS", "FAIL", "SKIPPED", "UNSUPPORTED", "ERROR", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum HealthCheckStatus extends Enum<HealthCheckStatus> {
    private static final /* synthetic */ HealthCheckStatus[] $VALUES = null;
    public static final HealthCheckStatus ERROR = null;
    public static final HealthCheckStatus FAIL = null;
    public static final HealthCheckStatus PASS = null;
    public static final HealthCheckStatus SKIPPED = null;
    public static final HealthCheckStatus UNSUPPORTED = null;

    static {
        HealthCheckStatus r1 = new HealthCheckStatus("PASS", 0);
        PASS = r1;
        HealthCheckStatus r2 = new HealthCheckStatus("FAIL", 1);
        FAIL = r2;
        HealthCheckStatus r3 = new HealthCheckStatus("SKIPPED", 2);
        SKIPPED = r3;
        HealthCheckStatus r4 = new HealthCheckStatus("UNSUPPORTED", 3);
        UNSUPPORTED = r4;
        HealthCheckStatus r5 = new HealthCheckStatus("ERROR", 4);
        ERROR = r5;
        $VALUES = new HealthCheckStatus[]{r1, r2, r3, r4, r5};
    }

    public static HealthCheckStatus valueOf(String r1) {
        return (HealthCheckStatus) Enum.valueOf(HealthCheckStatus.class, r1);
    }

    public static HealthCheckStatus[] values() {
        return (HealthCheckStatus[]) $VALUES.clone();
    }

    private HealthCheckStatus(String r1, int r2) {
        super(r1, r2);
    }
}
