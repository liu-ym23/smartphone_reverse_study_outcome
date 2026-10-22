package com.bytedance.apm.r;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1839a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f1840b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f1841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f1842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f1843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f1844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Thread f1845g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f1846h;

    public static class a {
        volatile boolean haveAdd;
        volatile boolean haveRemove;
        List<j> mAddObservers;
        final List<j> mObservers;
        List<j> mRemoveObservers;

        public a() {
            this.mObservers = new ArrayList();
            this.mRemoveObservers = new ArrayList();
            this.mAddObservers = new ArrayList();
            this.haveRemove = false;
            this.haveAdd = false;
        }

        public void addMessageObserver(j r3) {
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mAddObservers.contains(r3) == true) goto L8;
            this.mAddObservers.add(r3);     // Catch: Throwable -> L10
            this.haveAdd = true;     // Catch: Throwable -> L10
            goto L8
        }

        protected void messageDispatchStarting(String r5) {
            if (this.haveAdd == false) goto L18;
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            Iterator<j> r1 = this.mAddObservers.iterator();     // Catch: Throwable -> L15
        L8:
            if (r1.hasNext() == false) goto L12;
            j r2 = r1.next();     // Catch: Throwable -> L15
            if (this.mObservers.contains(r2) == true) goto L8;
            this.mObservers.add(r2);     // Catch: Throwable -> L15
            goto L8
        L12:
            this.mAddObservers.clear();     // Catch: Throwable -> L15
            this.haveAdd = false;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        L18:
            Iterator<j> r4 = this.mObservers.iterator();
        L20:
            if (r4.hasNext() == false) goto L24;
            j r3 = r4.next();
            if (r3 == null) goto L20;
            r3.a(r5);
            goto L20
        }

        public void messageDispatched(String r3, Message r4) {
            Iterator<j> r0 = this.mObservers.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            j r1 = r0.next();
            if (r1 == null) goto L4;
            r1.b(r3, r4);
            goto L4
        L9:
            if (this.haveRemove == false) goto L22;
            List<j> r5 = this.mObservers;
            monitor-enter(r5);
            Iterator<j> r6 = this.mRemoveObservers.iterator();     // Catch: Throwable -> L19
        L14:
            if (r6.hasNext() == false) goto L16;
            j r2 = r6.next();     // Catch: Throwable -> L19
            this.mObservers.remove(r2);     // Catch: Throwable -> L19
            this.mAddObservers.remove(r2);     // Catch: Throwable -> L19
            goto L14
        L16:
            this.mRemoveObservers.clear();     // Catch: Throwable -> L19
            this.haveRemove = false;     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public void removeMessageObserver(j r3) {
            List<j> r0 = this.mObservers;
            monitor-enter(r0);
            if (r3 != null) goto L13;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.mRemoveObservers.contains(r3) == true) goto L8;
            this.mRemoveObservers.add(r3);     // Catch: Throwable -> L10
            this.haveRemove = true;     // Catch: Throwable -> L10
            goto L8
        }

        protected void setup(Object r1) {
        }
    }

    static {
        f1845g = Looper.getMainLooper().getThread();
    }

    public static void a(j r1) {
        a r0 = f1846h;
        if (r0 == null) goto L6;
        r0.addMessageObserver(r1);
        return;
    }

    public static void b() {
        if (f1839a == true) goto L5;
        return;
    L5:
        if (f1846h == null) goto L12;
        g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{f1846h});     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public static List<j> c() {
        a r0 = f1846h;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.mObservers;
    }

    public static synchronized boolean d(Printer r9) {
        monitor-enter(k.class);
    L32:
        th = move-exception;
        throw th;
    L6:
        if (f1839a == false) goto L11;
        monitor-exit(k.class);
        return true;
    L11:
        if (Build.VERSION.SDK_INT >= 29) goto L35;
    L29:
        f1846h = new a();     // Catch: Throwable -> L32
        f1841c = null;     // Catch: Throwable -> L32
        f1840b = true;     // Catch: Throwable -> L32
        f1839a = true;     // Catch: Throwable -> L32
        boolean r10 = f1839a;     // Catch: Throwable -> L32
        monitor-exit(k.class);
        return r10;
    L35:
        Object r1 = h(Looper.class, null, "sObserver");     // Catch: Throwable -> L28
        f1841c = r1;     // Catch: Throwable -> L28
        if (r1 == null) goto L16;
        f1842d = g(r1.getClass(), "messageDispatchStarting", new Class[0]);     // Catch: Throwable -> L28
        f1843e = g(f1841c.getClass(), "messageDispatched", new Class[]{Object.class, Message.class});     // Catch: Throwable -> L28
        f1844f = g(f1841c.getClass(), "dispatchingThrewException", new Class[]{Object.class, Message.class, Exception.class});     // Catch: Throwable -> L28
    L16:
        if (f1842d != null) goto L18;
    L21:
        f1841c = null;     // Catch: Throwable -> L28
    L22:
        f1846h = (a) Class.forName("com.bytedance.observer.ObserverWrapper").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L28
        if (f1841c == null) goto L25;
        System.out.println("LooperObserverMonitor.init: " + f1841c);     // Catch: Throwable -> L28
        f1846h.setup(f1841c);     // Catch: Throwable -> L28
    L25:
        g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")}).invoke(null, new Object[]{f1846h});     // Catch: Throwable -> L28
        f1839a = true;     // Catch: Throwable -> L28
        boolean r11 = f1839a;     // Catch: Throwable -> L28
        monitor-exit(k.class);
        return r11;
    L18:
        if (f1843e == null) goto L21;
        if (f1844f != null) goto L22;
    L28:
        f1841c = null;     // Catch: Throwable -> L32
        goto L29
    }

    public static void e(String r1) {
        a r0 = f1846h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatchStarting(r1);
    }

    public static void f(String r1, Message r2) {
        a r0 = f1846h;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.messageDispatched(r1, r2);
    }

    public static Method g(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private static <T> T h(Class r6, Object r7, String r8) {
        Field r9 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r8});     // Catch: Exception -> L4
        r9.setAccessible(true);     // Catch: Exception -> L4
        return (T) r9.get(r7);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void i(j r1) {
        a r0 = f1846h;
        if (r0 == null) goto L6;
        r0.removeMessageObserver(r1);
        return;
    }

    public static void j() {
        if (f1839a == true) goto L5;
        return;
    L5:
        if (f1846h == null) goto L16;
        Method r0 = g(Looper.class, "setObserver", new Class[]{Class.forName("android.os.Looper$Observer")});     // Catch: Throwable -> L11
        Object r1 = f1841c;     // Catch: Throwable -> L11
        if (r1 != null) goto L9;
        r0.invoke(null, new Object[]{null});     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        r0.invoke(null, new Object[]{r1});     // Catch: Throwable -> L11
    L17:
        return;
    }
}
