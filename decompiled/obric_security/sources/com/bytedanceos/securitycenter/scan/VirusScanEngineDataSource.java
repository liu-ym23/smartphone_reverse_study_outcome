package com.bytedanceos.securitycenter.scan;

import com.bytedance.apm.constant.PerfConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: VirusScanEngineDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&Jt\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014Jt\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/VirusScanEngineDataSource;", "", "cancelScan", "", "initScanner", "scanInstalledPackages", "Lcom/bytedanceos/securitycenter/scan/ScanEngineResult;", "cloudScan", "", "packages", "", "", "onProgress", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "curr", PerfConsts.PERF_DISK_TOTAL, "displayName", "(ZLjava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanUninstallApks", "apkPaths", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface VirusScanEngineDataSource {
    void cancelScan();

    void initScanner();

    Object scanInstalledPackages(boolean r1, List<String> r2, Function3<? super Integer, ? super Integer, ? super String, Unit> r3, Continuation<? super ScanEngineResult> r4);

    Object scanUninstallApks(boolean r1, List<String> r2, Function3<? super Integer, ? super Integer, ? super String, Unit> r3, Continuation<? super ScanEngineResult> r4);
}
