package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@ExperimentalCoroutinesApi
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {
    SendChannel getChannel();
}
