package com.monitor.cloudmessage.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.thread.AsyncEventManager;

/* JADX INFO: loaded from: classes.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    public NetworkBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context r2, Intent r3) {
        AsyncEventManager.getInstance().post(new AnonymousClass1(this, r2));
    }
}
