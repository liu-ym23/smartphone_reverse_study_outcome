package d.c.b.b;

import d.c.c.d.l;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g implements d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Class<?> f15348h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<File> f15350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final l<File> f15352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.b.a.a f15354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile a f15355g;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f15356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File f15357b;

        a(File r1, d r2) {
            this.f15356a = r2;
            this.f15357b = r1;
        }
    }

    static {
        f15348h = g.class;
    }

    public g(int r1, l<File> r2, String r3, l<File> r4, String r5, d.c.b.a.a r6) {
        this.f15349a = r1;
        this.f15354f = r6;
        this.f15350b = r2;
        this.f15351c = r3;
        this.f15352d = r4;
        this.f15353e = r5;
        this.f15355g = new a(null, null);
    }

    private void n() {
        File r0 = new File(this.f15350b.get(), this.f15351c);
        File r1 = new File(this.f15352d.get(), this.f15353e);
        m(r0);
        l(r1);
        this.f15355g = new a(r0, new d.c.b.b.a(r0, r1, this.f15349a, this.f15354f));
    }

    private boolean q() {
        a r1 = this.f15355g;
        if (r1.f15356a == null) goto L10;
        File r2 = r1.f15357b;
        if (r2 == null) goto L10;
        if (r2.exists() == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // d.c.b.b.d
    public long a(String r1) {
        return p().a(r1);
    }

    @Override // d.c.b.b.d
    public void b() {
        p().b();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        d.c.c.e.a.g(f15348h, "purgeUnexpectedResources", e);
    }

    @Override // d.c.b.b.d
    public d.b c(String r1, Object r2) {
        return p().c(r1, r2);
    }

    @Override // d.c.b.b.d
    public Collection<d.a> d() {
        return p().d();
    }

    @Override // d.c.b.b.d
    public boolean e(String r1, Object r2) {
        return p().e(r1, r2);
    }

    @Override // d.c.b.b.d
    public Map<String, String> f(String r1, Object r2) {
        return p().f(r1, r2);
    }

    @Override // d.c.b.b.d
    public d.c.a.a g(String r1, Object r2) {
        return p().g(r1, r2);
    }

    @Override // d.c.b.b.d
    public Collection<d.a> h() {
        return p().h();
    }

    @Override // d.c.b.b.d
    public void i() {
        p().i();
    }

    @Override // d.c.b.b.d
    public boolean isExternal() {
        return p().isExternal();
    L4:
        return false;
    }

    @Override // d.c.b.b.d
    public List<d.a> j() {
        return p().j();
    }

    @Override // d.c.b.b.d
    public long k(d.a r1) {
        return p().k(r1);
    }

    void l(File r4) {
        d.c.c.c.c.a(r4);     // Catch: d.c.c.c.c.a -> L4
    L5:
        d.c.c.e.a.a(f15348h, "Created config directory %s", r4.getAbsolutePath());
        return;
    L4:
        d.c.c.e.a.h(f15348h, "create config directory %s failed", new Object[]{r4.getAbsoluteFile()});
        goto L5
    }

    void m(File r4) {
        d.c.c.c.c.a(r4);     // Catch: d.c.c.c.c.a -> L5
        d.c.c.e.a.a(f15348h, "Created cache directory %s", r4.getAbsolutePath());
        return;
    L5:
        e = move-exception;
        this.f15354f.a(d.c.b.a.a.EnumC0411a.p, f15348h, "createRootDirectoryIfNecessary", e);
        throw e;
    }

    void o() {
        if (this.f15355g.f15356a != null) goto L5;
        return;
    L5:
        if (this.f15355g.f15357b == null) goto L9;
        d.c.c.c.a.b(this.f15355g.f15357b);
        return;
    }

    synchronized d p() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (q() == false) goto L6;
        o();     // Catch: Throwable -> L9
        n();     // Catch: Throwable -> L9
    L6:
        d r0 = this.f15355g.f15356a;     // Catch: Throwable -> L9
        d.c.c.d.i.g(r0);     // Catch: Throwable -> L9
        d r1 = r0;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    @Override // d.c.b.b.d
    public long remove(String r1) {
        return p().remove(r1);
    }
}
