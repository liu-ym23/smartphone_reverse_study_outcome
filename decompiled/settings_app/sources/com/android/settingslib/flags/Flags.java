package com.android.settingslib.flags;

/* JADX INFO: loaded from: classes.dex */
public final class Flags {
    private static FeatureFlags FEATURE_FLAGS = null;
    public static final String FLAG_ALLOW_ALL_WIDGETS_ON_LOCKSCREEN_BY_DEFAULT = "com.android.settingslib.flags.allow_all_widgets_on_lockscreen_by_default";
    public static final String FLAG_BLUETOOTH_QS_TILE_DIALOG_AUTO_ON_TOGGLE = "com.android.settingslib.flags.bluetooth_qs_tile_dialog_auto_on_toggle";
    public static final String FLAG_ENABLE_CACHED_BLUETOOTH_DEVICE_DEDUP = "com.android.settingslib.flags.enable_cached_bluetooth_device_dedup";
    public static final String FLAG_ENABLE_DETERMINING_ADVANCED_DETAILS_HEADER_WITH_METADATA = "com.android.settingslib.flags.enable_determining_advanced_details_header_with_metadata";
    public static final String FLAG_ENABLE_DETERMINING_SPATIAL_AUDIO_ATTRIBUTES_BY_PROFILE = "com.android.settingslib.flags.enable_determining_spatial_audio_attributes_by_profile";
    public static final String FLAG_ENABLE_HIDE_EXCLUSIVELY_MANAGED_BLUETOOTH_DEVICE = "com.android.settingslib.flags.enable_hide_exclusively_managed_bluetooth_device";
    public static final String FLAG_ENABLE_LE_AUDIO_QR_CODE_PRIVATE_BROADCAST_SHARING = "com.android.settingslib.flags.enable_le_audio_qr_code_private_broadcast_sharing";
    public static final String FLAG_ENABLE_LE_AUDIO_SHARING = "com.android.settingslib.flags.enable_le_audio_sharing";
    public static final String FLAG_ENABLE_SET_PREFERRED_TRANSPORT_FOR_LE_AUDIO_DEVICE = "com.android.settingslib.flags.enable_set_preferred_transport_for_le_audio_device";
    public static final String FLAG_LEGACY_LE_AUDIO_SHARING = "com.android.settingslib.flags.legacy_le_audio_sharing";
    public static final String FLAG_NEW_STATUS_BAR_ICONS = "com.android.settingslib.flags.new_status_bar_icons";

    public Flags() {
    }

    public static boolean allowAllWidgetsOnLockscreenByDefault() {
        return FEATURE_FLAGS.allowAllWidgetsOnLockscreenByDefault();
    }

    public static boolean bluetoothQsTileDialogAutoOnToggle() {
        return FEATURE_FLAGS.bluetoothQsTileDialogAutoOnToggle();
    }

    public static boolean enableCachedBluetoothDeviceDedup() {
        return FEATURE_FLAGS.enableCachedBluetoothDeviceDedup();
    }

    public static boolean enableDeterminingAdvancedDetailsHeaderWithMetadata() {
        return FEATURE_FLAGS.enableDeterminingAdvancedDetailsHeaderWithMetadata();
    }

    public static boolean enableDeterminingSpatialAudioAttributesByProfile() {
        return FEATURE_FLAGS.enableDeterminingSpatialAudioAttributesByProfile();
    }

    public static boolean enableHideExclusivelyManagedBluetoothDevice() {
        return FEATURE_FLAGS.enableHideExclusivelyManagedBluetoothDevice();
    }

    public static boolean enableLeAudioQrCodePrivateBroadcastSharing() {
        return FEATURE_FLAGS.enableLeAudioQrCodePrivateBroadcastSharing();
    }

    public static boolean enableLeAudioSharing() {
        return FEATURE_FLAGS.enableLeAudioSharing();
    }

    public static boolean enableSetPreferredTransportForLeAudioDevice() {
        return FEATURE_FLAGS.enableSetPreferredTransportForLeAudioDevice();
    }

    public static boolean legacyLeAudioSharing() {
        return FEATURE_FLAGS.legacyLeAudioSharing();
    }

    public static boolean newStatusBarIcons() {
        return FEATURE_FLAGS.newStatusBarIcons();
    }

    static {
        FEATURE_FLAGS = new FeatureFlagsImpl();
    }
}
