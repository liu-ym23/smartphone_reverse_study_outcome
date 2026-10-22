package com.obric.server.security.guard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.obric.security.guard.IObricSecurityGuardService;
import com.obric.security.guard.IObricSettingsEventObserver;
import com.obric.server.security.IObricSecurityPlugin;

/* JADX INFO: loaded from: classes.dex */
public class ObricSecurityGuardPlugin implements IObricSecurityPlugin {
    public static final IObricSecurityPlugin.Creator CREATOR = null;
    private static final String TAG = "ObricSecurityGuardPlugin";
    private final Context mContext;
    private ObricSecurityGuardManager mSecurityGuardManager;

    private class ObricSecurityGuardService extends IObricSecurityGuardService.Stub {
        private final Object lock;
        final /* synthetic */ ObricSecurityGuardPlugin this$0;

        /* synthetic */ ObricSecurityGuardService(ObricSecurityGuardPlugin r1, ObricSecurityGuardPluginIA r2) {
            this(r1);
        }

        private ObricSecurityGuardService(ObricSecurityGuardPlugin r1) {
            this.this$0 = r1;
            this.lock = new Object();
        }

        public Bundle getCurrentAppGrantPermissionInfo(String packageName) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L10;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L10:
            Bundle r1 = ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).getCurrentAppGrantPermissionInfo(packageName);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        }

        public Bundle getAppGrantPermissionInfo(String packageName, String[] permission) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L10;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L10:
            Bundle r1 = ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).getAppGrantPermissionInfo(packageName, permission);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        }

        public void updateMinPerPolicy(String packageName, String perPolicy) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).updateMinPerPolicy(packageName, perPolicy);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public int getActivityRiskType(String packageName, String activityName, Bundle extra) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L10;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return -2;
        L10:
            int r1 = ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).getActivityRiskType(packageName, activityName, extra);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        }

        public void updatePolicyFile(String fileName, String perPolicy) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).updatePolicyFile(fileName, perPolicy);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public String getSecurityPolicy(String fileName) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardUtils.isSystemOrPlatformApp(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0)) == true) goto L10;
            Log.e(ObricSecurityGuardPlugin.TAG, "Not system or platform app, forbidden access.");     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L10:
            String r1 = ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).getSecurityPolicy(fileName);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        }

        public void registerSettingsEventObserver(IObricSettingsEventObserver observer) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).registerSettingsEventObserver(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0), observer);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public void unregisterSettingsEventObserver(IObricSettingsEventObserver observer) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardPlugin.m100$$Nest$mcheckAccessPermission(this.this$0) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).unregisterSettingsEventObserver(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0), observer);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public void bdSettingsEventStart(int eventType, Bundle extra) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardUtils.isSystemOrPlatformApp(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0)) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Not system or platform app, forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).bdSettingsEventStart(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0), eventType, extra);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public void bdSettingsEventEnd(int eventType, Bundle extra) {
            Object r0 = this.lock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricSecurityGuardUtils.isSystemOrPlatformApp(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0)) == true) goto L9;
            Log.e(ObricSecurityGuardPlugin.TAG, "Not system or platform app, forbidden access.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L9:
            ObricSecurityGuardPlugin.m99$$Nest$fgetmSecurityGuardManager(this.this$0).bdSettingsEventEnd(ObricSecurityGuardPlugin.m98$$Nest$fgetmContext(this.this$0), eventType, extra);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m98$$Nest$fgetmContext(ObricSecurityGuardPlugin r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSecurityGuardManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ObricSecurityGuardManager m99$$Nest$fgetmSecurityGuardManager(ObricSecurityGuardPlugin r0) {
        return r0.mSecurityGuardManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m100$$Nest$mcheckAccessPermission(ObricSecurityGuardPlugin r0) {
        return r0.checkAccessPermission();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public IBinder asBinder() {
        return new ObricSecurityGuardService(this, null);
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStart() {
        this.mSecurityGuardManager = ObricSecurityGuardManager.getInstance();
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStop() {
    }

    private boolean checkAccessPermission() {
        int callingUid = Binder.getCallingUid();
        PackageManager packageManager = this.mContext.getPackageManager();
        String[] pkgs = packageManager.getPackagesForUid(callingUid);
        if (pkgs != null) goto L5;
        return false;
    L5:
        int r4 = pkgs.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L12;
        String pkg = pkgs[r5];
        if (GuardConst.VALID_ACCESS_APPS.contains(pkg) == true) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public ObricSecurityGuardPlugin(Context context) {
        this.mContext = context;
    }
}
