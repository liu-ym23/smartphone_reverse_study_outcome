package com.obric.matrix.opush.base.network;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;
import p000j.e0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0001H\u0002J(\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bH\u0016J0\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J8\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/opush/base/network/PushNetworkService;", "Lcom/obric/matrix/opush/base/network/INetworkService;", "()V", "get", "", WsConstants.KEY_CONNECTION_URL, "", "headers", "", "iRequestCallback", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "getNetworkService", "post", "form", "", "bodyJson", "Lokhttp3/RequestBody;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d implements a {
    public d() {
    }

    private final a b() {
        return e.f9238b;
    }

    @Override // com.obric.matrix.opush.base.network.a
    public void a(String r2, e0 r3, Map<String, String> r4, b r5) {
        o.f(r2, WsConstants.KEY_CONNECTION_URL);
        o.f(r3, "bodyJson");
        b().a(r2, r3, r4, r5);
    }
}
