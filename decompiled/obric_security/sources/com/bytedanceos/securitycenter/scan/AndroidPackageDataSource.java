package com.bytedanceos.securitycenter.scan;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.service.ApkVirusCheckHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidPackageDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/AndroidPackageDataSource;", "Lcom/bytedanceos/securitycenter/scan/PackageDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "getInstalledPackageNames", "", "", "isObricApp", "", ApkVirusCheckProvider.KEY_PKG, "isSystemApp", "resolveAppName", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AndroidPackageDataSource implements PackageDataSource {
    private final Context appContext;

    public AndroidPackageDataSource(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    @Override // com.bytedanceos.securitycenter.scan.PackageDataSource
    public List<String> getInstalledPackageNames() {
        Context r3 = this.appContext;     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r3, "appContext");     // Catch: Exception -> L8
        List<PackageInfo> r4 = r3.getPackageManager().getInstalledPackages(0);     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r4, "appContext.packageManager.getInstalledPackages(0)");     // Catch: Exception -> L8
        List<PackageInfo> r5 = r4;     // Catch: Exception -> L8
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Exception -> L8
        Iterator<T> r6 = r5.iterator();     // Catch: Exception -> L8
    L4:
        if (r6.hasNext() == false) goto L6;
        String r1 = ((PackageInfo) r6.next()).packageName;     // Catch: Exception -> L8
        Intrinsics.checkNotNullExpressionValue(r1, "it.packageName");     // Catch: Exception -> L8
        r0.add(r1);     // Catch: Exception -> L8
        goto L4
    L6:
        return r0;
    L8:
        e = move-exception;
        e.printStackTrace();
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedanceos.securitycenter.scan.PackageDataSource
    public boolean isSystemApp(String r3) {
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
        ApkVirusCheckHelper r0 = ApkVirusCheckHelper.INSTANCE;
        Context r2 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r2, "appContext");
        return r0.isSystemApp(r2, r3);
    }

    @Override // com.bytedanceos.securitycenter.scan.PackageDataSource
    public boolean isObricApp(String r3) {
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
        ApkVirusCheckHelper r0 = ApkVirusCheckHelper.INSTANCE;
        Context r2 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r2, "appContext");
        return r0.isObricApp(r2, r3);
    }

    @Override // com.bytedanceos.securitycenter.scan.PackageDataSource
    public String resolveAppName(String r3) {
        Intrinsics.checkNotNullParameter(r3, ApkVirusCheckProvider.KEY_PKG);
        Context r2 = this.appContext;     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r2, "appContext");     // Catch: Exception -> L9
        PackageManager r4 = r2.getPackageManager();     // Catch: Exception -> L9
        ApplicationInfo r0 = r4.getApplicationInfo(r3, 0);     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r0, "pm.getApplicationInfo(pkg, 0)");     // Catch: Exception -> L9
        String r5 = r4.getApplicationLabel(r0).toString();     // Catch: Exception -> L9
        if (StringsKt.isBlank(r5) == false) goto L6;
        r5 = r3;
    L6:
        return r5;
    L12:
        return r3;
    }
}
