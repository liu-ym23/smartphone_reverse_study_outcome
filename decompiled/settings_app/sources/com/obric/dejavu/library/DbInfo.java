package com.obric.dejavu.library;

import android.icu.text.PluralRules;
import kotlin.Metadata;

/* JADX INFO: compiled from: DbInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/obric/dejavu/library/DbInfo;", "", "dims", "", "kvType", "viewType", "bankType", "metricType", "(IIIII)V", "getBankType", "()I", "setBankType", "(I)V", "getDims", "setDims", "getKvType", "setKvType", "getMetricType", "setMetricType", "getViewType", "setViewType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbInfo {
    private int bankType;
    private int dims;
    private int kvType;
    private int metricType;
    private int viewType;

    public static /* synthetic */ DbInfo copy$default(DbInfo r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.dims;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.kvType;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.viewType;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bankType;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.metricType;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.dims;
    }

    public final int component2() {
        return this.kvType;
    }

    public final int component3() {
        return this.viewType;
    }

    public final int component4() {
        return this.bankType;
    }

    public final int component5() {
        return this.metricType;
    }

    public final DbInfo copy(int r7, int r8, int r9, int r10, int r11) {
        return new DbInfo(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DbInfo) == true) goto L8;
        return false;
    L8:
        DbInfo r6 = (DbInfo) r5;
        if (this.dims == r6.dims) goto L12;
        return false;
    L12:
        if (this.kvType == r6.kvType) goto L15;
        return false;
    L15:
        if (this.viewType == r6.viewType) goto L18;
        return false;
    L18:
        if (this.bankType == r6.bankType) goto L21;
        return false;
    L21:
        if (this.metricType == r6.metricType) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.dims) * 31) + Integer.hashCode(this.kvType)) * 31) + Integer.hashCode(this.viewType)) * 31) + Integer.hashCode(this.bankType)) * 31) + Integer.hashCode(this.metricType);
    }

    public String toString() {
        return "DbInfo(dims=" + this.dims + ", kvType=" + this.kvType + ", viewType=" + this.viewType + ", bankType=" + this.bankType + ", metricType=" + this.metricType + ')';
    }

    public DbInfo(int r1, int r2, int r3, int r4, int r5) {
        this.dims = r1;
        this.kvType = r2;
        this.viewType = r3;
        this.bankType = r4;
        this.metricType = r5;
    }

    public final int getDims() {
        return this.dims;
    }

    public final void setDims(int r1) {
        this.dims = r1;
    }

    public final int getKvType() {
        return this.kvType;
    }

    public final void setKvType(int r1) {
        this.kvType = r1;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public final void setViewType(int r1) {
        this.viewType = r1;
    }

    public final int getBankType() {
        return this.bankType;
    }

    public final void setBankType(int r1) {
        this.bankType = r1;
    }

    public final int getMetricType() {
        return this.metricType;
    }

    public final void setMetricType(int r1) {
        this.metricType = r1;
    }
}
