package com.obric.matrix.ws.k;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"getWsChannelManagerImpl", "Lcom/obric/matrix/ws/internal/WsChannel2Manager;", "toSimpleString", "", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "ws_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class n {
    public static final h a() {
        return h.f10643a;
    }

    public static final String b(WsChannelMsg r3) {
        o.f(r3, "<this>");
        return "WsChannelMsg{, channelId = " + r3.c() + ", logId=" + r3.d() + ", service=" + r3.s() + ", method=" + r3.f() + ", msgHeaders=" + r3.g() + '}';
    }
}
