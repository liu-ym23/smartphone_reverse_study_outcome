package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes2.dex */
public class KeyguardSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private SettingItemSwitch mDisplayLargeBatterySwitch;
    private SettingItemSwitch mDisplayWhenScreenOffSwitch;
    private PreviewSettingItemView mKeyguardStyleClassic;
    private PreviewSettingItemView mKeyguardStyleClock;
    private SettingItemText mLockScreenShortcutItem;
    private SettingItemTextVertical mLockScreenWallpaperItem;
    private ListContentItemText mNutsClockTheme;

    public void com_android_settings_KeyguardSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public KeyguardSettingsFragment() {
        super(R.layout.fragment_keyguard_settings);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        ((TextView) findViewByIdNullable(R.id.text_item_title)).setText(R.string.keyguard_style);
        PreviewSettingItemView r4 = (PreviewSettingItemView) findViewByIdNullable(R.id.item_preview_left);
        this.mKeyguardStyleClock = r4;
        r4.setOnClickListener(this);
        PreviewSettingItemView r5 = (PreviewSettingItemView) findViewByIdNullable(R.id.item_preview_right);
        this.mKeyguardStyleClassic = r5;
        r5.setOnClickListener(this);
        if (Utils.isCameraInScreen() == false) goto L5;
        this.mKeyguardStyleClassic.setPreview(R.drawable.keyguard_style_classic_gap_status_bar);
    L5:
        SettingItemTextVertical r6 = (SettingItemTextVertical) findViewByIdNullable(R.id.lock_screen_wallpaper);
        this.mLockScreenWallpaperItem = r6;
        r6.setOnClickListener(this);
        int r7 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_width);
        int r8 = (int) getResources().getDimension(R.dimen.wallpaper_settings_item_icon_height);
        this.mLockScreenWallpaperItem.setIconScale(r7, r8);
        SettingItemText r9 = (SettingItemText) findViewByIdNullable(R.id.lock_screen_shortcut);
        this.mLockScreenShortcutItem = r9;
        r9.setOnClickListener(this);
        if (SettingsFeature.isSupportForceTouch() == false) goto L8;
        ((TextView) findViewByIdNullable(R.id.lock_screen_shortcut_tips)).setText(R.string.lock_screen_shortcut_tips_force_touch);
    L8:
        this.mDisplayLargeBatterySwitch = (SettingItemSwitch) findViewByIdNullable(R.id.item_id_display_large_battery);
        this.mDisplayWhenScreenOffSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.display_when_screen_off);
        if (SettingsFeature.isDisplayWhenScreenOffSupport() == false) goto L11;
        this.mDisplayWhenScreenOffSwitch.setVisibility(0);
        this.mDisplayWhenScreenOffSwitch.setOnCheckedChangeListener(this);
        findViewByIdNullable(R.id.shadow_above_display_when_screen_off).setVisibility(0);
    L11:
        EventBus.getDefault().register(this);
        this.mNutsClockTheme = (ListContentItemText) findViewByIdNullable(R.id.nuts_clock_theme);
        if (SettingsFeature.isThemeClockSupport() == false) goto L15;
        this.mNutsClockTheme.setOnClickListener(this);
        this.mNutsClockTheme.setVisibility(0);
        findViewByIdNullable(R.id.shadow_above_nuts_clock_theme).setVisibility(0);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mDisplayLargeBatterySwitch.setOnCheckedChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    public void updateViews() {
        updateKeyguardStyle(getKeyguardStyle());
        boolean r3 = true;
        this.mLockScreenShortcutItem.setSubTitle(Utils.getSwitchStateResId(this.mContext, "keyguard_force_touch_state", 1));
        SettingItemSwitch r0 = this.mDisplayLargeBatterySwitch;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "display_large_battery_in_lockscreen", 1) != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        if (SettingsFeature.isDisplayWhenScreenOffSupport() == false) goto L14;
        SettingItemSwitch r2 = this.mDisplayWhenScreenOffSwitch;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "display_when_screen_off_enable", 0) == 1) goto L12;
        r3 = false;
    L12:
        r2.setChecked(r3);
        return;
    L14:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_KeyguardSettingsFragment__onResume$___twin___() {
        super.onResume();
        ExecutorManager.execute(new AnonymousClass1(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventType.LockscreenWallpaperIconUpdateEvent r1) {
        this.mLockScreenWallpaperItem.setIcon(r1.lockscreenWallpaper);
    }

    private void updateKeyguardStyle(int r5) {
        PreviewSettingItemView r0 = this.mKeyguardStyleClock;
        boolean r1 = false;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        PreviewSettingItemView r4 = this.mKeyguardStyleClassic;
        if (r5 != 1) goto L9;
        r1 = true;
    L9:
        r4.setChecked(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    private int getKeyguardStyle() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "keyguard_style", 0);
    }

    private void setKeyguardStyle(int r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "keyguard_style", r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        PreviewSettingItemView r0 = this.mKeyguardStyleClock;
        int r1 = 1;
        if (r4 != r0) goto L5;
    L16:
        if (r4 != r0) goto L18;
        r1 = 0;
    L18:
        setKeyguardStyle(r1);
        updateKeyguardStyle(r1);
        return;
    L5:
        if (r4 == this.mKeyguardStyleClassic) goto L16;
        if (r4 != this.mLockScreenWallpaperItem) goto L11;
        start(ChooseWallpaperTypeFragment.newInstance(1));
        return;
    L11:
        if (r4 != this.mLockScreenShortcutItem) goto L14;
        Intent r5 = new Intent();
        r5.putExtra("back_text", getString(R.string.keyguard_settings));
        r5.setClassName(Constants.PKG_KEYGUARD, "com.bytedanceos.keyguard.QuickItemSettingActivity");
        Utils.startActivity(this._mActivity, r5);
        return;
    L14:
        if (r4 != this.mNutsClockTheme) goto L22;
        start(ChooseLockThemeFragment.newInstance());
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mDisplayLargeBatterySwitch.getSwitch()) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "display_large_battery_in_lockscreen", r3 ? 1 : 0);
        return;
    L6:
        if (r2 != this.mDisplayWhenScreenOffSwitch.getSwitch()) goto L10;
        android.provider.Settings.Global.putInt(getContentResolver(), "display_when_screen_off_enable", r3 ? 1 : 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyguardSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_KeyguardSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyguardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_KeyguardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyguardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_KeyguardSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
