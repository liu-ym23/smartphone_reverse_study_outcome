package com.android.wifi.flags;

/* JADX INFO: loaded from: classes2.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // com.android.wifi.flags.FeatureFlags
    public boolean androidVWifiApi() {
        return true;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean anqpRequestWaitForResponse() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean d2dWhenInfraStaOff() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean delaySaveToStore() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean getBssidBlocklistApi() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean getChannelWidthApi() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean networkProviderBatteryChargingStatus() {
        return true;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean sharedConnectivityBroadcastReceiverTestApi() {
        return true;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean singleWifiThread() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean testFlagFunction() {
        return false;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean voipDetection() {
        return false;
    }

    public FeatureFlagsImpl() {
    }
}
