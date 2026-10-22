package com.obric.security.health.score.plan;

import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthPlan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "", SlardarConfigConsts.CONFIG_ID, "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthModulePlanItem {
    private final String id;

    public static /* synthetic */ HealthModulePlanItem copy$default(HealthModulePlanItem r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.id;
    }

    public final HealthModulePlanItem copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, SlardarConfigConsts.CONFIG_ID);
        return new HealthModulePlanItem(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof HealthModulePlanItem) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.id, ((HealthModulePlanItem) r2).id) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "HealthModulePlanItem(id=" + this.id + ")";
    }

    public HealthModulePlanItem(String r2) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        this.id = r2;
    }

    public final String getId() {
        return this.id;
    }
}
