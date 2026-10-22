package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final void M(Object r1) {
        if ((!Intrinsics.a(Thread.currentThread(), null)) == false) goto L6;
        LockSupport.unpark(null);
        return;
    }
}
