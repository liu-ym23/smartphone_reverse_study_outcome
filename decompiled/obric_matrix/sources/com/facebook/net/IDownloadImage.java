package com.facebook.net;

import androidx.window.embedding.EmbeddingCompat;
import d.b.r.i0.a0;
import d.b.r.i0.e0;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.l;
import d.b.r.i0.o;
import d.b.r.i0.y;
import d.b.r.k0.i;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IDownloadImage {
    @e0
    @y(2)
    @h
    d.b.r.b<i> downloadFileForHigh(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @e0
    @y(3)
    @h
    d.b.r.b<i> downloadFileForImmediate(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @e0
    @y(0)
    @h
    d.b.r.b<i> downloadFileForLow(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);

    @e0
    @y(1)
    @h
    d.b.r.b<i> downloadFileForNormal(@d.b.r.i0.a boolean r1, @o int r2, @g0 String r3, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r4, @l List<d.b.r.h0.b> r5, @d.b.r.i0.d Object r6);
}
