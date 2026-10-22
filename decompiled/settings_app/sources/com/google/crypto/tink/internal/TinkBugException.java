package com.google.crypto.tink.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class TinkBugException extends RuntimeException {

    public interface ThrowingRunnable {
        void run() throws Exception;
    }

    public interface ThrowingSupplier<T> {
        T get() throws Exception;
    }

    public TinkBugException(String message) {
        super(message);
    }

    public TinkBugException(String message, Throwable cause) {
        super(message, cause);
    }

    public TinkBugException(Throwable cause) {
        super(cause);
    }

    public static <T> T exceptionIsBug(ThrowingSupplier<T> t) {
        return t.get();
    L4:
        e = move-exception;
        throw new TinkBugException(e);
    }

    public static void exceptionIsBug(ThrowingRunnable v) {
        v.run();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        throw new TinkBugException(e);
    }
}
