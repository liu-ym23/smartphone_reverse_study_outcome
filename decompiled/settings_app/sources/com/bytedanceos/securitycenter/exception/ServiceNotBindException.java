package com.bytedanceos.securitycenter.exception;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceNotBindException extends RuntimeException {
    private static final String COMMON_EXCEPTION_MSG = "Security service not bind: %s";

    public static ServiceNotBindException forService(String r3) {
        return new ServiceNotBindException(String.format(COMMON_EXCEPTION_MSG, new Object[]{r3}));
    }

    public ServiceNotBindException(String r1) {
        super(r1);
    }
}
