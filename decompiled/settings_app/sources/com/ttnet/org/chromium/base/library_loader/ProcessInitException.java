package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes5.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int r3) {
        super("errorCode=" + r3);
    }

    public ProcessInitException(int r3, Throwable r4) {
        super("errorCode=" + r3, r4);
    }
}
