package d.b.h.a.a.d;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {
    private long mInitialDelay;
    private long mLoopInterval;
    private d mTaskType;
    private TimeUnit mTimeUnit;

    public b() {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
    }

    public b(long r3) {
        this.mInitialDelay = 0;
        this.mLoopInterval = 0;
        this.mTimeUnit = TimeUnit.MILLISECONDS;
        this.mLoopInterval = r3;
    }

    public b(long r1, long r3) {
        this(r3);
        this.mInitialDelay = r1;
    }

    public b(long r1, long r3, TimeUnit r5) {
        this(r1, r3);
        this.mTimeUnit = r5;
    }

    public long getInitialDelay() {
        return this.mInitialDelay;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public d getTaskType() {
        return this.mTaskType;
    }

    public TimeUnit getTimeUnit() {
        return this.mTimeUnit;
    }

    public boolean isLoop() {
        if (this.mLoopInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setTaskType(d r1) {
        this.mTaskType = r1;
    }
}
