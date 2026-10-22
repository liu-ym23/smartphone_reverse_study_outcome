package f.a.l;

import f.a.j.d.j;
import f.a.j.d.k;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f.a.f f17172a = null;

    /* JADX INFO: renamed from: f.a.l.a$a, reason: collision with other inner class name */
    static final class C0456a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f.a.f f17173a = null;

        static {
            f17173a = new f.a.j.d.b();
        }
    }

    static final class b implements Callable<f.a.f> {
        b() {
        }

        public f.a.f a() {
            return C0456a.f17173a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ f.a.f call() {
            return a();
        }
    }

    static final class c implements Callable<f.a.f> {
        c() {
        }

        public f.a.f a() {
            return d.f17174a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ f.a.f call() {
            return a();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f.a.f f17174a = null;

        static {
            f17174a = new f.a.j.d.c();
        }
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f.a.f f17175a = null;

        static {
            f17175a = new f.a.j.d.d();
        }
    }

    static final class f implements Callable<f.a.f> {
        f() {
        }

        public f.a.f a() {
            return e.f17175a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ f.a.f call() {
            return a();
        }
    }

    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final f.a.f f17176a = null;

        static {
            f17176a = new j();
        }
    }

    static final class h implements Callable<f.a.f> {
        h() {
        }

        public f.a.f a() {
            return g.f17176a;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ f.a.f call() {
            return a();
        }
    }

    static {
        f.a.k.a.h(new h());
        f17172a = f.a.k.a.e(new b());
        f.a.k.a.f(new c());
        k.d();
        f.a.k.a.g(new f());
    }

    public static f.a.f a() {
        return f.a.k.a.l(f17172a);
    }
}
