package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Boolean f2890b;

    public static boolean a(String r5) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L18:
        return false;
    L5:
        if (EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(r5) == true) goto L18;
        if ("Null".equalsIgnoreCase(r5) == true) goto L18;
        int r0 = 0;
    L10:
        if (r0 >= r5.length()) goto L15;
        if (r5.charAt(r0) != '0') goto L17;
        r0 = r0 + 1;
    L17:
        return !r1;
    L15:
        r1 = true;
        goto L17
    }

    public static void b(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(JSONObject r3, JSONObject r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L14;
        return;
    L14:
        Iterator<String> r0 = r4.keys();     // Catch: JSONException -> L11
    L8:
        if (r0.hasNext() == false) goto L18;
        String r1 = r0.next();     // Catch: JSONException -> L11
        r3.put(r1, r4.opt(r1));     // Catch: JSONException -> L11
        goto L8
    L18:
        return;
    L11:
        e = move-exception;
        q.i(e);
    }

    public static boolean d(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
    L6:
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.equals(r2) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        goto L6
    }

    static Context e(Context r1) {
        if ((r1 instanceof Application) == true) goto L7;
        if (r1 != null) goto L6;
        return r1;
    L6:
        return r1.getApplicationContext();
    L7:
        return r1;
    }

    public static String f() {
        Method r1 = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L8
        if ((r2 instanceof String) == false) goto L11;
        return (String) r2;
    L11:
        return null;
    L12:
        return null;
    }

    static String g(Context r3) {
        String r0 = f2889a;
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        String r1 = Application.getProcessName();
        if (TextUtils.isEmpty(r1) == true) goto L11;
        f2889a = r1;
        return r1;
    L11:
        String r2 = f();
        if (TextUtils.isEmpty(r2) == true) goto L27;
        f2889a = r2;
        return r2;
    L27:
        int r4 = Process.myPid();     // Catch: Exception -> L26
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L26
    L17:
        if (r5.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r6 = r5.next();     // Catch: Exception -> L26
        if (r6.pid != r4) goto L17;
        f2889a = r6.processName;     // Catch: Exception -> L26
    L21:
        f2889a = h();
        if (q.b() == false) goto L25;
        q.a("getProcessName, " + f2889a);
    L25:
        return f2889a;
    }

    private static String h() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L16
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L16
        r1.close();     // Catch: Exception -> L15
    L10:
        return r0;
    L12:
        if (r1 != null) goto L22;
    L14:
        return null;
    L22:
        r1.close();     // Catch: Exception -> L17
    L11:
        r1 = null;
        goto L12
    }

    public static boolean i(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return true;
    L6:
        if (r5.equalsIgnoreCase(EnvironmentCompat.MEDIA_UNKNOWN) == false) goto L9;
        return true;
    L9:
        if (r5.equalsIgnoreCase("None") == false) goto L11;
        return true;
    L11:
        int r2 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        if (r5.charAt(r2) != '0') goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return false;
    L21:
        return true;
    }

    public static boolean j(Context r1) {
        if (f2890b != null) goto L6;
        Objects.requireNonNull(r1, "context is null");
        f2890b = Boolean.valueOf(TextUtils.equals(g(r1), r1.getPackageName()));
    L6:
        return f2890b.booleanValue();
    }

    public static boolean k(String r5) {
        if (r5 == null) goto L5;
        int r1 = r5.length();
    L7:
        if (r1 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r1 > 128) goto L31;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L29;
        char r3 = r5.charAt(r2);
        if (r3 < '0') goto L18;
        if (r3 > '9') goto L18;
    L27:
        r2 = r2 + 1;
    L18:
        if (r3 < 'a') goto L22;
        if (r3 <= 'f') goto L27;
    L22:
        if (r3 < 'A') goto L26;
        if (r3 <= 'F') goto L27;
    L26:
        if (r3 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    public static void l(JSONObject r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.put(r2, r3);
        return;
    }

    public static void m(SharedPreferences r6, String[] r7) {
        SharedPreferences.Editor r0 = r6.edit();
        int r1 = r7.length;
        int r2 = 0;
        boolean r3 = false;
    L3:
        if (r2 >= r1) goto L8;
        String r4 = r7[r2];
        if (r6.contains(r4) == false) goto L7;
        r0.remove(r4);
        r3 = true;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r3 == false) goto L14;
        r0.apply();
        return;
    }

    static void n(boolean r0) {
        f2890b = Boolean.valueOf(r0);
    }
}
