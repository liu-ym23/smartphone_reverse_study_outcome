package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TasksKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f433a = 0;
    public static final int b = 0;
    public static final int c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f434d = 0;
    public static final NanoTimeSource e = null;

    static {
        f433a = SystemPropsKt.b(100000, "kotlinx.coroutines.scheduler.resolution.ns", 1, Long.MAX_VALUE);
        SystemPropsKt.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12);
        int r0 = SystemPropsKt.a();
        if (r0 >= 2) goto L5;
        r0 = 2;
    L5:
        int r1 = SystemPropsKt.d("kotlinx.coroutines.scheduler.core.pool.size", r0, 1, 0, 8);
        b = r1;
        c = SystemPropsKt.d("kotlinx.coroutines.scheduler.max.pool.size", RangesKt.b(SystemPropsKt.a() * 128, r1, 2097150), 0, 2097150, 4);
        f434d = TimeUnit.SECONDS.toNanos(SystemPropsKt.b(60, "kotlinx.coroutines.scheduler.keep.alive.sec", 1, Long.MAX_VALUE));
        e = NanoTimeSource.f432a;
    }
}
