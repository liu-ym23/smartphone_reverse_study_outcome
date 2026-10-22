package com.obric.safecheck.riskcontrol.domain.usecase;

import com.bytedanceos.preventdisturb.Contact;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.safecheck.riskcontrol.api.model.ScanResultRecord;
import com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository;
import com.obric.safecheck.riskcontrol.ui.RiskAppContentUiInfo;
import com.obric.safecheck.riskcontrol.ui.RiskAppUiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LoadRiskAppsUseCase.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B \u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0005\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0005\u0012!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u0006\u0010\u0013\u001a\u00020\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0006H\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ \u0010\u001d\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0015H\u0002J\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002R)\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase;", "", "repository", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;", "controlFlagsReader", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "installedAppInfoResolver", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "archiveAppInfoResolver", "Lkotlin/Function1;", "apkPath", "(Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "countControlled", "countUncontrolled", "isConfirmedRisk", "", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "isInstallationPackage", "loadControlledApps", "", "Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase$ListItem;", "loadDetail", "Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase$Detail;", "resolveAppInfo", "installationPackage", "toContentUiInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "Lcom/obric/safecheck/riskcontrol/api/model/ScanResultRecord;", "Companion", "Detail", "ListItem", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadRiskAppsUseCase {
    private static final Companion Companion = null;

    @Deprecated
    public static final int VIRUS_CODE_OTHER = 2;

    @Deprecated
    public static final int VIRUS_CODE_SEX = 1;
    private final Function1<String, RiskAppUiInfo> archiveAppInfoResolver;
    private final Function2<String, Integer, Integer> controlFlagsReader;
    private final Function2<String, Integer, RiskAppUiInfo> installedAppInfoResolver;
    private final ScanResultRepository repository;

    /* JADX INFO: compiled from: LoadRiskAppsUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase$Companion;", "", "()V", "VIRUS_CODE_OTHER", "", "VIRUS_CODE_SEX", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: LoadRiskAppsUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase$Detail;", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", Contact.CONTENT_SCHEME, "Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "appInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "controlFlags", "isInstallationPackage", "", "(Ljava/lang/String;ILcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;IZ)V", "getAppInfo", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "getContent", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "getControlFlags", "()I", "()Z", "getPkg", "()Ljava/lang/String;", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Detail {
        private final RiskAppUiInfo appInfo;
        private final RiskAppContentUiInfo content;
        private final int controlFlags;
        private final boolean isInstallationPackage;
        private final String pkg;
        private final int userId;

        public static /* synthetic */ Detail copy$default(Detail r4, String r5, int r6, RiskAppContentUiInfo r7, RiskAppUiInfo r8, int r9, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.pkg;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.userId;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.content;
        L11:
            RiskAppContentUiInfo r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.appInfo;
        L14:
            RiskAppUiInfo r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.controlFlags;
        L17:
            int r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.isInstallationPackage;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
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

        public final int component5() {
            return this.controlFlags;
        }

        public final boolean component6() {
            return this.isInstallationPackage;
        }

        public final Detail copy(String r8, int r9, RiskAppContentUiInfo r10, RiskAppUiInfo r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r8, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r10, Contact.CONTENT_SCHEME);
            Intrinsics.checkNotNullParameter(r11, "appInfo");
            return new Detail(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Detail) == false) goto L18;
            Detail r4 = (Detail) r3;
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
            if (this.controlFlags == r4.controlFlags) goto L16;
            return false;
        L16:
            if (this.isInstallationPackage == r4.isInstallationPackage) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
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
            int r8 = (((r6 + r1) * 31) + Integer.hashCode(this.controlFlags)) * 31;
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
            return "Detail(pkg=" + this.pkg + ", userId=" + this.userId + ", content=" + this.content + ", appInfo=" + this.appInfo + ", controlFlags=" + this.controlFlags + ", isInstallationPackage=" + this.isInstallationPackage + ")";
        }

        public Detail(String r2, int r3, RiskAppContentUiInfo r4, RiskAppUiInfo r5, int r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r4, Contact.CONTENT_SCHEME);
            Intrinsics.checkNotNullParameter(r5, "appInfo");
            this.pkg = r2;
            this.userId = r3;
            this.content = r4;
            this.appInfo = r5;
            this.controlFlags = r6;
            this.isInstallationPackage = r7;
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

        public final int getControlFlags() {
            return this.controlFlags;
        }

        public final boolean isInstallationPackage() {
            return this.isInstallationPackage;
        }
    }

    /* JADX INFO: compiled from: LoadRiskAppsUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/usecase/LoadRiskAppsUseCase$ListItem;", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", Contact.CONTENT_SCHEME, "Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "appInfo", "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "isInstallationPackage", "", "(Ljava/lang/String;ILcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;Z)V", "getAppInfo", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "getContent", "()Lcom/obric/safecheck/riskcontrol/ui/RiskAppContentUiInfo;", "()Z", "getPkg", "()Ljava/lang/String;", "getUserId", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ListItem {
        private final RiskAppUiInfo appInfo;
        private final RiskAppContentUiInfo content;
        private final boolean isInstallationPackage;
        private final String pkg;
        private final int userId;

        public static /* synthetic */ ListItem copy$default(ListItem r3, String r4, int r5, RiskAppContentUiInfo r6, RiskAppUiInfo r7, boolean r8, int r9, Object r10) {
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

        public final ListItem copy(String r7, int r8, RiskAppContentUiInfo r9, RiskAppUiInfo r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r9, Contact.CONTENT_SCHEME);
            Intrinsics.checkNotNullParameter(r10, "appInfo");
            return new ListItem(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ListItem) == false) goto L16;
            ListItem r4 = (ListItem) r3;
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
            return "ListItem(pkg=" + this.pkg + ", userId=" + this.userId + ", content=" + this.content + ", appInfo=" + this.appInfo + ", isInstallationPackage=" + this.isInstallationPackage + ")";
        }

        public ListItem(String r2, int r3, RiskAppContentUiInfo r4, RiskAppUiInfo r5, boolean r6) {
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

    static {
        Companion = new Companion(null);
    }

    private final boolean isConfirmedRisk(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoadRiskAppsUseCase(ScanResultRepository r2, Function2<? super String, ? super Integer, Integer> r3, Function2<? super String, ? super Integer, RiskAppUiInfo> r4, Function1<? super String, RiskAppUiInfo> r5) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "controlFlagsReader");
        Intrinsics.checkNotNullParameter(r4, "installedAppInfoResolver");
        Intrinsics.checkNotNullParameter(r5, "archiveAppInfoResolver");
        this.repository = r2;
        this.controlFlagsReader = r3;
        this.installedAppInfoResolver = r4;
        this.archiveAppInfoResolver = r5;
    }

    public final List<ListItem> loadControlledApps() {
        List<ScanResultRecord> r0 = this.repository.listControlled();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        ScanResultRecord r3 = (ScanResultRecord) r2.next();
        int r5 = r3.getUserId();
        int r4 = this.controlFlagsReader.invoke(r3.getPkg(), Integer.valueOf(r5)).intValue();
        if (r3.getControlled() == true) goto L8;
    L11:
        ListItem r9 = null;
    L12:
        if (r9 == null) goto L4;
        r1.add(r9);
        goto L4
    L8:
        if (RiskControlFlags.hasControlledItem(r4) == false) goto L11;
        boolean r8 = isInstallationPackage(r3.getPkg());
        r9 = new ListItem(r3.getPkg(), r5, toContentUiInfo(r3), resolveAppInfo(r3.getPkg(), r5, r8), r8);
        goto L12
    L15:
        return r1;
    }

    public final Detail loadDetail(String r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, ApkVirusCheckProvider.KEY_PKG);
        Iterator<T> r0 = this.repository.listControlled().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        ScanResultRecord r5 = (ScanResultRecord) r1;
        if (Intrinsics.areEqual(r5.getPkg(), r13) == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L4;
    L14:
        ScanResultRecord r2 = (ScanResultRecord) r1;
        if (r2 != null) goto L29;
        Iterator<T> r3 = this.repository.listAll().iterator();
    L18:
        if (r3.hasNext() == false) goto L27;
        Object r4 = r3.next();
        ScanResultRecord r7 = (ScanResultRecord) r4;
        if (Intrinsics.areEqual(r7.getPkg(), r13) == true) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L18;
    L28:
        r2 = (ScanResultRecord) r4;
        goto L29
    L22:
        if (r7.getUserId() != r14) goto L24;
        r8 = true;
        goto L25
    L27:
        r4 = null;
    L29:
        if (r2 != null) goto L31;
        return null;
    L31:
        boolean r11 = isInstallationPackage(r13);
        return new Detail(r2.getPkg(), r14, toContentUiInfo(r2), resolveAppInfo(r13, r14, r11), this.controlFlagsReader.invoke(r13, Integer.valueOf(r14)).intValue(), r11);
    L8:
        if (r5.getUserId() != r14) goto L10;
        r6 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    public final int countControlled() {
        List<ScanResultRecord> r0 = this.repository.listControlled();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L21;
        ScanResultRecord r3 = (ScanResultRecord) r1.next();
        int r4 = this.controlFlagsReader.invoke(r3.getPkg(), Integer.valueOf(r3.getUserId())).intValue();
        if (r3.getControlled() == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (RiskControlFlags.hasControlledItem(r4) == false) goto L15;
        r5 = true;
        goto L16
    L21:
        return r2;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return 0;
    }

    public final int countUncontrolled() {
        List<ScanResultRecord> r0 = this.repository.listAll();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L9:
        if (r1.hasNext() == false) goto L23;
        ScanResultRecord r3 = (ScanResultRecord) r1.next();
        if (isConfirmedRisk(r3.getVirusTypeCode()) == true) goto L13;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        if (r3.getControlled() == true) goto L17;
        if (isInstallationPackage(r3.getPkg()) == true) goto L17;
        r4 = true;
        goto L18
    L23:
        return r2;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return 0;
    }

    private final RiskAppUiInfo resolveAppInfo(String r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        return this.archiveAppInfoResolver.invoke(r1);
    L5:
        return this.installedAppInfoResolver.invoke(r1, Integer.valueOf(r2));
    }

    private final RiskAppContentUiInfo toContentUiInfo(ScanResultRecord r3) {
        String r0 = r3.getPkg();
        String r1 = r3.getVirusName();
        if (r1 != null) goto L6;
        r1 = r3.getVirusType();
    L6:
        return new RiskAppContentUiInfo(r0, r1, r3.getVirusDescription());
    }

    private final boolean isInstallationPackage(String r5) {
        if (StringsKt.endsWith(r5, ".apk", true) == false) goto L10;
        if (StringsKt.startsWith$default(r5, "/sdcard", false, 2, null) == false) goto L7;
        return true;
    L7:
        if (StringsKt.startsWith$default(r5, "/storage/emulated", false, 2, null) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
