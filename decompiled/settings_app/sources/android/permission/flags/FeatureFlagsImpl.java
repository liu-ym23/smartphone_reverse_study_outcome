package android.permission.flags;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // android.permission.flags.FeatureFlags
    public boolean apexSignaturePermissionAllowlistEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwareAppOpNewSchemaEnabled() {
        return false;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwarePermissionApisEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwarePermissionsEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceIdInOpProxyInfoEnabled() {
        return false;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean enhancedConfirmationModeApisEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean factoryResetPrepPermissionApis() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean finishRunningOpsForKilledPackages() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean getEmergencyRoleHolderApiEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean ignoreProcessText() {
        return false;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean opEnableMobileDataByUser() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean retailDemoRoleEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean runtimePermissionAppopsMappingEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentImprovements() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentMetricsBugfix() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentRecentsScreenshotBugfix() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveNotificationAppProtection() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean serverSideAttributionRegistration() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean setNextAttributionSource() {
        return false;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean shouldRegisterAttributionSource() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean signaturePermissionAllowlistEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean systemServerRoleControllerEnabled() {
        return true;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean voiceActivationPermissionApis() {
        return false;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean walletRoleEnabled() {
        return true;
    }

    public FeatureFlagsImpl() {
    }
}
