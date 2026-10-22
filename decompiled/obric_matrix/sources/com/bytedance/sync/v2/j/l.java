package com.bytedance.sync.v2.j;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import d.b.u.r;

/* JADX INFO: loaded from: classes.dex */
public final class l implements com.bytedance.sync.v2.f.e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6121g;

    public l(int r1, int r2) {
        this.f6120f = r1;
        this.f6121g = r2;
    }

    public e F(WsChannelMsg r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.s() == 20032) goto L8;
        return null;
    L8:
        if (r3.f() != 1) goto L24;
        byte[] r0 = r3.i();
        if (r0 != null) goto L13;
    L20:
        return e.f6069h.decode(r0);
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        if (TextUtils.equals(r3.j(), d.b.u.p.f15071b) == false) goto L20;
        r0 = com.bytedance.sync.v2.l.b.e(r0);
        goto L20
    L24:
        return null;
    }

    @Override // com.bytedance.sync.v2.f.e
    public e I(byte[] r2) {
        if (r2 != null) goto L10;
        return null;
    L10:
        return e.f6069h.decode(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.sync.v2.f.e
    public byte[] s(e r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        return e.f6069h.encode(r1);
    }

    @Override // com.bytedance.sync.v2.f.e
    public WsChannelMsg t(Context r4, e r5) {
        byte[] r0 = e.f6069h.encode(r5);
        if (r4 == null) goto L22;
        d.b.u.b0.b r6 = d.b.u.b0.b.g(r4);
        kotlin.n0.d.o.b(r6, "SyncSettings.inst(context!!)");
        if (r6.f().a() == false) goto L19;
        byte[] r7 = com.bytedance.common.utility.g.d(r0);
        if (r7 == null) goto L19;
        if (r7.length != 0) goto L11;
        boolean r1 = true;
    L13:
        if ((!r1) == false) goto L19;
        int r2 = r0.length;
        int r3 = r7.length;
        Integer r8 = com.bytedance.sync.v2.l.a.f6160a.c(r5);
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        r.e(r2, r3, r9);
        String r10 = "gzip";
        r0 = r7;
    L20:
        WsChannelMsg.b r11 = WsChannelMsg.b.c(this.f6120f);
        r11.f(r0);
        r11.e(2);
        r11.j(this.f6121g);
        r11.g(r10);
        r11.h(r10);
        return r11.b();
    L17:
        r9 = -1;
        goto L18
    L11:
        r1 = false;
    L19:
        r10 = "pb";
        goto L20
    L22:
        kotlin.n0.d.o.p();
        throw null;
    }
}
