package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class DividerPreference extends Preference {
    private Boolean mAllowAbove;
    private Boolean mAllowBelow;

    public DividerPreference(Context r3, AttributeSet r4) {
        super(r3, r4);
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.DividerPreference, 0, 0);
        if (r5.hasValue(0) == false) goto L6;
        this.mAllowAbove = Boolean.valueOf(r5.getBoolean(0, false));
    L6:
        if (r5.hasValue(1) == false) goto L8;
        this.mAllowBelow = Boolean.valueOf(r5.getBoolean(1, false));
    L8:
        r5.recycle();
    }

    public DividerPreference(Context r2) {
        this(r2, null);
    }

    public void setDividerAllowedAbove(boolean r1) {
        this.mAllowAbove = Boolean.valueOf(r1);
        notifyChanged();
    }

    public void setDividerAllowedBelow(boolean r1) {
        this.mAllowBelow = Boolean.valueOf(r1);
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        Boolean r0 = this.mAllowAbove;
        if (r0 == null) goto L5;
        r2.setDividerAllowedAbove(r0.booleanValue());
    L5:
        Boolean r1 = this.mAllowBelow;
        if (r1 == null) goto L9;
        r2.setDividerAllowedBelow(r1.booleanValue());
        return;
    }
}
