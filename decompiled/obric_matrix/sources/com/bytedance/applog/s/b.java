package com.bytedance.applog.s;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f2367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Map<String, List<Set<String>>> f2368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Map<String, List<Map<String, Object>>> f2369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String f2370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f2371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String[] f2372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f2373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.bytedance.applog.y.a f2374l;
    int m;
    String n;
    String o;
    String p;

    public b() {
        this.f2372j = null;
        this.f2373k = false;
        this.m = 0;
    }

    public void a(int r1) {
        this.f2373k = com.bytedance.applog.v.a.c(r1);
    }

    public com.bytedance.applog.y.a b() {
        return this.f2374l;
    }

    public long c() {
        return this.f2367e;
    }

    public String d() {
        if (this.m != 0) goto L5;
    L30:
        return null;
    L5:
        if (TextUtils.isEmpty(this.n) == true) goto L30;
        if (TextUtils.isEmpty(this.p) == false) goto L29;
        if (this.n.startsWith("https://") == true) goto L12;
    L14:
        String r0 = null;
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L20;
        this.p = null;
        return null;
    L20:
        if (TextUtils.isEmpty(this.o) == false) goto L22;
    L26:
        String r1 = "/service/2/app_log/";
    L27:
        this.p = r0 + r1;
        goto L29
    L22:
        if (this.o.startsWith("/") == false) goto L26;
        if (this.o.endsWith("/") == false) goto L26;
        r1 = this.o;
        goto L27
    L12:
        if (this.n.endsWith("/") == true) goto L14;
        r0 = this.n;
    L29:
        return this.p;
    }

    public int e() {
        return this.f2364b;
    }

    public int f() {
        return this.f2363a;
    }

    public String[] g(String[] r9, String r10) {
        if (TextUtils.isEmpty(this.f2370h) == false) goto L8;
        if (TextUtils.isEmpty(this.f2371i) == false) goto L8;
        return null;
    L8:
        if (this.f2372j != null) goto L32;
        this.f2372j = new String[r9.length];
        int r2 = 0;
    L11:
        if (r2 >= r9.length) goto L32;
        int r3 = r9[r2].indexOf(r10);
        if (r3 <= 0) goto L29;
        String r4 = r9[r2].substring(0, r3);
        String r5 = r9[r2].substring(r3);
        if (TextUtils.isEmpty(this.f2370h) == true) goto L22;
        if (this.f2370h.startsWith("https://") == false) goto L22;
        if (this.f2370h.endsWith("/") == true) goto L22;
        r4 = this.f2370h;
    L22:
        if (TextUtils.isEmpty(this.f2371i) == false) goto L24;
    L28:
        this.f2372j[r2] = r4 + r5;
    L30:
        r2 = r2 + 1;
        goto L11
    L24:
        if (this.f2371i.startsWith("/") == false) goto L28;
        if (this.f2371i.endsWith("/") == false) goto L28;
        r5 = this.f2371i;
        goto L28
    L29:
        this.f2372j[r2] = r9[r2];
    L32:
        if (this.f2373k == false) goto L34;
        return null;
    L34:
        String[] r8 = this.f2372j;
        if (r8 != null) goto L37;
    L39:
        return null;
    L37:
        if (r8.length <= 0) goto L39;
        return r8;
    }

    public int h() {
        return this.f2365c;
    }
}
