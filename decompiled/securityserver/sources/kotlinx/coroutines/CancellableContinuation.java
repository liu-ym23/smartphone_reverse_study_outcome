package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface CancellableContinuation<T> extends Continuation<T> {

    @Metadata
    public static final class DefaultImpls {
    }

    void B(CoroutineDispatcher r1);

    Symbol c(Object r1, Object r2);

    void g();

    Symbol m(Object r1, LockFreeLinkedListNode.AbstractAtomicDesc r2, Function1 r3);

    void u(Function1 r1);

    Symbol x(Throwable r1);
}
