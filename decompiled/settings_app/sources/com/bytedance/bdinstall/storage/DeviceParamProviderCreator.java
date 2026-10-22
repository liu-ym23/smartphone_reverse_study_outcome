package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceParamProviderCreator extends CommonDeviceParamProviderCreator {
    public DeviceParamProviderCreator() {
    }

    public static void registerInstallParameterProvider(Context r0, Env r1, InstallOptions r2) {
        StorageSettings r3 = createSettings(r0, r1, r2);
        if (r1.isI18n() == true) goto L5;
        IInstallParameters r4 = new CNDeviceParamsProvider(r0, r3);
    L6:
        INewUserModeService r5 = (INewUserModeService) ServiceManager.getService(INewUserModeService.class);
        if (r5 == null) goto L9;
        r4 = (IInstallParameters) r5.tryReplaceService(IInstallParameters.class, r4);
    L9:
        ServiceManager.registerService(IInstallParameters.class, r4);
        return;
    L5:
        r4 = new DeviceParamsProvider(r0, r3);
        goto L6
    }
}
