package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.constant.PerfConsts;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GxbUpdateItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateItem;", "", "fileName", "", "downloadUrl", "md5", PerfConsts.PERF_DISK_FILE_SIZE, "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDownloadUrl", "()Ljava/lang/String;", "getFileName", "getMd5", "getSize", "getVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbUpdateItem {

    @SerializedName("download_url")
    private final String downloadUrl;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("md5")
    private final String md5;

    @SerializedName(PerfConsts.PERF_DISK_FILE_SIZE)
    private final String size;

    @SerializedName("version")
    private final String version;

    public GxbUpdateItem() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GxbUpdateItem copy$default(GxbUpdateItem r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.fileName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.downloadUrl;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.md5;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.size;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.version;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.fileName;
    }

    public final String component2() {
        return this.downloadUrl;
    }

    public final String component3() {
        return this.md5;
    }

    public final String component4() {
        return this.size;
    }

    public final String component5() {
        return this.version;
    }

    public final GxbUpdateItem copy(String r7, String r8, String r9, String r10, String r11) {
        return new GxbUpdateItem(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof GxbUpdateItem) == false) goto L16;
        GxbUpdateItem r4 = (GxbUpdateItem) r3;
        if (Intrinsics.areEqual(this.fileName, r4.fileName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.downloadUrl, r4.downloadUrl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.md5, r4.md5) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.size, r4.size) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.version, r4.version) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.fileName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.downloadUrl;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.md5;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.size;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.version;
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
        return "GxbUpdateItem(fileName=" + this.fileName + ", downloadUrl=" + this.downloadUrl + ", md5=" + this.md5 + ", size=" + this.size + ", version=" + this.version + ")";
    }

    public GxbUpdateItem(String r1, String r2, String r3, String r4, String r5) {
        this.fileName = r1;
        this.downloadUrl = r2;
        this.md5 = r3;
        this.size = r4;
        this.version = r5;
    }

    public /* synthetic */ GxbUpdateItem(String r4, String r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        String r0 = null;
        if ((r9 & 1) == 0) goto L6;
        String r11 = (String) null;
        r4 = null;
    L6:
        if ((r9 & 2) == 0) goto L8;
        String r12 = (String) null;
        String r13 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        String r14 = (String) null;
        String r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        String r15 = (String) null;
        String r2 = null;
    L18:
        if ((r9 & 16) == 0) goto L20;
        String r16 = (String) null;
    L21:
        this(r4, r13, r1, r2, r0);
        return;
    L20:
        r0 = r8;
        goto L21
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r13 = r5;
        goto L10
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getVersion() {
        return this.version;
    }
}
