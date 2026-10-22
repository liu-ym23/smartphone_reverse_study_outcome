package com.android.settings;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.SearchIndexableResource;
import android.telephony.CarrierConfigManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreferenceCompat;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.fingerprint.FingerprintEnrollIntroduction;
import com.android.settings.fingerprint.FingerprintSettings;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Index;
import com.android.settings.search.Indexable;
import com.android.settings.search.SearchIndexableRaw;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SecuritySettings extends SettingsPreferenceFragment23 implements Preference.OnPreferenceChangeListener, DialogInterface.OnClickListener, Indexable {
    private static final int CHANGE_TRUST_AGENT_SETTINGS = 126;
    private static final String KEY_ADVANCED_SECURITY = "advanced_security";
    private static final String KEY_CREDENTIALS_INSTALL = "credentials_install";
    private static final String KEY_CREDENTIALS_MANAGER = "credentials_management";
    private static final String KEY_CREDENTIAL_STORAGE_TYPE = "credential_storage_type";
    private static final String KEY_DEVICE_ADMIN_CATEGORY = "device_admin_category";
    private static final String KEY_FINGERPRINT_SETTINGS = "fingerprint_settings";
    private static final String KEY_LOCK_AFTER_TIMEOUT = "lock_after_timeout";
    private static final String KEY_MANAGE_TRUST_AGENTS = "manage_trust_agents";
    private static final String KEY_OWNER_INFO_SETTINGS = "owner_info_settings";
    private static final String KEY_POWER_INSTANTLY_LOCKS = "power_button_instantly_locks";
    private static final String KEY_RESET_CREDENTIALS = "credentials_reset";
    private static final String KEY_SCREEN_PINNING = "screen_pinning_settings";
    private static final String KEY_SECURITY_CATEGORY = "security_category";
    private static final String KEY_SHOW_PASSWORD = "show_password";
    private static final String KEY_SIM_LOCK = "sim_lock";
    private static final String KEY_TOGGLE_INSTALL_APPLICATIONS = "toggle_install_applications";
    private static final String KEY_TRUST_AGENT = "trust_agent";
    private static final String KEY_UNLOCK_SET_OR_CHANGE = "unlock_set_or_change";
    private static final String KEY_VISIBLE_PATTERN = "visiblepattern";
    private static final int MY_USER_ID = 0;
    private static final boolean ONLY_ONE_TRUST_AGENT = true;
    private static final String PACKAGE_MIME_TYPE = "application/vnd.android.package-archive";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final int SET_OR_CHANGE_LOCK_METHOD_REQUEST = 123;
    private static final String[] SWITCH_PREFERENCE_KEYS = null;
    private static final String TAG = "SecuritySettings";
    private static final String TRUST_AGENT_CLICK_INTENT = "trust_agent_click_intent";
    private static final Intent TRUST_AGENT_INTENT = null;
    private ChooseLockSettingsHelper mChooseLockSettingsHelper;
    private DevicePolicyManager mDPM;
    private boolean mIsPrimary;
    private ListPreference mLockAfter;
    private LockPatternUtils mLockPatternUtils;
    private Preference mOwnerInfoPref;
    private SwitchPreferenceCompat mPowerButtonInstantlyLocks;
    private Preference mResetCredentials;
    private SwitchPreferenceCompat mShowPassword;
    private SwitchPreferenceCompat mToggleAppInstallation;
    private Intent mTrustAgentClickIntent;
    private SwitchPreferenceCompat mVisiblePattern;
    private DialogInterface mWarnInstallApps;

    private static class SecuritySearchIndexProvider extends BaseSearchIndexProvider {
        boolean mIsPrimary;

        public SecuritySearchIndexProvider() {
            if (SecuritySettings.access$000() != 0) goto L5;
            boolean r0 = true;
        L6:
            this.mIsPrimary = r0;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.android.settings.search.BaseSearchIndexProvider, com.android.settings.search.Indexable.SearchIndexProvider
        public List<SearchIndexableResource> getXmlResourcesToIndex(Context r3, boolean r4) {
            ArrayList r5 = new ArrayList();
            int r0 = SecuritySettings.access$100(r3, new LockPatternUtils(r3));
            SearchIndexableResource r1 = new SearchIndexableResource(r3);
            r1.xmlResId = r0;
            r5.add(r1);
            if (this.mIsPrimary == false) goto L12;
            int r2 = ((DevicePolicyManager) r3.getSystemService("device_policy")).getStorageEncryptionStatus();
            if (r2 != 1) goto L7;
            r0 = R.xml.security_settings_unencrypted;
        L11:
            SearchIndexableResource r6 = new SearchIndexableResource(r3);
            r6.xmlResId = r0;
            r5.add(r6);
            goto L12
        L7:
            if (r2 != 3) goto L11;
            r0 = R.xml.security_settings_encrypted;
        L12:
            SearchIndexableResource r7 = new SearchIndexableResource(r3);
            r7.xmlResId = R.xml.security_settings_misc;
            r5.add(r7);
            return r5;
        }

        @Override // com.android.settings.search.BaseSearchIndexProvider, com.android.settings.search.Indexable.SearchIndexProvider
        public List<SearchIndexableRaw> getRawDataToIndex(Context r5, boolean r6) {
            ArrayList r7 = new ArrayList();
            Resources r0 = r5.getResources();
            String r1 = r0.getString(R.string.security_settings_title);
            SearchIndexableRaw r2 = new SearchIndexableRaw(r5);
            r2.title = r1;
            r2.screenTitle = r1;
            r7.add(r2);
            if (this.mIsPrimary == true) goto L10;
            if (UserManager.get(r5).isLinkedUser() == false) goto L7;
            int r4 = R.string.profile_info_settings_title;
        L8:
            SearchIndexableRaw r3 = new SearchIndexableRaw(r5);
            r3.title = r0.getString(r4);
            r3.screenTitle = r1;
            r7.add(r3);
            goto L10
        L7:
            r4 = R.string.user_info_settings_title;
        L10:
            if (((FingerprintManager) NullSafe.nonNull(r5.getSystemService("fingerprint"))).isHardwareDetected() == false) goto L12;
            SearchIndexableRaw r8 = new SearchIndexableRaw(r5);
            r8.title = r0.getString(R.string.security_settings_fingerprint_preference_title);
            r8.screenTitle = r1;
            r7.add(r8);
        L12:
            int r9 = 0;
            if (((UserManager) r5.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_credentials") == true) goto L15;
            SearchIndexableRaw r10 = new SearchIndexableRaw(r5);
            r10.title = r0.getString(0);
            r10.screenTitle = r1;
            r7.add(r10);
        L15:
            LockPatternUtils r11 = new LockPatternUtils(r5);
            if (r11.isSecure(SecuritySettings.access$000()) == false) goto L21;
            ArrayList r12 = SecuritySettings.access$200(r5.getPackageManager(), r11, (DevicePolicyManager) r5.getSystemService(DevicePolicyManager.class));
        L19:
            if (r9 >= r12.size()) goto L21;
            TrustAgentUtils.TrustAgentComponentInfo r13 = (TrustAgentUtils.TrustAgentComponentInfo) r12.get(r9);
            SearchIndexableRaw r14 = new SearchIndexableRaw(r5);
            r14.title = r13.title;
            r14.screenTitle = r1;
            r7.add(r14);
            r9 = r9 + 1;
        L21:
            return r7;
        }

        @Override // com.android.settings.search.BaseSearchIndexProvider, com.android.settings.search.Indexable.SearchIndexProvider
        public List<String> getNonIndexableKeys(Context r4) {
            ArrayList r0 = new ArrayList();
            LockPatternUtils r1 = new LockPatternUtils(r4);
            SecuritySettings.access$100(r4, r1);
            TelephonyManager r2 = TelephonyManager.getDefault();
            if (this.mIsPrimary == true) goto L5;
        L6:
            r0.add(SecuritySettings.KEY_SIM_LOCK);
        L8:
            if (((UserManager) r4.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_config_credentials") == false) goto L11;
            r0.add(SecuritySettings.KEY_CREDENTIALS_MANAGER);
        L11:
            if (r1.isSecure(SecuritySettings.access$000()) == true) goto L13;
            r0.add(SecuritySettings.KEY_TRUST_AGENT);
            r0.add(SecuritySettings.KEY_MANAGE_TRUST_AGENTS);
        L13:
            return r0;
        L5:
            if (r2.hasIccCard() == true) goto L8;
            goto L6
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23
    protected int getHelpResource() {
        return R.string.help_url_security;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SecuritySettings() {
    }

    static /* synthetic */ int access$000() {
        return MY_USER_ID;
    }

    static /* synthetic */ int access$100(Context r0, LockPatternUtils r1) {
        return getResIdForLockUnlockScreen(r0, r1);
    }

    static /* synthetic */ ArrayList access$200(PackageManager r0, LockPatternUtils r1, DevicePolicyManager r2) {
        return getActiveTrustAgents(r0, r1, r2);
    }

    static {
        TRUST_AGENT_INTENT = new Intent("android.service.trust.TrustAgentService");
        SWITCH_PREFERENCE_KEYS = new String[]{KEY_LOCK_AFTER_TIMEOUT, KEY_VISIBLE_PATTERN, KEY_POWER_INSTANTLY_LOCKS, KEY_SHOW_PASSWORD, KEY_TOGGLE_INSTALL_APPLICATIONS};
        MY_USER_ID = UserHandle.myUserId();
        SEARCH_INDEX_DATA_PROVIDER = new SecuritySearchIndexProvider();
    }

    public void com_android_settings_SecuritySettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
        this.mDPM = (DevicePolicyManager) getSystemService("device_policy");
        this.mChooseLockSettingsHelper = new ChooseLockSettingsHelper(getActivity());
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.containsKey(TRUST_AGENT_CLICK_INTENT) == false) goto L9;
        this.mTrustAgentClickIntent = (Intent) r3.getParcelable(TRUST_AGENT_CLICK_INTENT);
        return;
    }

    private static int getResIdForLockUnlockScreen(Context r1, LockPatternUtils r2) {
        int r3 = MY_USER_ID;
        if (r2.isSecure(r3) == false) goto L5;
        int r4 = r2.getKeyguardStoredPasswordQuality(r3);
        if (r4 != 65536) goto L11;
        return R.xml.security_settings_pattern;
    L11:
        if (r4 != 131072) goto L13;
    L22:
        return R.xml.security_settings_pin;
    L13:
        if (r4 == 196608) goto L22;
        if (r4 != 262144) goto L17;
    L21:
        return R.xml.security_settings_password;
    L17:
        if (r4 == 327680) goto L21;
        if (r4 == 393216) goto L21;
        return 0;
    L5:
        if (r2.isLockScreenDisabled(r3) == false) goto L7;
        return R.xml.security_settings_lockscreen;
    L7:
        return R.xml.security_settings_chooser;
    }

    private PreferenceScreen createPreferenceHierarchy() {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L5;
        r0.removeAll();
    L5:
        addPreferencesFromResource(R.xml.security_settings);
        PreferenceScreen r1 = getPreferenceScreen();
        addPreferencesFromResource(getResIdForLockUnlockScreen(getActivity(), this.mLockPatternUtils));
        int r2 = MY_USER_ID;
        int r3 = 0;
        if (r2 != 0) goto L8;
        boolean r4 = true;
    L9:
        this.mIsPrimary = r4;
        Preference r5 = findPreference(KEY_OWNER_INFO_SETTINGS);
        this.mOwnerInfoPref = r5;
        if (r5 == null) goto L13;
        r5.setOnPreferenceClickListener(new AnonymousClass1(this));
    L13:
        if (this.mIsPrimary == true) goto L15;
    L18:
        PreferenceGroup r6 = (PreferenceGroup) r1.findPreference(KEY_SECURITY_CATEGORY);
        if (r6 == null) goto L21;
        maybeAddFingerprintPreference(r6);
        addTrustAgentSettings(r6);
    L21:
        ListPreference r7 = (ListPreference) r1.findPreference(KEY_LOCK_AFTER_TIMEOUT);
        this.mLockAfter = r7;
        if (r7 == null) goto L24;
        setupLockAfterPreference();
        updateLockAfterPreferenceSummary();
    L24:
        this.mVisiblePattern = (SwitchPreferenceCompat) r1.findPreference(KEY_VISIBLE_PATTERN);
        this.mPowerButtonInstantlyLocks = (SwitchPreferenceCompat) r1.findPreference(KEY_POWER_INSTANTLY_LOCKS);
        Preference r8 = r1.findPreference(KEY_TRUST_AGENT);
        if (this.mPowerButtonInstantlyLocks == null) goto L30;
        if (r8 == null) goto L30;
        if (r8.getTitle().length() <= 0) goto L30;
        this.mPowerButtonInstantlyLocks.setSummary(getString(R.string.lockpattern_settings_power_button_instantly_locks_summary, new Object[]{r8.getTitle()}));
    L30:
        addPreferencesFromResource(R.xml.security_settings_misc);
        TelephonyManager.getDefault();
        PersistableBundle r9 = ((CarrierConfigManager) getActivity().getSystemService("carrier_config")).getConfig();
        if (this.mIsPrimary == false) goto L35;
        if (r9 == null) goto L37;
        if (r9.getBoolean("hide_sim_lock_settings_bool") == true) goto L35;
    L37:
        if (android.provider.Settings.System.getInt(getContentResolver(), "lock_to_app_enabled", 0) == 0) goto L39;
        r1.findPreference(KEY_SCREEN_PINNING).setSummary(getResources().getString(R.string.switch_on_text));
    L39:
        this.mShowPassword = (SwitchPreferenceCompat) r1.findPreference(KEY_SHOW_PASSWORD);
        this.mResetCredentials = r1.findPreference(KEY_RESET_CREDENTIALS);
        UserManager r10 = (UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r10.hasUserRestriction("no_config_credentials") == true) goto L42;
        r1.findPreference(KEY_CREDENTIAL_STORAGE_TYPE).setSummary(0);
    L43:
        PreferenceGroup r11 = (PreferenceGroup) r1.findPreference(KEY_DEVICE_ADMIN_CATEGORY);
        SwitchPreferenceCompat r12 = (SwitchPreferenceCompat) findPreference(KEY_TOGGLE_INSTALL_APPLICATIONS);
        this.mToggleAppInstallation = r12;
        r12.setChecked(isNonMarketAppsAllowed());
        this.mToggleAppInstallation.setEnabled(this.mIsPrimary);
        if (r10.hasUserRestriction("no_install_unknown_sources") == false) goto L46;
    L47:
        this.mToggleAppInstallation.setEnabled(false);
    L48:
        PreferenceGroup r13 = (PreferenceGroup) r1.findPreference(KEY_ADVANCED_SECURITY);
        if (r13 == null) goto L55;
        Preference r14 = r13.findPreference(KEY_MANAGE_TRUST_AGENTS);
        if (r14 == null) goto L55;
        if (this.mLockPatternUtils.isSecure(r2) == true) goto L55;
        r14.setEnabled(false);
        r14.setSummary(R.string.disabled_because_no_backup_security);
    L55:
        Index.getInstance(getActivity()).updateFromClassNameResource(SecuritySettings.class.getName(), true, true);
    L56:
        String[] r15 = SWITCH_PREFERENCE_KEYS;
        if (r3 >= r15.length) goto L62;
        Preference r16 = findPreference(r15[r3]);
        if (r16 == null) goto L61;
        r16.setOnPreferenceChangeListener(this);
    L61:
        r3 = r3 + 1;
        goto L56
    L62:
        return r1;
    L46:
        if (r10.hasUserRestriction("no_install_apps") == false) goto L48;
    L42:
        PreferenceGroup r17 = (PreferenceGroup) r1.findPreference(KEY_CREDENTIALS_MANAGER);
        r17.removePreference(r1.findPreference(KEY_RESET_CREDENTIALS));
        r17.removePreference(r1.findPreference(KEY_CREDENTIALS_INSTALL));
        r17.removePreference(r1.findPreference(KEY_CREDENTIAL_STORAGE_TYPE));
    L35:
        r1.removePreference(r1.findPreference(KEY_SIM_LOCK));
        goto L37
    L15:
        if (LockPatternUtils.isDeviceEncryptionEnabled() == false) goto L17;
        addPreferencesFromResource(R.xml.security_settings_encrypted);
        goto L18
    L17:
        addPreferencesFromResource(R.xml.security_settings_unencrypted);
        goto L18
    L8:
        r4 = false;
        goto L9
    }

    private void maybeAddFingerprintPreference(PreferenceGroup r7) {
        FingerprintManager r0 = (FingerprintManager) getActivity().getSystemService("fingerprint");
        if (r0.isHardwareDetected() == true) goto L6;
        OLog.v(TAG, "No fingerprint hardware detected!!");
        return;
    L6:
        Preference r1 = new Preference(r7.getContext());
        r1.setKey("fingerprint_settings");
        r1.setTitle(R.string.security_settings_fingerprint_preference_title);
        Intent r2 = new Intent();
        List r3 = r0.getEnrolledFingerprints();
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        if (r4 <= 0) goto L12;
        r1.setSummary(getResources().getQuantityString(R.plurals.security_settings_fingerprint_preference_summary, r4, new Object[]{Integer.valueOf(r4)}));
        String r6 = FingerprintSettings.class.getName();
    L13:
        r2.setClassName("com.android.settings", r6);
        r1.setIntent(r2);
        r7.addPreference(r1);
        return;
    L12:
        r6 = FingerprintEnrollIntroduction.class.getName();
        goto L13
    L9:
        r4 = 0;
        goto L10
    }

    private void addTrustAgentSettings(PreferenceGroup r7) {
        boolean r0 = this.mLockPatternUtils.isSecure(MY_USER_ID);
        ArrayList<TrustAgentUtils.TrustAgentComponentInfo> r6 = getActiveTrustAgents(getPackageManager(), this.mLockPatternUtils, this.mDPM);
        int r2 = 0;
    L4:
        if (r2 >= r6.size()) goto L9;
        TrustAgentUtils.TrustAgentComponentInfo r3 = r6.get(r2);
        Preference r4 = new Preference(r7.getContext());
        r4.setKey(KEY_TRUST_AGENT);
        r4.setTitle(r3.title);
        r4.setSummary(r3.summary);
        Intent r5 = new Intent();
        r5.setComponent(r3.componentName);
        r5.setAction("android.intent.action.MAIN");
        r4.setIntent(r5);
        r7.addPreference(r4);
        if (r0 == true) goto L8;
        r4.setEnabled(false);
        r4.setSummary(R.string.disabled_because_no_backup_security);
    L8:
        r2 = r2 + 1;
        goto L4
    }

    private static ArrayList<TrustAgentUtils.TrustAgentComponentInfo> getActiveTrustAgents(PackageManager r8, LockPatternUtils r9, DevicePolicyManager r10) {
        ArrayList<TrustAgentUtils.TrustAgentComponentInfo> r0 = new ArrayList();
        List<ResolveInfo> r1 = r8.queryIntentServices(TRUST_AGENT_INTENT, 128);
        List r11 = r9.getEnabledTrustAgents(MY_USER_ID);
        int r4 = 0;
        if ((r10.getKeyguardDisabledFeatures(null) & 16) == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r1 == null) goto L29;
        if (r11 == null) goto L29;
        if (r11.isEmpty() == true) goto L29;
    L11:
        if (r4 >= r1.size()) goto L29;
        ResolveInfo r5 = r1.get(r4);
        if (r5.serviceInfo == null) goto L28;
        if (TrustAgentUtils.checkProvidePermission(r5, r8) == false) goto L28;
        TrustAgentUtils.TrustAgentComponentInfo r6 = TrustAgentUtils.getSettingsComponent(r8, r5);
        if (r6.componentName == null) goto L28;
        if (r11.contains(TrustAgentUtils.getComponentName(r5)) == false) goto L28;
        if (TextUtils.isEmpty(r6.title) == true) goto L28;
        if (r3 == false) goto L27;
        r10.getTrustAgentConfiguration(null, TrustAgentUtils.getComponentName(r5));
    L27:
        r0.add(r6);
    L28:
        r4 = r4 + 1;
    L29:
        return r0;
    L5:
        r3 = false;
        goto L6
    }

    private boolean isNonMarketAppsAllowed() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), "install_non_market_apps", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setNonMarketAppsAllowed(boolean r3) {
        if (((UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_install_unknown_sources") == false) goto L5;
        return;
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), "install_non_market_apps", r3 ? 1 : 0);
    }

    private void warnAppInstallation() {
        this.mWarnInstallApps = new AlertDialog.Builder(getActivity()).setTitle(getResources().getString(R.string.error_title)).setIcon(android.R.drawable.ic_dialog_alert).setMessage(getResources().getString(R.string.install_all_warning)).setPositiveButton(android.R.string.yes, this).setNegativeButton(android.R.string.no, this).show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (r2 == this.mWarnInstallApps) goto L5;
        return;
    L5:
        if (r3 != (-1)) goto L7;
        boolean r4 = true;
    L8:
        setNonMarketAppsAllowed(r4);
        SwitchPreferenceCompat r1 = this.mToggleAppInstallation;
        if (r1 == null) goto L13;
        r1.setChecked(r4);
        return;
    L13:
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DialogInterface r0 = this.mWarnInstallApps;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private void setupLockAfterPreference() {
        this.mLockAfter.setValue(String.valueOf(android.provider.Settings.Secure.getLong(getContentResolver(), "lock_screen_lock_after_timeout", 5000)));
        this.mLockAfter.setOnPreferenceChangeListener(this);
        DevicePolicyManager r0 = this.mDPM;
        if (r0 == null) goto L5;
        long r3 = r0.getMaximumTimeToLock(null);
    L6:
        long r5 = Math.max(0, android.provider.Settings.System.getInt(getContentResolver(), PageConstants.LAUNCH_PAGE_SCREEN_OFF_TIMEOUT, 0));
        if (r3 <= 0) goto L10;
        disableUnusableTimeouts(Math.max(0, r3 - r5));
        return;
    L10:
        return;
    L5:
        r3 = 0;
        goto L6
    }

    private void updateLockAfterPreferenceSummary() {
        long r0 = android.provider.Settings.Secure.getLong(getContentResolver(), "lock_screen_lock_after_timeout", 5000);
        CharSequence[] r2 = this.mLockAfter.getEntries();
        CharSequence[] r3 = this.mLockAfter.getEntryValues();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r5 >= r3.length) goto L9;
        if (r0 < Long.valueOf(r3[r5].toString()).longValue()) goto L8;
        r6 = r5;
    L8:
        r5 = r5 + 1;
        goto L4
    L9:
        Preference r1 = getPreferenceScreen().findPreference(KEY_TRUST_AGENT);
        if (r1 != null) goto L12;
    L17:
        this.mLockAfter.setSummary(getString(R.string.lock_after_timeout_summary, new Object[]{r2[r6]}));
        return;
    L12:
        if (r1.getTitle().length() <= 0) goto L17;
        if (Long.valueOf(r3[r6].toString()).longValue() != 0) goto L16;
        this.mLockAfter.setSummary(getString(R.string.lock_immediately_summary_with_exception, new Object[]{r1.getTitle()}));
        return;
    L16:
        this.mLockAfter.setSummary(getString(R.string.lock_after_timeout_summary_with_exception, new Object[]{r2[r6], r1.getTitle()}));
    }

    private void disableUnusableTimeouts(long r9) {
        CharSequence[] r0 = this.mLockAfter.getEntries();
        CharSequence[] r1 = this.mLockAfter.getEntryValues();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (r5 >= r1.length) goto L10;
        if (Long.valueOf(r1[r5].toString()).longValue() > r9) goto L8;
        r2.add(r0[r5]);
        r3.add(r1[r5]);
    L8:
        r5 = r5 + 1;
        goto L4
    L10:
        if (r2.size() == r0.length) goto L12;
    L13:
        this.mLockAfter.setEntries((CharSequence[]) r2.toArray(new CharSequence[r2.size()]));
        this.mLockAfter.setEntryValues((CharSequence[]) r3.toArray(new CharSequence[r3.size()]));
        int r6 = Integer.valueOf(this.mLockAfter.getValue()).intValue();
        if (r6 > r9) goto L16;
        this.mLockAfter.setValue(String.valueOf(r6));
    L16:
        ListPreference r8 = this.mLockAfter;
        if (r2.size() <= 0) goto L19;
        r4 = true;
    L19:
        r8.setEnabled(r4);
        return;
    L12:
        if (r3.size() == r1.length) goto L16;
        goto L13
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        Intent r1 = this.mTrustAgentClickIntent;
        if (r1 == null) goto L6;
        r2.putParcelable(TRUST_AGENT_CLICK_INTENT, r1);
        return;
    }

    public void com_android_settings_SecuritySettings__onResume$___twin___() {
        super.onResume();
        createPreferenceHierarchy();
        LockPatternUtils r0 = this.mChooseLockSettingsHelper.utils();
        SwitchPreferenceCompat r1 = this.mVisiblePattern;
        if (r1 == null) goto L5;
        r1.setChecked(r0.isVisiblePatternEnabled(MY_USER_ID));
    L5:
        SwitchPreferenceCompat r2 = this.mPowerButtonInstantlyLocks;
        if (r2 == null) goto L8;
        r2.setChecked(r0.getPowerButtonInstantlyLocks(MY_USER_ID));
    L8:
        SwitchPreferenceCompat r3 = this.mShowPassword;
        if (r3 == null) goto L15;
        boolean r4 = true;
        if (android.provider.Settings.System.getInt(getContentResolver(), KEY_SHOW_PASSWORD, 1) != 0) goto L14;
        r4 = false;
    L14:
        r3.setChecked(r4);
    L15:
        updateOwnerInfo();
    }

    public void updateOwnerInfo() {
        Preference r0 = this.mOwnerInfoPref;
        if (r0 == null) goto L10;
        LockPatternUtils r1 = this.mLockPatternUtils;
        int r2 = MY_USER_ID;
        if (r1.isOwnerInfoEnabled(r2) == false) goto L7;
        String r3 = this.mLockPatternUtils.getOwnerInfo(r2);
    L8:
        r0.setSummary(r3);
        return;
    L7:
        r3 = getString(R.string.owner_info_settings_summary);
        goto L8
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r9) {
        String r0 = r9.getKey();
        if (KEY_UNLOCK_SET_OR_CHANGE.equals(r0) == false) goto L6;
        startFragment(this, "com.android.settings.ChooseLockGeneric$ChooseLockGenericFragment", R.string.lock_settings_picker_title, 123, null);
        return true;
    L6:
        if (KEY_TRUST_AGENT.equals(r0) == false) goto L15;
        ChooseLockSettingsHelper r1 = new ChooseLockSettingsHelper(getActivity(), this);
        this.mTrustAgentClickIntent = r9.getIntent();
        if (r1.launchConfirmationActivity(126, r9.getTitle(), 0) == true) goto L17;
        Intent r10 = this.mTrustAgentClickIntent;
        if (r10 == null) goto L18;
        startActivity(r10);
        this.mTrustAgentClickIntent = null;
        return true;
    L18:
        return true;
    L17:
        return true;
    L15:
        return super.onPreferenceTreeClick(r9);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 126) goto L5;
    L10:
        createPreferenceHierarchy();
        return;
    L5:
        if (r2 != (-1)) goto L10;
        Intent r4 = this.mTrustAgentClickIntent;
        if (r4 == null) goto L12;
        startActivity(r4);
        this.mTrustAgentClickIntent = null;
        return;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        String r5 = r3.getKey();
        LockPatternUtils r0 = this.mChooseLockSettingsHelper.utils();
        if (KEY_LOCK_AFTER_TIMEOUT.equals(r5) == false) goto L11;
        int r6 = Integer.parseInt((String) r4);
        android.provider.Settings.Secure.putInt(getContentResolver(), "lock_screen_lock_after_timeout", r6);     // Catch: NumberFormatException -> L7
    L9:
        updateLockAfterPreferenceSummary();
    L25:
        return true;
    L7:
        e = move-exception;
        OLog.e(TAG, "could not persist lockAfter timeout setting", e);
        goto L9
    L11:
        if (KEY_VISIBLE_PATTERN.equals(r5) == false) goto L14;
        r0.setVisiblePatternEnabled(((Boolean) r4).booleanValue(), MY_USER_ID);
        goto L25
    L14:
        if (KEY_POWER_INSTANTLY_LOCKS.equals(r5) == false) goto L17;
        this.mLockPatternUtils.setPowerButtonInstantlyLocks(((Boolean) r4).booleanValue(), MY_USER_ID);
        goto L25
    L17:
        if (KEY_SHOW_PASSWORD.equals(r5) == false) goto L20;
        android.provider.Settings.System.putInt(getContentResolver(), KEY_SHOW_PASSWORD, ((Boolean) r4).booleanValue() ? 1 : 0);
        goto L25
    L20:
        if (KEY_TOGGLE_INSTALL_APPLICATIONS.equals(r5) == false) goto L25;
        if (((Boolean) r4).booleanValue() == false) goto L24;
        this.mToggleAppInstallation.setChecked(false);
        warnAppInstallation();
        return false;
    L24:
        setNonMarketAppsAllowed(false);
        goto L25
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SecuritySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SecuritySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SecuritySettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecuritySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SecuritySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SecuritySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
