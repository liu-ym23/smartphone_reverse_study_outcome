package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdGenerator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/work/impl/utils/IdGenerator;", "", "workDatabase", "Landroidx/work/impl/WorkDatabase;", "(Landroidx/work/impl/WorkDatabase;)V", "nextAlarmManagerId", "", "nextJobSchedulerIdWithRange", "minInclusive", "maxInclusive", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IdGenerator {
    private final WorkDatabase workDatabase;

    public static /* synthetic */ Integer $r8$lambda$LyUC9fmKDw6AhARQq6V7VCdkafU(IdGenerator r0, int r1, int r2) {
        return nextJobSchedulerIdWithRange$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$fIl4yTd4RSvtLPTyoZbhi4q3Rnk(IdGenerator r0) {
        return nextAlarmManagerId$lambda$1(r0);
    }

    public IdGenerator(WorkDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "workDatabase");
        this.workDatabase = r2;
    }

    public final int nextJobSchedulerIdWithRange(final int r3, final int r4) {
        Object r2 = this.workDatabase.runInTransaction(new IdGenerator$$ExternalSyntheticLambda1(this, r3, r4));
        Intrinsics.checkNotNullExpressionValue(r2, "workDatabase.runInTransa…            id\n        })");
        return ((Number) r2).intValue();
    }

    private static final Integer nextJobSchedulerIdWithRange$lambda$0(IdGenerator r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        int r0 = IdGeneratorKt.access$nextId(r3.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY);
        boolean r2 = false;
        if (r4 > r0) goto L6;
        if (r0 > r5) goto L6;
        r2 = true;
    L6:
        if (r2 == true) goto L8;
        IdGeneratorKt.access$updatePreference(r3.workDatabase, IdGeneratorKt.NEXT_JOB_SCHEDULER_ID_KEY, r4 + 1);
    L10:
        return Integer.valueOf(r4);
    L8:
        r4 = r0;
        goto L10
    }

    public final int nextAlarmManagerId() {
        Object r2 = this.workDatabase.runInTransaction(new IdGenerator$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(r2, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) r2).intValue();
    }

    private static final Integer nextAlarmManagerId$lambda$1(IdGenerator r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return Integer.valueOf(IdGeneratorKt.access$nextId(r1.workDatabase, IdGeneratorKt.NEXT_ALARM_MANAGER_ID_KEY));
    }
}
