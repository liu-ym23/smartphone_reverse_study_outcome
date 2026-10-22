package com.obric.security.health.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/security/health/model/HealthTaskProgressEvent;", "", "itemId", "", "title", "moduleId", "taskPassed", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getItemId", "()Ljava/lang/String;", "getModuleId", "getTaskPassed", "()Z", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthTaskProgressEvent {
    private final String itemId;
    private final String moduleId;
    private final boolean taskPassed;
    private final String title;

    public static /* synthetic */ HealthTaskProgressEvent copy$default(HealthTaskProgressEvent r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.itemId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.moduleId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.taskPassed;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.itemId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.moduleId;
    }

    public final boolean component4() {
        return this.taskPassed;
    }

    public final HealthTaskProgressEvent copy(String r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "moduleId");
        return new HealthTaskProgressEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthTaskProgressEvent) == false) goto L14;
        HealthTaskProgressEvent r4 = (HealthTaskProgressEvent) r3;
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L12;
        return false;
    L12:
        if (this.taskPassed == r4.taskPassed) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.moduleId;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.taskPassed;
        ?? r10 = r9;
        if (r9 == false) goto L17;
        r10 = 1;
    L17:
        return r8 + r10;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "HealthTaskProgressEvent(itemId=" + this.itemId + ", title=" + this.title + ", moduleId=" + this.moduleId + ", taskPassed=" + this.taskPassed + ")";
    }

    public HealthTaskProgressEvent(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "moduleId");
        this.itemId = r2;
        this.title = r3;
        this.moduleId = r4;
        this.taskPassed = r5;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final boolean getTaskPassed() {
        return this.taskPassed;
    }
}
