package com.android.settingslib.media.flags;

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

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r8) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ENABLE_OUTPUT_SWITCHER_FOR_SYSTEM_ROUTING, Flags.FLAG_ENABLE_TV_MEDIA_OUTPUT_DIALOG, Flags.FLAG_REMOVE_UNNECESSARY_ROUTE_SCANNING, Flags.FLAG_USE_MEDIA_ROUTER2_FOR_INFO_MEDIA_MANAGER, Flags.FLAG_USE_PLAYBACK_INFO_FOR_ROUTING_CONTROLS, ""}));
        this.mGetValueImpl = r8;
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean enableOutputSwitcherForSystemRouting() {
        return getValue(Flags.FLAG_ENABLE_OUTPUT_SWITCHER_FOR_SYSTEM_ROUTING, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean enableTvMediaOutputDialog() {
        return getValue(Flags.FLAG_ENABLE_TV_MEDIA_OUTPUT_DIALOG, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean removeUnnecessaryRouteScanning() {
        return getValue(Flags.FLAG_REMOVE_UNNECESSARY_ROUTE_SCANNING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean useMediaRouter2ForInfoMediaManager() {
        return getValue(Flags.FLAG_USE_MEDIA_ROUTER2_FOR_INFO_MEDIA_MANAGER, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // com.android.settingslib.media.flags.FeatureFlags
    public boolean usePlaybackInfoForRoutingControls() {
        return getValue(Flags.FLAG_USE_PLAYBACK_INFO_FOR_ROUTING_CONTROLS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
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
        return Arrays.asList(new String[]{Flags.FLAG_ENABLE_OUTPUT_SWITCHER_FOR_SYSTEM_ROUTING, Flags.FLAG_ENABLE_TV_MEDIA_OUTPUT_DIALOG, Flags.FLAG_REMOVE_UNNECESSARY_ROUTE_SCANNING, Flags.FLAG_USE_MEDIA_ROUTER2_FOR_INFO_MEDIA_MANAGER, Flags.FLAG_USE_PLAYBACK_INFO_FOR_ROUTING_CONTROLS});
    }
}
