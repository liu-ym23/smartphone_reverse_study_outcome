package com.bytedance.news.common.service.manager;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = null;

    public ServiceManager() {
    }

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
    }

    public static <T> T getService(Class<T> r3) {
        T r0 = (T) SERVICES.get(r3);
        if (r0 == null) goto L5;
    L28:
        return r0;
    L5:
        monitor-enter(ServiceManager.class);
        ConcurrentHashMap<Class, ServiceCreator<?>> r1 = SERVICE_CREATORS;     // Catch: Throwable -> L25
        ServiceCreator<?> r2 = r1.get(r3);     // Catch: Throwable -> L25
        if (r2 == null) goto L13;
        T r4 = (T) r2.create();
        r1.remove(r3);     // Catch: Throwable -> L25
        if (r4 == null) goto L13;
        putService(r3, r4);     // Catch: Throwable -> L25
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L25
        return r4;
    L13:
        T r5 = (T) ServiceFinder.findService(r3);
        if (r5 == null) goto L18;
        putService(r3, r5);     // Catch: Throwable -> L25
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L25
        return r5;
    L18:
        r0 = (T) tryGetByReflect(r3);
        if (r0 == null) goto L23;
        putService(r3, r0);     // Catch: Throwable -> L25
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L25
        return r0;
    L23:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }

    public static <T> void registerService(Class<T> r1, ServiceCreator<T> r2) {
        SERVICE_CREATORS.put(r1, r2);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        SERVICES.remove(r1, r2);
    }

    public static <T> void registerServiceLoadListener(Class<T> r1, ServiceLoadListener<T> r2) {
        SERVICE_LOAD_LISTENERS.put(r1, r2);
    }

    private static <T> void putService(Class<T> r2, T r3) {
        SERVICES.put(r2, r3);
        ConcurrentHashMap<Class, ServiceLoadListener> r0 = SERVICE_LOAD_LISTENERS;
        ServiceLoadListener r1 = r0.get(r2);
        if (r1 == null) goto L6;
        r1.onServiceLoaded(r3);
        r0.remove(r2);
        return;
    }

    private static <T> T tryGetByReflect(Class<T> r2) {
        Object r3 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r2.getName()})).newInstance();     // Catch: InstantiationException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        if ((r3 instanceof IServiceProxy) == false) goto L17;
        return (T) ((IServiceProxy) r3).newInstance();
    L17:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
