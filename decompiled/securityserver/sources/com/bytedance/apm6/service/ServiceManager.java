package com.bytedance.apm6.service;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = null;

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
    }

    public ServiceManager() {
    }

    public static <T> T getService(Class<T> r4) {
        T r0 = (T) SERVICES.get(r4);
        if (r0 == null) goto L5;
    L19:
        return r0;
    L5:
        monitor-enter(ServiceManager.class);
        ConcurrentHashMap<Class, ServiceCreator<?>> r2 = SERVICE_CREATORS;     // Catch: Throwable -> L13
        ServiceCreator<?> r3 = r2.get(r4);     // Catch: Throwable -> L13
        if (r3 == null) goto L15;
        r0 = (T) r3.create();
        r2.remove(r4);     // Catch: Throwable -> L13
        if (r0 == null) goto L15;
        putService(r4, r0);     // Catch: Throwable -> L13
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L13
        return r0;
    L15:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
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

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }

    public static <T> void registerServiceLoadListener(Class<T> r1, ServiceLoadListener<T> r2) {
        SERVICE_LOAD_LISTENERS.put(r1, r2);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        SERVICES.remove(r1, r2);
    }

    public static <T> void registerService(Class<T> r1, ServiceCreator<T> r2) {
        SERVICE_CREATORS.put(r1, r2);
    }
}
