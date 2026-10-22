package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public interface Delay {

    @Metadata
    public static final class DefaultImpls {
    }

    void e(long r1, CancellableContinuationImpl r3);

    DisposableHandle h(long r1, Runnable r3, CoroutineContext r4);
}
