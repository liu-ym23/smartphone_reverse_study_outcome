package com.android.settings.eldership;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
interface IEldershipSettingsController {
    boolean areSubSettingsEnabled(boolean r1);

    boolean areSubSettingsVisible(boolean r1);

    IEldershipSettingsBehavior getSettingsBehavior();

    View onCreateSwitcherView(Context r1, boolean r2, OnSwitcherCheckedChangedListener r3);

    boolean onSetupTitleAndOkButton(OFloatingTitleBar r1, Button r2);

    boolean showFamilyLoveSettings();

    boolean showLauncherSetting();

    boolean showRingtoneSetting();

    boolean showScreenZoomSetting();

    void updateSwitcherView(boolean r1);
}
