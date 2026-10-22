package com.ss.android.account.adapter;

import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import d.b.s.a.l0.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorAdapter implements h {
    public MonitorAdapter() {
    }

    @Override // d.b.s.a.l0.h
    public void a(long r1, String r3) {
        AppLog.setUserId(r1);
        AppLog.setSessionKey(r3);
    }

    @Override // d.b.s.a.l0.h
    public String getDeviceId() {
        return DeviceRegisterManager.getDeviceId();
    }

    @Override // d.b.s.a.l0.h
    public void onEvent(String r1, JSONObject r2) {
        AppLogNewUtils.onEventV3(r1, r2);
    }
}
