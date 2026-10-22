package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CoroutineExceptionHandlerImplKt {
    private static final List<CoroutineExceptionHandler> handlers = null;

    static {
        handlers = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));
    }

    public static final void handleCoroutineExceptionImpl(CoroutineContext r4, Throwable r5) {
        Iterator<CoroutineExceptionHandler> r0 = handlers.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        r0.next().handleException(r4, r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Thread r2 = Thread.currentThread();
        r2.getUncaughtExceptionHandler().uncaughtException(r2, CoroutineExceptionHandlerKt.handlerException(r5, th));
        goto L4
    L10:
        Thread r1 = Thread.currentThread();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        kotlin.ExceptionsKt.addSuppressed(r5, new DiagnosticCoroutineContextException(r4));     // Catch: Throwable -> L13
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        r1.getUncaughtExceptionHandler().uncaughtException(r1, r5);
        return;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
