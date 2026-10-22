package com.android.settings;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import com.android.settings.inputmethod.LanguageOption;
import com.android.settings.servicemanager.IPlatform;
import kotlin.Metadata;

/* JADX INFO: compiled from: CnPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/settings/CnPlatform;", "Lcom/android/settings/servicemanager/IPlatform;", "()V", "isGoogleLawEnable", "", "isGoogleResetEnable", "isPrintEnable", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CnPlatform implements IPlatform {
    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isGoogleLawEnable() {
        return false;
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isGoogleResetEnable() {
        return false;
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isPrintEnable() {
        return false;
    }

    public CnPlatform() {
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isCurrentLanguage(LanguageOption.LocaleInfo r1) {
        return IPlatform.DefaultImpls.isCurrentLanguage(this, r1);
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isShowConnectedApList() {
        return IPlatform.DefaultImpls.isShowConnectedApList(this);
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public boolean isShowNubiaShare() {
        return IPlatform.DefaultImpls.isShowNubiaShare(this);
    }

    @Override // com.android.settings.servicemanager.IPlatform
    public String readConfiguredNetworkKey(WifiManager r1, WifiConfiguration r2) {
        return IPlatform.DefaultImpls.readConfiguredNetworkKey(this, r1, r2);
    }
}
