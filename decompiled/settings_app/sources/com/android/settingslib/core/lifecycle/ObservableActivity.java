package com.android.settingslib.core.lifecycle;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public class ObservableActivity extends FragmentActivity implements LifecycleOwner {
    private final Lifecycle mLifecycle;

    public ObservableActivity() {
        this.mLifecycle = new Lifecycle(this);
    }

    public Lifecycle getSettingsLifecycle() {
        return this.mLifecycle;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        this.mLifecycle.onAttach(this);
        this.mLifecycle.onCreate(r3);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r3);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r3, PersistableBundle r4) {
        this.mLifecycle.onAttach(this);
        this.mLifecycle.onCreate(r3);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r3, r4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r2) {
        if (super.onCreateOptionsMenu(r2) == false) goto L6;
        this.mLifecycle.onCreateOptionsMenu(r2, null);
        return true;
    L6:
        return false;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r2) {
        if (super.onPrepareOptionsMenu(r2) == false) goto L6;
        this.mLifecycle.onPrepareOptionsMenu(r2);
        return true;
    L6:
        return false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r2) {
        boolean r0 = this.mLifecycle.onOptionsItemSelected(r2);
        if (r0 == false) goto L5;
        return r0;
    L5:
        return super.onOptionsItemSelected(r2);
    }
}
