package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.preference.PreferenceViewHolder;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class AppListSwitchPreference extends AppListPreference {
    private static final String TAG = "AppListSwitchPref";
    private Checkable mSwitch;

    public AppListSwitchPreference(Context r3, AttributeSet r4) {
        super(r3, r4, 0, R.style.AppListSwitchPreference);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        Checkable r3 = (Checkable) r2.findViewById(android.R.id.switch_widget);
        this.mSwitch = r3;
        if (getValue() == null) goto L5;
        boolean r1 = true;
    L6:
        r3.setChecked(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    protected void onClick() {
        if (getValue() == null) goto L8;
        if (callChangeListener(null) == false) goto L20;
        setValue(null);
        return;
    L20:
        return;
    L8:
        if (getEntryValues() != null) goto L10;
    L18:
        OLog.e(TAG, "Attempting to show dialog with zero entries: " + getKey());
        return;
    L10:
        if (getEntryValues().length == 0) goto L18;
        if (getEntryValues().length != 1) goto L17;
        String r0 = getEntryValues()[0].toString();
        if (callChangeListener(r0) == false) goto L22;
        setValue(r0);
        return;
    L22:
        return;
    L17:
        super.onClick();
    }

    @Override // androidx.preference.ListPreference
    public void setValue(String r1) {
        super.setValue(r1);
        Checkable r0 = this.mSwitch;
        if (r0 == null) goto L9;
        if (r1 == null) goto L6;
        boolean r2 = true;
    L7:
        r0.setChecked(r2);
        return;
    L6:
        r2 = false;
        goto L7
    }
}
