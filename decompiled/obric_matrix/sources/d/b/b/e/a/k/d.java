package d.b.b.e.a.k;

import com.bytedance.common.utility.i;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class d implements d.b.b.e.a.l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedHashMap<f, ConcurrentLinkedQueue<C0331d>> f12673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.o.o.a f12674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12678f;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f12679i;

        a(d r1, long r2, long r4) {
            this.f12679i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((System.currentTimeMillis() - d.d(this.f12679i)) < d.f(this.f12679i)) goto L14;
        L8:
            th = move-exception;
            d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "send", th);
        L10:
            d.e(this.f12679i, System.currentTimeMillis());
            return;
        L5:
            if (d.g(this.f12679i) == true) goto L10;
            d.h(this.f12679i);     // Catch: Throwable -> L8
            goto L10
        }
    }

    class b implements Comparator<File> {
        b(d r1) {
        }

        public int a(File r1, File r2) {
            return r1.compareTo(r2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(File r1, File r2) {
            return a(r1, r2);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f12680a = null;

        static {
            f12680a = new d(null);
        }

        static /* synthetic */ d a() {
            return f12680a;
        }
    }

    /* JADX INFO: renamed from: d.b.b.e.a.k.d$d, reason: collision with other inner class name */
    private static final class C0331d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte[] f12681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f12682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f12683c;

        C0331d(byte[] r1, int r2, long r3) {
            this.f12681a = r1;
            this.f12682b = r2;
            this.f12683c = r3;
        }
    }

    private d() {
        this.f12673a = new LinkedHashMap();
        this.f12675c = 30000;
        this.f12676d = 0;
        this.f12677e = 1;
        this.f12678f = false;
    }

    /* synthetic */ d(a r1) {
        this();
    }

    static /* synthetic */ long d(d r2) {
        return r2.f12676d;
    }

    static /* synthetic */ long e(d r0, long r1) {
        r0.f12676d = r1;
        return r1;
    }

    static /* synthetic */ long f(d r2) {
        return r2.f12675c;
    }

    static /* synthetic */ boolean g(d r0) {
        return r0.f12678f;
    }

    static /* synthetic */ void h(d r0) {
        r0.m();
    }

    private void i(List<d.b.b.e.a.j.a> r4) {
        Iterator<d.b.b.e.a.j.a> r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        d.b.b.e.a.j.a r5 = r3.next();
    L10:
        d.b.b.o.m.b.f(d.b.b.e.a.a.f12571a, "delete LogFile's source File failed. logFile=" + r5.d());
        goto L4
    L7:
        if (r5.d() == null) goto L4;
        d.b.b.o.c.a(r5.d());     // Catch: Exception -> L10
        goto L4
    }

    public static d j() {
        return c.a();
    }

    private void l() {
        this.f12677e = 1;
        this.f12675c = 30000;
    }

    private void m() {
        if (i.o(d.b.b.o.a.b()) == true) goto L5;
        return;
    L5:
        if (d.b.b.e.a.k.c.e().j() == false) goto L21;
        if (d.b.b.o.a.c() == false) goto L9;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "trigger send.");
    L9:
        boolean r0 = p();
        if (d.b.b.i.c.a.A() == false) goto L12;
        r0 = n();
    L12:
        if (r0 == false) goto L15;
        l();
        goto L21
    L15:
        if (this.f12675c >= 120000) goto L18;
        long r4 = this.f12677e;
        this.f12675c = (r4 + 1) * 30000;
        this.f12677e = r4 + 1;
    L18:
        if (this.f12675c <= 120000) goto L21;
        this.f12675c = 120000;
    L21:
        if (d.b.b.o.a.c() == true) goto L23;
        return;
    L23:
        if (d.b.b.e.a.k.c.e().j() == true) goto L28;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "report log disable");
        return;
    }

    private boolean n() {
        Iterator<f> r9 = g.c().iterator();
        boolean r1 = true;
    L4:
        if (r9.hasNext() == false) goto L24;
        f r2 = r9.next();
        File r3 = d.b.b.e.a.k.a.g().i(r2.getName());
        if (r3 == null) goto L4;
        if (r3.exists() == false) goto L4;
        if (e.h(r2).k(d.b.b.o.c.e(r3)) == true) goto L13;
        d.b.b.e.a.k.a.c r4 = d.b.b.e.a.k.a.g().h(r3);
        if (r4 == null) goto L19;
        int r5 = r4.c() + 1;
    L20:
        long r6 = d.b.b.e.a.k.c.e().g(r5) + System.currentTimeMillis();
        d.b.b.e.a.k.a.g().m(r3, r5, r6);
        if (d.b.b.o.a.c() == false) goto L23;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendfile error retry count:" + r3.getName() + "  " + r5 + " nextRetryTime:" + r6);
    L23:
        r1 = false;
        goto L4
    L19:
        r5 = 0;
        goto L20
    L13:
        if (d.b.b.o.a.c() == false) goto L15;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendFile: success");
    L15:
        d.b.b.e.a.k.a.g().c(r3);
        goto L4
    L24:
        return r1;
    }

    private boolean p() {
        if (this.f12673a.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<f> r0 = this.f12673a.keySet().iterator();
        boolean r2 = true;
    L7:
        if (r0.hasNext() == false) goto L35;
        f r3 = r0.next();
        ConcurrentLinkedQueue<C0331d> r4 = this.f12673a.get(r3);
        if (r4 == null) goto L7;
        C0331d[] r6 = (C0331d[]) r4.toArray(new C0331d[0]);
        C0331d r7 = null;
        int r8 = r6.length;
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L20;
        C0331d r10 = r6[r9];
        if (r10.f12682b <= 0) goto L19;
        if ((System.currentTimeMillis() - r10.f12683c) > 0) goto L19;
        r9 = r9 + 1;
    L19:
        r7 = r10;
    L20:
        if (r7 == null) goto L22;
    L24:
        if (r7 == null) goto L7;
        if (d.b.b.o.a.c() == false) goto L29;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendMemory");
    L29:
        boolean r5 = e.h(r3).k(r7.f12681a);
        if (r5 == false) goto L32;
        r4.remove(r7);
    L33:
        if (r5 == true) goto L7;
        r2 = false;
        goto L7
    L32:
        r7.f12682b++;
        r7.f12683c = d.b.b.e.a.k.c.e().g(r7.f12682b) + System.currentTimeMillis();
        goto L33
    L22:
        if (r4.size() <= 0) goto L24;
        r7 = r4.peek();
        goto L24
    L35:
        return r2;
    }

    @Override // d.b.b.e.a.l.d
    public long a() {
        File[] r6 = d.b.b.e.a.k.a.g().k();
        long r0 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r0 = r0 + r6[r3].length();
        r3 = r3 + 1;
        goto L6
    L8:
        return r0;
    }

    @Override // d.b.b.e.a.l.d
    public void b(long r6) {
        File[] r5 = d.b.b.e.a.k.a.g().k();
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        File r2 = r5[r1];
        if (d.b.b.e.a.k.a.e(r2) > r6) goto L10;
        d.b.b.o.c.a(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    @Override // d.b.b.e.a.l.d
    public void c(long r10) {
        File[] r0 = d.b.b.e.a.k.a.g().k();
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.sort(r0, new b(this));
        int r9 = r0.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L6:
        if (r4 >= r9) goto L13;
        File r7 = r0[r4];
        if (r7.exists() == false) goto L12;
        if (r7.isFile() == false) goto L12;
        r5 = r5 + r7.length();
    L12:
        r4 = r4 + 1;
        goto L6
    L13:
        int r11 = r0.length;
    L14:
        if (r1 >= r11) goto L36;
        File r6 = r0[r1];
        if ((r5 - r2) <= r10) goto L25;
        if (r6.exists() == false) goto L24;
        if (r6.isFile() == false) goto L24;
        long r8 = r6.length();
        if (d.b.b.o.c.b(r6) == false) goto L24;
        r2 = r2 + r8;
    L24:
        r1 = r1 + 1;
        goto L14
    L25:
        return;
    }

    @Override // d.b.b.e.a.l.d
    public String getName() {
        return "second_log_dir";
    }

    public void k() {
        this.f12674b = new a(this, 0, 30000);
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13066f).c(this.f12674b);
    }

    public void o(List<d.b.b.e.a.j.a> r19, int r20) {
    L62:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "sendLog", th);
        return;
    L4:
        if (d.b.b.e.a.k.c.e().k() == true) goto L6;
        Map<f, byte[]> r1 = g.d(r19, r20);     // Catch: Throwable -> L62
        if (r1 != null) goto L18;
        i(r19);     // Catch: Throwable -> L62
        return;
    L18:
        boolean r2 = i.o(d.b.b.o.a.b());     // Catch: Throwable -> L62
        Iterator<f> r3 = r1.keySet().iterator();     // Catch: Throwable -> L62
        boolean r5 = false;
    L20:
        if (r3.hasNext() == false) goto L58;
        f r6 = r3.next();     // Catch: Throwable -> L62
        byte[] r7 = r1.get(r6);     // Catch: Throwable -> L62
        if (r7 == null) goto L20;
        if (d.b.b.e.a.k.c.e().j() == false) goto L36;
        if (r2 == false) goto L36;
        if (d.b.b.o.a.c() == false) goto L30;
        com.bytedance.apm.doctor.a.d(r7);     // Catch: Throwable -> L62
    L30:
        boolean r8 = e.h(r6).k(r7);     // Catch: Throwable -> L62
        if (d.b.b.o.a.c() == false) goto L35;
        if (r8 == false) goto L34;
        com.bytedance.apm.doctor.a.h(r7);     // Catch: Throwable -> L62
        goto L35
    L34:
        com.bytedance.apm.doctor.a.f(r7);     // Catch: Throwable -> L62
    L35:
        this.f12676d = System.currentTimeMillis();     // Catch: Throwable -> L62
        r5 = r5 | r8;     // Catch: Throwable -> L62
        int r14 = 1;
    L38:
        if (d.b.b.o.a.c() == false) goto L40;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "sendDirect:isReportLogEnable " + d.b.b.e.a.k.c.e().j() + " :sendResult " + r8);     // Catch: Throwable -> L62
    L40:
        if (r8 == true) goto L56;
        long r12 = d.b.b.e.a.k.c.e().g(r14);     // Catch: Throwable -> L62
        long r10 = System.currentTimeMillis() + r12;     // Catch: Throwable -> L62
        if (d.b.b.i.c.a.A() == false) goto L44;
        long r16 = r10;
        r8 = d.b.b.e.a.k.a.g().l(r7, r6.getName(), r14, r16);     // Catch: Throwable -> L62
    L46:
        if (d.b.b.o.a.c() == false) goto L48;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "saveFile:Result:" + r8 + ":isMaiProcess:" + d.b.b.i.c.a.A() + " :" + r14 + " " + r12);     // Catch: Throwable -> L62
    L48:
        if (r8 == false) goto L50;
    L57:
        r5 = r5;
        goto L20
    L50:
        if (this.f12673a.containsKey(r6) == false) goto L52;
        ConcurrentLinkedQueue<C0331d> r4 = this.f12673a.get(r6);     // Catch: Throwable -> L62
    L54:
        if (r4.size() <= 10) goto L57;
        r4.poll();     // Catch: Throwable -> L62
        goto L57
    L52:
        r4 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L62
        r4.add(new C0331d(r7, r14, r16));     // Catch: Throwable -> L62
        goto L54
    L44:
        r16 = r10;
        goto L46
    L56:
        r5 = r5;
    L36:
        r8 = false;
        r14 = 0;
        goto L38
    L58:
        if (r5 == false) goto L60;
        l();     // Catch: Throwable -> L62
    L60:
        i(r19);     // Catch: Throwable -> L62
        return;
    L6:
        if (d.b.b.o.a.c() == false) goto L8;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "stop collect log");     // Catch: Throwable -> L62
    L8:
        Iterator<d.b.b.e.a.j.a> r9 = r19.iterator();     // Catch: Throwable -> L62
        long r11 = 0;
        long r13 = 0;
    L10:
        if (r9.hasNext() == false) goto L12;
        d.b.b.e.a.j.a r15 = r9.next();     // Catch: Throwable -> L62
        r11 = r11 + ((long) r15.g());     // Catch: Throwable -> L62
        r13 = r13 + ((long) r15.f());     // Catch: Throwable -> L62
        goto L10
    L12:
        d.b.b.e.a.k.b.c().e(r11, r13, System.currentTimeMillis(), d.b.b.e.a.k.b.EnumC0330b.f12656g);     // Catch: Throwable -> L62
        i(r19);     // Catch: Throwable -> L62
    }
}
