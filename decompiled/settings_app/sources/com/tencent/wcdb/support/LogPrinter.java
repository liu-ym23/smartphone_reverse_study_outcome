package com.tencent.wcdb.support;

import android.util.Printer;

/* JADX INFO: loaded from: classes5.dex */
public class LogPrinter implements Printer {
    private final int mPriority;
    private final String mTag;

    public LogPrinter(int r1, String r2) {
        this.mPriority = r1;
        this.mTag = r2;
    }

    @Override // android.util.Printer
    public void println(String r2) {
        Log.println(this.mPriority, this.mTag, r2);
    }
}
