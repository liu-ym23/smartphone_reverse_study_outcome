package f.a;

import f.a.j.c.a.g;
import f.a.j.c.a.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements e<T> {
    public a() {
    }

    public static <T> a<T> b(d<T> r1) {
        f.a.j.b.b.c(r1, "onSubscribe is null");
        return f.a.k.a.k(new f.a.j.c.a.c(r1));
    }

    public static <T> a<T> c(Throwable r1) {
        f.a.j.b.b.c(r1, "exception is null");
        return f.a.k.a.k(new f.a.j.c.a.d(r1));
    }

    public static <T> a<T> e(T r1) {
        f.a.j.b.b.c(r1, "item is null");
        return f.a.k.a.k(new f.a.j.c.a.f(r1));
    }

    @Override // f.a.e
    public final void a(c<? super T> r2) {
        f.a.j.b.b.c(r2, "observer is null");
        c<? super T> r3 = f.a.k.a.o(this, r2);
        f.a.j.b.b.c(r3, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        i(r3);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        f.a.h.b.a(th);
        NullPointerException r4 = new NullPointerException("subscribeActual failed");
        r4.initCause(th);
        throw r4;
    }

    public final <R> a<R> d(f.a.i.e<? super T, ? extends e<? extends R>> r2) {
        f.a.j.b.b.c(r2, "mapper is null");
        return f.a.k.a.k(new f.a.j.c.a.e(this, r2));
    }

    public final <R> a<R> f(f.a.i.e<? super T, ? extends R> r2) {
        f.a.j.b.b.c(r2, "mapper is null");
        return f.a.k.a.k(new g(this, r2));
    }

    public final f.a.g.b g(f.a.i.d<? super T> r2, f.a.i.d<? super Throwable> r3) {
        return h(r2, r3, f.a.j.b.a.f17059b);
    }

    public final f.a.g.b h(f.a.i.d<? super T> r2, f.a.i.d<? super Throwable> r3, f.a.i.a r4) {
        f.a.j.b.b.c(r2, "onSuccess is null");
        f.a.j.b.b.c(r3, "onError is null");
        f.a.j.b.b.c(r4, "onComplete is null");
        f.a.j.c.a.b r0 = new f.a.j.c.a.b(r2, r3, r4);
        k(r0);
        return r0;
    }

    protected abstract void i(c<? super T> r1);

    public final a<T> j(f r2) {
        f.a.j.b.b.c(r2, "scheduler is null");
        return f.a.k.a.k(new h(this, r2));
    }

    public final <E extends c<? super T>> E k(E r1) {
        a(r1);
        return r1;
    }
}
