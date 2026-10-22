package com.android.settings;

import com.android.settings.servicemanager.IGoogleHelp;
import kotlin.Metadata;

/* JADX INFO: compiled from: GoogleHelp.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/GoogleHelp;", "Lcom/android/settings/servicemanager/IGoogleHelp;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleHelp implements IGoogleHelp {
    public static final GoogleHelp INSTANCE = null;

    static {
        INSTANCE = new GoogleHelp();
    }

    private GoogleHelp() {
    }

    @Override // com.android.settings.servicemanager.IGoogleHelp
    public boolean isShowGoogleGms() {
        return IGoogleHelp.DefaultImpls.isShowGoogleGms(this);
    }

    @Override // com.android.settings.servicemanager.IGoogleHelp
    public boolean isShowGoogleWellbeing() {
        return IGoogleHelp.DefaultImpls.isShowGoogleWellbeing(this);
    }

    @Override // com.android.settings.servicemanager.IGoogleHelp
    public boolean isShowLocationServices() {
        return IGoogleHelp.DefaultImpls.isShowLocationServices(this);
    }

    @Override // com.android.settings.servicemanager.IGoogleHelp
    public boolean isShowNearbySharingBtn() {
        return IGoogleHelp.DefaultImpls.isShowNearbySharingBtn(this);
    }
}
