package com.obric.security.health.model;

import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/security/health/model/HealthScoreSnapshot;", "", PerfConsts.PERF_DISK_TOTAL, "", "modules", "", "Lcom/obric/security/health/model/HealthModuleSnapshot;", "updatedAt", "", "(ILjava/util/List;J)V", "completedItems", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "getCompletedItems", "()Ljava/util/List;", "getModules", "todoItems", "getTodoItems", "getTotal", "()I", "getUpdatedAt", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthScoreSnapshot {
    private final List<HealthModuleSnapshot> modules;
    private final int total;
    private final long updatedAt;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthScoreSnapshot copy$default(HealthScoreSnapshot r0, int r1, List r2, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.total;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.modules;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.updatedAt;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.total;
    }

    public final List<HealthModuleSnapshot> component2() {
        return this.modules;
    }

    public final long component3() {
        return this.updatedAt;
    }

    public final HealthScoreSnapshot copy(int r1, List<HealthModuleSnapshot> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "modules");
        return new HealthScoreSnapshot(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthScoreSnapshot) == false) goto L12;
        HealthScoreSnapshot r4 = (HealthScoreSnapshot) r3;
        if (this.total == r4.total) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.modules, r4.modules) == true) goto L10;
        return false;
    L10:
        if (this.updatedAt == r4.updatedAt) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.total) * 31;
        List<HealthModuleSnapshot> r1 = this.modules;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.updatedAt);
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "HealthScoreSnapshot(total=" + this.total + ", modules=" + this.modules + ", updatedAt=" + this.updatedAt + ")";
    }

    public HealthScoreSnapshot(int r2, List<HealthModuleSnapshot> r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "modules");
        this.total = r2;
        this.modules = r3;
        this.updatedAt = r4;
    }

    public final int getTotal() {
        return this.total;
    }

    public final List<HealthModuleSnapshot> getModules() {
        return this.modules;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<HealthCheckItemSnapshot> getCompletedItems() {
        List<HealthModuleSnapshot> r4 = this.modules;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((HealthModuleSnapshot) r5.next()).getItems());
        goto L4
    L6:
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L18;
        Object r2 = r1.next();
        HealthCheckItemSnapshot r3 = (HealthCheckItemSnapshot) r2;
        if (r3.getVisible() == true) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L8;
        r6.add(r2);
        goto L8
    L12:
        if (r3.isCompleted() == false) goto L14;
        r7 = true;
        goto L15
    L18:
        return r6;
    }

    public final List<HealthCheckItemSnapshot> getTodoItems() {
        List<HealthModuleSnapshot> r4 = this.modules;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((HealthModuleSnapshot) r5.next()).getItems());
        goto L4
    L6:
        ArrayList r6 = new ArrayList();
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L18;
        Object r2 = r1.next();
        HealthCheckItemSnapshot r3 = (HealthCheckItemSnapshot) r2;
        if (r3.getVisible() == true) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L8;
        r6.add(r2);
        goto L8
    L12:
        if (r3.isCompleted() == true) goto L14;
        r7 = true;
        goto L15
    L18:
        return r6;
    }
}
