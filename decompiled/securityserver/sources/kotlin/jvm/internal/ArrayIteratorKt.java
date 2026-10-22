package kotlin.jvm.internal;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ArrayIteratorKt {
    public static final Iterator a(Object[] r1) {
        Intrinsics.f(r1, "array");
        return new ArrayIterator(r1);
    }
}
