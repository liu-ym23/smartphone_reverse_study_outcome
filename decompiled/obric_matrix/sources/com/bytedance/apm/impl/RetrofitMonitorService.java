package com.bytedance.apm.impl;

import d.b.r.i0.a0;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.l;
import d.b.r.i0.q;
import d.b.r.i0.t;
import d.b.r.i0.w;
import d.b.r.k0.i;
import d.b.r.k0.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface RetrofitMonitorService {
    @h
    d.b.r.b<i> fetch(@g0 String r1, @a0 Map<String, String> r2, @d.b.r.i0.a boolean r3);

    @t
    d.b.r.b<i> report(@g0 String r1, @d.b.r.i0.b j r2, @l List<d.b.r.h0.b> r3, @d.b.r.i0.a boolean r4);

    @q
    @t
    d.b.r.b<i> uploadFiles(@g0 String r1, @w Map<String, j> r2, @l List<d.b.r.h0.b> r3);
}
