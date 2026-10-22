package com.obric.matrix.platform;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Intent f9485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9486b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f9487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f9488d;

    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(Activity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r1, Bundle r2) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityCreated is invoked");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r1) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityDestroyed is invoked");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityPaused is invoked");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r2) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityResumed is invoked");
            b.i(r2.getIntent());
            b.b(a(r2), b.a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivitySaveInstanceState is invoked");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r1) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityStarted is invoked");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r1) {
            com.obric.matrix.server.t.b.b.a("PVR", "onActivityStopped is invoked");
        }
    }

    static {
        f9486b = new AtomicBoolean(false);
        f9487c = new AtomicBoolean(false);
        f9488d = null;
    }

    static /* synthetic */ String a() {
        return f9488d;
    }

    static /* synthetic */ void b(Context r0, String r1) {
        k(r0, r1);
    }

    public static void c(Intent r4) {
        if (r4 != null) goto L6;
        com.obric.matrix.server.t.b.b.a("PVR", "checkForChallengeInvites is invoked, intent is null");
        return;
    L6:
        com.obric.matrix.server.t.b.b.a("PVR", "checkForChallengeInvites intent has key CHALLENGE_ID_KEY = " + r4.hasExtra("pvr_challenge_id"));
        r4.hasExtra("pvr_challenge_id");
    }

    public static void d(Intent r4) {
        if (r4 != null) goto L6;
        com.obric.matrix.server.t.b.b.a("PVR", "checkForRoomInvites is invoked, intent is null");
        return;
    L6:
        com.obric.matrix.server.t.b.b.a("PVR", "checkForRoomInvites intent has key ROOM_ID_KEY = " + r4.hasExtra("pvr_room_id"));
        r4.hasExtra("pvr_room_id");
    }

    private static Intent e() {
        return f9485a;
    }

    private static boolean f(Intent r2) {
        if (r2.hasExtra("intent_cmd") == false) goto L5;
    L11:
        com.obric.matrix.server.t.b.b.a("PVR", "hasPvrKey is true");
        return true;
    L5:
        if (r2.hasExtra("pvr_room_id") == true) goto L11;
        if (r2.hasExtra("pvr_challenge_id") == true) goto L11;
        com.obric.matrix.server.t.b.b.a("PVR", "hasPvrKey is false");
        return false;
    }

    private static boolean g(Intent r11) {
        boolean r0 = false;
        if (r11 != null) goto L8;
        String r12 = "isNewIntent() called with: newIntent is null, return false";
    L5:
        com.obric.matrix.server.t.b.b.a("PVR", r12);
        return r0;
    L8:
        if (f(r11) == true) goto L10;
        r12 = "isNewIntent() called with: hasPvrKey is false, return false";
        goto L5
    L10:
        Intent r2 = e();
        if (r2 != null) goto L14;
        com.obric.matrix.server.t.b.b.a("PVR", "isNewIntent() called with: oldIntent is null, return true");
        return true;
    L14:
        long r7 = r2.getLongExtra("pvr_set_last_intent_time", 0);
        long r4 = r11.getLongExtra("pvr_set_last_intent_time", 0);
        com.obric.matrix.server.t.b.b.a("PVR", "isNewIntent() called with: oldIntent hashCode = " + r2.hashCode() + ", setLatestIntentTime = " + r7 + ", newIntent hashCode = " + r11.hashCode() + ", setLatestIntentTime = " + r4);
        if (r2.hashCode() != r11.hashCode()) goto L17;
    L19:
        r12 = "isNewIntent() return " + r0;
        goto L5
    L17:
        if (r7 == r4) goto L19;
        r0 = true;
        goto L19
    }

    public static void h(Context r3, String r4) {
        com.obric.matrix.server.t.b.b.a("PVR", "nativeInitialize called");
        if (f9487c.getAndSet(true) == false) goto L5;
        return;
    L5:
        f9488d = r4;
        k(r3, r4);
        if ((r3 instanceof Activity) == false) goto L10;
        Activity r5 = (Activity) r3;
        i(r5.getIntent());
        Application r6 = r5.getApplication();
    L8:
        l(r6);
        return;
    L10:
        if ((r3 instanceof Application) == false) goto L12;
        r6 = (Application) r3;
        goto L8
    L12:
        com.obric.matrix.server.t.b.b.j("PVR", "PVRPlatform is in limited mode. Some features won't work. You likely want to init with an Activity.");
    }

    public static void i(Intent r2) {
        com.obric.matrix.server.t.b.b.a("PVR", "onCheckIntentChanged() called with: newIntent = " + r2);
        j(r2);
        if (g(r2) == false) goto L6;
        m(r2);
        d(r2);
        c(r2);
        return;
    }

    private static void j(Intent r6) {
        if (r6 != null) goto L7;
        String r7 = "printIntent called, intent is null !";
    L5:
        com.obric.matrix.server.t.b.b.a("PVR", r7);
        return;
    L7:
        com.obric.matrix.server.t.b.b.a("PVR", "printIntent called, intent hashCode = " + r6.hashCode());
        Bundle r8 = r6.getExtras();
        if (r8 != null) goto L10;
        r7 = "printIntent called, getExtras is null";
        goto L5
    L10:
        StringBuilder r1 = new StringBuilder();
        Iterator<String> r2 = r8.keySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        String r3 = r2.next();
        r1.append("\"" + r3 + "\":\"" + r8.get(r3) + "\", ");
        goto L12
    L14:
        r7 = "printIntent called, getExtras = " + r1.toString();
        goto L5
    }

    private static void k(Context r1, String r2) {
        if (f9486b.compareAndSet(false, true) == false) goto L6;
        com.obric.matrix.server.t.b.b.a("PVR", "PVRPlatformBroadcastReceiver is registered");
        return;
    }

    private static void l(Application r1) {
        r1.registerActivityLifecycleCallbacks(new a());
        com.obric.matrix.server.t.b.b.a("PVR", "ActivityLifecycleCallbacks is registered");
    }

    private static void m(Intent r5) {
        if (r5 != null) goto L6;
        com.obric.matrix.server.t.b.b.a("PVR", "setLatestIntent is invoked, intent is null");
        return;
    L6:
        long r1 = System.currentTimeMillis();
        com.obric.matrix.server.t.b.b.a("PVR", "setLatestIntent is invoked, intent hashCode = " + r5.hashCode() + ",time = " + r1);
        r5.putExtra("pvr_set_last_intent_time", r1);
        f9485a = r5;
    }
}
