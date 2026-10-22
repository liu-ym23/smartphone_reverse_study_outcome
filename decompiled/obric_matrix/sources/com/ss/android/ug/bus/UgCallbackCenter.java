package com.ss.android.ug.bus;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class UgCallbackCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f12316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> f12317b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Handler f12318c = null;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LifecycleOwner f12322f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f12323g;

        a(LifecycleOwner r1, d r2) {
            this.f12322f = r1;
            this.f12323g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            UgCallbackCenter.c(this.f12322f, this.f12323g);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f12324f;

        b(d r1) {
            this.f12324f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            UgCallbackCenter.e(this.f12324f);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f12325f;

        c(Object r1) {
            this.f12325f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            UgCallbackCenter.b(this.f12325f);
        }
    }

    public interface d<T> {
        void a(T r1);
    }

    static {
        f12316a = new Object();
        f12317b = new ConcurrentHashMap();
        f12318c = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ ConcurrentHashMap a() {
        return f12317b;
    }

    public static <Event> void b(Event r2) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        f12318c.post(new c(r2));
        return;
    L6:
        ConcurrentHashMap<d, Object> r0 = f12317b.get(r2.getClass());
        if (r0 == null) goto L14;
        Iterator<d> r1 = r0.keySet().iterator();
    L10:
        if (r1.hasNext() == false) goto L20;
        d r3 = r1.next();
        if (r3 == null) goto L10;
        r3.a(r2);
        goto L10
    L20:
        return;
    }

    public static <EVENT> void c(LifecycleOwner r3, final d<EVENT> r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        f12318c.post(new a(r3, r4));
        return;
    L8:
        final Type r0 = ((ParameterizedType) r4.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> r1 = f12317b;
        final ConcurrentHashMap<d, Object> r2 = r1.get(r0);
        if (r2 != null) goto L11;
        r2 = new ConcurrentHashMap();
        r1.put(r0, r2);
    L11:
        r2.put(r4, f12316a);
        if (r3 == null) goto L15;
        r3.getLifecycle().addObserver(new AnonymousClass2(r2, r4, r0));
        return;
    }

    public static <EVENT> void d(d<EVENT> r1) {
        c(null, r1);
    }

    public static <EVENT> void e(d<EVENT> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L8;
        f12318c.post(new b(r3));
        return;
    L8:
        Type r0 = ((ParameterizedType) r3.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        ConcurrentHashMap<Type, ConcurrentHashMap<d, Object>> r1 = f12317b;
        ConcurrentHashMap<d, Object> r2 = r1.get(r0);
        if (r2 == null) goto L14;
        r2.remove(r3);
        if (r2.isEmpty() == false) goto L15;
        r1.remove(r0);
        return;
    L15:
        return;
    }
}
