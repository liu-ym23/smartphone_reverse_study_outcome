package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.storage.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f5481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f5482b;

    b(f r2) {
        this.f5481a = new ConcurrentHashMap();
        this.f5482b = r2;
    }

    private <T extends ILocalSettings> T a(Context r7, Class<T> r8) {
        f r6 = this.f5482b;
        T r0 = (T) d.a(r8, r6);
        if (r0 == null) goto L21;
        return r0;
    L21:
        Constructor<?> r1 = Class.forName(r8.getName() + "$$SettingImpl", true, r8.getClassLoader()).getConstructor(new Class[]{Context.class, i.class});     // Catch: InvocationTargetException -> L9 InstantiationException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        com.bytedance.push.settings.g.a r9 = (com.bytedance.push.settings.g.a) r8.getAnnotation(com.bytedance.push.settings.g.a.class);     // Catch: InvocationTargetException -> L9 InstantiationException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if (r9 == null) goto L20;
        return (T) r1.newInstance(new Object[]{r7, r6.a(r7, r9.supportMultiProcess(), r9.storageKey())});
    L20:
        throw new IllegalStateException("get settings instance error，please check warning log");
    L17:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L11:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    <T extends ILocalSettings> T b(Context r2, Class<T> r3) {
        T r0 = (T) this.f5481a.get(r3);
        if (r0 != null) goto L13;
        monitor-enter(this);
        r0 = (T) this.f5481a.get(r3);     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        ILocalSettings r4 = a(r2, r3);     // Catch: Throwable -> L10
        this.f5481a.put(r3, r4);     // Catch: Throwable -> L10
        r0 = (T) r4;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L13:
        return r0;
    }
}
