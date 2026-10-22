package com.bytedanceos.securitycenter.scan;

import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PackageDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/PackageDataSource;", "", "getInstalledPackageNames", "", "", "isObricApp", "", ApkVirusCheckProvider.KEY_PKG, "isSystemApp", "resolveAppName", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface PackageDataSource {
    List<String> getInstalledPackageNames();

    boolean isObricApp(String r1);

    boolean isSystemApp(String r1);

    String resolveAppName(String r1);
}
