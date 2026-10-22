package com.android.settingslib.media.flags;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean enableOutputSwitcherForSystemRouting() {
        return true;
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean enableTvMediaOutputDialog() {
        return false;
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean removeUnnecessaryRouteScanning() {
        return true;
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean useMediaRouter2ForInfoMediaManager() {
        return true;
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean usePlaybackInfoForRoutingControls() {
        return true;
    }

    public FeatureFlagsImpl() {
    }
}
