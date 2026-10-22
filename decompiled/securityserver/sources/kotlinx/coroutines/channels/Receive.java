package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class Receive<E> extends LockFreeLinkedListNode implements ReceiveOrClosed<E> {
    public Function1 K(Object r1) {
        return null;
    }

    public abstract void L(Closed r1);

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public final /* bridge */ /* synthetic */ Object f() {
        return AbstractChannelKt.b;
    }
}
