package com.bytedance.common.wschannel.channel.c.a;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.m;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements IWsChannelClient, WeakHandler.IHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f3373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f3374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f3375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f3376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<String, Object> f3377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f3378l;
    private ContentObserver m;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.c.a.a$a, reason: collision with other inner class name */
    class C0095a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3379a;

        C0095a(a r1, Handler r2) {
            this.f3379a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            super.onChange(r2);
            a r3 = this.f3379a;
            if (a.b(r3, a.a(r3)) == false) goto L5;
            a r4 = this.f3379a;
            r4.openConnection(a.c(r4), a.d(this.f3379a));
            return;
        L5:
            this.f3379a.stopConnection();
        }
    }

    static {
    }

    public a(int r2, Handler r3) {
        this.f3377k = new HashMap();
        this.f3372f = r2;
        this.f3374h = r3;
        this.m = new C0095a(this, this.f3374h);
    }

    static /* synthetic */ Context a(a r0) {
        return r0.f3373g;
    }

    static /* synthetic */ boolean b(a r0, Context r1) {
        return r0.g(r1);
    }

    static /* synthetic */ Map c(a r0) {
        return r0.f3377k;
    }

    static /* synthetic */ List d(a r0) {
        return r0.f3378l;
    }

    private void e(Context r9) {
        System.currentTimeMillis();
        Class<?> r0 = Class.forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r0 != null) goto L16;
        return;
    L16:
        r0.getMethod("a", new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r0, new Object[]{r9, 2, null});     // Catch: Throwable -> L10
    L12:
        System.currentTimeMillis();
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        Log.d("WsChannelSdk_ok", "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
        r0 = null;
        goto L6
    }

    private void f(Context r4) {
        r4.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.k(r4, WsConstants.KEY_OK_IMPL_ENABLE, TypedValues.Custom.S_BOOLEAN), true, this.m);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean g(Context r1) {
        return o.f(r1).i();
    }

    private void h() {
        Context r0 = this.f3373g;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getContentResolver().unregisterContentObserver(this.m);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d("WsChannelSdk_ok", "destroy() , channelId = " + this.f3372f);
        this.f3375i.C();
        h();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r4, IWsChannelClient r5) {
        if (this.f3376j == false) goto L5;
        return;
    L5:
        this.f3376j = true;
        Log.d("WsChannelSdk_ok", "init() , channelId = " + this.f3372f);
        this.f3373g = r4.getApplicationContext();
        e(r4);
        c.h r0 = new c.h(r4);
        r0.c(new com.bytedance.common.wschannel.channel.c.a.f.c(r4));
        r0.b(m.h(this.f3372f));
        c r1 = r0.a();
        this.f3375i = r1;
        r1.f0(new e(this.f3373g, r1, r5));
        f(r4);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.f3375i.M();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r3) {
        if (g(this.f3373g) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onAppStateChanged(), channelId = " + this.f3372f);
        c r2 = this.f3375i;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.Q(r0);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        Log.d("WsChannelSdk_ok", "onConnection()");
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        Log.d("WsChannelSdk_ok", "onMessage(),channel = " + this.f3372f);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r3) {
        if (g(this.f3373g) == true) goto L5;
        return;
    L5:
        Log.d("WsChannelSdk_ok", "onNetworkStateChanged(), channelId = " + this.f3372f);
        this.f3375i.R(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        if (r3 == null) goto L4;
        this.f3377k.putAll(r3);
    L4:
        this.f3378l = r4;
        if (g(this.f3373g) == true) goto L7;
        return;
    L7:
        Log.d("WsChannelSdk_ok", "onParameterChange(),channelId = " + this.f3372f);
        this.f3375i.S(r3, r4);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r1, boolean r2, String r3) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r2, List<String> r3) {
        if (r2 == null) goto L4;
        this.f3377k.putAll(r2);
    L4:
        this.f3378l = r3;
        if (g(this.f3373g) == true) goto L7;
        return;
    L7:
        this.f3375i.A(r2, r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r3) {
        if (g(this.f3373g) == true) goto L6;
        return false;
    L6:
        Log.d("WsChannelSdk_ok", "sendMessage(),channelId = " + this.f3372f);
        return this.f3375i.b0(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d("WsChannelSdk_ok", "stopConnection(),channelId = " + this.f3372f);
        this.f3375i.g0();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
    }
}
