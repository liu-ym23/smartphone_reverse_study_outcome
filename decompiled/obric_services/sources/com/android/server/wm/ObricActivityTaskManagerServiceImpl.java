package com.android.server.wm;

import android.app.ActivityOptions;
import android.app.IObricActivitySwitchListener;
import android.app.IObricActivityTaskManager;
import android.app.IObricAppSwitchListener;
import android.app.IObricBackNavigationListener;
import android.app.assist.AssistStructure;
import android.content.ComponentName;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.android.server.LocalServices;
import com.android.server.appop.AppOpsService;
import com.android.server.input.IObricInputManagerService;
import com.android.server.input.InputManagerInternal;
import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import com.obric.internal.app.ObricAssistUtils;
import com.obric.security.audit.SecurityAuditManager;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ObricActivityTaskManagerServiceImpl implements IObricActivityTaskManagerService {
    public static final String ACTION_ARGS = "action_args";
    public static final String ACTION_KEY_EVENT = "KEY";
    public static final String ACTION_TOUCH_DOWN_EVENT = "TOUCH_DOWN";
    public static final String ACTION_TOUCH_UP_EVENT = "TOUCH_UP";
    public static final String ACTION_TYPE = "action_type";
    public static final String AGENT_NAME = "agent_name";
    public static final String AGENT_UUID = "agent_uuid";
    private static final long APP_BACKGROUND_DEBOUNCE_MS = 500;
    public static final String LOG_SOURCE = "log_source";
    public static final String LOG_SOURCE_FRAMEWORK = "framework";
    public static final String PACKAGE_SHA256 = "package_sha256";
    private static final String TAG = "ObricActivityTaskManagerServiceImpl";
    public static final String TARGET_ACTIVITY = "target_activity";
    public static final String TARGET_PACKAGE = "target_package";
    public static final String TIMESTAMP = "timestamp";
    private String agentName;
    private String agentPackageName;
    private int agentUid;
    private String agentuuid;
    private AppOpsService mAppOpsService;
    private final Object mAutoActionLock;
    private String[] mAutoDisablePackages;
    private final ActivityTaskManagerService mBase;
    private final Object mClickViewTreeControllerLock;
    private volatile ObricClickViewTreeInputController mClickViewTreeInputController;
    private IObricActivityTaskManager mObricActivityTaskManager;
    private final RemoteCallbackList<IObricActivitySwitchListener> mRemoteActivitySwitchListeners;
    private final RemoteCallbackList<IObricAppSwitchListener> mRemoteAppSwitchListeners;
    private final RemoteCallbackList<IObricBackNavigationListener> mRemoteBackNavigationInVritualDisplayListeners;
    private final RemoteCallbackList<IObricBackNavigationListener> mRemoteBackNavigationListeners;
    private final Map<String, Runnable> mRunnableMap;
    private String pkgsha256;
    private String sLastForegroundPackage;

    protected class ObricActivityTaskManagerImpl extends IObricActivityTaskManager.Stub {
        final /* synthetic */ ObricActivityTaskManagerServiceImpl this$0;

        protected ObricActivityTaskManagerImpl(ObricActivityTaskManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public boolean registerAppSwitchListener(IObricAppSwitchListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricActivityTaskManagerServiceImpl.m33$$Nest$fgetmRemoteAppSwitchListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricActivityTaskManagerServiceImpl.m33$$Nest$fgetmRemoteAppSwitchListeners(this.this$0).register(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean unregisterAppSwitchListener(IObricAppSwitchListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricActivityTaskManagerServiceImpl.m33$$Nest$fgetmRemoteAppSwitchListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricActivityTaskManagerServiceImpl.m33$$Nest$fgetmRemoteAppSwitchListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean registerActivitySwitchListener(IObricActivitySwitchListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricActivityTaskManagerServiceImpl.m32$$Nest$fgetmRemoteActivitySwitchListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricActivityTaskManagerServiceImpl.m32$$Nest$fgetmRemoteActivitySwitchListeners(this.this$0).register(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean unregisterActivitySwitchListener(IObricActivitySwitchListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricActivityTaskManagerServiceImpl.m32$$Nest$fgetmRemoteActivitySwitchListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricActivityTaskManagerServiceImpl.m32$$Nest$fgetmRemoteActivitySwitchListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean updateAgentInfo(Bundle bundle) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == true) goto L5;
            return false;
        L5:
            ObricActivityTaskManagerServiceImpl.m40$$Nest$fputpkgsha256(this.this$0, null);
            ObricActivityTaskManagerServiceImpl.m39$$Nest$fputagentuuid(this.this$0, null);
            ObricActivityTaskManagerServiceImpl.m36$$Nest$fputagentName(this.this$0, null);
            ObricActivityTaskManagerServiceImpl.m37$$Nest$fputagentPackageName(this.this$0, null);
            ObricActivityTaskManagerServiceImpl.m38$$Nest$fputagentUid(this.this$0, 0);
            ObricActivityTaskManagerServiceImpl.m40$$Nest$fputpkgsha256(this.this$0, bundle.getString(ObricActivityTaskManagerServiceImpl.PACKAGE_SHA256));     // Catch: Exception -> L9
            ObricActivityTaskManagerServiceImpl.m39$$Nest$fputagentuuid(this.this$0, bundle.getString(ObricActivityTaskManagerServiceImpl.AGENT_UUID));     // Catch: Exception -> L9
            ObricActivityTaskManagerServiceImpl.m36$$Nest$fputagentName(this.this$0, bundle.getString(ObricActivityTaskManagerServiceImpl.AGENT_NAME));     // Catch: Exception -> L9
            ObricActivityTaskManagerServiceImpl.m37$$Nest$fputagentPackageName(this.this$0, bundle.getString("package_name"));     // Catch: Exception -> L9
            ObricActivityTaskManagerServiceImpl.m38$$Nest$fputagentUid(this.this$0, bundle.getInt("uid"));     // Catch: Exception -> L9
            return true;
        L9:
            e = move-exception;
            Slog.e(ObricActivityTaskManagerServiceImpl.TAG, "updateAgentInfo: " + e.getMessage());
            return false;
        }

        public void reportClickViewTreeRecord(String eventId, String fingerprint, Bundle record, AssistStructure structure) {
            if (record != null) goto L5;
            return;
        L5:
            int callingUid = Binder.getCallingUid();
            ObricClickViewTreeInputController controller = ObricActivityTaskManagerServiceImpl.m42$$Nest$mgetClickViewTreeInputController(this.this$0);     // Catch: Exception -> L24
            if (controller.allowReport(callingUid) == true) goto L10;
            return;
        L10:
            if (ObricActivityTaskManagerServiceImpl.m31$$Nest$fgetmBase(this.this$0).mWindowManager.getObricExt().isUidRunningOnAutoActionDisplay(callingUid) == false) goto L12;
            String clickClassification = record.getString("obric.click_viewtree.click_classification");     // Catch: Exception -> L24
            if (structure == null) goto L18;
            boolean r4 = true;
        L19:
            controller.logReportReceive(eventId, fingerprint, clickClassification, r4);     // Catch: Exception -> L24
            int upEventId = controller.matchUpEventId(fingerprint);     // Catch: Exception -> L24
            boolean imeReady = false;
            if (upEventId == (-1)) goto L22;
            imeReady = ObricActivityTaskManagerServiceImpl.m44$$Nest$mpushAssistStructureToInputListener(this.this$0, structure, upEventId, clickClassification);     // Catch: Exception -> L24
        L22:
            controller.logImeForward(upEventId, imeReady);     // Catch: Exception -> L24
            return;
        L18:
            r4 = false;
            goto L19
        L12:
            if (Build.IS_DEBUGGABLE == false) goto L28;
            Slog.w(ObricActivityTaskManagerServiceImpl.TAG, "ClickViewTree[SS_RECV] rejected uid=" + callingUid + " not owner of auto_action display");     // Catch: Exception -> L24
            return;
        L28:
            return;
        L24:
            e = move-exception;
            Slog.w(ObricActivityTaskManagerServiceImpl.TAG, "ClickViewTree[SS_RECV] failed", e);
        }
    }

    private final class PendingAppBackground implements Runnable {
        private final String mPackageName;
        final /* synthetic */ ObricActivityTaskManagerServiceImpl this$0;

        PendingAppBackground(ObricActivityTaskManagerServiceImpl r1, String packageName) {
            this.this$0 = r1;
            this.mPackageName = packageName;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ObricActivityTaskManagerServiceImpl.m34$$Nest$fgetmRunnableMap(this.this$0).remove(this.mPackageName, this) == true) goto L6;
            return;
        L6:
            if (this.mPackageName.equals(ObricActivityTaskManagerServiceImpl.m35$$Nest$fgetsLastForegroundPackage(this.this$0)) == false) goto L8;
            ObricActivityTaskManagerServiceImpl.m41$$Nest$fputsLastForegroundPackage(this.this$0, null);
        L8:
            ObricActivityTaskManagerServiceImpl.m43$$Nest$monAppBackground(this.this$0, this.mPackageName);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-n0S__HBYAvKCMC3ZY7uw5w5knQ, reason: not valid java name */
    public static /* synthetic */ void m30$r8$lambda$n0S__HBYAvKCMC3ZY7uw5w5knQ(ObricActivityTaskManagerServiceImpl r0) {
        r0.lambda$reportKeyEventOnAutoDisplay$3();
    }

    public static /* synthetic */ boolean $r8$lambda$HDUIHj5waCjTSfuoGFIPrfGFVAQ(ObricActivityTaskManagerServiceImpl r0, int r1, ActivityRecord r2) {
        return r0.lambda$cleanupStaleAutoActionSecondaryHomeExceptDisplay$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$I1lIz7NGMwx3xRj8mSQURSkwpVk(ObricActivityTaskManagerServiceImpl r0) {
        r0.lambda$reportKeyEventOnAutoDisplay$4();
    }

    public static /* synthetic */ void $r8$lambda$dknXrdja8Kh_wBUyaNLYbkNdQkA(ObricActivityTaskManagerServiceImpl r0, int r1) {
        r0.pushClickTimeoutToInputListener(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$snTD40BJekTMGhoZvvL9ai8TUvQ(ObricActivityTaskManagerServiceImpl r0, int r1, ActivityRecord r2) {
        return r0.lambda$cleanupAutoActionSecondaryHomeOnDisplay$1(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerService m31$$Nest$fgetmBase(ObricActivityTaskManagerServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteActivitySwitchListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m32$$Nest$fgetmRemoteActivitySwitchListeners(ObricActivityTaskManagerServiceImpl r0) {
        return r0.mRemoteActivitySwitchListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteAppSwitchListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m33$$Nest$fgetmRemoteAppSwitchListeners(ObricActivityTaskManagerServiceImpl r0) {
        return r0.mRemoteAppSwitchListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunnableMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m34$$Nest$fgetmRunnableMap(ObricActivityTaskManagerServiceImpl r0) {
        return r0.mRunnableMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetsLastForegroundPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m35$$Nest$fgetsLastForegroundPackage(ObricActivityTaskManagerServiceImpl r0) {
        return r0.sLastForegroundPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fputagentName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m36$$Nest$fputagentName(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.agentName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputagentPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m37$$Nest$fputagentPackageName(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.agentPackageName = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputagentUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m38$$Nest$fputagentUid(ObricActivityTaskManagerServiceImpl r0, int r1) {
        r0.agentUid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputagentuuid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m39$$Nest$fputagentuuid(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.agentuuid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputpkgsha256, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m40$$Nest$fputpkgsha256(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.pkgsha256 = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputsLastForegroundPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m41$$Nest$fputsLastForegroundPackage(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.sLastForegroundPackage = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetClickViewTreeInputController, reason: not valid java name */
    static /* bridge */ /* synthetic */ ObricClickViewTreeInputController m42$$Nest$mgetClickViewTreeInputController(ObricActivityTaskManagerServiceImpl r0) {
        return r0.getClickViewTreeInputController();
    }

    /* JADX INFO: renamed from: -$$Nest$monAppBackground, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m43$$Nest$monAppBackground(ObricActivityTaskManagerServiceImpl r0, String r1) {
        r0.onAppBackground(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpushAssistStructureToInputListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m44$$Nest$mpushAssistStructureToInputListener(ObricActivityTaskManagerServiceImpl r0, AssistStructure r1, int r2, String r3) {
        return r0.pushAssistStructureToInputListener(r1, r2, r3);
    }

    public ObricActivityTaskManagerServiceImpl(ActivityTaskManagerService service) {
        this.mRemoteBackNavigationInVritualDisplayListeners = new RemoteCallbackList();
        this.mRemoteBackNavigationListeners = new RemoteCallbackList();
        this.mRemoteAppSwitchListeners = new RemoteCallbackList();
        this.mRemoteActivitySwitchListeners = new RemoteCallbackList();
        Objects.requireNonNull(this);
        this.mObricActivityTaskManager = new ObricActivityTaskManagerImpl(this);
        this.mClickViewTreeControllerLock = new Object();
        this.mAutoDisablePackages = new String[0];
        this.mAutoActionLock = new Object();
        this.mRunnableMap = new ConcurrentHashMap();
        this.sLastForegroundPackage = null;
        this.pkgsha256 = null;
        this.agentuuid = null;
        this.agentName = null;
        this.agentPackageName = null;
        this.agentUid = 0;
        this.mBase = service;
    }

    private ObricClickViewTreeInputController getClickViewTreeInputController() {
        ObricClickViewTreeInputController controller = this.mClickViewTreeInputController;
        if (controller != null) goto L14;
        Object r1 = this.mClickViewTreeControllerLock;
        monitor-enter(r1);
        controller = this.mClickViewTreeInputController;     // Catch: Throwable -> L11
        if (controller != null) goto L9;
        controller = new ObricClickViewTreeInputController(new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda5(this));     // Catch: Throwable -> L11
        this.mClickViewTreeInputController = controller;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return controller;
    }

    public void updateMutePackageLocked() {
        DisplayContent dc = this.mBase.mWindowManager.getObricExt().getAutoVirtualDisplayContent();
        if (dc != null) goto L5;
        return;
    L5:
        ActivityRecord topActivity = dc.getTopActivity(false, false);
        if (topActivity != null) goto L8;
        return;
    L8:
        updateMutePackage(topActivity.getUid(), topActivity.packageName, topActivity.getActivityType());
    }

    public void setAppops(AppOpsService appOpsService) {
        this.mAppOpsService = appOpsService;
    }

    public void updateMuteStatus(boolean shouldMute) {
        if (this.mAppOpsService != null) goto L6;
        Slog.w(TAG, "updateMuteStatus. mService is null");
        return;
    L6:
        this.mAppOpsService.getObricExt().updateMuteStatus(shouldMute);
    }

    public Task getTopDisplayFocusedRootTask(ActivityTaskManagerService service) {
        return getTopNoneAssistDisplayedRootTask();
    }

    private Task getTopNoneAssistDisplayedRootTask() {
        final Task[] foundTask = new Task[1];
        this.mBase.mRootWindowContainer.forAllTasks(new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda0(foundTask));
        return foundTask[0];
    }

    static /* synthetic */ boolean lambda$getTopNoneAssistDisplayedRootTask$0(Task[] foundTask, Task rootTask) {
        if (rootTask.realActivity == null) goto L10;
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(rootTask.realActivity.getPackageName()) == false) goto L10;
        if (ObricAssistUtils.containsAssistantSpecialPage(rootTask.realActivity.getClassName()) == true) goto L10;
        return false;
    L10:
        if (rootTask.getWindowingMode() != 5) goto L12;
    L19:
        return false;
    L12:
        if (rootTask.getWindowingMode() == 2) goto L19;
        if (rootTask.isFocusableAndVisible() == false) goto L18;
        foundTask[0] = rootTask;
        return true;
    L18:
        return false;
    }

    public boolean isAppBlockedByAuto(String packageName) {
        Object r0 = this.mAutoActionLock;
        monitor-enter(r0);
        boolean r1 = Arrays.asList(this.mAutoDisablePackages).contains(packageName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addDisablePackage(String[] packageName) {
        if (packageName != null) goto L5;
        Slog.e(TAG, "addDisablePackage. packageName is null");
        return;
    L5:
        Object r0 = this.mAutoActionLock;
        monitor-enter(r0);
        this.mAutoDisablePackages = packageName;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean registerBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        RemoteCallbackList<IObricBackNavigationListener> r0 = this.mRemoteBackNavigationInVritualDisplayListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteBackNavigationInVritualDisplayListeners.register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean unregisterBackNavigationInVirtualDisplayListenerEx(IObricBackNavigationListener listener) {
        RemoteCallbackList<IObricBackNavigationListener> r0 = this.mRemoteBackNavigationInVritualDisplayListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteBackNavigationInVritualDisplayListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean registerBackNavigationListener(IObricBackNavigationListener listener) {
        RemoteCallbackList<IObricBackNavigationListener> r0 = this.mRemoteBackNavigationListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteBackNavigationListeners.register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean unregisterBackNavigationListener(IObricBackNavigationListener listener) {
        RemoteCallbackList<IObricBackNavigationListener> r0 = this.mRemoteBackNavigationListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteBackNavigationListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyBackNavigationStarted(RemoteCallbackList<IObricBackNavigationListener> listener) {
        monitor-enter(listener);
    L13:
        th = move-exception;
        throw th;
    L4:
        int i = listener.beginBroadcast() - 1;
    L5:
        if (i < 0) goto L10;
        listener.getBroadcastItem(i).onBackNavigationStarted();     // Catch: RemoteException -> L8 Throwable -> L13
    L9:
        i = i - 1;
        goto L5
    L10:
        listener.finishBroadcast();     // Catch: Throwable -> L13
        monitor-exit(listener);     // Catch: Throwable -> L13
    }

    private void notifyBackNavigationDone(RemoteCallbackList<IObricBackNavigationListener> listener) {
        monitor-enter(listener);
    L13:
        th = move-exception;
        throw th;
    L4:
        int i = listener.beginBroadcast() - 1;
    L5:
        if (i < 0) goto L10;
        listener.getBroadcastItem(i).onBackNavigationDone();     // Catch: RemoteException -> L8 Throwable -> L13
    L9:
        i = i - 1;
        goto L5
    L10:
        listener.finishBroadcast();     // Catch: Throwable -> L13
        monitor-exit(listener);     // Catch: Throwable -> L13
    }

    public void onBackNavigationStarted(WindowState window) {
        notifyBackNavigationStarted(this.mRemoteBackNavigationListeners);
        if (window != null) goto L5;
        return;
    L5:
        if (window.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L9;
        Slog.d(TAG, "on back navigation started in obric virtual display");
        notifyBackNavigationStarted(this.mRemoteBackNavigationInVritualDisplayListeners);
        return;
    }

    public void onBackNavigationDone(WindowManagerService wms) {
        notifyBackNavigationDone(this.mRemoteBackNavigationListeners);
        WindowState window = wms.getFocusedWindowLocked();
        if (window != null) goto L9;
        Task currentTask = wms.mAtmService.getTopDisplayFocusedRootTask();
        if (currentTask == null) goto L7;
        WindowState r2 = currentTask.getWindow(new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda4());
    L8:
        window = r2;
        goto L9
    L7:
        r2 = null;
    L9:
        if (window != null) goto L11;
        return;
    L11:
        if (window.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L15;
        Slog.d(TAG, "on back navigation done in obric virtual display");
        notifyBackNavigationDone(this.mRemoteBackNavigationInVritualDisplayListeners);
        return;
    }

    public boolean filterTaskFromRecents(Task task) {
        if (task != null) goto L4;
        return false;
    L4:
        if (task.getObricExtWindowContainer().inObricVirtualDisplay() == true) goto L6;
        return false;
    L6:
        if (task.getTopResumedActivity() == null) goto L12;
        return true;
    L12:
        return false;
    }

    public void cleanupAutoActionSecondaryHomeOnDisplay(final int displayId) {
        if (canCleanupAutoActionSecondaryHome(displayId) == true) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mBase.mGlobalLock;
        monitor-enter(r0);
        removeMatchingAutoActionSecondaryHomeLocked(new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda6(this, displayId), "obric-clean-secondary-home-on-auto-action-display-removal");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$cleanupAutoActionSecondaryHomeOnDisplay$1(int displayId, ActivityRecord activity) {
        if (isCleanableAutoActionSecondaryHome(activity) == true) goto L5;
    L7:
        return false;
    L5:
        if (activity.getDisplayId() != displayId) goto L7;
        return true;
    }

    public void cleanupStaleAutoActionSecondaryHomeExceptDisplay(final int displayId) {
        if (canCleanupAutoActionSecondaryHome(displayId) == true) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mBase.mGlobalLock;
        monitor-enter(r0);
        removeMatchingAutoActionSecondaryHomeLocked(new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda1(this, displayId), "obric-clean-stale-secondary-home-before-auto-action-home-start");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ boolean lambda$cleanupStaleAutoActionSecondaryHomeExceptDisplay$2(int displayId, ActivityRecord activity) {
        if (isCleanableAutoActionSecondaryHome(activity) == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldCleanupStaleAutoActionDisplay(activity.getDisplayId(), displayId) == false) goto L7;
        return true;
    }

    private boolean canCleanupAutoActionSecondaryHome(int displayId) {
        if (displayId != 0) goto L4;
    L6:
        return false;
    L4:
        if (displayId == (-1)) goto L6;
        return true;
    }

    private void removeMatchingAutoActionSecondaryHomeLocked(Predicate<ActivityRecord> activityMatcher, String reason) {
        SparseArray<WindowProcessController> pidMap = this.mBase.mProcessMap.getPidMap();
        ArrayList<ActivityRecord> targets = new ArrayList();
        int i = pidMap.size() - 1;
    L3:
        if (i < 0) goto L14;
        WindowProcessController proc = pidMap.valueAt(i);
        if (proc == null) goto L13;
        ArrayList<ActivityRecord> activities = new ArrayList(proc.getActivities());
        int j = activities.size() - 1;
    L8:
        if (j < 0) goto L13;
        ActivityRecord activity = activities.get(j);
        if (activityMatcher.test(activity) == false) goto L12;
        targets.add(activity);
    L12:
        j = j - 1;
    L13:
        i = i - 1;
        goto L3
    L14:
        int i2 = targets.size();
        int i3 = i2 - 1;
    L15:
        if (i3 < 0) goto L17;
        removeAutoActionSecondaryHomeActivity(targets.get(i3), reason);
        i3 = i3 - 1;
        goto L15
    }

    private boolean isCleanableAutoActionSecondaryHome(ActivityRecord activity) {
        if (activity != null) goto L5;
    L16:
        return false;
    L5:
        if (activity.finishing == true) goto L16;
        if (activity.getDisplayId() == 0) goto L16;
        if (activity.getDisplayId() == (-1)) goto L16;
        if (activity.getActivityType() == 2) goto L15;
        return false;
    L15:
        return ObricAssistUtils.isSecondaryHomeIntent(activity.intent);
    }

    private boolean shouldCleanupStaleAutoActionDisplay(int activityDisplayId, int targetDisplayId) {
        if (activityDisplayId == targetDisplayId) goto L19;
        if (activityDisplayId == 0) goto L19;
        if (activityDisplayId == (-1)) goto L19;
        DisplayContent displayContent = this.mBase.mRootWindowContainer.getDisplayContent(activityDisplayId);
        if (displayContent == null) goto L18;
        if (displayContent.isRemoved() == true) goto L13;
        return false;
    L13:
        if (displayContent.getObricExtWindowContainer().inObricVirtualDisplay() == false) goto L21;
        return true;
    L21:
        return false;
    L18:
        return this.mBase.mWindowManager.getObricExt().isRemovedObricVirtualDisplayId(activityDisplayId);
    L19:
        return false;
    }

    private void removeAutoActionSecondaryHomeActivity(ActivityRecord activity, String reason) {
        if (activity != null) goto L4;
        return;
    L4:
        if (activity.finishing == true) goto L15;
        Task task = activity.getTask();
        if (task != null) goto L9;
    L11:
        activity.destroyIfPossible(reason);
        return;
    L9:
        if (task.isActivityTypeHome() == false) goto L11;
        task.remove(false, reason);
        return;
    }

    public void activityPaused(ActivityRecord activityRecord) {
        if (activityRecord.getDisplayId() == 0) goto L5;
        return;
    L5:
        if (activityRecord.finishing == false) goto L7;
        return;
    L7:
        if (activityRecord.getActivityType() != 2) goto L9;
        return;
    L9:
        if (activityRecord.getTask() != null) goto L11;
        return;
    L11:
        if (activityRecord.getTask().getRootTask() == this.mBase.mWindowManager.mRoot.getDisplayContent(0).getFocusedRootTask()) goto L18;
        Slog.d("VirtualDisplay_taskListener", activityRecord.getTask().getRootTask() + "is returning");
        this.mBase.mWindowManager.getObricExt().onTaskToBackground(activityRecord.getTask().getTaskInfo());
        return;
    }

    public boolean shouldBeBlockInVisibleRange(Task task, int taskIndex) {
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(task.getBasePackageName()) == true) goto L6;
        return false;
    L6:
        if (task.getResumedActivity() != null) goto L8;
    L12:
        return false;
    L8:
        if (task.getResumedActivity().toString().contains("autoaction") == false) goto L12;
        if (taskIndex == 0) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean writeRobotsLog(String targetPackage, String targetActivity, String actionType, String timestamp, String args) {
        if (this.pkgsha256 != null) goto L5;
    L22:
        Slog.e(TAG, "writeRobotsLog: invalid params");
        return false;
    L5:
        if (this.agentuuid == null) goto L22;
        if (this.agentName == null) goto L22;
        JSONObject json = new JSONObject();
        json.put(PACKAGE_SHA256, this.pkgsha256);     // Catch: Exception -> L19
        json.put(AGENT_UUID, this.agentuuid);     // Catch: Exception -> L19
        json.put(AGENT_NAME, this.agentName);     // Catch: Exception -> L19
        json.put(TARGET_PACKAGE, targetPackage);     // Catch: Exception -> L19
        json.put(TARGET_ACTIVITY, targetActivity);     // Catch: Exception -> L19
        json.put(ACTION_TYPE, actionType);     // Catch: Exception -> L19
        json.put(TIMESTAMP, timestamp);     // Catch: Exception -> L19
        json.put(LOG_SOURCE, LOG_SOURCE_FRAMEWORK);     // Catch: Exception -> L19
        if (args == null) goto L13;
        json.put(ACTION_ARGS, args);     // Catch: Exception -> L19
    L13:
        long token = Binder.clearCallingIdentity();     // Catch: Exception -> L19
        SecurityAuditManager.recordAudit(json.toString());     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);     // Catch: Exception -> L19
        return true;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L20:
        return true;
    }

    public int getRobotsAgentUid() {
        return this.agentUid;
    }

    public void recordClickViewTreeCandidate(MotionEvent event) {
        getClickViewTreeInputController().onMotionEventCandidate(event);
    }

    public void reportKeyEventOnAutoDisplay(InputEvent event) {
        if ((event instanceof KeyEvent) == false) goto L14;
        KeyEvent keyEvent = (KeyEvent) event;
        if (keyEvent.getKeyCode() == 4) goto L7;
        return;
    L7:
        Slog.d(TAG, "reportKeyEventOnAutoDisplay: " + keyEvent);
        switch(keyEvent.getAction()) {
            case 0: goto L11;
            case 1: goto L10;
            default: goto L9;
        };
    L9:
        return;
    L10:
        Runnable callback = new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda3(this);
    L12:
        this.mBase.mH.post(callback);
        return;
    L11:
        callback = new ObricActivityTaskManagerServiceImpl$$ExternalSyntheticLambda2(this);
        goto L12
    }

    private /* synthetic */ void lambda$reportKeyEventOnAutoDisplay$3() {
        notifyBackNavigationStarted(this.mRemoteBackNavigationInVritualDisplayListeners);
    }

    private /* synthetic */ void lambda$reportKeyEventOnAutoDisplay$4() {
        notifyBackNavigationDone(this.mRemoteBackNavigationInVritualDisplayListeners);
    }

    public void clearInvalidLaunchDisplayId(SafeActivityOptions safeOptions) {
        if (safeOptions != null) goto L4;
        return;
    L4:
        if (safeOptions.getOriginalOptions() == null) goto L27;
        ActivityOptions options = safeOptions.getOriginalOptions();
        int launchDisplayId = options.getLaunchDisplayId();
        if (launchDisplayId != (-1)) goto L10;
        return;
    L10:
        if (this.mBase.mWindowManager.getObricExt().isRemovedObricVirtualDisplayId(launchDisplayId) == true) goto L12;
        return;
    L12:
        DisplayContent displayContent = this.mBase.mRootWindowContainer.getDisplayContent(launchDisplayId);
        if (displayContent != null) goto L15;
    L18:
        RootWindowContainer root = this.mBase.mRootWindowContainer;
        if (root.mDisplayManager == null) goto L25;
        Display display = root.mDisplayManager.getDisplay(launchDisplayId);
        if (display != null) goto L26;
        options.setLaunchDisplayId(-1);
        Slog.w(TAG, "Cleared stale launchDisplayId : " + launchDisplayId);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        if (displayContent.isRemoved() == false) goto L18;
        options.setLaunchDisplayId(-1);
        Slog.w(TAG, "Cleared stale launchDisplayId : " + launchDisplayId);
        return;
    }

    public void updateMutePackage(int uid, String packageName, int activityType) {
        if (this.mAppOpsService != null) goto L5;
        Slog.w(TAG, "updateMutedApp. mService is null");
        return;
    L5:
        this.mAppOpsService.getObricExt().updateMutePackage(uid, packageName, activityType);
    }

    public void resetMuteSessionState() {
        if (this.mAppOpsService != null) goto L6;
        Slog.w(TAG, "resetMuteSessionState. mService is null");
        return;
    L6:
        this.mAppOpsService.getObricExt().resetMuteSessionState();
    }

    public void setWhitelist(Set<String> whitelist) {
        if (this.mAppOpsService != null) goto L6;
        Slog.w(TAG, "setWhitelist. mService is null");
        return;
    L6:
        this.mAppOpsService.getObricExt().setWhitelist(whitelist);
    }

    private void onAppBackground(String packageName) {
        Slog.d(TAG, "onAppBackground: app=" + packageName);
        RemoteCallbackList<IObricAppSwitchListener> r0 = this.mRemoteAppSwitchListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteAppSwitchListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteAppSwitchListeners.getBroadcastItem(i).onAppBackground(packageName);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteAppSwitchListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void onAppForeground(String packageName) {
        Slog.d(TAG, "onAppForeground: app=" + packageName);
        RemoteCallbackList<IObricAppSwitchListener> r0 = this.mRemoteAppSwitchListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteAppSwitchListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteAppSwitchListeners.getBroadcastItem(i).onAppForeground(packageName);     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteAppSwitchListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void onActivityBackground(ComponentName componentName) {
        if (componentName != null) goto L4;
        return;
    L4:
        RemoteCallbackList<IObricActivitySwitchListener> r0 = this.mRemoteActivitySwitchListeners;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        int i = this.mRemoteActivitySwitchListeners.beginBroadcast() - 1;
    L8:
        if (i < 0) goto L13;
        this.mRemoteActivitySwitchListeners.getBroadcastItem(i).onActivityBackground(componentName);     // Catch: RemoteException -> L11 Throwable -> L16
    L12:
        i = i - 1;
        goto L8
    L13:
        this.mRemoteActivitySwitchListeners.finishBroadcast();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    private void onActivityForeground(ComponentName componentName) {
        if (componentName != null) goto L4;
        return;
    L4:
        RemoteCallbackList<IObricActivitySwitchListener> r0 = this.mRemoteActivitySwitchListeners;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L7:
        int i = this.mRemoteActivitySwitchListeners.beginBroadcast() - 1;
    L8:
        if (i < 0) goto L13;
        this.mRemoteActivitySwitchListeners.getBroadcastItem(i).onActivityForeground(componentName);     // Catch: RemoteException -> L11 Throwable -> L16
    L12:
        i = i - 1;
        goto L8
    L13:
        this.mRemoteActivitySwitchListeners.finishBroadcast();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public void reportUsageInfo(ActivityRecord activity, int event) {
        if (event == 2) goto L6;
        if (event == 1) goto L6;
        return;
    L6:
        String packageName = activity.packageName;
        ComponentName componentName = activity.mActivityComponent;
        if (componentName == null) goto L9;
    L11:
        if (event != 2) goto L13;
        String eventStr = "BACKGROUND";
    L14:
        Slog.d(TAG, "app=" + packageName + ", activity=" + componentName + ", event=" + eventStr);
        if (event != 2) goto L20;
        onActivityBackground(componentName);
        Runnable oldRunnable = this.mRunnableMap.remove(packageName);
        if (oldRunnable == null) goto L19;
        this.mBase.mUiHandler.removeCallbacks(oldRunnable);
    L19:
        Runnable newRunnable = new PendingAppBackground(this, packageName);
        this.mRunnableMap.put(packageName, newRunnable);
        this.mBase.mUiHandler.postDelayed(newRunnable, APP_BACKGROUND_DEBOUNCE_MS);
        return;
    L20:
        if (event != 1) goto L31;
        onActivityForeground(componentName);
        Runnable runnable = this.mRunnableMap.remove(packageName);
        if (runnable == null) goto L25;
        this.mBase.mUiHandler.removeCallbacks(runnable);
    L25:
        if (packageName.equals(this.sLastForegroundPackage) == false) goto L27;
        return;
    L27:
        this.sLastForegroundPackage = packageName;
        onAppForeground(packageName);
        return;
    L31:
        return;
    L13:
        eventStr = "FOREGROUND";
        goto L14
    L9:
        if (activity.info == null) goto L11;
        componentName = new ComponentName(packageName, activity.info.name);
        goto L11
    }

    private boolean pushAssistStructureToInputListener(AssistStructure structure, int eventId, String clickClassification) {
        InputManagerInternal imi = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);     // Catch: Exception -> L12
        if (imi != null) goto L6;
        return false;
    L6:
        IObricInputManagerService obricExt = imi.getObricExt();     // Catch: Exception -> L12
        if (obricExt != null) goto L9;
        return false;
    L9:
        obricExt.pushAssistStructure(structure, eventId, clickClassification);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Slog.w(TAG, "ClickViewTree[SS_FORWARD] failed", e);
        return false;
    }

    private void pushClickTimeoutToInputListener(int upEventId) {
        InputManagerInternal imi = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);     // Catch: Exception -> L10
        if (imi != null) goto L5;
        return;
    L5:
        IObricInputManagerService obricExt = imi.getObricExt();     // Catch: Exception -> L10
        if (obricExt != null) goto L8;
        return;
    L8:
        obricExt.pushAssistStructure(null, upEventId, "APP_REPORT_TIMEOUT");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "ClickViewTree[SS_TIMEOUT] forward failed", e);
    }

    public IObricActivityTaskManager getIObricExt() {
        return this.mObricActivityTaskManager;
    }
}
