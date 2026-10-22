package com.bytedance.applog.collector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.j;
import com.bytedance.applog.o.e;
import com.bytedance.applog.w.h;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f2213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static h f2214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static h f2215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f2216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f2217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f2218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashSet<Integer> f2219g = null;

    static {
        new HashMap();
        f2219g = new HashSet(8);
    }

    public a(j r1) {
    }

    public static h a() {
        h r0 = f2214b;
        h r1 = f2215c;
        if (r1 != null) goto L9;
        if (r0 != null) goto L10;
        return null;
    L10:
        return r0;
    L9:
        return r1;
    }

    public static void b(Activity r3) {
        if (f2215c == null) goto L5;
        c(f2218f);
    L5:
        h r0 = f2214b;
        if (r0 == null) goto L11;
        f2217e = r0.x;
        long r1 = System.currentTimeMillis();
        f2216d = r1;
        d(r0, r1);
        f2214b = null;
        if (r3 == null) goto L12;
        r3.isChild();
        return;
    L12:
        return;
    }

    public static void c(Object r0) {
    }

    public static h d(h r3, long r4) {
        h r0 = (h) r3.a();
        r0.t(r4);
        long r5 = r4 - r3.f2444g;
        if (r5 > 0) goto L5;
        r5 = 1000;
    L5:
        r0.v = r5;
        e.F(r0);
        return r0;
    }

    public static h e(String r2, String r3, long r4, String r6) {
        h r0 = new h();
        if (TextUtils.isEmpty(r3) == true) goto L5;
        r2 = r2 + ":" + r3;
    L5:
        r0.x = r2;
        r0.t(r4);
        r0.v = -1;
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        r0.w = r6;
        e.F(r0);
        return r0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        f2219g.add(Integer.valueOf(r1.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
        f2219g.remove(Integer.valueOf(r1.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
        b(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r5) {
        long r0 = System.currentTimeMillis();
        h r4 = e(r5.getClass().getName(), "", r0, f2217e);
        f2214b = r4;
        r4.y = !f2219g.remove(Integer.valueOf(r5.hashCode())) ? 1 : 0;
        if (r5.isChild() == true) goto L6;
        r5.getWindow().getDecorView().hashCode();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
        f2213a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
        if (f2217e == null) goto L8;
        int r0 = f2213a - 1;
        f2213a = r0;
        if (r0 > 0) goto L9;
        f2217e = null;
        f2216d = 0;
        return;
    L9:
        return;
    }
}
