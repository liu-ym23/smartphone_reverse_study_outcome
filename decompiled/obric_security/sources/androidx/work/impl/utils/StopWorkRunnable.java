package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes.dex */
public class StopWorkRunnable implements Runnable {
    private static final String TAG = null;
    private final boolean mStopInForeground;
    private final StartStopToken mToken;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("StopWorkRunnable");
    }

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, StartStopToken startStopToken, boolean stopInForeground) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mToken = startStopToken;
        this.mStopInForeground = stopInForeground;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mStopInForeground == false) goto L5;
        boolean r0 = this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mToken);
    L6:
        Logger.get().debug(TAG, "StopWorkRunnable for " + this.mToken.getId().getWorkSpecId() + "; Processor.stopWork = " + r0);
        return;
    L5:
        r0 = this.mWorkManagerImpl.getProcessor().stopWork(this.mToken);
        goto L6
    }
}
