package com.ss.ttuploader;

import android.text.TextUtils;
import com.bytedance.ttnet.m.d;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTUploadExternNetBridge implements TTExternNetLoaderListener {
    TTExternResponseInfo curResponseInfo;
    String extraInfo;
    volatile boolean isFinished;
    private Lock lock;
    long mHandle;

    public TTUploadExternNetBridge() {
        this.lock = new ReentrantLock();
        this.curResponseInfo = null;
        this.extraInfo = null;
        this.isFinished = false;
        this.mHandle = 0;
    }

    private native void nativeTTNetCallback(long r1);

    private native int nativeTTNetReadFileData(long r1, byte[] r3, long r4, int r6);

    public void cancelTask(Object r1) {
        TTExternNetLoader r2 = (TTExternNetLoader) r1;
        if (r2 == null) goto L6;
        r2.cancelTask();
        return;
    }

    public Object getExtraInfo() {
        this.lock.lock();     // Catch: Throwable -> L5
        String r0 = this.extraInfo;     // Catch: Throwable -> L5
        this.lock.unlock();
        return r0;
    L5:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public Object getResponseObject() {
        this.lock.lock();     // Catch: Throwable -> L5
        TTExternResponseInfo r0 = this.curResponseInfo;     // Catch: Throwable -> L5
        this.lock.unlock();
        return r0;
    L5:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int isFinished() {
        if (this.isFinished == true) goto L7;
        return 0;
    L7:
        return 1;
    }

    @Override // com.ss.ttuploader.TTExternNetLoaderListener
    public void onComplete(TTExternResponseInfo r3) {
        this.lock.lock();     // Catch: Throwable -> L5
        this.curResponseInfo = r3;     // Catch: Throwable -> L5
        this.isFinished = true;     // Catch: Throwable -> L5
        nativeTTNetCallback(this.mHandle);
        this.lock.unlock();
        return;
    L5:
        th = move-exception;
        nativeTTNetCallback(this.mHandle);
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.ttuploader.TTExternNetLoaderListener
    public void onFailed(String r3, Throwable r4) {
        this.lock.lock();     // Catch: Throwable -> L7
        this.isFinished = true;     // Catch: Throwable -> L7
        if (r4 == null) goto L5;
        this.extraInfo = r4.toString();     // Catch: Throwable -> L7
    L5:
        nativeTTNetCallback(this.mHandle);
        this.lock.unlock();
        return;
    L7:
        th = move-exception;
        nativeTTNetCallback(this.mHandle);
        this.lock.unlock();
        throw th;
    }

    @Override // com.ss.ttuploader.TTExternNetLoaderListener
    public int readFileData(byte[] r8, long r9, int r11) {
        return nativeTTNetReadFileData(this.mHandle, r8, r9, r11);
    }

    public void resetHandle() {
        this.lock.lock();     // Catch: Throwable -> L5
        this.mHandle = 0;     // Catch: Throwable -> L5
        this.lock.unlock();
        return;
    L5:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int sendRequest(Object r11, long r12, String r14, String r15, String r16, byte[] r17, int r18, int r19, int r20) {
        if (r11 != null) goto L5;
    L29:
        return -1;
    L5:
        if (r12 == 0) goto L29;
        if (TextUtils.isEmpty(r14) == true) goto L29;
        this.mHandle = r12;
        JSONObject r7 = new JSONObject(r16);     // Catch: Exception -> L12
    L13:
        TTExternNetLoader r3 = (TTExternNetLoader) r11;
        if (r7 == null) goto L29;
        if (r3 == null) goto L29;
        this.curResponseInfo = null;
        this.lock.lock();     // Catch: Throwable -> L26
        this.isFinished = false;     // Catch: Throwable -> L26
        this.lock.unlock();
        d r9 = new d();
        r9.f13374i = r19 + r20;
        r9.o = true;
        int r1 = r3.sendRequest(new TTExternRequestInfo(r14, r15, r7, r17, r9), this);     // Catch: Throwable -> L22
    L23:
        if (r1 >= 0) goto L25;
        return r1;
    L25:
        return 0;
    L22:
        r1 = -2;
    L26:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L12:
        r7 = null;
        goto L13
    }
}
