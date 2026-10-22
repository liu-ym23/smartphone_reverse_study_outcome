package com.android.settingslib.development;

import android.content.Context;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.core.AbstractPreferenceController;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeveloperOptionsPreferenceController extends AbstractPreferenceController {
    protected Preference mPreference;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return true;
    }

    public DeveloperOptionsPreferenceController(Context r1) {
        super(r1);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mPreference = r2.findPreference(getPreferenceKey());
    }

    public void onDeveloperOptionsEnabled() {
        if (isAvailable() == false) goto L6;
        onDeveloperOptionsSwitchEnabled();
        return;
    }

    public void onDeveloperOptionsDisabled() {
        if (isAvailable() == false) goto L6;
        onDeveloperOptionsSwitchDisabled();
        return;
    }

    protected void onDeveloperOptionsSwitchEnabled() {
        this.mPreference.setEnabled(true);
    }

    protected void onDeveloperOptionsSwitchDisabled() {
        this.mPreference.setEnabled(false);
    }
}
