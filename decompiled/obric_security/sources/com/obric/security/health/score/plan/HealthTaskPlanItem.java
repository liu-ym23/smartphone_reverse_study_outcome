package com.obric.security.health.score.plan;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.security.health.score.task.HealthCheckTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthPlan.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J'\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\f¨\u0006%"}, d2 = {"Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "", "task", "Lcom/obric/security/health/score/task/HealthCheckTask;", "score", "", "policy", "Lcom/obric/security/health/score/plan/HealthTaskPlanPolicy;", "(Lcom/obric/security/health/score/task/HealthCheckTask;ILcom/obric/security/health/score/plan/HealthTaskPlanPolicy;)V", "executable", "", "getExecutable", "()Z", "grantedHidden", "getGrantedHidden", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "moduleId", "getModuleId", "getPolicy", "()Lcom/obric/security/health/score/plan/HealthTaskPlanPolicy;", "getScore", "()I", "getTask", "()Lcom/obric/security/health/score/task/HealthCheckTask;", "visible", "getVisible", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthTaskPlanItem {
    private final HealthTaskPlanPolicy policy;
    private final int score;
    private final HealthCheckTask task;

    public static /* synthetic */ HealthTaskPlanItem copy$default(HealthTaskPlanItem r0, HealthCheckTask r1, int r2, HealthTaskPlanPolicy r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.task;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.score;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.policy;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final HealthCheckTask component1() {
        return this.task;
    }

    public final int component2() {
        return this.score;
    }

    public final HealthTaskPlanPolicy component3() {
        return this.policy;
    }

    public final HealthTaskPlanItem copy(HealthCheckTask r1, int r2, HealthTaskPlanPolicy r3) {
        Intrinsics.checkNotNullParameter(r1, "task");
        Intrinsics.checkNotNullParameter(r3, "policy");
        return new HealthTaskPlanItem(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthTaskPlanItem) == false) goto L12;
        HealthTaskPlanItem r4 = (HealthTaskPlanItem) r3;
        if (Intrinsics.areEqual(this.task, r4.task) == true) goto L8;
        return false;
    L8:
        if (this.score == r4.score) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.policy, r4.policy) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        HealthCheckTask r0 = this.task;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.score)) * 31;
        HealthTaskPlanPolicy r4 = this.policy;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthTaskPlanItem(task=" + this.task + ", score=" + this.score + ", policy=" + this.policy + ")";
    }

    public HealthTaskPlanItem(HealthCheckTask r2, int r3, HealthTaskPlanPolicy r4) {
        Intrinsics.checkNotNullParameter(r2, "task");
        Intrinsics.checkNotNullParameter(r4, "policy");
        this.task = r2;
        this.score = r3;
        this.policy = r4;
    }

    public final HealthCheckTask getTask() {
        return this.task;
    }

    public final int getScore() {
        return this.score;
    }

    public final HealthTaskPlanPolicy getPolicy() {
        return this.policy;
    }

    public final String getId() {
        return this.task.getId();
    }

    public final String getModuleId() {
        return this.task.getModuleId();
    }

    public final boolean getExecutable() {
        if (this.policy != HealthTaskPlanPolicy.EXECUTABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getVisible() {
        if (this.policy != HealthTaskPlanPolicy.EXECUTABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getGrantedHidden() {
        if (this.policy != HealthTaskPlanPolicy.GRANTED_HIDDEN) goto L5;
        return true;
    L5:
        return false;
    }
}
