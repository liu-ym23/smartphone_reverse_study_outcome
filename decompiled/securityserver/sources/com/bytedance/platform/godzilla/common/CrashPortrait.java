package com.bytedance.platform.godzilla.common;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public class CrashPortrait {
    public String appVersion;
    public String clazzName;
    public String detailMessage;
    public String methodName;
    public int osVersion;
    public String processName;
    public String threadName;
    public String throwableClassName;
    public int updateVersion;

    public CrashPortrait() {
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("CrashPortrait{processName='");
        r0.append(this.processName);
        r0.append("', clazzName='");
        r0.append(this.clazzName);
        r0.append("', methodName='");
        r0.append(this.methodName);
        r0.append("', threadName='");
        r0.append(this.threadName);
        r0.append("', appVersion='");
        r0.append(this.appVersion);
        r0.append("', updateVersion=");
        r0.append(this.updateVersion);
        r0.append(", detailMessage='");
        r0.append(this.detailMessage);
        r0.append("', throwableClassName='");
        r0.append(this.throwableClassName);
        r0.append("', osVersion=");
        return a.l(r0, this.osVersion, '}');
    }
}
