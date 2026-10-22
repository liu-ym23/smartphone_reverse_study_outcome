package com.android.settings.eldership;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
interface IEldershipSettingsBehavior {
    CharSequence getFontSize();

    CharSequence getLauncherSetting();

    CharSequence getScreenZoom();

    void handleSubSettingsResult(int r1, int r2, Bundle r3);

    boolean isEldershipModeEnable();

    boolean isMuteDoubleCheckEnable();

    boolean isOneStepEnable();

    boolean isTextBoomEnable();

    boolean isthinkboostEnable();

    void onSaveInstanceState(Bundle r1);

    void setEldershipModeEnable(boolean r1);

    void setMuteDoubleCheckEnable(boolean r1);

    void setOneStepEnable(boolean r1);

    void setTextBoomEnable(boolean r1);

    void setthinkboostEnable(boolean r1);

    void startFontSizeSetting();

    void startLauncherSetting();

    void startScreenZoomSetting();
}
