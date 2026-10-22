package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class tj implements cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f533a;
    private z6 b;
    private qg c;
    private Handler d;
    private long e;
    private int f;
    private long g;
    private boolean h;
    private int i;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ tj f534a;

        /* JADX INFO: renamed from: tmsdkobf.tj$a$a, reason: collision with other inner class name */
        class C0107a implements w6 {
            C0107a(a r1) {
            }

            @Override // tmsdkobf.w6
            public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
                if (r3 != 0) goto L7;
                if (r4 != 0) goto L8;
                if (r5 == null) goto L9;
                dh r6 = (dh) r5;
                return;
            L9:
                return;
            L8:
                return;
            }
        }

        a(tj r1) {
            this.f534a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (tj.a(this.f534a).f444a.f460a.e.n().d() == true) goto L5;
            return;
        L5:
            List r0 = tj.a(this.f534a).f444a.f();
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.size() == 0) goto L24;
            int r1 = tj.b(this.f534a);
            long r2 = System.currentTimeMillis();
            if (tj.c(this.f534a) != 0) goto L13;
        L14:
            int r3 = tk.a(tj.a(this.f534a).f444a.f460a.e.b(1));
            if (r3 != 1) goto L17;
            return;
        L17:
            if (r3 == 2) goto L25;
            tj.a(this.f534a, r2);
            vg r6 = new vg();
            r6.f583a = this.f534a.d();
            r6.b = "localIPStack=" + r3;
            tj.a(this.f534a).f444a.a(993, r6, new dh(), 2560, new C0107a(this), 60000);
            return;
        L25:
            return;
        L13:
            if ((r2 - tj.c(this.f534a)) > (r1 * 1000)) goto L14;
            return;
        }
    }

    class b implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ hi f535a;
        final /* synthetic */ tj b;

        b(tj r1, hi r2) {
            this.b = r1;
            this.f535a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            if (r3 != 0) goto L7;
            if (r4 != 0) goto L7;
            if (r5 == null) goto L7;
            tj.a(this.b, false, (ji) r5);
        L7:
            hi r0 = this.f535a;
            if (r0 == null) goto L14;
            if (r3 != 0) goto L12;
            r3 = r4;
        L12:
            r0.a(Integer.valueOf(r3));
            return;
        }
    }

    class c implements a7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f536a;
        final /* synthetic */ tj b;

        c(tj r1, int r2) {
            this.b = r1;
            this.f536a = r2;
        }

        @Override // tmsdkobf.a7
        public Cif a(int r3, long r4, int r6, JceStruct r7) {
            if (r7 != null) goto L6;
            return null;
        L6:
            if (r6 != this.f536a) goto L10;
            return tj.a(this.b, r4, r3, (ji) r7);
        L10:
            if (r6 == 10171) goto L12;
            return null;
        L12:
            return tj.a(this.b, r4, r3, (kh) r7);
        }
    }

    class d implements dl.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ tj f537a;

        d(tj r1) {
            this.f537a = r1;
        }

        @Override // tmsdkobf.dl.f
        public void f() {
            tj.d(this.f537a);
        }

        @Override // tmsdkobf.dl.f
        public void h() {
        }
    }

    public tj(Context r3, int r4, z6 r5, qg r6) {
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.i = 0;
        this.f533a = r3;
        this.b = r5;
        this.c = r6;
        this.d = new Handler(this.c.f444a.h());
        g();
        h();
    }

    static /* synthetic */ qg a(tj r0) {
        return r0.c;
    }

    static /* synthetic */ int b(tj r0) {
        return r0.e();
    }

    static /* synthetic */ long c(tj r2) {
        return r2.e;
    }

    static /* synthetic */ void d(tj r0) {
        r0.i();
    }

    private int e() {
        if (this.f != 0) goto L6;
        this.f = this.b.a(300);
    L6:
        return this.f;
    }

    private void g() {
        dl.b().b(new d(this));
    }

    private void h() {
        ql r0 = this.c.f444a;
        int r4 = r0.f460a.j.d();
        c r8 = new c(this, r4);
        r0.a(0, r4, new ji(), 0, r8);
        r0.a(0, 10171, new kh(), 0, r8);
    }

    private void i() {
        this.h = false;
    }

    public boolean f() {
        if (this.c.f444a.f460a.j.a() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.g == 0) goto L9;
        if ((System.currentTimeMillis() - this.g) <= 600000) goto L11;
    L9:
        if (j() == true) goto L11;
        return true;
    }

    public boolean j() {
        String r0 = b();
        return a(a(r0, true), a(r0 + "_ipv6", true), d());
    }

    static /* synthetic */ long a(tj r0, long r1) {
        r0.e = r1;
        return r1;
    }

    private String b() {
        return b(bl.a(this.f533a));
    }

    public static int c() {
        if (4 == ik.f277a) goto L7;
        int r0 = rj.b(rd.e());
        if ((-1) == r0) goto L7;
        return r0;
    L7:
        return 2;
    }

    public int d() {
        int r1 = 4;
        if (this.h == false) goto L7;
        this.i = 4;
        return 4;
    L7:
        if (this.c.f444a.f460a.e.n().d() == true) goto L10;
        this.i = 4;
        return 4;
    L10:
        int r0 = this.c.f444a.f460a.e.n().b();
        int r2 = tk.a(this.c.f444a.f460a.e.b(1));
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L16;
        r1 = r0;
    L16:
        this.i = r1;
        return r1;
    L15:
        r1 = 3;
        goto L16
    }

    static /* synthetic */ void a(tj r0, boolean r1, JceStruct r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ Cif a(tj r0, long r1, int r3, ji r4) {
        return r0.a(r1, r3, r4);
    }

    private String b(int r3) {
        String r2 = ("" + this.c.f444a.f460a.c) + "_st" + this.c.f444a.f460a.k + "_";
        if (r3 != 1) goto L5;
        String r4 = "wifi_" + fl.a();
    L7:
        return r2 + r4;
    L5:
        r4 = "apn_" + r3;
        goto L7
    }

    static /* synthetic */ Cif a(tj r0, long r1, int r3, kh r4) {
        return r0.a(r1, r3, r4);
    }

    @Override // tmsdkobf.cl
    public boolean a(List r9, List r10) {
        if (r9 == null) goto L23;
        if (r10 == null) goto L23;
        int r0 = d();
        String r1 = b();
        u5 r3 = a(r1, true);
        u5 r2 = a(r1 + "_ipv6", true);
        if (a(r3, r2, r0) == false) goto L14;
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L11;
        if (r0 == 3) goto L10;
        r9.addAll(a(r3.b, false));
    L13:
        return true;
    L10:
        r9.addAll(a(r2.b, true));
        goto L13
    L11:
        r9.addAll(a(r3.b, false));
        r10.addAll(a(r2.b, true));
        goto L13
    L12:
        r9.addAll(a(r2.b, true));
        r10.addAll(a(r3.b, false));
        goto L13
    L14:
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L18;
        r9.addAll(this.c.f444a.m());
        r9.addAll(this.c.f444a.o());
    L21:
        return false;
    L18:
        r9.addAll(this.c.f444a.n());
        r9.addAll(this.c.f444a.p());
        goto L21
    L19:
        r9.addAll(this.c.f444a.m());
        r9.addAll(this.c.f444a.o());
        r10.addAll(this.c.f444a.n());
        r10.addAll(this.c.f444a.p());
        goto L21
    L20:
        r9.addAll(this.c.f444a.n());
        r9.addAll(this.c.f444a.p());
        r10.addAll(this.c.f444a.m());
        r10.addAll(this.c.f444a.o());
    L23:
        throw new IllegalArgumentException("getSocketAddressList: firstList and secondList must not be null!");
    }

    @Override // tmsdkobf.cl
    public int a() {
        int r0 = this.i;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return d();
    }

    public void a(String r2) {
        this.d.post(new a(this));
    }

    public List a(int r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != 2560) goto L6;
        r0.addAll(this.c.f444a.f());
        return r0;
    L6:
        int r1 = d();
        if (r6 != 2048) goto L9;
        boolean r7 = true;
    L10:
        if (r1 != 1) goto L12;
        if (r7 == false) goto L33;
        List r2 = this.c.f444a.b();
    L34:
        String r3 = (String) r2.get(0);
        if (r7 == false) goto L37;
        List r5 = this.c.f444a.c();
    L38:
        r0.add((String) r5.get(0));
        r0.add(r3);
    L39:
        return r0;
    L37:
        r5 = this.c.f444a.g();
        goto L38
    L33:
        r2 = this.c.f444a.e();
        goto L34
    L12:
        if (r1 != 2) goto L14;
        if (r7 == false) goto L25;
        List r4 = this.c.f444a.b();
    L26:
        String r8 = (String) r4.get(0);
        if (r7 == false) goto L29;
        List r9 = this.c.f444a.c();
    L30:
        String r10 = (String) r9.get(0);
        r0.add(r8);
        r0.add(r10);
        goto L39
    L29:
        r9 = this.c.f444a.g();
        goto L30
    L25:
        r4 = this.c.f444a.e();
        goto L26
    L14:
        if (r1 == 3) goto L19;
        if (r7 == false) goto L17;
        List r11 = this.c.f444a.b();
    L18:
        r0.add((String) r11.get(0));
        goto L39
    L17:
        r11 = this.c.f444a.e();
        goto L18
    L19:
        if (r7 == false) goto L21;
        List r12 = this.c.f444a.c();
    L22:
        r0.add((String) r12.get(0));
        goto L39
    L21:
        r12 = this.c.f444a.g();
        goto L22
    L9:
        r7 = false;
        goto L10
    }

    public void a(int r11, hi r12, long r13) {
        this.g = System.currentTimeMillis();
        wg r4 = new wg();
        r4.f602a = "127.0.0.1";
        this.c.f444a.a(r11, r4, new ji(), 512, new b(this, r12), r13);
    }

    private boolean a(u5 r2, u5 r3, int r4) {
        if (r4 != 4) goto L9;
        if (r2 != null) goto L6;
    L7:
        return false;
    L6:
        if (r2.a() == false) goto L7;
        return true;
    L9:
        if (r4 != 3) goto L14;
        if (r3 != null) goto L12;
    L13:
        return false;
    L12:
        if (r3.a() == false) goto L13;
        return true;
    L14:
        if (r2 != null) goto L16;
    L24:
        return false;
    L16:
        if (r2.a() == false) goto L24;
        if (r3 == null) goto L24;
        if (r3.a() == false) goto L24;
        return true;
    }

    private Cif a(long r1, int r3, ji r4) {
        a(true, r4);
        eh r5 = new eh();
        r5.f184a = r4.f293a;
        int r0 = this.c.f444a.f460a.j.b();
        return new Cif(Long.valueOf(r1), Integer.valueOf(r0), r5);
    }

    private Cif a(long r1, int r3, kh r4) {
        int r2 = r4.f309a;
        if (r2 <= 0) goto L5;
        this.f = r2;
        this.b.f(r2);
    L5:
        a("push_instr");
        return null;
    }

    private void a(boolean r7, JceStruct r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if ((r8 instanceof ji) == true) goto L7;
        return;
    L7:
        ji r9 = (ji) r8;
        if (r9.f293a == 0) goto L10;
    L20:
        long r0 = System.currentTimeMillis() + (((long) r9.c) * 1000);
        List r2 = u5.a(r9.b, false);
        List r4 = u5.a(r9.g, false);
        u5 r5 = new u5(r0, r2, false);
        u5 r3 = new u5(r0, r4, false);
        int r1 = bl.a(this.f533a);
        int r10 = r9.e;
        if (r10 != r1) goto L23;
        String r11 = b();
        this.b.a(r11, r5.f548a, r5.b);
        this.b.a(r11 + "_ipv6", r3.f548a, r3.b);
    L24:
        if (r7 == false) goto L28;
        a(this.f533a);
        return;
    L28:
        return;
    L23:
        String r12 = b(r10);
        this.b.a(r12, r5.f548a, r5.b);
        this.b.a(r12 + "_ipv6", r3.f548a, r3.b);
        goto L24
    L10:
        if (r9.c != 0) goto L20;
        ArrayList r6 = r9.b;
        if (r6 != null) goto L14;
    L15:
        ArrayList r13 = r9.g;
        if (r13 != null) goto L18;
        return;
    L18:
        if (r13.size() != 0) goto L20;
        return;
    L14:
        if (r6.size() != 0) goto L20;
        goto L15
    }

    private void a(Context r4) {
        Intent r0 = new Intent("a.ip.l.p");     // Catch: Throwable -> L8
        r0.setPackage(r4.getPackageName());     // Catch: Throwable -> L8
        r0.putExtra("sharkPkg", this.c.f444a.f460a.c);     // Catch: Throwable -> L8
        r0.putExtra("instanceName", this.c.f444a.f460a.d);     // Catch: Throwable -> L8
        r4.sendBroadcast(r0, rd.f());     // Catch: Throwable -> L8
        return;
    }

    private List a(List r3, boolean r4) {
        ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
    L7:
        if (r4 == false) goto L9;
        List r2 = this.c.f444a.n();
    L11:
        if (r0.size() >= 2) goto L13;
        r0.addAll(u5.a(r2, true));
    L14:
        return r0;
    L13:
        r0.addAll(1, u5.a(r2, true));
        goto L14
    L9:
        r2 = this.c.f444a.m();
        goto L11
    L5:
        if (r3.size() <= 0) goto L7;
        r0.addAll(r3);
        goto L7
    }

    private u5 a(String r5, boolean r6) {
        u5 r0 = this.b.b(r5);
        if (r0 == null) goto L10;
        if (r0.a() == true) goto L11;
        if (r6 == false) goto L10;
        this.b.a(r5, 0, null);
        goto L10
    L11:
        return r0;
    L10:
        return null;
    }
}
