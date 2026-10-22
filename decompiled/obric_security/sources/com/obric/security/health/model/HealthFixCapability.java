package com.obric.security.health.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/security/health/model/HealthFixCapability;", "", "(Ljava/lang/String;I)V", "NONE", "AUTO", "NAVIGATE", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum HealthFixCapability extends Enum<HealthFixCapability> {
    private static final /* synthetic */ HealthFixCapability[] $VALUES = null;
    public static final HealthFixCapability AUTO = null;
    public static final HealthFixCapability NAVIGATE = null;
    public static final HealthFixCapability NONE = null;

    static {
        HealthFixCapability r1 = new HealthFixCapability("NONE", 0);
        NONE = r1;
        HealthFixCapability r2 = new HealthFixCapability("AUTO", 1);
        AUTO = r2;
        HealthFixCapability r3 = new HealthFixCapability("NAVIGATE", 2);
        NAVIGATE = r3;
        $VALUES = new HealthFixCapability[]{r1, r2, r3};
    }

    public static HealthFixCapability valueOf(String r1) {
        return (HealthFixCapability) Enum.valueOf(HealthFixCapability.class, r1);
    }

    public static HealthFixCapability[] values() {
        return (HealthFixCapability[]) $VALUES.clone();
    }

    private HealthFixCapability(String r1, int r2) {
        super(r1, r2);
    }
}
