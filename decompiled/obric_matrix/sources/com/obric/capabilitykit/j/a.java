package com.obric.capabilitykit.j;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0016\u0010\u0019\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001bJ\u0016\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001bJ\u0010\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\b\u0010\u001f\u001a\u00020\u0017H\u0016J\u0016\u0010 \u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001bJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\"J\u0010\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\bJ\b\u0010%\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010&\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010-\u001a\u00020(H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/apphost/ActivityManager;", "Lcom/obric/capabilitykit/apphost/ActivityStackManager;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "activityStack", "Ljava/util/Stack;", "Landroid/app/Activity;", "appBackgroundListeners", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/apphost/ActivityStackManager$OnAppBackGroundListener;", "Lkotlin/collections/ArrayList;", "<set-?>", "currentActivity", "getCurrentActivity", "()Landroid/app/Activity;", "isBackground", "", "lastForegroundTime", "", "startedActivityStack", "addAppBackGroundListener", "", "listener", "backPressActivity", "clazz", "Ljava/lang/Class;", "containActivity", "endActivity", "activity", "finishAllActivities", "finishFirstTopActivity", "getActivityList", "", "getPreviousActivity", "curActivity", "isAppBackground", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "popActivity", "pushActivity", "removeAppBackGroundListener", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Stack<Activity> f8145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Stack<Activity> f8146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Activity f8148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayList<b> f8149e;

    static {
    }

    public a(Application r2) {
        o.f(r2, "application");
        r2.registerActivityLifecycleCallbacks(this);
        this.f8145a = new Stack();
        this.f8146b = new Stack();
        this.f8147c = true;
        this.f8149e = new ArrayList();
    }

    private final void b(Activity r1) {
        this.f8145a.remove(r1);
    }

    private final void c(Activity r1) {
        this.f8145a.add(r1);
    }

    public Activity a() {
        return this.f8148d;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
        o.f(r1, "activity");
        this.f8148d = r1;
        c(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r2) {
        o.f(r2, "activity");
        if (o.a(a(), r2) == false) goto L5;
        this.f8148d = null;
    L5:
        b(r2);
        if (this.f8145a.isEmpty() == false) goto L11;
        Iterator<T> r1 = this.f8149e.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        ((b) r1.next()).a();
        goto L9
    L13:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r1) {
        o.f(r1, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity r2) {
        monitor-enter(this);
        o.f(r2, "activity");     // Catch: Throwable -> L12
        this.f8148d = r2;     // Catch: Throwable -> L12
        if (this.f8147c == false) goto L10;
        System.currentTimeMillis();     // Catch: Throwable -> L12
        this.f8147c = false;     // Catch: Throwable -> L12
        Iterator<T> r3 = this.f8149e.iterator();     // Catch: Throwable -> L12
    L7:
        if (r3.hasNext() == false) goto L10;
        ((b) r3.next()).b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
        o.f(r1, "activity");
        o.f(r2, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r2) {
        o.f(r2, "activity");
        this.f8146b.add(r2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity r2) {
        monitor-enter(this);
        o.f(r2, "activity");     // Catch: Throwable -> L14
        this.f8146b.remove(r2);     // Catch: Throwable -> L14
        if (this.f8147c == false) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (this.f8146b.isEmpty() == false) goto L12;
        this.f8147c = true;     // Catch: Throwable -> L14
        Iterator<T> r3 = this.f8149e.iterator();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L12;
        ((b) r3.next()).c();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
