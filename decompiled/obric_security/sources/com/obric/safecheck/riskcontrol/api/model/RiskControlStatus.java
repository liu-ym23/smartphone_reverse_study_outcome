package com.obric.safecheck.riskcontrol.api.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: RiskControlStatus.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/model/RiskControlStatus;", "", "(Ljava/lang/String;I)V", "CONTROLLED", "RELEASED", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum RiskControlStatus extends Enum<RiskControlStatus> {
    private static final /* synthetic */ RiskControlStatus[] $VALUES = null;
    public static final RiskControlStatus CONTROLLED = null;
    public static final RiskControlStatus RELEASED = null;

    static {
        RiskControlStatus r1 = new RiskControlStatus("CONTROLLED", 0);
        CONTROLLED = r1;
        RiskControlStatus r2 = new RiskControlStatus("RELEASED", 1);
        RELEASED = r2;
        $VALUES = new RiskControlStatus[]{r1, r2};
    }

    public static RiskControlStatus valueOf(String r1) {
        return (RiskControlStatus) Enum.valueOf(RiskControlStatus.class, r1);
    }

    public static RiskControlStatus[] values() {
        return (RiskControlStatus[]) $VALUES.clone();
    }

    private RiskControlStatus(String r1, int r2) {
        super(r1, r2);
    }
}
