package android.os;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // android.os.FeatureFlags
    public boolean adpfFmqEagerSend() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfGpuReportActualWorkDuration() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfHwuiGpu() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfMeasureDuringInputEventBoost() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfObtainviewBoost() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfPlatformPowerEfficiency() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfPreferPowerEfficiency() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfUseFmqChannel() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfUseFmqChannelFixed() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean allowPrivateProfile() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean allowThermalHeadroomThresholds() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean androidOsBuildVanillaIceCream() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean batteryPartStatusApi() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean batterySaverSupportedCheckApi() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean batteryServiceSupportCurrentAdbCommand() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean bugreportModeMaxValue() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean disallowCellularNullCiphersRestriction() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean messageQueueTailTracking() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean perfettoSdkTracing() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean removeAppProfilerPssCollection() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean securityStateService() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean stateOfHealthPublic() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean storageLifetimeApi() {
        return true;
    }

    @Override // android.os.FeatureFlags
    public boolean strictModeRestrictedNetwork() {
        return false;
    }

    @Override // android.os.FeatureFlags
    public boolean telemetryApisFrameworkInitialization() {
        return true;
    }

    public FeatureFlagsImpl() {
    }
}
