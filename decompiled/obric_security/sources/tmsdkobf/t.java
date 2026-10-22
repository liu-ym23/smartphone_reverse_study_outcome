package tmsdkobf;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public class t {
    private static volatile t c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f518a;
    private volatile u b;

    class a implements d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f519a;
        final /* synthetic */ t b;

        a(t r1, CountDownLatch r2) {
            this.b = r1;
            this.f519a = r2;
        }

        @Override // tmsdkobf.d6
        public void a(String r1, String r2, int r3, String r4, String r5) {
            t.m2441$$Nest$fputa(this.b, 262);
            CountDownLatch r0 = this.f519a;
            if (r0 == null) goto L6;
            r0.countDown();
            return;
        }

        @Override // tmsdkobf.d6
        public void a() {
            q8.b("ArpAdapt", "startArp ————> stop");
            t.m2441$$Nest$fputa(this.b, 263);
            CountDownLatch r2 = this.f519a;
            if (r2 == null) goto L6;
            r2.countDown();
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputa, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2441$$Nest$fputa(t r0, int r1) {
        r0.f518a = r1;
    }

    private t() {
        this.f518a = 261;
    }

    public static t a() {
        if (c != null) goto L15;
        monitor-enter(t.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new t();     // Catch: Throwable -> L11
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public void b() {
        if (this.b == null) goto L6;
        q8.c("ArpAdapt", "touch > mArpShield.stop()");
        this.b.e();
        this.b = null;
        return;
    }

    public synchronized int a(String r7, long r8) {
        monitor-enter(this);
        q8.b("ArpAdapt", "startArp ————> start");     // Catch: Throwable -> L14
        this.f518a = 261;     // Catch: Throwable -> L14
        CountDownLatch r1 = new CountDownLatch(1);     // Catch: Throwable -> L14
        this.b = new u(TMSDKContext.getApplicaionContext(), r7, new a(this, r1));     // Catch: Throwable -> L14
        this.b.a(r8);     // Catch: Throwable -> L14
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L14
        this.b.d();     // Catch: Throwable -> L14
        r1.await(r8, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
        r1.countDown();     // Catch: Throwable -> L9
        if (this.b == null) goto L11;
        this.b.f();     // Catch: Throwable -> L9
    L11:
        q8.a("ArpAdapt", "[mWifiBssid : " + r7 + "][maxOverTime : " + r8 + "]sendArpCheck result : " + this.f518a + "] exec time : " + (System.currentTimeMillis() - r2));     // Catch: Throwable -> L14
        q8.b("ArpAdapt", "startArp ————> end");     // Catch: Throwable -> L14
        int r9 = this.f518a;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r9;
    L9:
        th = move-exception;
        q8.a("ArpAdapt", "wait CountDownLatch (Throwable)", th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
