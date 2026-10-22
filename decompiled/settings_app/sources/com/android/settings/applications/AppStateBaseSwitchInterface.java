package com.android.settings.applications;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes2.dex */
public interface AppStateBaseSwitchInterface {
    boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1);

    boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1);

    CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(com.android.settingslib.applications.ApplicationsState.AppEntry r1);
}
