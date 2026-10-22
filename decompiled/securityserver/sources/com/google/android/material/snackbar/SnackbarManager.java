package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;

    @Nullable
    private SnackbarRecord currentSnackbar;

    @NonNull
    private final Handler handler;

    @NonNull
    private final Object lock;

    @Nullable
    private SnackbarRecord nextSnackbar;

    public interface Callback {
        void dismiss(int r1);

        void show();
    }

    public static class SnackbarRecord {

        @NonNull
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        public SnackbarRecord(int r2, Callback r3) {
            this.callback = new WeakReference(r3);
            this.duration = r2;
        }

        public boolean isSnackbar(@Nullable Callback r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (this.callback.get() != r1) goto L6;
            return true;
        }
    }

    private SnackbarManager() {
        this.lock = new Object();
        this.handler = new Handler(Looper.getMainLooper(), new AnonymousClass1(this));
    }

    private boolean cancelSnackbarLocked(@NonNull SnackbarRecord r2, int r3) {
        Callback r0 = r2.callback.get();
        if (r0 == null) goto L6;
        this.handler.removeCallbacksAndMessages(r2);
        r0.dismiss(r3);
        return true;
    L6:
        return false;
    }

    public static SnackbarManager getInstance() {
        if (snackbarManager != null) goto L6;
        snackbarManager = new SnackbarManager();
    L6:
        return snackbarManager;
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

    private void scheduleTimeoutLocked(@NonNull SnackbarRecord r3) {
        int r0 = r3.duration;
        if (r0 != (-2)) goto L5;
        return;
    L5:
        if (r0 <= 0) goto L8;
    L11:
        this.handler.removeCallbacksAndMessages(r3);
        Handler r2 = this.handler;
        r2.sendMessageDelayed(Message.obtain(r2, 0, r3), r0);
        return;
    L8:
        if (r0 != (-1)) goto L10;
        r0 = 1500;
        goto L11
    L10:
        r0 = LONG_DURATION_MS;
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

    public void dismiss(Callback r3, int r4) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L10;
        cancelSnackbarLocked(this.currentSnackbar, r4);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L10:
        if (isNextSnackbarLocked(r3) == false) goto L12;
        cancelSnackbarLocked(this.nextSnackbar, r4);     // Catch: Throwable -> L7
        goto L12
    }

    public void handleTimeout(@NonNull SnackbarRecord r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.currentSnackbar != r3) goto L7;
    L11:
        cancelSnackbarLocked(r3, 2);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.nextSnackbar != r3) goto L12;
        goto L12
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
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L7;
    L12:
        boolean r2 = true;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        if (isNextSnackbarLocked(r3) == true) goto L12;
        r2 = false;
        goto L13
    }

    public void onDismissed(Callback r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r2) == false) goto L11;
        this.currentSnackbar = null;     // Catch: Throwable -> L9
        if (this.nextSnackbar == null) goto L11;
        showNextSnackbarLocked();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void onShown(Callback r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r2) == false) goto L9;
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void pauseTimeout(Callback r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L11;
        SnackbarRecord r4 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r4.paused == true) goto L11;
        r4.paused = true;     // Catch: Throwable -> L9
        this.handler.removeCallbacksAndMessages(r4);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void restoreTimeoutIfPaused(Callback r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r3) == false) goto L11;
        SnackbarRecord r4 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r4.paused == false) goto L11;
        r4.paused = false;     // Catch: Throwable -> L9
        scheduleTimeoutLocked(r4);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void show(int r3, Callback r4) {
        Object r0 = this.lock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentSnackbarLocked(r4) == false) goto L12;
        SnackbarRecord r5 = this.currentSnackbar;     // Catch: Throwable -> L9
        r5.duration = r3;     // Catch: Throwable -> L9
        this.handler.removeCallbacksAndMessages(r5);     // Catch: Throwable -> L9
        scheduleTimeoutLocked(this.currentSnackbar);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (isNextSnackbarLocked(r4) == false) goto L14;
        this.nextSnackbar.duration = r3;     // Catch: Throwable -> L9
    L15:
        SnackbarRecord r6 = this.currentSnackbar;     // Catch: Throwable -> L9
        if (r6 != null) goto L18;
    L21:
        this.currentSnackbar = null;     // Catch: Throwable -> L9
        showNextSnackbarLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L18:
        if (cancelSnackbarLocked(r6, 4) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        this.nextSnackbar = new SnackbarRecord(r3, r4);     // Catch: Throwable -> L9
        goto L15
    }
}
