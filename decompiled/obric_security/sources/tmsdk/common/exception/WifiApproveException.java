package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class WifiApproveException extends Exception {
    public WifiApproveException(String r1) {
        super(r1);
    }

    public String getErrMsg() {
        String r0 = getMessage();
        if (r0 != null) goto L7;
        Throwable r1 = getCause();
        if (r1 == null) goto L7;
        r0 = r1.getMessage();
    L7:
        if (r0 != null) goto L11;
        return "";
    L11:
        return r0;
    }

    public WifiApproveException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public WifiApproveException(Throwable r2) {
        super(r2.getMessage(), r2);
    }
}
