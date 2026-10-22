package android.permission.flags;

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

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r28) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_APEX_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, Flags.FLAG_DEVICE_AWARE_APP_OP_NEW_SCHEMA_ENABLED, Flags.FLAG_DEVICE_AWARE_PERMISSION_APIS_ENABLED, Flags.FLAG_DEVICE_AWARE_PERMISSIONS_ENABLED, Flags.FLAG_DEVICE_ID_IN_OP_PROXY_INFO_ENABLED, Flags.FLAG_ENHANCED_CONFIRMATION_MODE_APIS_ENABLED, Flags.FLAG_FACTORY_RESET_PREP_PERMISSION_APIS, Flags.FLAG_FINISH_RUNNING_OPS_FOR_KILLED_PACKAGES, Flags.FLAG_GET_EMERGENCY_ROLE_HOLDER_API_ENABLED, Flags.FLAG_IGNORE_PROCESS_TEXT, Flags.FLAG_OP_ENABLE_MOBILE_DATA_BY_USER, Flags.FLAG_RETAIL_DEMO_ROLE_ENABLED, Flags.FLAG_RUNTIME_PERMISSION_APPOPS_MAPPING_ENABLED, Flags.FLAG_SENSITIVE_CONTENT_IMPROVEMENTS, Flags.FLAG_SENSITIVE_CONTENT_METRICS_BUGFIX, Flags.FLAG_SENSITIVE_CONTENT_RECENTS_SCREENSHOT_BUGFIX, Flags.FLAG_SENSITIVE_NOTIFICATION_APP_PROTECTION, Flags.FLAG_SERVER_SIDE_ATTRIBUTION_REGISTRATION, Flags.FLAG_SET_NEXT_ATTRIBUTION_SOURCE, Flags.FLAG_SHOULD_REGISTER_ATTRIBUTION_SOURCE, Flags.FLAG_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, Flags.FLAG_SYSTEM_SERVER_ROLE_CONTROLLER_ENABLED, Flags.FLAG_VOICE_ACTIVATION_PERMISSION_APIS, Flags.FLAG_WALLET_ROLE_ENABLED, ""}));
        this.mGetValueImpl = r28;
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean apexSignaturePermissionAllowlistEnabled() {
        return getValue(Flags.FLAG_APEX_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda16());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwareAppOpNewSchemaEnabled() {
        return getValue(Flags.FLAG_DEVICE_AWARE_APP_OP_NEW_SCHEMA_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda5());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwarePermissionApisEnabled() {
        return getValue(Flags.FLAG_DEVICE_AWARE_PERMISSION_APIS_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda12());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceAwarePermissionsEnabled() {
        return getValue(Flags.FLAG_DEVICE_AWARE_PERMISSIONS_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda21());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean deviceIdInOpProxyInfoEnabled() {
        return getValue(Flags.FLAG_DEVICE_ID_IN_OP_PROXY_INFO_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda17());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean enhancedConfirmationModeApisEnabled() {
        return getValue(Flags.FLAG_ENHANCED_CONFIRMATION_MODE_APIS_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda22());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean factoryResetPrepPermissionApis() {
        return getValue(Flags.FLAG_FACTORY_RESET_PREP_PERMISSION_APIS, new CustomFeatureFlags$$ExternalSyntheticLambda8());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean finishRunningOpsForKilledPackages() {
        return getValue(Flags.FLAG_FINISH_RUNNING_OPS_FOR_KILLED_PACKAGES, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean getEmergencyRoleHolderApiEnabled() {
        return getValue(Flags.FLAG_GET_EMERGENCY_ROLE_HOLDER_API_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean ignoreProcessText() {
        return getValue(Flags.FLAG_IGNORE_PROCESS_TEXT, new CustomFeatureFlags$$ExternalSyntheticLambda18());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean opEnableMobileDataByUser() {
        return getValue(Flags.FLAG_OP_ENABLE_MOBILE_DATA_BY_USER, new CustomFeatureFlags$$ExternalSyntheticLambda19());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean retailDemoRoleEnabled() {
        return getValue(Flags.FLAG_RETAIL_DEMO_ROLE_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda10());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean runtimePermissionAppopsMappingEnabled() {
        return getValue(Flags.FLAG_RUNTIME_PERMISSION_APPOPS_MAPPING_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentImprovements() {
        return getValue(Flags.FLAG_SENSITIVE_CONTENT_IMPROVEMENTS, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentMetricsBugfix() {
        return getValue(Flags.FLAG_SENSITIVE_CONTENT_METRICS_BUGFIX, new CustomFeatureFlags$$ExternalSyntheticLambda13());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveContentRecentsScreenshotBugfix() {
        return getValue(Flags.FLAG_SENSITIVE_CONTENT_RECENTS_SCREENSHOT_BUGFIX, new CustomFeatureFlags$$ExternalSyntheticLambda14());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean sensitiveNotificationAppProtection() {
        return getValue(Flags.FLAG_SENSITIVE_NOTIFICATION_APP_PROTECTION, new CustomFeatureFlags$$ExternalSyntheticLambda11());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean serverSideAttributionRegistration() {
        return getValue(Flags.FLAG_SERVER_SIDE_ATTRIBUTION_REGISTRATION, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean setNextAttributionSource() {
        return getValue(Flags.FLAG_SET_NEXT_ATTRIBUTION_SOURCE, new CustomFeatureFlags$$ExternalSyntheticLambda15());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean shouldRegisterAttributionSource() {
        return getValue(Flags.FLAG_SHOULD_REGISTER_ATTRIBUTION_SOURCE, new CustomFeatureFlags$$ExternalSyntheticLambda20());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean signaturePermissionAllowlistEnabled() {
        return getValue(Flags.FLAG_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean systemServerRoleControllerEnabled() {
        return getValue(Flags.FLAG_SYSTEM_SERVER_ROLE_CONTROLLER_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda9());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean voiceActivationPermissionApis() {
        return getValue(Flags.FLAG_VOICE_ACTIVATION_PERMISSION_APIS, new CustomFeatureFlags$$ExternalSyntheticLambda23());
    }

    @Override // android.permission.flags.FeatureFlags
    public boolean walletRoleEnabled() {
        return getValue(Flags.FLAG_WALLET_ROLE_ENABLED, new CustomFeatureFlags$$ExternalSyntheticLambda4());
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
        return Arrays.asList(new String[]{Flags.FLAG_APEX_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, Flags.FLAG_DEVICE_AWARE_APP_OP_NEW_SCHEMA_ENABLED, Flags.FLAG_DEVICE_AWARE_PERMISSION_APIS_ENABLED, Flags.FLAG_DEVICE_AWARE_PERMISSIONS_ENABLED, Flags.FLAG_DEVICE_ID_IN_OP_PROXY_INFO_ENABLED, Flags.FLAG_ENHANCED_CONFIRMATION_MODE_APIS_ENABLED, Flags.FLAG_FACTORY_RESET_PREP_PERMISSION_APIS, Flags.FLAG_FINISH_RUNNING_OPS_FOR_KILLED_PACKAGES, Flags.FLAG_GET_EMERGENCY_ROLE_HOLDER_API_ENABLED, Flags.FLAG_IGNORE_PROCESS_TEXT, Flags.FLAG_OP_ENABLE_MOBILE_DATA_BY_USER, Flags.FLAG_RETAIL_DEMO_ROLE_ENABLED, Flags.FLAG_RUNTIME_PERMISSION_APPOPS_MAPPING_ENABLED, Flags.FLAG_SENSITIVE_CONTENT_IMPROVEMENTS, Flags.FLAG_SENSITIVE_CONTENT_METRICS_BUGFIX, Flags.FLAG_SENSITIVE_CONTENT_RECENTS_SCREENSHOT_BUGFIX, Flags.FLAG_SENSITIVE_NOTIFICATION_APP_PROTECTION, Flags.FLAG_SERVER_SIDE_ATTRIBUTION_REGISTRATION, Flags.FLAG_SET_NEXT_ATTRIBUTION_SOURCE, Flags.FLAG_SHOULD_REGISTER_ATTRIBUTION_SOURCE, Flags.FLAG_SIGNATURE_PERMISSION_ALLOWLIST_ENABLED, Flags.FLAG_SYSTEM_SERVER_ROLE_CONTROLLER_ENABLED, Flags.FLAG_VOICE_ACTIVATION_PERMISSION_APIS, Flags.FLAG_WALLET_ROLE_ENABLED});
    }
}
