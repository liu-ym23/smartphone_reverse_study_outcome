package d.b.b.f.e.k;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import com.bytedance.monitor.collector.k;
import d.b.b.f.e.i;
import d.b.b.f.e.j;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class h extends d.b.b.f.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Double> f12860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<j> f12861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<j> f12862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.o.o.a f12863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.b.f.d.c f12864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12866h;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ h f12867i;

        a(h r1, long r2, long r4) {
            this.f12867i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.f(this.f12867i);
        }
    }

    class b implements Comparator<j> {
        b(h r1) {
        }

        public int a(j r5, j r6) {
            return (int) ((r6.a() * 100.0d) - (r5.a() * 100.0d));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(j r1, j r2) {
            return a(r1, r2);
        }
    }

    public h(d.b.b.f.e.d r7) {
        super(r7);
        this.f12865g = 0;
        this.f12860b = new CopyOnWriteArrayList();
        this.f12862d = new CopyOnWriteArrayList();
        this.f12861c = new CopyOnWriteArrayList();
        this.f12863e = new a(this, 0, 1000);
    }

    static /* synthetic */ void f(h r0) {
        r0.j();
    }

    private void g(j r8, Thread r9, StringBuilder r10) {
        StackTraceElement[] r11 = r9.getStackTrace();
        int r0 = r11.length;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        StackTraceElement r5 = r11[r2];
        r3 = r3 + 1;
        r10.append("\tat ");
        r10.append(r5.getClassName());
        r10.append(".");
        r10.append(r5.getMethodName());
        r10.append("(");
        r10.append(r5.getFileName());
        r10.append(":");
        r10.append(r5.getLineNumber());
        r10.append(")\n");
        if (r3 > 40) goto L9;
        r2 = r2 + 1;
    L9:
        r8.l(r10.toString());
        r8.p(String.format("%.2f", new Object[]{Double.valueOf(r8.a() / this.f12864f.e())}));
        this.f12862d.add(r8);
        r10.setLength(0);
    }

    @SuppressLint({"CI_DefaultLocale"})
    private void h() {
        if (this.f12861c.isEmpty() == false) goto L6;
        i.c(Process.myPid(), this.f12861c);
        e("over process threshold, first collect thread info, list size: " + this.f12861c.size());
        return;
    L6:
        i.a(Process.myPid(), this.f12861c, this.f12864f.e(), this.f12864f.f());
        e("over process threshold, second collect thread info, list size after filter is: " + this.f12861c.size());
        if (this.f12861c.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f12861c.size() <= 10) goto L14;
        this.f12861c.clear();
        return;
    L14:
        if (d.b.b.f.e.c.c().d() == false) goto L50;
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r4 = r0.activeCount();
        int r5 = r4 + (r4 / 2);
        Thread[] r6 = new Thread[r5];
        r0.enumerate(r6);
        StringBuilder r1 = new StringBuilder();
        ListIterator<j> r7 = this.f12861c.listIterator();
    L17:
        if (r7.hasNext() == false) goto L61;
        j r8 = r7.next();
        if (r8 == null) goto L17;
        if (r8.f() == Process.myPid()) goto L24;
        int r9 = 0;
    L27:
        if (r9 >= r5) goto L43;
        Thread r10 = r6[r9];
        if (r10 == null) goto L43;
        if (r8.g().equals(r10.getName()) == true) goto L40;
        if (r10.getName().length() <= 15) goto L38;
        if (r8.g().equals(r10.getName().substring(0, 15)) == true) goto L40;
    L38:
        r9 = r9 + 1;
    L40:
        if (r10 == Thread.currentThread()) goto L42;
        g(r8, r10, r1);
    L42:
        boolean r11 = true;
    L44:
        if (r11 == true) goto L17;
        if (this.f12864f.k() == false) goto L17;
        String r12 = k.n().h(r8.f());
        if (r12 == null) goto L17;
        r8.l(r12);
        r8.p(String.format("%.2f", new Object[]{Double.valueOf(r8.a() / this.f12864f.e())}));
        this.f12862d.add(r8);
    L43:
        r11 = false;
        goto L44
    L24:
        if (this.f12864f.j() == false) goto L17;
        g(r8, Looper.getMainLooper().getThread(), r1);
    L61:
        Collections.sort(this.f12861c, new b(this));
        LinkedList<d.b.b.n.h.a.C0344a> r2 = new LinkedList();
        Iterator<j> r3 = this.f12861c.iterator();
    L63:
        if (r3.hasNext() == false) goto L65;
        j r13 = r3.next();
        r2.add(new d.b.b.n.h.a.C0344a(r13.g(), r13.a(), r13.f()));
        goto L63
    L65:
        d.b.b.f.f.a.c().e(r2);
        this.f12861c.clear();
        return;
    L50:
        ListIterator<j> r14 = this.f12861c.listIterator();
    L52:
        if (r14.hasNext() == false) goto L61;
        j r15 = r14.next();
        if (r15 == null) goto L52;
        if (r15.f() != Process.myPid()) goto L60;
        if (this.f12864f.j() == false) goto L52;
    L60:
        r15.p(String.format("%.2f", new Object[]{Double.valueOf(r15.a() / this.f12864f.e())}));
        this.f12862d.add(r15);
        goto L52
    }

    private long i() {
        d.b.b.f.d.c r4 = this.f12864f;
        if (r4 != null) goto L7;
        return 30000;
    L7:
        return ((long) r4.h()) * 1000;
    }

    private void j() {
        if (d.b.b.f.e.b.c() == false) goto L6;
        m();
        this.f12804a.h();
        return;
    L6:
        boolean r0 = k();
        if ((System.currentTimeMillis() - this.f12865g) < i()) goto L10;
        l();
        return;
    L10:
        if (r0 == true) goto L13;
        e("not over process threshold");
        this.f12861c.clear();
        return;
    L13:
        h();
    }

    private boolean k() {
        double r0 = d.b.b.f.e.e.a();
        this.f12860b.add(Double.valueOf(r0));
        return d.b.b.f.e.b.e(this.f12864f, r0, this.f12866h);
    }

    private void l() {
        if (this.f12860b.isEmpty() == false) goto L5;
    L99:
        e("finish collect, but no exception thread is found");
        m();
        this.f12804a.h();
        return;
    L5:
        if (this.f12862d.isEmpty() == true) goto L99;
        Iterator<Double> r1 = this.f12860b.iterator();
        double r4 = 0.0d;
        double r9 = 0.0d;
    L9:
        if (r1.hasNext() == false) goto L14;
        double r6 = r1.next().doubleValue();
        if (r9 >= r6) goto L13;
        r9 = r6;
    L13:
        r4 = r4 + r6;
        goto L9
    L14:
        e("report exception data, exception thread size is: " + this.f12862d.size());
        double r7 = r4 / ((double) this.f12860b.size());
        LinkedList r2 = new LinkedList();
        String[] r5 = d.b.b.f.e.b.a().split("#");
        String r11 = null;
        if (this.f12866h == false) goto L38;
        if (this.f12864f.a().isEmpty() == true) goto L59;
        int r8 = r5.length;
        int r13 = 0;
        double r14 = 0.0d;
    L19:
        if (r13 >= r8) goto L33;
        String r12 = r5[r13];
        if (this.f12864f.a().containsKey(r12) == false) goto L32;
        double r3 = this.f12864f.a().get(r12).doubleValue();
        if (r3 < 0.0d) goto L32;
        if (r14 >= r3) goto L30;
        r14 = r3;
        r11 = r12;
    L30:
        if (r7 <= r3) goto L32;
        r2.add(r12);
    L32:
        r13 = r13 + 1;
        goto L19
    L33:
        if (r11 == null) goto L59;
        if (r2.contains(r11) == false) goto L59;
    L57:
        r2.remove(r11);
        r2.add(0, r11);
    L59:
        if (r2.isEmpty() == true) goto L61;
    L68:
        d.b.b.f.e.c.c().e(System.currentTimeMillis());
        d.b.b.f.a.c r10 = d.b.b.f.e.c.c().b();
        if (r10 == null) goto L72;
        r10.a(r7);
    L72:
        if (r2.isEmpty() == true) goto L74;
        String r15 = d.b.b.o.f.a(r2.toArray(), "#");
        if (this.f12866h == false) goto L91;
        if (r7 <= this.f12864f.c()) goto L91;
        StringBuilder r16 = new StringBuilder();
        r16.append(r15);
        r16.append("#");
        r16.append("apm_max_background");
    L89:
        r15 = r16.toString();
    L95:
        String r17 = r15;
    L96:
        d.b.b.l.a.d(new d.b.b.f.e.k.b(r7, r9, this.f12862d, r17, this.f12866h));
    L97:
        m();
        this.f12804a.e();
        return;
    L91:
        if (this.f12866h == true) goto L95;
        if (r7 <= this.f12864f.d()) goto L95;
        r16 = new StringBuilder();
        r16.append(r15);
        r16.append("#");
        r16.append("apm_max_foreground");
        goto L89
    L74:
        if (this.f12866h == false) goto L79;
        if (r7 <= this.f12864f.c()) goto L79;
        r17 = "apm_max_background";
    L79:
        if (this.f12866h == false) goto L81;
    L83:
        r15 = "";
        goto L95
    L81:
        if (r7 <= this.f12864f.d()) goto L83;
        r17 = "apm_max_foreground";
        goto L96
    L61:
        if (this.f12866h == false) goto L65;
        if (r7 > this.f12864f.c()) goto L68;
    L65:
        if (this.f12866h == true) goto L97;
        if (r7 <= this.f12864f.d()) goto L97;
    L38:
        if (this.f12864f.b().isEmpty() == true) goto L59;
        int r18 = r5.length;
        int r19 = 0;
        double r110 = 0.0d;
    L40:
        if (r19 >= r18) goto L54;
        String r20 = r5[r19];
        if (this.f12864f.b().containsKey(r20) == false) goto L53;
        double r111 = this.f12864f.b().get(r20).doubleValue();
        if (r111 < 0.0d) goto L53;
        if (r110 >= r111) goto L51;
        r11 = r20;
        r110 = r111;
    L51:
        if (r7 <= r111) goto L53;
        r2.add(r20);
    L53:
        r19 = r19 + 1;
        goto L40
    L54:
        if (r11 == null) goto L59;
        if (r2.contains(r11) == false) goto L59;
        goto L57
    }

    private void m() {
        this.f12860b.clear();
        this.f12862d.clear();
        this.f12861c.clear();
        this.f12865g = 0;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).b(this.f12863e);
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void a(d.b.b.f.d.c r3, boolean r4) {
        super.a(r3, r4);
        this.f12864f = r3;
        this.f12865g = System.currentTimeMillis();
        this.f12866h = r4;
        d.b.b.o.o.b.a(d.b.b.o.o.c.f13069i).c(this.f12863e);
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void b(boolean r1) {
        super.b(r1);
        m();
        this.f12804a.f();
    }

    @Override // d.b.b.f.e.g
    public d.b.b.f.e.h c() {
        return d.b.b.f.e.h.f12827h;
    }

    @Override // d.b.b.f.e.a, d.b.b.f.e.g
    public void d() {
        super.d();
        m();
    }
}
