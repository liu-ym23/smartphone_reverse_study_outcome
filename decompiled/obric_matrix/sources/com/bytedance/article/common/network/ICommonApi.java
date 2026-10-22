package com.bytedance.article.common.network;

import androidx.window.embedding.EmbeddingCompat;
import d.b.r.b;
import d.b.r.i0.a;
import d.b.r.i0.f;
import d.b.r.i0.g;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.l;
import d.b.r.i0.o;
import d.b.r.i0.t;
import d.b.r.k0.i;
import d.b.r.k0.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @h
    b<String> get(@o int r1, @g0 String r2, @l List<d.b.r.h0.b> r3, @a boolean r4);

    @t
    b<String> postData(@o int r1, @g0 String r2, @d.b.r.i0.b j r3, @l List<d.b.r.h0.b> r4, @a boolean r5);

    @t
    b<i> postDataStream(@o int r1, @g0 String r2, @d.b.r.i0.b j r3, @l List<d.b.r.h0.b> r4, @a boolean r5);

    @t
    @g
    b<String> postForm(@o int r1, @g0 String r2, @f(encode = EmbeddingCompat.DEBUG) Map<String, String> r3, @l List<d.b.r.h0.b> r4, @a boolean r5);
}
