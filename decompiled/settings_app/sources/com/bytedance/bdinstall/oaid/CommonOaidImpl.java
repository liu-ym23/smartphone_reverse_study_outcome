package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.MsaIdInterface;

/* JADX INFO: loaded from: classes3.dex */
final class CommonOaidImpl extends BaseOaidImpl<MsaIdInterface> {
    private static final String PACKAGE_NAME = "com.mdid.msa";

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Common";
    }

    CommonOaidImpl() {
        super(PACKAGE_NAME);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl, com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r2) {
        startMsaklServer(r2, r2.getPackageName());
        return super.getOaid(r2);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<MsaIdInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r3) {
        Intent r2 = new Intent();
        r2.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaIdService");
        r2.setAction("com.bun.msa.action.bindto.service");
        r2.putExtra("com.bun.msa.param.pkgname", r3.getPackageName());
        return r2;
    }

    private void startMsaklServer(Context r3, String r4) {
        Intent r2 = new Intent();
        r2.setClassName(PACKAGE_NAME, "com.mdid.msa.service.MsaKlService");
        r2.setAction("com.bun.msa.action.start.service");
        r2.putExtra("com.bun.msa.param.pkgname", r4);
        r2.putExtra("com.bun.msa.param.runinset", true);     // Catch: Exception -> L5
        r3.startService(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
