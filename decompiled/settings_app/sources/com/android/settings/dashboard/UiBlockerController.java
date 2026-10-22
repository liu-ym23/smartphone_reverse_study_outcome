package com.android.settings.dashboard;

import com.android.settingslib.utils.ThreadUtils;
import com.obric.olog.OLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class UiBlockerController {
    private static final String TAG = "UiBlockerController";
    private static final int TIMEOUT_MILLIS = 300;
    private boolean mBlockerFinished;
    private CountDownLatch mCountDownLatch;
    private Set<String> mKeys;
    private long mTimeoutMillis;

    public UiBlockerController(List<String> r3) {
        this(r3, 300);
    }

    public UiBlockerController(List<String> r3, long r4) {
        this.mCountDownLatch = new CountDownLatch(r3.size());
        this.mBlockerFinished = r3.isEmpty();
        this.mKeys = new HashSet(r3);
        this.mTimeoutMillis = r4;
    }

    public boolean start(final Runnable r2) {
        if (this.mKeys.isEmpty() == false) goto L6;
        return false;
    L6:
        ThreadUtils.postOnBackgroundThread(new UiBlockerController$$ExternalSyntheticLambda0(this, r2));
        return true;
    }

    /* JADX INFO: renamed from: lambda$start$0$com-android-settings-dashboard-UiBlockerController, reason: not valid java name */
    /* synthetic */ void m419xb9a649dc(Runnable r5) {
        this.mCountDownLatch.await(this.mTimeoutMillis, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L4
    L5:
        this.mBlockerFinished = true;
        ThreadUtils.postOnMainThread(r5);
        return;
    L4:
        OLog.w(TAG, "interrupted");
        goto L5
    }

    public boolean isBlockerFinished() {
        return this.mBlockerFinished;
    }

    public boolean countDown(String r2) {
        if (this.mKeys.remove(r2) == false) goto L6;
        this.mCountDownLatch.countDown();
        return true;
    L6:
        return false;
    }
}
