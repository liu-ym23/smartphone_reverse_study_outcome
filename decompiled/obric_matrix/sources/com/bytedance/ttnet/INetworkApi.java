package com.bytedance.ttnet;

import androidx.window.embedding.EmbeddingCompat;
import d.b.r.i0.a0;
import d.b.r.i0.e0;
import d.b.r.i0.g0;
import d.b.r.i0.l;
import d.b.r.i0.o;
import d.b.r.i0.q;
import d.b.r.i0.t;
import d.b.r.i0.w;
import d.b.r.k0.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @d.b.r.i0.h
    d.b.r.b<String> doGet(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @d.b.r.i0.h
    d.b.r.b<d.b.r.k0.i> doGetBytes(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @t
    @d.b.r.i0.g
    d.b.r.b<String> doPost(@o int r1, @g0 String r2, @a0 Map<String, String> r3, @d.b.r.i0.f(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @e0
    @d.b.r.i0.h
    d.b.r.b<d.b.r.k0.i> downloadFile(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4);

    @e0
    @d.b.r.i0.h
    d.b.r.b<d.b.r.k0.i> downloadFile(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @t
    d.b.r.b<String> postBody(@o int r1, @g0 String r2, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r3, @d.b.r.i0.b j r4, @l List<d.b.r.h0.b> r5);

    @q
    @t
    d.b.r.b<String> postMultiPart(@o int r1, @g0 String r2, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r3, @w Map<String, j> r4, @l List<d.b.r.h0.b> r5);
}
