package com.bytedanceos.securitycenter.scan;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusDbScanDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/VirusDbRecord;", "", ApkVirusCheckProvider.KEY_PKG, "", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "virusName", "virusDescription", "controlled", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getControlled", "()Z", "getPkg", "()Ljava/lang/String;", "getVirusDescription", "getVirusName", "getVirusTypeCode", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusDbRecord {
    private final boolean controlled;
    private final String pkg;
    private final String virusDescription;
    private final String virusName;
    private final int virusTypeCode;

    public static /* synthetic */ VirusDbRecord copy$default(VirusDbRecord r3, String r4, int r5, String r6, String r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.pkg;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.virusTypeCode;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.virusName;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.virusDescription;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.controlled;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.pkg;
    }

    public final int component2() {
        return this.virusTypeCode;
    }

    public final String component3() {
        return this.virusName;
    }

    public final String component4() {
        return this.virusDescription;
    }

    public final boolean component5() {
        return this.controlled;
    }

    public final VirusDbRecord copy(String r7, int r8, String r9, String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
        return new VirusDbRecord(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof VirusDbRecord) == false) goto L16;
        VirusDbRecord r4 = (VirusDbRecord) r3;
        if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
        return false;
    L8:
        if (this.virusTypeCode == r4.virusTypeCode) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.virusName, r4.virusName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.virusDescription, r4.virusDescription) == true) goto L14;
        return false;
    L14:
        if (this.controlled == r4.controlled) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.pkg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.virusTypeCode)) * 31;
        String r4 = this.virusName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.virusDescription;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.controlled;
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
        return "VirusDbRecord(pkg=" + this.pkg + ", virusTypeCode=" + this.virusTypeCode + ", virusName=" + this.virusName + ", virusDescription=" + this.virusDescription + ", controlled=" + this.controlled + ")";
    }

    public VirusDbRecord(String r2, int r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        this.pkg = r2;
        this.virusTypeCode = r3;
        this.virusName = r4;
        this.virusDescription = r5;
        this.controlled = r6;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getVirusTypeCode() {
        return this.virusTypeCode;
    }

    public final String getVirusName() {
        return this.virusName;
    }

    public final String getVirusDescription() {
        return this.virusDescription;
    }

    public final boolean getControlled() {
        return this.controlled;
    }
}
