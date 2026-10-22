package com.bytedance.privacy.attestation;

import android.text.TextUtils;
import com.bytedance.security.eventproto.monitor.ErrorEvent;
import com.bytedance.security.eventproto.monitor.NormalEvent;
import com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper;

/* JADX INFO: loaded from: classes.dex */
public class IdAttestationEventTrace {
    public static void a(int r6, String r7, String r8, long r9, AttestationConfig r11) {
        if (r6 != 0) goto L5;
        NormalEvent.eventReport(1, 0, r7, r8, r9);
        return;
    L5:
        AttestationConfigInfoWrapper.Builder r10 = AttestationConfigInfoWrapper.newBuilder();
        boolean[] r0 = r11.f6a;
        ErrorEvent.eventReport(1, 0, r7, r8, r6, r10.setReqUdid(r0[0]).setReqRpdid(r0[1]).setReqRpuid(r0[2]).setAddCustomInfo(true ^ TextUtils.isEmpty(r11.b)).setDevHealthStatusRequired(r11.c).build());
    }
}
