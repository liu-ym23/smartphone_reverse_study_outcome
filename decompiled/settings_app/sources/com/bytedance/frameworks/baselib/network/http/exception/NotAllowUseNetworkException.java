package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class NotAllowUseNetworkException extends IOException {
    private static final long serialVersionUID = -210264743726619965L;

    public NotAllowUseNetworkException() {
    }

    public NotAllowUseNetworkException(String r1) {
        super(r1);
    }

    public NotAllowUseNetworkException(Throwable r1) {
        initCause(r1);
    }

    public NotAllowUseNetworkException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
