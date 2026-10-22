package com.android.settings.fuelgauge;

import android.os.BatteryStats;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryWifiParser extends BatteryFlagParser {
    public BatteryWifiParser(int r2) {
        super(r2, false, 0);
    }

    @Override // com.android.settings.fuelgauge.BatteryFlagParser
    protected boolean isSet(BatteryStats.HistoryItem r3) {
        int r2 = (r3.states2 & 15) >> 0;
        if (r2 != 0) goto L5;
    L15:
        return false;
    L5:
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L15;
        if (r2 == 11) goto L15;
        if (r2 == 12) goto L15;
        return true;
    }
}
