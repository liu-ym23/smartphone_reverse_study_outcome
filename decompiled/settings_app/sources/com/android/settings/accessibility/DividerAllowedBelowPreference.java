package com.android.settings.accessibility;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class DividerAllowedBelowPreference extends Preference {
    public DividerAllowedBelowPreference(Context r1) {
        super(r1);
    }

    public DividerAllowedBelowPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public DividerAllowedBelowPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        r1.setDividerAllowedBelow(true);
    }
}
