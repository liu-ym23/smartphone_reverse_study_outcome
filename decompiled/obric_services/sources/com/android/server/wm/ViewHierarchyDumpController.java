package com.android.server.wm;

import android.app.IAssistDataReceiver;
import android.app.ITopActivityAssistDataReceiver;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class ViewHierarchyDumpController {
    private static final String TAG = "VHDCtl";
    private final WindowManagerService mWmService;

    private static final class VHDAssistDataReceiver extends IAssistDataReceiver.Stub {
        private ITopActivityAssistDataReceiver mOurReceiver;
        private int mRequestId;

        VHDAssistDataReceiver(int requestId, ITopActivityAssistDataReceiver ourReceiver) {
            this.mRequestId = requestId;
            this.mOurReceiver = ourReceiver;
        }

        public void onHandleAssistData(Bundle data) {
            Slog.i(ViewHierarchyDumpController.TAG, "onHandleAssistData received for requestId=" + this.mRequestId);
            this.mOurReceiver.onResultData(this.mRequestId, data);     // Catch: Throwable -> L5
            return;
        L6:
            Slog.i(ViewHierarchyDumpController.TAG, "onHandleAssistData: callback error for requestId=" + this.mRequestId);
        }

        public void onHandleAssistScreenshot(Bitmap screenshot) {
            Slog.i(ViewHierarchyDumpController.TAG, "onHandleAssistScreenshot:" + screenshot);
        }
    }

    public ViewHierarchyDumpController(WindowManagerService wms) {
        this.mWmService = wms;
    }

    public IBinder getTopActivityToken(int displayId) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        monitor-enter(r0);
        DisplayContent dc = this.mWmService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L17
        if (dc != null) goto L9;
        Slog.w(TAG, "getTopWindowToken: Invalid displayId=" + displayId);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L9:
        ActivityRecord topActivity = dc.getDefaultTaskDisplayArea().getActivity(new ViewHierarchyDumpController$$ExternalSyntheticLambda0(), true);     // Catch: Throwable -> L17
        if (topActivity == null) goto L14;
        IBinder r2 = topActivity.token;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L17
        Slog.w(TAG, "getTopActivityToken: no active ActivityToken under displayId=" + displayId);
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ boolean lambda$getTopActivityToken$0(ActivityRecord r) {
        if (r != null) goto L4;
    L6:
        return false;
    L4:
        if (r.finishing == true) goto L6;
        return true;
    }

    public boolean requestTopActivityAssistData(int requestId, int displayId, ITopActivityAssistDataReceiver receiver) {
        IBinder targetWindowToken = getTopActivityToken(displayId);
        if (targetWindowToken != null) goto L15;
        Slog.w(TAG, "requestTopActivityAssistData: no top-activity token found for displayId=" + displayId);
        return false;
    L15:
        ActivityTaskManagerService atm = this.mWmService.mAtmService;     // Catch: Throwable -> L12
        Bundle receiverExtras = new Bundle();     // Catch: Throwable -> L12
        boolean result = atm.requestAssistContextExtras(4, new VHDAssistDataReceiver(requestId, receiver), receiverExtras, targetWindowToken, false, true);     // Catch: Throwable -> L12
        if (result == true) goto L10;
        Slog.w(TAG, "requestTopActivityAssistData: cannot call atm for `requestAssistContextExtras`");     // Catch: Throwable -> L12
        return false;
    L10:
        return true;
    L12:
        t = move-exception;
        Slog.w(TAG, "Throwable during requestTopActivityAssistData call", t);
        return false;
    }
}
