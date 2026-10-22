package com.bytedance.common.wschannel.server;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class m implements com.bytedance.common.wschannel.channel.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static AtomicBoolean f3789i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.common.wschannel.server.a f3791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f3792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f3793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f3794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BlockingQueue<WsChannelService.b> f3795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ExecutorService f3796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f3797h;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f3798f;

        a(m r1) {
            this.f3798f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("MessageDispatcher");     // Catch: Throwable -> L11
        L3:
            Thread.currentThread();     // Catch: Throwable -> L11
            if (Thread.interrupted() == true) goto L13;
            m.i().getAndSet(true);     // Catch: Throwable -> L11
            WsChannelService.b r0 = (WsChannelService.b) m.j(this.f3798f).take();     // Catch: Throwable -> L11
            m.k(this.f3798f, r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L11
        L13:
            m.i().getAndSet(false);
            return;
        L11:
            th = move-exception;
            th.printStackTrace();
            goto L13
        }
    }

    static {
        f3789i = new AtomicBoolean(true);
    }

    m(Context r2, com.bytedance.common.wschannel.server.a r3) {
        this.f3795f = new LinkedBlockingQueue();
        this.f3796g = Executors.newSingleThreadExecutor();
        this.f3797h = l();
        this.f3790a = r2;
        this.f3791b = r3;
        this.f3792c = new c(r2, WsClientService.class);
        this.f3793d = true;
        p();
    }

    static /* synthetic */ AtomicBoolean i() {
        return f3789i;
    }

    static /* synthetic */ BlockingQueue j(m r0) {
        return r0.f3795f;
    }

    static /* synthetic */ void k(m r0, WsChannelService.b r1) {
        r0.n(r1);
    }

    @WorkerThread
    private Runnable l() {
        return new a(this);
    }

    private long m() {
        if (this.f3793d == true) goto L5;
        return 0;
    L5:
        return com.bytedance.common.wschannel.u.b.a();
    }

    @WorkerThread
    private void n(WsChannelService.b r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.f3708b != null) goto L10;
        if (r11.f3710d != null) goto L10;
        return;
    L10:
        if (r11.f3710d == null) goto L12;
        boolean r0 = true;
    L58:
        long r4 = m();     // Catch: Throwable -> L52
        if (r0 == false) goto L17;
        WsChannelMsg r1 = r11.f3710d;     // Catch: Throwable -> L52
    L21:
        long r6 = m();     // Catch: Throwable -> L52
        if (r1 != WsChannelMsg.x) goto L24;
    L50:
        Logger.e("WsChannelService", "handleMessage decode msg is EMPTY!");     // Catch: Throwable -> L52
        return;
    L24:
        if (d.n(r1) == true) goto L50;
        r1.F(new NewMsgTimeHolder(r11.f3709c, r4, r6));     // Catch: Throwable -> L52
        r1.y(r11.f3707a);     // Catch: Throwable -> L52
        r1.L(new ComponentName(this.f3790a, WsChannelService.class));     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L29;
        Logger.d("WsChannelService", "version =  seqId = " + r1.q() + " logId = " + r1.d() + " wsChannelMsg = " + r1.toString());     // Catch: Throwable -> L52
    L29:
        Map<Integer, IWsApp> r12 = this.f3791b.f3711a;     // Catch: Throwable -> L52
        if (r12 != null) goto L32;
    L48:
        Logger.e("WsChannelService", "mKeeper.mWsAppMap is empty!");     // Catch: Throwable -> L52
        return;
    L32:
        if (r12.size() <= 0) goto L48;
        Iterator<Map.Entry<Integer, IWsApp>> r13 = this.f3791b.f3711a.entrySet().iterator();     // Catch: Throwable -> L52
    L36:
        if (r13.hasNext() == false) goto L68;
        IWsApp r2 = r13.next().getValue();     // Catch: Throwable -> L52
        if (r2 == null) goto L39;
        if (r2.c() != r1.c()) goto L36;
        Intent r3 = new Intent();     // Catch: Throwable -> L46
        r3.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L46
        r3.setComponent(new ComponentName(this.f3790a, WsClientService.class));     // Catch: Throwable -> L46
        r3.putExtra(WsConstants.KEY_PAYLOAD, r1);     // Catch: Throwable -> L46
        q(r3);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        String r5 = "deliver fail,reason:" + th;     // Catch: Throwable -> L52
    L40:
        Logger.e("WsChannelService", r5);     // Catch: Throwable -> L52
        goto L36
    L39:
        r5 = "wsApp is null!";
        goto L40
    L68:
        return;
    L17:
        byte[] r7 = r11.f3708b;     // Catch: Throwable -> L52
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "data = " + com.bytedance.common.wschannel.u.c.a(r7) + " data.length = " + r7.length);     // Catch: Throwable -> L52
    L20:
        r1 = com.bytedance.common.wschannel.q.b.a().a(r7);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L56;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L56:
        th.printStackTrace();
        return;
    L12:
        r0 = false;
        goto L58
    }

    private void p() {
        if (this.f3797h != null) goto L10;
        this.f3797h = l();
    L10:
        this.f3796g.submit(this.f3797h);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @SuppressLint({"NewApi"})
    private void q(Intent r1) {
        this.f3792c.b(r1);
    }

    private void r(IWsChannelClient r2) {
        if (com.bytedance.common.wschannel.o.f(this.f3790a).j() == true) goto L5;
        return;
    L5:
        this.f3794e.t(r2);
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void a(WsChannelMsg r5, boolean r6) {
        ComponentName r1 = r5.p();
        if (r1 == null) goto L17;
        byte[] r7 = r5.i();     // Catch: Throwable -> L12
        if (r7 != null) goto L7;
        r7 = new byte[1];     // Catch: Throwable -> L12
    L7:
        Intent r2 = new Intent();     // Catch: Throwable -> L12
        r2.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L12
        r2.setComponent(r1);     // Catch: Throwable -> L12
        r2.putExtra(WsConstants.KEY_SEND_RESULT, r6);     // Catch: Throwable -> L12
        r2.putExtra(WsConstants.KEY_PAYLOAD_MD5, com.bytedance.common.utility.c.a(r7));     // Catch: Throwable -> L12
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelService", "send result = " + r6 + " payloadMd5 = " + r2.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L12
    L10:
        this.f3790a.startService(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void b(ServiceConnectEvent r5) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.f3790a, WsClientService.class));     // Catch: Throwable -> L4
        r0.putExtra("service", r5);     // Catch: Throwable -> L4
        q(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void c() {
        this.f3792c.c();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void d(IWsChannelClient r2, int r3, JSONObject r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        r4.put(WsConstants.KEY_CHANNEL_ID, r3);     // Catch: JSONException -> L6
    L8:
        SocketState r5 = SocketState.b(r4);
        h(r2, r5);
        r(r2);
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelService", "onConnection: state=" + r5.f3582g + " | type=" + r5.f3581f + " | error=" + r5.f3586k);
        return;
    L14:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void e() {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.f3790a, WsClientService.class));     // Catch: Throwable -> L4
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.f3791b.f3713c.values()));     // Catch: Throwable -> L4
        q(r0);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void f(int r4, byte[] r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.b r2 = new WsChannelService.b(r4, r5, m());     // Catch: Throwable -> L6
        this.f3795f.offer(r2);     // Catch: Throwable -> L6
        f3789i.getAndSet(true);     // Catch: Throwable -> L6
        p();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void g(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.b r2 = new WsChannelService.b(r4, r5, m());     // Catch: Throwable -> L6
        this.f3795f.offer(r2);     // Catch: Throwable -> L6
        f3789i.getAndSet(true);     // Catch: Throwable -> L6
        p();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.a
    public void h(IWsChannelClient r4, SocketState r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f3791b.f3713c.put(Integer.valueOf(r5.c()), r5);
        Intent r6 = new Intent();     // Catch: Throwable -> L7
        r6.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r6.setComponent(new ComponentName(this.f3790a, WsClientService.class));     // Catch: Throwable -> L7
        r6.putExtra(WsConstants.KEY_CONNECTION, r5);     // Catch: Throwable -> L7
        q(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    void o(b r1) {
        this.f3794e = r1;
    }
}
