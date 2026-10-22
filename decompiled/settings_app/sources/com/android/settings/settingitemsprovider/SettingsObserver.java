package com.android.settings.settingitemsprovider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import com.android.settings.Calibration;
import com.android.settings.ScreenRefreshRateFragment;
import com.android.settings.SettingsFeature;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.settingitemsprovider.Items.IntelligentSettingItems;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsObserver extends ContentObserver {
    private static final String TAG = "SettingItems";
    private Context mContext;
    private DatabaseHelper mHelper;

    public SettingsObserver(Handler r1) {
        super(r1);
        OLog.d(TAG, "SettingsObserver created");
    }

    public void setup(Context r1, DatabaseHelper r2) {
        this.mContext = r1;
        this.mHelper = r2;
        registerAllObservers();
    }

    public void registerAllObservers() {
        ContentResolver r0 = this.mContext.getContentResolver();
        r0.registerContentObserver(Settings.Global.getUriFor("mobile_data"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor("radio_stk_ready"), false, this);
        r0.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_daltonizer_enabled"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor("smt_5g_status"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor(ScreenRefreshRateFragment.SCREEN_REFRESH_RATE), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor(SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor("auto_time"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor("glove_mode_enable"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor(IntelligentSettingItems.IS_AUTO_RECORD_ENABLED), false, this);
        r0.registerContentObserver(Settings.Secure.getUriFor("night_display_activated"), false, this);
        r0.registerContentObserver(Settings.Global.getUriFor("navigationbar_trigger_mode"), false, this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r2, Uri r3) {
        OLog.d(TAG, "DB value changed : uri = " + r3);
        this.mHelper.notifyChanged(r3);
        handleSettingsChanged(r3);
    }

    private void handleSettingsChanged(Uri r3) {
        if (r3.equals(Settings.Global.getUriFor("glove_mode_enable")) == true) goto L5;
        return;
    L5:
        if (SettingsFeature.isSupportGloveMode() == false) goto L12;
        boolean r4 = false;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "glove_mode_enable", 0) != 1) goto L9;
        r4 = true;
    L9:
        Calibration.setGloveMode(r4);
        return;
    }
}
