package d.b.r;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
abstract class m<ResponseT, ReturnT> extends z<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final u<ReturnT> f14475a;

    static final class a<ResponseT, ReturnT> extends m<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.c<ResponseT, ReturnT> f14476b;

        a(u r1, d.b.r.c<ResponseT, ReturnT> r2) {
            super(r1);
            this.f14476b = r2;
        }

        @Override // d.b.r.m
        protected ReturnT c(d.b.r.b<ResponseT> r1, Object[] r2) {
            return this.f14476b.b(r1);
        }
    }

    static final class b<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.c<ResponseT, d.b.r.b<ResponseT>> f14477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f14478c;

        b(u r1, d.b.r.c<ResponseT, d.b.r.b<ResponseT>> r2, boolean r3) {
            super(r1);
            this.f14477b = r2;
            this.f14478c = r3;
        }

        @Override // d.b.r.m
        protected Object c(d.b.r.b<ResponseT> r2, Object[] r3) {
            d.b.r.b<ResponseT> r4 = this.f14477b.b(r2);
            kotlin.k0.d r5 = (kotlin.k0.d) r3[r3.length - 1];
        L8:
            e = move-exception;
            return p.d(e, r5);
        L4:
            if (this.f14478c == false) goto L7;
            return p.b(r4, r5);
        L7:
            return p.a(r4, r5);
        }
    }

    static final class c<ResponseT> extends m<ResponseT, Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.b.r.c<ResponseT, d.b.r.b<ResponseT>> f14479b;

        c(u r1, d.b.r.c<ResponseT, d.b.r.b<ResponseT>> r2) {
            super(r1);
            this.f14479b = r2;
        }

        @Override // d.b.r.m
        protected Object c(d.b.r.b<ResponseT> r1, Object[] r2) {
            d.b.r.b<ResponseT> r0 = this.f14479b.b(r1);
            kotlin.k0.d r3 = (kotlin.k0.d) r2[r2.length - 1];
            return p.c(r0, r3);
        L5:
            e = move-exception;
            return p.d(e, r3);
        }
    }

    m(u<ReturnT> r1) {
        this.f14475a = r1;
    }

    private static <ResponseT, ReturnT> d.b.r.c<ResponseT, ReturnT> d(v r1, Method r2, Type r3, Annotation[] r4) {
        return (d.b.r.c<ResponseT, ReturnT>) r1.c(r3, r4);
    L4:
        e = move-exception;
        throw f0.p(r2, e, "Unable to create call adapter for %s", new Object[]{r3});
    }

    private static <ResponseT> f<d.b.r.k0.i, ResponseT> e(v r2, Method r3, Type r4) {
        return r2.q(r4, r3.getAnnotations());
    L5:
        e = move-exception;
        throw f0.p(r3, e, "Unable to create converter for %s", new Object[]{r4});
    }

    static <ResponseT, ReturnT> m<ResponseT, ReturnT> f(v r10, Method r11, u r12) {
        boolean r1 = r12.f14561a;
        Annotation[] r2 = r11.getAnnotations();
        if (r1 == false) goto L11;
        Type[] r4 = r11.getGenericParameterTypes();
        Type r5 = f0.h(0, (ParameterizedType) r4[r4.length - 1]);
        if (f0.j(r5) == d0.class) goto L7;
    L9:
        boolean r6 = false;
    L10:
        Type r7 = new f0.c(null, d.b.r.b.class, new Type[]{r5});
        r2 = b0.a(r2);
    L12:
        d.b.r.c r3 = d(r10, r11, r7, r2);
        Type r8 = r3.a();
        if (r8 == p000j.f0.class) goto L38;
        if (r8 == d0.class) goto L36;
        if (r8 == d.b.r.h0.d.class) goto L34;
        if (r12.q.equals("HEAD") == true) goto L20;
    L24:
        r12.p = e(r10, r11, r8);
        if (r1 == false) goto L27;
        if (r6 == false) goto L32;
        return new c(r12, r3);
    L32:
        return new b(r12, r3, false);
    L27:
        return new a(r12, r3);
    L20:
        if (Void.class.equals(r8) == true) goto L24;
        throw f0.o(r11, "HEAD method must use Void as response type.", new Object[0]);
    L34:
        throw f0.o(r11, "'" + f0.j(r8).getName() + "' is not a valid response body type.", new Object[0]);
    L36:
        throw f0.o(r11, "Response must include generic type (e.g., SsResponse<String>)", new Object[0]);
    L38:
        throw f0.o(r11, "'" + f0.j(r8).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L9;
        r5 = f0.i(0, (ParameterizedType) r5);
        r6 = true;
        goto L10
    L11:
        r7 = r11.getGenericReturnType();
        r6 = false;
        goto L12
    }

    @Override // d.b.r.z
    final ReturnT a(Object[] r3) {
        return c(new c0(this.f14475a, r3), r3);
    }

    protected abstract ReturnT c(d.b.r.b<ResponseT> r1, Object[] r2);
}
