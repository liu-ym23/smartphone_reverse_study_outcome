package com.android.settingslib.development;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.UserManager;
import android.provider.Settings;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.settings.applications.PickApplicationActivity;

/* JADX INFO: loaded from: classes.dex */
public class DevelopmentSettingsEnabler {
    public static final String DEVELOPMENT_SETTINGS_CHANGED_ACTION = "com.android.settingslib.development.DevelopmentSettingsEnabler.SETTINGS_CHANGED";

    private DevelopmentSettingsEnabler() {
    }

    public static void setDevelopmentSettingsEnabled(Context r2, boolean r3) {
        Settings.Global.putInt(r2.getContentResolver(), "development_settings_enabled", r3 ? 1 : 0);
        LocalBroadcastManager.getInstance(r2).sendBroadcast(new Intent(DEVELOPMENT_SETTINGS_CHANGED_ACTION));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isDevelopmentSettingsEnabled(Context r4) {
        UserManager r0 = (UserManager) r4.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (Settings.Global.getInt(r4.getContentResolver(), "development_settings_enabled", Build.TYPE.equals("eng") ? 1 : 0) == 0) goto L5;
        Object[] r5 = true;
    L6:
        boolean r3 = r0.hasUserRestriction("no_debugging_features");
        if (r0.isAdminUser() == false) goto L12;
        if (r3 == true) goto L12;
        if (r5 == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r5 = false;
        goto L6
    }
}
