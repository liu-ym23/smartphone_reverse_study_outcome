package com.android.settingslib;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.UserInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbPort;
import android.hardware.usb.UsbPortStatus;
import android.icu.text.NumberFormat;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.NetworkCapabilities;
import android.net.TetheringManager;
import android.net.vcn.VcnTransportInfo;
import android.net.wifi.WifiInfo;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.webkit.Flags;
import android.webkit.IWebViewUpdateService;
import android.webkit.WebViewFactory;
import android.webkit.WebViewProviderInfo;
import android.webkit.WebViewUpdateManager;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.GlobalProxyLancet;
import com.android.internal.util.UserIcons;
import com.android.launcher3.icons.BaseIconFactory;
import com.android.launcher3.icons.FastBitmapDrawable;
import com.android.launcher3.icons.IconFactory;
import com.android.launcher3.util.UserIconInfo;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.android.settingslib.drawable.UserIconDrawable;
import com.android.settingslib.fuelgauge.BatteryStatus;
import com.android.settingslib.fuelgauge.BatteryUtils;
import com.android.settingslib.utils.BuildCompatUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static final String INCOMPATIBLE_CHARGER_WARNING_DISABLED = "incompatible_charger_warning_disabled";
    static final int[] SHOW_X_WIFI_PIE = null;
    static final String STORAGE_MANAGER_ENABLED_PROPERTY = "ro.storage_manager.enabled";
    private static final String TAG = "Utils";
    static final int[] WIFI_4_PIE = null;
    static final int[] WIFI_5_PIE = null;
    static final int[] WIFI_6_PIE = null;
    static final int[] WIFI_7_PIE = null;
    static final int[] WIFI_PIE = null;
    private static String sDefaultWebViewPackageName;
    private static String sPermissionControllerPackageName;
    private static String sServicesSystemSharedLibPackageName;
    private static String sSharedSystemSharedLibPackageName;
    private static Signature[] sSystemSignature;

    public Utils() {
    }

    static {
        WIFI_PIE = new int[]{android.R.drawable.pointer_vertical_double_arrow_vector_icon, android.R.drawable.pointer_vertical_text, android.R.drawable.pointer_vertical_text_icon, android.R.drawable.pointer_vertical_text_large, android.R.drawable.pointer_vertical_text_large_icon};
        SHOW_X_WIFI_PIE = new int[]{R.drawable.ic_show_x_wifi_signal_0, R.drawable.ic_show_x_wifi_signal_1, R.drawable.ic_show_x_wifi_signal_2, R.drawable.ic_show_x_wifi_signal_3, R.drawable.ic_show_x_wifi_signal_4};
        WIFI_4_PIE = new int[]{android.R.drawable.pointer_text_large_icon, android.R.drawable.pointer_text_vector, android.R.drawable.pointer_text_vector_icon, android.R.drawable.pointer_top_left_diagonal_double_arrow, android.R.drawable.pointer_top_left_diagonal_double_arrow_icon};
        WIFI_5_PIE = new int[]{android.R.drawable.pointer_top_left_diagonal_double_arrow_large, android.R.drawable.pointer_top_left_diagonal_double_arrow_large_icon, android.R.drawable.pointer_top_left_diagonal_double_arrow_vector, android.R.drawable.pointer_top_left_diagonal_double_arrow_vector_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow};
        WIFI_6_PIE = new int[]{android.R.drawable.pointer_top_right_diagonal_double_arrow_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow_large, android.R.drawable.pointer_top_right_diagonal_double_arrow_large_icon, android.R.drawable.pointer_top_right_diagonal_double_arrow_vector, android.R.drawable.pointer_top_right_diagonal_double_arrow_vector_icon};
        WIFI_7_PIE = new int[]{android.R.drawable.pointer_vertical_double_arrow, android.R.drawable.pointer_vertical_double_arrow_icon, android.R.drawable.pointer_vertical_double_arrow_large, android.R.drawable.pointer_vertical_double_arrow_large_icon, android.R.drawable.pointer_vertical_double_arrow_vector};
    }

    public static void updateLocationEnabled(Context r2, boolean r3, int r4, int r5) {
        Settings.Secure.putIntForUser(r2.getContentResolver(), "location_changer", r5, r4);
        ((LocationManager) r2.getSystemService(LocationManager.class)).setLocationEnabledForUser(r3, UserHandle.of(r4));
    }

    public static int getTetheringLabel(TetheringManager r4) {
        String[] r0 = r4.getTetherableUsbRegexs();
        String[] r1 = r4.getTetherableWifiRegexs();
        String[] r5 = r4.getTetherableBluetoothRegexs();
        boolean r2 = true;
        if (r0.length == 0) goto L5;
        boolean r3 = true;
    L7:
        if (r1.length == 0) goto L9;
        boolean r6 = true;
    L11:
        if (r5.length != 0) goto L14;
        r2 = false;
    L14:
        if (r6 == false) goto L19;
        if (r3 == false) goto L19;
        if (r2 == false) goto L19;
        return R.string.tether_settings_title_all;
    L19:
        if (r6 == false) goto L23;
        if (r3 == false) goto L23;
        return R.string.tether_settings_title_all;
    L23:
        if (r6 == false) goto L27;
        if (r2 == false) goto L27;
        return R.string.tether_settings_title_all;
    L27:
        if (r6 == true) goto L29;
        if (r3 == false) goto L34;
        if (r2 == false) goto L34;
        return R.string.tether_settings_title_usb_bluetooth;
    L34:
        if (r3 == false) goto L38;
        return R.string.tether_settings_title_usb;
    L38:
        return R.string.tether_settings_title_bluetooth;
    L29:
        return R.string.tether_settings_title_wifi;
    L9:
        r6 = false;
        goto L11
    L5:
        r3 = false;
        goto L7
    }

    public static String getUserLabel(Context r3, UserInfo r4) {
        if (r4 == null) goto L4;
        String r0 = r4.name;
    L6:
        if (r4.isManagedProfile() == false) goto L13;
        if (BuildCompatUtils.isAtLeastT() == false) goto L11;
        return getUpdatableManagedUserTitle(r3);
    L11:
        return r3.getString(R.string.managed_user_title);
    L13:
        if (r4.isGuest() == false) goto L15;
        r0 = r3.getString(android.R.string.ime_action_go);
    L15:
        if (r0 != null) goto L18;
        if (r4 == null) goto L18;
        r0 = Integer.toString(r4.id);
    L21:
        return r3.getResources().getString(R.string.running_process_item_user_label, new Object[]{r0});
    L18:
        if (r4 != null) goto L21;
        r0 = r3.getString(R.string.unknown);
        goto L21
    L4:
        r0 = null;
        goto L6
    }

    private static String getUpdatableManagedUserTitle(final Context r2) {
        return ((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getResources().getString("Settings.WORK_PROFILE_USER_LABEL", new Utils$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ String lambda$getUpdatableManagedUserTitle$0(Context r1) {
        return r1.getString(R.string.managed_user_title);
    }

    public static Drawable getUserIcon(Context r3, UserManager r4, UserInfo r5) {
        int r0 = UserIconDrawable.getDefaultSize(r3);
        if (r5.isManagedProfile() == false) goto L7;
        Drawable r6 = UserIconDrawable.getManagedUserDrawable(r3);
        r6.setBounds(0, 0, r0, r0);
        return r6;
    L7:
        if (r5.iconPath == null) goto L13;
        Bitmap r7 = r4.getUserIcon(r5.id);
        if (r7 == null) goto L13;
        return new UserIconDrawable(r0).setIcon(r7).bake();
    L13:
        return new UserIconDrawable(r0).setIconDrawable(UserIcons.getDefaultUserIcon(r3.getResources(), r5.id, false)).bake();
    }

    public static String formatPercentage(double r0, boolean r2) {
        if (r2 == false) goto L4;
        int r1 = Math.round((float) r0);
    L6:
        return formatPercentage(r1);
    L4:
        r1 = (int) r0;
        goto L6
    }

    public static String formatPercentage(long r0, long r2) {
        return formatPercentage(r0 / r2);
    }

    public static String formatPercentage(int r4) {
        return formatPercentage(((double) r4) / 100.0d);
    }

    public static String formatPercentage(double r1) {
        return NumberFormat.getPercentInstance().format(r1);
    }

    public static int getBatteryLevel(Intent r3) {
        int r0 = r3.getIntExtra("level", 0);
        int r1 = r0 * 100;
        return r1 / r3.getIntExtra("scale", 100);
    }

    public static String getBatteryStatus(Context r4, Intent r5, boolean r6) {
        int r0 = r5.getIntExtra("status", 1);
        Resources r1 = r4.getResources();
        String r2 = r1.getString(R.string.battery_info_status_unknown);
        BatteryStatus r3 = new BatteryStatus(r5);
        if (r3.isCharged() == false) goto L9;
        if (r6 == false) goto L6;
        int r7 = R.string.battery_info_status_full_charged;
    L31:
        return r1.getString(r7);
    L6:
        r7 = R.string.battery_info_status_full;
        goto L31
    L9:
        if (r0 != 2) goto L25;
        if (r6 == false) goto L13;
        return getRegularChargingStatusString(r1);
    L13:
        if (r3.isPluggedInWired() == false) goto L21;
        int r8 = r3.getChargingSpeed(r4);
        if (r8 == 0) goto L35;
        if (r8 == 2) goto L34;
        return getRegularChargingStatusString(r1);
    L34:
        return getFastChargingStatusString(r1);
    L35:
        return getSlowChargingStatusString(r1);
    L21:
        if (r3.isPluggedInDock() == false) goto L37;
        return getDockChargingStatusString(r1);
    L37:
        return getWirelessChargingStatusString(r1);
    L25:
        if (r0 != 3) goto L28;
        return r1.getString(R.string.battery_info_status_discharging);
    L28:
        if (r0 == 4) goto L30;
        return r2;
    L30:
        return r1.getString(R.string.battery_info_status_not_charging);
    }

    private static String getFastChargingStatusString(Resources r1) {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L5;
        int r0 = R.string.battery_info_status_charging_fast_v2;
    L7:
        return r1.getString(r0);
    L5:
        r0 = R.string.battery_info_status_charging_fast;
        goto L7
    }

    private static String getSlowChargingStatusString(Resources r1) {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L5;
        int r0 = R.string.battery_info_status_charging_v2;
    L7:
        return r1.getString(r0);
    L5:
        r0 = R.string.battery_info_status_charging_slow;
        goto L7
    }

    private static String getRegularChargingStatusString(Resources r1) {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L5;
        int r0 = R.string.battery_info_status_charging_v2;
    L7:
        return r1.getString(r0);
    L5:
        r0 = R.string.battery_info_status_charging;
        goto L7
    }

    private static String getWirelessChargingStatusString(Resources r1) {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L5;
        int r0 = R.string.battery_info_status_charging_v2;
    L7:
        return r1.getString(r0);
    L5:
        r0 = R.string.battery_info_status_charging_wireless;
        goto L7
    }

    private static String getDockChargingStatusString(Resources r1) {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L5;
        int r0 = R.string.battery_info_status_charging_v2;
    L7:
        return r1.getString(r0);
    L5:
        r0 = R.string.battery_info_status_charging_dock;
        goto L7
    }

    public static ColorStateList getColorAccent(Context r1) {
        return getColorAttr(r1, android.R.attr.colorAccent);
    }

    public static ColorStateList getColorError(Context r1) {
        return getColorAttr(r1, android.R.attr.colorError);
    }

    public static int getColorAccentDefaultColor(Context r1) {
        return getColorAttrDefaultColor(r1, android.R.attr.colorAccent);
    }

    public static int getColorErrorDefaultColor(Context r1) {
        return getColorAttrDefaultColor(r1, android.R.attr.colorError);
    }

    public static int getColorStateListDefaultColor(Context r1, int r2) {
        return r1.getResources().getColorStateList(r2, r1.getTheme()).getDefaultColor();
    }

    public static int getDisabled(Context r1, int r2) {
        return applyAlphaAttr(r1, android.R.attr.disabledAlpha, r2);
    }

    public static int applyAlphaAttr(Context r2, int r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r3});
        float r6 = r5.getFloat(0, 0.0f);
        r5.recycle();
        return applyAlpha(r6, r4);
    }

    public static int applyAlpha(float r2, int r3) {
        return Color.argb((int) (r2 * Color.alpha(r3)), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static int getColorAttrDefaultColor(Context r1, int r2) {
        return getColorAttrDefaultColor(r1, r2, 0);
    }

    public static int getColorAttrDefaultColor(Context r2, int r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r3});
        int r6 = r5.getColor(0, r4);
        r5.recycle();
        return r6;
    }

    public static ColorStateList getColorAttr(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        ColorStateList r5 = r4.getColorStateList(0);     // Catch: Throwable -> L6
        r4.recycle();
        return r5;
    L6:
        th = move-exception;
        r4.recycle();
        throw th;
    }

    public static int getThemeAttr(Context r1, int r2) {
        return getThemeAttr(r1, r2, 0);
    }

    public static int getThemeAttr(Context r2, int r3, int r4) {
        TypedArray r5 = r2.obtainStyledAttributes(new int[]{r3});
        int r6 = r5.getResourceId(0, r4);
        r5.recycle();
        return r6;
    }

    public static Drawable getDrawable(Context r2, int r3) {
        TypedArray r4 = r2.obtainStyledAttributes(new int[]{r3});
        Drawable r5 = r4.getDrawable(0);
        r4.recycle();
        return r5;
    }

    public static ColorMatrix getAlphaInvariantColorMatrixForColor(int r6) {
        return new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, Color.red(r6), 0.0f, 0.0f, 0.0f, 0.0f, Color.green(r6), 0.0f, 0.0f, 0.0f, 0.0f, Color.blue(r6), 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
    }

    public static ColorFilter getAlphaInvariantColorFilterForColor(int r1) {
        return new ColorMatrixColorFilter(getAlphaInvariantColorMatrixForColor(r1));
    }

    @Deprecated
    public static boolean isSystemPackage(Resources r4, PackageManager r5, PackageInfo r6) {
        if (sSystemSignature != null) goto L5;
        sSystemSignature = new Signature[]{getSystemSignature(r5)};
    L5:
        Signature r0 = sSystemSignature[0];
        if (r0 == null) goto L10;
        if (r0.equals(getFirstSignature(r6)) == false) goto L10;
        return true;
    L10:
        if (isEssentialPackage(r4, r5, r6.packageName) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private static Signature getFirstSignature(PackageInfo r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.signatures != null) goto L6;
        return null;
    L6:
        if (r1.signatures.length > 0) goto L8;
        return null;
    L8:
        return r1.signatures[0];
    }

    private static Signature getSystemSignature(PackageManager r2) {
        return getFirstSignature(r2.getPackageInfo(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, 64));
    L4:
        return null;
    }

    public static boolean isEssentialPackage(Resources r1, PackageManager r2, String r3) {
        if (sPermissionControllerPackageName != null) goto L6;
        sPermissionControllerPackageName = r2.getPermissionControllerPackageName();
    L6:
        if (sServicesSystemSharedLibPackageName != null) goto L9;
        sServicesSystemSharedLibPackageName = r2.getServicesSystemSharedLibraryPackageName();
    L9:
        if (sSharedSystemSharedLibPackageName != null) goto L12;
        sSharedSystemSharedLibPackageName = r2.getSharedSystemSharedLibraryPackageName();
    L12:
        if (r3.equals(sPermissionControllerPackageName) == false) goto L14;
    L27:
        return true;
    L14:
        if (r3.equals(sServicesSystemSharedLibPackageName) == true) goto L27;
        if (r3.equals(sSharedSystemSharedLibPackageName) == true) goto L27;
        if (r3.equals("com.android.printspooler") == true) goto L27;
        if (Flags.updateServiceV2() == false) goto L24;
        if (r3.equals(getDefaultWebViewPackageName()) == true) goto L27;
    L24:
        if (isDeviceProvisioningPackage(r1, r3) == true) goto L27;
        return false;
    }

    public static boolean isDeviceProvisioningPackage(Resources r1, String r2) {
        String r3 = r1.getString(android.R.string.config_ethernet_iface_regex);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if (r3.equals(r2) == false) goto L7;
        return true;
    }

    private static String getDefaultWebViewPackageName() {
        String r0 = sDefaultWebViewPackageName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        WebViewProviderInfo r1 = null;
        if (Flags.updateServiceIpcWrapper() == false) goto L20;
        WebViewUpdateManager r2 = WebViewUpdateManager.getInstance();
        if (r2 == null) goto L16;
        r1 = r2.getDefaultWebViewPackage();
    L16:
        if (r1 == null) goto L19;
        sDefaultWebViewPackageName = r1.packageName;
    L19:
        return sDefaultWebViewPackageName;
    L20:
        IWebViewUpdateService r3 = WebViewFactory.getUpdateService();     // Catch: RemoteException -> L14
        if (r3 == null) goto L16;
        r1 = r3.getDefaultWebViewPackage();     // Catch: RemoteException -> L14
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "RemoteException when trying to fetch default WebView package Name", e);
        goto L16
    }

    public static int getWifiIconResource(int r1) {
        return getWifiIconResource(false, r1, 0);
    }

    public static int getWifiIconResource(boolean r1, int r2) {
        return getWifiIconResource(r1, r2, 0);
    }

    public static int getWifiIconResource(int r1, int r2) {
        return getWifiIconResource(false, r1, r2);
    }

    public static int getWifiIconResource(boolean r2, int r3, int r4) {
        if (r3 < 0) goto L27;
        int[] r0 = WIFI_PIE;
        if (r3 >= r0.length) goto L27;
        if (r2 == false) goto L9;
        return SHOW_X_WIFI_PIE[r3];
    L9:
        if (r4 == 4) goto L25;
        if (r4 == 5) goto L23;
        if (r4 == 6) goto L21;
        if (r4 == 8) goto L19;
        return r0[r3];
    L19:
        return WIFI_7_PIE[r3];
    L21:
        return WIFI_6_PIE[r3];
    L23:
        return WIFI_5_PIE[r3];
    L25:
        return WIFI_4_PIE[r3];
    L27:
        throw new IllegalArgumentException("No Wifi icon found for level: " + r3);
    }

    public static int getDefaultStorageManagerDaysToRetain(Resources r1) {
        return r1.getInteger(android.R.integer.config_sidefpsKeyguardPowerPressWindow);
    L5:
        return 90;
    }

    public static boolean isWifiOnly(Context r1) {
        return !((TelephonyManager) r1.getSystemService(TelephonyManager.class)).isDataCapable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static boolean isStorageManagerEnabled(Context r3) {
        ?? r1 = SystemProperties.getBoolean(STORAGE_MANAGER_ENABLED_PROPERTY, false);     // Catch: Resources.NotFoundException -> L5
    L7:
        if (Settings.Secure.getInt(r3.getContentResolver(), "automatic_storage_manager_enabled", r1) == 0) goto L12;
        return true;
    L12:
        return false;
    L5:
        r1 = 0;
        goto L7
    }

    public static boolean isAudioModeOngoingCall(Context r2) {
        int r3 = ((AudioManager) r2.getSystemService(AudioManager.class)).getMode();
        if (r3 != 1) goto L5;
        return true;
    L5:
        if (r3 != 2) goto L7;
        return true;
    L7:
        if (r3 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isInService(ServiceState r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r4 = getCombinedServiceState(r3);
        if (r4 != 3) goto L8;
    L13:
        return false;
    L8:
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        return true;
    }

    public static int getCombinedServiceState(ServiceState r2) {
        if (r2 != null) goto L5;
        return 1;
    L5:
        int r1 = r2.getVoiceRegState();
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
    L13:
        return r1;
    L10:
        if (isDataRegInWwanAndInService(r2) == false) goto L13;
        return 0;
    }

    private static boolean isDataRegInWwanAndInService(ServiceState r2) {
        NetworkRegistrationInfo r3 = r2.getNetworkRegistrationInfo(2, 1);
        if (r3 != null) goto L7;
        return false;
    L7:
        return r3.isInService();
    }

    public static Drawable getBadgedIcon(Context r4, Drawable r5, UserHandle r6) {
        int r0 = 0;
        UserInfo r1 = ((UserManager) r4.getSystemService(UserManager.class)).getUserInfo(r6.getIdentifier());     // Catch: Exception -> L26
        if (r1 == null) goto L14;
        if (r1.isCloneProfile() == false) goto L9;
        r0 = 2;
        goto L14
    L9:
        if (r1.isManagedProfile() == false) goto L11;
        r0 = 1;
        goto L14
    L11:
        if (r1.isPrivateProfile() == false) goto L14;
        r0 = 3;
    L14:
        IconFactory r2 = IconFactory.obtain(r4);
        FastBitmapDrawable r7 = r2.createBadgedIconBitmap(r5, new BaseIconFactory.IconOptions().setUser(new UserIconInfo(r6, r0))).newIcon(r4);     // Catch: Throwable -> L19
        if (r2 == null) goto L18;
        r2.close();
    L18:
        return r7;
    L19:
        th = move-exception;
        if (r2 != null) goto L27;
    L25:
        throw th;
    L27:
        r2.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    public static Drawable getBadgedIcon(Context r1, ApplicationInfo r2) {
        return getBadgedIcon(r1, r2.loadUnbadgedIcon(r1.getPackageManager()), UserHandle.getUserHandleForUid(r2.uid));
    }

    public static Bitmap convertCornerRadiusBitmap(Context r3, Bitmap r4, float r5) {
        Bitmap r0 = Bitmap.createBitmap(r4.getWidth(), r4.getHeight(), Bitmap.Config.ARGB_8888);
        RoundedBitmapDrawable r6 = RoundedBitmapDrawableFactory.create(r3.getResources(), r4);
        r6.setAntiAlias(true);
        r6.setCornerRadius(r5);
        Canvas r7 = new Canvas(r0);
        r6.setBounds(0, 0, r7.getWidth(), r7.getHeight());
        r6.draw(r7);
        return r0;
    }

    public static WifiInfo tryGetWifiInfoForVcn(NetworkCapabilities r1) {
        if (r1.getTransportInfo() != null) goto L5;
        return null;
    L5:
        if ((r1.getTransportInfo() instanceof VcnTransportInfo) == true) goto L8;
        return null;
    L8:
        return r1.getTransportInfo().getWifiInfo();
    }

    public static boolean containsIncompatibleChargers(Context r8, String r9) {
    L47:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(r9, "containsIncompatibleChargers()", e);
        return false;
    L4:
        if (Settings.Secure.getInt(r8.getContentResolver(), INCOMPATIBLE_CHARGER_WARNING_DISABLED, 0) != 1) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(r9, "containsIncompatibleChargers: disabled");     // Catch: Exception -> L47
        return false;
    L7:
        UsbManager r10 = (UsbManager) r8.getSystemService(UsbManager.class);
        if (r10 != null) goto L10;
        return false;
    L10:
        List r11 = r10.getPorts();
        if (r11 != null) goto L13;
    L46:
        return false;
    L13:
        if (r11.isEmpty() == true) goto L46;
        Iterator r12 = r11.iterator();
    L17:
        if (r12.hasNext() == false) goto L46;
        UsbPort r1 = (UsbPort) r12.next();
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(r9, "usbPort: " + r1);
        if (r1.supportsComplianceWarnings() == false) goto L17;
        UsbPortStatus r2 = r1.getStatus();
        if (r2 == null) goto L17;
        if (r2.isConnected() == false) goto L17;
        int[] r3 = r2.getComplianceWarnings();
        if (r3 == null) goto L17;
        if (r3.length == 0) goto L17;
        int r4 = r3.length;
        int r5 = 0;
    L32:
        if (r5 >= r4) goto L17;
        int r6 = r3[r5];
        if (android.hardware.usb.flags.Flags.enableUsbDataComplianceWarning() == true) goto L36;
    L42:
        if (r6 == 1) goto L45;
        if (r6 == 2) goto L45;
    L44:
        r5 = r5 + 1;
    L45:
        return true;
    L36:
        if (android.hardware.usb.flags.Flags.enableInputPowerLimitedWarning() == false) goto L42;
        if (r6 == 2) goto L41;
        if (r6 != 5) goto L44;
    L41:
        return true;
    }
}
