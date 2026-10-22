package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String TAG = null;

    public DiagnosticsReceiver() {
    }

    static {
        TAG = Logger.tagWithPrefix("DiagnosticsRcvr");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) goto L4;
        return;
    L4:
        Logger.get().debug(TAG, "Requesting diagnostics");
        WorkManager.getInstance(context).enqueue(OneTimeWorkRequest.from(DiagnosticsWorker.class));     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        Logger.get().error(TAG, "WorkManager is not initialized", e);
    }
}
