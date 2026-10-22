package com.obric.safecheck.riskcontrol.api.model;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskAppControlRecord.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003J\t\u0010#\u001a\u00020\u000fHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00062"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/model/RiskAppControlRecord;", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "appName", "riskType", "riskLevel", "riskDesc", "installIdentity", "controlStatus", "Lcom/obric/safecheck/riskcontrol/api/model/RiskControlStatus;", "controlFlags", "createdAt", "", "updatedAt", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/safecheck/riskcontrol/api/model/RiskControlStatus;IJJ)V", "getAppName", "()Ljava/lang/String;", "getControlFlags", "()I", "getControlStatus", "()Lcom/obric/safecheck/riskcontrol/api/model/RiskControlStatus;", "getCreatedAt", "()J", "getInstallIdentity", "getPkg", "getRiskDesc", "getRiskLevel", "getRiskType", "getUpdatedAt", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppControlRecord {
    private final String appName;
    private final int controlFlags;
    private final RiskControlStatus controlStatus;
    private final long createdAt;
    private final String installIdentity;
    private final String pkg;
    private final String riskDesc;
    private final String riskLevel;
    private final String riskType;
    private final long updatedAt;
    private final int userId;

    public static /* synthetic */ RiskAppControlRecord copy$default(RiskAppControlRecord r15, String r16, int r17, String r18, String r19, String r20, String r21, String r22, RiskControlStatus r23, int r24, long r25, long r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r2 = r15.pkg;
    L7:
        if ((r29 & 2) == 0) goto L9;
        int r3 = r15.userId;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r4 = r15.appName;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r5 = r15.riskType;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r6 = r15.riskLevel;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r7 = r15.riskDesc;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r8 = r15.installIdentity;
    L31:
        if ((r29 & 128) == 0) goto L33;
        RiskControlStatus r9 = r15.controlStatus;
    L35:
        if ((r29 & 256) == 0) goto L37;
        int r10 = r15.controlFlags;
    L39:
        if ((r29 & 512) == 0) goto L41;
        long r11 = r15.createdAt;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        long r13 = r15.updatedAt;
    L47:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13);
    L45:
        r13 = r27;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.pkg;
    }

    public final long component10() {
        return this.createdAt;
    }

    public final long component11() {
        return this.updatedAt;
    }

    public final int component2() {
        return this.userId;
    }

    public final String component3() {
        return this.appName;
    }

    public final String component4() {
        return this.riskType;
    }

    public final String component5() {
        return this.riskLevel;
    }

    public final String component6() {
        return this.riskDesc;
    }

    public final String component7() {
        return this.installIdentity;
    }

    public final RiskControlStatus component8() {
        return this.controlStatus;
    }

    public final int component9() {
        return this.controlFlags;
    }

    public final RiskAppControlRecord copy(String r16, int r17, String r18, String r19, String r20, String r21, String r22, RiskControlStatus r23, int r24, long r25, long r27) {
        Intrinsics.checkNotNullParameter(r16, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r18, "appName");
        Intrinsics.checkNotNullParameter(r19, "riskType");
        Intrinsics.checkNotNullParameter(r20, "riskLevel");
        Intrinsics.checkNotNullParameter(r21, "riskDesc");
        Intrinsics.checkNotNullParameter(r22, "installIdentity");
        Intrinsics.checkNotNullParameter(r23, "controlStatus");
        return new RiskAppControlRecord(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof RiskAppControlRecord) == false) goto L28;
        RiskAppControlRecord r6 = (RiskAppControlRecord) r5;
        if (Intrinsics.areEqual(this.pkg, r6.pkg) == true) goto L8;
        return false;
    L8:
        if (this.userId == r6.userId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.riskType, r6.riskType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.riskLevel, r6.riskLevel) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.riskDesc, r6.riskDesc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.installIdentity, r6.installIdentity) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.controlStatus, r6.controlStatus) == true) goto L22;
        return false;
    L22:
        if (this.controlFlags == r6.controlFlags) goto L24;
        return false;
    L24:
        if (this.createdAt == r6.createdAt) goto L26;
        return false;
    L26:
        if (this.updatedAt == r6.updatedAt) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        String r0 = this.pkg;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.userId)) * 31;
        String r4 = this.appName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.riskType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.riskLevel;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.riskDesc;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.installIdentity;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        RiskControlStatus r19 = this.controlStatus;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return ((((((r18 + r1) * 31) + Integer.hashCode(this.controlFlags)) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
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
        return "RiskAppControlRecord(pkg=" + this.pkg + ", userId=" + this.userId + ", appName=" + this.appName + ", riskType=" + this.riskType + ", riskLevel=" + this.riskLevel + ", riskDesc=" + this.riskDesc + ", installIdentity=" + this.installIdentity + ", controlStatus=" + this.controlStatus + ", controlFlags=" + this.controlFlags + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public RiskAppControlRecord(String r2, int r3, String r4, String r5, String r6, String r7, String r8, RiskControlStatus r9, int r10, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r4, "appName");
        Intrinsics.checkNotNullParameter(r5, "riskType");
        Intrinsics.checkNotNullParameter(r6, "riskLevel");
        Intrinsics.checkNotNullParameter(r7, "riskDesc");
        Intrinsics.checkNotNullParameter(r8, "installIdentity");
        Intrinsics.checkNotNullParameter(r9, "controlStatus");
        this.pkg = r2;
        this.userId = r3;
        this.appName = r4;
        this.riskType = r5;
        this.riskLevel = r6;
        this.riskDesc = r7;
        this.installIdentity = r8;
        this.controlStatus = r9;
        this.controlFlags = r10;
        this.createdAt = r11;
        this.updatedAt = r13;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getRiskType() {
        return this.riskType;
    }

    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public final String getRiskDesc() {
        return this.riskDesc;
    }

    public final String getInstallIdentity() {
        return this.installIdentity;
    }

    public final RiskControlStatus getControlStatus() {
        return this.controlStatus;
    }

    public final int getControlFlags() {
        return this.controlFlags;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
