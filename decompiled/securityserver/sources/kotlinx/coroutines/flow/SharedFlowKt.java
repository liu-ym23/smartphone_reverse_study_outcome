package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SharedFlowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f397a = null;

    static {
        f397a = new Symbol("NO_VALUE");
    }

    public static final void a(Object[] r0, long r1, Object r3) {
        r0[((int) r1) & (r0.length - 1)] = r3;
    }

    public static final Flow b(SharedFlow r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        if (r3 == 0) goto L6;
        if (r3 == (-3)) goto L6;
    L9:
        return new ChannelFlowOperatorImpl(r1, r2, r3, r4);
    L6:
        if (r4 != BufferOverflow.b) goto L9;
        return r1;
    }
}
