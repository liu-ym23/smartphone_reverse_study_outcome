package com.bytedanceos.securitycenter.exception;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidCallerException extends RemoteException {
    private static final String COMMON_EXCEPTION_MSG = "Bind by non-permitted app: %s";

    public static InvalidCallerException fromCaller(String r3) {
        return new InvalidCallerException(String.format(COMMON_EXCEPTION_MSG, new Object[]{r3}));
    }

    public InvalidCallerException(String r1) {
        super(r1);
    }
}
