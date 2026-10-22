package com.bytedance.common.wschannel.q;

import android.text.TextUtils;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import k.h;

/* JADX INFO: loaded from: classes.dex */
class c implements a {
    c() {
    }

    private static String c(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder(r4);
        int r5 = r0.indexOf("ttnet;");
        if (r5 >= 0) goto L8;
        return null;
    L8:
        r0.insert(r5 + 6, "recv_time=" + System.currentTimeMillis() + ";");
        return r0.toString();
    }

    @Override // com.bytedance.common.wschannel.q.a
    public WsChannelMsg a(byte[] r13) {
        Frame r12 = Frame.ADAPTER.decode(r13);
        long r0 = ((Long) Wire.get(r12.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r2 = ((Long) Wire.get(r12.logid, Frame.DEFAULT_LOGID)).longValue();
        int r14 = ((Integer) Wire.get(r12.service, Frame.DEFAULT_SERVICE)).intValue();
        int r4 = ((Integer) Wire.get(r12.method, Frame.DEFAULT_METHOD)).intValue();
        List r5 = (List) Wire.get(r12.headers, Collections.emptyList());
        String r6 = (String) Wire.get(r12.payload_encoding, "");
        String r8 = (String) Wire.get(r12.payload_type, "");
        byte[] r9 = ((h) Wire.get(r12.payload, Frame.DEFAULT_PAYLOAD)).E();
        String r10 = (String) Wire.get(r12.serverTiming, "");
        String r15 = (String) Wire.get(r12.msgId, "");
        WsChannelMsg r11 = new WsChannelMsg();
        r11.A(r2);
        r11.M(r0);
        r11.O(r14);
        r11.C(r4);
        if (r5 != null) goto L5;
    L11:
        r11.H(r6);
        r11.K(r8);
        r11.G(r9);
        String r16 = c(r10);
        if (TextUtils.isEmpty(r16) == true) goto L14;
        r10 = r16;
    L14:
        r11.N(r10);
        r11.E(r15);
        return r11;
    L5:
        if (r5.size() < 0) goto L11;
        ArrayList r17 = new ArrayList();
        Iterator r1 = r5.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Frame.b r3 = (Frame.b) r1.next();
        WsChannelMsg.MsgHeader r7 = new WsChannelMsg.MsgHeader();
        r7.e((String) Wire.get(r3.f3567f, ""));
        r7.f((String) Wire.get(r3.f3568g, ""));
        r17.add(r7);
        goto L8
    L10:
        r11.D(r17);
        goto L11
    }

    @Override // com.bytedance.common.wschannel.q.a
    public byte[] b(WsChannelMsg r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.i() == null) goto L8;
        h r4 = h.u(r5.i());
    L9:
        Frame.a r0 = new Frame.a();
        r0.c(Long.valueOf(r5.d()));
        r0.j(Long.valueOf(r5.q()));
        r0.l(Integer.valueOf(r5.s()));
        r0.h(r5.j());
        r0.i(r5.l());
        r0.g(r4);
        r0.e(Integer.valueOf(r5.f()));
        List<WsChannelMsg.MsgHeader> r6 = r5.g();
        ArrayList r7 = new ArrayList();
        if (r6 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r1 = r8.next();
        Frame.b.a r2 = new Frame.b.a();
        r2.b(r1.b());
        r2.c(r1.d());
        r7.add(r2.a());
    L16:
        if (r7.isEmpty() == true) goto L19;
        r0.b(r7);
    L19:
        return Frame.ADAPTER.encode(r0.a());
    L8:
        r4 = h.f18266i;
        goto L9
    }
}
