package com.obric.security.health.score.task;

import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthModulePresentation;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B_\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003Jo\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/security/health/score/task/HealthTaskPresentations;", "", "allModules", "", "Lcom/obric/security/health/model/HealthModulePresentation;", "byId", "", "", "Lcom/obric/security/health/model/HealthCheckItemPresentation;", "visibleModules", "executableItems", "visibleItemIds", "", "grantedHiddenItems", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Set;Ljava/util/List;)V", "getAllModules", "()Ljava/util/List;", "getById", "()Ljava/util/Map;", "getExecutableItems", "getGrantedHiddenItems", "getVisibleItemIds", "()Ljava/util/Set;", "getVisibleModules", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthTaskPresentations {
    public static final Companion Companion = null;
    private static final HealthTaskPresentations EMPTY = null;
    private final List<HealthModulePresentation> allModules;
    private final Map<String, HealthCheckItemPresentation> byId;
    private final List<HealthCheckItemPresentation> executableItems;
    private final List<HealthCheckItemPresentation> grantedHiddenItems;
    private final Set<String> visibleItemIds;
    private final List<HealthModulePresentation> visibleModules;

    /* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/score/task/HealthTaskPresentations$Companion;", "", "()V", "EMPTY", "Lcom/obric/security/health/score/task/HealthTaskPresentations;", "getEMPTY", "()Lcom/obric/security/health/score/task/HealthTaskPresentations;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final HealthTaskPresentations getEMPTY() {
            return HealthTaskPresentations.access$getEMPTY$cp();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthTaskPresentations copy$default(HealthTaskPresentations r4, List r5, Map r6, List r7, List r8, Set r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.allModules;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.byId;
    L8:
        Map r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.visibleModules;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.executableItems;
    L14:
        List r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.visibleItemIds;
    L17:
        Set r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.grantedHiddenItems;
    L20:
        List r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final List<HealthModulePresentation> component1() {
        return this.allModules;
    }

    public final Map<String, HealthCheckItemPresentation> component2() {
        return this.byId;
    }

    public final List<HealthModulePresentation> component3() {
        return this.visibleModules;
    }

    public final List<HealthCheckItemPresentation> component4() {
        return this.executableItems;
    }

    public final Set<String> component5() {
        return this.visibleItemIds;
    }

    public final List<HealthCheckItemPresentation> component6() {
        return this.grantedHiddenItems;
    }

    public final HealthTaskPresentations copy(List<HealthModulePresentation> r8, Map<String, HealthCheckItemPresentation> r9, List<HealthModulePresentation> r10, List<HealthCheckItemPresentation> r11, Set<String> r12, List<HealthCheckItemPresentation> r13) {
        Intrinsics.checkNotNullParameter(r8, "allModules");
        Intrinsics.checkNotNullParameter(r9, "byId");
        Intrinsics.checkNotNullParameter(r10, "visibleModules");
        Intrinsics.checkNotNullParameter(r11, "executableItems");
        Intrinsics.checkNotNullParameter(r12, "visibleItemIds");
        Intrinsics.checkNotNullParameter(r13, "grantedHiddenItems");
        return new HealthTaskPresentations(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthTaskPresentations) == false) goto L18;
        HealthTaskPresentations r4 = (HealthTaskPresentations) r3;
        if (Intrinsics.areEqual(this.allModules, r4.allModules) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.byId, r4.byId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.visibleModules, r4.visibleModules) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.executableItems, r4.executableItems) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.visibleItemIds, r4.visibleItemIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.grantedHiddenItems, r4.grantedHiddenItems) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        List<HealthModulePresentation> r0 = this.allModules;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, HealthCheckItemPresentation> r4 = this.byId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<HealthModulePresentation> r7 = this.visibleModules;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<HealthCheckItemPresentation> r10 = this.executableItems;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Set<String> r13 = this.visibleItemIds;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<HealthCheckItemPresentation> r16 = this.grantedHiddenItems;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthTaskPresentations(allModules=" + this.allModules + ", byId=" + this.byId + ", visibleModules=" + this.visibleModules + ", executableItems=" + this.executableItems + ", visibleItemIds=" + this.visibleItemIds + ", grantedHiddenItems=" + this.grantedHiddenItems + ")";
    }

    public HealthTaskPresentations(List<HealthModulePresentation> r2, Map<String, HealthCheckItemPresentation> r3, List<HealthModulePresentation> r4, List<HealthCheckItemPresentation> r5, Set<String> r6, List<HealthCheckItemPresentation> r7) {
        Intrinsics.checkNotNullParameter(r2, "allModules");
        Intrinsics.checkNotNullParameter(r3, "byId");
        Intrinsics.checkNotNullParameter(r4, "visibleModules");
        Intrinsics.checkNotNullParameter(r5, "executableItems");
        Intrinsics.checkNotNullParameter(r6, "visibleItemIds");
        Intrinsics.checkNotNullParameter(r7, "grantedHiddenItems");
        this.allModules = r2;
        this.byId = r3;
        this.visibleModules = r4;
        this.executableItems = r5;
        this.visibleItemIds = r6;
        this.grantedHiddenItems = r7;
    }

    public static final /* synthetic */ HealthTaskPresentations access$getEMPTY$cp() {
        return EMPTY;
    }

    public final List<HealthModulePresentation> getAllModules() {
        return this.allModules;
    }

    public final Map<String, HealthCheckItemPresentation> getById() {
        return this.byId;
    }

    public final List<HealthModulePresentation> getVisibleModules() {
        return this.visibleModules;
    }

    public final List<HealthCheckItemPresentation> getExecutableItems() {
        return this.executableItems;
    }

    public final Set<String> getVisibleItemIds() {
        return this.visibleItemIds;
    }

    public final List<HealthCheckItemPresentation> getGrantedHiddenItems() {
        return this.grantedHiddenItems;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new HealthTaskPresentations(CollectionsKt.emptyList(), MapsKt.emptyMap(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), SetsKt.emptySet(), CollectionsKt.emptyList());
    }
}
