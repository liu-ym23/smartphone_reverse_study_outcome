package com.android.settings;

import com.android.settings.service.bean.DeviceInfo;
import com.android.settings.servicemanager.IGuaranteeHelp;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: GuaranteeHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/GuaranteeHelp;", "Lcom/android/settings/servicemanager/IGuaranteeHelp;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GuaranteeHelp implements IGuaranteeHelp {
    public static final GuaranteeHelp INSTANCE = null;

    static {
        INSTANCE = new GuaranteeHelp();
    }

    private GuaranteeHelp() {
    }

    @Override // com.android.settings.servicemanager.IGuaranteeHelp
    public Object getDeviceInfo(String r1, String r2, String r3, Continuation<? super DeviceInfo> r4) {
        return IGuaranteeHelp.DefaultImpls.getDeviceInfo(this, r1, r2, r3, r4);
    }

    @Override // com.android.settings.servicemanager.IGuaranteeHelp
    public boolean isFistShowWarrantyCard() {
        return IGuaranteeHelp.DefaultImpls.isFistShowWarrantyCard(this);
    }
}
