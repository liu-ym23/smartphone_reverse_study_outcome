package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CoroutineExceptionHandlerImplKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f369a = null;

    static {
        Iterator r0 = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator();
        Intrinsics.f(r0, "<this>");
        f369a = SequencesKt.d(new ConstrainedOnceSequence(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(r0)));
    }

    public static final void a(CoroutineContext r5, Throwable r6) {
        Iterator r7 = f369a.iterator();
    L4:
        if (r7.hasNext() == false) goto L14;
        ((CoroutineExceptionHandler) r7.next()).y();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Thread r1 = Thread.currentThread();
        Thread.UncaughtExceptionHandler r2 = r1.getUncaughtExceptionHandler();
        if (r6 != th) goto L12;
        Throwable r3 = r6;
    L13:
        r2.uncaughtException(r1, r3);
        goto L4
    L12:
        r3 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        kotlin.ExceptionsKt.a(r3, r6);
        goto L13
    L14:
        Thread r8 = Thread.currentThread();
        r8.getUncaughtExceptionHandler().uncaughtException(r8, r6);
    }
}
