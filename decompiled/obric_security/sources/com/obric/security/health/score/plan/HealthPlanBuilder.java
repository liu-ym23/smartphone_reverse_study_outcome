package com.obric.security.health.score.plan;

import com.obric.security.health.score.task.HealthCheckTask;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthPlanBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nH\u0002R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/security/health/score/plan/HealthPlanBuilder;", "", "baseModules", "", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "baseTasks", "Lcom/obric/security/health/score/task/HealthCheckTask;", "(Ljava/util/List;Ljava/util/List;)V", "moduleItems", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "taskItems", "Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "addModule", "module", "addTask", "task", "build", "Lcom/obric/security/health/score/plan/HealthPlan;", "enable", "taskId", "grantAndHide", "overrideScore", "score", "", "replaceTask", "taskItem", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthPlanBuilder {
    private final LinkedHashMap<String, HealthModulePlanItem> moduleItems;
    private final LinkedHashMap<String, HealthTaskPlanItem> taskItems;

    public HealthPlanBuilder(List<HealthModulePlanItem> r2, List<? extends HealthCheckTask> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseModules");
        Intrinsics.checkNotNullParameter(r3, "baseTasks");
        this.moduleItems = new LinkedHashMap();
        this.taskItems = new LinkedHashMap();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        addModule((HealthModulePlanItem) r4.next());
        goto L4
    L6:
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        addTask((HealthCheckTask) r5.next());
        goto L8
    }

    public final HealthPlanBuilder addModule(HealthModulePlanItem r3) {
        Intrinsics.checkNotNullParameter(r3, "module");
        if ((!this.moduleItems.containsKey(r3.getId())) == false) goto L7;
        this.moduleItems.put(r3.getId(), r3);
        return this;
    L7:
        throw new IllegalArgumentException(("Duplicate health module id: " + r3.getId()).toString());
    }

    public final HealthPlanBuilder addTask(HealthCheckTask r6) {
        Intrinsics.checkNotNullParameter(r6, "task");
        if ((!this.taskItems.containsKey(r6.getId())) == false) goto L11;
        if (this.moduleItems.containsKey(r6.getModuleId()) == false) goto L9;
        this.taskItems.put(r6.getId(), new HealthTaskPlanItem(r6, r6.getDefaultScore(), HealthTaskPlanPolicy.EXECUTABLE));
        return this;
    L9:
        throw new IllegalArgumentException(("Health task module not found, taskId=" + r6.getId() + " moduleId=" + r6.getModuleId()).toString());
    L11:
        throw new IllegalArgumentException(("Duplicate health task id: " + r6.getId()).toString());
    }

    public final HealthPlanBuilder replaceTask(HealthCheckTask r9) {
        Intrinsics.checkNotNullParameter(r9, "task");
        HealthTaskPlanItem r0 = this.taskItems.get(r9.getId());
        if (r0 == null) goto L11;
        HealthTaskPlanItem r1 = r0;
        if (Intrinsics.areEqual(r1.getModuleId(), r9.getModuleId()) == false) goto L9;
        this.taskItems.put(r9.getId(), HealthTaskPlanItem.copy$default(r1, r9, 0, null, 6, null));
        return this;
    L9:
        throw new IllegalArgumentException(("Health task module changed, taskId=" + r9.getId() + " previousModuleId=" + r1.getModuleId() + " moduleId=" + r9.getModuleId()).toString());
    L11:
        throw new IllegalArgumentException(("Health task not found, taskId=" + r9.getId()).toString());
    }

    public final HealthPlanBuilder overrideScore(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        if (r9 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.taskItems.put(r8, HealthTaskPlanItem.copy$default(taskItem(r8), null, r9, null, 5, null));
        return this;
    L10:
        throw new IllegalArgumentException(("Health task score must be >= 0, taskId=" + r8 + " score=" + r9).toString());
    L5:
        r0 = false;
        goto L6
    }

    public final HealthPlanBuilder grantAndHide(String r8) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        this.taskItems.put(r8, HealthTaskPlanItem.copy$default(taskItem(r8), null, 0, HealthTaskPlanPolicy.GRANTED_HIDDEN, 3, null));
        return this;
    }

    public final HealthPlanBuilder enable(String r8) {
        Intrinsics.checkNotNullParameter(r8, "taskId");
        this.taskItems.put(r8, HealthTaskPlanItem.copy$default(taskItem(r8), null, 0, HealthTaskPlanPolicy.EXECUTABLE, 3, null));
        return this;
    }

    public final HealthPlan build() {
        Collection<HealthModulePlanItem> r1 = this.moduleItems.values();
        Intrinsics.checkNotNullExpressionValue(r1, "moduleItems.values");
        List r2 = CollectionsKt.toList(r1);
        Collection<HealthTaskPlanItem> r3 = this.taskItems.values();
        Intrinsics.checkNotNullExpressionValue(r3, "taskItems.values");
        return new HealthPlan(r2, CollectionsKt.toList(r3));
    }

    private final HealthTaskPlanItem taskItem(String r2) {
        HealthTaskPlanItem r1 = this.taskItems.get(r2);
        if (r1 == null) goto L7;
        return r1;
    L7:
        throw new IllegalArgumentException(("Health task not found, taskId=" + r2).toString());
    }
}
