package com.android.settings.eldership;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
class BasicEldershipSettingsController implements IEldershipSettingsController {
    private Context mContext;
    private BasicEldershipSettingsBehavior mSettingsBehavior;

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean areSubSettingsEnabled(boolean r1) {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean areSubSettingsVisible(boolean r1) {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public View onCreateSwitcherView(Context r1, boolean r2, OnSwitcherCheckedChangedListener r3) {
        return null;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showFamilyLoveSettings() {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showRingtoneSetting() {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showScreenZoomSetting() {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public void updateSwitcherView(boolean r1) {
    }

    public BasicEldershipSettingsController(BaseFragment r2) {
        this.mContext = r2.getActivity();
        this.mSettingsBehavior = new BasicEldershipSettingsBehavior(r2);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean onSetupTitleAndOkButton(OFloatingTitleBar r1, Button r2) {
        r1.setCenterTitle(R.string.eldership_mode_settings_title);
        r2.setVisibility(8);
        return false;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showLauncherSetting() {
        return Utils.isBytedanceLauncher(this.mContext);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public IEldershipSettingsBehavior getSettingsBehavior() {
        return this.mSettingsBehavior;
    }
}
