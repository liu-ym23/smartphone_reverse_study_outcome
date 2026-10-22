package com.bytedance.bdinstall.service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceManager {
    private static HashMap<Class, HashMap<String, ?>> gServices;
    private static final ConcurrentHashMap<Class, ServiceCreator> sServiceCreators = null;
    private static final ConcurrentHashMap<Class, Object> sServices = null;

    public ServiceManager() {
    }

    static {
        sServices = new ConcurrentHashMap();
        sServiceCreators = new ConcurrentHashMap();
    }

    public static <T> T getService(Class<T> r4) {
        ConcurrentHashMap<Class, Object> r0 = sServices;
        Object r1 = (T) r0.get(r4);
        if (r1 != null) goto L18;
        monitor-enter(r0);
        r1 = r0.get(r4);     // Catch: Throwable -> L15
        if (r1 != null) goto L13;
        ConcurrentHashMap<Class, ServiceCreator> r2 = sServiceCreators;     // Catch: Throwable -> L15
        ServiceCreator r3 = r2.get(r4);     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r1 = (T) r3.create(r4);
        if (r1 == null) goto L12;
        r0.put(r4, r1);     // Catch: Throwable -> L15
    L12:
        r2.remove(r4);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return (T) r1;
    }

    public static <T> T getService(Class<T> r3, String r4) {
        if (r4 == null) goto L28;
        if ("".equals(r4) == true) goto L28;
        monitor-enter(ServiceManager.class);
        HashMap<Class, HashMap<String, ?>> r1 = gServices;     // Catch: Throwable -> L24
        if (r1 != null) goto L11;
    L22:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L24
        return null;
    L11:
        if (r1.containsKey(r3) == false) goto L22;
        HashMap<String, ?> r5 = gServices.get(r3);     // Catch: Throwable -> L24
        if (r5 != null) goto L15;
    L20:
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L24
        return null;
    L15:
        if (r5.size() == 0) goto L20;
        T r6 = (T) r5.get(r4);
        monitor-exit(ServiceManager.class);     // Catch: Throwable -> L24
        return r6;
    L24:
        th = move-exception;
        throw th;
    L28:
        return (T) getService(r3);
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        sServices.put(r1, r2);
    }

    public static <T> void registerService(Class<T> r1, ServiceCreator r2) {
        sServiceCreators.put(r1, r2);
    }

    public static synchronized <T> void registerService(Class<T> r3, T r4, String r5) {
        monitor-enter(ServiceManager.class);
        if (r5 != null) goto L23;
    L17:
        registerService(r3, r4);     // Catch: Throwable -> L20
        monitor-exit(ServiceManager.class);
        return;
    L23:
    L20:
        th = move-exception;
        throw th;
    L6:
        if ("".equals(r5) == true) goto L17;
        if (gServices != null) goto L11;
        gServices = new HashMap();     // Catch: Throwable -> L20
    L11:
        HashMap<String, ?> r1 = gServices.get(r3);     // Catch: Throwable -> L20
        if (r1 != null) goto L14;
        r1 = new HashMap();     // Catch: Throwable -> L20
        gServices.put(r3, r1);     // Catch: Throwable -> L20
    L14:
        r1.put(r5, r4);     // Catch: Throwable -> L20
        monitor-exit(ServiceManager.class);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        sServices.remove(r1, r2);
    }

    public static synchronized <T> void unregisterService(Class<T> r2, T r3, String r4) {
        monitor-enter(ServiceManager.class);
        HashMap<Class, HashMap<String, ?>> r1 = gServices;     // Catch: Throwable -> L15
        if (r1 == null) goto L13;
        if (r3 == null) goto L13;
        HashMap<String, ?> r5 = r1.get(r2);     // Catch: Throwable -> L15
        if (r5 == null) goto L11;
        r5.remove(r4);     // Catch: Throwable -> L15
    L11:
        monitor-exit(ServiceManager.class);
        return;
    L13:
        monitor-exit(ServiceManager.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
