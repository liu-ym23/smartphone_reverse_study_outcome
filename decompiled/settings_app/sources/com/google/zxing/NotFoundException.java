package com.google.zxing;

/* JADX INFO: loaded from: classes4.dex */
public final class NotFoundException extends ReaderException {
    private static final NotFoundException INSTANCE = null;

    static {
        NotFoundException r0 = new NotFoundException();
        INSTANCE = r0;
        r0.setStackTrace(NO_TRACE);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return INSTANCE;
    }
}
