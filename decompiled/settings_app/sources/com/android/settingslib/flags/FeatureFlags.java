package com.android.settingslib.flags;

/* JADX INFO: loaded from: classes.dex */
public interface FeatureFlags {
    boolean allowAllWidgetsOnLockscreenByDefault();

    boolean bluetoothQsTileDialogAutoOnToggle();

    boolean enableCachedBluetoothDeviceDedup();

    boolean enableDeterminingAdvancedDetailsHeaderWithMetadata();

    boolean enableDeterminingSpatialAudioAttributesByProfile();

    boolean enableHideExclusivelyManagedBluetoothDevice();

    boolean enableLeAudioQrCodePrivateBroadcastSharing();

    boolean enableLeAudioSharing();

    boolean enableSetPreferredTransportForLeAudioDevice();

    boolean legacyLeAudioSharing();

    boolean newStatusBarIcons();
}
