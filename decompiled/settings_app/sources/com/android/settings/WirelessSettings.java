package com.android.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TetheringManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.ims.ImsManager;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedPreference;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import org.codeaurora.wfcservice.IWFCService;
import org.codeaurora.wfcservice.IWFCServiceCB;

/* JADX INFO: loaded from: classes2.dex */
public class WirelessSettings extends SettingsPreferenceFragment {
    private static final boolean DEBUG = true;
    public static final String EXIT_ECM_RESULT = "exit_ecm_result";
    private static final String KEY_ANDROID_BEAM_SETTINGS = "android_beam_settings";
    private static final String KEY_MANAGE_MOBILE_PLAN = "manage_mobile_plan";
    private static final String KEY_MOBILE_NETWORK_SETTINGS = "mobile_network_settings";
    private static final String KEY_PROXY_SETTINGS = "proxy_settings";
    private static final String KEY_TETHER_SETTINGS = "tether_settings";
    private static final String KEY_TOGGLE_AIRPLANE = "toggle_airplane";
    private static final String KEY_TOGGLE_NFC = "toggle_nfc";
    private static final String KEY_VPN_SETTINGS = "vpn_settings";
    private static final String KEY_WFC_ENHANCED_SETTINGS = "wifi_calling_enhanced_settings";
    private static final String KEY_WFC_SETTINGS = "wifi_calling_settings";
    private static final String KEY_WIMAX_SETTINGS = "wimax_settings";
    private static final int MANAGE_MOBILE_PLAN_DIALOG_ID = 1;
    public static final int REQUEST_CODE_EXIT_ECM = 1;
    private static final String SAVED_MANAGE_MOBILE_PLAN_MSG = "mManageMobilePlanMessage";
    private static final String TAG = "WirelessSettings";
    private static final String VOICE_OVER_LTE = "voice_over_lte";
    private AirplaneModeEnabler mAirplaneModeEnabler;
    private SwitchPreference mAirplaneModePreference;
    private PreferenceScreen mButtonWfc;
    private IWFCServiceCB mCallback;
    private ConnectivityManager mCm;
    private ServiceConnection mConnection;
    private boolean mEnhancedWFCSettingsEnabled;
    boolean mIsNetworkSettingsAvailable;
    private boolean mLteEnabled;
    private String mManageMobilePlanMessage;
    private NfcAdapter mNfcAdapter;
    private com.android.settings.nfc.NfcEnabler mNfcEnabler;
    private PackageManager mPm;
    private TelephonyManager mTm;
    private UserManager mUm;
    private SwitchPreference mVoLtePreference;
    private IWFCService mWFCService;

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_url_more_networks;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public WirelessSettings() {
        this.mIsNetworkSettingsAvailable = false;
        this.mEnhancedWFCSettingsEnabled = false;
        this.mConnection = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        this.mLteEnabled = false;
    }

    static /* synthetic */ IWFCService access$000(WirelessSettings r0) {
        return r0.mWFCService;
    }

    static /* synthetic */ IWFCService access$002(WirelessSettings r0, IWFCService r1) {
        r0.mWFCService = r1;
        return r1;
    }

    static /* synthetic */ IWFCServiceCB access$100(WirelessSettings r0) {
        return r0.mCallback;
    }

    static /* synthetic */ boolean access$200(WirelessSettings r0) {
        return r0.mEnhancedWFCSettingsEnabled;
    }

    static /* synthetic */ PreferenceScreen access$300(WirelessSettings r0) {
        return r0.mButtonWfc;
    }

    static /* synthetic */ void access$400(WirelessSettings r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ String access$502(WirelessSettings r0, String r1) {
        r0.mManageMobilePlanMessage = r1;
        return r1;
    }

    private void updateCallback() {
        OLog.i(TAG, "call back from settings is called");
    }

    private void unbindWFCService() {
        if (this.mEnhancedWFCSettingsEnabled == true) goto L6;
        return;
    L6:
        if (this.mWFCService != null) goto L13;
    L11:
        getActivity().unbindService(this.mConnection);
        OLog.d(TAG, "WFCService unbind error ");
        return;
    L13:
        OLog.d(TAG, "WFCService unbindService");     // Catch: RemoteException -> L9
        this.mWFCService.unregisterCallback(this.mCallback);     // Catch: RemoteException -> L9
    L9:
        e = move-exception;
        OLog.e(TAG, "WFCService unregister error " + e);
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        unbindWFCService();
        super.onDestroy();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r4) {
        log("onPreferenceTreeClick: preference=" + r4);
        if (r4 != this.mAirplaneModePreference) goto L9;
        if (Boolean.parseBoolean(SystemProperties.get("ril.cdma.inecmmode")) == false) goto L9;
        startActivityForResult(new Intent("android.telephony.action.SHOW_NOTICE_ECM_BLOCK_OTHERS", null), 1);
        return true;
    L9:
        if (r4 != findPreference(KEY_MANAGE_MOBILE_PLAN)) goto L12;
        onManageMobilePlanClick();
    L23:
        return super.onPreferenceTreeClick(r4);
    L12:
        if (this.mLteEnabled == false) goto L17;
        if (r4 != this.mVoLtePreference) goto L17;
        ImsManager.setEnhanced4gLteModeSetting(getActivity(), this.mVoLtePreference.isChecked());
    L17:
        if (r4 != findPreference(KEY_MOBILE_NETWORK_SETTINGS)) goto L23;
        if (this.mIsNetworkSettingsAvailable == false) goto L23;
        onMobileNetworkSettingsClick();
        return true;
    }

    public void onMobileNetworkSettingsClick() {
        log("onMobileNetworkSettingsClick:");
        Intent r0 = new Intent("android.intent.action.MAIN");
        log("qti MobileNetworkSettings Enabled");
        r0.setComponent(new ComponentName("com.qualcomm.qti.networksetting", "com.qualcomm.qti.networksetting.MobileNetworkSettings"));
        startActivity(r0);
    }

    public void onManageMobilePlanClick() {
        log("onManageMobilePlanClick:");
        this.mManageMobilePlanMessage = null;
        Resources r1 = getActivity().getResources();
        NetworkInfo r2 = this.mCm.getActiveNetworkInfo();
        if (this.mTm.hasIccCard() == false) goto L29;
        if (r2 == null) goto L29;
        Intent r3 = new Intent("android.intent.action.ACTION_CARRIER_SETUP");
        List r4 = this.mTm.getCarrierPackageNamesForIntent(r3);
        if (r4 == null) goto L15;
        if (r4.isEmpty() == true) goto L15;
        if (r4.size() == 1) goto L12;
        OLog.w(TAG, "Multiple matching carrier apps found, launching the first.");
    L12:
        r3.setPackage((String) r4.get(0));
        startActivity(r3);
        return;
    L15:
        if (TextUtils.isEmpty(null) == true) goto L21;
        Intent r5 = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
        r5.setData(Uri.parse(null));
        r5.setFlags(272629760);
        startActivity(r5);     // Catch: ActivityNotFoundException -> L19
    L33:
        if (TextUtils.isEmpty(this.mManageMobilePlanMessage) == true) goto L38;
        log("onManageMobilePlanClick: message=" + this.mManageMobilePlanMessage);
        showDialog(1);
        return;
    L38:
        return;
    L19:
        e = move-exception;
        OLog.w(TAG, "onManageMobilePlanClick: startActivity failed" + e);
        goto L33
    L21:
        String r0 = this.mTm.getSimOperatorName();
        if (TextUtils.isEmpty(r0) == false) goto L27;
        String r6 = this.mTm.getNetworkOperatorName();
        if (TextUtils.isEmpty(r6) == false) goto L26;
        this.mManageMobilePlanMessage = r1.getString(R.string.mobile_unknown_sim_operator);
        goto L33
    L26:
        this.mManageMobilePlanMessage = r1.getString(R.string.mobile_no_provisioning_url, new Object[]{r6});
        goto L33
    L27:
        this.mManageMobilePlanMessage = r1.getString(R.string.mobile_no_provisioning_url, new Object[]{r0});
    L29:
        if (this.mTm.hasIccCard() == true) goto L31;
        this.mManageMobilePlanMessage = r1.getString(R.string.mobile_insert_sim_card);
        goto L33
    L31:
        this.mManageMobilePlanMessage = r1.getString(R.string.mobile_connect_to_internet);
        goto L33
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r3) {
        log("onCreateDialog: dialogId=" + r3);
        if (r3 == 1) goto L7;
        return super.onCreateDialog(r3);
    L7:
        return new AlertDialog.Builder(getActivity()).setMessage(this.mManageMobilePlanMessage).setCancelable(false).setPositiveButton(android.R.string.ok, new AnonymousClass3(this)).create();
    }

    public static boolean isRadioAllowed(Context r2, String r3) {
        if (AirplaneModeEnabler.isAirplaneModeOn(r2) == true) goto L5;
        return true;
    L5:
        String r4 = android.provider.Settings.Global.getString(r2.getContentResolver(), "airplane_mode_toggleable_radios");
        if (r4 != null) goto L8;
    L10:
        return false;
    L8:
        if (r4.contains(r3) == false) goto L10;
        return true;
    }

    private void log(String r1) {
        OLog.d(TAG, r1);
    }

    public void com_android_settings_WirelessSettings__onCreate$___twin___(Bundle r15) {
        super.onCreate(r15);
        if (r15 == null) goto L5;
        this.mManageMobilePlanMessage = r15.getString(SAVED_MANAGE_MOBILE_PLAN_MSG);
    L5:
        log("onCreate: mManageMobilePlanMessage=" + this.mManageMobilePlanMessage);
        this.mCm = (ConnectivityManager) getSystemService("connectivity");
        this.mTm = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        this.mPm = getPackageManager();
        this.mUm = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        addPreferencesFromResource(R.xml.wireless_settings);
        boolean r16 = this.mUm.isAdminUser();
        FragmentActivity r0 = getActivity();
        this.mAirplaneModePreference = (SwitchPreference) findPreference(KEY_TOGGLE_AIRPLANE);
        SwitchPreference r3 = (SwitchPreference) findPreference(KEY_TOGGLE_NFC);
        RestrictedPreference r5 = (RestrictedPreference) findPreference(KEY_ANDROID_BEAM_SETTINGS);
        this.mAirplaneModeEnabler = null;
        this.mNfcEnabler = new com.android.settings.nfc.NfcEnabler(r0, r3, r5);
        boolean r7 = getActivity().getResources().getBoolean(R.bool.wifi_call_enhanced_setting);
        this.mEnhancedWFCSettingsEnabled = r7;
        if (r7 == false) goto L8;
        this.mButtonWfc = (PreferenceScreen) findPreference(KEY_WFC_ENHANCED_SETTINGS);
        removePreference(KEY_WFC_SETTINGS);
    L9:
        boolean r8 = true;
        if (this.mEnhancedWFCSettingsEnabled == false) goto L12;
        Intent r9 = new Intent();
        r9.setAction("com.qualcomm.qti.wfcservice.IWFCService");
        r9.setPackage("com.qualcomm.qti.wfcservice");
        r0.bindService(r9, this.mConnection, 1);
    L12:
        String r10 = android.provider.Settings.Global.getString(r0.getContentResolver(), "airplane_mode_toggleable_radios");
        if (r16 == true) goto L15;
    L17:
        boolean r11 = false;
    L19:
        if (r11 == true) goto L21;
    L28:
        PreferenceScreen r12 = getPreferenceScreen();
        Preference r13 = findPreference(KEY_WIMAX_SETTINGS);
        if (r13 == null) goto L32;
        r12.removePreference(r13);
    L32:
        if (r10 != null) goto L34;
    L35:
        findPreference(KEY_VPN_SETTINGS).setDependency(KEY_TOGGLE_AIRPLANE);
    L36:
        if (r16 == true) goto L38;
    L39:
        removePreference(KEY_VPN_SETTINGS);
    L40:
        if (r10 == null) goto L42;
        r10.contains("bluetooth");
    L42:
        if (r10 != null) goto L44;
    L45:
        findPreference(KEY_TOGGLE_NFC).setDependency(KEY_TOGGLE_AIRPLANE);
        findPreference(KEY_ANDROID_BEAM_SETTINGS).setDependency(KEY_TOGGLE_AIRPLANE);
    L46:
        NfcAdapter r2 = NfcAdapter.getDefaultAdapter(r0);
        this.mNfcAdapter = r2;
        if (r2 != null) goto L50;
        getPreferenceScreen().removePreference(r3);
        getPreferenceScreen().removePreference(r5);
        this.mNfcEnabler = null;
    L50:
        if (r16 == true) goto L52;
    L57:
        removePreference(KEY_MOBILE_NETWORK_SETTINGS);
        removePreference(KEY_MANAGE_MOBILE_PLAN);
    L59:
        if (getResources().getBoolean(R.bool.config_show_mobile_plan) == true) goto L64;
        if (findPreference(KEY_MANAGE_MOBILE_PLAN) == null) goto L64;
        removePreference(KEY_MANAGE_MOBILE_PLAN);
    L64:
        if (this.mPm.hasSystemFeature("android.hardware.type.television") == false) goto L66;
        removePreference(KEY_TOGGLE_AIRPLANE);
    L66:
        Preference r17 = findPreference(KEY_PROXY_SETTINGS);
        DevicePolicyManager r1 = (DevicePolicyManager) r0.getSystemService("device_policy");
        getPreferenceScreen().removePreference(r17);
        if (r1.getGlobalProxyAdmin() != null) goto L69;
        boolean r4 = true;
    L70:
        r17.setEnabled(r4);
        TetheringManager r18 = (TetheringManager) r0.getSystemService(TetheringManager.class);
        boolean r6 = r0.getResources().getBoolean(R.bool.config_settings_rjil_layout);
        if (r6 == false) goto L74;
        removePreference(KEY_MOBILE_NETWORK_SETTINGS);
    L74:
        if (MultiSDKAdapterNew.checkIfRestrictionEnforced(r0, "no_config_tethering", UserHandle.myUserId()) != null) goto L78;
        r8 = false;
    L78:
        if (r18.isTetheringSupported() == true) goto L81;
        if (r8 == true) goto L81;
    L92:
        getPreferenceScreen().removePreference(findPreference(KEY_TETHER_SETTINGS));
        return;
    L81:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r0, "no_config_tethering", UserHandle.myUserId()) == true) goto L92;
        if (r6 == true) goto L92;
        if (r8 == true) goto L94;
        Preference r14 = findPreference(KEY_TETHER_SETTINGS);
        r14.setTitle(com.android.settingslib.Utils.getTetheringLabel(r18));
        if (getResources().getBoolean(R.bool.config_tethering_settings_display_summary_Tmobile) == false) goto L88;
        ((RestrictedPreference) r14).useAdminDisabledSummary(false);
        r14.setSummary(R.string.tethering_settings_summary);
    L88:
        this.mLteEnabled = getActivity().getResources().getBoolean(R.bool.config_voice_over_lte_enabled);
        SwitchPreference r19 = (SwitchPreference) findPreference(VOICE_OVER_LTE);
        this.mVoLtePreference = r19;
        if (this.mLteEnabled == false) goto L91;
        r19.setChecked(ImsManager.isEnhanced4gLteModeSettingEnabledByUser(getActivity()));
        return;
    L91:
        getPreferenceScreen().removePreference(this.mVoLtePreference);
        return;
    L94:
        return;
    L69:
        r4 = false;
        goto L70
    L52:
        if (Utils.isWifiOnly(getActivity()) == true) goto L57;
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r0, "no_config_mobile_networks", UserHandle.myUserId()) == true) goto L57;
        this.mIsNetworkSettingsAvailable = Utils.isNetworkSettingsApkAvailable(getActivity());
        goto L59
    L44:
        if (r10.contains(SettingsSwitchKeyUtil.NFC) == true) goto L46;
    L38:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r0, "no_config_vpn", UserHandle.myUserId()) == false) goto L40;
    L34:
        if (r10.contains("wifi") == true) goto L36;
    L21:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r0, "no_config_mobile_networks", UserHandle.myUserId()) == true) goto L28;
        if (r10 != null) goto L25;
    L27:
        findPreference(KEY_WIMAX_SETTINGS).setDependency(KEY_TOGGLE_AIRPLANE);
        goto L32
    L25:
        if (r10.contains("wimax") == true) goto L32;
        if (r11 == false) goto L32;
    L15:
        if (getResources().getBoolean(android.R.bool.device_idle_light_idle_increase_linearly) == false) goto L17;
        r11 = true;
        goto L19
    L8:
        this.mButtonWfc = (PreferenceScreen) findPreference(KEY_WFC_SETTINGS);
        removePreference(KEY_WFC_ENHANCED_SETTINGS);
        goto L9
    }

    public void com_android_settings_WirelessSettings__onResume$___twin___() {
        super.onResume();
        AirplaneModeEnabler r0 = this.mAirplaneModeEnabler;
        if (r0 == null) goto L5;
        r0.resume();
    L5:
        com.android.settings.nfc.NfcEnabler r1 = this.mNfcEnabler;
        if (r1 == null) goto L8;
        r1.resume();
    L8:
        FragmentActivity r2 = getActivity();
        if (ImsManager.isWfcEnabledByPlatform(r2) == false) goto L17;
        getPreferenceScreen().addPreference(this.mButtonWfc);
        if (this.mEnhancedWFCSettingsEnabled == true) goto L14;
        return;
    L14:
        if (ImsManager.isWfcEnabledByUser(r2) == true) goto L16;
        this.mButtonWfc.setSummary(R.string.disabled);
        return;
    L16:
        this.mButtonWfc.setSummary(SystemProperties.get("sys.wificall.status.msg"));
        return;
    L17:
        log("WFC not supported. Remove WFC menu");
        if (this.mButtonWfc == null) goto L23;
        getPreferenceScreen().removePreference(this.mButtonWfc);
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        if (TextUtils.isEmpty(this.mManageMobilePlanMessage) == true) goto L6;
        r2.putString(SAVED_MANAGE_MOBILE_PLAN_MSG, this.mManageMobilePlanMessage);
        return;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AirplaneModeEnabler r0 = this.mAirplaneModeEnabler;
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        com.android.settings.nfc.NfcEnabler r1 = this.mNfcEnabler;
        if (r1 == null) goto L9;
        r1.pause();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        if (r4 != 1) goto L7;
        Boolean r0 = Boolean.valueOf(r6.getBooleanExtra(EXIT_ECM_RESULT, false));
        AirplaneModeEnabler r1 = this.mAirplaneModeEnabler;
        if (r1 == null) goto L7;
        r1.setAirplaneModeInECM(r0.booleanValue(), this.mAirplaneModePreference.isChecked());
    L7:
        super.onActivityResult(r4, r5, r6);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WirelessSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WirelessSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WirelessSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_WirelessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WirelessSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_WirelessSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
