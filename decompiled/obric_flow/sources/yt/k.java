package yt;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23345a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f23346b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f23347c = 0;
    public static final int d = 0;
    public static final long e = 0;
    public static final g f = null;

    static {
        int r5 = u.f18952a;
        String r10 = System.getProperty("kotlinx.coroutines.scheduler.default.name");     // Catch: SecurityException -> L5
    L6:
        if (r10 != null) goto L8;
        r10 = "DefaultDispatcher";
    L8:
        f23345a = r10;
        f23346b = kotlinx.coroutines.internal.f.i(100000, 1, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        f23347c = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(u.f18952a, 2), 1, 0, 8);
        d = kotlinx.coroutines.internal.f.j("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        e = TimeUnit.SECONDS.toNanos(kotlinx.coroutines.internal.f.i(60, 1, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f = g.f23340a;
        return;
    L5:
        r10 = null;
        goto L6
    }
}
