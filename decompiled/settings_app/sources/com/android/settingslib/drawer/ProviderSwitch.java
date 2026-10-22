package com.android.settingslib.drawer;

/* JADX INFO: loaded from: classes.dex */
public interface ProviderSwitch {
    String getSwitchErrorMessage(boolean r1);

    boolean isSwitchChecked();

    boolean onSwitchCheckedChanged(boolean r1);
}
