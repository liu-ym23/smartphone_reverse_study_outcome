package com.android.settings.revone;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.SliderWithIcons;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class TabletSettingsFragment extends BaseFragment implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private SettingItemSwitch mAutoBrightnessSwitch;
    private final ContentObserver mBrightnessModeObserver;
    private final ContentObserver mBrightnessObserver;
    private Handler mHandler;
    private boolean mInTrack;
    private SettingItemText mKeyboardCustomKeyItem;
    private int mMaxBrightness;
    private int mMinBrightness;
    private SettingItemText mMouseKeyboardItem;
    private SliderWithIcons mSeekBar;
    private SettingItemText mShortcutSettings;
    private SettingItemText mSightTrackingItem;
    private SettingItemText mWallpaperView;

    public void com_android_settings_revone_TabletSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TabletSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TabletSettingsFragment() {
        this.mMaxBrightness = 100;
        this.mMinBrightness = 0;
        this.mInTrack = false;
        this.mHandler = new Handler();
        final Handler r1 = this.mHandler;
        this.mBrightnessObserver = new AnonymousClass1(this, r1);
        final Handler r2 = this.mHandler;
        this.mBrightnessModeObserver = new AnonymousClass2(this, r2);
    }

    static /* synthetic */ void access$000(TabletSettingsFragment r0) {
        r0.onBrightnessChanged();
    }

    static /* synthetic */ void access$100(TabletSettingsFragment r0) {
        r0.updateBrightnessMode();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.revone_tablet_settings_layout, r3, false);
        SliderWithIcons r5 = (SliderWithIcons) findViewByIdNullable(R.id.brightness_seekbar);
        this.mSeekBar = r5;
        r5.setOnSeekBarChangeListener(this);
        this.mSeekBar.setMax(this.mMaxBrightness - this.mMinBrightness);
        this.mAutoBrightnessSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.switch_auto_brightness);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.wallpaper_settings);
        this.mWallpaperView = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewByIdNullable(R.id.shortcut_btn);
        this.mShortcutSettings = r7;
        r7.setOnClickListener(this);
        SettingItemText r8 = (SettingItemText) findViewByIdNullable(R.id.mouse_key_mode);
        this.mMouseKeyboardItem = r8;
        r8.setOnClickListener(this);
        SettingItemText r9 = (SettingItemText) findViewByIdNullable(R.id.custom_keyboard);
        this.mKeyboardCustomKeyItem = r9;
        r9.setOnClickListener(this);
        SettingItemText r10 = (SettingItemText) findViewByIdNullable(R.id.sight_tracking);
        this.mSightTrackingItem = r10;
        r10.setOnClickListener(this);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mAutoBrightnessSwitch.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        this.mSeekBar.setProgress(getProgressByCurBrightness());
        updateBrightnessMode();
        registerBrightnessContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterBrightnessContentObserver();
    }

    private int getProgressByCurBrightness() {
        int r0 = getBrightness();
        int r1 = this.mMinBrightness;
        if (r0 >= r1) goto L5;
        r0 = r1;
    L5:
        int r2 = this.mMaxBrightness;
        if (r0 <= r2) goto L9;
        r0 = r2;
    L9:
        return r0 - r1;
    }

    private void onBrightnessChanged() {
        if (this.mInTrack == true) goto L6;
        this.mSeekBar.setProgress(getProgressByCurBrightness());
        return;
    }

    private void updateBrightnessMode() {
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), "revone_screen_brightness_mode", 0) != 1) goto L5;
        r2 = true;
    L5:
        this.mAutoBrightnessSwitch.setChecked(r2);
    }

    private int getBrightness() {
        return Settings.Global.getInt(getContentResolver(), "revone_realtime_screen_brightness", 50);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        new Intent().putExtra("back_text", getString(R.string.tablet_settings));
        if (r4 != this.mWallpaperView) goto L6;
        start(TabletWallpaperSettings.class);
        return;
    L6:
        if (r4 != this.mShortcutSettings) goto L9;
        start(TabletShortcutSettings.class);
        return;
    L9:
        if (r4 != this.mMouseKeyboardItem) goto L12;
        start(MouseSettingsFragment.class);
        return;
    L12:
        if (r4 != this.mKeyboardCustomKeyItem) goto L15;
        start(KeyboardSettingsFragment.class);
        return;
    L15:
        if (r4 != this.mSightTrackingItem) goto L22;
        start(SightTrackingSettingsFragment.class);
        return;
    }

    private void registerBrightnessContentObserver() {
        ContentResolver r0 = getContentResolver();
        r0.registerContentObserver(Settings.Global.getUriFor("revone_realtime_screen_brightness"), true, this.mBrightnessObserver);
        r0.registerContentObserver(Settings.Global.getUriFor("revone_screen_brightness_mode"), true, this.mBrightnessModeObserver);
    }

    private void unregisterBrightnessContentObserver() {
        ContentResolver r0 = getContentResolver();
        r0.unregisterContentObserver(this.mBrightnessObserver);
        r0.unregisterContentObserver(this.mBrightnessModeObserver);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mAutoBrightnessSwitch.getSwitch()) goto L6;
        Settings.Global.putInt(getContentResolver(), "revone_screen_brightness_mode", r3 ? 1 : 0);
        return;
    }

    private int getBrightnessByProgress(int r1) {
        return this.mMinBrightness + r1;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        Settings.Global.putInt(getContentResolver(), "revone_realtime_screen_brightness", getBrightnessByProgress(r2));
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        this.mInTrack = true;
        unregisterBrightnessContentObserver();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r3) {
        this.mInTrack = false;
        Settings.Global.putInt(getContentResolver(), "revone_realtime_screen_brightness", getBrightnessByProgress(r3.getProgress()));
        registerBrightnessContentObserver();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TabletSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TabletSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TabletSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
