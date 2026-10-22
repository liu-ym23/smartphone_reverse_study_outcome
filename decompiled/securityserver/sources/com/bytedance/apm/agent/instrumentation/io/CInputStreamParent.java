package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class CInputStreamParent extends CInputStreamPParent {
    public CInputStreamParent(InputStream r2) {
        this(r2, false);
    }

    private boolean isEmpty() {
        return !this.buf.hasRemaining();
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r1) {
        this.callback.addStreamCompleteListener(r1);
    }

    public boolean bufLT(long r3) {
        if (this.buf.remaining() < r3) goto L5;
        return true;
    L5:
        return false;
    }

    public void callComplete() {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c);
        this.callback.notifyStreamComplete(r0);
        return;
    }

    public void callError(Exception r4) {
        if (this.callback.isComplete() == true) goto L6;
        StreamCompleteEvent r0 = new StreamCompleteEvent(this, this.c, r4);
        this.callback.notifyStreamError(r0);
        return;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    public int rb() {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        return this.buf.get();
    }

    @Override // java.io.InputStream
    public int read(byte[] r8) {
        int r0 = r8.length;
        int r2 = 0;
        if (this.cac == false) goto L44;
        ByteBuffer r1 = this.buf;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (bufLT(r0) == false) goto L18;
        int r9 = rb(r8);     // Catch: Throwable -> L14
        if (r9 < 0) goto L17;
        this.c += (long) r9;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r9;
    L17:
        throw new IOException("CountingInputStream wrong");     // Catch: Throwable -> L14
    L18:
        int r3 = this.buf.remaining();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L25;
        r2 = rb(r8, 0, r3);     // Catch: Throwable -> L14
        if (r2 < 0) goto L24;
        r0 = r0 - r2;     // Catch: Throwable -> L14
        this.c += (long) r2;     // Catch: Throwable -> L14
        goto L25
    L24:
        throw new IOException("CountingInputStream wrong2");     // Catch: Throwable -> L14
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L14
    L44:
        int r10 = this.impl.read(r8, r2, r0);     // Catch: IOException -> L33
        if (r10 < 0) goto L35;
        this.c += (long) r10;     // Catch: IOException -> L33
        return r10 + r2;
    L35:
        if (r2 > 0) goto L38;
        callComplete();     // Catch: IOException -> L33
        return r10;
    L38:
        return r2;
    L33:
        e = move-exception;
        CInputStreamPParent.sLog.error(e.toString());
        if (ApmContext.isDebugMode() == false) goto L42;
        Logger.i("APM-Counting", "notify system err: " + e);
        e.printStackTrace();
    L42:
        callError(e);
        throw e;
    }

    public void setBufferingEnabled(boolean r1) {
        this.cac = r1;
    }

    public CInputStreamParent(InputStream r1, boolean r2) {
        super(r1, r2);
    }

    private int rb(byte[] r3) {
        return rb(r3, 0, r3.length);
    }

    private int rb(byte[] r3, int r4, int r5) {
        if (isEmpty() == false) goto L6;
        return -1;
    L6:
        int r0 = this.buf.remaining();
        this.buf.get(r3, r4, r5);
        return r0 - this.buf.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.cac == false) goto L28;
        ByteBuffer r0 = this.buf;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (bufLT(1) == false) goto L15;
        int r3 = rb();     // Catch: Throwable -> L11
        if (r3 < 0) goto L13;
        this.c++;     // Catch: Throwable -> L11
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L28:
        int r1 = this.impl.read();     // Catch: IOException -> L22
        if (r1 < 0) goto L24;
        this.c++;     // Catch: IOException -> L22
    L25:
        return r1;
    L24:
        callComplete();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        callError(e);
        throw e;
    }
}
