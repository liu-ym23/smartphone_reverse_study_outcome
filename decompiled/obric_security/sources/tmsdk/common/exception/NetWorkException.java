package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class NetWorkException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f43a;

    public NetWorkException(int r1, String r2) {
        super(r2);
        this.f43a = r1;
    }

    public int getErrCode() {
        return this.f43a;
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

    public NetWorkException(int r1, String r2, Throwable r3) {
        super(r2, r3);
        this.f43a = r1;
    }

    public NetWorkException(int r2, Throwable r3) {
        super(r3.getMessage(), r3);
        this.f43a = r2;
    }
}
