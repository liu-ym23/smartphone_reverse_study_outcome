package tmsdkobf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ql f444a;
    private Context b;
    private o c;
    private Handler d;
    private z6 e;
    private zh f;
    private ak g;
    private qj h;
    private dk i;
    private l j;
    private k k;
    private n l;
    private n m;
    private ArrayList n;
    private LinkedHashMap o;
    private ExecutorService p;
    private boolean q;
    private boolean r;
    private long s;
    private long t;
    private boolean u;
    private boolean v;
    private sg w;
    private String x;
    private zh.c y;

    class a implements zh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg f445a;

        a(qg r1) {
            this.f445a = r1;
        }

        @Override // tmsdkobf.zh.c
        public void a(boolean r7, int r8, n r9) {
            qg.a(this.f445a, r7, r9, r8, 0, null);
        }

        @Override // tmsdkobf.zh.c
        public void a(boolean r1, int r2, byte[] r3, n r4) {
            qg.a(this.f445a, r1, r2, r3, r4);
        }
    }

    class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg f446a;

        b(qg r1, Looper r2) {
            this.f446a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            super.handleMessage(r3);
            if (r3.what != 1) goto L7;
            qg.a(this.f446a, (n) r3.obj);
            return;
        }
    }

    class c implements o7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o7 f447a;
        final /* synthetic */ qg b;

        c(qg r1, o7 r2) {
            this.b = r1;
            this.f447a = r2;
        }

        @Override // tmsdkobf.o7
        public void a(int r2, String r3) {
            this.f447a.a(r2, r3);
            dk.b(qg.d(this.b), this.b.f444a.f460a.c, r2, r3);
        }
    }

    class d implements o7 {
        d(qg r1) {
        }

        @Override // tmsdkobf.o7
        public void a(int r1, String r2) {
        }
    }

    class e implements j6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg f448a;

        e(qg r1) {
            this.f448a = r1;
        }

        @Override // tmsdkobf.j6
        public void a(int r1, String r2) {
            qg r0 = this.f448a;
            if (r0.f444a.f460a.l == true) goto L6;
            qg.a(r0, r1);
            return;
        }
    }

    class f implements p7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg f449a;

        f(qg r1) {
            this.f449a = r1;
        }

        @Override // tmsdkobf.p7
        public void a(int r1, String r2) {
            qg r0 = this.f449a;
            if (r0.f444a.f460a.l == true) goto L6;
            qg.b(r0, r1);
            return;
        }
    }

    class g extends ti {
        final /* synthetic */ ArrayList b;
        final /* synthetic */ n c;
        final /* synthetic */ qg d;

        g(qg r1, String r2, ArrayList r3, n r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Iterator r0 = this.b.iterator();     // Catch: Exception -> L25
        L4:
            if (r0.hasNext() == false) goto L11;
            pi r6 = (pi) r0.next();     // Catch: Exception -> L25
            if (r6 == null) goto L4;
            rh r2 = this.d.f444a.k();     // Catch: Exception -> L25
            r2.a("SharkNetwork", r6.f422a, r6.b, r6, 24);     // Catch: Exception -> L25
            goto L4
        L11:
            LinkedHashMap r1 = qg.j(this.d);     // Catch: Exception -> L25
            monitor-enter(r1);     // Catch: Exception -> L25
            qg.j(this.d).put(Integer.valueOf(this.c.f451a), this.c);     // Catch: Throwable -> L21
            monitor-exit(r1);     // Catch: Throwable -> L21
            long r3 = this.c.p;     // Catch: Exception -> L25
            if (r3 > 0) goto L19;
            r3 = 600000;
        L19:
            Message r4 = Message.obtain(qg.k(this.d), 1, this.c);     // Catch: Exception -> L25
            qg.k(this.d).sendMessageDelayed(r4, r3);     // Catch: Exception -> L25
            qg.l(this.d).a(this.c);     // Catch: Exception -> L25
            return;
        L21:
            th = move-exception;
            throw th;     // Catch: Exception -> L25
        }
    }

    class h extends ti {
        final /* synthetic */ n b;
        final /* synthetic */ qg c;

        h(qg r1, n r2) {
            this.c = r1;
            this.b = r2;
        }

        @Override // tmsdkobf.ti
        public void a() {
            n r4 = qg.c(this.c, this.b.f451a);
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.n == false) goto L8;
            int r0 = -21050000;
        L9:
            qg r2 = this.c;
            boolean r3 = this.b.h;
            qg.a(r2, r3, r4, r0, 0, null);
            return;
        L8:
            r0 = -21000020;
            goto L9
        }
    }

    class i implements p7 {
        i(qg r1) {
        }

        @Override // tmsdkobf.p7
        public void a(int r1, String r2) {
        }
    }

    public interface j {
        void a(boolean r1, int r2, int r3, ArrayList r4);
    }

    public interface k {
        long a(boolean r1, int r2, ij r3);

        long b(boolean r1, int r2, ij r3);
    }

    public interface l {
        void a(j6 r1);

        void a(o7 r1);

        void a(p7 r1);
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f450a;
        int b;
        n c;
        kj d;
        boolean e;

        private m() {
            this.f450a = -1;
            this.b = -1;
            this.e = false;
        }

        /* synthetic */ m(a r1) {
            this();
        }
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f451a;
        public int b;
        public boolean c;
        public boolean d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public long i;
        public nd j;
        public ArrayList k;
        public j l;
        public long m;
        public boolean n;
        public byte o;
        public long p;
        public boolean q;
        public int r;

        public n(int r4, boolean r5, boolean r6, boolean r7, long r8, ArrayList r10, j r11, long r12) {
            this.b = 0;
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.h = false;
            this.m = System.currentTimeMillis();
            this.n = false;
            this.o = 0;
            this.p = -1;
            this.q = false;
            this.r = 0;
            this.b = r4;
            this.c = r5;
            this.g = r6;
            this.f = r7;
            this.i = r8;
            this.k = r10;
            this.l = r11;
            this.f451a = jl.c().a();
            this.p = r12;
        }

        public void a(boolean r1) {
            this.q = r1;
        }

        public boolean b() {
            if (this.g == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f == true) goto L8;
            return false;
        }

        public boolean c() {
            if (Math.abs(System.currentTimeMillis() - this.m) < 600000) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean a() {
            return this.c;
        }
    }

    private class o extends ri {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ qg f452a;

        class a extends ti {
            final /* synthetic */ o b;

            /* JADX INFO: renamed from: tmsdkobf.qg$o$a$a, reason: collision with other inner class name */
            class C0103a implements qj.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ a f453a;

                C0103a(a r1) {
                    this.f453a = r1;
                }

                @Override // tmsdkobf.qj.d
                public void a(int r7, int r8, int r9, String r10) {
                    int r5 = j4.d(r9);
                    qg.a(this.f453a.b.f452a, false);
                    qj.a(qg.d(this.f453a.b.f452a), this.f453a.b.f452a.f444a.f460a.c, r5, r10);
                    qg.a(this.f453a.b.f452a, r5);
                    this.f453a.b.f452a.f444a.k().a("SharkNetwork", r8, r7, 62, r5);
                    this.f453a.b.f452a.f444a.k().a(r7);
                }
            }

            a(o r1) {
                this.b = r1;
            }

            @Override // tmsdkobf.ti
            public void a() {
                if (qg.b(this.b.f452a) == true) goto L5;
            L7:
                qg.a(this.b.f452a, true);
                qg.a(this.b.f452a, System.currentTimeMillis());
                qg.o(this.b.f452a).a(new C0103a(this));
                return;
            L5:
                if (bk.a(System.currentTimeMillis(), qg.c(this.b.f452a), 3) == true) goto L7;
            }
        }

        class b extends ti {
            final /* synthetic */ o b;

            class a extends dk.h {
                final /* synthetic */ b b;

                a(b r1, dk r2) {
                    this.b = r1;
                    Objects.requireNonNull(r2);
                    super(r2);
                }

                @Override // tmsdkobf.dk.h
                public void a(int r2, String r3) {
                    qg.b(this.b.b.f452a, false);
                    qg.b(this.b.b.f452a, r2);
                }
            }

            b(o r1) {
                this.b = r1;
            }

            @Override // tmsdkobf.ti
            public void a() {
                if (qg.f(this.b.f452a) == true) goto L5;
            L7:
                qg.b(this.b.f452a, true);
                qg.b(this.b.f452a, System.currentTimeMillis());
                dk r0 = qg.q(this.b.f452a);
                dk r2 = qg.q(this.b.f452a);
                Objects.requireNonNull(r2);
                r0.a(new a(this, r2));
                return;
            L5:
                if (bk.a(System.currentTimeMillis(), qg.g(this.b.f452a), 3) == true) goto L7;
            }
        }

        class c extends ti {
            final /* synthetic */ o b;

            c(o r1) {
                this.b = r1;
            }

            @Override // tmsdkobf.ti
            public void a() {
                qg.o(this.b.f452a).a(true, null);
            }
        }

        class d extends ti {
            final /* synthetic */ o b;

            d(o r1) {
                this.b = r1;
            }

            @Override // tmsdkobf.ti
            public void a() {
                qg.q(this.b.f452a).a(true, false, 0);
            }
        }

        public o(qg r1, Looper r2) {
            this.f452a = r1;
            super(r2, "SharkNetwork-WorkHandler");
        }

        @Override // tmsdkobf.ri
        public void a(Message r5) {
            int r0 = r5.what;
            if (r0 != 10) goto L5;
            qg.h(this.f452a);
            return;
        L5:
            if (r0 != 11) goto L7;
            n r6 = (n) r5.obj;
            if (r6 == null) goto L101;
            LinkedHashMap r1 = qg.j(this.f452a);
            monitor-enter(r1);
            qg.j(this.f452a).remove(Integer.valueOf(r6.f451a));     // Catch: Throwable -> L72
            monitor-exit(r1);     // Catch: Throwable -> L72
            ArrayList r2 = qg.a(this.f452a);
            monitor-enter(r2);
            qg.a(this.f452a).add(r6);     // Catch: Throwable -> L69
            monitor-exit(r2);     // Catch: Throwable -> L69
            qg.i(this.f452a).sendEmptyMessage(1);
            return;
        L69:
            th = move-exception;
            throw th;
        L72:
            th = move-exception;
            throw th;
        L101:
            return;
        L7:
            if (r0 == 20) goto L48;
            switch(r0) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                default: goto L103;
            };
        L10:
            dk.a(qg.d(this.f452a), this.f452a.f444a.f460a.c);
            return;
        L11:
            dk.b(qg.d(this.f452a), this.f452a.f444a.f460a.c);
            return;
        L12:
            qj.a(qg.d(this.f452a), this.f452a.f444a.f460a.c);
            return;
        L13:
            qg.e(this.f452a).submit(new d(this));
            return;
        L14:
            qg.e(this.f452a).submit(new c(this));
            return;
        L15:
            qg.e(this.f452a).submit(new a(this));
            return;
        L16:
            qg.e(this.f452a).submit(new b(this));
            return;
        L17:
            qg.i(this.f452a).removeMessages(1);
            if (qg.o(this.f452a).e() == false) goto L22;
            qg.p(this.f452a);
            return;
        L22:
            if (qg.q(this.f452a).b() == true) goto L24;
        L27:
            ArrayList r7 = qg.a(this.f452a);
            monitor-enter(r7);
        L45:
            th = move-exception;
            throw th;
        L30:
            if (qg.a(this.f452a).size() > 0) goto L33;
            monitor-exit(r7);     // Catch: Throwable -> L45
            return;
        L33:
            ArrayList r3 = (ArrayList) qg.a(this.f452a).clone();     // Catch: Throwable -> L45
            qg.a(this.f452a).clear();     // Catch: Throwable -> L45
            monitor-exit(r7);     // Catch: Throwable -> L45
            Iterator r8 = r3.iterator();
        L37:
            if (r8.hasNext() == false) goto L104;
            n r4 = (n) r8.next();
            if (r4 == null) goto L37;
            if (r4.g == true) goto L43;
            qg.a(this.f452a, true, r4);
            goto L37
        L43:
            qg.a(this.f452a, false, r4);
            goto L37
        L104:
            return;
        L24:
            if (qg.q(this.f452a).c() == false) goto L27;
            qg.r(this.f452a);
            return;
        L103:
            return;
        L48:
            qg.i(this.f452a).removeMessages(20);
            if (qg.m(this.f452a) == null) goto L54;
            if (r5.arg1 != 2) goto L54;
            qg r9 = this.f452a;
            qg.a(r9, true, qg.m(r9));
            return;
        L54:
            if (qg.n(this.f452a) != null) goto L56;
            return;
        L56:
            if (r5.arg1 != 3) goto L99;
            qg r10 = this.f452a;
            qg.a(r10, true, qg.n(r10));
            return;
        }
    }

    qg(Context r7, z6 r8, l r9, k r10, ql r11) {
        this.l = null;
        this.m = null;
        this.n = new ArrayList();
        this.o = new LinkedHashMap();
        this.q = false;
        this.r = false;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.y = new a(this);
        this.b = r7;
        this.e = r8;
        this.j = r9;
        this.k = r10;
        this.f444a = r11;
        int r3 = r11.f460a.k;
        this.g = new ak(r7, this);
        this.h = new qj(r7, this, r3);
        this.i = new dk(r7, this, r3);
        this.p = uk.a("SharkNetwork-SharkRunPool");
        this.f = new zh(r7, r8, r3, this.y, this);
        this.c = new o(this, this.f444a.h());
        this.d = new b(this, this.f444a.h());
    }

    static /* synthetic */ void a(qg r0, boolean r1, n r2, int r3, int r4, ArrayList r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ boolean b(qg r0) {
        return r0.q;
    }

    static /* synthetic */ long c(qg r2) {
        return r2.s;
    }

    static /* synthetic */ Context d(qg r0) {
        return r0.b;
    }

    static /* synthetic */ ExecutorService e(qg r0) {
        return r0.p;
    }

    static /* synthetic */ boolean f(qg r0) {
        return r0.r;
    }

    static /* synthetic */ long g(qg r2) {
        return r2.t;
    }

    static /* synthetic */ void h(qg r0) {
        r0.a();
    }

    static /* synthetic */ o i(qg r0) {
        return r0.c;
    }

    static /* synthetic */ LinkedHashMap j(qg r0) {
        return r0.o;
    }

    static /* synthetic */ Handler k(qg r0) {
        return r0.d;
    }

    static /* synthetic */ zh l(qg r0) {
        return r0.f;
    }

    static /* synthetic */ n m(qg r0) {
        return r0.l;
    }

    static /* synthetic */ n n(qg r0) {
        return r0.m;
    }

    static /* synthetic */ qj o(qg r0) {
        return r0.h;
    }

    static /* synthetic */ void p(qg r0) {
        r0.e();
    }

    static /* synthetic */ dk q(qg r0) {
        return r0.i;
    }

    static /* synthetic */ void r(qg r0) {
        r0.f();
    }

    static /* synthetic */ void a(qg r0, boolean r1, int r2, byte[] r3, n r4) {
        r0.a(r1, r2, r3, r4);
    }

    static /* synthetic */ boolean b(qg r0, boolean r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ n c(qg r0, int r1) {
        return r0.e(r1);
    }

    private void e() {
        c(23);
        a(new e(this), false);
    }

    private void f() {
        c(25);
        a(new f(this), false);
    }

    private void l() {
        if (this.f444a.f460a.l == true) goto L5;
        return;
    L5:
        this.c.removeMessages(10);
        this.c.sendEmptyMessageDelayed(10, WsConstants.EXIT_DELAY_TIME);
    }

    public rl d() {
        return this.f.a();
    }

    void g() {
        this.c.removeMessages(4);
        this.c.sendEmptyMessageDelayed(4, 1000);
    }

    public void h() {
        l();
    }

    void i() {
        this.c.removeMessages(5);
        this.c.sendEmptyMessageDelayed(5, 1000);
    }

    void j() {
        this.h.b();
    }

    void k() {
        this.i.d();
    }

    void m() {
        a(new d(this));
    }

    void n() {
        this.c.removeMessages(3);
        this.c.sendEmptyMessage(3);
    }

    void o() {
        this.c.removeMessages(2);
        this.c.sendEmptyMessage(2);
    }

    static /* synthetic */ ArrayList a(qg r0) {
        return r0.n;
    }

    static /* synthetic */ long b(qg r0, long r1) {
        r0.t = r1;
        return r1;
    }

    private void d(int r3) {
        if (r3 != 0) goto L6;
        this.c.sendEmptyMessage(1);
        return;
    L6:
        if (r3 <= 0) goto L8;
        int r1 = Math.abs(-600000000) + r3;
    L10:
        if (this.i.b() == false) goto L14;
        a(false, r1, true);
        return;
    L14:
        return;
    L8:
        r1 = (-600000000) + r3;
        goto L10
    }

    public z6 c() {
        return this.e;
    }

    static /* synthetic */ boolean a(qg r0, boolean r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ void b(qg r0, int r1) {
        r0.d(r1);
    }

    private void c(int r3) {
        ArrayList r0 = this.n;
        monitor-enter(r0);
        ArrayList r1 = (ArrayList) this.n.clone();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.size() <= 0) goto L20;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L21;
        a((n) r2.next(), r3);
        goto L11
    L21:
        return;
    L20:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ long a(qg r0, long r1) {
        r0.s = r1;
        return r1;
    }

    private n e(int r2) {
        LinkedHashMap r0 = this.o;
        monitor-enter(r0);
        n r1 = (n) this.o.remove(Integer.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String b() {
        return this.h.a();
    }

    static /* synthetic */ void a(qg r0, int r1) {
        r0.b(r1);
    }

    public void b(ArrayList r13, j r14) {
        n r11 = new n(0, true, false, false, 0, r13, r14, 0);
        this.m = r11;
        r11.e = true;
        this.c.obtainMessage(20, 3, 0).sendToTarget();
    }

    static /* synthetic */ void a(qg r0, n r1) {
        r0.b(r1);
    }

    static /* synthetic */ void a(qg r0, boolean r1, n r2) {
        r0.a(r1, r2);
    }

    public void a(j6 r2, boolean r3) {
        if (r3 == false) goto L7;
        String r4 = this.e.f();
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.a(0, r4);
        return;
    L7:
        l r5 = this.j;
        if (r5 == null) goto L11;
        r5.a(r2);
    L11:
        if (this.f444a.f460a.l == true) goto L13;
        this.c.removeMessages(6);
        this.c.sendEmptyMessage(6);
        return;
    L13:
        n();
    }

    private void b(int r3) {
        if (r3 != 0) goto L6;
        this.c.sendEmptyMessage(1);
        return;
    L6:
        if (r3 <= 0) goto L8;
        int r1 = Math.abs(-800000000) + r3;
    L9:
        a(false, r1, true);
        return;
    L8:
        r1 = (-800000000) + r3;
        goto L9
    }

    private void b(n r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        uk.a(new h(this, r2), "onTimeout");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private m b(byte[] r9) {
        nd r1 = null;
        m r0 = new m(0 == true ? 1 : 0);
        if (r9 != null) goto L58;
    L54:
        r0.f450a = -1800;     // Catch: Exception -> L56
    L57:
        return r0;
    L58:
    L56:
        r0.f450a = -2500;
        goto L57
    L5:
        if (r9.length == 0) goto L54;
        boolean r3 = false;
        sj r10 = (sj) z7.b(r9, new sj(), false);     // Catch: Exception -> L56
        if (r10 != null) goto L10;
        r0.f450a = -2300;     // Catch: Exception -> L56
        goto L57
    L10:
        nj r2 = r10.f515a;     // Catch: Exception -> L56
        if (r2 != null) goto L13;
        r0.f450a = -2200;     // Catch: Exception -> L56
        goto L57
    L13:
        int r4 = r2.d;     // Catch: Exception -> L56
        if (r4 != 0) goto L16;
        Object[] r6 = true;
    L17:
        r0.b = r4;     // Catch: Exception -> L56
        n r5 = a(r4);     // Catch: Exception -> L56
        r0.c = r5;     // Catch: Exception -> L56
        int r7 = r2.b;     // Catch: Exception -> L56
        if (r7 == 0) goto L23;
        r0.f450a = r7;     // Catch: Exception -> L56
        if (r7 != 2) goto L22;
        r3 = true;
    L22:
        r0.e = r3;     // Catch: Exception -> L56
        goto L57
    L23:
        if (r5 == null) goto L25;
        r1 = r5.j;     // Catch: Exception -> L56
    L25:
        byte[] r8 = r10.b;     // Catch: Exception -> L56
        if (r8 != null) goto L28;
    L32:
        if (r1 != null) goto L35;
        r1 = this.g.a();     // Catch: Exception -> L56
    L35:
        if (nd.b(r1) == true) goto L38;
        if (r6 == true) goto L38;
        r0.f450a = -1900;     // Catch: Exception -> L56
    L38:
        byte[] r11 = r10.c;     // Catch: Exception -> L56
        if (r11 != null) goto L41;
    L52:
        r0.f450a = -2100;     // Catch: Exception -> L56
        goto L57
    L41:
        if (r11.length == 0) goto L52;
        byte[] r12 = jk.a(rd.e(), this.f444a.i(), uj.c(r1.b), r11, r2.f375a);     // Catch: Exception -> L56
        if (r12 != null) goto L46;
    L51:
        r0.f450a = -600;     // Catch: Exception -> L56
        goto L57
    L46:
        if (r12.length <= 0) goto L51;
        kj r13 = (kj) z7.b(r12, new kj(), false);     // Catch: Exception -> L56
        if (r13 != null) goto L50;
        r0.f450a = -2400;     // Catch: Exception -> L56
        goto L57
    L50:
        r0.f450a = 0;     // Catch: Exception -> L56
        r0.d = r13;     // Catch: Exception -> L56
        goto L57
    L28:
        if (r8.length <= 0) goto L32;
        r1 = this.g.a(r8, r1);     // Catch: Exception -> L56
        if (nd.b(r1) == true) goto L38;
        r0.f450a = -2000;     // Catch: Exception -> L56
        goto L57
    L16:
        r6 = false;
        goto L17
    }

    public void a(o7 r4) {
        ql r0 = this.f444a;
        if (r0.f460a.l == true) goto L8;
        l r1 = this.j;
        if (r1 == null) goto L7;
        r1.a(r4);
    L7:
        this.c.removeMessages(8);
        this.c.sendEmptyMessage(8);
        return;
    L8:
        this.i.a(new c(this, r4), this.e, r0);
    }

    public void a(p7 r2, boolean r3) {
        if (r3 == false) goto L7;
        String r4 = this.e.o();
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.a(0, r4);
        return;
    L7:
        l r5 = this.j;
        if (r5 == null) goto L11;
        r5.a(r2);
    L11:
        if (this.f444a.f460a.l == true) goto L13;
        this.c.removeMessages(7);
        this.c.sendEmptyMessage(7);
        return;
    L13:
        o();
    }

    public void a(boolean r14, int r15, long r16, ArrayList r18, j r19) {
        n r12 = new n(r15, false, false, false, r16, r18, r19, 0);
        r12.a(r14);
        a(r12);
        boolean r1 = this.f444a.f460a.l;
        Iterator r2 = r18.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (((pi) r2.next()).f422a != 2) goto L4;
        r1 = false;
        goto L4
    L8:
        if (r1 == false) goto L16;
        this.h.a(false, null);
        return;
    }

    public void a(n r8) {
        if (r8 == null) goto L24;
        ArrayList r0 = r8.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size() <= 0) goto L33;
        ArrayList r1 = this.n;
        monitor-enter(r1);
        this.n.add(r8);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        cj.a("TMSDK_SK_HB", "asyncSendShark");
        Iterator r9 = r8.k.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        pi r5 = (pi) r9.next();
        if (r5 == null) goto L14;
        cj.a("TMSDK_SK_HB", "asyncSendShark, cmdID:" + r5.f422a);
        this.f444a.k().a("SharkNetwork", r5.f422a, r5.b, r5, 20);
        goto L14
    L19:
        this.c.sendEmptyMessage(1);
        return;
    L21:
        th = move-exception;
        throw th;
    L33:
        return;
    }

    public void a(ArrayList r13, j r14) {
        n r11 = new n(0, true, false, false, 0, r13, r14, 0);
        this.l = r11;
        r11.d = true;
        this.c.obtainMessage(20, 2, 0).sendToTarget();
    }

    public byte[] a(n r11, boolean r12, String r13, z6 r14) {
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.g == true) goto L10;
        r11.j = this.g.a();
        return a(a(rd.e(), r12, r11, r11.j, r11.k, r13, r14, this.f444a.f460a.l), r13, r11);
    L10:
        return new byte[]{r11.o};
    }

    public void a(n r7, int r8, int r9, int r10) {
        this.f444a.k().a("SharkNetwork", r8, r7, r9, r10);
    }

    private void a(n r8, int r9) {
        if (r8 == null) goto L15;
        ArrayList r0 = r8.k;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.size() <= 0) goto L22;
        Iterator r10 = r8.k.iterator();
    L10:
        if (r10.hasNext() == false) goto L23;
        pi r5 = (pi) r10.next();
        if (r5 == null) goto L10;
        this.f444a.k().a("SharkNetwork", r5.f422a, r5.b, r5, r9);
        goto L10
    L23:
        return;
    L22:
        return;
    }

    private void a() {
        String r0 = this.e.f();
        String r1 = this.e.g();
        if (TextUtils.isEmpty(r0) == true) goto L10;
        if (TextUtils.isEmpty(r1) == true) goto L10;
        if (r0.equals(r1) == true) goto L10;
    L14:
        String r2 = this.e.o();
        String r3 = this.e.p();
        if (TextUtils.isEmpty(r2) == true) goto L22;
        if (TextUtils.isEmpty(r3) == true) goto L22;
        if (r2.equals(r3) == true) goto L22;
    L26:
        this.h.a(true, null);
        this.i.a(true, false, 0);
        return;
    L22:
        if (TextUtils.isEmpty(r2) == true) goto L26;
        if (TextUtils.isEmpty(r3) == false) goto L26;
        this.e.d(r2, false);
    L10:
        if (TextUtils.isEmpty(r0) == true) goto L14;
        if (TextUtils.isEmpty(r1) == false) goto L14;
        this.e.b(r0, false);
        goto L14
    }

    private void a(boolean r4, n r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r6 = r5.k;
        if (r6 != null) goto L7;
        return;
    L7:
        if (r6.size() == 0) goto L12;
        this.p.submit(new g(this, "submitSharkSend", r6, r5));
        return;
    }

    private si a(Context r11, boolean r12, n r13, nd r14, ArrayList r15, String r16, z6 r17, boolean r18) {
        si r8 = new si();
        r8.f514a = r13.f451a;
        r8.d = r15;
        if (r12 == true) goto L5;
    L20:
        sg r0 = a(r11, false, r14, r16, r17, r18);
        r8.c = r0;
        if (r12 == false) goto L23;
        this.w = r0;
        this.v = false;
    L23:
        return r8;
    L5:
        if (r13.d == true) goto L20;
        if (r13.e == true) goto L20;
        if (r13.f == true) goto L20;
        if (r13.g == true) goto L23;
        sg r1 = a(r11, false, r14, r16, r17, r18);
        if (a(r1, this.w) == true) goto L18;
        r8.c = r1;
        this.w = r1;
        this.v = false;
        goto L23
    L18:
        if (this.v == false) goto L23;
        r8.c = r1;
        this.w = r1;
        this.v = false;
        goto L23
    }

    private byte[] a(si r6, String r7, n r8) {
        byte[] r1 = z7.a(r6);     // Catch: Throwable -> L15
        if (r1 != null) goto L6;
        return null;
    L6:
        dj r2 = new dj();     // Catch: Throwable -> L15
        vi r3 = new vi();     // Catch: Throwable -> L15
        r2.f158a = r3;     // Catch: Throwable -> L15
        r3.f585a = 20;     // Catch: Throwable -> L15
        r3.d = r7;     // Catch: Throwable -> L15
        r3.e = this.f444a.l();     // Catch: Throwable -> L15
        vi r9 = r2.f158a;     // Catch: Throwable -> L15
        r9.f = r6.f514a;     // Catch: Throwable -> L15
        r9.g = r6.b;     // Catch: Throwable -> L15
        byte[] r10 = jk.a(r1, r9);     // Catch: Throwable -> L15
        if (r10 != null) goto L10;
        return null;
    L10:
        if (nd.b(r8.j) == false) goto L12;
        r2.b = null;     // Catch: Throwable -> L15
        vi r11 = r2.f158a;     // Catch: Throwable -> L15
        r11.b = r8.j.c;     // Catch: Throwable -> L15
        r2.c = jk.b(r10, uj.c(r8.j.b), this.f444a.i());     // Catch: Throwable -> L15
    L13:
        return z7.a(r2);
    L12:
        Pair r12 = this.g.a(r8);     // Catch: Throwable -> L15
        String r4 = (String) r12.first;     // Catch: Throwable -> L15
        r2.b = (byte[]) r12.second;     // Catch: Throwable -> L15
        r2.f158a.b = null;     // Catch: Throwable -> L15
        r2.c = jk.b(r10, uj.c(r4), this.f444a.i());     // Catch: Throwable -> L15
        a(r8, 21, 0, 0);     // Catch: Throwable -> L15
    L15:
        return null;
    }

    private sg a(Context r3, boolean r4, nd r5, String r6, z6 r7, boolean r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        sg r0 = new sg();
        String r1 = "";
        if (r5 == null) goto L8;
        String r9 = r5.c;
    L9:
        if (r4 == true) goto L12;
        r1 = r9;
    L12:
        r0.e = r1;
        r0.f = r7.d();
        r0.f512a = bl.a(r3);
        r0.g = bl.b(r3);
        if (r7.u() == false) goto L15;
        r0.b = r7.e();
    L16:
        r0.c = r6;
        r0.h = r7.b();
        r0.i = r7.c();
        r0.j = r7.q();
        r0.k = this.i.a();
        if (this.x != null) goto L23;
        int r10 = Process.myPid();
        if (r8 == false) goto L21;
        String r11 = "b";
    L22:
        this.x = r11 + r10;
        goto L23
    L21:
        r11 = "f";
    L23:
        r0.d = this.x;
        return r0;
    L15:
        r0.b = -1;
        goto L16
    L8:
        r9 = "";
        goto L9
    }

    private void a(ArrayList r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() <= 0) goto L23;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L24;
        ij r0 = (ij) r4.next();
        if (r0 == null) goto L8;
        if (r0.d != 3) goto L8;
        this.v = true;
        return;
    L24:
        return;
    }

    private void a(boolean r19, int r20, byte[] r21, n r22) {
        n r2 = r22;
        if (r20 == 0) goto L8;
        if (r2 == null) goto L6;
        a(r19, r22, r20, 0, null);
        return;
    L6:
        a(r19, r20, false);
        return;
    L8:
        if (r21 != null) goto L10;
    L55:
        if (r2 == null) goto L57;
        a(r19, r22, -21001805, 0, null);
        return;
    L57:
        a(r19, -21001805, false);
        return;
    L10:
        if (r21.length == 0) goto L55;
        if (a(r21) == false) goto L15;
        return;
    L15:
        m r5 = b(r21);
        if (r2 != null) goto L18;
    L19:
        int r7 = r5.b;
    L20:
        if (r2 != null) goto L23;
        r2 = r5.c;
    L23:
        if (r5.f450a == 0) goto L26;
        a(r19, r2, r5);
        return;
    L26:
        kj r6 = r5.d;
        ArrayList r14 = r6.c;
        if (r14 != null) goto L29;
    L53:
        a(r19, r2, -21002600, r6.f311a, null);
        return;
    L29:
        if (r14.size() == 0) goto L53;
        a(r14);
        ArrayList r15 = a(r19, r6, r14);
        char r13 = 1;
        if (r15 == null) goto L46;
        if (r15.size() <= 0) goto L46;
        Iterator r16 = r15.iterator();
    L37:
        if (r16.hasNext() == false) goto L42;
        ij r8 = (ij) r16.next();
        if (r8 == null) goto L37;
        rh r9 = this.f444a.k();
        int r10 = r8.f276a;
        int r11 = r8.c;
        Object[] r12 = new Object[2];
        r12[0] = Integer.valueOf(r21.length + 4);
        r12[r13] = Integer.valueOf(r14.size());
        r9.a("SharkNetwork", r10, r11, 61, r20, String.format("%d/%d", r12));
        r13 = 1;
        goto L37
    L42:
        if (r2 == null) goto L46;
        a(r19, r2, 0, r6.f311a, r15);
    L46:
        if (this.u == false) goto L48;
        return;
    L48:
        if (this.i.b() == false) goto L50;
        return;
    L50:
        if (this.f444a.f460a.l == false) goto L67;
        this.u = true;
        a(new i(this), true);
        return;
    L67:
        return;
    L18:
        if (r2.f451a != (-1)) goto L20;
        goto L19
    }

    private void a(boolean r7, n r8, m r9) {
        int r3 = r9.f450a;
        if (r9.e == false) goto L13;
        if (r8 == null) goto L12;
        this.g.a(r8.j, r8.f451a);
        if (r8.r != 0) goto L11;
        a(r8, 22);
        if (r8.d == true) goto L10;
        r8.r++;
        this.c.sendMessageDelayed(this.c.obtainMessage(11, r8), 100);
        return;
    L10:
        a(r7, r8, r3, 0, null);
        return;
    L11:
        a(r7, r8, r3, 0, null);
        return;
    L12:
        a(r7, r3, false);
        return;
    L13:
        if (r8 == null) goto L15;
        a(r7, r8, r3, 0, null);
        return;
    L15:
        a(r7, r3, false);
    }

    private n a(int r3) {
        n r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        n r1 = this.m;
        if (r1 != null) goto L10;
    L12:
        LinkedHashMap r2 = this.o;
        monitor-enter(r2);
        n r4 = (n) this.o.get(Integer.valueOf(r3));     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r4;
    L18:
        th = move-exception;
        throw th;
    L10:
        if (r1.f451a != r3) goto L12;
        return r1;
    L5:
        if (r0.f451a != r3) goto L7;
        return r0;
    }

    private void a(boolean r3, n r4, int r5, int r6, ArrayList r7) {
        if (r4 != null) goto L9;
        return;
    L9:
        this.d.removeMessages(1, r4);     // Catch: Exception -> L8
        e(r4.f451a);     // Catch: Exception -> L8
        j r2 = r4.l;     // Catch: Exception -> L8
        if (r2 == null) goto L11;
        r2.a(r3, r5, r6, r7);     // Catch: Exception -> L8
        return;
    L11:
        return;
    }

    private void a(boolean r8, int r9, boolean r10) {
        ArrayList r0 = new ArrayList();
        LinkedHashMap r1 = this.o;
        monitor-enter(r1);
        r0.addAll(this.o.values());     // Catch: Throwable -> L20
        this.o.clear();     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (r10 == false) goto L15;
        ArrayList r11 = this.n;
        monitor-enter(r11);
        r0.addAll(this.n);     // Catch: Throwable -> L12
        this.n.clear();     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Iterator r12 = r0.iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        a(r8, (n) r12.next(), r9, 0, null);
        goto L17
    L19:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    private boolean a(byte[] r8) {
        if (jk.a(r8) == true) goto L5;
        return false;
    L5:
        byte r9 = r8[0];
        int r10 = this.f444a.k().b(r9);
        if (r10 < 0) goto L16;
        LinkedHashMap r0 = this.o;
        monitor-enter(r0);
        n r3 = (n) this.o.get(Integer.valueOf(r10));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (r3 == null) goto L20;
        a(true, r3, 0, 0, null);
        return true;
    L20:
        return true;
    L13:
        th = move-exception;
        throw th;
    L16:
        return true;
    }

    private final ArrayList a(boolean r7, kj r8, ArrayList r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r9.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L17;
        ij r3 = (ij) r9.get(r2);
        if (r3 == null) goto L16;
        boolean r4 = jk.c(r3);
        boolean r5 = jk.b(r3);
        if (r4 == false) goto L13;
        r0.add(r3);
        goto L16
    L13:
        if (r5 == false) goto L15;
        this.k.a(r7, r8.f311a, r3);
        goto L16
    L15:
        this.k.b(r7, r8.f311a, r3);
    L16:
        r2 = r2 + 1;
        goto L6
    L17:
        return r0;
    }

    private static boolean a(sg r6, sg r7) {
        if (r6 != null) goto L7;
        if (r7 != null) goto L7;
        return true;
    L7:
        if (r6 == null) goto L35;
        if (r7 == null) goto L35;
        if (r6.f512a != r7.f512a) goto L34;
        if (r6.b != r7.b) goto L34;
        if (a(r6.c, r7.c) == false) goto L34;
        if (a(r6.d, r7.d) == false) goto L34;
        if (a(r6.e, r7.e) == false) goto L34;
        if (r6.f != r7.f) goto L34;
        if (r6.g != r7.g) goto L34;
        if (r6.h != r7.h) goto L34;
        if (r6.i != r7.i) goto L34;
        if (a(r6.j, r7.j) == false) goto L34;
        if (a(r6.k, r7.k) == false) goto L34;
        return true;
    L34:
        return false;
    L35:
        return false;
    }

    private static boolean a(String r0, String r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r0 == null) goto L11;
        if (r1 != null) goto L10;
        return false;
    L10:
        return r0.equals(r1);
    L11:
        return false;
    }

    private static boolean a(ah r4, ah r5) {
        if (r4 != null) goto L7;
        if (r5 != null) goto L7;
        return true;
    L7:
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r4.f101a != r5.f101a) goto L16;
        if (a(r4.b, r5.b) == false) goto L16;
        return true;
    L16:
        return false;
    L17:
        return false;
    }
}
