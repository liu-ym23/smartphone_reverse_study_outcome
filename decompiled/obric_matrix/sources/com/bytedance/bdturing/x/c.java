package com.bytedance.bdturing.x;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.b0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Activity> f3258a;

    public static final class a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f3259a;

        a(c r1) {
            this.f3259a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            this.f3259a.a(new WeakReference(r2));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
        }
    }

    public c(Application r8) {
        o.g(r8, "application");
        Class<?> r0 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L19
        Activity r3 = null;
        Object r1 = r0.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L19
        Field r2 = r0.getDeclaredField("mActivities");     // Catch: Throwable -> L19
        o.b(r2, "activitiesFiled");     // Catch: Throwable -> L19
        r2.setAccessible(true);     // Catch: Throwable -> L19
        Object r4 = r2.get(r1);     // Catch: Throwable -> L19
        if (r4 == null) goto L18;
        Collection r5 = ((Map) r4).values();     // Catch: Throwable -> L19
        o.b(r5, "activityMap.values()");     // Catch: Throwable -> L19
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L19
    L7:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();     // Catch: Throwable -> L19
        Class<?> r9 = r7.getClass();     // Catch: Throwable -> L19
        Field r10 = r9.getDeclaredField("paused");     // Catch: Throwable -> L19
        o.b(r10, "activityRecordClz.getDeclaredField(\"paused\")");     // Catch: Throwable -> L19
        r10.setAccessible(true);     // Catch: Throwable -> L19
        if (r10.getBoolean(r7) == true) goto L7;
        Field r11 = r9.getDeclaredField("activity");     // Catch: Throwable -> L19
        o.b(r11, "activityRecordClz.getDeclaredField(\"activity\")");     // Catch: Throwable -> L19
        r11.setAccessible(true);     // Catch: Throwable -> L19
        Object r12 = r11.get(r7);     // Catch: Throwable -> L19
        if (r12 == null) goto L14;
        r3 = (Activity) r12;     // Catch: Throwable -> L19
        goto L7
    L14:
        throw new b0("null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L19
    L15:
        if (r3 == null) goto L21;
        this.f3258a = new WeakReference(r3);     // Catch: Throwable -> L19
    L21:
        r8.registerActivityLifecycleCallbacks(new a(this));
        return;
    L18:
        throw new b0("null cannot be cast to non-null type java.util.Map<kotlin.Any, kotlin.Any>");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        goto L21
    }

    public final void a(WeakReference<Activity> r2) {
        o.g(r2, "<set-?>");
        this.f3258a = r2;
    }
}
