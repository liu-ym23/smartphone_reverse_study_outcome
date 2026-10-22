package com.bytedance.apm6.java_alloc;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class Trace {
    byte[] buffer;
    byte[] buffer2;
    int position;
    ByteBuffer stream;

    public Trace() {
        this.buffer = new byte[4096];
        this.buffer2 = new byte[4096];
    }

    public void onTrace(ITraceReader r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r0 = getTraceLength();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L10;
        int r6 = JavaAllocCollector.fillStringBytes(this.stream, this.buffer);
        int r8 = JavaAllocCollector.fillStringBytes(this.stream, this.buffer2);
        int r9 = this.stream.getInt();
        if (r11.onItem(this.buffer, r6, this.buffer2, r8, r9) == false) goto L13;
        r1 = r1 + 1;
        goto L5
    L13:
        return;
    }

    public int getTraceLength() {
        this.stream.position(this.position);
        return this.stream.getInt();
    }

    public void setStream(ByteBuffer r1) {
        this.stream = r1;
        this.position = r1.position();
    }
}
