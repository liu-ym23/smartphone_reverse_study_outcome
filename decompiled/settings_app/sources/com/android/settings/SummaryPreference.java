package com.android.settings;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.applications.LinearColorBar;

/* JADX INFO: loaded from: classes2.dex */
public class SummaryPreference extends Preference {
    private static final String TAG = "SummaryPreference";
    private String mAmount;
    private String mEndLabel;
    private int mLeft;
    private float mLeftRatio;
    private int mMiddle;
    private float mMiddleRatio;
    private int mRight;
    private float mRightRatio;
    private String mStartLabel;
    private String mUnits;

    public SummaryPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.settings_summary_preference);
        this.mLeft = r1.getColor(R.color.summary_default_start);
        this.mRight = r1.getColor(R.color.summary_default_end);
    }

    public void setAmount(String r4) {
        this.mAmount = r4;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mUnits == null) goto L9;
        setTitle(TextUtils.expandTemplate(getContext().getText(R.string.storage_size_large), new CharSequence[]{this.mAmount, this.mUnits}));
        return;
    }

    public void setUnits(String r4) {
        this.mUnits = r4;
        if (this.mAmount == null) goto L7;
        if (r4 == null) goto L8;
        setTitle(TextUtils.expandTemplate(getContext().getText(R.string.storage_size_large), new CharSequence[]{this.mAmount, this.mUnits}));
        return;
    L8:
        return;
    }

    public void setLabels(String r1, String r2) {
        this.mStartLabel = r1;
        this.mEndLabel = r2;
        notifyChanged();
    }

    public void setRatios(float r1, float r2, float r3) {
        this.mLeftRatio = r1;
        this.mMiddleRatio = r2;
        this.mRightRatio = r3;
        notifyChanged();
    }

    public void setColors(int r1, int r2, int r3) {
        this.mLeft = r1;
        this.mMiddle = r2;
        this.mRight = r3;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        LinearColorBar r0 = (LinearColorBar) r5.itemView.findViewById(R.id.color_bar);
        r0.setRatios(this.mLeftRatio, this.mMiddleRatio, this.mRightRatio);
        r0.setColors(this.mLeft, this.mMiddle, this.mRight);
        if (TextUtils.isEmpty(this.mStartLabel) == true) goto L5;
    L8:
        r5.findViewById(R.id.label_bar).setVisibility(0);
        ((TextView) r5.findViewById(android.R.id.text1)).setText(this.mStartLabel);
        ((TextView) r5.findViewById(android.R.id.text2)).setText(this.mEndLabel);
        return;
    L5:
        if (TextUtils.isEmpty(this.mEndLabel) == false) goto L8;
        r5.findViewById(R.id.label_bar).setVisibility(8);
    }
}
