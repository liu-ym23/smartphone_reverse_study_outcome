package com.bytedance.common.wschannel.server;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.WorkerThread;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.client.WsClientService;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.model.NewMsgTimeHolder;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;
import com.bytedance.common.wschannel.utils.Utils;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class WsChannelMsgHandler implements IMessageHandler {
    private static AtomicBoolean mDispatcherAlive;
    private final Context mContext;
    private ExecutorService mExecutorService;
    private final ChannelKeeper mKeeper;
    private ChannelManager mManager;
    private Runnable mMessageDispatcher;
    private Future<?> mMessageDispatcherFeature;
    private BlockingQueue<WsChannelService.Msg> mMessageQueue;
    private final ClientMsgSender mMessageSender;
    private final boolean traceEnable;

    static {
        mDispatcherAlive = new AtomicBoolean(true);
    }

    public WsChannelMsgHandler(Context r2, ChannelKeeper r3) {
        this.mMessageQueue = new LinkedBlockingQueue();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mMessageDispatcher = createMessageDispatcher();
        this.mMessageDispatcherFeature = null;
        this.mContext = r2;
        this.mKeeper = r3;
        this.mMessageSender = new ClientMsgSender(r2, WsClientService.class);
        this.traceEnable = true;
        startMessageDispatcher();
    }

    public static /* synthetic */ AtomicBoolean access$000() {
        return mDispatcherAlive;
    }

    public static /* synthetic */ BlockingQueue access$100(WsChannelMsgHandler r0) {
        return r0.mMessageQueue;
    }

    public static /* synthetic */ void access$200(WsChannelMsgHandler r0, WsChannelService.Msg r1) {
        r0.handleMessage(r1);
    }

    @WorkerThread
    private Runnable createMessageDispatcher() {
        return new AnonymousClass1(this);
    }

    private long getTsIfEnable() {
        if (this.traceEnable == true) goto L5;
        return 0;
    L5:
        return TimeCompactUtil.getTimeStampNanos();
    }

    @WorkerThread
    private void handleMessage(WsChannelService.Msg r12) {
        if (r12 != null) goto L6;
        return;
    L6:
        if (r12.data != null) goto L11;
        if (r12.message != null) goto L11;
        return;
    L11:
        if (r12.message == null) goto L13;
        boolean r2 = true;
    L59:
        long r6 = getTsIfEnable();     // Catch: Throwable -> L18
        if (r2 == false) goto L20;
        WsChannelMsg r1 = r12.message;     // Catch: Throwable -> L18
    L24:
        long r8 = getTsIfEnable();     // Catch: Throwable -> L18
        if (r1 != WsChannelMsg.EMPTY) goto L27;
    L52:
        Logger.e("WsChannelService", "handleMessage decode msg is EMPTY!");     // Catch: Throwable -> L18
        return;
    L27:
        if (FrontierMessageManager.shouldDropMessageByFilter(r1) == true) goto L52;
        r1.setNewMsgTimeHolder(new NewMsgTimeHolder(r12.ts, r6, r8));     // Catch: Throwable -> L18
        r1.setChannelId(r12.channelId);     // Catch: Throwable -> L18
        r1.setReplayToComponentName(new ComponentName(this.mContext, WsChannelService.class));     // Catch: Throwable -> L18
        if (Logger.debug() == false) goto L32;
        Logger.d("WsChannelService", "version =  seqId = " + r1.getSeqId() + " logId = " + r1.getLogId() + " wsChannelMsg = " + r1.toString());     // Catch: Throwable -> L18
    L32:
        Map<Integer, IWsApp> r13 = this.mKeeper.mWsAppMap;     // Catch: Throwable -> L18
        if (r13 != null) goto L35;
    L50:
        Logger.e("WsChannelService", "mKeeper.mWsAppMap is empty!");     // Catch: Throwable -> L18
        return;
    L35:
        if (r13.size() <= 0) goto L50;
        Iterator<Map.Entry<Integer, IWsApp>> r14 = this.mKeeper.mWsAppMap.entrySet().iterator();     // Catch: Throwable -> L18
    L39:
        if (r14.hasNext() == false) goto L71;
        IWsApp r0 = r14.next().getValue();     // Catch: Throwable -> L18
        if (r0 == null) goto L42;
        if (r0.getChannelId() != r1.getChannelId()) goto L39;
        Intent r3 = new Intent();     // Catch: Throwable -> L48
        r3.setAction(WsConstants.RECEIVE_PAYLOAD_ACTION);     // Catch: Throwable -> L48
        r3.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L48
        r3.putExtra(WsConstants.KEY_PAYLOAD, r1);     // Catch: Throwable -> L48
        startOrBindService(r3);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        Logger.e("WsChannelService", "deliver fail,reason:" + th);     // Catch: Throwable -> L18
        goto L39
    L42:
        Logger.e("WsChannelService", "wsApp is null!");     // Catch: Throwable -> L18
        goto L39
    L71:
        return;
    L20:
        byte[] r4 = r12.data;     // Catch: Throwable -> L18
        if (Logger.debug() == false) goto L23;
        Logger.d("WsChannelService", "data = " + Utils.byte2HexStr(r4) + " data.length = " + r4.length);     // Catch: Throwable -> L18
    L23:
        r1 = MsgConverterFactory.getConverter().decode(r4);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if ((th instanceof ProtocolException) == false) goto L57;
        Logger.e("WsChannelSdk", "Unsupported message protocol, ignore this message");
        return;
    L57:
        th.printStackTrace();
        return;
    L13:
        r2 = false;
        goto L59
    }

    private void startMessageDispatcher() {
        if (this.mMessageDispatcher != null) goto L10;
        this.mMessageDispatcher = createMessageDispatcher();
    L10:
        this.mMessageDispatcherFeature = this.mExecutorService.submit(this.mMessageDispatcher);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    @SuppressLint({"NewApi"})
    private void startOrBindService(Intent r1) {
        this.mMessageSender.sendMsg(r1);
    }

    private void trySyncCurrentState(IWsChannelClient r2) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        this.mManager.syncCurrentState(r2);
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r2, int r3, JSONObject r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        r4.put(WsConstants.KEY_CHANNEL_ID, r3);     // Catch: JSONException -> L6
    L8:
        SocketState r5 = SocketState.fromJson(r4);
        onConnection(r2, r5);
        trySyncCurrentState(r2);
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelService", "onConnection: state=" + r5.connectionState + " | type=" + r5.connectionType + " | error=" + r5.error);
        return;
    L14:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void onDestroy() {
        Future<?> r1 = this.mMessageDispatcherFeature;     // Catch: Throwable -> L7
        if (r1 == null) goto L16;
        r1.cancel(true);     // Catch: Throwable -> L7
        this.mMessageDispatcherFeature = null;     // Catch: Throwable -> L7
    L16:
        ExecutorService r2 = this.mExecutorService;     // Catch: Throwable -> L13
        if (r2 == null) goto L20;
        r2.shutdown();     // Catch: Throwable -> L13
        this.mExecutorService = null;     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onLinkProgress(String r5, JSONObject r6) {
        if (r6 == null) goto L11;
    L7:
        r6.put(WsConstants.KEY_PROGRESS, r5);     // Catch: Throwable -> L5
        Intent r7 = new Intent();     // Catch: Throwable -> L5
        r7.setAction(WsConstants.RECEIVE_PROGRESS_ACTION);     // Catch: Throwable -> L5
        r7.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L5
        r7.putExtra(WsConstants.KEY_PROGRESS, r6.toString());     // Catch: Throwable -> L5
        startOrBindService(r7);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    L11:
        r6 = new JSONObject();     // Catch: Throwable -> L5
        goto L7
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r4, byte[] r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.Msg r2 = new WsChannelService.Msg(r4, r5, getTsIfEnable());     // Catch: Throwable -> L6
        this.mMessageQueue.offer(r2);     // Catch: Throwable -> L6
        mDispatcherAlive.getAndSet(true);     // Catch: Throwable -> L6
        startMessageDispatcher();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onServiceConnectEvent(ServiceConnectEvent r5) {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.RECEIVE_SERVICE_ACTION);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L4
        r0.putExtra("service", r5);     // Catch: Throwable -> L4
        startOrBindService(r0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void replySendMsgResult(WsChannelMsg r6, boolean r7) {
        ComponentName r2 = r6.getReplayToComponentName();
        if (r2 == null) goto L18;
        byte[] r8 = r6.getPayload();     // Catch: Throwable -> L7
        if (r8 != null) goto L9;
        r8 = new byte[1];     // Catch: Throwable -> L7
    L9:
        Intent r3 = new Intent();     // Catch: Throwable -> L7
        r3.setAction(WsConstants.SEND_PAYLOAD_ACTION);     // Catch: Throwable -> L7
        r3.setComponent(r2);     // Catch: Throwable -> L7
        r3.putExtra(WsConstants.KEY_SEND_RESULT, r7);     // Catch: Throwable -> L7
        r3.putExtra(WsConstants.KEY_PAYLOAD_MD5, DigestUtils.md5Hex(r8));     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelService", "send result = " + r7 + " payloadMd5 = " + r3.getStringExtra(WsConstants.KEY_PAYLOAD_MD5));     // Catch: Throwable -> L7
    L12:
        this.mContext.startService(r3);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public void setChannelManager(ChannelManager r1) {
        this.mManager = r1;
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void syncSocketState() {
        Intent r0 = new Intent();     // Catch: Throwable -> L4
        r0.setAction(WsConstants.SYNC_CONNECT_STATE);     // Catch: Throwable -> L4
        r0.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L4
        r0.putParcelableArrayListExtra(WsConstants.KEY_CONNECTION, new ArrayList(this.mKeeper.mChannelState.values()));     // Catch: Throwable -> L4
        startOrBindService(r0);     // Catch: Throwable -> L4
        Logger.d("WsChannelSdk", "try sync socket state to main process");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void tryResendMsg() {
        this.mMessageSender.tryResendMsg();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onMessage(int r4, WsChannelMsg r5) {
        if (r5 != null) goto L9;
        return;
    L9:
        WsChannelService.Msg r2 = new WsChannelService.Msg(r4, r5, getTsIfEnable());     // Catch: Throwable -> L6
        this.mMessageQueue.offer(r2);     // Catch: Throwable -> L6
        mDispatcherAlive.getAndSet(true);     // Catch: Throwable -> L6
        startMessageDispatcher();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IMessageHandler
    public void onConnection(IWsChannelClient r4, SocketState r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mKeeper.mChannelState.put(Integer.valueOf(r5.getChannelId()), r5);
        Intent r6 = new Intent();     // Catch: Throwable -> L7
        r6.setAction(WsConstants.RECEIVE_CONNECTION_ACTION);     // Catch: Throwable -> L7
        r6.setComponent(new ComponentName(this.mContext, WsClientService.class));     // Catch: Throwable -> L7
        r6.putExtra(WsConstants.KEY_CONNECTION, r5);     // Catch: Throwable -> L7
        startOrBindService(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
