package tmsdkobf;

import tmsdk.common.exception.UnauthorizedCallerException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n1 {
    public static void a(Class... r10) {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        if (r0.length != 0) goto L5;
        return;
    L5:
        int r1 = r0.length;
        int r3 = 0;
        boolean r4 = false;
    L6:
        if (r3 >= r1) goto L14;
        StackTraceElement r5 = r0[r3];
        int r6 = r10.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        if (r5.getClassName().equals(r10[r7].getName()) == true) goto L11;
        r7 = r7 + 1;
        goto L8
    L11:
        r4 = true;
    L13:
        r3 = r3 + 1;
        goto L6
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        throw new UnauthorizedCallerException();
    }
}
