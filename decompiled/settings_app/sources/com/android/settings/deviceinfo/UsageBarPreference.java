package com.android.settings.deviceinfo;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.google.android.collect.Lists;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UsageBarPreference extends Preference {
    private final List<PercentageBarChart.Entry> mEntries;

    public void commit() {
    }

    public UsageBarPreference(Context r2) {
        this(r2, null);
    }

    public UsageBarPreference(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public UsageBarPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public UsageBarPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mEntries = Lists.newArrayList();
    }

    public void addEntry(int r2, float r3, int r4) {
        this.mEntries.add(PercentageBarChart.createEntry(r2, r3, r4));
        Collections.sort(this.mEntries);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
    }

    public void clear() {
        this.mEntries.clear();
    }
}
