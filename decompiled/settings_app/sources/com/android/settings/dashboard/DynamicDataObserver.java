package com.android.settings.dashboard;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.android.settingslib.utils.ThreadUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicDataObserver extends ContentObserver {
    private CountDownLatch mCountDownLatch;
    private boolean mUpdateDelegated;
    private Runnable mUpdateRunnable;

    public abstract Uri getUri();

    public abstract void onDataChanged();

    protected DynamicDataObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mCountDownLatch = new CountDownLatch(1);
        onDataChanged();
    }

    public synchronized void updateUi() {
        monitor-enter(this);
        this.mUpdateDelegated = true;     // Catch: Throwable -> L9
        Runnable r0 = this.mUpdateRunnable;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.run();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public CountDownLatch getCountDownLatch() {
        return this.mCountDownLatch;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r1) {
        onDataChanged();
    }

    protected synchronized void post(Runnable r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mUpdateDelegated == false) goto L6;
        ThreadUtils.postOnMainThread(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.mUpdateRunnable = r2;     // Catch: Throwable -> L9
        this.mCountDownLatch.countDown();     // Catch: Throwable -> L9
        goto L7
    }
}
