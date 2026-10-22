package kotlinx.coroutines.debug.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ConcurrentWeakMap$entries$1 extends Lambda implements Function2<Object, Object, Map.Entry<Object, Object>> {
    public static final ConcurrentWeakMap$entries$1 b = null;

    static {
        b = new ConcurrentWeakMap$entries$1(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return new ConcurrentWeakMap.Entry(r1, r2);
    }
}
