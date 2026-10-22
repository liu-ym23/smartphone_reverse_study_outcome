package com.android.settings.dashboard;

import android.content.Context;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.core.PreferenceControllerMixin;
import com.android.settingslib.core.AbstractPreferenceController;

/* JADX INFO: loaded from: classes2.dex */
class DashboardTilePlaceholderPreferenceController extends AbstractPreferenceController implements PreferenceControllerMixin {
    private static final String KEY_PLACEHOLDER = "dashboard_tile_placeholder";
    private int mOrder;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_PLACEHOLDER;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return false;
    }

    public DashboardTilePlaceholderPreferenceController(Context r1) {
        super(r1);
        this.mOrder = Integer.MAX_VALUE;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r3) {
        Preference r0 = r3.findPreference(getPreferenceKey());
        if (r0 == null) goto L6;
        this.mOrder = r0.getOrder();
        r3.removePreference(r0);
        return;
    }

    public int getOrder() {
        return this.mOrder;
    }
}
