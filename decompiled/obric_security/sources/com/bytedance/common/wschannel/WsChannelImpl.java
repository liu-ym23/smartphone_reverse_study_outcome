package com.bytedance.common.wschannel;

import android.content.Context;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.event.MessageAckEvent;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class WsChannelImpl implements WsChannel {
    private final OnMessageAckListener mAckReceiver;
    private ChannelInfo mChannelInfo;
    private final Context mContext;
    private final WsChannelApi mImpl;
    private AtomicBoolean mPendingUnRegister;
    private boolean mPrivateProtocolEnabled;
    private final OnMessageReceiveListener mReceiver;
    private final OnServiceConnectListener mServiceListener;
    private ConcurrentHashMap<Integer, Boolean> mServiceState;
    private ConnectionState mState;
    private SsWsApp mWsApp;

    WsChannelImpl(Context r3, WsChannelApi r4, ChannelInfo r5, OnMessageReceiveListener r6, OnServiceConnectListener r7, OnMessageAckListener r8) {
        this.mPendingUnRegister = new AtomicBoolean(false);
        this.mServiceState = new ConcurrentHashMap();
        this.mContext = r3;
        this.mImpl = r4;
        this.mChannelInfo = r5;
        this.mReceiver = r6;
        this.mServiceListener = r7;
        this.mAckReceiver = r8;
        this.mWsApp = WsChannelSdk2.createParameterMap(r5);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public int getChannelId() {
        return this.mChannelInfo.channelId;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void unregister() {
        this.mImpl.unRegisterApp(this.mContext, this.mChannelInfo.channelId);
        this.mPendingUnRegister.set(true);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void onParamChanged(ChannelInfo r3) {
        if (r3 == null) goto L11;
        if (r3.channelId != this.mChannelInfo.channelId) goto L11;
        if (this.mPendingUnRegister.get() == false) goto L8;
        return;
    L8:
        this.mChannelInfo = r3;
        SsWsApp r4 = WsChannelSdk2.createParameterMap(r3);
        this.mWsApp = r4;
        this.mImpl.onParameterChange(this.mContext, r4);
        return;
    L11:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isConnected() {
        if (this.mState != ConnectionState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isServiceConnected(int r1) {
        Boolean r0 = this.mServiceState.get(Integer.valueOf(r1));
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public boolean isPrivateProtocolEnabled() {
        return this.mPrivateProtocolEnabled;
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void sendMsg(WsChannelMsg r3, MsgSendListener r4) {
        if (r3.getChannelId() != this.mChannelInfo.channelId) goto L12;
        if (this.mPendingUnRegister.get() == false) goto L9;
        if (r4 == null) goto L13;
        r4.onSendResult(r3, false);
        return;
    L13:
        return;
    L9:
        this.mImpl.sendPayload(this.mContext, new MainProcessMsg(r3, r4));
        return;
    L12:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public String sendMsgWithAck(WsChannelMsg r4, MsgSendListener r5) {
        if (r4.getChannelId() != this.mChannelInfo.channelId) goto L13;
        if (this.mPendingUnRegister.get() == false) goto L10;
        if (r5 == null) goto L14;
        r5.onSendResult(r4, false);
        return null;
    L14:
        return null;
    L10:
        String r0 = UUID.randomUUID().toString().replace("-", "");
        r4.setUUID(r0);
        this.mImpl.sendPayload(this.mContext, new MainProcessMsg(r4, r5));
        return r0;
    L13:
        throw new IllegalArgumentException("channelId isn't the same");
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void registerService(int r3) {
        this.mImpl.registerServiceId(this.mContext, this.mChannelInfo.channelId, r3);
    }

    @Override // com.bytedance.common.wschannel.WsChannel
    public void unregisterService(int r4) {
        this.mImpl.unregisterServiceId(this.mContext, this.mChannelInfo.channelId, r4);
        this.mServiceState.remove(Integer.valueOf(r4));
    }

    void register() {
        this.mImpl.registerApp(this.mContext, this.mWsApp);
    }

    void onReceive(WsChannelMsg r8) {
        if (this.mReceiver == null) goto L9;
        if (r8.isAckMsg() == true) goto L9;
        this.mReceiver.onReceiveMsg(r8);
        return;
    L9:
        if (this.mAckReceiver != null) goto L11;
        return;
    L11:
        if (r8.isAckMsg() == false) goto L15;
        MessageAckEvent r0 = new MessageAckEvent(r8.getUUID(), r8.getChannelId(), r8.getService(), r8.getMethod(), r8.getLogInfo());
        r0.setState(r8.getState());
        this.mAckReceiver.onReceiveMsgAck(r0);
        return;
    }

    void onReceiveConnectEvent(ConnectEvent r2, JSONObject r3) {
        OnMessageReceiveListener r0 = this.mReceiver;
        if (r0 == null) goto L6;
        r0.onReceiveConnectEvent(r2, r3);
    L6:
        if (r2.connectionState == ConnectionState.CONNECT_CLOSED) goto L8;
        return;
    L8:
        if (this.mPendingUnRegister.get() == false) goto L12;
        WsChannelSdk2.unregister(getChannelId());
        return;
    }

    void onReceiveServiceConnectEvent(ServiceConnectEvent r1) {
        OnServiceConnectListener r0 = this.mServiceListener;
        if (r0 == null) goto L6;
        r0.onServiceConnectEvent(r1);
        return;
    }

    void syncState(ConnectionState r1, boolean r2) {
        this.mState = r1;
        this.mPrivateProtocolEnabled = r2;
    }

    void syncServiceState(ServiceConnectEvent r2) {
        this.mServiceState.put(Integer.valueOf(r2.getServiceId()), Boolean.valueOf(r2.isServiceConnected()));
    }

    void replySendMsgResult(WsChannelMsg r1, boolean r2) {
        if ((r1 instanceof MainProcessMsg) == false) goto L8;
        MainProcessMsg r3 = (MainProcessMsg) r1;
        WsChannelMsg r0 = r3.getOrigin();
        MsgSendListener r4 = r3.getListener();
        if (r4 == null) goto L9;
        r4.onSendResult(r0, r2);
        return;
    L9:
        return;
    }
}
