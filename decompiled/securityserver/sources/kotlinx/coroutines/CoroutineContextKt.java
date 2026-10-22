package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.SystemPropsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f366a = false;

    static {
        String r0 = SystemPropsKt.c("kotlinx.coroutines.scheduler");
        if (r0 == null) goto L19;
        int r1 = r0.hashCode();
        if (r1 == 0) goto L18;
        if (r1 == 3551) goto L15;
        if (r1 != 109935) goto L23;
        if (r0.equals("off") == false) goto L23;
        boolean r2 = false;
    L20:
        f366a = r2;
        return;
    L23:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + r0 + '\'').toString());
    L15:
        if (r0.equals("on") == false) goto L23;
    L18:
        if (r0.equals("") == false) goto L23;
    L19:
        r2 = true;
        goto L20
    }

    public static final CoroutineContext a(CoroutineScope r2, CoroutineContext r3) {
        CoroutineContext r4 = r2.A().i(r3);
        if (DebugKt.f370a == false) goto L5;
        CoroutineContext r5 = r4.i(new CoroutineId(DebugKt.c.incrementAndGet()));
    L6:
        ExecutorCoroutineDispatcher r0 = Dispatchers.f372a;
        if (r4 != r0) goto L9;
        return r5;
    L9:
        if (r4.f(ContinuationInterceptor.Key.f336a) == null) goto L11;
        return r5;
    L11:
        return r5.i(r0);
    L5:
        r5 = r4;
        goto L6
    }
}
