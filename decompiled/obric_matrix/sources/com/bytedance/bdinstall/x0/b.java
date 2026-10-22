package com.bytedance.bdinstall.x0;

import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.bytedance.bdinstall.t;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f2895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Type, c> f2897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    public static final ConcurrentHashMap<com.bytedance.bdinstall.x0.c, Object> f2898d = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f2899f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.bytedance.bdinstall.x0.a f2900g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Object f2901h;

        a(c r1, com.bytedance.bdinstall.x0.a r2, Object r3) {
            this.f2899f = r1;
            this.f2900g = r2;
            this.f2901h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<com.bytedance.bdinstall.x0.a> r0 = this.f2899f.a().iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            if (this.f2900g != r0.next()) goto L4;
            this.f2900g.a(this.f2901h);
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdinstall.x0.b$b, reason: collision with other inner class name */
    class RunnableC0081b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f2902f;

        RunnableC0081b(Object r1) {
            this.f2902f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.f2902f);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConcurrentHashMap<com.bytedance.bdinstall.x0.a, Object> f2904b;

        private c() {
            this.f2904b = new ConcurrentHashMap();
        }

        /* synthetic */ c(a r1) {
            this();
        }

        Set<com.bytedance.bdinstall.x0.a> a() {
            return this.f2904b.keySet();
        }

        public void b(com.bytedance.bdinstall.x0.a r1, Object r2) {
            this.f2904b.put(r1, r2);
        }
    }

    static {
        f2895a = new Object();
        f2896b = new Object();
        f2897c = new ConcurrentHashMap();
        f2898d = new ConcurrentHashMap();
    }

    private static <EVENT> void a(com.bytedance.bdinstall.x0.a<EVENT> r1, c r2, Object r3) {
        t.e(new a(r2, r1, r3));
    }

    @MainThread
    public static <Event> void b(Event r4) {
        if (Looper.myLooper() == t.c()) goto L6;
        t.e(new RunnableC0081b(r4));
        return;
    L6:
        Object r0 = f2895a;
        monitor-enter(r0);
        ConcurrentHashMap<Type, c> r1 = f2897c;     // Catch: Throwable -> L19
        c r2 = r1.get(r4.getClass());     // Catch: Throwable -> L19
        if (r2 != null) goto L11;
        r2 = new c(null);     // Catch: Throwable -> L19
        r1.put(r4.getClass(), r2);     // Catch: Throwable -> L19
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L19
        r2.f2903a = r4;
        Iterator<com.bytedance.bdinstall.x0.a> r3 = r2.a().iterator();
    L14:
        if (r3.hasNext() == false) goto L18;
        com.bytedance.bdinstall.x0.a r5 = r3.next();
        if (r5 == null) goto L14;
        r5.a(r4);
        goto L14
    L18:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <EVENT> void c(boolean r5, com.bytedance.bdinstall.x0.a<EVENT> r6) {
        if (r6 != 0) goto L4;
        return;
    L4:
        Type r0 = ((ParameterizedType) r6.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Object r1 = f2895a;
        monitor-enter(r1);
        ConcurrentHashMap<Type, c> r2 = f2897c;     // Catch: Throwable -> L18
        c r3 = r2.get(r0);     // Catch: Throwable -> L18
        if (r3 != null) goto L9;
        r3 = new c(null);     // Catch: Throwable -> L18
        r2.put(r0, r3);     // Catch: Throwable -> L18
    L9:
        Object r4 = f2896b;     // Catch: Throwable -> L18
        r3.b(r6, r4);     // Catch: Throwable -> L18
        if ((r6 instanceof com.bytedance.bdinstall.x0.c) == false) goto L12;
        f2898d.put((com.bytedance.bdinstall.x0.c) r6, r4);     // Catch: Throwable -> L18
    L12:
        if (r5 == false) goto L16;
        Object r7 = r3.f2903a;     // Catch: Throwable -> L18
        if (r7 == null) goto L16;
        a(r6, r3, r7);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void d(Object r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Object r0 = f2895a;
        monitor-enter(r0);
        com.bytedance.bdinstall.x0.c r1 = null;
        Iterator<com.bytedance.bdinstall.x0.c> r2 = f2898d.keySet().iterator();     // Catch: Throwable -> L17
    L9:
        if (r2.hasNext() == false) goto L13;
        com.bytedance.bdinstall.x0.c r3 = r2.next();     // Catch: Throwable -> L17
        if (r3.b() != r5) goto L9;
        r1 = r3;
    L13:
        if (r1 == null) goto L15;
        d(r1);     // Catch: Throwable -> L17
        f2898d.remove(r1);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
