package com.obric.security.safecheckapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApkInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0019H\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006$"}, d2 = {"Lcom/obric/security/safecheckapi/ApkInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "packageName", "", "signatureMd5", "signatureSha1", "signatureSha256", "apkMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApkMd5", "()Ljava/lang/String;", "getPackageName", "getSignatureMd5", "getSignatureSha1", "getSignatureSha256", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "safecheckapi_release"}, k = 1, mv = {1, 4, 3})
public final class ApkInfo implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String apkMd5;
    private final String packageName;
    private final String signatureMd5;
    private final String signatureSha1;
    private final String signatureSha256;

    /* JADX INFO: compiled from: ApkInfo.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/security/safecheckapi/ApkInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/security/safecheckapi/ApkInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/security/safecheckapi/ApkInfo;", "safecheckapi_release"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<ApkInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ApkInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ApkInfo[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApkInfo createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ApkInfo(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApkInfo[] newArray(int r1) {
            return new ApkInfo[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ApkInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ApkInfo copy$default(ApkInfo r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.packageName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.signatureMd5;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.signatureSha1;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.signatureSha256;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.apkMd5;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.signatureMd5;
    }

    public final String component3() {
        return this.signatureSha1;
    }

    public final String component4() {
        return this.signatureSha256;
    }

    public final String component5() {
        return this.apkMd5;
    }

    public final ApkInfo copy(String r7, String r8, String r9, String r10, String r11) {
        return new ApkInfo(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ApkInfo) == false) goto L16;
        ApkInfo r4 = (ApkInfo) r3;
        if (Intrinsics.areEqual(this.packageName, r4.packageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.signatureMd5, r4.signatureMd5) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.signatureSha1, r4.signatureSha1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signatureSha256, r4.signatureSha256) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.apkMd5, r4.apkMd5) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.packageName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.signatureMd5;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.signatureSha1;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.signatureSha256;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.apkMd5;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "ApkInfo(packageName=" + this.packageName + ", signatureMd5=" + this.signatureMd5 + ", signatureSha1=" + this.signatureSha1 + ", signatureSha256=" + this.signatureSha256 + ", apkMd5=" + this.apkMd5 + ")";
    }

    public ApkInfo(String r1, String r2, String r3, String r4, String r5) {
        this.packageName = r1;
        this.signatureMd5 = r2;
        this.signatureSha1 = r3;
        this.signatureSha256 = r4;
        this.apkMd5 = r5;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSignatureMd5() {
        return this.signatureMd5;
    }

    public final String getSignatureSha1() {
        return this.signatureSha1;
    }

    public final String getSignatureSha256() {
        return this.signatureSha256;
    }

    public /* synthetic */ ApkInfo(String r2, String r3, String r4, String r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = "";
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getApkMd5() {
        return this.apkMd5;
    }

    public ApkInfo(Parcel r8) {
        Intrinsics.checkNotNullParameter(r8, "parcel");
        this(r8.readString(), r8.readString(), r8.readString(), r8.readString(), r8.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.packageName);
        r1.writeString(this.signatureMd5);
        r1.writeString(this.signatureSha1);
        r1.writeString(this.signatureSha256);
        r1.writeString(this.apkMd5);
    }
}
