package com.android.settings.notificationcustom;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes2.dex */
public final class QuickWidgetFactory {
    public static final String DESKTOP_SYSTEM_UI_PKG = "com.android.desktop.systemui";
    public static final String SYSTEM_UI_PKG = "com.android.systemui";

    public QuickWidgetFactory() {
    }

    private static String getWidgetTitle(Context r1, String r2) {
        return Utils.getPackageString(r1, "com.android.systemui", r2);
    }

    public static QuickWidget getWidget(Context r2, String r3) {
        if ("toggleAirplane".equals(r3) == false) goto L6;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_flight_mode"), R.drawable.setting_notice_flight);
    L6:
        if ("toggleWifi".equals(r3) == false) goto L9;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_wifi"), R.drawable.setting_notice_wifi);
    L9:
        if ("toggleMobileData".equals(r3) == false) goto L12;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_mobile_data"), R.drawable.setting_notice_data_sim);
    L12:
        if ("toggleVpn".equals(r3) == false) goto L15;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_vpn"), R.drawable.setting_notice_vpn);
    L15:
        if ("toggleWifiAp".equals(r3) == false) goto L18;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_ap"), R.drawable.setting_notice_ap);
    L18:
        if ("toggleBluetooth".equals(r3) == false) goto L21;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_bluetooth"), R.drawable.setting_notice_bluetooth);
    L21:
        if ("toggleDisableButtons".equals(r3) == false) goto L24;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_disturb_mode_buttons"), R.drawable.setting_notice_undisturb);
    L24:
        if ("toggleGPS".equals(r3) == false) goto L27;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_location"), R.drawable.setting_notice_location);
    L27:
        if ("toggleFlashlight".equals(r3) == false) goto L30;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_flashlight"), R.drawable.setting_notice_flashlight);
    L30:
        if ("toggleAutoRotate".equals(r3) == false) goto L33;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_auto_rotation"), R.drawable.setting_notice_auto_rotation);
    L33:
        if ("togglerrecordscreen".equals(r3) == false) goto L36;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_record_screen"), R.drawable.setting_notice_screen_recorder);
    L36:
        if ("togglepowersave".equals(r3) == false) goto L39;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_power_save"), R.drawable.setting_notice_power_save);
    L39:
        if ("toggleScreenShot".equals(r3) == false) goto L42;
        return new QuickWidget(r3, getWidgetTitle(r2, "screenshot"), R.drawable.setting_notice_screen_capture);
    L42:
        if ("toggleVibrate".equals(r3) == false) goto L45;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_vibrate"), R.drawable.setting_notice_vibrate);
    L45:
        if ("toggleMute".equals(r3) == false) goto L48;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_mute"), R.drawable.setting_notice_mute);
    L48:
        if ("toggleNFC".equals(r3) == false) goto L51;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_nfc"), R.drawable.setting_notice_nfc);
    L51:
        if ("toggleKeepScreenOn".equals(r3) == false) goto L54;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_screen_keep_on"), R.drawable.setting_notice_screen_light);
    L54:
        if ("toggleLockScreen".equals(r3) == false) goto L57;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_lockscreen"), R.drawable.setting_notice_screen_lock_screen);
    L57:
        if ("toggleProtectEyes".equals(r3) == false) goto L60;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_protect_eyes"), R.drawable.setting_notice_eyes_protection);
    L60:
        if ("toggleFakeCall".equals(r3) == false) goto L63;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_fake_call"), R.drawable.fake_calling);
    L63:
        if ("toggleAutoBrightness".equals(r3) == false) goto L66;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_auto_brightness"), R.drawable.setting_notice_auto_brightness);
    L66:
        if ("toggleWirelessTNT".equalsIgnoreCase(r3) == false) goto L69;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_wireless_tnt"), R.drawable.setting_notice_wireless_tnt);
    L69:
        if ("toggleReadingMode".equals(r3) == false) goto L72;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_reading_mode"), R.drawable.setting_notice_reading_mode);
    L72:
        if ("toggleRealtimeSubtitle".equals(r3) == false) goto L75;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_realtime_subtitle"), R.drawable.setting_notice_realtime_subtitle);
    L75:
        if ("toggleRelay".equals(r3) == false) goto L78;
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_relay"), R.drawable.setting_notice_relay_mode_land);
    L78:
        if ("toggleChargePhone".equals(r3) == true) goto L107;
        return null;
    L107:
        return new QuickWidget(r3, getWidgetTitle(r2, "widget_charge_phone"), R.drawable.setting_notice_charge_phone_land);
    }
}
