package com.android.settingslib.flags;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean allowAllWidgetsOnLockscreenByDefault() {
        return false;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean bluetoothQsTileDialogAutoOnToggle() {
        return false;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableCachedBluetoothDeviceDedup() {
        return true;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableDeterminingAdvancedDetailsHeaderWithMetadata() {
        return true;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableDeterminingSpatialAudioAttributesByProfile() {
        return true;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableHideExclusivelyManagedBluetoothDevice() {
        return true;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableLeAudioQrCodePrivateBroadcastSharing() {
        return false;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableLeAudioSharing() {
        return false;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableSetPreferredTransportForLeAudioDevice() {
        return true;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean legacyLeAudioSharing() {
        return false;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean newStatusBarIcons() {
        return false;
    }

    public FeatureFlagsImpl() {
    }
}
