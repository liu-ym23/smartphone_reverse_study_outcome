package com.bytedance.common.wschannel.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSdk;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsMessengerService extends Service implements WeakHandler.IHandler {
    protected WeakHandler mHandler;
    private Messenger mMessenger;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }

    static /* synthetic */ void access$000(AbsMessengerService r0) {
        r0.tryInitInPushProcess();
    }

    public AbsMessengerService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        ThreadPlus.submitRunnable(new AnonymousClass1(this));
        Logger.d("AbsMessengerService", "onCreate " + this);
        this.mHandler = new WeakHandler(this);
        this.mMessenger = new Messenger(this.mHandler);
    }

    private void tryInitInPushProcess() {
        WsChannelSdk.init(getApplication(), null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        Logger.d("AbsMessengerService", "onBind " + this);
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r3) {
        Logger.d("AbsMessengerService", "onUnBind " + this);
        return super.onUnbind(r3);
    }
}
