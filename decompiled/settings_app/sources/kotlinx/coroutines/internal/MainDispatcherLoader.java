package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "FAST_SERVICE_LOADER_ENABLED", "", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MainDispatcherLoader {
    private static final boolean FAST_SERVICE_LOADER_ENABLED = false;
    public static final MainDispatcherLoader INSTANCE = null;
    public static final MainCoroutineDispatcher dispatcher = null;

    private MainDispatcherLoader() {
    }

    static {
        MainDispatcherLoader r0 = new MainDispatcherLoader();
        INSTANCE = r0;
        FAST_SERVICE_LOADER_ENABLED = SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        dispatcher = r0.loadMainDispatcher();
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
    L25:
        th = move-exception;
        return MainDispatchersKt.createMissingDispatcher$default(th, null, 2, null);
    L4:
        if (FAST_SERVICE_LOADER_ENABLED == false) goto L6;
        List<MainDispatcherFactory> r0 = FastServiceLoader.INSTANCE.loadMainDispatcherFactory$kotlinx_coroutines_core();     // Catch: Throwable -> L25
    L7:
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L25
        if (r1.hasNext() == true) goto L10;
        Object r2 = null;
    L19:
        MainDispatcherFactory r3 = (MainDispatcherFactory) r2;     // Catch: Throwable -> L25
        if (r3 == null) goto L23;
        MainCoroutineDispatcher r4 = MainDispatchersKt.tryCreateDispatcher(r3, r0);     // Catch: Throwable -> L25
        if (r4 == null) goto L23;
        return r4;
    L23:
        return MainDispatchersKt.createMissingDispatcher$default(null, null, 3, null);
    L10:
        r2 = r1.next();     // Catch: Throwable -> L25
        if (r1.hasNext() == false) goto L19;
        int r5 = ((MainDispatcherFactory) r2).getLoadPriority();     // Catch: Throwable -> L25
    L14:
        Object r6 = r1.next();     // Catch: Throwable -> L25
        int r7 = ((MainDispatcherFactory) r6).getLoadPriority();     // Catch: Throwable -> L25
        if (r5 >= r7) goto L18;
        r2 = r6;
        r5 = r7;
    L18:
        if (r1.hasNext() == true) goto L14;
    L6:
        r0 = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));     // Catch: Throwable -> L25
        goto L7
    }
}
