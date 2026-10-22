package com.bytedance.news.common.service.manager;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5262a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f5263b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, com.bytedance.news.common.service.manager.a<?>> f5264c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, c> f5265d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5266e;

    static class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RuntimeException f5267f;

        a(RuntimeException r1) {
            this.f5267f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw this.f5267f;
        }
    }

    static {
        f5263b = new ConcurrentHashMap();
        f5264c = new ConcurrentHashMap();
        f5265d = new ConcurrentHashMap();
        f5266e = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T] */
    public static <T> T a(Class<T> r6) {
        ConcurrentHashMap<Class, Object> r1 = f5263b;
        Object r2 = r1.get(r6);
        boolean r3 = true;
        if (r2 != null) goto L5;
    L10:
        boolean r5 = false;
        T r4 = r2;
    L11:
        if (r4 != 0) goto L57;
        monitor-enter(r6);
        T r7 = (T) r1.get(r6);
        if (r7 != null) goto L16;
        r3 = r5;
    L24:
        ConcurrentHashMap<Class, com.bytedance.news.common.service.manager.a<?>> r0 = f5264c;     // Catch: Throwable -> L54
        com.bytedance.news.common.service.manager.a<?> r8 = r0.get(r6);     // Catch: Throwable -> L54
        if (r8 == null) goto L58;
        T r9 = (T) r8.create();
        r0.remove(r6);     // Catch: Throwable -> L54
        if (r9 == null) goto L58;
        if (r3 == false) goto L30;
        e(r6);     // Catch: Throwable -> L54
    L30:
        b(r6, r9);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r9;
    L58:
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L54
    L45:
        r4 = (T) f(r6);
        if (r4 == 0) goto L52;
        if (r3 == false) goto L49;
        e(r6);     // Catch: Throwable -> L54
    L49:
        b(r6, r4);     // Catch: Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r4;
    L52:
        monitor-exit(r6);     // Catch: Throwable -> L54
        goto L57
    L34:
        if (f5262a == false) goto L36;
        T r10 = (T) b.b(r6);
    L37:
        if (r10 == null) goto L45;
        if (r3 == false) goto L40;
        e(r6);     // Catch: Exception -> L43 Throwable -> L54
    L40:
        b(r6, r10);     // Catch: Exception -> L43 Throwable -> L54
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r10;
    L36:
        r10 = (T) b.a(r6);
        goto L37
    L16:
        if (r7.getClass() == Object.class) goto L18;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return r7;
    L18:
        if (f5266e == true) goto L24;
        monitor-exit(r6);     // Catch: Throwable -> L54
        return null;
    L54:
        th = move-exception;
        throw th;
    L57:
        return (T) r4;
    L5:
        if (r2.getClass() != Object.class) goto L10;
        if (f5266e == true) goto L9;
        return null;
    L9:
        r5 = true;
        r4 = (T) null;
        goto L11
    }

    private static <T> void b(Class<T> r2, T r3) {
        f5263b.put(r2, r3);
        ConcurrentHashMap<Class, c> r0 = f5265d;
        c r1 = r0.get(r2);
        if (r1 == null) goto L6;
        r1.a(r3);
        r0.remove(r2);
        return;
    }

    public static <T> void c(Class<T> r2, com.bytedance.news.common.service.manager.a<T> r3) {
        f5264c.put(r2, r3);
        ConcurrentHashMap<Class, Object> r4 = f5263b;
        Object r0 = r4.get(r2);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getClass() != Object.class) goto L9;
        r4.remove(r2);
        return;
    }

    public static <T> void d(Class<T> r1, T r2) {
        f5263b.put(r1, r2);
    }

    private static void e(Class<?> r2) {
        new Thread(new a(new RuntimeException(r2.getName() + "已被提前注入空实现，请在ArticleApplication.registerReturnNullService()方法中将提前注入空实现的代码删除，有疑问联系 @zenghongjian.zhj"))).start();
    }

    private static <T> T f(Class<T> r2) {
        Object r3 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r2.getName()})).newInstance();     // Catch: Throwable -> L9
        if ((r3 instanceof IServiceProxy) == false) goto L7;
        return (T) ((IServiceProxy) r3).newInstance();
    L7:
        return null;
    L12:
        return null;
    }

    public static <T> void g(Class<T> r1, T r2) {
        f5263b.remove(r1, r2);
    }
}
