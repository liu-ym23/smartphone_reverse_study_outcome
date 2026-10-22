package com.obric.safecheck.riskcontrol.ui;

import com.bytedanceos.preventdisturb.Contact;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RiskAppListViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/safecheck/riskcontrol/ui/RiskAppListItemUiState;", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", Contact.CONTENT_SCHEME, "Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "appInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "isInstallationPackage", "", "(Ljava/lang/String;ILcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;Z)V", "getAppInfo", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "getContent", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "()Z", "getPkg", "()Ljava/lang/String;", "getUserId", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskAppListItemUiState {
    private final RiskAppUiInfo appInfo;
    private final RiskAppContentUiInfo content;
    private final boolean isInstallationPackage;
    private final String pkg;
    private final int userId;

    public static /* synthetic */ RiskAppListItemUiState copy$default(RiskAppListItemUiState r3, String r4, int r5, RiskAppContentUiInfo r6, RiskAppUiInfo r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.pkg;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.userId;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.content;
    L11:
        RiskAppContentUiInfo r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.appInfo;
    L14:
        RiskAppUiInfo r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.isInstallationPackage;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.pkg;
    }

    public final int component2() {
        return this.userId;
    }

    public final RiskAppContentUiInfo component3() {
        return this.content;
    }

    public final RiskAppUiInfo component4() {
        return this.appInfo;
    }

    public final boolean component5() {
        return this.isInstallationPackage;
    }

    public final RiskAppListItemUiState copy(String r7, int r8, RiskAppContentUiInfo r9, RiskAppUiInfo r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r9, Contact.CONTENT_SCHEME);
        Intrinsics.checkNotNullParameter(r10, "appInfo");
        return new RiskAppListItemUiState(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RiskAppListItemUiState) == false) goto L16;
        RiskAppListItemUiState r4 = (RiskAppListItemUiState) r3;
        if (Intrinsics.areEqual(this.pkg, r4.pkg) == true) goto L8;
        return false;
    L8:
        if (this.userId == r4.userId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appInfo, r4.appInfo) == true) goto L14;
        return false;
    L14:
        if (this.isInstallationPackage == r4.isInstallationPackage) goto L25;
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
        int r3 = ((r2 * 31) + Integer.hashCode(this.userId)) * 31;
        RiskAppContentUiInfo r4 = this.content;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        RiskAppUiInfo r7 = this.appInfo;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.isInstallationPackage;
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
        return "RiskAppListItemUiState(pkg=" + this.pkg + ", userId=" + this.userId + ", content=" + this.content + ", appInfo=" + this.appInfo + ", isInstallationPackage=" + this.isInstallationPackage + ")";
    }

    public RiskAppListItemUiState(String r2, int r3, RiskAppContentUiInfo r4, RiskAppUiInfo r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Intrinsics.checkNotNullParameter(r4, Contact.CONTENT_SCHEME);
        Intrinsics.checkNotNullParameter(r5, "appInfo");
        this.pkg = r2;
        this.userId = r3;
        this.content = r4;
        this.appInfo = r5;
        this.isInstallationPackage = r6;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final RiskAppContentUiInfo getContent() {
        return this.content;
    }

    public final RiskAppUiInfo getAppInfo() {
        return this.appInfo;
    }

    public final boolean isInstallationPackage() {
        return this.isInstallationPackage;
    }
}
