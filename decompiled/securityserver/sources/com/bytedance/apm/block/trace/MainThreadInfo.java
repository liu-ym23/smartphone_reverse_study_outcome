package com.bytedance.apm.block.trace;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class MainThreadInfo {
    private static final int DEAL_INPUT_EVENT = 0;
    private static final int INPUT_EVENT_COUNT = 1;
    private static final int NEWEST_INPUT_EVENT = 3;
    private static final int OLDEST_INPUT_EVENT = 2;
    public boolean isValid;
    public long[] mainThreadInfo;

    public MainThreadInfo() {
        this.mainThreadInfo = new long[4];
        this.isValid = false;
    }

    public void addInputEventInfo(long r7) {
        long[] r0 = this.mainThreadInfo;
        if (r0[0] != 0) goto L5;
        r0[0] = SystemClock.uptimeMillis();
    L5:
        long[] r1 = this.mainThreadInfo;
        r1[1] = r1[1] + 1;
        if (r7 >= r1[2]) goto L9;
        r1[2] = r7;
    L9:
        if (r7 <= r1[3]) goto L11;
        r1[3] = r7;
    L11:
        this.isValid = true;
    }

    public boolean isInputDelayed() {
        long[] r5 = this.mainThreadInfo;
        if ((r5[0] - r5[2]) <= 100) goto L6;
        return true;
    L6:
        return false;
    }

    public void reset() {
        long[] r0 = this.mainThreadInfo;
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = Long.MAX_VALUE;
        r0[3] = 0;
        this.isValid = false;
    }
}
