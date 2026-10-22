package com.android.server.input;

import android.app.ITopActivityAssistDataReceiver;
import android.app.assist.AssistStructure;
import android.hardware.display.DisplayManagerInternal;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.Slog;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.android.internal.view.IObricInputManager;
import com.android.server.LocalServices;
import com.android.server.wm.ObricClickViewTreeInputController;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ObricInputManagerServiceImpl implements IObricInputManagerService {
    private static final int INJECTION_TIMEOUT_MILLIS = 30000;
    private static final String TAG = "ObricInputManagerServiceImpl";
    private final InputManagerService mBase;
    private final IObricInputManager mIObricInputManagerExt;
    private IBinder.DeathRecipient mInjectEventResponseDeathRecipient;
    private volatile ITopActivityAssistDataReceiver mInjectEventResponseListener;
    private IBinder mInjectEventResponseListenerBinder;
    private final Object mInjectListenerLock;
    private WindowManagerInternal mWindowManagerInternal;

    protected class ObricInputManagerExtImpl extends IObricInputManager.Stub {
        final /* synthetic */ ObricInputManagerServiceImpl this$0;

        protected ObricInputManagerExtImpl(ObricInputManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public void registerInjectEventResponseListener(ITopActivityAssistDataReceiver receiver) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricInputManagerServiceImpl.m7$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == false) goto L24;
            if (receiver != null) goto L6;
            return;
        L6:
            final IBinder binder = receiver.asBinder();
            Object r1 = ObricInputManagerServiceImpl.m9$$Nest$fgetmInjectListenerLock(this.this$0);
            monitor-enter(r1);
            ObricInputManagerServiceImpl.m13$$Nest$mclearInjectEventResponseListenerLocked(this.this$0);     // Catch: Throwable -> L20
            IBinder.DeathRecipient recipient = new AnonymousClass1(this, binder);     // Catch: Throwable -> L20
            binder.linkToDeath(recipient, 0);     // Catch: RemoteException -> L16 Throwable -> L20
            ObricInputManagerServiceImpl.m11$$Nest$fputmInjectEventResponseListener(this.this$0, receiver);     // Catch: Throwable -> L20
            ObricInputManagerServiceImpl.m12$$Nest$fputmInjectEventResponseListenerBinder(this.this$0, binder);     // Catch: Throwable -> L20
            ObricInputManagerServiceImpl.m10$$Nest$fputmInjectEventResponseDeathRecipient(this.this$0, recipient);     // Catch: Throwable -> L20
            SystemProperties.set("sys.obric.click_viewtree.inject_listener", "true");     // Catch: Throwable -> L20
            if (ObricInputManagerServiceImpl.m14$$Nest$smisClickViewTreeDebugEnabled() == false) goto L14;
            Slog.d(ObricInputManagerServiceImpl.TAG, "ClickViewTree[INPUT_LISTENER] registered");     // Catch: Throwable -> L20
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L20
            return;
        L16:
            e = move-exception;
            Slog.w(ObricInputManagerServiceImpl.TAG, "ClickViewTree[INPUT_LISTENER] register skipped: binder already dead", e);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L24:
            throw new SecurityException("registerInjectEventResponseListener is not allowed");
        }

        public void unregisterInjectEventResponseListener(ITopActivityAssistDataReceiver receiver) {
            if (ObricPermissionCheckHelper.isSystemApp(ObricInputManagerServiceImpl.m7$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == false) goto L16;
            Object r0 = ObricInputManagerServiceImpl.m9$$Nest$fgetmInjectListenerLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (ObricInputManagerServiceImpl.m14$$Nest$smisClickViewTreeDebugEnabled() == false) goto L9;
            Slog.d(ObricInputManagerServiceImpl.TAG, "ClickViewTree[INPUT_LISTENER] unregistered");     // Catch: Throwable -> L12
        L9:
            ObricInputManagerServiceImpl.m13$$Nest$mclearInjectEventResponseListenerLocked(this.this$0);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L16:
            throw new SecurityException("unregisterInjectEventResponseListener is not allowed");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputManagerService m7$$Nest$fgetmBase(ObricInputManagerServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjectEventResponseListenerBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m8$$Nest$fgetmInjectEventResponseListenerBinder(ObricInputManagerServiceImpl r0) {
        return r0.mInjectEventResponseListenerBinder;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjectListenerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9$$Nest$fgetmInjectListenerLock(ObricInputManagerServiceImpl r0) {
        return r0.mInjectListenerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInjectEventResponseDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10$$Nest$fputmInjectEventResponseDeathRecipient(ObricInputManagerServiceImpl r0, IBinder.DeathRecipient r1) {
        r0.mInjectEventResponseDeathRecipient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInjectEventResponseListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m11$$Nest$fputmInjectEventResponseListener(ObricInputManagerServiceImpl r0, ITopActivityAssistDataReceiver r1) {
        r0.mInjectEventResponseListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInjectEventResponseListenerBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m12$$Nest$fputmInjectEventResponseListenerBinder(ObricInputManagerServiceImpl r0, IBinder r1) {
        r0.mInjectEventResponseListenerBinder = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mclearInjectEventResponseListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m13$$Nest$mclearInjectEventResponseListenerLocked(ObricInputManagerServiceImpl r0) {
        r0.clearInjectEventResponseListenerLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$smisClickViewTreeDebugEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m14$$Nest$smisClickViewTreeDebugEnabled() {
        return isClickViewTreeDebugEnabled();
    }

    public ObricInputManagerServiceImpl(InputManagerService inputManagerService) {
        this.mInjectEventResponseListener = null;
        this.mInjectListenerLock = new Object();
        Objects.requireNonNull(this);
        this.mIObricInputManagerExt = new ObricInputManagerExtImpl(this);
        this.mBase = inputManagerService;
    }

    private static boolean isClickViewTreeDebugEnabled() {
        if (Build.IS_DEBUGGABLE == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean("persist.sys.obric.click_viewtree.debug", false) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public IObricInputManager getIObricExt() {
        return this.mIObricInputManagerExt;
    }

    public int injectInputEvent(InputEvent event, boolean injectIntoUid, int targetUid, int mode, DisplayManagerInternal Dmi, NativeInputManagerService mNative) {
        if (this.mWindowManagerInternal != null) goto L6;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    L6:
        if (event.getDisplayId() == 0) goto L22;
        if (event.getDisplayId() == (-1)) goto L22;
        if (Dmi.getDisplayInfo(event.getDisplayId()) == null) goto L22;
        if ("auto_action".equals(Dmi.getDisplayInfo(event.getDisplayId()).name) == false) goto L22;
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().shouldDispatchToAutoDisplay() == false) goto L16;
        int flags = 1207959552 | 67108864;
        int flags2 = flags;
    L17:
        recordClickViewTreeCandidate(event);
        int result = mNative.injectInputEvent(event, injectIntoUid, targetUid, mode, INJECTION_TIMEOUT_MILLIS, flags2);
        return result;
    L16:
        flags2 = 1207959552;
    L22:
        if (event.getDisplayId() == 0) goto L24;
    L33:
        int result2 = mNative.injectInputEvent(event, injectIntoUid, targetUid, mode, INJECTION_TIMEOUT_MILLIS, 134217728);
        return result2;
    L24:
        if ((event instanceof KeyEvent) == false) goto L33;
        KeyEvent kv = (KeyEvent) event;
        if (kv.getKeyCode() == 4) goto L28;
    L32:
        this.mWindowManagerInternal.getObricWindowManagerInternal().reportKeyEventOnAutoDisplay(event);
        goto L33
    L28:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().shouldDispatchToAutoDisplay() == false) goto L32;
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().isVDPlayerOnTop() == false) goto L32;
        int displayId = this.mWindowManagerInternal.getObricWindowManagerInternal().getAutoDisplayId();
        event.setDisplayId(displayId);
        goto L32
    }

    private void recordClickViewTreeCandidate(InputEvent event) {
        if ((event instanceof MotionEvent) == true) goto L5;
        return;
    L5:
        MotionEvent motionEvent = (MotionEvent) event;
        int action = motionEvent.getActionMasked();
        if (action == 0) goto L10;
        if (action == 1) goto L10;
        return;
    L10:
        if (ObricClickViewTreeInputController.isPointerSource(motionEvent.getSource()) == true) goto L13;
        return;
    L13:
        if (SystemProperties.getBoolean("sys.obric.click_viewtree.inject_listener", false) == true) goto L16;
        return;
    L16:
        if (SystemProperties.getBoolean("sys.obric.click_viewtree.call_user", false) == false) goto L33;
        return;
    L33:
    L28:
        t = move-exception;
        if (Build.IS_DEBUGGABLE == false) goto L35;
        Slog.w(TAG, "ClickViewTree[INPUT] record candidate failed", t);
        return;
    L35:
        return;
    L19:
        if (this.mWindowManagerInternal.getObricWindowManagerInternal().hasSecureWindow(motionEvent.getDisplayId()) == true) goto L21;
        this.mWindowManagerInternal.getObricWindowManagerInternal().recordClickViewTreeCandidate(motionEvent);     // Catch: Throwable -> L28
        return;
    L21:
        if (isClickViewTreeDebugEnabled() == false) goto L23;
        Slog.d(TAG, "ClickViewTree[INPUT] skip record reason=secure_window displayId=" + motionEvent.getDisplayId());     // Catch: Throwable -> L28
    L23:
        if (action != 1) goto L34;
        pushAssistStructure(null, motionEvent.getId(), "SECURE_BLOCKED");     // Catch: Throwable -> L28
        return;
    }

    public void onInputEventInjectedForRobots(InputEvent event) {
        if (this.mWindowManagerInternal != null) goto L5;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
    L5:
        this.mWindowManagerInternal.getObricWindowManagerInternal().onInputEventInjectedForRobots(event);
    }

    private void clearInjectEventResponseListenerLocked() {
        if (this.mInjectEventResponseListenerBinder != null) goto L5;
    L7:
        this.mInjectEventResponseListener = null;
        this.mInjectEventResponseListenerBinder = null;
        this.mInjectEventResponseDeathRecipient = null;
        SystemProperties.set("sys.obric.click_viewtree.inject_listener", "false");
        return;
    L5:
        if (this.mInjectEventResponseDeathRecipient == null) goto L7;
        this.mInjectEventResponseListenerBinder.unlinkToDeath(this.mInjectEventResponseDeathRecipient, 0);
        goto L7
    }

    public void pushAssistStructure(AssistStructure structure, int eventId, String clickClassification) {
        ITopActivityAssistDataReceiver listener = this.mInjectEventResponseListener;
        if (listener == null) goto L5;
        Bundle bundle = new Bundle();
        if (structure == null) goto L11;
        bundle.putParcelable("assist_structure", structure);
    L11:
        bundle.putString("type", clickClassification);
        bundle.putInt("event_id", eventId);
        listener.onResultData(-1, bundle);     // Catch: Throwable -> L20
        if (isClickViewTreeDebugEnabled() == false) goto L27;
        StringBuilder r3 = new StringBuilder().append("ClickViewTree[INPUT_PUSH] delivered eventId=").append(eventId).append(" type=").append(clickClassification).append(" hasStructure=");     // Catch: Throwable -> L20
        if (structure == null) goto L17;
        boolean r4 = true;
    L18:
        Slog.d(TAG, r3.append(r4).toString());     // Catch: Throwable -> L20
        return;
    L17:
        r4 = false;
        goto L18
    L27:
        return;
    L20:
        t = move-exception;
        Slog.e(TAG, "ClickViewTree[INPUT_PUSH] failed eventId=" + eventId, t);
        return;
    L5:
        if (isClickViewTreeDebugEnabled() == false) goto L25;
        Slog.d(TAG, "ClickViewTree[INPUT_PUSH] skipped reason=no_listener eventId=" + eventId);
        return;
    }
}
