package com.bytedance.common.wschannel.client;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, d> f3501b;

    public interface a {
        void a(WsChannelMsg r1, boolean r2);

        void b(com.bytedance.common.wschannel.r.b r1, JSONObject r2);

        void c(WsChannelMsg r1);

        void d(ServiceConnectEvent r1);

        void e(int r1, com.bytedance.common.wschannel.r.c r2, boolean r3);

        void f(String r1, boolean r2);
    }

    public c(@NonNull a r4) {
        super(r4);
        HashMap r0 = new HashMap();
        r0.put(WsConstants.RECEIVE_CONNECTION_ACTION, new e(r4));
        r0.put(WsConstants.SYNC_CONNECT_STATE, new j(r4));
        r0.put(WsConstants.RECEIVE_PROGRESS_ACTION, new g(r4));
        r0.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new f(r4));
        r0.put(WsConstants.SEND_PAYLOAD_ACTION, new i(r4));
        r0.put(WsConstants.RECEIVE_SERVICE_ACTION, new h(r4));
        this.f3501b = Collections.unmodifiableMap(r0);
    }

    @Override // com.bytedance.common.wschannel.client.d
    public void a(Intent r3, com.bytedance.common.wschannel.model.a r4) {
        d r2 = this.f3501b.get(r3.getAction());     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        r2.a(r3, r4);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d("AbsWsClientService", "count = " + r3.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L17:
        return;
    L6:
        Logger.e("error action!");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Logger.e("AbsWsClientService", th.toString());
        goto L11
    }
}
