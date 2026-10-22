package tmsdkobf;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import tmsdk.common.tcc.ApkSAFScanner;
import tmsdk.common.tcc.DeepCleanEngine;
import tmsdk.common.tcc.DeepCleanSAFEngine;
import tmsdk.common.tcc.SdcardScannerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f199a;
    public final Set b;
    protected final Set c;
    protected BlockingQueue d;
    protected final AtomicBoolean e;
    protected final AtomicBoolean f;
    volatile DeepCleanEngine g;
    volatile DeepCleanSAFEngine h;
    volatile DeepCleanEngine i;
    volatile DeepCleanSAFEngine j;
    volatile DeepCleanEngine k;
    volatile DeepCleanSAFEngine l;
    volatile ad m;
    volatile boolean n;
    volatile s6 o;
    private volatile int p;
    protected volatile Set q;
    protected volatile int r;

    class a implements ad.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ fd f200a;

        a(fd r1) {
            this.f200a = r1;
        }

        @Override // tmsdkobf.ad.c
        public void a() {
            fd.m2384$$Nest$me(this.f200a);
        }
    }

    public static /* synthetic */ void $r8$lambda$Pherg7iFjZE6di9ZdNMn6283OKI(fd r0, CountDownLatch r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void $r8$lambda$eyZQKLSDie9y74X_nDukIluRdmg(fd r0, CountDownLatch r1) {
        r0.a(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gse-FAxEJFJttQpTSGY_v1WpaMY, reason: not valid java name */
    public static /* synthetic */ void m2382$r8$lambda$gseFAxEJFJttQpTSGY_v1WpaMY(fd r0, List r1, CountDownLatch r2) {
        r0.c(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$pUJBb-2DK1M2yzn5QPhWDp2iMD8, reason: not valid java name */
    public static /* synthetic */ void m2383$r8$lambda$pUJBb2DK1M2yzn5QPhWDp2iMD8(fd r0, List r1, CountDownLatch r2) {
        r0.a(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$srEpwAtT5kO9Vnt6IaC0ta0Ar2M(fd r0, ad r1) {
        r0.a(r1);
    }

    public static /* synthetic */ void $r8$lambda$xKPa99bp99fNC4DUpjP49vU8ESg(fd r0, List r1, CountDownLatch r2) {
        r0.b(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$me, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2384$$Nest$me(fd r0) {
        r0.e();
    }

    public fd(s6 r7, ArrayList r8, int r9, int r10) {
        this.f199a = new ArrayList(Arrays.asList(new String[]{new String(c2.b), new String(c2.c), new String(c2.d)}));
        this.b = new HashSet(Arrays.asList(new String[]{new String(c2.f123a)}));
        this.c = new HashSet();
        this.d = new LinkedBlockingQueue();
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.n = false;
        this.p = 0;
        this.q = null;
        this.r = 5;
        this.o = r7;
        if (r8 != null) goto L5;
    L7:
        if (r10 >= 1) goto L9;
    L11:
        this.p = r9;
        return;
    L9:
        if (r10 > 99) goto L11;
        this.r = r10;
        goto L11
    L5:
        if (r8.isEmpty() == true) goto L7;
        this.q = new HashSet(r8);
        goto L7
    }

    private void e() {
        if (this.m != null) goto L5;
    L8:
        k();
        m();
        return;
    L5:
        if (this.n == false) goto L7;
        this.m.l();
        goto L8
    L7:
        this.m.d(this.p);
        goto L8
    }

    public static long f() {
        StatFs r1 = new StatFs(Environment.getDataDirectory().getPath());
        long r2 = r1.getBlockSizeLong();
        return r1.getAvailableBlocksLong() * r2;
    }

    public static long h() {
        StatFs r1 = new StatFs(Environment.getDataDirectory().getPath());
        long r2 = r1.getBlockSizeLong();
        return r1.getBlockCountLong() * r2;
    }

    public static long i() {
        long r2 = f();     // Catch: Throwable -> L11
        if (r2 != 0) goto L6;
        return -1;
    L6:
        long r6 = h();     // Catch: Throwable -> L11
        if (r6 != 0) goto L16;
        return -1;
    L16:
        return r6 - r2;
    L11:
        th = move-exception;
        q8.b("ScanBase", th);
        return -1;
    }

    private void m() {
        if (this.m == null) goto L6;
        this.m.n();
        this.m = null;
        return;
    }

    public void a() {
        this.n = true;
        if (this.m == null) goto L5;
        this.m.l();
    L5:
        l();
    }

    protected abstract boolean b();

    protected boolean b(List r1) {
        return true;
    }

    protected boolean c() {
        return true;
    }

    protected boolean c(List r1) {
        return true;
    }

    protected boolean d(List r1) {
        return true;
    }

    protected List g() {
        if (this.q == null) goto L8;
        if (this.q.isEmpty() == true) goto L8;
        return new ArrayList(this.q);
    L8:
        return this.m.a();
    }

    protected boolean j() {
        return true;
    }

    protected abstract void k();

    public void l() {
        if (this.g == null) goto L6;
        this.g.cancel();
    L6:
        if (this.h == null) goto L9;
        this.h.cancel();
    L9:
        if (this.i == null) goto L12;
        this.i.cancel();
    L12:
        if (this.j == null) goto L15;
        this.j.cancel();
    L15:
        if (this.k == null) goto L18;
        this.k.cancel();
    L18:
        if (this.l == null) goto L20;
        this.l.cancel();
    L20:
        BlockingQueue r0 = this.d;
        if (r0 == null) goto L23;
        r0.clear();
    L23:
        Set r1 = this.c;
        if (r1 == null) goto L26;
        r1.clear();
    L26:
        AtomicBoolean r2 = this.e;
        if (r2 == null) goto L29;
        r2.set(false);
    L29:
        AtomicBoolean r3 = this.f;
        if (r3 == null) goto L33;
        r3.set(false);
        return;
    }

    private void a(final List r6) {
        if (i() <= 50000000000L) goto L5;
        int r0 = 1;
    L6:
        final CountDownLatch r2 = new CountDownLatch(r0 + 2);
        we r1 = ve.f();
        r1.a(new fd$$ExternalSyntheticLambda3(this, r6, r2), "scan_AD1");
        r1.a(new fd$$ExternalSyntheticLambda4(this, r6, r2), "scan_AD2");
        if (r0 == 0) goto L13;
        r1.a(new fd$$ExternalSyntheticLambda5(this, r6, r2), "scan_AD3");
    L13:
        r2.await();     // Catch: InterruptedException -> L11
        return;
    L11:
        Thread.currentThread().interrupt();
        return;
    L5:
        r0 = 0;
        goto L6
    }

    private /* synthetic */ void b(List r2, CountDownLatch r3) {
        this.i = SdcardScannerFactory.getDeepCleanEngine(this.m);     // Catch: Throwable -> L11
        boolean r0 = ve.f581a;     // Catch: Throwable -> L11
        if (this.i != null) goto L7;
        r3.countDown();
        return;
    L7:
        if (this.n == false) goto L9;
        a();     // Catch: Throwable -> L11
    L9:
        c(r2);     // Catch: Throwable -> L11
        a(this.i, this.j);     // Catch: Throwable -> L11
    L13:
        r3.countDown();
        return;
    L11:
        th = move-exception;
        q8.b("ScanBase", th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    private void d() {
        int r1 = 1;
        if (this.p != 1) goto L9;
        Set r0 = this.b;
        if (r0 == null) goto L9;
        if (r0.isEmpty() == true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r1 = 2;
    L12:
        final CountDownLatch r3 = new CountDownLatch(r1);
        we r4 = ve.f();
        r4.a(new fd$$ExternalSyntheticLambda0(this, r3), "scan_normal");
        if (r2 == false) goto L19;
        r4.a(new fd$$ExternalSyntheticLambda1(this, r3), "scan_mm");
    L19:
        r3.await();     // Catch: InterruptedException -> L17
        return;
    L17:
        Thread.currentThread().interrupt();
        return;
    L9:
        r2 = false;
        goto L10
    }

    private void e(List r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.isEmpty() == true) goto L33;
        Iterator r0 = r7.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        String r1 = (String) r0.next();
        byte[] r3 = c2.f123a;
        if (a(r1, new String(r3)) == false) goto L8;
        this.d.add(new ha(r1, new String(r3)));
        goto L8
    L12:
        Iterator r2 = this.f199a.iterator();
    L14:
        if (r2.hasNext() == false) goto L34;
        String r4 = (String) r2.next();
        Iterator r5 = r7.iterator();
    L17:
        if (r5.hasNext() == false) goto L14;
        String r6 = (String) r5.next();
        if (a(r6, r4) == false) goto L17;
        this.d.add(new ha(r6, r4));
        goto L17
    L34:
        return;
    }

    private boolean a(String r2, String r3) {
        String r4 = r2 + r3;
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return false;
    L6:
        if (this.c.contains(r4) == true) goto L9;
        this.c.add(r4);
        return true;
    L9:
        return false;
    }

    private /* synthetic */ void b(CountDownLatch r3) {
        this.i = SdcardScannerFactory.getDeepCleanEngine(this.m);     // Catch: Throwable -> L11
        boolean r0 = ve.f581a;     // Catch: Throwable -> L11
        if (this.i != null) goto L7;
        r3.countDown();
        return;
    L7:
        if (this.n == false) goto L9;
        a();     // Catch: Throwable -> L11
    L9:
        c();     // Catch: Throwable -> L11
        a(this.i, this.j);     // Catch: Throwable -> L11
    L13:
        r3.countDown();
        return;
    L11:
        th = move-exception;
        q8.b("ScanBase", th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    private /* synthetic */ void c(List r2, CountDownLatch r3) {
        this.k = SdcardScannerFactory.getDeepCleanEngine(this.m);     // Catch: Throwable -> L11
        boolean r0 = ve.f581a;     // Catch: Throwable -> L11
        if (this.k != null) goto L7;
        r3.countDown();
        return;
    L7:
        if (this.n == false) goto L9;
        a();     // Catch: Throwable -> L11
    L9:
        d(r2);     // Catch: Throwable -> L11
        a(this.k, this.l);     // Catch: Throwable -> L11
    L13:
        r3.countDown();
        return;
    L11:
        th = move-exception;
        q8.b("ScanBase", th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    private /* synthetic */ void a(List r2, CountDownLatch r3) {
        this.g = SdcardScannerFactory.getDeepCleanEngine(this.m);     // Catch: Throwable -> L12
        boolean r0 = ve.f581a;     // Catch: Throwable -> L12
        if (this.g != null) goto L8;
        this.m.c(-1);     // Catch: Throwable -> L12
        r3.countDown();
        return;
    L8:
        if (this.n == false) goto L10;
        a();     // Catch: Throwable -> L12
    L10:
        b(r2);     // Catch: Throwable -> L12
        a(this.g, this.h);     // Catch: Throwable -> L12
    L14:
        r3.countDown();
        return;
    L12:
        th = move-exception;
        q8.b("ScanBase", th);     // Catch: Throwable -> L16
        this.m.c(-4);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    public boolean b(final ad r3) {
        ve.f().a(new fd$$ExternalSyntheticLambda2(this, r3), "scan_base");
        return true;
    }

    private /* synthetic */ void a(CountDownLatch r3) {
        this.g = SdcardScannerFactory.getDeepCleanEngine(this.m);     // Catch: Throwable -> L14
        boolean r0 = ve.f581a;     // Catch: Throwable -> L14
        if (this.g != null) goto L10;
        if (this.m == null) goto L7;
        this.m.c(-1);     // Catch: Throwable -> L14
    L7:
        r3.countDown();
        return;
    L10:
        if (this.n == false) goto L12;
        a();     // Catch: Throwable -> L14
    L12:
        b();     // Catch: Throwable -> L14
        a(this.g, this.h);     // Catch: Throwable -> L14
    L16:
        r3.countDown();
        return;
    L14:
        th = move-exception;
        q8.b("ScanBase", th);     // Catch: Throwable -> L18
        this.m.c(-4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    private /* synthetic */ void a(ad r3) {
        this.m = r3;     // Catch: Throwable -> L35
        if (this.m != null) goto L6;
        return;
    L6:
        if (r3.c() != null) goto L9;
        return;
    L9:
        if (this.m.h() == false) goto L11;
        this.m.a(new a(this));     // Catch: Throwable -> L35
    L11:
        this.m.m();     // Catch: Throwable -> L35
        if (this.p != 1) goto L17;
        if (j() == true) goto L17;
        return;
    L17:
        if (this.p != 1) goto L25;
        List r4 = g();     // Catch: Throwable -> L35
        e(r4);     // Catch: Throwable -> L35
        if (r4 == null) goto L24;
        Iterator r0 = r4.iterator();     // Catch: Throwable -> L35
    L22:
        if (r0.hasNext() == false) goto L24;
        a((String) r0.next());     // Catch: Throwable -> L35
    L24:
        a(r4);     // Catch: Throwable -> L35
    L26:
        Thread.sleep(300);     // Catch: Throwable -> L35
        if (this.m == null) goto L32;
        if (this.m.h() == true) goto L32;
        e();     // Catch: Throwable -> L35
        return;
    L32:
        if (this.m == null) goto L43;
        this.m.p();     // Catch: Throwable -> L35
        return;
    L43:
        return;
    L25:
        d();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        q8.b("ScanBase", th);
        if (this.m == null) goto L44;
        this.m.c(-4);
        return;
    }

    private void a(DeepCleanEngine r1, DeepCleanSAFEngine r2) {
        if (r1 == null) goto L4;
        r1.release();
    L4:
        if (r2 == null) goto L7;
        r2.release();
        return;
    }

    private void a(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        File r0 = new File(r7 + ApkSAFScanner.ANDROID_DATA);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L11;
        return;
    L11:
        int r2 = r1.length;
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L26;
        File r4 = r1[r3];
        if (this.n == true) goto L34;
        if (r4.isDirectory() == false) goto L25;
        if (r4.listFiles() == null) goto L25;
        if (r4.listFiles().length <= 0) goto L25;
        String r5 = r4.getAbsolutePath().substring(r7.length());
        if (a(r7, r5) == false) goto L25;
        this.d.add(new ha(r7, r5));
    L25:
        r3 = r3 + 1;
        goto L12
    L34:
        return;
    }
}
