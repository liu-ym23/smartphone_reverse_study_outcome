package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes.dex */
public class ReportTrafficEntity extends TrafficLogEntity {
    private long endTime;

    public ReportTrafficEntity(long r11, int r13, int r14, int r15, long r16, long r18, long r20) {
        super(r11, r13, r14, r15, r16, r20);
        this.endTime = r18;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return getTime();
    }
}
