package tmsdkobf;

import com.obric.matrix.platform.sdk.ones.internal.monitor.SdkErrorCode;

/* JADX INFO: loaded from: classes5.dex */
public class s5 {
    public static final s5 b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k3 f499a;

    static {
        b = new s5();
    }

    public s5() {
    }

    public x5 a(byte[] r2, int r3, int r4) {
        o1 r1 = this.f499a.b;
        if (r1 == null) goto L19;
        r0.a r5 = r1.a(r2, r3, r4);     // Catch: Throwable -> L13
        if (r5 != null) goto L8;
        x5 r6 = x5.a(SdkErrorCode.ERROR_SEND_CMD_ERROR);     // Catch: Throwable -> L13
    L15:
        return r6;
    L8:
        int r7 = r5.f463a;     // Catch: Throwable -> L13
        if (r7 == 0) goto L12;
        r6 = x5.a(r7 + SdkErrorCode.ERROR_SEND_CMD_ERROR);     // Catch: Throwable -> L13
        goto L15
    L12:
        r6 = new x5(0, r5.b, 0, 0);     // Catch: Throwable -> L13
    L18:
        return x5.a(SdkErrorCode.ERROR_SEND_CMD_ERROR);
    L19:
        return x5.a(SdkErrorCode.ERROR_SEND_CMD_ERROR);
    }
}
