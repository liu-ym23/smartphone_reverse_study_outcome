package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsWsClientService extends Service implements WeakHandler.IHandler, ClientMsgParser.ParserListener {
    public static final String TAG = "AbsWsClientService";
    private final Handler mHandler;
    private Messenger mMessenger;
    private final ClientMsgParser parser;

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg r1) {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String r1, boolean r2) {
    }

    public AbsWsClientService() {
        this.mHandler = new WeakHandler(this);
        this.parser = new ClientMsgParser(this);
    }

    static /* synthetic */ void access$000(AbsWsClientService r0, Intent r1, long r2) {
        r0.handleIntent(r1, r2);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mMessenger = new Messenger(this.mHandler);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent r3, int r4, int r5) {
        if (Logger.debug() == false) goto L9;
        StringBuilder r6 = new StringBuilder("onStartCommand intent = ");
        if (r3 == null) goto L7;
        String r7 = r3.toString();
    L8:
        Logger.d(TAG, r6.append(r7).toString());
        goto L9
    L7:
        r7 = "null";
    L9:
        final long r8 = TimeCompactUtil.getTimeStampNanos();
        SocketHandler.inst().postRunnable(new AnonymousClass1(this, r3, r8));
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onDestroy");
        return;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r6) {
        final long r1 = TimeCompactUtil.getTimeStampNanos();     // Catch: Exception -> L15
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.what != 10123) goto L20;
        final Intent r7 = (Intent) r6.getData().getParcelable(WsConstants.DATA_INTENT);     // Catch: Exception -> L15
        if (Logger.debug() == false) goto L11;
        Logger.d(TAG, "handleMsg = " + r7);     // Catch: Exception -> L15
    L11:
        if (r7 == null) goto L13;
        SocketHandler.inst().postRunnable(new AnonymousClass2(this, r7, r1));     // Catch: Exception -> L15
        return;
    L13:
        Logger.e(TAG, "handleMsg but intent isnull");     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        Logger.e(e.toString());
    }

    private void handleIntent(Intent r2, long r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        ClientServiceTrace r0 = new ClientServiceTrace(r3);
        this.parser.parse(r2, r0);
    }
}
