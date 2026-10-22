package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.ListPreference;

/* JADX INFO: loaded from: classes2.dex */
public class WarnedListPreference extends ListPreference {
    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void onClick() {
    }

    public WarnedListPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public void click() {
        super.onClick();
    }
}
