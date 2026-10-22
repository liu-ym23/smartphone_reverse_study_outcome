package com.android.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class TintablePreference extends Preference {
    private int mTintColor;

    public TintablePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void setTint(int r1) {
        this.mTintColor = r1;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        if (this.mTintColor == 0) goto L5;
        ((ImageView) r3.findViewById(android.R.id.icon)).setImageTintList(ColorStateList.valueOf(this.mTintColor));
        return;
    L5:
        ((ImageView) r3.findViewById(android.R.id.icon)).setImageTintList(null);
    }
}
