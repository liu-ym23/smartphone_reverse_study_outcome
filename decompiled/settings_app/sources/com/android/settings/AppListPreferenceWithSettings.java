package com.android.settings;

import android.content.ComponentName;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class AppListPreferenceWithSettings extends AppListPreference {
    private ComponentName mSettingsComponent;
    private View mSettingsIcon;

    static /* synthetic */ ComponentName access$000(AppListPreferenceWithSettings r0) {
        return r0.mSettingsComponent;
    }

    public AppListPreferenceWithSettings(Context r1, AttributeSet r2) {
        super(r1, r2);
        setWidgetLayoutResource(R.layout.preference_widget_settings);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.findViewById(R.id.settings_button);
        this.mSettingsIcon = r3;
        r3.setOnClickListener(new AnonymousClass1(this));
        ((ViewGroup) this.mSettingsIcon.getParent()).setPaddingRelative(0, 0, 0, 0);
        updateSettingsVisibility();
    }

    private void updateSettingsVisibility() {
        View r0 = this.mSettingsIcon;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mSettingsComponent != null) goto L8;
        r0.setVisibility(8);
        return;
    L8:
        r0.setVisibility(0);
    }

    protected void setSettingsComponent(ComponentName r1) {
        this.mSettingsComponent = r1;
        updateSettingsVisibility();
    }
}
