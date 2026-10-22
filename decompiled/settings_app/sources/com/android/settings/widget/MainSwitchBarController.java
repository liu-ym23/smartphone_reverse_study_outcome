package com.android.settings.widget;

import android.widget.Switch;
import com.android.settingslib.RestrictedLockUtils;

/* JADX INFO: loaded from: classes.dex */
public class MainSwitchBarController extends SwitchWidgetController implements SwitchBar.OnSwitchChangeListener {
    private final SwitchBar mMainSwitch;

    public MainSwitchBarController(SwitchBar r1) {
        this.mMainSwitch = r1;
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void setupView() {
        this.mMainSwitch.show();
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void teardownView() {
        this.mMainSwitch.hide();
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void setTitle(String r1) {
        this.mMainSwitch.setTitle(r1);
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void startListening() {
        this.mMainSwitch.addOnSwitchChangeListener(this);
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void stopListening() {
        this.mMainSwitch.removeOnSwitchChangeListener(this);
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void setChecked(boolean r1) {
        this.mMainSwitch.setChecked(r1);
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public boolean isChecked() {
        return this.mMainSwitch.isChecked();
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void setEnabled(boolean r1) {
        this.mMainSwitch.setEnabled(r1);
    }

    @Override // com.android.settings.widget.SwitchBar.OnSwitchChangeListener
    public void onSwitchChanged(Switch r1, boolean r2) {
        if (this.mListener == null) goto L6;
        this.mListener.onSwitchToggled(r2);
        return;
    }

    @Override // com.android.settings.widget.SwitchWidgetController
    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r1) {
        this.mMainSwitch.setDisabledByAdmin(r1);
    }
}
