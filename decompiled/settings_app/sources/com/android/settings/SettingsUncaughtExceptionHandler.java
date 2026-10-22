package com.android.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.android.settings.about.DeviceUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String LOG_PREFIX = "log_";
    private static final int MAX_LOG_FILE_COUNT = 10;
    private static final long TEN_DAYS = 864000000;
    private static volatile SettingsUncaughtExceptionHandler mInstance;
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    static /* synthetic */ void access$000(SettingsUncaughtExceptionHandler r0) {
        r0.trimLogFiles();
    }

    static /* synthetic */ String access$100(SettingsUncaughtExceptionHandler r0) {
        return r0.getLogs();
    }

    static /* synthetic */ void access$200(SettingsUncaughtExceptionHandler r0, String r1) {
        r0.sendMail(r1);
    }

    private SettingsUncaughtExceptionHandler(Context r1) {
        this.mContext = r1;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static SettingsUncaughtExceptionHandler getInstance(Context r2) {
        if (mInstance != null) goto L15;
        monitor-enter(SettingsUncaughtExceptionHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new SettingsUncaughtExceptionHandler(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SettingsUncaughtExceptionHandler.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void register() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable r3) {
        saveLog(r3);     // Catch: Exception -> L4
    L6:
        this.mDefaultHandler.uncaughtException(r2, r3);
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    private void saveLog(Throwable r6) throws IOException {
        FileOutputStream r1 = null;
        String r7 = getStackTraceForThrowable("", r6, null);
        if (r7 == null) goto L28;
        StringBuilder r0 = new StringBuilder("=======================\n");
        r0.append(getDeviceInfo()).append("\n").append(r7).append("\n=======================\n");
        File r8 = new File(this.mContext.getFilesDir() + "/log_" + System.currentTimeMillis());
        r8.createNewFile();
        FileOutputStream r2 = new FileOutputStream(r8);     // Catch: Throwable -> L13 IOException -> L15
        r2.write(r0.toString().getBytes());     // Catch: Throwable -> L9 IOException -> L11
        r2.flush();     // Catch: Throwable -> L9 IOException -> L11
        r2.close();     // Catch: IOException -> L20
    L30:
        goto L28
    L11:
        e = e;
        r1 = r2;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L13
        if (r1 == null) goto L28;
        r1.close();     // Catch: IOException -> L20
    L9:
        th = th;
        r1 = r2;
    L22:
        if (r1 != null) goto L33;
    L27:
        throw th;
    L33:
        r1.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = e;
    L13:
        th = th;
    L28:
        trimLogFiles();
    }

    private void trimLogFiles() {
        File r0 = new File(this.mContext.getFilesDir().toString());
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L38;
        File[] r1 = r0.listFiles();
        if (r1 == null) goto L39;
        long r2 = System.currentTimeMillis();
        ArrayList r3 = new ArrayList();
        int r4 = r1.length;
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L17;
        File r6 = r1[r5];
        if (r6.getName().startsWith(LOG_PREFIX) == false) goto L16;
        if ((r2 - r6.lastModified()) <= TEN_DAYS) goto L15;
        r6.delete();
        goto L16
    L15:
        r3.add(r6);
    L16:
        r5 = r5 + 1;
        goto L9
    L17:
        r3.trimToSize();
        if (r3.size() <= 10) goto L26;
        Collections.sort(r3, new AnonymousClass1(this));
        int r11 = r3.size() - 1;
    L20:
        if (r11 < 10) goto L26;
        ((File) r3.get(r11)).delete();     // Catch: Exception -> L23
    L25:
        r11 = r11 - 1;
    L23:
        e = move-exception;
        e.printStackTrace();
    L26:
        r3.clear();
        return;
    L39:
        return;
    }

    private String getDeviceInfo() {
        StringBuilder r5 = new StringBuilder();
        String r0 = EnvironmentCompat.MEDIA_UNKNOWN;
        r0 = SystemProperties.get("ro.os.ota.version", EnvironmentCompat.MEDIA_UNKNOWN);     // Catch: Exception -> L6
    L4:
        r5.append("time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n").append("sim exists:" + Utils.isSimExists()).append("\n").append("model:" + Build.MODEL + DeviceUtils.INSTANCE.getMsvSuffix()).append("\n").append("version:" + r0).append("\n");
        return r5.toString();
    }

    private String getLogs() {
        File r0 = new File(this.mContext.getFilesDir().toString());
        BufferedReader r1 = null;
        if (r0.exists() == true) goto L5;
    L41:
        StringBuilder r2 = null;
    L42:
        if (r2 != null) goto L45;
        return null;
    L45:
        return r2.toString();
    L5:
        if (r0.isDirectory() == false) goto L41;
        File[] r7 = r0.listFiles();
        if (r7 == null) goto L41;
        r2 = new StringBuilder();
        int r3 = r7.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L42;
        File r5 = r7[r4];
        if (r5.getName().startsWith(LOG_PREFIX) == false) goto L40;
        BufferedReader r6 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L23 IOException -> L25 FileNotFoundException -> L30
    L52:
        String r8 = r6.readLine();     // Catch: IOException -> L19 FileNotFoundException -> L21 Throwable -> L35
        if (r8 == null) goto L16;
        r2.append(r8).append("\n");     // Catch: IOException -> L19 FileNotFoundException -> L21 Throwable -> L35
        goto L52
    L16:
        r2.append("\n\n\n");     // Catch: IOException -> L19 FileNotFoundException -> L21 Throwable -> L35
    L50:
        r6.close();     // Catch: IOException -> L47
        goto L40
    L35:
        th = th;
        r1 = r6;
    L37:
        if (r1 != null) goto L48;
    L39:
        throw th;
    L48:
        r1.close();     // Catch: IOException -> L46
    L21:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L35
        if (r6 == null) goto L40;
    L19:
        e = e;
    L27:
        e.getStackTrace();     // Catch: Throwable -> L35
        if (r6 == null) goto L40;
    L30:
        e = e;
        r6 = null;
    L25:
        e = e;
        r6 = null;
    L23:
        th = th;
    L40:
        r4 = r4 + 1;
        goto L9
    }

    public void reportLogs() {
        new Thread(new AnonymousClass2(this)).start();
    }

    private void sendMail(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        PickApplicationActivity.EXTRA_USER.equals(Build.TYPE);
        Intent r0 = new Intent("android.intent.action.SENDTO");
        r0.setType("text/plain");
        r0.setData(Uri.parse(""));
        r0.putExtra("android.intent.extra.TITLE", "BugReport: Settings exception log");
        r0.putExtra("android.intent.extra.SUBJECT", "BugReport: Settings exception log");
        r0.putExtra("android.intent.extra.TEXT", r5);
        r0.addFlags(268435456);
        this.mContext.startActivity(r0);     // Catch: ActivityNotFoundException -> L8
        return;
    L8:
        OLog.w("", "email clients not found...");
    }

    private String getStackTraceForThrowable(String r6, Throwable r7, StackTraceElement[] r8) throws IOException {
        StringBuilder r0 = new StringBuilder();
        r0.append(r7.toString());
        r0.append("\n");
        StackTraceElement[] r2 = r7.getStackTrace();
        if (r2 == null) goto L13;
        int r3 = 0;
        if (r8 == null) goto L7;
        int r9 = countDuplicates(r2, r8);
    L9:
        if (r3 >= (r2.length - r9)) goto L11;
        r0.append(r6);
        r0.append("\tat ");
        r0.append(r2[r3].toString());
        r0.append("\n");
        r3 = r3 + 1;
        goto L9
    L11:
        if (r9 <= 0) goto L13;
        r0.append(r6);
        r0.append("\t... ");
        r0.append(Integer.toString(r9));
        r0.append(" more\n");
        goto L13
    L7:
        r9 = 0;
    L13:
        Throwable r10 = r7.getCause();
        if (r10 == null) goto L17;
        r0.append(r6);
        r0.append("Caused by: ");
        r0.append(getStackTraceForThrowable(r6, r10, r2));
    L17:
        return r0.toString();
    }

    private static int countDuplicates(StackTraceElement[] r5, StackTraceElement[] r6) {
        int r0 = r6.length;
        int r1 = r5.length;
        int r2 = 0;
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L10;
        r0 = r0 - 1;
        if (r0 < 0) goto L10;
        if (r6[r0].equals(r5[r1]) == false) goto L10;
        r2 = r2 + 1;
    L10:
        return r2;
    }
}
