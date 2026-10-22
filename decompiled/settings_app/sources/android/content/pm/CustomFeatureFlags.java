package android.content.pm;

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

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r39) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ALLOW_SDK_SANDBOX_QUERY_INTENT_ACTIVITIES, Flags.FLAG_ARCHIVING, Flags.FLAG_ASL_IN_APK_APP_METADATA_SOURCE, Flags.FLAG_COMPONENT_STATE_CHANGED_METRICS, Flags.FLAG_DISALLOW_SDK_LIBS_TO_BE_APPS, Flags.FLAG_EMERGENCY_INSTALL_PERMISSION, Flags.FLAG_ENCODE_APP_INTENT, Flags.FLAG_FIX_DUPLICATED_FLAGS, Flags.FLAG_FIX_SYSTEM_APPS_FIRST_INSTALL_TIME, Flags.FLAG_FORCE_MULTI_ARCH_NATIVE_LIBS_MATCH, Flags.FLAG_GET_PACKAGE_INFO, Flags.FLAG_GET_PACKAGE_INFO_WITH_FD, Flags.FLAG_GET_PACKAGE_STORAGE_STATS, Flags.FLAG_GET_RESOLVED_APK_PATH, Flags.FLAG_IMPROVE_HOME_APP_BEHAVIOR, Flags.FLAG_IMPROVE_INSTALL_DONT_KILL, Flags.FLAG_IMPROVE_INSTALL_FREEZE, Flags.FLAG_INTRODUCE_MEDIA_PROCESSING_TYPE, Flags.FLAG_LIGHTWEIGHT_INVISIBLE_LABEL_DETECTION, Flags.FLAG_MIN_TARGET_SDK_24, Flags.FLAG_NULLABLE_DATA_DIR, Flags.FLAG_PACKAGE_RESTART_QUERY_DISABLED_BY_DEFAULT, Flags.FLAG_PROVIDE_INFO_OF_APK_IN_APEX, Flags.FLAG_QUARANTINED_ENABLED, Flags.FLAG_READ_INSTALL_INFO, Flags.FLAG_RECOVERABILITY_DETECTION, Flags.FLAG_RELATIVE_REFERENCE_INTENT_FILTERS, Flags.FLAG_RESTRICT_NONPRELOADS_SYSTEM_SHAREDUIDS, Flags.FLAG_ROLLBACK_LIFETIME, Flags.FLAG_SDK_LIB_INDEPENDENCE, Flags.FLAG_SET_PRE_VERIFIED_DOMAINS, Flags.FLAG_STAY_STOPPED, Flags.FLAG_USE_ART_SERVICE_V2, Flags.FLAG_USE_PIA_V2, Flags.FLAG_WAIT_APPLICATION_KILLED, ""}));
        this.mGetValueImpl = r39;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean allowSdkSandboxQueryIntentActivities() {
        return getValue(Flags.FLAG_ALLOW_SDK_SANDBOX_QUERY_INTENT_ACTIVITIES, new CustomFeatureFlags$$ExternalSyntheticLambda10());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean archiving() {
        return getValue(Flags.FLAG_ARCHIVING, new CustomFeatureFlags$$ExternalSyntheticLambda33());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean aslInApkAppMetadataSource() {
        return getValue(Flags.FLAG_ASL_IN_APK_APP_METADATA_SOURCE, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean componentStateChangedMetrics() {
        return getValue(Flags.FLAG_COMPONENT_STATE_CHANGED_METRICS, new CustomFeatureFlags$$ExternalSyntheticLambda30());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean disallowSdkLibsToBeApps() {
        return getValue(Flags.FLAG_DISALLOW_SDK_LIBS_TO_BE_APPS, new CustomFeatureFlags$$ExternalSyntheticLambda23());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean emergencyInstallPermission() {
        return getValue(Flags.FLAG_EMERGENCY_INSTALL_PERMISSION, new CustomFeatureFlags$$ExternalSyntheticLambda14());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean encodeAppIntent() {
        return getValue(Flags.FLAG_ENCODE_APP_INTENT, new CustomFeatureFlags$$ExternalSyntheticLambda21());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean fixDuplicatedFlags() {
        return getValue(Flags.FLAG_FIX_DUPLICATED_FLAGS, new CustomFeatureFlags$$ExternalSyntheticLambda27());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean fixSystemAppsFirstInstallTime() {
        return getValue(Flags.FLAG_FIX_SYSTEM_APPS_FIRST_INSTALL_TIME, new CustomFeatureFlags$$ExternalSyntheticLambda9());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean forceMultiArchNativeLibsMatch() {
        return getValue(Flags.FLAG_FORCE_MULTI_ARCH_NATIVE_LIBS_MATCH, new CustomFeatureFlags$$ExternalSyntheticLambda25());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageInfo() {
        return getValue(Flags.FLAG_GET_PACKAGE_INFO, new CustomFeatureFlags$$ExternalSyntheticLambda29());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageInfoWithFd() {
        return getValue(Flags.FLAG_GET_PACKAGE_INFO_WITH_FD, new CustomFeatureFlags$$ExternalSyntheticLambda20());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageStorageStats() {
        return getValue(Flags.FLAG_GET_PACKAGE_STORAGE_STATS, new CustomFeatureFlags$$ExternalSyntheticLambda16());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getResolvedApkPath() {
        return getValue(Flags.FLAG_GET_RESOLVED_APK_PATH, new CustomFeatureFlags$$ExternalSyntheticLambda32());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveHomeAppBehavior() {
        return getValue(Flags.FLAG_IMPROVE_HOME_APP_BEHAVIOR, new CustomFeatureFlags$$ExternalSyntheticLambda15());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveInstallDontKill() {
        return getValue(Flags.FLAG_IMPROVE_INSTALL_DONT_KILL, new CustomFeatureFlags$$ExternalSyntheticLambda19());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveInstallFreeze() {
        return getValue(Flags.FLAG_IMPROVE_INSTALL_FREEZE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean introduceMediaProcessingType() {
        return getValue(Flags.FLAG_INTRODUCE_MEDIA_PROCESSING_TYPE, new CustomFeatureFlags$$ExternalSyntheticLambda22());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean lightweightInvisibleLabelDetection() {
        return getValue(Flags.FLAG_LIGHTWEIGHT_INVISIBLE_LABEL_DETECTION, new CustomFeatureFlags$$ExternalSyntheticLambda11());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean minTargetSdk24() {
        return getValue(Flags.FLAG_MIN_TARGET_SDK_24, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean nullableDataDir() {
        return getValue(Flags.FLAG_NULLABLE_DATA_DIR, new CustomFeatureFlags$$ExternalSyntheticLambda24());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean packageRestartQueryDisabledByDefault() {
        return getValue(Flags.FLAG_PACKAGE_RESTART_QUERY_DISABLED_BY_DEFAULT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean provideInfoOfApkInApex() {
        return getValue(Flags.FLAG_PROVIDE_INFO_OF_APK_IN_APEX, new CustomFeatureFlags$$ExternalSyntheticLambda18());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean quarantinedEnabled() {
        return getValue(Flags.FLAG_QUARANTINED_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda17());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean readInstallInfo() {
        return getValue(Flags.FLAG_READ_INSTALL_INFO, new CustomFeatureFlags$$ExternalSyntheticLambda26());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean recoverabilityDetection() {
        return getValue(Flags.FLAG_RECOVERABILITY_DETECTION, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean relativeReferenceIntentFilters() {
        return getValue(Flags.FLAG_RELATIVE_REFERENCE_INTENT_FILTERS, new CustomFeatureFlags$$ExternalSyntheticLambda8());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean restrictNonpreloadsSystemShareduids() {
        return getValue(Flags.FLAG_RESTRICT_NONPRELOADS_SYSTEM_SHAREDUIDS, new CustomFeatureFlags$$ExternalSyntheticLambda13());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean rollbackLifetime() {
        return getValue(Flags.FLAG_ROLLBACK_LIFETIME, new CustomFeatureFlags$$ExternalSyntheticLambda34());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean sdkLibIndependence() {
        return getValue(Flags.FLAG_SDK_LIB_INDEPENDENCE, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean setPreVerifiedDomains() {
        return getValue(Flags.FLAG_SET_PRE_VERIFIED_DOMAINS, new CustomFeatureFlags$$ExternalSyntheticLambda28());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean stayStopped() {
        return getValue(Flags.FLAG_STAY_STOPPED, new CustomFeatureFlags$$ExternalSyntheticLambda31());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean useArtServiceV2() {
        return getValue(Flags.FLAG_USE_ART_SERVICE_V2, new CustomFeatureFlags$$ExternalSyntheticLambda12());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean usePiaV2() {
        return getValue(Flags.FLAG_USE_PIA_V2, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    @Override // android.content.pm.FeatureFlags
    public boolean waitApplicationKilled() {
        return getValue(Flags.FLAG_WAIT_APPLICATION_KILLED, new CustomFeatureFlags$$ExternalSyntheticLambda5());
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
        return Arrays.asList(new String[]{Flags.FLAG_ALLOW_SDK_SANDBOX_QUERY_INTENT_ACTIVITIES, Flags.FLAG_ARCHIVING, Flags.FLAG_ASL_IN_APK_APP_METADATA_SOURCE, Flags.FLAG_COMPONENT_STATE_CHANGED_METRICS, Flags.FLAG_DISALLOW_SDK_LIBS_TO_BE_APPS, Flags.FLAG_EMERGENCY_INSTALL_PERMISSION, Flags.FLAG_ENCODE_APP_INTENT, Flags.FLAG_FIX_DUPLICATED_FLAGS, Flags.FLAG_FIX_SYSTEM_APPS_FIRST_INSTALL_TIME, Flags.FLAG_FORCE_MULTI_ARCH_NATIVE_LIBS_MATCH, Flags.FLAG_GET_PACKAGE_INFO, Flags.FLAG_GET_PACKAGE_INFO_WITH_FD, Flags.FLAG_GET_PACKAGE_STORAGE_STATS, Flags.FLAG_GET_RESOLVED_APK_PATH, Flags.FLAG_IMPROVE_HOME_APP_BEHAVIOR, Flags.FLAG_IMPROVE_INSTALL_DONT_KILL, Flags.FLAG_IMPROVE_INSTALL_FREEZE, Flags.FLAG_INTRODUCE_MEDIA_PROCESSING_TYPE, Flags.FLAG_LIGHTWEIGHT_INVISIBLE_LABEL_DETECTION, Flags.FLAG_MIN_TARGET_SDK_24, Flags.FLAG_NULLABLE_DATA_DIR, Flags.FLAG_PACKAGE_RESTART_QUERY_DISABLED_BY_DEFAULT, Flags.FLAG_PROVIDE_INFO_OF_APK_IN_APEX, Flags.FLAG_QUARANTINED_ENABLED, Flags.FLAG_READ_INSTALL_INFO, Flags.FLAG_RECOVERABILITY_DETECTION, Flags.FLAG_RELATIVE_REFERENCE_INTENT_FILTERS, Flags.FLAG_RESTRICT_NONPRELOADS_SYSTEM_SHAREDUIDS, Flags.FLAG_ROLLBACK_LIFETIME, Flags.FLAG_SDK_LIB_INDEPENDENCE, Flags.FLAG_SET_PRE_VERIFIED_DOMAINS, Flags.FLAG_STAY_STOPPED, Flags.FLAG_USE_ART_SERVICE_V2, Flags.FLAG_USE_PIA_V2, Flags.FLAG_WAIT_APPLICATION_KILLED});
    }
}
