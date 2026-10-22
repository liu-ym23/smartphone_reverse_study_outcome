package com.android.settings.eldership;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
class WizardEldershipSettingsController implements IEldershipSettingsController, View.OnClickListener {
    private Activity mActivity;
    private SettingItemCheck mItemUsageForEldership;
    private SettingItemCheck mItemUsageForMyself;
    private Button mOkButton;
    private WizardEldershipSettingsBehavior mSettingsBehavior;
    private OnSwitcherCheckedChangedListener mSwitcherCheckedChangedListener;
    private View mSwitcherView;

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean areSubSettingsEnabled(boolean r1) {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean areSubSettingsVisible(boolean r1) {
        return r1;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showFamilyLoveSettings() {
        return false;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showLauncherSetting() {
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showRingtoneSetting() {
        return false;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean showScreenZoomSetting() {
        return false;
    }

    static /* synthetic */ void access$000(WizardEldershipSettingsController r0) {
        r0.startNextWizardStep();
    }

    static /* synthetic */ Button access$100(WizardEldershipSettingsController r0) {
        return r0.mOkButton;
    }

    public WizardEldershipSettingsController(BaseFragment r2, Bundle r3) {
        this.mActivity = r2.getActivity();
        this.mSettingsBehavior = new WizardEldershipSettingsBehavior(r2, r3);
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public boolean onSetupTitleAndOkButton(OFloatingTitleBar r2, Button r3) {
        r2.setCenterTitle(R.string.eldership_mode_settings_setup_wizard_title);
        this.mOkButton = r3;
        r3.setVisibility(0);
        r3.setText(R.string.next_step);
        r3.setOnClickListener(this);
        return true;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public View onCreateSwitcherView(Context r3, boolean r4, OnSwitcherCheckedChangedListener r5) {
        View r6 = View.inflate(r3, R.layout.setup_wizard_eldership_switcher, null);
        this.mItemUsageForMyself = (SettingItemCheck) r6.findViewById(R.id.item_usage_for_myself);
        this.mItemUsageForEldership = (SettingItemCheck) r6.findViewById(R.id.item_usage_for_eldership);
        this.mSwitcherView = r6;
        this.mSwitcherCheckedChangedListener = r5;
        this.mItemUsageForMyself.setOnClickListener(this);
        this.mItemUsageForEldership.setOnClickListener(this);
        updateSwitcherView(r4);
        return r6;
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public void updateSwitcherView(boolean r3) {
        if (this.mSwitcherView != null) goto L5;
        return;
    L5:
        this.mItemUsageForMyself.setChecked(!r3);
        this.mItemUsageForEldership.setChecked(r3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        boolean r1 = true;
        if (r3 == this.mItemUsageForMyself) goto L15;
        if (r3 == this.mItemUsageForEldership) goto L15;
        Button r0 = this.mOkButton;
        if (r3 == r0) goto L10;
        return;
    L10:
        if (r0.getTag() != null) goto L12;
    L13:
        this.mOkButton.setTag(true);
        this.mSettingsBehavior.saveSettings(new AnonymousClass1(this));
        return;
    L12:
        if (((Boolean) this.mOkButton.getTag()).booleanValue() == false) goto L13;
        return;
    L15:
        if (r3 == this.mItemUsageForEldership) goto L18;
        r1 = false;
    L18:
        toggleEldershipModeIfNeed(r1);
    }

    private void startNextWizardStep() {
        if (this.mSwitcherView != null) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        if (this.mItemUsageForEldership.isChecked() == false) goto L8;
        r0.setClassName("com.bytedanceos.cloudsync", "com.bytedanceos.accounts.AccountsActivity");
        r0.putExtra("bytedance_origin_app_tag", "first_step");
    L9:
        Utils.startActivity(this.mActivity, r0);
        return;
    L8:
        r0.setClassName("com.android.settings", "com.android.settings.LauncherChooseActivity");
        goto L9
    }

    private void toggleEldershipModeIfNeed(boolean r2) {
        if (this.mSwitcherView != null) goto L6;
        return;
    L6:
        if (this.mItemUsageForEldership.isChecked() == r2) goto L15;
        if (r2 == false) goto L9;
    L11:
        updateSwitcherView(r2);
        OnSwitcherCheckedChangedListener r1 = this.mSwitcherCheckedChangedListener;
        if (r1 == null) goto L16;
        r1.onEldershipModeCheckedChanged(r2);
        return;
    L16:
        return;
    L9:
        if (this.mSettingsBehavior.areEldershipSettingsSaved() == false) goto L11;
        this.mSettingsBehavior.setEldershipSettingsToDefault();
        goto L11
    }

    @Override // com.android.settings.eldership.IEldershipSettingsController
    public IEldershipSettingsBehavior getSettingsBehavior() {
        return this.mSettingsBehavior;
    }
}
