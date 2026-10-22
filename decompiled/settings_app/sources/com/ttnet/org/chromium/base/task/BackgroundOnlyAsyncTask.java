package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BackgroundOnlyAsyncTask<Result> extends AsyncTask<Result> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static {
    }

    @Override // com.ttnet.org.chromium.base.task.AsyncTask
    protected final void onPostExecute(Result r1) {
    }

    public BackgroundOnlyAsyncTask() {
    }
}
