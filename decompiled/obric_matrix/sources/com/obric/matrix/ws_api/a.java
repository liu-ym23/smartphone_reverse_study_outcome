package com.obric.matrix.ws_api;

import com.bytedance.common.wschannel.j;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/obric/matrix/ws_api/IWsChannelListener;", "", "onHeartbeat", "", "onWsChannelChanged", "wsChannel", "Lcom/bytedance/common/wschannel/WsChannel;", "onWsChannelMsg", "wsChannelMsg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "onWsConnectEvent", "connectEvent", "Lcom/bytedance/common/wschannel/event/ConnectEvent;", "connectJson", "Lorg/json/JSONObject;", "ws_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: com.obric.matrix.ws_api.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class C0289a {
        public static void a(a r0) {
        }

        public static void b(a r0, j r1) {
        }
    }

    void a(com.bytedance.common.wschannel.r.b r1, JSONObject r2);

    void b(j r1);

    void c();

    void d(WsChannelMsg r1);
}
