package com.obric.safecheck.util.serviceutil;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryChargeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/util/serviceutil/BatteryChargeUtils;", "", "()V", "isDeviceCharging", "", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BatteryChargeUtils {
    public static final BatteryChargeUtils INSTANCE = null;

    static {
        INSTANCE = new BatteryChargeUtils();
    }

    private BatteryChargeUtils() {
    }

    public final boolean isDeviceCharging(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r2 = r3.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r2 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullExpressionValue(r2, "context.registerReceiver…        ) ?: return false");
        if (r2.getIntExtra("status", -1) != 2) goto L9;
        return true;
    L9:
        return false;
    }
}
