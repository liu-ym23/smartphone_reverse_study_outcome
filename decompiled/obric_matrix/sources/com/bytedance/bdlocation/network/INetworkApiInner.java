package com.bytedance.bdlocation.network;

import androidx.window.embedding.EmbeddingCompat;
import d.b.r.b;
import d.b.r.i0.a;
import d.b.r.i0.a0;
import d.b.r.i0.d;
import d.b.r.i0.f;
import d.b.r.i0.g;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.l;
import d.b.r.i0.o;
import d.b.r.i0.t;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApiInner {
    @h
    b<String> doGet(@a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d Object r6);

    @t
    @g
    b<String> doPost(@o int r1, @g0 String r2, @a0 Map<String, String> r3, @f(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d Object r6, @a boolean r7);
}
