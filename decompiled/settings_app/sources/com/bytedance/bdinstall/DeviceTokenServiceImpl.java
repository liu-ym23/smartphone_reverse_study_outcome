package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
final class DeviceTokenServiceImpl extends AbsDeviceTokenService {
    private final Context mContext;
    private volatile Env mEnv;

    public DeviceTokenServiceImpl(Context r1, Env r2) {
        this.mContext = r1;
        this.mEnv = r2;
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public void updateToken(String r2, Env r3) {
        this.mEnv = r3;
        r3.getEnvIsolateSp(this.mContext).edit().putString(Api.KEY_DEVICE_TOKEN, r2).apply();
        SubpSyncManager.inst(this.mContext).sendSubpEvent(Api.KEY_DEVICE_TOKEN, r2);
    }

    @Override // com.bytedance.bdinstall.AbsDeviceTokenService
    protected String getDeviceToken() {
        return this.mEnv.getEnvIsolateSp(this.mContext).getString(Api.KEY_DEVICE_TOKEN, null);
    }
}
