package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i implements com.bytedance.common.wschannel.channel.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f3770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.client.c.a f3771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.common.wschannel.client.c f3772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f3773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f3774f;

    i(Context r3, a r4) {
        com.bytedance.common.wschannel.e r0 = new com.bytedance.common.wschannel.e();
        this.f3771c = r0;
        this.f3772d = new com.bytedance.common.wschannel.client.c(r0);
        this.f3774f = new AtomicInteger(0);
        this.f3769a = r3;
        this.f3770b = r4;
    }

    private long i() {
        return 0;
    }

    @WorkerThread
    private void j(WsChannelService.b r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.f3708b != null) goto L9;
        if (r12.f3710d != null) goto L9;
        return;
    L9:
        if (r12.f3710d == null) goto L11;
        boolean r0 = true;
    L54:
        long r5 = i();     // Catch: Throwable -> L48
        if (r0 == false) goto L16;
        WsChannelMsg r1 = r12.f3710d;     // Catch: Throwable -> L48
    L20:
        long r7 = i();     // Catch: Throwable -> L48
        if (r1 != WsChannelMsg.x) goto L23;
        return;
    L23:
        if (d.n(r1) == true) goto L65;
        r1.F(new NewMsgTimeHolder(r12.f3709c, r5, r7));     // Catch: Throwable -> L48
        r1.y(r12.f3707a);     // Catch: Throwable -> L48
        r1.L(new ComponentName(this.f3769a, WsChannelService.class));     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L28;
        Logger.d("WsChannelService", "version =  seqId = " + r1.q() + " logId = " + r1.d() + " wsChannelMsg = " + r1.toString());     // Catch: Throwable -> L48
    L28:
        Map<Integer, IWsApp> r13 = this.f3770b.f3711a;     // Catch: Throwable -> L48
        if (r13 != null) goto L31;
        return;
    L31:
        if (r13.size() <= 0) goto L67;
        Iterator<Map.Entry<Integer, IWsApp>> r14 = this.f3770b.f3711a.entrySet().iterator();     // Catch: Throwable -> L48
    L34:
        if (r14.hasNext() == false) goto L71;
        IWsApp r2 = r14.next().getValue();     // Catch: Throwable -> L48
        if (r2 == null) goto L34;
        if (r2.c() != r1.c()) goto L34;
        Intent r3 = new Intent();     // Catch: Throwable -> L48
        r3.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L48
        r3.putExtra(WsConstants.KEY_PAYLOAD, r1);     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L45;
        r3.putExtra(WsConstants.MSG_COUNT, this.f3774f.addAndGet(1));     // Catch: Throwable -> L48
    L45:
        this.f3772d.a(r3, null);     // Catch: Throwable -> L48
        goto L34
    L71:
        return;
    L67:
        return;
    L65:
        return;
    L16:
        byte[] r4 = r12.f3708b;     // Catch: Throwable -> L48
        if (Logger.debug() == false) goto L19;
        Logger.d("WsChannelService", "data = " + com.bytedance.common.wschannel.u.c.a(r4) + " data.length = " + r4.length);     // Catch: Throwable -> L48
    L19:
        r1 = com.bytedance.common.wschannel.q.b.a().a(r4);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L52;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L52:
        th.printStackTrace();
        return;
    L11:
        r0 = false;
        goto L54
    }

    private void l(IWsChannelClient r2) {
        if (com.bytedance.common.wschannel.o.f(this.f3769a).j() == true) goto L5;
        return;
    L5:
        this.f3773e.t(r2);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(WsChannelMsg r1, boolean r2) {
        this.f3771c.a(r1, r2);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void b(ServiceConnectEvent r3) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.putExtra("service", r3);     // Catch: Throwable -> L4
        this.f3772d.a(r0, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void c() {
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void d(IWsChannelClient r2, int r3, JSONObject r4) {
        if (r4 != null) goto L10;
        return;
    L10:
        r4.put(WsConstants.KEY_CHANNEL_ID, r3);     // Catch: JSONException -> L6
    L8:
        h(r2, SocketState.b(r4));
        l(r2);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void e() {
        Intent r0 = new Intent();
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f3770b.f3713c.values()));
        this.f3772d.a(r0, null);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void f(int r4, byte[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        j(new WsChannelService.b(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void g(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        j(new WsChannelService.b(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void h(IWsChannelClient r2, SocketState r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.f3770b.f3713c.put(Integer.valueOf(r3.c()), r3);
        Intent r4 = new Intent();     // Catch: Throwable -> L7
        r4.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r4.putExtra(WsConstants.KEY_CONNECTION, r3);     // Catch: Throwable -> L7
        this.f3772d.a(r4, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    void k(b r1) {
        this.f3773e = r1;
    }
}
