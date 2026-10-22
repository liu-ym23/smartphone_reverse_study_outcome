package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdManager;

/* JADX INFO: loaded from: classes3.dex */
final class CoolpadOaidImpl extends BaseOaidImpl<IDeviceIdManager> {
    private static final String DEVICEIDMANAGER_SERVICE_CLASSNAME = "com.coolpad.deviceidsupport.DeviceIdService";
    private static final String DEVICEIDMANAGER_SERVICE_PACKAGENAME = "com.coolpad.deviceidsupport";
    private final Context mContext;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "coolpad";
    }

    static /* synthetic */ Context access$000(CoolpadOaidImpl r0) {
        return r0.mContext;
    }

    CoolpadOaidImpl(Context r2) {
        super(DEVICEIDMANAGER_SERVICE_PACKAGENAME);
        this.mContext = r2;
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        String r0 = Settings.Global.getString(r3.getContentResolver(), "coolos.oaid");     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r0) == true) goto L9;
        OaidApi.Result r1 = new OaidApi.Result();     // Catch: Throwable -> L6
        r1.oaid = r0;     // Catch: Throwable -> L6
        return r1;
    L9:
        return super.getOaid(r3);
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdManager, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r3) {
        Intent r2 = new Intent();
        r2.setComponent(new ComponentName(DEVICEIDMANAGER_SERVICE_PACKAGENAME, DEVICEIDMANAGER_SERVICE_CLASSNAME));
        return r2;
    }
}
