package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SemaphoreKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f448a = 0;
    public static final Symbol b = null;
    public static final Symbol c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Symbol f449d = null;
    public static final Symbol e = null;
    public static final int f = 0;

    static {
        f448a = SystemPropsKt.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12);
        b = new Symbol("PERMIT");
        c = new Symbol("TAKEN");
        f449d = new Symbol("BROKEN");
        e = new Symbol("CANCELLED");
        f = SystemPropsKt.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12);
    }

    public static Semaphore a(int r2) {
        return new SemaphoreImpl(r2, 0);
    }
}
