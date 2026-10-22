package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiagnosticsWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Landroidx/work/impl/workers/DiagnosticsWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "parameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(Context r2, WorkerParameters r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "parameters");
        super(r2, r3);
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        WorkManagerImpl r8 = WorkManagerImpl.getInstance(getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(r8, "getInstance(applicationContext)");
        WorkDatabase r9 = r8.getWorkDatabase();
        Intrinsics.checkNotNullExpressionValue(r9, "workManager.workDatabase");
        WorkSpecDao r0 = r9.workSpecDao();
        WorkNameDao r1 = r9.workNameDao();
        WorkTagDao r2 = r9.workTagDao();
        SystemIdInfoDao r10 = r9.systemIdInfoDao();
        List<WorkSpec> r3 = r0.getRecentlyCompletedWork(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        List<WorkSpec> r4 = r0.getRunningWork();
        List<WorkSpec> r5 = r0.getAllEligibleWorkSpecsForScheduling(200);
        if ((!r3.isEmpty()) == false) goto L6;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Recently completed work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r1, r2, r10, r3));
    L6:
        if ((!r4.isEmpty()) == false) goto L9;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Running work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r1, r2, r10, r4));
    L9:
        if ((!r5.isEmpty()) == false) goto L11;
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), "Enqueued work:\n\n");
        Logger.get().info(DiagnosticsWorkerKt.access$getTAG$p(), DiagnosticsWorkerKt.access$workSpecRows(r1, r2, r10, r5));
    L11:
        ListenableWorker.Result r11 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(r11, "success()");
        return r11;
    }
}
