package com.android.settings.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigureNotificationSettings extends SettingsPreferenceFragment {
    private static final String KEY_LOCK_SCREEN_NOTIFICATIONS = "lock_screen_notifications";
    private static final String KEY_LOCK_SCREEN_PROFILE_NOTIFICATIONS = "lock_screen_notifications_profile";
    private static final String KEY_NOTIFICATION_PULSE = "notification_pulse";
    private static final String TAG = "ConfigNotiSettings";
    private Context mContext;
    private RestrictedDropDownPreference mLockscreen;
    private RestrictedDropDownPreference mLockscreenProfile;
    private int mLockscreenSelectedValue;
    private int mLockscreenSelectedValueProfile;
    private TwoStatePreference mNotificationPulse;
    private int mProfileChallengeUserId;
    private boolean mSecure;
    private boolean mSecureProfile;
    private final SettingsObserver mSettingsObserver;

    private final class SettingsObserver extends ContentObserver {
        private final Uri LOCK_SCREEN_PRIVATE_URI;
        private final Uri LOCK_SCREEN_SHOW_URI;
        private final Uri NOTIFICATION_LIGHT_PULSE_URI;
        final /* synthetic */ ConfigureNotificationSettings this$0;

        public SettingsObserver(ConfigureNotificationSettings r1) {
            this.this$0 = r1;
            super(new Handler());
            this.NOTIFICATION_LIGHT_PULSE_URI = Settings.System.getUriFor("notification_light_pulse");
            this.LOCK_SCREEN_PRIVATE_URI = Settings.Secure.getUriFor("lock_screen_allow_private_notifications");
            this.LOCK_SCREEN_SHOW_URI = Settings.Secure.getUriFor("lock_screen_show_notifications");
        }

        public void register(boolean r3) {
            ContentResolver r0 = ConfigureNotificationSettings.access$800(this.this$0);
            if (r3 == false) goto L5;
            r0.registerContentObserver(this.NOTIFICATION_LIGHT_PULSE_URI, false, this);
            r0.registerContentObserver(this.LOCK_SCREEN_PRIVATE_URI, false, this);
            r0.registerContentObserver(this.LOCK_SCREEN_SHOW_URI, false, this);
            return;
        L5:
            r0.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            super.onChange(r1, r2);
            if (this.NOTIFICATION_LIGHT_PULSE_URI.equals(r2) == false) goto L6;
            ConfigureNotificationSettings.access$900(this.this$0);
        L6:
            if (this.LOCK_SCREEN_PRIVATE_URI.equals(r2) == false) goto L8;
        L9:
            ConfigureNotificationSettings.access$1000(this.this$0);
            if (ConfigureNotificationSettings.access$600(this.this$0) == (-10000)) goto L14;
            ConfigureNotificationSettings.access$1100(this.this$0);
            return;
        L14:
            return;
        L8:
            if (this.LOCK_SCREEN_SHOW_URI.equals(r2) == true) goto L9;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ConfigureNotificationSettings() {
        this.mSettingsObserver = new SettingsObserver(this);
    }

    static /* synthetic */ ContentResolver access$000(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ int access$100(ConfigureNotificationSettings r0) {
        return r0.mLockscreenSelectedValue;
    }

    static /* synthetic */ void access$1000(ConfigureNotificationSettings r0) {
        r0.updateLockscreenNotifications();
    }

    static /* synthetic */ int access$102(ConfigureNotificationSettings r0, int r1) {
        r0.mLockscreenSelectedValue = r1;
        return r1;
    }

    static /* synthetic */ void access$1100(ConfigureNotificationSettings r0) {
        r0.updateLockscreenNotificationsForProfile();
    }

    static /* synthetic */ ContentResolver access$200(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ ContentResolver access$300(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ int access$400(ConfigureNotificationSettings r0) {
        return r0.mLockscreenSelectedValueProfile;
    }

    static /* synthetic */ int access$402(ConfigureNotificationSettings r0, int r1) {
        r0.mLockscreenSelectedValueProfile = r1;
        return r1;
    }

    static /* synthetic */ ContentResolver access$500(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ int access$600(ConfigureNotificationSettings r0) {
        return r0.mProfileChallengeUserId;
    }

    static /* synthetic */ ContentResolver access$700(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ ContentResolver access$800(ConfigureNotificationSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ void access$900(ConfigureNotificationSettings r0) {
        r0.updatePulse();
    }

    public void com_android_settings_notification_ConfigureNotificationSettings__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        FragmentActivity r6 = getActivity();
        this.mContext = r6;
        this.mProfileChallengeUserId = Utils.getManagedProfileId(UserManager.get(r6), UserHandle.myUserId());
        LockPatternUtils r7 = new LockPatternUtils(getActivity());
        boolean r1 = true;
        boolean r0 = !r7.isSeparateProfileChallengeEnabled(this.mProfileChallengeUserId);
        this.mSecure = r7.isSecure(UserHandle.myUserId());
        int r2 = this.mProfileChallengeUserId;
        if (r2 != (-10000)) goto L5;
    L10:
        r1 = false;
    L11:
        this.mSecureProfile = r1;
        addPreferencesFromResource(R.xml.configure_notification_settings);
        initPulse();
        initLockscreenNotifications();
        if (this.mProfileChallengeUserId == (-10000)) goto L15;
        addPreferencesFromResource(R.xml.configure_notification_settings_profile);
        initLockscreenNotificationsForProfile();
        return;
    L15:
        return;
    L5:
        if (r7.isSecure(r2) == true) goto L11;
        if (r0 == false) goto L10;
        if (this.mSecure == false) goto L10;
        goto L10
    }

    public void com_android_settings_notification_ConfigureNotificationSettings__onResume$___twin___() {
        super.onResume();
        this.mSettingsObserver.register(true);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSettingsObserver.register(false);
    }

    private void initPulse() {
        TwoStatePreference r0 = (TwoStatePreference) getPreferenceScreen().findPreference(KEY_NOTIFICATION_PULSE);
        this.mNotificationPulse = r0;
        if (r0 != null) goto L7;
        OLog.i(TAG, "Preference not found: notification_pulse");
        return;
    L7:
        if (getResources().getBoolean(android.R.bool.config_isPreApprovalRequestAvailable) == true) goto L9;
        getPreferenceScreen().removePreference(this.mNotificationPulse);
        return;
    L9:
        updatePulse();
        this.mNotificationPulse.setOnPreferenceChangeListener(new AnonymousClass1(this));
    }

    private void updatePulse() {
        TwoStatePreference r0 = this.mNotificationPulse;
        if (r0 != null) goto L13;
        return;
    L13:
        boolean r1 = true;
        if (Settings.System.getInt(getContentResolver(), "notification_light_pulse") == 1) goto L9;
        r1 = false;
    L9:
        r0.setChecked(r1);     // Catch: Settings.SettingNotFoundException -> L11
        return;
    L11:
        OLog.e(TAG, "notification_light_pulse not found");
    }

    private void initLockscreenNotifications() {
        RestrictedDropDownPreference r0 = (RestrictedDropDownPreference) getPreferenceScreen().findPreference(KEY_LOCK_SCREEN_NOTIFICATIONS);
        this.mLockscreen = r0;
        if (r0 != null) goto L6;
        OLog.i(TAG, "Preference not found: lock_screen_notifications");
        return;
    L6:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r1.add(getString(R.string.lock_screen_notifications_summary_disable));
        r2.add(Integer.toString(R.string.lock_screen_notifications_summary_disable));
        String r3 = getString(R.string.lock_screen_notifications_summary_show);
        String r4 = Integer.toString(R.string.lock_screen_notifications_summary_show);
        r1.add(r3);
        r2.add(r4);
        setRestrictedIfNotificationFeaturesDisabled(r3, r4, 12);
        if (this.mSecure == false) goto L9;
        String r5 = getString(R.string.lock_screen_notifications_summary_hide);
        String r6 = Integer.toString(R.string.lock_screen_notifications_summary_hide);
        r1.add(r5);
        r2.add(r6);
        setRestrictedIfNotificationFeaturesDisabled(r5, r6, 4);
    L9:
        this.mLockscreen.setEntries((CharSequence[]) r1.toArray(new CharSequence[r1.size()]));
        this.mLockscreen.setEntryValues((CharSequence[]) r2.toArray(new CharSequence[r2.size()]));
        updateLockscreenNotifications();
        if (this.mLockscreen.getEntries().length <= 1) goto L12;
        this.mLockscreen.setOnPreferenceChangeListener(new AnonymousClass2(this));
        return;
    L12:
        this.mLockscreen.setEnabled(false);
    }

    private void initLockscreenNotificationsForProfile() {
        RestrictedDropDownPreference r0 = (RestrictedDropDownPreference) getPreferenceScreen().findPreference(KEY_LOCK_SCREEN_PROFILE_NOTIFICATIONS);
        this.mLockscreenProfile = r0;
        if (r0 != null) goto L6;
        OLog.i(TAG, "Preference not found: lock_screen_notifications_profile");
        return;
    L6:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        r1.add(getString(R.string.lock_screen_notifications_summary_disable_profile));
        r2.add(Integer.toString(R.string.lock_screen_notifications_summary_disable_profile));
        String r3 = getString(R.string.lock_screen_notifications_summary_show_profile);
        String r4 = Integer.toString(R.string.lock_screen_notifications_summary_show_profile);
        r1.add(r3);
        r2.add(r4);
        setRestrictedIfNotificationFeaturesDisabled(r3, r4, 12);
        if (this.mSecureProfile == false) goto L9;
        String r5 = getString(R.string.lock_screen_notifications_summary_hide_profile);
        String r6 = Integer.toString(R.string.lock_screen_notifications_summary_hide_profile);
        r1.add(r5);
        r2.add(r6);
        setRestrictedIfNotificationFeaturesDisabled(r5, r6, 4);
    L9:
        this.mLockscreenProfile.setOnPreClickListener(new ConfigureNotificationSettings$$ExternalSyntheticLambda0(this));
        this.mLockscreenProfile.setEntries((CharSequence[]) r1.toArray(new CharSequence[r1.size()]));
        this.mLockscreenProfile.setEntryValues((CharSequence[]) r2.toArray(new CharSequence[r2.size()]));
        updateLockscreenNotificationsForProfile();
        if (this.mLockscreenProfile.getEntries().length <= 1) goto L12;
        this.mLockscreenProfile.setOnPreferenceChangeListener(new AnonymousClass3(this));
        return;
    L12:
        this.mLockscreenProfile.setEnabled(false);
    }

    /* JADX INFO: renamed from: lambda$initLockscreenNotificationsForProfile$0$com-android-settings-notification-ConfigureNotificationSettings, reason: not valid java name */
    /* synthetic */ boolean m523xf25376de(Preference r2) {
        Context r3 = this.mContext;
        return Utils.startQuietModeDialogIfNecessary(r3, UserManager.get(r3), this.mProfileChallengeUserId);
    }

    private void setRestrictedIfNotificationFeaturesDisabled(CharSequence r3, CharSequence r4, int r5) {
        RestrictedLockUtils.EnforcedAdmin r0 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(this.mContext, r5, UserHandle.myUserId());
        if (r0 != null) goto L5;
    L7:
        int r1 = this.mProfileChallengeUserId;
        if (r1 == (-10000)) goto L15;
        RestrictedLockUtils.EnforcedAdmin r6 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(this.mContext, r5, r1);
        if (r6 != null) goto L12;
        return;
    L12:
        if (this.mLockscreenProfile == null) goto L17;
        RestrictedDropDownPreference.RestrictedItem r2 = new RestrictedDropDownPreference.RestrictedItem(r3, r4, r6);
        this.mLockscreenProfile.addRestrictedItem(r2);
        return;
    L17:
        return;
    L15:
        return;
    L5:
        if (this.mLockscreen == null) goto L7;
        RestrictedDropDownPreference.RestrictedItem r7 = new RestrictedDropDownPreference.RestrictedItem(r3, r4, r0);
        this.mLockscreen.addRestrictedItem(r7);
        goto L7
    }

    private void updateLockscreenNotifications() {
        if (this.mLockscreen != null) goto L5;
        return;
    L5:
        boolean r0 = getLockscreenNotificationsEnabled(UserHandle.myUserId());
        if (this.mSecure == true) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r0 == true) goto L14;
        int r2 = R.string.lock_screen_notifications_summary_disable;
    L17:
        this.mLockscreenSelectedValue = r2;
        this.mLockscreen.setValue(Integer.toString(r2));
        return;
    L14:
        if (r1 == false) goto L16;
        r2 = R.string.lock_screen_notifications_summary_show;
        goto L17
    L16:
        r2 = R.string.lock_screen_notifications_summary_hide;
        goto L17
    L8:
        if (getLockscreenAllowPrivateNotifications(UserHandle.myUserId()) == true) goto L11;
        r1 = false;
        goto L12
    }

    private void updateLockscreenNotificationsForProfile() {
        int r0 = this.mProfileChallengeUserId;
        if (r0 != (-10000)) goto L6;
        return;
    L6:
        if (this.mLockscreenProfile != null) goto L8;
        return;
    L8:
        boolean r1 = getLockscreenNotificationsEnabled(r0);
        if (this.mSecureProfile == true) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r1 == true) goto L17;
        int r3 = R.string.lock_screen_notifications_summary_disable_profile;
    L20:
        this.mLockscreenSelectedValueProfile = r3;
        this.mLockscreenProfile.setValue(Integer.toString(r3));
        return;
    L17:
        if (r2 == false) goto L19;
        r3 = R.string.lock_screen_notifications_summary_show_profile;
        goto L20
    L19:
        r3 = R.string.lock_screen_notifications_summary_hide_profile;
        goto L20
    L11:
        if (getLockscreenAllowPrivateNotifications(this.mProfileChallengeUserId) == true) goto L14;
        r2 = false;
        goto L15
    }

    private boolean getLockscreenNotificationsEnabled(int r3) {
        if (Settings.Secure.getIntForUser(getContentResolver(), "lock_screen_show_notifications", 0, r3) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean getLockscreenAllowPrivateNotifications(int r3) {
        if (Settings.Secure.getIntForUser(getContentResolver(), "lock_screen_allow_private_notifications", 0, r3) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ConfigureNotificationSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_ConfigureNotificationSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ConfigureNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ConfigureNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ConfigureNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_ConfigureNotificationSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
