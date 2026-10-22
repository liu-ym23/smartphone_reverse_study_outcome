package com.android.settings.applications;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
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
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DrawOverlayDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final int[] APP_OPS_OP_CODE = null;
    private static final String KEY_APP_OPS_SETTINGS_DESC = "app_ops_settings_description";
    private static final String KEY_APP_OPS_SETTINGS_PREFS = "app_ops_settings_preference";
    private static final String KEY_APP_OPS_SETTINGS_SWITCH = "app_ops_settings_switch";
    private static final String LOG_TAG = "DrawOverlayDetails";
    private AppOpsManager mAppOpsManager;
    private AppStateOverlayBridge mOverlayBridge;
    private Preference mOverlayDesc;
    private Preference mOverlayPrefs;
    private AppStateOverlayBridge.OverlayState mOverlayState;
    private Intent mSettingsIntent;
    private SwitchPreference mSwitchPref;

    public void com_android_settings_applications_DrawOverlayDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DrawOverlayDetails() {
    }

    static {
        APP_OPS_OP_CODE = new int[]{24};
    }

    public void com_android_settings_applications_DrawOverlayDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mOverlayBridge = new AppStateOverlayBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
        addPreferencesFromResource(R.xml.app_ops_permissions_details);
        this.mSwitchPref = (SwitchPreference) findPreference(KEY_APP_OPS_SETTINGS_SWITCH);
        this.mOverlayPrefs = findPreference(KEY_APP_OPS_SETTINGS_PREFS);
        this.mOverlayDesc = findPreference(KEY_APP_OPS_SETTINGS_DESC);
        getPreferenceScreen().setTitle(R.string.draw_overlay);
        this.mSwitchPref.setTitle(R.string.permit_draw_overlay);
        this.mOverlayPrefs.setTitle(R.string.app_overlay_permission_preference);
        this.mOverlayDesc.setSummary(R.string.allow_overlay_description);
        this.mSwitchPref.setOnPreferenceChangeListener(this);
        this.mOverlayPrefs.setOnPreferenceClickListener(this);
        this.mSettingsIntent = new Intent("android.intent.action.MAIN").setAction("android.settings.action.MANAGE_OVERLAY_PERMISSION");
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r4) {
        if (r4 == this.mOverlayPrefs) goto L5;
        return false;
    L5:
        if (this.mSettingsIntent == null) goto L16;
        getActivity().startActivityAsUser(this.mSettingsIntent, new UserHandle(this.mUserId));     // Catch: ActivityNotFoundException -> L8
        return true;
    L8:
        e = move-exception;
        OLog.w(LOG_TAG, "Unable to launch app draw overlay settings " + this.mSettingsIntent, e);
        return true;
    L16:
        return true;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        if (r2 == this.mSwitchPref) goto L5;
        return false;
    L5:
        if (this.mOverlayState != null) goto L7;
    L9:
        return true;
    L7:
        if (((Boolean) r3).booleanValue() == this.mOverlayState.isPermissible()) goto L9;
        setCanDrawOverlay(!this.mOverlayState.isPermissible());
        refreshUi();
        goto L9
    }

    private void setCanDrawOverlay(boolean r4) {
        AppOpsManager r0 = this.mAppOpsManager;
        int r1 = this.mPackageInfo.applicationInfo.uid;
        String r3 = this.mPackageName;
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        r0.setMode(24, r1, r3, r5);
        return;
    L5:
        r5 = 2;
        goto L6
    }

    private boolean canDrawOverlay(String r3) {
        if (this.mAppOpsManager.noteOpNoThrow(24, this.mPackageInfo.applicationInfo.uid, r3) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        if (this.mPackageInfo != null) goto L6;
        return false;
    L6:
        AppStateOverlayBridge.OverlayState r0 = this.mOverlayBridge.getOverlayInfo(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        this.mOverlayState = r0;
        boolean r1 = r0.isPermissible();
        this.mSwitchPref.setChecked(r1);
        this.mSwitchPref.setEnabled(this.mOverlayState.permissionDeclared);
        this.mOverlayPrefs.setEnabled(r1);
        getPreferenceScreen().removePreference(this.mOverlayPrefs);
        return true;
    }

    public static CharSequence getSummary(Context r2, com.android.settingslib.applications.ApplicationsState.AppEntry r3) {
        if ((r3.extraInfo instanceof AppStateOverlayBridge.OverlayState) == false) goto L6;
        AppStateOverlayBridge.OverlayState r4 = (AppStateOverlayBridge.OverlayState) r3.extraInfo;
    L10:
        return getSummary(r2, r4);
    L6:
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L8;
        r4 = new AppStateOverlayBridge.OverlayState((AppStateAppOpsBridge.PermissionState) r3.extraInfo);
        goto L10
    L8:
        r4 = new AppStateOverlayBridge(r2, null, null).getOverlayInfo(r3.info.packageName, r3.info.uid);
        goto L10
    }

    public static CharSequence getSummary(Context r0, AppStateOverlayBridge.OverlayState r1) {
        if (r1.isPermissible() == false) goto L5;
        int r2 = R.string.system_alert_window_on;
    L7:
        return r0.getString(r2);
    L5:
        r2 = R.string.system_alert_window_off;
        goto L7
    }

    public static CharSequence getSummary(Context r5, String r6) {
        PackageManager r0 = r5.getPackageManager();
        int r2 = R.string.system_alert_window_off;
        ApplicationInfo r1 = r0.getApplicationInfo(r6, 0);     // Catch: PackageManager.NameNotFoundException -> L16
        int r3 = r1.uid;     // Catch: PackageManager.NameNotFoundException -> L16
        if ((r1.flags & 1) == 0) goto L7;
        return r5.getString(R.string.system_alert_window_on);
    L7:
        AppOpsManager r4 = (AppOpsManager) r5.getSystemService("appops");
        if (r3 != (-1)) goto L12;
        return r5.getString(R.string.system_alert_window_off);
    L12:
        if (r4.noteOpNoThrow(24, r3, r6) != 0) goto L15;
        r2 = R.string.system_alert_window_on;
    L15:
        return r5.getString(r2);
    L16:
        e = move-exception;
        OLog.w(LOG_TAG, "Package " + r6 + " not found", e);
        return r5.getString(R.string.system_alert_window_off);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DrawOverlayDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_DrawOverlayDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DrawOverlayDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DrawOverlayDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_DrawOverlayDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
