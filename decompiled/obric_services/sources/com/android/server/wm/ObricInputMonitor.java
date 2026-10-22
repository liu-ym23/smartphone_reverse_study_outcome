package com.android.server.wm;

import android.app.IObricWindowGestureListener;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Slog;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.InputMonitor;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class ObricInputMonitor {
    private static final int DEFAULT_DISPLAY = 0;
    private static final String DEFAULT_INPUT_MONITOR_NAME = "obric-gesture-monitor";
    private static final float SWIPE_THRESHOLD = 100.0f;
    private static final String TAG = "ObricInputMonitor";
    private float mDownY;
    private final Handler mHandler;
    private InputEventReceiver mInputEventReceiver;
    private InputMonitor mInputMonitor;
    private final String mInputMonitorName;
    private boolean mIsRegistered;
    private boolean mIsTrackingSwipe;
    private final RemoteCallbackList<IObricWindowGestureListener> mRemoteWindowGestureListeners;
    private final WindowState mWindowState;

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m57$$Nest$fgetmHandler(ObricInputMonitor r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputMonitor m58$$Nest$fgetmInputMonitor(ObricInputMonitor r0) {
        return r0.mInputMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputMonitorName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m59$$Nest$fgetmInputMonitorName(ObricInputMonitor r0) {
        return r0.mInputMonitorName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m60$$Nest$fgetmIsRegistered(ObricInputMonitor r0) {
        return r0.mIsRegistered;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInputEventReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m61$$Nest$fputmInputEventReceiver(ObricInputMonitor r0, InputEventReceiver r1) {
        r0.mInputEventReceiver = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInputMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m62$$Nest$fputmInputMonitor(ObricInputMonitor r0, InputMonitor r1) {
        r0.mInputMonitor = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsRegistered, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m63$$Nest$fputmIsRegistered(ObricInputMonitor r0, boolean r1) {
        r0.mIsRegistered = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanup, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m64$$Nest$mcleanup(ObricInputMonitor r0) {
        r0.cleanup();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleInputEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m65$$Nest$mhandleInputEvent(ObricInputMonitor r0, InputEvent r1) {
        r0.handleInputEvent(r1);
    }

    public ObricInputMonitor(WindowState windowState, String inputMonitorName) {
        this.mIsRegistered = false;
        this.mDownY = 0.0f;
        this.mIsTrackingSwipe = false;
        this.mRemoteWindowGestureListeners = new RemoteCallbackList();
        this.mWindowState = windowState;
        if (inputMonitorName == null) goto L5;
        String r0 = inputMonitorName;
    L6:
        this.mInputMonitorName = r0;
        this.mHandler = new Handler(Looper.getMainLooper());
        return;
    L5:
        r0 = DEFAULT_INPUT_MONITOR_NAME;
        goto L6
    }

    public ObricInputMonitor(WindowState windowState) {
        this(windowState, null);
    }

    public WindowState getWindowState() {
        return this.mWindowState;
    }

    public String getPackageName() {
        if (this.mWindowState != null) goto L7;
        return "unknown";
    L7:
        return this.mWindowState.getOwningPackage();
    }

    public boolean isRegistered() {
        return this.mIsRegistered;
    }

    public int getWindowGestureListenerCount() {
        return this.mRemoteWindowGestureListeners.getRegisteredCallbackCount();
    }

    public void registerInputMonitor() {
        this.mHandler.post(new AnonymousClass1(this));
    }

    public void unregisterInputMonitor() {
        this.mHandler.post(new AnonymousClass2(this));
    }

    private void cleanup() {
        if (this.mInputEventReceiver == null) goto L6;
        this.mInputEventReceiver.dispose();
        this.mInputEventReceiver = null;
    L6:
        if (this.mInputMonitor == null) goto L8;
        this.mInputMonitor.dispose();
        this.mInputMonitor = null;
    L8:
        this.mIsRegistered = false;
        Slog.d(TAG, "InputMonitor unregistered");
    }

    private void handleInputEvent(InputEvent event) {
        if ((event instanceof MotionEvent) == true) goto L5;
        return;
    L5:
        MotionEvent motionEvent = (MotionEvent) event;
        int action = motionEvent.getActionMasked();
        switch(action) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L9;
            case 3: goto L14;
            default: goto L19;
        };
    L14:
        this.mIsTrackingSwipe = false;
        return;
    L15:
        this.mDownY = motionEvent.getY();
        this.mIsTrackingSwipe = true;
        return;
    L19:
        return;
    L9:
        if (this.mIsTrackingSwipe == false) goto L17;
        float deltaY = this.mDownY - motionEvent.getY();
        if (deltaY <= SWIPE_THRESHOLD) goto L21;
        notifySwipeUp();
        this.mIsTrackingSwipe = false;
        return;
    L21:
        return;
    }

    private void notifySwipeUp() {
        RemoteCallbackList<IObricWindowGestureListener> r0 = this.mRemoteWindowGestureListeners;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        int i = this.mRemoteWindowGestureListeners.beginBroadcast() - 1;
    L6:
        if (i < 0) goto L12;
        this.mRemoteWindowGestureListeners.getBroadcastItem(i).onHomeSwipeUp();     // Catch: RemoteException -> L9 Throwable -> L15
    L11:
        i = i - 1;     // Catch: Throwable -> L15
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to notify window gesture listener", e);     // Catch: Throwable -> L15
        goto L11
    L12:
        this.mRemoteWindowGestureListeners.finishBroadcast();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    public boolean registerWindowGestureListener(IObricWindowGestureListener listener) {
        RemoteCallbackList<IObricWindowGestureListener> r0 = this.mRemoteWindowGestureListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteWindowGestureListeners.register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean unregisterWindowGestureListener(IObricWindowGestureListener listener) {
        RemoteCallbackList<IObricWindowGestureListener> r0 = this.mRemoteWindowGestureListeners;
        monitor-enter(r0);
        boolean r1 = this.mRemoteWindowGestureListeners.unregister(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
