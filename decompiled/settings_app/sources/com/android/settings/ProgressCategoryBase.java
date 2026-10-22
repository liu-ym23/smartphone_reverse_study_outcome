package com.android.settings;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProgressCategoryBase extends PreferenceCategory {
    private static final String TAG = "ProgressCategoryBase";

    public abstract void setProgress(boolean r1);

    public ProgressCategoryBase(Context r2) {
        this(r2, null);
    }

    public ProgressCategoryBase(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ProgressCategoryBase(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, 0);
    }

    public ProgressCategoryBase(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    @Override // androidx.preference.PreferenceGroup
    public boolean addPreference(Preference r2) {
        return super.addPreference(r2);
    L4:
        e = move-exception;
        OLog.e(TAG, "addPreference error", e);
        return false;
    }
}
