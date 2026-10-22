package com.ss.ttuploader.net;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class BaseDNS {
    private static final int MSG_IS_CANCELLED = 0;
    private static final int MSG_IS_ERROR = 2;
    private static final int MSG_IS_RETRY = 1;
    private static final int MSG_IS_SUCCESS = 3;
    private static final String TAG = "BaseDNS";
    protected boolean mCancelled;
    protected Handler mHandler;
    public String mHostname;
    public String mId;
    protected DNSCompletionListener mListener;
    protected TTVNetClient mNetClient;

    public BaseDNS(String r3, Handler r4) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r3;
        this.mHandler = r4;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public BaseDNS(String r2, TTVNetClient r3, Handler r4) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = r2;
        this.mHandler = r4;
        if (r3 != null) goto L5;
        r3 = new TTHTTPNetwork();
    L5:
        this.mNetClient = r3;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public void cancel() {
    }

    public void close() {
    }

    public boolean isRunning() {
        return true;
    }

    protected void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    protected void notifyError(TTUploadDNSInfo r3) {
        Message r4 = this.mHandler.obtainMessage(2, r3);
        this.mHandler.sendMessage(r4);
    }

    protected void notifyRetry(Error r3) {
        Message r4 = this.mHandler.obtainMessage(1, r3);
        this.mHandler.sendMessage(r4);
    }

    protected void notifySuccess(TTUploadDNSInfo r3) {
        Message r4 = this.mHandler.obtainMessage(3, r3);
        this.mHandler.sendMessage(r4);
    }

    public void setCompletionListener(DNSCompletionListener r1) {
        this.mListener = r1;
    }

    public void start() {
    }
}
