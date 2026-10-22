package com.bytedance.apm.block;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class BlockRecord {
    long beginTime;
    boolean belongDump;
    boolean belongFrame;
    JSONObject cpuInfo;
    long currentTime;
    boolean delayDoFrame;
    boolean delayInputEvent;
    long endTime;
    boolean ignoreStack;
    volatile boolean isErrorStack;
    boolean isPollOnce;
    boolean isSeriousBlock;
    boolean isValid;
    String lastScene;
    JSONObject looperMessages;
    JSONObject memoryInfo;
    String msg;
    JSONObject perfInfo;
    StackTraceElement[] stackTrace;
    StackTraceElement[] stackTrace2;
    String trace;
    long traceTime;
    long traceTime2;
    String uuid;

    BlockRecord(long r4, String r6) {
        this.isValid = true;
        this.belongDump = false;
        this.belongFrame = false;
        this.delayInputEvent = false;
        this.delayDoFrame = false;
        this.beginTime = -1;
        this.endTime = -1;
        this.isSeriousBlock = false;
        this.isPollOnce = false;
        this.isErrorStack = false;
        this.beginTime = r4;
        this.msg = r6;
    }

    BlockRecord getCopy() {
        BlockRecord r0 = new BlockRecord(this.beginTime, this.msg);
        r0.endTime = this.endTime;
        r0.isValid = this.isValid;
        r0.belongDump = this.belongDump;
        r0.belongFrame = this.belongFrame;
        r0.delayInputEvent = this.delayInputEvent;
        r0.delayDoFrame = this.delayDoFrame;
        r0.currentTime = this.currentTime;
        r0.isSeriousBlock = this.isSeriousBlock;
        r0.isPollOnce = this.isPollOnce;
        r0.traceTime = this.traceTime;
        r0.traceTime2 = this.traceTime2;
        r0.stackTrace = this.stackTrace;
        r0.stackTrace2 = this.stackTrace2;
        r0.trace = this.trace;
        r0.uuid = this.uuid;
        r0.lastScene = this.lastScene;
        r0.looperMessages = this.looperMessages;
        r0.cpuInfo = this.cpuInfo;
        r0.memoryInfo = this.memoryInfo;
        r0.perfInfo = this.perfInfo;
        r0.ignoreStack = this.ignoreStack;
        return r0;
    }

    void reset(long r1, String r3) {
        this.beginTime = r1;
        this.msg = r3;
        this.endTime = -1;
        this.isValid = false;
    }

    void reset() {
        this.isValid = true;
        this.belongDump = false;
        this.belongFrame = false;
        this.delayInputEvent = false;
        this.delayDoFrame = false;
        this.currentTime = 0;
        this.isSeriousBlock = false;
        this.isErrorStack = false;
        this.isPollOnce = false;
        this.ignoreStack = false;
        this.traceTime = 0;
        this.traceTime2 = 0;
        this.stackTrace = null;
        this.stackTrace2 = null;
        this.trace = null;
        this.uuid = null;
        this.lastScene = null;
        this.looperMessages = null;
        this.cpuInfo = null;
        this.memoryInfo = null;
        this.perfInfo = null;
    }
}
