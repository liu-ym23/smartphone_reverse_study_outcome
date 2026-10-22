package com.bytedance.bdinstall;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbsDeviceTokenService implements DeviceTokenService {
    protected abstract String getDeviceToken();

    AbsDeviceTokenService() {
    }

    @Override // com.bytedance.bdinstall.DeviceTokenService
    public Map<String, String> getRequestHeader() {
        String r2 = getDeviceToken();
        HashMap r0 = new HashMap();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.put("x-tt-dt", r2);
        return r0;
    }
}
