package com.slardaros.client.monitor.io;

import java.util.EventObject;

/* JADX INFO: loaded from: classes5.dex */
public final class StreamCompleteEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final long bytes;
    private final Exception exception;

    public StreamCompleteEvent(Object r1, long r2, Exception r4) {
        super(r1);
        this.bytes = r2;
        this.exception = r4;
    }

    public StreamCompleteEvent(Object r2, long r3) {
        this(r2, r3, null);
    }

    public long getBytes() {
        return this.bytes;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean isError() {
        if (this.exception == null) goto L5;
        return true;
    L5:
        return false;
    }
}
