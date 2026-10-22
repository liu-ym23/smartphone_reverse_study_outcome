package d.b.r;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final c.a f14360a = null;

    class a implements c<Object, b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f14361a;

        a(g r1, Type r2) {
            this.f14361a = r2;
        }

        @Override // d.b.r.c
        public Type a() {
            return this.f14361a;
        }

        @Override // d.b.r.c
        public /* bridge */ /* synthetic */ b<?> b(b<Object> r1) {
            c(r1);
            return r1;
        }

        public b<Object> c(b<Object> r1) {
            return r1;
        }
    }

    static {
        f14360a = new g();
    }

    g() {
    }

    @Override // d.b.r.c.a
    public c<?, ?> a(Type r1, Annotation[] r2, v r3) {
        if (c.a.b(r1) == b.class) goto L7;
        return null;
    L7:
        return new a(this, f0.f(r1));
    }
}
