package com.ttnet.org.chromium.base.jank_tracker;

/* JADX INFO: loaded from: classes5.dex */
class JankMetrics {
    public final long[] durationsNs;
    public final long[] jankBurstsNs;
    public final int skippedFrames;
    public final long[] timestampsNs;

    public JankMetrics(long[] r1, long[] r2, long[] r3, int r4) {
        this.timestampsNs = r1;
        this.durationsNs = r2;
        this.jankBurstsNs = r3;
        this.skippedFrames = r4;
    }
}
