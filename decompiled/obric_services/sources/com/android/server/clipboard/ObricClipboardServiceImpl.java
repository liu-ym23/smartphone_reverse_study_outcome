package com.android.server.clipboard;

import android.content.ClipData;
import android.content.IObricClipboardManager;
import android.content.IOnPrimaryClipChangedListener;
import android.os.Binder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import android.util.SparseArrayMap;
import com.android.server.wm.IObricWindowManagerInternal;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObricClipboardServiceImpl implements IObricClipboardService {
    private static final String TAG = "ObricClipboardServiceImpl";
    private final ClipboardService mBase;
    private volatile boolean mClipboardIsolate;
    private final SparseArrayMap<Integer, ClipboardService.Clipboard> mClipboardsInOautoDisplay;
    private IObricClipboardManager mObricClipboardManager;

    protected class ObricClipboardManagerImpl extends IObricClipboardManager.Stub {
        final /* synthetic */ ObricClipboardServiceImpl this$0;

        protected ObricClipboardManagerImpl(ObricClipboardServiceImpl this$0) {
            this.this$0 = this$0;
        }

        private void enforceSystemApp() {
            int callingUid = Binder.getCallingUid();
            if (ObricPermissionCheckHelper.isSystemApp(ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).getContext(), callingUid) == false) goto L6;
            return;
        L6:
            throw new SecurityException("Only system apps can call IObricClipboardManager");
        }

        public void setClipboardIsolated() {
            enforceSystemApp();
            Object r0 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r0);
            ObricClipboardServiceImpl.m6$$Nest$fputmClipboardIsolate(this.this$0, true);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setOautoClipdataToUser(int userId, int deviceId) {
            enforceSystemApp();
            Object r0 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r0);
            ClipboardService.Clipboard clipboardOauto = this.this$0.getClipboardLockedInOautoDisplay(userId, deviceId);     // Catch: Throwable -> L19
            if (clipboardOauto != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L7:
            if (clipboardOauto.primaryClip == null) goto L17;
            ClipboardService.Clipboard clipboardUser = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).getClipboardLocked(userId, deviceId);     // Catch: Throwable -> L19
            if (clipboardUser != null) goto L13;
            Slog.w(ObricClipboardServiceImpl.TAG, "getClipboardLocked called with not running userId " + userId);     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L13:
            clipboardUser.primaryClip = new ClipData(clipboardOauto.primaryClip);     // Catch: Throwable -> L19
            int i = clipboardOauto.primaryClip.getItemCount() - 1;     // Catch: Throwable -> L19
        L14:
            if (i < 0) goto L16;
            clipboardUser.primaryClip.setItemAt(i, new ClipData.Item(clipboardOauto.primaryClip.getItemAt(i)));     // Catch: Throwable -> L19
            i = i - 1;     // Catch: Throwable -> L19
            goto L14
        L16:
            ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).sendClipChangedBroadcast(clipboardUser);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }

        public void setUserClipdataToOauto(int userId, int deviceId) {
            enforceSystemApp();
            Object r0 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r0);
            ClipboardService.Clipboard clipboardUser = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).getClipboardLocked(userId, deviceId);     // Catch: Throwable -> L18
            if (clipboardUser != null) goto L7;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L7:
            if (clipboardUser.primaryClip == null) goto L16;
            ClipboardService.Clipboard clipboardOauto = this.this$0.getClipboardLockedInOautoDisplay(userId, deviceId);     // Catch: Throwable -> L18
            if (clipboardOauto != null) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L18
            return;
        L12:
            clipboardOauto.primaryClip = new ClipData(clipboardUser.primaryClip);     // Catch: Throwable -> L18
            int i = clipboardUser.primaryClip.getItemCount() - 1;     // Catch: Throwable -> L18
        L13:
            if (i < 0) goto L15;
            clipboardOauto.primaryClip.setItemAt(i, new ClipData.Item(clipboardUser.primaryClip.getItemAt(i)));     // Catch: Throwable -> L18
            i = i - 1;     // Catch: Throwable -> L18
            goto L13
        L15:
            ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).sendClipChangedBroadcast(clipboardOauto);     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        public void addOautoPrimaryClipChangedListener(IOnPrimaryClipChangedListener listener, String callingPackage, String attributionTag, int userId, int deviceId) {
            enforceSystemApp();
            int intendingUid = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).getIntendingUid(callingPackage, userId);
            Object r1 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r1);
            ClipboardService.Clipboard clipboard = this.this$0.getClipboardLockedInOautoDisplay(userId, deviceId);     // Catch: Throwable -> L11
            if (clipboard != null) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L8:
            RemoteCallbackList r3 = clipboard.primaryClipListeners;     // Catch: Throwable -> L11
            ClipboardService r5 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0);     // Catch: Throwable -> L11
            Objects.requireNonNull(r5);     // Catch: Throwable -> L11
            r3.register(listener, new ClipboardService.ListenerInfo(r5, intendingUid, callingPackage, attributionTag));     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void removeOautoPrimaryClipChangedListener(IOnPrimaryClipChangedListener listener, String callingPackage, String attributionTag, int userId, int deviceId) {
            enforceSystemApp();
            Object r0 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r0);
            ClipboardService.Clipboard clipboard = this.this$0.getClipboardLockedInOautoDisplay(userId, deviceId);     // Catch: Throwable -> L11
            if (clipboard != null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L8:
            clipboard.primaryClipListeners.unregister(listener);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void clearOautoPrimaryClip(int userId, int deviceId) {
            enforceSystemApp();
            Object r0 = ObricClipboardServiceImpl.m4$$Nest$fgetmBase(this.this$0).mLock;
            monitor-enter(r0);
            ObricClipboardServiceImpl.m5$$Nest$fgetmClipboardsInOautoDisplay(this.this$0).delete(userId, Integer.valueOf(deviceId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ ClipboardService m4$$Nest$fgetmBase(ObricClipboardServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClipboardsInOautoDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m5$$Nest$fgetmClipboardsInOautoDisplay(ObricClipboardServiceImpl r0) {
        return r0.mClipboardsInOautoDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmClipboardIsolate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6$$Nest$fputmClipboardIsolate(ObricClipboardServiceImpl r0, boolean r1) {
        r0.mClipboardIsolate = r1;
    }

    public ObricClipboardServiceImpl(ClipboardService service) {
        this.mClipboardsInOautoDisplay = new SparseArrayMap();
        this.mClipboardIsolate = false;
        Objects.requireNonNull(this);
        this.mObricClipboardManager = new ObricClipboardManagerImpl(this);
        this.mBase = service;
    }

    public ClipboardService.Clipboard getClipboardLockedInOautoDisplay(int userId, int deviceId) {
        ClipboardService.Clipboard clipboard = (ClipboardService.Clipboard) this.mClipboardsInOautoDisplay.get(userId, Integer.valueOf(deviceId));
        if (clipboard == null) goto L22;
        return clipboard;
    L22:
    L18:
        e = move-exception;
        Slog.e(TAG, "RemoteException calling UserManager: " + e);
        return null;
    L6:
        if (this.mBase.mUm.isUserRunning(userId) == true) goto L10;
        Slog.w(TAG, "getClipboardLocked called with not running userId " + userId);     // Catch: RemoteException -> L18
        return null;
    L10:
        if (deviceId != 0) goto L12;
    L17:
        ClipboardService.Clipboard clipboard2 = new ClipboardService.Clipboard(userId, deviceId);
        clipboard2.needIsolate = true;
        this.mClipboardsInOautoDisplay.add(userId, Integer.valueOf(deviceId), clipboard2);
        return clipboard2;
    L12:
        if (this.mBase.mVdm == null) goto L17;
        if (this.mBase.mVdm.isValidVirtualDeviceId(deviceId) == true) goto L17;
        Slog.w(TAG, "getClipboardLocked called with invalid (possibly released) deviceId " + deviceId);
        return null;
    }

    private void setClipboardLockedInOautoDisplay(int userId, int deviceId, ClipboardService.Clipboard clipboard) {
        if (clipboard != null) goto L21;
        return;
    L21:
    L17:
        e = move-exception;
        Slog.e(TAG, "RemoteException calling UserManager: " + e);
        return;
    L5:
        if (this.mBase.mUm.isUserRunning(userId) == true) goto L9;
        Slog.w(TAG, "setClipboardLockedInOautoDisplay called with not running userId " + userId);     // Catch: RemoteException -> L17
        return;
    L9:
        if (deviceId != 0) goto L11;
    L16:
        clipboard.needIsolate = true;
        this.mClipboardsInOautoDisplay.add(userId, Integer.valueOf(deviceId), clipboard);
        return;
    L11:
        if (this.mBase.mVdm == null) goto L16;
        if (this.mBase.mVdm.isValidVirtualDeviceId(deviceId) == true) goto L16;
        Slog.w(TAG, "setClipboardLockedInOautoDisplay called with invalid eviceId " + deviceId);
    }

    public void setClipboardIsolate(boolean isolate) {
        Object r0 = this.mBase.mLock;
        monitor-enter(r0);
        this.mClipboardIsolate = isolate;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isClipboardIsolated() {
        Object r0 = this.mBase.mLock;
        monitor-enter(r0);
        boolean r1 = this.mClipboardIsolate;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isClipDataFromOauto(ClipData clip) {
        if (clip != null) goto L4;
    L10:
        return false;
    L4:
        if (clip.getDescription() == null) goto L10;
        if (clip.getDescription().getExtras() == null) goto L10;
        if ("oauto_display".equals(clip.getDescription().getExtras().getString("com.obric.clipboard.clip_description_tag")) == false) goto L10;
        return true;
    }

    public void clearOautoPrimaryClipLocked(int userId, int deviceId) {
        Object r0 = this.mBase.mLock;
        monitor-enter(r0);
        this.mClipboardsInOautoDisplay.delete(userId, Integer.valueOf(deviceId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAppLaunchInOautoDisplay(IObricWindowManagerInternal wmsInternal) {
        if (wmsInternal != null) goto L5;
        return false;
    L5:
        int autoDisplayId = wmsInternal.getAutoDisplayId();
        int launchDisplayId = wmsInternal.getCallingFocusedDisplayId();
        if (autoDisplayId == 0) goto L10;
        if (launchDisplayId != autoDisplayId) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public IObricClipboardManager getIObricExt() {
        return this.mObricClipboardManager;
    }
}
