package com.android.settings.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.KeyCharacterMap;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.internal.content.PackageMonitor;
import com.android.internal.view.RotationPolicy;
import com.android.settings.DialogCreatable;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedPreference;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilitySettings extends SettingsPreferenceFragment implements DialogCreatable, Preference.OnPreferenceChangeListener, Indexable {
    private static final String AUTOCLICK_PREFERENCE_SCREEN = "autoclick_preference_screen";
    private static final String CAPTIONING_PREFERENCE_SCREEN = "captioning_preference_screen";
    private static final long DELAY_UPDATE_SERVICES_MILLIS = 1000;
    private static final String DISPLAY_DALTONIZER_PREFERENCE_SCREEN = "daltonizer_preference_screen";
    private static final String DISPLAY_MAGNIFICATION_PREFERENCE_SCREEN = "screen_magnification_preference_screen";
    private static final String ENABLE_ACCESSIBILITY_GESTURE_PREFERENCE_SCREEN = "enable_global_gesture_preference_screen";
    public static final String EXTRA_CHECKED = "checked";
    public static final String EXTRA_COMPONENT_NAME = "component_name";
    public static final String EXTRA_DISABLE_WARNING_DIALOG = "no_warning_dialog";
    public static final String EXTRA_INFO = "info";
    public static final String EXTRA_PREFERENCE_KEY = "preference_key";
    public static final String EXTRA_SETTINGS_COMPONENT_NAME = "settings_component_name";
    public static final String EXTRA_SETTINGS_TITLE = "settings_title";
    public static final String EXTRA_SUMMARY = "summary";
    public static final String EXTRA_TITLE = "title";
    private static final String FONT_SIZE_PREFERENCE_SCREEN = "font_size_preference_screen";
    public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final String SELECT_LONG_PRESS_TIMEOUT_PREFERENCE = "select_long_press_timeout_preference";
    private static final String SERVICES_CATEGORY = "services_category";
    private static final String SYSTEM_CATEGORY = "system_category";
    private static final String TOGGLE_HIGH_TEXT_CONTRAST_PREFERENCE = "toggle_high_text_contrast_preference";
    private static final String TOGGLE_INVERSION_PREFERENCE = "toggle_inversion_preference";
    private static final String TOGGLE_LARGE_POINTER_ICON = "toggle_large_pointer_icon";
    private static final String TOGGLE_LOCK_SCREEN_ROTATION_PREFERENCE = "toggle_lock_screen_rotation_preference";
    private static final String TOGGLE_MASTER_MONO = "toggle_master_mono";
    private static final String TOGGLE_POWER_BUTTON_ENDS_CALL_PREFERENCE = "toggle_power_button_ends_call_preference";
    private static final String TOGGLE_SPEAK_PASSWORD_PREFERENCE = "toggle_speak_password_preference";
    static final Set<ComponentName> sInstalledServices = null;
    private PreferenceScreen mAutoclickPreferenceScreen;
    private PreferenceScreen mCaptioningPreferenceScreen;
    private PreferenceScreen mDisplayDaltonizerPreferenceScreen;
    private PreferenceScreen mDisplayMagnificationPreferenceScreen;
    private DevicePolicyManager mDpm;
    private PreferenceScreen mFontSizePreferenceScreen;
    private PreferenceScreen mGlobalGesturePreferenceScreen;
    private final Handler mHandler;
    private int mLongPressTimeoutDefault;
    private final Map<String, String> mLongPressTimeoutValuetoTitleMap;
    private Preference mNoServicesMessagePreference;
    private final RotationPolicy.RotationPolicyListener mRotationPolicyListener;
    private ListPreference mSelectLongPressTimeoutPreference;
    private PreferenceCategory mServicesCategory;
    private final SettingsContentObserver mSettingsContentObserver;
    private final PackageMonitor mSettingsPackageMonitor;
    private PreferenceCategory mSystemsCategory;
    private SwitchPreference mToggleHighTextContrastPreference;
    private SwitchPreference mToggleInversionPreference;
    private SwitchPreference mToggleLargePointerIconPreference;
    private SwitchPreference mToggleLockScreenRotationPreference;
    private SwitchPreference mToggleMasterMonoPreference;
    private SwitchPreference mTogglePowerButtonEndsCallPreference;
    private SwitchPreference mToggleSpeakPasswordPreference;
    private final Runnable mUpdateRunnable;

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_uri_accessibility;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilitySettings() {
        this.mLongPressTimeoutValuetoTitleMap = new HashMap();
        final Handler r0 = new Handler();
        this.mHandler = r0;
        this.mUpdateRunnable = new AnonymousClass1(this);
        this.mSettingsPackageMonitor = new AnonymousClass2(this);
        this.mSettingsContentObserver = new AnonymousClass3(this, r0);
        this.mRotationPolicyListener = new AnonymousClass4(this);
    }

    static /* synthetic */ void access$000(AccessibilitySettings r0) {
        r0.updateServicesPreferences();
    }

    static /* synthetic */ Runnable access$100(AccessibilitySettings r0) {
        return r0.mUpdateRunnable;
    }

    static /* synthetic */ Handler access$200(AccessibilitySettings r0) {
        return r0.mHandler;
    }

    static /* synthetic */ void access$300(AccessibilitySettings r0) {
        r0.updateLockScreenRotationCheckbox();
    }

    static {
        sInstalledServices = new HashSet();
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass5();
    }

    public void com_android_settings_accessibility_AccessibilitySettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        addPreferencesFromResource(R.xml.accessibility_settings);
        initializeAllPreferences();
        this.mDpm = (DevicePolicyManager) getActivity().getSystemService("device_policy");
    }

    public void com_android_settings_accessibility_AccessibilitySettings__onResume$___twin___() {
        super.onResume();
        updateAllPreferences();
        this.mSettingsPackageMonitor.register(getActivity(), getActivity().getMainLooper(), false);
        this.mSettingsContentObserver.register(getContentResolver());
        if (RotationPolicy.isRotationSupported(getActivity()) == false) goto L6;
        RotationPolicy.registerRotationPolicyListener(getActivity(), this.mRotationPolicyListener);
        return;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mSettingsPackageMonitor.unregister();
        this.mSettingsContentObserver.unregister(getContentResolver());
        if (RotationPolicy.isRotationSupported(getActivity()) == false) goto L5;
        RotationPolicy.unregisterRotationPolicyListener(getActivity(), this.mRotationPolicyListener);
    L5:
        super.onPause();
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        if (this.mSelectLongPressTimeoutPreference != r3) goto L7;
        handleLongPressTimeoutPreferenceChange((String) r4);
        return true;
    L7:
        if (this.mToggleInversionPreference != r3) goto L10;
        handleToggleInversionPreferenceChange(((Boolean) r4).booleanValue());
        return true;
    L10:
        return false;
    }

    private void handleLongPressTimeoutPreferenceChange(String r4) {
        Settings.Secure.putInt(getContentResolver(), "long_press_timeout", Integer.parseInt(r4));
        this.mSelectLongPressTimeoutPreference.setSummary(this.mLongPressTimeoutValuetoTitleMap.get(r4));
    }

    private void handleToggleInversionPreferenceChange(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_display_inversion_enabled", r2 ? 1 : 0);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if (this.mToggleHighTextContrastPreference != r3) goto L7;
        handleToggleTextContrastPreferenceClick();
        return true;
    L7:
        if (this.mTogglePowerButtonEndsCallPreference != r3) goto L11;
        handleTogglePowerButtonEndsCallPreferenceClick();
        return true;
    L11:
        if (this.mToggleLockScreenRotationPreference != r3) goto L15;
        handleLockScreenRotationPreferenceClick();
        return true;
    L15:
        if (this.mToggleSpeakPasswordPreference != r3) goto L19;
        handleToggleSpeakPasswordPreferenceClick();
        return true;
    L19:
        if (this.mToggleLargePointerIconPreference != r3) goto L23;
        handleToggleLargePointerIconPreferenceClick();
        return true;
    L23:
        if (this.mToggleMasterMonoPreference != r3) goto L27;
        handleToggleMasterMonoPreferenceClick();
        return true;
    L27:
        if (this.mGlobalGesturePreferenceScreen != r3) goto L31;
        handleToggleEnableAccessibilityGesturePreferenceClick();
        return true;
    L31:
        if (this.mDisplayMagnificationPreferenceScreen != r3) goto L35;
        handleDisplayMagnificationPreferenceScreenClick();
        return true;
    L35:
        return super.onPreferenceTreeClick(r3);
    }

    private void handleToggleTextContrastPreferenceClick() {
        Settings.Secure.putInt(getContentResolver(), "high_text_contrast_enabled", this.mToggleHighTextContrastPreference.isChecked() ? 1 : 0);
    }

    private void handleTogglePowerButtonEndsCallPreferenceClick() {
        ContentResolver r0 = getContentResolver();
        if (this.mTogglePowerButtonEndsCallPreference.isChecked() == false) goto L5;
        int r2 = 2;
    L6:
        Settings.Secure.putInt(r0, "incall_power_button_behavior", r2);
        return;
    L5:
        r2 = 1;
        goto L6
    }

    private void handleLockScreenRotationPreferenceClick() {
        RotationPolicy.setRotationLockForAccessibility(getActivity(), !this.mToggleLockScreenRotationPreference.isChecked(), getContext().getPackageName());
    }

    private void handleToggleSpeakPasswordPreferenceClick() {
        Settings.Secure.putInt(getContentResolver(), "speak_password", this.mToggleSpeakPasswordPreference.isChecked() ? 1 : 0);
    }

    private void handleToggleLargePointerIconPreferenceClick() {
        Settings.Secure.putInt(getContentResolver(), "accessibility_large_pointer_icon", this.mToggleLargePointerIconPreference.isChecked() ? 1 : 0);
    }

    private void handleToggleMasterMonoPreferenceClick() {
        Settings.System.putIntForUser(getContentResolver(), "master_mono", this.mToggleMasterMonoPreference.isChecked() ? 1 : 0, -2);
    }

    private void handleToggleEnableAccessibilityGesturePreferenceClick() {
        Bundle r0 = this.mGlobalGesturePreferenceScreen.getExtras();
        r0.putString("title", getString(R.string.accessibility_global_gesture_preference_title));
        r0.putString("summary", getString(R.string.accessibility_global_gesture_preference_description));
        boolean r3 = false;
        if (Settings.Global.getInt(getContentResolver(), "enable_accessibility_global_gesture_enabled", 0) != 1) goto L5;
        r3 = true;
    L5:
        r0.putBoolean("checked", r3);
        super.onPreferenceTreeClick(this.mGlobalGesturePreferenceScreen);
    }

    private void handleDisplayMagnificationPreferenceScreenClick() {
        Bundle r0 = this.mDisplayMagnificationPreferenceScreen.getExtras();
        r0.putString("title", getString(R.string.accessibility_screen_magnification_title));
        r0.putCharSequence("summary", getActivity().getResources().getText(R.string.accessibility_screen_magnification_summary));
        boolean r3 = false;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_display_magnification_enabled", 0) != 1) goto L5;
        r3 = true;
    L5:
        r0.putBoolean("checked", r3);
        super.onPreferenceTreeClick(this.mDisplayMagnificationPreferenceScreen);
    }

    private void initializeAllPreferences() {
        this.mServicesCategory = (PreferenceCategory) findPreference(SERVICES_CATEGORY);
        this.mSystemsCategory = (PreferenceCategory) findPreference(SYSTEM_CATEGORY);
        this.mToggleHighTextContrastPreference = (SwitchPreference) findPreference(TOGGLE_HIGH_TEXT_CONTRAST_PREFERENCE);
        SwitchPreference r0 = (SwitchPreference) findPreference(TOGGLE_INVERSION_PREFERENCE);
        this.mToggleInversionPreference = r0;
        r0.setOnPreferenceChangeListener(this);
        this.mTogglePowerButtonEndsCallPreference = (SwitchPreference) findPreference(TOGGLE_POWER_BUTTON_ENDS_CALL_PREFERENCE);
        if (KeyCharacterMap.deviceHasKey(26) == true) goto L5;
    L6:
        this.mSystemsCategory.removePreference(this.mTogglePowerButtonEndsCallPreference);
    L7:
        this.mToggleLockScreenRotationPreference = (SwitchPreference) findPreference(TOGGLE_LOCK_SCREEN_ROTATION_PREFERENCE);
        if (RotationPolicy.isRotationSupported(getActivity()) == true) goto L10;
        this.mSystemsCategory.removePreference(this.mToggleLockScreenRotationPreference);
    L10:
        this.mToggleSpeakPasswordPreference = (SwitchPreference) findPreference(TOGGLE_SPEAK_PASSWORD_PREFERENCE);
        this.mToggleLargePointerIconPreference = (SwitchPreference) findPreference(TOGGLE_LARGE_POINTER_ICON);
        this.mToggleMasterMonoPreference = (SwitchPreference) findPreference(TOGGLE_MASTER_MONO);
        ListPreference r1 = (ListPreference) findPreference(SELECT_LONG_PRESS_TIMEOUT_PREFERENCE);
        this.mSelectLongPressTimeoutPreference = r1;
        r1.setOnPreferenceChangeListener(this);
        if (this.mLongPressTimeoutValuetoTitleMap.size() != 0) goto L15;
        String[] r2 = getResources().getStringArray(R.array.long_press_timeout_selector_values);
        int r3 = 0;
        this.mLongPressTimeoutDefault = Integer.parseInt(r2[0]);
        String[] r4 = getResources().getStringArray(R.array.long_press_timeout_selector_titles);
        int r5 = r2.length;
    L13:
        if (r3 >= r5) goto L15;
        this.mLongPressTimeoutValuetoTitleMap.put(r2[r3], r4[r3]);
        r3 = r3 + 1;
    L15:
        this.mCaptioningPreferenceScreen = (PreferenceScreen) findPreference(CAPTIONING_PREFERENCE_SCREEN);
        this.mDisplayMagnificationPreferenceScreen = (PreferenceScreen) findPreference(DISPLAY_MAGNIFICATION_PREFERENCE_SCREEN);
        this.mFontSizePreferenceScreen = (PreferenceScreen) findPreference(FONT_SIZE_PREFERENCE_SCREEN);
        this.mAutoclickPreferenceScreen = (PreferenceScreen) findPreference(AUTOCLICK_PREFERENCE_SCREEN);
        this.mDisplayDaltonizerPreferenceScreen = (PreferenceScreen) findPreference(DISPLAY_DALTONIZER_PREFERENCE_SCREEN);
        this.mGlobalGesturePreferenceScreen = (PreferenceScreen) findPreference(ENABLE_ACCESSIBILITY_GESTURE_PREFERENCE_SCREEN);
        int r6 = getActivity().getResources().getInteger(android.R.integer.config_maxScanTasksForHomeVisibility);
        if (KeyCharacterMap.deviceHasKey(26) == true) goto L18;
    L19:
        this.mSystemsCategory.removePreference(this.mGlobalGesturePreferenceScreen);
        return;
    L18:
        if (r6 != 1) goto L19;
        return;
    L5:
        if (Utils.isVoiceCapable(getActivity()) == true) goto L7;
        goto L6
    }

    private void updateAllPreferences() {
        updateServicesPreferences();
        updateSystemPreferences();
    }

    private void updateServicesPreferences() {
        this.mServicesCategory.removeAll();
        List<AccessibilityServiceInfo> r1 = AccessibilityManager.getInstance(getActivity()).getInstalledAccessibilityServiceList();
        Set<ComponentName> r2 = AccessibilityUtils.getEnabledServicesFromSettings(getActivity());
        List r3 = this.mDpm.getPermittedAccessibilityServices(UserHandle.myUserId());
        boolean r6 = false;
        boolean r5 = true;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_enabled", 0) != 1) goto L5;
        boolean r4 = true;
    L6:
        int r7 = r1.size();
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L40;
        AccessibilityServiceInfo r9 = r1.get(r8);
        RestrictedPreference r10 = new RestrictedPreference(getActivity());
        String r11 = r9.getResolveInfo().loadLabel(getPackageManager()).toString();
        ServiceInfo r12 = r9.getResolveInfo().serviceInfo;
        ComponentName r13 = new ComponentName(r12.packageName, r12.name);
        r10.setKey(r13.flattenToString());
        r10.setTitle(r11);
        if (r4 == true) goto L11;
    L13:
        boolean r14 = r6;
    L14:
        if (r14 == false) goto L16;
        String r15 = getString(R.string.accessibility_feature_state_on);
    L17:
        String r16 = r12.packageName;
        if (r3 != null) goto L20;
    L23:
        boolean r17 = true;
    L24:
        if (r17 == true) goto L31;
        if (r14 == true) goto L31;
        RestrictedLockUtils.EnforcedAdmin r18 = MultiSDKAdapterNew.checkIfAccessibilityServiceDisallowed(getActivity(), r12.packageName, UserHandle.myUserId());
        if (r18 == null) goto L29;
        r10.setDisabledByAdmin(r18);
    L30:
        r5 = true;
    L32:
        r10.setSummary(r15);
        r10.setOrder(r8);
        r10.setFragment(ToggleAccessibilityServicePreferenceFragment.class.getName());
        r10.setPersistent(r5);
        Bundle r19 = r10.getExtras();
        r19.putString(EXTRA_PREFERENCE_KEY, r10.getKey());
        r19.putBoolean("checked", r14);
        r19.putString("title", r11);
        String r110 = r9.loadDescription(getPackageManager());
        if (TextUtils.isEmpty(r110) == false) goto L35;
        r110 = getString(R.string.accessibility_service_default_description);
    L35:
        r19.putString("summary", r110);
        String r111 = r9.getSettingsActivityName();
        if (TextUtils.isEmpty(r111) == true) goto L38;
        r19.putString(EXTRA_SETTINGS_TITLE, getString(R.string.accessibility_menu_item_settings));
        r19.putString(EXTRA_SETTINGS_COMPONENT_NAME, new ComponentName(r9.getResolveInfo().serviceInfo.packageName, r111).flattenToString());
    L38:
        r19.putParcelable(EXTRA_COMPONENT_NAME, r13);
        this.mServicesCategory.addPreference(r10);
        r8 = r8 + 1;
        r6 = false;
        goto L7
    L29:
        r10.setEnabled(false);
    L31:
        r5 = true;
        r10.setEnabled(true);
        goto L32
    L20:
        if (r3.contains(r16) == true) goto L23;
        r17 = r6;
        goto L24
    L16:
        r15 = getString(R.string.accessibility_feature_state_off);
        goto L17
    L11:
        if (r2.contains(r13) == false) goto L13;
        r14 = r5;
        goto L14
    L40:
        if (this.mServicesCategory.getPreferenceCount() == 0) goto L42;
        return;
    L42:
        if (this.mNoServicesMessagePreference != null) goto L44;
        Preference r20 = new Preference(getPrefContext());
        this.mNoServicesMessagePreference = r20;
        r20.setPersistent(false);
        this.mNoServicesMessagePreference.setLayoutResource(R.layout.text_description_preference);
        this.mNoServicesMessagePreference.setSelectable(false);
        this.mNoServicesMessagePreference.setSummary(getString(R.string.accessibility_no_services_installed));
    L44:
        this.mServicesCategory.addPreference(this.mNoServicesMessagePreference);
        return;
    L5:
        r4 = false;
        goto L6
    }

    private void updateSystemPreferences() {
        SwitchPreference r0 = this.mToggleHighTextContrastPreference;
        boolean r3 = false;
        if (Settings.Secure.getInt(getContentResolver(), "high_text_contrast_enabled", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        SwitchPreference r2 = this.mToggleInversionPreference;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_display_inversion_enabled", 0) != 1) goto L9;
        boolean r4 = true;
    L10:
        r2.setChecked(r4);
        if (KeyCharacterMap.deviceHasKey(26) == true) goto L13;
    L19:
        updateLockScreenRotationCheckbox();
        if (Settings.Secure.getInt(getContentResolver(), "speak_password", 0) == 0) goto L22;
        boolean r5 = true;
    L23:
        this.mToggleSpeakPasswordPreference.setChecked(r5);
        SwitchPreference r6 = this.mToggleLargePointerIconPreference;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_large_pointer_icon", 0) == 0) goto L26;
        boolean r7 = true;
    L27:
        r6.setChecked(r7);
        updateMasterMono();
        String r8 = String.valueOf(Settings.Secure.getInt(getContentResolver(), "long_press_timeout", this.mLongPressTimeoutDefault));
        this.mSelectLongPressTimeoutPreference.setValue(r8);
        this.mSelectLongPressTimeoutPreference.setSummary(this.mLongPressTimeoutValuetoTitleMap.get(r8));
        updateFeatureSummary("accessibility_captioning_enabled", this.mCaptioningPreferenceScreen);
        updateFeatureSummary("accessibility_display_magnification_enabled", this.mDisplayMagnificationPreferenceScreen);
        updateFeatureSummary("accessibility_display_daltonizer_enabled", this.mDisplayDaltonizerPreferenceScreen);
        updateFontSizeSummary(this.mFontSizePreferenceScreen);
        updateAutoclickSummary(this.mAutoclickPreferenceScreen);
        if (Settings.Global.getInt(getContentResolver(), "enable_accessibility_global_gesture_enabled", 0) != 1) goto L30;
        r3 = true;
    L30:
        if (r3 == false) goto L32;
        this.mGlobalGesturePreferenceScreen.setSummary(R.string.accessibility_global_gesture_preference_summary_on);
        return;
    L32:
        this.mGlobalGesturePreferenceScreen.setSummary(R.string.accessibility_global_gesture_preference_summary_off);
        return;
    L26:
        r7 = false;
        goto L27
    L22:
        r5 = false;
        goto L23
    L13:
        if (Utils.isVoiceCapable(getActivity()) == false) goto L19;
        if (Settings.Secure.getInt(getContentResolver(), "incall_power_button_behavior", 1) != 2) goto L17;
        boolean r9 = true;
    L18:
        this.mTogglePowerButtonEndsCallPreference.setChecked(r9);
        goto L19
    L17:
        r9 = false;
        goto L18
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    private void updateFeatureSummary(String r2, Preference r3) {
        boolean r0 = false;
        if (Settings.Secure.getInt(getContentResolver(), r2, 0) != 1) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L7;
        int r1 = R.string.accessibility_feature_state_on;
    L8:
        r3.setSummary(r1);
        return;
    L7:
        r1 = R.string.accessibility_feature_state_off;
        goto L8
    }

    private void updateAutoclickSummary(Preference r4) {
        boolean r2 = false;
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_autoclick_enabled", 0) != 1) goto L5;
        r2 = true;
    L5:
        if (r2 == true) goto L8;
        r4.setSummary(R.string.accessibility_feature_state_off);
        return;
    L8:
        r4.setSummary(ToggleAutoclickPreferenceFragment.getAutoclickPreferenceSummary(getResources(), Settings.Secure.getInt(getContentResolver(), "accessibility_autoclick_delay", 600)));
    }

    private void updateFontSizeSummary(Preference r4) {
        float r0 = Settings.System.getFloat(getContext().getContentResolver(), "font_scale", 1.0f);
        Resources r3 = getContext().getResources();
        r4.setSummary(r3.getStringArray(R.array.entries_font_size)[ToggleFontSizePreferenceFragment.fontSizeValueToIndex(r0, r3.getStringArray(R.array.entryvalues_font_size))]);
    }

    private void updateLockScreenRotationCheckbox() {
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        this.mToggleLockScreenRotationPreference.setChecked(!RotationPolicy.isRotationLocked(r0));
        return;
    }

    private void updateMasterMono() {
        boolean r3 = false;
        if (Settings.System.getIntForUser(getContentResolver(), "master_mono", 0, -2) != 1) goto L5;
        r3 = true;
    L5:
        this.mToggleMasterMonoPreference.setChecked(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilitySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilitySettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilitySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilitySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilitySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
