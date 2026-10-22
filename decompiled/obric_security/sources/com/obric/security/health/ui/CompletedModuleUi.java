package com.obric.security.health.ui;

import com.obric.security.health.model.HealthCheckItemSnapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptimizeResultBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/security/health/ui/CompletedModuleUi;", "", "moduleUi", "Lcom/obric/security/health/ui/OptimizeModuleUi;", "items", "", "Lcom/obric/security/health/model/HealthCheckItemSnapshot;", "(Lcom/obric/security/health/ui/OptimizeModuleUi;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getModuleUi", "()Lcom/obric/security/health/ui/OptimizeModuleUi;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
final class CompletedModuleUi {
    private final List<HealthCheckItemSnapshot> items;
    private final OptimizeModuleUi moduleUi;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompletedModuleUi copy$default(CompletedModuleUi r0, OptimizeModuleUi r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.moduleUi;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.items;
    L9:
        return r0.copy(r1, r2);
    }

    public final OptimizeModuleUi component1() {
        return this.moduleUi;
    }

    public final List<HealthCheckItemSnapshot> component2() {
        return this.items;
    }

    public final CompletedModuleUi copy(OptimizeModuleUi r1, List<HealthCheckItemSnapshot> r2) {
        Intrinsics.checkNotNullParameter(r1, "moduleUi");
        Intrinsics.checkNotNullParameter(r2, "items");
        return new CompletedModuleUi(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CompletedModuleUi) == false) goto L10;
        CompletedModuleUi r4 = (CompletedModuleUi) r3;
        if (Intrinsics.areEqual(this.moduleUi, r4.moduleUi) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.items, r4.items) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        OptimizeModuleUi r0 = this.moduleUi;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<HealthCheckItemSnapshot> r4 = this.items;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CompletedModuleUi(moduleUi=" + this.moduleUi + ", items=" + this.items + ")";
    }

    public CompletedModuleUi(OptimizeModuleUi r2, List<HealthCheckItemSnapshot> r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleUi");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.moduleUi = r2;
        this.items = r3;
    }

    public final OptimizeModuleUi getModuleUi() {
        return this.moduleUi;
    }

    public final List<HealthCheckItemSnapshot> getItems() {
        return this.items;
    }
}
