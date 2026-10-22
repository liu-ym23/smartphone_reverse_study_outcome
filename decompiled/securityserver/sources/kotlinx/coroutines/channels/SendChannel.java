package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface SendChannel<E> {

    @Metadata
    public static final class DefaultImpls {
    }

    void E(Function1 r1);

    Object I(Object r1, Continuation r2);

    boolean J();

    boolean z(Throwable r1);
}
