package cz.msebera.android.httpclient.extras;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class HttpClientAndroidLog {
    private boolean debugEnabled;
    private boolean errorEnabled;
    private boolean infoEnabled;
    private String logTag;
    private boolean traceEnabled;
    private boolean warnEnabled;

    public HttpClientAndroidLog(Object r1) {
        this.logTag = r1.toString();
        this.debugEnabled = false;
        this.errorEnabled = false;
        this.traceEnabled = false;
        this.warnEnabled = false;
        this.infoEnabled = false;
    }

    public void enableDebug(boolean r1) {
        this.debugEnabled = r1;
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public void debug(Object r2) {
        if (isDebugEnabled() == false) goto L6;
        Log.d(this.logTag, r2.toString());
        return;
    }

    public void debug(Object r2, Throwable r3) {
        if (isDebugEnabled() == false) goto L6;
        Log.d(this.logTag, r2.toString(), r3);
        return;
    }

    public void enableError(boolean r1) {
        this.errorEnabled = r1;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public void error(Object r2) {
        if (isErrorEnabled() == false) goto L6;
        Log.e(this.logTag, r2.toString());
        return;
    }

    public void error(Object r2, Throwable r3) {
        if (isErrorEnabled() == false) goto L6;
        Log.e(this.logTag, r2.toString(), r3);
        return;
    }

    public void enableWarn(boolean r1) {
        this.warnEnabled = r1;
    }

    public boolean isWarnEnabled() {
        return this.warnEnabled;
    }

    public void warn(Object r2) {
        if (isWarnEnabled() == false) goto L6;
        Log.w(this.logTag, r2.toString());
        return;
    }

    public void warn(Object r2, Throwable r3) {
        if (isWarnEnabled() == false) goto L6;
        Log.w(this.logTag, r2.toString(), r3);
        return;
    }

    public void enableInfo(boolean r1) {
        this.infoEnabled = r1;
    }

    public boolean isInfoEnabled() {
        return this.infoEnabled;
    }

    public void info(Object r2) {
        if (isInfoEnabled() == false) goto L6;
        Log.i(this.logTag, r2.toString());
        return;
    }

    public void info(Object r2, Throwable r3) {
        if (isInfoEnabled() == false) goto L6;
        Log.i(this.logTag, r2.toString(), r3);
        return;
    }

    public void enableTrace(boolean r1) {
        this.traceEnabled = r1;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public void trace(Object r2) {
        if (isTraceEnabled() == false) goto L6;
        Log.i(this.logTag, r2.toString());
        return;
    }

    public void trace(Object r2, Throwable r3) {
        if (isTraceEnabled() == false) goto L6;
        Log.i(this.logTag, r2.toString(), r3);
        return;
    }
}
