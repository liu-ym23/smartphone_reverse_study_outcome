package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class OperationSecurityException extends Exception {
    public OperationSecurityException(String r1) {
        super(r1);
    }

    public OperationSecurityException(Throwable r2) {
        if (r2 == null) goto L4;
        String r0 = r2.getMessage();
    L5:
        super(r0, r2);
        return;
    L4:
        r0 = "";
        goto L5
    }
}
