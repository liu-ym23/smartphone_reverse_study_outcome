package com.bytedanceos.securitycenter.exception;

/* JADX INFO: loaded from: classes3.dex */
public class NoSuchAppException extends RuntimeException {
    private static final String COMMON_EXCEPTION_MSG = "No such APP: %s";

    public static NoSuchAppException forApp(String r3) {
        return new NoSuchAppException(String.format(COMMON_EXCEPTION_MSG, new Object[]{r3}));
    }

    public NoSuchAppException(String r1) {
        super(r1);
    }
}
