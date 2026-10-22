package com.bytedance.privacy.pseudoid;

import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;

/* JADX INFO: loaded from: classes.dex */
public class PseudoIDEventTrace {
    public PseudoIDEventTrace() {
    }

    public static void eventTrace(int r7, int r8, String r9, String r10, long r11) {
        if (r7 != 0) goto L4;
        NormalEvent.eventReport(0, r8, r9, r10, r11);
        return;
    L4:
        ErrorEvent.eventReport(0, r8, r9, r10, r7, null);
    }
}
