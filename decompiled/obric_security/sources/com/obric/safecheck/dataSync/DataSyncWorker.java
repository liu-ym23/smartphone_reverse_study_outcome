package com.obric.safecheck.dataSync;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.obric.matrix.platform.sdk.ones.internal.monitor.EventConstants;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.miitAntiFraud.MiitAntiFraudUpdateRequester;
import com.obric.securitycenter.api.TrackUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DataSyncWorker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/dataSync/DataSyncWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getContext", "()Landroid/content/Context;", "doWork", "Landroidx/work/ListenableWorker$Result;", "syncLargeDataFromServer", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DataSyncWorker extends Worker {
    private final Context context;

    public DataSyncWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(r2, r3);
        this.context = r2;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        syncLargeDataFromServer(this.context);     // Catch: Throwable -> L5
        ListenableWorker.Result r1 = ListenableWorker.Result.success();     // Catch: Throwable -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "Result.success()");     // Catch: Throwable -> L5
        return r1;
    L5:
        th = move-exception;
        AntiFraudApiClient.getInstance().taskDoing = false;
        String r4 = Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName();     // Catch: Throwable -> L12
        String r5 = th.getMessage();     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = "无具体异常消息";
    L10:
        StackTraceElement[] r2 = th.getStackTrace();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "e.stackTrace");     // Catch: Throwable -> L12
        String r0 = ("异常类型：" + r4 + "，异常消息：" + r5) + ", Trace= " + CollectionsKt.joinToString$default(ArraysKt.take(r2, 3), IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null);     // Catch: Throwable -> L12
    L13:
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "antiFraud_data_sync_task", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", "fail"), TuplesKt.to(EventConstants.EVENT_KEY_ERROR_MESSAGE, r0)}), false, 4, null);
        if (getRunAttemptCount() >= 3) goto L16;
        ListenableWorker.Result r13 = ListenableWorker.Result.retry();
    L17:
        ListenableWorker.Result r3 = r13;
        Intrinsics.checkNotNullExpressionValue(r3, "if (runAttemptCount < 3)…t.failure()\n            }");
        return r3;
    L16:
        r13 = ListenableWorker.Result.failure();
    L12:
        r0 = "error";
        goto L13
    }

    private final void syncLargeDataFromServer(Context r1) {
        OLog.d("WorkManagerHelper_AntiFraud", "syncLargeDataFromServer: start");
        AntiFraudApiClient.getInstance().getAntiFraudDataAsync("DataSyncWorker");
        MiitAntiFraudUpdateRequester.requestUpdateList$default(null, 1, null);
    }
}
