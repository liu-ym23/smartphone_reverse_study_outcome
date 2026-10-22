package com.obric.security.health.score.task;

import kotlin.Metadata;

/* JADX INFO: compiled from: RiskBehaviorProtectionHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\u0004¨\u0006\u0004"}, d2 = {"hasRiskFlag", "", "", "flag", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class RiskBehaviorProtectionHelperKt {
    public static final boolean hasRiskFlag(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
