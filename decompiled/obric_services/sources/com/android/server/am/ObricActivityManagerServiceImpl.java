package com.android.server.am;

import android.app.ActivityManager;
import android.app.IObricActivityManager;
import android.app.IObricActivityManagerInternal;
import android.app.IObricBackNavigationListener;
import android.app.IObricDisplayInfoCallback;
import android.app.IObricTaskStackListener;
import android.app.ITopActivityAssistDataReceiver;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.wm.IObricActivityTaskManagerService;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityManagerServiceImpl implements IObricActivityManagerService {
    private static final String TAG = "ObricActivityManagerServiceImpl";
    private final ActivityManagerService mBase;
    private final IObricActivityManager mIObricActivityManager;
    private IObricActivityManagerInternal mIObricActivityManagerInternal;

    private class ObricActivityManagerImpl extends IObricActivityManager.Stub {
        final /* synthetic */ ObricActivityManagerServiceImpl this$0;

        /* synthetic */ ObricActivityManagerImpl(ObricActivityManagerServiceImpl r1, ObricActivityManagerServiceImplIA r2) {
            this(r1);
        }

        private ObricActivityManagerImpl(ObricActivityManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        public boolean isPackageVisibleOnDisplay(String pakcageName, int displayId) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().isPackageVisibleOnDisplay(pakcageName, displayId);
        }

        public boolean registerTaskStackListenerEx(IObricTaskStackListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L5;
            return false;
        L5:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().registerTaskStackListenerEx(listener);
        }

        public boolean moveTaskToDisplay(int taskId, int displayId, boolean isTop) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().moveTaskToDisplay(taskId, displayId, isTop);
        }

        public void tryToMute(boolean shouldMute) throws RemoteException {
            ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().tryToMute(shouldMute);
        }

        public boolean unregisterTaskStackListenerEx(IObricTaskStackListener listener) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().unregisterTaskStackListenerEx(listener);
        }

        public void enableCallUser(boolean enable) throws RemoteException {
            ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().enableCallUser(enable);
        }

        public int getAutoDisplayId() throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L5;
            return 0;
        L5:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().getAutoDisplayId();
        }

        public void addDisablePackage(String[] packageName) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            Slog.e(ObricActivityManagerServiceImpl.TAG, "addDisablePackage: only system app can add disable package");
            return;
        L6:
            ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt().addDisablePackage(packageName);
        }

        public boolean registerBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt().registerBackNavigationInVirtualDisplayListenerEx(listener);
        }

        public boolean unregisterBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt().unregisterBackNavigationInVirtualDisplayListenerEx(listener);
        }

        public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int displayId) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().getCurrentTaskInfo(displayId);
        }

        public boolean registerObricDisplayInfoCallback(IObricDisplayInfoCallback listener) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().registerDisplayInfoListenerEx(listener);
        }

        public boolean unregisterObricDisplayInfoCallback(IObricDisplayInfoCallback listener) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().unregisterObricDisplayInfoCallback(listener);
        }

        public boolean registerBackNavigationListener(IObricBackNavigationListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt().registerBackNavigationListener(listener);
        }

        public boolean unregisterBackNavigationListener(IObricBackNavigationListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt().unregisterBackNavigationListener(listener);
        }

        public boolean requestTopActivityAssistData(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) throws RemoteException {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().requestTopActivityAssistData(requestId, displayId, receiver);
        }

        public void setMuteWhitelist(List<String> whitelist) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            Slog.e(ObricActivityManagerServiceImpl.TAG, "setMuteWhitelist: only system app can set whitelist");
            return;
        L6:
            IObricActivityTaskManagerService r0 = ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mActivityTaskManager.getObricExt();
            if (whitelist == null) goto L9;
            HashSet r1 = new HashSet(whitelist);
        L10:
            r0.setWhitelist(r1);
            return;
        L9:
            r1 = null;
            goto L10
        }

        public void reportScenePerceptionEvent(int type, Bundle bundle) {
            ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().reportScenePerceptionEvent(type, bundle, Binder.getCallingUid());
        }
    }

    private class ObricActivityManagerInternalImpl implements IObricActivityManagerInternal {
        final /* synthetic */ ObricActivityManagerServiceImpl this$0;

        /* synthetic */ ObricActivityManagerInternalImpl(ObricActivityManagerServiceImpl r1, ObricActivityManagerServiceImplIA r2) {
            this(r1);
        }

        private ObricActivityManagerInternalImpl(ObricActivityManagerServiceImpl r1) {
            this.this$0 = r1;
        }

        public boolean isMutedApp(int uid, String callingPackageName) {
            return ObricActivityManagerServiceImpl.m1$$Nest$fgetmBase(this.this$0).mAppOpsService.getObricExt().isMutedApp(uid, callingPackageName);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1$$Nest$fgetmBase(ObricActivityManagerServiceImpl r0) {
        return r0.mBase;
    }

    public ObricActivityManagerServiceImpl(ActivityManagerService base) {
        ObricActivityManagerServiceImplIA r1 = null;
        this.mIObricActivityManager = new ObricActivityManagerImpl(this, r1);
        this.mIObricActivityManagerInternal = new ObricActivityManagerInternalImpl(this, r1);
        this.mBase = base;
    }

    public IObricActivityManager getIObricExt() {
        return this.mIObricActivityManager;
    }

    public IObricActivityManagerInternal getObricActivityManagerInternal() {
        return this.mIObricActivityManagerInternal;
    }
}
