package com.bytedance.news.common.settings.h;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.services.apm.api.IEnsure;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> f5332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> f5333b;

    public h() {
        this.f5332a = new ConcurrentHashMap();
        this.f5333b = new ConcurrentHashMap();
    }

    private static <T extends ISettings> T a(Class<T> r6, com.bytedance.news.common.settings.b r7) {
        com.bytedance.news.common.settings.g.g r1 = r7.h();
        T r2 = (T) i.a(r6, r1);
        if (r2 == null) goto L48;
        r2.updateSettings(null);
        return r2;
    L48:
        com.bytedance.news.common.settings.api.annotation.a r3 = (com.bytedance.news.common.settings.api.annotation.a) r6.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
        if (r3 == null) goto L47;
        boolean r4 = com.bytedance.news.common.settings.g.i.a.b(r7.a()).c();     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
        if (r7.l() == false) goto L13;
        String r5 = "all_app_settings_sp";
        if (r4 == true) goto L17;
        com.bytedance.news.common.settings.g.i.a.b(r7.a()).e(true);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
    L17:
        if (r7.m() == false) goto L20;
        com.bytedance.news.common.settings.g.f r8 = r1.a(r5);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
    L49:
        return (T) b(r6, r8);
    L20:
        r8 = r1.a(r5);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
        T r9 = (T) com.bytedance.news.common.settings.c.a(r6.getName(), r8);
        if (r9 == null) goto L49;
        r9.updateSettings(null);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
        return r9;
    L13:
        r5 = r3.storageKey();     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
        if (r4 == false) goto L17;
        com.bytedance.news.common.settings.g.i.a.b(r7.a()).e(false);     // Catch: InvocationTargetException -> L25 InstantiationException -> L30 IllegalAccessException -> L34 NoSuchMethodException -> L38 ClassNotFoundException -> L42
    L47:
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    L42:
        e = move-exception;
        e.printStackTrace();
        IEnsure r10 = (IEnsure) com.bytedance.news.common.service.manager.d.a(IEnsure.class);
        if (r10 == null) goto L47;
        String r0 = "获取settings实例失败，ClassNotFoundException";
        Throwable r11 = e;
        IEnsure r12 = r10;
    L29:
        r12.ensureNotReachHere(r11, r0);
    L34:
        e = move-exception;
        e.printStackTrace();
        IEnsure r13 = (IEnsure) com.bytedance.news.common.service.manager.d.a(IEnsure.class);
        if (r13 == null) goto L47;
        r0 = "获取settings实例失败，IllegalAccessException";
        r11 = e;
        r12 = r13;
    L30:
        e = move-exception;
        e.printStackTrace();
        IEnsure r14 = (IEnsure) com.bytedance.news.common.service.manager.d.a(IEnsure.class);
        if (r14 == null) goto L47;
        r0 = "获取settings实例失败，InstantiationException";
        r11 = e;
        r12 = r14;
    L38:
        e = move-exception;
        e.printStackTrace();
        IEnsure r15 = (IEnsure) com.bytedance.news.common.service.manager.d.a(IEnsure.class);
        if (r15 == null) goto L47;
        r0 = "获取settings实例失败，NoSuchMethodException";
        r11 = e;
        r12 = r15;
    L25:
        e = move-exception;
        e.printStackTrace();
        IEnsure r16 = (IEnsure) com.bytedance.news.common.service.manager.d.a(IEnsure.class);
        if (r16 == null) goto L47;
        r0 = "获取settings实例失败，InvocationTargetException";
        r11 = e;
        r12 = r16;
        goto L29
    }

    private static <T extends ISettings> ISettings b(Class<T> r4, com.bytedance.news.common.settings.g.f r5) {
        ISettings r6 = (ISettings) Class.forName(r4.getName() + "$$Impl", true, r4.getClassLoader()).getConstructor(new Class[]{com.bytedance.news.common.settings.g.f.class}).newInstance(new Object[]{r5});
        r6.updateSettings(null);
        return r6;
    }

    public <T extends ISettings> T c(Class<T> r3, com.bytedance.news.common.settings.b r4, String r5) {
        T r0 = (T) this.f5332a.get(r3);
        if (r0 != null) goto L36;
        com.bytedance.news.common.settings.api.annotation.a r1 = (com.bytedance.news.common.settings.api.annotation.a) r3.getAnnotation(com.bytedance.news.common.settings.api.annotation.a.class);
        if (r1 != null) goto L7;
        String r2 = "";
    L9:
        if (r5.equals(r2) == false) goto L34;
        Object r6 = null;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r7 = this.f5333b;
        monitor-enter(r7);
    L30:
        th = move-exception;
        throw th;
    L13:
        if (this.f5333b.containsKey(r3) == false) goto L15;
        r6 = this.f5333b.get(r3);     // Catch: Throwable -> L30
    L15:
        if (r6 != null) goto L17;
        r6 = new Object();     // Catch: Throwable -> L30
        this.f5333b.put(r3, r6);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r7);     // Catch: Throwable -> L30
        monitor-enter(r6);
        r0 = (T) this.f5332a.get(r3);     // Catch: Throwable -> L27
        if (r0 != null) goto L25;
        ISettings r8 = a(r3, r4);     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        this.f5332a.put(r3, r8);     // Catch: Throwable -> L27
    L24:
        r0 = (T) r8;
    L25:
        monitor-exit(r6);     // Catch: Throwable -> L27
    L38:
        return r0;
    L27:
        th = move-exception;
        throw th;
    L34:
        throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + r2 + " - ");
    L7:
        r2 = r1.settingsId();
        goto L9
    L36:
        if (this.f5333b.containsKey(r3) == false) goto L38;
        this.f5333b.remove(r3);
        goto L38
    }

    public synchronized void d(@NonNull com.bytedance.news.common.settings.g.c r5, @NonNull com.bytedance.news.common.settings.b r6) {
        monitor-enter(this);
        Iterator<ISettings> r0 = this.f5332a.values().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        r0.next().updateSettings(r5);     // Catch: Throwable -> L10
        goto L5
    L7:
        Context r1 = a.b();     // Catch: Throwable -> L10
        g.c(r1).i(r5.b(), r6.c());     // Catch: Throwable -> L10
        e.c(r1).e(r5, r6.c());     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
