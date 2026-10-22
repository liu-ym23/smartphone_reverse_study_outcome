package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ReceiveChannel<E> {

    @Metadata
    public static final class DefaultImpls {
    }

    Object G(Continuation r1);

    void a(CancellationException r1);

    ChannelIterator iterator();

    boolean j();

    SelectClause1 l();

    SelectClause1 n();

    Object poll();

    Object s(Continuation r1);
}
