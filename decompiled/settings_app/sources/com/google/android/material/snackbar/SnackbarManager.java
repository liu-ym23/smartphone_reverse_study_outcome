package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    private SnackbarRecord currentSnackbar;
    private final Handler handler;
    private final Object lock;
    private SnackbarRecord nextSnackbar;

    interface Callback {
        void dismiss(int r1);

        void show();
    }

    private static class SnackbarRecord {
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        SnackbarRecord(int r2, Callback r3) {
            this.callback = new WeakReference(r3);
            this.duration = r2;
        }

        boolean isSnackbar(Callback r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.callback.get() != r1) goto L6;
            return true;
        }
    }

    static SnackbarManager getInstance() {
        if (snackbarManager != null) goto L6;
        snackbarManager = new SnackbarManager();
    L6:
        return snackbarManager;
    }

    private SnackbarManager() {
        this.lock = new Object();
        this.handler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    public void show(int r3, Callback r4) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r4) == false) goto L10;
        this.currentSnackbar.duration = r3;     // Catch: Throwable -> L22
        this.handler.removeCallbacksAndMessages(this.currentSnackbar);     // Catch: Throwable -> L22
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L10:
        if (isNextSnackbarLocked(r4) == false) goto L12;
        this.nextSnackbar.duration = r3;     // Catch: Throwable -> L22
    L13:
        SnackbarRecord r5 = this.currentSnackbar;     // Catch: Throwable -> L22
        if (r5 != null) goto L16;
    L19:
        this.currentSnackbar = null;     // Catch: Throwable -> L22
        showNextSnackbarLocked();     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L16:
        if (cancelSnackbarLocked(r5, 4) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L12:
        this.nextSnackbar = new SnackbarRecord(r3, r4);     // Catch: Throwable -> L22
        goto L13
    }

    public void dismiss(Callback r3, int r4) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L8;
        cancelSnackbarLocked(this.currentSnackbar, r4);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L8:
        if (isNextSnackbarLocked(r3) == false) goto L10;
        cancelSnackbarLocked(this.nextSnackbar, r4);     // Catch: Throwable -> L12
        goto L10
    }

    public void onDismissed(Callback r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r2) == false) goto L9;
        this.currentSnackbar = null;     // Catch: Throwable -> L11
        if (this.nextSnackbar == null) goto L9;
        showNextSnackbarLocked();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void onShown(Callback r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r2) == false) goto L7;
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void pauseTimeout(Callback r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.currentSnackbar.paused == true) goto L9;
        this.currentSnackbar.paused = true;     // Catch: Throwable -> L11
        this.handler.removeCallbacksAndMessages(this.currentSnackbar);     // Catch: Throwable -> L11
        goto L9
    }

    public void restoreTimeoutIfPaused(Callback r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == true) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.currentSnackbar.paused == false) goto L9;
        this.currentSnackbar.paused = false;     // Catch: Throwable -> L11
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L11
        goto L9
    }

    public boolean isCurrent(Callback r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = isCurrentSnackbarLocked(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCurrentOrNext(Callback r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (isNextSnackbarLocked(r3) == true) goto L10;
        r2 = false;
        goto L11
    }

    private void showNextSnackbarLocked() {
        SnackbarRecord r0 = this.nextSnackbar;
        if (r0 == null) goto L9;
        this.currentSnackbar = r0;
        this.nextSnackbar = null;
        Callback r1 = r0.callback.get();
        if (r1 == null) goto L7;
        r1.show();
        return;
    L7:
        this.currentSnackbar = null;
        return;
    }

    private boolean cancelSnackbarLocked(SnackbarRecord r2, int r3) {
        Callback r0 = r2.callback.get();
        if (r0 == null) goto L6;
        this.handler.removeCallbacksAndMessages(r2);
        r0.dismiss(r3);
        return true;
    L6:
        return false;
    }

    private boolean isCurrentSnackbarLocked(Callback r1) {
        SnackbarRecord r0 = this.currentSnackbar;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSnackbar(r1) == false) goto L7;
        return true;
    }

    private boolean isNextSnackbarLocked(Callback r1) {
        SnackbarRecord r0 = this.nextSnackbar;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isSnackbar(r1) == false) goto L7;
        return true;
    }

    private void scheduleTimeoutLocked(SnackbarRecord r3) {
        if (r3.duration != (-2)) goto L6;
        return;
    L6:
        if (r3.duration <= 0) goto L9;
        int r0 = r3.duration;
    L12:
        this.handler.removeCallbacksAndMessages(r3);
        Handler r2 = this.handler;
        r2.sendMessageDelayed(Message.obtain(r2, 0, r3), r0);
        return;
    L9:
        if (r3.duration != (-1)) goto L11;
        r0 = 1500;
        goto L12
    L11:
        r0 = LONG_DURATION_MS;
        goto L12
    }

    void handleTimeout(SnackbarRecord r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.currentSnackbar != r3) goto L7;
    L8:
        cancelSnackbarLocked(r3, 2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.nextSnackbar != r3) goto L9;
        goto L8
    }
}
