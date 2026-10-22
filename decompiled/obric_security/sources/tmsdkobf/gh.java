package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes5.dex */
public class gh implements qg.l, qg.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f220a;
    private boolean b;
    private qg c;
    private z6 d;
    private ql e;
    private List f;
    private List g;
    private List h;
    private h i;
    private ExecutorService j;
    private ArrayList k;
    private TreeMap l;
    private SparseArray m;
    private ml n;
    private long o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Handler x;
    private Handler y;

    class a extends Handler {
        a(gh r1, Looper r2) {
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r12) {
            if (r12.what != 11) goto L16;
            Object[] r11 = (Object[]) r12.obj;     // Catch: Throwable -> L12
            k r13 = (k) r11[0];     // Catch: Throwable -> L12
            r13.getClass();     // Catch: Throwable -> L12
            w6 r0 = r13.i;     // Catch: Throwable -> L12
            if (r0 != null) goto L8;
        L13:
            return;
        L8:
            if ((r0 instanceof v6) == false) goto L10;
            ((v6) r0).a(r13.j, ((Integer) r11[1]).intValue(), ((Integer) r11[2]).intValue(), ((Integer) r11[3]).intValue(), r13.g);     // Catch: Throwable -> L12
            goto L13
        L10:
            r0.onFinish(r13.j, ((Integer) r11[1]).intValue(), ((Integer) r11[2]).intValue(), ((Integer) r11[3]).intValue(), r13.f);     // Catch: Throwable -> L12
        L17:
            return;
        }
    }

    class b extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        b(gh r1, String r2, List r3, int r4, String r5) {
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Iterator r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((j6) r0.next()).a(this.c, this.d);
            goto L4
        }
    }

    class c extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        c(gh r1, String r2, List r3, int r4, String r5) {
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Iterator r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((o7) r0.next()).a(this.c, this.d);
            goto L4
        }
    }

    class d extends ti {
        final /* synthetic */ List b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        d(gh r1, String r2, List r3, int r4, String r5) {
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            Iterator r0 = this.b.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((p7) r0.next()).a(this.c, this.d);
            goto L4
        }
    }

    class e extends ti {
        final /* synthetic */ long b;
        final /* synthetic */ ij c;
        final /* synthetic */ Cif d;
        final /* synthetic */ gh e;

        e(gh r1, String r2, long r3, ij r5, Cif r6) {
            this.e = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            gh.c(this.e, this.b, this.c, this.d);
        }
    }

    class f extends ti {
        final /* synthetic */ long b;
        final /* synthetic */ ij c;
        final /* synthetic */ Cif d;
        final /* synthetic */ gh e;

        f(gh r1, String r2, long r3, ij r5, Cif r6) {
            this.e = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            super(r2);
        }

        @Override // tmsdkobf.ti
        public void a() {
            gh.d(this.e, this.b, this.c, this.d);
        }
    }

    class g implements w6 {
        g(gh r1) {
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
        }
    }

    private final class h extends bj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f221a;
        final /* synthetic */ gh b;

        class a extends ti {
            final /* synthetic */ Context b;
            final /* synthetic */ Intent c;
            final /* synthetic */ String d;
            final /* synthetic */ h e;

            a(h r1, String r2, Context r3, Intent r4, String r5) {
                this.e = r1;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                super(r2);
            }

            @Override // tmsdkobf.ti
            public void a() {
                String r0 = gh.t(this.e.b).f460a.c;
                String r1 = this.b.getPackageName();
                String r3 = String.format("action.guid.got:%s", new Object[]{r1});
                String r5 = String.format("action.vid.got:%s", new Object[]{r1});
                String r6 = String.format("action.tk.got:%s", new Object[]{r1});
                String r7 = String.format("action.reg.guid:%s", new Object[]{r1});
                String r8 = String.format("action.get.vid:%s", new Object[]{r1});
                String r2 = String.format("action.reg.tk:%s", new Object[]{r1});
                String r4 = this.c.getStringExtra("k.s.p");
                if (r4 != null) goto L5;
                return;
            L5:
                if (r4.equals(r0) == true) goto L8;
                return;
            L8:
                if (r3.equals(this.d) == false) goto L16;
                int r9 = this.c.getIntExtra("k.rc", -1);
                String r10 = this.c.getStringExtra("k.g");
                if (r9 == 0) goto L12;
            L14:
                gh.a(this.e.b, r9, r10);
                return;
            L12:
                if (gh.t(this.e.b).f460a.l == true) goto L14;
                gh.s(this.e.b).a(r10, false);
                gh.s(this.e.b).b(r10, false);
                gh.d(this.e.b);
                goto L14
            L16:
                if (r5.equals(this.d) == false) goto L19;
                gh.b(this.e.b, this.c.getIntExtra("k.rc", -1), this.c.getStringExtra("k.v"));
                return;
            L19:
                if (r6.equals(this.d) == false) goto L29;
                int r11 = this.c.getIntExtra("k.rc", -1);
                String r12 = this.c.getStringExtra("k.tk");
                if (r11 == 0) goto L23;
            L27:
                gh.c(this.e.b, r11, r12);
                return;
            L23:
                if (TextUtils.isEmpty(r12) == true) goto L27;
                if (gh.t(this.e.b).f460a.l == true) goto L27;
                gh.s(this.e.b).c(r12, false);
                gh.s(this.e.b).d(r12, false);
                gh.f(this.e.b);
                goto L27
            L29:
                if (r7.equals(this.d) == false) goto L34;
                if (gh.t(this.e.b).f460a.l == false) goto L48;
                this.e.b.m();
                return;
            L48:
                return;
            L34:
                if (r8.equals(this.d) == false) goto L39;
                if (gh.t(this.e.b).f460a.l == false) goto L50;
                this.e.b.l();
                return;
            L50:
                return;
            L39:
                if (r2.equals(this.d) == true) goto L41;
                return;
            L41:
                if (gh.t(this.e.b).f460a.l == false) goto L53;
                this.e.b.n();
                return;
            }
        }

        private h(gh r1) {
            this.b = r1;
            this.f221a = false;
        }

        static /* synthetic */ void a(h r0, Context r1) {
            r0.a(r1);
        }

        @Override // tmsdkobf.bj
        public void a(Context r8, Intent r9) {
            String r5 = r9.getAction();
            if (r5 != null) goto L5;
            return;
        L5:
            uk.a(new a(this, "doOnRecv: " + r5, r8, r9, r5), "shark-InnerReceiver-doOnRecv");
        }

        /* synthetic */ h(gh r1, a r2) {
            this(r1);
        }

        private void a(Context r9) {
            if (this.f221a == true) goto L27;
            String r0 = r9.getPackageName();     // Catch: Throwable -> L24
            IntentFilter r3 = new IntentFilter();     // Catch: Throwable -> L24
            r3.addAction(String.format("action.guid.got:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.sk.got:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.vid.got:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.tk.got:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.reg.guid:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.get.vid:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            r3.addAction(String.format("action.reg.tk:%s", new Object[]{r0}));     // Catch: Throwable -> L24
            if (Build.VERSION.SDK_INT < 33) goto L21;
            r9.registerReceiver(this, r3, rd.f(), null, 4);     // Catch: Throwable -> L24
        L22:
            this.f221a = true;     // Catch: Throwable -> L24
            return;
        L21:
            r9.registerReceiver(this, r3, rd.f(), null);     // Catch: Throwable -> L24
        L28:
            return;
        }
    }

    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f222a;
        long b;
        ij c;
        int d;

        public i(int r1, long r2, long r4, ij r6) {
            this.d = r1;
            this.f222a = r2;
            this.b = r4;
            this.c = r6;
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f223a;
        public long b;

        public j(boolean r1, long r2) {
            this.f223a = r1;
            this.b = r2;
        }
    }

    private static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f224a;
        public int b;
        public int c;
        public JceStruct d;
        public byte[] e;
        public JceStruct f;
        public byte[] g;
        public int h;
        public w6 i;
        public int j;
        public int k;
        public vd l;
        public long m;
        public long n;
        public long o;
        public long p;
        public int q;

        k(int r1, int r2, long r3, int r5, JceStruct r6, byte[] r7, JceStruct r8, int r9, w6 r10, x6 r11) {
            this.m = -1;
            this.n = 0;
            this.p = System.currentTimeMillis();
            this.q = 0;
            int r4 = jl.b().a();
            this.j = r4;
            this.f224a = r1;
            this.b = r2;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.h = r9;
            this.i = r10;
            this.l = new vd(r4);
        }

        static /* synthetic */ boolean a(k r0) {
            return r0.a();
        }

        private boolean a() {
            long r0 = Math.abs(System.currentTimeMillis() - this.p);
            long r2 = this.m;
            if (r2 > 0) goto L7;
            r2 = 600000;
        L7:
            if (r0 < r2) goto L9;
            return true;
        L9:
            return false;
        }
    }

    private class l extends ti {
        private TreeMap b;
        private ArrayList c;
        private Handler d;
        private Handler e;
        final /* synthetic */ gh f;

        class a extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f225a;

            a(l r1, Looper r2, gh r3) {
                this.f225a = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r3) {
                e r0 = (e) r3.obj;
                l.a(this.f225a, r0.f228a, r3.what, -11050000);
            }
        }

        class b extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f226a;

            b(l r1, Looper r2, gh r3) {
                this.f226a = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r3) {
                if (r3.what != 1) goto L7;
                int r0 = r3.arg1;
                int r4 = r3.arg2;
                l.a(this.f226a, r4, r0, -10000017);
                return;
            }
        }

        class c implements qg.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l f227a;

            c(l r1) {
                this.f227a = r1;
            }

            @Override // tmsdkobf.qg.j
            public void a(boolean r1, int r2, int r3, ArrayList r4) {
                l.a(this.f227a, r1, r2, r3, r4);
            }
        }

        class d extends ti {
            final /* synthetic */ long b;
            final /* synthetic */ k c;
            final /* synthetic */ Integer d;
            final /* synthetic */ int e;
            final /* synthetic */ Integer f;

            d(l r1, String r2, long r3, k r5, Integer r6, int r7, Integer r8) {
                this.b = r3;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                super(r2);
            }

            @Override // tmsdkobf.ti
            public void a() {
                long r0 = (System.nanoTime() - this.b) / 1000000;     // Catch: Throwable -> L10
                k r1 = this.c;     // Catch: Throwable -> L10
                r1.getClass();     // Catch: Throwable -> L10
                w6 r4 = r1.i;     // Catch: Throwable -> L10
                if (r4 != null) goto L5;
            L8:
                long r2 = (System.nanoTime() - this.b) / 1000000;     // Catch: Throwable -> L10
                return;
            L5:
                if ((r4 instanceof v6) == false) goto L7;
                ((v6) r4).a(r1.j, this.d.intValue(), this.e, this.f.intValue(), this.c.g);     // Catch: Throwable -> L10
                goto L8
            L7:
                r4.onFinish(r1.j, this.d.intValue(), this.e, this.f.intValue(), this.c.f);     // Catch: Throwable -> L10
            }
        }

        private class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f228a;

            public e(l r1, int r2) {
                this.f228a = r2;
            }
        }

        /* synthetic */ l(gh r1, String r2, a r3) {
            this(r1, r2);
        }

        static /* synthetic */ void a(l r0, int r1, int r2, int r3) {
            r0.a(r1, r2, r3);
        }

        public Set b() {
            TreeMap r0 = this.b;
            monitor-enter(r0);
            TreeMap r1 = (TreeMap) this.b.clone();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r1.entrySet();
        L8:
            th = move-exception;
            throw th;
        }

        private l(gh r2, String r3) {
            this.f = r2;
            super(r3);
            this.b = new TreeMap();
            this.c = new ArrayList();
            this.d = new a(this, gh.t(r2).h(), r2);
            this.e = new b(this, gh.t(r2).h(), r2);
        }

        static /* synthetic */ void a(l r0, boolean r1, int r2, int r3, ArrayList r4) {
            r0.a(r1, r2, r3, r4);
        }

        public void a(Integer r2, k r3) {
            TreeMap r0 = this.b;
            monitor-enter(r0);
            this.b.put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void b(int r6) {
            Set r0 = b();
            TreeMap r1 = this.b;
            monitor-enter(r1);
            this.b.clear();     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            Iterator r2 = r0.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            Map.Entry r3 = (Map.Entry) r2.next();
            int r4 = ((Integer) r3.getKey()).intValue();
            this.d.removeMessages(r4);
            a((k) r3.getValue(), Integer.valueOf(((k) r3.getValue()).c), Integer.valueOf(r6), -1);
            goto L8
        L10:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void a(k r2) {
            ArrayList r0 = this.c;
            monitor-enter(r0);
            this.c.add(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean a(int r2) {
            TreeMap r0 = this.b;
            monitor-enter(r0);
            boolean r1 = this.b.containsKey(Integer.valueOf(r2));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // tmsdkobf.ti
        public void a() {
            ArrayList r0 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r8 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r4 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r9 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r10 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r11 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r12 = new ArrayList();     // Catch: Exception -> L126
            ArrayList r13 = new ArrayList();     // Catch: Exception -> L126
            Iterator r1 = b().iterator();     // Catch: Exception -> L126
            long r14 = 0;
        L5:
            if (r1.hasNext() == false) goto L69;
            Map.Entry r5 = (Map.Entry) r1.next();     // Catch: Exception -> L126
            if (((k) r5.getValue()).l.a() == false) goto L9;
        L67:
            r1 = r1;
            r14 = r14;
        L68:
            r12 = r12;
            r13 = r13;
            goto L5
        L9:
            if (k.a((k) r5.getValue()) == false) goto L11;
            this.e.obtainMessage(1, ((k) r5.getValue()).j, ((k) r5.getValue()).c).sendToTarget();     // Catch: Exception -> L126
            goto L67
        L11:
            ((k) r5.getValue()).l.a(1);     // Catch: Exception -> L126
            pi r2 = new pi();     // Catch: Exception -> L126
            r2.f422a = ((k) r5.getValue()).c;     // Catch: Exception -> L126
            r2.b = ((k) r5.getValue()).j;     // Catch: Exception -> L126
            r2.c = 0;     // Catch: Exception -> L126
            r2.g = 0;     // Catch: Exception -> L126
            if (((k) r5.getValue()).e == null) goto L23;
            byte[] r6 = ((k) r5.getValue()).e;     // Catch: Exception -> L126
            Iterator r16 = r1;
            if (((k) r5.getValue()).q != 1) goto L22;
            wd r3 = (wd) z7.a(r6, new wd(), false);     // Catch: Exception -> L126
            if (r3 == null) goto L21;
            vj r7 = r3.b;     // Catch: Exception -> L126
            if (r7 == null) goto L21;
            r2.d = r3.f600a;     // Catch: Exception -> L126
            r2.f = z7.a(r7);     // Catch: Exception -> L126
            r2.g = 1;     // Catch: Exception -> L126
            long r22 = r14;
            gh.t(this.f).k().a(r2.f422a, r2.b, r3.b.d);     // Catch: Exception -> L126
        L30:
            if (((k) r5.getValue()).m <= 0) goto L32;
            this.d.sendMessageDelayed(Message.obtain(this.d, r2.b, new e(this, r2.f422a)), ((k) r5.getValue()).m);     // Catch: Exception -> L126
        L32:
            int r15 = ((k) r5.getValue()).h;     // Catch: Exception -> L126
            if (sl.a(r15, 2560) == false) goto L39;
            if ((r15 & 8192) == 0) goto L37;
            r9.add(r2);     // Catch: Exception -> L126
        L58:
            if (((k) r5.getValue()).n <= r22) goto L60;
            r14 = ((k) r5.getValue()).n;     // Catch: Exception -> L126
        L62:
            if (((k) r5.getValue()).m <= r14) goto L66;
            r14 = ((k) r5.getValue()).m;     // Catch: Exception -> L126
        L66:
            gh.t(this.f).k().a("SharkProtocolQueue", r2.f422a, r2.b, r2, 10);     // Catch: Exception -> L126
            r1 = r16;
            goto L68
        L60:
            r14 = r22;
            goto L62
        L37:
            r4.add(r2);     // Catch: Exception -> L126
            goto L58
        L39:
            if (sl.a(r15, 2048) == false) goto L45;
            if ((r15 & 8192) == 0) goto L43;
            r8.add(r2);     // Catch: Exception -> L126
            goto L58
        L43:
            r0.add(r2);     // Catch: Exception -> L126
            goto L58
        L45:
            if (sl.a(r15, 512) == false) goto L51;
            if ((r15 & 8192) == 0) goto L49;
            r11.add(r2);     // Catch: Exception -> L126
            goto L58
        L49:
            r10.add(r2);     // Catch: Exception -> L126
            goto L58
        L51:
            if (sl.a(r15, 1024) == false) goto L54;
            r12.add(r2);     // Catch: Exception -> L126
            goto L58
        L54:
            if ((r15 & 8192) == 0) goto L56;
            r11.add(r2);     // Catch: Exception -> L126
            goto L58
        L56:
            r13.add(r2);     // Catch: Exception -> L126
        L21:
            throw new RuntimeException("bytes to SharkHttpEntity got null, cmd: " + r2.f422a + " SharkHttpEntity: " + r3);     // Catch: Exception -> L126
        L22:
            r22 = r14;
            r2.d = r6;     // Catch: Exception -> L126
            r2.f = null;     // Catch: Exception -> L126
            r2.g = 0;     // Catch: Exception -> L126
            goto L30
        L23:
            r16 = r1;
            r22 = r14;
            JceStruct r17 = ((k) r5.getValue()).d;     // Catch: Exception -> L126
            if (r17 != null) goto L26;
        L28:
            r2.d = z7.a(r17);     // Catch: Exception -> L126
            r2.f = null;     // Catch: Exception -> L126
            r2.g = 0;     // Catch: Exception -> L126
            goto L30
        L26:
            if ((r17 instanceof wd) == false) goto L28;
            wd r18 = (wd) r17;     // Catch: Exception -> L126
            r2.d = r18.f600a;     // Catch: Exception -> L126
            r2.f = z7.a(r18.b);     // Catch: Exception -> L126
            r2.g = 1;     // Catch: Exception -> L126
            gh.t(this.f).k().a(r2.f422a, r2.b, r18.b.d);     // Catch: Exception -> L126
            goto L30
        L69:
            ArrayList r25 = r12;
            ArrayList r26 = r13;
            long r23 = r14;
            ArrayList r19 = this.c;     // Catch: Exception -> L126
            monitor-enter(r19);     // Catch: Exception -> L126
        L123:
            th = move-exception;
            throw th;     // Catch: Exception -> L126
        L72:
            if (this.c.size() <= 0) goto L74;
            ArrayList r20 = (ArrayList) this.c.clone();     // Catch: Throwable -> L123
        L75:
            monitor-exit(r19);     // Catch: Throwable -> L123
            if (r20 == null) goto L121;
            Iterator r21 = r20.iterator();     // Catch: Exception -> L126
        L79:
            if (r21.hasNext() == false) goto L121;
            k r24 = (k) r21.next();     // Catch: Exception -> L126
            if (k.a(r24) == true) goto L82;
            pi r27 = new pi();     // Catch: Exception -> L126
            r27.f422a = r24.c;     // Catch: Exception -> L126
            r27.b = r24.j;     // Catch: Exception -> L126
            r27.c = r24.k;     // Catch: Exception -> L126
            r27.d = null;     // Catch: Exception -> L126
            gj r28 = new gj();     // Catch: Exception -> L126
            r28.f232a = r24.o;     // Catch: Exception -> L126
            r27.e = r28;     // Catch: Exception -> L126
            byte[] r29 = r24.e;     // Catch: Exception -> L126
            if (r29 == null) goto L86;
            r27.d = r29;     // Catch: Exception -> L126
        L87:
            int r30 = r24.h;     // Catch: Exception -> L126
            if (sl.a(r30, 2560) == false) goto L97;
            if ((r30 & 8192) == 0) goto L95;
            r9.add(r27);     // Catch: Exception -> L126
        L120:
            gh.t(this.f).k().a("SharkProtocolQueue", r27.f422a, r27.b, r27, 10);     // Catch: Exception -> L126
            r26 = r26;
            r25 = r25;
            goto L79
        L95:
            r4.add(r27);     // Catch: Exception -> L126
            goto L120
        L97:
            if (sl.a(r30, 2048) == false) goto L104;
            if ((r30 & 8192) == 0) goto L101;
            r8.add(r27);     // Catch: Exception -> L126
            goto L120
        L101:
            r0.add(r27);     // Catch: Exception -> L126
            goto L120
        L104:
            if (sl.a(r30, 512) == false) goto L111;
            if ((r30 & 8192) == 0) goto L108;
            r11.add(r27);     // Catch: Exception -> L126
        L109:
            r25 = r25;
            r26 = r26;
            goto L120
        L108:
            r10.add(r27);     // Catch: Exception -> L126
            goto L109
        L111:
            if (sl.a(r30, 1024) == false) goto L114;
            r25 = r25;
            r25.add(r27);     // Catch: Exception -> L126
        L113:
            r26 = r26;
            goto L120
        L114:
            r25 = r25;
            if ((r30 & 8192) == 0) goto L117;
            r11.add(r27);     // Catch: Exception -> L126
            goto L113
        L117:
            r26 = r26;
            r26.add(r27);     // Catch: Exception -> L126
            goto L120
        L86:
            r27.d = z7.a(r24.d);     // Catch: Exception -> L126
            goto L87
        L82:
            int r31 = r24.c;     // Catch: Exception -> L126
        L121:
            a(2560, false, r4, r23);     // Catch: Exception -> L126
            a(2560, true, r9, r23);     // Catch: Exception -> L126
            a(2048, false, r0, r23);     // Catch: Exception -> L126
            a(2048, true, r8, r23);     // Catch: Exception -> L126
            a(512, false, r10, r23);     // Catch: Exception -> L126
            a(512, true, r11, r23);     // Catch: Exception -> L126
            a(1024, false, r25, r23);     // Catch: Exception -> L126
            a(0, false, r26, r23);     // Catch: Exception -> L126
            return;
        L74:
            r20 = null;
        L126:
            b(-10001200);
        }

        private void a(int r9, boolean r10, ArrayList r11, long r12) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (r11.size() <= 0) goto L9;
            gh.m(this.f).a(r10, r9, r12, r11, new c(this));
            return;
        }

        private void a(boolean r1, int r2, int r3, ArrayList r4) {
            if (r4 != null) goto L5;
            if (r2 != 0) goto L5;
            r2 = -1;
        L5:
            if (r2 != 0) goto L13;
            Iterator r5 = r4.iterator();
        L8:
            if (r5.hasNext() == false) goto L21;
            ij r6 = (ij) r5.next();
            if (a(r6.c) == true) goto L11;
            gh.t(this.f).k().a(r6.c);
            goto L8
        L11:
            a(r6);
            goto L8
        L21:
            return;
        L13:
            b(r2);
        }

        private void a(ij r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            this.d.removeMessages(r10.c);
            TreeMap r0 = this.b;
            monitor-enter(r0);
            k r1 = (k) this.b.get(Integer.valueOf(r10.c));     // Catch: Throwable -> L53
            if (r1 != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L53
            return;
        L10:
            this.b.remove(Integer.valueOf(r10.c));     // Catch: Throwable -> L53
            monitor-exit(r0);     // Catch: Throwable -> L53
            byte[] r2 = r10.f;
            byte[] r3 = null;
            JceStruct r4 = null;
            r4 = null;
            r4 = null;
            r4 = null;
            if (r2 != null) goto L15;
        L44:
            JceStruct r5 = null;
        L46:
            if (r1.g == r3) goto L49;
            r1.g = r3;
        L49:
            if (r1.f == r5) goto L51;
            r1.f = r5;
        L51:
            a(r1, Integer.valueOf(r10.f276a), Integer.valueOf(r10.d), Integer.valueOf(r10.e));
            return;
        L15:
            if (r10.d != 0) goto L44;
        L41:
            r2 = null;
        L42:
            r10.d = j4.d(-11000900);
        L43:
            JceStruct r8 = r4;
            r3 = r2;
            r5 = r8;
            goto L46
        L59:
            if (r10.i != 0) goto L32;
            w6 r6 = r1.i;     // Catch: Exception -> L41
            if (r6 == null) goto L25;
            if ((r6 instanceof v6) == false) goto L25;
        L26:
            if (r4 != null) goto L43;
            if (r2 != null) goto L43;
            if (r1.f == null) goto L58;
            r10.d = j4.d(-11000900);     // Catch: Exception -> L56
        L58:
        L25:
            r4 = z7.b(r2, r1.f, true);     // Catch: Exception -> L41
            r2 = null;
            goto L26
        L32:
            ck r7 = (ck) z7.b(r10.h, new ck(), false);     // Catch: Exception -> L41
            nl r9 = new nl();     // Catch: Exception -> L41
            r9.f377a = r2;     // Catch: Exception -> L41
            r9.b = r7;     // Catch: Exception -> L41
            w6 r11 = r1.i;     // Catch: Exception -> L41
            if (r11 != null) goto L35;
        L38:
            r2 = null;
            r4 = r9;
        L39:
            r1.q = 1;     // Catch: Exception -> L56
            goto L58
        L35:
            if ((r11 instanceof v6) == false) goto L38;
            r2 = z7.a(r9);     // Catch: Exception -> L41
        L53:
            th = move-exception;
            throw th;
        }

        private void a(int r4, int r5, int r6) {
            TreeMap r0 = this.b;
            monitor-enter(r0);
            k r1 = (k) this.b.get(Integer.valueOf(r5));     // Catch: Throwable -> L12
            if (r1 != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L8:
            this.b.remove(Integer.valueOf(r5));     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            a(r1, Integer.valueOf(r4), Integer.valueOf(r6), -1);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private void a(k r12, Integer r13, Integer r14, Integer r15) {
            r12.l.a(2);
            int r16 = j4.d(r14.intValue());
            gh.t(this.f).k().a("SharkProtocolQueue", r13.intValue(), r12.j, 62, r16);
            gh.t(this.f).k().a(r12.j);
            if (r12.i != null) goto L5;
            return;
        L5:
            int r0 = sd.a(r12.h);
            if (r0 != 8) goto L8;
            gh.r(this.f).sendMessage(gh.r(this.f).obtainMessage(11, new Object[]{r12, r13, Integer.valueOf(r16), r15}));
            return;
        L8:
            if (r0 == 16) goto L24;
            d r1 = new d(this, "doCallBack " + r13, System.nanoTime(), r12, r13, r16, r15);
            if (sd.b(r12.h) < 96) goto L12;
            uk.b(r1, "shark-callback");
            return;
        L12:
            uk.a(r1, "shark-callback");
            return;
        L24:
            w6 r2 = r12.i;     // Catch: Throwable -> L22
            if (r2 != null) goto L16;
        L23:
            return;
        L16:
            if ((r2 instanceof v6) == false) goto L18;
            ((v6) r2).a(r12.j, r13.intValue(), r16, r15.intValue(), r12.g);     // Catch: Throwable -> L22
            goto L23
        L18:
            r2.onFinish(r12.j, r13.intValue(), r16, r15.intValue(), r12.f);     // Catch: Throwable -> L22
        }
    }

    private class m extends ri {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ gh f229a;

        public m(gh r1, Looper r2) {
            this.f229a = r1;
            super(r2, "SharkProtocolQueue-MyHandler");
        }

        @Override // tmsdkobf.ri
        public void a(Message r12) {
            int r0 = r12.what;
            if (r0 == 1) goto L66;
            if (r0 != 3) goto L6;
            removeMessages(3);
            if (gh.t(this.f229a).f460a.i == false) goto L64;
            gh.l(this.f229a);
            return;
        L64:
            gh.n(this.f229a);
            return;
        L6:
            if (r0 != 4) goto L8;
            HashSet r13 = new HashSet();
            SparseArray r1 = gh.o(this.f229a);
            monitor-enter(r1);
        L58:
            th = move-exception;
            throw th;
        L33:
            if (gh.o(this.f229a).size() <= 0) goto L41;
            long r2 = System.currentTimeMillis();     // Catch: Throwable -> L58
            int r3 = 0;
        L36:
            if (r3 >= gh.o(this.f229a).size()) goto L41;
            if ((r2 - ((i) gh.o(this.f229a).valueAt(r3)).f222a) < 1800000) goto L40;
            r13.add(Integer.valueOf(gh.o(this.f229a).keyAt(r3)));     // Catch: Throwable -> L58
        L40:
            r3 = r3 + 1;     // Catch: Throwable -> L58
        L41:
            monitor-exit(r1);     // Catch: Throwable -> L58
            if (r13.size() <= 0) goto L127;
            Iterator r14 = r13.iterator();
        L46:
            if (r14.hasNext() == false) goto L132;
            Integer r4 = (Integer) r14.next();
            SparseArray r5 = gh.o(this.f229a);
            monitor-enter(r5);
            i r6 = (i) gh.o(this.f229a).get(r4.intValue());     // Catch: Throwable -> L55
            gh.o(this.f229a).remove(r4.intValue());     // Catch: Throwable -> L55
            monitor-exit(r5);     // Catch: Throwable -> L55
            if (r6 == null) goto L46;
            if (r6.d != 0) goto L46;
            gh r7 = this.f229a;
            ij r8 = r6.c;
            gh.a(r7, r8.b, r6.b, r8.f276a, null, null, -2);
        L55:
            th = move-exception;
            throw th;
        L132:
            return;
        L127:
            return;
        L8:
            if (r0 != 5) goto L130;
            int r15 = r12.arg1;
            TreeMap r9 = gh.p(this.f229a);
            monitor-enter(r9);
            Cif r10 = (Cif) gh.p(this.f229a).get(Integer.valueOf(r15));     // Catch: Throwable -> L27
            monitor-exit(r9);     // Catch: Throwable -> L27
            SparseArray r11 = gh.o(this.f229a);
            monitor-enter(r11);
            i r16 = (i) gh.o(this.f229a).get(r15);     // Catch: Throwable -> L24
            gh.o(this.f229a).delete(r15);     // Catch: Throwable -> L24
            monitor-exit(r11);     // Catch: Throwable -> L24
            if (r10 == null) goto L123;
            if (r16 != null) goto L21;
            return;
        L21:
            if (r16.d != 0) goto L23;
            gh.a(this.f229a, r16.b, r16.c, r10);
            return;
        L23:
            gh.b(this.f229a, r16.b, r16.c, r10);
            return;
        L123:
            return;
        L24:
            th = move-exception;
            throw th;
        L27:
            th = move-exception;
            throw th;
        L130:
            return;
        L66:
            if (gh.a(this.f229a) == true) goto L131;
            gh.b(this.f229a);
            gh r17 = this.f229a;
            Context r18 = gh.q(r17);
            z6 r19 = gh.s(this.f229a);
            gh r20 = this.f229a;
            gh.a(r17, new qg(r18, r19, r20, r20, gh.t(r20)));
            gh.a(this.f229a, uk.a("SharkProtocolQueue-RunPool"));
            gh.a(this.f229a, true);
            ArrayList r110 = gh.u(this.f229a);
            monitor-enter(r110);
            int r21 = gh.u(this.f229a).size();     // Catch: Throwable -> L100
            monitor-exit(r110);     // Catch: Throwable -> L100
            if (r21 <= 0) goto L75;
            gh.v(this.f229a).sendEmptyMessage(3);
        L75:
            if (gh.w(this.f229a) == false) goto L78;
            this.f229a.f();
        L78:
            if (gh.c(this.f229a) == false) goto L81;
            gh.d(this.f229a);
        L81:
            if (gh.e(this.f229a) == false) goto L84;
            gh.f(this.f229a);
        L84:
            if (gh.g(this.f229a) == false) goto L87;
            this.f229a.m();
        L87:
            if (gh.h(this.f229a) == false) goto L90;
            this.f229a.l();
        L90:
            if (gh.i(this.f229a) == false) goto L93;
            this.f229a.n();
        L93:
            if (gh.j(this.f229a) == false) goto L96;
            this.f229a.j();
        L96:
            if (gh.k(this.f229a) == false) goto L98;
            this.f229a.k();
        L98:
            gh.m(this.f229a).h();
            return;
        L100:
            th = move-exception;
            throw th;
        }
    }

    gh(Context r4, z6 r5, ql r6) {
        this.b = false;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.k = new ArrayList();
        this.l = new TreeMap();
        this.m = new SparseArray();
        this.n = new ml(1000);
        this.o = 0;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = new a(this, Looper.getMainLooper());
        this.f220a = r4;
        this.d = r5;
        this.e = r6;
        this.x = new m(this, this.e.h());
        h r7 = new h(this, null);
        this.i = r7;
        h.a(r7, this.f220a);
    }

    static /* synthetic */ boolean a(gh r0) {
        return r0.b;
    }

    static /* synthetic */ void b(gh r0) {
        r0.b();
    }

    static /* synthetic */ boolean c(gh r0) {
        return r0.s;
    }

    static /* synthetic */ void d(gh r0) {
        r0.g();
    }

    static /* synthetic */ boolean e(gh r0) {
        return r0.w;
    }

    static /* synthetic */ void f(gh r0) {
        r0.h();
    }

    static /* synthetic */ boolean g(gh r0) {
        return r0.t;
    }

    static /* synthetic */ boolean h(gh r0) {
        return r0.v;
    }

    static /* synthetic */ boolean i(gh r0) {
        return r0.u;
    }

    static /* synthetic */ boolean j(gh r0) {
        return r0.p;
    }

    static /* synthetic */ boolean k(gh r0) {
        return r0.q;
    }

    static /* synthetic */ void l(gh r0) {
        r0.c();
    }

    static /* synthetic */ qg m(gh r0) {
        return r0.c;
    }

    static /* synthetic */ void n(gh r0) {
        r0.d();
    }

    static /* synthetic */ SparseArray o(gh r0) {
        return r0.m;
    }

    static /* synthetic */ TreeMap p(gh r0) {
        return r0.l;
    }

    static /* synthetic */ Context q(gh r0) {
        return r0.f220a;
    }

    static /* synthetic */ Handler r(gh r0) {
        return r0.y;
    }

    static /* synthetic */ z6 s(gh r0) {
        return r0.d;
    }

    static /* synthetic */ ql t(gh r0) {
        return r0.e;
    }

    static /* synthetic */ ArrayList u(gh r0) {
        return r0.k;
    }

    static /* synthetic */ Handler v(gh r0) {
        return r0.x;
    }

    static /* synthetic */ boolean w(gh r0) {
        return r0.r;
    }

    static /* synthetic */ boolean a(gh r0, boolean r1) {
        r0.b = r1;
        return r1;
    }

    static /* synthetic */ void b(gh r0, long r1, ij r3, Cif r4) {
        r0.c(r1, r3, r4);
    }

    static /* synthetic */ void c(gh r0, int r1, String r2) {
        r0.c(r1, r2);
    }

    static /* synthetic */ void d(gh r0, long r1, ij r3, Cif r4) {
        r0.a(r1, r3, r4);
    }

    private void g() {
        if (this.b == false) goto L5;
        this.c.j();
        return;
    L5:
        this.s = true;
    }

    private void h() {
        if (this.b == false) goto L5;
        this.c.k();
        return;
    L5:
        this.w = true;
    }

    public boolean e() {
        if (this.o <= 0) goto L10;
        long r4 = (System.nanoTime() - this.o) / 1000000;
        if (r4 < 5000) goto L7;
        return false;
    L7:
        if (r4 <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public void f() {
        if (this.b == false) goto L5;
        this.c.g();
        this.c.i();
        return;
    L5:
        this.r = true;
    }

    public void i() {
        this.x.sendEmptyMessage(1);
    }

    public void j() {
        if (this.b == false) goto L5;
        this.c.d().p();
        return;
    L5:
        this.p = true;
    }

    public void k() {
        if (this.b == false) goto L5;
        this.c.d().q();
        return;
    L5:
        this.q = true;
    }

    public void l() {
        if (this.b == false) goto L5;
        this.c.m();
        return;
    L5:
        this.v = true;
    }

    public void m() {
        if (this.b == false) goto L5;
        this.c.n();
        return;
    L5:
        this.t = true;
    }

    public void n() {
        if (this.b == false) goto L5;
        this.c.o();
        return;
    L5:
        this.u = true;
    }

    static /* synthetic */ qg a(gh r0, qg r1) {
        r0.c = r1;
        return r1;
    }

    static /* synthetic */ void b(gh r0, int r1, String r2) {
        r0.b(r1, r2);
    }

    static /* synthetic */ void c(gh r0, long r1, ij r3, Cif r4) {
        r0.b(r1, r3, r4);
    }

    private void d() {
        boolean r0 = e();
        ArrayList r1 = this.k;
        monitor-enter(r1);
        Iterator r2 = this.k.iterator();     // Catch: Throwable -> L22
    L6:
        if (r2.hasNext() == false) goto L20;
        k r3 = (k) r2.next();     // Catch: Throwable -> L22
        if (r0 == false) goto L12;
        if (sd.b(r3.h) < 96) goto L6;
    L12:
        r2.remove();     // Catch: Throwable -> L22
        if (r3.l.a() == true) goto L6;
        l r4 = new l(this, "SharkSendTaskRunnable", null);     // Catch: Throwable -> L22
        if ((r3.h & 1073741824) != 0) goto L18;
        r4.a(Integer.valueOf(r3.j), r3);     // Catch: Throwable -> L22
    L19:
        this.j.submit(r4);     // Catch: Throwable -> L22
        goto L6
    L18:
        r4.a(r3);     // Catch: Throwable -> L22
        goto L19
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ WeakReference a(gh r0, int r1, long r2, int r4, JceStruct r5, byte[] r6, int r7) {
        return r0.a(r1, r2, r4, r5, r6, r7);
    }

    private void c() {
        l r0 = new l(this, "SharkSendTaskRunnable", null);
        boolean r1 = e();
        ArrayList r2 = this.k;
        monitor-enter(r2);
        Iterator r3 = this.k.iterator();     // Catch: Throwable -> L24
        int r4 = 0;
    L6:
        if (r3.hasNext() == false) goto L20;
        k r5 = (k) r3.next();     // Catch: Throwable -> L24
        if (r1 == false) goto L12;
        if (sd.b(r5.h) < 96) goto L6;
    L12:
        r3.remove();     // Catch: Throwable -> L24
        if (r5.l.a() == true) goto L6;
        if ((r5.h & 1073741824) != 0) goto L18;
        r0.a(Integer.valueOf(r5.j), r5);     // Catch: Throwable -> L24
    L19:
        r4 = r4 + 1;     // Catch: Throwable -> L24
        goto L6
    L18:
        r0.a(r5);     // Catch: Throwable -> L24
        goto L19
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L24
        if (r4 <= 0) goto L39;
        this.j.submit(r0);
        return;
    L39:
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // tmsdkobf.qg.k
    public long b(boolean r12, int r13, ij r14) {
        if (r14 != null) goto L5;
    L32:
        return -1;
    L5:
        if (jk.a(r14) == false) goto L32;
        if (r14.d == 0) goto L10;
        return -1;
    L10:
        TreeMap r0 = this.l;
        monitor-enter(r0);
        Cif r1 = (Cif) this.l.get(Integer.valueOf(r14.f276a));     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        if (r1 != null) goto L24;
        SparseArray r2 = this.m;
        monitor-enter(r2);
        this.m.append(r14.f276a, new i(1, System.currentTimeMillis(), 0, r14));     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        this.x.removeMessages(4);
        this.x.sendEmptyMessageDelayed(4, 1800000);
        return -1;
    L21:
        th = move-exception;
        throw th;
    L24:
        c(0, r14, r1);
        Object r11 = r1.c;
        if (r11 != null) goto L27;
        return -1;
    L27:
        return ((j) r11).b;
    L29:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(gh r0, long r1, ij r3, Cif r4) {
        r0.d(r1, r3, r4);
    }

    static /* synthetic */ void a(gh r0, int r1, String r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ ExecutorService a(gh r0, ExecutorService r1) {
        r0.j = r1;
        return r1;
    }

    public WeakReference a(int r16, int r17, int r18, long r19, long r21, int r23, JceStruct r24, byte[] r25, JceStruct r26, int r27, w6 r28, x6 r29, long r30, long r32, int r34) {
        if (r18 > 0) goto L5;
        k r14 = new k(r16, r17, r21, r23, r24, r25, r26, r27, r28, r29);
        r14.q = r34;
        r14.m = r30;
        r14.n = r32;
        ArrayList r1 = this.k;
        monitor-enter(r1);
        this.k.add(r14);     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
        if (sd.b(r27) < 96) goto L13;
        boolean r2 = true;
    L14:
        boolean r8 = r2;
        if (r24 != null) goto L17;
    L20:
        String r3 = null;
    L21:
        String r9 = r3;
        this.e.k().a(r14.j, r23, r30, null, false, r8, r9);
        this.e.k().a("SharkProtocolQueue", r23, r14.j, null, 0);
        if (this.b == false) goto L25;
        this.x.sendEmptyMessage(3);
    L25:
        return new WeakReference(r14.l);
    L17:
        if ((r24 instanceof wd) == false) goto L20;
        r3 = ((wd) r24).b.d;     // Catch: Exception -> L29
    L13:
        r2 = false;
    L26:
        th = move-exception;
        throw th;
    L5:
        return a(r18, r19, r23, r24, r25, 1);
    }

    private void d(long r10, ij r12, Cif r13) {
        this.e.b(new e(this, "handleCallbackForPush", r10, r12, r13), "handleCallbackForPush");
    }

    @Override // tmsdkobf.qg.k
    public long a(boolean r17, int r18, ij r19) {
        if (r19 != null) goto L5;
    L39:
        return -1;
    L5:
        if (jk.b(r19) == false) goto L39;
        fk r1 = r19.g;
        if (r1 == null) goto L10;
        long r2 = r1.f206a;
    L11:
        long r10 = r2;
        a(r10, r19.f276a, r18, r19.b);
        if (r19.d == 0) goto L15;
        return -1;
    L15:
        if (this.n.a(Long.valueOf(r10)) == false) goto L17;
        return -1;
    L17:
        this.n.b(Long.valueOf(r10));
        TreeMap r3 = this.l;
        monitor-enter(r3);
        Cif r4 = (Cif) this.l.get(Integer.valueOf(r19.f276a));     // Catch: Throwable -> L36
        monitor-exit(r3);     // Catch: Throwable -> L36
        if (r4 != null) goto L31;
        SparseArray r12 = this.m;
        monitor-enter(r12);
        this.m.append(r19.f276a, new i(0, System.currentTimeMillis(), r10, r19));     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
        this.x.removeMessages(4);
        this.x.sendEmptyMessageDelayed(4, 1800000);
        return -1;
    L28:
        th = move-exception;
        throw th;
    L31:
        d(r10, r19, r4);
        Object r0 = r4.c;
        if (r0 != null) goto L34;
        return -1;
    L34:
        return ((j) r0).b;
    L36:
        th = move-exception;
        throw th;
    L10:
        r2 = 0;
        goto L11
    }

    private void c(int r8, String r9) {
        ArrayList r3 = new ArrayList();
        List r0 = this.h;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.h.size() <= 0) goto L7;
        r3.addAll(this.h);     // Catch: Throwable -> L12
        this.h.clear();     // Catch: Throwable -> L12
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r3.size() <= 0) goto L17;
        uk.a(new d(this, "shark-callback: notifyVidTicketGot", r3, r8, r9), "shark-callback: notifyVidTicketGot");
        return;
    }

    private void c(long r10, ij r12, Cif r13) {
        this.e.b(new f(this, "handleCallbackForGift", r10, r12, r13), "handleCallbackForGift");
    }

    private void b() {
        f6 r0 = this.e.f460a.y;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.d.a(r0.a()) == true) goto L15;
        String r1 = r0.a(this.e.f460a.k);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.d.c(r1);
        this.d.d(r1);
    L10:
        String r2 = r0.b(this.e.f460a.k);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        this.d.c(r2, false);
        this.d.d(r2, false);
    L13:
        this.d.e(r0.a(), true);
        return;
    }

    private void b(int r8, String r9) {
        ArrayList r3 = new ArrayList();
        List r0 = this.g;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.g.size() <= 0) goto L7;
        r3.addAll(this.g);     // Catch: Throwable -> L12
        this.g.clear();     // Catch: Throwable -> L12
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r3.size() <= 0) goto L17;
        uk.a(new c(this, "shark-callback: notifyVidGot", r3, r8, r9), "shark-callback: notifyVidGot");
        return;
    }

    private void b(long r11, ij r13, Cif r14) {
        byte[] r0 = r13.f;
        if (r0 != null) goto L5;
    L9:
        JceStruct r7 = null;
    L20:
        Object r1 = r14.b;     // Catch: Throwable -> L17
        if (((j) r14.c).f223a == true) goto L15;
        Cif r15 = ((a7) r1).a(r13.b, r11, r13.f276a, r7);     // Catch: Throwable -> L17
        if (r15 == null) goto L21;
        a(r13.b, r11, ((Integer) r15.b).intValue(), (JceStruct) r15.c, null, 1);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L15:
        ua.a(r1);     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.d.a(new Thread(), th, "handleCallbackForPush exception", null);
        return;
    L5:
        if (((j) r14.c).f223a == true) goto L9;
        Object r2 = r14.f272a;
        if (r2 == null) goto L9;
        r7 = z7.b(r0, (JceStruct) r2, true);
        goto L20
    }

    public void a(long r5, int r7, JceStruct r8, int r9, a7 r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        TreeMap r12 = this.l;
        monitor-enter(r12);
        this.l.put(Integer.valueOf(r7), new Cif(r8, r10, new j(r11, r5)));     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        if (this.b == false) goto L17;
        this.x.obtainMessage(5, r7, 0).sendToTarget();
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public a7 a(int r3, int r4) {
        TreeMap r5 = this.l;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.l.containsKey(Integer.valueOf(r3)) == false) goto L7;
        a7 r2 = (a7) ((Cif) this.l.remove(Integer.valueOf(r3))).b;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    @Override // tmsdkobf.qg.l
    public void a(j6 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List r0 = this.f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f.contains(r3) == true) goto L9;
        this.f.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // tmsdkobf.qg.l
    public void a(o7 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List r0 = this.g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.g.contains(r3) == true) goto L9;
        this.g.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // tmsdkobf.qg.l
    public void a(p7 r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List r0 = this.h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.h.contains(r3) == true) goto L9;
        this.h.add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    private void a(int r8, String r9) {
        ArrayList r3 = new ArrayList();
        List r0 = this.f;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f.size() <= 0) goto L7;
        r3.addAll(this.f);     // Catch: Throwable -> L12
        this.f.clear();     // Catch: Throwable -> L12
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r3.size() <= 0) goto L17;
        uk.a(new b(this, "shark-callback: notifyGuidGot", r3, r8, r9), "shark-callback: notifyGuidGot");
        return;
    }

    private void a(long r9, ij r11, Cif r12) {
        byte[] r0 = r11.f;
        if (r0 != null) goto L5;
    L9:
        JceStruct r7 = null;
    L20:
        Object r1 = r12.b;     // Catch: Throwable -> L17
        if (((j) r12.c).f223a == true) goto L15;
        Cif r10 = ((a7) r1).a(r11.b, r9, r11.f276a, r7);     // Catch: Throwable -> L17
        if (r10 == null) goto L21;
        a(r11.b, ((Integer) r10.b).intValue(), (JceStruct) r10.c);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L15:
        ua.a(r1);     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.d.a(new Thread(), th, "handleCallbackForGift exception", null);
        return;
    L5:
        if (((j) r12.c).f223a == true) goto L9;
        Object r2 = r12.f272a;
        if (r2 == null) goto L9;
        r7 = z7.b(r0, (JceStruct) r2, true);
        goto L20
    }

    private void a(long r16, int r18, int r19, int r20) {
        if (r18 != 11306) goto L5;
        return;
    L5:
        k r14 = new k(Process.myPid(), 0, 0, r18, null, new byte[0], null, 1073741824, null, null);
        r14.k = r20;
        r14.o = r16;
        ArrayList r1 = this.k;
        monitor-enter(r1);
        this.k.add(r14);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        this.e.k().a(r14.j, r18, -1, "push-ar-cmd_" + r18, true, false);
        this.e.k().a(r14.j);
        if (this.b == false) goto L18;
        this.x.sendEmptyMessage(3);
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private WeakReference a(int r16, long r17, int r19, JceStruct r20, byte[] r21, int r22) {
        vh r8 = new vh();
        r8.f584a = r19;
        r8.c = r22;
        if (r21 != null) goto L5;
    L7:
        if (r20 == null) goto L9;
        r8.b = z7.a(r20);
    L9:
        k r14 = new k(0, 0, -1, 1103, r8, z7.a(r8), null, 1073741824, null, null);
        r14.k = r16;
        r14.o = r17;
        ArrayList r2 = this.k;
        monitor-enter(r2);
        this.k.add(r14);     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        this.e.k().a(r14.j, 1103, -1, "push-br-cmd_" + r19, true, false);
        if (this.b == false) goto L17;
        this.x.sendEmptyMessage(3);
    L17:
        return new WeakReference(r14.l);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r21.length <= 0) goto L7;
        r8.b = r21;
        goto L9
    }

    private WeakReference a(int r9, int r10, JceStruct r11) {
        return this.e.a(r10, r11, null, 0, new g(this), 60000);
    }

    public void a() {
        if (this.b == false) goto L6;
        this.c.d().i();
        return;
    }
}
