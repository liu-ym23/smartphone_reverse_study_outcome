package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.monitor.IWsSdkMonitor;
import com.bytedance.common.wschannel.server.PushChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelSdk {
    private static final long DELAY_POST_APPSTATE_INETRVAL = 2000;
    private static WsChannelApi impl;
    private static AppStateListener mAppStateChangedListener;
    private static MemTrimListener mMemTrimListener;
    private static Map<Integer, ChannelInfo> mRegisterMap;
    private static Application sApplication;
    private static boolean sCalculateAppState;
    private static DelayParam sDelayParams;
    private static Map<Integer, BaseHeartBeatPolicy> sHeartbeatPolicy;
    private static volatile boolean sInit;
    private static boolean sIsCurrentBackground;
    private static final Object sLock = null;
    private static String sProcessName;

    private static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private AppStateListener() {
        }

        /* synthetic */ AppStateListener(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            WsChannelSdk.access$302(false);
            if (WsChannelSdk.access$700() != null) goto L5;
        L6:
            WsChannelSdk.access$500().onEnterToForeground(WsChannelSdk.access$400());
            return;
        L5:
            if (DelayParam.access$100(WsChannelSdk.access$700()) == true) goto L6;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            WsChannelSdk.access$302(true);
            if (WsChannelSdk.access$700() != null) goto L5;
        L6:
            WsChannelSdk.access$500().onEnterToBackground(WsChannelSdk.access$400());
            return;
        L5:
            if (DelayParam.access$100(WsChannelSdk.access$700()) == true) goto L6;
        }
    }

    private static class DelayParam {
        private boolean finishDelay;
        private Map<Integer, ChannelInfo> mDelayMap;

        private DelayParam() {
            this.finishDelay = false;
            this.mDelayMap = new ConcurrentHashMap();
        }

        /* synthetic */ DelayParam(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean access$100(DelayParam r0) {
            return r0.finishDelay;
        }

        static /* synthetic */ boolean access$102(DelayParam r0, boolean r1) {
            r0.finishDelay = r1;
            return r1;
        }

        static /* synthetic */ Map access$200(DelayParam r0) {
            return r0.mDelayMap;
        }
    }

    static /* synthetic */ boolean access$300() {
        return sIsCurrentBackground;
    }

    static /* synthetic */ boolean access$302(boolean r0) {
        sIsCurrentBackground = r0;
        return r0;
    }

    static /* synthetic */ Application access$400() {
        return sApplication;
    }

    static /* synthetic */ WsChannelApi access$500() {
        return impl;
    }

    static /* synthetic */ DelayParam access$700() {
        return sDelayParams;
    }

    static {
        sLock = new Object();
        impl = new WsChannelMultiProcessImpl();
        mAppStateChangedListener = new AppStateListener(null);
        mMemTrimListener = null;
        mRegisterMap = new ConcurrentHashMap();
        sHeartbeatPolicy = new ConcurrentHashMap();
    }

    private WsChannelSdk() {
    }

    public static Context getContext() {
        return sApplication;
    }

    public static void init(Application r3, OnMessageReceiveListener r4) {
        doInit(r3, r4, false, true, null);
    }

    public static void init(Application r2, OnMessageReceiveListener r3, boolean r4) {
        doInit(r2, r3, r4, true, null);
    }

    public static void init(Application r1, OnMessageReceiveListener r2, OnBindWsChannelServiceListener r3, boolean r4) {
        doInit(r1, r2, r4, true, r3);
    }

    public static void init(WschannelSdkInitParam r0) {
        doInitWithParam(r0);
    }

    public static void initWithoutLifeCycle(Application r2, OnMessageReceiveListener r3) {
        doInit(r2, r3, false, false, null);
    }

    public static void finishDelay() {
        checkInit();
        Object r0 = sLock;
        monitor-enter(r0);
        DelayParam r1 = sDelayParams;     // Catch: Throwable -> L22
        if (r1 != null) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L7:
        if (DelayParam.access$100(r1) == true) goto L20;
        DelayParam.access$102(sDelayParams, true);     // Catch: Throwable -> L22
        if (DelayParam.access$200(sDelayParams).isEmpty() == true) goto L16;
        Iterator r2 = DelayParam.access$200(sDelayParams).values().iterator();     // Catch: Throwable -> L22
    L13:
        if (r2.hasNext() == false) goto L15;
        registerChannel((ChannelInfo) r2.next());     // Catch: Throwable -> L22
        goto L13
    L15:
        DelayParam.access$200(sDelayParams).clear();     // Catch: Throwable -> L22
    L17:
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass1(), DELAY_POST_APPSTATE_INETRVAL);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L16:
        impl.tryStartPushProcess(sApplication, true, true);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static void registerChannel(ChannelInfo r3) {
        checkInit();
        Object r0 = sLock;
        monitor-enter(r0);
        DelayParam r1 = sDelayParams;     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L10:
        doRealRegisterOrParametersChangedMethod(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (DelayParam.access$100(r1) == true) goto L10;
        DelayParam.access$200(sDelayParams).put(Integer.valueOf(r3.channelId), r3);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private static void doRealRegisterOrParametersChangedMethod(ChannelInfo r2) {
        mRegisterMap.put(Integer.valueOf(r2.channelId), r2);
        SsWsApp r3 = createParameterMap(r2);
        impl.registerApp(sApplication, r3);
    }

    @Deprecated
    public static void registerToutianChannel(ChannelInfo r2, String r3) {
        r2.extra.put("sid", r3);
        registerChannel(r2);
    }

    public static void registerService(int r2, int r3) {
        checkInit();
        impl.registerServiceId(sApplication, r2, r3);
    }

    public static void unregisterService(int r2, int r3) {
        checkInit();
        impl.unregisterServiceId(sApplication, r2, r3);
        WsConstants.removeService(r2, r3);
    }

    public static void unregisterChannel(int r3) {
        checkInit();
        WsConstants.remove(r3);
        mRegisterMap.remove(Integer.valueOf(r3));
        Object r0 = sLock;
        monitor-enter(r0);
        DelayParam r1 = sDelayParams;     // Catch: Throwable -> L12
        if (r1 != null) goto L7;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        finishDelay();
        impl.unRegisterApp(sApplication, r3);
        return;
    L7:
        if (DelayParam.access$100(r1) == true) goto L9;
        DelayParam.access$200(sDelayParams).remove(Integer.valueOf(r3));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static void setEnable(Context r1, boolean r2) {
        boolean r0 = WsChannelSettings.inst(r1).isEnable();
        WsChannelSettings.inst(r1).setEnable(r2);
        if (r0 == true) goto L9;
        if (r2 == false) goto L11;
        Iterator<ChannelInfo> r3 = mRegisterMap.values().iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        registerChannel(r3.next());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public static void onParametersChanged(ChannelInfo r4) {
        checkInit();
        Object r0 = sLock;
        monitor-enter(r0);
        DelayParam r1 = sDelayParams;     // Catch: Throwable -> L13
        if (r1 != null) goto L7;
    L10:
        SsWsApp r2 = createParameterMap(r4);     // Catch: Throwable -> L13
        mRegisterMap.put(Integer.valueOf(r4.channelId), r4);     // Catch: Throwable -> L13
        impl.onParameterChange(sApplication, r2);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (DelayParam.access$100(r1) == true) goto L10;
        DelayParam.access$200(sDelayParams).put(Integer.valueOf(r4.channelId), r4);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static void onToutiaoWsChannelParametersChanged(ChannelInfo r2, String r3) {
        r2.extra.put("sid", r3);
        onParametersChanged(r2);
    }

    public static void sendPayload(WsChannelMsg r2) {
        checkInit();
        if (r2 == null) goto L28;
        if (r2.getChannelId() <= 0) goto L26;
        if (r2.getService() < 0) goto L24;
        if (r2.getMethod() <= 0) goto L22;
        if (r2.getPayload() == null) goto L20;
        DelayParam r0 = sDelayParams;
        if (r0 != null) goto L15;
    L17:
        impl.sendPayload(sApplication, r2);
        return;
    L15:
        if (DelayParam.access$100(r0) == true) goto L17;
        finishDelay();
        goto L17
    L20:
        throw new IllegalArgumentException("illegal payload");
    L22:
        throw new IllegalArgumentException("illegal method");
    L24:
        throw new IllegalArgumentException("illegal service");
    L26:
        throw new IllegalArgumentException("illegal channelId");
    L28:
        throw new IllegalArgumentException("WsChannelMsg can't be null");
    }

    public static String sendPayloadWithAck(WsChannelMsg r3) {
        checkInit();
        if (r3 == null) goto L28;
        if (r3.getChannelId() <= 0) goto L26;
        if (r3.getService() < 0) goto L24;
        if (r3.getMethod() <= 0) goto L22;
        if (r3.getPayload() == null) goto L20;
        DelayParam r0 = sDelayParams;
        if (r0 != null) goto L15;
    L17:
        String r1 = UUID.randomUUID().toString().replace("-", "");
        r3.setUUID(r1);
        impl.sendPayload(sApplication, r3);
        return r1;
    L15:
        if (DelayParam.access$100(r0) == true) goto L17;
        finishDelay();
        goto L17
    L20:
        throw new IllegalArgumentException("illegal payload");
    L22:
        throw new IllegalArgumentException("illegal method");
    L24:
        throw new IllegalArgumentException("illegal service");
    L26:
        throw new IllegalArgumentException("illegal channelId");
    L28:
        throw new IllegalArgumentException("WsChannelMsg can't be null");
    }

    public static void enterToForeground() {
        if (sInit == true) goto L6;
        return;
    L6:
        if (sCalculateAppState == true) goto L9;
        mAppStateChangedListener.onEnterToForeground();
        return;
    }

    public static void enterToBackground() {
        if (sInit == true) goto L6;
        return;
    L6:
        if (sCalculateAppState == true) goto L9;
        mAppStateChangedListener.onEnterToBackground();
        return;
    }

    public static MemTrimListener getMemTrimListener() {
        return mMemTrimListener;
    }

    public static void setMemTrimListener(MemTrimListener r0) {
        mMemTrimListener = r0;
    }

    public static void onTrimMemory(int r2) {
        if (sInit == true) goto L5;
        return;
    L5:
        impl.onTrimMemory(sApplication, r2);
    }

    public static boolean isWsConnected(int r3) {
        DelayParam r0 = sDelayParams;
        if (r0 != null) goto L5;
    L6:
        WsChannelApi r1 = impl;
        Application r2 = sApplication;
        r1.tryStartPushProcess(r2, Utils.isMainProcess(r2, sProcessName));
    L8:
        return WsConstants.isWsChannelConnected(r3);
    L5:
        if (DelayParam.access$100(r0) == false) goto L8;
        goto L6
    }

    public static boolean isPrivateProtocolEnabled(int r0) {
        return WsConstants.isPrivateProtocolEnabled(r0);
    }

    public static boolean isWsServiceConnected(int r0, int r1) {
        return WsConstants.isServiceConnected(r0, r1);
    }

    public static void setAutoConnectDisabledChannelIds(Context r0, ArrayList<Integer> r1) {
        WsChannelSettings.inst(r0).setAutoConnectDisabledChannelIds(r1);
    }

    public static boolean isOkChannelEnable(Context r0) {
        return WsChannelSettings.inst(r0).isOkChannelEnable();
    }

    public static boolean isEnable(Context r0) {
        return WsChannelSettings.inst(r0).isEnable();
    }

    public static void setEnableReportAppState(Context r0, boolean r1) {
        WsChannelSettings.inst(r0).setReportAppStateEnable(r1);
    }

    public static void setOkChannelEnable(Context r0, boolean r1) {
        WsChannelSettings.inst(r0).setOKChannelEnable(r1);
    }

    public static void setSocketLimit(Context r0, long r1) {
        WsChannelSettings.inst(r0).setSocketReadLimitSize(r1);
    }

    public static void setRetrySendMsgDelayTimeMillis(Context r0, long r1) {
        WsChannelSettings.inst(r0).setRetrySendMsgDelay(r1);
    }

    public static void setMonitorInPush(IWsSdkMonitor r1) {
        HeartBeatMonitor.getInstance().setHeartBeatMonitor(r1);
    }

    public static <T extends IHeartBeatMeta> void setHeartBeatPolicy(int r1, BaseHeartBeatPolicy<T> r2) {
        sHeartbeatPolicy.put(Integer.valueOf(r1), r2);
    }

    public static <T extends IHeartBeatMeta> BaseHeartBeatPolicy<T> getHeartBeatPolicy(int r1) {
        return sHeartbeatPolicy.get(Integer.valueOf(r1));
    }

    private static void doInitWithParam(WschannelSdkInitParam r9) {
        if (sInit == false) goto L5;
        return;
    L5:
        Application r0 = r9.getApplication();
        OnMessageReceiveListener r1 = r9.getListener();
        boolean r2 = r9.isCalculateAppState();
        boolean r3 = r9.isDelayStartPushProcess();
        OnBindWsChannelServiceListener r4 = r9.bindWsChannelServiceListener;
        boolean r5 = r9.isEnableOfflineDetect();
        sInit = true;
        sApplication = r0;
        sCalculateAppState = r2;
        String r7 = Utils.getCurProcessName(r0);
        sProcessName = r7;
        boolean r8 = Utils.isMainProcess(r0, r7);
        if (r3 == false) goto L9;
        if (r8 == false) goto L9;
        DelayParam r6 = new DelayParam(null);
        sDelayParams = r6;
        DelayParam.access$102(r6, false);
    L9:
        if (r8 == false) goto L18;
        if (r2 == false) goto L12;
        LifeCycleMonitor r10 = new LifeCycleMonitor();
        r10.setAppStateChangedListener(mAppStateChangedListener);
        r0.registerActivityLifecycleCallbacks(r10);
    L12:
        WsConstants.setOnMessageReceiveListener(r1);
        WsConstants.setOptLogic(r9.getOptLogic());
        WsConstants.setBindWsChannelServiceListener(r4);
        if (r0 == null) goto L21;
        WsChannelSettings r11 = WsChannelSettings.inst(r0);
        if (r11 == null) goto L21;
        r11.setEnableOfflineDetect(r5);
    L21:
        if (sDelayParams != null) goto L24;
        impl.tryStartPushProcess(sApplication, r8, true);
        return;
    L24:
        return;
    L18:
        if (Utils.isMessageProcess(sProcessName) == false) goto L21;
        registerNetChangeReceiver();
        goto L21
    }

    private static void doInit(Application r1, OnMessageReceiveListener r2, boolean r3, boolean r4, OnBindWsChannelServiceListener r5) {
        doInitWithParam(new WschannelSdkInitParam.Builder().application(r1).messageReceiveListener(r2).delayStartPushProcess(r3).calculateAppState(r4).enableOfflineDetect(false).bindWsChannelServiceListener(r5).build());
    }

    private static SsWsApp createParameterMap(ChannelInfo r13) {
        Map<String, String> r0 = r13.extra;
        ArrayList r1 = new ArrayList();
        Iterator<Map.Entry<String, String>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, String> r3 = r2.next();
        if (r3 == null) goto L4;
        r1.add(r3.getKey() + "=" + Uri.encode(r3.getValue()));
        goto L4
    L9:
        int r4 = r13.aid;
        if (r4 <= 0) goto L46;
        String r5 = r13.deviceId;
        if (StringUtils.isEmpty(r5) == true) goto L44;
        String r6 = r13.installId;
        if (StringUtils.isEmpty(r6) == true) goto L42;
        int r7 = r13.fpid;
        if (r7 <= 0) goto L40;
        String r8 = r13.appKey;
        if (StringUtils.isEmpty(r8) == true) goto L38;
        int r9 = r13.updateVersionCode;
        if (r9 <= 0) goto L36;
        int r10 = r13.channelId;
        if (r10 <= 0) goto L34;
        boolean r11 = r13.privateProtocolEnabled;
        List<Integer> r12 = r13.serviceIdList;
        if (r11 == false) goto L31;
        if (r12 == null) goto L30;
        if (r12.isEmpty() == false) goto L31;
    L30:
        throw new IllegalArgumentException("ServiceIdList cannot be empty when private protocol is enabled.");
    L31:
        boolean r14 = r13.disableFallbackWs;
        WsConstants.initServiceState(r10, r12);
        return new SsWsApp.SsWsAppBuilder().setAppId(r4).setDeviceId(r5).setInstallId(r6).setFPID(r7).setAppKey(r8).setConnectUrls(r13.urls).setAppVersion(r9).setPlatform(0).setChannelId(r10).setExtra(TextUtils.join("&", r1.toArray())).setHeaders(r13.headers).enableNewPrivateProtocol(r11).setServiceIdList(r12).setPrivateProtocolUrl(r13.privateProtocolUrl).setTransportMode(r13.transportMode.getTypeValue()).disableFallbackWS(r14).build();
    L34:
        throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
    L36:
        throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
    L38:
        throw new IllegalArgumentException("appKey is empty,please set appKey first");
    L40:
        throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
    L42:
        throw new IllegalArgumentException("installId is empty ,please set installId first");
    L44:
        throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
    L46:
        throw new IllegalArgumentException("aid == 0 ,please set aid first");
    }

    private static void registerNetChangeReceiver() {
        IntentFilter r0 = new IntentFilter();     // Catch: Exception -> L4
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        Application r1 = sApplication;     // Catch: Exception -> L4
        Application r3 = sApplication;     // Catch: Exception -> L4
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, new WsChannelReceiver(r3, PushChannelManager.inst(r3)), r0);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static void checkInit() {
        if (sInit == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("please init first");
    }

    public static JSONObject reportFrontierMessageMetrics(WsChannelMsg r5, int r6) {
        ChannelInfo r7 = mRegisterMap.get(Integer.valueOf(r6));
        if (r7 == null) goto L21;
        if (r5 == null) goto L21;
        JSONObject r2 = parseServerTiming(r5.getServerTiming());     // Catch: Exception -> L19
        if (r2 != null) goto L10;
        return null;
    L10:
        r2.put("im_rt", true);     // Catch: Exception -> L19
        r2.put("msgid", r5.getMsgId());     // Catch: Exception -> L19
        r2.put("service_id", r5.getService());     // Catch: Exception -> L19
        r2.put(WsConstants.KEY_FPID, r7.fpid);     // Catch: Exception -> L19
        r2.put("qid", r7.aid);     // Catch: Exception -> L19
        if (r7.privateProtocolEnabled == false) goto L14;
        r2.put("mode", r7.transportMode.getTypeValue());     // Catch: Exception -> L19
        r2.put(WifiAuthorizeUtils.AUTO_LOGIN_HOST, r7.privateProtocolUrl);     // Catch: Exception -> L19
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.d(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET, "user_msg:" + r2);     // Catch: Exception -> L19
    L18:
        return r2;
    L14:
        r2.put("mode", 4);     // Catch: Exception -> L19
        r2.put(WifiAuthorizeUtils.AUTO_LOGIN_HOST, r7.urls.get(0));     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        return null;
    }

    private static JSONObject parseServerTiming(String r18) throws Exception {
        String r0 = r18;
        LinkedHashMap r1 = new LinkedHashMap();
        if (splitStringIntoKeyValueMap(r0, "=", ";", ",", r1) == true) goto L6;
        return null;
    L6:
        if (r1.containsKey(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET) == true) goto L8;
        return null;
    L8:
        Map r2 = (Map) r1.get(ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);
        if (r2.containsKey("recv_time") == true) goto L11;
        return null;
    L11:
        long r5 = Long.parseLong((String) r2.get("recv_time"));
        if (r5 >= 0) goto L14;
        return null;
    L14:
        JSONObject r3 = new JSONObject();
        if (r2.containsKey("sta") == false) goto L17;
        long r10 = Long.parseLong((String) r2.get("sta"));
    L18:
        long r12 = System.currentTimeMillis();
        if (r10 <= 0) goto L21;
        long r14 = r5 - r10;
        boolean r4 = true;
    L22:
        long r7 = r12 - r5;
        r3.put(WsConstants.KEY_IS_ACK, r4);
        r3.put("tt_dur", r14);
        r3.put("recv_call_dur", r7);
        String r6 = "";
        r3.put(ICronetClient.KEY_RECEIVE_TIME, r5 + "");
        r3.put("im_recv_time", r12);
        Iterator r8 = r1.keySet().iterator();
    L24:
        if (r8.hasNext() == false) goto L31;
        String r9 = (String) r8.next();
        if (r9.startsWith("client_") == false) goto L24;
        if (r9.length() <= 7) goto L24;
        r6 = r9;
    L31:
        if (TextUtils.isEmpty(r6) == true) goto L38;
        r3.put("msg_type", r6.substring(7));
        Map r11 = (Map) r1.get(r6);
        if (r11.containsKey("sta") == false) goto L38;
        long r13 = Long.parseLong((String) r11.get("sta"));
        if (r13 <= 0) goto L38;
        r3.put("im_dur", r12 - r13);
        r3.put("send_call_dur", r10 - r13);
    L38:
        if (r0.substring(r18.length() - 1) == ",") goto L40;
        r0 = r0 + ",";
    L40:
        r3.put("server_timing", r0 + "im_recv;dur=" + r7);
        return r3;
    L21:
        r4 = false;
        r14 = 0;
        goto L22
    L17:
        r10 = -1;
        goto L18
    }

    private static boolean splitStringIntoKeyValueMap(String r9, String r10, String r11, String r12, Map<String, Map<String, String>> r13) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r12) == true) goto L68;
        if (r13 == null) goto L70;
        String[] r14 = r9.split(r12);
        if (r14 != null) goto L15;
        return false;
    L15:
        int r15 = 0;
    L17:
        if (r15 >= r14.length) goto L49;
        if (TextUtils.isEmpty(r14[r15]) == true) goto L47;
        String[] r0 = r14[r15].trim().split(r11);
        if (r0 == null) goto L47;
        if (r0.length < 2) goto L47;
        String r3 = r0[0];
        LinkedHashMap r5 = new LinkedHashMap();
        int r6 = 1;
    L28:
        if (r6 >= r0.length) goto L45;
        if (TextUtils.isEmpty(r0[r6]) == true) goto L43;
        String[] r7 = r0[r6].trim().split(r10);
        if (r7 == null) goto L43;
        if (r7.length != 2) goto L43;
        if (TextUtils.isEmpty(r7[0]) == true) goto L43;
        if (TextUtils.isEmpty(r7[1]) == true) goto L43;
        r5.put(r7[0], r7[1]);
    L43:
        r6 = r6 + 1;
        goto L28
    L45:
        if (r5.size() <= 0) goto L47;
        r13.put(r3, r5);
    L47:
        r15 = r15 + 1;
        goto L17
    L49:
        if (r13.size() != 0) goto L51;
        return false;
    L51:
        return true;
    L70:
        return false;
    L68:
        return false;
    }
}
