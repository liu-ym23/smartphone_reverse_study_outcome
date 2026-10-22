package com.android.settingslib.utils;

import android.content.AsyncTaskLoader;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class AsyncLoader<T> extends AsyncTaskLoader<T> {
    private T mResult;

    protected abstract void onDiscardResult(T r1);

    public AsyncLoader(Context r1) {
        super(r1);
    }

    @Override // android.content.Loader
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

    @Override // android.content.Loader
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override // android.content.Loader
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

    @Override // android.content.Loader
    protected void onReset() {
        super.onReset();
        onStopLoading();
        T r0 = this.mResult;
        if (r0 == null) goto L5;
        onDiscardResult(r0);
    L5:
        this.mResult = null;
    }

    @Override // android.content.AsyncTaskLoader
    public void onCanceled(T r1) {
        super.onCanceled(r1);
        if (r1 == null) goto L6;
        onDiscardResult(r1);
        return;
    }
}
