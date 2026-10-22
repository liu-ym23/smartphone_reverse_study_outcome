package com.android.settings;

import com.android.settings.wifi.WifiTrackerLibProvider;
import com.android.settings.wifi.WifiTrackerLibProviderImpl;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureFactoryImpl extends FeatureFactory {
    private WifiTrackerLibProvider mWifiTrackerLibProvider;

    public FeatureFactoryImpl() {
    }

    @Override // com.android.settings.FeatureFactory
    public WifiTrackerLibProvider getWifiTrackerLibProvider() {
        if (this.mWifiTrackerLibProvider != null) goto L6;
        this.mWifiTrackerLibProvider = new WifiTrackerLibProviderImpl();
    L6:
        return this.mWifiTrackerLibProvider;
    }
}
