package com.android.settings.wifi.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
public class NoTitlePreferenceCategory extends PreferenceCategory {
    public NoTitlePreferenceCategory(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public NoTitlePreferenceCategory(Context r1) {
        super(r1);
        setLayoutResource(R.layout.headerless_preference_category);
    }

    @Override // androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        TextView r0 = (TextView) r1.findViewById(android.R.id.title);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }
}
