package com.ss.android.ugc.aweme.framework.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class StaticServiceImplManager {
    private Map<String, Object> serviceImplCache;
    final Set<String> serviceImplNotExistSet;
    private Map<String, Set<Object>> serviceImplSetCache;
    final Set<String> serviceImplSetNotExistSet;

    private static class SingleInstanceHolder {
        private static final StaticServiceImplManager INSTANCE = null;

        private SingleInstanceHolder() {
        }

        static /* synthetic */ StaticServiceImplManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new StaticServiceImplManager();
        }
    }

    public StaticServiceImplManager() {
        this.serviceImplCache = new ConcurrentHashMap();
        this.serviceImplNotExistSet = Collections.synchronizedSet(new HashSet());
        this.serviceImplSetCache = new ConcurrentHashMap();
        this.serviceImplSetNotExistSet = Collections.synchronizedSet(new HashSet());
    }

    public static StaticServiceImplManager getInstance() {
        return SingleInstanceHolder.access$000();
    }

    public <T> T getStaticServiceImpl(Class<T> r4) {
        String r0 = r4.getName();
        T r1 = (T) this.serviceImplCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return (T) getStaticServiceImplReal(r4);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> r4) {
        String r0 = r4.getName();
        Set<T> r1 = (Set) this.serviceImplSetCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplSetNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return getStaticServiceImplSetReal(r4);
    }

    private <T> T getStaticServiceImplReal(Class<T> r1) {
        this.serviceImplNotExistSet.add(r1.getName());
        return null;
    }

    private void putStaticServiceImplCache(String r1, Object r2) {
        this.serviceImplCache.put(r1, r2);
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> r1) {
        this.serviceImplSetNotExistSet.add(r1.getName());
        return null;
    }

    private void putStaticServiceImplSetCache(String r1, Set<Object> r2) {
        this.serviceImplSetCache.put(r1, r2);
    }
}
