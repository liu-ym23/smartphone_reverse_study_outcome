package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static boolean mAppAlive;
    private static WeakHandler sHandler;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
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

    static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        mAppAlive = r0;
        return r0;
    }

    static /* synthetic */ AppStateListener access$100(LifeCycleMonitor r0) {
        return r0.mListener;
    }

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public LifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        if (getActivity() == null) goto L6;
        mAppAlive = true;
        return;
    }

    private static Activity getActivity() {
        Class<?> r1 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r2 = r1.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r3 = r1.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r3.setAccessible(true);     // Catch: Throwable -> L14
        Map r4 = (Map) r3.get(r2);     // Catch: Throwable -> L14
        if (r4 != null) goto L6;
        return null;
    L6:
        Iterator r5 = r4.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();     // Catch: Throwable -> L14
        Class<?> r7 = r6.getClass();     // Catch: Throwable -> L14
        Field r8 = r7.getDeclaredField("paused");     // Catch: Throwable -> L14
        r8.setAccessible(true);     // Catch: Throwable -> L14
        if (r8.getBoolean(r6) == true) goto L8;
        Field r9 = r7.getDeclaredField("activity");     // Catch: Throwable -> L14
        r9.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r9.get(r6);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r1) {
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r2 = this.mListener;
        if (r2 == null) goto L7;
        r2.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, 30000);
        return;
    }

    public void setAppStateChangedListener(AppStateListener r1) {
        this.mListener = r1;
    }
}
