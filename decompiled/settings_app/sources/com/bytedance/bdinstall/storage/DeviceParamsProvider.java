package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Api;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceParamsProvider extends AbsDeviceParamsProvider {
    DeviceParamsProvider(Context r1, StorageSettings r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList(new String[]{Api.KEY_OPEN_UDID, Api.KEY_C_UDID, "device_id", Api.KEY_INSTALL_ID}));
    }
}
