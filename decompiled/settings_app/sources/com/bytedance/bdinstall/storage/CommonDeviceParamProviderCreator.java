package com.bytedance.bdinstall.storage;

import android.content.Context;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: loaded from: classes3.dex */
class CommonDeviceParamProviderCreator {
    public static final String FILE_NAME = "device_parameters";
    private static final String I18N_FILE_NAME = "dp";

    CommonDeviceParamProviderCreator() {
    }

    static StorageSettings createSettings(Context r2, Env r3, InstallOptions r4) {
        if (r3.isI18n() == false) goto L5;
        String r0 = LocalConstants.wrapEnvSuffix("dp", r3);
    L7:
        if (r4.isLocalTest() == false) goto L9;
        r0 = r0 + "_local";
    L9:
        StorageSettings r1 = new StorageSettings();
        r1.setFileName(r0 + ".dat");
        r1.setSp(r3.getEnvIsolateSp(r2));
        r1.setAnonymous(r4.isAnonymous());
        r1.setLocalTest(r4.isLocalTest());
        r1.setAccount(r4.getAccount(), LocalConstants.wrapEnvSuffix("", r3));
        r1.setNeedSharedStorage(r4.isNeedSharedStorage());
        r1.setOptions(r4);
        return r1;
    L5:
        r0 = LocalConstants.wrapEnvSuffix(FILE_NAME, r3);
        goto L7
    }
}
