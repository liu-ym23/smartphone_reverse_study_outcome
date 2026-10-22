package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDeviceIdService;

/* JADX INFO: loaded from: classes3.dex */
final class SamsungOaidImpl extends BaseOaidImpl<IDeviceIdService> {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Samsung";
    }

    SamsungOaidImpl() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDeviceIdService, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r2) {
        Intent r1 = new Intent();
        r1.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return r1;
    }
}
