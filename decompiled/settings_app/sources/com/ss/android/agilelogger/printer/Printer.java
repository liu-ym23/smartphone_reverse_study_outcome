package com.ss.android.agilelogger.printer;

import com.ss.android.agilelogger.LogItem;

/* JADX INFO: loaded from: classes5.dex */
public interface Printer {
    void flush();

    void println(LogItem r1);

    void release();
}
