package com.android.settings;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class TimeChangeReceiver extends BroadcastReceiver {
    public static final String ACTION_SHOW_TAB_AT = "show_tab_at";
    private static final String CHINA_DISPLAY_NAME = "China Standard Time";
    public static final String EXTRA_ZONE_CHANGE_WARN_MSG = "extra_zone_change_warn_msg";
    public static final int GLOBAL_CLOCK_TAB_INDEX = 0;
    private static final String HONG_KONG_DISPLAY_NAME = "Hong Kong Standard Time";
    private static final int HOURS_1 = 3600000;
    private static final String LAST_CHANGED_ZONE_ID = "last_changed_zone_id";
    private static final int NOTIFICATION_ID = 1001;
    private static final String TAG = "TimeChangeReceiver";
    private static final String TAI_PEI_DISPLAY_NAME = "Taipei Standard Time";
    private static boolean networkChangeTimezone;
    private Context mContext;

    static {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_TimeChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public TimeChangeReceiver() {
    }

    public void com_android_settings_TimeChangeReceiver__onReceive$___twin___(Context r7, Intent r8) {
        this.mContext = r7;
        String r0 = r8.getAction();
        String r1 = r8.getStringExtra("time-zone");
        String r2 = TAG;
        OLog.d(r2, "action:" + r0 + "  zone:" + r1);
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (r0.equals(AdaptConstants.ACTION_NETWORK_SET_TIMEZONE) == false) goto L11;
        int r9 = r8.getIntExtra("time-zone-changed", 0);
        OLog.d(r2, "extra changed" + r9 + "  networkChangeTimezone:" + networkChangeTimezone);
        if (networkChangeTimezone == true) goto L9;
        if (r9 == 1) goto L9;
    L17:
        if (TextUtils.isEmpty(r1) == true) goto L20;
        android.provider.Settings.System.putString(r7.getContentResolver(), LAST_CHANGED_ZONE_ID, r1);
        return;
    L20:
        return;
    L9:
        promptUser(r7, r1);
        networkChangeTimezone = false;
    L11:
        if ("android.intent.action.TIMEZONE_CHANGED".equals(r0) == false) goto L17;
        if (getAutoState("auto_time") == false) goto L15;
        promptUser(r7, r1);
        networkChangeTimezone = false;
        goto L17
    L15:
        networkChangeTimezone = true;
        goto L17
    }

    private boolean isChinaArea(String r1) {
        String r0 = getZoneEnglishDisplayName(r1);
        if (TextUtils.equals(r0, CHINA_DISPLAY_NAME) == false) goto L5;
    L10:
        return true;
    L5:
        if (r0.equals(HONG_KONG_DISPLAY_NAME) == true) goto L10;
        if (r0.equals(TAI_PEI_DISPLAY_NAME) == true) goto L10;
        return false;
    }

    private String getZoneEnglishDisplayName(String r3) {
        return TimeZone.getTimeZone(r3).getDisplayName(false, 1, Locale.ENGLISH);
    }

    private void promptUser(Context r3, String r4) {
        String r0 = android.provider.Settings.System.getString(r3.getContentResolver(), LAST_CHANGED_ZONE_ID);
        if (r0 != null) goto L6;
        OLog.d(TAG, "promptUser, lastChangedZoneId is null, return");
        return;
    L6:
        if (r4 != null) goto L10;
        OLog.d(TAG, "promptUser, zoneId is null, return");
        return;
    L10:
        if (isChinaArea(r0) == false) goto L16;
        if (isChinaArea(r4) == false) goto L16;
        OLog.d(TAG, "promptUser, lastChangedZoneId: " + r0 + ", zoneId: " + r4 + ", isChinaArea, return");
        return;
    L16:
        if (SettingsFeature.ENABLE_DOUBLE_TIMEZONE_FEATURE == false) goto L18;
        showNotification();
        return;
    L18:
        startConfirmDialog(r3, r4);
    }

    private boolean getAutoState(String r2) {
        if (android.provider.Settings.System.getInt(this.mContext.getContentResolver(), r2) <= 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    private boolean isShowDateOfTimezone(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "show_date_of_current_timezone", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void showNotification() {
        Notification r0 = new Notification();
        r0.when = System.currentTimeMillis();
        r0.flags = 16;
        r0.icon = R.drawable.setting_time_earth;
        r0.defaults |= 3;
        r0.flags = 16;
        Intent r1 = new Intent();
        if (isShowDateOfTimezone(this.mContext) == true) goto L5;
        r1 = new Intent(this.mContext, TimezoneSettingsActivity.class);
        int r2 = R.string.notification_title_timezone_changed;
        int r4 = R.string.notification_msg_enable_show_date_of_timezone_changed;
    L6:
        r0.tickerText = this.mContext.getString(r2);
        r0.contentIntent = PendingIntent.getActivity(this.mContext, 0, r1, 335544320);
        Context r3 = this.mContext;
        r0.setLatestEventInfo(r3, r3.getString(r2), this.mContext.getString(r4), r0.contentIntent);
        ((NotificationManager) this.mContext.getSystemService("notification")).notify(1001, r0);
        return;
    L5:
        r1.setComponent(new ComponentName("com.bytedanceos.clock", "com.bytedanceos.clock.activity.ClockActivity"));
        r1.putExtra(ACTION_SHOW_TAB_AT, 0);
        r2 = R.string.notification_msg_timezone_changed;
        r4 = R.string.notification_message_global_time;
        goto L6
    }

    private void startConfirmDialog(Context r4, String r5) {
        OLog.d(TAG, "startConfirmDialog zoneId:" + r5);
        TimeZone r6 = TimeZone.getTimeZone(r5);
        Intent r0 = new Intent();
        r0.setClass(r4, TimeZoneChangeWarnActivity.class);
        r0.setFlags(335544320);
        r0.putExtra(EXTRA_ZONE_CHANGE_WARN_MSG, r6.getDisplayName() + HanziToPinyin.Token.SEPARATOR + createGmtText(r6));
        Utils.startActivity(r4, r0, 1, -1);
    }

    private String createGmtText(TimeZone r3) {
        int r2 = r3.getOffset(Calendar.getInstance().getTimeInMillis());
        int r4 = Math.abs(r2);
        StringBuilder r0 = new StringBuilder("GMT");
        if (r2 >= 0) goto L5;
        r0.append('-');
    L6:
        r0.append(r4 / 3600000);
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        int r5 = (r4 / 60000) % 60;
        if (r5 >= 10) goto L9;
        r0.append('0');
    L9:
        r0.append(r5);
        return r0.toString();
    L5:
        r0.append('+');
        goto L6
    }

    @Insert("onReceive")
    public static void com_android_settings_TimeChangeReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(TimeChangeReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        TimeChangeReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_TimeChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_TimeChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_TimeChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_TimeChangeReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
