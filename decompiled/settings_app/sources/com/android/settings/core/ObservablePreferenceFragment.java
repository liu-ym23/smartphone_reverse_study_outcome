package com.android.settings.core;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.LifecycleOwner;
import androidx.preference.PreferenceScreen;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settingslib.core.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public class ObservablePreferenceFragment extends SettingsPreferenceFragment implements LifecycleOwner {
    private final Lifecycle mLifecycle;

    public ObservablePreferenceFragment() {
        this.mLifecycle = new Lifecycle(this);
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ androidx.lifecycle.Lifecycle getLifecycle() {
        return getLifecycle();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    public Lifecycle getSettingsLifecycle() {
        return this.mLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mLifecycle.onAttach(r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        this.mLifecycle.onCreate(r3);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r3);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat
    public void setPreferenceScreen(PreferenceScreen r2) {
        this.mLifecycle.setPreferenceScreen(r2);
        super.setPreferenceScreen(r2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mLifecycle.onSaveInstanceState(r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r2, MenuInflater r3) {
        this.mLifecycle.onCreateOptionsMenu(r2, r3);
        super.onCreateOptionsMenu(r2, r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu r2) {
        this.mLifecycle.onPrepareOptionsMenu(r2);
        super.onPrepareOptionsMenu(r2);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r2) {
        boolean r0 = this.mLifecycle.onOptionsItemSelected(r2);
        if (r0 == false) goto L5;
        return r0;
    L5:
        return super.onOptionsItemSelected(r2);
    }
}
