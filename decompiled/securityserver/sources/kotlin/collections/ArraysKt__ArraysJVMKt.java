package kotlin.collections;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class ArraysKt__ArraysJVMKt {
    public static final void a(int r3, int r4) {
        if (r3 > r4) goto L5;
        return;
    L5:
        throw new IndexOutOfBoundsException("toIndex (" + r3 + ") is greater than size (" + r4 + ").");
    }
}
