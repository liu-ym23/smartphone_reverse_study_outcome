package com.android.settings.fuelgauge;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.BatteryStats;
import android.text.format.Formatter;
import com.android.settings.R;
import com.android.settings.graph.UsageView;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryInfo {
    public int batteryLevel;
    public String batteryPercentString;
    public String chargeLabelString;
    public boolean discharging;
    private boolean mCharging;
    private BatteryStats mStats;
    public String remainingLabel;
    public long remainingTimeUs;
    public String statusLabel;
    private long timePeriod;

    public interface BatteryDataParser {
        void onDataGap();

        void onDataPoint(long r1, BatteryStats.HistoryItem r3);

        void onParsingDone();

        void onParsingStarted(long r1, long r3);
    }

    public interface Callback {
        void onBatteryInfoLoaded(BatteryInfo r1);
    }

    private static void parse(BatteryStats r0, long r1, BatteryDataParser... r3) {
    }

    public BatteryInfo() {
        this.discharging = true;
        this.remainingTimeUs = 0;
    }

    static /* synthetic */ long access$002(BatteryInfo r0, long r1) {
        r0.timePeriod = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(BatteryInfo r0) {
        return r0.mCharging;
    }

    public void bindHistory(final UsageView r9, BatteryDataParser... r10) {
        BatteryDataParser r0 = new AnonymousClass1(this, r9);
        BatteryDataParser[] r1 = new BatteryDataParser[r10.length + 1];
        int r4 = 0;
    L4:
        if (r4 >= r10.length) goto L6;
        r1[r4] = r10[r4];
        r4 = r4 + 1;
        goto L4
    L6:
        r1[r10.length] = r0;
        parse(this.mStats, this.remainingTimeUs, r1);
        Context r11 = r9.getContext();
        String r2 = r11.getString(R.string.charge_length_format, new Object[]{Formatter.formatShortElapsedTime(r11, this.timePeriod)});
        long r5 = this.remainingTimeUs;
        if (r5 == 0) goto L9;
        String r8 = r11.getString(R.string.remaining_length_format, new Object[]{Formatter.formatShortElapsedTime(r11, r5 / 1000)});
    L10:
        r9.setBottomLabels(new CharSequence[]{r2, r8});
        return;
    L9:
        r8 = "";
        goto L10
    }

    public static void getBatteryInfo(Context r1, Callback r2) {
        getBatteryInfo(r1, r2, false);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.fuelgauge.BatteryInfo$2] */
    public static void getBatteryInfo(final Context r1, final Callback r2, final boolean r3) {
        new AnonymousClass2(r1, r3, r2).execute(new Void[0]);
    }

    public static BatteryInfo getBatteryInfo(Context r6, Intent r7, BatteryStats r8, long r9) {
        return getBatteryInfo(r6, r7, r8, r9, false);
    }

    public static BatteryInfo getBatteryInfo(Context r16, Intent r17, BatteryStats r18, long r19, boolean r21) {
        BatteryInfo r2 = new BatteryInfo();
        r2.mStats = r18;
        int r4 = com.android.settings.Utils.getBatteryLevel(r17);
        r2.batteryLevel = r4;
        r2.batteryPercentString = com.android.settings.Utils.formatPercentage(r4);
        if (r17.getIntExtra("plugged", 0) == 0) goto L5;
        boolean r5 = true;
    L6:
        r2.mCharging = r5;
        Resources r6 = r16.getResources();
        r2.statusLabel = com.android.settings.Utils.getBatteryStatus(r6, r17);
        if (r2.mCharging == true) goto L16;
        long r14 = r18.computeBatteryTimeRemaining(r19);
        if (r14 <= 0) goto L15;
        r2.remainingTimeUs = r14;
        String r0 = Formatter.formatShortElapsedTime(r16, r14 / 1000);
        if (r21 == false) goto L13;
        int r1 = R.string.power_remaining_duration_only_short;
    L14:
        r2.remainingLabel = r6.getString(r1, new Object[]{r0});
        r2.chargeLabelString = r6.getString(R.string.power_discharging_duration, new Object[]{r2.batteryPercentString, r0});
    L26:
        return r2;
    L13:
        r1 = R.string.power_remaining_duration_only;
        goto L14
    L15:
        r2.remainingLabel = null;
        r2.chargeLabelString = r2.batteryPercentString;
        goto L26
    L16:
        long r15 = r18.computeChargeTimeRemaining(r19);
        int r3 = r17.getIntExtra("status", 1);
        r2.discharging = false;
        if (r15 > 0) goto L19;
    L25:
        String r7 = r6.getString(R.string.battery_info_status_charging_lower);
        r2.remainingLabel = null;
        r2.chargeLabelString = r6.getString(R.string.power_charging, new Object[]{r2.batteryPercentString, r7});
        goto L26
    L19:
        if (r3 == 5) goto L25;
        r2.remainingTimeUs = r15;
        String r8 = Formatter.formatShortElapsedTime(r16, r15 / 1000);
        if (r21 == false) goto L23;
        int r9 = R.string.power_charging_duration_short;
    L24:
        r2.remainingLabel = r6.getString(R.string.power_remaining_charging_duration_only, new Object[]{r8});
        r2.chargeLabelString = r6.getString(r9, new Object[]{r2.batteryPercentString, r8});
        goto L26
    L23:
        r9 = R.string.power_charging_duration;
        goto L24
    L5:
        r5 = false;
        goto L6
    }
}
