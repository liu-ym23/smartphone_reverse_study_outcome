package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class EventLoop_commonKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f373a = null;
    public static final Symbol b = null;

    static {
        f373a = new Symbol("REMOVED_TASK");
        b = new Symbol("CLOSED_EMPTY");
    }

    public static final long a(long r3) {
        if (r3 > 0) goto L6;
        return 0;
    L6:
        if (r3 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return 1000000 * r3;
    }
}
