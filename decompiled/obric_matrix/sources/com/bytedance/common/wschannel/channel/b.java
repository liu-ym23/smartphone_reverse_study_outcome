package com.bytedance.common.wschannel.channel;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IWsChannelClient {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f3365l = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f3367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f3368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IWsChannelClient f3370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private a f3371k;

    static {
    }

    private b(int r3, a r4, Handler r5) {
        this.f3369i = true;
        this.f3366f = r3;
        this.f3371k = r4;
        this.f3367g = r5;
        e();     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        if (this.f3369i == false) goto L7;
        String r6 = "use cronet to connect";
    L6:
        Logger.d("WsChannelClient", r6);     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L14:
        if (this.f3370j != null) goto L19;
        Logger.d("WsChannelClient", "use okhttp to connect");
        this.f3370j = new com.bytedance.common.wschannel.channel.c.a.a(r3, r5);
        return;
    L19:
        return;
    L7:
        r6 = "use PushManager to connect";
    L11:
        String r7 = "don't find plugin or plugin download failed";
    L12:
        Logger.d("WsChannelClient", r7);
    L9:
        th = move-exception;
        th.printStackTrace();
        r7 = "don't find plugin";
        goto L12
    }

    private Class<?> a(String r1) {
        return Class.forName(r1);
    L4:
        return null;
    }

    public static b c(int r1, a r2, Handler r3) {
        return new b(r1, r2, r3);
    }

    private void d(JSONObject r3) {
        a r0 = this.f3371k;
        if (r0 == null) goto L6;
        r0.d(this, this.f3366f, r3);
        return;
    }

    private void e() {
        if (this.f3370j != null) goto L17;
        Class<?> r0 = null;
        if (k.c(f3365l) == true) goto L7;
        r0 = a(f3365l);
    L7:
        if (r0 != null) goto L9;
        r0 = a("org.chromium.wschannel.MySelfChannelImpl");
        this.f3369i = true;
    L9:
        if (r0 != null) goto L11;
        r0 = a("com.b.c.ws.MySelfChannelImpl");
        this.f3369i = false;
    L11:
        if (r0 == null) goto L16;
        Object r1 = r0.newInstance();
        if ((r1 instanceof IWsChannelClient) == false) goto L18;
        this.f3370j = (IWsChannelClient) r1;
        return;
    L18:
        return;
    L16:
        throw new ClassNotFoundException("plugin class not found");
    }

    public boolean b() {
        return this.f3370j instanceof com.bytedance.common.wschannel.channel.c.a.a;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        IWsChannelClient r0 = this.f3370j;     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        r0.destroy();     // Catch: Throwable -> L19
        if ((this.f3370j instanceof com.bytedance.common.wschannel.channel.c.a.a) == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L19
        List<String> r2 = this.f3368h;     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
    L12:
        String r3 = "";
    L24:
        r1.put(WsConstants.KEY_CONNECTION_TYPE, 0);     // Catch: Exception -> L15 Throwable -> L19
        r1.put(WsConstants.KEY_CONNECTION_STATE, 3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put(WsConstants.KEY_CONNECTION_URL, r3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L15 Throwable -> L19
        d(r1);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r2.size() < 1) goto L12;
        r3 = this.f3368h.get(0);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r4, IWsChannelClient r5) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L12;
        return;
    L12:
        r0.init(r4, r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.f3370j instanceof com.bytedance.common.wschannel.channel.c.a.a) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet socket init failed，use okhttp to connect");
        com.bytedance.common.wschannel.channel.c.a.a r1 = new com.bytedance.common.wschannel.channel.c.a.a(this.f3366f, this.f3367g);
        this.f3370j = r1;
        r1.init(r4, r5);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L6;
        r0.onAppStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        monitor-enter(this);
        d(r1);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r2) {
        a r0 = this.f3371k;
        if (r0 == null) goto L6;
        r0.g(this.f3366f, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        a r0 = this.f3371k;
        if (r0 == null) goto L6;
        r0.f(this.f3366f, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L6;
        r0.onNetworkStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r2, List<String> r3) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L5;
        r0.onParameterChange(r2, r3);
    L5:
        this.f3368h = r3;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r3, boolean r4, String r5) {
        a r0 = this.f3371k;
        if (r0 == null) goto L6;
        r0.b(new ServiceConnectEvent(this.f3366f, r3, r4, r5));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r2, List<String> r3) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L5;
        r0.openConnection(r2, r3);
    L5:
        this.f3368h = r3;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L6;
        r0.registerService(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L6;
        r0.stopConnection();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
        IWsChannelClient r0 = this.f3370j;
        if (r0 == null) goto L6;
        r0.unregisterService(r1);
        return;
    }
}
