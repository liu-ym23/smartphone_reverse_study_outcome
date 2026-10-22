package com.bytedance.mpaas.monitor;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfo;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.r.b;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f5260a;

    /* JADX INFO: renamed from: com.bytedance.mpaas.monitor.a$a, reason: collision with other inner class name */
    class RunnableC0169a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Handler f5261f;

        RunnableC0169a(Handler r1) {
            this.f5261f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("moduleHookUpload", "response:" + a.c("https://cloudapi.bytedance.net/faas/services/ttlxeq/invoke/MultiUpload", a.b()));
            this.f5261f.getLooper().quit();
        }
    }

    static {
        f5260a = new ArrayList();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static SharedPreferences a(Application r0, String r1, int r2) {
        return b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ String b() {
        return f();
    }

    static /* synthetic */ String c(String r0, String r1) {
        return g(r0, r1);
    }

    public static synchronized void d(String r2) {
        monitor-enter(a.class);
        f5260a.add(r2);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static long e() {
        return a(com.bytedance.mpaas.app.a.b(), "module_hook_upload", 0).getLong("last_upload_time", 0);
    }

    private static synchronized String f() {
        monitor-enter(a.class);
        String r1 = new String();     // Catch: Throwable -> L16
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L11 Throwable -> L16
        r2.put("user_id", "hook");     // Catch: Exception -> L11 Throwable -> L16
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L11 Throwable -> L16
        Iterator<String> r4 = f5260a.iterator();     // Catch: Exception -> L11 Throwable -> L16
    L7:
        if (r4.hasNext() == false) goto L9;
        String r5 = r4.next();     // Catch: Exception -> L11 Throwable -> L16
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L11 Throwable -> L16
        r6.put("name", "module_hook");     // Catch: Exception -> L11 Throwable -> L16
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L11 Throwable -> L16
        r7.put(IBdInstall.PARAM_APP_ID, AppInfo.getInstatnce().getAid());     // Catch: Exception -> L11 Throwable -> L16
        r7.put("hook_name", r5);     // Catch: Exception -> L11 Throwable -> L16
        r7.put(WsConstants.KEY_PLATFORM, "android");     // Catch: Exception -> L11 Throwable -> L16
        r6.put("params", r7);     // Catch: Exception -> L11 Throwable -> L16
        r3.put(r6);     // Catch: Exception -> L11 Throwable -> L16
        goto L7
    L9:
        r2.put("events", r3);     // Catch: Exception -> L11 Throwable -> L16
        r1 = r2.toString();     // Catch: Exception -> L11 Throwable -> L16
    L13:
        Log.i("moduleHookUpload", "requestBody:" + r1);     // Catch: Throwable -> L16
        monitor-exit(a.class);
        return r1;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private static String g(String r5, String r6) {
        StringBuffer r0 = new StringBuffer();
        HttpURLConnection r1 = null;
        HttpURLConnection r7 = (HttpURLConnection) new URL(r5).openConnection();     // Catch: Throwable -> L18 Exception -> L20
        r7.setRequestMethod("POST");     // Catch: Throwable -> L14 Exception -> L16
        r7.setRequestProperty(INetworkApi.CONTENT_TYPE, "application/json;charset=UTF-8");     // Catch: Throwable -> L14 Exception -> L16
        r7.setDoOutput(true);     // Catch: Throwable -> L14 Exception -> L16
        r7.setUseCaches(false);     // Catch: Throwable -> L14 Exception -> L16
        OutputStream r2 = r7.getOutputStream();     // Catch: Throwable -> L14 Exception -> L16
        r2.write(r6.getBytes());     // Catch: Throwable -> L14 Exception -> L16
        r2.flush();     // Catch: Throwable -> L14 Exception -> L16
        if (r7.getResponseCode() != 200) goto L11;
        h(System.currentTimeMillis());     // Catch: Throwable -> L14 Exception -> L16
        InputStream r8 = r7.getInputStream();     // Catch: Throwable -> L14 Exception -> L16
        BufferedReader r3 = new BufferedReader(new InputStreamReader(r8, "UTF-8"));     // Catch: Throwable -> L14 Exception -> L16
    L7:
        String r4 = r3.readLine();     // Catch: Throwable -> L14 Exception -> L16
        if (r4 == null) goto L10;
        r0.append(r4);     // Catch: Throwable -> L14 Exception -> L16
        goto L7
    L10:
        r8.close();     // Catch: Throwable -> L14 Exception -> L16
    L11:
        r2.close();     // Catch: Throwable -> L14 Exception -> L16
        if (r7 == null) goto L25;
        r7.disconnect();
    L25:
        return r0.toString();
    L16:
        e = e;
        r1 = r7;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r1 == null) goto L25;
        r1.disconnect();
    L14:
        th = th;
        r1 = r7;
    L26:
        if (r1 == null) goto L28;
        r1.disconnect();
    L28:
        throw th;
    L20:
        e = e;
    L18:
        th = th;
        goto L26
    }

    private static void h(long r3) {
        SharedPreferences.Editor r0 = a(com.bytedance.mpaas.app.a.b(), "module_hook_upload", 0).edit();
        r0.putLong("last_upload_time", r3);
        r0.commit();
    }

    public static void i() {
        if (AppInfo.getInstatnce().isApkDebuggable() == true) goto L6;
        return;
    L6:
        if ((System.currentTimeMillis() - e()) <= 86400000) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        HandlerThread r1 = new HandlerThread("uploadHookThread");
        r1.start();
        Handler r2 = new Handler(r1.getLooper());
        r2.post(new RunnableC0169a(r2));
        return;
    L12:
        return;
    L8:
        r0 = false;
        goto L9
    }
}
