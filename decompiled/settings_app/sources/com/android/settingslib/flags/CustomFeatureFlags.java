package com.android.settingslib.flags;

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

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r14) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ALLOW_ALL_WIDGETS_ON_LOCKSCREEN_BY_DEFAULT, Flags.FLAG_BLUETOOTH_QS_TILE_DIALOG_AUTO_ON_TOGGLE, Flags.FLAG_ENABLE_CACHED_BLUETOOTH_DEVICE_DEDUP, Flags.FLAG_ENABLE_DETERMINING_ADVANCED_DETAILS_HEADER_WITH_METADATA, Flags.FLAG_ENABLE_DETERMINING_SPATIAL_AUDIO_ATTRIBUTES_BY_PROFILE, Flags.FLAG_ENABLE_HIDE_EXCLUSIVELY_MANAGED_BLUETOOTH_DEVICE, Flags.FLAG_ENABLE_LE_AUDIO_QR_CODE_PRIVATE_BROADCAST_SHARING, Flags.FLAG_ENABLE_LE_AUDIO_SHARING, Flags.FLAG_ENABLE_SET_PREFERRED_TRANSPORT_FOR_LE_AUDIO_DEVICE, Flags.FLAG_LEGACY_LE_AUDIO_SHARING, Flags.FLAG_NEW_STATUS_BAR_ICONS, ""}));
        this.mGetValueImpl = r14;
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean allowAllWidgetsOnLockscreenByDefault() {
        return getValue(Flags.FLAG_ALLOW_ALL_WIDGETS_ON_LOCKSCREEN_BY_DEFAULT, new CustomFeatureFlags$$ExternalSyntheticLambda8());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean bluetoothQsTileDialogAutoOnToggle() {
        return getValue(Flags.FLAG_BLUETOOTH_QS_TILE_DIALOG_AUTO_ON_TOGGLE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableCachedBluetoothDeviceDedup() {
        return getValue(Flags.FLAG_ENABLE_CACHED_BLUETOOTH_DEVICE_DEDUP, new CustomFeatureFlags$$ExternalSyntheticLambda10());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableDeterminingAdvancedDetailsHeaderWithMetadata() {
        return getValue(Flags.FLAG_ENABLE_DETERMINING_ADVANCED_DETAILS_HEADER_WITH_METADATA, new CustomFeatureFlags$$ExternalSyntheticLambda5());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableDeterminingSpatialAudioAttributesByProfile() {
        return getValue(Flags.FLAG_ENABLE_DETERMINING_SPATIAL_AUDIO_ATTRIBUTES_BY_PROFILE, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableHideExclusivelyManagedBluetoothDevice() {
        return getValue(Flags.FLAG_ENABLE_HIDE_EXCLUSIVELY_MANAGED_BLUETOOTH_DEVICE, new CustomFeatureFlags$$ExternalSyntheticLambda9());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableLeAudioQrCodePrivateBroadcastSharing() {
        return getValue(Flags.FLAG_ENABLE_LE_AUDIO_QR_CODE_PRIVATE_BROADCAST_SHARING, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableLeAudioSharing() {
        return getValue(Flags.FLAG_ENABLE_LE_AUDIO_SHARING, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean enableSetPreferredTransportForLeAudioDevice() {
        return getValue(Flags.FLAG_ENABLE_SET_PREFERRED_TRANSPORT_FOR_LE_AUDIO_DEVICE, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean legacyLeAudioSharing() {
        return getValue(Flags.FLAG_LEGACY_LE_AUDIO_SHARING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.settingslib.flags.FeatureFlags
    public boolean newStatusBarIcons() {
        return getValue(Flags.FLAG_NEW_STATUS_BAR_ICONS, new CustomFeatureFlags$$ExternalSyntheticLambda2());
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
        return Arrays.asList(new String[]{Flags.FLAG_ALLOW_ALL_WIDGETS_ON_LOCKSCREEN_BY_DEFAULT, Flags.FLAG_BLUETOOTH_QS_TILE_DIALOG_AUTO_ON_TOGGLE, Flags.FLAG_ENABLE_CACHED_BLUETOOTH_DEVICE_DEDUP, Flags.FLAG_ENABLE_DETERMINING_ADVANCED_DETAILS_HEADER_WITH_METADATA, Flags.FLAG_ENABLE_DETERMINING_SPATIAL_AUDIO_ATTRIBUTES_BY_PROFILE, Flags.FLAG_ENABLE_HIDE_EXCLUSIVELY_MANAGED_BLUETOOTH_DEVICE, Flags.FLAG_ENABLE_LE_AUDIO_QR_CODE_PRIVATE_BROADCAST_SHARING, Flags.FLAG_ENABLE_LE_AUDIO_SHARING, Flags.FLAG_ENABLE_SET_PREFERRED_TRANSPORT_FOR_LE_AUDIO_DEVICE, Flags.FLAG_LEGACY_LE_AUDIO_SHARING, Flags.FLAG_NEW_STATUS_BAR_ICONS});
    }
}
