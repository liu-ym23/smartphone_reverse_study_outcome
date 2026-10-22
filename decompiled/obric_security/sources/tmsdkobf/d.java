package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Object f137a = null;
    static Object b = null;
    static c c = null;
    static volatile long d = -1;

    class a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f138a;
        final /* synthetic */ boolean b;

        a(f r1, boolean r2) {
            this.f138a = r1;
            this.b = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            if (r3 != 0) goto L6;
            this.f138a.a();
            this.f138a.c();
            this.f138a.b();
            if (this.b == true) goto L6;
            m9.e().a(System.currentTimeMillis());
        L6:
            q8.b("Common", "[common] disconnect for Statistics Report");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s9.a();
            d.b(false);
            lf.a();
        }
    }

    static class c extends g0 implements i9.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f139a = false;

        static {
        }

        c() {
        }

        @Override // tmsdkobf.i9.c
        public void a() {
        }

        @Override // tmsdkobf.g0
        public void a(Context r1, Intent r2) {
        }

        @Override // tmsdkobf.i9.c
        public void b() {
            if (ve.a() == true) goto L5;
            return;
        L5:
            if (d.a("FirstCheck") == false) goto L9;
            d.m2375$$Nest$smb();
            return;
        }

        public synchronized void a(Context r2) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (f139a == true) goto L9;
            i9 r3 = i9.a(r2);     // Catch: Throwable -> L11
            if (r3 == null) goto L8;
            r3.a(this);     // Catch: Throwable -> L11
        L8:
            f139a = true;     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2375$$Nest$smb() {
        b();
    }

    static {
        f137a = new Object();
        b = new Object();
    }

    public static void a() {
        a(true);
    }

    private static void b() {
        q8.c("Common", "dcpr");
        Object r0 = b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((System.currentTimeMillis() - d) >= 600000) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        d = System.currentTimeMillis();     // Catch: Throwable -> L11
        ((bf) qd.a(4)).a(new b(), "xxx");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    static int c() {
        int r0 = m9.e().c();
        if (r0 > 0) goto L6;
        int r1 = a(1, 20);
        a(r1);
        return r1;
    L6:
        return r0;
    }

    public static void d() {
        s2.a();
        if (mb.d() == false) goto L5;
        return;
    L5:
        if (mb.c() == false) goto L7;
        return;
    L7:
        if (c != null) goto L12;
        c r0 = new c();
        c = r0;
        r0.a(TMSDKContext.getApplicaionContext());
        return;
    }

    public static void a(boolean r1) {
        q8.c("Common", "cpr");
        Object r2 = f137a;
        monitor-enter(r2);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (a("FirstCheck") == true) goto L7;
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L7:
        if (k9.c() == false) goto L12;
        b();     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
    }

    public static synchronized void b(boolean r1) {
        monitor-enter(d.class);
        c(r1);     // Catch: Throwable -> L7
    L5:
        monitor-exit(d.class);
    }

    private static void c(boolean r8) {
        f r0 = f.e();
        a1 r3 = new a1();
        r3.f83a = new ArrayList();
        ArrayList r1 = r0.h();
        int r4 = 0;
        if (r1 == null) goto L14;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        q4 r5 = (q4) r2.next();
        int r6 = r5.toByteArray().length;
        if (r6 <= 1024000) goto L10;
        f.b(r5.f432a);
    L10:
        int r7 = r6 + r4;
        if (r7 < 1024000) goto L12;
        r2.remove();
        goto L6
    L12:
        r3.f83a.add(r5);
        r4 = r7;
    L14:
        ArrayList r9 = r0.j();
        if (r9 == null) goto L26;
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L26;
        q4 r11 = (q4) r10.next();
        int r12 = r11.toByteArray().length;
        if (r12 <= 1024000) goto L22;
        f.d(r11.f432a);
    L22:
        int r13 = r12 + r4;
        if (r13 < 1024000) goto L24;
        r10.remove();
        goto L18
    L24:
        r3.f83a.add(r11);
        r4 = r13;
    L26:
        ArrayList r14 = r0.i();
        if (r14 == null) goto L38;
        Iterator r15 = r14.iterator();
    L30:
        if (r15.hasNext() == false) goto L38;
        q4 r16 = (q4) r15.next();
        int r17 = r16.toByteArray().length;
        if (r17 <= 1024000) goto L34;
        f.c(r16.f432a);
    L34:
        int r18 = r17 + r4;
        if (r18 < 1024000) goto L36;
        r15.remove();
        goto L30
    L36:
        r3.f83a.add(r16);
        r4 = r18;
    L38:
        za r19 = ve.e();
        q8.a("Common", "[common] connect for Statistics Report");
        r19.a(3651, r3, null, 0, new a(r0, r8));
    }

    static int a(int r7, int r8) {
        int r9 = r8 - r7;
        if (r9 >= 0) goto L11;
        return -1;
    L11:
        long r0 = Long.parseLong(la.b(TMSDKContext.getApplicaionContext()));     // Catch: Throwable -> L8
    L9:
        Random r2 = new Random();
        r2.setSeed(((System.currentTimeMillis() + ((long) System.identityHashCode(r2))) + ((long) System.identityHashCode(m9.e()))) + r0);
        int r10 = ((int) (r2.nextDouble() * ((double) r9))) + r7;
        int r11 = (int) (r2.nextDouble() * 60.0d);
        int r12 = (r10 * 3600) + (r11 * 60);
        return r12 + ((int) (r2.nextDouble() * 60.0d));
    L8:
        r0 = 0;
        goto L9
    }

    static boolean a(String r15) {
        long r0 = System.currentTimeMillis();
        long r2 = m9.e().b();
        if (r2 != 0) goto L7;
        m9.e().a(System.currentTimeMillis());
        return false;
    L7:
        if (r0 <= r2) goto L22;
        if ((r0 - r2) >= 90000000) goto L24;
        Calendar r16 = Calendar.getInstance();
        r16.set(11, 0);
        r16.set(12, 0);
        r16.set(13, 0);
        int r8 = c();
        long r9 = r16.getTimeInMillis() + (((long) r8) * 1000);
        if (r9 <= r0) goto L15;
        r9 = r9 - 86400000;
    L15:
        if (r2 > r9) goto L25;
        int r17 = Calendar.getInstance().get(11);
        int r1 = Calendar.getInstance().get(12);
        if (r17 != 8) goto L24;
        if (r1 >= 3) goto L24;
        return false;
    L25:
        return false;
    L24:
        return true;
    L22:
        if (Math.abs(r0 - r2) >= 90000000) goto L24;
        return false;
    }

    public static void a(int r1) {
        m9.e().a(r1);
    }
}
