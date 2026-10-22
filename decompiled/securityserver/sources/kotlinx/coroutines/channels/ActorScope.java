package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@ObsoleteCoroutinesApi
@Metadata
public interface ActorScope<E> extends CoroutineScope, ReceiveChannel<E> {

    @Metadata
    public static final class DefaultImpls {
    }
}
