package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class ll {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f339a;
    private z6 b;
    private e c;
    private f d;
    private pc e;
    private PowerManager f;
    private String g;
    private String h;
    private String i;
    private gi j;
    private sh k;
    private AtomicInteger l;
    private boolean m;
    private Handler n;
    private boolean o;
    private Runnable p;

    class a extends ti {
        final /* synthetic */ ll b;

        a(ll r1) {
            this.b = r1;
        }

        @Override // tmsdkobf.ti
        public void a() {
            cj.a("TMSDK_SK", "mKeepAliveRunnable-doRun");
            ll.a(this.b).sendEmptyMessageDelayed(10, 5000);
        }
    }

    class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ll f340a;

        b(ll r1, Looper r2) {
            this.f340a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            int r3 = r2.what;
            if (r3 == 10) goto L21;
            if (r3 != 1) goto L7;
            ll.g(this.f340a);
            ll.h(this.f340a).e();
            return;
        L7:
            if (r3 != 2) goto L9;
            this.f340a.n();
            return;
        L9:
            if (r3 != 3) goto L11;
            ll.i(this.f340a);
            return;
        L11:
            if (r3 != 4) goto L13;
            ll.b(this.f340a);
            return;
        L13:
            if (r3 != 5) goto L30;
            ll.f(this.f340a);
            return;
        L30:
            return;
        L21:
            if (ll.j(this.f340a) == false) goto L29;
            this.f340a.n();
            ll.a(this.f340a, false);
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f341a;
        final /* synthetic */ ll b;

        c(ll r1, int r2) {
            this.b = r1;
            this.f341a = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r0 = ((long) this.b.g().e) * 1000;
            long r2 = this.f341a;
            if (r0 >= r2) goto L5;
            r0 = r2;
        L5:
            cj.a("TMSDK_SK", "extendConnectOnSend, mIsKeepAfSendFlagHasSet:[" + ll.j(this.b) + "]");
            if (ll.j(this.b) == true) goto L8;
            ll.g(this.b);
            ll.a(this.b, true);
        L8:
            ll.a(this.b).removeMessages(10);
            ll.l(this.b).a(ll.k(this.b));
            ll.l(this.b).a(ll.k(this.b), r0, ll.c(this.b));
        }
    }

    class d implements Comparator {
        d() {
        }

        public int a(di r1, di r2) {
            return r1.f157a - r2.f157a;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r1, Object r2) {
            return a((di) r1, (di) r2);
        }
    }

    public interface e {
        ql a();

        void c();

        void d();

        void e();
    }

    private class f extends bj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ll f342a;

        private f(ll r1) {
            this.f342a = r1;
        }

        @Override // tmsdkobf.bj
        public void a(Context r2, Intent r3) {
            String r4 = r3.getAction();
            String r5 = r3.getPackage();
            if (r4 == null) goto L15;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r5.equals(rd.e().getPackageName()) == true) goto L9;
            return;
        L9:
            if (r4.equals(ll.d(this.f342a)) == false) goto L12;
            ll.a(this.f342a).sendEmptyMessage(3);
            return;
        L12:
            if (r4.equals(ll.e(this.f342a)) == false) goto L18;
            ll.a(this.f342a).sendEmptyMessage(2);
            return;
        L18:
            return;
        }

        /* synthetic */ f(ll r1, a r2) {
            this(r1);
        }
    }

    public ll(z6 r3, e r4) {
        this.l = new AtomicInteger(0);
        this.m = false;
        this.o = false;
        this.p = new a(this);
        this.f339a = rd.e();
        this.b = r3;
        this.c = r4;
        ql r5 = r4.a();
        sh r0 = new sh(r5.f460a.B);
        this.k = r0;
        this.j = new gi(r0);
        this.f = (PowerManager) this.f339a.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);     // Catch: Throwable -> L6
    L4:
        String r6 = r5.j();
        this.g = r6 + "_action.ka.cy";
        this.h = r6 + "_action.ka.cl";
        this.i = r6 + "_action.ka.ase";
        this.n = new b(this, r5.h());
    }

    static /* synthetic */ Handler a(ll r0) {
        return r0.n;
    }

    static /* synthetic */ void b(ll r0) {
        r0.b();
    }

    private static final int c(int r0) {
        return r0 * 60;
    }

    static /* synthetic */ String d(ll r0) {
        return r0.g;
    }

    static /* synthetic */ String e(ll r0) {
        return r0.h;
    }

    static /* synthetic */ void f(ll r0) {
        r0.c();
    }

    static /* synthetic */ void g(ll r0) {
        r0.j();
    }

    static /* synthetic */ e h(ll r0) {
        return r0.c;
    }

    static /* synthetic */ void i(ll r0) {
        r0.d();
    }

    static /* synthetic */ boolean j(ll r0) {
        return r0.m;
    }

    static /* synthetic */ String k(ll r0) {
        return r0.i;
    }

    static /* synthetic */ gi l(ll r0) {
        return r0.j;
    }

    public void m() {
        this.n.removeMessages(5);
        this.n.sendEmptyMessageDelayed(5, 100);
    }

    void n() {
        int r0 = this.l.decrementAndGet();
        cj.a("TMSDK_SK", "tryCloseConnectionAsyn, refCount:[" + r0 + "]");
        if (r0 > 0) goto L6;
        this.l.set(0);
        this.c.d();
        return;
    }

    static /* synthetic */ boolean a(ll r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    private void b() {
        cj.a("TMSDK_SK", "doStartKeepAlive");
        if (this.o == false) goto L7;
        this.c.c();
        return;
    L7:
        if (this.d != null) goto L13;
        this.d = new f(this, null);
        IntentFilter r4 = new IntentFilter();
        r4.addAction(this.h);
        r4.addAction(this.g);
        if (Build.VERSION.SDK_INT < 33) goto L12;
        this.f339a.registerReceiver(this.d, r4, rd.f(), null, 4);     // Catch: Throwable -> L15
    L16:
        goto L13
    L12:
        this.f339a.registerReceiver(this.d, r4, rd.f(), null);     // Catch: Throwable -> L15
    L13:
        this.n.sendEmptyMessage(3);
        this.o = true;
        boolean r8 = this.c.a().f460a.C;
    }

    static /* synthetic */ Runnable c(ll r0) {
        return r0.p;
    }

    private void d() {
        di r0 = f();
        if (r0 != null) goto L5;
        return;
    L5:
        a();
        if (a("execRule") == false) goto L8;
        this.n.sendEmptyMessage(1);
        this.k.a(this.f339a, this.h, r0.b * 1000);
    L8:
        this.k.a(this.f339a, this.g, (r0.b + r0.c) * 1000);
    }

    private static ArrayList e() {
        ArrayList r0 = new ArrayList();
        di r1 = new di();
        r1.f157a = b(0);
        r1.b = c(10);
        r1.c = c(60);
        r0.add(r1);
        di r2 = new di();
        r2.f157a = b(8);
        r2.b = c(15);
        r2.c = c(15);
        r0.add(r2);
        di r3 = new di();
        r3.f157a = b(15);
        r3.b = c(10);
        r3.c = c(20);
        r0.add(r3);
        return r0;
    }

    private di f() {
        pc r0 = g();
        if (r0 == null) goto L14;
        ArrayList r1 = r0.d;
        if (r1 != null) goto L7;
        return null;
    L7:
        if (r1.size() <= 0) goto L19;
        int r4 = i();
        int r2 = r0.d.size() - 1;
    L9:
        if (r2 < 0) goto L20;
        di r3 = (di) r0.d.get(r2);
        if (r3.f157a <= r4) goto L12;
        r2 = r2 - 1;
        goto L9
    L12:
        return r3;
    L20:
        return null;
    L19:
        return null;
    L14:
        return null;
    }

    private int i() {
        Calendar r2 = Calendar.getInstance();
        if (r2 != null) goto L7;
        return 0;
    L7:
        return ((r2.get(11) * 3600) + (r2.get(12) * 60)) + r2.get(13);
    }

    private void j() {
        if (this.l.get() >= 0) goto L5;
        this.l.set(0);
    L5:
        this.l.incrementAndGet();
    }

    public synchronized pc g() {
        monitor-enter(this);
        pc r0 = this.e;     // Catch: Throwable -> L14
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        pc r1 = this.b.m();     // Catch: Throwable -> L14
        this.e = r1;     // Catch: Throwable -> L14
        if (r1 == null) goto L10;
        a(r1);     // Catch: Throwable -> L14
    L11:
        pc r2 = this.e;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r2;
    L10:
        pc r3 = new pc();     // Catch: Throwable -> L14
        this.e = r3;     // Catch: Throwable -> L14
        r3.b = this.c.a().f460a.r;     // Catch: Throwable -> L14
        pc r4 = this.e;     // Catch: Throwable -> L14
        r4.e = this.c.a().f460a.s;     // Catch: Throwable -> L14
        pc r5 = this.e;     // Catch: Throwable -> L14
        r5.c = new ArrayList();     // Catch: Throwable -> L14
        pc r6 = this.e;     // Catch: Throwable -> L14
        r6.d = e();     // Catch: Throwable -> L14
        pc r7 = this.e;     // Catch: Throwable -> L14
        r7.f = true;     // Catch: Throwable -> L14
        r7.g = true;     // Catch: Throwable -> L14
        r7.h = this.c.a().f460a.u;     // Catch: Throwable -> L14
        pc r8 = this.e;     // Catch: Throwable -> L14
        r8.i = this.c.a().f460a.t;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public int h() {
        return this.l.get();
    }

    public void k() {
        this.l.set(0);
    }

    public void l() {
        this.n.removeMessages(4);
        this.n.sendEmptyMessageDelayed(4, 100);
    }

    private void c() {
        cj.a("TMSDK_SK", "doStopKeepAlive, mIsRunning:[" + this.o + "]");
        if (this.o == true) goto L5;
        return;
    L5:
        a();
        f r0 = this.d;
        if (r0 != null) goto L13;
    L11:
        n();
        this.o = false;
        return;
    L13:
        this.f339a.unregisterReceiver(r0);     // Catch: Throwable -> L9
        this.d = null;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        cj.a("TMSDK_SK", "doStopKeepAlive, t:[" + th + "]");
        goto L11
    }

    boolean a(String r5) {
        pc r6 = g();
        if (r6 != null) goto L6;
        return true;
    L6:
        if (r6.f == false) goto L8;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L21;
        if (r6.g == true) goto L21;
        PowerManager r4 = this.f;
        if (r4 == null) goto L21;
        if ((!r4.isScreenOn()) == false) goto L21;
        return false;
    L21:
        return r1;
    L8:
        if (2 == bl.b()) goto L10;
        r1 = false;
        goto L11
    }

    void a(int r3) {
        this.n.post(new c(this, r3));
    }

    void a(long r2) {
        this.n.sendEmptyMessageDelayed(10, r2);
    }

    private void a(pc r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ArrayList r0 = r3.d;
        if (r0 != null) goto L7;
    L9:
        r3.d = e();
    L11:
        if (r3.b > 30) goto L14;
        r3.b = 30;
    L14:
        if (r3.e > 0) goto L17;
        r3.e = this.c.a().f460a.s;
    L17:
        if (r3.h > 0) goto L20;
        r3.h = this.c.a().f460a.u;
    L20:
        if (r3.i > 0) goto L23;
        r3.i = this.c.a().f460a.t;
        return;
    L23:
        return;
    L7:
        if (r0.size() <= 0) goto L9;
        a(r3.d);
        goto L11
    }

    public void b(pc r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.e = r2;     // Catch: Throwable -> L8
        this.b.a(r2);     // Catch: Throwable -> L8
        a(this.e);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static final int b(int r0) {
        return c(r0 * 60);
    }

    private static void a(List r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.size() != 0) goto L7;
        return;
    L7:
        if (((di) r4.get(0)).f157a <= 0) goto L12;
        di r1 = (di) r4.get(r4.size() - 1);
        di r2 = new di();
        r2.f157a = b(0);
        r2.b = r1.b;
        r2.c = r1.c;
        r4.add(0, r2);
    L12:
        Collections.sort(r4, new d());     // Catch: Exception -> L11
        return;
    }

    private void a() {
        this.k.a(this.f339a, this.h);
        this.k.a(this.f339a, this.g);
        this.n.removeMessages(2);
        this.n.removeMessages(3);
        this.n.removeMessages(1);
    }
}
