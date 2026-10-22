package com.bytedance.sysoptimizer;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes2.dex */
public class StackLeakItem {
    private int leakCount;
    private String soBuildId;
    private long soEndAddr;
    private String soPath;
    private long soStartAddr;
    private long startRoutine;
    private long startRoutineOffset;

    public String getBuildId() {
        return this.soBuildId;
    }

    public int getLeakCount() {
        return this.leakCount;
    }

    public long getOffset() {
        return this.startRoutineOffset;
    }

    public String getSoName() {
        String r0 = this.soPath;
        if (r0 == null) goto L9;
        int r1 = r0.lastIndexOf(47);
        if (r1 < 0) goto L9;
        if (r1 >= (this.soPath.length() - 1)) goto L9;
        return this.soPath.substring(r1 + 1);
    L9:
        return NetworkStackConstant.UNKNOWN_TYPE;
    }

    public String getLeakItem() {
        return "[" + this.leakCount + "] stacks leaked: " + Long.toHexString(this.startRoutineOffset) + " " + Long.toHexString(this.soStartAddr) + "-" + Long.toHexString(this.soEndAddr) + " r-xp " + getSoName() + " (" + this.soBuildId + ")";
    }

    public StackLeakItem(int r1, long r2, long r4, long r6, String r8, String r9) {
        this.leakCount = r1;
        this.startRoutine = r2;
        this.soStartAddr = r4;
        this.soEndAddr = r6;
        this.soPath = r8;
        this.soBuildId = r9;
        this.startRoutineOffset = r2 - r4;
    }
}
