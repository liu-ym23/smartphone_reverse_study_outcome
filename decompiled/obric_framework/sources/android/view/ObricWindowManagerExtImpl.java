package android.view;

import android.app.IAssistantWindowFocusStatusListener;
import android.app.IObricInputMethodListener;
import android.app.IObricWindowGestureListener;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.IBinder;
import android.util.Log;
import android.util.Slog;
import android.window.ScreenCapture;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricWindowManagerExtImpl implements IObricWindowManagerExt {
    private static final String TAG = "ObricWindowManagerExtImpl";

    public ObricWindowManagerExtImpl() {
    }

    public Bitmap takeScreenshot(List<String> includingPackageNames, List<String> excludingPackageNames) {
        new SurfaceControl.Transaction().apply(true);
        ScreenCapture.SynchronousScreenCaptureListener syncScreenCapture = ScreenCapture.createSyncCaptureListener();
        if (takeSurfaceControlScreenshot(includingPackageNames, excludingPackageNames, syncScreenCapture) == false) goto L25;
        ScreenCapture.ScreenshotHardwareBuffer captureBuffer = syncScreenCapture.getBuffer();
        if (captureBuffer != null) goto L8;
        Slog.d(TAG, "takeScreenshot failed captureBuffer is null");
        return null;
    L8:
        Bitmap screenShot = captureBuffer.asBitmap();
        if (screenShot != null) goto L12;
        Slog.d(TAG, "takeScreenshot failed screenShot is null");
        return null;
    L12:
        HardwareBuffer buffer = captureBuffer.getHardwareBuffer();
        Bitmap swBitmap = screenShot.copy(Bitmap.Config.ARGB_8888, false);     // Catch: Throwable -> L18
        if (buffer == null) goto L16;
        buffer.close();
    L16:
        screenShot.recycle();
        return swBitmap;
    L18:
        th = move-exception;
        if (buffer != null) goto L29;
    L24:
        throw th;
    L29:
        buffer.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    L25:
        Slog.d(TAG, "takeScreenshot failed");
        return null;
    }

    public boolean takeSurfaceControlScreenshot(List<String> includingPackageNames, List<String> excludingPackageNames, ScreenCapture.ScreenCaptureListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().takeSurfaceControlScreenshot(includingPackageNames, excludingPackageNames, listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call takeSurfaceControlScreenshot " + e);
        return false;
    }

    public boolean isAutoImeShowing() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().isAutoImeShowing();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call isAutoImeShowing " + e);
        return false;
    }

    public boolean isAutoActionRunning() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().isAutoActionRunning();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call isAutoActionRunning " + e);
        return false;
    }

    public boolean focusedWindowIsSecure() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().focusedWindowIsSecure();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call focusedWindowIsSecure " + e);
        return false;
    }

    public boolean isInputMethodShown() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().isInputMethodShown();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call isInputMethodShown " + e);
        return false;
    }

    public boolean registerInputMethodListener(IObricInputMethodListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().registerInputMethodListener(listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call registerInputMethodListener " + e);
        return false;
    }

    public boolean unregisterInputMethodListener(IObricInputMethodListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().unregisterInputMethodListener(listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call unregisterInputMethodListener " + e);
        return false;
    }

    public boolean registerWindowGestureListener(IBinder windowToken, IObricWindowGestureListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().registerWindowGestureListener(windowToken, listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call registerWindowGestureListener " + e);
        return false;
    }

    public boolean unregisterWindowGestureListener(IBinder windowToken, IObricWindowGestureListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().unregisterWindowGestureListener(windowToken, listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call unregisterWindowGestureListener " + e);
        return false;
    }

    public int getAutoDisplayId() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().getAutoDisplayId();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call getAutoDisplayId " + e);
        return -1;
    }

    public int getCallingFocusedDisplayId() {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().getCallingFocusedDisplayId();
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call getCallingFocusedDisplayId " + e);
        return -1;
    }

    public boolean registerAssistantWindowFocusStatusListener(IAssistantWindowFocusStatusListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().registerAssistantWindowFocusStatusListener(listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call registerAssistantWindowFocusStatusListener " + e);
        return false;
    }

    public boolean unregisterAssistantWindowFocusStatusListener(IAssistantWindowFocusStatusListener listener) {
        return WindowManagerGlobal.getWindowManagerService().getIObricExt().unregisterAssistantWindowFocusStatusListener(listener);
    L4:
        e = move-exception;
        Log.e(TAG, "fail to call unregisterAssistantWindowFocusStatusListener " + e);
        return false;
    }

    public boolean setAssistantWindowInKeyguardMode(Window window) {
        if (window != null) goto L5;
        return false;
    L5:
        WindowManager.LayoutParams attrs = window.getAttributes();
        IObricLayoutParams obricParams = attrs.getObricExt();
        if (obricParams != null) goto L9;
        Log.w(TAG, "setAssistantWindowInKeyguardMode: obric params is null");
        return false;
    L9:
        obricParams.addPrivateFlag(2);
        window.setAttributes(attrs);
        return true;
    }
}
