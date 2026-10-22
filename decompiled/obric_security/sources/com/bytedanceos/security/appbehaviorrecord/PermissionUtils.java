package com.bytedanceos.security.appbehaviorrecord;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedanceos/security/appbehaviorrecord/PermissionUtils;", "", "()V", "LOG_TAG", "", "getAppName", "context", "Landroid/content/Context;", "packageName", "isAppInstalled", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PermissionUtils {
    public static final PermissionUtils INSTANCE = null;
    private static final String LOG_TAG = "PermissionUtils";

    static {
        INSTANCE = new PermissionUtils();
    }

    private PermissionUtils() {
    }

    public final String getAppName(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        PackageManager r0 = r1.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "context.packageManager");     // Catch: PackageManager.NameNotFoundException -> L5
        ApplicationInfo r3 = r0.getApplicationInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "packageManager.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L5
        return r0.getApplicationLabel(r3).toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final boolean isAppInstalled(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "packageName");
        r1.getPackageManager().getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L9:
        return false;
    }
}
