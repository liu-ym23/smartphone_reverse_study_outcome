package com.android.settings.eldership;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import com.android.settings.DisplaySizeSettingsFragment;
import com.android.settings.FontScaleSettingsActivity;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
class BasicEldershipSettingsBehavior implements IEldershipSettingsBehavior {
    private Context mContext;
    private BaseFragment mHostFragment;

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getScreenZoom() {
        return null;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void handleSubSettingsResult(int r1, int r2, Bundle r3) {
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isEldershipModeEnable() {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void onSaveInstanceState(Bundle r1) {
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setEldershipModeEnable(boolean r1) {
    }

    public BasicEldershipSettingsBehavior(BaseFragment r1) {
        this.mHostFragment = r1;
        this.mContext = r1.getContext();
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setMuteDoubleCheckEnable(boolean r2) {
        saveGlobalSetting("mute_double_check_enable", r2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isMuteDoubleCheckEnable() {
        return isGlobalSettingEnabled("mute_double_check_enable", false);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isTextBoomEnable() {
        return isGlobalSettingEnabled("text_boom", true);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setTextBoomEnable(boolean r2) {
        saveGlobalSetting("text_boom", r2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isOneStepEnable() {
        return isGlobalSettingEnabled("side_bar_mode", true);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setOneStepEnable(boolean r2) {
        saveGlobalSetting("side_bar_mode", r2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public boolean isthinkboostEnable() {
        return isGlobalSettingEnabled(SettingsSwitchKeyUtil.VOICE_INPUT, true);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void setthinkboostEnable(boolean r2) {
        if (r2 == false) goto L5;
        saveGlobalSetting(SettingsSwitchKeyUtil.VOICE_INPUT, r2);
        return;
    L5:
        saveGlobalSetting(SettingsSwitchKeyUtil.VOICE_INPUT, r2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getLauncherSetting() {
        Context r0 = this.mContext;
        return EldershipUtils.getLauncherSettingSubTitle(r0, Utils.getCurrentLauncherMode(r0), Utils.getCurrentLauncherTheme(this.mContext));
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public CharSequence getFontSize() {
        return Utils.getCurrentFontScaleStr(this.mContext);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startLauncherSetting() {
        this.mHostFragment.start(EldershipLauncherSettingFragment.newInstance(Utils.getCurrentLauncherMode(this.mContext), Utils.getCurrentLauncherTheme(this.mContext), false));
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startFontSizeSetting() {
        this.mHostFragment.startActivity(new Intent(this.mContext, FontScaleSettingsActivity.class));
    }

    @Override // com.android.settings.eldership.IEldershipSettingsBehavior
    public void startScreenZoomSetting() {
        this.mHostFragment.start(DisplaySizeSettingsFragment.class);
    }

    private void saveGlobalSetting(String r1, boolean r2) {
        Settings.Global.putInt(this.mContext.getContentResolver(), r1, r2 ? 1 : 0);
    }

    private boolean isGlobalSettingEnabled(String r1, boolean r2) {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), r1, r2 ? 1 : 0) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
