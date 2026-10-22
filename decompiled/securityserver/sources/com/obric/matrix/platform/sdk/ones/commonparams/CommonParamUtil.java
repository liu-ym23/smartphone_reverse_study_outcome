package com.obric.matrix.platform.sdk.ones.commonparams;

import android.annotation.SuppressLint;
import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonParamUtil {

    @NotNull
    public static final Companion Companion = null;

    @Nullable
    private static CommonParamUtil instance;
    private final Context appContext;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String district;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

    @NotNull
    private String province;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CommonParamUtil getInstance(@NotNull Context r2) {
            Intrinsics.f(r2, "context");
            if (CommonParamUtil.access$getInstance$cp() != null) goto L5;
            CommonParamUtil.access$setInstance$cp(new CommonParamUtil(r2, null));
        L5:
            CommonParamUtil r1 = CommonParamUtil.access$getInstance$cp();
            Intrinsics.c(r1);
            return r1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CommonParamUtil(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public static final /* synthetic */ CommonParamUtil access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(CommonParamUtil r0) {
        instance = r0;
    }

    private final String getDeviceProcessorInfo() {
        BufferedReader r0 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Exception -> L14
    L16:
        String r1 = r0.readLine();     // Catch: Throwable -> L11
        Intrinsics.e(r1, "it");     // Catch: Throwable -> L11
        if (StringsKt.F(r1, "Hardware", false) == false) goto L16;
        Matcher r2 = Pattern.compile("Hardware\\s*:\\s*(.*)$").matcher(r1);     // Catch: Throwable -> L11
        if (r2.matches() == false) goto L16;
        String r4 = r2.group(1);     // Catch: Throwable -> L11
        Intrinsics.e(r4, "m.group(1)");     // Catch: Throwable -> L11
        r0.close();     // Catch: Exception -> L14
        return r4;
    L11:
        th = move-exception;
        r0.close();     // Catch: Exception -> L14
        throw th;     // Catch: Exception -> L14
    L14:
        return "Unknown";
    }

    public final void destroy() {
    }

    @NotNull
    public final Map<String, Object> getAllProperties(@Nullable Map<String, ? extends Object> r26) {
        Map<String, Object> r0 = MapsKt.d(new Pair[]{new Pair("device_brand", getDeviceBrand()), new Pair("device_brightness", Float.valueOf(getCurrentScreenBrightness())), new Pair("device_cpu_architecture", getCpuArchitecture()), new Pair("device_cpu_corenum", Integer.valueOf(getCpuCoreCount())), new Pair("device_cpu_info", getCpuString()), new Pair("device_height", Integer.valueOf(getDeviceHeight())), new Pair("device_ip_address", getIpAddress()), new Pair("device_is_charging", Boolean.valueOf(getDeviceIsCharging())), new Pair("device_model", getDeviceModel()), new Pair("device_poweron_duration", getDevicePoweronDuration()), new Pair("device_resolution", getDeviceResolution()), new Pair("device_storage_total", getTotalStorageSize()), new Pair("device_storage_available", getSDAvailableSize()), new Pair("device_width", Integer.valueOf(getDeviceWidth())), new Pair("os_api", Integer.valueOf(getOsApi())), new Pair("os_baseband", getOsBaseband()), new Pair("os_build_date", getOsBuildDate()), new Pair("os_kernal", getOsKernal()), new Pair("os_language", getOsLanguage()), new Pair("os_network_type", getOsNetworkType()), new Pair("os_ota_version", getOsOtaVersion()), new Pair("os_rom_version", getOsOtaMajorVersion()), new Pair("os_timezone", getOsTimezone())});
        if (r26 == null) goto L6;
        LinkedHashMap r2 = new LinkedHashMap(r0);
        r2.putAll(r26);
        return r2;
    L6:
        return r0;
    }

    @NotNull
    public final String getAppPackageName() {
        String r1 = this.appContext.getPackageName();
        Intrinsics.e(r1, "appContext.packageName");
        return r1;
    }

    public final int getAppVersionCode() {
        return this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0).versionCode;
    L4:
        return -1;
    }

    @NotNull
    public final String getAppVersionName() {
        String r2 = this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0).versionName;     // Catch: Exception -> L4
        Intrinsics.e(r2, "{\n            appContext… 0).versionName\n        }");     // Catch: Exception -> L4
        return r2;
    L4:
        return "Unknown";
    }

    public final int getBatteryCapacity() {
        Object r1 = this.appContext.getSystemService("batterymanager");
        if (r1 == null) goto L7;
        return ((BatteryManager) r1).getIntProperty(4);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
    }

    @NotNull
    public final String getCpuArchitecture() {
        String[] r1 = Build.SUPPORTED_ABIS;
        Intrinsics.e(r1, "SUPPORTED_ABIS");
        if (r1.length != 0) goto L5;
        String r2 = null;
    L6:
        if (r2 != null) goto L9;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        return r2;
    L5:
        r2 = r1[0];
        goto L6
    }

    public final int getCpuCoreCount() {
        return Runtime.getRuntime().availableProcessors();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    @NotNull
    public final String getCpuString() {
        if (Intrinsics.a(getSystemProperty("ro.soc.model"), "SM8750") == false) goto L6;
        return "Qualcomm® Snapdragon™ 8 Gen 4";
    L6:
        return getDeviceProcessorInfo();
    }

    public final float getCurrentScreenBrightness() {
        return Settings.System.getInt(this.appContext.getContentResolver(), "screen_brightness") / 255.0f;
    L4:
        return -1.0f;
    }

    public final int getDeviceBatteryPercent() {
        final Ref.IntRef r0 = new Ref.IntRef();
        IntentFilter r1 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        BroadcastReceiver r2 = new CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1(r0);
        this.appContext.registerReceiver(r2, r1);
        return r0.b;
    }

    @NotNull
    public final String getDeviceBrand() {
        return "Ocean";
    }

    public final int getDeviceHeight() {
        Object r1 = this.appContext.getSystemService("window");
        if (r1 == null) goto L7;
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r1).getDefaultDisplay().getMetrics(r0);
        return r0.heightPixels;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final boolean getDeviceIsCharging() {
        IntentFilter r0 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r2 = this.appContext.registerReceiver(null, r0);
        int r1 = -1;
        if (r2 == null) goto L6;
        r1 = r2.getIntExtra("status", -1);
    L6:
        if (r1 != 2) goto L8;
    L11:
        return true;
    L8:
        if (r1 == 5) goto L11;
        return false;
    }

    @NotNull
    public final String getDeviceModel() {
        String r1 = Build.MODEL;
        Intrinsics.e(r1, "MODEL");
        return r1;
    }

    @NotNull
    public final String getDevicePoweronDuration() {
        int r4 = (int) (SystemClock.elapsedRealtime() / ((long) 1000));     // Catch: Exception -> L4
        int r0 = r4 / 3600;     // Catch: Exception -> L4
        int r5 = r4 % 3600;     // Catch: Exception -> L4
        int r1 = r5 / 60;     // Catch: Exception -> L4
        return String.format("%02d小时%02d分%02d秒", Arrays.copyOf(new Object[]{Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(r5 % 60)}, 3));
    L4:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @NotNull
    public final String getDeviceResolution() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getDeviceWidth());
        r0.append('x');
        r0.append(getDeviceHeight());
        return r0.toString();
    }

    @NotNull
    public final String getDeviceSerialNumber() {
        String r1 = Build.getSerial();
        Intrinsics.e(r1, "getSerial()");
        return r1;
    }

    public final int getDeviceWidth() {
        Object r1 = this.appContext.getSystemService("window");
        if (r1 == null) goto L7;
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r1).getDefaultDisplay().getMetrics(r0);
        return r0.widthPixels;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @SuppressLint({"MissingPermission"})
    @NotNull
    public final String getImei() {
        Object r2 = this.appContext.getSystemService("phone");     // Catch: Exception -> L8
        if (r2 == null) goto L7;
        TelephonyManager r3 = (TelephonyManager) r2;     // Catch: Exception -> L8
        return r3.getImei(0) + '-' + r3.getImei(1);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Exception -> L8
    L8:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @NotNull
    public final String getIpAddress() {
        Enumeration<NetworkInterface> r3 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L12
    L4:
        if (r3.hasMoreElements() == false) goto L22;
        Enumeration<InetAddress> r0 = r3.nextElement().getInetAddresses();     // Catch: Exception -> L12
    L7:
        if (r0.hasMoreElements() == false) goto L4;
        InetAddress r1 = r0.nextElement();     // Catch: Exception -> L12
        if (r1.isLoopbackAddress() == true) goto L7;
        String r4 = r1.getHostAddress();     // Catch: Exception -> L12
        Intrinsics.e(r4, "address.hostAddress");     // Catch: Exception -> L12
        return r4;
    L22:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L12:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final int getOsApi() {
        return Build.VERSION.SDK_INT;
    }

    @NotNull
    public final String getOsBaseband() {
        String r1 = Build.getRadioVersion();
        Intrinsics.e(r1, "getRadioVersion()");
        return r1;
    }

    @NotNull
    public final String getOsBuildDate() {
        return String.valueOf(Build.TIME);
    }

    @NotNull
    public final String getOsKernal() {
        return System.getProperty("os.version").toString();
    }

    @NotNull
    public final String getOsLanguage() {
        String r1 = this.appContext.getResources().getConfiguration().getLocales().get(0).getLanguage();
        Intrinsics.e(r1, "appContext.resources.con…ation.locales[0].language");
        return r1;
    }

    @NotNull
    public final String getOsNetworkType() {
        if (this.appContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) goto L16;
        Object r3 = this.appContext.getSystemService("connectivity");     // Catch: Exception -> L17
        if (r3 == null) goto L15;
        NetworkInfo r4 = ((ConnectivityManager) r3).getActiveNetworkInfo();     // Catch: Exception -> L17
        if (r4 == null) goto L10;
        String r5 = r4.getTypeName();     // Catch: Exception -> L17
    L11:
        if (r5 != null) goto L20;
        return "Unknown";
    L20:
        return r5;
    L10:
        r5 = null;
        goto L11
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L17
    L16:
        return "Unknown";
    L21:
        return "Unknown";
    }

    @NotNull
    public final String getOsOtaMajorVersion() {
        String r3 = getOsOtaVersion();     // Catch: Exception -> L7
        MatchResult r4 = new Regex("^\\d+\\.\\d+\\.\\d+").a(0, r3);     // Catch: Exception -> L7
        if (r4 == null) goto L10;
        return r4.getValue();
    L10:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L11:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @NotNull
    public final String getOsOtaVersion() {
        return getSystemProperty("ro.os.ota.version");
    }

    @NotNull
    public final String getOsTimezone() {
        String r1 = TimeZone.getDefault().getID();
        Intrinsics.e(r1, "getDefault().id");
        return r1;
    }

    @NotNull
    public final String getSDAvailableSize() {
        return (new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() / ((long) 1000000)) + " MB";
    }

    @NotNull
    public final String getSystemProperty(@NotNull String r4) {
        Intrinsics.f(r4, "fieldName");
        String r5 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r4});     // Catch: Exception -> L7
        if (r5 != null) goto L12;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L12:
        return r5;
    L7:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    @NotNull
    public final String getTotalStorageSize() {
        Context r7 = this.appContext;     // Catch: Exception -> L8
        Object r1 = r7.getSystemService("storagestats");     // Catch: Exception -> L8
        if (r1 == null) goto L31;
        StorageStatsManager r2 = (StorageStatsManager) r1;     // Catch: Exception -> L8
        StorageManager r8 = (StorageManager) r7.getSystemService(StorageManager.class);     // Catch: Exception -> L8
        Object r9 = r8.getClass().getMethod("getVolumes", null).invoke(r8, null);     // Catch: Exception -> L8
        if ((r9 instanceof List) == false) goto L10;
        List r10 = (List) r9;     // Catch: Exception -> L8
    L11:
        Class<?> r3 = Class.forName("android.os.storage.VolumeInfo");     // Catch: Exception -> L8
        Method r4 = r3.getMethod("isPrimary", null);     // Catch: Exception -> L8
        Method r5 = r3.getMethod("getFsUuid", null);     // Catch: Exception -> L8
        if (r10 == null) goto L23;
        Iterator r11 = r10.iterator();     // Catch: Exception -> L8
    L15:
        if (r11.hasNext() == false) goto L23;
        Object r6 = r11.next();     // Catch: Exception -> L8
        Object r12 = r4.invoke(r6, null);     // Catch: Exception -> L8
        if (r12 == null) goto L22;
        if (((Boolean) r12).booleanValue() == false) goto L15;
    L24:
        if (r6 == null) goto L39;
        Object r13 = r2.getClass().getMethod("getTotalBytes", new Class[]{String.class}).invoke(r2, new Object[]{r5.invoke(r6, null)});     // Catch: Exception -> L8
        if (r13 == null) goto L29;
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(((((Long) r13).longValue() / 1000.0d) / 1000.0d) / 1000.0d) + " GB";
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L8
    L39:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L8
    L23:
        r6 = null;
        goto L24
    L10:
        r10 = null;
        goto L11
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.StorageStatsManager");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private CommonParamUtil(Context r1) {
        this.appContext = r1.getApplicationContext();
        this.country = "";
        this.province = "";
        this.city = "";
        this.district = "";
        this.longitude = "";
        this.latitude = "";
    }
}
