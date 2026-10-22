package d.b.r;

import androidx.core.app.NotificationCompat;
import h.a.b1;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.b f14482f;

        a(d.b.r.b r1) {
            this.f14482f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
            invoke2(r1);
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            this.f14482f.cancel();
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.b f14483f;

        b(d.b.r.b r1) {
            this.f14483f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
            invoke2(r1);
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            this.f14483f.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> implements d.b.r.e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a.n f14484a;

        c(h.a.n r1) {
            this.f14484a = r1;
        }

        @Override // d.b.r.e
        public void a(d.b.r.b<T> r4, d0<T> r5) {
            kotlin.n0.d.o.f(r4, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r5, "response");
            if (r5.e() == false) goto L8;
            T r6 = r5.a();
            if (r6 != null) goto L7;
            Object r7 = r4.b().V(o.class);
            kotlin.n0.d.o.c(r7);
            Method r8 = ((o) r7).a();
            StringBuilder r0 = new StringBuilder();
            r0.append("Response from ");
            kotlin.n0.d.o.e(r8, "method");
            Class<?> r1 = r8.getDeclaringClass();
            kotlin.n0.d.o.e(r1, "method.declaringClass");
            r0.append(r1.getName());
            r0.append('.');
            r0.append(r8.getName());
            r0.append(" was null but response body type was declared as non-null");
            kotlin.e r9 = new kotlin.e(r0.toString());
            h.a.n r3 = this.f14484a;
            kotlin.v.a r10 = kotlin.v.f21457g;
            Object r11 = kotlin.w.a(r9);
        L9:
            kotlin.v.b(r11);
            r3.resumeWith(r11);
            return;
        L7:
            h.a.n r12 = this.f14484a;
            kotlin.v.a r13 = kotlin.v.f21457g;
            kotlin.v.b(r6);
            r12.resumeWith(r6);
            return;
        L8:
            r3 = this.f14484a;
            l r14 = new l(r5);
            kotlin.v.a r15 = kotlin.v.f21457g;
            r11 = kotlin.w.a(r14);
            goto L9
        }

        @Override // d.b.r.e
        public void b(d.b.r.b<T> r2, Throwable r3) {
            kotlin.n0.d.o.f(r2, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r3, "t");
            h.a.n r1 = this.f14484a;
            kotlin.v.a r4 = kotlin.v.f21457g;
            Object r5 = kotlin.w.a(r3);
            kotlin.v.b(r5);
            r1.resumeWith(r5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> implements d.b.r.e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a.n f14485a;

        d(h.a.n r1) {
            this.f14485a = r1;
        }

        @Override // d.b.r.e
        public void a(d.b.r.b<T> r2, d0<T> r3) {
            kotlin.n0.d.o.f(r2, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r3, "response");
            boolean r4 = r3.e();
            h.a.n r1 = this.f14485a;
            if (r4 == false) goto L5;
            Object r5 = r3.a();
            kotlin.v.a r6 = kotlin.v.f21457g;
        L6:
            kotlin.v.b(r5);
            r1.resumeWith(r5);
            return;
        L5:
            l r7 = new l(r3);
            kotlin.v.a r8 = kotlin.v.f21457g;
            r5 = kotlin.w.a(r7);
            goto L6
        }

        @Override // d.b.r.e
        public void b(d.b.r.b<T> r2, Throwable r3) {
            kotlin.n0.d.o.f(r2, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r3, "t");
            h.a.n r1 = this.f14485a;
            kotlin.v.a r4 = kotlin.v.f21457g;
            Object r5 = kotlin.w.a(r3);
            kotlin.v.b(r5);
            r1.resumeWith(r5);
        }
    }

    static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.b f14486f;

        e(d.b.r.b r1) {
            this.f14486f = r1;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(Throwable r1) {
            invoke2(r1);
            return kotlin.f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable r1) {
            this.f14486f.cancel();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class f<T> implements d.b.r.e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h.a.n f14487a;

        f(h.a.n r1) {
            this.f14487a = r1;
        }

        @Override // d.b.r.e
        public void a(d.b.r.b<T> r2, d0<T> r3) {
            kotlin.n0.d.o.f(r2, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r3, "response");
            h.a.n r1 = this.f14487a;
            kotlin.v.a r4 = kotlin.v.f21457g;
            kotlin.v.b(r3);
            r1.resumeWith(r3);
        }

        @Override // d.b.r.e
        public void b(d.b.r.b<T> r2, Throwable r3) {
            kotlin.n0.d.o.f(r2, NotificationCompat.CATEGORY_CALL);
            kotlin.n0.d.o.f(r3, "t");
            h.a.n r1 = this.f14487a;
            kotlin.v.a r4 = kotlin.v.f21457g;
            Object r5 = kotlin.w.a(r3);
            kotlin.v.b(r5);
            r1.resumeWith(r5);
        }
    }

    static final class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.k0.d f14488f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Exception f14489g;

        g(kotlin.k0.d r1, Exception r2) {
            this.f14488f = r1;
            this.f14489g = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlin.k0.d r0 = kotlin.k0.i.b.b(this.f14488f);
            Exception r2 = this.f14489g;
            kotlin.v.a r1 = kotlin.v.f21457g;
            Object r3 = kotlin.w.a(r2);
            kotlin.v.b(r3);
            r0.resumeWith(r3);
        }
    }

    public static final <T> Object a(d.b.r.b<T> r3, kotlin.k0.d<? super T> r4) {
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r4), 1);
        r0.A();
        r0.h(new a(r3));
        r3.l(new c(r0));
        Object r5 = r0.x();
        if (r5 != kotlin.k0.i.b.c()) goto L5;
        kotlin.k0.j.a.h.c(r4);
    L5:
        return r5;
    }

    public static final <T> Object b(d.b.r.b<T> r3, kotlin.k0.d<? super T> r4) {
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r4), 1);
        r0.A();
        r0.h(new b(r3));
        r3.l(new d(r0));
        Object r5 = r0.x();
        if (r5 != kotlin.k0.i.b.c()) goto L5;
        kotlin.k0.j.a.h.c(r4);
    L5:
        return r5;
    }

    public static final <T> Object c(d.b.r.b<T> r3, kotlin.k0.d<? super d0<T>> r4) {
        h.a.o r0 = new h.a.o(kotlin.k0.i.b.b(r4), 1);
        r0.A();
        r0.h(new e(r3));
        r3.l(new f(r0));
        Object r5 = r0.x();
        if (r5 != kotlin.k0.i.b.c()) goto L5;
        kotlin.k0.j.a.h.c(r4);
    L5:
        return r5;
    }

    public static final Object d(Exception r3, kotlin.k0.d<?> r4) {
        b1.a().dispatch(r4.getContext(), new g(r4, r3));
        Object r5 = kotlin.k0.i.b.c();
        if (r5 != kotlin.k0.i.b.c()) goto L6;
        kotlin.k0.j.a.h.c(r4);
    L6:
        if (r5 != kotlin.k0.i.b.c()) goto L9;
        return r5;
    L9:
        return kotlin.f0.f18324a;
    }
}
