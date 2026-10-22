package com.android.settings;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseLockGenericPreference extends Preference {
    private Drawable background;

    public ChooseLockGenericPreference(Context r2, AttributeSet r3) {
        super(r2, r3);
        TypedArray r4 = r2.obtainStyledAttributes(r3, R.styleable.ChooseLockGenericPreference);
        this.background = r4.getDrawable(0);
        r4.recycle();
        setLayoutResource(R.layout.choose_lock_generic_preference);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        View r2 = r1.itemView;
        Drawable r0 = this.background;
        if (r0 == null) goto L6;
        r2.setBackgroundDrawable(r0);
        return;
    }
}
