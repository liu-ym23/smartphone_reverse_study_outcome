package obric.time;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
class ReferenceTime {
    static final long INVALID_TIME = -1;
    private final long mBaseTime;
    private final long mRefrenceTime;

    public ReferenceTime() {
        this(-1, -1);
    }

    public ReferenceTime(long r1, long r3) {
        this.mBaseTime = r1;
        this.mRefrenceTime = r3;
    }

    public long getBaseTime() {
        return this.mBaseTime;
    }

    public long getRefrenceTime() {
        return this.mRefrenceTime;
    }

    public boolean isValidNetworkTime() {
        if (this.mBaseTime != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (this.mRefrenceTime == (-1)) goto L7;
        return true;
    }

    public long getNetworkTimeMillis() {
        if (isValidNetworkTime() == true) goto L7;
        return -1;
    L7:
        return (getBaseTime() + SystemClock.elapsedRealtime()) - getRefrenceTime();
    }

    public long getCurrentTimeMillis() {
        if (isValidNetworkTime() == false) goto L6;
        return getNetworkTimeMillis();
    L6:
        return System.currentTimeMillis();
    }

    public String toString() {
        return "ReferenceTime{mBaseTime=" + this.mBaseTime + ", mRefrenceTime=" + this.mRefrenceTime + '}';
    }
}
