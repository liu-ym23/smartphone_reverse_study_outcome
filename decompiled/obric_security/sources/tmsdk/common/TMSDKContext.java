package tmsdk.common;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import tmsdkobf.b3;
import tmsdkobf.f;
import tmsdkobf.h8;
import tmsdkobf.i5;
import tmsdkobf.k4;
import tmsdkobf.k9;
import tmsdkobf.la;
import tmsdkobf.m3;
import tmsdkobf.nb;
import tmsdkobf.q8;
import tmsdkobf.rd;
import tmsdkobf.ve;
import tmsdkobf.ya;
import tmsdkobf.ye;
import tmsdkobf.za;
import tmsdkobf.zc;

/* JADX INFO: loaded from: classes5.dex */
public final class TMSDKContext {
    public static final int CONFIGURATION_FILE_ERROR = -400;
    public static final String CONFIGURATION_FILE_NAME = "configuration_file_name";
    public static final boolean C_E = true;
    public static final String LIB_TMS_COMMON_EXT = "Tmsdk-2.0.16-mfr";
    public static final int LICENCE_ERROR = -300;
    public static final int LICENCE_EXPIRED = -200;
    public static final int NETWORK_ERROR = -100;
    public static final int NORMAL = 0;
    public static final boolean NO_SAF = true;
    public static final String PRE_HTTP_SERVER_URL = "http_server_url";
    public static final String PRE_LIB_PATH = "pre_lib_path";
    public static final String PRE_TCP_SERVER_ADDRESS = "tcp_server_address";
    public static final String PRE_USE_IP_LIST = "use_ip_list";
    private static final String SDK_VERSION_INFO = "8.2.13 20260616155408";
    public static final boolean S_C_F = false;
    private static final String TAG = "TMSDKContext";
    public static final boolean W_Z = false;
    public static final boolean Y_B = true;
    private static final Object lock_item = null;
    public static boolean mIsMainProcess;
    private static Context sApplication;
    private static Context sCurrentApplication;
    private static Map<String, String> sEnvMap;
    private static boolean sInitialized;
    private static Class<? extends TMSService> sSecureServiceClass;

    static {
        HashMap r0 = new HashMap();
        sEnvMap = r0;
        r0.put(PRE_LIB_PATH, null);
        lock_item = 0;
        sInitialized = false;
        mIsMainProcess = true;
    }

    public TMSDKContext() {
    }

    private static native void cC(int r0);

    public static synchronized <T extends TMSService> int checkLicenceSafeState() {
        monitor-enter(TMSDKContext.class);
        int r1 = checkLicenceSafeState(null);     // Catch: Throwable -> L8
        monitor-exit(TMSDKContext.class);
        return r1;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean checkLisence() {
        return ye.d().a();
    }

    public static void closeConnection() {
        q8.a(TAG, "closeConnection");
        ve.e().a();
        if (i5.d() == true) goto L5;
        return;
    L5:
        if (getApplicaionContext() == null) goto L9;
        i5.c(getApplicaionContext());
        return;
    }

    public static void commonCheck() {
        q8.a(TAG, "commonCheck");
        cC(0);
    }

    private static native int doRegisterNatives(int r0, Class<?> r1);

    public static Context getApplicaionContext() {
        Context r0 = sApplication;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getApplicationContext();
    }

    public static String getCountry() {
        if (sApplication != null) goto L6;
        q8.c(TAG, "getCountry error, no init");
        return "";
    L6:
        String r0 = h8.d().b();
        q8.c(TAG, "getCountry = " + r0);
        return r0;
    }

    public static Context getCurrentContext() {
        return sCurrentApplication;
    }

    public static String getEnvironmentDescription() {
        return b3.b();
    }

    public static String getGuid() {
        if (isInitialized() == true) goto L5;
        return "";
    L5:
        za r0 = ve.e();
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0.b();
    }

    public static String getLanguage() {
        if (sApplication != null) goto L6;
        q8.c(TAG, "getLanguage error, no init");
        return "";
    L6:
        String r0 = h8.d().e();
        q8.c(TAG, "getLanguage = " + r0);
        return r0;
    }

    private static native int getProcBitStatus();

    public static String getSDKVersionInfo() {
        return SDK_VERSION_INFO;
    }

    public static String getScript() {
        if (sApplication != null) goto L6;
        q8.c(TAG, "getScript error, no init");
        return "";
    L6:
        String r0 = h8.d().f();
        q8.c(TAG, "getScript = " + r0);
        return r0;
    }

    public static String getStrFromEnvMap(String r2) {
        Object r0 = lock_item;
        monitor-enter(r0);
        String r3 = sEnvMap.get(r2);     // Catch: Throwable -> L9
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized <T extends TMSService> boolean init(Context r5, Class<T> r6, ITMSApplicaionConfig r7) {
        monitor-enter(TMSDKContext.class);
    L44:
        th = move-exception;
        throw th;
    L6:
        if (isInitialized() == false) goto L9;
        monitor-exit(TMSDKContext.class);
        return true;
    L9:
        if (r5 == null) goto L43;
        q8.a(TAG, "TMSDK version=" + getSDKVersionInfo());     // Catch: Throwable -> L44
        q8.c(TAG, "android api: " + Build.VERSION.SDK_INT + IOUtils.LINE_SEPARATOR_UNIX);     // Catch: Throwable -> L44
        sApplication = r5.getApplicationContext();     // Catch: Throwable -> L44
        if (ve.h() == true) goto L15;
        monitor-exit(TMSDKContext.class);
        return false;
    L15:
        sSecureServiceClass = r6;     // Catch: Throwable -> L44
        if (zc.b() == false) goto L40;
        Object r8 = lock_item;     // Catch: Throwable -> L44
        monitor-enter(r8);     // Catch: Throwable -> L44
        if (r7 != null) goto L48;
    L34:
        monitor-exit(r8);     // Catch: Throwable -> L37
        monitor-exit(TMSDKContext.class);
        return true;
    L48:
        HashMap<String, String> r9 = r7.config(new HashMap(sEnvMap));     // Catch: Throwable -> L37
        String r10 = r9.get(PRE_HTTP_SERVER_URL);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r10) == true) goto L23;
        sEnvMap.put(PRE_HTTP_SERVER_URL, r10);     // Catch: Throwable -> L37
    L23:
        String r11 = r9.get(PRE_TCP_SERVER_ADDRESS);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r11) == true) goto L26;
        sEnvMap.put(PRE_TCP_SERVER_ADDRESS, r11);     // Catch: Throwable -> L37
    L26:
        String r12 = r9.get(PRE_LIB_PATH);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r12) == true) goto L30;
        sEnvMap.put(PRE_LIB_PATH, r12);     // Catch: Throwable -> L37
    L30:
        if (b3.a(sApplication, r9.get(CONFIGURATION_FILE_NAME)) == true) goto L34;
        monitor-exit(r8);     // Catch: Throwable -> L37
        monitor-exit(TMSDKContext.class);
        return false;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L40:
        sApplication = null;     // Catch: Throwable -> L44
        throw new RuntimeException("tms cannot proguard!");     // Catch: Throwable -> L44
    L43:
        throw new RuntimeException("contxt is null when TMSDK init!");     // Catch: Throwable -> L44
    }

    public static boolean isAbroad() {
        return b3.c();
    }

    public static boolean isInitialized() {
        return sInitialized;
    }

    public static void onImsiChanged() {
    }

    public static void registerNatives(int r3, Class<?> r4) {
        ve.k();
        int r5 = doRegisterNatives(r3, r4);
        if (r5 != 0) goto L6;
        return;
    L6:
        throw new UnsatisfiedLinkError("Failed to register " + r4.toString() + "(err=" + r5 + ")");
    }

    public static void reportChannelInfo() {
        q8.a(TAG, "reportChannelInfo");
        nb.a();
    }

    public static void setAutoConnectionSwitch(boolean r2) {
        ve.a(r2);
        q8.a(TAG, "setAutoConnectionSwitch: " + r2);
        if (sApplication != null) goto L5;
        return;
    L5:
        if (ve.a() == false) goto L7;
        int r0 = 29987;
    L8:
        f.f(r0);
        if (r2 == true) goto L11;
        return;
    L11:
        if (isInitialized() == false) goto L16;
        reportChannelInfo();
        return;
    L16:
        return;
    L7:
        r0 = 29988;
        goto L8
    }

    public static int setCountryCode(String r3) {
        if (sApplication != null) goto L6;
        q8.c(TAG, "setCountryCode error, no init");
        return -10;
    L6:
        q8.a(TAG, "setCountryCode countryCode = " + r3);
        int r4 = h8.d().c(r3);
        q8.c(TAG, "setCountryCode code = " + r4);
        return r4;
    }

    public static void setCurrentContext(Context r0) {
        sCurrentApplication = r0;
    }

    public static void setDeviceInfo(Context r3, String r4, String r5) {
        q8.a(TAG, "androidId:" + r4 + "|modelName:" + r5);
        if (r3 == null) goto L18;
        sApplication = r3.getApplicationContext();
        if (ve.h() == true) goto L7;
        return;
    L7:
        String r6 = ye.d().c();
        q8.a(TAG, "chanel:" + r6);
        if (r6 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        k4.a(r5);
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        la.f326a = r4;
        return;
    L19:
        return;
    L18:
        throw new RuntimeException("contxt is null when checkLisence");
    }

    public static void setDualPhoneInfoFetcher(IDualPhoneInfoFetcher r0) {
        ve.a(r0);
    }

    public static void setExtraInfoFetcher(ExtraInfoFetcher r0) {
        ve.a(r0);
    }

    public static int setLanguageDefault() {
        if (sApplication != null) goto L6;
        q8.c(TAG, "setLanguageDefault error, no init");
        return -10;
    L6:
        int r0 = h8.d().a(null, null, null, true);
        q8.c(TAG, "setLanguageDefault code = " + r0);
        return r0;
    }

    public static int setLanguageInfo(String r4, String r5) {
        if (sApplication != null) goto L6;
        q8.c(TAG, "setLanguageAndCountry error, no init");
        return -10;
    L6:
        q8.a(TAG, "setLanguageAndCountry language = " + r4 + ", country = " + r5);
        int r6 = h8.d().a(r4, r5, "", false);
        q8.c(TAG, "setLanguageAndCountry code = " + r6);
        return r6;
    }

    public static void setLogBeta(boolean r0) {
        q8.b(r0);
    }

    public static void setLogTag(String r0) {
        q8.a(r0);
    }

    public static void setMainProcess(boolean r0) {
        mIsMainProcess = r0;
    }

    public static void setTMSDKLogEnable(boolean r0) {
        q8.a(r0);
    }

    public static boolean startPersistentLink() {
        if (ve.e() != null) goto L6;
        return false;
    L6:
        q8.a(TAG, "startPersistentLink");
        ve.e().f();
        return true;
    }

    public static void stopPersistentLink() {
        q8.a(TAG, "stopPersistentLink");
        ve.e().g();
    }

    public static synchronized <T extends TMSService> int checkLicenceSafeState(Context r5) {
        monitor-enter(TMSDKContext.class);
        rd.a(sApplication);     // Catch: Throwable -> L39
        if (b3.a(sApplication) == 1) goto L10;
        monitor-exit(TMSDKContext.class);
        return -400;
    L10:
        za.a(new m3(new ya()));     // Catch: Throwable -> L39
        if (sSecureServiceClass == null) goto L16;
        Context r1 = sCurrentApplication;     // Catch: Throwable -> L39
        if (r1 != null) goto L15;
        r1 = sApplication;     // Catch: Throwable -> L39
    L15:
        r1.startService(new Intent(r1, sSecureServiceClass));     // Catch: Throwable -> L39
    L16:
        ve.g();     // Catch: Throwable -> L39
        sInitialized = true;     // Catch: Throwable -> L39
        if (k9.c() == true) goto L22;
        monitor-exit(TMSDKContext.class);
        return -100;
    L22:
        if (ye.d().e() == false) goto L27;
        monitor-exit(TMSDKContext.class);
        return -200;
    L27:
        if (r5 == null) goto L33;
        if (checkLisence(r5) == true) goto L36;
        monitor-exit(TMSDKContext.class);
        return -300;
    L36:
        monitor-exit(TMSDKContext.class);
        return 0;
    L33:
        if (checkLisence() == true) goto L36;
        monitor-exit(TMSDKContext.class);
        return -300;
    L39:
        th = move-exception;
        throw th;
    }

    public static boolean checkLisence(Context r1) {
        if (r1 == null) goto L6;
        sApplication = r1.getApplicationContext();
        return ye.d().a();
    L6:
        throw new RuntimeException("contxt is null when checkLisence");
    }

    public static int setLanguageInfo(String r3, String r4, String r5) {
        if (sApplication != null) goto L6;
        q8.c(TAG, "setLanguageAndCountry error, no init");
        return -10;
    L6:
        q8.a(TAG, "setLanguageAndCountry language = " + r3 + ", country = " + r4 + ", script = " + r5);
        int r6 = h8.d().a(r3, r4, r5, true);
        q8.c(TAG, "setLanguageAndCountry code = " + r6);
        return r6;
    }
}
