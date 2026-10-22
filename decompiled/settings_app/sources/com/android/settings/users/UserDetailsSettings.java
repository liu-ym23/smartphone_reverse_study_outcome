package com.android.settings.users;

import android.app.Dialog;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class UserDetailsSettings extends SettingsPreferenceFragment implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {
    private static final int DIALOG_CONFIRM_ENABLE_CALLING = 2;
    private static final int DIALOG_CONFIRM_ENABLE_CALLING_AND_SMS = 3;
    private static final int DIALOG_CONFIRM_REMOVE = 1;
    static final String EXTRA_USER_GUEST = "guest_user";
    static final String EXTRA_USER_ID = "user_id";
    private static final String KEY_ENABLE_TELEPHONY = "enable_calling";
    private static final String KEY_REMOVE_USER = "remove_user";
    private static final String TAG = "UserDetailsSettings";
    private Bundle mDefaultGuestRestrictions;
    private boolean mGuestUser;
    private SwitchPreference mPhonePref;
    private Preference mRemoveUserPref;
    private UserInfo mUserInfo;
    private UserManager mUserManager;

    static {
    }

    public void com_android_settings_users_UserDetailsSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public UserDetailsSettings() {
    }

    public void com_android_settings_users_UserDetailsSettings__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        FragmentActivity r8 = getActivity();
        this.mUserManager = (UserManager) r8.getSystemService(PickApplicationActivity.EXTRA_USER);
        addPreferencesFromResource(R.xml.user_details_settings);
        this.mPhonePref = (SwitchPreference) findPreference(KEY_ENABLE_TELEPHONY);
        this.mRemoveUserPref = findPreference(KEY_REMOVE_USER);
        boolean r1 = getArguments().getBoolean(EXTRA_USER_GUEST, false);
        this.mGuestUser = r1;
        if (r1 == true) goto L9;
        int r2 = getArguments().getInt("user_id", -1);
        if (r2 == (-1)) goto L8;
        this.mUserInfo = this.mUserManager.getUserInfo(r2);
        this.mPhonePref.setChecked(!this.mUserManager.hasUserRestriction("no_outgoing_calls", new UserHandle(r2)));
        this.mRemoveUserPref.setOnPreferenceClickListener(this);
    L11:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(r8, "no_remove_user", UserHandle.myUserId()) == false) goto L13;
        removePreference(KEY_REMOVE_USER);
    L13:
        this.mPhonePref.setOnPreferenceChangeListener(this);
        return;
    L8:
        throw new RuntimeException("Arguments to this fragment must contain the user id");
    L9:
        removePreference(KEY_REMOVE_USER);
        this.mPhonePref.setTitle(R.string.user_enable_calling);
        Bundle r3 = this.mUserManager.getDefaultGuestRestrictions();
        this.mDefaultGuestRestrictions = r3;
        this.mPhonePref.setChecked(!r3.getBoolean("no_outgoing_calls"));
        goto L11
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r2) {
        if (r2 == this.mRemoveUserPref) goto L5;
        return false;
    L5:
        if (this.mUserManager.isAdminUser() == false) goto L9;
        showDialog(1);
        return true;
    L9:
        throw new RuntimeException("Only admins can remove a user");
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        if (Boolean.TRUE.equals(r2) == true) goto L5;
        enableCallsAndSms(false);
        return true;
    L5:
        if (this.mGuestUser == false) goto L7;
        int r3 = 2;
    L8:
        showDialog(r3);
        return false;
    L7:
        r3 = 3;
        goto L8
    }

    void enableCallsAndSms(boolean r7) {
        this.mPhonePref.setChecked(r7);
        if (this.mGuestUser == false) goto L13;
        this.mDefaultGuestRestrictions.putBoolean("no_outgoing_calls", !r7);
        this.mDefaultGuestRestrictions.putBoolean("no_sms", true);
        this.mUserManager.setDefaultGuestRestrictions(this.mDefaultGuestRestrictions);
        Iterator r8 = this.mUserManager.getUsers(true).iterator();
    L6:
        if (r8.hasNext() == false) goto L20;
        UserInfo r0 = (UserInfo) r8.next();
        if (r0.isGuest() == false) goto L6;
        UserHandle r1 = UserHandle.of(r0.id);
        Iterator<String> r2 = this.mDefaultGuestRestrictions.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        this.mUserManager.setUserRestriction(r3, this.mDefaultGuestRestrictions.getBoolean(r3), r1);
        goto L11
    L20:
        return;
    L13:
        UserHandle r4 = UserHandle.of(this.mUserInfo.id);
        this.mUserManager.setUserRestriction("no_outgoing_calls", !r7, r4);
        this.mUserManager.setUserRestriction("no_sms", !r7, r4);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r3) {
        if (getActivity() != null) goto L7;
        return null;
    L7:
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L15;
        return UserDialogs.createEnablePhoneCallsAndSmsDialog(getActivity(), new AnonymousClass3(this));
    L15:
        throw new IllegalArgumentException("Unsupported dialogId " + r3);
    L17:
        return UserDialogs.createEnablePhoneCallsDialog(getActivity(), new AnonymousClass2(this));
    L19:
        return UserDialogs.createRemoveDialog(getActivity(), this.mUserInfo.id, new AnonymousClass1(this));
    }

    void removeUser() {
        this.mUserManager.removeUser(this.mUserInfo.id);
        finishFragment();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(UserDetailsSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_UserDetailsSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(UserDetailsSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_UserDetailsSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(UserDetailsSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_UserDetailsSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
