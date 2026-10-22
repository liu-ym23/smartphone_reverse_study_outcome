package com.bytedance.apm6.foundation;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifeManager implements Application.ActivityLifecycleCallbacks, ActivityLifecycleService {
    private boolean changingConfigActivity;
    private int frontActivityCount;
    private volatile boolean isFront;
    private final ArrayList<IActivityLifecycleObserver> observers;
    private String topActivityClassName;
    private WeakReference<Activity> topActivityRef;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    public ActivityLifeManager() {
        this.observers = new ArrayList();
        this.topActivityClassName = null;
        Application r0 = ApmContext.getContext();
        r0.unregisterActivityLifecycleCallbacks(this);
        r0.registerActivityLifecycleCallbacks(this);
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public boolean isForeground() {
        return this.isFront;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void register(IActivityLifecycleObserver r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
        this.observers.add(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public void unregister(IActivityLifecycleObserver r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
        this.observers.remove(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.apm6.service.lifecycle.ActivityLifecycleService
    public String getTopActivityClassName() {
        WeakReference<Activity> r0 = this.topActivityRef;
        if (r0 != null) goto L5;
        return "";
    L5:
        Activity r1 = r0.get();
        if (r1 == null) goto L11;
        String r2 = this.topActivityClassName;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return r1.getClass().getCanonicalName();
    L11:
        return "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r4) {
        this.topActivityRef = new WeakReference(r4);
        this.topActivityClassName = null;
        Object[] r3 = collectObservers();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((IActivityLifecycleObserver) r3[r1]).onActivityResume(r4);
        r1 = r1 + 1;
        goto L3
    }

    private void notifyFront(Activity r4) {
        Object[] r3 = collectObservers();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((IActivityLifecycleObserver) r3[r1]).onFront(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r4) {
        Object[] r3 = collectObservers();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((IActivityLifecycleObserver) r3[r1]).onActivityPause(r4);
        r1 = r1 + 1;
        goto L3
    }

    private void notifyBackground(Activity r4) {
        Object[] r3 = collectObservers();
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((IActivityLifecycleObserver) r3[r1]).onBackground(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r3, Bundle r4) {
        Object[] r2 = collectObservers();
        int r5 = r2.length;
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        ((IActivityLifecycleObserver) r2[r0]).onActivityCreated(r3);
        r0 = r0 + 1;
        goto L3
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Object[] r0 = collectObservers();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        ((IActivityLifecycleObserver) r0[r3]).onActivityStarted(r6);
        r3 = r3 + 1;
        goto L3
    L6:
        if (this.changingConfigActivity == false) goto L9;
        this.changingConfigActivity = false;
        return;
    L9:
        int r2 = this.frontActivityCount + 1;
        this.frontActivityCount = r2;
        if (r2 != 1) goto L14;
        this.isFront = true;
        notifyFront(r6);
        return;
    }

    private Object[] collectObservers() {
        ArrayList<IActivityLifecycleObserver> r0 = this.observers;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.observers.size() <= 0) goto L7;
        Object[] r2 = this.observers.toArray();     // Catch: Throwable -> L12
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r3) {
        if (r3.isChangingConfigurations() == false) goto L6;
        this.changingConfigActivity = true;
        return;
    L6:
        int r0 = this.frontActivityCount - 1;
        this.frontActivityCount = r0;
        if (r0 != 0) goto L10;
        this.isFront = false;
        notifyBackground(r3);
        return;
    }
}
