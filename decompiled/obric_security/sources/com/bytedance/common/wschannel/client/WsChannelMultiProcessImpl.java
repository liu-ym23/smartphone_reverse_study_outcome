package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelMultiProcessImpl implements WsChannelApi {
    private static final int CHECK_CONNECTION_TIMEOUT = 10000;
    private static boolean mAsync = false;
    private long bindServiceConnectedTime;
    private long bindServiceStartTime;
    private final Runnable checkConnectionRunnable;
    private final LinkedBlockingDeque<WsChannelApi.ServiceHolder> mServiceHolderQueue;
    private WeakReference<Context> sContextRef;
    Messenger service;
    ServiceConnection serviceConnection;

    class MessengerServiceConnection implements ServiceConnection {
        final /* synthetic */ WsChannelMultiProcessImpl this$0;

        MessengerServiceConnection(WsChannelMultiProcessImpl r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r5.toString());
        L13:
            this.this$0.service = null;     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.access$300(this.this$0).clear();     // Catch: Throwable -> L9
            WsChannelMultiProcessImpl.access$500(this.this$0, r5);     // Catch: Throwable -> L9
        L11:
            WsChannelMultiProcessImpl.access$100(this.this$0, 2, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.access$600(this.this$0));
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r5, IBinder r6) {
            if (r5 == null) goto L18;
            if (r6 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L17;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString() + ", " + WsChannelMultiProcessImpl.access$700());
        L17:
            this.this$0.service = new Messenger(r6);     // Catch: Throwable -> L13
            if (WsChannelMultiProcessImpl.access$700() == false) goto L11;
            ThreadPlus.submitRunnable(new AnonymousClass1(this, r5));     // Catch: Throwable -> L13
        L15:
            WsChannelMultiProcessImpl.access$602(this.this$0, SystemClock.uptimeMillis());
            WsChannelMultiProcessImpl.access$100(this.this$0, 0, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.access$000(this.this$0));
            return;
        L11:
            WsChannelMultiProcessImpl.access$400(this.this$0, r5);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();
            goto L15
        }
    }

    static {
    }

    public WsChannelMultiProcessImpl() {
        this.checkConnectionRunnable = new AnonymousClass1(this);
        this.bindServiceStartTime = 0;
        this.bindServiceConnectedTime = 0;
        this.mServiceHolderQueue = new LinkedBlockingDeque();
    }

    static /* synthetic */ long access$000(WsChannelMultiProcessImpl r2) {
        return r2.bindServiceStartTime;
    }

    static /* synthetic */ void access$100(WsChannelMultiProcessImpl r0, int r1, long r2) {
        r0.onReportServiceConnect(r1, r2);
    }

    static /* synthetic */ WeakReference access$200(WsChannelMultiProcessImpl r0) {
        return r0.sContextRef;
    }

    static /* synthetic */ WeakReference access$202(WsChannelMultiProcessImpl r0, WeakReference r1) {
        r0.sContextRef = r1;
        return r1;
    }

    static /* synthetic */ LinkedBlockingDeque access$300(WsChannelMultiProcessImpl r0) {
        return r0.mServiceHolderQueue;
    }

    static /* synthetic */ void access$400(WsChannelMultiProcessImpl r0, ComponentName r1) {
        r0.bindOrSendMsg(r1);
    }

    static /* synthetic */ void access$500(WsChannelMultiProcessImpl r0, ComponentName r1) {
        r0.onServiceDisconnected(r1);
    }

    static /* synthetic */ long access$600(WsChannelMultiProcessImpl r2) {
        return r2.bindServiceConnectedTime;
    }

    static /* synthetic */ long access$602(WsChannelMultiProcessImpl r0, long r1) {
        r0.bindServiceConnectedTime = r1;
        return r1;
    }

    static /* synthetic */ boolean access$700() {
        return mAsync;
    }

    public static void setAsyncOpt(boolean r0) {
        mAsync = r0;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context r2, boolean r3) {
        tryStartPushProcess(r2, r3, false);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(final Context r1, boolean r2, boolean r3) {
        if (r2 == false) goto L4;
        startPushProcess(r1, r3);
        return;
    L4:
        ThreadPlus.submitRunnable(new AnonymousClass2(this, r1));
    }

    private void startPushProcess(final Context r2, final boolean r3) {
        ThreadPlus.submitRunnable(new AnonymousClass3(this, r2, r3));
    }

    private synchronized void bindOrSendMsg(ComponentName r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.service != null) goto L6;
        doBindService(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        onServiceConnected(r2);     // Catch: Throwable -> L9
        goto L7
    }

    private void sendMsg(ComponentName r2, Message r3) throws RemoteException {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r3.toString() + " , + what = " + r3.what);
    L7:
        Messenger r1 = this.service;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.send(r3);
    }

    private void doBindService(ComponentName r4) {
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L24;
        Context r1 = r0.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r4 != null) goto L21;
        return;
    L21:
        Intent r2 = new Intent();     // Catch: Throwable -> L18
        r2.setComponent(r4);     // Catch: Throwable -> L18
        r1.startService(r2);     // Catch: Throwable -> L18
    L19:
        Intent r3 = new Intent();     // Catch: Throwable -> L15
        r3.setComponent(r4);     // Catch: Throwable -> L15
        MessengerServiceConnection r5 = new MessengerServiceConnection(this);     // Catch: Throwable -> L15
        this.serviceConnection = r5;     // Catch: Throwable -> L15
        startConnectCheckTimeout();     // Catch: Throwable -> L15
        r1.bindService(r3, r5, 1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void startConnectCheckTimeout() {
        this.bindServiceStartTime = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() != null) goto L5;
        return;
    L5:
        SocketHandler.inst().getHandler().postDelayed(this.checkConnectionRunnable, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private void onReportServiceConnect(int r1, long r2) {
        OnBindWsChannelServiceListener r0 = WsConstants.getBindWsChannelServiceListener();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onBindServiceResult(r1, r2);
    }

    private JSONObject getExtra(long r2) {
        JSONObject r1 = new JSONObject();
        r1.put("total_duration", r2);     // Catch: Exception -> L5
    L4:
        return r1;
    }

    private void onServiceConnected(ComponentName r6) {
        if (r6 != null) goto L17;
        return;
    L17:
        if (this.mServiceHolderQueue.peek() == null) goto L27;
        WsChannelApi.ServiceHolder r0 = this.mServiceHolderQueue.poll();     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        Message r1 = new Message();     // Catch: Throwable -> L16
        r1.what = r0.what;     // Catch: Throwable -> L16
        r1.getData().putParcelable(r0.key, r0.obj);     // Catch: Throwable -> L16
        sendMsg(r6, r1);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.service = null;     // Catch: Throwable -> L16
        this.mServiceHolderQueue.offerFirst(r0);     // Catch: Throwable -> L16
        onReportServiceConnect(3, SystemClock.uptimeMillis() - this.bindServiceConnectedTime);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    private synchronized void onServiceDisconnected(ComponentName r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void register(Context r3, IWsApp r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "register wsApp = " + r4.toString());
    L14:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r5 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r5.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r5.obj = r4;     // Catch: Throwable -> L18
        r5.what = 0;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r5);     // Catch: Throwable -> L18
        bindOrSendMsg(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    private void unregister(Context r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L10:
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "unregister channelId = " + r4);
    L17:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L14
        WsChannelApi.ServiceHolder r5 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L14
        r5.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L14
        r5.obj = new IntegerParcelable(r4);     // Catch: Throwable -> L14
        r5.what = 1;     // Catch: Throwable -> L14
        this.mServiceHolderQueue.offer(r5);     // Catch: Throwable -> L14
        bindOrSendMsg(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (r0.get() != null) goto L10;
        goto L8
    }

    private void sendParameterChange(Context r3, IWsApp r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendParameterChange wsApp = " + r4.toString());
    L14:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r5 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r5.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L18
        r5.obj = r4;     // Catch: Throwable -> L18
        r5.what = 4;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r5);     // Catch: Throwable -> L18
        bindOrSendMsg(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context r3, WsChannelMsg r4) {
        if (r3 == null) goto L23;
        if (r4 == null) goto L24;
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "sendPayload wsChannelMsg = " + r4.toString());
    L14:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L21;
        return;
    L21:
        ComponentName r1 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L18
        WsChannelApi.ServiceHolder r5 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L18
        r5.key = WsConstants.KEY_PAYLOAD;     // Catch: Throwable -> L18
        r5.obj = r4;     // Catch: Throwable -> L18
        r5.what = 5;     // Catch: Throwable -> L18
        this.mServiceHolderQueue.offer(r5);     // Catch: Throwable -> L18
        bindOrSendMsg(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (r0.get() != null) goto L11;
    L24:
        return;
    }

    private void sendAppState(final Context r3, final int r4) {
        if (r3 == null) goto L20;
        if (r4 > 0) goto L5;
        return;
    L5:
        if (r4 > 3) goto L22;
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L10;
    L11:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r4);
    L16:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L18;
        return;
    L18:
        ThreadPlus.submitRunnable(new AnonymousClass4(this, r3, r4));
        return;
    L10:
        if (r0.get() != null) goto L13;
    L22:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context r3, SsWsApp r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L10:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L12;
        return;
    L12:
        if (r4 == null) goto L15;
        register(r3, r4);
        return;
    L15:
        return;
    L7:
        if (r0.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context r3, int r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "unRegisterApp");
    L7:
        unregister(r3, r4);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context r3, SsWsApp r4) {
        if (r3 == null) goto L18;
        if (r4 == null) goto L19;
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L8;
    L9:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L11:
        if (Logger.debug() == false) goto L14;
        Logger.d("WsChannelSdk", "onParameterChange" + r4.toString());
    L14:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L16;
        return;
    L16:
        sendParameterChange(r3, r4);
        return;
    L8:
        if (r0.get() != null) goto L11;
    L19:
        return;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context r2) {
        sendAppState(r2, 1);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context r2) {
        sendAppState(r2, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(final Context r3, final int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        WeakReference<Context> r0 = this.sContextRef;
        if (r0 != null) goto L7;
    L8:
        this.sContextRef = new WeakReference(r3.getApplicationContext());
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.d("WsChannelSdk", "onTrimMemory level = " + r4);
    L13:
        if (WsChannelSettings.inst(r3).isEnable() == true) goto L15;
        return;
    L15:
        ThreadPlus.submitRunnable(new AnonymousClass5(this, r3, r4));
        return;
    L7:
        if (r0.get() != null) goto L10;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context r3, int r4, int r5) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "register serviceId = " + r5);
    L12:
        ComponentName r0 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L9
        WsChannelApi.ServiceHolder r6 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L9
        r6.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L9
        r6.obj = new ServiceParcelable(r4, r5);     // Catch: Throwable -> L9
        r6.what = 12;     // Catch: Throwable -> L9
        this.mServiceHolderQueue.offer(r6);     // Catch: Throwable -> L9
        bindOrSendMsg(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context r3, int r4, int r5) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L12;
        Logger.d("WsChannelSdk", "unregister serviceId = " + r5);
    L12:
        ComponentName r0 = new ComponentName(r3, WsChannelService.class);     // Catch: Throwable -> L9
        WsChannelApi.ServiceHolder r6 = new WsChannelApi.ServiceHolder();     // Catch: Throwable -> L9
        r6.key = WsConstants.KEY_WS_APP;     // Catch: Throwable -> L9
        r6.obj = new ServiceParcelable(r4, r5);     // Catch: Throwable -> L9
        r6.what = 13;     // Catch: Throwable -> L9
        this.mServiceHolderQueue.offer(r6);     // Catch: Throwable -> L9
        bindOrSendMsg(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
    }
}
