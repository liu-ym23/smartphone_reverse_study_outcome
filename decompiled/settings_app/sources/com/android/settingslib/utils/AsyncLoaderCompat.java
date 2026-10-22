package com.android.settingslib.utils;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncLoaderCompat<T> extends AsyncTaskLoader<T> {
    private T mResult;

    protected abstract void onDiscardResult(T r1);

    public AsyncLoaderCompat(Context r1) {
        super(r1);
    }

    @Override // androidx.loader.content.Loader
    protected void onStartLoading() {
        T r0 = this.mResult;
        if (r0 == null) goto L6;
        deliverResult(r0);
    L6:
        if (takeContentChanged() == false) goto L8;
    L9:
        forceLoad();
        return;
    L8:
        if (this.mResult == null) goto L9;
    }

    @Override // androidx.loader.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override // androidx.loader.content.Loader
    public void deliverResult(T r3) {
        if (isReset() == false) goto L7;
        if (r3 == null) goto L15;
        onDiscardResult(r3);
        return;
    L15:
        return;
    L7:
        T r0 = this.mResult;
        this.mResult = r3;
        if (isStarted() == false) goto L10;
        super.deliverResult(r3);
    L10:
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0 == this.mResult) goto L17;
        onDiscardResult(r0);
        return;
    }

    @Override // androidx.loader.content.Loader
    protected void onReset() {
        super.onReset();
        onStopLoading();
        T r0 = this.mResult;
        if (r0 == null) goto L5;
        onDiscardResult(r0);
    L5:
        this.mResult = null;
    }

    @Override // androidx.loader.content.AsyncTaskLoader
    public void onCanceled(T r1) {
        super.onCanceled(r1);
        if (r1 == null) goto L6;
        onDiscardResult(r1);
        return;
    }
}
