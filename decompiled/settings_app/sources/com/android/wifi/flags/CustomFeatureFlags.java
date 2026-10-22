package com.android.wifi.flags;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    private boolean isOptimizationEnabled() {
        return false;
    }

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r14) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ANDROID_V_WIFI_API, Flags.FLAG_ANQP_REQUEST_WAIT_FOR_RESPONSE, Flags.FLAG_D2D_WHEN_INFRA_STA_OFF, Flags.FLAG_DELAY_SAVE_TO_STORE, Flags.FLAG_GET_BSSID_BLOCKLIST_API, Flags.FLAG_GET_CHANNEL_WIDTH_API, Flags.FLAG_NETWORK_PROVIDER_BATTERY_CHARGING_STATUS, Flags.FLAG_SHARED_CONNECTIVITY_BROADCAST_RECEIVER_TEST_API, Flags.FLAG_SINGLE_WIFI_THREAD, Flags.FLAG_TEST_FLAG_FUNCTION, Flags.FLAG_VOIP_DETECTION, ""}));
        this.mGetValueImpl = r14;
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean androidVWifiApi() {
        return getValue(Flags.FLAG_ANDROID_V_WIFI_API, new CustomFeatureFlags$$ExternalSyntheticLambda5());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean anqpRequestWaitForResponse() {
        return getValue(Flags.FLAG_ANQP_REQUEST_WAIT_FOR_RESPONSE, new CustomFeatureFlags$$ExternalSyntheticLambda8());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean d2dWhenInfraStaOff() {
        return getValue(Flags.FLAG_D2D_WHEN_INFRA_STA_OFF, new CustomFeatureFlags$$ExternalSyntheticLambda10());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean delaySaveToStore() {
        return getValue(Flags.FLAG_DELAY_SAVE_TO_STORE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean getBssidBlocklistApi() {
        return getValue(Flags.FLAG_GET_BSSID_BLOCKLIST_API, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean getChannelWidthApi() {
        return getValue(Flags.FLAG_GET_CHANNEL_WIDTH_API, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean networkProviderBatteryChargingStatus() {
        return getValue(Flags.FLAG_NETWORK_PROVIDER_BATTERY_CHARGING_STATUS, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean sharedConnectivityBroadcastReceiverTestApi() {
        return getValue(Flags.FLAG_SHARED_CONNECTIVITY_BROADCAST_RECEIVER_TEST_API, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean singleWifiThread() {
        return getValue(Flags.FLAG_SINGLE_WIFI_THREAD, new CustomFeatureFlags$$ExternalSyntheticLambda9());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean testFlagFunction() {
        return getValue(Flags.FLAG_TEST_FLAG_FUNCTION, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    @Override // com.android.wifi.flags.FeatureFlags
    public boolean voipDetection() {
        return getValue(Flags.FLAG_VOIP_DETECTION, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    public boolean isFlagReadOnlyOptimized(String r2) {
        if (this.mReadOnlyFlagsSet.contains(r2) == true) goto L5;
        return false;
    L5:
        if (isOptimizationEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    protected boolean getValue(String r1, Predicate<FeatureFlags> r2) {
        return this.mGetValueImpl.test(r1, r2);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ANDROID_V_WIFI_API, Flags.FLAG_ANQP_REQUEST_WAIT_FOR_RESPONSE, Flags.FLAG_D2D_WHEN_INFRA_STA_OFF, Flags.FLAG_DELAY_SAVE_TO_STORE, Flags.FLAG_GET_BSSID_BLOCKLIST_API, Flags.FLAG_GET_CHANNEL_WIDTH_API, Flags.FLAG_NETWORK_PROVIDER_BATTERY_CHARGING_STATUS, Flags.FLAG_SHARED_CONNECTIVITY_BROADCAST_RECEIVER_TEST_API, Flags.FLAG_SINGLE_WIFI_THREAD, Flags.FLAG_TEST_FLAG_FUNCTION, Flags.FLAG_VOIP_DETECTION});
    }
}
