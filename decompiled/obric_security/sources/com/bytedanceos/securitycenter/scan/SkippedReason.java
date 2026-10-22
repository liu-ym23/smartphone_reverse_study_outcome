package com.bytedanceos.securitycenter.scan;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScanPlan.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SkippedReason;", "", "(Ljava/lang/String;I)V", "CONTROLLED_RISK", "PRE_CONFIRMED_RISK", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkippedReason extends Enum<SkippedReason> {
    private static final /* synthetic */ SkippedReason[] $VALUES = null;
    public static final SkippedReason CONTROLLED_RISK = null;
    public static final SkippedReason PRE_CONFIRMED_RISK = null;

    static {
        SkippedReason r1 = new SkippedReason("CONTROLLED_RISK", 0);
        CONTROLLED_RISK = r1;
        SkippedReason r2 = new SkippedReason("PRE_CONFIRMED_RISK", 1);
        PRE_CONFIRMED_RISK = r2;
        $VALUES = new SkippedReason[]{r1, r2};
    }

    public static SkippedReason valueOf(String r1) {
        return (SkippedReason) Enum.valueOf(SkippedReason.class, r1);
    }

    public static SkippedReason[] values() {
        return (SkippedReason[]) $VALUES.clone();
    }

    private SkippedReason(String r1, int r2) {
        super(r1, r2);
    }
}
