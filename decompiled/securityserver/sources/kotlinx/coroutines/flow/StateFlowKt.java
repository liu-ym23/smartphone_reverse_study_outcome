package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StateFlowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f400a = null;
    public static final Symbol b = null;

    static {
        f400a = new Symbol("NONE");
        b = new Symbol("PENDING");
    }

    public static final MutableStateFlow a(Object r1) {
        if (r1 != null) goto L7;
        r1 = NullSurrogateKt.f403a;
    L7:
        return new StateFlowImpl(r1);
    }

    public static final void b(MutableStateFlow r3, int r4) {
    L2:
        StateFlowImpl r0 = (StateFlowImpl) r3;
        int r1 = ((Number) r0.h()).intValue();
        if (r0.i(Integer.valueOf(r1), Integer.valueOf(r1 + r4)) == false) goto L2;
    }
}
