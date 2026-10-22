package com.obric.safecheck.data;

import com.obric.safecheck.database.entity.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Directory.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/data/Directory;", "Lcom/obric/safecheck/database/entity/Item;", "endDate", "", "(Ljava/lang/String;)V", "getEndDate", "()Ljava/lang/String;", "setEndDate", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class Directory implements Item {
    private String endDate;

    /* JADX WARN: Multi-variable type inference failed */
    public Directory() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Directory copy$default(Directory r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.endDate;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.endDate;
    }

    public final Directory copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "endDate");
        return new Directory(r1);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof Directory) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.endDate, ((Directory) r2).endDate) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        String r0 = this.endDate;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "Directory(endDate=" + this.endDate + ")";
    }

    public Directory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "endDate");
        this.endDate = r2;
    }

    public /* synthetic */ Directory(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final void setEndDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endDate = r2;
    }
}
