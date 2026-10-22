package com.bytedanceos.securitycenter.scan;

import android.content.IntentSender;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.domain.usecase.PersistScanResultsUseCase;
import com.obric.safecheck.riskcontrol.ui.RiskAppUiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: SafeCheckRiskAppUseCase.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002./B\u0084\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00126\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u0013¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001bJ\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0014J\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u0014J\u0014\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u001bJ\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0016\u0010)\u001a\u00020\"2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u0002J\u0016\u0010*\u001a\u00020\"2\u0006\u0010'\u001a\u00020\b2\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u0004\u0018\u00010\u0019*\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase;", "", "persistScanResultsUseCase", "Lcom/obric/safecheck/riskcontrol/domain/usecase/PersistScanResultsUseCase;", "appUninstallDataSource", "Lcom/bytedanceos/securitycenter/scan/AppUninstallDataSource;", "installedAppInfoResolver", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "Lcom/obric/safecheck/riskcontrol/ui/RiskAppUiInfo;", "archiveAppInfoResolver", "Lkotlin/Function1;", "apkPath", "externalStorageRoots", "Lkotlin/Function0;", "", "(Lcom/obric/safecheck/riskcontrol/domain/usecase/PersistScanResultsUseCase;Lcom/bytedanceos/securitycenter/scan/AppUninstallDataSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "buildCleanTargets", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase$CleanTargets;", "riskApps", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "selectedRiskKeys", "", "collectRiskApps", ApkVirusCheckProvider.KEY_RESULTS, "Ltmsdk/common/module/qscanner/QScanResultEntity;", "deleteApkFiles", "apkApps", "deleteRecords", "", "cleanedKeys", "hasDeletePackagesPermission", "", "isPackageInstalled", "packageName", "isRiskControlled", "persistRiskApps", "requestInstalledUninstall", "intentSender", "Landroid/content/IntentSender;", "toRiskAppItem", "CleanTargets", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckRiskAppUseCase {
    private static final Companion Companion = null;

    @Deprecated
    public static final int DEFAULT_USER_ID = 0;
    private final AppUninstallDataSource appUninstallDataSource;
    private final Function1<String, RiskAppUiInfo> archiveAppInfoResolver;
    private final Function0<List<String>> externalStorageRoots;
    private final Function2<String, Integer, RiskAppUiInfo> installedAppInfoResolver;
    private final PersistScanResultsUseCase persistScanResultsUseCase;

    /* JADX INFO: compiled from: SafeCheckRiskAppUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase$CleanTargets;", "", "apkApps", "", "Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppItem;", "installedApps", "(Ljava/util/List;Ljava/util/List;)V", "getApkApps", "()Ljava/util/List;", "getInstalledApps", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CleanTargets {
        private final List<SafeCheckRiskAppItem> apkApps;
        private final List<SafeCheckRiskAppItem> installedApps;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CleanTargets copy$default(CleanTargets r0, List r1, List r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.apkApps;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.installedApps;
        L9:
            return r0.copy(r1, r2);
        }

        public final List<SafeCheckRiskAppItem> component1() {
            return this.apkApps;
        }

        public final List<SafeCheckRiskAppItem> component2() {
            return this.installedApps;
        }

        public final CleanTargets copy(List<SafeCheckRiskAppItem> r1, List<SafeCheckRiskAppItem> r2) {
            Intrinsics.checkNotNullParameter(r1, "apkApps");
            Intrinsics.checkNotNullParameter(r2, "installedApps");
            return new CleanTargets(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof CleanTargets) == false) goto L10;
            CleanTargets r4 = (CleanTargets) r3;
            if (Intrinsics.areEqual(this.apkApps, r4.apkApps) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.installedApps, r4.installedApps) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            List<SafeCheckRiskAppItem> r0 = this.apkApps;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<SafeCheckRiskAppItem> r4 = this.installedApps;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "CleanTargets(apkApps=" + this.apkApps + ", installedApps=" + this.installedApps + ")";
        }

        public CleanTargets(List<SafeCheckRiskAppItem> r2, List<SafeCheckRiskAppItem> r3) {
            Intrinsics.checkNotNullParameter(r2, "apkApps");
            Intrinsics.checkNotNullParameter(r3, "installedApps");
            this.apkApps = r2;
            this.installedApps = r3;
        }

        public final List<SafeCheckRiskAppItem> getApkApps() {
            return this.apkApps;
        }

        public final List<SafeCheckRiskAppItem> getInstalledApps() {
            return this.installedApps;
        }
    }

    /* JADX INFO: compiled from: SafeCheckRiskAppUseCase.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/SafeCheckRiskAppUseCase$Companion;", "", "()V", "DEFAULT_USER_ID", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCheckRiskAppUseCase(PersistScanResultsUseCase r2, AppUninstallDataSource r3, Function2<? super String, ? super Integer, RiskAppUiInfo> r4, Function1<? super String, RiskAppUiInfo> r5, Function0<? extends List<String>> r6) {
        Intrinsics.checkNotNullParameter(r2, "persistScanResultsUseCase");
        Intrinsics.checkNotNullParameter(r3, "appUninstallDataSource");
        Intrinsics.checkNotNullParameter(r4, "installedAppInfoResolver");
        Intrinsics.checkNotNullParameter(r5, "archiveAppInfoResolver");
        Intrinsics.checkNotNullParameter(r6, "externalStorageRoots");
        this.persistScanResultsUseCase = r2;
        this.appUninstallDataSource = r3;
        this.installedAppInfoResolver = r4;
        this.archiveAppInfoResolver = r5;
        this.externalStorageRoots = r6;
    }

    public final List<SafeCheckRiskAppItem> collectRiskApps(List<? extends QScanResultEntity> r5) {
        Intrinsics.checkNotNullParameter(r5, ApkVirusCheckProvider.KEY_RESULTS);
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if (RiskResultMapper.INSTANCE.isRiskResult(((QScanResultEntity) r1).scanResult) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        SafeCheckRiskAppItem r3 = toRiskAppItem((QScanResultEntity) r2.next());
        if (r3 == null) goto L10;
        r7.add(r3);
        goto L10
    L14:
        ArrayList r8 = r7;
        persistRiskApps(r8);
        ArrayList r4 = new ArrayList();
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        Object r10 = r9.next();
        if (isRiskControlled(((SafeCheckRiskAppItem) r10).getKey()) == true) goto L16;
        r4.add(r10);
        goto L16
    L21:
        return r4;
    }

    public final CleanTargets buildCleanTargets(List<SafeCheckRiskAppItem> r3, Set<String> r4) {
        Intrinsics.checkNotNullParameter(r3, "riskApps");
        Intrinsics.checkNotNullParameter(r4, "selectedRiskKeys");
        ArrayList r2 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (r4.contains(((SafeCheckRiskAppItem) r0).getKey()) == false) goto L4;
        r2.add(r0);
        goto L4
    L8:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r2.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Object r1 = r8.next();
        if (((SafeCheckRiskAppItem) r1).isInstallationPackage() == true) goto L13;
        r7.add(r1);
        goto L10
    L13:
        r6.add(r1);
        goto L10
    L15:
        Pair r9 = new Pair(r6, r7);
        return new CleanTargets((List) r9.component1(), (List) r9.component2());
    }

    public final boolean isPackageInstalled(String r2) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        return this.appUninstallDataSource.isPackageInstalled(r2);
    }

    public final boolean hasDeletePackagesPermission() {
        return this.appUninstallDataSource.hasDeletePackagesPermission();
    }

    public final void requestInstalledUninstall(String r2, IntentSender r3) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "intentSender");
        this.appUninstallDataSource.requestUninstall(r2, r3);
    }

    public final Set<String> deleteApkFiles(List<SafeCheckRiskAppItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "apkApps");
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        SafeCheckRiskAppItem r1 = (SafeCheckRiskAppItem) r6.next();
        if (this.appUninstallDataSource.deleteApkFile(r1.getKey()) == false) goto L8;
        String r2 = r1.getKey();
    L9:
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r2 = null;
        goto L9
    L12:
        return r0;
    }

    public final void deleteRecords(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "cleanedKeys");
        this.persistScanResultsUseCase.deleteRecords(r2);
    }

    private final boolean isRiskControlled(String r1) {
        return this.persistScanResultsUseCase.isRiskControlled(r1);
    L4:
        return false;
    }

    private final void persistRiskApps(List<SafeCheckRiskAppItem> r10) {
        if (r10.isEmpty() == false) goto L12;
        return;
    L12:
        PersistScanResultsUseCase r9 = this.persistScanResultsUseCase;     // Catch: Exception -> L11
        List<SafeCheckRiskAppItem> r11 = r10;     // Catch: Exception -> L11
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));     // Catch: Exception -> L11
        Iterator<T> r12 = r11.iterator();     // Catch: Exception -> L11
    L7:
        if (r12.hasNext() == false) goto L9;
        SafeCheckRiskAppItem r1 = (SafeCheckRiskAppItem) r12.next();     // Catch: Exception -> L11
        r0.add(new PersistScanResultsUseCase.ScanResultRecord(r1.getKey(), r1.getVirusType(), r1.getVirusTypeCode(), r1.getVirusName(), r1.getVirusDescription()));     // Catch: Exception -> L11
        goto L7
    L9:
        r9.persistAll(r0);     // Catch: Exception -> L11
        return;
    }

    private final SafeCheckRiskAppItem toRiskAppItem(QScanResultEntity r23) {
        String r2 = r23.path;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = r23.packageName;
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        boolean r13 = RiskResultMapper.INSTANCE.isInstallationPackage(r2, r3, this.externalStorageRoots.invoke());
        String r7 = RiskResultMapper.INSTANCE.deriveKey(r2, r3, r13);
        if (StringsKt.isBlank(r7) == false) goto L13;
        return null;
    L13:
        String r5 = RiskResultMapper.INSTANCE.deriveFallbackName(r7);
        if (r13 == false) goto L25;
        RiskAppUiInfo r14 = this.archiveAppInfoResolver.invoke(r7);
        String r0 = r23.softName;
        if (r0 != null) goto L22;
        String r1 = r14.getAppName();
        if (StringsKt.isBlank(r1) == true) goto L21;
        r5 = r1;
    L21:
        String r16 = r5;
    L23:
        RiskAppUiInfo r6 = RiskAppUiInfo.copy$default(r14, null, r16, null, null, null, 29, null);
    L24:
        RiskAppUiInfo r8 = r6;
        Pair<String, Integer> r9 = RiskResultMapper.INSTANCE.deriveVirusType(r23.virusName);
        return new SafeCheckRiskAppItem(r7, r8, r9.component1(), r9.component2().intValue(), r23.virusName, r23.virusDiscription, r13, 0);
    L22:
        r16 = r0;
        goto L23
    L25:
        RiskAppUiInfo r15 = this.installedAppInfoResolver.invoke(r7, 0);
        String r10 = r15.getAppName();
        if (StringsKt.isBlank(r10) == false) goto L32;
        String r11 = r23.softName;
        if (r11 == null) goto L31;
        r5 = r11;
    L31:
        r10 = r5;
    L32:
        r6 = RiskAppUiInfo.copy$default(r15, null, r10, null, null, null, 29, null);
        goto L24
    }
}
