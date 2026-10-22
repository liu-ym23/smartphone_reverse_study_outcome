package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MainDispatcherLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainCoroutineDispatcher f422a = null;

    static {
        String r0 = SystemPropsKt.c("kotlinx.coroutines.fast.service.loader");
        if (r0 == null) goto L5;
        boolean r1 = Boolean.parseBoolean(r0);
    L33:
        if (r1 == false) goto L11;
        List r2 = FastServiceLoader.a();     // Catch: Throwable -> L9
    L12:
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L9
        if (r3.hasNext() == true) goto L15;
        Object r4 = null;
    L21:
        MainDispatcherFactory r5 = (MainDispatcherFactory) r4;     // Catch: Throwable -> L9
        if (r5 != null) goto L34;
        MainCoroutineDispatcher r6 = new MissingMainCoroutineDispatcher(null, null);     // Catch: Throwable -> L9
    L31:
        f422a = r6;
        return;
    L34:
        r6 = r5.a();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        MissingMainCoroutineDispatcher r7 = new MissingMainCoroutineDispatcher(null, th);     // Catch: Throwable -> L9
    L30:
        r6 = r7;
        goto L31
    L15:
        r4 = r3.next();     // Catch: Throwable -> L9
        if (r3.hasNext() == false) goto L21;
        ((MainDispatcherFactory) r4).getClass();     // Catch: Throwable -> L9
    L19:
        ((MainDispatcherFactory) r3.next()).getClass();     // Catch: Throwable -> L9
        if (r3.hasNext() == true) goto L19;
    L11:
        Iterator r8 = ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator();     // Catch: Throwable -> L9
        Intrinsics.f(r8, "<this>");     // Catch: Throwable -> L9
        r2 = SequencesKt.d(new ConstrainedOnceSequence(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(r8)));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r7 = new MissingMainCoroutineDispatcher(null, th);
        goto L30
    L5:
        r1 = true;
        goto L33
    }
}
