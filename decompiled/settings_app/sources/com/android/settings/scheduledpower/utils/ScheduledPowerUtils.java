package com.android.settings.scheduledpower.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.android.settings.Utils;
import com.android.settings.scheduledpower.ShutdownConfirmActivity;
import com.android.settings.scheduledpower.receiver.ScheduledPowerOnAndOffReceiver;
import com.android.vcard.VCardConfig;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScheduledPowerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010*\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0007J\u0018\u0010,\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0007J\u0010\u0010-\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0018\u0010.\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0007J\u0018\u0010/\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020&H\u0007J\u0018\u00100\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0004H\u0007J\u0018\u00102\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/android/settings/scheduledpower/utils/ScheduledPowerUtils;", "", "()V", "DEFAULT_SHUTDOWN_TIME", "", "DEFAULT_STARTUP_TIME", "FW_ACTION_CANCEL_POWER_ON_ALARM", "", "FW_ACTION_REQUEST_SHUTDOWN", "FW_ACTION_SET_POWER_ON_ALARM", "FW_PACKAGE_SET_POWER_ON_ALARM", "FW_REASON_REQUEST_SHUTDOWN", "KEY_CONFIRM", "KEY_N1_SCHEDULED_POWER_OFF", "KEY_N1_SCHEDULED_POWER_ON", "KEY_N1_SHUTDOWN_TIME", "KEY_N1_STARTUP_TIME", "KEY_TIME", "SETTINGS_PACKAGE", "SETTINGS_SCHEDULED_POWER_ON_AND_OFF_RECEIVER", "TAG", ScheduledPowerUtils.WAKE_ALARM_TEST, "mShutdownAlarmPendingIntent", "Landroid/app/PendingIntent;", "mStartupAlarmPendingIntent", "formatClockTime", "time", "getAlarmClockTime", "targetTime", "getShutdownAlarmPendingIntent", "context", "Landroid/content/Context;", "getShutdownTime", "getStartupAlarmPendingIntent", "getStartupIntent", "Landroid/content/Intent;", "getStartupTime", "isScheduledPowerOffOpen", "", "isScheduledPowerOnOpen", "routeToShutdownConfigActivity", "", "sendShutdownEvent", "isOpened", "sendStartupEvent", "shutdown", "updateScheduledPowerOffStatus", "updateScheduledPowerOnStatus", "updateShutdownTime", "shutdownTime", "updateStartupTime", "startupTime", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScheduledPowerUtils {
    private static final long DEFAULT_SHUTDOWN_TIME = 82800000;
    private static final long DEFAULT_STARTUP_TIME = 25200000;
    private static final String FW_ACTION_CANCEL_POWER_ON_ALARM = "org.codeaurora.poweroffalarm.action.CANCEL_ALARM";
    private static final String FW_ACTION_REQUEST_SHUTDOWN = "com.android.internal.intent.action.REQUEST_SHUTDOWN";
    private static final String FW_ACTION_SET_POWER_ON_ALARM = "org.codeaurora.poweroffalarm.action.SET_ALARM";
    private static final String FW_PACKAGE_SET_POWER_ON_ALARM = "com.qualcomm.qti.poweroffalarm";
    private static final String FW_REASON_REQUEST_SHUTDOWN = "android.intent.extra.REASON";
    public static final ScheduledPowerUtils INSTANCE = null;
    private static final String KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";
    private static final String KEY_N1_SCHEDULED_POWER_OFF = "n1_scheduled_power_off";
    private static final String KEY_N1_SCHEDULED_POWER_ON = "n1_scheduled_power_on";
    private static final String KEY_N1_SHUTDOWN_TIME = "n1_shutdown_time";
    private static final String KEY_N1_STARTUP_TIME = "n1_startup_time";
    private static final String KEY_TIME = "time";
    private static final String SETTINGS_PACKAGE = "com.android.settings";
    private static final String SETTINGS_SCHEDULED_POWER_ON_AND_OFF_RECEIVER = "com.android.settings.scheduledpower.receiver.ScheduledPowerOnAndOffReceiver";
    private static final String TAG = "ScheduledPowerUtils";
    private static final String WAKE_ALARM_TEST = "WAKE_ALARM_TEST";
    private static volatile PendingIntent mShutdownAlarmPendingIntent;
    private static volatile PendingIntent mStartupAlarmPendingIntent;

    static {
        INSTANCE = new ScheduledPowerUtils();
    }

    private ScheduledPowerUtils() {
    }

    @JvmStatic
    public static final boolean isScheduledPowerOnOpen(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.System.getInt(r2.getContentResolver(), KEY_N1_SCHEDULED_POWER_ON, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @JvmStatic
    public static final void updateScheduledPowerOnStatus(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.System.putInt(r1.getContentResolver(), KEY_N1_SCHEDULED_POWER_ON, r2 ? 1 : 0);
    }

    @JvmStatic
    public static final boolean isScheduledPowerOffOpen(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Settings.System.getInt(r2.getContentResolver(), KEY_N1_SCHEDULED_POWER_OFF, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @JvmStatic
    public static final void updateScheduledPowerOffStatus(Context r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.System.putInt(r1.getContentResolver(), KEY_N1_SCHEDULED_POWER_OFF, r2 ? 1 : 0);
    }

    @JvmStatic
    public static final long getStartupTime(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return Settings.System.getLong(r3.getContentResolver(), KEY_N1_STARTUP_TIME, 25200000);
    }

    @JvmStatic
    public static final void updateStartupTime(Context r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.System.putLong(r1.getContentResolver(), KEY_N1_STARTUP_TIME, r2);
    }

    @JvmStatic
    public static final long getShutdownTime(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return Settings.System.getLong(r3.getContentResolver(), KEY_N1_SHUTDOWN_TIME, DEFAULT_SHUTDOWN_TIME);
    }

    @JvmStatic
    public static final void updateShutdownTime(Context r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Settings.System.putLong(r1.getContentResolver(), KEY_N1_SHUTDOWN_TIME, r2);
    }

    @JvmStatic
    public static final String formatClockTime(long r4) {
        String r5 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r4 / ((long) LibUtil.HOUR)), Long.valueOf((r4 / ((long) 60000)) % ((long) 60))}, 2));
        Intrinsics.checkNotNullExpressionValue(r5, "format(...)");
        return r5;
    }

    private final long getAlarmClockTime(long r3) {
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(System.currentTimeMillis());
        r2.set(11, (int) (r3 / ((long) LibUtil.HOUR)));
        r2.set(12, (int) ((r3 / ((long) 60000)) % ((long) 60)));
        r2.set(13, 0);
        r2.set(14, 0);
        if (r2.getTimeInMillis() >= System.currentTimeMillis()) goto L6;
        r2.add(6, 1);
    L6:
        return r2.getTimeInMillis();
    }

    @JvmStatic
    public static final void sendStartupEvent(Context r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        OLog.i(TAG, "sendStartupTimeEvent, isOpened: " + r8);
        Object r0 = r7.getSystemService("alarm");
        if ((r0 instanceof AlarmManager) == false) goto L5;
        AlarmManager r1 = (AlarmManager) r0;
    L6:
        if (r8 == false) goto L13;
        ScheduledPowerUtils r9 = INSTANCE;
        r7.sendBroadcast(r9.getStartupIntent(r7));
        if (r1 == null) goto L19;
        PendingIntent r2 = mStartupAlarmPendingIntent;
        if (r2 == null) goto L12;
        r1.cancel(r2);
    L12:
        PendingIntent r3 = r9.getStartupAlarmPendingIntent(r7);
        mStartupAlarmPendingIntent = r3;
        long r10 = r9.getAlarmClockTime(getStartupTime(r7));
        OLog.i(TAG, "sendStartupEvent, set alarm, alarmClockTime: " + r10);
        r1.setExact(0, r10, r3);
        return;
    L19:
        return;
    L13:
        Intent r11 = new Intent(FW_ACTION_CANCEL_POWER_ON_ALARM);
        long r4 = INSTANCE.getAlarmClockTime(getStartupTime(r7));
        OLog.i(TAG, "sendStartupEvent, cancel alarm, alarmClockTime: " + r4);
        r11.putExtra("time", r4);
        r11.setPackage(FW_PACKAGE_SET_POWER_ON_ALARM);
        r7.sendBroadcast(r11);
        if (r1 == null) goto L21;
        PendingIntent r12 = mStartupAlarmPendingIntent;
        if (r12 == null) goto L22;
        r1.cancel(r12);
        mStartupAlarmPendingIntent = null;
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final Intent getStartupIntent(Context r4) {
        Intent r0 = new Intent(FW_ACTION_SET_POWER_ON_ALARM);
        r0.putExtra("time", getAlarmClockTime(getStartupTime(r4)));
        r0.setPackage(FW_PACKAGE_SET_POWER_ON_ALARM);
        return r0;
    }

    private final PendingIntent getStartupAlarmPendingIntent(Context r4) {
        Intent r3 = new Intent(ScheduledPowerOnAndOffReceiver.ACTION_SET_SCHEDULED_POWER_ON);
        r3.setComponent(new ComponentName("com.android.settings", SETTINGS_SCHEDULED_POWER_ON_AND_OFF_RECEIVER));
        PendingIntent r5 = PendingIntent.getBroadcast(r4, 0, r3, VCardConfig.FLAG_APPEND_TYPE_PARAM);
        Intrinsics.checkNotNullExpressionValue(r5, "getBroadcast(...)");
        return r5;
    }

    @JvmStatic
    public static final void sendShutdownEvent(Context r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        OLog.i(TAG, "sendShutdownEvent, isOpened: " + r6);
        Object r0 = r5.getSystemService("alarm");
        if ((r0 instanceof AlarmManager) == false) goto L5;
        AlarmManager r1 = (AlarmManager) r0;
    L6:
        if (r6 == false) goto L12;
        if (r1 == null) goto L17;
        PendingIntent r7 = mShutdownAlarmPendingIntent;
        if (r7 == null) goto L11;
        r1.cancel(r7);
    L11:
        ScheduledPowerUtils r8 = INSTANCE;
        PendingIntent r2 = r8.getShutdownAlarmPendingIntent(r5);
        mShutdownAlarmPendingIntent = r2;
        long r9 = r8.getAlarmClockTime(getShutdownTime(r5));
        OLog.i(TAG, "sendShutdownEvent, set alarm, alarmClockTime: " + r9);
        r1.setExact(0, r9, r2);
        return;
    L17:
        return;
    L12:
        if (r1 == null) goto L19;
        PendingIntent r10 = mShutdownAlarmPendingIntent;
        if (r10 == null) goto L20;
        r1.cancel(r10);
        mShutdownAlarmPendingIntent = null;
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final PendingIntent getShutdownAlarmPendingIntent(Context r4) {
        Intent r3 = new Intent(ScheduledPowerOnAndOffReceiver.ACTION_SET_SCHEDULED_POWER_OFF);
        r3.setComponent(new ComponentName("com.android.settings", SETTINGS_SCHEDULED_POWER_ON_AND_OFF_RECEIVER));
        PendingIntent r5 = PendingIntent.getBroadcast(r4, 0, r3, VCardConfig.FLAG_APPEND_TYPE_PARAM);
        Intrinsics.checkNotNullExpressionValue(r5, "getBroadcast(...)");
        return r5;
    }

    @JvmStatic
    public static final void routeToShutdownConfigActivity(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        long r0 = getShutdownTime(r7);
        Calendar r2 = Calendar.getInstance();
        int r3 = r2.get(11);
        int r4 = r2.get(12);
        int r5 = (int) (r0 / ((long) LibUtil.HOUR));
        int r1 = (int) ((r0 / ((long) 60000)) % ((long) 60));
        if (r3 != r5) goto L8;
        if (r4 != r1) goto L8;
        Intent r6 = new Intent(r7, ShutdownConfirmActivity.class);
        r6.addFlags(268435456);
        Utils.startActivity(r7, r6);
        return;
    L8:
        OLog.i(TAG, "routeToShutdownConfigActivity, current time mismatch, return");
    }

    @JvmStatic
    public static final void shutdown(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intent r0 = new Intent(FW_ACTION_REQUEST_SHUTDOWN);
        r0.putExtra(KEY_CONFIRM, false);
        r0.putExtra(FW_REASON_REQUEST_SHUTDOWN, WAKE_ALARM_TEST);
        Utils.startActivity(r3, r0);
    }
}
