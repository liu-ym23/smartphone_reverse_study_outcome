package com.bytedance.frameworks.baselib.network.http.exception;

import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* JADX INFO: loaded from: classes3.dex */
public class ClientProtocolException extends TTNetExceptionStorage {
    private static final long serialVersionUID = -5596590843227115865L;

    public ClientProtocolException() {
    }

    public ClientProtocolException(String r1) {
        super(r1);
    }

    public ClientProtocolException(Throwable r1) {
        initCause(r1);
    }

    public ClientProtocolException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
