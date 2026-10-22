package d.c.c.i;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import d.c.c.d.n;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f15425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f15426i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile StatFs f15427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile File f15428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile StatFs f15429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile File f15430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f15431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lock f15432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f15433g;

    /* JADX INFO: renamed from: d.c.c.i.a$a, reason: collision with other inner class name */
    public static final enum EnumC0415a extends Enum<EnumC0415a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0415a f15434f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0415a f15435g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ EnumC0415a[] f15436h = null;

        static {
            EnumC0415a r0 = new EnumC0415a("INTERNAL", 0);
            f15434f = r0;
            EnumC0415a r1 = new EnumC0415a("EXTERNAL", 1);
            f15435g = r1;
            f15436h = new EnumC0415a[]{r0, r1};
        }

        private EnumC0415a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0415a valueOf(String r1) {
            return (EnumC0415a) Enum.valueOf(EnumC0415a.class, r1);
        }

        public static EnumC0415a[] values() {
            return (EnumC0415a[]) f15436h.clone();
        }
    }

    static {
        f15426i = TimeUnit.MINUTES.toMillis(2);
    }

    protected a() {
        this.f15427a = null;
        this.f15429c = null;
        this.f15433g = false;
        this.f15432f = new ReentrantLock();
    }

    protected static StatFs a(String r1) {
        return new StatFs(r1);
    }

    private void b() {
        if (this.f15433g == true) goto L12;
        this.f15432f.lock();
    L9:
        th = move-exception;
        this.f15432f.unlock();
        throw th;
    L6:
        if (this.f15433g == true) goto L8;
        this.f15428b = Environment.getDataDirectory();     // Catch: Throwable -> L9
        this.f15430d = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
        g();     // Catch: Throwable -> L9
        this.f15433g = true;     // Catch: Throwable -> L9
    L8:
        this.f15432f.unlock();
        return;
    }

    public static synchronized a d() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f15425h != null) goto L7;
        f15425h = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = f15425h;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    private void e() {
        if (this.f15432f.tryLock() == true) goto L12;
        return;
    L12:
    L8:
        th = move-exception;
        this.f15432f.unlock();
        throw th;
    L5:
        if ((SystemClock.uptimeMillis() - this.f15431e) <= f15426i) goto L7;
        g();     // Catch: Throwable -> L8
    L7:
        this.f15432f.unlock();
    }

    private void g() {
        this.f15427a = h(this.f15427a, this.f15428b);
        this.f15429c = h(this.f15429c, this.f15430d);
        this.f15431e = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.StatFs] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.os.StatFs] */
    /* JADX WARN: Type inference failed for: r1v5 */
    private StatFs h(StatFs r2, File r3) {
        ?? r1 = 0;
        r1 = 0;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.exists() == false) goto L19;
        if (r2 != null) goto L9;
        r2 = a(r3.getAbsolutePath());     // Catch: Throwable -> L11 IllegalArgumentException -> L15
    L10:
        r1 = r2;
        goto L20
    L18:
        return r1;
    L9:
        r2.restat(r3.getAbsolutePath());     // Catch: Throwable -> L11 IllegalArgumentException -> L15
    L11:
        th = move-exception;
        n.a(th);
        throw r1;
    L20:
        return r1;
    L19:
        return null;
    }

    @SuppressLint({"DeprecatedMethod"})
    public long c(EnumC0415a r3) {
        b();
        e();
        if (r3 != EnumC0415a.f15434f) goto L5;
        StatFs r2 = this.f15427a;
    L6:
        if (r2 != null) goto L8;
        return 0;
    L8:
        if (Build.VERSION.SDK_INT < 18) goto L10;
        long r0 = r2.getBlockSizeLong();
        long r4 = r2.getAvailableBlocksLong();
    L12:
        return r0 * r4;
    L10:
        r0 = r2.getBlockSize();
        r4 = r2.getAvailableBlocks();
        goto L12
    L5:
        r2 = this.f15429c;
        goto L6
    }

    public boolean f(EnumC0415a r3, long r4) {
        b();
        long r2 = c(r3);
        if (r2 > 0) goto L5;
        return true;
    L5:
        if (r2 < r4) goto L10;
        return false;
    L10:
        return true;
    }
}
