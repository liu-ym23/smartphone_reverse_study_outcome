package androidx.core.content;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
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
import android.os.Build;
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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BuildCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sLock = null;
    private static final Object sSync = null;
    private static TypedValue sTempValue;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void startActivities(Context r0, Intent[] r1, Bundle r2) {
            r0.startActivities(r1, r2);
        }

        @DoNotInline
        static void startActivity(Context r0, Intent r1, Bundle r2) {
            r0.startActivity(r1, r2);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static File[] getExternalCacheDirs(Context r0) {
            return r0.getExternalCacheDirs();
        }

        @DoNotInline
        static File[] getExternalFilesDirs(Context r0, String r1) {
            return r0.getExternalFilesDirs(r1);
        }

        @DoNotInline
        static File[] getObbDirs(Context r0) {
            return r0.getObbDirs();
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static File getCodeCacheDir(Context r0) {
            return r0.getCodeCacheDir();
        }

        @DoNotInline
        static Drawable getDrawable(Context r0, int r1) {
            return r0.getDrawable(r1);
        }

        @DoNotInline
        static File getNoBackupFilesDir(Context r0) {
            return r0.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Context r0, int r1) {
            return r0.getColor(r1);
        }

        @DoNotInline
        static <T> T getSystemService(Context r0, Class<T> r1) {
            return (T) r0.getSystemService(r1);
        }

        @DoNotInline
        static String getSystemServiceName(Context r0, Class<?> r1) {
            return r0.getSystemServiceName(r1);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static Context createDeviceProtectedStorageContext(Context r0) {
            return r0.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        static File getDataDir(Context r0) {
            return r0.getDataDir();
        }

        @DoNotInline
        static boolean isDeviceProtectedStorage(Context r0) {
            return r0.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
            return r1.registerReceiver(r2, r3, r4, r5);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
        }

        @Proxy("registerReceiver")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @RequiresApi(api = 26)
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5, int r6) {
            return r1.registerReceiver(r2, r3, r4, r5, r6);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5, r6);
        }

        @DoNotInline
        static Intent registerReceiver(Context r6, @Nullable BroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
            if ((r11 & 4) == 0) goto L8;
            if (r9 != null) goto L8;
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, ContextCompat.obtainAndCheckReceiverPermission(r6), r10);
        L8:
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, r9, r10, r11 & 1);
        }

        @DoNotInline
        static ComponentName startForegroundService(Context r0, Intent r1) {
            return r0.startForegroundService(r1);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Executor getMainExecutor(Context r0) {
            return r0.getMainExecutor();
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static String getAttributionTag(Context r0) {
            return r0.getAttributionTag();
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @Proxy("registerReceiver")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @RequiresApi(api = 26)
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api33Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5, int r6) {
            return r1.registerReceiver(r2, r3, r4, r5, r6);
        L4:
            e = move-exception;
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
            throw e;
        L8:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5, r6);
        }

        @DoNotInline
        static Intent registerReceiver(Context r0, @Nullable BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4, int r5) {
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api33Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r0, r1, r2, r3, r4, r5);
        }
    }

    private static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        static {
            HashMap<Class<?>, String> r0 = new HashMap();
            SERVICES = r0;
            int r1 = Build.VERSION.SDK_INT;
            if (r1 < 22) goto L6;
            r0.put(SubscriptionManager.class, "telephony_subscription_service");
            r0.put(UsageStatsManager.class, "usagestats");
        L6:
            if (r1 < 21) goto L9;
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
        L9:
            if (r1 < 19) goto L12;
            r0.put(AppOpsManager.class, "appops");
            r0.put(CaptioningManager.class, "captioning");
            r0.put(ConsumerIrManager.class, "consumer_ir");
            r0.put(PrintManager.class, "print");
        L12:
            if (r1 < 18) goto L15;
            r0.put(BluetoothManager.class, "bluetooth");
        L15:
            if (r1 < 17) goto L18;
            r0.put(DisplayManager.class, "display");
            r0.put(UserManager.class, "user");
        L18:
            if (r1 < 16) goto L20;
            r0.put(InputManager.class, "input");
            r0.put(MediaRouter.class, "media_router");
            r0.put(NsdManager.class, "servicediscovery");
        L20:
            r0.put(AccessibilityManager.class, "accessibility");
            r0.put(AccountManager.class, "account");
            r0.put(ActivityManager.class, "activity");
            r0.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            r0.put(AudioManager.class, "audio");
            r0.put(ClipboardManager.class, "clipboard");
            r0.put(ConnectivityManager.class, "connectivity");
            r0.put(DevicePolicyManager.class, "device_policy");
            r0.put(DownloadManager.class, "download");
            r0.put(DropBoxManager.class, "dropbox");
            r0.put(InputMethodManager.class, "input_method");
            r0.put(KeyguardManager.class, "keyguard");
            r0.put(LayoutInflater.class, "layout_inflater");
            r0.put(LocationManager.class, LocationMonitorConst.LOCATION);
            r0.put(NfcManager.class, "nfc");
            r0.put(NotificationManager.class, "notification");
            r0.put(PowerManager.class, "power");
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

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface RegisterReceiverFlags {
    }

    static {
        sLock = new Object();
        sSync = new Object();
    }

    protected ContextCompat() {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r1, BroadcastReceiver r2, IntentFilter r3, String r4, Handler r5) {
        return r1.registerReceiver(r2, r3, r4, r5);
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r2, r3, r4, r5);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static int checkSelfPermission(@NonNull Context r2, @NonNull String r3) {
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

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.createDeviceProtectedStorageContext(r2);
    }

    private static File createFilesDir(File r4) {
        Object r0 = sSync;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r4.exists() == false) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L7:
        if (r4.mkdirs() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L10:
        Log.w(TAG, "Unable to create files subdir " + r4.getPath());     // Catch: Throwable -> L13
        goto L11
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        return Api30Impl.getAttributionTag(r2);
    }

    @NonNull
    public static File getCodeCacheDir(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getCodeCacheDir(r2);
    L7:
        return createFilesDir(new File(r2.getApplicationInfo().dataDir, "code_cache"));
    }

    @ColorInt
    public static int getColor(@NonNull Context r2, @ColorRes int r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r2, r3);
    L7:
        return r2.getResources().getColor(r3);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context r1, @ColorRes int r2) {
        return ResourcesCompat.getColorStateList(r1.getResources(), r2, r1.getTheme());
    }

    @Nullable
    public static File getDataDir(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        String r3 = r2.getApplicationInfo().dataDir;
        if (r3 != null) goto L11;
        return null;
    L11:
        return new File(r3);
    L5:
        return Api24Impl.getDataDir(r2);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context r4, @DrawableRes int r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 21) goto L7;
        return Api21Impl.getDrawable(r4, r5);
    L7:
        if (r0 >= 16) goto L9;
        Object r1 = sLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (sTempValue != null) goto L15;
        sTempValue = new TypedValue();     // Catch: Throwable -> L18
    L15:
        r4.getResources().getValue(r5, sTempValue, true);     // Catch: Throwable -> L18
        r5 = sTempValue.resourceId;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
    L9:
        return r4.getResources().getDrawable(r5);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalCacheDirs(r2);
    L7:
        return new File[]{r2.getExternalCacheDir()};
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context r2, @Nullable String r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getExternalFilesDirs(r2, r3);
    L7:
        return new File[]{r2.getExternalFilesDir(r3)};
    }

    @NonNull
    public static Executor getMainExecutor(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getMainExecutor(r2);
    L7:
        return ExecutorCompat.create(new Handler(r2.getMainLooper()));
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNoBackupFilesDir(r2);
    L7:
        return createFilesDir(new File(r2.getApplicationInfo().dataDir, "no_backup"));
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return Api19Impl.getObbDirs(r2);
    L7:
        return new File[]{r2.getObbDir()};
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context r2, @NonNull Class<T> r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r4 = getSystemServiceName(r2, r3);
        if (r4 != null) goto L11;
        return null;
    L11:
        return (T) r2.getSystemService(r4);
    L5:
        return (T) Api23Impl.getSystemService(r2, r3);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context r2, @NonNull Class<?> r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSystemServiceName(r2, r3);
    L7:
        return LegacyServiceMapHolder.SERVICES.get(r3);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return Api24Impl.isDeviceProtectedStorage(r2);
    }

    static String obtainAndCheckReceiverPermission(Context r3) {
        String r0 = r3.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r3, r0) != 0) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Permission " + r0 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @Nullable
    public static Intent registerReceiver(@NonNull Context r6, @Nullable BroadcastReceiver r7, @NonNull IntentFilter r8, int r9) {
        return registerReceiver(r6, r7, r8, null, null, r9);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static Intent registerReceiver(@NonNull Context r6, @Nullable BroadcastReceiver r7, @NonNull IntentFilter r8, @Nullable String r9, @Nullable Handler r10, int r11) {
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
        if (Build.VERSION.SDK_INT < 26) goto L33;
        return Api26Impl.registerReceiver(r6, r7, r8, r9, r10, r5);
    L33:
        if ((r5 & 4) == 0) goto L38;
        if (r9 != null) goto L38;
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, obtainAndCheckReceiverPermission(r6), r10);
    L38:
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r6, r7, r8, r9, r10);
    L14:
        if ((r5 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r11 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static boolean startActivities(@NonNull Context r1, @NonNull Intent[] r2) {
        return startActivities(r1, r2, null);
    }

    public static boolean startActivities(@NonNull Context r2, @NonNull Intent[] r3, @Nullable Bundle r4) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivities(r2, r3, r4);
        return true;
    L5:
        r2.startActivities(r3);
        return true;
    }

    public static void startActivity(@NonNull Context r2, @NonNull Intent r3, @Nullable Bundle r4) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        Api16Impl.startActivity(r2, r3, r4);
        return;
    L5:
        r2.startActivity(r3);
    }

    public static void startForegroundService(@NonNull Context r2, @NonNull Intent r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.startForegroundService(r2, r3);
        return;
    L5:
        r2.startService(r3);
    }
}
