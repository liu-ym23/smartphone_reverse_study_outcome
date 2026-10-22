package com.android.settings;

import android.content.Context;
import android.os.UserManager;
import android.util.AttributeSet;
import androidx.preference.PreferenceCategory;

/* JADX INFO: loaded from: classes2.dex */
public class WorkOnlyCategory extends PreferenceCategory implements SelfAvailablePreference {
    public WorkOnlyCategory(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.android.settings.SelfAvailablePreference
    public boolean isAvailable(Context r1) {
        if (Utils.getManagedProfile(UserManager.get(r1)) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
