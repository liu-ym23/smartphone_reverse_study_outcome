package com.obric.securitycenter.api;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&J.\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\fH&¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/api/ITmsApkCheckManager;", "", "scanInstalledPackages", "", "isCloudScan", "", "packageNames", "", "", "scanListener", "Lcom/obric/securitycenter/api/ApkScanListener;", "timeoutMillis", "", "scanUninstallApks", "", "var2", "var3", "var4", "var5", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ITmsApkCheckManager {
    int scanInstalledPackages(boolean r1, List<String> r2, ApkScanListener r3, long r4);

    void scanUninstallApks(List<String> r1, ApkScanListener r2, boolean r3, long r4);
}
