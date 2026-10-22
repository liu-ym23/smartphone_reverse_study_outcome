package com.android.settings.applications;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserHandle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class WriteSettingsDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final int[] APP_OPS_OP_CODE = null;
    private static final String KEY_APP_OPS_PREFERENCE_SCREEN = "app_ops_preference_screen";
    private static final String KEY_APP_OPS_SETTINGS_DESC = "app_ops_settings_description";
    private static final String KEY_APP_OPS_SETTINGS_PREFS = "app_ops_settings_preference";
    private static final String KEY_APP_OPS_SETTINGS_SWITCH = "app_ops_settings_switch";
    private static final String LOG_TAG = "WriteSettingsDetails";
    private AppStateWriteSettingsBridge mAppBridge;
    private AppOpsManager mAppOpsManager;
    private Intent mSettingsIntent;
    private SwitchPreference mSwitchPref;
    private Preference mWriteSettingsDesc;
    private Preference mWriteSettingsPrefs;
    private AppStateWriteSettingsBridge.WriteSettingsState mWriteSettingsState;

    public void com_android_settings_applications_WriteSettingsDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WriteSettingsDetails() {
    }

    static {
        APP_OPS_OP_CODE = new int[]{23};
    }

    public void com_android_settings_applications_WriteSettingsDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mAppBridge = new AppStateWriteSettingsBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
        addPreferencesFromResource(R.xml.app_ops_permissions_details);
        this.mSwitchPref = (SwitchPreference) findPreference(KEY_APP_OPS_SETTINGS_SWITCH);
        this.mWriteSettingsPrefs = findPreference(KEY_APP_OPS_SETTINGS_PREFS);
        this.mWriteSettingsDesc = findPreference(KEY_APP_OPS_SETTINGS_DESC);
        getPreferenceScreen().setTitle(R.string.write_settings);
        this.mSwitchPref.setTitle(R.string.permit_write_settings);
        this.mWriteSettingsPrefs.setTitle(R.string.write_settings_preference);
        this.mWriteSettingsDesc.setSummary(R.string.write_settings_description);
        this.mSwitchPref.setOnPreferenceChangeListener(this);
        this.mWriteSettingsPrefs.setOnPreferenceClickListener(this);
        this.mSettingsIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.USAGE_ACCESS_CONFIG").setPackage(this.mPackageName);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r4) {
        if (r4 == this.mWriteSettingsPrefs) goto L5;
        return false;
    L5:
        if (this.mSettingsIntent == null) goto L16;
        getActivity().startActivityAsUser(this.mSettingsIntent, new UserHandle(this.mUserId));     // Catch: ActivityNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        OLog.w(LOG_TAG, "Unable to launch write system settings " + this.mSettingsIntent, e);
        return true;
    L16:
        return true;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 == this.mSwitchPref) goto L5;
        return false;
    L5:
        if (this.mWriteSettingsState != null) goto L7;
    L9:
        return true;
    L7:
        if (((Boolean) r3).booleanValue() == this.mWriteSettingsState.isPermissible()) goto L9;
        setCanWriteSettings(!this.mWriteSettingsState.isPermissible());
        refreshUi();
        goto L9
    }

    private void setCanWriteSettings(boolean r4) {
        AppOpsManager r0 = this.mAppOpsManager;
        int r1 = this.mPackageInfo.applicationInfo.uid;
        String r3 = this.mPackageName;
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        r0.setMode(23, r1, r3, r5);
        return;
    L5:
        r5 = 2;
        goto L6
    }

    private boolean canWriteSettings(String r3) {
        if (this.mAppOpsManager.noteOpNoThrow(23, this.mPackageInfo.applicationInfo.uid, r3) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L6;
        return false;
    L6:
        AppStateWriteSettingsBridge.WriteSettingsState r0 = this.mAppBridge.getWriteSettingsInfo(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        this.mWriteSettingsState = r0;
        boolean r1 = r0.isPermissible();
        this.mSwitchPref.setChecked(r1);
        this.mSwitchPref.setEnabled(this.mWriteSettingsState.permissionDeclared);
        this.mWriteSettingsPrefs.setEnabled(r1);
        getPreferenceScreen().removePreference(this.mWriteSettingsPrefs);
        return true;
    }

    public static CharSequence getSummary(Context r2, com.android.settingslib.applications.ApplicationsState.AppEntry r3) {
        if ((r3.extraInfo instanceof AppStateWriteSettingsBridge.WriteSettingsState) == false) goto L6;
        AppStateWriteSettingsBridge.WriteSettingsState r4 = (AppStateWriteSettingsBridge.WriteSettingsState) r3.extraInfo;
    L10:
        return getSummary(r2, r4);
    L6:
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L8;
        r4 = new AppStateWriteSettingsBridge.WriteSettingsState((AppStateAppOpsBridge.PermissionState) r3.extraInfo);
        goto L10
    L8:
        r4 = new AppStateWriteSettingsBridge(r2, null, null).getWriteSettingsInfo(r3.info.packageName, r3.info.uid);
        goto L10
    }

    public static CharSequence getSummary(Context r0, AppStateWriteSettingsBridge.WriteSettingsState r1) {
        if (r1.isPermissible() == false) goto L5;
        int r2 = R.string.write_settings_on;
    L7:
        return r0.getString(r2);
    L5:
        r2 = R.string.write_settings_off;
        goto L7
    }

    public static CharSequence getSummary(Context r7, String r8) {
        PackageManager r0 = r7.getPackageManager();
        int r1 = R.string.write_settings_off;
        int r2 = 0;
        if (r0 != null) goto L34;
    L11:
        boolean r3 = false;
    L12:
        AppOpsManager r4 = (AppOpsManager) r7.getSystemService("appops");
        List r5 = r4.getPackagesForOps(APP_OPS_OP_CODE);
        if (r5 != null) goto L17;
        return r7.getString(R.string.write_settings_off);
    L17:
        if (r3 == true) goto L20;
        r2 = -1;
    L20:
        Iterator r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L26;
        AppOpsManager.PackageOps r9 = (AppOpsManager.PackageOps) r6.next();
        if (r8.equals(r9.getPackageName()) == false) goto L22;
        r2 = r9.getUid();
    L26:
        if (r2 != (-1)) goto L30;
        return r7.getString(R.string.write_settings_off);
    L30:
        if (r4.noteOpNoThrow(23, r2, r8) != 0) goto L33;
        r1 = R.string.write_settings_on;
    L33:
        return r7.getString(r1);
    L34:
        r3 = true;
        if ((r0.getApplicationInfo(r8, 0).flags & 1) == 0) goto L11;
    L8:
        e = move-exception;
        OLog.w(LOG_TAG, "Package " + r8 + " not found", e);
        return r7.getString(R.string.write_settings_off);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WriteSettingsDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_WriteSettingsDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WriteSettingsDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_WriteSettingsDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WriteSettingsDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_WriteSettingsDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
