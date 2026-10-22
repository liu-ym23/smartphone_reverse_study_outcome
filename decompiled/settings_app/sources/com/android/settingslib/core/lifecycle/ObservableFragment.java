package com.android.settingslib.core.lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ObservableFragment extends Fragment implements LifecycleOwner {
    private final Lifecycle mLifecycle;

    public ObservableFragment() {
        this.mLifecycle = new Lifecycle(this);
    }

    public Lifecycle getSettingsLifecycle() {
        return this.mLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        this.mLifecycle.onAttach(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        this.mLifecycle.onCreate(r3);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mLifecycle.onSaveInstanceState(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
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
