package com.android.settings.fuelgauge;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;
import com.android.settings.graph.UsageView;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryHistoryPreference_ extends Preference {
    protected static final String BATTERY_HISTORY_FILE = "tmp_bat_history.bin";
    private BatteryInfo mBatteryInfo;

    public BatteryHistoryPreference_(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.battery_usage_graph);
        setSelectable(true);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        Bundle r2 = new Bundle();
        r2.putString(BatteryHistoryDetail.EXTRA_STATS, BATTERY_HISTORY_FILE);
        Fragment r7 = (Fragment) null;
        com.android.settings.Utils.startWithFragment(getContext(), BatteryHistoryDetail.class.getName(), r2, null, 0, R.string.history_details_title, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        if (this.mBatteryInfo != null) goto L5;
        return;
    L5:
        r3.itemView.setClickable(true);
        r3.setDividerAllowedAbove(true);
        ((TextView) r3.findViewById(R.id.charge)).setText(this.mBatteryInfo.batteryPercentString);
        ((TextView) r3.findViewById(R.id.estimation)).setText(this.mBatteryInfo.remainingLabel);
        UsageView r4 = (UsageView) r3.findViewById(R.id.battery_usage);
        r4.findViewById(R.id.label_group).setAlpha(0.7f);
        this.mBatteryInfo.bindHistory(r4, new BatteryInfo.BatteryDataParser[0]);
    }
}
