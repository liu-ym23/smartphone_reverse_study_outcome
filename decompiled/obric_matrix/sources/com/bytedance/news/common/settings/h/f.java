package com.bytedance.news.common.settings.h;

import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> f5329a;

    public f() {
        this.f5329a = new ConcurrentHashMap();
    }

    private <T extends ILocalSettings> T a(Class<T> r5, com.bytedance.news.common.settings.b r6) {
        com.bytedance.news.common.settings.g.g r4 = r6.h();
        T r7 = (T) i.a(r5, r4);
        if (r7 == null) goto L21;
        return r7;
    L21:
        Constructor<?> r8 = Class.forName(r5.getName() + "$$Impl", true, r5.getClassLoader()).getConstructor(new Class[]{com.bytedance.news.common.settings.g.f.class});     // Catch: InvocationTargetException -> L9 InstantiationException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        com.bytedance.news.common.settings.api.annotation.a r9 = (com.bytedance.news.common.settings.api.annotation.a) r5.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);     // Catch: InvocationTargetException -> L9 InstantiationException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15 ClassNotFoundException -> L17
        if (r9 == null) goto L20;
        return (T) r8.newInstance(new Object[]{r4.a(r9.storageKey())});
    L20:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
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

    public <T extends ILocalSettings> T b(Class<T> r2, com.bytedance.news.common.settings.b r3, String r4) {
        T r0 = (T) this.f5329a.get(r2);
        if (r0 != null) goto L25;
        com.bytedance.news.common.settings.api.annotation.a r1 = (com.bytedance.news.common.settings.api.annotation.a) r2.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);
        if (r1 != null) goto L7;
        String r5 = "";
    L9:
        if (r4.equals(r5) == false) goto L24;
        monitor-enter(this);
        ILocalSettings r6 = this.f5329a.get(r2);     // Catch: Throwable -> L20
        if (r6 != null) goto L17;
        ILocalSettings r7 = a(r2, r3);     // Catch: Throwable -> L20
        if (r7 == null) goto L16;
        this.f5329a.put(r2, r7);     // Catch: Throwable -> L20
    L16:
        r0 = (T) r7;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        goto L25
    L17:
        r0 = r6;
    L20:
        th = move-exception;
        throw th;
    L24:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r5 + " - ");
    L7:
        r5 = r1.settingsId();
    L25:
        return (T) r0;
    }
}
