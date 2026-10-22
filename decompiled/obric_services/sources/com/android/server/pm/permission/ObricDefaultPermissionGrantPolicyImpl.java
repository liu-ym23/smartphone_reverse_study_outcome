package com.android.server.pm.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.utils.ObricPermissionCheckHelper;

/* JADX INFO: loaded from: classes.dex */
public class ObricDefaultPermissionGrantPolicyImpl implements IObricDefaultPermissionGrantPolicy {
    private static final String TAG = "ObricDefaultPermissionGrantPolicy";
    private DefaultPermissionGrantPolicy mBase;

    public ObricDefaultPermissionGrantPolicyImpl(DefaultPermissionGrantPolicy base) {
        this.mBase = base;
    }

    public boolean isObricAssistant(Context context, String packageName) {
        boolean result = false;
        Log.i(TAG, "Check whether packages is ObricAssist: " + packageName);     // Catch: PackageManager.NameNotFoundException -> L10
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 64);     // Catch: PackageManager.NameNotFoundException -> L10
        if (packageInfo.signatures != null) goto L6;
    L12:
        Log.i(TAG, "Package is ObricAssist: " + result);
        return result;
    L6:
        if (packageInfo.signatures.length <= 0) goto L12;
        String signature = packageInfo.signatures[0].toCharsString();     // Catch: PackageManager.NameNotFoundException -> L10
        result = ObricPermissionCheckHelper.isObricAssist(packageName, signature);     // Catch: PackageManager.NameNotFoundException -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "Package not found: " + packageName, e);
        goto L12
    }
}
