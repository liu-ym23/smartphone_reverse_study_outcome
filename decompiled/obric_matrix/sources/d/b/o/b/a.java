package d.b.o.b;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.r.e;
import com.bytedance.apm.r.h;
import com.bytedance.apm.r.m.f;
import com.bytedance.apm.r.m.g;
import com.bytedance.monitor.collector.k;
import com.bytedance.monitor.collector.o;
import d.b.b.o.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.r.a implements e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static a f14181j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static d.b.o.b.b f14182k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f14183l = 0;
    public static boolean m = false;
    public static boolean n = false;
    private static volatile boolean o = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f14184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f.C0061f f14185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f.C0061f f14186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile String f14187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long[] f14188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f14189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f14190h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14191i;

    /* JADX INFO: renamed from: d.b.o.b.a$a, reason: collision with other inner class name */
    class RunnableC0382a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f14192f;

        RunnableC0382a(a r1) {
            this.f14192f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.r.m.e.A().M(this.f14192f);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long[] f14193f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f14194g;

        b(a r1, long[] r2, long r3) {
            this.f14193f = r2;
            this.f14194g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r0 = new LinkedList();
            d.b.o.a.a.j(this.f14193f, r0, true, com.bytedance.monitor.collector.a.f5105b);
            d.b.o.a.a.f(r0, 5);
            com.bytedance.monitor.collector.d.a r1 = k.n().p();
            if (r1 != null) goto L6;
            return;
        L6:
            if (r0.size() > 2) goto L8;
            return;
        L8:
            r1.b("method_tracer", "in," + this.f14194g);
            Iterator r5 = r0.iterator();
        L10:
            if (r5.hasNext() == false) goto L12;
            r1.b("method_tracer", ((g) r5.next()).toString());
            goto L10
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f14195f;

        c(String r1) {
            this.f14195f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r4 = new JSONObject();     // Catch: JSONException -> L4
            r4.put("evil_method_section", this.f14195f);     // Catch: JSONException -> L4
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.c("evil_method_tracing", 0, null, r4, null, null));     // Catch: JSONException -> L4
            return;
        }
    }

    private class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f14196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f14197g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long[] f14198h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f14199i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f14200j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f14201k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f14202l;
        String m;
        String n;
        long o;
        com.bytedance.monitor.collector.g.i p;

        /* JADX INFO: renamed from: d.b.o.b.a$d$a, reason: collision with other inner class name */
        class C0383a implements d.b.o.a.a.b {
            C0383a(d r1) {
            }

            @Override // d.b.o.a.a.b
            public boolean a(long r3, int r5) {
                if (r3 >= (r5 * 5)) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // d.b.o.a.a.b
            public int b() {
                return 60;
            }

            @Override // d.b.o.a.a.b
            public void c(List<g> r4, int r5) {
                if (com.bytedance.apm.d.C() == false) goto L5;
                com.bytedance.apm.x.g.c("EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r5), 30, r4});
            L5:
                ListIterator<g> r3 = r4.listIterator(Math.min(r5, 30));
            L7:
                if (r3.hasNext() == false) goto L9;
                r3.next();
                r3.remove();
                goto L7
            }
        }

        d(a r4, boolean r5, String r6, long[] r7, long[] r8, long r9, long r11, long r13, String r15, long r16, String r18, com.bytedance.monitor.collector.g.i r19) {
            this.f14202l = r6;
            this.f14200j = r11;
            this.f14199i = r9;
            this.f14198h = r7;
            this.f14201k = r13;
            this.m = r15;
            this.o = r16;
            this.n = r18;
            this.p = r19;
        }

        static /* synthetic */ boolean a(d r0, boolean r1) {
            r0.f14197g = r1;
            return r1;
        }

        static /* synthetic */ boolean b(d r0, boolean r1) {
            r0.f14196f = r1;
            return r1;
        }

        void c() {
            LinkedList r2 = new LinkedList();     // Catch: Exception -> L14
            long[] r3 = this.f14198h;     // Catch: Exception -> L14
            if (r3.length <= 0) goto L7;
            d.b.o.a.a.j(r3, r2, true, this.f14201k);     // Catch: Exception -> L14
            d.b.o.a.a.m(r2, 30, new C0383a(this));     // Catch: Exception -> L14
        L7:
            if (r2.size() > 2) goto L9;
            return;
        L9:
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L14
            long r5 = Math.max(this.f14200j, d.b.o.a.a.g(r2, r4));     // Catch: Exception -> L14
            String r6 = d.b.o.a.a.d(r2, r5);     // Catch: Exception -> L14
            JSONObject r7 = new JSONObject();     // Catch: Exception -> L14
            String r8 = r4.toString();     // Catch: Exception -> L14
            com.bytedance.monitor.collector.g.i r9 = this.p;     // Catch: Exception -> L14
            if (r9 == null) goto L12;
            r9.f(this.n, null, null, r8);     // Catch: Exception -> L14
        L12:
            r7.put("stack", r8);     // Catch: Exception -> L14
            r7.put("stack_key", r6);     // Catch: Exception -> L14
            r7.put("scene", this.f14202l);     // Catch: Exception -> L14
            r7.put("cost_time", r5);     // Catch: Exception -> L14
            r7.put("cpu_cost", this.f14199i);     // Catch: Exception -> L14
            r7.put("method_time", r5);     // Catch: Exception -> L14
            k r10 = k.n();     // Catch: Exception -> L14
            long r11 = this.f14201k;     // Catch: Exception -> L14
            JSONObject r12 = r10.f(r11 - this.f14200j, r11);     // Catch: Exception -> L14
            f r13 = f.E();     // Catch: Exception -> L14
            long r14 = this.f14201k;     // Catch: Exception -> L14
            r12.put("evil_method", r13.D(r14 - this.f14200j, r14));     // Catch: Exception -> L14
            r7.put("custom", r12);     // Catch: Exception -> L14
            r7.put("message", o.b(this.m));     // Catch: Exception -> L14
            r7.put("timestamp", this.f14201k);     // Catch: Exception -> L14
            r7.put("event_type", "lag_drop_frame");     // Catch: Exception -> L14
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L14
            r15.put("crash_section", com.bytedance.apm.d.B(this.o));     // Catch: Exception -> L14
            r15.put("block_frame", String.valueOf(this.f14197g));     // Catch: Exception -> L14
            r15.put("block_input", String.valueOf(this.f14196f));     // Catch: Exception -> L14
            r15.put("trace_type", "message");     // Catch: Exception -> L14
            r15.put("update_version_code", com.bytedance.apm.d.l().optString("update_version_code"));     // Catch: Exception -> L14
            r7.put("filters", r15);     // Catch: Exception -> L14
            com.bytedance.apm.t.c.a.p().e(new com.bytedance.apm.t.d.d("drop_frame_stack", r7));     // Catch: Exception -> L14
            a.i("evil_method_end");     // Catch: Exception -> L14
            return;
        L14:
            a.i("evil_method_analyse_exception");
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    static {
    }

    public a(boolean r1) {
        this(false, false);
    }

    public a(boolean r3, boolean r4) {
        this.f14184b = false;
        this.f14188f = new long[3];
        this.f14189g = 0;
        this.f14190h = null;
        this.f14191i = false;
        if (r4 == true) goto L6;
        j();
    L6:
        if (f14181j != null) goto L9;
        f14181j = this;
        return;
    }

    static /* synthetic */ void i(String r0) {
        k(r0);
    }

    private static void k(String r2) {
        com.bytedance.apm.f0.b.f().i(new c(r2));
    }

    public static void l(d.b.o.b.b r0) {
        f14182k = r0;
    }

    public static void m(long r2) {
        if (r2 >= 70) goto L5;
        r2 = 1000;
    L5:
        f14183l = r2;
    }

    public static void n(boolean r0) {
        n = r0;
    }

    @Override // com.bytedance.apm.r.e
    public void a(boolean r1, long r2) {
        m(r2);
        n = r1;
        if (r1 == true) goto L6;
        i.a(new RunnableC0382a(this));
        f.E().L();
        return;
    }

    @Override // com.bytedance.apm.r.a
    public void c(String r6) {
        super.c(r6);
        f.G(1048574, com.bytedance.monitor.collector.a.f5105b);
        if ((com.bytedance.monitor.collector.a.f5105b - this.f14189g) <= 300) goto L9;
        this.f14186d = this.f14185c;
        this.f14189g = com.bytedance.monitor.collector.a.f5105b;
        this.f14185c = f.I("EvilMethodTracer#dispatchBegin", 0);
        if (this.f14184b == false) goto L9;
        if (this.f14186d == null) goto L9;
        long[] r0 = f.E().w(this.f14186d);     // Catch: Throwable -> L11
        long r1 = com.bytedance.monitor.collector.a.f5105b;     // Catch: Throwable -> L11
        k.n().r().f(new b(this, r0, r1));     // Catch: Throwable -> L11
    L9:
        this.f14187e = r6;
    }

    @Override // com.bytedance.apm.r.a
    public void d(long r19, long r21, long r23, long r25, boolean r27) {
        super.d(r19, r21, r23, r25, r27);
        f.J(1048574, com.bytedance.monitor.collector.a.f5105b);
        d r1 = this.f14190h;
        if (r1 == null) goto L6;
        d.a(r1, r27);
        d.b(this.f14190h, com.bytedance.apm.r.m.e.A().f1891b.b());
        com.bytedance.apm.f0.b.f().i(this.f14190h);
        this.f14190h = null;
    L6:
        if (f.E().H() == true) goto L8;
        return;
    L8:
        long r8 = r23 - r19;
        if (r8 < f14183l) goto L25;
        d.b.o.b.b r2 = f14182k;
        if (r2 == null) goto L13;
        r2.a(r8, r27);
    L13:
        k("evil_method_begin");
        long[] r4 = f.E().w(this.f14185c);
        if (r4 != null) goto L16;
    L23:
        k("evil_method_data_null");
        return;
    L16:
        if (r4.length == 0) goto L23;
        long[] r5 = new long[3];
        System.arraycopy(this.f14188f, 0, r5, 0, 3);
        String r0 = h.b();
        if (TextUtils.isEmpty(r0) == false) goto L21;
        String r3 = ActivityLifeObserver.getInstance().getTopActivityClassName();
    L22:
        String r12 = this.f14187e;
        this.f14190h = new d(this, ActivityLifeObserver.getInstance().isForeground(), r3, r4, r5, r25 - r21, r8, r23, r12, System.currentTimeMillis(), "uuid", k.n().o());
        return;
    L21:
        r3 = r0 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();
        goto L22
    }

    public void j() {
        if (o == false) goto L5;
        return;
    L5:
        com.bytedance.apm.r.f.a(this);
        o = true;
    }

    public void o(boolean r1) {
    }

    public synchronized void p() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f14191i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (n == true) goto L10;
    L12:
        this.f14191i = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (m == false) goto L12;
        com.bytedance.apm.r.m.e.A().u(this);     // Catch: Throwable -> L15
        goto L12
    }
}
