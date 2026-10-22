package com.ss.android.agilelogger;

import com.ss.android.agilelogger.utils.FormatUtils;

/* JADX INFO: loaded from: classes4.dex */
public class LogItem {
    public String className;
    public String lineNum;
    public FormatUtils.TYPE mFormatType;
    public int mLevel;
    public boolean mMainThread;
    public String mMsg;
    public Object mObj;
    public Object mObj2;
    public String mStackTraceInfo;
    public String mTag;
    public long mThreadId;
    public String mThreadInfo;
    public String methodName;
    public int oprationType;

    @Deprecated
    public void recycle() {
    }

    public LogItem() {
        this.oprationType = -1;
    }

    public static LogItem obtain() {
        return new LogItem();
    }

    public static LogItem obtain(int r1, String r2, String r3, long r4, boolean r6) {
        LogItem r0 = obtain();
        r0.mLevel = r1;
        r0.mTag = r2;
        r0.mMsg = r3;
        r0.mThreadId = r4;
        r0.mMainThread = r6;
        return r0;
    }

    public static LogItem obtain(int r1, String r2, String r3, String r4, String r5) {
        LogItem r0 = obtain();
        r0.mLevel = r1;
        r0.mTag = r2;
        r0.mMsg = r3;
        r0.mThreadInfo = r4;
        r0.mStackTraceInfo = r5;
        return r0;
    }
}
