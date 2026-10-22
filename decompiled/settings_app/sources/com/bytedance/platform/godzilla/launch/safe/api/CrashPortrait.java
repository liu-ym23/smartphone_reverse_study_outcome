package com.bytedance.platform.godzilla.launch.safe.api;

/* JADX INFO: loaded from: classes3.dex */
public class CrashPortrait {
    public String clazzName;
    public String detailMessage;
    public String methodName;
    public int osVersion;
    public String processName;
    public String threadName;
    public String throwableClassName;

    public CrashPortrait() {
    }

    public String toString() {
        return "CrashPortrait{processName='" + this.processName + "', clazzName='" + this.clazzName + "', methodName='" + this.methodName + "', threadName='" + this.threadName + "', detailMessage='" + this.detailMessage + "', throwableClassName='" + this.throwableClassName + "', osVersion=" + this.osVersion + '}';
    }
}
