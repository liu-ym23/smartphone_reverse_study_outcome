package com.bytedance.mpaas.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LinkedList<Activity> f5243a;

    /* JADX INFO: renamed from: com.bytedance.mpaas.activity.a$a, reason: collision with other inner class name */
    public static class C0166a implements Application.ActivityLifecycleCallbacks {
        public C0166a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            a.a().remove(r1);
            a.a().add(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
            a.a().remove(r1);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r1) {
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

    static {
        f5243a = new LinkedList();
    }

    static /* synthetic */ LinkedList a() {
        return f5243a;
    }

    public static void b(Application r1) {
        c(r1, new C0166a());
    }

    public static void c(Application r0, C0166a r1) {
        r0.registerActivityLifecycleCallbacks(r1);
    }
}
