package com.bytedance.apm.a0.k;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f1231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f1232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f1234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f1235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f1236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f1238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f1239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f1240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f1241k;

    public e() {
        this.f1232b = new CopyOnWriteArrayList();
        this.f1233c = -1;
        this.f1234d = 0;
        this.f1235e = 0;
        this.f1236f = 0;
        this.f1237g = 0;
        this.f1238h = 0;
        this.f1239i = 0;
        this.f1240j = 0;
        this.f1241k = 0;
    }

    private void m() {
        if (this.f1231a != null) goto L5;
        return;
    L5:
        BufferedReader r0 = null;
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L17
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new FileInputStream(this.f1231a), "utf-8"));     // Catch: Throwable -> L17
        int r3 = 1;
    L26:
        String r4 = r2.readLine();     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        if (r3 < 0) goto L12;
        r1.add(r4);     // Catch: Throwable -> L15
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L26
    L13:
        this.f1232b.clear();     // Catch: Throwable -> L15
        this.f1232b.addAll(r1);     // Catch: Throwable -> L15
        d.b.l.a.d.b(r2);
        return;
    L15:
        th = th;
        r0 = r2;
    L24:
        th.printStackTrace();     // Catch: Throwable -> L21
        d.b.l.a.d.b(r0);
        return;
    L21:
        th = move-exception;
        d.b.l.a.d.b(r0);
        throw th;
    L17:
        th = th;
        goto L24
    }

    private void n() {
        e this = this;
        if ((System.currentTimeMillis() - this.f1233c) >= 1000) goto L5;
        return;
    L5:
        this.f1233c = System.currentTimeMillis();
        int r1 = Process.myUid();
        m();
        if (com.bytedance.apm.util.i.b(this.f1232b) == false) goto L8;
        return;
    L8:
        Iterator<String> r2 = this.f1232b.iterator();
        long r3 = 0;
        long r5 = 0;
        long r7 = 0;
        long r9 = 0;
        long r11 = 0;
        long r13 = 0;
        long r15 = 0;
        long r19 = 0;
    L10:
        if (r2.hasNext() == false) goto L45;
        r2 = r2;
        long r23 = r15;
        String[] r4 = r2.next().split(" ");
    L41:
        int r32 = r1;
        long r34 = r5;
    L40:
        long r6 = r23;
    L42:
        r15 = r6;
    L43:
        r5 = r34;
    L44:
        r1 = r32;
        goto L10
    L13:
        if (TextUtils.equals(r4[3], "uid_tag_int") == true) goto L14;
        if (r1 != Integer.parseInt(r4[3])) goto L39;
        long r16 = Long.parseLong(r4[5]);     // Catch: Exception -> L41
        long r25 = Long.parseLong(r4[6]);     // Catch: Exception -> L41
        long r27 = Long.parseLong(r4[7]);     // Catch: Exception -> L41
        long r29 = Long.parseLong(r4[8]);     // Catch: Exception -> L41
        r32 = r1;
        if (Long.valueOf(r4[4]).longValue() != 1) goto L27;
        r34 = r5;
        if (r4[1].startsWith("rmnet_data") == false) goto L25;
        r11 = r11 + (r27 + r16);     // Catch: Exception -> L49
        r13 = r13 + (r29 + r25);     // Catch: Exception -> L49
    L30:
        if (Long.valueOf(r4[4]).longValue() == 0) goto L56;
    L38:
        r6 = r23;
        goto L42
    L56:
        if (r4[1].startsWith("rmnet_data") == false) goto L34;
        r7 = r7 + (r27 + r16);
        r15 = r23 + (r29 + r25);
        goto L43
    L34:
        r6 = r23;
        if (r4[1].startsWith("wlan") == false) goto L42;
        long r0 = r34 + (r27 + r16);
        r19 = r19 + (r29 + r25);
        r15 = r6;
        r5 = r0;
        goto L44
    L25:
        if (r4[1].startsWith("wlan") == false) goto L30;
        r9 = r9 + (r27 + r16);     // Catch: Exception -> L49
        r3 = r3 + (r29 + r25);     // Catch: Exception -> L49
        goto L30
    L27:
        r34 = r5;
        goto L30
    L39:
        r32 = r1;
        r34 = r5;
        goto L40
    L14:
        r15 = r23;
        goto L10
    L45:
        long r8 = r5;
        this.f1234d = r8;
        this.f1235e = r7;
        this.f1236f = r9;
        this.f1237g = r11;
        this.f1238h = r19;
        this.f1239i = r15;
        this.f1240j = r3;
        this.f1241k = r13;
    }

    @Override // com.bytedance.apm.a0.k.b
    public long a() {
        return b() + i();
    }

    @Override // com.bytedance.apm.a0.k.b
    public long b() {
        n();
        return this.f1235e;
    }

    @Override // com.bytedance.apm.a0.k.b
    public long c() {
        return k() + l();
    }

    @Override // com.bytedance.apm.a0.k.b
    public void d(boolean r1) {
    }

    @Override // com.bytedance.apm.a0.k.b
    public long e() {
        n();
        return this.f1239i + this.f1238h;
    }

    @Override // com.bytedance.apm.a0.k.b
    public long f() {
        n();
        return this.f1236f;
    }

    @Override // com.bytedance.apm.a0.k.b
    public long g() {
        n();
        return this.f1237g;
    }

    @Override // com.bytedance.apm.a0.k.b
    public long h() {
        return g() + f();
    }

    @Override // com.bytedance.apm.a0.k.b
    public long i() {
        n();
        return this.f1234d;
    }

    @Override // com.bytedance.apm.a0.k.b
    public void init() {
        this.f1231a = new File("/proc/net/xt_qtaguid/stats");
    }

    @Override // com.bytedance.apm.a0.k.b
    public long j() {
        n();
        return this.f1241k + this.f1240j;
    }

    public long k() {
        return b() + g();
    }

    public long l() {
        return i() + f();
    }
}
