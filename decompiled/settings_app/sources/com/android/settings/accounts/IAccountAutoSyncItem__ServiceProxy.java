package com.android.settings.accounts;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class IAccountAutoSyncItem__ServiceProxy implements IServiceProxy<IAccountAutoSyncItem> {
    public IAccountAutoSyncItem__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ IAccountAutoSyncItem newInstance() {
        return newInstance();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IAccountAutoSyncItem newInstance() {
        return new AccountAutoSyncItemView();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r2) {
        r2.put("com.android.settings.accounts.IAccountAutoSyncItem", "com.android.settings.accounts.AccountAutoSyncItemView");
    }
}
