package com.bytedanceos.securitycenter.scan;

import android.content.Context;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidAppUninstallDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/AndroidAppUninstallDataSource;", "Lcom/bytedanceos/securitycenter/scan/AppUninstallDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "packageManager", "Landroid/content/pm/PackageManager;", "getPackageManager", "()Landroid/content/pm/PackageManager;", "deleteApkFile", "", "path", "", "hasDeletePackagesPermission", "isPackageInstalled", "packageName", "requestUninstall", "", "intentSender", "Landroid/content/IntentSender;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AndroidAppUninstallDataSource implements AppUninstallDataSource {
    private final Context appContext;

    public AndroidAppUninstallDataSource(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    private final PackageManager getPackageManager() {
        Context r1 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        PackageManager r2 = r1.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r2, "appContext.packageManager");
        return r2;
    }

    @Override // com.bytedanceos.securitycenter.scan.AppUninstallDataSource
    public boolean isPackageInstalled(String r2) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AndroidAppUninstallDataSource r1 = this;     // Catch: Throwable -> L5
        Object r3 = Result.m774constructorimpl(getPackageManager().getPackageInfo(r2, 0));     // Catch: Throwable -> L5
    L8:
        return Result.m781isSuccessimpl(r3);
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedanceos.securitycenter.scan.AppUninstallDataSource
    public boolean hasDeletePackagesPermission() {
        if (this.appContext.checkSelfPermission("android.permission.DELETE_PACKAGES") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedanceos.securitycenter.scan.AppUninstallDataSource
    public void requestUninstall(String r2, IntentSender r3) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "intentSender");
        getPackageManager().getPackageInstaller().uninstall(r2, r3);
    }

    @Override // com.bytedanceos.securitycenter.scan.AppUninstallDataSource
    public boolean deleteApkFile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        AndroidAppUninstallDataSource r1 = this;     // Catch: Throwable -> L5
        Object r3 = Result.m774constructorimpl(Boolean.valueOf(new File(r2).delete()));     // Catch: Throwable -> L5
    L8:
        if (Result.m780isFailureimpl(r3) == false) goto L11;
        r3 = false;
    L11:
        return ((Boolean) r3).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
