package com.bytedance.retrofit2.ttnet;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetExceptionStorage extends IOException {
    private static final long serialVersionUID = -1606114814728652693L;
    public Object infoObj;
    public boolean needReport;
    public boolean reportMonitorError;
    public boolean reportMonitorOk;
    public String traceCode;
    public String url;

    public TTNetExceptionStorage() {
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r1) {
        super(r1);
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r1, Throwable r2) {
        super(r1, r2);
        this.needReport = false;
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public void setInfo(boolean r1, boolean r2, boolean r3, String r4, String r5, Object r6) {
        this.needReport = r1;
        this.reportMonitorOk = r2;
        this.reportMonitorError = r3;
        this.url = r4;
        this.traceCode = r5;
        this.infoObj = r6;
    }

    public String getTraceCode() {
        return this.traceCode;
    }
}
