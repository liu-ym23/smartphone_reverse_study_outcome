package com.bytedanceos.securitycenter.scan;

import android.content.IntentSender;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppUninstallDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/AppUninstallDataSource;", "", "deleteApkFile", "", "path", "", "hasDeletePackagesPermission", "isPackageInstalled", "packageName", "requestUninstall", "", "intentSender", "Landroid/content/IntentSender;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface AppUninstallDataSource {
    boolean deleteApkFile(String r1);

    boolean hasDeletePackagesPermission();

    boolean isPackageInstalled(String r1);

    void requestUninstall(String r1, IntentSender r2);
}
