package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextKey;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    @Metadata
    @ExperimentalStdlibApi
    public static final class Key extends AbstractCoroutineContextKey<CoroutineDispatcher, ExecutorCoroutineDispatcher> {

        /* JADX INFO: renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1, reason: invalid class name */
        @Metadata
        final class AnonymousClass1 extends Lambda implements Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher> {
            public static final AnonymousClass1 b = null;

            static {
                b = new AnonymousClass1(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object r1) {
                CoroutineContext.Element r2 = (CoroutineContext.Element) r1;
                if ((r2 instanceof ExecutorCoroutineDispatcher) == true) goto L6;
                r2 = null;
            L6:
                return (ExecutorCoroutineDispatcher) r2;
            }
        }
    }

    static {
        Key.AnonymousClass1 r1 = Key.AnonymousClass1.b;
        new Key(CoroutineDispatcher.c, r1);
    }
}
