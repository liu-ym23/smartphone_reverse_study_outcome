package com.android.settingslib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.R;

/* JADX INFO: loaded from: classes.dex */
public class SelectorWithWidgetPreference extends CheckBoxPreference {
    private View mAppendix;
    private int mAppendixVisibility;
    private ImageView mExtraWidget;
    private View mExtraWidgetContainer;
    private View.OnClickListener mExtraWidgetOnClickListener;
    private boolean mIsCheckBox;
    private OnClickListener mListener;

    public interface OnClickListener {
        void onRadioButtonClicked(SelectorWithWidgetPreference r1);
    }

    public SelectorWithWidgetPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mListener = null;
        this.mAppendixVisibility = -1;
        this.mIsCheckBox = false;
        init();
    }

    public SelectorWithWidgetPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mListener = null;
        this.mAppendixVisibility = -1;
        this.mIsCheckBox = false;
        init();
    }

    public SelectorWithWidgetPreference(Context r2, boolean r3) {
        super(r2, null);
        this.mListener = null;
        this.mAppendixVisibility = -1;
        this.mIsCheckBox = r3;
        init();
    }

    public SelectorWithWidgetPreference(Context r2) {
        this(r2, null);
    }

    public void setOnClickListener(OnClickListener r1) {
        this.mListener = r1;
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void onClick() {
        OnClickListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRadioButtonClicked(this);
        return;
    }

    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        super.onBindViewHolder(r4);
        View r0 = r4.findViewById(R.id.summary_container);
        if (r0 != null) goto L5;
    L13:
        this.mExtraWidget = (ImageView) r4.findViewById(R.id.selector_extra_widget);
        this.mExtraWidgetContainer = r4.findViewById(R.id.selector_extra_widget_container);
        setExtraWidgetOnClickListener(this.mExtraWidgetOnClickListener);
        return;
    L5:
        if (TextUtils.isEmpty(getSummary()) == false) goto L7;
        int r1 = 8;
    L8:
        r0.setVisibility(r1);
        View r2 = r4.findViewById(R.id.appendix);
        this.mAppendix = r2;
        if (r2 == null) goto L13;
        int r3 = this.mAppendixVisibility;
        if (r3 == (-1)) goto L13;
        r2.setVisibility(r3);
        goto L13
    L7:
        r1 = 0;
        goto L8
    }

    public void setAppendixVisibility(int r2) {
        View r0 = this.mAppendix;
        if (r0 == null) goto L5;
        r0.setVisibility(r2);
    L5:
        this.mAppendixVisibility = r2;
    }

    public void setExtraWidgetOnClickListener(View.OnClickListener r3) {
        this.mExtraWidgetOnClickListener = r3;
        ImageView r0 = this.mExtraWidget;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mExtraWidgetContainer == null) goto L14;
        r0.setOnClickListener(r3);
        View r4 = this.mExtraWidgetContainer;
        if (this.mExtraWidgetOnClickListener == null) goto L10;
        int r2 = 0;
    L11:
        r4.setVisibility(r2);
        return;
    L10:
        r2 = 8;
        goto L11
    }

    public boolean isCheckBox() {
        return this.mIsCheckBox;
    }

    private void init() {
        if (this.mIsCheckBox == false) goto L5;
        setWidgetLayoutResource(R.layout.preference_widget_checkbox);
    L6:
        setLayoutResource(R.layout.preference_selector_with_widget);
        setIconSpaceReserved(false);
        return;
    L5:
        setWidgetLayoutResource(R.layout.preference_widget_radiobutton);
        goto L6
    }
}
