package com.obric.security.tcsecurity.safecheck;

import com.obric.olog.OLog;
import com.obric.securitycenter.api.ApkScanListener;
import com.obric.securitycenter.api.ITmsApkCheckManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScannerManagerV2;
import tmsdk.fg.creator.ManagerCreatorF;

/* JADX INFO: compiled from: TmsApkCheckManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J.\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/security/tcsecurity/safecheck/TmsApkCheckManager;", "Lcom/obric/securitycenter/api/ITmsApkCheckManager;", "()V", "mQScannerMananger", "Ltmsdk/common/module/qscanner/QScannerManagerV2;", "scanInstalledPackages", "", "isCloudScan", "", "packageNames", "", "", "scanListener", "Lcom/obric/securitycenter/api/ApkScanListener;", "timeoutMillis", "", "scanUninstallApks", "", "apkPath", "apkScanListener", "useCache", "timeout", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TmsApkCheckManager implements ITmsApkCheckManager {
    public static final TmsApkCheckManager INSTANCE = null;
    private static QScannerManagerV2 mQScannerMananger;

    static {
        INSTANCE = new TmsApkCheckManager();
    }

    private TmsApkCheckManager() {
    }

    @Override // com.obric.securitycenter.api.ITmsApkCheckManager
    public void scanUninstallApks(List<String> r9, final ApkScanListener r10, boolean r11, long r12) {
        Intrinsics.checkNotNullParameter(r9, "apkPath");
        Intrinsics.checkNotNullParameter(r10, "apkScanListener");
        if (mQScannerMananger != null) goto L5;
        mQScannerMananger = (QScannerManagerV2) ManagerCreatorF.getManager(QScannerManagerV2.class);
    L5:
        QScannerManagerV2 r8 = mQScannerMananger;
        if (r8 == null) goto L8;
        Integer r13 = Integer.valueOf(r8.initScanner());
    L9:
        OLog.d("TmsApkCheckManager_AntiFraud", "initScanner: " + r13);
        OLog.e("TmsApkCheckManager_AntiFraud", "scanUninstallApks: " + mQScannerMananger + "  " + r9);
        QScannerManagerV2 r1 = mQScannerMananger;
        if (r1 == null) goto L13;
        r1.scanUninstallApks(6, r9, new C03901(r10), r11, r12);
        return;
    L13:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // com.obric.securitycenter.api.ITmsApkCheckManager
    public int scanInstalledPackages(boolean r9, List<String> r10, final ApkScanListener r11, long r12) {
        if (mQScannerMananger != null) goto L5;
        mQScannerMananger = (QScannerManagerV2) ManagerCreatorF.getManager(QScannerManagerV2.class);
    L5:
        QScannerManagerV2 r8 = mQScannerMananger;
        if (r8 == null) goto L8;
        Integer r13 = Integer.valueOf(r8.initScanner());
    L9:
        OLog.d("TmsApkCheckManager_AntiFraud", "initScanner: " + r13);
        if (r9 == false) goto L12;
        int r14 = 6;
    L13:
        int r1 = r14;
        QScannerManagerV2 r0 = mQScannerMananger;
        if (r0 != null) goto L18;
        return -1;
    L18:
        return r0.scanInstalledPackages(r1, r10, new AnonymousClass1(r11), 4, true, r12);
    L12:
        r14 = 2;
        goto L13
    L8:
        r13 = null;
        goto L9
    }
}
