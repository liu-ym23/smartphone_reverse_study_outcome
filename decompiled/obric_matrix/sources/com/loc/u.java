package com.loc;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.matrix.common_api.INetworkApi;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends o5 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f7855l;
    private String m;

    public u(byte[] r2, String r3) {
        this.m = LocationInfoConst.ALLOW_USE_LOCATION;
        this.f7855l = (byte[]) r2.clone();
        this.m = r3;
        d(t0.a.f7805j);
        f(t0.c.f7814f);
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        HashMap r0 = new HashMap();
        r0.put(INetworkApi.CONTENT_TYPE, "application/zip");
        r0.put("Content-Length", String.valueOf(this.f7855l.length));
        return r0;
    }

    @Override // com.loc.t0
    public final String j() {
        String r0 = u5.u(g.f7303b);
        byte[] r3 = u5.o(g.f7302a);
        byte[] r4 = new byte[r3.length + 50];
        System.arraycopy(this.f7855l, 0, r4, 0, 50);
        System.arraycopy(r3, 0, r4, 50, r3.length);
        return String.format(r0, new Object[]{LocationInfoConst.ALLOW_USE_LOCATION, this.m, LocationInfoConst.ALLOW_USE_LOCATION, "open", p5.b(r4)});
    }

    @Override // com.loc.t0
    public final byte[] q() {
        return this.f7855l;
    }

    @Override // com.loc.t0
    public final Map<String, String> r() {
        return null;
    }

    @Override // com.loc.t0
    public final boolean t() {
        return false;
    }
}
