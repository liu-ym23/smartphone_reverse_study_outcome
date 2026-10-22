package androidx.work.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemIdInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/model/SystemIdInfo;", "", "workSpecId", "", "generation", "", "systemId", "(Ljava/lang/String;II)V", "getGeneration", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemIdInfo {
    private final int generation;
    public final int systemId;
    public final String workSpecId;

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.workSpecId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.generation;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.systemId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "workSpecId");
        return new SystemIdInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemIdInfo) == true) goto L8;
        return false;
    L8:
        SystemIdInfo r6 = (SystemIdInfo) r5;
        if (Intrinsics.areEqual(this.workSpecId, r6.workSpecId) == true) goto L12;
        return false;
    L12:
        if (this.generation == r6.generation) goto L15;
        return false;
    L15:
        if (this.systemId == r6.systemId) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + Integer.hashCode(this.generation)) * 31) + Integer.hashCode(this.systemId);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ", systemId=" + this.systemId + ')';
    }

    public SystemIdInfo(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "workSpecId");
        this.workSpecId = r2;
        this.generation = r3;
        this.systemId = r4;
    }

    public final int getGeneration() {
        return this.generation;
    }
}
