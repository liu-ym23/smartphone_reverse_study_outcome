package com.bytedance.common.push;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public class ActivityLifecycleObserver extends Observable implements Application.ActivityLifecycleCallbacks, WeakHandler.IHandler {
    public static final int BACKGROUND_DELAY_SECOND = 30000;
    public static final int MSG_ENTER_BACK = 1;
    private static final String TAG = "DerivativeManager";
    private static ActivityLifecycleObserver ins = null;
    private static boolean sIsBackGround = false;
    private static int sNumStarted;
    private WeakReference<Activity> mActivityRef;
    private boolean mAppActive;
    private AppStateListener mLifeCycleListener;
    private final List<Application.ActivityLifecycleCallbacks> mListener;
    private Runnable mRunnable;
    private WeakHandler sHandler;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    static {
    }

    static /* synthetic */ boolean access$000(ActivityLifecycleObserver r0) {
        return r0.mAppActive;
    }

    static /* synthetic */ boolean access$002(ActivityLifecycleObserver r0, boolean r1) {
        r0.mAppActive = r1;
        return r1;
    }

    static /* synthetic */ AppStateListener access$100(ActivityLifecycleObserver r0) {
        return r0.mLifeCycleListener;
    }

    public static synchronized ActivityLifecycleObserver getIns() {
        monitor-enter(ActivityLifecycleObserver.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (ins != null) goto L7;
        ins = new ActivityLifecycleObserver();     // Catch: Throwable -> L10
    L7:
        ActivityLifecycleObserver r1 = ins;     // Catch: Throwable -> L10
        monitor-exit(ActivityLifecycleObserver.class);
        return r1;
    }

    private ActivityLifecycleObserver() {
        this.mRunnable = new AnonymousClass1(this);
        this.sHandler = new WeakHandler(this);
        this.mListener = new ArrayList();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r4, Bundle r5) {
        Object[] r3 = collectActivityLifecycleCallbacks();
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((Application.ActivityLifecycleCallbacks) r3[r1]).onActivityCreated(r4, r5);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r6) {
        Object[] r0 = collectActivityLifecycleCallbacks();
        if (r0 == null) goto L7;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        ((Application.ActivityLifecycleCallbacks) r0[r3]).onActivityStarted(r6);
        r3 = r3 + 1;
    L7:
        this.sHandler.removeMessages(1);
        int r5 = sNumStarted;
        if (r5 != 0) goto L10;
        sIsBackGround = false;
    L10:
        sNumStarted = r5 + 1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r4) {
        this.mActivityRef = new WeakReference(r4);
        if (this.mAppActive == true) goto L7;
        this.mAppActive = true;
        Logger.d("ActivityLifecycleObserver", "onResume sAppAlive = true");
        AppStateListener r0 = this.mLifeCycleListener;
        if (r0 == null) goto L7;
        r0.onEnterToForeground();
    L7:
        this.sHandler.removeCallbacks(this.mRunnable);
        Object[] r3 = collectActivityLifecycleCallbacks();
        if (r3 == null) goto L12;
        int r1 = r3.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L14;
        ((Application.ActivityLifecycleCallbacks) r3[r2]).onActivityResumed(r4);
        r2 = r2 + 1;
        goto L10
    L14:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        if (this.mAppActive == false) goto L5;
        this.sHandler.postDelayed(this.mRunnable, 30000);
    L5:
        Object[] r4 = collectActivityLifecycleCallbacks();
        if (r4 == null) goto L10;
        int r0 = r4.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        ((Application.ActivityLifecycleCallbacks) r4[r1]).onActivityPaused(r5);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r5) {
        Object[] r0 = collectActivityLifecycleCallbacks();
        if (r0 == null) goto L7;
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        ((Application.ActivityLifecycleCallbacks) r0[r2]).onActivityStopped(r5);
        r2 = r2 + 1;
    L7:
        int r6 = sNumStarted - 1;
        sNumStarted = r6;
        if (r6 != 0) goto L12;
        sIsBackGround = true;
        this.sHandler.sendEmptyMessageDelayed(1, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r4, Bundle r5) {
        Object[] r3 = collectActivityLifecycleCallbacks();
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((Application.ActivityLifecycleCallbacks) r3[r1]).onActivitySaveInstanceState(r4, r5);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r4) {
        Object[] r3 = collectActivityLifecycleCallbacks();
        if (r3 == null) goto L7;
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        ((Application.ActivityLifecycleCallbacks) r3[r1]).onActivityDestroyed(r4);
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public boolean isBackGround() {
        return sIsBackGround;
    }

    public boolean isApplicationActive() {
        return this.mAppActive;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        if (r2.what == 1) goto L6;
        return;
    L6:
        if (sIsBackGround == false) goto L9;
        setChanged();
        notifyObservers(Boolean.valueOf(sIsBackGround));
        return;
    }

    public void addActivityLifeCycleListener(Application.ActivityLifecycleCallbacks r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        List<Application.ActivityLifecycleCallbacks> r0 = this.mListener;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mListener.contains(r3) == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L10:
        this.mListener.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void removeActivityLifeCycleListener(Application.ActivityLifecycleCallbacks r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        List<Application.ActivityLifecycleCallbacks> r0 = this.mListener;
        monitor-enter(r0);
        this.mListener.remove(r2);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private Object[] collectActivityLifecycleCallbacks() {
        List<Application.ActivityLifecycleCallbacks> r0 = this.mListener;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener.size() <= 0) goto L7;
        Object[] r2 = this.mListener.toArray();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public void setAppStateChangedListener(AppStateListener r1) {
        this.mLifeCycleListener = r1;
    }

    public Activity getTopActivity() {
        WeakReference<Activity> r0 = this.mActivityRef;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }
}
