package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class DividedCategory extends PreferenceCategory {
    public DividedCategory(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        r1.setDividerAllowedAbove(true);
    }
}
