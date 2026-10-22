package com.android.settingslib.utils.applications;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.UserManager;
import com.GlobalProxyLancet;
import com.android.settingslib.utils.R;

/* JADX INFO: loaded from: classes.dex */
public class AppUtils {
    private static final String TAG = "AppUtils";

    static {
    }

    public AppUtils() {
    }

    public static CharSequence getApplicationLabel(PackageManager r2, String r3) {
        return r2.getApplicationInfo(r3, 4194816).loadLabel(r2);
    L5:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to find info for package: " + r3);
        return null;
    }

    public static String getAppContentDescription(Context r2, String r3, int r4) {
        CharSequence r5 = getApplicationLabel(r2.getPackageManager(), r3);
        if (r5 != null) goto L7;
        return "";
    L7:
        if (((UserManager) r2.getSystemService(UserManager.class)).isManagedProfile(r4) == false) goto L10;
        return r2.getString(R.string.accessibility_work_profile_app_description, new Object[]{r5});
    L10:
        return r5.toString();
    }
}
