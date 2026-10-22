package com.obric.matrix.platform.sdk.ones.commonparams;

import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommonParamUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u0000 72\u00020\u0001:\u00017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\b\u0010$\u001a\u00020\bH\u0002J\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\u0015J\b\u0010(\u001a\u00020\bH\u0007J\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\bJ\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u0006\u00102\u001a\u00020\bJ\u0006\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bR\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonparams/CommonParamUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "city", "", "country", "district", "latitude", "longitude", "province", "destroy", "", "getAllProperties", "", "params", "getAppPackageName", "getAppVersionCode", "", "getAppVersionName", "getBatteryCapacity", "getCpuArchitecture", "getCpuCoreCount", "getCpuString", "getCurrentScreenBrightness", "", "getDeviceBatteryPercent", "getDeviceBrand", "getDeviceHeight", "getDeviceIsCharging", "", "getDeviceModel", "getDevicePoweronDuration", "getDeviceProcessorInfo", "getDeviceResolution", "getDeviceSerialNumber", "getDeviceWidth", "getImei", "getIpAddress", "getOsApi", "getOsBaseband", "getOsBuildDate", "getOsKernal", "getOsLanguage", "getOsNetworkType", "getOsOtaMajorVersion", "getOsOtaVersion", "getOsTimezone", "getSDAvailableSize", "getSystemProperty", "fieldName", "getTotalStorageSize", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonParamUtil {
    public static final Companion Companion = null;
    private static CommonParamUtil instance;
    private final Context appContext;
    private String city;
    private String country;
    private String district;
    private String latitude;
    private String longitude;
    private String province;

    /* JADX INFO: compiled from: CommonParamUtil.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonparams/CommonParamUtil$Companion;", "", "()V", "instance", "Lcom/obric/matrix/platform/sdk/ones/commonparams/CommonParamUtil;", "getInstance", "context", "Landroid/content/Context;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final CommonParamUtil getInstance(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (CommonParamUtil.access$getInstance$cp() != null) goto L5;
            CommonParamUtil.access$setInstance$cp(new CommonParamUtil(r2, null));
        L5:
            CommonParamUtil r1 = CommonParamUtil.access$getInstance$cp();
            Intrinsics.checkNotNull(r1);
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CommonParamUtil(Context r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public final void destroy() {
    }

    public final String getDeviceBrand() {
        return "Ocean";
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

    public static final /* synthetic */ CommonParamUtil access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ void access$setInstance$cp(CommonParamUtil r0) {
        instance = r0;
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

    public final int getDeviceHeight() {
        Object r1 = this.appContext.getSystemService("window");
        if (r1 == null) goto L7;
        DisplayMetrics r0 = new DisplayMetrics();
        ((WindowManager) r1).getDefaultDisplay().getMetrics(r0);
        return r0.heightPixels;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final String getDeviceResolution() {
        return new StringBuilder().append(getDeviceWidth()).append('x').append(getDeviceHeight()).toString();
    }

    public final String getDeviceModel() {
        String r1 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(r1, "MODEL");
        return r1;
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

    public final int getBatteryCapacity() {
        Object r1 = this.appContext.getSystemService("batterymanager");
        if (r1 == null) goto L7;
        return ((BatteryManager) r1).getIntProperty(4);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
    }

    public final int getDeviceBatteryPercent() {
        final Ref.IntRef r0 = new Ref.IntRef();
        IntentFilter r1 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        BroadcastReceiver r2 = new CommonParamUtil$getDeviceBatteryPercent$batteryReceiver$1(r0);
        this.appContext.registerReceiver(r2, r1);
        return r0.element;
    }

    public final String getDeviceSerialNumber() {
        String r1 = Build.getSerial();
        Intrinsics.checkNotNullExpressionValue(r1, "getSerial()");
        return r1;
    }

    public final String getDevicePoweronDuration() {
        int r6 = (int) (SystemClock.elapsedRealtime() / ((long) 1000));     // Catch: Exception -> L4
        int r0 = r6 / 3600;     // Catch: Exception -> L4
        int r7 = r6 % 3600;     // Catch: Exception -> L4
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L4
        String r8 = String.format("%02d小时%02d分%02d秒", Arrays.copyOf(new Object[]{Integer.valueOf(r0), Integer.valueOf(r7 / 60), Integer.valueOf(r7 % 60)}, 3));     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r8, "format(format, *args)");     // Catch: Exception -> L4
        return r8;
    L4:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final int getOsApi() {
        return Build.VERSION.SDK_INT;
    }

    public final String getOsOtaVersion() {
        return getSystemProperty("ro.os.ota.version");
    }

    public final String getOsBaseband() {
        String r1 = Build.getRadioVersion();
        Intrinsics.checkNotNullExpressionValue(r1, "getRadioVersion()");
        return r1;
    }

    public final String getOsKernal() {
        return System.getProperty("os.version").toString();
    }

    public final String getOsBuildDate() {
        return String.valueOf(Build.TIME);
    }

    public final String getOsOtaMajorVersion() {
        String r5 = getOsOtaVersion();     // Catch: Exception -> L10
        MatchResult r6 = Regex.find$default(new Regex("^\\d+\\.\\d+\\.\\d+"), r5, 0, 2, null);     // Catch: Exception -> L10
        if (r6 == null) goto L13;
        String r7 = r6.getValue();     // Catch: Exception -> L10
        if (r7 != null) goto L9;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L9:
        return r7;
    L13:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L15:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String getOsLanguage() {
        String r1 = this.appContext.getResources().getConfiguration().getLocales().get(0).getLanguage();
        Intrinsics.checkNotNullExpressionValue(r1, "appContext.resources.con…ation.locales[0].language");
        return r1;
    }

    public final String getOsTimezone() {
        String r1 = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(r1, "getDefault().id");
        return r1;
    }

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

    public final String getAppPackageName() {
        String r1 = this.appContext.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r1, "appContext.packageName");
        return r1;
    }

    public final int getAppVersionCode() {
        return this.appContext.getPackageManager().getPackageInfo(this.appContext.getPackageName(), 0).versionCode;
    L4:
        return -1;
    }

    public final String getAppVersionName() {
        PackageManager r1 = this.appContext.getPackageManager();     // Catch: Exception -> L12
        if (r1 == null) goto L15;
        PackageInfo r3 = r1.getPackageInfo(this.appContext.getPackageName(), 0);     // Catch: Exception -> L12
        if (r3 == null) goto L16;
        String r4 = r3.versionName;     // Catch: Exception -> L12
        if (r4 != null) goto L11;
        return "Unknown";
    L11:
        return r4;
    L16:
        return "Unknown";
    L15:
        return "Unknown";
    L18:
        return "Unknown";
    }

    public final String getCpuString() {
        if (Intrinsics.areEqual(getSystemProperty("ro.soc.model"), "SM8750") == false) goto L6;
        return "Qualcomm® Snapdragon™ 8 Gen 4";
    L6:
        return getDeviceProcessorInfo();
    }

    private final String getDeviceProcessorInfo() {
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/cpuinfo"));     // Catch: Exception -> L18
    L20:
        String r2 = r1.readLine();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r2, "it");     // Catch: Throwable -> L15
        if (r2 == null) goto L13;
        if (StringsKt.startsWith$default(r2, "Hardware", false, 2, null) == false) goto L20;
        Matcher r3 = Pattern.compile("Hardware\\s*:\\s*(.*)$").matcher(r2);     // Catch: Throwable -> L15
        if (r3.matches() == false) goto L20;
        String r0 = r3.group(1);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r0, "m.group(1)");     // Catch: Throwable -> L15
        r1.close();     // Catch: Exception -> L18
        return r0;
    L13:
        r1.close();     // Catch: Exception -> L18
        return "Unknown";
    L15:
        th = move-exception;
        r1.close();     // Catch: Exception -> L18
        throw th;     // Catch: Exception -> L18
    L18:
        return "Unknown";
    }

    public final float getCurrentScreenBrightness() {
        return Settings.System.getInt(this.appContext.getContentResolver(), "screen_brightness") / 255.0f;
    L4:
        return -1.0f;
    }

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

    public final Map<String, Object> getAllProperties(Map<String, ? extends Object> r4) {
        Map<String, Object> r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("device_brand", getDeviceBrand()), TuplesKt.to("device_brightness", Float.valueOf(getCurrentScreenBrightness())), TuplesKt.to("device_cpu_architecture", getCpuArchitecture()), TuplesKt.to("device_cpu_corenum", Integer.valueOf(getCpuCoreCount())), TuplesKt.to("device_cpu_info", getCpuString()), TuplesKt.to("device_height", Integer.valueOf(getDeviceHeight())), TuplesKt.to("device_ip_address", getIpAddress()), TuplesKt.to("device_is_charging", Boolean.valueOf(getDeviceIsCharging())), TuplesKt.to("device_model", getDeviceModel()), TuplesKt.to("device_poweron_duration", getDevicePoweronDuration()), TuplesKt.to("device_resolution", getDeviceResolution()), TuplesKt.to("device_storage_total", getTotalStorageSize()), TuplesKt.to("device_storage_available", getSDAvailableSize()), TuplesKt.to("device_width", Integer.valueOf(getDeviceWidth())), TuplesKt.to("os_api", Integer.valueOf(getOsApi())), TuplesKt.to("os_baseband", getOsBaseband()), TuplesKt.to("os_build_date", getOsBuildDate()), TuplesKt.to("os_kernal", getOsKernal()), TuplesKt.to("os_language", getOsLanguage()), TuplesKt.to("os_network_type", getOsNetworkType()), TuplesKt.to("os_ota_version", getOsOtaVersion()), TuplesKt.to("os_rom_version", getOsOtaMajorVersion()), TuplesKt.to("os_timezone", getOsTimezone())});
        if (r4 != null) goto L5;
        return r3;
    L5:
        return MapsKt.plus(r3, r4);
    }

    public final String getSystemProperty(String r7) {
        Intrinsics.checkNotNullParameter(r7, "fieldName");
        String r8 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{r7});     // Catch: Exception -> L7
        if (r8 != null) goto L12;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L12:
        return r8;
    L7:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String getTotalStorageSize() {
        Context r9 = this.appContext;     // Catch: Exception -> L29
        Object r1 = r9.getSystemService("storagestats");     // Catch: Exception -> L29
        if (r1 == null) goto L28;
        StorageStatsManager r2 = (StorageStatsManager) r1;     // Catch: Exception -> L29
        StorageManager r10 = (StorageManager) r9.getSystemService(StorageManager.class);     // Catch: Exception -> L29
        Object r11 = r10.getClass().getMethod("getVolumes", new Class[0]).invoke(r10, new Object[0]);     // Catch: Exception -> L29
        Object r3 = null;
        if ((r11 instanceof List) == false) goto L8;
        List r12 = (List) r11;     // Catch: Exception -> L29
    L9:
        Class<?> r4 = Class.forName("android.os.storage.VolumeInfo");     // Catch: Exception -> L29
        Method r5 = r4.getMethod("isPrimary", new Class[0]);     // Catch: Exception -> L29
        Method r6 = r4.getMethod("getFsUuid", new Class[0]);     // Catch: Exception -> L29
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();     // Catch: Exception -> L29
    L13:
        if (r13.hasNext() == false) goto L21;
        Object r7 = r13.next();     // Catch: Exception -> L29
        Object r8 = r5.invoke(r7, new Object[0]);     // Catch: Exception -> L29
        if (r8 == null) goto L20;
        if (((Boolean) r8).booleanValue() == false) goto L13;
        r3 = r7;
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L29
    L21:
        if (r3 == null) goto L37;
        Object r14 = r2.getClass().getMethod("getTotalBytes", new Class[]{String.class}).invoke(r2, new Object[]{r6.invoke(r3, new Object[0])});     // Catch: Exception -> L29
        if (r14 == null) goto L26;
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(((((Long) r14).longValue() / 1000.0d) / 1000.0d) / 1000.0d) + " GB";
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L29
    L37:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L8:
        r12 = null;
        goto L9
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.StorageStatsManager");     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String getSDAvailableSize() {
        return (new StatFs(Environment.getExternalStorageDirectory().getPath()).getAvailableBytes() / ((long) 1000000)) + " MB";
    }

    public final String getIpAddress() {
        Enumeration<NetworkInterface> r3 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L13
    L4:
        if (r3.hasMoreElements() == false) goto L26;
        Enumeration<InetAddress> r0 = r3.nextElement().getInetAddresses();     // Catch: Exception -> L13
    L7:
        if (r0.hasMoreElements() == false) goto L4;
        InetAddress r1 = r0.nextElement();     // Catch: Exception -> L13
        if (r1.isLoopbackAddress() == true) goto L7;
        if (r1 == null) goto L7;
        String r4 = r1.getHostAddress();     // Catch: Exception -> L13
        Intrinsics.checkNotNullExpressionValue(r4, "address.hostAddress");     // Catch: Exception -> L13
        return r4;
    L26:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L13:
        e = move-exception;
        e.printStackTrace();
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public final String getCpuArchitecture() {
        String[] r1 = Build.SUPPORTED_ABIS;
        Intrinsics.checkNotNullExpressionValue(r1, "SUPPORTED_ABIS");
        String r2 = (String) ArraysKt.firstOrNull(r1);
        if (r2 != null) goto L6;
        return EnvironmentCompat.MEDIA_UNKNOWN;
    L6:
        return r2;
    }

    public final int getCpuCoreCount() {
        return Runtime.getRuntime().availableProcessors();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }
}
