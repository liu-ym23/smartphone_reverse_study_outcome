package com.android.settings.location;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class RadioButtonPreference extends CheckBoxPreference {
    private OnClickListener mListener;

    public interface OnClickListener {
        void onRadioButtonClicked(RadioButtonPreference r1);
    }

    public RadioButtonPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mListener = null;
        setWidgetLayoutResource(R.layout.preference_widget_radiobutton);
    }

    public RadioButtonPreference(Context r2, AttributeSet r3) {
        this(r2, r3, android.R.attr.checkBoxPreferenceStyle);
    }

    public RadioButtonPreference(Context r2) {
        this(r2, null);
    }

    void setOnClickListener(OnClickListener r1) {
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
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        TextView r0 = (TextView) r1.findViewById(android.R.id.title);
        if (r0 == null) goto L6;
        r0.setSingleLine(false);
        r0.setMaxLines(3);
        return;
    }
}
