package com.ss.ttuploader.net;

import android.os.Handler;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.ss.ttuploader.TTUploadLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    private static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public MyRunnable(LocalDNS r2) {
            this.mLocalDNSRef = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            TTUploadLog.d(LocalDNS.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            LocalDNS r10 = this.mLocalDNSRef.get();
            if (r10 != null) goto L7;
            TTUploadLog.d(LocalDNS.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
            return;
        L7:
            if (LocalDNS.access$100(r10) == true) goto L10;
            r10.cancel();
            TTUploadLog.d(LocalDNS.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
            r10.notifyError(new TTUploadDNSInfo(0, r10.mHostname, null, 0, r10.mId));
            return;
        }
    }

    public LocalDNS(String r1, Handler r2) {
        super(r1, r2);
        this.mRet = false;
    }

    static /* synthetic */ InetAddress[] access$000(LocalDNS r0) {
        return r0.mAddress;
    }

    static /* synthetic */ InetAddress[] access$002(LocalDNS r0, InetAddress[] r1) {
        r0.mAddress = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(LocalDNS r0) {
        return r0.mRet;
    }

    static /* synthetic */ boolean access$102(LocalDNS r0, boolean r1) {
        r0.mRet = r1;
        return r1;
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public void cancel() {
        if (this.mCancelled == false) goto L5;
        return;
    L5:
        this.mCancelled = true;
        Future r1 = this.mFuture;
        if (r1 == null) goto L9;
        r1.cancel(true);
        this.mFuture = null;
        return;
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public void close() {
        super.close();
        Future r0 = this.mFuture;
        if (r0 == null) goto L6;
        r0.cancel(true);
        this.mFuture = null;
        return;
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }

    @Override // com.ss.ttuploader.net.BaseDNS
    public void start() {
        this.mFuture = TTUploadThreadPool.addExecuteTask(new AnonymousClass1(this));     // Catch: Exception -> L4
    L6:
        this.mHandler.postDelayed(new MyRunnable(this), BDLocationConfig.sScanBleMaxInterval);
        return;
    L4:
        e = move-exception;
        TTUploadLog.d(TAG, String.format("****end call local dns, exception:%s host:%s", new Object[]{e, this.mHostname}));
        notifyError(new TTUploadDNSInfo(0, this.mHostname, null, 0, this.mId));
        goto L6
    }
}
