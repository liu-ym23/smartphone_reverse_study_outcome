package com.android.settings.fuelgauge;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.AttributeSet;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import com.android.settings.R;
import com.bytedance.apm.battery.config.BatteryTypeInf;

/* JADX INFO: loaded from: classes2.dex */
public class BatterySaverPreference extends Preference {
    private final ContentObserver mObserver;
    private PowerManager mPowerManager;

    static /* synthetic */ void access$000(BatterySaverPreference r0) {
        r0.updateSwitch();
    }

    public BatterySaverPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        final Handler r3 = new Handler();
        this.mObserver = new AnonymousClass1(this, r3);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        Fragment r4 = (Fragment) null;
        com.android.settings.Utils.startWithFragment(getContext(), getFragment(), null, null, 0, 0, getTitle());
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.mPowerManager = (PowerManager) getContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mObserver.onChange(true);
        getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power_trigger_level"), true, this.mObserver);
        getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power"), true, this.mObserver);
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        getContext().getContentResolver().unregisterContentObserver(this.mObserver);
    }

    private void updateSwitch() {
        Context r0 = getContext();
        if (this.mPowerManager.isPowerSaveMode() == false) goto L5;
        int r1 = R.string.battery_saver_on_summary;
    L6:
        int r2 = Settings.Global.getInt(r0.getContentResolver(), "low_power_trigger_level", 0);
        if (r2 <= 0) goto L9;
        int r3 = R.string.battery_saver_desc_turn_on_auto_pct;
    L10:
        setSummary(r0.getString(r1, new Object[]{r0.getString(r3, new Object[]{com.android.settings.Utils.formatPercentage(r2)})}));
        return;
    L9:
        r3 = R.string.battery_saver_desc_turn_on_auto_never;
        goto L10
    L5:
        r1 = R.string.battery_saver_off_summary;
        goto L6
    }
}
