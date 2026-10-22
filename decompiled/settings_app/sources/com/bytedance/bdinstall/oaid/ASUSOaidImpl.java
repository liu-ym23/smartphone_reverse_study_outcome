package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.oaid.impl.IDidAidlInterface;

/* JADX INFO: loaded from: classes3.dex */
final class ASUSOaidImpl extends BaseOaidImpl<IDidAidlInterface> {
    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "ASUS";
    }

    ASUSOaidImpl() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected ServiceBlockBinder.ServiceBindedListener<IDidAidlInterface, String> buildServiceImpl() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.BaseOaidImpl
    protected Intent buildIntent(Context r3) {
        Intent r2 = new Intent();
        r2.setAction("com.asus.msa.action.ACCESS_DID");
        r2.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return r2;
    }
}
