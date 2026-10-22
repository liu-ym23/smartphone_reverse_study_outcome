package com.obric.security.health.ui;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptimizeCenterUiState.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/security/health/ui/OptimizeModuleUi;", "", "moduleId", "", "titleResId", "", "iconResId", "status", "Lcom/obric/security/health/ui/OptimizeModuleStatus;", "subtitle", "optimizedCount", "completedItemIds", "", "(Ljava/lang/String;IILcom/obric/security/health/ui/OptimizeModuleStatus;Ljava/lang/String;ILjava/util/Set;)V", "getCompletedItemIds", "()Ljava/util/Set;", "getIconResId", "()I", "getModuleId", "()Ljava/lang/String;", "getOptimizedCount", "getStatus", "()Lcom/obric/security/health/ui/OptimizeModuleStatus;", "getSubtitle", "getTitleResId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OptimizeModuleUi {
    private final Set<String> completedItemIds;
    private final int iconResId;
    private final String moduleId;
    private final int optimizedCount;
    private final OptimizeModuleStatus status;
    private final String subtitle;
    private final int titleResId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OptimizeModuleUi copy$default(OptimizeModuleUi r5, String r6, int r7, int r8, OptimizeModuleStatus r9, String r10, int r11, Set r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.moduleId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.titleResId;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.iconResId;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.status;
    L14:
        OptimizeModuleStatus r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.subtitle;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.optimizedCount;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.completedItemIds;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.moduleId;
    }

    public final int component2() {
        return this.titleResId;
    }

    public final int component3() {
        return this.iconResId;
    }

    public final OptimizeModuleStatus component4() {
        return this.status;
    }

    public final String component5() {
        return this.subtitle;
    }

    public final int component6() {
        return this.optimizedCount;
    }

    public final Set<String> component7() {
        return this.completedItemIds;
    }

    public final OptimizeModuleUi copy(String r9, int r10, int r11, OptimizeModuleStatus r12, String r13, int r14, Set<String> r15) {
        Intrinsics.checkNotNullParameter(r9, "moduleId");
        Intrinsics.checkNotNullParameter(r12, "status");
        Intrinsics.checkNotNullParameter(r13, "subtitle");
        Intrinsics.checkNotNullParameter(r15, "completedItemIds");
        return new OptimizeModuleUi(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OptimizeModuleUi) == false) goto L20;
        OptimizeModuleUi r4 = (OptimizeModuleUi) r3;
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L8;
        return false;
    L8:
        if (this.titleResId == r4.titleResId) goto L10;
        return false;
    L10:
        if (this.iconResId == r4.iconResId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subtitle, r4.subtitle) == true) goto L16;
        return false;
    L16:
        if (this.optimizedCount == r4.optimizedCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.completedItemIds, r4.completedItemIds) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r0 = this.moduleId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + Integer.hashCode(this.titleResId)) * 31) + Integer.hashCode(this.iconResId)) * 31;
        OptimizeModuleStatus r4 = this.status;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.subtitle;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.optimizedCount)) * 31;
        Set<String> r10 = this.completedItemIds;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
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
        return "OptimizeModuleUi(moduleId=" + this.moduleId + ", titleResId=" + this.titleResId + ", iconResId=" + this.iconResId + ", status=" + this.status + ", subtitle=" + this.subtitle + ", optimizedCount=" + this.optimizedCount + ", completedItemIds=" + this.completedItemIds + ")";
    }

    public OptimizeModuleUi(String r2, int r3, int r4, OptimizeModuleStatus r5, String r6, int r7, Set<String> r8) {
        Intrinsics.checkNotNullParameter(r2, "moduleId");
        Intrinsics.checkNotNullParameter(r5, "status");
        Intrinsics.checkNotNullParameter(r6, "subtitle");
        Intrinsics.checkNotNullParameter(r8, "completedItemIds");
        this.moduleId = r2;
        this.titleResId = r3;
        this.iconResId = r4;
        this.status = r5;
        this.subtitle = r6;
        this.optimizedCount = r7;
        this.completedItemIds = r8;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final OptimizeModuleStatus getStatus() {
        return this.status;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final int getOptimizedCount() {
        return this.optimizedCount;
    }

    public /* synthetic */ OptimizeModuleUi(String r10, int r11, int r12, OptimizeModuleStatus r13, String r14, int r15, Set r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 32) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r17 & 64) == 0) goto L9;
        Set r8 = SetsKt.emptySet();
    L10:
        this(r10, r11, r12, r13, r14, r7, r8);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    public final Set<String> getCompletedItemIds() {
        return this.completedItemIds;
    }
}
