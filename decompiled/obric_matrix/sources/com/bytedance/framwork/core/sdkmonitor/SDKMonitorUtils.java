package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKMonitorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, k> f4758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f4759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, List<String>> f4760c;

    static {
        f4758a = new ConcurrentHashMap();
        f4759b = new ConcurrentHashMap();
        f4760c = new ConcurrentHashMap();
    }

    public SDKMonitorUtils() {
    }

    public static List<String> a(List<String> r4) {
        LinkedList r0 = new LinkedList();
        Iterator<String> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        r0.add(("https://" + new URL(r5.next()).getHost()) + "/monitor/collect/");     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    public static k b(@NonNull String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (f4758a.get(r3) != null) goto L17;
        monitor-enter(SDKMonitorUtils.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f4758a.get(r3) != null) goto L11;
        k r1 = new k(r3);     // Catch: Throwable -> L13
        f4758a.put(r3, r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(SDKMonitorUtils.class);     // Catch: Throwable -> L13
    L17:
        return f4758a.get(r3);
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static synchronized void c(@NonNull Context r3, @NonNull String r4, @NonNull JSONObject r5, k.m r6) {
        monitor-enter(SDKMonitorUtils.class);
        if (r3 != null) goto L29;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L29:
    L26:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (r5 == null) goto L23;
        if (f4758a.get(r4) != null) goto L13;
    L16:
        k r1 = f4758a.get(r4);     // Catch: Throwable -> L26
        if (r1 != null) goto L19;
        r1 = new k(r4);     // Catch: Throwable -> L26
        f4758a.put(r4, r1);     // Catch: Throwable -> L26
    L19:
        r1.e0(f4760c.remove(r4));     // Catch: Throwable -> L26
        r1.f0(f4759b.remove(r4));     // Catch: Throwable -> L26
        r1.N(r3, r5, r6);     // Catch: Throwable -> L26
        monitor-exit(SDKMonitorUtils.class);
        return;
    L13:
        if (f4758a.get(r4).R() == false) goto L16;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L23:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L26
    L25:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L26
    }

    public static synchronized void d(@NonNull String r5, @NonNull List<String> r6) {
        monitor-enter(SDKMonitorUtils.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L20:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (g.a(r6) == true) goto L20;
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L22
        Iterator<String> r7 = r6.iterator();     // Catch: Throwable -> L22
    L11:
        if (r7.hasNext() == false) goto L17;
        r1.add(("https://" + new URL(r7.next()).getHost()) + "/monitor/appmonitor/v3/settings");     // Catch: MalformedURLException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L11
    L17:
        f4760c.put(r5, r1);     // Catch: Throwable -> L22
        monitor-exit(SDKMonitorUtils.class);
    }

    public static synchronized void e(@NonNull String r2, @NonNull List<String> r3) {
        monitor-enter(SDKMonitorUtils.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L12:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (g.a(r3) == true) goto L12;
        f4759b.put(r2, a(r3));     // Catch: Throwable -> L14
        monitor-exit(SDKMonitorUtils.class);
    }
}
