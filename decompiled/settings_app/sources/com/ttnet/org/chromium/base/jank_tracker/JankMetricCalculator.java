package com.ttnet.org.chromium.base.jank_tracker;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
class JankMetricCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS = 50000000;
    private static final long JANK_THRESHOLD_NS = 16000000;
    private static final long NANOSECONDS_PER_MILLISECOND = 1000000;

    static {
    }

    JankMetricCalculator() {
    }

    private static long[] calculateJankBurstDurationsNs(long[] r10, long[] r11) {
        ArrayList r0 = new ArrayList();
        int r3 = 0;
        long r4 = 0;
    L4:
        if (r3 >= r10.length) goto L26;
        if (r3 > 0) goto L7;
    L11:
        long r6 = r11[r3];
        if (isFrameJanky(r3, r11) == false) goto L15;
    L13:
        r4 = r4 + r6;
    L24:
        r3 = r3 + 1;
        goto L4
    L15:
        if (r4 <= 0) goto L24;
        if (areFramesConsecutive(r3 - 1, r3, r10, r11) == false) goto L23;
        int r8 = r3 + 1;
        if (areFramesConsecutive(r3, r8, r10, r11) == false) goto L23;
        if (isFrameJanky(r8, r11) == true) goto L13;
    L23:
        r0.add(Long.valueOf(r4));
        r4 = 0;
        goto L24
    L7:
        if (r4 <= 0) goto L11;
        if (areFramesConsecutive(r3 - 1, r3, r10, r11) == true) goto L11;
        r0.add(Long.valueOf(r4));
        r4 = 0;
        goto L11
    L26:
        if (r4 <= 0) goto L29;
        r0.add(Long.valueOf(r4));
    L29:
        return longArrayToPrimitiveArray((Long[]) r0.toArray(new Long[r0.size()]));
    }

    static JankMetrics calculateJankMetrics(FrameMetrics r4) {
        long[] r0 = longArrayToPrimitiveArray(r4.timestampsNs);
        long[] r1 = longArrayToPrimitiveArray(r4.durationsNs);
        int r5 = sumArray(r4.skippedFrames);
        return new JankMetrics(r0, r1, calculateJankBurstDurationsNs(r0, r1), r5);
    }

    private static boolean isFrameJanky(int r3, long[] r4) {
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (r3 < r4.length) goto L8;
        return false;
    L8:
        if (r4[r3] <= JANK_THRESHOLD_NS) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean areFramesConsecutive(int r5, int r6, long[] r7, long[] r8) {
        if (r5 < 0) goto L15;
        if (r6 >= 0) goto L7;
        return false;
    L7:
        if (r5 < r7.length) goto L9;
        return false;
    L9:
        if (r6 >= r7.length) goto L19;
        long r1 = r7[r5];
        if (((r7[r6] - r8[r6]) - r1) >= JANK_BURST_CONSECUTIVE_FRAME_THRESHOLD_NS) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    L15:
        return false;
    }

    private static long[] longArrayToPrimitiveArray(Long[] r4) {
        long[] r0 = new long[r4.length];
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0[r1] = r4[r1].longValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static int sumArray(Integer[] r4) {
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + r4[r1].intValue();
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }
}
