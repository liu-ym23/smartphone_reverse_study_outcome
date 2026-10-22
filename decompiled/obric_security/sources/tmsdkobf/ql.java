package tmsdkobf;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ql {
    private static String k = "SharkImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ud.b f460a;
    private gh b;
    private yg c;
    private rh d;
    private boolean e;
    private boolean f;
    private y6 g;
    private Looper h;
    private Handler i;
    private Handler j;

    static {
    }

    public ql(ud.b r4) {
        this.e = true;
        this.f = true;
        this.h = null;
        this.i = null;
        this.j = null;
        k += "-" + r4.d;
        sl.a(r4.f);
        this.f460a = r4;
        r4.e.a(null);
        this.g = r4.f.a();
        this.b = new gh(r4.f556a, r4.e, this);
        this.c = new yg(r4.e, this);
        this.d = new rh(r4.e, this);
    }

    public WeakReference a(int r21, JceStruct r22, JceStruct r23, int r24, w6 r25, long r26) {
        return a(Process.myPid(), 0, 0, 0, 1, r21, r22, null, r23, r24, r25, null, r26, 0, 0);
    }

    public List b() {
        List r0 = this.f460a.e.n().a(this.f460a.k, tj.c());
        if (r0 == null) goto L7;
        if (r0.size() == 0) goto L7;
        return r0;
    L7:
        return e();
    }

    public List c() {
        List r0 = this.f460a.e.n().b(this.f460a.k, tj.c());
        if (r0 == null) goto L7;
        if (r0.size() == 0) goto L7;
        return r0;
    L7:
        return g();
    }

    public String d() {
        return this.f460a.e.f();
    }

    public List e() {
        List r2 = this.f460a.e.n().c(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public List f() {
        List r2 = this.f460a.e.n().d(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public List g() {
        List r2 = this.f460a.e.n().e(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public Looper h() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.h != null) goto L7;
        HandlerThread r0 = uk.a("Shark-Looper-" + this.f460a.d, -1);     // Catch: Throwable -> L10
        r0.start();     // Catch: Throwable -> L10
        this.h = r0.getLooper();     // Catch: Throwable -> L10
    L7:
        monitor-exit(this);     // Catch: Throwable -> L10
        return this.h;
    }

    public y6 i() {
        return this.g;
    }

    public String j() {
        return "" + this.f460a.c + "-" + this.f460a.d;
    }

    public rh k() {
        return this.d;
    }

    public int l() {
        return this.f460a.e.n().c();
    }

    public List m() {
        List r2 = this.f460a.e.n().f(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public List n() {
        List r2 = this.f460a.e.n().g(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public List o() {
        List r2 = this.f460a.e.n().h(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public List p() {
        List r2 = this.f460a.e.n().i(this.f460a.k, tj.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ArrayList();
    }

    public boolean q() {
        return this.b.e();
    }

    public boolean r() {
        return this.e;
    }

    public boolean s() {
        return this.f;
    }

    public void t() {
        if (this.f460a.l == false) goto L6;
        this.b.f();
        return;
    }

    public void u() {
        if (w() == false) goto L6;
        this.b.j();
        return;
    }

    public void v() {
        if (w() == false) goto L6;
        this.b.k();
        return;
    }

    public boolean w() {
        return this.f460a.m;
    }

    public WeakReference a(int r21, byte[] r22, int r23, v6 r24, long r25) {
        return a(Process.myPid(), 0, 0, 0, 1, r21, null, r22, null, r23, r24, null, r25, 0, 0);
    }

    public WeakReference a(int r21, JceStruct r22, JceStruct r23, int r24, w6 r25, long r26, long r28, int r30) {
        return a(Process.myPid(), 0, 0, 0, 1, r21, r22, null, r23, r24, r25, null, r26, r28, r30);
    }

    public WeakReference a(int r21, int r22, int r23, long r24, long r26, int r28, JceStruct r29, byte[] r30, JceStruct r31, int r32, w6 r33, x6 r34, long r35, long r37, int r39) {
        if (r29 != null) goto L5;
    L7:
        Process.myPid();
        if (this.f460a.n == false) goto L15;
        if ((r32 & 4096) != 0) goto L15;
        this.c.a(r26, r23, r24, r28, r29, r30, r31, r32, r33, r35, r37, r39);
        return null;
    L15:
        return this.b.a(r21, r22, r23, r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r37, r39);
    L5:
        if ((r29 instanceof wd) == false) goto L7;
        String r1 = ((wd) r29).b.d;     // Catch: Exception -> L16
        goto L7
    }

    public void b(Runnable r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.j != null) goto L7;
        HandlerThread r4 = uk.a("Shark-Callback-Queue-Outer-" + this.f460a.d, -1);     // Catch: Throwable -> L10
        r4.start();     // Catch: Throwable -> L10
        this.j = new Handler(r4.getLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(this);     // Catch: Throwable -> L10
        this.j.post(r2);
    }

    public void c(boolean r2) {
        this.b.i();
        if (r2 == false) goto L6;
        u();
        return;
    }

    public void b(boolean r1) {
        this.f = r1;
    }

    public void a(long r11, int r13, JceStruct r14, int r15, a7 r16, boolean r17) {
        if (this.f460a.n == true) goto L8;
        this.b.a(r11, r13, r14, r15, r16, r17);
        return;
    L8:
        this.c.a(r11, r13, r14, r15, r16);     // Catch: Exception -> L7
        return;
    }

    public a7 a(int r2, int r3) {
        if (this.f460a.n == true) goto L7;
        return this.b.a(r2, r3);
    L7:
        return this.c.a(r2, r3);
    }

    public void a(long r10, int r12, JceStruct r13, int r14, a7 r15) {
        if (w() == true) goto L5;
        return;
    L5:
        this.b.a(r10, r12, r13, r14, r15, false);
    }

    public void a(Runnable r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.i != null) goto L7;
        HandlerThread r4 = uk.a("Shark-Callback-Queue-" + this.f460a.d, -1);     // Catch: Throwable -> L10
        r4.start();     // Catch: Throwable -> L10
        this.i = new Handler(r4.getLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(this);     // Catch: Throwable -> L10
        this.i.post(r2);
    }

    public void a(boolean r1) {
        this.e = r1;
    }

    public void a() {
        cj.a("TMSDK_SK", "closeConnection");     // Catch: Throwable -> L5
        this.b.a();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        cj.a("TMSDK_SK", "closeConnection, e:" + th.getMessage());
        th.printStackTrace();
    }
}
