package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSettings;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelReceiver extends BroadcastReceiver {
    private static boolean sFrontierEnabled = false;
    private boolean mIsFirstTimeReceiveNetChangedAction;
    private ChannelManager mManager;
    private NetworkUtils.NetworkType mOnCreateNetworkType;

    static {
    }

    static /* synthetic */ void access$000(WsChannelReceiver r0, Context r1) {
        r0.loadFrontierEnabled(r1);
    }

    static /* synthetic */ boolean access$100() {
        return sFrontierEnabled;
    }

    static /* synthetic */ ChannelManager access$200(WsChannelReceiver r0) {
        return r0.mManager;
    }

    @Deprecated
    public WsChannelReceiver() {
        this.mIsFirstTimeReceiveNetChangedAction = true;
    }

    public WsChannelReceiver(Context r2, ChannelManager r3) {
        this.mIsFirstTimeReceiveNetChangedAction = true;
        this.mOnCreateNetworkType = NetworkUtils.getNetworkType(r2);
        this.mManager = r3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context r2, Intent r3) {
        if (r2 == null) goto L20;
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mManager != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r3.getAction()) == false) goto L11;
        return;
    L11:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == true) goto L14;
        return;
    L14:
        if (this.mIsFirstTimeReceiveNetChangedAction == false) goto L18;
        this.mIsFirstTimeReceiveNetChangedAction = false;
        if (NetworkUtils.getNetworkType(r2) != this.mOnCreateNetworkType) goto L18;
        return;
    L18:
        ThreadPlus.submitRunnable(new AnonymousClass1(this, r2));
        return;
    }

    private void loadFrontierEnabled(Context r1) {
        boolean r0 = WsChannelSettings.inst(r1).isEnable();     // Catch: Throwable -> L6
        if (r0 == sFrontierEnabled) goto L9;
        sFrontierEnabled = r0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }
}
