package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryTimesPolicy;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OkChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    private static final String MSBridgeMethod = "a";
    private static final String MSBridgeOV = "com.bytedance.mobsec.metasec.ov.MSB";
    public static final String TAG = "WsChannelSdk_ok";
    private static final int T_WSCHANNEL_INIT = 2;
    public static long sInitMSSdkMilliDuration;
    private final int mChannelId;
    private Map<String, Object> mConfigMap;
    private Context mContext;
    private Handler mHandler;
    private boolean mHasInit;
    private ContentObserver mOkChannelEnableObserver;
    private List<String> mUrls;
    private WsOkClient mWsClient;

    static {
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r1, boolean r2, String r3) {
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
    public void unregisterService(int r1) {
    }

    static /* synthetic */ Context access$000(OkChannelImpl r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$100(OkChannelImpl r0, Context r1) {
        return r0.okChannelEnable(r1);
    }

    static /* synthetic */ Map access$200(OkChannelImpl r0) {
        return r0.mConfigMap;
    }

    static /* synthetic */ List access$300(OkChannelImpl r0) {
        return r0.mUrls;
    }

    public OkChannelImpl(int r2, Handler r3) {
        this.mConfigMap = new HashMap();
        this.mChannelId = r2;
        this.mHandler = r3;
        final Handler r4 = this.mHandler;
        this.mOkChannelEnableObserver = new AnonymousClass1(this, r4);
    }

    private boolean okChannelEnable(Context r1) {
        return WsChannelSettings.inst(r1).isOkChannelEnable();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r5, IWsChannelClient r6) {
        if (this.mHasInit == false) goto L5;
        return;
    L5:
        this.mHasInit = true;
        Log.d(TAG, "init() , channelId = " + this.mChannelId);
        this.mContext = r5.getApplicationContext();
        initMSSdk(r5);
        WsOkClient r0 = new WsOkClient.Builder(r5).retryPolicy(new RetryTimesPolicy(r5)).heartBeatPolicy(WsChannelSdk.getHeartBeatPolicy(this.mChannelId)).build();
        this.mWsClient = r0;
        r0.setWsStatusListener(new WsStatusChangedListener(this.mContext, this.mWsClient, r6));
        observerSpChanged(r5);
    }

    private void initMSSdk(Context r11) {
        long r0 = System.currentTimeMillis();
        Class<?> r2 = Class.forName(MSBridgeOV);     // Catch: ClassNotFoundException -> L5
    L6:
        if (r2 != null) goto L14;
        return;
    L14:
        r2.getMethod(MSBridgeMethod, new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r2, new Object[]{r11, 2, null});     // Catch: Throwable -> L10
    L12:
        sInitMSSdkMilliDuration = System.currentTimeMillis() - r0;
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        Log.d(TAG, "MSSdk Class -com.bytedance.mobsec.metasec.ov.MSB- not found, init fail.");
        sInitMSSdkMilliDuration = -1;
        r2 = null;
        goto L6
    }

    public static long getsInitMSSdkMilliDuration() {
        return sInitMSSdkMilliDuration;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        Log.d(TAG, "destroy() , channelId = " + this.mChannelId);
        this.mWsClient.destroy();
        unregisterObserver();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r3) {
        if (okChannelEnable(this.mContext) == true) goto L5;
        return;
    L5:
        Log.d(TAG, "onAppStateChanged(), channelId = " + this.mChannelId);
        WsOkClient r2 = this.mWsClient;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.onAppStateChanged(r0);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r3) {
        if (okChannelEnable(this.mContext) == true) goto L5;
        return;
    L5:
        Log.d(TAG, "onNetworkStateChanged(), channelId = " + this.mChannelId);
        this.mWsClient.onNetworkStateChanged(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.mWsClient.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r2, List<String> r3) {
        if (r2 == null) goto L4;
        this.mConfigMap.putAll(r2);
    L4:
        this.mUrls = r3;
        if (okChannelEnable(this.mContext) == true) goto L7;
        return;
    L7:
        this.mWsClient.connect(r2, r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        Log.d(TAG, "stopConnection(),channelId = " + this.mChannelId);
        this.mWsClient.stopConnect();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r3, List<String> r4) {
        if (r3 == null) goto L4;
        this.mConfigMap.putAll(r3);
    L4:
        this.mUrls = r4;
        if (okChannelEnable(this.mContext) == true) goto L7;
        return;
    L7:
        Log.d(TAG, "onParameterChange(),channelId = " + this.mChannelId);
        this.mWsClient.onParameterChange(r3, r4);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r3) {
        if (okChannelEnable(this.mContext) == true) goto L6;
        return false;
    L6:
        Log.d(TAG, "sendMessage(),channelId = " + this.mChannelId);
        return this.mWsClient.sendMessage(r3);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r2) {
        Log.d(TAG, "onMessage(),channel = " + this.mChannelId);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r1) {
        Log.d(TAG, "onConnection()");
    }

    private void observerSpChanged(Context r4) {
        r4.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(r4, WsConstants.KEY_OK_IMPL_ENABLE, "boolean"), true, this.mOkChannelEnableObserver);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private void unregisterObserver() {
        Context r0 = this.mContext;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getContentResolver().unregisterContentObserver(this.mOkChannelEnableObserver);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }
}
