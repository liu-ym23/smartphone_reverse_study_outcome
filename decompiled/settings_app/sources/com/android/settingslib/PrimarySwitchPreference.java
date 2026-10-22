package com.android.settingslib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.core.instrumentation.SettingsJankMonitor;

/* JADX INFO: loaded from: classes.dex */
public class PrimarySwitchPreference extends RestrictedPreference {
    private boolean mChecked;
    private boolean mCheckedSet;
    private boolean mEnableSwitch;
    private CompoundButton mSwitch;

    public PrimarySwitchPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mEnableSwitch = true;
    }

    public PrimarySwitchPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mEnableSwitch = true;
    }

    public PrimarySwitchPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mEnableSwitch = true;
    }

    public PrimarySwitchPreference(Context r1) {
        super(r1);
        this.mEnableSwitch = true;
    }

    @Override // com.android.settingslib.widget.TwoTargetPreference
    protected int getSecondTargetResId() {
        return androidx.preference.R.layout.preference_widget_switch_compat;
    }

    @Override // com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        View r0 = r3.findViewById(android.R.id.widget_frame);
        if ((r0 instanceof LinearLayout) == false) goto L5;
        ((LinearLayout) r0).setGravity(8388629);
    L5:
        CompoundButton r4 = (CompoundButton) r3.findViewById(androidx.preference.R.id.switchWidget);
        this.mSwitch = r4;
        if (r4 == null) goto L9;
        r4.setOnClickListener(new PrimarySwitchPreference$$ExternalSyntheticLambda0(this));
        this.mSwitch.setOnTouchListener(new PrimarySwitchPreference$$ExternalSyntheticLambda1());
        this.mSwitch.setContentDescription(getTitle());
        this.mSwitch.setChecked(this.mChecked);
        this.mSwitch.setEnabled(this.mEnableSwitch);
        return;
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settingslib-PrimarySwitchPreference, reason: not valid java name */
    /* synthetic */ void m734x7457526e(View r3) {
        CompoundButton r4 = this.mSwitch;
        if (r4 != null) goto L5;
    L7:
        boolean r5 = !this.mChecked;
        if (callChangeListener(Boolean.valueOf(r5)) == false) goto L11;
        SettingsJankMonitor.detectToggleJank(getKey(), this.mSwitch);
        setChecked(r5);
        persistBoolean(r5);
        return;
    L11:
        return;
    L5:
        if (r4.isEnabled() == true) goto L7;
    }

    static /* synthetic */ boolean lambda$onBindViewHolder$1(View r0, MotionEvent r1) {
        if (r1.getActionMasked() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isChecked() {
        if (this.mSwitch != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mChecked == false) goto L7;
        return true;
    }

    public Boolean getCheckedState() {
        if (this.mCheckedSet == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(this.mChecked);
    }

    public void setChecked(boolean r3) {
        if (this.mChecked == r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L9:
        this.mChecked = r3;
        this.mCheckedSet = true;
        CompoundButton r2 = this.mSwitch;
        if (r2 == null) goto L14;
        r2.setChecked(r3);
        return;
    L14:
        return;
    L8:
        if (this.mCheckedSet == false) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setSwitchEnabled(boolean r1) {
        this.mEnableSwitch = r1;
        CompoundButton r0 = this.mSwitch;
        if (r0 == null) goto L6;
        r0.setEnabled(r1);
        return;
    }

    public boolean isSwitchEnabled() {
        return this.mEnableSwitch;
    }

    @Override // com.android.settingslib.RestrictedPreference
    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r1) {
        super.setDisabledByAdmin(r1);
        if (r1 != null) goto L5;
        boolean r2 = true;
    L6:
        setSwitchEnabled(r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public CompoundButton getSwitch() {
        return this.mSwitch;
    }

    @Override // com.android.settingslib.widget.TwoTargetPreference
    protected boolean shouldHideSecondTarget() {
        if (getSecondTargetResId() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
