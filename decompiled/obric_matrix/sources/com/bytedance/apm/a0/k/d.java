package com.bytedance.apm.a0.k;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm.a0.k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long[] f1217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile long[] f1218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f1219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f1220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile long f1221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f1222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile long f1223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile long f1224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile long f1225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f1226k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile long f1227l;
    private volatile boolean m;
    private NetworkStatsManager n;
    private int o;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f1228f;

        a(d r1) {
            this.f1228f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.k(this.f1228f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f1230g;

        b(d r1, boolean r2) {
            this.f1230g = r1;
            this.f1229f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.l(this.f1230g);
            d.m(this.f1230g, !this.f1229f);
        }
    }

    public d() {
        this.f1216a = false;
        this.f1219d = 0;
        this.f1220e = 0;
        this.f1221f = 0;
        this.f1222g = 0;
        this.f1223h = 0;
        this.f1224i = 0;
        this.f1225j = 0;
        this.f1226k = 0;
        this.f1227l = -1;
        this.m = true;
        this.o = -1;
    }

    static /* synthetic */ void k(d r0) {
        r0.r();
    }

    static /* synthetic */ void l(d r0) {
        r0.s();
    }

    static /* synthetic */ boolean m(d r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    private int n(@NonNull Context r3) {
        if (this.o != (-1)) goto L12;
        PackageManager r0 = r3.getApplicationContext().getPackageManager();
        PackageInfo r4 = r0.getPackageInfo(r3.getApplicationContext().getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r4 == null) goto L12;
        this.o = r4.applicationInfo.uid;     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        return this.o;
    }

    @RequiresApi(api = 23)
    private long[] p(long r17, long r19, int r21) {
        Context r2 = com.bytedance.apm.d.h();
        if (this.n != null) goto L6;
        this.n = (NetworkStatsManager) r2.getApplicationContext().getSystemService("netstats");
    L6:
        if (this.n == null) goto L8;
        NetworkStats r4 = null;
        NetworkStats.Bucket r5 = new NetworkStats.Bucket();
        long r6 = 0;
        r4 = this.n.querySummary(r21, null, r17, r19);     // Catch: Exception -> L12
    L14:
        long r8 = 0;
        long r10 = 0;
        long r12 = 0;
    L15:
        if (r4 == null) goto L21;
        if (r4.hasNextBucket() == false) goto L21;
        r4.getNextBucket(r5);
        if (n(r2) != r5.getUid()) goto L15;
        r6 = r6 + r5.getRxBytes();
        r8 = r8 + r5.getTxBytes();
        r10 = r10 + r5.getRxPackets();
        r12 = r12 + r5.getTxPackets();
    L21:
        if (r4 == null) goto L24;
        r4.close();
    L24:
        return new long[]{r6 + r8, r10 + r12};
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L8:
        return new long[]{0, 0};
    }

    @RequiresApi(api = 23)
    @WorkerThread
    private void r() {
        if (this.f1216a == false) goto L5;
        return;
    L5:
        this.f1216a = true;
        this.f1217b = p(0, 4611686018427387903L, 1);
        this.f1218c = p(0, 4611686018427387903L, 0);
        this.f1227l = SystemClock.elapsedRealtime();
        if (com.bytedance.apm.d.C() == false) goto L9;
        d.b.b.o.m.b.a("NewTrafficStatisticsImp", "initTrafficData: mTotalWifiBytes:" + this.f1217b[0] + " mTotalWifiPackets:" + this.f1217b[1] + " mTotalMobileBytes:" + this.f1218c[0] + " mTotalMobilePackets:" + this.f1218c[1]);
        return;
    }

    @RequiresApi(api = 23)
    private void s() {
        long r7 = SystemClock.elapsedRealtime();
        if ((r7 - this.f1227l) >= 1000) goto L5;
        return;
    L5:
        if (this.f1227l == (-1)) goto L21;
        long[] r9 = p(0, 4611686018427387903L, 1);
        long[] r0 = p(0, 4611686018427387903L, 0);
        long r2 = r0[0] - this.f1218c[0];
        long r10 = r0[1] - this.f1218c[1];
        this.f1218c = r0;
        long r12 = r9[0] - this.f1217b[0];
        long r14 = r9[1] - this.f1217b[1];
        this.f1217b = r9;
        if (com.bytedance.apm.d.C() == false) goto L10;
        String r1 = "NewTrafficStatisticsImp";
        d.b.b.o.m.b.a(r1, "mTotalWifiBytes:" + this.f1217b[0] + " mTotalWifiPackets:" + this.f1217b[1] + " mTotalMobileBytes:" + this.f1218c[0] + " mTotalMobilePackets:" + this.f1218c[1]);
    L12:
        if (this.m == false) goto L14;
        this.f1222g += r2;
        this.f1226k += r10;
        this.f1221f += r12;
        this.f1225j += r14;
    L16:
        if (com.bytedance.apm.d.C() == false) goto L18;
        d.b.b.o.m.b.a(r1, "periodWifiBytes" + r12 + " periodMobileBytes:" + r2 + " mMobileBackBytes:" + this.f1220e + " mWifiBackBytes:" + this.f1219d);
    L18:
        this.f1227l = r7;
        return;
    L14:
        this.f1220e += r2;
        this.f1224i += r10;
        this.f1219d += r12;
        this.f1223h += r14;
        goto L16
    L10:
        r1 = "NewTrafficStatisticsImp";
        goto L12
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long a() {
        s();
        return this.f1220e + this.f1219d;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long b() {
        s();
        return this.f1220e;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long c() {
        return o() + q();
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public void d(boolean r3) {
        com.bytedance.apm.f0.b.f().d(new b(this, r3));
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long e() {
        s();
        return this.f1224i + this.f1223h;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long f() {
        s();
        return this.f1221f;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long g() {
        s();
        return this.f1222g;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long h() {
        s();
        return this.f1222g + this.f1221f;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long i() {
        s();
        return this.f1219d;
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public void init() {
        if (com.bytedance.apm.f0.b.f().g() == false) goto L5;
        r();
        return;
    L5:
        com.bytedance.apm.f0.b.f().i(new a(this));
    }

    @Override // com.bytedance.apm.a0.k.b
    @RequiresApi(api = 23)
    public long j() {
        s();
        return this.f1226k + this.f1225j;
    }

    @RequiresApi(api = 23)
    public long o() {
        s();
        return this.f1220e + this.f1222g;
    }

    @RequiresApi(api = 23)
    public long q() {
        s();
        return this.f1219d + this.f1221f;
    }
}
