package com.android.settings;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class ApnPreference extends Preference implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    static final String TAG = "ApnPreference";
    private static CompoundButton mCurrentChecked;
    private static String mSelectedKey;
    private boolean mApnReadOnly;
    private boolean mProtectFromCheckedChange;
    private boolean mSelectable;

    static {
    }

    public ApnPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mProtectFromCheckedChange = false;
        this.mSelectable = true;
        this.mApnReadOnly = false;
    }

    public ApnPreference(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.apnPreferenceStyle);
    }

    public ApnPreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r4) {
        super.onBindViewHolder(r4);
        View r0 = r4.findViewById(R.id.apn_radiobutton);
        if (r0 != null) goto L5;
    L13:
        View r5 = r4.findViewById(R.id.text_layout);
        if (r5 != null) goto L16;
        return;
    L16:
        if ((r5 instanceof RelativeLayout) == false) goto L20;
        r5.setOnClickListener(this);
        return;
    L20:
        return;
    L5:
        if ((r0 instanceof RadioButton) == false) goto L13;
        RadioButton r1 = (RadioButton) r0;
        if (this.mSelectable == false) goto L12;
        r1.setOnCheckedChangeListener(this);
        boolean r2 = getKey().equals(mSelectedKey);
        if (r2 == false) goto L11;
        mCurrentChecked = r1;
        mSelectedKey = getKey();
    L11:
        this.mProtectFromCheckedChange = true;
        r1.setChecked(r2);
        this.mProtectFromCheckedChange = false;
        r1.setVisibility(0);
        goto L13
    L12:
        r1.setVisibility(8);
        goto L13
    }

    public boolean isChecked() {
        return getKey().equals(mSelectedKey);
    }

    public void setChecked() {
        mSelectedKey = getKey();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        OLog.i(TAG, "ID: " + getKey() + " :" + r4);
        if (this.mProtectFromCheckedChange == false) goto L5;
        return;
    L5:
        if (r4 == false) goto L10;
        CompoundButton r5 = mCurrentChecked;
        if (r5 == null) goto L9;
        r5.setChecked(false);
    L9:
        mCurrentChecked = r3;
        String r6 = getKey();
        mSelectedKey = r6;
        callChangeListener(r6);
        return;
    L10:
        mCurrentChecked = null;
        mSelectedKey = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (R.id.text_layout != r5.getId()) goto L10;
        Context r6 = getContext();
        if (r6 == null) goto L11;
        Intent r1 = new Intent("android.intent.action.EDIT", ContentUris.withAppendedId(Telephony.Carriers.CONTENT_URI, Integer.parseInt(getKey())));
        r1.putExtra("DISABLE_EDITOR", this.mApnReadOnly);
        r6.startActivity(r1);
        return;
    L11:
        return;
    }

    @Override // androidx.preference.Preference
    public void setSelectable(boolean r1) {
        this.mSelectable = r1;
    }

    public boolean getSelectable() {
        return this.mSelectable;
    }

    public void setApnReadOnly(boolean r1) {
        this.mApnReadOnly = r1;
    }
}
