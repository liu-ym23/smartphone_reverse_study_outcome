package com.bytedanceos.securitycenter.scan;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.ui.RiskAppUiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCheckRiskAppItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J]\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\u0013\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "", "key", "", "appInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", ApkVirusCheckProvider.KEY_VIRUS_TYPE, ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "virusName", "virusDescription", "isInstallationPackage", "", AccountInfoBundleKey.USER_ID, "(Ljava/lang/String;Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZI)V", "getAppInfo", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "()Z", "getKey", "()Ljava/lang/String;", "getUserId", "()I", "getVirusDescription", "getVirusName", "getVirusType", "getVirusTypeCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckRiskAppItem {
    private final RiskAppUiInfo appInfo;
    private final boolean isInstallationPackage;
    private final String key;
    private final int userId;
    private final String virusDescription;
    private final String virusName;
    private final String virusType;
    private final int virusTypeCode;

    public static /* synthetic */ SafeCheckRiskAppItem copy$default(SafeCheckRiskAppItem r9, String r10, RiskAppUiInfo r11, String r12, int r13, String r14, String r15, boolean r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.key;
    L7:
        if ((r18 & 2) == 0) goto L9;
        RiskAppUiInfo r3 = r9.appInfo;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.virusType;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.virusTypeCode;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.virusName;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.virusDescription;
    L27:
        if ((r18 & 64) == 0) goto L29;
        boolean r8 = r9.isInstallationPackage;
    L31:
        if ((r18 & 128) == 0) goto L33;
        int r1 = r9.userId;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final RiskAppUiInfo component2() {
        return this.appInfo;
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
        return this.isInstallationPackage;
    }

    public final int component8() {
        return this.userId;
    }

    public final SafeCheckRiskAppItem copy(String r11, RiskAppUiInfo r12, String r13, int r14, String r15, String r16, boolean r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, "appInfo");
        Intrinsics.checkNotNullParameter(r13, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        return new SafeCheckRiskAppItem(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SafeCheckRiskAppItem) == false) goto L22;
        SafeCheckRiskAppItem r4 = (SafeCheckRiskAppItem) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appInfo, r4.appInfo) == true) goto L10;
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
        if (this.isInstallationPackage == r4.isInstallationPackage) goto L20;
        return false;
    L20:
        if (this.userId == r4.userId) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RiskAppUiInfo r4 = this.appInfo;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.virusType;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.virusTypeCode)) * 31;
        String r10 = this.virusName;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.virusDescription;
        if (r13 == null) goto L21;
        r1 = r13.hashCode();
    L21:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.isInstallationPackage;
        ?? r16 = r15;
        if (r15 == false) goto L25;
        r16 = 1;
    L25:
        return ((r14 + r16) * 31) + Integer.hashCode(this.userId);
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
        return "SafeCheckRiskAppItem(key=" + this.key + ", appInfo=" + this.appInfo + ", virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ", virusName=" + this.virusName + ", virusDescription=" + this.virusDescription + ", isInstallationPackage=" + this.isInstallationPackage + ", userId=" + this.userId + ")";
    }

    public SafeCheckRiskAppItem(String r2, RiskAppUiInfo r3, String r4, int r5, String r6, String r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        Intrinsics.checkNotNullParameter(r4, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
        this.key = r2;
        this.appInfo = r3;
        this.virusType = r4;
        this.virusTypeCode = r5;
        this.virusName = r6;
        this.virusDescription = r7;
        this.isInstallationPackage = r8;
        this.userId = r9;
    }

    public final String getKey() {
        return this.key;
    }

    public final RiskAppUiInfo getAppInfo() {
        return this.appInfo;
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

    public final boolean isInstallationPackage() {
        return this.isInstallationPackage;
    }

    public final int getUserId() {
        return this.userId;
    }
}
