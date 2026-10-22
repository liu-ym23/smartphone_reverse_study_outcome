package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class URLDispatch {
    public static final String KEY_EPOCH = "epoch";
    public static final String KEY_ETAG = "etag";
    public static final String KEY_FINAL_URL = "final_url";
    public static final String KEY_TTNET_ORIGIN_HOST = "ttnet_origin_host";
    private static final String TAG = "URLDispatch";
    private static final int TIME_OUT_MILLISECONDS = 300;
    private String mEpoch;
    private String mEtag;
    private String mFinalUrl;
    private MessageLoop mMessageLoop;
    private String mOriginalUrl;
    private String mTTNetOriginHost;

    static {
    }

    public URLDispatch(String r1) {
        this.mOriginalUrl = r1;
        this.mMessageLoop = new MessageLoop();
    }

    public void done() {
        this.mMessageLoop.quit();
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }

    public void resume(Runnable r3) {
        this.mMessageLoop.execute(r3);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception URLDispatch resume ", new Object[]{e});
    }

    public void setResult(String r1, String r2, String r3, String r4) {
        this.mFinalUrl = r1;
        this.mEtag = r2;
        this.mEpoch = r3;
        this.mTTNetOriginHost = r4;
    }

    public void waitResult(int r1) {
        MessageLoop r0 = this.mMessageLoop;
        if (r1 > 0) goto L6;
        r1 = 300;
    L6:
        r0.loop(r1);
    }
}
