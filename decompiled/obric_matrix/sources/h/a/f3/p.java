package h.a.f3;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class p {
    public static final void a(int r1) {
        boolean r0 = true;
        if (r1 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(kotlin.n0.d.o.m("Expected positive parallelism level, but got ", Integer.valueOf(r1)).toString());
    }
}
