package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public interface FusibleFlow<T> extends Flow<T> {

    @Metadata
    public static final class DefaultImpls {
    }

    Flow b(CoroutineContext r1, int r2, BufferOverflow r3);
}
