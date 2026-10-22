package com.android.settings.wifi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.AdaptWifiConfig;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SavedAccessPointsWifiSettings extends SettingsPreferenceFragment23 implements DialogInterface.OnClickListener, Indexable {
    private static final String SAVE_DIALOG_ACCESS_POINT_STATE = "wifi_ap_state";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final String TAG = "SavedAccessPointsWifiSettings";
    private Bundle mAccessPointSavedState;
    private WifiDialog mDialog;
    private AccessPoint mDlgAccessPoint;
    private AccessPoint mSelectedAccessPoint;
    private WifiManager mWifiManager;

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SavedAccessPointsWifiSettings() {
    }

    static /* synthetic */ List access$000(Context r0, WifiManager r1) {
        return constructSavedAccessPoints(r0, r1);
    }

    public void com_android_settings_wifi_SavedAccessPointsWifiSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        addPreferencesFromResource(R.xml.wifi_display_saved_access_points);
    }

    public void com_android_settings_wifi_SavedAccessPointsWifiSettings__onResume$___twin___() {
        super.onResume();
        initPreferences();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        this.mWifiManager = (WifiManager) getSystemService("wifi");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.containsKey(SAVE_DIALOG_ACCESS_POINT_STATE) == false) goto L9;
        this.mAccessPointSavedState = r3.getBundle(SAVE_DIALOG_ACCESS_POINT_STATE);
        return;
    }

    private void initPreferences() {
        PreferenceScreen r0 = getPreferenceScreen();
        FragmentActivity r1 = getActivity();
        WifiManager r2 = (WifiManager) r1.getSystemService("wifi");
        this.mWifiManager = r2;
        List<AccessPoint> r3 = constructSavedAccessPoints(r1, r2);
        r0.removeAll();
        int r4 = r3.size();
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L6;
        r0.addPreference(r3.get(r5));
        r5 = r5 + 1;
        goto L3
    L6:
        if (getPreferenceScreen().getPreferenceCount() >= 1) goto L10;
        OLog.w(TAG, "Saved networks activity loaded, but there are no saved networks!");
        return;
    }

    private static List<AccessPoint> constructSavedAccessPoints(Context r12, WifiManager r13) {
        ArrayList r0 = new ArrayList();
        HashMap r1 = new HashMap();
        List<WifiConfiguration> r3 = r13.getConfiguredNetworks();     // Catch: RuntimeException -> L5
    L7:
        List<ScanResult> r14 = r13.getScanResults();
        if (r3 == null) goto L29;
        int r4 = r14.size();
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L15;
        ScanResult r7 = r14.get(r6);
        List r8 = (List) r1.get(r7.SSID);
        if (r8 != null) goto L14;
        r8 = new ArrayList();
        r1.put(r7.SSID, r8);
    L14:
        r8.add(r7);
        r6 = r6 + 1;
        goto L10
    L15:
        int r15 = r3.size();
        int r5 = 0;
    L16:
        if (r5 >= r15) goto L29;
        WifiConfiguration r9 = r3.get(r5);
        if (new AdaptWifiConfig(r9).getSelfAdded() == true) goto L20;
    L22:
        AccessPoint r10 = new AccessPoint(r12, r9);
        List r11 = (List) r1.get(r10.ssid);
        r10.setShowSummary(false);
        if (r11 == null) goto L27;
        int r16 = r11.size();
        int r17 = 0;
    L25:
        if (r17 >= r16) goto L27;
        r10.update((ScanResult) r11.get(r17), R.drawable.selector_setting_sub_item_bg_middle);
        r10.setIcon(null);
        r17 = r17 + 1;
    L27:
        r0.add(r10);
    L28:
        r5 = r5 + 1;
        goto L16
    L20:
        if (r9.numAssociation != 0) goto L22;
    L29:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        r3 = null;
        goto L7
    }

    private void showDialog(AccessPoint r2, boolean r3) {
        if (this.mDialog == null) goto L5;
        removeDialog(1);
        this.mDialog = null;
    L5:
        this.mDlgAccessPoint = r2;
        showDialog(1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r3) {
        if (r3 == 1) goto L7;
        return super.onCreateDialog(r3);
    L7:
        if (this.mDlgAccessPoint != null) goto L9;
        this.mDlgAccessPoint = new AccessPoint(getActivity(), this.mAccessPointSavedState);
        this.mAccessPointSavedState = null;
    L9:
        this.mSelectedAccessPoint = this.mDlgAccessPoint;
        return this.mDialog;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        WifiDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == true) goto L7;
        return;
    L7:
        if (this.mDlgAccessPoint == null) goto L12;
        Bundle r1 = new Bundle();
        this.mAccessPointSavedState = r1;
        this.mDlgAccessPoint.saveWifiState(r1);
        r3.putBundle(SAVE_DIALOG_ACCESS_POINT_STATE, this.mAccessPointSavedState);
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (r3 != (-3)) goto L8;
        AccessPoint r4 = this.mSelectedAccessPoint;
        if (r4 == null) goto L9;
        this.mWifiManager.forget(r4.networkId, null);
        getPreferenceScreen().removePreference(this.mSelectedAccessPoint);
        this.mSelectedAccessPoint = null;
        return;
    L9:
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r2) {
        if ((r2 instanceof AccessPoint) == false) goto L7;
        showDialog((AccessPoint) r2, false);
        return true;
    L7:
        return super.onPreferenceTreeClick(r2);
    }

    static {
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass1();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SavedAccessPointsWifiSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SavedAccessPointsWifiSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SavedAccessPointsWifiSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_SavedAccessPointsWifiSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SavedAccessPointsWifiSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_SavedAccessPointsWifiSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
