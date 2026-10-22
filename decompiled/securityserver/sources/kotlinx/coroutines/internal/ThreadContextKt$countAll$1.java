package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ThreadContextKt$countAll$1 extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {
    public static final ThreadContextKt$countAll$1 b = null;

    static {
        b = new ThreadContextKt$countAll$1(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        CoroutineContext.Element r3 = (CoroutineContext.Element) r2;
        if ((r3 instanceof ThreadContextElement) == true) goto L5;
        return r1;
    L5:
        if ((r1 instanceof Integer) == true) goto L7;
        r1 = null;
    L7:
        Integer r4 = (Integer) r1;
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
    L11:
        if (r5 != 0) goto L14;
        return r3;
    L14:
        return Integer.valueOf(r5 + 1);
    L10:
        r5 = 1;
        goto L11
    }
}
