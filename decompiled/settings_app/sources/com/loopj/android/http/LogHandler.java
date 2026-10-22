package com.loopj.android.http;

import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class LogHandler implements LogInterface {
    boolean mLoggingEnabled;
    int mLoggingLevel;

    public LogHandler() {
        this.mLoggingEnabled = true;
        this.mLoggingLevel = 2;
    }

    @Override // com.loopj.android.http.LogInterface
    public boolean isLoggingEnabled() {
        return this.mLoggingEnabled;
    }

    @Override // com.loopj.android.http.LogInterface
    public void setLoggingEnabled(boolean r1) {
        this.mLoggingEnabled = r1;
    }

    @Override // com.loopj.android.http.LogInterface
    public int getLoggingLevel() {
        return this.mLoggingLevel;
    }

    @Override // com.loopj.android.http.LogInterface
    public void setLoggingLevel(int r1) {
        this.mLoggingLevel = r1;
    }

    @Override // com.loopj.android.http.LogInterface
    public boolean shouldLog(int r1) {
        if (r1 < this.mLoggingLevel) goto L5;
        return true;
    L5:
        return false;
    }

    public void log(int r2, String r3, String r4) {
        logWithThrowable(r2, r3, r4, null);
    }

    public void logWithThrowable(int r2, String r3, String r4, Throwable r5) {
        if (isLoggingEnabled() == true) goto L5;
        return;
    L5:
        if (shouldLog(r2) == true) goto L7;
        return;
    L7:
        if (r2 != 2) goto L9;
        Log.v(r3, r4, r5);
        return;
    L9:
        if (r2 != 3) goto L11;
        Log.d(r3, r4, r5);
        return;
    L11:
        if (r2 != 4) goto L13;
        Log.i(r3, r4, r5);
        return;
    L13:
        if (r2 != 5) goto L15;
        Log.w(r3, r4, r5);
        return;
    L15:
        if (r2 != 6) goto L17;
        Log.e(r3, r4, r5);
        return;
    L17:
        if (r2 == 8) goto L20;
        return;
    L20:
        if (Integer.valueOf(Build.VERSION.SDK).intValue() <= 8) goto L22;
        checkedWtf(r3, r4, r5);
        return;
    L22:
        Log.e(r3, r4, r5);
    }

    private void checkedWtf(String r1, String r2, Throwable r3) {
        Log.wtf(r1, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void v(String r2, String r3) {
        log(2, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void v(String r2, String r3, Throwable r4) {
        logWithThrowable(2, r2, r3, r4);
    }

    @Override // com.loopj.android.http.LogInterface
    public void d(String r2, String r3) {
        log(2, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void d(String r2, String r3, Throwable r4) {
        logWithThrowable(3, r2, r3, r4);
    }

    @Override // com.loopj.android.http.LogInterface
    public void i(String r2, String r3) {
        log(4, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void i(String r2, String r3, Throwable r4) {
        logWithThrowable(4, r2, r3, r4);
    }

    @Override // com.loopj.android.http.LogInterface
    public void w(String r2, String r3) {
        log(5, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void w(String r2, String r3, Throwable r4) {
        logWithThrowable(5, r2, r3, r4);
    }

    @Override // com.loopj.android.http.LogInterface
    public void e(String r2, String r3) {
        log(6, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void e(String r2, String r3, Throwable r4) {
        logWithThrowable(6, r2, r3, r4);
    }

    @Override // com.loopj.android.http.LogInterface
    public void wtf(String r2, String r3) {
        log(8, r2, r3);
    }

    @Override // com.loopj.android.http.LogInterface
    public void wtf(String r2, String r3, Throwable r4) {
        logWithThrowable(8, r2, r3, r4);
    }
}
