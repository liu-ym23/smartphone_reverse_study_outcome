package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OpDescriptor {
    public abstract AtomicOp a();

    public final boolean b(OpDescriptor r4) {
        AtomicOp r3 = a();
        if (r3 == null) goto L10;
        AtomicOp r5 = r4.a();
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r3.g() >= r5.g()) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public abstract Object c(Object r1);

    public String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    }
}
