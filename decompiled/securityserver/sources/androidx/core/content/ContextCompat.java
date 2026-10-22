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
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
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
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock = null;
    private static TypedValue sTempValue;

    public static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

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
            r0.put(UserManager.class, "user");
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
            r0.put(LocationManager.class, BatteryTypeInf.BATTERY_LOC_API);
            r0.put(NfcManager.class, "nfc");
            r0.put(NotificationManager.class, "notification");
            r0.put(PowerManager.class, BatteryTypeInf.BATTERY_POWER_LOCK);
            r0.put(SearchManager.class, "search");
            r0.put(SensorManager.class, "sensor");
            r0.put(StorageManager.class, "storage");
            r0.put(TelephonyManager.class, "phone");
            r0.put(TextServicesManager.class, "textservices");
            r0.put(UiModeManager.class, "uimode");
            r0.put(UsbManager.class, "usb");
            r0.put(Vibrator.class, "vibrator");
            r0.put(WallpaperManager.class, "wallpaper");
            r0.put(WifiP2pManager.class, "wifip2p");
            r0.put(WifiManager.class, "wifi");
            r0.put(WindowManager.class, "window");
        }

        private LegacyServiceMapHolder() {
        }
    }

    public static class MainHandlerExecutor implements Executor {
        private final Handler mHandler;

        public MainHandlerExecutor(@NonNull Handler r1) {
            this.mHandler = r1;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            if (this.mHandler.post(r2) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    static {
        sLock = new Object();
    }

    public ContextCompat() {
    }

    public static int checkSelfPermission(@NonNull Context r2, @NonNull String r3) {
        if (r3 == null) goto L6;
        return r2.checkPermission(r3, Process.myPid(), Process.myUid());
    L6:
        throw new IllegalArgumentException("permission is null");
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context r0) {
        return r0.createDeviceProtectedStorageContext();
    }

    private static synchronized File createFilesDir(File r4) {
        monitor-enter(ContextCompat.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r4.exists() == false) goto L7;
    L18:
        monitor-exit(ContextCompat.class);
        return r4;
    L7:
        if (r4.mkdirs() == true) goto L18;
        if (r4.exists() == false) goto L12;
        monitor-exit(ContextCompat.class);
        return r4;
    L12:
        Log.w(TAG, "Unable to create files subdir " + r4.getPath());     // Catch: Throwable -> L16
        monitor-exit(ContextCompat.class);
        return null;
    }

    public static File getCodeCacheDir(@NonNull Context r0) {
        return r0.getCodeCacheDir();
    }

    @ColorInt
    public static int getColor(@NonNull Context r0, @ColorRes int r1) {
        return r0.getColor(r1);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r0, @ColorRes int r1) {
        return r0.getColorStateList(r1);
    }

    @Nullable
    public static File getDataDir(@NonNull Context r0) {
        return r0.getDataDir();
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r0, @DrawableRes int r1) {
        return r0.getDrawable(r1);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context r0) {
        return r0.getExternalCacheDirs();
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context r0, @Nullable String r1) {
        return r0.getExternalFilesDirs(r1);
    }

    public static Executor getMainExecutor(Context r0) {
        return r0.getMainExecutor();
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context r0) {
        return r0.getNoBackupFilesDir();
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context r0) {
        return r0.getObbDirs();
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context r0, @NonNull Class<T> r1) {
        return (T) r0.getSystemService(r1);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context r0, @NonNull Class<?> r1) {
        return r0.getSystemServiceName(r1);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context r0) {
        return r0.isDeviceProtectedStorage();
    }

    public static boolean startActivities(@NonNull Context r1, @NonNull Intent[] r2) {
        return startActivities(r1, r2, null);
    }

    public static void startActivity(@NonNull Context r0, @NonNull Intent r1, @Nullable Bundle r2) {
        r0.startActivity(r1, r2);
    }

    public static void startForegroundService(@NonNull Context r0, @NonNull Intent r1) {
        r0.startForegroundService(r1);
    }

    public static boolean startActivities(@NonNull Context r0, @NonNull Intent[] r1, @Nullable Bundle r2) {
        r0.startActivities(r1, r2);
        return true;
    }
}
