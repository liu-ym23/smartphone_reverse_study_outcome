package androidx.work.impl.workers;

import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.utils.futures.SettableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintTrackingWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ARGUMENT_CLASS_NAME", "", "TAG", "setFailed", "", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "setRetry", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ConstraintTrackingWorkerKt {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG = null;

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ boolean access$setFailed(SettableFuture r0) {
        return setFailed(r0);
    }

    public static final /* synthetic */ boolean access$setRetry(SettableFuture r0) {
        return setRetry(r0);
    }

    private static final boolean setFailed(SettableFuture<ListenableWorker.Result> r1) {
        return r1.set(ListenableWorker.Result.failure());
    }

    private static final boolean setRetry(SettableFuture<ListenableWorker.Result> r1) {
        return r1.set(ListenableWorker.Result.retry());
    }

    static {
        String r0 = Logger.tagWithPrefix("ConstraintTrkngWrkr");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        TAG = r0;
    }
}
