package com.obric.matrix.deviceinfo;

import com.bytedance.os.oms.deviceinfo.DeviceInfoProviderBase;
import com.obric.matrix.ostracker_api.b;
import com.obric.matrix.r.c.c;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceInfoBackendService extends DeviceInfoProviderBase {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.obric.matrix.ostracker_api.a f9088f;

    class a implements com.obric.matrix.ostracker_api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DeviceInfoBackendService f9089a;

        a(DeviceInfoBackendService r1) {
            this.f9089a = r1;
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void a(String r3) {
            c.b("OmsDeviceInfoProvider", "onDeviceIdLoaded, did = " + r3);
            com.obric.matrix.deviceinfo.a.e(this.f9089a.getApplicationContext()).g(r3);
            DeviceInfoBackendService.a(this.f9089a, r3);
        }

        @Override // com.obric.matrix.ostracker_api.a
        public void b(String r3) {
            c.b("OmsDeviceInfoProvider", "onInstallIdLoaded, installId = " + r3);
            com.obric.matrix.deviceinfo.a.e(this.f9089a.getApplicationContext()).h(r3);
            DeviceInfoBackendService.b(this.f9089a, r3);
        }
    }

    public DeviceInfoBackendService() {
        this.f9088f = new a(this);
    }

    static /* synthetic */ void a(DeviceInfoBackendService r0, String r1) {
        r0.notifyDeviceIdLoaded(r1);
    }

    static /* synthetic */ void b(DeviceInfoBackendService r0, String r1) {
        r0.notifyInstallIdLoaded(r1);
    }

    protected String computeDeviceId() {
        c.b("OmsDeviceInfoProvider", "getDeviceId");
        return com.obric.matrix.deviceinfo.a.e(getApplicationContext()).a();
    }

    protected String computeInstallId() {
        c.b("OmsDeviceInfoProvider", "getInstallId");
        return com.obric.matrix.deviceinfo.a.e(getApplicationContext()).b();
    }

    public void onCreate() {
        super.onCreate();
        c.b("OmsDeviceInfoProvider", "onCreate");
        b.a(this.f9088f);
    }

    public void onDestroy() {
        b.h(this.f9088f);
        super.onDestroy();
        c.b("OmsDeviceInfoProvider", "onDestroy");
    }
}
