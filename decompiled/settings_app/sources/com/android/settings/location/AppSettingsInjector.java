package com.android.settings.location;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.preference.Preference;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.widget.RestrictedAppPreference;
import com.android.settingslib.core.instrumentation.MetricsFeatureProvider;

/* JADX INFO: loaded from: classes2.dex */
public class AppSettingsInjector extends com.android.settingslib.location.SettingsInjector {
    private final int mMetricsCategory;
    private final MetricsFeatureProvider mMetricsFeatureProvider;

    public AppSettingsInjector(Context r1, int r2) {
        super(r1);
        this.mMetricsCategory = r2;
        this.mMetricsFeatureProvider = FeatureFactory.getFeatureFactory().getMetricsFeatureProvider();
    }

    @Override // com.android.settingslib.location.SettingsInjector
    protected Preference createPreference(Context r1, com.android.settingslib.location.InjectedSetting r2) {
        if (TextUtils.isEmpty(r2.userRestriction) == false) goto L6;
        return new Preference(r1);
    L6:
        return new RestrictedAppPreference(r1, r2.userRestriction);
    }

    @Override // com.android.settingslib.location.SettingsInjector
    protected void logPreferenceClick(Intent r2) {
        this.mMetricsFeatureProvider.logStartedIntent(r2, this.mMetricsCategory);
    }
}
