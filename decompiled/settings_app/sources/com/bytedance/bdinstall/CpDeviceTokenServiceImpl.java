package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class CpDeviceTokenServiceImpl extends AbsDeviceTokenService implements SubpSyncManager.OnUpdateListener {
    private volatile String mDeviceToken;

    public CpDeviceTokenServiceImpl(Context r2) {
        SubpSyncManager.inst(r2).observer(Api.KEY_DEVICE_TOKEN, this);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mDeviceToken;
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r1, Env r2) {
        this.mDeviceToken = r1;
    }

    @Override // com.bytedance.bdinstall.SubpSyncManager.OnUpdateListener
    public void onUpdate(String r2) {
        updateToken(r2, null);
    }
}
