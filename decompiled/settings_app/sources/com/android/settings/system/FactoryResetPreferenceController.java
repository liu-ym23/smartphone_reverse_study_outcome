package com.android.settings.system;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.UserManager;
import com.android.settings.AdvancedSettingsFragment;
import com.android.settings.MasterClear;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class FactoryResetPreferenceController {
    public static final String ACTION_PREPARE_FACTORY_RESET = "com.android.settings.ACTION_PREPARE_FACTORY_RESET";
    public static final int REQUEST_CODE_PREPARE_FACTORY_RESET = 10001;
    private static final String TAG = "FactoryResetPreference";
    private final Context mContext;
    private final UserManager mUm;

    public FactoryResetPreferenceController(Context r2) {
        this.mContext = r2;
        this.mUm = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
    }

    public boolean isAvailable() {
        return this.mUm.isAdminUser();
    }

    public Intent getPrepareFactoryResetIntent() {
        Intent r0 = new Intent(ACTION_PREPARE_FACTORY_RESET);
        PackageManager r8 = this.mContext.getPackageManager();
        ResolveInfo r2 = r8.resolveActivity(r0, 0);
        if (r2 != null) goto L5;
    L33:
        OLog.i(TAG, "Unable to resolve a Factory Reset Handler Activity");
        return null;
    L5:
        if (r2.activityInfo == null) goto L33;
        String r3 = r2.activityInfo.packageName;
        PackageInfo r9 = r8.getPackageInfo(r3, 4096);     // Catch: PackageManager.NameNotFoundException -> L30
        if (r9.requestedPermissions != null) goto L11;
    L28:
        OLog.e(TAG, "Factory Reset Handler has no permissions requested.");
        return null;
    L11:
        if (r9.requestedPermissions.length == 0) goto L28;
        int r4 = 0;
    L15:
        if (r4 >= r9.requestedPermissions.length) goto L26;
        String r5 = r9.requestedPermissions[r4];
        if ((r9.requestedPermissionsFlags[r4] & 2) == 0) goto L19;
        boolean r6 = true;
    L21:
        if (r5.equals("android.permission.PREPARE_FACTORY_RESET") == false) goto L25;
        if (r6 == false) goto L25;
        OLog.d(TAG, "Found valid factory reset preparation activity: " + r3);
        return r0;
    L25:
        r4 = r4 + 1;
        goto L15
    L19:
        r6 = false;
        goto L21
    L26:
        OLog.w(TAG, "Factory Reset Handler does not have PREPARE_FACTORY_RESET permission");
        return r0;
    L30:
        e = move-exception;
        OLog.e(TAG, "Unable to resolve a Factory Reset Handler Application", e);
        return null;
    }

    public void startFactoryResetActivity(AdvancedSettingsFragment r1) {
        r1.start(MasterClear.class);
    }

    public void handlePrepareResult(AdvancedSettingsFragment r2, int r3, Intent r4) {
        if (r3 != (-1)) goto L5;
        OLog.d(TAG, "Factory reset preparation completed, starting factory reset");
        startFactoryResetActivity(r2);
        return;
    L5:
        OLog.w(TAG, "Factory reset preparation cancelled or failed, resultCode=" + r3);
    }
}
