package com.android.server.notification;

import android.app.IObricNotificationListener;
import android.app.IObricNotificationManager;
import android.app.IObricToastShowListener;
import android.app.TransientUI;
import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObricNotificationManagerServiceImpl implements IObricNotificationManagerService {
    private static final String TAG = "NotificationService";
    protected final ArraySet<String> mAllowNotificationListenerPackages;
    private NotificationManagerService mBase;
    private boolean mIsPanelShown;
    private IObricNotificationManager mObricNotificationManager;
    private final RemoteCallbackList<IObricNotificationListener> mRemoteNotificationListeners;
    private final RemoteCallbackList<IObricToastShowListener> mRemoteToastShowListeners;
    private WindowManagerInternal mWindowManagerInternal;

    protected class ObricNotificationManagerImpl extends IObricNotificationManager.Stub {
        final /* synthetic */ ObricNotificationManagerServiceImpl this$0;

        protected ObricNotificationManagerImpl(ObricNotificationManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public boolean registerNotificationListener(IObricNotificationListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricNotificationManagerServiceImpl.m23$$Nest$fgetmBase(this.this$0).getContext(), Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricNotificationManagerServiceImpl.m25$$Nest$fgetmRemoteNotificationListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricNotificationManagerServiceImpl.m25$$Nest$fgetmRemoteNotificationListeners(this.this$0).register(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean unregisterNotificationListener(IObricNotificationListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricNotificationManagerServiceImpl.m23$$Nest$fgetmBase(this.this$0).getContext(), Binder.getCallingUid()) == true) goto L6;
            return false;
        L6:
            RemoteCallbackList r0 = ObricNotificationManagerServiceImpl.m25$$Nest$fgetmRemoteNotificationListeners(this.this$0);
            monitor-enter(r0);
            boolean r1 = ObricNotificationManagerServiceImpl.m25$$Nest$fgetmRemoteNotificationListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean isPanelShown() {
            if (ObricPermissionCheckHelper.isSystemApp(ObricNotificationManagerServiceImpl.m23$$Nest$fgetmBase(this.this$0).getContext(), Binder.getCallingUid()) == true) goto L7;
            Slog.e(ObricNotificationManagerServiceImpl.TAG, "isPanelShown: only system app can call");
            return false;
        L7:
            return ObricNotificationManagerServiceImpl.m24$$Nest$fgetmIsPanelShown(this.this$0);
        }

        public void registerToastShowListener(IObricToastShowListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricNotificationManagerServiceImpl.m23$$Nest$fgetmBase(this.this$0).getContext(), Binder.getCallingUid()) == true) goto L6;
            Slog.e(ObricNotificationManagerServiceImpl.TAG, "registerToastShowListener: only system app can call");
            return;
        L6:
            RemoteCallbackList r0 = ObricNotificationManagerServiceImpl.m26$$Nest$fgetmRemoteToastShowListeners(this.this$0);
            monitor-enter(r0);
            ObricNotificationManagerServiceImpl.m26$$Nest$fgetmRemoteToastShowListeners(this.this$0).register(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void unregisterToastShowListener(IObricToastShowListener listener) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricNotificationManagerServiceImpl.m23$$Nest$fgetmBase(this.this$0).getContext(), Binder.getCallingUid()) == true) goto L6;
            Slog.e(ObricNotificationManagerServiceImpl.TAG, "unregisterToastShowListener: only system app can call");
            return;
        L6:
            RemoteCallbackList r0 = ObricNotificationManagerServiceImpl.m26$$Nest$fgetmRemoteToastShowListeners(this.this$0);
            monitor-enter(r0);
            ObricNotificationManagerServiceImpl.m26$$Nest$fgetmRemoteToastShowListeners(this.this$0).unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void onToastShow(String packageName, IBinder token, CharSequence text) {
            ObricNotificationManagerServiceImpl.m27$$Nest$monToastShow(this.this$0, packageName, token, text);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManagerService m23$$Nest$fgetmBase(ObricNotificationManagerServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsPanelShown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m24$$Nest$fgetmIsPanelShown(ObricNotificationManagerServiceImpl r0) {
        return r0.mIsPanelShown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteNotificationListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m25$$Nest$fgetmRemoteNotificationListeners(ObricNotificationManagerServiceImpl r0) {
        return r0.mRemoteNotificationListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteToastShowListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m26$$Nest$fgetmRemoteToastShowListeners(ObricNotificationManagerServiceImpl r0) {
        return r0.mRemoteToastShowListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$monToastShow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m27$$Nest$monToastShow(ObricNotificationManagerServiceImpl r0, String r1, IBinder r2, CharSequence r3) {
        r0.onToastShow(r1, r2, r3);
    }

    public ObricNotificationManagerServiceImpl(NotificationManagerService base) {
        this.mIsPanelShown = false;
        this.mRemoteNotificationListeners = new RemoteCallbackList();
        this.mRemoteToastShowListeners = new RemoteCallbackList();
        Objects.requireNonNull(this);
        this.mObricNotificationManager = new ObricNotificationManagerImpl(this);
        this.mAllowNotificationListenerPackages = new ArraySet(Arrays.asList(new String[]{ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA, "com.android.launcher3", "com.google.android.projection.gearhead"}));
        this.mBase = base;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    }

    public void allowNotificationListenerForSpecificApps() {
        int i = 0;
    L4:
        if (i >= this.mAllowNotificationListenerPackages.size()) goto L10;
        String pkg = this.mAllowNotificationListenerPackages.valueAt(i);
        ArraySet<ComponentName> approvedListeners = this.mBase.mListeners.queryPackageForServices(pkg, 786432, 0);
        int k = 0;
    L7:
        if (k >= approvedListeners.size()) goto L9;
        ComponentName cn = approvedListeners.valueAt(k);
        Slog.d(TAG, "allowNotificationListenerForSpecificApps: ComponentName=" + cn);
        allowNotificationListener(0, cn);
        k = k + 1;
        goto L7
    L9:
        i = i + 1;
        goto L4
    }

    protected void allowNotificationListener(int userId, ComponentName cn) {
        this.mBase.getBinderService().setNotificationListenerAccessGrantedForUser(cn, userId, true, true);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void onPanelShown() {
        this.mIsPanelShown = true;
        RemoteCallbackList<IObricNotificationListener> r1 = this.mRemoteNotificationListeners;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteNotificationListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteNotificationListeners.getBroadcastItem(i).onPanelShown();     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteNotificationListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
    }

    public void onPanelHidden() {
        this.mIsPanelShown = false;
        RemoteCallbackList<IObricNotificationListener> r0 = this.mRemoteNotificationListeners;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteNotificationListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L11;
        this.mRemoteNotificationListeners.getBroadcastItem(i).onPanelHidden();     // Catch: RemoteException -> L9 Throwable -> L14
    L10:
        i = i - 1;
        goto L6
    L11:
        this.mRemoteNotificationListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void onToastShow(String packageName, IBinder token, CharSequence text) {
        if (text != null) goto L4;
        return;
    L4:
        ArrayList r0 = this.mBase.mToastQueue;
        monitor-enter(r0);
        int index = this.mBase.indexOfToastLocked(packageName, token);     // Catch: Throwable -> L40
        if (index != 0) goto L9;
        boolean isCurrentShowingToast = true;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L40
        if (isCurrentShowingToast == true) goto L13;
        return;
    L13:
        Slog.d(TAG, "onToastShow: " + packageName + " " + token);
        if (this.mWindowManagerInternal == null) goto L39;
        int displayId = this.mWindowManagerInternal.getObricWindowManagerInternal().getAutoDisplayId();
        if (displayId > 0) goto L19;
        return;
    L19:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().isPkgRunWithOAuto(packageName) == true) goto L22;
        return;
    L22:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().hasSecureWindow(displayId) == false) goto L24;
        return;
    L24:
        TransientUI transientUI = new TransientUI("toast", text.toString());
        RemoteCallbackList<IObricToastShowListener> r4 = this.mRemoteToastShowListeners;
        monitor-enter(r4);
    L36:
        th = move-exception;
        throw th;
    L27:
        int i = this.mRemoteToastShowListeners.beginBroadcast() - 1;
    L28:
        if (i < 0) goto L33;
        this.mRemoteToastShowListeners.getBroadcastItem(i).onToastShow(transientUI);     // Catch: RemoteException -> L31 Throwable -> L36
    L32:
        i = i - 1;
        goto L28
    L33:
        this.mRemoteToastShowListeners.finishBroadcast();     // Catch: Throwable -> L36
        monitor-exit(r4);     // Catch: Throwable -> L36
        Slog.d(TAG, "mRemoteToastShowListeners: " + packageName + " " + token);
        return;
    L39:
        return;
    L9:
        isCurrentShowingToast = false;
    L40:
        th = move-exception;
        throw th;
    }

    public IObricNotificationManager getIObricExt() {
        return this.mObricNotificationManager;
    }
}
