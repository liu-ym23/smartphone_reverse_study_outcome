package com.obric.security.health.score.task;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.score.plan.HealthTaskPlanItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u001d\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0018HÖ\u0001J\t\u0010'\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b \u0010\n¨\u0006("}, d2 = {"Lcom/obric/security/health/score/task/HealthTaskEntry;", "", "item", "Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "presentation", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "(Lcom/obric/security/health/score/plan/HealthTaskPlanItem;Lcom/obric/security/health/model/HealthCheckItemPresentation;)V", "executable", "", "getExecutable", "()Z", "grantedHidden", "getGrantedHidden", SlardarConfigConsts.CONFIG_ID, "", "getId", "()Ljava/lang/String;", "getItem", "()Lcom/obric/security/health/score/plan/HealthTaskPlanItem;", "moduleId", "getModuleId", "getPresentation", "()Lcom/obric/security/health/model/HealthCheckItemPresentation;", "score", "", "getScore", "()I", "task", "Lcom/obric/security/health/score/task/HealthCheckTask;", "getTask", "()Lcom/obric/security/health/score/task/HealthCheckTask;", "visible", "getVisible", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
final class HealthTaskEntry {
    private final HealthTaskPlanItem item;
    private final HealthCheckItemPresentation presentation;

    public static /* synthetic */ HealthTaskEntry copy$default(HealthTaskEntry r0, HealthTaskPlanItem r1, HealthCheckItemPresentation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.item;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.presentation;
    L9:
        return r0.copy(r1, r2);
    }

    public final HealthTaskPlanItem component1() {
        return this.item;
    }

    public final HealthCheckItemPresentation component2() {
        return this.presentation;
    }

    public final HealthTaskEntry copy(HealthTaskPlanItem r1, HealthCheckItemPresentation r2) {
        Intrinsics.checkNotNullParameter(r1, "item");
        Intrinsics.checkNotNullParameter(r2, "presentation");
        return new HealthTaskEntry(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthTaskEntry) == false) goto L10;
        HealthTaskEntry r4 = (HealthTaskEntry) r3;
        if (Intrinsics.areEqual(this.item, r4.item) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.presentation, r4.presentation) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        HealthTaskPlanItem r0 = this.item;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HealthCheckItemPresentation r4 = this.presentation;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthTaskEntry(item=" + this.item + ", presentation=" + this.presentation + ")";
    }

    public HealthTaskEntry(HealthTaskPlanItem r2, HealthCheckItemPresentation r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "presentation");
        this.item = r2;
        this.presentation = r3;
    }

    public final HealthTaskPlanItem getItem() {
        return this.item;
    }

    public final HealthCheckItemPresentation getPresentation() {
        return this.presentation;
    }

    public final String getId() {
        return this.item.getId();
    }

    public final HealthCheckTask getTask() {
        return this.item.getTask();
    }

    public final int getScore() {
        return this.item.getScore();
    }

    public final String getModuleId() {
        return this.item.getModuleId();
    }

    public final boolean getVisible() {
        return this.item.getVisible();
    }

    public final boolean getExecutable() {
        return this.item.getExecutable();
    }

    public final boolean getGrantedHidden() {
        return this.item.getGrantedHidden();
    }
}
