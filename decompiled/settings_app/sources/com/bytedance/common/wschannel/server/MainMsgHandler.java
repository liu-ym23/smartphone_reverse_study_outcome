package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.MainClientMsgListener;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.Utils;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MainMsgHandler implements IMessageHandler {
    private final ChannelKeeper channelKeeper;
    private final Context mContext;
    private ClientMsgParser.ParserListener mListener;
    private ChannelManager mManager;
    private final AtomicInteger mMsgCount;
    private ClientMsgParser parser;
    private final boolean traceEnable;

    private long getTsIfEnable() {
        return 0;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onLinkProgress(String r1, JSONObject r2) {
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void tryResendMsg() {
    }

    MainMsgHandler(Context r3, ChannelKeeper r4) {
        this.mListener = new MainClientMsgListener();
        this.parser = new ClientMsgParser(this.mListener);
        this.mMsgCount = new AtomicInteger(0);
        this.traceEnable = false;
        this.mContext = r3;
        this.channelKeeper = r4;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r4, byte[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        handleMessage(new WsChannelService.Msg(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        handleMessage(new WsChannelService.Msg(r4, r5, 0));
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r2, int r3, JSONObject r4) {
        if (r4 != null) goto L10;
        return;
    L10:
        r4.put(WsConstants.KEY_CHANNEL_ID, r3);     // Catch: JSONException -> L6
    L8:
        onConnection(r2, SocketState.fromJson(r4));
        trySyncCurrentState(r2);
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private void trySyncCurrentState(IWsChannelClient r2) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        this.mManager.syncCurrentState(r2);
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r2, SocketState r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.channelKeeper.mChannelState.put(Integer.valueOf(r3.getChannelId()), r3);
        Intent r4 = new Intent();     // Catch: Throwable -> L7
        r4.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r4.putExtra(WsConstants.KEY_CONNECTION, r3);     // Catch: Throwable -> L7
        this.parser.parse(r4, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onServiceConnectEvent(ServiceConnectEvent r3) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.putExtra("service", r3);     // Catch: Throwable -> L4
        this.parser.parse(r0, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private void handleMessage(WsChannelService.Msg r13) {
        if (r13 != null) goto L5;
        return;
    L5:
        if (r13.data != null) goto L10;
        if (r13.message != null) goto L10;
        return;
    L10:
        if (r13.message == null) goto L12;
        boolean r2 = true;
    L55:
        long r7 = getTsIfEnable();     // Catch: Throwable -> L49
        if (r2 == false) goto L17;
        WsChannelMsg r1 = r13.message;     // Catch: Throwable -> L49
    L21:
        long r9 = getTsIfEnable();     // Catch: Throwable -> L49
        if (r1 != WsChannelMsg.EMPTY) goto L24;
        return;
    L24:
        if (FrontierMessageManager.shouldDropMessageByFilter(r1) == true) goto L66;
        r1.setNewMsgTimeHolder(new NewMsgTimeHolder(r13.ts, r7, r9));     // Catch: Throwable -> L49
        r1.setChannelId(r13.channelId);     // Catch: Throwable -> L49
        r1.setReplayToComponentName(new ComponentName(this.mContext, WsChannelService.class));     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L30;
        Logger.d("WsChannelService", "version =  seqId = " + r1.getSeqId() + " logId = " + r1.getLogId() + " wsChannelMsg = " + r1.toString());     // Catch: Throwable -> L49
    L30:
        if (this.channelKeeper.mWsAppMap != null) goto L32;
        return;
    L32:
        if (this.channelKeeper.mWsAppMap.size() <= 0) goto L68;
        Iterator<Map.Entry<Integer, IWsApp>> r14 = this.channelKeeper.mWsAppMap.entrySet().iterator();     // Catch: Throwable -> L49
    L35:
        if (r14.hasNext() == false) goto L72;
        IWsApp r0 = r14.next().getValue();     // Catch: Throwable -> L49
        if (r0 == null) goto L35;
        if (r0.getChannelId() != r1.getChannelId()) goto L35;
        Intent r3 = new Intent();     // Catch: Throwable -> L49
        r3.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L49
        r3.putExtra("payload", r1);     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L46;
        r3.putExtra(WsConstants.MSG_COUNT, this.mMsgCount.addAndGet(1));     // Catch: Throwable -> L49
    L46:
        this.parser.parse(r3, null);     // Catch: Throwable -> L49
        goto L35
    L72:
        return;
    L68:
        return;
    L66:
        return;
    L17:
        byte[] r4 = r13.data;     // Catch: Throwable -> L49
        if (Logger.debug() == false) goto L20;
        Logger.d("WsChannelService", "data = " + Utils.byte2HexStr(r4) + " data.length = " + r4.length);     // Catch: Throwable -> L49
    L20:
        r1 = MsgConverterFactory.getConverter().decode(r4);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L53;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L53:
        th.printStackTrace();
        return;
    L12:
        r2 = false;
        goto L55
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void syncSocketState() {
        Intent r0 = new Intent();
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.channelKeeper.mChannelState.values()));
        this.parser.parse(r0, null);
    }

    void setChannelManager(ChannelManager r1) {
        this.mManager = r1;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void replySendMsgResult(WsChannelMsg r1, boolean r2) {
        this.mListener.replySendMsgResult(r1, r2);
    }
}
