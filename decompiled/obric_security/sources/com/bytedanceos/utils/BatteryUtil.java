package com.bytedanceos.utils;

import android.content.Context;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.UidBatteryConsumer;
import com.obric.security.battertpower.PowerAdvisorService;

/* JADX INFO: loaded from: classes2.dex */
public class BatteryUtil {
    public static /* synthetic */ double $r8$lambda$aYr1S67KkkR48yp_5wO3TfWEFPs(UidBatteryConsumer r2) {
        return r2.getConsumedPower();
    }

    public BatteryUtil() {
    }

    public static long getBatteryTimeRemainingMs(Context context) {
        return PowerAdvisorService.computeBatteryTimeRemaining() / 1000;
    }

    public static int getAppsBatteryUsagePercent(Context context) {
        BatteryUsageStats r7 = ((BatteryStatsManager) context.getSystemService(BatteryStatsManager.class)).getBatteryUsageStats();
        double r1 = r7.getAggregateBatteryConsumer(0).getConsumedPower();
        double r3 = r7.getUidBatteryConsumers().stream().mapToDouble(new BatteryUtil$$ExternalSyntheticLambda0()).sum();
        if (r3 > 0.0d) goto L5;
    L9:
        return 0;
    L5:
        if (r1 <= 0.0d) goto L9;
        return (int) (Math.min(r3 / r1, 1.0d) * 100.0d);
    }
}
