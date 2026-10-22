package com.bytedance.apm.a0.k;

import androidx.core.location.LocationRequestCompat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, i> f1208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, i> f1209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1214h;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f1215a = null;

        static {
            f1215a = new c();
        }

        static /* synthetic */ c a() {
            return f1215a;
        }
    }

    public c() {
        this.f1210d = 50;
        this.f1211e = 20;
        this.f1212f = 50;
        this.f1213g = Math.min(3, 50 / 2);
        this.f1214h = 0;
    }

    public static c d() {
        return a.a();
    }

    public synchronized void a(long r11, String r13, String r14) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.f1209c != null) goto L7;
        this.f1209c = new HashMap();     // Catch: Throwable -> L44
    L7:
        if (this.f1209c.containsKey(r13) == false) goto L11;
        i r12 = this.f1209c.get(r13);     // Catch: Throwable -> L44
        r12.f1254i++;     // Catch: Throwable -> L44
        r12.f1255j = System.currentTimeMillis();     // Catch: Throwable -> L44
        int r15 = r12.f1254i;     // Catch: Throwable -> L44
        if (r15 <= this.f1214h) goto L42;
        this.f1214h = r15;     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L11:
        Map<String, i> r0 = this.f1208b;     // Catch: Throwable -> L44
        if (r0 == null) goto L41;
        boolean r1 = r0.containsKey(r13);     // Catch: Throwable -> L44
        long r2 = LocationRequestCompat.PASSIVE_INTERVAL;
        String r3 = null;
        if (r1 == false) goto L31;
        i r16 = this.f1208b.get(r13);     // Catch: Throwable -> L44
        int r17 = r16.f1254i;     // Catch: Throwable -> L44
        r16.f1254i = r17 + 1;     // Catch: Throwable -> L44
        r16.f1255j = System.currentTimeMillis();     // Catch: Throwable -> L44
        if (r17 <= this.f1213g) goto L42;
        this.f1208b.remove(r13);     // Catch: Throwable -> L44
        if (this.f1209c.size() < this.f1211e) goto L29;
        long r4 = this.f1207a + ((System.currentTimeMillis() - this.f1207a) / 2);     // Catch: Throwable -> L44
        Iterator<Map.Entry<String, i>> r18 = this.f1209c.entrySet().iterator();     // Catch: Throwable -> L44
    L21:
        if (r18.hasNext() == false) goto L27;
        Map.Entry<String, i> r19 = r18.next();     // Catch: Throwable -> L44
        if (r19.getValue().f1255j >= r4) goto L21;
        if (r19.getValue().f1254i >= r2) goto L21;
        long r5 = r19.getValue().f1254i;     // Catch: Throwable -> L44
        r3 = r19.getValue().f1251f;     // Catch: Throwable -> L44
        r2 = r5;
        goto L21
    L27:
        if (r3 == null) goto L29;
        this.f1209c.remove(r3);     // Catch: Throwable -> L44
    L29:
        this.f1209c.put(r13, r16);     // Catch: Throwable -> L44
        goto L42
    L31:
        if (this.f1208b.size() < this.f1210d) goto L40;
        Iterator<Map.Entry<String, i>> r6 = this.f1208b.entrySet().iterator();     // Catch: Throwable -> L44
    L34:
        if (r6.hasNext() == false) goto L38;
        Map.Entry<String, i> r7 = r6.next();     // Catch: Throwable -> L44
        if (r7.getValue().f1255j >= r2) goto L34;
        r2 = r7.getValue().f1255j;     // Catch: Throwable -> L44
        r3 = r7.getValue().f1251f;     // Catch: Throwable -> L44
        goto L34
    L38:
        if (r3 == null) goto L40;
        this.f1208b.remove(r3);     // Catch: Throwable -> L44
    L40:
        this.f1208b.put(r13, new i(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    L41:
        HashMap r8 = new HashMap();     // Catch: Throwable -> L44
        this.f1208b = r8;     // Catch: Throwable -> L44
        r8.put(r13, new i(r13, r11, r14));     // Catch: Throwable -> L44
        goto L42
    }

    public void b() {
        this.f1207a = 0;
        this.f1214h = 0;
        Map<String, i> r0 = this.f1208b;
        if (r0 == null) goto L5;
        r0.clear();
        this.f1208b = null;
    L5:
        Map<String, i> r1 = this.f1209c;
        if (r1 == null) goto L9;
        r1.clear();
        this.f1209c = null;
        return;
    }

    public synchronized Map<String, i> c() {
        monitor-enter(this);
        Map<String, i> r0 = this.f1209c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int e() {
        return this.f1214h;
    }
}
