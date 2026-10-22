package d.b.r;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class a extends d.b.r.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14319a;

    /* JADX INFO: renamed from: d.b.r.a$a, reason: collision with other inner class name */
    static final class C0387a implements d.b.r.f<d.b.r.k0.i, d.b.r.k0.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0387a f14320a = null;

        static {
            f14320a = new C0387a();
        }

        C0387a() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ d.b.r.k0.i a(d.b.r.k0.i r1) {
            return b(r1);
        }

        public d.b.r.k0.i b(d.b.r.k0.i r4) {
            if (r4 != null) goto L4;
        L15:
            return r4;
        L4:
            if ((r4 instanceof d.b.r.k0.g) == true) goto L15;
            String r3 = r4.a();
            InputStream r5 = r4.d();
            d.b.r.k0.g r1 = new d.b.r.k0.g(r3, f0.w(r5), new String[0]);     // Catch: Throwable -> L11
            if (r5 != null) goto L22;
        L10:
            return r1;
        L22:
            r5.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r5 != null) goto L20;
        L14:
            throw th;
        L20:
            r5.close();     // Catch: IOException -> L17
            goto L14
        }
    }

    static final class b implements d.b.r.f<d.b.r.h0.b, d.b.r.h0.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f14321a = null;

        static {
            f14321a = new b();
        }

        b() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ d.b.r.h0.b a(d.b.r.h0.b r1) {
            d.b.r.h0.b r2 = r1;
            b(r2);
            return r2;
        }

        public d.b.r.h0.b b(d.b.r.h0.b r1) {
            return r1;
        }
    }

    static final class c implements d.b.r.f<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f14322a = null;

        static {
            f14322a = new c();
        }

        c() {
        }

        @Override // d.b.r.f
        public Object a(Object r1) {
            return r1;
        }
    }

    static final class d implements d.b.r.f<d.b.r.k0.j, d.b.r.k0.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f14323a = null;

        static {
            f14323a = new d();
        }

        d() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ d.b.r.k0.j a(d.b.r.k0.j r1) {
            d.b.r.k0.j r2 = r1;
            b(r2);
            return r2;
        }

        public d.b.r.k0.j b(d.b.r.k0.j r1) {
            return r1;
        }
    }

    static final class e implements d.b.r.f<d.b.r.k0.i, d.b.r.k0.i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f14324a = null;

        static {
            f14324a = new e();
        }

        e() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ d.b.r.k0.i a(d.b.r.k0.i r1) {
            d.b.r.k0.i r2 = r1;
            b(r2);
            return r2;
        }

        public d.b.r.k0.i b(d.b.r.k0.i r1) {
            return r1;
        }
    }

    static final class f implements d.b.r.f<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f f14325a = null;

        static {
            f14325a = new f();
        }

        f() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ String a(String r1) {
            String r2 = r1;
            b(r2);
            return r2;
        }

        public String b(String r1) {
            return r1;
        }
    }

    static final class g implements d.b.r.f<d.b.r.k0.i, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f14326a = null;

        static {
            f14326a = new g();
        }

        g() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ String a(d.b.r.k0.i r1) {
            return b(r1);
        }

        public String b(d.b.r.k0.i r2) {
            if ((r2 instanceof d.b.r.k0.g) == false) goto L9;
            String r1 = "UTF-8";
            if (r2.a() == null) goto L8;
            r1 = d.b.r.k0.d.a(r2.a(), "UTF-8");
        L8:
            return new String(((d.b.r.k0.g) r2).k(), r1);
        L9:
            return null;
        }
    }

    static final class h implements d.b.r.f<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f14327a = null;

        static {
            f14327a = new h();
        }

        h() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ String a(Object r1) {
            return b(r1);
        }

        public String b(Object r1) {
            return r1.toString();
        }
    }

    static final class i implements d.b.r.f<d.b.r.k0.i, kotlin.f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final i f14328a = null;

        static {
            f14328a = new i();
        }

        i() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ kotlin.f0 a(d.b.r.k0.i r1) {
            return b(r1);
        }

        public kotlin.f0 b(d.b.r.k0.i r1) {
            r1.d().close();     // Catch: IOException -> L4
        L7:
            return kotlin.f0.f18324a;
        L4:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    static final class j implements d.b.r.f<d.b.r.k0.i, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final j f14329a = null;

        static {
            f14329a = new j();
        }

        j() {
        }

        @Override // d.b.r.f
        public /* bridge */ /* synthetic */ Void a(d.b.r.k0.i r1) {
            return b(r1);
        }

        public Void b(d.b.r.k0.i r1) {
            InputStream r0 = r1.d();
            if (r0 == null) goto L7;
            r0.close();
            return null;
        L7:
            return null;
        }
    }

    a() {
        this.f14319a = true;
    }

    @Override // d.b.r.f.a
    public d.b.r.f<?, d.b.r.h0.b> a(Type r1, Annotation[] r2, v r3) {
        if (r1 == d.b.r.h0.b.class) goto L5;
        return null;
    L5:
        return b.f14321a;
    }

    @Override // d.b.r.f.a
    public d.b.r.f<?, Object> b(Type r1, Annotation[] r2, v r3) {
        if (r1 == Object.class) goto L5;
        return null;
    L5:
        return c.f14322a;
    }

    @Override // d.b.r.f.a
    public d.b.r.f<?, d.b.r.k0.j> c(Type r1, Annotation[] r2, Annotation[] r3, v r4) {
        if (d.b.r.k0.j.class.isAssignableFrom(f0.j(r1)) == true) goto L5;
        return null;
    L5:
        return d.f14323a;
    }

    @Override // d.b.r.f.a
    public d.b.r.f<d.b.r.k0.i, ?> d(Type r1, Annotation[] r2, v r3) {
        if (r1 != d.b.r.k0.i.class) goto L11;
        if (f0.n(r2, d.b.r.i0.e0.class) == false) goto L9;
        return e.f14324a;
    L9:
        return C0387a.f14320a;
    L11:
        if (r1 != String.class) goto L15;
        return g.f14326a;
    L15:
        if (r1 != Void.class) goto L19;
        return j.f14329a;
    L19:
        if (this.f14319a == true) goto L21;
        return null;
    L21:
        if (r1 != kotlin.f0.class) goto L30;
        return i.f14328a;
    L24:
        this.f14319a = false;
        return null;
    L30:
        return null;
    }

    @Override // d.b.r.f.a
    public d.b.r.f<?, String> e(Type r1, Annotation[] r2, v r3) {
        if (r1 == String.class) goto L5;
        return null;
    L5:
        return f.f14325a;
    }
}
