package com.obric.safecheck.riskcontrol.api.model;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanResultRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JS\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006#"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/model/ScanResultRecord;", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", ApkVirusCheckProvider.KEY_VIRUS_TYPE, ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "virusName", "virusDescription", "controlled", "", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getControlled", "()Z", "getPkg", "()Ljava/lang/String;", "getUserId", "()I", "getVirusDescription", "getVirusName", "getVirusType", "getVirusTypeCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ScanResultRecord {
    private final boolean controlled;
    private final String pkg;
    private final int userId;
    private final String virusDescription;
    private final String virusName;
    private final String virusType;
    private final int virusTypeCode;

    public static /* synthetic */ ScanResultRecord copy$default(ScanResultRecord r5, String r6, int r7, String r8, int r9, String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.pkg;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.userId;
    L8:
        int r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.virusType;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.virusTypeCode;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.virusName;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.virusDescription;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.controlled;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.pkg;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.virusType;
    }

    public final int component4() {
        return this.virusTypeCode;
    }

    public final String component5() {
        return this.virusName;
    }

    public final String component6() {
        return this.virusDescription;
    }

    public final boolean component7() {
        return this.controlled;
    }

    public final ScanResultRecord copy(String r9, int r10, String r11, int r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r11, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        return new ScanResultRecord(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScanResultRecord) == false) goto L20;
        ScanResultRecord r4 = (ScanResultRecord) r3;
        if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
        return false;
    L8:
        if (this.userId == r4.userId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.virusType, r4.virusType) == true) goto L12;
        return false;
    L12:
        if (this.virusTypeCode == r4.virusTypeCode) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.virusName, r4.virusName) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.virusDescription, r4.virusDescription) == true) goto L18;
        return false;
    L18:
        if (this.controlled == r4.controlled) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        String r0 = this.pkg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.userId)) * 31;
        String r4 = this.virusType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.virusTypeCode)) * 31;
        String r7 = this.virusName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.virusDescription;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        int r11 = (r9 + r1) * 31;
        boolean r12 = this.controlled;
        ?? r13 = r12;
        if (r12 == false) goto L21;
        r13 = 1;
    L21:
        return r11 + r13;
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
        return "ScanResultRecord(pkg=" + this.pkg + ", userId=" + this.userId + ", virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ", virusName=" + this.virusName + ", virusDescription=" + this.virusDescription + ", controlled=" + this.controlled + ")";
    }

    public ScanResultRecord(String r2, int r3, String r4, int r5, String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r4, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        this.pkg = r2;
        this.userId = r3;
        this.virusType = r4;
        this.virusTypeCode = r5;
        this.virusName = r6;
        this.virusDescription = r7;
        this.controlled = r8;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getVirusType() {
        return this.virusType;
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
