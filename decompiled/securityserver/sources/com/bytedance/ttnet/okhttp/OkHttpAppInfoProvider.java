package com.bytedance.ttnet.okhttp;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.ITTNetDepend;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpAppInfoProvider implements IOkHttpAppInfoProvider {
    private static volatile OkHttpAppInfoProvider sInstance;
    private ICronetAppProvider mCronetProvider;
    private ITTNetDepend mTTNetDepend;

    private OkHttpAppInfoProvider() {
    }

    public static OkHttpAppInfoProvider inst() {
        if (sInstance != null) goto L16;
        monitor-enter(OkHttpAppInfoProvider.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new OkHttpAppInfoProvider();     // Catch: Throwable -> L9
    L11:
        monitor-exit(OkHttpAppInfoProvider.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public List<String> getAbSdkVersion() {
        ICronetAppProvider r0 = this.mCronetProvider;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbSdkVersion();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public int getAid() {
        ITTNetDepend r0 = this.mTTNetDepend;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getAppId();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String getHttpDnsDomain() {
        ITTNetDepend r1 = this.mTTNetDepend;
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.getTTNetServiceDomainMap().get("httpdns");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String[] getHttpDnsDomainHardCodeIps() {
        Object r1 = this.mTTNetDepend;
        if ((r1 instanceof AbsOptionalTTNetDepend) == true) goto L5;
        return null;
    L5:
        return ((AbsOptionalTTNetDepend) r1).getHttpDnsHardCodeIps();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public String[] getHttpDnsPreloadDomains() {
        Object r1 = this.mTTNetDepend;
        if ((r1 instanceof AbsOptionalTTNetDepend) == true) goto L5;
        return null;
    L5:
        return ((AbsOptionalTTNetDepend) r1).getPreloadDomains();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider
    public void sendAppMonitorEvent(String r1, String r2) {
        ICronetAppProvider r0 = this.mCronetProvider;
        if (r0 == null) goto L6;
        r0.sendAppMonitorEvent(r1, r2);
        return;
    }

    public void setCronetProvider(ICronetAppProvider r1) {
        this.mCronetProvider = r1;
    }

    public void setTTNetDepend(ITTNetDepend r1) {
        this.mTTNetDepend = r1;
    }
}
