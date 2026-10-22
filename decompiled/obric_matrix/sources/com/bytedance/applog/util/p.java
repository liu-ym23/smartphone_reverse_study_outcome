package com.bytedance.applog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2434a;

    static {
    }

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
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static JSONObject c(JSONObject r3, JSONObject r4) {
        Iterator<String> r0 = r4.keys();     // Catch: JSONException -> L7
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = r0.next();     // Catch: JSONException -> L7
        r3.put(r1, r4.opt(r1));     // Catch: JSONException -> L7
    L9:
        return r3;
    L7:
        e = move-exception;
        n.i(e);
        goto L9
    }

    public static JSONObject d(JSONObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Iterator<String> r1 = r3.keys();
        if (r1 != null) goto L8;
        return null;
    L8:
        LinkedList r0 = new LinkedList();
    L10:
        if (r1.hasNext() == false) goto L17;
        r0.add(r1.next());
        goto L10
    L17:
        return new JSONObject(r3, (String[]) r0.toArray(new String[0]));
    L14:
        e = move-exception;
        n.c("copyJson", e);
        return r3;
    }

    public static void e(SQLiteDatabase r0) {
        if (r0 == null) goto L10;
        r0.endTransaction();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.i(th);
        return;
    }

    public static boolean f(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static String g(Context r3) {
        String r0 = f2434a;
        if (TextUtils.isEmpty(r0) == true) goto L17;
        return r0;
    L17:
        int r1 = Process.myPid();     // Catch: Exception -> L16
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L16
    L7:
        if (r4.hasNext() == false) goto L11;
        ActivityManager.RunningAppProcessInfo r2 = r4.next();     // Catch: Exception -> L16
        if (r2.pid != r1) goto L7;
        f2434a = r2.processName;     // Catch: Exception -> L16
    L11:
        f2434a = h();
        if (n.f2430b == false) goto L15;
        n.b("getProcessName, " + f2434a, null);
    L15:
        return f2434a;
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

    public static boolean i(String r0) {
        Class.forName(r0);     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean j(JSONObject r0, JSONObject r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        return r0.toString().equals(r1.toString());
    L7:
        return f(r0, r1);
    }

    public static String k(Map<String, String> r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.isEmpty() == true) goto L17;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L13
        Iterator<Map.Entry<String, String>> r4 = r3.entrySet().iterator();     // Catch: Throwable -> L13
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r4.next();     // Catch: Throwable -> L13
        r0.put(r1.getKey(), r1.getValue());     // Catch: Throwable -> L13
        goto L7
    L9:
        return r0.toString();
    L18:
        return null;
    L17:
        return null;
    }

    public static long l(JSONObject r2, String r3) {
        if (r2 != null) goto L9;
        return 0;
    L9:
        return Long.parseLong(r2.optString(r3));
    L11:
        return 0;
    }
}
