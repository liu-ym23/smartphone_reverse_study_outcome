package vendor.qti.hardware.touchscreen.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class Status {
    public static final int OK = 0;
    public static final int UNKNOWN_ERROR = 1;
    public static final int UNSUPPORTED_OPERATION = 2;

    public Status() {
    }

    public static final String toString(int r2) {
        if (r2 != 0) goto L6;
        return "OK";
    L6:
        if (r2 != 1) goto L10;
        return "UNKNOWN_ERROR";
    L10:
        if (r2 != 2) goto L14;
        return "UNSUPPORTED_OPERATION";
    L14:
        return "0x" + Integer.toHexString(r2);
    }

    public static final String dumpBitfield(int r4) {
        ArrayList r0 = new ArrayList();
        r0.add("OK");
        int r2 = 1;
        if ((r4 & 1) != 1) goto L5;
        r0.add("UNKNOWN_ERROR");
    L7:
        if ((r4 & 2) != 2) goto L9;
        r0.add("UNSUPPORTED_OPERATION");
        r2 = r2 | 2;
    L9:
        if (r4 == r2) goto L12;
        r0.add("0x" + Integer.toHexString(r4 & (~r2)));
    L12:
        return String.join(" | ", r0);
    L5:
        r2 = 0;
        goto L7
    }
}
