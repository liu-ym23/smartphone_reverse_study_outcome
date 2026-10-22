package com.obric.matrix.ws.k;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052(\u0010\u0006\u001a$\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0018\u00010\tj\u0004\u0018\u0001`\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/ws/internal/IWsMsgSender;", "", "sendWsMsg", "", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "listener", "Lkotlin/Function3;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ws_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface g {
    void a(WsChannelMsg r1, q<? super Boolean, ? super WsChannelMsg, ? super Exception, f0> r2);
}
