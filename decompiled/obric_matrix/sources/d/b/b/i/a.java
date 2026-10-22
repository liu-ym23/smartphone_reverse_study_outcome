package d.b.b.i;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import d.b.b.n.g.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks, d.b.b.n.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<c> f12950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f12951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f12955f;

    public a() {
        this.f12950a = new ArrayList();
        this.f12952c = null;
        Application r0 = d.b.b.o.a.b();
        r0.unregisterActivityLifecycleCallbacks(this);
        r0.registerActivityLifecycleCallbacks(this);
    }

    private Object[] d() {
        ArrayList<c> r0 = this.f12950a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f12950a.size() <= 0) goto L7;
        Object[] r2 = this.f12950a.toArray();     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r2 == null) goto L11;
        return r2;
    L11:
        return new Object[0];
    L7:
        r2 = null;
        goto L8
    }

    private void e(Activity r4) {
        Object[] r3 = d();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((c) r3[r1]).onBackground(r4);
        r1 = r1 + 1;
        goto L3
    }

    private void f(Activity r4) {
        Object[] r3 = d();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((c) r3[r1]).onFront(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // d.b.b.n.g.a
    public void a(c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ArrayList<c> r0 = this.f12950a;
        monitor-enter(r0);
        this.f12950a.remove(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.b.b.n.g.a
    public void b(c r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ArrayList<c> r0 = this.f12950a;
        monitor-enter(r0);
        this.f12950a.add(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // d.b.b.n.g.a
    public String c() {
        WeakReference<Activity> r0 = this.f12951b;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = r0.get();
        if (r1 == null) goto L11;
        String r2 = this.f12952c;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return r1.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // d.b.b.n.g.a
    public boolean isForeground() {
        return this.f12955f;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r3, Bundle r4) {
        Object[] r2 = d();
        int r5 = r2.length;
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        ((c) r2[r0]).c(r3);
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r4) {
        Object[] r3 = d();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((c) r3[r1]).onActivityPause(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r4) {
        this.f12951b = new WeakReference(r4);
        this.f12952c = null;
        Object[] r3 = d();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((c) r3[r1]).onActivityResume(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Object[] r0 = d();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        ((c) r0[r3]).onActivityStarted(r6);
        r3 = r3 + 1;
        goto L3
    L6:
        if (this.f12953d == false) goto L9;
        this.f12953d = false;
        return;
    L9:
        int r2 = this.f12954e + 1;
        this.f12954e = r2;
        if (r2 != 1) goto L14;
        this.f12955f = true;
        f(r6);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        if (r3.isChangingConfigurations() == false) goto L6;
        this.f12953d = true;
        return;
    L6:
        int r0 = this.f12954e - 1;
        this.f12954e = r0;
        if (r0 != 0) goto L10;
        this.f12955f = false;
        e(r3);
        return;
    }
}
