package com.obric.matrix.launch.bdtracker;

import androidx.window.embedding.EmbeddingCompat;
import d.b.r.i0.a0;
import d.b.r.i0.d;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.m;
import d.b.r.i0.t;
import d.b.r.k0.j;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b`\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\b\u0001\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0001H'J@\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'J@\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0016\b\u0001\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0001H'¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/launch/bdtracker/ITTNetworkService;", "", "getCall", "Lcom/bytedance/retrofit2/Call;", "", "relativePath", "queryMap", "", "extraInfo", "postCall", "body", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "headers", "", "reqInfo", "postCallWithByteArray", "", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ITTNetworkService {
    @h
    d.b.r.b<String> getCall(@g0 String r1, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r2, @d Object r3);

    @t("/")
    d.b.r.b<String> postCall(@d.b.r.i0.b j r1, @m Map<String, String> r2, @d Object r3);

    @t("/")
    d.b.r.b<byte[]> postCallWithByteArray(@d.b.r.i0.b j r1, @m Map<String, String> r2, @d Object r3);
}
