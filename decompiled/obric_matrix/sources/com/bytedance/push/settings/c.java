package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.storage.i;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> f5483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> f5484b;

    c() {
        this.f5483a = new ConcurrentHashMap();
        this.f5484b = new ConcurrentHashMap();
    }

    private static <T extends ISettings> T a(Context r3, Class<T> r4) {
        f r0 = e.a();
        T r1 = (T) d.a(r4, r0);
        Throwable r2 = null;
        if (r1 == null) goto L26;
        r1.updateSettings(r3, null);
        return r1;
    L26:
        com.bytedance.push.settings.g.a r5 = (com.bytedance.push.settings.g.a) r4.getAnnotation(com.bytedance.push.settings.g.a.class);     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        if (r5 == null) goto L21;
        String r6 = r5.storageKey();     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16 ClassNotFoundException -> L18
        return (T) b(r3, r4, r0.a(r3, r5.supportMultiProcess(), r6));
    L21:
        if (r2 == null) goto L25;
        throw new IllegalStateException("get settings instance error，please check warning log", r2);
    L25:
        throw new IllegalStateException("get settings instance error，please check warning log");
    L18:
        e = move-exception;
        ClassNotFoundException r7 = e;
        r7.printStackTrace();
        r2 = r7;
    L14:
        e = move-exception;
        IllegalAccessException r8 = e;
        r8.printStackTrace();
        r2 = r8;
    L12:
        e = move-exception;
        InstantiationException r9 = e;
        r9.printStackTrace();
        r2 = r9;
    L16:
        e = move-exception;
        NoSuchMethodException r10 = e;
        r10.printStackTrace();
        r2 = r10;
    L10:
        e = move-exception;
        InvocationTargetException r11 = e;
        r11.printStackTrace();
        r2 = r11;
        goto L21
    }

    private static <T extends ISettings> ISettings b(Context r4, Class<T> r5, i r6) {
        ISettings r7 = (ISettings) Class.forName(r5.getName() + "$$SettingImpl", true, r5.getClassLoader()).getConstructor(new Class[]{i.class}).newInstance(new Object[]{r6});
        r7.updateSettings(r4, null);
        return r7;
    }

    public <T extends ISettings> T c(Context r4, Class<T> r5) {
        T r0 = (T) this.f5483a.get(r5);
        if (r0 != null) goto L28;
        Object r1 = null;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r2 = this.f5484b;
        monitor-enter(r2);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (this.f5484b.containsKey(r5) == false) goto L9;
        r1 = this.f5484b.get(r5);     // Catch: Throwable -> L24
    L9:
        if (r1 != null) goto L11;
        r1 = new Object();     // Catch: Throwable -> L24
        this.f5484b.put(r5, r1);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L24
        monitor-enter(r1);
        ISettings r3 = this.f5483a.get(r5);     // Catch: Throwable -> L21
        if (r3 != null) goto L18;
        ISettings r6 = a(r4, r5);     // Catch: Throwable -> L21
        if (r6 == null) goto L19;
        this.f5483a.put(r5, r6);     // Catch: Throwable -> L21
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return (T) r6;
    L18:
        r6 = r3;
    L21:
        th = move-exception;
        throw th;
    L28:
        if (this.f5484b.containsKey(r5) == false) goto L36;
        this.f5484b.remove(r5);
        return r0;
    L36:
        return r0;
    }
}
