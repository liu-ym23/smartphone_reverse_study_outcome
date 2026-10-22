package com.ttnet.org.chromium.base.library_loader;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessInitException extends RuntimeException {
    public ProcessInitException(int r2) {
        super(a.a.e(r2, "errorCode="));
    }

    public ProcessInitException(int r2, Throwable r3) {
        super(a.a.e(r2, "errorCode="), r3);
    }
}
