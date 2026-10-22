package android.content.pm;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // android.content.pm.FeatureFlags
    public boolean allowSdkSandboxQueryIntentActivities() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean archiving() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean aslInApkAppMetadataSource() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean componentStateChangedMetrics() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean disallowSdkLibsToBeApps() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean emergencyInstallPermission() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean encodeAppIntent() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean fixDuplicatedFlags() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean fixSystemAppsFirstInstallTime() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean forceMultiArchNativeLibsMatch() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageInfo() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageInfoWithFd() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getPackageStorageStats() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean getResolvedApkPath() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveHomeAppBehavior() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveInstallDontKill() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean improveInstallFreeze() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean introduceMediaProcessingType() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean lightweightInvisibleLabelDetection() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean minTargetSdk24() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean nullableDataDir() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean packageRestartQueryDisabledByDefault() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean provideInfoOfApkInApex() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean quarantinedEnabled() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean readInstallInfo() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean recoverabilityDetection() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean relativeReferenceIntentFilters() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean restrictNonpreloadsSystemShareduids() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean rollbackLifetime() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean sdkLibIndependence() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean setPreVerifiedDomains() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean stayStopped() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean useArtServiceV2() {
        return true;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean usePiaV2() {
        return false;
    }

    @Override // android.content.pm.FeatureFlags
    public boolean waitApplicationKilled() {
        return false;
    }

    public FeatureFlagsImpl() {
    }
}
