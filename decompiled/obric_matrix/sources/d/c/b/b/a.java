package d.c.b.b;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.b.b.d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Class<?> f15273i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final long f15274j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f15275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f15277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f15278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f15279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f15280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d.c.b.a.a f15281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.facebook.common.time.a f15282h;

    /* JADX INFO: renamed from: d.c.b.b.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0412a {
    }

    private class b implements d.c.c.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d.c.b.b.d.a> f15283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private e f15284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f15285c;

        public b(a r1, e r2) {
            this.f15285c = r1;
            this.f15283a = new ArrayList();
            this.f15284b = r2;
        }

        @Override // d.c.c.c.b
        public void a(File r5) {
            C0412a r2 = null;
            if (this.f15284b != e.f15293g) goto L9;
            f r0 = a.n(this.f15285c, r5);
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.f15295a != ".cnt") goto L19;
            List<d.c.b.b.d.a> r4 = this.f15283a;
            d r1 = new d(r0.f15296b, r5, r2);
        L16:
            r4.add(r1);
            return;
        L19:
            return;
        L9:
            f r3 = a.l(this.f15285c, r5);
            if (r3 == null) goto L20;
            String r6 = r3.f15295a;
            if (r6 != ".cnt") goto L14;
        L15:
            r4 = this.f15283a;
            r1 = new d(r3.f15296b, r5, r2);
            goto L16
        L14:
            if (r6 == ".tmp") goto L15;
            return;
        }

        @Override // d.c.c.c.b
        public void b(File r1) {
        }

        @Override // d.c.c.c.b
        public void c(File r1) {
        }

        public List<d.c.b.b.d.a> d() {
            return Collections.unmodifiableList(this.f15283a);
        }
    }

    private class c implements d.c.c.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<d.c.b.b.d.a> f15286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f15287b;

        private c(a r1) {
            this.f15287b = r1;
            this.f15286a = new ArrayList();
        }

        /* synthetic */ c(a r1, C0412a r2) {
            this(r1);
        }

        @Override // d.c.c.c.b
        public void a(File r4) {
            f r0 = a.l(this.f15287b, r4);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.f15295a != ".cnt") goto L9;
            this.f15286a.add(new d(r0.f15296b, r4, null));
            return;
        }

        @Override // d.c.c.c.b
        public void b(File r1) {
        }

        @Override // d.c.c.c.b
        public void c(File r1) {
        }

        public List<d.c.b.b.d.a> d() {
            return Collections.unmodifiableList(this.f15286a);
        }
    }

    static class d implements d.c.b.b.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.c.a.b f15289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f15290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f15291d;

        private d(String r1, File r2) {
            d.c.c.d.i.g(r2);
            d.c.c.d.i.g(r1);
            this.f15288a = r1;
            this.f15289b = d.c.a.b.b(r2);
            this.f15290c = -1;
            this.f15291d = -1;
        }

        /* synthetic */ d(String r1, File r2, C0412a r3) {
            this(r1, r2);
        }

        @Override // d.c.b.b.d.a
        public long a() {
            if (this.f15290c >= 0) goto L6;
            this.f15290c = this.f15289b.size();
        L6:
            return this.f15290c;
        }

        @Override // d.c.b.b.d.a
        public long b() {
            if (this.f15291d >= 0) goto L6;
            this.f15291d = this.f15289b.c().lastModified();
        L6:
            return this.f15291d;
        }

        public d.c.a.b c() {
            return this.f15289b;
        }

        @Override // d.c.b.b.d.a
        public String getId() {
            return this.f15288a;
        }
    }

    static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f15292f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f15293g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ e[] f15294h = null;

        static {
            e r0 = new e("IMAGE_CACHE_FILE", 0);
            f15292f = r0;
            e r1 = new e("CONFIG_FILE", 1);
            f15293g = r1;
            f15294h = new e[]{r0, r1};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f15294h.clone();
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15296b;

        private f(String r1, String r2) {
            this.f15295a = r1;
            this.f15296b = r2;
        }

        /* synthetic */ f(String r1, String r2, C0412a r3) {
            this(r1, r2);
        }

        public static f b(File r5) {
            String r6 = r5.getName();
            int r1 = r6.lastIndexOf(46);
            if (r1 > 0) goto L5;
            return null;
        L5:
            String r3 = a.r(r6.substring(r1));
            if (r3 != null) goto L8;
            return null;
        L8:
            String r7 = r6.substring(0, r1);
            if (r3.equals(".tmp") == false) goto L15;
            int r0 = r7.lastIndexOf(46);
            if (r0 > 0) goto L13;
            return null;
        L13:
            r7 = r7.substring(0, r0);
        L15:
            return new f(r3, r7);
        }

        public File a(File r2) {
            return File.createTempFile(this.f15296b + ".", ".tmp", r2);
        }

        public String c(String r2) {
            return r2 + File.separator + this.f15296b + this.f15295a;
        }

        public String toString() {
            return this.f15295a + "(" + this.f15296b + ")";
        }
    }

    private static class g extends IOException {
        public g(long r3, long r5) {
            super("File was not written completely. Expected: " + r3 + ", found: " + r5);
        }
    }

    class h implements d.c.b.b.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final File f15298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f15299c;

        public h(a r1, String r2, File r3) {
            this.f15299c = r1;
            this.f15297a = r2;
            this.f15298b = r3;
        }

        @Override // d.c.b.b.d.b
        public boolean a() {
            if (this.f15298b.exists() == true) goto L5;
        L8:
            return true;
        L5:
            if (this.f15298b.delete() == true) goto L8;
            return false;
        }

        @Override // d.c.b.b.d.b
        public void b(d.c.b.a.k r5, Object r6) {
            FileOutputStream r7 = new FileOutputStream(this.f15298b);     // Catch: FileNotFoundException -> L12
            d.c.c.d.c r0 = new d.c.c.d.c(r7);     // Catch: Throwable -> L9
            r5.a(r0);     // Catch: Throwable -> L9
            r0.flush();     // Catch: Throwable -> L9
            long r1 = r0.a();     // Catch: Throwable -> L9
            r7.close();
            if (this.f15298b.length() != r1) goto L8;
            return;
        L8:
            throw new g(r1, this.f15298b.length());
        L9:
            th = move-exception;
            r7.close();
            throw th;
        L12:
            e = move-exception;
            a.m(this.f15299c).a(d.c.b.a.a.EnumC0411a.f15262l, a.s(), "updateResource", e);
            throw e;
        }

        @Override // d.c.b.b.d.b
        public d.c.a.a c(Object r4) {
            File r5 = this.f15299c.z(this.f15297a);
            d.c.c.c.c.b(this.f15298b, r5);     // Catch: d.c.c.c.c.d -> L9
            if (r5.exists() == false) goto L8;
            r5.setLastModified(a.q(this.f15299c).now());
        L8:
            return d.c.a.b.b(r5);
        L9:
            e = move-exception;
            Throwable r0 = e.getCause();
            if (r0 != null) goto L13;
        L18:
            d.c.b.a.a.EnumC0411a r1 = d.c.b.a.a.EnumC0411a.o;
        L19:
            a.m(this.f15299c).a(r1, a.s(), "commit", e);
            throw e;
        L13:
            if ((r0 instanceof d.c.c.c.c.C0413c) == false) goto L15;
            r1 = d.c.b.a.a.EnumC0411a.n;
            goto L19
        L15:
            if ((r0 instanceof FileNotFoundException) == false) goto L18;
            r1 = d.c.b.a.a.EnumC0411a.m;
            goto L19
        }
    }

    private class i implements d.c.c.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f15300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f15301b;

        private i(a r1) {
            this.f15301b = r1;
        }

        /* synthetic */ i(a r1, C0412a r2) {
            this(r1);
        }

        private boolean d(File r4) {
            f r0 = a.l(this.f15301b, r4);
            boolean r1 = false;
            if (r0 != null) goto L5;
            return false;
        L5:
            String r2 = r0.f15295a;
            if (r2 != ".tmp") goto L10;
            return e(r4);
        L10:
            if (r2 != ".cnt") goto L12;
            r1 = true;
        L12:
            d.c.c.d.i.i(r1);
            return true;
        }

        private boolean e(File r5) {
            if (r5.lastModified() <= (a.q(this.f15301b).now() - a.f15274j)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // d.c.c.c.b
        public void a(File r2) {
            if (this.f15300a == true) goto L5;
        L6:
            r2.delete();
            return;
        L5:
            if (d(r2) == false) goto L6;
        }

        @Override // d.c.c.c.b
        public void b(File r2) {
            if (this.f15300a == false) goto L5;
            return;
        L5:
            if (r2.equals(a.o(this.f15301b)) == false) goto L9;
            this.f15300a = true;
            return;
        }

        @Override // d.c.c.c.b
        public void c(File r2) {
            if (a.p(this.f15301b).equals(r2) == true) goto L8;
            if (this.f15300a == true) goto L8;
            r2.delete();
        L8:
            if (this.f15300a == true) goto L10;
            return;
        L10:
            if (r2.equals(a.o(this.f15301b)) == false) goto L14;
            this.f15300a = false;
            return;
        }
    }

    static {
        f15273i = a.class;
        f15274j = TimeUnit.MINUTES.toMillis(30);
    }

    public a(File r4, File r5, int r6, d.c.b.a.a r7) {
        d.c.c.d.i.g(r4);
        this.f15275a = r4;
        this.f15280f = r5;
        this.f15276b = I(r4, r7);
        this.f15277c = new File(r4, G(r6));
        this.f15279e = new File(r4, G(r6) + "-config");
        this.f15278d = new File(r5, G(r6) + "-config");
        this.f15281g = r7;
        N();
        M();
        this.f15282h = com.facebook.common.time.c.a();
    }

    private static String B(String r2) {
        if (".cnt".equals(r2) == false) goto L6;
        return ".cnt";
    L6:
        if (".tmp".equals(r2) == false) goto L8;
        return ".tmp";
    L8:
        return null;
    }

    private String C(String r4) {
        f r0 = new f(".cnt", r4, null);
        return r0.c(F(r0.f15296b));
    }

    private f D(File r4) {
        f r0 = f.b(r4);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (E(r0.f15296b).equals(r4.getParentFile()) == false) goto L9;
        return r0;
    L9:
        return null;
    }

    private File E(String r2) {
        return new File(F(r2));
    }

    private String F(String r2) {
        return this.f15277c + File.separator + String.valueOf(Math.abs(r2.hashCode() % 100));
    }

    static String G(int r3) {
        return String.format(null, "%s.ols%d.%d", new Object[]{"v2", 100, Integer.valueOf(r3)});
    }

    private void H(String r3, Object r4) {
        if ((r4 instanceof d.c.b.b.f) == true) goto L5;
        return;
    L5:
        Map<String, String> r5 = ((d.c.b.b.f) r4).b();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isEmpty() == true) goto L18;
        File r0 = new File(y(r3));
        if (r0.exists() == true) goto L12;
        K(r0, "insert");
    L12:
        File r6 = w(r3);
        if (r6.exists() == true) goto L15;
        r6.createNewFile();
    L15:
        J(r5, r6);
        return;
    }

    private static boolean I(File r6, d.c.b.a.a r7) {
        File r1 = Environment.getExternalStorageDirectory();     // Catch: Exception -> L15
        if (r1 == null) goto L24;
        String r2 = r1.toString();     // Catch: Exception -> L15
        String r8 = r6.getCanonicalPath();     // Catch: IOException -> L11 Exception -> L15
        return r8.contains(r2);
    L9:
        e = e;
    L13:
        r7.a(d.c.b.a.a.EnumC0411a.v, f15273i, "failed to read folder to check if external: " + r8, e);     // Catch: Exception -> L15
        return false;
    L11:
        e = e;
        r8 = null;
        goto L13
    L24:
        return false;
    L15:
        e = move-exception;
        r7.a(d.c.b.a.a.EnumC0411a.v, f15273i, "failed to get the external storage directory!", e);
        return false;
    }

    private File J(Map<String, String> r4, File r5) {
        StringBuilder r3 = new StringBuilder();
        FileWriter r0 = new FileWriter(r5, false);
        Iterator<Map.Entry<String, String>> r6 = r4.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r6.next();
        String r2 = r1.getKey();
        String r7 = r1.getValue();
        r3.append(r2);
        r3.append("=");
        r3.append(r7);
        r3.append(System.lineSeparator());
        goto L4
    L6:
        r0.write(r3.toString());
        r0.close();
        return r5;
    }

    private void K(File r3, String r4) {
        d.c.c.c.c.a(r3);     // Catch: d.c.c.c.c.a -> L4
        return;
    L4:
        e = move-exception;
        this.f15281g.a(d.c.b.a.a.EnumC0411a.p, f15273i, r4, e);
        throw e;
    }

    private boolean L(String r4, boolean r5) {
        File r6 = z(r4);
        boolean r0 = r6.exists();
        if (r5 == false) goto L6;
        if (r0 == false) goto L6;
        r6.setLastModified(this.f15282h.now());
    L6:
        return r0;
    }

    private void M() {
        boolean r1 = true;
        if (this.f15275a.exists() == true) goto L6;
    L9:
        if (r1 == false) goto L16;
        d.c.c.c.c.a(this.f15277c);     // Catch: d.c.c.c.c.a -> L12
        return;
    L12:
        this.f15281g.a(d.c.b.a.a.EnumC0411a.p, f15273i, "version directory could not be created: " + this.f15277c, null);
        return;
    L16:
        return;
    L6:
        if (this.f15277c.exists() == true) goto L8;
        d.c.c.c.a.b(this.f15275a);
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    private void N() {
        boolean r1 = true;
        if (this.f15275a.exists() == true) goto L6;
    L9:
        if (r1 == false) goto L16;
        d.c.c.c.c.a(this.f15277c);     // Catch: d.c.c.c.c.a -> L12
        return;
    L12:
        this.f15281g.a(d.c.b.a.a.EnumC0411a.p, f15273i, "version directory could not be created: " + this.f15277c, null);
        return;
    L16:
        return;
    L6:
        if (this.f15277c.exists() == true) goto L8;
        d.c.c.c.a.b(this.f15275a);
        goto L9
    L8:
        r1 = false;
        goto L9
    }

    static /* synthetic */ f l(a r0, File r1) {
        return r0.D(r1);
    }

    static /* synthetic */ d.c.b.a.a m(a r0) {
        return r0.f15281g;
    }

    static /* synthetic */ f n(a r0, File r1) {
        return r0.x(r1);
    }

    static /* synthetic */ File o(a r0) {
        return r0.f15277c;
    }

    static /* synthetic */ File p(a r0) {
        return r0.f15275a;
    }

    static /* synthetic */ com.facebook.common.time.a q(a r0) {
        return r0.f15282h;
    }

    static /* synthetic */ String r(String r0) {
        return B(r0);
    }

    static /* synthetic */ Class s() {
        return f15273i;
    }

    private long t(File r3) {
        if (r3.exists() == true) goto L6;
        return 0;
    L6:
        long r0 = r3.length();
        if (r3.delete() == false) goto L9;
        return r0;
    L9:
        return -1;
    }

    private Map<String, String> u(File r4) {
        HashMap r3 = new HashMap();
        if (r4.exists() == true) goto L5;
        return r3;
    L5:
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new FileReader(r4));     // Catch: Throwable -> L17 IOException -> L19
    L36:
        String r5 = r1.readLine();     // Catch: Throwable -> L13 IOException -> L15
        if (r5 == null) goto L10;
        int r2 = r5.lastIndexOf("=");     // Catch: Throwable -> L13 IOException -> L15
        r3.put(r5.substring(0, r2), r5.substring(r2 + 1));     // Catch: Throwable -> L13 IOException -> L15
        goto L36
    L10:
        r1.close();     // Catch: Throwable -> L13 IOException -> L15
        r1.close();     // Catch: IOException -> L27
    L29:
        goto L23
    L15:
        e = e;
        r0 = r1;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L17
        if (r0 == null) goto L23;
        r0.close();     // Catch: IOException -> L27
    L13:
        th = th;
        r0 = r1;
    L24:
        if (r0 != null) goto L33;
    L26:
        throw th;
    L33:
        r0.close();     // Catch: IOException -> L28
    L19:
        e = e;
    L17:
        th = th;
    L23:
        return r3;
    }

    private File w(String r3) {
        return new File(y(r3) + File.separator + r3 + ".cnt");
    }

    private f x(File r5) {
        f r0 = f.b(r5);
        if (r0 != null) goto L6;
        return null;
    L6:
        if (new File(y(r0.f15296b)).equals(r5.getParentFile()) == false) goto L9;
        return r0;
    L9:
        return null;
    }

    private String y(String r2) {
        return this.f15278d + File.separator + String.valueOf(Math.abs(r2.hashCode() % 100));
    }

    public List<d.c.b.b.d.a> A() {
        c r0 = new c(this, null);
        d.c.c.c.a.c(this.f15277c, r0);
        return r0.d();
    }

    @Override // d.c.b.b.d
    public long a(String r5) {
        String r0 = String.valueOf(Math.abs(r5.hashCode() % 100));
        StringBuilder r1 = new StringBuilder();
        r1.append(this.f15279e);
        String r2 = File.separator;
        r1.append(r2);
        r1.append(r0);
        t(new File(r1.toString() + r2 + r5 + ".cnt"));
        return t(w(r5));
    }

    @Override // d.c.b.b.d
    public void b() {
        d.c.c.c.a.c(this.f15275a, new i(this, null));
    }

    @Override // d.c.b.b.d
    public d.c.b.b.d.b c(String r5, Object r6) {
        f r0 = new f(".tmp", r5, null);
        File r1 = E(r0.f15296b);
        if (r1.exists() == true) goto L10;
        K(r1, "insert");
    L10:
        File r2 = r0.a(r1);     // Catch: IOException -> L7
        H(r5, r6);     // Catch: IOException -> L7
        return new h(this, r5, r2);
    L7:
        e = move-exception;
        this.f15281g.a(d.c.b.a.a.EnumC0411a.f15261k, f15273i, "insert", e);
        throw e;
    }

    @Override // d.c.b.b.d
    public /* bridge */ /* synthetic */ Collection d() {
        return v();
    }

    @Override // d.c.b.b.d
    public boolean e(String r1, Object r2) {
        return L(r1, false);
    }

    @Override // d.c.b.b.d
    public Map<String, String> f(String r4, Object r5) {
        String r6 = String.valueOf(Math.abs(r4.hashCode() % 100));
        StringBuilder r0 = new StringBuilder();
        r0.append(this.f15279e);
        String r1 = File.separator;
        r0.append(r1);
        r0.append(r6);
        Map<String, String> r7 = u(new File(r0.toString() + r1 + r4 + ".cnt"));
        r7.putAll(u(w(r4)));
        return r7;
    }

    @Override // d.c.b.b.d
    public d.c.a.a g(String r3, Object r4) {
        File r5 = z(r3);
        if (r5.exists() == false) goto L6;
        r5.setLastModified(this.f15282h.now());
        return d.c.a.b.b(r5);
    L6:
        return null;
    }

    @Override // d.c.b.b.d
    public /* bridge */ /* synthetic */ Collection h() {
        return A();
    }

    @Override // d.c.b.b.d
    public void i() {
        d.c.c.c.a.a(this.f15275a);
        d.c.c.c.a.a(this.f15280f);
    }

    @Override // d.c.b.b.d
    public boolean isExternal() {
        return this.f15276b;
    }

    @Override // d.c.b.b.d
    public List<d.c.b.b.d.a> j() {
        b r0 = new b(this, e.f15292f);
        d.c.c.c.a.c(this.f15277c, r0);
        return r0.d();
    }

    @Override // d.c.b.b.d
    public long k(d.c.b.b.d.a r1) {
        return t(((d) r1).c().c());
    }

    @Override // d.c.b.b.d
    public long remove(String r1) {
        return t(z(r1));
    }

    public List<d.c.b.b.d.a> v() {
        b r0 = new b(this, e.f15293g);
        d.c.c.c.a.c(this.f15278d, r0);
        return r0.d();
    }

    File z(String r2) {
        return new File(C(r2));
    }
}
