package com.android.settings.specialaccess.notificationaccess;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.preference.Preference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MoreSettingsPreferenceController {
    private static final String KEY_MORE_SETTINGS = "more_settings";
    private static final String TAG = "MoreSettingsPrefContr";
    Intent mIntent;
    String mPackage;
    PackageManager mPm;

    public MoreSettingsPreferenceController() {
        this.mIntent = new Intent("android.service.notification.action.SETTINGS_HOME");
    }

    public boolean getAvailabilityStatus() {
        List<ResolveInfo> r3 = this.mPm.queryIntentActivities(this.mIntent, PackageManager.ResolveInfoFlags.of(0));
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.isEmpty() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public MoreSettingsPreferenceController setPackageManager(PackageManager r1) {
        this.mPm = r1;
        return this;
    }

    public MoreSettingsPreferenceController setPackage(String r2) {
        this.mPackage = r2;
        this.mIntent.setPackage(r2);
        return this;
    }

    public void updateState(Preference r1) {
        r1.setIntent(this.mIntent);
    }
}
