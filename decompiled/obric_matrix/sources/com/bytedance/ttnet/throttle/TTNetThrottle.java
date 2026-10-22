package com.bytedance.ttnet.throttle;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;

/* JADX INFO: loaded from: classes.dex */
public class TTNetThrottle {
    public static final int DIRECTION_TYPE_DOWN = 2;
    public static final int DIRECTION_TYPE_PC_DOWN = 8;
    public static final int DIRECTION_TYPE_PC_UP = 4;
    public static final int DIRECTION_TYPE_UP = 1;
    private static final String TAG = "TTNetThrottle";

    public TTNetThrottle() {
    }

    private static j getCronetHttpClient() {
        if (d.c() == false) goto L7;
        return j.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    public static void start(String[] r2, int r3, long r4) {
        if (r2 != null) goto L4;
    L16:
        Logger.debug();
        return;
    L4:
        if (r3 == 1) goto L12;
        if (r3 == 2) goto L12;
        if (r3 == 4) goto L12;
        if (r3 != 8) goto L16;
    L12:
        if (r4 < 0) goto L16;
        getCronetHttpClient().W(r2, r3, r4);     // Catch: Throwable -> L18
        return;
    }

    public static void stop(String[] r1, int r2) {
        if (r1 != null) goto L4;
    L14:
        Logger.debug();
        return;
    L4:
        if (r2 != 1) goto L6;
    L17:
        getCronetHttpClient().X(r1, r2);     // Catch: Throwable -> L16
        return;
    L19:
        return;
    L6:
        if (r2 == 2) goto L17;
        if (r2 == 4) goto L17;
        if (r2 == 8) goto L17;
        goto L14
    }
}
