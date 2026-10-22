package com.bytedance.sremlib;

import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.AsyncTask;
import android.os.SystemProperties;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

/* JADX INFO: loaded from: classes3.dex */
public class LibUtil {
    public static final String ACTION_BOOT_COMPLETELY = "android.intent.action.BOOT_COMPLETED";
    public static final String ACTION_BOOT_COMPLETELY_REM_SERVICE = "android.intent.rem.action.BOOT_COMPLETED";
    public static final String ACTION_DISABLE_REM = "com.bytedance.rem.framework.REMDisable";
    public static final String ACTION_DISABLE_WIFI = "com.bytedance.rem.framework.WIFIDisable";
    public static final String ACTION_ENABLE_REM = "com.bytedance.rem.framework.REMEnable";
    public static final String ACTION_ENABLE_WIFI = "com.bytedance.rem.framework.WIFIEnable";
    public static final String ACTION_RTC_REM = "android.intent.rem.action.RTC_REM";
    public static final String ACTION_SEND_LOG = "android.intent.rem.action.SEND_LOG";
    public static final String ACTION_SEND_MESSAGE = "android.intent.rem.action.SEND_MESSAGE";
    public static final String ACTION_STORAGE_OPERATOR = "android.intent.rem.action.STORAGE_OPERATOR";
    private static final String AP_LOG_PATH = "/data/Mlog/";
    public static final String CP_LOG_PATH = "/sdcard/logs/backup/";
    public static final String CP_LOG_PATH_1 = "/data/com_DDR_RW.bin";
    public static final int DAY = 86400000;
    public static final boolean DEBUG = false;
    public static final long DEFAULT_LIVETIME_RECORD_INTERVAL = 1200000;
    public static final long DEFAULT_LIVETIME_SUBMIT_INTERVAL = 21600000;
    public static final String DEFAULT_REM_MODEM_NUMBER = "13021210642";
    public static final String EXCEPTION_APPLICATION = "app";
    public static final String EXCEPTION_LIVE_TIME = "live_time";
    public static final String EXCEPTION_OTHERS = "others";
    public static final String EXCEPTION_PATH = "/data/";
    public static final int EXCEPTION_REM_KERNEL = 32;
    public static final String EXTRA_MESSAGE_ID = "msg_id";
    private static boolean FLAG_BACKUP_LOG = false;
    private static final String HOST = "127.0.0.1";
    public static final int HOUR = 3600000;
    public static final String HW_VERSION = "hw_version";
    public static final String KEY_BOOT_TIMES = "boot_times";
    public static final String KEY_ENABLE_BUG_REPORT = "send_action_app_error";
    public static final String KEY_LAST_TIME = "last_time";
    public static final String KEY_TOTAL_TIME = "total_time";
    public static final String MESSAGE_BOOT_TIMES = "boot_times";
    public static final String MESSAGE_BUILD_VERSION = "build_version";
    public static final String MESSAGE_CP_VERSION = "cp_version";
    public static final String MESSAGE_EXCEPTION_DESCRIPTION = "exception_description";
    public static final String MESSAGE_EXCEPTION_TYPE = "exception_type";
    public static final String MESSAGE_HEADER_EXCEPTION = "&>";
    public static final String MESSAGE_HEADER_LIVE_TIME = "***";
    public static final String MESSAGE_LIVE_TIME = "live_time";
    public static final String MESSAGE_LIVE_TIME_TOTAL = "live_time_total";
    public static final String MESSAGE_LOG_PATH = "log_path";
    public static final String MESSAGE_PHONE_SETTING = "phone_setting";
    public static final String MESSAGE_PRODUCT_NAME = "product_name";
    public static final String MESSAGE_SEPARATOR = ":";
    public static final String MESSAGE_TYPE = "message_type";
    public static final String MESSAGE_UPTIME = "uptime";
    public static final int MINUTE = 60000;
    public static final String PARCELABLE_EXTRA = "android.intent.extra.BUG_REPORT";
    private static final int PORT = 54321;
    public static final String PREFERENCE_APP_SWITCH = "app_switch";
    public static final String PREFERENCE_CP_SWITCH = "cp_switch";
    public static final String PREFERENCE_DATA_RESET = "data_reset";
    public static final String PREFERENCE_IP = "wifi_ip";
    public static final String PREFERENCE_KPANIC_SWITCH = "kpanic_switch";
    public static final String PREFERENCE_LIVE_TIME_INTERVEL = "live_time_interval";
    public static final String PREFERENCE_MASTER_SWITCH = "master_switch";
    public static final String PREFERENCE_MODEM = "rem_modem";
    public static final String PREFERENCE_RTC_INTERVEL = "rtc_interval";
    public static final String PREFERENCE_WIFI_SWITCH = "wifi_switch";
    public static final String PSN = "psn";
    public static final String Phone_Setting_File = "/sys/class/mmc_host/mmc0/device/mmc_host/mmc0/mmc0:0001/cid";
    public static final int RESEND_NORMAL = 1;
    public static final int RESEND_SMS = 0;
    public static final String RESPONSE_INFO_ERROR = "REM send error";
    public static final String RESPONSE_INFO_OK = "REM send ok";
    public static final int SECOND = 1000;
    public static final String SYSTEM_APPS_ERROR_RECEIVER_PROPERTY = "ro.error.receiver.system.apps";
    public static final String SYS_PROPERTY_TAG_BUILD_VERSION = "ro.build.date";
    public static final String SYS_PROPERTY_TAG_CP_VERSION = "gsm.version.baseband";
    public static final String SYS_PROPERTY_TAG_DEVTEST = "persist.bytedance.devtest";
    public static final String SYS_PROPERTY_TAG_PRODUCT_NAME = "ro.build.description";
    public static final String SYS_PROPERTY_TAG_REM_SWITCH = "persist.radio.rem.enable";
    public static final String SYS_PROPERTY_TAG_WIFI_SWITCH = "persist.radio.remwifi.enable";
    private static final String TAPI_LOG_PATH = "/data/log/";
    private static final String TRACE_LOG_PATH = "/data/anr/traces.txt";
    public static long liveTimeInterval = 1200000;

    public static class SendTcmdTask extends AsyncTask<String, Integer, String> {
        public SendTcmdTask() {
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String doInBackground2(String... r3) {
            if (LibUtil.runTcmdCommand(r3[0]) == false) goto L5;
            OLog.d("Scitd", r3[0] + " has been run sucessfully");
            return null;
        L5:
            OLog.e("Scitd", r3[0] + " has been run unsucessfully");
            return null;
        }
    }

    static {
    }

    public LibUtil() {
    }

    public static void close(Reader r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e("bhj", String.format("%s:%d: ", new Object[]{"Util.java", 655}), e);
    }

    public static void close(Socket r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e("bhj", String.format("%s:%d: ", new Object[]{"Util.java", 666}), e);
    }

    public static void close(LocalSocket r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e("bhj", String.format("%s:%d: ", new Object[]{"Util.java", 677}), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [int] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.PrintWriter] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static String unixSend(String r9, int r10, String r11) {
        String r1 = "";
        ?? r3 = 0;
        PrintWriter r4 = null;
        r4 = null;
        r3 = 0;
        r4 = null;
        r3 = 0;
        LocalSocket r5 = new LocalSocket();     // Catch: Throwable -> L26 Exception -> L28
    L45:
        r5.connect(new LocalSocketAddress("scitd", LocalSocketAddress.Namespace.RESERVED));     // Catch: Throwable -> L22 Exception -> L24
        r5.setSoTimeout(r10);     // Catch: Throwable -> L22 Exception -> L24
        r10 = new BufferedReader(new InputStreamReader(r5.getInputStream()));     // Catch: Throwable -> L22 Exception -> L24
        PrintWriter r6 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(r5.getOutputStream())), true);     // Catch: Exception -> L20 Throwable -> L35
        r6.println(r9);     // Catch: Throwable -> L16 Exception -> L18
        r6.flush();     // Catch: Throwable -> L16 Exception -> L18
    L7:
        String r7 = r10.readLine();     // Catch: Throwable -> L16 Exception -> L18
        if (r7 == null) goto L15;
        if (r11 == null) goto L13;
        if (r7.contains(r11) == false) goto L13;
        StringBuilder r12 = new StringBuilder().append(r7);     // Catch: Throwable -> L16 Exception -> L18
        r7 = ", ";
        OLog.e("bhj", r12.append(", ").append(r1).toString());     // Catch: Throwable -> L16 Exception -> L18
    L13:
        r1 = (r1 + r7) + "\n";     // Catch: Throwable -> L16 Exception -> L18
    L15:
        r6.close();
        r3 = r7;
        r10 = r10;
    L33:
        close(r10);
        close(r5);
        return r1;
    L18:
        e = e;
        r4 = r6;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L35
        OLog.e("bhj", String.format("%s:%d: command is %s", new Object[]{"Util.java", 697, r9}), e);     // Catch: Throwable -> L35
        r3 = r4;
        r10 = r10;
        if (r4 == null) goto L33;
        r4.close();
        r3 = r4;
        r10 = r10;
    L16:
        th = th;
        r3 = r6;
    L36:
        if (r3 == 0) goto L38;
        r3.close();
    L38:
        close(r10);
        close(r5);
        throw th;
    L20:
        e = e;
        goto L30
    L24:
        e = e;
        r10 = 0;
    L22:
        th = th;
        r10 = 0;
    L35:
        th = th;
    L28:
        e = e;
        r10 = 0;
        r5 = null;
    L26:
        th = th;
        r10 = 0;
        r5 = null;
        goto L36
    }

    public static String TCP_Send(String r10, int r11, String r12) {
        String r1 = "";
        if (SystemProperties.getInt("ro.debuggable", 0) == 0) goto L5;
        PrintWriter r4 = null;
        Socket r5 = new Socket("127.0.0.1", 54321);     // Catch: Throwable -> L30 Exception -> L32
        r5.setSoTimeout(r11);     // Catch: Throwable -> L26 Exception -> L28
        BufferedReader r13 = new BufferedReader(new InputStreamReader(r5.getInputStream()));     // Catch: Throwable -> L26 Exception -> L28
        PrintWriter r6 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(r5.getOutputStream())), true);     // Catch: Exception -> L24 Throwable -> L39
        r6.println(r10);     // Catch: Throwable -> L20 Exception -> L22
        r6.flush();     // Catch: Throwable -> L20 Exception -> L22
    L11:
        String r7 = r13.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r7 == null) goto L19;
        if (r12 == null) goto L17;
        if (r7.contains(r12) == false) goto L17;
        OLog.e("bhj", r7 + ", " + r1);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        r1 = (r1 + r7) + "\n";     // Catch: Throwable -> L20 Exception -> L22
    L19:
        r6.close();
    L37:
        close(r13);
        close(r5);
        return r1;
    L22:
        e = e;
        r4 = r6;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L39
        OLog.e("bhj", String.format("%s:%d: command is %s", new Object[]{"LibUtil.java", 327, r10}), e);     // Catch: Throwable -> L39
        if (r4 == null) goto L37;
        r4.close();
    L20:
        th = th;
        r4 = r6;
    L40:
        if (r4 == null) goto L42;
        r4.close();
    L42:
        close(r13);
        close(r5);
        throw th;
    L24:
        e = e;
    L39:
        th = th;
        goto L40
    L28:
        e = e;
        r13 = null;
    L26:
        th = th;
        r13 = null;
        goto L40
    L32:
        e = e;
        r13 = null;
        r5 = null;
    L30:
        th = th;
        r13 = null;
        r5 = null;
        goto L40
    L5:
        return unixSend(r10, r11, r12);
    }

    public static String TCP_Send(String r1, String r2) {
        return TCP_Send(r1, 10000, r2);
    }

    public static String TCP_Send(String r2) {
        return TCP_Send(r2, 3000, null);
    }

    public static boolean runTcmdCommand(String r2) {
        String r3 = TCP_Send(r2);
        if ("" != r3) goto L5;
    L8:
        return false;
    L5:
        if ((-1) == r3.indexOf("ret: 0", 0)) goto L8;
        return true;
    }
}
