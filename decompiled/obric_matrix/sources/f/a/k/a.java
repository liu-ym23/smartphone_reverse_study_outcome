package f.a.k;

import f.a.c;
import f.a.f;
import f.a.i.b;
import f.a.i.d;
import f.a.i.e;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile d<? super Throwable> f17162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile e<? super Runnable, ? extends Runnable> f17163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile e<? super Callable<f>, ? extends f> f17164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile e<? super Callable<f>, ? extends f> f17165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile e<? super Callable<f>, ? extends f> f17166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile e<? super Callable<f>, ? extends f> f17167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile e<? super f, ? extends f> f17168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile e<? super f.a.a, ? extends f.a.a> f17169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile b<? super f.a.a, ? super c, ? extends c> f17170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile boolean f17171j;

    static <T, U, R> R a(b<T, U, R> r0, T r1, U r2) {
        return r0.a(r1, r2);
    L4:
        th = move-exception;
        throw f.a.j.e.a.a(th);
    }

    static <T, R> R b(e<T, R> r0, T r1) {
        return r0.apply(r1);
    L4:
        th = move-exception;
        throw f.a.j.e.a.a(th);
    }

    static f c(e<? super Callable<f>, ? extends f> r0, Callable<f> r1) {
        Object r2 = b(r0, r1);
        f.a.j.b.b.c(r2, "Scheduler Callable result can't be null");
        return (f) r2;
    }

    static f d(Callable<f> r1) {
        f r2 = r1.call();     // Catch: Throwable -> L4
        f.a.j.b.b.c(r2, "Scheduler Callable result can't be null");     // Catch: Throwable -> L4
        return r2;
    L4:
        th = move-exception;
        throw f.a.j.e.a.a(th);
    }

    public static f e(Callable<f> r1) {
        f.a.j.b.b.c(r1, "Scheduler Callable can't be null");
        e<? super Callable<f>, ? extends f> r0 = f17164c;
        if (r0 != null) goto L7;
        return d(r1);
    L7:
        return c(r0, r1);
    }

    public static f f(Callable<f> r1) {
        f.a.j.b.b.c(r1, "Scheduler Callable can't be null");
        e<? super Callable<f>, ? extends f> r0 = f17166e;
        if (r0 != null) goto L7;
        return d(r1);
    L7:
        return c(r0, r1);
    }

    public static f g(Callable<f> r1) {
        f.a.j.b.b.c(r1, "Scheduler Callable can't be null");
        e<? super Callable<f>, ? extends f> r0 = f17167f;
        if (r0 != null) goto L7;
        return d(r1);
    L7:
        return c(r0, r1);
    }

    public static f h(Callable<f> r1) {
        f.a.j.b.b.c(r1, "Scheduler Callable can't be null");
        e<? super Callable<f>, ? extends f> r0 = f17165d;
        if (r0 != null) goto L7;
        return d(r1);
    L7:
        return c(r0, r1);
    }

    static boolean i(Throwable r2) {
        if ((r2 instanceof f.a.h.c) == false) goto L6;
        return true;
    L6:
        if ((r2 instanceof IllegalStateException) == false) goto L9;
        return true;
    L9:
        if ((r2 instanceof NullPointerException) == false) goto L12;
        return true;
    L12:
        if ((r2 instanceof IllegalArgumentException) == false) goto L15;
        return true;
    L15:
        if ((r2 instanceof f.a.h.a) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean j() {
        return f17171j;
    }

    public static <T> f.a.a<T> k(f.a.a<T> r1) {
        e<? super f.a.a, ? extends f.a.a> r0 = f17169h;
        if (r0 != null) goto L5;
        return r1;
    L5:
        return (f.a.a) b(r0, r1);
    }

    public static f l(f r1) {
        e<? super f, ? extends f> r0 = f17168g;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (f) b(r0, r1);
    }

    public static void m(Throwable r2) {
        d<? super Throwable> r0 = f17162a;
        if (r2 != null) goto L6;
        r2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r0 != null) goto L15;
    L13:
        r2.printStackTrace();
        q(r2);
        return;
    L15:
        r0.accept(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        q(th);
        goto L13
    L6:
        if (i(r2) == true) goto L8;
        r2 = new f.a.h.e(r2);
        goto L8
    }

    public static Runnable n(Runnable r1) {
        f.a.j.b.b.c(r1, "run is null");
        e<? super Runnable, ? extends Runnable> r0 = f17163b;
        if (r0 != null) goto L6;
        return r1;
    L6:
        return (Runnable) b(r0, r1);
    }

    public static <T> c<? super T> o(f.a.a<T> r1, c<? super T> r2) {
        b<? super f.a.a, ? super c, ? extends c> r0 = f17170i;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return (c) a(r0, r1, r2);
    }

    public static void p(d<? super Throwable> r1) {
        if (f17171j == true) goto L7;
        f17162a = r1;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    static void q(Throwable r2) {
        Thread r0 = Thread.currentThread();
        r0.getUncaughtExceptionHandler().uncaughtException(r0, r2);
    }
}
