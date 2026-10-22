package com.android.settingslib.development;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.TwoStatePreference;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.RestrictedSwitchPreference;
import com.android.settingslib.core.ConfirmationDialogController;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEnableAdbPreferenceController extends DeveloperOptionsPreferenceController implements ConfirmationDialogController {
    public static final String ACTION_ENABLE_ADB_STATE_CHANGED = "com.android.settingslib.development.AbstractEnableAdbController.ENABLE_ADB_STATE_CHANGED";
    public static final int ADB_SETTING_OFF = 0;
    public static final int ADB_SETTING_ON = 1;
    private static final String KEY_ENABLE_ADB = "enable_adb";
    protected RestrictedSwitchPreference mPreference;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_ENABLE_ADB;
    }

    public AbstractEnableAdbPreferenceController(Context r1) {
        super(r1);
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController, com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        if (isAvailable() == false) goto L6;
        this.mPreference = (RestrictedSwitchPreference) r2.findPreference(KEY_ENABLE_ADB);
        return;
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController, com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return ((UserManager) this.mContext.getSystemService(UserManager.class)).isAdminUser();
    }

    private boolean isAdbEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "adb_enabled", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void updateState(Preference r3) {
        ((TwoStatePreference) r3).setChecked(isAdbEnabled());
        if (isAvailable() == false) goto L6;
        ((RestrictedSwitchPreference) r3).setDisabledByAdmin(RestrictedLockUtilsInternal.checkIfUsbDataSignalingIsDisabled(this.mContext, UserHandle.myUserId()));
        return;
    }

    @Override // com.android.settingslib.development.DeveloperOptionsPreferenceController
    protected void onDeveloperOptionsSwitchEnabled() {
        super.onDeveloperOptionsSwitchEnabled();
        if (isAvailable() == false) goto L6;
        this.mPreference.setDisabledByAdmin(RestrictedLockUtilsInternal.checkIfUsbDataSignalingIsDisabled(this.mContext, UserHandle.myUserId()));
        return;
    }

    public void enablePreference(boolean r2) {
        if (isAvailable() == false) goto L6;
        this.mPreference.setEnabled(r2);
        return;
    }

    public void resetPreference() {
        if (this.mPreference.isChecked() == false) goto L6;
        this.mPreference.setChecked(false);
        handlePreferenceTreeClick(this.mPreference);
        return;
    }

    public boolean haveDebugSettings() {
        return isAdbEnabled();
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean handlePreferenceTreeClick(Preference r4) {
        if (isUserAMonkey() == false) goto L6;
        return false;
    L6:
        if (TextUtils.equals(KEY_ENABLE_ADB, r4.getKey()) == true) goto L8;
        return false;
    L8:
        if (isAdbEnabled() == true) goto L10;
        showConfirmationDialog(r4);
        return true;
    L10:
        writeAdbSetting(false);
        return true;
    }

    protected void writeAdbSetting(boolean r3) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "adb_enabled", r3 ? 1 : 0);
        notifyStateChanged();
    }

    private void notifyStateChanged() {
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(new Intent(ACTION_ENABLE_ADB_STATE_CHANGED));
    }

    boolean isUserAMonkey() {
        return ActivityManager.isUserAMonkey();
    }
}
