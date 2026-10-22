package com.loc;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 extends t0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f7560l;
    private Map<String, String> m;

    public n0(byte[] r1, Map<String, String> r2) {
        this.f7560l = r1;
        this.m = r2;
        d(t0.a.f7805j);
        f(t0.c.f7815g);
    }

    @Override // com.loc.t0
    public final Map<String, String> b() {
        return null;
    }

    @Override // com.loc.t0
    public final String j() {
        return "https://adiu.amap.com/ws/device/adius";
    }

    @Override // com.loc.t0
    public final byte[] q() {
        return this.f7560l;
    }

    @Override // com.loc.t0
    public final Map<String, String> r() {
        return this.m;
    }
}
