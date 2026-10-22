package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SwitchBar;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenPinningSettings extends SettingsPreferenceFragment implements SwitchBar.OnSwitchChangeListener {
    private static final int CHANGE_LOCK_METHOD_REQUEST = 43;
    private static final CharSequence KEY_USE_SCREEN_LOCK = null;
    private LockPatternUtils mLockPatternUtils;
    private SwitchBar mSwitchBar;
    private SwitchPreference mUseScreenLock;

    public void com_android_settings_ScreenPinningSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ScreenPinningSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ScreenPinningSettings() {
    }

    static /* synthetic */ boolean access$000(ScreenPinningSettings r0, boolean r1) {
        return r0.setScreenLockUsed(r1);
    }

    static {
        KEY_USE_SCREEN_LOCK = "use_screen_lock";
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        SettingsActivity r3 = (SettingsActivity) getActivity();
        this.mLockPatternUtils = new LockPatternUtils(r3);
        SwitchBar r4 = r3.getSwitchBar();
        this.mSwitchBar = r4;
        r4.addOnSwitchChangeListener(this);
        this.mSwitchBar.show();
        this.mSwitchBar.setChecked(isLockToAppEnabled(getActivity()));
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        ViewGroup r5 = (ViewGroup) r3.findViewById(android.R.id.list_container);
        View r6 = LayoutInflater.from(getContext()).inflate(R.layout.screen_pinning_instructions, r5, false);
        r5.addView(r6);
        setEmptyView(r6);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mSwitchBar.removeOnSwitchChangeListener(this);
        this.mSwitchBar.hide();
    }

    private static boolean isLockToAppEnabled(Context r2) {
        if (android.provider.Settings.System.getInt(r2.getContentResolver(), "lock_to_app_enabled", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setLockToAppEnabled(boolean r3) {
        android.provider.Settings.System.putInt(getContentResolver(), "lock_to_app_enabled", r3 ? 1 : 0);
        if (r3 == false) goto L6;
        setScreenLockUsedSetting(isScreenLockUsed());
        return;
    }

    private boolean isScreenLockUsed() {
        boolean r0 = this.mLockPatternUtils.isSecure(UserHandle.myUserId());
        if (android.provider.Settings.Secure.getInt(getContentResolver(), "lock_to_app_exit_locked", r0 ? 1 : 0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean setScreenLockUsed(boolean r3) {
        if (r3 == true) goto L4;
    L7:
        setScreenLockUsedSetting(r3);
        return true;
    L4:
        if (new LockPatternUtils(getActivity()).getKeyguardStoredPasswordQuality(UserHandle.myUserId()) != 0) goto L7;
        Intent r4 = new Intent("android.app.action.SET_NEW_PASSWORD");
        r4.putExtra("minimum_quality", 65536);
        startActivityForResult(r4, 43);
        return false;
    }

    private void setScreenLockUsedSetting(boolean r2) {
        android.provider.Settings.Secure.putInt(getContentResolver(), "lock_to_app_exit_locked", r2 ? 1 : 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (r1 == 43) goto L5;
        return;
    L5:
        if (new LockPatternUtils(getActivity()).getKeyguardStoredPasswordQuality(UserHandle.myUserId()) == 0) goto L7;
        boolean r4 = true;
    L8:
        setScreenLockUsed(r4);
        this.mUseScreenLock.setChecked(r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    private int getCurrentSecurityTitle() {
        int r0 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserHandle.myUserId());
        if (r0 == 65536) goto L22;
        if (r0 != 131072) goto L7;
        return R.string.screen_pinning_unlock_pin;
    L7:
        if (r0 != 196608) goto L9;
        return R.string.screen_pinning_unlock_pin;
    L9:
        if (r0 != 262144) goto L11;
        return R.string.screen_pinning_unlock_password;
    L11:
        if (r0 != 327680) goto L13;
        return R.string.screen_pinning_unlock_password;
    L13:
        if (r0 != 393216) goto L15;
        return R.string.screen_pinning_unlock_password;
    L15:
        if (r0 != 524288) goto L31;
        return R.string.screen_pinning_unlock_password;
    L31:
        return R.string.screen_pinning_unlock_none;
    L22:
        if (this.mLockPatternUtils.isLockPatternEnabled(UserHandle.myUserId()) == false) goto L25;
        return R.string.screen_pinning_unlock_pattern;
    L25:
        return R.string.screen_pinning_unlock_none;
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        setLockToAppEnabled(r2);
        updateDisplay();
    }

    public void updateDisplay() {
        PreferenceScreen r0 = getPreferenceScreen();
        if (r0 == null) goto L6;
        r0.removeAll();
    L6:
        if (isLockToAppEnabled(getActivity()) == false) goto L12;
        addPreferencesFromResource(R.xml.screen_pinning_settings);
        SwitchPreference r1 = (SwitchPreference) getPreferenceScreen().findPreference(KEY_USE_SCREEN_LOCK);
        this.mUseScreenLock = r1;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.setOnPreferenceChangeListener(new AnonymousClass1(this));
        this.mUseScreenLock.setChecked(isScreenLockUsed());
        this.mUseScreenLock.setTitle(getCurrentSecurityTitle());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScreenPinningSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenPinningSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScreenPinningSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ScreenPinningSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScreenPinningSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ScreenPinningSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
