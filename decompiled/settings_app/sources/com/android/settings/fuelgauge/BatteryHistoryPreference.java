package com.android.settings.fuelgauge;

import android.content.Context;
import android.content.Intent;
import android.os.BatteryStats;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.SettingsActivity;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryHistoryPreference extends Preference {
    protected static final String BATTERY_HISTORY_FILE = "tmp_bat_history.bin";
    private Intent mBatteryBroadcast;
    private BatteryHistoryChart mChart;
    private BatteryStats mStats;

    public BatteryHistoryPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.battery_history_chart);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        Bundle r3 = new Bundle();
        r3.putString(BatteryHistoryDetail.EXTRA_STATS, BATTERY_HISTORY_FILE);
        if ((getContext() instanceof SettingsActivity) == false) goto L9;
        Fragment r8 = (Fragment) null;
        ((SettingsActivity) getContext()).startPreferencePanel(BatteryHistoryDetail.class.getName(), r3, R.string.history_details_title, null, null, 0);
        return;
    }

    BatteryStats getStats() {
        return this.mStats;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        super.onBindViewHolder(r4);
        if (this.mStats != null) goto L5;
        return;
    L5:
        BatteryHistoryChart r5 = (BatteryHistoryChart) r4.findViewById(R.id.battery_history_chart);
        if (this.mChart != null) goto L8;
        r5.setStats(this.mStats, this.mBatteryBroadcast);
        this.mChart = r5;
        return;
    L8:
        ViewGroup r0 = (ViewGroup) r5.getParent();
        int r6 = r0.indexOfChild(r5);
        r0.removeViewAt(r6);
        if (this.mChart.getParent() == null) goto L11;
        ((ViewGroup) this.mChart.getParent()).removeView(this.mChart);
    L11:
        r0.addView(this.mChart, r6);
    }
}
