package com.android.settings.applications.appinfo;

import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.AppInfoWithHeader;
import com.android.settings.applications.AppStateAppOpsBridge;
import com.android.settings.applications.AppStateOverlayBridge;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.ApplicationsState;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DrawOverlayDetails extends AppInfoWithHeader implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final String KEY_APP_OPS_SETTINGS_SWITCH = "app_ops_settings_switch";
    private static final String LOG_TAG = "DrawOverlayDetails";
    private AppOpsManager mAppOpsManager;
    private OListItemSwitch mCheckSwitch;
    private AppStateOverlayBridge mOverlayBridge;
    private AppStateOverlayBridge.OverlayState mOverlayState;
    private TwoStatePreference mSwitchPref;

    public void com_android_settings_applications_appinfo_DrawOverlayDetails__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected AlertDialog createDialog(int r1, int r2) {
        return null;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment
    public int getMetricsCategory() {
        return UCharacter.UnicodeBlock.BASSA_VAH_ID;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r1) {
        return false;
    }

    @Override // com.android.settings.applications.AppInfoBase, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DrawOverlayDetails() {
        this.mSwitchPref = null;
    }

    static /* synthetic */ AppStateOverlayBridge.OverlayState access$000(DrawOverlayDetails r0) {
        return r0.mOverlayState;
    }

    static /* synthetic */ void access$100(DrawOverlayDetails r0, boolean r1) {
        r0.setCanDrawOverlay(r1);
    }

    public void com_android_settings_applications_appinfo_DrawOverlayDetails__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mOverlayBridge = new AppStateOverlayBridge(r5, this.mState, null);
        this.mAppOpsManager = (AppOpsManager) r5.getSystemService("appops");
        if (Utils.isSystemAlertWindowEnabled(r5) == true) goto L6;
        this.mPackageInfo = null;
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        if (this.mPackageInfo != null) goto L7;
        return r1.inflate(R.layout.manage_applications_apps_unsupported, null);
    L7:
        return r1.inflate(R.layout.special_access_common_permission_details, null);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mOverlayState = this.mOverlayBridge.getOverlayInfo(this.mPackageName, this.mPackageInfo.applicationInfo.uid);
        OListItemSwitch r5 = (OListItemSwitch) r3.findViewById(R.id.item_switch);
        this.mCheckSwitch = r5;
        r5.setTitleString(getString(R.string.permit_draw_overlay));
        this.mCheckSwitch.setChecked(this.mOverlayState.isPermissible());
        this.mCheckSwitch.setEnabled(this.mOverlayState.permissionDeclared);
        this.mCheckSwitch.setOnCheckedChangeListener(new AnonymousClass1(this));
        ((TextView) r3.findViewById(R.id.tv_desc)).setText(R.string.allow_overlay_description);
        refreshUi();
    }

    @Override // com.android.settings.applications.AppInfoBase, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mOverlayBridge.release();
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
        logSpecialPermissionChange(r4, this.mPackageName);
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

    void logSpecialPermissionChange(boolean r3, String r4) {
        if (r3 == false) goto L4;
        int r2 = 770;
    L5:
        OLog.i(TAG, "logSpecialPermissionChange logCategory=" + r2 + ", packageName=" + r4);
        return;
    L4:
        r2 = 771;
        goto L5
    }

    @Override // com.android.settings.applications.AppInfoBase
    protected boolean refreshUi() {
        PackageInfo r0 = this.mPackageInfo;
        return true;
    }

    public static CharSequence getSummary(Context r2, ApplicationsState.AppEntry r3) {
        if (r3 != null) goto L6;
        return "";
    L6:
        if ((r3.extraInfo instanceof AppStateOverlayBridge.OverlayState) == false) goto L9;
        AppStateOverlayBridge.OverlayState r4 = (AppStateOverlayBridge.OverlayState) r3.extraInfo;
    L13:
        return getSummary(r2, r4);
    L9:
        if ((r3.extraInfo instanceof AppStateAppOpsBridge.PermissionState) == false) goto L11;
        r4 = new AppStateOverlayBridge.OverlayState((AppStateAppOpsBridge.PermissionState) r3.extraInfo);
        goto L13
    L11:
        r4 = new AppStateOverlayBridge(r2, null, null).getOverlayInfo(r3.info.packageName, r3.info.uid);
        goto L13
    }

    public static CharSequence getSummary(Context r0, AppStateOverlayBridge.OverlayState r1) {
        if (r1.isPermissible() == false) goto L5;
        int r2 = R.string.app_permission_summary_allowed;
    L7:
        return r0.getString(r2);
    L5:
        r2 = R.string.app_permission_summary_not_allowed;
        goto L7
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DrawOverlayDetails r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_DrawOverlayDetails__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DrawOverlayDetails r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_appinfo_DrawOverlayDetails_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DrawOverlayDetails r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_appinfo_DrawOverlayDetails__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
