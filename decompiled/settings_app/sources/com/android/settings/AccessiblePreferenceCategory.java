package com.android.settings;

import android.content.Context;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class AccessiblePreferenceCategory extends PreferenceCategory {
    private String mContentDescription;

    public AccessiblePreferenceCategory(Context r1) {
        super(r1);
    }

    public void setContentDescription(String r1) {
        this.mContentDescription = r1;
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        r1.itemView.setContentDescription(this.mContentDescription);
    }
}
