package com.android.settings;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.hardware.display.DisplayManager;
import android.net.NetworkUtils;
import android.net.Uri;
import android.os.PowerManager;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import bytedanceos.api.LayoutParamsSmt;
import bytedanceos.api.PackageManagerSmt;
import bytedanceos.api.PowerManagerSmt;
import com.android.internal.display.BrightnessSynchronizer;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes2.dex */
public class AdaptUtils {
    public static final float DC_REAL_WORK_BRIGHTNESS = 0.275f;

    public static void setColorTemperatureValue(int r0, int r1) {
    }

    public AdaptUtils() {
    }

    public static float getDimAmountForBrightness(WindowManager.LayoutParams r1) {
        return LayoutParamsSmt.getInstance().getDimAmountForBrightness(r1);
    }

    public static void setDimAmountForBrightness(WindowManager.LayoutParams r1, float r2) {
        LayoutParamsSmt.getInstance().setDimAmountForBrightness(r1, r2);
    }

    public static int getLteOnCdmaMode(TelephonyManager r1) {
        if (r1 != null) goto L4;
        return -1;
    L4:
        return r1.getLteOnCdmaMode(r1.getSubscriptionId());
    }

    public static InetAddress parseNumericAddress(String r0) {
        return NetworkUtils.numericToInetAddress(r0);
    }

    public static void setBrightness(Context r0, int r1, DisplayManager r2, int r3, int r4) throws RemoteException {
        r2.setTemporaryBrightness(0, BrightnessSynchronizer.multiBitBrightnessIntToFloatForNormal(r0, r1, r4, r3));
    }

    public static int getBrightness(Context r2) {
        return android.provider.Settings.System.getInt(r2.getContentResolver(), "screen_brightness_multi_bit", 0);
    }

    public static void setBrightnessForPowerManager(Context r1, PowerManagerSmt r2, int r3, int r4, int r5) {
        r2.setBrightness((PowerManager) r1.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK), BrightnessSynchronizer.multiBitBrightnessIntToFloatForNormal(r1, r3, r5, r4));
    }

    public static void startSetTemporaryBrightness(DisplayManager r1, boolean r2, float r3) {
        r1.startSetTemporaryBrightness(0, r2, r3);
    }

    public static Uri getMediaExternalContentUri() {
        return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }

    public static void setAppNotchState(IPackageManager r0, String r1, int r2) {
        PackageManagerSmt.getInstance().setNotchState(r1, r2);
    }
}
