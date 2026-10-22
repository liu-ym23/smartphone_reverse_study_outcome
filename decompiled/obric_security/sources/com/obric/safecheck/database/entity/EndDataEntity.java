package com.obric.safecheck.database.entity;

import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EndDataEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/safecheck/database/entity/EndDataEntity;", "", SlardarConfigConsts.CONFIG_ID, "", "enddata", "", "(ILjava/lang/String;)V", "getEnddata", "()Ljava/lang/String;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class EndDataEntity {
    private final String enddata;
    private final int id;

    public static /* synthetic */ EndDataEntity copy$default(EndDataEntity r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enddata;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.enddata;
    }

    public final EndDataEntity copy(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "enddata");
        return new EndDataEntity(r1, r2);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof EndDataEntity) == false) goto L10;
        EndDataEntity r4 = (EndDataEntity) r3;
        if (this.id == r4.id) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enddata, r4.enddata) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.id) * 31;
        String r1 = this.enddata;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "EndDataEntity(id=" + this.id + ", enddata=" + this.enddata + ")";
    }

    public EndDataEntity(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "enddata");
        this.id = r2;
        this.enddata = r3;
    }

    public /* synthetic */ EndDataEntity(int r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 1;
    L5:
        this(r1, r2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getEnddata() {
        return this.enddata;
    }
}
