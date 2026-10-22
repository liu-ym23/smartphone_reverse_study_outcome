package d.b.b.e.a.k;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ss.ttuploader.TTUploadResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final long[] n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f12660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f12661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f12662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f12663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile int f12664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f12665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f12666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f12667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f12668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AtomicLong f12669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AtomicLong f12670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d.b.b.e.a.h.a f12671l;
    private volatile boolean m;

    static /* synthetic */ class a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static c f12672a;

        static {
            f12672a = new c(null);
        }
    }

    static {
        n = new long[]{120000, 300000, 600000, 1800000, 3600000};
    }

    private c() {
        this.f12662c = 0;
        this.f12668i = true;
        this.f12665f = new ArrayList();
        this.f12666g = new ArrayList();
        this.f12667h = new ArrayList();
        this.f12669j = new AtomicLong(0);
        this.f12670k = new AtomicLong();
    }

    /* synthetic */ c(a r1) {
        this();
    }

    private long c() {
        if (this.f12661b <= this.f12663d) goto L5;
        int r0 = this.f12661b;
    L6:
        long r1 = r0;
        if (r1 <= this.f12664e) goto L10;
        return r1;
    L10:
        return this.f12664e;
    L5:
        r0 = this.f12663d;
        goto L6
    }

    public static c e() {
        return b.f12672a;
    }

    private void o() {
        this.f12668i = false;
        this.f12669j.set(System.currentTimeMillis());
    }

    void a(long r3) {
        this.f12664e = (int) (r3 * 1000);
        o();
    }

    void b() {
        l();
        this.m = true;
        this.f12670k.set(System.currentTimeMillis());
    }

    List<String> d() {
        d.b.b.e.a.h.a r0 = this.f12671l;
        if (r0 == null) goto L9;
        if (d.b.b.o.f.b(r0.b()) == true) goto L9;
        return this.f12671l.b();
    L9:
        return this.f12667h;
    }

    List<String> f() {
        d.b.b.e.a.h.a r0 = this.f12671l;
        if (r0 == null) goto L9;
        if (d.b.b.o.f.b(r0.h()) == true) goto L9;
        return this.f12671l.h();
    L9:
        return this.f12665f;
    }

    long g(int r2) {
        int r3 = r2 - 1;
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        long[] r1 = n;
        if (r3 < r1.length) goto L11;
        return r1[r1.length - 1];
    L11:
        return r1[r3];
    }

    List<String> h() {
        d.b.b.e.a.h.a r0 = this.f12671l;
        if (r0 == null) goto L9;
        if (d.b.b.o.f.b(r0.i()) == true) goto L9;
        return this.f12671l.i();
    L9:
        return this.f12666g;
    }

    boolean i() {
        d.b.b.e.a.h.a r0 = this.f12671l;
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.j();
    }

    boolean j() {
        if (this.f12668i == false) goto L5;
        return true;
    L5:
        if ((System.currentTimeMillis() - this.f12669j.get()) > c()) goto L10;
        return false;
    L10:
        return true;
    }

    boolean k() {
        if (this.m == false) goto L10;
        if ((System.currentTimeMillis() - this.f12670k.get()) > c()) goto L7;
        return true;
    L7:
        return false;
    L10:
        return this.m;
    }

    void l() {
        if (this.f12660a != 0) goto L7;
        this.f12660a = 1;
        int r0 = 300000;
    L5:
        this.f12661b = r0;
    L15:
        if (d.b.b.o.a.c() == false) goto L17;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "longBackOff:" + this.f12661b + " netFailCount:" + this.f12660a);
    L17:
        o();
        return;
    L7:
        if (this.f12660a != 1) goto L10;
        this.f12660a = 2;
        r0 = 900000;
        goto L5
    L10:
        if (this.f12660a != 2) goto L12;
        int r1 = 3;
    L13:
        this.f12660a = r1;
        this.f12661b = 1800000;
        goto L15
    L12:
        r1 = 4;
        goto L13
    }

    void m() {
        this.m = false;
    }

    void n() {
        this.f12668i = true;
        this.m = false;
        this.f12660a = 0;
        this.f12661b = 0;
        this.f12662c = 0;
        this.f12663d = 0;
        this.f12664e = 0;
        this.f12670k.set(0);
        this.f12669j.set(0);
    }

    public void p(List<String> r2) {
        if (d.b.b.o.f.b(r2) == false) goto L5;
        return;
    L5:
        this.f12667h.clear();
        this.f12667h.addAll(r2);
    }

    public void q(List<String> r2) {
        if (d.b.b.o.f.b(r2) == false) goto L5;
        return;
    L5:
        this.f12665f.clear();
        this.f12665f.addAll(r2);
    }

    public void r(List<String> r2) {
        if (d.b.b.o.f.b(r2) == false) goto L5;
        return;
    L5:
        this.f12666g.clear();
        this.f12666g.addAll(r2);
    }

    void s() {
        if (this.f12662c != 0) goto L7;
        this.f12662c = 1;
        int r0 = LocationInfoConst.HALF_MINUTES;
    L5:
        this.f12663d = r0;
        if (d.b.b.o.a.c() == false) goto L19;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "shortStopInterval:" + this.f12663d + " shortFailCount:" + this.f12662c);
    L19:
        o();
        return;
    L7:
        if (this.f12662c != 1) goto L10;
        this.f12662c = 2;
        r0 = TTUploadResolver.HOST_MAX_CACHE_TIME;
        goto L5
    L10:
        if (this.f12662c != 2) goto L13;
        this.f12662c = 3;
        r0 = LocationInfoConst.TWO_MINUTES;
        goto L5
    L13:
        if (this.f12662c != 3) goto L15;
        this.f12662c = 4;
        r0 = 240000;
        goto L5
    L15:
        this.f12662c = 5;
        r0 = 300000;
        goto L5
    }

    public void t(d.b.b.e.a.h.a r1) {
        this.f12671l = r1;
    }
}
