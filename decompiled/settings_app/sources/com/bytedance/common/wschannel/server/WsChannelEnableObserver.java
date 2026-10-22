package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes3.dex */
class WsChannelEnableObserver implements IEnableObserver {
    private final Context mContext;
    private final Handler mHandler;
    private IEnableObserver.OnWsChannelEnableChangedObserver mObserver;
    private boolean mPushSdkEnabled;
    private ContentObserver mPushSdkEnabledObserver;

    static /* synthetic */ void access$000(WsChannelEnableObserver r0) {
        r0.handlePushSdkEnabled();
    }

    WsChannelEnableObserver(Context r1, Handler r2) {
        this.mHandler = r2;
        this.mContext = r1;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void startLoad() {
        loadPushSdkEnabled();
        final Handler r1 = this.mHandler;
        this.mPushSdkEnabledObserver = new AnonymousClass1(this, r1);
        registerContentObservers();
    }

    private void loadPushSdkEnabled() {
        boolean r1 = WsChannelSettings.inst(this.mContext).isEnable();     // Catch: Throwable -> L10
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r1);     // Catch: Throwable -> L10
    L7:
        if (r1 == this.mPushSdkEnabled) goto L13;
        this.mPushSdkEnabled = r1;     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    private void registerContentObservers() {
        this.mContext.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(this.mContext, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, this.mPushSdkEnabledObserver);     // Catch: Throwable -> L4
        return;
    }

    private void handlePushSdkEnabled() {
        boolean r0 = this.mPushSdkEnabled;     // Catch: Exception -> L8
        loadPushSdkEnabled();     // Catch: Exception -> L8
        boolean r1 = this.mPushSdkEnabled;     // Catch: Exception -> L8
        if (r0 == r1) goto L11;
        IEnableObserver.OnWsChannelEnableChangedObserver r2 = this.mObserver;     // Catch: Exception -> L8
        if (r2 == null) goto L12;
        r2.onWsChannelEnableChange(r1);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public boolean isEnable() {
        return this.mPushSdkEnabled;
    }

    @Override // com.bytedance.common.wschannel.server.IEnableObserver
    public void setEnableListener(IEnableObserver.OnWsChannelEnableChangedObserver r1) {
        this.mObserver = r1;
    }
}
