package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        Integer r0 = Integer.valueOf(((Constructor) r2).getParameterTypes().length);
        Integer r3 = Integer.valueOf(((Constructor) r1).getParameterTypes().length);
        if (r0 != r3) goto L6;
        return 0;
    L6:
        return r0.compareTo(r3);
    }
}
