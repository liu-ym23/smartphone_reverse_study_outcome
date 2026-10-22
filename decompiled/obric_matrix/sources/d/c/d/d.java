package d.c.d;

import d.c.c.d.l;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static class a<T> implements l<c<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f15472a;

        a(Throwable r1) {
            this.f15472a = r1;
        }

        public c<T> a() {
            return d.b(this.f15472a);
        }

        @Override // d.c.c.d.l
        public /* bridge */ /* synthetic */ Object get() {
            return a();
        }
    }

    public static <T> l<c<T>> a(Throwable r1) {
        return new a(r1);
    }

    public static <T> c<T> b(Throwable r1) {
        h r0 = h.t();
        r0.m(r1);
        return r0;
    }
}
