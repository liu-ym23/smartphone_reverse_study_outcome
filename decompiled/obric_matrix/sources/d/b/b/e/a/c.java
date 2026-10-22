package d.b.b.e.a;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.b.b.e.a.l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f12577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f12578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.o.l.a<d.b.b.e.a.j.a> f12579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile d.b.b.e.a.j.c f12580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile d.b.b.o.o.a f12581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12582f;

    class a extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12583i;

        a(c r1, long r2, long r4) {
            this.f12583i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.d(this.f12583i);
        }
    }

    class b extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12584i;

        b(c r1, long r2, long r4) {
            this.f12584i = r1;
            super(r2, r4);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.d(this.f12584i);
        }
    }

    /* JADX INFO: renamed from: d.b.b.e.a.c$c, reason: collision with other inner class name */
    class C0328c extends d.b.b.o.o.a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ c f12585i;

        C0328c(c r1, long r2) {
            this.f12585i = r1;
            super(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e(this.f12585i);
        }
    }

    class d implements Comparator<String> {
        d(c r1) {
        }

        public int a(String r1, String r2) {
            return String.CASE_INSENSITIVE_ORDER.compare(r1, r2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
            return a(r1, r2);
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12586a = null;

        static {
            f12586a = new c();
        }

        static /* synthetic */ c a() {
            return f12586a;
        }
    }

    public c() {
        this.f12577a = 60000;
        this.f12578b = 1048576;
        this.f12579c = new d.b.b.o.l.a(10);
        this.f12582f = false;
    }

    static /* synthetic */ void d(c r0) {
        r0.k();
    }

    static /* synthetic */ void e(c r0) {
        r0.j();
    }

    private void f() {
    L6:
        th = move-exception;
        d.b.b.o.m.b.c(d.b.b.e.a.a.f12571a, "flushBuffer", th);
        return;
    L3:
        if (this.f12580d == null) goto L11;
        this.f12580d.b();     // Catch: Throwable -> L6
        return;
    }

    private long g(File r4) {
        String r3 = r4.getName();
        int r5 = r3.indexOf("_");
        if (r5 != (-1)) goto L9;
        return -1;
    L9:
        return Long.parseLong(r3.substring(0, r5));
    L8:
        return -1;
    }

    public static c h() {
        return e.a();
    }

    private void j() {
        File r13 = d.b.b.e.a.b.e();
        if (r13.exists() == true) goto L5;
        return;
    L5:
        File[] r14 = r13.listFiles();
        if (r14 != null) goto L8;
        return;
    L8:
        int r0 = r14.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L42;
        File r3 = r14[r2];
        if (r3 == null) goto L41;
        if (r3.exists() == false) goto L41;
        if (r3.length() <= 0) goto L41;
        if (Long.parseLong(r3.getName().split("_")[0]) >= d.b.b.i.c.a.o()) goto L41;
        FileChannel r4 = null;
        r4 = new RandomAccessFile(r3, "rw").getChannel();     // Catch: Throwable -> L33
        FileLock r5 = r4.tryLock(0, LocationRequestCompat.PASSIVE_INTERVAL, false);     // Catch: Throwable -> L33
        if (r5 == null) goto L30;
        if (r5.isValid() == false) goto L30;
        File r6 = new File(d.b.b.e.a.b.b(), d.b.b.e.a.b.a());     // Catch: Throwable -> L33
        boolean r7 = com.bytedance.common.utility.n.b.d(r3.getAbsolutePath(), r6.getAbsolutePath());     // Catch: Throwable -> L33
        if (d.b.b.o.a.c() == false) goto L28;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "moveInactiveSubProcessData: src:" + r3.getAbsolutePath() + " dst:" + r6.getAbsolutePath() + " isSuccess:" + r7);     // Catch: Throwable -> L33
    L28:
        r5.release();     // Catch: Throwable -> L33
    L37:
        d.b.b.o.d.a(r4);
    L30:
        if (d.b.b.o.a.c() == false) goto L37;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "moveInactiveSubProcessData isValid is not true ");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
    L38:
        th = move-exception;
        d.b.b.o.d.a(r4);
        throw th;
    L35:
        if (d.b.b.o.a.c() == false) goto L37;
        d.b.b.o.m.b.g(d.b.b.e.a.a.f12571a, "moveInactiveSubProcessData failed.", th);     // Catch: Throwable -> L38
    L41:
        r2 = r2 + 1;
        goto L9
    }

    private void k() {
        long r0 = System.currentTimeMillis();
        f();
        m();
        if (d.b.b.i.c.a.A() == false) goto L8;
        if (this.f12582f == true) goto L8;
        l();
    L8:
        if (d.b.b.o.a.c() == false) goto L11;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - r0));
        return;
    }

    private void l() {
        if (this.f12580d == null) goto L5;
        String[] r0 = this.f12580d.h();
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L48;
        List r1 = Arrays.asList(r0);
        Collections.sort(r1, new d(this));
        if (d.b.b.o.a.c() == false) goto L13;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "reportFile: parsing " + r1.size() + " files. fileNameList" + r1);
    L13:
        ArrayList r2 = new ArrayList();
        int r3 = 0;
        int r4 = 0;
    L15:
        if (r3 >= r1.size()) goto L38;
        File r7 = new File(d.b.b.e.a.b.b(), (String) r1.get(r3));
        if (r7.exists() == false) goto L36;
        d.b.b.e.a.j.a r5 = d.b.b.e.a.j.a.a(r7);
        if (r5 == null) goto L22;
        int r8 = r5.f();
        if (r4 != 0) goto L28;
    L35:
        r4 = r4 + r8;
        r2.add(r5);
        goto L36
    L28:
        if ((r4 + r8) < this.f12578b) goto L35;
        if (com.bytedance.apm.x.a.c() == null) goto L33;
        com.bytedance.apm.x.a.c().a(d.b.b.e.a.a.f12571a, "sendList:" + r1.toString());
    L33:
        d.b.b.e.a.k.d.j().o(r2, r1.size() - r2.size());
        return;
    L22:
        if (d.b.b.o.a.c() == false) goto L24;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "logFile invalid. delete now.");
    L24:
        r7.delete();
    L36:
        r3 = r3 + 1;
        goto L15
    L38:
        if (com.bytedance.apm.x.a.c() == null) goto L40;
        com.bytedance.apm.x.a.c().a(d.b.b.e.a.a.f12571a, "sendList:" + r1.toString());
    L40:
        d.b.b.e.a.k.d.j().o(r2, 0);
        return;
    L48:
        return;
    L5:
        d.b.b.o.m.b.b(d.b.b.e.a.a.f12571a, "persistentBuffer is null");
        r0 = null;
        goto L6
    }

    private void m() {
        if (this.f12579c.a() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L7:
        if (this.f12579c.a() == true) goto L18;
        r0.add(this.f12579c.b());
        d.b.b.e.a.j.a r3 = this.f12579c.b();
        if (r3 == null) goto L7;
        int r4 = r3.f();
        if (r2 == 0) goto L17;
        if ((r2 + r4) < this.f12578b) goto L17;
        d.b.b.e.a.k.d.j().o(r0, 0);
        r0.clear();
        r0.add(r3);
        r2 = r4;
    L17:
        r2 = r2 + r4;
        r0.add(r3);
        goto L7
    L18:
        d.b.b.e.a.k.d.j().o(r0, 0);
    }

    @Override // d.b.b.e.a.l.d
    public long a() {
        String[] r7 = this.f12580d.h();
        long r0 = 0;
        if (r7 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r7.length == 0) goto L10;
        int r2 = r7.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        String r4 = r7[r3];
        r0 = r0 + new File(d.b.b.e.a.b.b(), r4).length();
        r3 = r3 + 1;
        goto L8
    }

    @Override // d.b.b.e.a.l.d
    public void b(long r10) {
        if (this.f12580d != null) goto L5;
        return;
    L5:
        String[] r0 = this.f12580d.h();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.length == 0) goto L23;
        int r1 = r0.length;
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L24;
        String r3 = r0[r2];
        File r4 = new File(d.b.b.e.a.b.b(), r3);
        long r5 = g(r4);
        if (r5 != (-1)) goto L16;
    L14:
        d.b.b.o.c.a(r4);
    L18:
        r2 = r2 + 1;
        goto L11
    L16:
        if (r5 > r10) goto L18;
    L24:
        return;
    }

    @Override // d.b.b.e.a.l.d
    public void c(long r11) {
        if (this.f12580d != null) goto L5;
        return;
    L5:
        String[] r10 = this.f12580d.h();
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.length == 0) goto L41;
        Arrays.sort(r10);
        int r0 = r10.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L11:
        if (r4 >= r0) goto L18;
        File r8 = new File(d.b.b.e.a.b.b(), r10[r4]);
        if (r8.exists() == false) goto L17;
        if (r8.isFile() == false) goto L17;
        r5 = r5 + r8.length();
    L17:
        r4 = r4 + 1;
        goto L11
    L18:
        int r3 = r10.length;
    L19:
        if (r1 >= r3) goto L42;
        String r6 = r10[r1];
        if ((r5 - r2) <= r11) goto L43;
        File r7 = new File(d.b.b.e.a.b.b(), r6);
        if (r7.exists() == false) goto L29;
        if (r7.isFile() == false) goto L29;
        long r9 = r7.length();
        if (d.b.b.o.c.b(r7) == false) goto L29;
        r2 = r2 + r9;
    L29:
        r1 = r1 + 1;
        goto L19
    L43:
        return;
    L42:
        return;
    }

    @Override // d.b.b.e.a.l.d
    public String getName() {
        return "first_log_dir";
    }

    public synchronized void i() {
        monitor-enter(this);
        this.f12581e = new b(this, 0, this.f12577a);     // Catch: Throwable -> L8
        d.b.b.o.o.c r0 = d.b.b.o.o.c.f13066f;     // Catch: Throwable -> L8
        d.b.b.o.o.b.a(r0).c(this.f12581e);     // Catch: Throwable -> L8
        if (d.b.b.i.c.a.A() == false) goto L6;
        d.b.b.o.o.b.a(r0).c(new C0328c(this, BDLocationConfig.sScanBleMaxInterval));     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void n(d.b.b.e.a.j.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.f12579c.c(r1);
    }

    public synchronized void o(long r8) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (d.b.b.o.a.c() == false) goto L7;
        d.b.b.o.m.b.a(d.b.b.e.a.a.f12571a, "setLoopInterval:" + this.f12577a);     // Catch: Throwable -> L20
    L7:
        if (r8 > 0) goto L9;
    L18:
        monitor-exit(this);
        return;
    L9:
        if (this.f12577a == r8) goto L18;
        this.f12577a = r8;     // Catch: Throwable -> L20
        if (this.f12581e != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        d.b.b.o.o.c r9 = d.b.b.o.o.c.f13066f;     // Catch: Throwable -> L20
        d.b.b.o.o.b.a(r9).b(this.f12581e);     // Catch: Throwable -> L20
        this.f12581e = new a(this, this.f12577a, this.f12577a);     // Catch: Throwable -> L20
        d.b.b.o.o.b.a(r9).c(this.f12581e);     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    public void p(long r3) {
        if (r3 > 0) goto L5;
        return;
    L5:
        this.f12578b = r3;
    }

    public void q(d.b.b.e.a.j.c r1) {
        this.f12580d = r1;
    }
}
