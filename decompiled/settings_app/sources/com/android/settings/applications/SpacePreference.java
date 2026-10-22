package com.android.settings.applications;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class SpacePreference extends Preference {
    private int mHeight;

    public SpacePreference(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.preferenceStyle);
    }

    public SpacePreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public SpacePreference(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        setLayoutResource(com.android.settings.R.layout.space_preference);
        TypedArray r8 = r4.obtainStyledAttributes(r5, new int[]{R.attr.layout_height}, r6, r7);
        this.mHeight = r8.getDimensionPixelSize(0, 0);
        r8.recycle();
    }

    public void setHeight(int r1) {
        this.mHeight = r1;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        ViewGroup.LayoutParams r0 = new ViewGroup.LayoutParams(-1, this.mHeight);
        r3.itemView.setLayoutParams(r0);
    }
}
