package com.android.settings;

import android.content.Context;
import com.bytedance.sremlib.LibUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DozeModeActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0001J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/android/settings/DozeModeUtils;", "", "()V", "AOD_ALL_DAY", "", "AOD_LOW_POWER_CONSUME", "AOD_OFF", "AOD_SCHEDULED", "DEFAULT_AOD_SCHEDULED_END", "", "DEFAULT_AOD_SCHEDULED_START", "KEY_OBRIC_AOD_DISPLAY_POLICY", "", "KEY_OBRIC_AOD_SCHEDULED_END", "KEY_OBRIC_AOD_SCHEDULED_START", "formatClockTime", "time", "getAODDisplayPolicy", "context", "Landroid/content/Context;", "getAODDisplayPolicy$app_neridaCnRelease", "getAODDisplayPolicySummary", "getAODScheduledEndTime", "getAODScheduledEndTime$app_neridaCnRelease", "getAODScheduledStartTime", "getAODScheduledStartTime$app_neridaCnRelease", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DozeModeUtils {
    public static final int AOD_ALL_DAY = 1;
    public static final int AOD_LOW_POWER_CONSUME = 0;
    public static final int AOD_OFF = -1;
    public static final int AOD_SCHEDULED = 2;
    public static final long DEFAULT_AOD_SCHEDULED_END = 75600000;
    public static final long DEFAULT_AOD_SCHEDULED_START = 25200000;
    public static final DozeModeUtils INSTANCE = null;
    public static final String KEY_OBRIC_AOD_DISPLAY_POLICY = "obric_aod_display_policy";
    public static final String KEY_OBRIC_AOD_SCHEDULED_END = "obric_aod_scheduled_end_time";
    public static final String KEY_OBRIC_AOD_SCHEDULED_START = "obric_aod_scheduled_start_time";

    static {
        INSTANCE = new DozeModeUtils();
    }

    private DozeModeUtils() {
    }

    public final int getAODDisplayPolicy$app_neridaCnRelease(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        boolean r1 = true;
        if (android.provider.Settings.Secure.getInt(r3.getContentResolver(), "doze_always_on", 1) == 1) goto L7;
        r1 = false;
    L7:
        if (r1 == true) goto L9;
        return -1;
    L9:
        int r4 = android.provider.Settings.Global.getInt(r3.getContentResolver(), KEY_OBRIC_AOD_DISPLAY_POLICY, 0);
        if (r4 >= (-1)) goto L12;
    L15:
        return 0;
    L12:
        if (r4 > 2) goto L15;
        return r4;
    }

    @JvmStatic
    public static final String getAODDisplayPolicySummary(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = INSTANCE.getAODDisplayPolicy$app_neridaCnRelease(r2) + 1;
        String r3 = r2.getResources().getStringArray(R.array.obric_doze_display_policy)[r0];
        Intrinsics.checkNotNullExpressionValue(r3, "get(...)");
        return r3;
    }

    private final String formatClockTime(long r4) {
        String r3 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r4 / ((long) LibUtil.HOUR)), Long.valueOf((r4 / ((long) 60000)) % ((long) 60))}, 2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return r3;
    }

    public final String getAODScheduledStartTime$app_neridaCnRelease(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return formatClockTime(android.provider.Settings.Global.getLong(r4.getContentResolver(), KEY_OBRIC_AOD_SCHEDULED_START, DEFAULT_AOD_SCHEDULED_START));
    }

    public final String getAODScheduledEndTime$app_neridaCnRelease(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return formatClockTime(android.provider.Settings.Global.getLong(r4.getContentResolver(), KEY_OBRIC_AOD_SCHEDULED_END, DEFAULT_AOD_SCHEDULED_END));
    }
}
