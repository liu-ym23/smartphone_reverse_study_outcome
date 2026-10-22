package com.android.settingslib.suggestions;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.service.settings.suggestions.Suggestion;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.android.settingslib.core.lifecycle.Lifecycle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionControllerMixinCompat implements SuggestionController.ServiceConnectionListener, LifecycleObserver, LoaderManager.LoaderCallbacks<List<Suggestion>> {
    private static final boolean DEBUG = false;
    private static final String TAG = "SuggestionCtrlMixin";
    private final Context mContext;
    private final SuggestionControllerHost mHost;
    private final SuggestionController mSuggestionController;
    private boolean mSuggestionLoaded;

    public interface SuggestionControllerHost {
        LoaderManager getLoaderManager();

        void onSuggestionReady(List<Suggestion> r1);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public /* bridge */ /* synthetic */ void onLoadFinished(Loader<List<Suggestion>> r1, List<Suggestion> r2) {
        onLoadFinished2(r1, r2);
    }

    public SuggestionControllerMixinCompat(Context r1, SuggestionControllerHost r2, Lifecycle r3, ComponentName r4) {
        Context r5 = r1.getApplicationContext();
        this.mContext = r5;
        this.mHost = r2;
        this.mSuggestionController = new SuggestionController(r5, r4, this);
        if (r3 == null) goto L6;
        r3.addObserver(this);
        return;
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    public void onStart() {
        this.mSuggestionController.start();
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.mSuggestionController.stop();
    }

    @Override // com.android.settingslib.suggestions.SuggestionController.ServiceConnectionListener
    public void onServiceConnected() {
        LoaderManager r0 = this.mHost.getLoaderManager();
        if (r0 == null) goto L6;
        r0.restartLoader(42, null, this);
        return;
    }

    @Override // com.android.settingslib.suggestions.SuggestionController.ServiceConnectionListener
    public void onServiceDisconnected() {
        LoaderManager r1 = this.mHost.getLoaderManager();
        if (r1 == null) goto L6;
        r1.destroyLoader(42);
        return;
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public Loader<List<Suggestion>> onCreateLoader(int r2, Bundle r3) {
        if (r2 != 42) goto L7;
        this.mSuggestionLoaded = false;
        return new SuggestionLoaderCompat(this.mContext, this.mSuggestionController);
    L7:
        throw new IllegalArgumentException("This loader id is not supported " + r2);
    }

    /* JADX INFO: renamed from: onLoadFinished, reason: avoid collision after fix types in other method */
    public void onLoadFinished2(Loader<List<Suggestion>> r1, List<Suggestion> r2) {
        this.mSuggestionLoaded = true;
        this.mHost.onSuggestionReady(r2);
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<List<Suggestion>> r1) {
        this.mSuggestionLoaded = false;
    }

    public boolean isSuggestionLoaded() {
        return this.mSuggestionLoaded;
    }

    public void dismissSuggestion(Suggestion r1) {
        this.mSuggestionController.dismissSuggestions(r1);
    }

    public void launchSuggestion(Suggestion r1) {
        this.mSuggestionController.launchSuggestion(r1);
    }
}
