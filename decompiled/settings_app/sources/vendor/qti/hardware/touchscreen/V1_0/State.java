package vendor.qti.hardware.touchscreen.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class State {
    public static final int OFF = 0;
    public static final int ON = 1;

    public State() {
    }

    public static final String toString(int r2) {
        if (r2 != 0) goto L6;
        return "OFF";
    L6:
        if (r2 != 1) goto L10;
        return "ON";
    L10:
        return "0x" + Integer.toHexString(r2);
    }

    public static final String dumpBitfield(int r4) {
        ArrayList r0 = new ArrayList();
        r0.add("OFF");
        int r2 = 1;
        if ((r4 & 1) != 1) goto L5;
        r0.add("ON");
    L6:
        if (r4 == r2) goto L9;
        r0.add("0x" + Integer.toHexString(r4 & (~r2)));
    L9:
        return String.join(" | ", r0);
    L5:
        r2 = 0;
        goto L6
    }
}
