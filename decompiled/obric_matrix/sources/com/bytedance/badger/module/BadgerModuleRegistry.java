package com.bytedance.badger.module;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class BadgerModuleRegistry {
    public static final BadgerModuleRegistry INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap f2630a = null;

    static {
        INSTANCE = new BadgerModuleRegistry();
        f2630a = new ConcurrentHashMap();
    }

    private BadgerModuleRegistry() {
    }

    private final native int nativeGetProviderCount();

    private final native boolean nativeRegisterProvider(String r1, BadgerModuleBase r2);

    private final native boolean nativeUnregisterProvider(String r1);

    public static final void registerProvider(BadgerModuleBase r2) {
        if (r2 == null) goto L5;
        String r0 = r2.getName();
        f2630a.put(r0, r2);
        INSTANCE.nativeRegisterProvider(r0, r2);
        return;
    }

    public static final void unregisterProvider(String r1) {
        if (r1 == null) goto L5;
        BadgerModuleBase r2 = (BadgerModuleBase) f2630a.remove(r1);
        return;
    }
}
