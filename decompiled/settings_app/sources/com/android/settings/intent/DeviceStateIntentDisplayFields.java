package com.android.settings.intent;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentDisplayFields;", "", "()V", "calculateBrightnessPercent", "", "brightness", "minimum", "maximum", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentDisplayFields {
    public static final DeviceStateIntentDisplayFields INSTANCE = null;

    static {
        INSTANCE = new DeviceStateIntentDisplayFields();
    }

    private DeviceStateIntentDisplayFields() {
    }

    @JvmStatic
    public static final int calculateBrightnessPercent(int r1, int r2, int r3) {
        if (r3 > r2) goto L6;
        return -1;
    L6:
        return RangesKt.coerceIn(MathKt.roundToInt(((RangesKt.coerceIn(r1, r2, r3) - r2) * 100.0f) / (r3 - r2)), 0, 100);
    }
}
