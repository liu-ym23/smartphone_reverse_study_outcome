package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IAssistantWindowFocusStatusListener;
import android.app.IObricDisplayInfoCallback;
import android.app.IObricInputMethodListener;
import android.app.IObricTaskStackListener;
import android.app.IObricWindowGestureListener;
import android.app.ITopActivityAssistDataReceiver;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.view.IObricWindowManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.ImeTracker;
import android.window.ScreenCapture;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.obric.internal.app.ObricAssistUtils;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import obric.memorydata.MemoryManagerProxy;

/* JADX INFO: loaded from: classes.dex */
public class ObricWindowManagerServiceImpl implements IObricWindowManagerService {
    private static final String[] ASSIST_SOURCE_DISPLAY_PKG_ALLOWLIST = null;
    private static final boolean DEBUG = false;
    private static final String LAUNCHER_PACKAGE = "com.android.launcher3";
    private static final int MAX_REMOVED_OBRIC_VIRTUAL_DISPLAY_IDS = 1000;
    private static final long SCENE_PERCEPTION_TIMEOUT_MS = 5000;
    private static final String SYSTEMUI_PACKAGE = "com.android.systemui";
    private static final String TAG = "ObricWindowManagerServiceImpl";
    private static final String VD_PLAYER_ACTIVITY = "com.obric.autoaction.vdplayer.VDPlayerStubActivity";
    private static final String VD_PLAYER_PACKAGE = "com.larus.nova";
    private static final Set<String> WHITELSTED_APPS_IN_AUTO = null;
    private ObricInputMonitor mActiveGestureMonitor;
    private volatile String mAutoFocusedPkg;
    private IBinder mAutoFocusedWindowToken;
    private IObricWindowManager mIObricWindowManager;
    private volatile boolean mIsAutoActionInCallUser;
    private volatile boolean mIsInputMethodShown;
    private final Runnable mMuteRunnable;
    private final IObricWindowManagerInternal mObricWindowManagerInternal;
    private final RemoteCallbackList<IAssistantWindowFocusStatusListener> mRemoteAssistantWindowFocusStatusListeners;
    private final RemoteCallbackList<IObricDisplayInfoCallback> mRemoteDisplayInfoListeners;
    private IRemoteInputConnection mRemoteInputConnection;
    private final RemoteCallbackList<IObricInputMethodListener> mRemoteInputMethodListeners;
    private final RemoteCallbackList<IObricTaskStackListener> mRemoteTaskStackListeners;
    private final Set<Integer> mRemovedObricVirtualDisplayIds;
    private final Map<String, ScenePerceptionData> mScenePerceptionData;
    private final ViewHierarchyDumpController mViewHierarchyDumpController;
    private WindowManagerService mWmService;

    final class ExtLocalService implements IObricWindowManagerInternal {
        final /* synthetic */ ObricWindowManagerServiceImpl this$0;

        ExtLocalService(ObricWindowManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public Bitmap getWallPaperScreenShot(IBinder token) {
            return null;
        }

        public boolean showImeInAuto(IBinder windowToken, int selfReportedDisplayId) {
            return this.this$0.showImeInAuto(windowToken, selfReportedDisplayId);
        }

        public void hideImeInAuto(int selfReportedDisplayId) {
            this.this$0.hideImeInAuto(selfReportedDisplayId);
        }

        public IBinder getAutoFocusedWindowToken() {
            return ObricWindowManagerServiceImpl.m69$$Nest$fgetmAutoFocusedWindowToken(this.this$0);
        }

        public boolean shouldBlockVibrationForAuto(String pkg) {
            if (ObricWindowManagerServiceImpl.m86$$Nest$sfgetWHITELSTED_APPS_IN_AUTO().contains(pkg) == false) goto L5;
        L11:
            return false;
        L5:
            if (ObricWindowManagerServiceImpl.m68$$Nest$fgetmAutoFocusedPkg(this.this$0) == null) goto L11;
            if (ObricWindowManagerServiceImpl.m68$$Nest$fgetmAutoFocusedPkg(this.this$0).equals(pkg) == false) goto L11;
            if (ObricWindowManagerServiceImpl.m70$$Nest$fgetmIsAutoActionInCallUser(this.this$0) == true) goto L11;
            return true;
        }

        public boolean hideImeInAuto(IBinder windowToken, int selfReportedDisplayId) {
            return ObricWindowManagerServiceImpl.m82$$Nest$mhideImeInAuto(this.this$0, windowToken, selfReportedDisplayId);
        }

        public void setFakeInputConnection(IRemoteInputConnection currentInputConnection) {
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
            ObricWindowManagerServiceImpl.m77$$Nest$fputmRemoteInputConnection(this.this$0, currentInputConnection);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isPkgRunWithOAuto(String pkg) {
            if (ObricWindowManagerServiceImpl.m68$$Nest$fgetmAutoFocusedPkg(this.this$0) != null) goto L5;
        L7:
            return false;
        L5:
            if (ObricWindowManagerServiceImpl.m68$$Nest$fgetmAutoFocusedPkg(this.this$0).equals(pkg) == false) goto L7;
            return true;
        }

        public boolean shouldDispatchToAutoDisplay() {
            return this.this$0.shouldDispatchToAutoDisplay();
        }

        public void onInputEventInjectedForRobots(InputEvent event) {
            String actionType = "";
            String timeStamp = String.valueOf(System.currentTimeMillis());
            if ((event instanceof MotionEvent) == false) goto L11;
            MotionEvent motionEvent = (MotionEvent) event;
            if (motionEvent.getActionMasked() != 0) goto L8;
            actionType = ObricActivityTaskManagerServiceImpl.ACTION_TOUCH_DOWN_EVENT;
            String args = "x=" + motionEvent.getX() + ",y=" + motionEvent.getY();
            String args2 = args;
        L13:
            if ((event instanceof KeyEvent) == false) goto L15;
            String actionType2 = ObricActivityTaskManagerServiceImpl.ACTION_KEY_EVENT;
        L16:
            WindowManagerGlobalLock r1 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r1);
            String targetPackage = ObricWindowManagerServiceImpl.m68$$Nest$fgetmAutoFocusedPkg(this.this$0);     // Catch: Throwable -> L27
            DisplayContent dc = this.this$0.getAutoVirtualDisplayContent();     // Catch: Throwable -> L27
            if (dc != null) goto L21;
        L23:
            String targetActivity = "";
        L24:
            ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mAtmService.getObricExt().writeRobotsLog(targetPackage, targetActivity, actionType2, timeStamp, args2);     // Catch: Throwable -> L27
            monitor-exit(r1);     // Catch: Throwable -> L27
            return;
        L21:
            if (dc.getTopMostActivity() == null) goto L23;
            String targetActivity2 = dc.getTopMostActivity().toString();     // Catch: Throwable -> L27
            targetActivity = targetActivity2;
        L27:
            th = move-exception;
            throw th;
        L15:
            actionType2 = actionType;
            goto L16
        L8:
            if (motionEvent.getActionMasked() != 1) goto L10;
            actionType = ObricActivityTaskManagerServiceImpl.ACTION_TOUCH_UP_EVENT;
            String args3 = "x=" + motionEvent.getX() + ",y=" + motionEvent.getY();
            args2 = args3;
            goto L13
        L10:
            return;
        L11:
            args2 = "";
            goto L13
        }

        public int getRobotsAgentUid() {
            return ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mAtmService.getObricExt().getRobotsAgentUid();
        }

        public int getAutoDisplayId() {
            return this.this$0.getAutoDisplayId();
        }

        public boolean isAutoActionRunning() {
            return this.this$0.isAutoActionRunning();
        }

        public boolean isOwningFocusedWindowOnDisplay(int uid, int pid, String packageName, String activityClassName, int displayId) {
            return ObricWindowManagerServiceImpl.m83$$Nest$misOwningFocusedWindowOnDisplayInner(this.this$0, uid, pid, packageName, activityClassName, displayId);
        }

        public boolean shouldClipBoardIsolate() {
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (ObricWindowManagerServiceImpl.m70$$Nest$fgetmIsAutoActionInCallUser(this.this$0) == false) goto L7;
        L9:
            boolean r1 = false;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L7:
            if (isAutoActionRunning() == false) goto L9;
            r1 = true;
            goto L10
        }

        public int getCallingFocusedDisplayId() {
            return ObricWindowManagerServiceImpl.m80$$Nest$mgetCallingFocusedDisplayIdInner(this.this$0);
        }

        public void reportKeyEventOnAutoDisplay(InputEvent event) {
            ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mAtmService.getObricExt().reportKeyEventOnAutoDisplay(event);
        }

        public boolean hasSecureWindow(int displayId) {
            return ObricWindowManagerServiceImpl.m81$$Nest$mhasSecureWindowInner(this.this$0, displayId);
        }

        public void recordClickViewTreeCandidate(MotionEvent event) {
            ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mAtmService.getObricExt().recordClickViewTreeCandidate(event);
        }

        public boolean isVDPlayerOnTop() {
            return ObricWindowManagerServiceImpl.m84$$Nest$misVDPlayerOnTopInner(this.this$0);
        }

        public int getAllowlistedAssistSourceDisplayId() {
            return ObricWindowManagerServiceImpl.m79$$Nest$mgetAllowlistedAssistSourceDisplayIdInner(this.this$0);
        }
    }

    protected class ObricWindowManagerImpl extends IObricWindowManager.Stub {
        final /* synthetic */ ObricWindowManagerServiceImpl this$0;

        protected ObricWindowManagerImpl(ObricWindowManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public boolean takeSurfaceControlScreenshot(List<String> includingPackageNames, List<String> excludingPackageNames, ScreenCapture.ScreenCaptureListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            long identity = Binder.clearCallingIdentity();
            boolean r10 = ObricWindowManagerServiceImpl.m85$$Nest$mtakeSnapshot(this.this$0, includingPackageNames, excludingPackageNames, listener, false, false);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return r10;
        L12:
            th = move-exception;
            Throwable r11 = th;
        L16:
            Binder.restoreCallingIdentity(identity);
            throw r11;
        L14:
            th = move-exception;
            r11 = th;
            goto L16
        }

        public boolean isAutoImeShowing() throws RemoteException {
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
            boolean r2 = false;
            if (ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).getObricExt().getAutoVirtualDisplayContent() != null) goto L7;
            monitor-exit(r0);     // Catch: Throwable -> L16
            return false;
        L7:
            if (ObricWindowManagerServiceImpl.m73$$Nest$fgetmRemoteInputConnection(this.this$0) != null) goto L9;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r2;
        L9:
            if (this.this$0.getAutoVirtualDisplayContent().getDisplayPolicy().getObricExt().isAutoImeShowing() == false) goto L12;
            r2 = true;
        L16:
            th = move-exception;
            throw th;
        }

        public boolean isAutoActionRunning() throws RemoteException {
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
            Iterator r1 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mRoot.mChildren.iterator();     // Catch: Throwable -> L16
        L6:
            if (r1.hasNext() == false) goto L13;
            DisplayContent dc = (DisplayContent) r1.next();     // Catch: Throwable -> L16
            if (dc.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L16
            return true;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return false;
        L16:
            th = move-exception;
            throw th;
        }

        public int getAutoDisplayId() {
            return this.this$0.getAutoDisplayId();
        }

        public int getCallingFocusedDisplayId() {
            return ObricWindowManagerServiceImpl.m80$$Nest$mgetCallingFocusedDisplayIdInner(this.this$0);
        }

        public boolean focusedWindowIsSecure() {
            return ObricWindowManagerServiceImpl.m81$$Nest$mhasSecureWindowInner(this.this$0, 0);
        }

        public boolean isInputMethodShown() throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L7;
            return false;
        L7:
            return ObricWindowManagerServiceImpl.m71$$Nest$fgetmIsInputMethodShown(this.this$0);
        }

        public boolean registerInputMethodListener(IObricInputMethodListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricWindowManagerServiceImpl.m74$$Nest$fgetmRemoteInputMethodListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricWindowManagerServiceImpl.m74$$Nest$fgetmRemoteInputMethodListeners(this.this$0).register(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean unregisterInputMethodListener(IObricInputMethodListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricWindowManagerServiceImpl.m74$$Nest$fgetmRemoteInputMethodListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricWindowManagerServiceImpl.m74$$Nest$fgetmRemoteInputMethodListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean registerWindowGestureListener(IBinder windowToken, IObricWindowGestureListener listener) throws RemoteException {
            Slog.d(ObricWindowManagerServiceImpl.TAG, "registerWindowGestureListener called, windowToken=" + windowToken + ", listener=" + listener + ", callingUid=" + Binder.getCallingUid());
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            Slog.e(ObricWindowManagerServiceImpl.TAG, "registerWindowGestureListener: not a system app");
            return false;
        L6:
            if (windowToken == null) goto L31;
            if (listener == null) goto L31;
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
            WindowState windowState = ObricWindowManagerServiceImpl.m78$$Nest$mfindWindowStateByToken(this.this$0, windowToken);     // Catch: Throwable -> L28
            if (windowState != null) goto L16;
            Slog.e(ObricWindowManagerServiceImpl.TAG, "Failed to find WindowState for token: " + windowToken);     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return false;
        L16:
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Found WindowState: " + windowState + ", package=" + windowState.getOwningPackage());     // Catch: Throwable -> L28
            ObricWindowStateImpl obricExt = (ObricWindowStateImpl) windowState.getObricExt();     // Catch: Throwable -> L28
            ObricInputMonitor manager = obricExt.getInputMonitorManager();     // Catch: Throwable -> L28
            if (manager != null) goto L19;
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Creating new ObricInputMonitor");     // Catch: Throwable -> L28
            manager = new ObricInputMonitor(windowState, "obric-home-monitor");     // Catch: Throwable -> L28
            obricExt.setInputMonitorManager(manager);     // Catch: Throwable -> L28
        L20:
            boolean result = manager.registerWindowGestureListener(listener);     // Catch: Throwable -> L28
            if (windowState.isFocused() == true) goto L23;
        L25:
            Slog.d(ObricWindowManagerServiceImpl.TAG, "registerWindowGestureListener result: " + result);     // Catch: Throwable -> L28
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Registered window gesture listener for window: " + windowState.getOwningPackage());     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return result;
        L23:
            if (windowState.getDisplayId() != 0) goto L25;
            manager.registerInputMonitor();     // Catch: Throwable -> L28
            ObricWindowManagerServiceImpl.m76$$Nest$fputmActiveGestureMonitor(this.this$0, manager);     // Catch: Throwable -> L28
            goto L25
        L19:
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Reusing existing ObricInputMonitor");     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        L31:
            Slog.e(ObricWindowManagerServiceImpl.TAG, "registerSwipeUpListener: windowToken or listener is null");
            return false;
        }

        public boolean unregisterWindowGestureListener(IBinder windowToken, IObricWindowGestureListener listener) throws RemoteException {
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L5;
            return false;
        L5:
            if (windowToken == null) goto L31;
            if (listener == null) goto L31;
            WindowManagerGlobalLock r0 = ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mGlobalLock;
            monitor-enter(r0);
            WindowState windowState = ObricWindowManagerServiceImpl.m78$$Nest$mfindWindowStateByToken(this.this$0, windowToken);     // Catch: Throwable -> L28
            if (windowState != null) goto L15;
            Slog.e(ObricWindowManagerServiceImpl.TAG, "Failed to find WindowState for token: " + windowToken);     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return false;
        L15:
            ObricWindowStateImpl obricExt = (ObricWindowStateImpl) windowState.getObricExt();     // Catch: Throwable -> L28
            ObricInputMonitor manager = obricExt.getInputMonitorManager();     // Catch: Throwable -> L28
            if (manager != null) goto L19;
            monitor-exit(r0);     // Catch: Throwable -> L28
            return false;
        L19:
            boolean result = manager.unregisterWindowGestureListener(listener);     // Catch: Throwable -> L28
            if (manager.getWindowGestureListenerCount() != 0) goto L25;
            manager.unregisterInputMonitor();     // Catch: Throwable -> L28
            obricExt.setInputMonitorManager(null);     // Catch: Throwable -> L28
            if (ObricWindowManagerServiceImpl.m67$$Nest$fgetmActiveGestureMonitor(this.this$0) != manager) goto L24;
            ObricWindowManagerServiceImpl.m76$$Nest$fputmActiveGestureMonitor(this.this$0, null);     // Catch: Throwable -> L28
        L24:
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Removed input monitor for window when all swipe listeners are unregistered");     // Catch: Throwable -> L28
        L25:
            Slog.d(ObricWindowManagerServiceImpl.TAG, "Unregistered swipe listener for window: " + windowState.getOwningPackage());     // Catch: Throwable -> L28
            monitor-exit(r0);     // Catch: Throwable -> L28
            return result;
        L28:
            th = move-exception;
            throw th;
        L31:
            return false;
        }

        public boolean registerAssistantWindowFocusStatusListener(IAssistantWindowFocusStatusListener listener) throws RemoteException {
            if (listener != null) goto L6;
            return false;
        L6:
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L8;
            return false;
        L8:
            RemoteCallbackList r0 = ObricWindowManagerServiceImpl.m72$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricWindowManagerServiceImpl.m72$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners(this.this$0).register(listener);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        L13:
            th = move-exception;
            throw th;
        }

        public boolean unregisterAssistantWindowFocusStatusListener(IAssistantWindowFocusStatusListener listener) throws RemoteException {
            if (listener != null) goto L6;
            return false;
        L6:
            if (ObricPermissionCheckHelper.isSystemApp(ObricWindowManagerServiceImpl.m75$$Nest$fgetmWmService(this.this$0).mContext, Binder.getCallingUid()) == true) goto L8;
            return false;
        L8:
            RemoteCallbackList r0 = ObricWindowManagerServiceImpl.m72$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricWindowManagerServiceImpl.m72$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r1;
        L13:
            th = move-exception;
            throw th;
        }
    }

    private static class ScenePerceptionData {
        final long mCreateTime;
        final String mPackageName;
        final String mSessionId;

        ScenePerceptionData(String sessionId, String packageName) {
            this.mSessionId = sessionId;
            this.mPackageName = packageName;
            this.mCreateTime = SystemClock.elapsedRealtime();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Ku1U1BLESuQ-AQw6WhzAULDq458, reason: not valid java name */
    public static /* synthetic */ void m66$r8$lambda$Ku1U1BLESuQAQw6WhzAULDq458(ObricWindowManagerServiceImpl r0, WindowProcessController r1, int r2) {
        r0.lambda$reportError$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$rvtibOYDeTMRdusn0BodrhtsijA(ObricWindowManagerServiceImpl r0, long r1, List r3, String r4, ScenePerceptionData r5) {
        r0.lambda$requestScenePerception$10(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveGestureMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ObricInputMonitor m67$$Nest$fgetmActiveGestureMonitor(ObricWindowManagerServiceImpl r0) {
        return r0.mActiveGestureMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoFocusedPkg, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m68$$Nest$fgetmAutoFocusedPkg(ObricWindowManagerServiceImpl r0) {
        return r0.mAutoFocusedPkg;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutoFocusedWindowToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m69$$Nest$fgetmAutoFocusedWindowToken(ObricWindowManagerServiceImpl r0) {
        return r0.mAutoFocusedWindowToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsAutoActionInCallUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m70$$Nest$fgetmIsAutoActionInCallUser(ObricWindowManagerServiceImpl r0) {
        return r0.mIsAutoActionInCallUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsInputMethodShown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m71$$Nest$fgetmIsInputMethodShown(ObricWindowManagerServiceImpl r0) {
        return r0.mIsInputMethodShown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m72$$Nest$fgetmRemoteAssistantWindowFocusStatusListeners(ObricWindowManagerServiceImpl r0) {
        return r0.mRemoteAssistantWindowFocusStatusListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteInputConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRemoteInputConnection m73$$Nest$fgetmRemoteInputConnection(ObricWindowManagerServiceImpl r0) {
        return r0.mRemoteInputConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteInputMethodListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m74$$Nest$fgetmRemoteInputMethodListeners(ObricWindowManagerServiceImpl r0) {
        return r0.mRemoteInputMethodListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m75$$Nest$fgetmWmService(ObricWindowManagerServiceImpl r0) {
        return r0.mWmService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveGestureMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m76$$Nest$fputmActiveGestureMonitor(ObricWindowManagerServiceImpl r0, ObricInputMonitor r1) {
        r0.mActiveGestureMonitor = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteInputConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m77$$Nest$fputmRemoteInputConnection(ObricWindowManagerServiceImpl r0, IRemoteInputConnection r1) {
        r0.mRemoteInputConnection = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mfindWindowStateByToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowState m78$$Nest$mfindWindowStateByToken(ObricWindowManagerServiceImpl r0, IBinder r1) {
        return r0.findWindowStateByToken(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAllowlistedAssistSourceDisplayIdInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m79$$Nest$mgetAllowlistedAssistSourceDisplayIdInner(ObricWindowManagerServiceImpl r0) {
        return r0.getAllowlistedAssistSourceDisplayIdInner();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCallingFocusedDisplayIdInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m80$$Nest$mgetCallingFocusedDisplayIdInner(ObricWindowManagerServiceImpl r0) {
        return r0.getCallingFocusedDisplayIdInner();
    }

    /* JADX INFO: renamed from: -$$Nest$mhasSecureWindowInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m81$$Nest$mhasSecureWindowInner(ObricWindowManagerServiceImpl r0, int r1) {
        return r0.hasSecureWindowInner(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideImeInAuto, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m82$$Nest$mhideImeInAuto(ObricWindowManagerServiceImpl r0, IBinder r1, int r2) {
        return r0.hideImeInAuto(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misOwningFocusedWindowOnDisplayInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m83$$Nest$misOwningFocusedWindowOnDisplayInner(ObricWindowManagerServiceImpl r0, int r1, int r2, String r3, String r4, int r5) {
        return r0.isOwningFocusedWindowOnDisplayInner(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$misVDPlayerOnTopInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m84$$Nest$misVDPlayerOnTopInner(ObricWindowManagerServiceImpl r0) {
        return r0.isVDPlayerOnTopInner();
    }

    /* JADX INFO: renamed from: -$$Nest$mtakeSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m85$$Nest$mtakeSnapshot(ObricWindowManagerServiceImpl r0, List r1, List r2, ScreenCapture.ScreenCaptureListener r3, boolean r4, boolean r5) {
        return r0.takeSnapshot(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetWHITELSTED_APPS_IN_AUTO, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m86$$Nest$sfgetWHITELSTED_APPS_IN_AUTO() {
        return WHITELSTED_APPS_IN_AUTO;
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        r1 = true;
    L5:
        DEBUG = r1;
        WHITELSTED_APPS_IN_AUTO = new ArraySet(Set.of(SYSTEMUI_PACKAGE, LAUNCHER_PACKAGE));
        ASSIST_SOURCE_DISPLAY_PKG_ALLOWLIST = new String[]{"com.android.gallery3d"};
    }

    private WindowState findWindowStateByToken(final IBinder windowToken) {
        if (windowToken != null) goto L5;
        return null;
    L5:
        DisplayContent defaultDisplay = this.mWmService.mRoot.getDisplayContent(0);
        if (defaultDisplay != null) goto L8;
        return null;
    L8:
        final WindowState[] foundWindow = new WindowState[1];
        defaultDisplay.forAllWindows(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda6(windowToken, foundWindow), true);
        return foundWindow[0];
    }

    static /* synthetic */ boolean lambda$findWindowStateByToken$0(IBinder windowToken, WindowState[] foundWindow, WindowState w) {
        if (w.getWindowToken() != windowToken) goto L6;
        foundWindow[0] = w;
        return true;
    L6:
        return false;
    }

    public ObricWindowManagerServiceImpl(WindowManagerService base) {
        this.mRemoteTaskStackListeners = new RemoteCallbackList();
        this.mRemoteDisplayInfoListeners = new RemoteCallbackList();
        this.mRemoteInputMethodListeners = new RemoteCallbackList();
        this.mRemoteAssistantWindowFocusStatusListeners = new RemoteCallbackList();
        this.mIsInputMethodShown = false;
        this.mRemoteInputConnection = null;
        this.mScenePerceptionData = new ConcurrentHashMap();
        this.mRemovedObricVirtualDisplayIds = Collections.synchronizedSet(new ArraySet());
        Objects.requireNonNull(this);
        this.mIObricWindowManager = new ObricWindowManagerImpl(this);
        this.mIsAutoActionInCallUser = false;
        this.mAutoFocusedPkg = "";
        this.mObricWindowManagerInternal = new ExtLocalService(this);
        this.mMuteRunnable = new AnonymousClass1(this);
        this.mWmService = base;
        this.mViewHierarchyDumpController = new ViewHierarchyDumpController(base);
    }

    public IObricWindowManager getIObricExt() {
        return this.mIObricWindowManager;
    }

    public Bitmap takeAssistScreenshotForTopApp() {
        if (this.mWmService.checkCallingPermission("android.permission.READ_FRAME_BUFFER", "requestAssistScreenshot()") == false) goto L27;
        List<String> includingPackages = new ArrayList();
        WindowManagerGlobalLock r1 = this.mWmService.mGlobalLock;
        monitor-enter(r1);
        DisplayContent dc = this.mWmService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L23
        ActivityRecord topActivity = dc.getDefaultTaskDisplayArea().getActivity(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda3(), true);     // Catch: Throwable -> L23
        Bitmap ret = null;
        if (topActivity != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L23
        return null;
    L10:
        includingPackages.add(topActivity.packageName);     // Catch: Throwable -> L23
        WindowState wallpaper = dc.mWallpaperController.getTopVisibleWallpaper();     // Catch: Throwable -> L23
        if (wallpaper == null) goto L13;
        includingPackages.add(wallpaper.getOwningPackage());     // Catch: Throwable -> L23
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L23
        ScreenCapture.SynchronousScreenCaptureListener syncScreenCapture = ScreenCapture.createSyncCaptureListener();
        takeSnapshot(includingPackages, null, syncScreenCapture, true, true);
        ScreenCapture.ScreenshotHardwareBuffer shb = syncScreenCapture.getBuffer();
        if (shb == null) goto L17;
        Bitmap bm = shb.asBitmap();
    L18:
        if (bm == null) goto L20;
        ret = bm.asShared();
    L20:
        if (ret == bm) goto L22;
        bm.recycle();
    L22:
        return ret;
    L17:
        bm = null;
    L23:
        th = move-exception;
        throw th;
    L27:
        throw new SecurityException("Requires READ_FRAME_BUFFER permission");
    }

    static /* synthetic */ boolean lambda$takeAssistScreenshotForTopApp$1(ActivityRecord r) {
        if (r != null) goto L4;
    L14:
        return false;
    L4:
        if (r.finishing == true) goto L14;
        if (r.inFreeformWindowingMode() == true) goto L14;
        if (r.inPinnedWindowingMode() == true) goto L14;
        if ("com.larus.nova".equals(r.packageName) == true) goto L12;
    L13:
        return true;
    L12:
        if (ObricAssistUtils.containsAssistantSpecialPage(r.mActivityComponent.getClassName()) == false) goto L14;
        goto L13
    }

    private boolean hasSecureWindowInner(int displayId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent displayContent = this.mWmService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L12
        if (displayContent == null) goto L9;
        boolean r2 = displayContent.forAllWindows(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda2(), true);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$hasSecureWindowInner$2(WindowState w) {
        if (w.isVisible() == true) goto L5;
        return false;
    L5:
        if (w.isSecureLocked() == false) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isVDPlayerOnTopInner() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent dc = this.mWmService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L37
        boolean r2 = false;
        if (dc != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L37
        return false;
    L8:
        DisplayPolicy policy = dc.getDisplayPolicy();     // Catch: Throwable -> L37
        ActivityRecord focusAr = null;
        if (policy == null) goto L11;
        WindowState shade = policy.getNotificationShade();     // Catch: Throwable -> L37
    L12:
        if (shade != null) goto L14;
    L17:
        WindowState focus = dc.mCurrentFocus;     // Catch: Throwable -> L37
        if (focus == null) goto L20;
        focusAr = focus.getActivityRecord();     // Catch: Throwable -> L37
    L20:
        if (focusAr == null) goto L22;
        ActivityRecord top = focusAr;
    L23:
        if (top != null) goto L25;
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L37
        return false;
    L25:
        if (top.mActivityComponent == null) goto L35;
        if ("com.larus.nova".equals(top.mActivityComponent.getPackageName()) == true) goto L30;
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L37
        return r2;
    L30:
        if (VD_PLAYER_ACTIVITY.equals(top.mActivityComponent.getClassName()) == false) goto L33;
        r2 = true;
        goto L33
    L22:
        top = dc.getTopMostActivity();     // Catch: Throwable -> L37
        goto L23
    L14:
        if (shade.isVisible() == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L37
        return false;
    L11:
        shade = null;
    L37:
        th = move-exception;
        throw th;
    }

    public WindowState resolveBackFocusedWindow() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (shouldDispatchToAutoDisplay() == true) goto L7;
    L11:
        int topFocusedDisplayId = this.mWmService.mRoot.getTopFocusedDisplayId();     // Catch: Throwable -> L19
        DisplayContent dc = this.mWmService.mRoot.getDisplayContent(topFocusedDisplayId);     // Catch: Throwable -> L19
        if (dc != null) goto L14;
        dc = this.mWmService.mRoot.getDisplayContent(0);     // Catch: Throwable -> L19
    L14:
        if (dc == null) goto L16;
        WindowState r3 = dc.mCurrentFocus;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r3;
    L16:
        r3 = null;
        goto L17
    L7:
        if (isVDPlayerOnTopInner() == false) goto L11;
        WindowState r1 = this.mWmService.getFocusedWindowLocked();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r1;
    }

    private boolean takeSnapshot(final List<String> includingPackageNames, final List<String> excludingPackageNames, ScreenCapture.ScreenCaptureListener listener, final boolean needExcludeAssist, final boolean excludeFreeformAndPinned) {
        if (includingPackageNames == null) goto L6;
        if (excludingPackageNames == null) goto L6;
        return false;
    L6:
        Slog.i(TAG, "include: " + includingPackageNames + " exclude: " + excludingPackageNames);
        WindowManagerGlobalLock r1 = this.mWmService.mGlobalLock;
        monitor-enter(r1);
        DisplayContent dc = this.mWmService.mRoot.getDisplayContent(0);     // Catch: Throwable -> L17
        final ArraySet<SurfaceControl> surfaceControls = new ArraySet();     // Catch: Throwable -> L17
        dc.forAllWindows(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda10(excludeFreeformAndPinned, surfaceControls, excludingPackageNames, includingPackageNames, needExcludeAssist), true);     // Catch: Throwable -> L21
        ScreenCapture.LayerCaptureArgs.Builder builder = new ScreenCapture.LayerCaptureArgs.Builder(dc.getSurfaceControl());     // Catch: Throwable -> L21
        if (surfaceControls.isEmpty() == true) goto L13;
        Slog.i(TAG, "exclude layer: " + surfaceControls);     // Catch: Throwable -> L21
        builder.setExcludeLayers((SurfaceControl[]) surfaceControls.toArray(new SurfaceControl[0]));     // Catch: Throwable -> L21
    L13:
        ScreenCapture.LayerCaptureArgs r14 = builder.build();     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        this.mWmService.captureDisplay(0, r14, listener);
        return true;
    L17:
        th = move-exception;
        Throwable r11 = th;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L21
        throw r11;
    L21:
        th = move-exception;
        r11 = th;
        goto L19
    }

    static /* synthetic */ void lambda$takeSnapshot$3(boolean excludeFreeformAndPinned, ArraySet surfaceControls, List excludingPackageNames, List includingPackageNames, boolean needExcludeAssist, WindowState w) {
        if (w.isVisible() == true) goto L5;
        return;
    L5:
        if (excludeFreeformAndPinned == true) goto L7;
    L21:
        String pkg = w.getOwningPackage();
        if (excludingPackageNames != null) goto L24;
        if (includingPackageNames != null) goto L29;
        return;
    L29:
        if (includingPackageNames.contains(pkg) == true) goto L32;
        surfaceControls.add(w.getSurfaceControl());
        return;
    L32:
        if ("com.larus.nova".equals(pkg) == true) goto L34;
        return;
    L34:
        if (ObricAssistUtils.containsAssistantSpecialPage(w.getWindowTag().toString()) == true) goto L43;
        if (needExcludeAssist == false) goto L44;
        surfaceControls.add(w.getSurfaceControl());
        return;
    L44:
        return;
    L43:
        return;
    L24:
        if (excludingPackageNames.contains(pkg) == false) goto L39;
        surfaceControls.add(w.getSurfaceControl());
        return;
    L39:
        return;
    L7:
        if (w.inFreeformWindowingMode() == false) goto L9;
    L10:
        Task task = w.getTask();
        if (task != null) goto L13;
        return;
    L13:
        SurfaceControl sc = task.getSurfaceControl();
        if (sc != null) goto L16;
        return;
    L16:
        if (sc.isValid() == false) goto L38;
        surfaceControls.add(sc);
        return;
    L38:
        return;
    L9:
        if (w.inPinnedWindowingMode() == false) goto L21;
        goto L10
    }

    public void updateWindowStateShowWhenKeyguard(WindowManager.LayoutParams attrs, int callingPid, int callingUid, WindowState win) {
        if (attrs.type == 2005) goto L5;
        return;
    L5:
        if (this.mWmService.mContext.checkPermission("android.permission.POST_NOTIFICATIONS", callingPid, callingUid) != 0) goto L9;
        win.getObricExt().setShouldShowWhenLocked(true);
        return;
    }

    public boolean shouldDispatchToAutoDisplay() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsAutoActionInCallUser == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L7:
        if (isAutoActionRunning() == false) goto L9;
        r1 = true;
        goto L10
    }

    public void enableCallUser(boolean enable) {
        if (ObricPermissionCheckHelper.isSystemApp(this.mWmService.mContext, Binder.getCallingUid()) == true) goto L6;
        Slog.e(TAG, "enableCallUser: only system app can enable call user");
        return;
    L6:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
    L34:
        th = move-exception;
        throw th;
    L9:
        if (this.mIsAutoActionInCallUser == enable) goto L11;
        Slog.i(TAG, "enableCallUser changes to: " + enable);     // Catch: Throwable -> L34
    L11:
        this.mIsAutoActionInCallUser = enable;     // Catch: Throwable -> L34
        if (enable == false) goto L14;
        String r2 = "true";
    L15:
        SystemProperties.set("sys.obric.click_viewtree.call_user", r2);     // Catch: Throwable -> L34
        DisplayContent displayContent = getAutoVirtualDisplayContent();     // Catch: Exception -> L30 Throwable -> L34
        if (displayContent != null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L20:
        ActivityRecord ac = displayContent.getTopMostActivity();     // Catch: Exception -> L30 Throwable -> L34
        if (ac != null) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L24:
        WindowState window = ac.findMainWindow();     // Catch: Exception -> L30 Throwable -> L34
        if (window != null) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L28:
        window.mClient.restartInput();     // Catch: Exception -> L30 Throwable -> L34
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L30:
        e = move-exception;
        Slog.w(TAG, "enableCallUser restartInput failed", e);     // Catch: Throwable -> L34
        goto L32
    L14:
        r2 = "false";
        goto L15
    }

    public DisplayContent getAutoVirtualDisplayContent() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        Iterator r1 = this.mWmService.mRoot.mChildren.iterator();     // Catch: Throwable -> L15
    L6:
        if (r1.hasNext() == false) goto L12;
        DisplayContent dc = (DisplayContent) r1.next();     // Catch: Throwable -> L15
        if (dc.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return dc;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean isAutoActionRunning() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        Iterator r1 = this.mWmService.mRoot.mChildren.iterator();     // Catch: Throwable -> L16
    L6:
        if (r1.hasNext() == false) goto L13;
        DisplayContent dc = (DisplayContent) r1.next();     // Catch: Throwable -> L16
        if (dc.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean isUidRunningOnAutoActionDisplay(final int uid) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent dc = getAutoVirtualDisplayContent();     // Catch: Throwable -> L12
        if (dc != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L9:
        boolean r2 = dc.forAllActivities(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda4(uid));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$isUidRunningOnAutoActionDisplay$4(int uid, ActivityRecord r) {
        if (r != null) goto L4;
    L6:
        return false;
    L4:
        if (r.getUid() != uid) goto L6;
        return true;
    }

    public boolean isPackageVisibleOnDisplay(final String packageName, int displayId) {
        if (ObricPermissionCheckHelper.isSystemApp(this.mWmService.mContext, Binder.getCallingUid()) == true) goto L6;
        Slog.e(TAG, "isPackageVisibleOnDisplay: only system app can check package visible");
        return false;
    L6:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent displayContent = this.mWmService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L15
        if (displayContent != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L12:
        final AtomicBoolean isVisible = new AtomicBoolean(false);     // Catch: Throwable -> L15
        displayContent.forAllActivities(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda5(packageName, isVisible));     // Catch: Throwable -> L15
        boolean r1 = isVisible.get();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r1;
    L15:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$isPackageVisibleOnDisplay$5(String packageName, AtomicBoolean isVisible, ActivityRecord r) {
        if (packageName.equals(r.packageName) == true) goto L5;
        return;
    L5:
        if (r.isVisible() == false) goto L7;
    L8:
        isVisible.set(true);
        return;
    L7:
        if (r.isAnimating(2, 9) == true) goto L8;
    }

    public void onDisplayStatusBarChanged(int displayId, int appearance) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onDisplayStatusBarChanged(displayId, appearance);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public boolean moveTaskToDisplay(int taskId, int displayId, boolean isTop) {
        long token = Binder.clearCallingIdentity();
        WindowManagerGlobalLock r2 = this.mWmService.mGlobalLock;     // Catch: Throwable -> L12 Exception -> L14
        monitor-enter(r2);     // Catch: Throwable -> L12 Exception -> L14
        boolean r3 = moveTaskToDisplayInnerLocked(taskId, displayId, isTop);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 Exception -> L14
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L14:
        e = move-exception;
        Slog.w(TAG, "moveTaskToDisplayInnerLocked failed", e);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(token);
        return false;
    }

    public int getAutoDisplayId() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent dc = getAutoVirtualDisplayContent();     // Catch: Throwable -> L12
        if (dc != null) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0;
    L9:
        int r2 = dc.getDisplayId();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public Pair<WindowToken, DisplayContent> findSuitableWindowTokenLocked(boolean hasParent, WindowState parentWindow, WindowManager.LayoutParams attrs, WindowToken currentToken) {
        if (currentToken != null) goto L5;
        if (hasParent == false) goto L8;
        IBinder windowTokenToFind = parentWindow.mAttrs.token;
    L10:
        if (isAutoActionRunning() == false) goto L17;
        DisplayContent dc = this.mWmService.getObricExt().getAutoVirtualDisplayContent();
        if (dc == null) goto L17;
        WindowToken token = dc.getWindowToken(windowTokenToFind);
        if (token == null) goto L17;
        Slog.i(TAG, "Window token reassigned to auto virtual display " + dc.getDisplayId());
        return new Pair(token, dc);
    L17:
        DisplayContent dc2 = this.mWmService.getDefaultDisplayContentLocked();
        WindowToken token2 = dc2.getWindowToken(windowTokenToFind);
        if (token2 == null) goto L22;
        Slog.i(TAG, "Window token reassigned to default display");
        return new Pair(token2, dc2);
    L22:
        return new Pair(null, null);
    L8:
        windowTokenToFind = attrs.token;
        goto L10
    L5:
        return new Pair(null, null);
    }

    public void setAutoFocusedPkg(String owningPackage) {
        Slog.i(TAG, "setAutoFocusedPkg, owningPackage=" + owningPackage);
        this.mAutoFocusedPkg = owningPackage;
    }

    public void onInputMethodShown(boolean shown) {
        this.mIsInputMethodShown = shown;
        RemoteCallbackList<IObricInputMethodListener> r0 = this.mRemoteInputMethodListeners;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteInputMethodListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L13;
        if (shown == true) goto L21;
        this.mRemoteInputMethodListeners.getBroadcastItem(i).onInputMethodHidden();     // Catch: RemoteException -> L11 Throwable -> L16
    L12:
        i = i - 1;
        goto L6
    L21:
        this.mRemoteInputMethodListeners.getBroadcastItem(i).onInputMethodShown();     // Catch: RemoteException -> L11 Throwable -> L16
        goto L12
    L13:
        this.mRemoteInputMethodListeners.finishBroadcast();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public boolean showImeInAuto(IBinder windowToken, int selfReportedDisplayId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        InputTarget imeTarget = this.mWmService.getInputTargetFromWindowTokenLocked(windowToken);     // Catch: Throwable -> L20
        if (imeTarget != null) goto L9;
        Slog.e(TAG, "showImeInAuto: imeTarget is null");     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L9:
        this.mAutoFocusedWindowToken = windowToken;     // Catch: Throwable -> L20
        InsetsControlTarget controlTarget = imeTarget.getImeControlTarget();     // Catch: Throwable -> L20
        DisplayContent dc = this.mWmService.getObricExt().getAutoVirtualDisplayContent();     // Catch: Throwable -> L20
        if (dc != null) goto L12;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L12:
        if (selfReportedDisplayId != dc.getDisplayId()) goto L18;
        if (dc.getDisplayPolicy().getObricExt().setAutoImeShowing(true) == false) goto L18;
        dc.getInsetsStateController().notifyInsetsChanged();     // Catch: Throwable -> L20
        controlTarget.showInsets(WindowInsets.Type.ime(), true, autoImeToken());     // Catch: Throwable -> L20
        dc.setLayoutNeeded();     // Catch: Throwable -> L20
        dc.mWmService.mWindowPlacerLocked.requestTraversal();     // Catch: Throwable -> L20
        Slog.d(TAG, "AutoImeAnim: showImeInAuto! and the controlTarget is " + controlTarget);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    public void hideImeInAuto(int selfReportedDisplayId) {
        if (this.mAutoFocusedWindowToken == null) goto L6;
        hideImeInAuto(this.mAutoFocusedWindowToken, selfReportedDisplayId);
        return;
    }

    public void onAutoBlacklistAppOpen(String packageName) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onBlacklistAppOpen(packageName);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public boolean registerTaskStackListenerEx(IObricTaskStackListener listener) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteTaskStackListeners.register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void reportError(final WindowProcessController app, final int error) {
        this.mWmService.mH.post(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda9(this, app, error));
    }

    private /* synthetic */ void lambda$reportError$7(final WindowProcessController app, int error) {
        Slog.i(TAG, "reportError, proc=" + app + ", error=" + error);
        final Task[] finishedTask = new Task[1];
        WindowManagerGlobalLock r2 = this.mWmService.mGlobalLock;
        monitor-enter(r2);
        final Task focusedRootTask = this.mWmService.mRoot.getTopDisplayFocusedRootTask();     // Catch: Throwable -> L10
        this.mWmService.mRoot.forAllLeafTasks(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda1(finishedTask, focusedRootTask, app), true);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (finishedTask[0] == null) goto L15;
        int taskid = finishedTask[0].mTaskId;
        reportErrorToListener(taskid, error);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void lambda$reportError$6(Task[] finishedTask, Task focusedRootTask, WindowProcessController app, Task leafTask) {
        if (finishedTask[0] == null) goto L5;
    L9:
        boolean recordTopOrVisible = false;
    L11:
        if (leafTask.topRunningActivity() != null) goto L13;
        return;
    L13:
        if (leafTask.topRunningActivity().app != app) goto L18;
        if (recordTopOrVisible == false) goto L19;
        finishedTask[0] = leafTask;
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (focusedRootTask != leafTask.getRootTask()) goto L7;
    L8:
        recordTopOrVisible = true;
        goto L11
    L7:
        if (leafTask.isVisibleRequested() == false) goto L9;
        goto L8
    }

    public void reportErrorToListener(int taskid, int error) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onReportError(taskid, error);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void tryToMuteDelay(Long delay) {
        this.mWmService.mH.postDelayed(this.mMuteRunnable, delay.longValue());
    }

    public void tryToMute(boolean shouldMute) {
        if (ObricPermissionCheckHelper.isSystemApp(this.mWmService.mContext, Binder.getCallingUid()) == true) goto L6;
        Slog.e(TAG, "tryToMute: only system app can mute");
        return;
    L6:
        this.mWmService.mH.removeCallbacks(this.mMuteRunnable);
        if (shouldMute == true) goto L10;
        this.mWmService.mAtmService.getObricExt().updateMuteStatus(false);
        return;
    L10:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        this.mWmService.mAtmService.getObricExt().updateMutePackageLocked();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.mWmService.mAtmService.getObricExt().updateMuteStatus(true);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean unregisterTaskStackListenerEx(IObricTaskStackListener listener) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteTaskStackListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean onWindowSecureChanged(DisplayContent displayContent, boolean hasSecureWindow, boolean newWindowSecure) {
        if (hasSecureWindow != newWindowSecure) goto L5;
        return hasSecureWindow;
    L5:
        if (this.mRemoteDisplayInfoListeners.getRegisteredCallbackCount() != 0) goto L7;
        return hasSecureWindow;
    L7:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        if (newWindowSecure == false) goto L41;
        boolean secure = true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L36
        Slog.d(TAG, "update secure? : " + secure);
        RemoteCallbackList<IObricDisplayInfoCallback> r3 = this.mRemoteDisplayInfoListeners;
        monitor-enter(r3);
    L33:
        th = move-exception;
        throw th;
    L24:
        int i = this.mRemoteDisplayInfoListeners.beginBroadcast() - 1;
    L25:
        if (i < 0) goto L30;
        this.mRemoteDisplayInfoListeners.getBroadcastItem(i).onDisplaySecureChanged(displayContent.getDisplayId(), secure);     // Catch: RemoteException -> L28 Throwable -> L33
    L29:
        i = i - 1;
        goto L25
    L30:
        this.mRemoteDisplayInfoListeners.finishBroadcast();     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Throwable -> L33
        return secure;
    L41:
        WindowState secureWindow = displayContent.getWindow(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda0());     // Catch: Throwable -> L36
        Slog.d(TAG, "the secure window is " + secureWindow);     // Catch: Throwable -> L36
        if (secureWindow == null) goto L15;
        boolean secure2 = true;
    L16:
        if (secure2 == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L36
        return true;
    L19:
        secure = secure2;
        goto L20
    L15:
        secure2 = false;
    L36:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$onWindowSecureChanged$8(WindowState w) {
        if (w.isOnScreen() == true) goto L5;
    L9:
        return false;
    L5:
        if (w.isSecureLocked() == false) goto L9;
        if (w.mWinAnimator.getShown() == false) goto L9;
        return true;
    }

    public void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo info) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onTaskRemovedBeforeFocusChanged(info);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void onTaskToBackground(ActivityManager.RunningTaskInfo info) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onTaskToBackground(info);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void onDisplaySecureChanged(int displayId, boolean secure) {
        RemoteCallbackList<IObricTaskStackListener> r0 = this.mRemoteTaskStackListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteTaskStackListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteTaskStackListeners.getBroadcastItem(i).onDisplaySecureChanged(displayId, secure);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteTaskStackListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public IObricWindowManagerInternal getLocalService() {
        return this.mObricWindowManagerInternal;
    }

    public ActivityManager.RunningTaskInfo getCurrentTaskInfo(int displayId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (ObricPermissionCheckHelper.isSystemApp(this.mWmService.mContext, Binder.getCallingUid()) == true) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return null;
    L9:
        if (this.mWmService.mRoot.getDisplayContent(displayId) != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return null;
    L12:
        Task task = this.mWmService.mRoot.getDisplayContent(displayId).getTopRootTask();     // Catch: Throwable -> L19
        if (task != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L19
        return null;
    L16:
        ActivityManager.RunningTaskInfo r2 = task.getTaskInfo();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r2;
    }

    public boolean registerDisplayInfoListenerEx(IObricDisplayInfoCallback listener) {
        RemoteCallbackList<IObricDisplayInfoCallback> r0 = this.mRemoteDisplayInfoListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteDisplayInfoListeners.register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean unregisterObricDisplayInfoCallback(IObricDisplayInfoCallback listener) {
        RemoteCallbackList<IObricDisplayInfoCallback> r0 = this.mRemoteDisplayInfoListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteDisplayInfoListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int hasInputMethodClientFocus(int displayId) {
        if (this.mWmService.mRoot.getDisplayContent(displayId) != null) goto L5;
        return -5;
    L5:
        if (this.mWmService.mRoot.getDisplayContent(displayId).getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L7;
        return -5;
    L7:
        if (shouldDispatchToAutoDisplay() == false) goto L10;
        return 0;
    L10:
        Slog.d(TAG, "in calluser return ime ok");
        return -4;
    }

    public boolean requestTopActivityAssistData(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) {
        return this.mViewHierarchyDumpController.requestTopActivityAssistData(requestId, displayId, receiver);
    }

    private boolean findAssistantKeyguardFlag(WindowState window) {
        WindowState currentWindow = window;
    L3:
        if (currentWindow == null) goto L9;
        if ((currentWindow.mAttrs.getObricExt().getPrivateFlags() & 2) != 0) goto L6;
        currentWindow = currentWindow.getParentWindow();
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private ObricInputMonitor findInputMonitorWithParent(WindowState window) {
        WindowState currentWindow = window;
    L4:
        if (currentWindow == null) goto L10;
        ObricWindowStateImpl obricExt = (ObricWindowStateImpl) currentWindow.getObricExt();
        ObricInputMonitor manager = obricExt.getInputMonitorManager();
        if (manager != null) goto L7;
        currentWindow = currentWindow.getParentWindow();
        goto L4
    L7:
        Slog.d(TAG, "Window has InputMonitor: " + currentWindow.getOwningPackage());
        return manager;
    L10:
        Slog.d(TAG, "Window has no InputMonitor: " + window.getOwningPackage());
        return null;
    }

    public void onWindowRemoved(WindowState window) {
        if (window != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        ObricWindowStateImpl obricExt = (ObricWindowStateImpl) window.getObricExt();     // Catch: Throwable -> L14
        ObricInputMonitor manager = obricExt.getInputMonitorManager();     // Catch: Throwable -> L14
        if (manager == null) goto L12;
        manager.unregisterInputMonitor();     // Catch: Throwable -> L14
        obricExt.setInputMonitorManager(null);     // Catch: Throwable -> L14
        if (this.mActiveGestureMonitor != manager) goto L11;
        this.mActiveGestureMonitor = null;     // Catch: Throwable -> L14
    L11:
        Slog.d(TAG, "Cleaned up InputMonitor for removed window: " + window.getOwningPackage());     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void onWindowLostFocus(WindowState window) {
        if (window != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        ObricInputMonitor manager = findInputMonitorWithParent(window);     // Catch: Throwable -> L30
        if (manager == null) goto L11;
        Slog.d(TAG, "Window lost focus, unregistering InputMonitor: " + window.getOwningPackage());     // Catch: Throwable -> L30
        manager.unregisterInputMonitor();     // Catch: Throwable -> L30
        if (this.mActiveGestureMonitor != manager) goto L11;
        this.mActiveGestureMonitor = null;     // Catch: Throwable -> L30
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L30
        if (findAssistantKeyguardFlag(window) == true) goto L15;
        return;
    L15:
        RemoteCallbackList<IAssistantWindowFocusStatusListener> r1 = this.mRemoteAssistantWindowFocusStatusListeners;
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L18:
        int i = this.mRemoteAssistantWindowFocusStatusListeners.beginBroadcast() - 1;
    L19:
        if (i < 0) goto L24;
        this.mRemoteAssistantWindowFocusStatusListeners.getBroadcastItem(i).onAssistantWindowFocusStatusChanged(false);     // Catch: RemoteException -> L22 Throwable -> L27
    L23:
        i = i - 1;
        goto L19
    L24:
        this.mRemoteAssistantWindowFocusStatusListeners.finishBroadcast();     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public void onWindowGainedFocus(WindowState window) {
        if (window != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        ObricInputMonitor manager = findInputMonitorWithParent(window);     // Catch: Throwable -> L36
        if (this.mActiveGestureMonitor != null) goto L9;
    L13:
        if (manager != null) goto L15;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L36
        if (findAssistantKeyguardFlag(window) == true) goto L21;
        return;
    L21:
        RemoteCallbackList<IAssistantWindowFocusStatusListener> r1 = this.mRemoteAssistantWindowFocusStatusListeners;
        monitor-enter(r1);
    L33:
        th = move-exception;
        throw th;
    L24:
        int i = this.mRemoteAssistantWindowFocusStatusListeners.beginBroadcast() - 1;
    L25:
        if (i < 0) goto L30;
        this.mRemoteAssistantWindowFocusStatusListeners.getBroadcastItem(i).onAssistantWindowFocusStatusChanged(true);     // Catch: RemoteException -> L28 Throwable -> L33
    L29:
        i = i - 1;
        goto L25
    L30:
        this.mRemoteAssistantWindowFocusStatusListeners.finishBroadcast();     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        return;
    L15:
        if (window.getDisplayId() != 0) goto L17;
        Slog.d(TAG, "Window gained focus, re-registering InputMonitor: " + window.getOwningPackage());     // Catch: Throwable -> L36
        manager.registerInputMonitor();     // Catch: Throwable -> L36
        this.mActiveGestureMonitor = manager;     // Catch: Throwable -> L36
        goto L17
    L9:
        if (this.mActiveGestureMonitor == manager) goto L13;
        if (window.getDisplayId() != 0) goto L13;
        this.mActiveGestureMonitor.unregisterInputMonitor();     // Catch: Throwable -> L36
        this.mActiveGestureMonitor = null;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    public void onDisplayCaptured(int displayId) {
        int agentUid = this.mWmService.mAtmService.getObricExt().getRobotsAgentUid();
        if (agentUid != 0) goto L7;
        Slog.w(TAG, "onDisplayCaptured: agentUid is null");
        return;
    L7:
        if (Binder.getCallingUid() == agentUid) goto L10;
        Slog.w(TAG, "onDisplayCaptured: agentUid is not match");
        return;
    L10:
        if (displayId != 0) goto L12;
        return;
    L12:
        if (displayId != getAutoDisplayId()) goto L30;
        WindowManagerGlobalLock r2 = this.mWmService.mGlobalLock;
        monitor-enter(r2);
        String targetPackage = this.mAutoFocusedPkg;     // Catch: Throwable -> L24
        DisplayContent dc = getAutoVirtualDisplayContent();     // Catch: Throwable -> L24
        if (dc != null) goto L18;
    L20:
        String targetActivity = "";
    L21:
        this.mWmService.mAtmService.getObricExt().writeRobotsLog(targetPackage, targetActivity, "SCREENSHOT", String.valueOf(System.currentTimeMillis()), null);     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        return;
    L18:
        if (dc.getTopMostActivity() == null) goto L20;
        String targetActivity2 = dc.getTopMostActivity().toString();     // Catch: Throwable -> L24
        targetActivity = targetActivity2;
    L24:
        th = move-exception;
        throw th;
    }

    public void notifyWindowVisibleChanged(WindowState win, boolean winVisible) {
        this.mWmService.mPolicy.getObricExt().handleWindowVisibleChanged(win.getWindowTag().toString(), winVisible);
    }

    private boolean hideImeInAuto(IBinder windowToken, int selfReportedDisplayId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        InputTarget imeTarget = this.mWmService.getInputTargetFromWindowTokenLocked(windowToken);     // Catch: Throwable -> L20
        this.mAutoFocusedWindowToken = null;     // Catch: Throwable -> L20
        if (imeTarget != null) goto L9;
        Slog.e(TAG, "hideImeInAuto: imeTarget is null");     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L9:
        InsetsControlTarget controlTarget = imeTarget.getImeControlTarget();     // Catch: Throwable -> L20
        DisplayContent dc = this.mWmService.getObricExt().getAutoVirtualDisplayContent();     // Catch: Throwable -> L20
        if (dc != null) goto L12;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return false;
    L12:
        if (selfReportedDisplayId != dc.getDisplayId()) goto L18;
        if (dc.getDisplayPolicy().getObricExt().setAutoImeShowing(false) == false) goto L18;
        dc.getInsetsStateController().notifyInsetsChanged();     // Catch: Throwable -> L20
        controlTarget.hideInsets(WindowInsets.Type.ime(), true, autoImeToken());     // Catch: Throwable -> L20
        dc.setLayoutNeeded();     // Catch: Throwable -> L20
        dc.mWmService.mWindowPlacerLocked.requestTraversal();     // Catch: Throwable -> L20
        Slog.d(TAG, "AutoImeAnim: hideImeInAuto! and the controlTarget is " + controlTarget);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    private static ImeTracker.Token autoImeToken() {
        return new ImeTracker.Token(new Binder(), "AUTO_IME_TAG");
    }

    private boolean moveTaskToDisplayInnerLocked(int taskId, int displayId, boolean isTop) {
        Task task = this.mWmService.mRoot.anyTaskForId(taskId);
        if (task != null) goto L5;
        return false;
    L5:
        DisplayContent displayContent = this.mWmService.mRoot.getDisplayContent(displayId);
        if (displayContent != null) goto L8;
        return false;
    L8:
        this.mWmService.mRoot.moveRootTaskToDisplay(task.getRootTaskId(), displayId, isTop);
        this.mWmService.mRoot.refreshSecureSurfaceState();
        return true;
    }

    private int getCallingFocusedDisplayIdInner() {
        int callingUid = Binder.getCallingUid();
        WindowManagerGlobalLock r1 = this.mWmService.mGlobalLock;
        monitor-enter(r1);
        int i = this.mWmService.mRoot.getChildCount() - 1;     // Catch: Throwable -> L32
    L5:
        if (i < 0) goto L29;
        DisplayContent displayContent = this.mWmService.mRoot.getChildAt(i);     // Catch: Throwable -> L32
        if (displayContent.mCurrentFocus == null) goto L18;
        if (displayContent.mCurrentFocus.getOwningUid() != callingUid) goto L18;
        if (displayContent.mCurrentFocus.isVisible() == false) goto L18;
        if (displayContent.getDisplayId() == 0) goto L18;
        int r4 = displayContent.getDisplayId();     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        return r4;
    L18:
        if (displayContent.mFocusedApp == null) goto L28;
        if (displayContent.mFocusedApp.getUid() != callingUid) goto L28;
        if (displayContent.mFocusedApp.isVisible() == false) goto L28;
        if (displayContent.getDisplayId() == 0) goto L28;
        int r5 = displayContent.getDisplayId();     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        return r5;
    L28:
        i = i - 1;     // Catch: Throwable -> L32
        goto L5
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L32
        return 0;
    L32:
        th = move-exception;
        throw th;
    }

    private static boolean isAssistSourceDisplayPkgAllowed(String pkg) {
        if (pkg != null) goto L5;
        return false;
    L5:
        String[] r1 = ASSIST_SOURCE_DISPLAY_PKG_ALLOWLIST;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String allowed = r1[r3];
        if (allowed.equals(pkg) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private int getAllowlistedAssistSourceDisplayIdInner() {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        int autoDisplayId = getAutoDisplayId();     // Catch: Throwable -> L24
        int r2 = 0;
        if (autoDisplayId != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return 0;
    L8:
        Task task = this.mWmService.mAtmService.getObricExt().getTopDisplayFocusedRootTask(this.mWmService.mAtmService);     // Catch: Throwable -> L24
        if (task != null) goto L11;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return 0;
    L11:
        if (task.getDisplayId() != autoDisplayId) goto L22;
        if (task.realActivity == null) goto L16;
        String pkg = task.realActivity.getPackageName();     // Catch: Throwable -> L24
    L18:
        if (isAssistSourceDisplayPkgAllowed(pkg) == false) goto L20;
        r2 = autoDisplayId;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return r2;
    L16:
        pkg = task.getBasePackageName();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private boolean isOwningFocusedWindowOnDisplayInner(int uid, int pid, String packageName, String activityClassName, int displayId) {
        if (TextUtils.isEmpty(packageName) == true) goto L31;
        if (pid <= 0) goto L31;
        WindowManagerGlobalLock r7 = this.mWmService.mGlobalLock;
        monitor-enter(r7);
        DisplayContent displayContent = this.mWmService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L28
        if (displayContent != null) goto L12;
        monitor-exit(r7);     // Catch: Throwable -> L28
        return false;
    L12:
        WindowState focus = displayContent.mCurrentFocus;     // Catch: Throwable -> L28
        if (focus != null) goto L15;
    L26:
        monitor-exit(r7);     // Catch: Throwable -> L28
        return false;
    L15:
        if (focus.getOwningUid() != uid) goto L26;
        if (focus.getPid() != pid) goto L26;
        if (packageName.equals(focus.getOwningPackage()) == false) goto L26;
        if (focus.isVisible() == false) goto L26;
        boolean r2 = isUidPidPackageActivity(focus.getActivityRecord(), uid, pid, packageName, activityClassName);     // Catch: Throwable -> L28
        monitor-exit(r7);     // Catch: Throwable -> L28
        return r2;
    L28:
        th = move-exception;
        throw th;
    L31:
        return false;
    }

    private boolean isUidPidPackageActivity(ActivityRecord activity, int uid, int pid, String packageName, String activityClassName) {
        if (activity != null) goto L5;
    L21:
        return false;
    L5:
        if (activity.getUid() != uid) goto L21;
        if (activity.getPid() != pid) goto L21;
        if (packageName.equals(activity.packageName) == false) goto L21;
        if (TextUtils.isEmpty(activityClassName) == false) goto L15;
        return true;
    L15:
        if (activity.mActivityComponent != null) goto L17;
        return false;
    L17:
        if (activityClassName.equals(activity.mActivityComponent.getClassName()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isAssistWindow(WindowState window) {
        return findAssistantKeyguardFlag(window);
    }

    public boolean shouldBlockAddStartingWindow(ActivityRecord activityRecord) {
        if (activityRecord.getDisplayId() != 0) goto L6;
        return false;
    L6:
        boolean disable = activityRecord.getObricExtWindowContainer().inObricVirtualDisplay();
        if (disable == false) goto L9;
        Slog.d(TAG, "shouldBlockAddStartingWindow for obric virtual display: disable");
    L9:
        return disable;
    }

    public void requestScenePerception(Bundle bundle) {
        if (bundle == null) goto L5;
        final String packageName = bundle.getString("packageName");
        String sessionId = bundle.getString("sessionId");
        if (TextUtils.isEmpty(packageName) == true) goto L72;
        if (TextUtils.isEmpty(sessionId) == true) goto L72;
        if (hasSecureWindowInner(0) == false) goto L26;
        if (DEBUG == false) goto L18;
        Slog.i(TAG, "requestScenePerception fail: hasSecureWindowInner");
    L18:
        Bundle resultBundle = new Bundle();
        resultBundle.putString("sessionId", sessionId);
        resultBundle.putInt("state", 4);
        long identity = Binder.clearCallingIdentity();
        MemoryManagerProxy.reportScenePerceptionEvent(1, resultBundle);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(identity);
        return;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L26:
        if (DEBUG == false) goto L28;
        Slog.i(TAG, "requestScenePerception, packageName: " + packageName);
    L28:
        WindowManagerGlobalLock r6 = this.mWmService.mGlobalLock;
        monitor-enter(r6);
        ActivityRecord topActivity = null;
        final AtomicReference<Task> taskRef = new AtomicReference(null);     // Catch: Throwable -> L68
        DisplayContent dc = this.mWmService.getDefaultDisplayContentLocked();     // Catch: Throwable -> L68
        dc.getDefaultTaskDisplayArea().forAllTasks(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda7(taskRef, packageName));     // Catch: Throwable -> L68
        if (taskRef.get() == null) goto L33;
        topActivity = taskRef.get().topRunningActivity();     // Catch: Throwable -> L68
    L33:
        if (topActivity == null) goto L64;
        if (topActivity.isVisible() == false) goto L37;
    L39:
        WindowProcessController wpc = this.mWmService.mAtmService.getProcessController(topActivity.processName, topActivity.info.applicationInfo.uid);     // Catch: Throwable -> L68
        if (wpc == null) goto L59;
        if (wpc.hasThread() == false) goto L59;
        if (topActivity.token == null) goto L59;
        ScenePerceptionData scenePerceptionData = new ScenePerceptionData(sessionId, packageName);     // Catch: Exception -> L56 Throwable -> L68
        final long now = SystemClock.elapsedRealtime();     // Catch: Exception -> L56 Throwable -> L68
        final List<String> expiredSessionIds = new ArrayList();     // Catch: Exception -> L56 Throwable -> L68
        this.mScenePerceptionData.forEach(new ObricWindowManagerServiceImpl$$ExternalSyntheticLambda8(this, now, expiredSessionIds));     // Catch: Exception -> L56 Throwable -> L68
        this.mScenePerceptionData.put(sessionId, scenePerceptionData);     // Catch: Exception -> L56 Throwable -> L68
        wpc.getThread().doScenePerceptionAction(topActivity.token, 1, bundle);     // Catch: Exception -> L56 Throwable -> L68
        Iterator<String> r0 = expiredSessionIds.iterator();     // Catch: Exception -> L56 Throwable -> L68
    L47:
        if (r0.hasNext() == false) goto L61;
        String expiredSessionId = r0.next();     // Catch: Exception -> L56 Throwable -> L68
        Bundle expiredBundle = new Bundle();     // Catch: Exception -> L56 Throwable -> L68
        expiredBundle.putString("sessionId", expiredSessionId);     // Catch: Exception -> L56 Throwable -> L68
        Iterator<String> r17 = r0;
        expiredBundle.putInt("state", 3);     // Catch: Exception -> L56 Throwable -> L68
        long identity2 = Binder.clearCallingIdentity();     // Catch: Exception -> L56 Throwable -> L68
        MemoryManagerProxy.reportScenePerceptionEvent(1, expiredBundle);     // Catch: Throwable -> L52
        Binder.restoreCallingIdentity(identity2);     // Catch: Exception -> L56 Throwable -> L68
        r0 = r17;
    L52:
        th = move-exception;
        Binder.restoreCallingIdentity(identity2);     // Catch: Exception -> L56 Throwable -> L68
        throw th;     // Catch: Exception -> L56 Throwable -> L68
    L61:
        monitor-exit(r6);     // Catch: Throwable -> L68
        return;
    L56:
        e = move-exception;
        Slog.e(TAG, "requestScenePerception failed", e);     // Catch: Throwable -> L68
        this.mScenePerceptionData.remove(sessionId);     // Catch: Throwable -> L68
    L59:
        if (DEBUG == false) goto L61;
        Slog.e(TAG, "requestScenePerception: wpc is null or has not thread");     // Catch: Throwable -> L68
        goto L61
    L37:
        if (topActivity.shouldBeVisible() == true) goto L39;
    L64:
        if (DEBUG == false) goto L66;
        Slog.e(TAG, "requestScenePerception: topActivity is null or invisible");     // Catch: Throwable -> L68
    L66:
        monitor-exit(r6);     // Catch: Throwable -> L68
        return;
    L68:
        th = move-exception;
        throw th;
    L72:
        if (DEBUG == false) goto L84;
        Slog.e(TAG, "requestScenePerception: empty packageName or taskId or sessionId");
        return;
    L84:
        return;
    L5:
        if (DEBUG == false) goto L83;
        Slog.e(TAG, "requestScenePerception: input bundle is null");
        return;
    }

    static /* synthetic */ void lambda$requestScenePerception$9(AtomicReference taskRef, String packageName, Task task) {
        if (taskRef.get() == null) goto L5;
        return;
    L5:
        if (packageName.equals(task.getBasePackageName()) == true) goto L7;
        return;
    L7:
        if (task.isVisible() == false) goto L9;
    L10:
        taskRef.set(task);
        return;
    L9:
        if (task.isVisibleRequested() == true) goto L10;
    }

    private /* synthetic */ void lambda$requestScenePerception$10(long now, List expiredSessionIds, String key, ScenePerceptionData data) {
        if ((now - data.mCreateTime) > SCENE_PERCEPTION_TIMEOUT_MS) goto L5;
        return;
    L5:
        if (this.mScenePerceptionData.remove(key, data) == false) goto L9;
        expiredSessionIds.add(key);
        return;
    }

    public void reportScenePerceptionEvent(int type, Bundle bundle, int callingUid) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "reportScenePerceptionEvent: type=" + type);
    L5:
        switch(type) {
            case 1: goto L15;
            default: goto L18;
        };
    L15:
        reportScenePerceptionResult(bundle, callingUid);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        if (DEBUG == false) goto L14;
        Slog.e(TAG, "reportScenePerceptionEvent failed", e);
        return;
    L14:
        return;
    }

    private void reportScenePerceptionResult(Bundle result, int callingUid) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "reportScenePerceptionResult");
    L5:
        if (result == null) goto L7;
        String sessionId = result.getString("sessionId");
        if (sessionId == null) goto L13;
        ScenePerceptionData scenePerceptionData = this.mScenePerceptionData.remove(sessionId);
        if (scenePerceptionData != null) goto L23;
        if (DEBUG == false) goto L41;
        Slog.i(TAG, "reportScenePerceptionResult, sessionId not found in mScenePerceptionData");
        return;
    L41:
        return;
    L23:
        if (callingUid != MAX_REMOVED_OBRIC_VIRTUAL_DISPLAY_IDS) goto L25;
    L30:
        long identity = Binder.clearCallingIdentity();
        MemoryManagerProxy.reportScenePerceptionEvent(1, result);     // Catch: Throwable -> L34
        Binder.restoreCallingIdentity(identity);
        return;
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L25:
        if (ObricPermissionCheckHelper.isSameApp(this.mWmService.mContext, callingUid, scenePerceptionData.mPackageName) == true) goto L30;
        if (DEBUG == false) goto L42;
        Slog.i(TAG, "reportScenePerceptionResult, different packageName");
        return;
    L42:
        return;
    L13:
        if (DEBUG == false) goto L40;
        Slog.i(TAG, "reportScenePerceptionResult, null sessionId");
        return;
    L40:
        return;
    L7:
        if (DEBUG == false) goto L39;
        Slog.i(TAG, "reportScenePerceptionResult: result bundle is null");
        return;
    }

    public void recordObricVirtualDisplayRemoved(int displayId) {
        if (this.mRemovedObricVirtualDisplayIds.size() <= MAX_REMOVED_OBRIC_VIRTUAL_DISPLAY_IDS) goto L5;
        this.mRemovedObricVirtualDisplayIds.clear();
    L5:
        this.mRemovedObricVirtualDisplayIds.add(Integer.valueOf(displayId));
        Slog.d(TAG, "recordObricVirtualDisplayRemoved: displayId=" + displayId + ", size=" + this.mRemovedObricVirtualDisplayIds.size());
    }

    public boolean isRemovedObricVirtualDisplayId(int displayId) {
        return this.mRemovedObricVirtualDisplayIds.contains(Integer.valueOf(displayId));
    }
}
