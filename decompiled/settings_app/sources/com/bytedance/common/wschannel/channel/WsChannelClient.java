package com.bytedance.common.wschannel.channel;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelClient implements IWsChannelClient {
    private static final String CRONET_CHANNEL_IMPL_CLASS = "org.chromium.wschannel.MySelfChannelImpl";
    private static final String MYSELF_CHANNEL_IMPL_CLASS = "com.b.c.ws.MySelfChannelImpl";
    private static final String TAG = "WsChannelClient";
    private static String sMyselfChannelImplClass = "";
    private final int mChannelId;
    private final Handler mHandler;
    private IMessageHandler mMessageHandler;
    private List<String> mUrls;
    private boolean mUseCronetPlugin;
    private IWsChannelClient mWsChannelImpl;

    static {
    }

    public static void setMyselfChannelImplClass(String r0) {
        sMyselfChannelImplClass = r0;
    }

    public boolean isOkChannelImpl() {
        return this.mWsChannelImpl instanceof OkChannelImpl;
    }

    private WsChannelClient(int r3, IMessageHandler r4, Handler r5) {
        this.mUseCronetPlugin = true;
        this.mChannelId = r3;
        this.mMessageHandler = r4;
        this.mHandler = r5;
        tryResolveMySelfChannelImpl();     // Catch: Throwable -> L8 ClassNotFoundException -> L10
        if (this.mUseCronetPlugin == false) goto L6;
        Logger.d(TAG, "use cronet to connect");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L15:
    L12:
        if (this.mWsChannelImpl != null) goto L18;
        Logger.d(TAG, "use okhttp to connect");
        this.mWsChannelImpl = new OkChannelImpl(r3, r5);
        return;
    L18:
        return;
    L6:
        Logger.d(TAG, "use PushManager to connect");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L10:
        Logger.d(TAG, "don't find plugin or plugin download failed");
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "don't find plugin");
        goto L12
    }

    public static WsChannelClient newInstance(int r1, IMessageHandler r2, Handler r3) {
        return new WsChannelClient(r1, r2, r3);
    }

    private void tryResolveMySelfChannelImpl() throws Exception {
        if (this.mWsChannelImpl == null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(sMyselfChannelImplClass) == true) goto L7;
        Class<?> r0 = checkClass(sMyselfChannelImplClass);
    L8:
        if (r0 != null) goto L10;
        r0 = checkClass(CRONET_CHANNEL_IMPL_CLASS);
        this.mUseCronetPlugin = true;
    L10:
        if (r0 != null) goto L12;
        r0 = checkClass(MYSELF_CHANNEL_IMPL_CLASS);
        this.mUseCronetPlugin = false;
    L12:
        if (r0 == null) goto L17;
        Object r1 = r0.newInstance();
        if ((r1 instanceof IWsChannelClient) == false) goto L19;
        this.mWsChannelImpl = (IWsChannelClient) r1;
        return;
    L19:
        return;
    L17:
        throw new ClassNotFoundException("plugin class not found");
    L7:
        r0 = null;
        goto L8
    }

    private Class<?> checkClass(String r1) {
        return Class.forName(r1);
    L4:
        return null;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r4, IWsChannelClient r5) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L12;
        return;
    L12:
        r0.init(r4, r5);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.mWsChannelImpl instanceof OkChannelImpl) == true) goto L10;
        th.printStackTrace();
        Logger.d(TAG, "cronet socket init failed，use okhttp to connect");
        OkChannelImpl r1 = new OkChannelImpl(this.mChannelId, this.mHandler);
        this.mWsChannelImpl = r1;
        r1.init(r4, r5);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        IWsChannelClient r0 = this.mWsChannelImpl;     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        r0.destroy();     // Catch: Throwable -> L19
        if ((this.mWsChannelImpl instanceof OkChannelImpl) == true) goto L17;
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L19
        List<String> r2 = this.mUrls;     // Catch: Throwable -> L19
        if (r2 != null) goto L10;
    L12:
        String r3 = "";
    L24:
        r1.put("type", 0);     // Catch: Exception -> L15 Throwable -> L19
        r1.put("state", 3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put("url", r3);     // Catch: Exception -> L15 Throwable -> L19
        r1.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L15 Throwable -> L19
        onConnectionInternal(r1);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r2.size() < 1) goto L12;
        r3 = this.mUrls.get(0);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L6;
        r0.onAppStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L6;
        r0.onNetworkStateChanged(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r2, List<String> r3) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L5;
        r0.openConnection(r2, r3);
    L5:
        this.mUrls = r3;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L6;
        r0.stopConnection();
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r2, List<String> r3) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L5;
        r0.onParameterChange(r2, r3);
    L5:
        this.mUrls = r3;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        IMessageHandler r0 = this.mMessageHandler;
        if (r0 == null) goto L6;
        r0.onMessage(this.mChannelId, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        monitor-enter(this);
        onConnectionInternal(r1);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r3, boolean r4, String r5) {
        IMessageHandler r0 = this.mMessageHandler;
        if (r0 == null) goto L6;
        r0.onServiceConnectEvent(new ServiceConnectEvent(this.mChannelId, r3, r4, r5));
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.sendMessage(r1);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r2) {
        IMessageHandler r0 = this.mMessageHandler;
        if (r0 == null) goto L6;
        r0.onMessage(this.mChannelId, r2);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L6;
        r0.registerService(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r1) {
        IWsChannelClient r0 = this.mWsChannelImpl;
        if (r0 == null) goto L6;
        r0.unregisterService(r1);
        return;
    }

    private void onConnectionInternal(JSONObject r3) {
        IMessageHandler r0 = this.mMessageHandler;
        if (r0 == null) goto L6;
        r0.onConnection(this, this.mChannelId, r3);
        return;
    }
}
