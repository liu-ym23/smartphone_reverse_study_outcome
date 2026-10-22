package com.android.settings.display;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceGroup;
import com.android.settings.R;
import com.android.settingslib.display.DisplayDensityUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ScreenZoomPreference extends PreferenceGroup {
    @Override // androidx.preference.PreferenceGroup
    protected boolean isOnSameScreenAsChildren() {
        return false;
    }

    public ScreenZoomPreference(Context r3, AttributeSet r4) {
        super(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
        if (TextUtils.isEmpty(getFragment()) == false) goto L5;
        setFragment("com.android.settings.display.ScreenZoomSettings");
    L5:
        DisplayDensityUtils r5 = new DisplayDensityUtils(r3);
        if (r5.getCurrentIndexForDefaultDisplay() >= 0) goto L9;
        setVisible(false);
        setEnabled(false);
        return;
    L9:
        if (TextUtils.isEmpty(getSummary()) == false) goto L13;
        setSummary(r5.getDefaultDisplayDensityEntries()[r5.getCurrentIndexForDefaultDisplay()]);
        return;
    }
}
