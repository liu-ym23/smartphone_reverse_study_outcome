package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public interface SelectInstance<R> {
    Object d(LockFreeLinkedListNode.PrepareOp r1);

    boolean h();

    boolean l();

    SelectBuilderImpl n();

    void p(Throwable r1);

    Object q(AtomicDesc r1);

    void s(DisposableHandle r1);
}
