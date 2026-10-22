package com.android.settings.applications;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.internal.R;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class LayoutPreference extends Preference {
    private View mRootView;

    public LayoutPreference(Context r3, AttributeSet r4) {
        super(r3, r4);
        int r5 = r3.obtainStyledAttributes(r4, R.styleable.Preference, 0, 0).getResourceId(3, 0);
        if (r5 == 0) goto L7;
        setView(LayoutInflater.from(getContext()).inflate(r5, null, false));
        return;
    L7:
        throw new IllegalArgumentException("LayoutPreference requires a layout to be defined");
    }

    public LayoutPreference(Context r4, int r5) {
        this(r4, LayoutInflater.from(r4).inflate(r5, null, false));
    }

    public LayoutPreference(Context r1, View r2) {
        super(r1);
        setView(r2);
    }

    public void setView(View r4) {
        setLayoutResource(com.android.settings.R.layout.layout_preference_frame);
        setSelectable(false);
        ViewGroup r1 = (ViewGroup) r4.findViewById(com.android.settings.R.id.all_details);
        if (r1 == null) goto L5;
        Utils.forceCustomPadding(r1, true);
    L5:
        this.mRootView = r4;
        setShouldDisableView(false);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        FrameLayout r4 = (FrameLayout) r3.itemView;
        r4.removeAllViews();
        ViewGroup r0 = (ViewGroup) this.mRootView.getParent();
        if (r0 == null) goto L5;
        r0.removeView(this.mRootView);
    L5:
        r4.addView(this.mRootView);
    }

    public View findViewById(int r1) {
        return this.mRootView.findViewById(r1);
    }
}
