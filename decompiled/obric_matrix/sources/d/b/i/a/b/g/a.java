package d.b.i.a.b.g;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.net.URL;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.b.i.a.b.g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d.b.i.a.c.a f13855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile long f13856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f13857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f13858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f13859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f13860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile long f13861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile long f13862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f13863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f13864j;

    /* JADX INFO: renamed from: d.b.i.a.b.g.a$a, reason: collision with other inner class name */
    class C0366a extends d.b.i.a.c.a.AbstractC0369a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f13866b;

        C0366a(a r1, String r2) {
            this.f13866b = r1;
            this.f13865a = r2;
        }

        @Override // d.b.i.a.c.a.b
        public String a() {
            return this.f13865a + "sdk_monitor";
        }

        @Override // d.b.i.a.c.a.b
        public String b() {
            if (TextUtils.isEmpty(this.f13866b.f13863i) == true) goto L11;
            List<String> r0 = c();
            if (r0 != null) goto L7;
            return null;
        L7:
            if (r0.size() > 0) goto L14;
            return null;
        L14:
            return "https://" + this.f13866b.f13863i + new URL(r0.get(0)).getPath();
        L18:
            return null;
        L11:
            return null;
        }

        @Override // d.b.i.a.c.a.b
        public List<String> c() {
            return d.b.i.a.b.e.c.g(this.f13865a, "sdk_monitor");
        }

        @Override // d.b.i.a.c.a.b
        public int d() {
            return d.b.i.a.b.e.c.d(this.f13865a);
        }

        @Override // d.b.i.a.c.a.b
        public long f() {
            return d.b.i.a.b.e.c.c(this.f13865a);
        }
    }

    class b implements d.b.i.a.c.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f13867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f13868b;

        b(a r1, String r2) {
            this.f13868b = r1;
            this.f13867a = r2;
        }

        @Override // d.b.i.a.c.a.c
        public boolean a() {
            return d.b.i.a.b.e.c.a(this.f13867a);
        }

        @Override // d.b.i.a.c.a.c
        public long b() {
            return a.b(this.f13868b);
        }

        @Override // d.b.i.a.c.a.c
        public boolean c() {
            return this.f13868b.f13857c;
        }
    }

    class c extends d.b.i.a.c.a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f13869g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f13870h;

        c(a r1, Context r2, d.b.i.a.c.a.b r3, d.b.i.a.c.a.c r4, String r5) {
            this.f13870h = r1;
            this.f13869g = r5;
            super(r2, r3, r4);
        }

        @Override // d.b.i.a.c.a
        protected boolean h(String r8, byte[] r9) {
            if (d.a(this.f13869g) == null) goto L41;
            e r10 = d.a(this.f13869g).c(r8, r9);
            a.c(this.f13870h, null);
            if (r10 == null) goto L40;
            int r0 = r10.f13873a;
            if (r0 <= 0) goto L40;
            a r2 = this.f13870h;
            r2.f13857c = false;
            if (r0 != 200) goto L35;
            JSONObject r3 = r10.f13874b;
            if (r3 == null) goto L35;
            if ("success".equals(r3.opt("message")) == false) goto L21;
            a.d(this.f13870h);
            String r1 = r10.f13874b.optString("redirect");
            long r4 = r10.f13874b.optLong("delay");
            if (TextUtils.isEmpty(r1) == true) goto L18;
            a.c(this.f13870h, r1);
        L18:
            if (r4 <= 0) goto L20;
            a.e(this.f13870h, r4);
        L20:
            return true;
        L21:
            boolean r11 = "drop data".equals(r10.f13874b.opt("message"));
            boolean r5 = "drop all data".equals(r10.f13874b.opt("message"));
            String r6 = r10.f13874b.optString("redirect");
            long r7 = r10.f13874b.optLong("delay");
            if (TextUtils.isEmpty(r6) == true) goto L25;
            a.c(this.f13870h, r6);
        L25:
            if (r7 <= 0) goto L27;
            a.e(this.f13870h, r7);
        L27:
            a r12 = this.f13870h;
            if (r11 == false) goto L30;
            a.f(r12);
        L31:
            if (r5 == false) goto L33;
            a.h(this.f13870h);
        L33:
            return false;
        L30:
            a.g(r12);
        L35:
            if (500 > r0) goto L41;
            if (r0 > 600) goto L41;
            a.i(r2);
            return false;
        L40:
            a.j(this.f13870h);
            this.f13870h.f13857c = true;
        L41:
            return false;
        }
    }

    public a(Context r8, String r9) {
        this.f13864j = true;
        this.f13859e = r9;
        C0366a r4 = new C0366a(this, r9);
        b r5 = new b(this, r9);
        this.f13855a = new c(this, r8.getApplicationContext(), r4, r5, r9);
    }

    static /* synthetic */ long b(a r2) {
        return r2.o();
    }

    static /* synthetic */ void c(a r0, String r1) {
        r0.k(r1);
    }

    static /* synthetic */ void d(a r0) {
        r0.r();
    }

    static /* synthetic */ void e(a r0, long r1) {
        r0.l(r1);
    }

    static /* synthetic */ void f(a r0) {
        r0.n();
    }

    static /* synthetic */ void g(a r0) {
        r0.q();
    }

    static /* synthetic */ void h(a r0) {
        r0.m();
    }

    static /* synthetic */ void i(a r0) {
        r0.p();
    }

    static /* synthetic */ void j(a r0) {
        r0.t();
    }

    private void k(String r2) {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        this.f13863i = r2;
    }

    private void l(long r3) {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        this.f13862h = r3 * 1000;
        SDKMonitorUtils.b(this.f13859e).h0(this.f13862h);
    }

    private void m() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        p();
        SDKMonitorUtils.b(this.f13859e).i0(true);
        SDKMonitorUtils.b(this.f13859e).y();
        SDKMonitorUtils.b(this.f13859e).z();
    }

    private void n() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        p();
        SDKMonitorUtils.b(this.f13859e).i0(true);
    }

    private long o() {
        if (this.f13864j == true) goto L7;
        return 0;
    L7:
        if (this.f13856b <= this.f13861g) goto L9;
        long r0 = this.f13856b;
    L11:
        if (r0 <= this.f13862h) goto L14;
        return r0;
    L14:
        return this.f13862h;
    L9:
        r0 = this.f13861g;
        goto L11
    }

    private void p() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        int r0 = this.f13858d;
        if (r0 != 0) goto L10;
        long r2 = 300000;
    L8:
        this.f13856b = r2;
    L9:
        this.f13858d++;
        SDKMonitorUtils.b(this.f13859e).h0(this.f13856b);
        return;
    L10:
        if (r0 != 1) goto L12;
        r2 = 900000;
        goto L8
    L12:
        this.f13856b = 1800000;
        goto L9
    }

    private void q() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        SDKMonitorUtils.b(this.f13859e).i0(false);
    }

    private void r() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        SDKMonitorUtils.b(this.f13859e).g0();
        SDKMonitorUtils.b(this.f13859e).i0(false);
        this.f13858d = 0;
        this.f13856b = 0;
        this.f13860f = 0;
        this.f13861g = 0;
        this.f13862h = 0;
    }

    private void t() {
        if (this.f13864j == true) goto L5;
        return;
    L5:
        int r0 = this.f13860f;
        if (r0 != 0) goto L9;
        long r2 = 30000;
    L8:
        this.f13861g = r2;
        this.f13860f++;
        SDKMonitorUtils.b(this.f13859e).h0(this.f13861g);
        return;
    L9:
        if (r0 != 1) goto L12;
        r2 = 60000;
        goto L8
    L12:
        if (r0 != 2) goto L15;
        r2 = 120000;
        goto L8
    L15:
        if (r0 != 3) goto L17;
        r2 = 240000;
        goto L8
    L17:
        r2 = 300000;
        goto L8
    }

    @Override // d.b.i.a.b.g.b
    public boolean a(String r1) {
        return this.f13855a.a(r1);
    }

    public void s(String r1) {
        this.f13855a.j(r1);
    }
}
