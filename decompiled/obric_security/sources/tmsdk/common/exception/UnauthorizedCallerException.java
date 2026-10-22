package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class UnauthorizedCallerException extends SecurityException {
    public static final String DEFAULT_MESSAGE = "The caller is not permitted";

    public UnauthorizedCallerException() {
        this(DEFAULT_MESSAGE);
    }

    public UnauthorizedCallerException(String r1) {
        super(r1);
    }

    public UnauthorizedCallerException(String r1, Throwable r2) {
        super(r1, r2);
    }
}
