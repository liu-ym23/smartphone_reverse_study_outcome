package com.android.settings.applications;

import android.content.Context;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class LinearColorPreference extends Preference {
    int mColoredRegions;
    int mGreenColor;
    float mGreenRatio;
    LinearColorBar.OnRegionTappedListener mOnRegionTappedListener;
    int mRedColor;
    float mRedRatio;
    int mYellowColor;
    float mYellowRatio;

    public LinearColorPreference(Context r1) {
        super(r1);
        this.mRedColor = -5615568;
        this.mYellowColor = -5592528;
        this.mGreenColor = -13587888;
        this.mColoredRegions = 7;
        setLayoutResource(R.layout.preference_linearcolor);
    }

    public void setRatios(float r1, float r2, float r3) {
        this.mRedRatio = r1;
        this.mYellowRatio = r2;
        this.mGreenRatio = r3;
        notifyChanged();
    }

    public void setColors(int r1, int r2, int r3) {
        this.mRedColor = r1;
        this.mYellowColor = r2;
        this.mGreenColor = r3;
        notifyChanged();
    }

    public void setOnRegionTappedListener(LinearColorBar.OnRegionTappedListener r1) {
        this.mOnRegionTappedListener = r1;
        notifyChanged();
    }

    public void setColoredRegions(int r1) {
        this.mColoredRegions = r1;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        super.onBindViewHolder(r4);
        LinearColorBar r5 = (LinearColorBar) r4.findViewById(R.id.linear_color_bar);
        r5.setShowIndicator(false);
        r5.setColors(this.mRedColor, this.mYellowColor, this.mGreenColor);
        r5.setRatios(this.mRedRatio, this.mYellowRatio, this.mGreenRatio);
        r5.setColoredRegions(this.mColoredRegions);
        r5.setOnRegionTappedListener(this.mOnRegionTappedListener);
    }
}
