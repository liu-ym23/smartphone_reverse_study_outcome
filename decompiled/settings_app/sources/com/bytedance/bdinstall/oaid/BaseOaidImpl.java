package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseOaidImpl<SERVICE> implements OaidApi {
    private final String packageName;
    private final Singleton<Boolean> support;

    protected abstract Intent buildIntent(Context r1);

    protected abstract ServiceBlockBinder.ServiceBindedListener<SERVICE, String> buildServiceImpl();

    static /* synthetic */ String access$000(BaseOaidImpl r0) {
        return r0.packageName;
    }

    BaseOaidImpl(String r2) {
        this.support = new AnonymousClass1(this);
        this.packageName = r2;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        return this.support.get(new Object[]{r3}).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r4) {
        return wrapOaid((String) new ServiceBlockBinder(r4, buildIntent(r4), buildServiceImpl()).blockFetchResult());
    }

    private OaidApi.Result wrapOaid(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        OaidApi.Result r0 = new OaidApi.Result();
        r0.oaid = r1;
        return r0;
    }
}
