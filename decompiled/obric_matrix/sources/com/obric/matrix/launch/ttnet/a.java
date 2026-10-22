package com.obric.matrix.launch.ttnet;

import com.bytedance.mpaas.app.AppInfo;
import org.chromium.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.ttnet.k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f9157a;

    static {
        f9157a = new a();
    }

    public a() {
    }

    public static void e() {
        d.a().setAdapter(f9157a);     // Catch: Throwable -> L4
        org.chromium.c.W().z0(f9157a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppId() {
        return String.valueOf(508474);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getAppName() {
        return "o_project_test";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getBypassBOEJSON() {
        return "{\"bypass_boe_path_list\":[ \"/v2/pipeline\"], \"bypass_boe_host_list\":[ \"frontier-boe.bytedance.net\",\"cloudpush-boe.bytedance.net\",\"pico-push-boei18n.bytedance.net\",\"frontier-boei18n.bytedance.net\",\"pico-business-server.bytedance.net\",\"pico-business-server-boei18n.byteintl.net\",\"anywheredoor.bytedance.net\",\"sso.bytedance.com\",\"pdev-api-boe.bytedance.net\",\"pico-appstore-boe.bytedance.net\", \"pico-appstore-boei18n.bytedance.net\"]}";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getCarrierRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getChannel() {
        return AppInfo.getInstatnce().getChannel();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getDeviceId() {
        com.obric.matrix.ostracker_api.b r0 = com.obric.matrix.ostracker_api.b.f9463a;
        return com.obric.matrix.ostracker_api.b.c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getGetDomainDefaultJSON() {
        return com.obric.matrix.t.b.f10034a.a();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getStoreIdc() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getSysRegion() {
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getUserId() {
        return "";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionCode() {
        return String.valueOf(AppInfo.getInstatnce().getVersionCode());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public String getVersionName() {
        return String.valueOf(AppInfo.getInstatnce().getVersionName());
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetDepend
    public boolean loggerDebug() {
        if (AppInfo.getInstatnce().isApkDebuggable() == true) goto L10;
        com.obric.matrix.base.env.d r1 = com.obric.matrix.base.env.d.f8838a;
        if (r1.e() == true) goto L10;
        if (r1.f() == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider
    public void sendAppMonitorEvent(String r2, String r3) {
        com.obric.matrix.r.c.c.b("CronetDependAdapter", "sendAppMonitorEvent logType: " + r3 + " logContent: " + r2);
        com.bytedance.apm.c.h(r3, new JSONObject(r2));     // Catch: JSONException -> L5
        return;
    }
}
