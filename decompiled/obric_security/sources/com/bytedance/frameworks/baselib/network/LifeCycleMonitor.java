package com.bytedance.frameworks.baselib.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static boolean mAppAlive;
    private static WeakHandler sHandler;
    private List<NetworkAppStateListener> mListeners;

    public static abstract class NetworkAppStateListener {
        private Runnable mBGRunnable;
        private int mEnterBackgroundDelayMills;

        public abstract void onEnterToBackground();

        public abstract void onEnterToForeground();

        public NetworkAppStateListener() {
            this.mEnterBackgroundDelayMills = ActivityLifecycleObserver.BACKGROUND_DELAY_SECOND;
            this.mBGRunnable = new AnonymousClass1(this);
        }

        public NetworkAppStateListener(int r2) {
            this.mEnterBackgroundDelayMills = ActivityLifecycleObserver.BACKGROUND_DELAY_SECOND;
            this.mBGRunnable = new AnonymousClass1(this);
            this.mEnterBackgroundDelayMills = r2;
        }

        public Runnable getBGRunnable() {
            return this.mBGRunnable;
        }

        public int getEnterBackgroundDelayMills() {
            return this.mEnterBackgroundDelayMills;
        }

        public void setEnterBackgroundDelayMills(int r1) {
            this.mEnterBackgroundDelayMills = r1;
        }
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

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public LifeCycleMonitor() {
        this.mListeners = new CopyOnWriteArrayList();
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

    public void addListener(NetworkAppStateListener r1) {
        this.mListeners.add(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r1) {
        if (mAppAlive == true) goto L8;
        mAppAlive = true;
        Iterator<NetworkAppStateListener> r0 = this.mListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().onEnterToForeground();
    L8:
        sHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        if (mAppAlive == false) goto L8;
        Iterator<NetworkAppStateListener> r4 = this.mListeners.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        NetworkAppStateListener r6 = r4.next();
        sHandler.postDelayed(r6.getBGRunnable(), r6.getEnterBackgroundDelayMills());
        goto L6
    L10:
        return;
    }
}
