package com.obric.security.health.score.plan;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthPlan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/obric/security/health/score/plan/HealthPlan;", "", "modules", "", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "tasks", "Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "(Ljava/util/List;Ljava/util/List;)V", "getModules", "()Ljava/util/List;", "getTasks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthPlan {
    private final List<HealthModulePlanItem> modules;
    private final List<HealthTaskPlanItem> tasks;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthPlan copy$default(HealthPlan r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.modules;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tasks;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<HealthModulePlanItem> component1() {
        return this.modules;
    }

    public final List<HealthTaskPlanItem> component2() {
        return this.tasks;
    }

    public final HealthPlan copy(List<HealthModulePlanItem> r1, List<HealthTaskPlanItem> r2) {
        Intrinsics.checkNotNullParameter(r1, "modules");
        Intrinsics.checkNotNullParameter(r2, "tasks");
        return new HealthPlan(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthPlan) == false) goto L10;
        HealthPlan r4 = (HealthPlan) r3;
        if (Intrinsics.areEqual(this.modules, r4.modules) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tasks, r4.tasks) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<HealthModulePlanItem> r0 = this.modules;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<HealthTaskPlanItem> r4 = this.tasks;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthPlan(modules=" + this.modules + ", tasks=" + this.tasks + ")";
    }

    public HealthPlan(List<HealthModulePlanItem> r2, List<HealthTaskPlanItem> r3) {
        Intrinsics.checkNotNullParameter(r2, "modules");
        Intrinsics.checkNotNullParameter(r3, "tasks");
        this.modules = r2;
        this.tasks = r3;
    }

    public final List<HealthModulePlanItem> getModules() {
        return this.modules;
    }

    public final List<HealthTaskPlanItem> getTasks() {
        return this.tasks;
    }
}
