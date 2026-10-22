package com.bytedanceos.preventdisturb.widget;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import obric.app.ProgressDialog;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncDialog {
    private final Activity mActivity;
    private final Handler mHandler;
    private final boolean mIsKeyguardMode;
    private ProgressDialog mProgressDialog;
    private Runnable mShowProgressDialogRunnable;

    private class ModalDialogAsyncTask extends AsyncTask<Runnable, Void, Void> {
        final Runnable mPostExecuteTask;
        final /* synthetic */ AsyncDialog this$0;

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Runnable[] params) {
            return doInBackground2(params);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void result) {
            onPostExecute2(result);
        }

        public ModalDialogAsyncTask(final AsyncDialog this$0, int dialogStringId, final Runnable postExecuteTask) {
            this.this$0 = this$0;
            this.mPostExecuteTask = postExecuteTask;
            if (AsyncDialog.access$000(this$0) != null) goto L5;
            AsyncDialog.access$002(this$0, createProgressDialog());
        L5:
            if (dialogStringId <= 0) goto L7;
            AsyncDialog.access$000(this$0).setMessage(AsyncDialog.access$100(this$0).getText(dialogStringId));
            return;
        L7:
            AsyncDialog.access$000(this$0).setMessage(null);
        }

        private ProgressDialog createProgressDialog() {
            if (AsyncDialog.access$200(this.this$0) == false) goto L5;
            Context r1 = AsyncDialog.access$100(this.this$0).getApplicationContext();
        L6:
            ProgressDialog r0 = new ProgressDialog(r1);
            if (AsyncDialog.access$200(this.this$0) == false) goto L9;
            r0.getWindow().setType(2020);
        L9:
            r0.setCanceledOnTouchOutside(false);
            r0.setCancelable(false);
            return r0;
        L5:
            r1 = AsyncDialog.access$100(this.this$0);
            goto L6
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            AsyncDialog.access$400(this.this$0).postDelayed(AsyncDialog.access$300(this.this$0), 500);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Runnable... params) {
            if (params == null) goto L12;
            int r0 = 0;
        L14:
        L9:
            th = move-exception;
            AsyncDialog.access$400(this.this$0).removeCallbacks(AsyncDialog.access$300(this.this$0));
            throw th;
        L5:
            if (r0 >= params.length) goto L8;
            params[r0].run();     // Catch: Throwable -> L9
            r0 = r0 + 1;
            goto L14
        L8:
            AsyncDialog.access$400(this.this$0).removeCallbacks(AsyncDialog.access$300(this.this$0));
            return null;
        L12:
            return null;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void result) {
            if (AsyncDialog.access$100(this.this$0).isFinishing() == false) goto L6;
            return;
        L6:
            if (AsyncDialog.access$000(this.this$0) != null) goto L8;
        L10:
            Runnable r0 = this.mPostExecuteTask;
            if (r0 == null) goto L14;
            r0.run();
            return;
        L14:
            return;
        L8:
            if (AsyncDialog.access$000(this.this$0).isShowing() == false) goto L10;
            AsyncDialog.access$000(this.this$0).dismiss();
            goto L10
        }
    }

    static /* synthetic */ ProgressDialog access$000(AsyncDialog r0) {
        return r0.mProgressDialog;
    }

    static /* synthetic */ ProgressDialog access$002(AsyncDialog r0, ProgressDialog r1) {
        r0.mProgressDialog = r1;
        return r1;
    }

    static /* synthetic */ Activity access$100(AsyncDialog r0) {
        return r0.mActivity;
    }

    static /* synthetic */ boolean access$200(AsyncDialog r0) {
        return r0.mIsKeyguardMode;
    }

    static /* synthetic */ Runnable access$300(AsyncDialog r0) {
        return r0.mShowProgressDialogRunnable;
    }

    static /* synthetic */ Handler access$400(AsyncDialog r0) {
        return r0.mHandler;
    }

    public AsyncDialog(Activity activity) {
        this(activity, false);
    }

    public AsyncDialog(Activity activity, boolean isKeyguard) {
        this.mShowProgressDialogRunnable = new AnonymousClass1(this);
        this.mActivity = activity;
        this.mHandler = new Handler();
        this.mIsKeyguardMode = isKeyguard;
    }

    public void runAsync(final Runnable backgroundTask, final Runnable postExecuteTask, final int dialogStringId) {
        new ModalDialogAsyncTask(this, dialogStringId, postExecuteTask).execute(new Runnable[]{backgroundTask});
    }

    public void clearPendingProgressDialog() {
        this.mHandler.removeCallbacks(this.mShowProgressDialogRunnable);
        this.mProgressDialog = null;
    }

    public void dismissProgressDialog() {
        ProgressDialog r0 = this.mProgressDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }
}
