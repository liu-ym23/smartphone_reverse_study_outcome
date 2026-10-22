package com.bytedance.bdturing.ttnet;

import d.b.r.i0.a0;
import d.b.r.i0.e0;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.l;
import d.b.r.i0.t;
import d.b.r.k0.i;
import d.b.r.k0.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @h
    d.b.r.b<i> doGet(@d.b.r.i0.a boolean r1, @g0 String r2, @a0 Map<String, String> r3, @l List<d.b.r.h0.b> r4);

    @e0
    @t
    d.b.r.b<i> doPost(@g0 String r1, @a0 Map<String, String> r2, @d.b.r.i0.b j r3, @l List<d.b.r.h0.b> r4);
}
