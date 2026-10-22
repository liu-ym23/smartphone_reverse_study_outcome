package android.os;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    private boolean isOptimizationEnabled() {
        return false;
    }

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r29) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ADPF_FMQ_EAGER_SEND, Flags.FLAG_ADPF_GPU_REPORT_ACTUAL_WORK_DURATION, Flags.FLAG_ADPF_HWUI_GPU, Flags.FLAG_ADPF_MEASURE_DURING_INPUT_EVENT_BOOST, Flags.FLAG_ADPF_OBTAINVIEW_BOOST, Flags.FLAG_ADPF_PLATFORM_POWER_EFFICIENCY, Flags.FLAG_ADPF_PREFER_POWER_EFFICIENCY, Flags.FLAG_ADPF_USE_FMQ_CHANNEL, Flags.FLAG_ADPF_USE_FMQ_CHANNEL_FIXED, Flags.FLAG_ALLOW_PRIVATE_PROFILE, Flags.FLAG_ALLOW_THERMAL_HEADROOM_THRESHOLDS, Flags.FLAG_ANDROID_OS_BUILD_VANILLA_ICE_CREAM, Flags.FLAG_BATTERY_PART_STATUS_API, Flags.FLAG_BATTERY_SAVER_SUPPORTED_CHECK_API, Flags.FLAG_BATTERY_SERVICE_SUPPORT_CURRENT_ADB_COMMAND, Flags.FLAG_BUGREPORT_MODE_MAX_VALUE, Flags.FLAG_DISALLOW_CELLULAR_NULL_CIPHERS_RESTRICTION, Flags.FLAG_MESSAGE_QUEUE_TAIL_TRACKING, Flags.FLAG_PERFETTO_SDK_TRACING, Flags.FLAG_REMOVE_APP_PROFILER_PSS_COLLECTION, Flags.FLAG_SECURITY_STATE_SERVICE, Flags.FLAG_STATE_OF_HEALTH_PUBLIC, Flags.FLAG_STORAGE_LIFETIME_API, Flags.FLAG_STRICT_MODE_RESTRICTED_NETWORK, Flags.FLAG_TELEMETRY_APIS_FRAMEWORK_INITIALIZATION, ""}));
        this.mGetValueImpl = r29;
    }

    @Override // android.os.FeatureFlags
    public boolean adpfFmqEagerSend() {
        return getValue(Flags.FLAG_ADPF_FMQ_EAGER_SEND, new CustomFeatureFlags$$ExternalSyntheticLambda24());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfGpuReportActualWorkDuration() {
        return getValue(Flags.FLAG_ADPF_GPU_REPORT_ACTUAL_WORK_DURATION, new CustomFeatureFlags$$ExternalSyntheticLambda8());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfHwuiGpu() {
        return getValue(Flags.FLAG_ADPF_HWUI_GPU, new CustomFeatureFlags$$ExternalSyntheticLambda15());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfMeasureDuringInputEventBoost() {
        return getValue(Flags.FLAG_ADPF_MEASURE_DURING_INPUT_EVENT_BOOST, new CustomFeatureFlags$$ExternalSyntheticLambda21());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfObtainviewBoost() {
        return getValue(Flags.FLAG_ADPF_OBTAINVIEW_BOOST, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfPlatformPowerEfficiency() {
        return getValue(Flags.FLAG_ADPF_PLATFORM_POWER_EFFICIENCY, new CustomFeatureFlags$$ExternalSyntheticLambda11());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfPreferPowerEfficiency() {
        return getValue(Flags.FLAG_ADPF_PREFER_POWER_EFFICIENCY, new CustomFeatureFlags$$ExternalSyntheticLambda19());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfUseFmqChannel() {
        return getValue(Flags.FLAG_ADPF_USE_FMQ_CHANNEL, new CustomFeatureFlags$$ExternalSyntheticLambda14());
    }

    @Override // android.os.FeatureFlags
    public boolean adpfUseFmqChannelFixed() {
        return getValue(Flags.FLAG_ADPF_USE_FMQ_CHANNEL_FIXED, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // android.os.FeatureFlags
    public boolean allowPrivateProfile() {
        return getValue(Flags.FLAG_ALLOW_PRIVATE_PROFILE, new CustomFeatureFlags$$ExternalSyntheticLambda20());
    }

    @Override // android.os.FeatureFlags
    public boolean allowThermalHeadroomThresholds() {
        return getValue(Flags.FLAG_ALLOW_THERMAL_HEADROOM_THRESHOLDS, new CustomFeatureFlags$$ExternalSyntheticLambda23());
    }

    @Override // android.os.FeatureFlags
    public boolean androidOsBuildVanillaIceCream() {
        return getValue(Flags.FLAG_ANDROID_OS_BUILD_VANILLA_ICE_CREAM, new CustomFeatureFlags$$ExternalSyntheticLambda13());
    }

    @Override // android.os.FeatureFlags
    public boolean batteryPartStatusApi() {
        return getValue(Flags.FLAG_BATTERY_PART_STATUS_API, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    @Override // android.os.FeatureFlags
    public boolean batterySaverSupportedCheckApi() {
        return getValue(Flags.FLAG_BATTERY_SAVER_SUPPORTED_CHECK_API, new CustomFeatureFlags$$ExternalSyntheticLambda18());
    }

    @Override // android.os.FeatureFlags
    public boolean batteryServiceSupportCurrentAdbCommand() {
        return getValue(Flags.FLAG_BATTERY_SERVICE_SUPPORT_CURRENT_ADB_COMMAND, new CustomFeatureFlags$$ExternalSyntheticLambda9());
    }

    @Override // android.os.FeatureFlags
    public boolean bugreportModeMaxValue() {
        return getValue(Flags.FLAG_BUGREPORT_MODE_MAX_VALUE, new CustomFeatureFlags$$ExternalSyntheticLambda10());
    }

    @Override // android.os.FeatureFlags
    public boolean disallowCellularNullCiphersRestriction() {
        return getValue(Flags.FLAG_DISALLOW_CELLULAR_NULL_CIPHERS_RESTRICTION, new CustomFeatureFlags$$ExternalSyntheticLambda16());
    }

    @Override // android.os.FeatureFlags
    public boolean messageQueueTailTracking() {
        return getValue(Flags.FLAG_MESSAGE_QUEUE_TAIL_TRACKING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.os.FeatureFlags
    public boolean perfettoSdkTracing() {
        return getValue(Flags.FLAG_PERFETTO_SDK_TRACING, new CustomFeatureFlags$$ExternalSyntheticLambda17());
    }

    @Override // android.os.FeatureFlags
    public boolean removeAppProfilerPssCollection() {
        return getValue(Flags.FLAG_REMOVE_APP_PROFILER_PSS_COLLECTION, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // android.os.FeatureFlags
    public boolean securityStateService() {
        return getValue(Flags.FLAG_SECURITY_STATE_SERVICE, new CustomFeatureFlags$$ExternalSyntheticLambda12());
    }

    @Override // android.os.FeatureFlags
    public boolean stateOfHealthPublic() {
        return getValue(Flags.FLAG_STATE_OF_HEALTH_PUBLIC, new CustomFeatureFlags$$ExternalSyntheticLambda22());
    }

    @Override // android.os.FeatureFlags
    public boolean storageLifetimeApi() {
        return getValue(Flags.FLAG_STORAGE_LIFETIME_API, new CustomFeatureFlags$$ExternalSyntheticLambda5());
    }

    @Override // android.os.FeatureFlags
    public boolean strictModeRestrictedNetwork() {
        return getValue(Flags.FLAG_STRICT_MODE_RESTRICTED_NETWORK, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    @Override // android.os.FeatureFlags
    public boolean telemetryApisFrameworkInitialization() {
        return getValue(Flags.FLAG_TELEMETRY_APIS_FRAMEWORK_INITIALIZATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
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
        return Arrays.asList(new String[]{Flags.FLAG_ADPF_FMQ_EAGER_SEND, Flags.FLAG_ADPF_GPU_REPORT_ACTUAL_WORK_DURATION, Flags.FLAG_ADPF_HWUI_GPU, Flags.FLAG_ADPF_MEASURE_DURING_INPUT_EVENT_BOOST, Flags.FLAG_ADPF_OBTAINVIEW_BOOST, Flags.FLAG_ADPF_PLATFORM_POWER_EFFICIENCY, Flags.FLAG_ADPF_PREFER_POWER_EFFICIENCY, Flags.FLAG_ADPF_USE_FMQ_CHANNEL, Flags.FLAG_ADPF_USE_FMQ_CHANNEL_FIXED, Flags.FLAG_ALLOW_PRIVATE_PROFILE, Flags.FLAG_ALLOW_THERMAL_HEADROOM_THRESHOLDS, Flags.FLAG_ANDROID_OS_BUILD_VANILLA_ICE_CREAM, Flags.FLAG_BATTERY_PART_STATUS_API, Flags.FLAG_BATTERY_SAVER_SUPPORTED_CHECK_API, Flags.FLAG_BATTERY_SERVICE_SUPPORT_CURRENT_ADB_COMMAND, Flags.FLAG_BUGREPORT_MODE_MAX_VALUE, Flags.FLAG_DISALLOW_CELLULAR_NULL_CIPHERS_RESTRICTION, Flags.FLAG_MESSAGE_QUEUE_TAIL_TRACKING, Flags.FLAG_PERFETTO_SDK_TRACING, Flags.FLAG_REMOVE_APP_PROFILER_PSS_COLLECTION, Flags.FLAG_SECURITY_STATE_SERVICE, Flags.FLAG_STATE_OF_HEALTH_PUBLIC, Flags.FLAG_STORAGE_LIFETIME_API, Flags.FLAG_STRICT_MODE_RESTRICTED_NETWORK, Flags.FLAG_TELEMETRY_APIS_FRAMEWORK_INITIALIZATION});
    }
}
