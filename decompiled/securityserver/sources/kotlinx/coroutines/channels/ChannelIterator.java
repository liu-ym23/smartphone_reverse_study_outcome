package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ChannelIterator<E> {

    @Metadata
    public static final class DefaultImpls {
    }

    Object a(Continuation r1);

    Object next();
}
