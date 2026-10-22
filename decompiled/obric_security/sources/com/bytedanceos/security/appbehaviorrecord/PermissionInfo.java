package com.bytedanceos.security.appbehaviorrecord;

import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedanceos/security/appbehaviorrecord/PermissionInfo;", "", "permissionString", "", "foregroundDescription", "backgroundDescription", PushLog.KEY_TAG, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundDescription", "()Ljava/lang/String;", "getForegroundDescription", "getPermissionString", "getTag", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionInfo {
    private final String backgroundDescription;
    private final String foregroundDescription;
    private final String permissionString;
    private final String tag;

    public static /* synthetic */ PermissionInfo copy$default(PermissionInfo r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.permissionString;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.foregroundDescription;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.backgroundDescription;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.tag;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.permissionString;
    }

    public final String component2() {
        return this.foregroundDescription;
    }

    public final String component3() {
        return this.backgroundDescription;
    }

    public final String component4() {
        return this.tag;
    }

    public final PermissionInfo copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "foregroundDescription");
        return new PermissionInfo(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PermissionInfo) == false) goto L14;
        PermissionInfo r4 = (PermissionInfo) r3;
        if (Intrinsics.areEqual(this.permissionString, r4.permissionString) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.foregroundDescription, r4.foregroundDescription) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.backgroundDescription, r4.backgroundDescription) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tag, r4.tag) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.permissionString;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.foregroundDescription;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.backgroundDescription;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.tag;
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
        return "PermissionInfo(permissionString=" + this.permissionString + ", foregroundDescription=" + this.foregroundDescription + ", backgroundDescription=" + this.backgroundDescription + ", tag=" + this.tag + ")";
    }

    public PermissionInfo(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "foregroundDescription");
        this.permissionString = r2;
        this.foregroundDescription = r3;
        this.backgroundDescription = r4;
        this.tag = r5;
    }

    public /* synthetic */ PermissionInfo(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        String r8 = (String) null;
        r2 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        String r9 = (String) null;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        String r10 = (String) null;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public final String getPermissionString() {
        return this.permissionString;
    }

    public final String getForegroundDescription() {
        return this.foregroundDescription;
    }

    public final String getBackgroundDescription() {
        return this.backgroundDescription;
    }

    public final String getTag() {
        return this.tag;
    }
}
