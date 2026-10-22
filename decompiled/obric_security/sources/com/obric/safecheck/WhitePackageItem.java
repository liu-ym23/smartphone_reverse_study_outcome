package com.obric.safecheck;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AntiFraudWhiteListSettings.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/safecheck/WhitePackageItem;", "", "pkgName", "", "md5", "sha1", "sha256", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMd5", "()Ljava/lang/String;", "getPkgName", "getSha1", "getSha256", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WhitePackageItem {

    @SerializedName("signatureMd5")
    private final String md5;

    @SerializedName("pkgName")
    private final String pkgName;

    @SerializedName("signatureSha1")
    private final String sha1;

    @SerializedName("signatureSha256")
    private final String sha256;

    public static /* synthetic */ WhitePackageItem copy$default(WhitePackageItem r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.pkgName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.md5;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sha1;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.sha256;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.pkgName;
    }

    public final String component2() {
        return this.md5;
    }

    public final String component3() {
        return this.sha1;
    }

    public final String component4() {
        return this.sha256;
    }

    public final WhitePackageItem copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "pkgName");
        return new WhitePackageItem(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WhitePackageItem) == false) goto L14;
        WhitePackageItem r4 = (WhitePackageItem) r3;
        if (Intrinsics.areEqual(this.pkgName, r4.pkgName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.md5, r4.md5) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sha1, r4.sha1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sha256, r4.sha256) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.pkgName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.md5;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sha1;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sha256;
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
        return "WhitePackageItem(pkgName=" + this.pkgName + ", md5=" + this.md5 + ", sha1=" + this.sha1 + ", sha256=" + this.sha256 + ")";
    }

    public WhitePackageItem(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "pkgName");
        this.pkgName = r2;
        this.md5 = r3;
        this.sha1 = r4;
        this.sha256 = r5;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSha1() {
        return this.sha1;
    }

    public final String getSha256() {
        return this.sha256;
    }
}
