package com.android.settings.bluetooth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.CustomEditTextPreference;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceProfileRenamePreference extends CustomEditTextPreference {
    private String mDeviceName;

    public DeviceProfileRenamePreference(Context r1) {
        super(r1);
        setLayoutResource(R.layout.device_profile_rename_preference);
    }

    public DeviceProfileRenamePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLayoutResource(R.layout.device_profile_rename_preference);
    }

    public DeviceProfileRenamePreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setLayoutResource(R.layout.device_profile_rename_preference);
    }

    public void setSubtitle(String r1) {
        this.mDeviceName = r1;
        notifyChanged();
    }

    @Override // com.android.settings.CustomEditTextPreference
    protected void onBindDialogView(View r2) {
        super.onBindDialogView(r2);
        final EditText r3 = getEditText();
        if (r3 != null) goto L5;
        return;
    L5:
        r3.post(new AnonymousClass1(this, r3));
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        View r3 = r2.itemView;
        r3.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_single);
        TextView r4 = (TextView) r3.findViewById(R.id.subtitle);
        String r1 = this.mDeviceName;
        if (r1 == null) goto L6;
        r4.setText(r1);
        return;
    }
}
