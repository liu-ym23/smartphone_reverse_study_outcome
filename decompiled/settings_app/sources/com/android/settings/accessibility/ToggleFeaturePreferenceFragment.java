package com.android.settings.accessibility;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.widget.SwitchBar;
import com.android.settings.widget.ToggleSwitch;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ToggleFeaturePreferenceFragment extends SettingsPreferenceFragment {
    protected String mPreferenceKey;
    protected Intent mSettingsIntent;
    protected CharSequence mSettingsTitle;
    protected Preference mSummaryPreference;
    protected SwitchBar mSwitchBar;
    protected ToggleSwitch mToggleSwitch;

    protected void onInstallSwitchBarToggleSwitch() {
    }

    protected abstract void onPreferenceToggled(String r1, boolean r2);

    protected void onRemoveSwitchBarToggleSwitch() {
    }

    public ToggleFeaturePreferenceFragment() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        PreferenceScreen r4 = getPreferenceManager().createPreferenceScreen(getActivity());
        setPreferenceScreen(r4);
        final Context r1 = getPrefContext();
        Preference r0 = new AnonymousClass1(this, r1);
        this.mSummaryPreference = r0;
        r0.setSelectable(false);
        this.mSummaryPreference.setPersistent(false);
        this.mSummaryPreference.setLayoutResource(R.layout.text_description_preference);
        r4.addPreference(this.mSummaryPreference);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        SwitchBar r3 = ((SettingsActivity) getActivity()).getSwitchBar();
        this.mSwitchBar = r3;
        this.mToggleSwitch = r3.getSwitch();
        onProcessArguments(getArguments());
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        installActionBarToggleSwitch();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        removeActionBarToggleSwitch();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        super.onCreateOptionsMenu(r2, r3);
        CharSequence r4 = this.mSettingsTitle;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mSettingsIntent == null) goto L9;
        MenuItem r5 = r2.add(r4);
        r5.setShowAsAction(1);
        r5.setIntent(this.mSettingsIntent);
        return;
    }

    private void installActionBarToggleSwitch() {
        this.mSwitchBar.show();
        onInstallSwitchBarToggleSwitch();
    }

    private void removeActionBarToggleSwitch() {
        this.mToggleSwitch.setOnBeforeCheckedChangeListener(null);
        onRemoveSwitchBarToggleSwitch();
        this.mSwitchBar.hide();
    }

    public void setTitle(String r1) {
        getActivity().setTitle(r1);
    }

    protected void onProcessArguments(Bundle r3) {
        if (r3 != null) goto L5;
        getPreferenceScreen().removePreference(this.mSummaryPreference);
        return;
    L5:
        this.mPreferenceKey = r3.getString(AccessibilitySettings.EXTRA_PREFERENCE_KEY);
        if (r3.containsKey("checked") == false) goto L9;
        boolean r0 = r3.getBoolean("checked");
        this.mSwitchBar.setCheckedInternal(r0);
    L9:
        if (r3.containsKey("title") == false) goto L12;
        setTitle(r3.getString("title"));
    L12:
        if (r3.containsKey("summary") == false) goto L14;
        CharSequence r4 = r3.getCharSequence("summary");
        this.mSummaryPreference.setSummary(r4);
        return;
    L14:
        getPreferenceScreen().removePreference(this.mSummaryPreference);
    }
}
