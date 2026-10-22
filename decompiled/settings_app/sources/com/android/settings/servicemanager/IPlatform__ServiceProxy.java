package com.android.settings.servicemanager;

import com.android.settings.CnPlatform;
import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IPlatform__ServiceProxy implements IServiceProxy<IPlatform> {
    public IPlatform__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IPlatform newInstance() {
        return newInstance();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IPlatform newInstance() {
        return new CnPlatform();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        r2.put("com.android.settings.servicemanager.IPlatform", "com.android.settings.CnPlatform");
    }
}
