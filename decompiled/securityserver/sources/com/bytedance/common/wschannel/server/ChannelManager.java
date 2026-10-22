package com.bytedance.common.wschannel.server;

import a.a;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.channel.IMessageHandler;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.WsChannelClient;
import com.bytedance.common.wschannel.converter.MsgConverterFactory;
import com.bytedance.common.wschannel.log.WsChannelLog;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class ChannelManager implements WeakHandler.IHandler, IEnableObserver.OnWsChannelEnableChangedObserver {
    private final ChannelKeeper mChannelKeeper;
    private final IWsChannelSaver mChannelSaver;
    private final Context mContext;
    private AtomicLong mCounter;
    private boolean mIsForeground;
    private final Object mLock;
    private final IMessageHandler mMessageHandler;
    private final WeakHandler mThreadHandler;
    private IEnableObserver mWsChannelEnableObserver;

    public ChannelManager(Context r4, Looper r5, IWsChannelSaver r6, ChannelKeeper r7, IMessageHandler r8, final IEnableObserver r9) {
        this.mLock = new Object();
        this.mCounter = new AtomicLong(0);
        this.mIsForeground = false;
        this.mContext = r4.getApplicationContext();
        this.mThreadHandler = new WeakHandler(r5, this);
        this.mChannelSaver = r6;
        this.mChannelKeeper = r7;
        this.mMessageHandler = r8;
        this.mWsChannelEnableObserver = r9;
        r9.setEnableListener(this);
        runOnHandlerThread(new AnonymousClass1(this, r9));
    }

    public static /* synthetic */ IWsChannelSaver access$000(ChannelManager r0) {
        return r0.mChannelSaver;
    }

    public static /* synthetic */ void access$100(ChannelManager r0, Map r1) {
        r0.tryConnectIfEnable(r1);
    }

    public static /* synthetic */ IEnableObserver access$200(ChannelManager r0) {
        return r0.mWsChannelEnableObserver;
    }

    public static /* synthetic */ void access$300(ChannelManager r0, Message r1) {
        r0.doHandleMsg(r1);
    }

    public static /* synthetic */ void access$400(ChannelManager r0, IWsChannelClient r1) {
        r0.sendAppStateChangeMessage(r1);
    }

    private void doHandleMsg(Message r12) {
        int r6 = r12.what;     // Catch: Throwable -> L30
        if (r6 == 0) goto L133;
        boolean r7 = true;
        if (r6 == 1) goto L110;
        boolean r8 = false;
        if (r6 != 2) goto L10;
        int r13 = r12.arg1;     // Catch: Throwable -> L30
        if (Logger.debug() == false) goto L99;
        Logger.d("WsChannelService", "appState = " + r13);     // Catch: Throwable -> L30
    L99:
        if (r13 == 1) goto L102;
        r7 = false;
    L102:
        this.mIsForeground = r7;     // Catch: Throwable -> L30
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L30
        if (isEnable() == false) goto L168;
        sendAppStateChangeEvent(this.mChannelKeeper.mWsChannelClientMap.values());     // Catch: Throwable -> L30
        Iterator<IWsChannelClient> r11 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L30
    L106:
        if (r11.hasNext() == false) goto L174;
        IWsChannelClient r0 = r11.next();     // Catch: Throwable -> L30
        if (r0 == null) goto L106;
        r0.onAppStateChanged(r13);     // Catch: Throwable -> L30
        goto L106
    L174:
        return;
    L168:
        return;
    L10:
        if (r6 != 3) goto L12;
        int r14 = r12.arg1;     // Catch: Throwable -> L30
        if (Logger.debug() == false) goto L88;
        Logger.d("WsChannelService", "networkState = " + r14);     // Catch: Throwable -> L30
    L88:
        this.mMessageHandler.tryResendMsg();     // Catch: Throwable -> L30
        if (isEnable() == false) goto L167;
        Iterator<IWsChannelClient> r15 = this.mChannelKeeper.mWsChannelClientMap.values().iterator();     // Catch: Throwable -> L30
    L92:
        if (r15.hasNext() == false) goto L173;
        IWsChannelClient r1 = r15.next();     // Catch: Throwable -> L30
        if (r1 == null) goto L92;
        r1.onNetworkStateChanged(r14);     // Catch: Throwable -> L30
        goto L92
    L173:
        return;
    L167:
        return;
    L12:
        if (r6 != 4) goto L14;
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r16 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L30
        if ((r16 instanceof IWsApp) == false) goto L165;
        doOnParamChange((IWsApp) r16);     // Catch: Throwable -> L30
        return;
    L165:
        return;
    L14:
        if (r6 != 5) goto L16;
    L42:
        if (r6 == 10) goto L45;
        r7 = false;
    L45:
        r12.getData().setClassLoader(WsChannelMsg.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r2 = r12.getData().getParcelable(WsConstants.KEY_PAYLOAD);     // Catch: Throwable -> L30
        if ((r2 instanceof WsChannelMsg) == false) goto L162;
        WsChannelMsg r3 = (WsChannelMsg) r2;     // Catch: Throwable -> L30
        if (r3.getSeqId() > 0) goto L50;
        r3.setSeqId(this.mCounter.incrementAndGet());     // Catch: Throwable -> L30
    L50:
        IWsChannelClient r4 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r3.getChannelId()));     // Catch: Throwable -> L30
        if (r7 == false) goto L53;
        Logger.d("WsChannelService", "retry send msg");     // Catch: Throwable -> L30
    L53:
        if (r4 == null) goto L78;
        if (r6 == 10) goto L61;
        if ((r4 instanceof WsChannelClient) == false) goto L61;
        if (((WsChannelClient) r4).isOkChannelImpl() == false) goto L61;
        r3 = tryAddOkWsPayloadOpaque(r4, r3);     // Catch: Throwable -> L30
    L61:
        if (r4.privateProtocolEnabled() == true) goto L63;
    L66:
        boolean r5 = r4.sendMessage(MsgConverterFactory.getConverter().encode(r3));     // Catch: Throwable -> L30
    L65:
        r8 = r5;
        long r9 = WsChannelSettings.inst(this.mContext).getRetryDelay();     // Catch: Throwable -> L30
        if (r8 == true) goto L73;
        if (r7 == true) goto L73;
        if (r9 <= 0) goto L73;
        Message r17 = Message.obtain(r12);     // Catch: Throwable -> L30
        r17.what = 10;     // Catch: Throwable -> L30
        this.mThreadHandler.sendMessageDelayed(r17, r9);     // Catch: Throwable -> L30
    L73:
        if (r8 == false) goto L75;
    L77:
        this.mMessageHandler.replySendMsgResult(r3, r8);     // Catch: Throwable -> L30
    L80:
        if (Logger.debug() == false) goto L163;
        Logger.d("WsChannelService", "send payload success = " + r8);     // Catch: Throwable -> L30
        return;
    L163:
        return;
    L75:
        if (r9 <= 0) goto L77;
        if (r7 == false) goto L80;
    L63:
        if (r4.privateProtocolProxyEnabled() == true) goto L66;
        r5 = r4.sendMessage(r3);     // Catch: Throwable -> L30
        goto L65
    L78:
        this.mMessageHandler.replySendMsgResult(r3, false);     // Catch: Throwable -> L30
        goto L80
    L162:
        return;
    L16:
        if (r6 == 9) goto L41;
        if (r6 == 10) goto L42;
        if (r6 != 12) goto L21;
        r12.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r18 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L30
        if ((r18 instanceof ServiceParcelable) == false) goto L158;
        int r10 = ((ServiceParcelable) r18).getChannelId();     // Catch: Throwable -> L30
        int r19 = ((ServiceParcelable) r18).getServiceId();     // Catch: Throwable -> L30
        IWsChannelClient r110 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r10));     // Catch: Throwable -> L30
        if (r110 != null) goto L38;
        return;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d("WsChannelService", "register serviceId = " + r19);     // Catch: Throwable -> L30
    L40:
        r110.registerService(r19);     // Catch: Throwable -> L30
        return;
    L158:
        return;
    L21:
        if (r6 != 13) goto L154;
        r12.getData().setClassLoader(ServiceParcelable.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r111 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L30
        if ((r111 instanceof ServiceParcelable) == false) goto L155;
        int r20 = ((ServiceParcelable) r111).getChannelId();     // Catch: Throwable -> L30
        int r112 = ((ServiceParcelable) r111).getServiceId();     // Catch: Throwable -> L30
        IWsChannelClient r113 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r20));     // Catch: Throwable -> L30
        if (r113 != null) goto L28;
        return;
    L28:
        if (Logger.debug() == false) goto L32;
        Logger.d("WsChannelService", "unregister serviceId = " + r112);     // Catch: Throwable -> L30
    L32:
        r113.unregisterService(r112);     // Catch: Throwable -> L30
        return;
    L155:
        return;
    L154:
        return;
    L41:
        this.mMessageHandler.syncSocketState();     // Catch: Throwable -> L30
        return;
    L110:
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r114 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L30
        if ((r114 instanceof IntegerParcelable) == false) goto L169;
        int r115 = ((IntegerParcelable) r114).getData();     // Catch: Throwable -> L30
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L30
        this.mChannelKeeper.mWsAppMap.remove(Integer.valueOf(r115));     // Catch: Throwable -> L130
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L130
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L130
        Object r21 = this.mLock;     // Catch: Throwable -> L30
        monitor-enter(r21);     // Catch: Throwable -> L30
        IWsChannelClient r22 = this.mChannelKeeper.mWsChannelClientMap.remove(Integer.valueOf(r115));     // Catch: Throwable -> L127
        monitor-exit(r21);     // Catch: Throwable -> L127
        if (r22 != null) goto L122;
    L125:
        this.mChannelKeeper.mChannelState.remove(Integer.valueOf(r115));     // Catch: Throwable -> L30
        this.mThreadHandler.sendMessageDelayed(this.mThreadHandler.obtainMessage(8, r22), 1000);     // Catch: Throwable -> L30
        return;
    L122:
        if (Logger.debug() == false) goto L124;
        Logger.d("WsChannelService", "stopConnection,channelId = " + r115);     // Catch: Throwable -> L30
    L124:
        r22.destroy();     // Catch: Throwable -> L30
        goto L125
    L127:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L130:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L169:
        return;
    L133:
        r12.getData().setClassLoader(SsWsApp.class.getClassLoader());     // Catch: Throwable -> L30
        Parcelable r116 = r12.getData().getParcelable(WsConstants.KEY_WS_APP);     // Catch: Throwable -> L30
        if ((r116 instanceof IWsApp) == false) goto L170;
        doRegisterChannel((IWsApp) r116);     // Catch: Throwable -> L30
        return;
    L170:
        return;
    L30:
        th = move-exception;
        th.printStackTrace();
    }

    private void doOnParamChange(@NonNull IWsApp r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "doOnParamChange");
    L5:
        int r0 = WsChannelService.getClientKey(r6);
        if (isEnable() == false) goto L35;
        IWsChannelClient r1 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r6.getChannelId()));     // Catch: Throwable -> L23
        monitor-enter(WsChannelService.class);     // Catch: Throwable -> L23
        IWsApp r3 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L16
        if (r1 != null) goto L12;
    L27:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L16
        return;
    L12:
        if (r6.equals(r3) == true) goto L14;
    L18:
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r0), r6);     // Catch: Throwable -> L16
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L16
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L16
        Map<String, Object> r5 = getConfigMap(r6);     // Catch: Throwable -> L23
        if (r5 == null) goto L26;
        r1.onParameterChange(r5, r6.getConnectUrls());     // Catch: Throwable -> L23
        return;
    L26:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L23
    L14:
        if (r1.isConnected() == false) goto L18;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void doRegisterChannel(@NonNull IWsApp r9) {
        int r0 = WsChannelService.getClientKey(r9);
        if (isEnable() == true) goto L6;
        return;
    L6:
        monitor-enter(WsChannelService.class);
        IWsApp r2 = this.mChannelKeeper.mWsAppMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L14
        IWsChannelClient r3 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r0));     // Catch: Throwable -> L14
        boolean r4 = false;
        boolean r5 = true;
        if (r2 != null) goto L10;
    L16:
        if (r2 != null) goto L18;
        this.mChannelKeeper.mWsAppMap.put(Integer.valueOf(r0), r9);     // Catch: Throwable -> L14
        this.mChannelSaver.saveWsChannels(this.mChannelKeeper.mWsAppMap);     // Catch: Throwable -> L14
    L12:
        r5 = false;
        r4 = true;
    L18:
        monitor-exit(WsChannelService.class);     // Catch: Throwable -> L14
        if (r4 == false) goto L21;
        tryOpenConnection(r9);
        return;
    L21:
        if (r5 == false) goto L29;
        doOnParamChange(r9);
        return;
    L29:
        return;
    L10:
        if (r9.equals(r2) == false) goto L16;
        if (r3 == null) goto L12;
        r5 = false;
    L14:
        th = move-exception;
        throw th;
    }

    private Map<String, Object> getConfigMap(IWsApp r11) {
        HashMap r0 = new HashMap();
        r0.put("app_key", r11.getAppKey());
        r0.put(WsConstants.KEY_FPID, Integer.valueOf(r11.getFPID()));
        r0.put(WsConstants.KEY_SDK_VERSION, 2);
        r0.put(WsConstants.KEY_PLATFORM, 0);
        r0.put("app_version", Integer.valueOf(r11.getAppVersion()));
        r0.put("aid", Integer.valueOf(r11.getAppId()));
        r0.put("device_id", r11.getDeviceId());
        r0.put(WsConstants.KEY_INSTALL_ID, r11.getInstallId());
        r0.put(WsConstants.KEY_HEADERS, r11.getHeaders());
        String r3 = r11.getExtra();
        if (r3 != null) goto L6;
        onNullParamLog(WsConstants.KEY_EXTRA);
        r3 = "";
    L6:
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == false) goto L17;
        String[] r7 = r3.split("&");
        if (isForeground() == false) goto L10;
        String r8 = "0";
    L11:
        String r9 = "is_background=".concat(r8);
        if (r7.length > 0) goto L14;
    L16:
        r3 = r9;
        goto L17
    L14:
        if (TextUtils.isEmpty(r7[0]) == true) goto L16;
        r3 = a.B(r3, "&", r9);
        goto L17
    L10:
        r8 = "1";
    L17:
        r0.put(WsConstants.KEY_EXTRA, r3);
        if (r11.getDeviceId() != null) goto L21;
        onNullParamLog("device_id");
    L21:
        if (r11.getInstallId() != null) goto L24;
        onNullParamLog("install_id");
    L24:
        if (StringUtils.isEmpty(r11.getAppKey()) == false) goto L26;
        onNullParamLog("app_key");
    L26:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, Boolean.valueOf(r11.newPrivateProtocolEnabled()));
        if (r11.getServiceIdList() == null) goto L30;
        r0.put(WsConstants.KEY_SERVICE_ID_LIST, r11.getServiceIdList());
    L30:
        if (TextUtils.isEmpty(r11.getPrivateProtocolUrl()) == true) goto L32;
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, r11.getPrivateProtocolUrl());
    L32:
        r0.put(WsConstants.KEY_TRANSPORT_MODE, Integer.valueOf(r11.getTransportMode()));
        r0.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, Boolean.valueOf(r11.disableFallbackWSEnabled()));
        return r0;
    }

    private boolean isEnable() {
        return this.mWsChannelEnableObserver.isEnable();
    }

    private boolean isEnableOfflineDetect() {
        Context r1 = this.mContext;
        if (r1 != null) goto L5;
        return false;
    L5:
        WsChannelSettings r2 = WsChannelSettings.inst(r1);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.isEnableOfflineDetect();
    }

    private boolean isForeground() {
        return this.mIsForeground;
    }

    private void onNullParamLog(String r3) {
        Bundle r0 = new Bundle();
        r0.putString("param_name", r3);
        WsChannelLog.onEventV3Bundle(this.mContext, "wschannel_param_null", r0);
    }

    private void runOnHandlerThread(Runnable r1) {
        this.mThreadHandler.post(r1);
    }

    private void sendAppStateChangeEvent(Collection<IWsChannelClient> r2) {
        if (WsChannelSettings.inst(this.mContext).isReportAppStateEnable() == true) goto L5;
        return;
    L5:
        Iterator<IWsChannelClient> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        sendAppStateChangeMessage(r3.next());     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private void sendAppStateChangeMessage(IWsChannelClient r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        WsChannelMsg r1 = createStateChangedMsg();
        if (r2.privateProtocolEnabled() == false) goto L8;
        r2.sendMessage(r1);
        return;
    L8:
        r2.sendMessage(MsgConverterFactory.getConverter().encode(r1));
    }

    private void stopAllSocket() {
        Object r0 = this.mLock;     // Catch: Throwable -> L16
        monitor-enter(r0);     // Catch: Throwable -> L16
        Iterator<Map.Entry<Integer, IWsChannelClient>> r1 = this.mChannelKeeper.mWsChannelClientMap.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L12;
        IWsChannelClient r2 = r1.next().getValue();     // Catch: Throwable -> L10
        if (r2 == null) goto L6;
        r2.destroy();     // Catch: Throwable -> L10
        goto L6
    L12:
        this.mChannelKeeper.mWsChannelClientMap.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mChannelKeeper.mWsAppMap.clear();     // Catch: Throwable -> L16
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
    }

    private void tryConnectIfEnable(Map<Integer, IWsApp> r2) {
        if (isEnableOfflineDetect() == false) goto L8;
        if (NetworkUtils.isNetworkAvailable(this.mContext) == true) goto L8;
        return;
    L8:
        if (this.mWsChannelEnableObserver.isEnable() == false) goto L17;
        if (r2 == null) goto L23;
        Iterator<IWsApp> r3 = r2.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L24;
        IWsApp r0 = r3.next();
        if (r0 == null) goto L12;
        doRegisterChannel(r0);
        goto L12
    L24:
        return;
    L23:
        return;
    }

    private void tryOpenConnection(IWsApp r6) {
        if (Logger.debug() == false) goto L5;
        Logger.d("WsChannelService", "tryOpenConnection");
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        IWsChannelClient r2 = this.mChannelKeeper.mWsChannelClientMap.get(Integer.valueOf(r6.getChannelId()));     // Catch: Throwable -> L10
        if (r2 != null) goto L12;
        r2 = WsChannelClient.newInstance(r6.getChannelId(), this.mMessageHandler, this.mThreadHandler);     // Catch: Throwable -> L10
        r2.init(this.mContext, r2);     // Catch: Throwable -> L10
        this.mChannelKeeper.mWsChannelClientMap.put(Integer.valueOf(r6.getChannelId()), r2);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (r2.isConnected() == false) goto L38;
        SocketState r7 = this.mChannelKeeper.mChannelState.get(Integer.valueOf(r6.getChannelId()));
        Logger.d("WsChannelService", "state = " + r7);
        if (r7 == null) goto L39;
        this.mMessageHandler.onConnection(r2, r7);     // Catch: Throwable -> L33
        return;
    L42:
        return;
    L39:
        return;
    L38:
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        if (Logger.debug() == false) goto L24;
        Logger.d("WsChannelService", "try to open connection ,channelId = " + r6.getChannelId());     // Catch: Throwable -> L22
    L24:
        Map<String, Object> r5 = getConfigMap(r6);     // Catch: Throwable -> L22
        if (r5 == null) goto L28;
        r2.openConnection(r5, r6.getConnectUrls());     // Catch: Throwable -> L22
        return;
    L28:
        throw new IllegalArgumentException("configMap is empty !!!");     // Catch: Throwable -> L22
    L10:
        th = move-exception;
        throw th;
    }

    @NonNull
    public WsChannelMsg createStateChangedMsg() {
        WsChannelMsg.Builder r0 = WsChannelMsg.Builder.create(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).setMethod(4).setService(WsConstants.APP_STATE_CHANGE_SERVICE).setLogId(1008601).setPayload(new byte[0]).setPayloadEncoding("pb").setPayloadType("pb");
        if (isForeground() == false) goto L5;
        String r3 = "0";
    L7:
        return r0.addMsgHeader(WsConstants.APP_STATE_BACKGROUND_KEY, r3).build();
    L5:
        r3 = "1";
        goto L7
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r2) {
        final Message r3 = Message.obtain(r2);
        runOnHandlerThread(new AnonymousClass2(this, r3));
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver.OnWsChannelEnableChangedObserver
    public void onWsChannelEnableChange(boolean r1) {
        if (r1 == false) goto L4;
        tryConnectIfEnable(this.mChannelSaver.loadWsChannels());
        return;
    L4:
        stopAllSocket();
    }

    public void syncCurrentState(final IWsChannelClient r3) {
        if (r3.isConnected() == true) goto L5;
        return;
    L5:
        this.mThreadHandler.post(new AnonymousClass3(this, r3));
    }

    public WsChannelMsg tryAddOkWsPayloadOpaque(IWsChannelClient r2, WsChannelMsg r3) {
        WsChannelSettings.OkOpaqueCallback r1 = WsChannelSettings.getOkOpaqueCallback();
        if (r1 != null) goto L15;
        return r3;
    L15:
        Iterator<Map.Entry<String, String>> r4 = r1.onCallToWSPayloadOpaque(r3.toMap()).entrySet().iterator();     // Catch: Exception -> L10
    L7:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<String, String> r5 = r4.next();     // Catch: Exception -> L10
        r3.addHeader(r5.getKey(), r5.getValue());     // Catch: Exception -> L10
        goto L7
    L12:
        return r3;
    L10:
        e = move-exception;
        Logger.w("tryAddOkWsPayloadOpaque failed with exception" + e);
        return r3;
    }
}
