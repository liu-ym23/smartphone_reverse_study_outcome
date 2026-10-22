package com.obric.server.security.guard;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.obric.security.guard.IObricSettingsEventObserver;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityGuardManager implements IObricSecurityGuard {
    private static final Object OBSERVER_LOCK = null;
    private static final Object S_LOCK_GUARD = null;
    private static final String TAG = "ObricSecurityGuardManager";
    private static volatile ObricSecurityGuardManager instance;
    private MinPermissionManager mMinPermissionManager;
    private RemoteCallbackList<IObricSettingsEventObserver> mObservers;
    private SensitiveViewDetect mSensitiveViewDetect;

    /* JADX INFO: renamed from: -$$Nest$fgetmObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m97$$Nest$fgetmObservers(ObricSecurityGuardManager r0) {
        return r0.mObservers;
    }

    static {
        S_LOCK_GUARD = new Object();
        OBSERVER_LOCK = new Object();
    }

    private ObricSecurityGuardManager() {
        this.mObservers = new RemoteCallbackList();
        this.mMinPermissionManager = new MinPermissionManager();
        this.mSensitiveViewDetect = new SensitiveViewDetect();
    }

    public static ObricSecurityGuardManager getInstance() {
        if (instance != null) goto L15;
        Object r0 = S_LOCK_GUARD;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new ObricSecurityGuardManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    @Override // com.obric.server.security.guard.IObricSecurityGuard
    public Bundle getCurrentAppGrantPermissionInfo(String packageName) {
        if (TextUtils.isEmpty(packageName) == false) goto L7;
        Log.e(TAG, "getCurrentAppGrantPermissionInfo, packageName is empty");
        return new Bundle();
    L7:
        return this.mMinPermissionManager.getCurrentAppGrantPermissionInfo(packageName);
    }

    @Override // com.obric.server.security.guard.IObricSecurityGuard
    public Bundle getAppGrantPermissionInfo(String packageName, String[] permission) {
        if (TextUtils.isEmpty(packageName) == true) goto L10;
        if (permission == null) goto L10;
        if (permission.length == 0) goto L10;
        return this.mMinPermissionManager.getPerPolicy(packageName, permission);
    L10:
        Log.e(TAG, "getAppGrantPermissionInfo, packageName or permission is empty");
        return new Bundle();
    }

    @Override // com.obric.server.security.guard.IObricSecurityGuard
    public void updateMinPerPolicy(String packageName, String perPolicy) {
        if (TextUtils.isEmpty(packageName) == false) goto L5;
    L9:
        Log.e(TAG, "updateMinPerPolicy, packageName or perPolicy is empty");
        return;
    L5:
        if (TextUtils.isEmpty(perPolicy) == true) goto L9;
        this.mMinPermissionManager.updateMinPerPolicy(packageName, perPolicy);
    }

    public int getActivityRiskType(String packageName, String activityName, Bundle extra) {
        return this.mSensitiveViewDetect.getActivityRiskType(packageName, activityName, extra);
    }

    public void updatePolicyFile(String fileName, String perPolicy) {
        if (TextUtils.isEmpty(fileName) == false) goto L5;
    L11:
        Log.e(TAG, "updatePolicyFile, fileName or perPolicy is empty");
        return;
    L5:
        if (TextUtils.isEmpty(perPolicy) == true) goto L11;
        GuardDataStorage.writePolicy(fileName, perPolicy);
        if (fileName.equals("sen_data.json") == false) goto L13;
        this.mSensitiveViewDetect.init(perPolicy);
        return;
    }

    public String getSecurityPolicy(String fileName) {
        if (TextUtils.isEmpty(fileName) == false) goto L7;
        Log.e(TAG, "getSecurityPolicy, fileName is empty");
        return null;
    L7:
        return GuardDataStorage.getPolicy(fileName);
    }

    public void registerSettingsEventObserver(Context context, final IObricSettingsEventObserver observer) {
        if (observer != null) goto L5;
        Log.e(TAG, "registerSettingsEventObserver, observer is null!");
        return;
    L5:
        Object r0 = OBSERVER_LOCK;
        monitor-enter(r0);
        final String packageName = ObricSecurityGuardUtils.getCallingPackageName(context);     // Catch: Throwable -> L14
        Log.i(TAG, "registerSettingsEventObserver, packageName:" + packageName);     // Catch: Throwable -> L14
        this.mObservers.register(observer);     // Catch: Throwable -> L14
        observer.asBinder().linkToDeath(new AnonymousClass1(this, observer, packageName), 0);     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "linkToDeath error! name:" + packageName + "  error:" + e.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void unregisterSettingsEventObserver(Context context, IObricSettingsEventObserver observer) {
        Object r0 = OBSERVER_LOCK;
        monitor-enter(r0);
        String packageName = ObricSecurityGuardUtils.getCallingPackageName(context);     // Catch: Throwable -> L9
        Log.i(TAG, "unregisterSettingsEventObserver, packageName:" + packageName);     // Catch: Throwable -> L9
        if (observer == null) goto L7;
        this.mObservers.unregister(observer);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void bdSettingsEventStart(Context context, int eventType, Bundle extra) {
        Object r0 = OBSERVER_LOCK;
        monitor-enter(r0);
        String packageName = ObricSecurityGuardUtils.getCallingPackageName(context);     // Catch: Throwable -> L17
        Log.i(TAG, "bdSettingsEventStart, eventType:" + eventType + " packageName:" + packageName);     // Catch: Throwable -> L17
        int count = this.mObservers.beginBroadcast();     // Catch: Throwable -> L17
        int i = 0;
    L6:
        if (i >= count) goto L14;
        IObricSettingsEventObserver observer = this.mObservers.getBroadcastItem(i);     // Catch: RemoteException -> L11 Throwable -> L17
        if (observer == null) goto L13;
        observer.onEventStart(eventType, packageName, extra);     // Catch: RemoteException -> L11 Throwable -> L17
    L13:
        i = i + 1;     // Catch: Throwable -> L17
    L11:
        e = move-exception;
        Log.e(TAG, "observer onEvent failed! error:" + e.getMessage());     // Catch: Throwable -> L17
        goto L13
    L14:
        this.mObservers.finishBroadcast();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void bdSettingsEventEnd(Context context, int eventType, Bundle extra) {
        Object r0 = OBSERVER_LOCK;
        monitor-enter(r0);
        String packageName = ObricSecurityGuardUtils.getCallingPackageName(context);     // Catch: Throwable -> L17
        Log.i(TAG, "bdSettingsEventEnd, eventType:" + eventType + " packageName:" + packageName);     // Catch: Throwable -> L17
        int count = this.mObservers.beginBroadcast();     // Catch: Throwable -> L17
        int i = 0;
    L6:
        if (i >= count) goto L14;
        IObricSettingsEventObserver observer = this.mObservers.getBroadcastItem(i);     // Catch: RemoteException -> L11 Throwable -> L17
        if (observer == null) goto L13;
        observer.onEventEnd(eventType, packageName, extra);     // Catch: RemoteException -> L11 Throwable -> L17
    L13:
        i = i + 1;     // Catch: Throwable -> L17
    L11:
        e = move-exception;
        Log.e(TAG, "observer onEvent failed! error:" + e.getMessage());     // Catch: Throwable -> L17
        goto L13
    L14:
        this.mObservers.finishBroadcast();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
