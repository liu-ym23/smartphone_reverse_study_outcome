package com.ss.ttuploader.net;

import android.text.TextUtils;
import com.ss.ttuploader.TTUploadLog;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadDNSParserBridge implements TTUploadDNSParserListener {
    private static final String TAG = "TTUploadDNSParserBridge";
    private long handle;
    public String host;
    String ipList;
    boolean isFinish;
    private Lock lock;

    public TTUploadDNSParserBridge() {
        this.ipList = null;
        this.isFinish = false;
        this.lock = new ReentrantLock();
        this.handle = 0;
    }

    private static native void _notifyParserResult(long r0, String r2, String r3, long r4, String r6);

    public String getResult() {
        this.lock.lock();
        String r0 = this.ipList;     // Catch: Throwable -> L6
        this.lock.unlock();
        TTUploadLog.d(TAG, "****get result:" + r0);
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.ss.ttuploader.net.TTUploadDNSParserListener
    public void onCompletion(int r10, String r11, String r12, long r13, String r15) {
        this.lock.lock();
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        if (this.isFinish == true) goto L9;
        TTUploadLog.d(TAG, String.format("receive completion code:%d result:%s", new Object[]{Integer.valueOf(r10), r12}));     // Catch: Throwable -> L12
        this.ipList = r12;     // Catch: Throwable -> L12
        this.isFinish = true;     // Catch: Throwable -> L12
        long r2 = this.handle;     // Catch: Throwable -> L12
        if (r2 == 0) goto L10;
        _notifyParserResult(r2, r11, r12, r13, r15);     // Catch: Throwable -> L12
    L10:
        this.lock.unlock();
        return;
    L9:
        TTUploadLog.d(TAG, String.format("has finished not nedd cur completion code:%d result:%s expiredTime:%d", new Object[]{Integer.valueOf(r10), r12, Long.valueOf(r13)}));     // Catch: Throwable -> L12
        goto L10
    }

    public void release() {
        this.lock.lock();
        this.handle = 0;     // Catch: Throwable -> L6
        TTUploadDNSParser.getInstance().removeHost(this.host, this);     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int start(long r9, String r11) {
        TTUploadLog.d(TAG, "----start parse host:" + r11);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        TTUploadLog.d(TAG, "****end parse fail for host:" + r11);
        return -1;
    L6:
        this.lock.lock();
        this.handle = r9;
        this.host = r11;     // Catch: Throwable -> L19
        TTUploadDNSInfo r10 = IPCache.getInstance().get(r11);     // Catch: Throwable -> L19
        int r12 = 1;
        if (r10 == null) goto L15;
        this.ipList = r10.mIpList;     // Catch: Throwable -> L19
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L19
        TTUploadLog.d(TAG, String.format("get result from cache expiredT:%d curT:%d ", new Object[]{Long.valueOf(r10.mExpiredTime), Long.valueOf(r2)}));     // Catch: Throwable -> L19
        if (r10.mExpiredTime > r2) goto L12;
        TTUploadLog.d(TAG, String.format("has expired try call parse:", new Object[0]));     // Catch: Throwable -> L19
        TTUploadDNSParser.getInstance().addHost(r11, null);     // Catch: Throwable -> L19
    L12:
        long r0 = this.handle;     // Catch: Throwable -> L19
        if (r0 == 0) goto L17;
        _notifyParserResult(r0, r11, this.ipList, r10.mExpiredTime, null);     // Catch: Throwable -> L19
    L17:
        this.lock.unlock();
        return r12;
    L15:
        TTUploadLog.d(TAG, "****add host to parser");     // Catch: Throwable -> L19
        TTUploadDNSParser.getInstance().addHost(r11, this);     // Catch: Throwable -> L19
        r12 = 0;
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }
}
