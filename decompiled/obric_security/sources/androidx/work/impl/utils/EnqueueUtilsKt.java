package androidx.work.impl.utils;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.impl.workers.ConstraintTrackingWorkerKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EnqueueUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001e\u0010\n\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u000b"}, d2 = {"tryDelegateConstrainedWorkSpec", "Landroidx/work/impl/model/WorkSpec;", "workSpec", "usesScheduler", "", "schedulers", "", "Landroidx/work/impl/Scheduler;", "className", "", "wrapInConstraintTrackingWorkerIfNeeded", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EnqueueUtilsKt {
    public static final WorkSpec wrapInConstraintTrackingWorkerIfNeeded(List<? extends Scheduler> r1, WorkSpec r2) {
        Intrinsics.checkNotNullParameter(r1, "schedulers");
        Intrinsics.checkNotNullParameter(r2, "workSpec");
        return r2;
    }

    public static final WorkSpec tryDelegateConstrainedWorkSpec(WorkSpec r30) {
        Intrinsics.checkNotNullParameter(r30, "workSpec");
        Constraints r1 = r30.constraints;
        String r2 = r30.workerClassName;
        if (Intrinsics.areEqual(r2, ConstraintTrackingWorker.class.getName()) == false) goto L5;
        return r30;
    L5:
        if (r1.requiresBatteryNotLow() == false) goto L7;
    L8:
        Data r3 = new Data.Builder().putAll(r30.input).putString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME, r2).build();
        Intrinsics.checkNotNullExpressionValue(r3, "Builder().putAll(workSpe…ame)\n            .build()");
        String r4 = ConstraintTrackingWorker.class.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "name");
        return WorkSpec.copy$default(r30, null, null, r4, null, r3, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, 1048555, null);
    L7:
        if (r1.requiresStorageNotLow() == true) goto L8;
        return r30;
    }

    private static final boolean usesScheduler(List<? extends Scheduler> r2, String r3) {
        Class<?> r4 = Class.forName(r3);     // Catch: ClassNotFoundException -> L15
        List<? extends Scheduler> r5 = r2;     // Catch: ClassNotFoundException -> L15
        if ((r5 instanceof Collection) == true) goto L6;
    L8:
        Iterator<T> r6 = r5.iterator();     // Catch: ClassNotFoundException -> L15
    L9:
        if (r6.hasNext() == false) goto L23;
        if (r4.isAssignableFrom(((Scheduler) r6.next()).getClass()) == false) goto L9;
        return true;
    L23:
        return false;
    L6:
        if (r5.isEmpty() == false) goto L8;
        return false;
    L22:
        return false;
    }
}
