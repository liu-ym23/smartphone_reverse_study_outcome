package com.obric.safecheck.riskcontrol.api.model;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;

/* JADX INFO: compiled from: RiskInstallSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/model/RiskInstallSource;", "", "(Ljava/lang/String;I)V", "USER_CLICK", "ADB", "PM_INSTALL", NetworkStackConstant.UNKNOWN_TYPE, "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum RiskInstallSource extends Enum<RiskInstallSource> {
    private static final /* synthetic */ RiskInstallSource[] $VALUES = null;
    public static final RiskInstallSource ADB = null;
    public static final RiskInstallSource PM_INSTALL = null;
    public static final RiskInstallSource UNKNOWN = null;
    public static final RiskInstallSource USER_CLICK = null;

    static {
        RiskInstallSource r1 = new RiskInstallSource("USER_CLICK", 0);
        USER_CLICK = r1;
        RiskInstallSource r2 = new RiskInstallSource("ADB", 1);
        ADB = r2;
        RiskInstallSource r3 = new RiskInstallSource("PM_INSTALL", 2);
        PM_INSTALL = r3;
        RiskInstallSource r4 = new RiskInstallSource(NetworkStackConstant.UNKNOWN_TYPE, 3);
        UNKNOWN = r4;
        $VALUES = new RiskInstallSource[]{r1, r2, r3, r4};
    }

    public static RiskInstallSource valueOf(String r1) {
        return (RiskInstallSource) Enum.valueOf(RiskInstallSource.class, r1);
    }

    public static RiskInstallSource[] values() {
        return (RiskInstallSource[]) $VALUES.clone();
    }

    private RiskInstallSource(String r1, int r2) {
        super(r1, r2);
    }
}
