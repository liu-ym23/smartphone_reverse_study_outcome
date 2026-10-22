package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import com.GlobalProxyLancet;
import com.android.settings.MultiSimAdapter;
import com.android.settings.PageConstants;
import com.android.settings.applications.PickApplicationActivity;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes.dex */
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = null;
    private static final Object sSync = null;
    private static TypedValue sTempValue;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void startActivities(Context r0, Intent[] r1, Bundle r2) {
            r0.startActivities(r1, r2);
        }

        static void startActivity(Context r0, Intent r1, Bundle r2) {
            r0.startActivity(r1, r2);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static File[] getExternalCacheDirs(Context r0) {
            return r0.getExternalCacheDirs();
        }

        static File[] getExternalFilesDirs(Context r0, String r1) {
            return r0.getExternalFilesDirs(r1);
        }

        static File[] getObbDirs(Context r0) {
            return r0.getObbDirs();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable getDrawable(Context r0, int r1) {
            return r0.getDrawable(r1);
        }

        static File getNoBackupFilesDir(Context r0) {
            return r0.getNoBackupFilesDir();
        }

        static File getCodeCacheDir(Context r0) {
            return r0.getCodeCacheDir();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getColor(Context r0, int r1) {
            return r0.getColor(r1);
        }

        static <T> T getSystemService(Context r0, Class<T> r1) {
            return (T) r0.getSystemService(r1);
        }

        static String getSystemServiceName(Context r0, Class<?> r1) {
            return r0.getSystemServiceName(r1);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static File getDataDir(Context r0) {
            return r0.getDataDir();
        }

        static Context createDeviceProtectedStorageContext(Context r0) {
            return r0.createDeviceProtectedStorageContext();
        }

        static boolean isDeviceProtectedStorage(Context r0) {
            return r0.isDeviceProtectedStorage();
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static Intent registerReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
            if ((r11 & 4) == 0) goto L8;
            if (r9 != null) goto L8;
            return GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, ContextCompat.obtainAndCheckReceiverPermission(r6), r10);
        L8:
            return GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, r9, r10, r11 & 1);
        }

        static ComponentName startForegroundService(Context r0, Intent r1) {
            return r0.startForegroundService(r1);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Executor getMainExecutor(Context r0) {
            return r0.getMainExecutor();
        }
    }

    static class Api30Impl {
        private Api30Impl() {
        }

        static String getAttributionTag(Context r0) {
            return r0.getAttributionTag();
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static Intent registerReceiver(Context r0, BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4, int r5) {
            return GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r0, r1, r2, r3, r4, r5);
        }
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        private LegacyServiceMapHolder() {
        }

        static {
            HashMap<Class<?>, String> r0 = new HashMap();
            SERVICES = r0;
            r0.put(SubscriptionManager.class, "telephony_subscription_service");
            r0.put(UsageStatsManager.class, "usagestats");
            r0.put(AppWidgetManager.class, "appwidget");
            r0.put(BatteryManager.class, "batterymanager");
            r0.put(CameraManager.class, "camera");
            r0.put(JobScheduler.class, "jobscheduler");
            r0.put(LauncherApps.class, "launcherapps");
            r0.put(MediaProjectionManager.class, "media_projection");
            r0.put(MediaSessionManager.class, "media_session");
            r0.put(RestrictionsManager.class, "restrictions");
            r0.put(TelecomManager.class, "telecom");
            r0.put(TvInputManager.class, "tv_input");
            r0.put(AppOpsManager.class, "appops");
            r0.put(CaptioningManager.class, "captioning");
            r0.put(ConsumerIrManager.class, "consumer_ir");
            r0.put(PrintManager.class, "print");
            r0.put(BluetoothManager.class, "bluetooth");
            r0.put(DisplayManager.class, "display");
            r0.put(UserManager.class, PickApplicationActivity.EXTRA_USER);
            r0.put(InputManager.class, "input");
            r0.put(MediaRouter.class, "media_router");
            r0.put(NsdManager.class, "servicediscovery");
            r0.put(AccessibilityManager.class, "accessibility");
            r0.put(AccountManager.class, "account");
            r0.put(ActivityManager.class, "activity");
            r0.put(AlarmManager.class, "alarm");
            r0.put(AudioManager.class, "audio");
            r0.put(ClipboardManager.class, "clipboard");
            r0.put(ConnectivityManager.class, "connectivity");
            r0.put(DevicePolicyManager.class, "device_policy");
            r0.put(DownloadManager.class, "download");
            r0.put(DropBoxManager.class, "dropbox");
            r0.put(InputMethodManager.class, "input_method");
            r0.put(KeyguardManager.class, "keyguard");
            r0.put(LayoutInflater.class, "layout_inflater");
            r0.put(LocationManager.class, "location");
            r0.put(NfcManager.class, SettingsSwitchKeyUtil.NFC);
            r0.put(NotificationManager.class, "notification");
            r0.put(PowerManager.class, BatteryTypeInf.BATTERY_POWER_LOCK);
            r0.put(SearchManager.class, "search");
            r0.put(SensorManager.class, "sensor");
            r0.put(StorageManager.class, "storage");
            r0.put(TelephonyManager.class, MultiSimAdapter.PHONE_KEY);
            r0.put(TextServicesManager.class, "textservices");
            r0.put(UiModeManager.class, "uimode");
            r0.put(UsbManager.class, "usb");
            r0.put(Vibrator.class, "vibrator");
            r0.put(WallpaperManager.class, PageConstants.LAUNCH_PAGE_WALLPAPER);
            r0.put(WifiP2pManager.class, "wifip2p");
            r0.put(WifiManager.class, "wifi");
            r0.put(WindowManager.class, "window");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    static {
        sLock = new Object();
        sSync = new Object();
    }

    protected ContextCompat() {
    }

    public static String getAttributionTag(Context r0) {
        return Api30Impl.getAttributionTag(r0);
    }

    public static boolean startActivities(Context r1, Intent[] r2) {
        return startActivities(r1, r2, null);
    }

    public static boolean startActivities(Context r0, Intent[] r1, Bundle r2) {
        Api16Impl.startActivities(r0, r1, r2);
        return true;
    }

    public static void startActivity(Context r0, Intent r1, Bundle r2) {
        Api16Impl.startActivity(r0, r1, r2);
    }

    public static File getDataDir(Context r0) {
        return Api24Impl.getDataDir(r0);
    }

    public static File[] getObbDirs(Context r0) {
        return Api19Impl.getObbDirs(r0);
    }

    public static File[] getExternalFilesDirs(Context r0, String r1) {
        return Api19Impl.getExternalFilesDirs(r0, r1);
    }

    public static File[] getExternalCacheDirs(Context r0) {
        return Api19Impl.getExternalCacheDirs(r0);
    }

    public static Drawable getDrawable(Context r0, int r1) {
        return Api21Impl.getDrawable(r0, r1);
    }

    public static ColorStateList getColorStateList(Context r1, int r2) {
        return ResourcesCompat.getColorStateList(r1.getResources(), r2, r1.getTheme());
    }

    public static int getColor(Context r0, int r1) {
        return Api23Impl.getColor(r0, r1);
    }

    public static int checkSelfPermission(Context r2, String r3) {
        ObjectsCompat.requireNonNull(r3, "permission must be non-null");
        if (BuildCompat.isAtLeastT() == true) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r3) == false) goto L12;
        if (NotificationManagerCompat.from(r2).areNotificationsEnabled() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r2.checkPermission(r3, Process.myPid(), Process.myUid());
    }

    public static File getNoBackupFilesDir(Context r0) {
        return Api21Impl.getNoBackupFilesDir(r0);
    }

    public static File getCodeCacheDir(Context r0) {
        return Api21Impl.getCodeCacheDir(r0);
    }

    private static File createFilesDir(File r4) {
        Object r1 = sSync;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r4.exists() == false) goto L7;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r4;
    L7:
        if (r4.mkdirs() == false) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r4;
    L10:
        Log.w(TAG, "Unable to create files subdir " + r4.getPath());     // Catch: Throwable -> L13
        goto L11
    }

    public static Context createDeviceProtectedStorageContext(Context r0) {
        return Api24Impl.createDeviceProtectedStorageContext(r0);
    }

    public static boolean isDeviceProtectedStorage(Context r0) {
        return Api24Impl.isDeviceProtectedStorage(r0);
    }

    public static Executor getMainExecutor(Context r0) {
        return Api28Impl.getMainExecutor(r0);
    }

    public static void startForegroundService(Context r0, Intent r1) {
        Api26Impl.startForegroundService(r0, r1);
    }

    public static <T> T getSystemService(Context r0, Class<T> r1) {
        return (T) Api23Impl.getSystemService(r0, r1);
    }

    public static Intent registerReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, int r9) {
        return registerReceiver(r6, r7, r8, null, null, r9);
    }

    public static Intent registerReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        int r0 = r11 & 1;
        if (r0 != 0) goto L5;
    L9:
        if (r0 == 0) goto L11;
        r11 = r11 | 2;
    L11:
        int r5 = r11;
        int r12 = r5 & 2;
        if (r12 == 0) goto L14;
    L18:
        if (r12 == 0) goto L25;
        if ((r5 & 4) == 0) goto L25;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L25:
        if (BuildCompat.isAtLeastT() == false) goto L29;
        return Api33Impl.registerReceiver(r6, r7, r8, r9, r10, r5);
    L29:
        return Api26Impl.registerReceiver(r6, r7, r8, r9, r10, r5);
    L14:
        if ((r5 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r11 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static String getSystemServiceName(Context r0, Class<?> r1) {
        return Api23Impl.getSystemServiceName(r0, r1);
    }

    static String obtainAndCheckReceiverPermission(Context r3) {
        String r0 = r3.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r3, r0) != 0) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Permission " + r0 + " is required by your application to receive broadcasts, please add it to your manifest");
    }
}
