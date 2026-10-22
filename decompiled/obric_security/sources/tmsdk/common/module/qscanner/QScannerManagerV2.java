package tmsdk.common.module.qscanner;

import android.content.Context;
import java.util.List;
import tmsdk.common.module.qscanner.impl.b;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.f;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class QScannerManagerV2 extends BaseManagerF {
    public static final String LOG_TAG = "QScannerMgr";
    public static final String TAG = "TMSDK_QScannerManagerV2";
    private b b;

    public QScannerManagerV2() {
    }

    public void cancelScan() {
        this.b.cancelScan();
    }

    public void continueScan() {
        this.b.continueScan();
    }

    public int freeScanner() {
        return this.b.freeScanner();
    }

    public String getDescByLanID(int r1) {
        return this.b.b(r1);
    }

    public String getVirusBaseVersion() {
        return this.b.getVirusBaseVersion();
    }

    public int initScanner() {
        return this.b.initScanner();
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        b r0 = new b();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void pauseScan() {
        this.b.pauseScan();
    }

    public int scanInstalledPackages(int r9, List<String> r10, QScanListener r11, int r12, long r13) {
        return scanInstalledPackages(r9, r10, r11, r12, true, r13);
    }

    public int scanUninstallApks(int r8, List<String> r9, QScanListener r10, long r11) {
        return scanUninstallApks(r8, r9, r10, true, r11);
    }

    public void setCacheInterval(long r1) {
        this.b.setCacheInterval(r1);
    }

    public void setHashType(int r1) {
        b r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setHashType(r1);
    }

    public void setHashWay(int r1) {
        b r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setHashWay(r1);
    }

    public int scanInstalledPackages(int r9, List<String> r10, QScanListener r11, int r12, boolean r13, long r14) {
        q8.c(TAG, "scanInstalledPackages");
        f.f(1320056);
        return this.b.a(r9, r10, r11, r12, r13, r14);
    }

    public int scanUninstallApks(int r9, List<String> r10, QScanListener r11, boolean r12, long r13) {
        q8.c(TAG, "scanUninstallApks");
        f.f(1320057);
        return this.b.a(r9, r10, r11, r12, r13);
    }
}
