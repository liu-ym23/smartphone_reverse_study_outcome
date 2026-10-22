package com.bytedance.apm.battery.stats.info;

import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHookInfo {
    public StackTraceElement[] elements;
    public long endTime;
    public long startTime;
    public String threadName;

    public BaseHookInfo() {
    }

    String getStackDetails() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 9;
    L4:
        if (r1 >= this.elements.length) goto L7;
        r0.append("\tat ").append(this.elements[r1].toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
