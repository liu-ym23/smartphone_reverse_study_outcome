package com.bytedanceos.securitycenter.scan;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: ScanPlanBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanPlanBuilder;", "", "packageDataSource", "Lcom/bytedanceos/securitycenter/scan/PackageDataSource;", "virusDbScanDataSource", "Lcom/bytedanceos/securitycenter/scan/VirusDbScanDataSource;", "(Lcom/bytedanceos/securitycenter/scan/PackageDataSource;Lcom/bytedanceos/securitycenter/scan/VirusDbScanDataSource;)V", "build", "Lcom/bytedanceos/securitycenter/scan/ScanPlan;", "isCanceled", "Lkotlin/Function0;", "", "isConfirmedVirus", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "toRiskResult", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "Lcom/bytedanceos/securitycenter/scan/VirusDbRecord;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ScanPlanBuilder {
    private static final Companion Companion = null;

    @Deprecated
    public static final int VIRUS_CODE_NONE = 0;

    @Deprecated
    public static final int VIRUS_CODE_OTHER = 2;

    @Deprecated
    public static final int VIRUS_CODE_SEX = 1;
    private final PackageDataSource packageDataSource;
    private final VirusDbScanDataSource virusDbScanDataSource;

    /* JADX INFO: compiled from: ScanPlanBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanPlanBuilder$Companion;", "", "()V", "VIRUS_CODE_NONE", "", "VIRUS_CODE_OTHER", "VIRUS_CODE_SEX", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
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

    private final boolean isConfirmedVirus(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public ScanPlanBuilder(PackageDataSource r2, VirusDbScanDataSource r3) {
        Intrinsics.checkNotNullParameter(r2, "packageDataSource");
        Intrinsics.checkNotNullParameter(r3, "virusDbScanDataSource");
        this.packageDataSource = r2;
        this.virusDbScanDataSource = r3;
    }

    public final ScanPlan build(Function0<Boolean> r11) {
        Intrinsics.checkNotNullParameter(r11, "isCanceled");
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Map<String, VirusDbRecord> r4 = this.virusDbScanDataSource.loadAllByPkg();
        Iterator<String> r5 = this.packageDataSource.getInstalledPackageNames().iterator();
    L4:
        if (r5.hasNext() == false) goto L26;
        String r6 = r5.next();
        if (r11.invoke().booleanValue() == true) goto L26;
        if (this.packageDataSource.isSystemApp(r6) == true) goto L4;
        if (this.packageDataSource.isObricApp(r6) == true) goto L4;
        VirusDbRecord r7 = r4.get(r6);
        if (r7 == null) goto L16;
        if (r7.getControlled() == false) goto L16;
        r1.add(new ScanDisplayItem(r6, this.packageDataSource.resolveAppName(r6), SkippedReason.CONTROLLED_RISK));
    L16:
        if (r7 == null) goto L20;
        if (isConfirmedVirus(r7.getVirusTypeCode()) == false) goto L20;
        r3.add(toRiskResult(r7));
        r2.add(new ScanDisplayItem(r6, this.packageDataSource.resolveAppName(r6), SkippedReason.PRE_CONFIRMED_RISK));
    L20:
        if (r7 == null) goto L24;
        if (r7.getVirusTypeCode() == 0) goto L4;
    L24:
        r0.add(r6);
    L26:
        return new ScanPlan(r0, r1, r2, r3);
    }

    private final QScanResultEntity toRiskResult(VirusDbRecord r3) {
        QScanResultEntity r2 = new QScanResultEntity();
        r2.packageName = r3.getPkg();
        String r1 = (String) null;
        r2.softName = null;
        r2.scanResult = 260;
        r2.virusName = r3.getVirusName();
        r2.virusDiscription = r3.getVirusDescription();
        return r2;
    }
}
