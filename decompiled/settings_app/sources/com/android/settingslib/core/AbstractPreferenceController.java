package com.android.settingslib.core;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractPreferenceController {
    private static final String TAG = "AbstractPrefController";
    protected final Context mContext;
    private final DevicePolicyManager mDevicePolicyManager;

    public abstract String getPreferenceKey();

    public CharSequence getSummary() {
        return null;
    }

    public boolean handlePreferenceTreeClick(Preference r1) {
        return false;
    }

    public abstract boolean isAvailable();

    public void onViewCreated(LifecycleOwner r1) {
    }

    public AbstractPreferenceController(Context r2) {
        this.mContext = r2;
        this.mDevicePolicyManager = (DevicePolicyManager) r2.getSystemService("device_policy");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void displayPreference(PreferenceScreen r3) {
        String r0 = getPreferenceKey();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Skipping displayPreference because key is empty:" + getClass().getName());
        return;
    L7:
        if (isAvailable() == false) goto L13;
        setVisible(r3, r0, true);
        if ((this instanceof Preference.OnPreferenceChangeListener) == false) goto L15;
        Preference r4 = r3.findPreference(r0);
        if (r4 == null) goto L16;
        r4.setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener) this);
        return;
    L16:
        return;
    L15:
        return;
    L13:
        setVisible(r3, r0, false);
    }

    public void updateState(Preference r1) {
        refreshSummary(r1);
    }

    protected void refreshSummary(Preference r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        CharSequence r0 = getSummary();
        if (r0 != null) goto L7;
        return;
    L7:
        r1.setSummary(r0);
    }

    protected final void setVisible(PreferenceGroup r1, String r2, boolean r3) {
        Preference r0 = r1.findPreference(r2);
        if (r0 == null) goto L6;
        r0.setVisible(r3);
        return;
    }

    protected void replaceEnterpriseStringTitle(PreferenceScreen r2, String r3, String r4, final int r5) {
        if (BuildCompat.isAtLeastT() == true) goto L5;
        return;
    L5:
        if (this.mDevicePolicyManager == null) goto L14;
        Preference r6 = r2.findPreference(r3);
        if (r6 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Could not find enterprise preference " + r3);
        return;
    L11:
        r6.setTitle(this.mDevicePolicyManager.getResources().getString(r4, new AbstractPreferenceController$$ExternalSyntheticLambda1(this, r5)));
        return;
    }

    /* JADX INFO: renamed from: lambda$replaceEnterpriseStringTitle$0$com-android-settingslib-core-AbstractPreferenceController, reason: not valid java name */
    /* synthetic */ String m754x18600569(int r1) {
        return this.mContext.getString(r1);
    }

    protected void replaceEnterpriseStringSummary(PreferenceScreen r2, String r3, String r4, final int r5) {
        if (BuildCompat.isAtLeastT() == true) goto L5;
        return;
    L5:
        if (this.mDevicePolicyManager == null) goto L14;
        Preference r6 = r2.findPreference(r3);
        if (r6 != null) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Could not find enterprise preference " + r3);
        return;
    L11:
        r6.setSummary(this.mDevicePolicyManager.getResources().getString(r4, new AbstractPreferenceController$$ExternalSyntheticLambda0(this, r5)));
        return;
    }

    /* JADX INFO: renamed from: lambda$replaceEnterpriseStringSummary$1$com-android-settingslib-core-AbstractPreferenceController, reason: not valid java name */
    /* synthetic */ String m753xd7384cb8(int r1) {
        return this.mContext.getString(r1);
    }
}
