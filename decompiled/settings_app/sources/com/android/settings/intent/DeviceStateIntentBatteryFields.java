package com.android.settings.intent;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0007¨\u0006\u0010"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentBatteryFields;", "", "()V", "extractRemainingTimeMillis", "", "advisor", "methodName", "", "formatRemainingTime", "remainingTimeMillis", "isBatteryCharging", "", "status", "", "normalizeBatteryLevel", "level", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentBatteryFields {
    public static final DeviceStateIntentBatteryFields INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentBatteryFields();
    }

    @JvmStatic
    public static final boolean isBatteryCharging(int r1) {
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 5) goto L8;
        return false;
    }

    @JvmStatic
    public static final int normalizeBatteryLevel(int r2) {
        boolean r0 = false;
        if (r2 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return -1;
    L11:
        return r2;
    L5:
        if (r2 >= 101) goto L7;
        r0 = true;
        goto L7
    }

    private DeviceStateIntentBatteryFields() {
    }

    @JvmStatic
    public static final long extractRemainingTimeMillis(Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "methodName");
        if (r5 != null) goto L5;
        return 0;
    L5:
        Object r7 = r5.getClass().getMethod(r6, new Class[0]).invoke(r5, new Object[0]);
        if ((r7 instanceof Number) == false) goto L8;
        Number r8 = (Number) r7;
    L9:
        if (r8 != null) goto L11;
        return 0;
    L11:
        return r8.longValue();
    L8:
        r8 = null;
        goto L9
    }

    @JvmStatic
    public static final String formatRemainingTime(long r2) {
        if (r2 > 0) goto L7;
        return "";
    L7:
        return String.valueOf(r2);
    }
}
