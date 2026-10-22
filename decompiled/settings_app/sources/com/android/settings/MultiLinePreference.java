package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class MultiLinePreference extends Preference {
    public MultiLinePreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public MultiLinePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public MultiLinePreference(Context r1) {
        super(r1);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        TextView r0 = (TextView) r1.findViewById(android.R.id.title);
        if (r0 == null) goto L6;
        r0.setSingleLine(false);
        return;
    }
}
