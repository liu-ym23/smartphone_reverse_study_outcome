package com.slardaros.client;

/* JADX INFO: loaded from: classes5.dex */
public class ErrorEvent extends AgentEvent {
    public boolean isCatchLog;
    public boolean isDelete;
    public String mLogPath;
    public String mPackageName;
    public String mSummary;
    public String mTag;
    public String mType;

    public ErrorEvent(String r1, String r2, String r3, String r4, boolean r5, String r6, boolean r7) {
        this.mTag = r1;
        this.mType = r2;
        this.mSummary = r3;
        this.mLogPath = r4;
        this.isDelete = r5;
        this.mPackageName = r6;
        this.isCatchLog = r7;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String r1) {
        this.mTag = r1;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public void setSummary(String r1) {
        this.mSummary = r1;
    }

    public String getLogPath() {
        return this.mLogPath;
    }

    public void setLogPath(String r1) {
        this.mLogPath = r1;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public void setDelete(boolean r1) {
        this.isDelete = r1;
    }

    public boolean isCatchLog() {
        return this.isCatchLog;
    }

    public void setCatchLog(boolean r1) {
        this.isCatchLog = r1;
    }

    public String toString() {
        return "ErrorEvent{mTag='" + this.mTag + "', mType='" + this.mType + "', mSummary='" + this.mSummary + "', mLogPath='" + this.mLogPath + "', isCatchLog='" + this.isCatchLog + "', isDelete=" + this.isDelete + '}';
    }

    public void setPackageName(String r1) {
        this.mPackageName = r1;
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
